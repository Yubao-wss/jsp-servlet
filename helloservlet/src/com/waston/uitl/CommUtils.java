package com.waston.uitl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description: 封装基础的工具方法，如加载配置文件、json序列化等
 * @Author: Waston
 * @Date: 2019/7/30 19:04
 */
public class CommUtils {
    private CommUtils(){}

    /**
     * 根据指定的文件名加载配置文件
     * @param fileName
     * @return
     */
    public static Properties loadProperties(String fileName){
        Properties properties = new Properties();
        try {

            //获取当前配置文件夹下的输入流
            InputStream in = CommUtils.class.getClassLoader().getResourceAsStream(fileName);
            //加载配置文件里的所有内容
            properties.load(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
