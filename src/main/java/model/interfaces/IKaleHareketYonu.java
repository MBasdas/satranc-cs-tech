package model.interfaces;

import game.Board;
import model.AbstractTas;
import org.jetbrains.annotations.NotNull;

/**
 * İki farklı for döngüsü yazıldı.
 * Biri Y ekseninde hareket ettiriyor.
 * Diğeri X ekseninde hareket ettiriyor.
 * İçerdeki While  döngüsü ise taş bulana kadar hareket ettiriyor.
 */
public interface IKaleHareketYonu {
    default void kaleHareketi(@NotNull AbstractTas kale){
        AbstractTas tas = null;
        int xPoint = kale.getX();
        int yPoint = kale.getY();

        //x exeni yönünde hareket ettirmek için
        for(int x:kale.xExeniHareketYonu){
            //hangi yöne hareket ediyorsa o yönde taş bulana kadr ilerlemesi
            while(tas == null && kale.isValidMove(xPoint + x, kale.getY())){
                xPoint = xPoint + x;
                tas = Board.getInstance().getTas(xPoint, kale.getY());
                kale.tehditEt(tas);
            }
            tas = null;
            xPoint = kale.getX();
        }

        //y exeni yönünde hareket ettirmek için
        for(int y: kale.yExeniHareketYonu){
            //hangi yöne hareket ediyorsa o yönde taş bulana kadr ilerlemesi
            while(tas == null && kale.isValidMove(kale.getX(), yPoint + y)){
                yPoint = yPoint + y;
                tas = Board.getInstance().getTas(kale.getX(), yPoint);
                kale.tehditEt(tas);
            }
            tas = null;
            xPoint = kale.getX();
            yPoint = kale.getY();
        }
    }
}
