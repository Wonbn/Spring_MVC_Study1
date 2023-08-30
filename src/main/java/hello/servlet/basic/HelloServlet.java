package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        * HttpServlet 을 상속받고 Ctrl + O 단축키를 이용해서 찾은
        * service 메서드를 이용해서 Http 요청, 응답메세지를 자동으로 만들어준다.
        */
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // 쿼리 파라미터 중 username 이라는 이름을 가진 파라미터 값을 저장한다.
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 응답 헤더에 대한 내용을 쉽게 작성할 수 있다.
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        // 응답 메세지를 웹 브라우저에 출력한다.
        response.getWriter().write("Hello "+ username);

    }
}
