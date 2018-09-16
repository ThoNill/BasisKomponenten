package tests;

import org.nill.basiskomponenten.gemeinsam.DoubleB�ndelMap;
import org.nill.basiskomponenten.mathe.b�ndel.B�ndel;
import org.nill.basiskomponenten.mathe.b�ndel.B�ndelFabrik;

public class DoubleB�ndelFabrik implements
        B�ndelFabrik<B�ndel<String,Double>, String, Double> {
    
    DoubleB�ndelMap<String> create(String prefix, double... werte) {
        DoubleB�ndelMap<String> b�ndel = new DoubleB�ndelMap<>();
        b�ndel.setFabrik(this);
        int count = 1;
        for (double wert : werte) {
            String key = prefix + Integer.toString(count);
            b�ndel.put(key, wert);
            count++;
        }
        return b�ndel;
    }

    @Override
    public DoubleB�ndelMap<String> create() {
        DoubleB�ndelMap<String> b�ndel = new DoubleB�ndelMap<>();
        b�ndel.setFabrik(this);
        return b�ndel;
    }

}
