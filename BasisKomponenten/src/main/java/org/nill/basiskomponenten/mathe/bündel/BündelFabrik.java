package org.nill.basiskomponenten.mathe.bündel;

public interface BündelFabrik<B extends Bündel<KEY, ELEMENT>,KEY, ELEMENT > {
    B create();
}
