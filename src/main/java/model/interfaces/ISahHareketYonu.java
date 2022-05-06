package model.interfaces;

import game.Board;
import model.AbstractTas;

public interface ISahHareketYonu {
    default void sahHareketi(AbstractTas sah){
        AbstractTas tas = null;
        int xPoint = sah.getX();
        int yPoint = sah.getY();

        //kale gibi sağa sola
        //x exeni yönünde hareket ettirmek için
        for(int x:sah.xExeniHareketYonu){
            //hangi yöne hareket ediyorsa o yönde taş bulana kadr ilerlemesi
            xPoint = xPoint + x;
            if(sah.isValidMove(xPoint, sah.getY())){
                tas = Board.getInstance().getTas(xPoint, sah.getY());
                sah.tehditEt(tas);
            }
            tas = null;
            xPoint = sah.getX();
        }

        //kale gibi yukarı aşağı
        //y exeni yönünde hareket ettirmek için
        for(int y: sah.yExeniHareketYonu){
            //hangi yöne hareket ediyorsa o yönde taş bulana kadr ilerlemesi
            yPoint = sah.getY() + y;
            if(sah.isValidMove(sah.getX(), yPoint)){
                tas = Board.getInstance().getTas(sah.getX(), yPoint);
                sah.tehditEt(tas);
            }
            tas = null;
            yPoint = sah.getY();
        }

        tas = null;

        //çapraz yönde (fil gibi)
        //x exeni yönünde hareket ettirmek için
        for(int x:sah.xExeniHareketYonu){
            //y exeni yönünde hareket ettirmek için
            for(int y: sah.yExeniHareketYonu){
                //hangi yöne hareket ediyorsa o yönde taş bulana kadr ilerlemesi
                xPoint = xPoint + x;
                yPoint = yPoint + y;
                if(sah.isValidMove(xPoint, yPoint)){
                    tas = Board.getInstance().getTas(xPoint, yPoint);
                    sah.tehditEt(tas);
                }
                tas= null;
                xPoint = sah.getX();
                yPoint = sah.getY();
            }
        }
    }
}
