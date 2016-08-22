package org.JRapid.generation;


import org.JRapid.generation.impl.Generation;
import org.JRapid.generation.impl.SSMGenerationImpl;

/**
 * 执行生成操作类
 * Created by FengWeijian on 2015/5/8.
 */
public class Domain {

    public static void main(String[] args) {
        Generation generation = new SSMGenerationImpl();
        generation.generate();
    }

}
