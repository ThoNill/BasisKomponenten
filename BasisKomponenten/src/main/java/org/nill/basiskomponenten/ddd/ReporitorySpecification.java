package org.nill.basiskomponenten.ddd;

import org.nill.basiskomponenten.predicates.StaticPredicate;

public class ReporitorySpecification implements StaticPredicate<Entity> {

    public static boolean staticTest(Repository repository) {
        return !(repository instanceof Value || repository instanceof Fabric || repository instanceof Entity);
    }
}
