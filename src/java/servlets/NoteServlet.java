package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.console;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String line ="";
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        ArrayList<String> readLine = new ArrayList<>();
        
        while((line = br.readLine()) !=null) {
               readLine.add(line);
                }
        
        String editLink = request.getParameter("edit");
        String title = readLine.get(0);
        String contents = readLine.get(1); 
        
        System.out.print(editLink);
        Note note = new Note();
        note.setTitle(title);
        note.setContents(contents);
        request.setAttribute("data", note);
        
        if(editLink!=null) getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        
        else getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        br.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String title = request.getParameter("title");
      String contents = request.getParameter("contents");
      
    String path = getServletContext().getRealPath("/WEB-INF/note.txt");
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
    
    pw.write(title);
    pw.write("\n");
    pw.write(contents);
    
    Note note = new Note();
    note.setTitle(title);
    note.setContents(contents);
    
    request.setAttribute("data", note);
    
    getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    pw.close();
    }


}
