package game;

import model.AbstractTas;

import java.util.List;

public class CalculatePoints {

    private double whitePoint;
    private double blackPoint;

    public void calculcatePoint(){
        Board b = Board.getInstance();
        List<AbstractTas> whiteTaslar = b.getColoredTas(Utils.BEYAZ);
        List<AbstractTas> blackTaslar = b.getColoredTas(Utils.SIYAH);
        whiteTaslar.stream().forEach(AbstractTas::move);
        blackTaslar.stream().forEach(AbstractTas::move);

        whitePoint = sumPoint(whiteTaslar);
        blackPoint = sumPoint(blackTaslar);

        System.out.println("beyaz point " +whitePoint);
        System.out.println("Siyah point " +blackPoint);

    }

    private double sumPoint(List<AbstractTas> taslar) {
        return taslar.stream().map(AbstractTas::getPoint).reduce(0.0, Double::sum);
    }

    public double getWhitePoint(){
        return whitePoint;
    }

    public double getBlackPoint(){
        return blackPoint;
    }
}
