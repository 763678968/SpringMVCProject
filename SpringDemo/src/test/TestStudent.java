package test;

import config.MyConfig;
import entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {

    public static void testXml() {
        // 1.创建Spring的IOC容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2.从IOC容器中获取Bean实例(id为"student"的Student对象)
        Student student = (Student) context.getBean("student"); // setXXX()
        System.out.println(student);
    }

    public static void testAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Student stu = (Student) context.getBean("myStudent");
        System.out.println(stu);
    }



    public static void main(String[] args) {
//        testXml();
        testAnnotation();
    }
}
