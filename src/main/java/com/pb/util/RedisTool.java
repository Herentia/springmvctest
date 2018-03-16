package com.pb.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis连接工具类
 * @author haohan
 *
 */
public class RedisTool {
	
	//redis服务器地址
	private static String address = "localhost";
	//redis连接端口
	private static int port = 6379;
	//访问密码
	private static String auth = null;
	
	//可用连接实例的最大数目，默认值为8；  
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。  
    //private static final int MAX_ACTIVE = 1024; 
	
	//控制pool最多有多少个状态为空闲的jedis实例，默认值是8
	private static int MAX_IDLE = 10;  
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；  
    private static int MAX_WAIT = 10000;  
    private static int TIMEOUT = 10000;
    
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；  
    private static boolean TEST_ON_BORROW = true;  
    private static JedisPool jedisPool;
    
    //配置jedisPool
    static {  
        JedisPoolConfig config = new JedisPoolConfig();  
        config.setMaxIdle(MAX_IDLE);  
        config.setMaxWait(MAX_WAIT);  
        config.setTestOnBorrow(TEST_ON_BORROW);  
        //config.setMaxTotal(MAX_ACTIVE);  
        jedisPool = new JedisPool(config, address, port, TIMEOUT);  
    }
    
    //获取jedis客户端
    public static Jedis getJedis() {
    	Jedis jedis = null;
    	if(jedisPool != null) {
    		jedis = jedisPool.getResource();
    	}
    	return jedis;
    }
    
    /**
     * 返还资源
     * @param jedis 被返还的jedis
     */
    public static void returnResource(Jedis jedis) {
    	jedisPool.returnResource(jedis);
    }

}
