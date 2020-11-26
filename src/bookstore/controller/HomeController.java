package bookstore.controller;

import bookstore.model.User;
import bookstore.view.AuthView;
import bookstore.view.HomeView;

public class HomeController {
	
//	private User model;
	private HomeView view;
	
	public HomeController() {
	}
	
	public void viewAuthPage() {
		AuthView auth = new AuthView();
		auth.setVisible(true);
	}
	
	public void viewHomePage() {
		HomeView home = new HomeView();
		home.setVisible(true);
	}
	
	
	
	
	

}
