package model;

import model.interfaces.IFilHareketYonu;

public class Fil extends AbstractTas implements IFilHareketYonu {

    @Override
    public void move() {
         filHareketi(this);
    }



}
