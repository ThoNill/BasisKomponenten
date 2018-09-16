package org.nill.basiskomponenten.gemeinsam;

import java.util.Arrays;
import java.util.Objects;

import javax.money.MonetaryAmount;

public class EinzelBetragAusB�ndel<KEY> implements
        EinzelBetrag<BetragsB�ndel<KEY>> {
    private Iterable<KEY> positionen;

    public EinzelBetragAusB�ndel(Iterable<KEY> positionen) {
        super();
        this.positionen = Objects.requireNonNull(positionen);
    }

    public EinzelBetragAusB�ndel(KEY... positionen) {
        this(Arrays.asList(Objects.requireNonNull(positionen)));
    }

    @Override
    public MonetaryAmount apply(BetragsB�ndel<KEY> b�ndel) {
        return Objects.requireNonNull(b�ndel).getSumme(positionen);
    }

}
