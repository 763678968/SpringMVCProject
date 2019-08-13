package handler;

import entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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

    @RequestMapping(value="testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String al) {
        System.out.println(al);
        return "success"; // views/success.jsp，默认使用了请求转发的跳转方式
    }

    @RequestMapping(value="testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String jsessionId) {
        System.out.println(jsessionId);
        return "success"; // views/success.jsp，默认使用了请求转发的跳转方式
    }

    @RequestMapping(value="testObjectProperties")
    public String testObjectProperties(Student student) { // student属性必须和form表单中的属性name值一致（支持级联属性）
        System.out.println(student.getId() + "," + student.getName() + "," + student.getAddress().getHomeAddress() + "," + student.getAddress().getSchoolAddress());
        return "success";
    }

//    @RequestMapping(value="testServletAPI")
//    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
//        request.getParameter("uname");
//        System.out.println(request);
//        return "success";
//    }

    @RequestMapping(value="testModelAndView")
    public ModelAndView testModelAndView() { // ModelAndView:既有数据，又有视图
        // ModelAndView: Model -M   View -V
        ModelAndView mv = new ModelAndView("success"); // view: views/success.jsp

        Student student = new Student();
        student.setId(2);
        student.setName("zs");

        mv.addObject("student", student); // 相当于request.setAttribute("student", student);
        return mv;
    }



    @RequestMapping(value="testModelMap")
    public String testModelMap(ModelMap mm) {

        Student student = new Student();
        student.setId(2);
        student.setName("zs");

        mm.put("student2", student); // request域

        return "success";
    }

    @RequestMapping(value="testMap")
    public String testMap(Map<String, Object> m) {

        Student student = new Student();
        student.setId(2);
        student.setName("zs");

        m.put("student3", student); // request域

        return "success";
    }

    @RequestMapping(value="testModel")
    public String testModel(Model model) { // success

        Student student = new Student();
        student.setId(2);
        student.setName("zs");

        model.addAttribute("student4", student); // request域

        return "success";
    }

}
