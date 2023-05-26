package com.example.controller;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.NoteModel;
import com.example.model.UserModel;
import com.example.services.NoteService;
import com.example.utils.FormUtil;
import com.example.utils.SessionUtil;


@WebServlet("/note")
public class NoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NoteController() {
        super();
    }
    
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String view = "";
		if(type.equals("add")) {
			view = "/views/save_note.jsp";
		}
		else if(type.equals("list")) {
			NoteService service = new NoteService();
			UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
			List<NoteModel> notes = service.findAllByUserId(userModel.getId());
			request.setAttribute("notes", notes);
			view = "views/show_note.jsp";
		}
		else if(type.equals("edit")) {
			String id = request.getParameter("id");
			NoteService service = new NoteService();
			NoteModel note = service.findOneById(Long.parseLong(id));
			request.setAttribute("note", note);
			view = "/views/save_note.jsp";
		}
		else if(type.equals("delete")) {
			doDelete(request, response);
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		
		if(type.equals("add")) {
			NoteModel noteModel = FormUtil.toModel(request, NoteModel.class);
			UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
			noteModel.setUser(userModel);
		
			NoteService service = new NoteService();
			Long id = service.save(noteModel);
			
			if(id != null) {
				// add note success
				request.setAttribute("alert", "success");
				request.setAttribute("message", resourceBundle.getString("add_note_success"));
				RequestDispatcher rd = request.getRequestDispatcher("/views/save_note.jsp");
				rd.forward(request, response);
			}
			else {
				// add note failed
				
			}
		}
		else if(type.equals("edit")) {
			doPut(request, response);
		}
		
		
	}
	
	


	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoteModel newNote = FormUtil.toModel(request, NoteModel.class);
		
		NoteService service = new NoteService();
		boolean flag = service.updateNote(newNote);
		if(flag) {
			// update note success
			request.setAttribute("alert", "success");
			request.setAttribute("message", resourceBundle.getString("update_note_success"));
			RequestDispatcher rd = request.getRequestDispatcher("/views/save_note.jsp");
			rd.forward(request, response);
		}
		else {
			// update note failed
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		NoteService service = new NoteService();
		boolean flag = service.deleteNoteById(Long.parseLong(id));
		if(flag) {
			// delete note success
			response.sendRedirect(request.getContextPath() + "/note?type=list");
		}
		else {
			// delete note failed
		}
	}
}
