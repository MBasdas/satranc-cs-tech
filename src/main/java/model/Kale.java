package model;

import model.interfaces.IKaleHareketYonu;

public class Kale extends AbstractTas implements IKaleHareketYonu {

    @Override
    public void move() {
        kaleHareketi(this);
    }
}
