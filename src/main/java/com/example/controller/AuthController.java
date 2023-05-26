package com.example.controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.UserModel;
import com.example.services.UserService;
import com.example.utils.FormUtil;
import com.example.utils.SessionUtil;


@WebServlet("/auth")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AuthController() {
        super();
    }
    
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "";
		if(action != null) {
			if(action.equals("login")) {
				view = "/views/login.jsp";
			}
			else if(action.equals("register")) {
				view = "/views/register.jsp";
			}
			else if(action.equals("logout")) {
				SessionUtil.getInstance().removeValue(request, "userModel");
				view = "/views/home.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		
		UserModel userModel = FormUtil.toModel(request, UserModel.class);
		UserService service = new UserService();
		
		if(action.equals("login")) {
			userModel = service.findOneByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
			if(userModel != null) {
				// login success
				SessionUtil.getInstance().putValue(request, "userModel", userModel);
				response.sendRedirect(request.getContextPath() + "/home");
			}	
			else {
				// login failed
			}
		}
		else if(action.equals("register")) {
			Long id = service.save(userModel);
			if(id != null) { 
				// register success
				request.setAttribute("alert", "success");
				request.setAttribute("message", resourceBundle.getString("register_success"));
				RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
				rd.forward(request, response);		
			}
			else { 
				// register failed
			}
				
		}
	}

}
