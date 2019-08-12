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

  </body>
</html>