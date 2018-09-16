package org.nill.basiskomponenten.mathe.paare;

import java.util.function.Predicate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Li<R, L> implements Predicate<Paar<R, L>> {
    private L l;

    @Override
    public boolean test(Paar<R, L> t) {
        return l.equals(t.getL());
    }

}
