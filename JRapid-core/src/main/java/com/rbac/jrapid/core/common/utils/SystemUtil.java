package com.rbac.jrapid.core.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * 系统工具类,window系统Linux系统
 * @author fwj
 *
 */
public class SystemUtil {

	/**
	 * 检查系统类型
	 * @return  
	 */
	public static String checkSystemType(){
		String os = "";
		if("\\".equals(File.separator)){
			os = "windows";
		}else if("/".equals(File.separator)){
			os = "linux";
		}
		return os;
	}
	
	/** 
     * 获取cpu使用情况 
     * @return 
     * @throws Exception 
     */ 
    public static double getLinuxCpuUsage() throws Exception {   
        double cpuUsed = 0;   

        Runtime rt = Runtime.getRuntime();   
        Process p = rt.exec("top -b -n 1");// 调用系统的“top"命令   
       

        BufferedReader in = null;   
        try {   
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));   
            String str = null;   
            String[] strArray = null;   
           
            while ((str = in.readLine()) != null) {   
                int m = 0;   
                   
                if (str.indexOf(" R ") != -1) {// 只分析正在运行的进程，top进程本身除外 &&   
                       
                strArray = str.split(" ");   
                    for (String tmp : strArray) {   
                        if (tmp.trim().length() == 0)   
                            continue;   
                        if (++m == 9) {// 第9列为CPU的使用百分比(RedHat   
                               
                            cpuUsed += Double.parseDouble(tmp);   

                        }   

                    }   

                }   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            in.close();   
        }   
        return cpuUsed;   
    }   
    
	/** 
	* 内存监控 
	* @return 
	* @throws Exception 
	*/ 
    public static double getLinuxMemUsage() throws Exception {   

        double menUsed = 0;   
        Runtime rt = Runtime.getRuntime();   
        Process p = rt.exec("top -b -n 1");// 调用系统的“top"命令   
       

        BufferedReader in = null;   
        try {   
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));   
            String str = null;   
            String[] strArray = null;   
           
            while ((str = in.readLine()) != null) {   
                int m = 0;   
                   
                if (str.indexOf(" R ") != -1) {// 只分析正在运行的进程，top进程本身除外 &&   
                    //    
                    // System.out.println("------------------3-----------------");   
                    strArray = str.split(" ");   
                    for (String tmp : strArray) {   
                        if (tmp.trim().length() == 0)   
                            continue;   

                        if (++m == 10) {   
                            // 9)--第10列为mem的使用百分比(RedHat 9)   

                            menUsed += Double.parseDouble(tmp);   

                        }   
                    }   

                }   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            in.close();   
        }   
        return menUsed;   
    }   

    /** 
     * 获取磁盘空间大小 
     *   
     * @return 
     * @throws Exception 
     */ 
    public static double getLinuxDiskUsage() throws Exception {   
        double totalHD = 0;   
        double usedHD = 0;   
        Runtime rt = Runtime.getRuntime();   
        Process p = rt.exec("df -hl");//df -hl 查看硬盘空间   
       

        BufferedReader in = null;   
        try {   
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));   
            String str = null;   
            String[] strArray = null;   
            int flag = 0;   
            while ((str = in.readLine()) != null) {   
                int m = 0;   
//              if (flag > 0) {   
//                  flag++;   
                    strArray = str.split(" ");   
                    for (String tmp : strArray) {   
                        if (tmp.trim().length() == 0)   
                            continue;   
                        ++m;   
//                      System.out.println("----tmp----" + tmp);   
                        if (tmp.indexOf("G") != -1) {   
                            if (m == 2) {   
//                              System.out.println("---G----" + tmp);   
                                if (!tmp.equals("") && !tmp.equals("0"))   
                                	totalHD += Double.parseDouble(tmp   
                                            .substring(0, tmp.length() - 1)) * 1024;   

                            }   
                            if (m == 3) {   
//                              System.out.println("---G----" + tmp);   
                                if (!tmp.equals("none") && !tmp.equals("0"))   
                                	usedHD += Double.parseDouble(tmp.substring(   
                                            0, tmp.length() - 1)) * 1024;   

                            }   
                        }   
                        if (tmp.indexOf("M") != -1) {   
                            if (m == 2) {   
//                              System.out.println("---M---" + tmp);   
                                if (!tmp.equals("") && !tmp.equals("0"))   
                                	totalHD += Double.parseDouble(tmp   
                                            .substring(0, tmp.length() - 1));   

                            }   
                            if (m == 3) {   
//                              System.out.println("---M---" + tmp);   
                                if (!tmp.equals("none") && !tmp.equals("0"))   
                                	usedHD += Double.parseDouble(tmp.substring(   
                                            0, tmp.length() - 1));   
                                // System.out.println("----3----" + usedHD);   
                            }   
                        }   
                           
                    }   

//              }   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            in.close();   
        }   
        System.out.println("已用："+usedHD);
        System.out.println("总容量："+totalHD);
        return (usedHD / totalHD) * 100;   
    }   
    
    /**
     * 获取window硬盘使用率
     * @return
     */
    public static double getWindowsDiskUsage(){
    	File[] roots = File.listRoots();
		
		Double free = 0.00;
		Double total = 0.00;
		for(File file : roots){
			free = free + file.getFreeSpace();
			total = total + file.getTotalSpace();
		}
		
		Double value =	free/total *100;
		return value;
    }
}
