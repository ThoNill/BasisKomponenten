package org.nill.basiskomponenten.gemeinsam;

import java.util.Arrays;
import java.util.Objects;

import javax.money.MonetaryAmount;

import org.nill.basiskomponenten.betrag.Geld;
import org.nill.basiskomponenten.mathe.b�ndel.B�ndel;

public interface ProzentB�ndel<KEY> extends B�ndel<KEY, Double> {

    default double getBetrag(KEY position) {
        Objects.requireNonNull(position);

        Double d = getValue(position);
        if (d != null) {
            return d.doubleValue();
        }
        return 0.0;
    }

    default double getSumme(Iterable<KEY> keys) {
        Objects.requireNonNull(keys);
        double summe = 0.0d;
        for (KEY key : keys) {
            summe = summe + getBetrag(key);
        }
        return summe;
    }

    default double getSumme(KEY... positionen) {
        Objects.requireNonNull(positionen);
        return getSumme(Arrays.asList(positionen));
    };

    default double getSumme() {
        return getSumme(getKeys());
    };

    default BetragsB�ndel<KEY> verteilen(MonetaryAmount betrag) {
        Objects.requireNonNull(betrag);

        BetragsB�ndelMap<KEY> ergebnis = new BetragsB�ndelMap<>();
        double summe = getSumme();
        if (summe <= 0) {
            throw new IllegalArgumentException("Die Summe sollte > 0 sein");
        }
        KEY maxKey = null;
        MonetaryAmount maxAmount = Geld.getNull();
        for (KEY k : getKeys()) {
            MonetaryAmount value = Geld.percentAmount(betrag, getBetrag(k)
                    / summe);
            ergebnis.put(k, value);
            if (value.isGreaterThan(maxAmount)) {
                maxKey = k;
            }
        }
        korrigiereSummeAufDenBetrag(betrag, ergebnis, maxKey);
        return ergebnis;
    }

    default void korrigiereSummeAufDenBetrag(MonetaryAmount betrag,
            BetragsB�ndelMap<KEY> ergebnis, KEY maxKey) {
        Objects.requireNonNull(betrag);
        Objects.requireNonNull(ergebnis);
        Objects.requireNonNull(maxKey);

        MonetaryAmount korrektur = berechneKorrektur(betrag, ergebnis);
        if (!korrektur.isZero()) {
            korrigiereErgebnis(ergebnis, maxKey, korrektur);
        }

    }

    default void korrigiereErgebnis(BetragsB�ndelMap<KEY> ergebnis,
            KEY position, MonetaryAmount korrektur) {
        Objects.requireNonNull(ergebnis);
        Objects.requireNonNull(position);
        Objects.requireNonNull(korrektur);

        MonetaryAmount betrag = ergebnis.getBetrag(position);
        ergebnis.put(position, betrag.add(korrektur));
    }

    default MonetaryAmount berechneKorrektur(MonetaryAmount betrag,
            BetragsB�ndelMap<KEY> ergebnis) {
        Objects.requireNonNull(betrag);
        Objects.requireNonNull(ergebnis);

        return betrag.subtract(ergebnis.getSumme());
    }

}
