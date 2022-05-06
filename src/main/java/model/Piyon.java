package model;

import model.interfaces.IPiyonHareketYonu;

public class Piyon extends AbstractTas implements IPiyonHareketYonu {

    @Override
    public void move() {
        piyonHareketi(this);
    }

}
