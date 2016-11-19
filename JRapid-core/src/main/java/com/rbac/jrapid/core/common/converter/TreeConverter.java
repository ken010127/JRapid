package com.rbac.jrapid.core.common.converter;

import com.rbac.jrapid.core.common.annotation.CHILDREN;
import com.rbac.jrapid.core.common.annotation.ORDERID;
import com.rbac.jrapid.core.common.annotation.PARENTID;
import com.rbac.jrapid.core.common.utils.ReflectionUtils;
import com.rbac.jrapid.core.db.mybatis.annotation.PK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;
import java.util.Map.Entry;

/**
 * 树处理类
 * @author FengWeijian
 *
 */
public class TreeConverter<E> {
    protected static Logger logger = LoggerFactory.getLogger(TreeConverter.class);

	/**
	 * 获取ID主键
	 * @param entity 要转换的实体类
	 * @return
	 */
	private Object getId(E entity){
        List<Field> fields = ReflectionUtils.findFieldByAnnotation(entity.getClass(),PK.class);
        return ReflectionUtils.invokeGetterMethod(entity,fields.get(0).getName());
    };
	
	/**
	 * 获取父节点ID
	 * @param entity 要转换的实体类
	 * @return
	 */
	private Object getParentId(E entity){
        List<Field> fields = ReflectionUtils.findFieldByAnnotation(entity.getClass(),PARENTID.class);
        return ReflectionUtils.invokeGetterMethod(entity,fields.get(0).getName());
    }

    /**
     *  获取排序值
     * @param entity
     * @return
     */
    public Object getOrderId(E entity){
        List<Field> fields = ReflectionUtils.findFieldByAnnotation(entity.getClass(),ORDERID.class);
        return ReflectionUtils.invokeGetterMethod(entity,fields.get(0).getName());
    }
	
	/**
	 * 加入子节点
	 * @param entity 要转换的实体类
	 */
	public void setChildren(E entity,List<E> entitys){
        Field field = ReflectionUtils.findFieldByAnnotation(entity.getClass(),CHILDREN.class).get(0);
        ReflectionUtils.invokeSetterMethod(entity,field.getName(),entitys);
    }

	/**
	 * 根据Id获取节点
	 * @param id 节点ID
	 * @return
	 */
	//public abstract E getNode(Integer id);
	
	/**
	 * 转换成树模式
	 * @param tempOrderOrgList 找到根据父节点排序号的所有节点链表
	 * @return
	 * @throws Exception 
	 */
	public List<E> converToTreeModel(List<E> rootList, List<E> tempOrderOrgList) throws Exception{
		
		if(rootList==null && rootList.size()==0){
            throw new Exception("缺少根节点");
        }
		List<E> treeList = new ArrayList<E>();
		//根节点map
		Map<Object, E> mapQuery= new TreeMap<Object, E>();
		
	    //顶层节点保存到orgList 
	    for(int i=0;i<rootList.size();i++){
	    	E entity = rootList.get(i);
	    	treeList.add(entity);
	        mapQuery.put(getId(entity), entity);  
	    } 
	  
	    //将具有相同父ID的节点放到一个map(pid, map(id,Element))  
	    Map<Object, Object> tempOrderOrgMap = convertGroup(mapQuery,tempOrderOrgList);
	    
        //生成Map树 （mapTree）和 orgList
        collectToMapTree(tempOrderOrgMap, treeList); 
        
	    return treeList; 
	}
	
	public Map<Object, Object> convertGroup(Map<Object, E> mapQuery,List<E> elementList){
		if(elementList==null || elementList.isEmpty()) return null; 
		Map<Object, Object> tempMap= new LinkedHashMap<Object, Object>();
		
		List<Object> orderList = new ArrayList<Object>();
		
		for(E entity:elementList){
			
			//在顶层Map中就不加入  
	        if(mapQuery.containsKey(getId(entity))) continue;  
			//判断是否存在组
			if(!tempMap.containsKey(getParentId(entity))){
				Map<Object, Object> groupMap=new LinkedHashMap<Object, Object>();
				groupMap.put(getId(entity), entity);  
				tempMap.put(getParentId(entity), groupMap);
				
				orderList.add(getParentId(entity));
				
			}else{
				Map<Object, Object> groupMap= (Map<Object, Object>) tempMap.get(getParentId(entity));
				groupMap.put(getId(entity), entity);  
			}
		}
		
		return tempMap;
	}
	
	//第二项在第一项中收集 ,递归 
	private void collectToMapTree(Map<Object, Object> tempOrderOrgMap,List<E> orgList){
        for (E entity:orgList ){
		          
            List<E> children = new ArrayList<E>();
            Map<Integer,E> obMap = (Map<Integer, E>)tempOrderOrgMap.get(getId(entity));
            //没有孩子
            if(obMap ==null || obMap.isEmpty()) {
                continue;
            }
            else{
                //循环Map对象
                for(Entry<Integer, E> mapBean: obMap.entrySet()){
                    children.add(mapBean.getValue());
                }
                //排序子节点
                orderListByOrderId(children);

                collectToMapTree(tempOrderOrgMap, children);
                setChildren(entity,children);
            }
        }
	}

    /**
     * 根据orderId派讯
     * @param list 排序列表
     */
    private void orderListByOrderId(List<E> list){
        Collections.sort(list,new Comparator<E>(){
            public int compare(E arg0, E arg1) {
                Object arg0Obj = getOrderId(arg0);
                Object arg1Obj = getOrderId(arg1);
                if (arg0Obj!=null && arg1Obj!=null){
                    return arg0Obj.toString().compareTo(arg1Obj.toString());
                }else {
                    return -1;
                }
            }
        });
    }
	
}
