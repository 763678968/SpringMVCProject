package handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("handler") // 映射
public class SpringMVCHandler {

    @RequestMapping(value="welcome", method= RequestMethod.POST, params={"name=zs","age!=23", "!height"}) // 映射
    public String welcome() {
        return "success"; // views/success.jsp，默认使用了请求转发的跳转方式
    }

    @RequestMapping(value="welcome2", headers={"Accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8","Accept-Encoding=gzip, deflate, sdch, br"})
    public String welcome2() {
        return "success"; // views/success.jsp，默认使用了请求转发的跳转方式
    }

    @RequestMapping(value="welcome3/**/test")
    public String welcome3() {
        return "success"; // views/success.jsp，默认使用了请求转发的跳转方式
    }

    @RequestMapping(value="welcome4/a?c/test")
    public String welcome4() {
        return "success"; // views/success.jsp，默认使用了请求转发的跳转方式
    }

    @RequestMapping(value="welcome5/{name}")
    public String welcome5(@PathVariable("name") String name) {
        System.out.println(name);
        return "success"; // views/success.jsp，默认使用了请求转发的跳转方式
    }

    @RequestMapping(value="testRest/{id}", method=RequestMethod.POST)
    public String testPost(@PathVariable("id") Integer id) {
        System.out.println("post:增" + id);
        // Service层实现真正的增
        return "success"; // views/success.jsp，默认使用了请求转发的跳转方式
    }

    @RequestMapping(value="testRest/{id}", method=RequestMethod.DELETE)
    public String testDelete(@PathVariable("id") Integer id) {
        System.out.println("delete:删" + id);
        // Service层实现真正的增
        return "success"; // views/success.jsp，默认使用了请求转发的跳转方式
    }

    @RequestMapping(value="testRest/{id}", method=RequestMethod.PUT)
    public String testPut(@PathVariable("id") Integer id) {
        System.out.println("put:改" + id);
        // Service层实现真正的增
        return "success"; // views/success.jsp，默认使用了请求转发的跳转方式
    }

    @RequestMapping(value="testRest/{id}", method=RequestMethod.GET)
    public String testGet(@PathVariable("id") Integer id) {
        System.out.println("get:查" + id);
        // Service层实现真正的增
        return "success"; // views/success.jsp，默认使用了请求转发的跳转方式
    }
}
