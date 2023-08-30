package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;
import java.io.IOException;
import static java.nio.charset.StandardCharsets.*;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, UTF_8);

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
    /*
      Postman 을 이용해서 POST 방식의 raw 한 데이터를 Body 에 저장해서 요청한다.
      POST http://localhost:8080/request-body-string
      content-type: text/plain
      message body: hello
      결과: messageBody = hello
     */
}
