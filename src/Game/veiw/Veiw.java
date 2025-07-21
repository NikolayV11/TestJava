package Game.veiw;

import Game.models.Field;

public class Veiw {
	private Field field;

	public Veiw(Field field){
		this.field = field;
		System.out.println("Hello. This is a new Game!!!");
		System.out.println("----------------------------");
	}

	public void showField(){
		for (int i = 0; i < field.getSIZE_FIELD(); i++) {
			for (int j = 0; j < field.getSIZE_FIELD(); j++) {
				System.out.printf("[%s]" , field.getCellField(i,j));
			}
			System.out.println("Переход на новую строку.");
		}
	}
}
