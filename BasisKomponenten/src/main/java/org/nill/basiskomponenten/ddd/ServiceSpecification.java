package org.nill.basiskomponenten.ddd;

import org.nill.basiskomponenten.predicates.StaticPredicate;



public class ServiceSpecification implements StaticPredicate<Service> {

    public static boolean staticTest(Object service) {
        return !(service instanceof Value || service instanceof Entity|| service instanceof Fabric || service instanceof Repository);
    }
}
