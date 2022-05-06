package model;

import model.interfaces.IFilHareketYonu;
import model.interfaces.IKaleHareketYonu;

public class Vezir extends AbstractTas implements IKaleHareketYonu, IFilHareketYonu {

    @Override
    public void move() {
        filHareketi(this);
        kaleHareketi(this);
    }

}
