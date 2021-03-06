package tests;

import org.nill.basiskomponenten.gemeinsam.DoubleBŁndelMap;
import org.nill.basiskomponenten.mathe.bŁndel.BŁndel;
import org.nill.basiskomponenten.mathe.bŁndel.BŁndelFabrik;

public class DoubleBŁndelFabrik implements
        BŁndelFabrik<BŁndel<String,Double>, String, Double> {
    
    DoubleBŁndelMap<String> create(String prefix, double... werte) {
        DoubleBŁndelMap<String> bŁndel = new DoubleBŁndelMap<>();
        bŁndel.setFabrik(this);
        int count = 1;
        for (double wert : werte) {
            String key = prefix + Integer.toString(count);
            bŁndel.put(key, wert);
            count++;
        }
        return bŁndel;
    }

    @Override
    public DoubleBŁndelMap<String> create() {
        DoubleBŁndelMap<String> bŁndel = new DoubleBŁndelMap<>();
        bŁndel.setFabrik(this);
        return bŁndel;
    }

}
