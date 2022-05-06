package model.interfaces;

import game.Board;
import game.Utils;
import model.AbstractTas;

/**
 * Piyon Y ekseni yönünden yukarıyı mı kontrol edecek yoksa aşağıyı mı?
 * Bu açıdan düşününce piyonun rengi devreye giriyor.
 * Renge göre yukarı veya aşağıya bakması gerektiğini anlıyor.
 * Hareketi açısından tehdit edeceği taş yönünden komplex bir yapıya sahip değil.
 * Döngü gereksiz.
 */
public interface IPiyonHareketYonu {

    default void piyonHareketi(AbstractTas piyon){
        int y = piyon.getY() + piyon.yExeniHareketYonu[piyon.getColor()];
        int x1 = piyon.getX() + piyon.xExeniHareketYonu[0];//sağ tarafı
        int x2 = piyon.getX() + piyon.xExeniHareketYonu[1];//sol tarafı
        if(piyon.isValidMove(x1, y)){
            AbstractTas sagTas = Board.getInstance().getTas(x1, y);
            piyon.tehditEt(sagTas);
        }
        if(piyon.isValidMove(x2, y)){
            AbstractTas solTas = Board.getInstance().getTas(x2, y);
            piyon.tehditEt(solTas);
        }
    }


}
