package com.mz.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：MyBatisDB   
 * @Description：   DB连接
 * @author：Ma Zhen   
 * @date：2016-04-22       
 * @version
 */
public class MyBatisDB {
	
	 private static SqlSessionFactory sqlMapper ;
	 static {
	
		String resource = "com/wei/ssi/conf/mybatis/mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	}
	 
	 
	public static SqlSession getSqlSession(){
		if(sqlMapper == null ){
			return null;
		}
		return sqlMapper.openSession();
	}
	
	public static void close(){
		 getSqlSession().close();
	}
	
	public static void commit(){
		 getSqlSession().commit();
	}
	
	public static void rollback(){
		 getSqlSession().rollback();
	}
}
