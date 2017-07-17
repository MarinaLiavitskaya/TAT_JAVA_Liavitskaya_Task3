package com.epam.liavitskaya.main.runner;

import java.util.List;

import com.epam.liavitskaya.main.controller.Controller;
import com.epam.liavitskaya.main.server.Server;

public class Runner {

	public static void main(String[] args) {

		Controller controller = Controller.getInstance();				
		controller.executeTask("SIGN_IN superadmin1991 encryptT@1991");
			
		Server.startServer("ORDER_BOOK 8");		
		Server.startServer("REVIEW_PROFILE_ID 8");				
		List<String> startServer = Server.startServer("EDIT_PROFILE 3 Molly MP2302323 25+###59 email333 logixqrrn63 paes&wtswW43");
		System.out.println("###			startServer  " + startServer);
		Server.startServer("EDIT_BOOK The_Norwegian_Wood Haruki_Murakami Japan_1987 9");
		//Server.initServer("SHOW_ALL_AVAILABLE_BOOKS");
		Server.startServer("ADD_BOOK Harry_Potter J.K.Rowling England");		
		Server.startServer("WRITE_OFF_BOOK 9");
		//List<String> startServer = Server.startServer("MAKE_ADMIN_USER USER 1");
		//System.out.println(startServer);
		List<String> startServer2 = Server.startServer("WRITE_OFF_BOOK 8");	
		System.out.println("#####			startServer2  " + startServer2);
		// server.initServer("SHOW_ALL_AVAILABLE_BOOKS");
		Server.startServer("ADD_BOOK Harry_Potter_2 J.K.Rowling England");
		// server.initServer("SHOW_ALL_AVAILABLE_BOOKS");
		Server.startServer("ADD_BOOK Harry_Potter_3 J.K.Rowling England");			
		// server.initServer("SHOW_ALL_AVAILABLE_BOOKS");		
		List<String> startServer3 = Server.startServer("ADD_BOOK Harry_Potter_5 J.K.Rowling England");			
		System.out.println("########  	startServer3  " + startServer3);  // 12
	
	}
}
