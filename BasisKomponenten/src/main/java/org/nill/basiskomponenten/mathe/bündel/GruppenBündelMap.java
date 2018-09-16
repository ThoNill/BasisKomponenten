package org.nill.basiskomponenten.mathe.b�ndel;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;

import org.nill.basiskomponenten.mathe.gruppen.Gruppe;

public class GruppenB�ndelMap<KEY, ELEMENT> extends B�ndelMap<KEY, ELEMENT>
        implements GruppenB�ndel<KEY, ELEMENT> {

    public GruppenB�ndelMap(Gruppe<ELEMENT> gruppe, B�ndel<KEY, ELEMENT> map) {
        super(map);
        this.gruppe = gruppe;
    }

    private Gruppe<ELEMENT> gruppe;

    public GruppenB�ndelMap(Gruppe<ELEMENT> gruppe) {
        super();
        this.gruppe = gruppe;
    }

    @Override
    public GruppenB�ndelMap<KEY, ELEMENT> unit() {
        return new GruppenB�ndelMap<>(gruppe);
    }

    @Override
    public boolean isElement(GruppenB�ndel<KEY, ELEMENT> b) {
        return true;
    }

    @Override
    public boolean isUnit(GruppenB�ndel<KEY, ELEMENT> b) {
        Set<KEY> alle = b.getKeys();
        for (KEY k : alle) {
            if (!gruppe.isUnit(null2unit(getValue(k)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ELEMENT getSumme(Iterable<KEY> keys) {
        ELEMENT summe = gruppe.unit();
        for (KEY key : keys) {
            ELEMENT v = getBetrag(key);
            summe = gruppe.add(summe, v);
        }
        return summe;
    }

    @Override
    public ELEMENT getSumme(KEY... positionen) {
        return getSumme(Arrays.asList(positionen));
    };

    @Override
    public ELEMENT getSumme() {
        return getSumme(getKeys());
    }

    @Override
    public ELEMENT getValue(KEY position) {
        return this.get(position);
    }

    public <TO_KEY> GruppenB�ndelMap<TO_KEY, ELEMENT> transformiereUndSummiereKeys(
            Function<KEY, TO_KEY> transformation) {
        return transformiereUndSummiereKeys(gruppe, transformation);
    }

    public <K> void summiere(GruppenB�ndelMap<K, ELEMENT> b�ndel, K key,
            ELEMENT a) {
        summiere(gruppe, b�ndel, key, a);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 3;
        for (KEY k : getKeys()) {
            ELEMENT b = getBetrag(k);
            if (!gruppe.isUnit(b)) {
                result += getBetrag(k).hashCode();
            }
        }
        result = prime * result;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        // if (!super.equals(obj))
        // return false;
        if (!(obj instanceof GruppenB�ndelMap))
            return false;
        GruppenB�ndelMap other = (GruppenB�ndelMap) obj;
        if (gruppe == null) {
            if (other.gruppe != null)
                return false;
        }
        GruppenB�ndelMap<KEY, ELEMENT> b�ndel = (GruppenB�ndelMap<KEY, ELEMENT>) obj;
        Set<KEY> keys = alleKeys(this, b�ndel);
        for (KEY k : keys) {
            if (!getBetrag(k).equals(b�ndel.getBetrag(k))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Gruppe<ELEMENT> getGruppe() {
        return gruppe;
    }

}
