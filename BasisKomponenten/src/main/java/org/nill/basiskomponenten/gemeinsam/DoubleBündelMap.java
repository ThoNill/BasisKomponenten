package org.nill.basiskomponenten.gemeinsam;

import org.nill.basiskomponenten.mathe.bündel.GruppenBündelMap;
import org.nill.basiskomponenten.mathe.gruppen.DoubleAdditiv;

public class DoubleBündelMap<KEY> extends GruppenBündelMap<KEY, Double> {

    public DoubleBündelMap() {
        super(DoubleAdditiv.GRUPPE);
    }

    @Override
    public String toString() {
        return "Werte [entrySet=" + entrySet() + "]";
    }

}
