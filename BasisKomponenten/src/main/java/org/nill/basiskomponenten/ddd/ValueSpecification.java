package org.nill.basiskomponenten.ddd;

import org.nill.basiskomponenten.predicates.StaticPredicate;

public class ValueSpecification implements StaticPredicate<Value> {

    public static boolean staticTest(Object e) {
        return !(e instanceof Entity || e instanceof Fabric || e instanceof Repository);
    }
}
