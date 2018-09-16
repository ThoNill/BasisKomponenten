package org.nill.basiskomponenten.gemeinsam;

import org.nill.basiskomponenten.mathe.bündel.BündelMap;
import org.nill.basiskomponenten.mathe.bündel.GruppenBündelMap;
import org.nill.basiskomponenten.mathe.gruppen.IntegerAdditiv;

public class AnzahlBündelMap<KEY> extends GruppenBündelMap<KEY, Integer>
        implements AnzahlBündel<KEY> {

    public AnzahlBündelMap(BündelMap<KEY, Integer> map) {
        super(IntegerAdditiv.GRUPPE, map);
    }

    public AnzahlBündelMap() {
        super(IntegerAdditiv.GRUPPE);
    }

    @Override
    public String toString() {
        return "Werte [entrySet=" + entrySet() + "]";
    }

}
