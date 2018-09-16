package org.nill.basiskomponenten.gemeinsam;

import javax.money.MonetaryAmount;

import org.nill.basiskomponenten.mathe.b�ndel.B�ndel;
import org.nill.basiskomponenten.mathe.b�ndel.GruppenB�ndel;

public interface BetragsB�ndel<KEY> extends GruppenB�ndel<KEY, MonetaryAmount> {

    @Override
    default BetragsB�ndelMap<KEY> erweitern(B�ndel<KEY, MonetaryAmount> b�ndel) {
        return erweitern(new BetragsB�ndelMap<>(), b�ndel);
    }

    @Override
    default GruppenB�ndel<KEY, MonetaryAmount> unit() {
        return new BetragsB�ndelMap<KEY>();
    }
}
