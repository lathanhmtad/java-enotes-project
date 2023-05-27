package com.example.controller;

import java.io.IOException;
import java.util.List;

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

	private NoteService noteService;

	@Override
	public void init() throws ServletException {
		noteService = NoteService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String view = "";
		if (type.equals("add")) {
			view = "/views/save_note.jsp";
		} else if (type.equals("list")) {
			UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");	
			Long latestId = (Long) SessionUtil.getInstance().getValue(request, "latestNoteId");
			latestId = latestId != null ? latestId : 0L;
			List<NoteModel> notes = noteService.findAllByUserId(userModel.getId(), latestId);
			request.setAttribute("notes", notes);
			view = "views/show_note.jsp";
		} else if (type.equals("edit")) {
			String id = request.getParameter("id");
			NoteModel note = noteService.findOneById(Long.parseLong(id));
			request.setAttribute("note", note);
			view = "/views/save_note.jsp";
		} else if (type.equals("delete")) {
			doDelete(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String type = request.getParameter("type");

		if (type.equals("add")) {
			NoteModel noteModel = FormUtil.toModel(request, NoteModel.class);
			UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
			noteModel.setUser(userModel);

			Long id = noteService.save(noteModel);
			
			SessionUtil.getInstance().putValue(request, "latestNoteId", id);
			
			response.sendRedirect(request.getContextPath() + "/note?type=list");
		} else if (type.equals("edit")) {
			doPut(request, response);
		}
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoteModel newNote = FormUtil.toModel(request, NoteModel.class);

		noteService.update(newNote);
		SessionUtil.getInstance().putValue(request, "latestNoteId", newNote.getId());
		
		response.sendRedirect(request.getContextPath() + "/note?type=list");
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		noteService.deleteNoteById(Long.parseLong(id));
		
		response.sendRedirect(request.getContextPath() + "/note?type=list");

	}
}
