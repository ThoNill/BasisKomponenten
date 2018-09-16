package org.nill.basiskomponenten.gemeinsam;

import org.nill.basiskomponenten.mathe.b�ndel.B�ndelMap;
import org.nill.basiskomponenten.mathe.b�ndel.GruppenB�ndelMap;
import org.nill.basiskomponenten.mathe.gruppen.IntegerAdditiv;

public class AnzahlB�ndelMap<KEY> extends GruppenB�ndelMap<KEY, Integer>
        implements AnzahlB�ndel<KEY> {

    public AnzahlB�ndelMap(B�ndelMap<KEY, Integer> map) {
        super(IntegerAdditiv.GRUPPE, map);
    }

    public AnzahlB�ndelMap() {
        super(IntegerAdditiv.GRUPPE);
    }

    @Override
    public String toString() {
        return "Werte [entrySet=" + entrySet() + "]";
    }

}
