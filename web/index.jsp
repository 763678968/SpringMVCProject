<%--
  Created by IntelliJ IDEA.
  User: animation
  Date: 2019/8/10
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <!-- 如果web.xml中的配置是
          <servlet-mapping>
              <servlet-name>springDispatcherServlet</servlet-name>
              <url-pattern>/</url-pattern>
          </servlet-mapping>

          <a href="user/welcome.action">first springmvc - welcome</a> 交由springmvc处理，找@RequestMapping映射
          <a href="user/welcome.action">first springmvc - welcome</a> 交由springmvc处理，找@RequestMapping映射
          <a href="user/welcome">first springmvc - welcome</a>        交由servlet处理，找url-pattern / @WebServlet()
      -->

      <a href="handler/welcome3/xyz/abcz/asb/test">333333first springmvc - welcome</a><br>
      <a href="handler/welcome4/abc/test">4444444444first springmvc - welcome</a><br>
      <a href="handler/welcome5/zs">5555555first springmvc - welcome</a><br>

      <form action="handler/welcome" method="post">
          name:<input name="name"/><br>
          age:<input name="age"/><br>
          height:<input name="height"/><br>
          <input type="submit" value="post">
      </form>

      <br/>=========<br/>

      <form action="handler/testRest/1234" method="post">
          <input type="submit" value="增">
      </form>

      <form action="handler/testRest/1234" method="post">
          <input type="hidden" name="_method" value="DELETE"/>
          <input type="submit" value="删">
      </form>

      <form action="handler/testRest/1234" method="post">
          <input type="hidden" name="_method" value="PUT"/>
          <input type="submit" value="改">
      </form>

      <form action="handler/testRest/1234" method="get">
          <input type="submit" value="查"/>
      </form>

      -----------------<br/>
      <form action="handler/testParam" method="get">
          name:<input name="uname" type="text"/>
<%--          age:<input name="uage" type="text"/>--%>
          <input type="submit" value="查"/>
      </form>

      <a href="handler/testRequestHeader">testRequestHeader</a><br>
      <a href="handler/testCookieValue">testCookieValue</a><br>

      <form action="handler/testObjectProperties" method="post">
          id:<input name="id" type="text"/>
          name:<input name="name" type="text"/>
          家庭地址:<input name="address.homeAddress" type="text"/>
          学校地址:<input name="address.schoolAddress" type="text"/>
          <input type="submit" value="查">
      </form><br>

<%--      <a href="handler/testServletAPI">testServletAPI</a><br/>--%>

      <a href="handler/testModelAndView">testModelAndView</a><br>
      <a href="handler/testModelMap">testModelMap</a><br>
      <a href="handler/testMap">testMap</a><br>
      <a href="handler/testModel">testModel</a><br>
      <a href="handler/testI18n">testI18n</a><br>

      <form action="handler/testModelAttribute" method="post">
          编号:<input name="id" type="hidden" value="31"/>
          姓名:<input name="name" type="text"/>
          <input type="submit" value="修改">
      </form><br/>

      <br>
            <a href="handler/testMvcViewController">testMvcViewController</a>
      <br/>

      <form action="handler/testConverter" method="post">
            学生信息：<input name="studentInfo" type="text"/>
            <input type="submit" value="转换"/>
      </form>

      <form action="handler/testDateTimeFormat" method="post">
          编号:<input name="id" type="text" value="31"/>
          姓名:<input name="name" type="text"/>
          出生日期：<input name="birthday" type="text"/>
          邮箱：<input name="email" type="text"/>
          <input type="submit" value="修改">
      </form>

      <br/>
      <br/>
      <br/>
      <form action="handler/testUpload" method="post" enctype="multipart/form-data">
          <input name="file" type="file"/>
          描述:<input name="desc" type="text"/>

          <input type="submit" value="上传">
      </form>

  </body>
</html>