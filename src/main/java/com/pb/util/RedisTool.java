package com.pb.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis���ӹ�����
 * @author haohan
 *
 */
public class RedisTool {
	
	//redis��������ַ
	private static String address = "localhost";
	//redis���Ӷ˿�
	private static int port = 6379;
	//��������
	private static String auth = null;
	
	//��������ʵ���������Ŀ��Ĭ��ֵΪ8��  
    //�����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��  
    //private static final int MAX_ACTIVE = 1024; 
	
	//����pool����ж��ٸ�״̬Ϊ���е�jedisʵ����Ĭ��ֵ��8
	private static int MAX_IDLE = 10;  
    //�ȴ��������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ����������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��  
    private static int MAX_WAIT = 10000;  
    private static int TIMEOUT = 10000;
    
    //��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�  
    private static boolean TEST_ON_BORROW = true;  
    private static JedisPool jedisPool;
    
    //����jedisPool
    static {  
        JedisPoolConfig config = new JedisPoolConfig();  
        config.setMaxIdle(MAX_IDLE);  
        config.setMaxWait(MAX_WAIT);  
        config.setTestOnBorrow(TEST_ON_BORROW);  
        //config.setMaxTotal(MAX_ACTIVE);  
        jedisPool = new JedisPool(config, address, port, TIMEOUT);  
    }
    
    //��ȡjedis�ͻ���
    public static Jedis getJedis() {
    	Jedis jedis = null;
    	if(jedisPool != null) {
    		jedis = jedisPool.getResource();
    	}
    	return jedis;
    }
    
    /**
     * ������Դ
     * @param jedis ��������jedis
     */
    public static void returnResource(Jedis jedis) {
    	jedisPool.returnResource(jedis);
    }

}
