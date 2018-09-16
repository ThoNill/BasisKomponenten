package org.nill.basiskomponenten.ddd;

import org.nill.basiskomponenten.predicates.StaticPredicate;

public class FabricSpecification implements StaticPredicate<Entity> {

    public static boolean staticTest(Object e) {
        return !(e instanceof Value || e instanceof Entity || e instanceof Repository);
    }
}
