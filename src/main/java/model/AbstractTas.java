package model;

import game.Utils;

import java.util.Objects;

/**
 * Tüm satranç taşları bu classtan extend edilecek.
 */
public abstract class AbstractTas implements Cloneable{

    private String tasAdi;
    private String tamTasAdi;
    private double point;
    private int x;
    private int y;
    private int color;
    private boolean tehdit;

    public final int[] xExeniHareketYonu = {1, -1};
    public final int[] yExeniHareketYonu = {1, -1};

    public abstract void move();

    public void tehditEt(AbstractTas tas){
        if(tas != null && tas.getColor() != this.getColor()){
            tas.setTehdit(true);
            System.out.println(tas + ","+ this +" tarafından " + " Tehdit Edildi.");
        }
    }

    public boolean isValidMove(int x, int y){
        return x < 8 && y < 8
                && x > -1 && y > -1;
    }

    public double getPoint() {
        if(isTehdit())
            return point/2;
        else
            return point;
    }

    public String getTasAdi() {
        return tasAdi;
    }

    public void setTasAdi(String tasAdi) {
        this.tasAdi = tasAdi;
    }

    public String getTamTasAdi() {
        return tamTasAdi;
    }

    public void setTamTasAdi(String tamTasAdi) {
        this.tamTasAdi = tamTasAdi;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isTehdit() {
        return tehdit;
    }

    public void setTehdit(boolean tehdit) {
        this.tehdit = tehdit;
    }

    @Override
    public AbstractTas clone() {
        try {
            return (AbstractTas) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(Utils.RENK_ADI[getColor()])
                .append(" ")
                .append(tamTasAdi)
                .append(" y:")
                .append(this.getY())
                .append(" x:")
                .append(this.getX())
                .append(" ")
                .append(this.getPoint());
        return  str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractTas that = (AbstractTas) o;
        return color == that.color && Objects.equals(tasAdi, that.tasAdi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tasAdi, color);
    }
}