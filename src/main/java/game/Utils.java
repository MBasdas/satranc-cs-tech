package game;

public class Utils {


    public static final int SIYAH = 0;
    public static final int BEYAZ = 1;
    public static final String[] RENK_ADI = {"Siyah", "Beyaz"};

    public static final String SONUC_FILE="doc/sonuc.txt";
    public static final String BOARD_1= "doc/board1.txt";
    public static final String BOARD_2= "doc/board2.txt";
    public static final String BOARD_3= "doc/board3.txt";

    public static final class Points{
        private Points() {}
        public static final int SAH_POINT = 100;
        public static final int VEZIR_POINT = 9;
        public static final int FIL_POINT = 3;
        public static final int KALE_POINT = 5;
        public static final int AT_POINT = 3;
        public static final int PIYON_POINT = 1;
    }
}