package handler;

import entity.Address;
import entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

// 接口/类 注解  配置
//@SessionAttributes(value="student4") // 如果要在request中存放student4对象，则同时将该对象放入session域中
//@SessionAttributes(types={Student.class, Address.class}) // 如果要在request中存放Student类型的对象，则同时将该类型的对象放入session域中
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

        // forward:     redirect:
        //
        return "redirect:/views/success.jsp";
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


    @ModelAttribute // 在任何一次请求前，都会先执行@ModelAttribute修饰的方法
    // @ModelAttribute在请求该类的各个方法前均被执行的设计是基于一个思想：一个控制器，只做一个功能
    public void queryStudentById(Map<String, Object> map) {
        // StudentService stuService = new StudentServiceImpl();
        // Student student = stuService.queryStudentById(31);
        // 模拟调用三层查询数据库的操作
        Student student = new Student();
        student.setId(31);
        student.setName("zs");
        student.setAge(23);
//        map.put("student", student); // 约定：map的key就是方法参数类型的首字母小写
        map.put("stu", student);
    }

    // 修改 zs →  ls
    @RequestMapping(value="testModelAttribute")
    public String testModelAttribute(@ModelAttribute("stu") Student student) {
        student.setName(student.getName()); // 将名字修改为ls
        System.out.println(student.getId() + "," + student.getName() + "," + student.getAge());
        return "success";
    }

    @RequestMapping(value="testI18n")
    public String testI18n() {
        return "success";
    }

    @RequestMapping(value="testConverter")
    public String testConverter(@RequestParam("studentInfo") Student student) { // 前端：2-zs-23

        System.out.println(student.getId() + "," + student.getName() + "," + student.getAge());

        return "success";
    }

    @RequestMapping(value="testDateTimeFormat") // 如果Student格式化出错，会将错误信息传入result中
    public String testDateTimeFormat(@Valid Student student, BindingResult result, Map<String, Object> map) {

        System.out.println(student.getId() + "," + student.getName() + "," + student.getBirthday());

        if(result.getErrorCount() > 0) {
            for (FieldError error: result.getFieldErrors()) {
                System.out.println(error.getDefaultMessage());
                map.put("errors", result.getFieldErrors()); // 将错误信息传入request域中的errors中
//                result.getFieldErrors().get(0).getDefaultMessage();
            }
        }

        return "success";
    }



}
