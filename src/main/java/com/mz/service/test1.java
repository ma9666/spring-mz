package com.mz.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mz.entity.system.SysMenu;
import com.mz.service.system.SysMenuService;

public class test1 {
  
  static ApplicationContext context = new ClassPathXmlApplicationContext(
      new String[]{"spring-*.xml"}); 
  
  private SysMenuService<SysMenu> sysMenuService = (SysMenuService)context.getBean("sysMenuService");
  
  
  public void testList() throws Exception{
    
    SysMenu s = new SysMenu();
    
    List<SysMenu> queryByList = sysMenuService.queryByPageList(s);
    /*
    for(SysMenu menu: queryByList){
      System.out.println(menu.getUrl());
    }*/
  }
  static final int n = 7;
  
  public static void main(String[] args) throws Exception {
    //test1 test = new test1();
    //test.testList();
    int n1,n2,n3;
    n1 = (n-1) / 2;
    System.out.println(n1);
    int n2_max = (n-n1) / 2;
    System.out.println(n2_max);
    for(int i=1; i<=n2_max; i++){
        n2 = i;
        n3 = n - n1 -n2;
        if(n3 >= (n1+n2)){
            continue;
        }
        System.out.println("("+n1+","+n2+","+n3+")");
    }
    
    
  }
}
