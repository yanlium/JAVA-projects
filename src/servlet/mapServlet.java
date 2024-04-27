package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mapServlet")
public class mapServlet extends HttpServlet {
    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        //读取
        String address = req.getParameter(s,"address")*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter("address");
        req.setAttribute("address",address);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
