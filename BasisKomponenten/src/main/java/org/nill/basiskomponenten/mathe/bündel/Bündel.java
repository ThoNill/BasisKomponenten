package org.nill.basiskomponenten.mathe.b�ndel;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;

import org.nill.basiskomponenten.ddd.Repository;


public interface B�ndel<KEY, ELEMENT> extends Repository {

    Set<KEY> getKeys();
    B�ndelFabrik<B�ndel<KEY,ELEMENT>,KEY, ELEMENT> getFabrik();

    ELEMENT getValue(KEY position);

    ELEMENT put(KEY position, ELEMENT value);

    default Set<KEY> alleKeys(B�ndel<KEY, ELEMENT> a, B�ndel<KEY, ELEMENT> b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);

        Set<KEY> alleKeys = new HashSet(a.getKeys());
        alleKeys.addAll(b.getKeys());
        return alleKeys;
    }

    default B�ndel<KEY, ELEMENT> filterKeys(Predicate<KEY> predicate){
        Objects.requireNonNull(predicate);

        B�ndel<KEY, ELEMENT> b�ndel = getFabrik().create();
        for (KEY k : getKeys()) {
            if (predicate.test(k)) {
                b�ndel.put(k, getValue(k));
            }
        }
        return b�ndel;
    }

    default B�ndel<KEY, ELEMENT> forgetKeys(Predicate<KEY> predicate) {
        Objects.requireNonNull(predicate);

        return filterKeys(predicate.negate());
    }

    default B�ndel<KEY, ELEMENT> filterValues(Predicate<ELEMENT> predicate) {
        Objects.requireNonNull(predicate);

        B�ndel<KEY, ELEMENT> b�ndel = getFabrik().create();
        for (KEY k : getKeys()) {
            ELEMENT e = getValue(k);
            if (predicate.test(e)) {
                b�ndel.put(k, e);
            }
        }
        return b�ndel;
    }

    default <TO_KEY> B�ndel<TO_KEY, ELEMENT> transformKeys(
            Function<KEY, TO_KEY> transformation,
            B�ndelFabrik<B�ndel<TO_KEY, ELEMENT>,TO_KEY, ELEMENT> fabrik) {
        Objects.requireNonNull(transformation);

        B�ndel<TO_KEY, ELEMENT> b�ndel = fabrik.create();
        for (KEY k : getKeys()) {
            b�ndel.put(transformation.apply(k), getValue(k));
        }
        return b�ndel;
    }

    default <TO_ELEMENT> B�ndel<KEY, TO_ELEMENT> transformElements(
            Function<ELEMENT, TO_ELEMENT> transformation,B�ndelFabrik<B�ndel<KEY, TO_ELEMENT>,KEY, TO_ELEMENT> fabrik ) {
        Objects.requireNonNull(transformation);

        B�ndel<KEY, TO_ELEMENT> b�ndel = fabrik.create();
        for (KEY k : getKeys()) {
            b�ndel.put(k, transformation.apply(getValue(k)));
        }
        return b�ndel;
    }

    default <B extends B�ndelMap<KEY, ELEMENT>> B erweitern(B neuesB�ndel,
            B�ndel<KEY, ELEMENT> b�ndel) {
        Objects.requireNonNull(b�ndel);

        for (KEY k : getKeys()) {
            neuesB�ndel.put(k, getValue(k));
        }
        for (KEY k : b�ndel.getKeys()) {
            neuesB�ndel.put(k, b�ndel.getValue(k));
        }

        return neuesB�ndel;
    }

    default B�ndelMap<KEY, ELEMENT> erweitern(B�ndel<KEY, ELEMENT> b�ndel) {
        return erweitern(new B�ndelMap<>(), b�ndel);
    }

    default void log(Logger log) {
        Objects.requireNonNull(log);
        for (KEY k : getKeys()) {
            log.fine("Key " + k + "Value: " + getValue(k));
        }
    }

}