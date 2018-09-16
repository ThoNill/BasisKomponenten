package org.nill.basiskomponenten.mathe.paare;

import java.util.function.Predicate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Re<R, L> implements Predicate<Paar<R, L>> {
    private R r;

    @Override
    public boolean test(Paar<R, L> t) {
        return r.equals(t.getR());
    }

}
