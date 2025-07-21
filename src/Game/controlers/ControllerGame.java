package Game.controlers;

import Game.models.Field;
import Game.models.Player;

import java.util.Scanner;

public class ControllerGame {
	Scanner scanner = new Scanner(System.in);
	private Field field;
	private Player player1;
	private Player player2;

	public ControllerGame(Field field,Player player1, Player player2) {
		this.field = field;
		this.player1 = player1;
		this.player2 = player2;
	}

	public int inputCoordinate(String coordinate){
		System.out.printf("Введите координату %s", coordinate);
		return scanner.nextInt();
	}

//	Установка фигурки игрока на поле, если не получилось тоо!!!
	public void movePlayer(int x, int y, Player player){
		field.setCellField(x, y, player.getFIGURE());
	}

//	Определение игрока кто ходит
	public String curentMove(){
		String[][] temp = field.getStateField();
		int lentTemp = temp.length;
		int count = 0;
		for (int i = 0; i < lentTemp; i++) {
			for (int j = 0; j < lentTemp; j++) {
				if(temp[i][j] != " " || temp[i][j] != null){
					count++;
				}
			}
		}

		if(count == field.getSIZE_FIELD()*field.getSIZE_FIELD()){
			return null;
		}

		if(count % 2 == 0){
			return player1.getFIGURE();
		} else {
			return player2.getFIGURE();
		}
	}

	public boolean endGame(){
		if(curentMove() != null){
			return false;
		}

		return true;
	}

// проверка по горизонтали
	private boolean checkHorizonte(Player player){
		int count;
//		Проверка по горизонтали
		for (int i = 0; i < field.getSIZE_FIELD(); i++) {
			count = 0;
			for (int j = 0; j < field.getSIZE_FIELD(); j++) {
				if(field.getCellField(i,j) == player.getFIGURE()){
					count++;
				}
				if(count == field.getSIZE_FIELD()) return true;
			}

		}
		return false;
	}

//	проверка по вертикали
	private boolean checkVertical(Player player){
		int count = 0;
		for (int i = 0; i < field.getSIZE_FIELD(); i++) {
			count = 0;
			for (int j = 0; j < field.getSIZE_FIELD(); j++) {
				if(field.getCellField(j,i) == player.getFIGURE()){
					count++;
				}
				if(count == field.getSIZE_FIELD()) return true;
			}
		}
		return false;
	}

//	проверка по диагонали (с верхнего левого угла)
	private boolean checkDiagonal(Player player){
		int count = 0;
		if (field.getCellField(0,0) == player.getFIGURE()){
			for (int i = 0; i < field.getSIZE_FIELD(); i++) {
				if(field.getCellField(i,i) == player.getFIGURE()){
					count++;
				}
			}
		}
		if(count == field.getSIZE_FIELD()) return true;
		return false;
	}

//  проверка по диагонали (с верхнего правого угла)
private boolean checkDiagonalTwo(Player player){
	int count = 0;
	if(field.getCellField(field.getSIZE_FIELD() - 1, field.getSIZE_FIELD() - 1) == player.getFIGURE()){
		for (int i = 0; i < field.getSIZE_FIELD(); i++) {
			if(field.getCellField(i, field.getSIZE_FIELD() - 1 - i) == player.getFIGURE()) count++;
		}
	}

	if(count == field.getSIZE_FIELD()) return true;

	return false;
}

	//	Проверка победителя
	public boolean getWinnerPlayer(Player player){
		if(checkHorizonte(player))return true;
		if(checkVertical(player)) return true;
		if (checkDiagonal(player)) return true;
		if (checkDiagonalTwo(player)) return true;
		return false;
	}

//	Получить имя игрока
	public String getWinnerNamePlayer(){
		if(getWinnerPlayer(player1)) {
			return player1.getNAME();
		}
		if(getWinnerPlayer(player2)) {
			return player2.getNAME();
		} else {
			return "NON Winner";
		}
	}
}
