package org.nill.basiskomponenten.gemeinsam;

import javax.money.MonetaryAmount;

import org.nill.basiskomponenten.betrag.Geld;
import org.nill.basiskomponenten.mathe.bündel.Bündel;
import org.nill.basiskomponenten.mathe.bündel.GruppenBündelMap;

public class BetragsBündelMap<KEY> extends
        GruppenBündelMap<KEY, MonetaryAmount> implements BetragsBündel<KEY> {

    public BetragsBündelMap(Bündel<KEY, MonetaryAmount> map) {
        super(Geld.getGruppe(), map);
    }

    public BetragsBündelMap() {
        super(Geld.getGruppe());
    }

    @Override
    public String toString() {
        return "Werte [entrySet=" + entrySet() + "]";
    }

    public BetragsBündelMap<KEY> copy() {
        return (BetragsBündelMap<KEY>) transformElements((MonetaryAmount x) -> x,getFabrik());
    }

    @Override
    public BetragsBündelMap<KEY> unit() {
        return new BetragsBündelMap<KEY>();
    }
}
