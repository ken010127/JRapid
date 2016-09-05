package com.rbac.jrapid.core.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * 文件操作帮助类
 * @author fwj
 * @date 2014-08-10
 */
public class FileUtil {

    /**创建文件夹
     * @param path  目录
     */
    public static void createDir(String path){
        File dir=new File(path);
        if(!dir.exists() && !dir.isDirectory())
            dir.mkdir();
    }

    /**创建新文件
     * @param path 目录
     * @param fileName 文件名
     * @throws IOException
     */
    public static void createFile(String path,String fileName) throws IOException{
        File file=new File(path+"/"+fileName);
        if(!file.exists())
            file.createNewFile();
    }


    /**删除文件
     * @param path 文件路径
     */
    public static void delFile(String path) throws IOException {
    	File file=new File(path);
        if(file.exists()&&file.isFile())
            file.delete();
    }
    
    /**删除文件
     * @param dirPath 文件夹路径
     * @param fileName 文件名
     */
    public static void delFile(String dirPath,String fileName) throws IOException{
        String path = dirPath+File.separatorChar+fileName;
    	delFile(path);
    }

    /**
     * 删除目录下指定后缀的文件
     * @param path 文件目录
     * @param suffix 后缀
     */
    public static void deleteFileBySuffix(String path,String suffix){

        class GenericSuffixFilter implements FilenameFilter{
            private final String suffix;
            public GenericSuffixFilter(String suffix){
                this.suffix = suffix;
            }
            public boolean accept(File dir,String name){
                return (name.endsWith(suffix));
            }
        }


        GenericSuffixFilter filter = new GenericSuffixFilter(suffix);
        File dir = new File(path);
        String[] list = dir.list(filter);

        if(list==null || list.length==0){
            return;
        }

        File fileDelete;
        for(String file : list){
            StringBuffer sb = new StringBuffer(path);
            if(!path.endsWith(File.separator)){
                sb.append(File.separator);
            }
            sb.append(file);
            fileDelete = new File(sb.toString());
            boolean isDeleted = fileDelete.delete();
            System.out.println("文件："+sb+"是否删除成功："+isDeleted);
        }
    }

    /**递归删除文件夹
     * @param path
     */
    public static void delDir(String path){
        File dir=new File(path);
        if(dir.exists() && dir.isDirectory()){
            File[] tmp=dir.listFiles();
            for(int i=0;i<tmp.length;i++){
                if(tmp[i].isDirectory()){
                    delDir(path+"/"+tmp[i].getName());
                }
                else{
                    tmp[i].delete();
                }
            }
            dir.delete();
        }
    }

    /**
     * 读取文件夹下的直属文件（没有递归）
     * @param path 文件夹路径
     * @return 文件列表
     */
    public static List<File> readFiles(String path){
    	List<File> files = new ArrayList<File>();
    	File root = new File(path);
    	if(!root.isDirectory()){
    		String[] fileList = root.list();
    		if(fileList.length>0){
    			for(int i=0;i<fileList.length;i++){
    				File file = new File(path+File.separatorChar+fileList[i]);
    				files.add(file);
    			}
    		}
    	}else{
    		System.out.println("该路径不是文件夹");
    	}
    	return files;
    }
    
    /**读文件
     * @param path
     * @return
     * @throws IOException
     */

    public static String readByBufferedReader(String path) throws IOException{
        File file=new File(path);
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();

        BufferedReader br=new BufferedReader(new FileReader(file));

        String temp=null;

        StringBuffer sb=new StringBuffer();

        temp=br.readLine();

        while(temp!=null){

            sb.append(temp+" ");

            temp=br.readLine();

        }

        return sb.toString();

    }

    /**读文件
     * @param path
     * @return
     * @throws IOException
     */
    public static String readByFileInputStream(String path) throws IOException{
        File file=new File(path);

        if(!file.exists()||file.isDirectory())

            throw new FileNotFoundException();

        FileInputStream fis=new FileInputStream(file);

        byte[] buf = new byte[1024];

        StringBuffer sb=new StringBuffer();

        while((fis.read(buf))!=-1){

            sb.append(new String(buf));

            buf=new byte[1024];//重新生成，避免和上次读取的数据重复

        }

        return sb.toString();

    }

    /**
     * 以文件流的方式复制文件
     * @param src 文件源目录
     * @param dest 文件目的目录(不是父级文件夹，是文件)
     * @throws IOException
     */
    public static void copyFile(String src,String dest) throws IOException{

        FileInputStream in=new FileInputStream(src);

        File file=new File(dest);

        if(!file.exists())

            file.createNewFile();

        FileOutputStream out=new FileOutputStream(file);

        int c;

        byte buffer[]=new byte[1024];

        while((c=in.read(buffer))!=-1){

            for(int i=0;i<c;i++)

                out.write(buffer[i]);

        }

        in.close();

        out.close();

    }

    /**
     * 使用文件通道的方式复制文件
     * @param sourceFile 源文件
     * @param targetFile 复制到的新文件
     * @throws IOException 
     */
     public static void fileChannelCopy(File sourceFile, File targetFile) throws IOException {
         FileInputStream fi = null;
         FileOutputStream fo = null;
         FileChannel in = null;
         FileChannel out = null;
         fi = new FileInputStream(sourceFile);
         fo = new FileOutputStream(targetFile);
         in = fi.getChannel();//得到对应的文件通道
         out = fo.getChannel();//得到对应的文件通道
         in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
         fi.close();
         in.close();
         fo.close();
         out.close();    
     }
    
    /**
     * 文件重命名
     * @param path 文件目录
     * @param oldName  原来的文件名
     * @param newName  新文件名
     */
    public static void renameFile(String path,String oldName,String newName){

        if(!oldName.equals(newName)){//新的文件名和以前文件名不同时,才有必要进行重命名

            File oldFile=new File(path+"/"+oldName);

            File newFile=new File(path+"/"+newName);

            if(newFile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名

                System.out.println(newName+"已经存在！");

            else{

                oldFile.renameTo(newFile);

            }

        }

    }

    /**转移文件目录
     * @param fileName 文件名
     * @param oldPath 旧目录
     * @param newPath 新目录
     * @param cover 若新目录下存在和转移文件具有相同文件名的文件时，是否覆盖新目录下文件，cover=true将会覆盖原文件，否则不操作
     */
    public static void changeDirectory(String fileName,String oldPath,String newPath,boolean cover){
        if(!oldPath.equals(newPath)){
            File oldFile=new File(oldPath+"/"+fileName);
            File newFile=new File(newPath+"/"+fileName);
            if(newFile.exists()){//若在待转移目录下，已经存在待转移文件
                if(cover)//覆盖
                    oldFile.renameTo(newFile);
                else
                    System.out.println("在新目录下已经存在："+fileName);
            }
            else{
                oldFile.renameTo(newFile);
            }

        }

    }

    /**
     * 利用StringBuffer写文件
     * @param filePath 文件路径
     * @param sb 内容
     * @throws IOException
     */
    public static void StringBufferDemo(String filePath, StringBuffer sb) throws IOException {

        File file = new File(filePath);

        if (!file.exists())

            file.createNewFile();

        FileOutputStream out = new FileOutputStream(file, true);

        out.write(sb.toString().getBytes("utf-8"));

        out.close();

    }

    /**
     * 上传文件
     * @param rootPath 根目录
     * @param uploadFile 上传文件
     * @param fileName 文件名，带后缀
     * @return 上传成功返回文件路径，否则返回null
     * @throws IOException 
     */
    public static String uploadFileByDate(String rootPath,File uploadFile,String fileName) throws IOException{
    	return uploadFileByDate(rootPath, uploadFile, fileName,null);
    }
    
    /**
     * 上传文件
     * @param rootPath 根目录
     * @param uploadFile 上传文件
     * @param fileName 文件名，带后缀
     * @param tag 标识
     * @return 上传成功返回文件路径，否则返回null
     * @throws IOException 
     */
    public static String uploadFileByDate(String rootPath,File uploadFile,String fileName,String tag) throws IOException{
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date());
    	String yearStr = cal.get(Calendar.YEAR)+"";
    	//获取mm格式的月份
    	int month = cal.get(Calendar.MONTH)+1;
    	String monthStr = "";
    	if(month<10){
    		monthStr = "0"+month;
    	}else{
    		monthStr = ""+month;
    	}
    	//绝对路径
    	String filePath;
    	//相对路径
    	String relativePath;
    	//年份文件夹
    	relativePath = File.separatorChar+yearStr;
    	filePath = rootPath+relativePath;
    	//System.out.println("年份文件夹："+filePath);
    	createDir(filePath);
	   	
    	//月份文件夹
    	relativePath += File.separatorChar+monthStr;
    	filePath = rootPath+relativePath;
    	//System.out.println("月份文件夹："+filePath);
    	createDir(filePath);
	
    	//添加标识文件夹
    	if(tag!=null){
    		relativePath += File.separatorChar + tag;
    		filePath = rootPath+relativePath;
    		createDir(filePath);
    	}
    	
    	relativePath += File.separatorChar+fileName;
    	filePath = rootPath+relativePath;
    	File targetFile = new File(filePath);
    	if(!targetFile.exists()){
    		targetFile.createNewFile();
    	}
	
		fileChannelCopy(uploadFile, targetFile);	
    	
    	return relativePath;
    }
    
    public static void main(String[] args) {
    	String path = "F:\\cache";
    	File sourceFile = new File("F:\\www.zhuoku.com_桌酷精选壁纸.jpg");
    	String success = null;
		try {
			success = uploadFileByDate(path,sourceFile,"www.zhuoku.com_桌酷精选壁纸.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.out.println(success);
	}
}
