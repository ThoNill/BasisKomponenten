package org.nill.basiskomponenten.gemeinsam;

import javax.money.MonetaryAmount;

import org.nill.basiskomponenten.mathe.bündel.Bündel;
import org.nill.basiskomponenten.mathe.bündel.GruppenBündel;

public interface BetragsBündel<KEY> extends GruppenBündel<KEY, MonetaryAmount> {

    @Override
    default BetragsBündelMap<KEY> erweitern(Bündel<KEY, MonetaryAmount> bündel) {
        return erweitern(new BetragsBündelMap<>(), bündel);
    }

    @Override
    default GruppenBündel<KEY, MonetaryAmount> unit() {
        return new BetragsBündelMap<KEY>();
    }
}
