package com.epam.liavitskaya.test.server;

import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.liavitskaya.main.controller.Controller;
import com.epam.liavitskaya.main.server.Server;

public class ServerTest {
	
	Controller controller;
	Server server;

	@Test(dataProvider = "dataProvider", threadPoolSize = 1, invocationCount = 1, timeOut = 1000)
	public void f(String request, String expected) {
		
		LinkedList<String> startServer = (LinkedList<String>) Server.startServer(request);
		Assert.assertEquals(startServer.poll(), expected);		
	}

	@DataProvider
	public Object[][] dataProvider() {
		
		return new Object[][] { 
				new Object[] { "ORDER_BOOK 8", "Book is ordered" },
				new Object[] { "REVIEW_PROFILE_ID 8", "\nUser [userName = Ann, userPassportNo = null, phone = phone888, email = email888, userRole = USER, login = xxx888, userStatus = INACTIVE]" }, 
				new Object[] { "WRITE_OFF_BOOK 9", "book is written off" },
				new Object[] { "ADD_BOOK Harry_Potter_2 J.K.Rowling England", "New book is added" },
				new Object[] { "EDIT_BOOK The_Norwegian_Wood Haruki_Murakami Japan_1987 9", "book is edited" },				
				new Object[] { "REGISTRATION KIMBERIY MP1100010 PHONE110 EMAIL110 USER xxx110 encryptT10@ ACTIVE", "Welcome" },
				new Object[] { "REGISTRATION KIMBERIY MP1100010 PHONE110 EMAIL110 USER xXx110 encryptT10@ ACTIVE", "Error during registration" },
				new Object[] { "MAKE_ADMIN_USER USER 3", "Error during procedure of change of the status of the admin" },
				new Object[] { "CANCEL_ORDER 3", "Order is cancelled" },
				new Object[] { "CANCEL_ORDER 6", "Error during order book procedure" },
				new Object[] { "SHOW_ALL_AVAILABLE_BOOKS",
						"Check available books : [\nBook [title = Nineteen Eighty-Four, author = George Orwell, description = 1849_UK, bookStatus = AVAILABLE], \nBook [title = Lolita, author = Vladimir Nabokov, description = Russia, bookStatus = AVAILABLE], \nBook [title = Great Expectation, author = Charles Dickens, description = England, bookStatus = AVAILABLE], \nBook [title = The Hobbit, or There and Back Again, author = J.R.R.Tolkien, description = 1937 UK, bookStatus = AVAILABLE], \nBook [title = Harry_Potter_2, author = J.K.Rowling, description = England, bookStatus = AVAILABLE]]" },
		};
	}

	@BeforeClass
	public void beforeClass() {
		
		controller = Controller.getInstance();
		controller.executeTask("SIGN_IN admin_login222 encryptT@2");
	}

	@AfterClass
	public void afterClass() {

	}

}
