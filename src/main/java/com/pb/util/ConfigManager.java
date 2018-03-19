package com.pb.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件
 * 读取.properties文件   单例模式（这个类只能创建一个对象）
 * @author 许盼
 *
 */
public class ConfigManager {
	//声明了一个属性
	private static ConfigManager configManager;
	
	private static Properties properties;

	/**
	 * 构造方法   读文件
	 */
	private ConfigManager() {
		//属性文件的名称
		String propertiesPath="jdbc.properties";
		properties=new Properties();
		InputStream in=ConfigManager.class.getClassLoader().getResourceAsStream(propertiesPath);
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	/**
	 * 提供公共的方法 返回ConfigManager对象
	 * @return
	 */
	public static ConfigManager getConfigManager(){
		//如果configManager为空就从新new一个对象
		if(configManager==null){
			configManager=new ConfigManager();
		}
		return configManager;
		
	}
	
	/**
	 * 通过key获得对用值
	 * @param key
	 * @return
	 */
	public String getValueByKey(String key){
		return properties.getProperty(key);
		
	}
	
	
	
	

}
