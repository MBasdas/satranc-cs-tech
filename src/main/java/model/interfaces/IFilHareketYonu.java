package model.interfaces;

import game.Board;
import model.AbstractTas;
import org.jetbrains.annotations.NotNull;

/**
 * Dıştaki iki for döngüsü düşünüldüğü gibi maliyet yaratmıyor.
 * Onların amacı Y ekseni yönünde yukarı mı, aşağı mı hareket etmesi gerekitiğini buluyor.
 * X ekseni açısından da sağa mı, sola mı hareket etmesi gerektiğini buluyor.
 * İçerdeki while döngüsü ise hareket yönüne göre taş bulana kadar dönüyor.
 */
public interface IFilHareketYonu {
    default void filHareketi(@NotNull AbstractTas fil){
        AbstractTas tas = null;
        int xPoint = fil.getX();
        int yPoint = fil.getY();
        //y exeni yönünde hareket ettirmek için
        for(int y: fil.yExeniHareketYonu){
            //x exeni yönünde hareket ettirmek için
            for(int x:fil.xExeniHareketYonu){
                //hangi yöne hareket ediyorsa o yönde taş bulana kadr ilerlemesi
                while(tas == null && fil.isValidMove(xPoint + x, yPoint + y)){
                    xPoint = xPoint + x;
                    yPoint = yPoint + y;
                    tas = Board.getInstance().getTas(xPoint, yPoint);
                    fil.tehditEt(tas);
                }
                tas = null;
                xPoint = fil.getX();
                yPoint = fil.getY();
            }
        }
    }
}
