package org.nill.basiskomponenten.mathe.b�ndel;

import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import org.nill.basiskomponenten.mathe.gruppen.Gruppe;

public interface GruppenB�ndel<KEY, ELEMENT> extends B�ndel<KEY, ELEMENT>,
        Gruppe<GruppenB�ndel<KEY, ELEMENT>> {

    @Override
    Set<KEY> getKeys();

    @Override
    ELEMENT getValue(KEY position);

    @Override
    boolean isElement(GruppenB�ndel<KEY, ELEMENT> x);

    @Override
    boolean isUnit(GruppenB�ndel<KEY, ELEMENT> x);

    @Override
    GruppenB�ndel<KEY, ELEMENT> unit();

    @Override
    default GruppenB�ndel<KEY, ELEMENT> negate(GruppenB�ndel<KEY, ELEMENT> x) {
        return Objects.requireNonNull(x).negate();
    };

    ELEMENT getSumme(Iterable<KEY> keys);

    ELEMENT getSumme(KEY... positionen);

    ELEMENT getSumme();

    default <TO_KEY> GruppenB�ndelMap<TO_KEY, ELEMENT> transformiereUndSummiereKeys(
            Gruppe<ELEMENT> g, Function<KEY, TO_KEY> transformation) {
        Objects.requireNonNull(g);
        Objects.requireNonNull(transformation);

        GruppenB�ndelMap<TO_KEY, ELEMENT> b�ndel = new GruppenB�ndelMap<>(g);
        for (KEY k : getKeys()) {
            TO_KEY tk = transformation.apply(k);
            ELEMENT a = this.getValue(k);
            summiere(g, b�ndel, tk, a);
        }
        return b�ndel;
    }

    default <K> void summiere(Gruppe<ELEMENT> g,
            GruppenB�ndelMap<K, ELEMENT> b�ndel, K key, ELEMENT a) {
        Objects.requireNonNull(g);
        Objects.requireNonNull(a);
        Objects.requireNonNull(key);
        Objects.requireNonNull(g);
        Objects.requireNonNull(b�ndel);

        ELEMENT sum = g.add(b�ndel.getValue(key), a);
        b�ndel.put(key, sum);
    }

    public Gruppe<ELEMENT> getGruppe();

    @Override
    public default GruppenB�ndel<KEY, ELEMENT> add(
            GruppenB�ndel<KEY, ELEMENT> a, GruppenB�ndel<KEY, ELEMENT> b) {
        Gruppe<ELEMENT> gruppe = getGruppe();
        GruppenB�ndel<KEY, ELEMENT> ergebnis = unit();
        Set<KEY> alle = alleKeys(this, b);

        for (KEY k : alle) {
            ELEMENT s = gruppe.add(null2unit(a.getValue(k)),
                    null2unit(b.getValue(k)));
            if (!gruppe.isUnit(s)) {
                ergebnis.put(k, s);
            }
        }
        return ergebnis;
    }

    default ELEMENT null2unit(ELEMENT amount) {
        if (amount == null) {
            return getGruppe().unit();
        }
        return amount;
    }

    default ELEMENT getBetrag(KEY position) {
        return null2unit(getValue(position));
    }

    default GruppenB�ndel<KEY, ELEMENT> subtract(GruppenB�ndel<KEY, ELEMENT> a,
            GruppenB�ndel<KEY, ELEMENT> b) {
        Gruppe<ELEMENT> gruppe = getGruppe();
        GruppenB�ndel<KEY, ELEMENT> ergebnis = unit();
        Set<KEY> alle = alleKeys(a, b);

        for (KEY k : alle) {
            ELEMENT s = gruppe.add(null2unit(a.getValue(k)),
                    gruppe.negate(null2unit(b.getValue(k))));
            if (!gruppe.isUnit(s)) {
                ergebnis.put(k, s);
            }
        }
        return ergebnis;
    }

    default GruppenB�ndel<KEY, ELEMENT> negate() {
        Gruppe<ELEMENT> gruppe = getGruppe();
        GruppenB�ndel<KEY, ELEMENT> ergebnis = unit();
        Set<KEY> alle = getKeys();
        for (KEY k : alle) {
            ELEMENT s = gruppe.negate(getBetrag(k));
            if (gruppe.isUnit(s)) {
                ergebnis.put(k, s);
            }
        }
        return ergebnis;
    }

}