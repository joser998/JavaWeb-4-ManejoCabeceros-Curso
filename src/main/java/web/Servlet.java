package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter salida = response.getWriter();
        //Recibe el tipo de cabecero
        String metodoHttp = request.getMethod();
        
        //Creamos documento HTML
        salida.print("<html>");
        salida.print("<head>");
        salida.print("<title>Headers Http</title>");
        salida.print("</head>");
        
        salida.print("<body>");
        salida.print("<h1>Headers HTTP</h1>");
        salida.print("<br>");
        salida.print("Metodo Http: "+metodoHttp); //Imprimimos el cabecero
        
        String uri = request.getRequestURI();//Guardamos la URI
        salida.print("<br>");
        salida.print("Uri solicitada: "+uri);//Imprimimos la URI
        
        //Imprimimos todos los cabeceros disponibles
        salida.print("<br><br>");
        Enumeration cabeceros = request.getHeaderNames();
        while(cabeceros.hasMoreElements()){
            String nombreCabecero = (String) cabeceros.nextElement();
            salida.print("<b>"+nombreCabecero+"</b>");
            salida.print(request.getHeader(nombreCabecero));
            salida.print("<br>");
        }
        
        
        
        
        
        salida.print("</body>");
        salida.print("</html>");
        salida.close();
        
    }   
}