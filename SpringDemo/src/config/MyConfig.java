package config;

import entity.Address;
import entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean // id="myStudent", id默认就是方法名
    public Student myStudent() {
        Student student = new Student(100, "zs100", 88);
        student.setAddress(new Address("xa", "bj"));
        return student;
    }
}
