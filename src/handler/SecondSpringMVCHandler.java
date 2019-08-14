package handler;

import exception.MyArrayIndexOutofBoundsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("second")
public class SecondSpringMVCHandler {
    @RequestMapping("testExceptionHandler")
    public String testExceptionHandler() {
//        try {
        System.out.println(1 / 0);
//        } catch(ArithmeticException e)
        return "success";
    }

    @RequestMapping("testExceptionHandler2")
    public String testExceptionHandler2() {
        int[] nums = new int[2];
        System.out.println(nums[2]);
        return "success";
    }

    @RequestMapping("testMyException")
    public String testMyException(@RequestParam("i") Integer i) throws MyArrayIndexOutofBoundsException {
        if(i == 3) {
            throw new MyArrayIndexOutofBoundsException(); // 抛出异常
        }
        return "success";
    }

    @RequestMapping("testMyException2")
    public String testMyException2(@RequestParam("i") Integer i) {
        if (i == 3) {
            return "redirect:testResponseStatus"; // 跳转到某一个异常处理方法里
        }
        return "success";
    }

    @ResponseStatus(value=HttpStatus.CONFLICT, reason="测试。。。")
    @RequestMapping("testResponseStatus")
    public String testResponseStatus() {
        return "success";
    }


//    @ExceptionHandler({ArithmeticException.class})
//    public ModelAndView handlerArithmeticException1(Exception e) {
//        ModelAndView mv = new ModelAndView("error");
//        System.out.println(e + "==========");
//        mv.addObject("er", e);
//        return mv;
//    }
//
//    @ExceptionHandler({Exception.class})
//    public ModelAndView handlerArithmeticException2(Exception e) {
//        ModelAndView mv = new ModelAndView("error");
//        System.out.println(e + "==========");
//        mv.addObject("er", e);
//        return mv;
//    }
//
//    // 该方法可以捕获本类中抛出的ArithmeticException异常
//    @ExceptionHandler({ArithmeticException.class, ArrayIndexOutOfBoundsException.class})
//    public ModelAndView handlerArithmeticException(Exception e) {
//        ModelAndView mv = new ModelAndView("error");
//        System.out.println(e + "==========");
//        mv.addObject("er", e);
//        return mv;
//    }

}