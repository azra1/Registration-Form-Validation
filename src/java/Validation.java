/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Azra
 */
public class Validation extends HttpServlet {

        protected String defaultLogFile = "E:\\msglog.txt";
        int c=0;
        public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList al=new ArrayList();
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        try{
        final String fname = req.getParameter("fname");
        final String fphone = req.getParameter("fphone");
        final String femail = req.getParameter("femail");
        FileWriter f=new FileWriter(defaultLogFile, true);
        int fno = 0;
        if(fphone.length()!=10)
        {
            al.add("PROVIDE VALID PHONE NUMBER");
             out.println("<meta http-equiv='refresh' content='3;URL=index.html'>");//redirects after 3 seconds
             out.println("PROVIDE VALID PHONE NUMBER!");
             c=1;
        }
        else
        {
              f.write(fphone);
        }
        if ((fphone == null) || (fphone.equals(""))) {
            al.add("PROVIDE PHONE NUMBER...");
             out.println("<meta http-equiv='refresh' content='3;URL=index.html'>");//redirects after 3 seconds
              out.println("PROVIDE PHONE NUMBER!");
              c=1;
        } else {
            try {
                fno = Integer.parseInt("fphone");
            } catch (NumberFormatException nfe) {
                al.add("PROVIDE NUMBER IN PHONE NUMBER...");
                 out.println("<meta http-equiv='refresh' content='3;URL=index.html'>");//redirects after 3 seconds
                 c=1;
            }
        }
        if ((fname == null) || (fname.equals(""))) {
            al.add("NAME CAN'T BE BLANK...");
             out.println("<meta http-equiv='refresh' content='3;URL=index.html'>");//redirects after 3 seconds
              out.println("NAME CAN'T BE BLANK!");
              c=1;
        }
        else
        {
             f.write(fname);
        }
        if ((femail == null) || (femail.equals(""))) {
            al.add("EMAIL CAN'T BE BLANK...");
             out.println("<meta http-equiv='refresh' content='3;URL=index.html'>");//redirects after 3 seconds
              out.println("EMAIL CAN'T BE BLANK!");
              c=1;
        }
        else
        {
            f.write(femail);
        }
        RequestDispatcher rs = req.getRequestDispatcher("hello.html");
        rs.forward(req,res);
        }catch(Exception en)
        {
            System.out.println(en);
        }
        }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
};
