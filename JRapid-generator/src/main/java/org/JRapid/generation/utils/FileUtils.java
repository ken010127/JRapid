package org.JRapid.generation.utils;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作工具类
 * @author FWJ
 * Created on 2016/8/24 11:05
 */
public class FileUtils {

    /**
     * 创建文件夹
     * @param path
     * @return
     */
    public static File createFolder(String path){
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        return file;
    }

    /**
     * 创建文件
     * @param path 文件路径
     * @return 文件
     */
    public static File createFile(String path){
        File file = new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;

    }

}
