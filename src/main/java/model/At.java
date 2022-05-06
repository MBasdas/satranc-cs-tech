package model;

import model.interfaces.IAtHareketYonu;

public class At extends AbstractTas implements IAtHareketYonu {

    @Override
    public void move() {

        //hareket sıklığı 1 2 2 1
        //yani x eksenine 1 ekle y eksenine 2 ekle
        //yani y eksenine 2 ekle x eksenine 1 ekle
        atHareketi(this);
    }


}
