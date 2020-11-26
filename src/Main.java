import bookstore.database.DatabaseMySql;
import bookstore.view.AuthView;
import bookstore.view.HomeView;

public class Main {

	public Main() {
		AuthView auth = new AuthView();
		auth.setVisible(true);
//		DatabaseMySql n = new DatabaseMySql();
	}

	public static void main(String[] args) {
		new Main();
	}

}
