package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class Project
{
    public static void main( String[] args ) throws IOException
    {
      ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
      StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
     
          BufferedReader reader = new BufferedReader(
              new InputStreamReader(System.in));
   
        
          // Printing the read line
          System.out.println("1 - for add data");
          System.out.println("2 - for delete data");
          System.out.println("3 - for getdata");
          
          int input=Integer.parseInt(reader.readLine());
          if(input==1)
          {
        	  System.out.println("enter the id ");
        	  int uid=Integer.parseInt(reader.readLine());
        	  System.out.println("enter the name");
        	  String uname=reader.readLine();
        	  System.out.println("enter the city");
        	  String ucity=reader.readLine();
        	  
        	  Student student=new Student();
        	  student.setId(uid);
        	  student.setName(uname);
        	  student.setCity(ucity);
        	   int r=   studentDao.insert(student);
        	      System.out.println(r);
          }
          
          
      
      
     
    }
}
