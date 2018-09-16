package tests;

import org.nill.basiskomponenten.gemeinsam.DoubleBündelMap;
import org.nill.basiskomponenten.mathe.bündel.Bündel;
import org.nill.basiskomponenten.mathe.bündel.BündelFabrik;

public class DoubleBündelFabrik implements
        BündelFabrik<Bündel<String,Double>, String, Double> {
    
    DoubleBündelMap<String> create(String prefix, double... werte) {
        DoubleBündelMap<String> bündel = new DoubleBündelMap<>();
        bündel.setFabrik(this);
        int count = 1;
        for (double wert : werte) {
            String key = prefix + Integer.toString(count);
            bündel.put(key, wert);
            count++;
        }
        return bündel;
    }

    @Override
    public DoubleBündelMap<String> create() {
        DoubleBündelMap<String> bündel = new DoubleBündelMap<>();
        bündel.setFabrik(this);
        return bündel;
    }

}
