package model;

import game.Board;
import model.interfaces.ISahHareketYonu;

public class Sah extends AbstractTas implements ISahHareketYonu {

    @Override
    public void move() {
        sahHareketi(this);
    }
}