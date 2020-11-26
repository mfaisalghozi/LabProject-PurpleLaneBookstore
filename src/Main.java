import bookstore.view.AuthView;
import bookstore.view.HomeView;

public class Main {

	public Main() {
		AuthView auth = new AuthView();
		auth.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
