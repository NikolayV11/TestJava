package Game;

import Game.controlers.ControllerGame;
import Game.models.Field;
import Game.models.Player;
import Game.veiw.Veiw;

public class Main {
	public static void main(String[] args) {
		Field field = new Field(3);
		Player one = new Player("Max", "0");
		Player two = new Player("Lev", "1");
		ControllerGame controllerGame = new ControllerGame(field, one, two);
		Veiw veiw = new Veiw(field);
		veiw.showField();
	}
}
