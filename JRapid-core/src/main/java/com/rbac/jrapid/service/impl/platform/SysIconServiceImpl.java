package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.utils.FileUtil;
import com.rbac.jrapid.core.common.utils.PathUtil;
import com.rbac.jrapid.core.exception.BaseException;
import com.rbac.jrapid.service.platform.SysIconService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author FWJ
 * @since 2017/1/18 上午11:37
 */
@Service("SysIconService")
public class SysIconServiceImpl implements SysIconService {

    @Override
    public List<String> getIcons(String type) {
        try {
            //String path = PathUtil.getWebRoot();
            String path = "/Users/ken/code/JRapid/JRapid-web/src/main/webapp/";
            if("default".equals(type)){
                path += "resource/js/jquery-easyui-1.5/themes/icons";
            }else if ("custom".equals(type)){
                path += "resource/js/jquery-easyui-1.5/themes/customIcon";
            }
            List<File> files = FileUtil.readFiles(path);
            List<String> fileNames = new ArrayList<>();
            for (File file : files){
                String fileName = file.getName();
                if (fileName.endsWith("png") || fileName.endsWith("gif") || fileName.endsWith("jpg")){
                    fileNames.add(fileName);
                }
            }
            return fileNames;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException("","获取图标路径失败");
        }
    }
}
