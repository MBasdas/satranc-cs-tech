package app;

import game.Board;
import game.CalculatePoints;
import game.FileReader;
import game.Utils;

public class App {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("Tahta")
                .append("\t\t\t")
                .append("Beyaz")
                .append("\t\t\t")
                .append("Siyah")
                .append("\n");

        FileReader fr = FileReader.getInstance();
        fr.readFile(Utils.BOARD_1);
        System.out.println("-------------Yazılan Data--------------");
        Board.getInstance().printBoard();
        System.out.println("-------------Yazılan Data--------------");
        CalculatePoints cp = new CalculatePoints();
        cp.calculcatePoint();

        sb.append("board1")
                .append("\t\t\t")
                .append(cp.getWhitePoint())
                .append("\t\t\t")
                .append(cp.getBlackPoint())
                .append("\n");

        fr.readFile(Utils.BOARD_2);
        System.out.println("-------------Yazılan Data--------------");
        Board.getInstance().printBoard();
        System.out.println("-------------Yazılan Data--------------");
        cp.calculcatePoint();

        sb.append("board2")
                .append("\t\t\t")
                .append(cp.getWhitePoint())
                .append("\t\t\t")
                .append(cp.getBlackPoint())
                .append("\n");

        fr.readFile(Utils.BOARD_3);
        System.out.println("-------------Yazılan Data--------------");
        Board.getInstance().printBoard();
        System.out.println("-------------Yazılan Data--------------");
        cp.calculcatePoint();

        sb.append("board3")
                .append("\t\t\t")
                .append(cp.getWhitePoint())
                .append("\t\t\t")
                .append(cp.getBlackPoint())
                .append("\n");

        FileReader.getInstance().writeFile(Utils.SONUC_FILE,sb.toString());


    }


}
