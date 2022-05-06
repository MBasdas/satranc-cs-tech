package game;

import model.*;
import model.builder.TasBuilder;

/**
 * Factory pattern ile taşlar burada üretiliyor.
 */
public class FactoryCreateTas {

    public static AbstractTas getTas(String tas, int x, int y, int color){
        AbstractTas t = null;

        if(tas.equalsIgnoreCase("s")){
            t= TasBuilder.build(Sah.class)
                    .with(v->v.setTasAdi("S"))
                    .with(v->v.setTamTasAdi("Şah"))
                    .with(v->v.setPoint(Utils.Points.SAH_POINT))
                    .with(v->v.setColor(color))
                    .with(v->v.setX(x))
                    .with(v->v.setY(y))
                    .get();
        }else if(tas.equalsIgnoreCase("p")){
            t= TasBuilder.build(Piyon.class)
                    .with(v->v.setTasAdi("P"))
                    .with(v->v.setTamTasAdi("Piyon"))
                    .with(v->v.setPoint(Utils.Points.PIYON_POINT))
                    .with(v->v.setColor(color))
                    .with(v->v.setX(x))
                    .with(v->v.setY(y))
                    .get();
        }else if(tas.equalsIgnoreCase("a")){
            t= TasBuilder.build(At.class)
                    .with(v->v.setTasAdi("A"))
                    .with(v->v.setTamTasAdi("At"))
                    .with(v->v.setPoint(Utils.Points.AT_POINT))
                    .with(v->v.setColor(color))
                    .with(v->v.setX(x))
                    .with(v->v.setY(y))
                    .get();
        }else if(tas.equalsIgnoreCase("f")){
            t= TasBuilder.build(Fil.class)
                    .with(v->v.setTasAdi("F"))
                    .with(v->v.setTamTasAdi("Fil"))
                    .with(v->v.setPoint(Utils.Points.FIL_POINT))
                    .with(v->v.setColor(color))
                    .with(v->v.setX(x))
                    .with(v->v.setY(y))
                    .get();
        }else if(tas.equalsIgnoreCase("k")){
            t= TasBuilder.build(Kale.class)
                    .with(v->v.setTasAdi("K"))
                    .with(v->v.setTamTasAdi("Kale"))
                    .with(v->v.setPoint(Utils.Points.KALE_POINT))
                    .with(v->v.setColor(color))
                    .with(v->v.setX(x))
                    .with(v->v.setY(y))
                    .get();
        }else if(tas.equalsIgnoreCase("v")){
           t= TasBuilder.build(Vezir.class)
                   .with(v->v.setTasAdi("V"))
                   .with(v->v.setTamTasAdi("Vezir"))
                   .with(v->v.setPoint(Utils.Points.VEZIR_POINT))
                   .with(v->v.setColor(color))
                   .with(v->v.setX(x))
                   .with(v->v.setY(y))
                   .get();
       }
        return t;
    }


}
