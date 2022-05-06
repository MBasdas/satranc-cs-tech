package model.interfaces;

import game.Board;
import model.AbstractTas;

/**
 * Algoritma kötü görünüyor.
 * Ancak burada bellek yönetimi açısından problem bulunmadığı varsayılıyor.
 * Ayrıca 3 tane döngü iki şer kez dönüyor.
 * 2^3 => 8 operasyonla işlem bitiyor.
 */

public interface IAtHareketYonu {
    default void atHareketi(AbstractTas at){
        int xPoint = at.getX();
        int yPoint = at.getY();


        //y ekseni yönünde hareket et
        for(int y: at.yExeniHareketYonu){
            //x  ekseni yönünde hareket et
            for(int x: at.xExeniHareketYonu) {
                //L hareketi için böyle yazıldı.
                //Y ekseni 2 artarken/azalırken X ekseni 1 artar/azalır
                //X Ekseni 2 artarken/azalırken Y ekseni 1 artar/azalır
                for (int iki = 0; iki < 3; iki++) {
                    if (iki % 2 == 0) {
                        yPoint += y * 2;
                        xPoint += x;
                    } else {
                        yPoint += y;
                        xPoint += x * 2;
                    }
                    if(at.isValidMove(xPoint, yPoint))
                        at.tehditEt(Board.getInstance().getTas(xPoint, yPoint));
                    //Başlangıç noktasına dönüldü.
                    xPoint = at.getX();
                    yPoint = at.getY();
                }
            }
        }
    }
}
