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

      <a href="handler/welcome2">first springmvc - welcome</a><br>

      <form action="handler/welcome" method="post">
          name:<input name="name"/><br>
          age:<input name="age"/><br>
          height:<input name="height"/><br>
          <input type="submit" value="post">
      </form>
  </body>
</html>