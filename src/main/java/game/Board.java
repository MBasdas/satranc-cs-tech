package game;

import model.AbstractTas;

import java.util.ArrayList;
import java.util.List;

/**
 * Board oluştururken iki boyutlu array kullanmayı tercih ettim.
 * Map de tercih edilebilirdi. Ancak görsel düşününce iki boyutlu
 * arrayin daha iyi olabileceğini düşündüm.
 * Hareket yönü için for döngülerini iç içe kullanmak zorunda bıraktı.
 * Map kullansam iç içe döngülerin çoğundan beni kurtarabilirdi.
 * Taşları dolaşmak için dıştaki iki döngü yerine tek döngü ile hallebilirdi.
 *
 * Ayrıca Board'ı singleton pattern ile oluşturdum.
 */
public class Board {

    private static Board board;
    private static final Object obj = new Object();
    private static AbstractTas[][] taslar;

    private Board() {}

    public static Board getInstance(){
        if(board !=null) {
            return board;
        }

        synchronized(obj){
            if(board == null){
                board = new Board();
            }
            return board;
        }
    }

    public void addTas(AbstractTas t) {
        if(t!=null){
            taslar[t.getY()][t.getX()] = t;
        }
    }

    public AbstractTas[][] getTaslar(){
        return taslar;
    }

    public AbstractTas getTas(int x, int y){
        return taslar[y][x];
    }

    public List<AbstractTas> getColoredTas(int color){
        List<AbstractTas> coloredTaslar = new ArrayList<>();
        for(int y=0; y< 8 ; y++){
            for (int x=0; x<8; x++){
                if(getTas(x,y) != null && getTas(x,y).getColor() == color)
                    coloredTaslar.add(getTas(x,y));
            }
        }
        return coloredTaslar;
    }

    public void printBoard() {
        for(int y=0; y< 8 ; y++){
            for (int x=0; x<8; x++){
                if(getTas(x,y) == null)
                    System.out.print("--");
                else
                    System.out.print(getTas(x,y).getTasAdi() +  getTas(x,y).getColor());
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void resetTaslar(){
        this.taslar = new AbstractTas[8][8];
    }
}
