package org.nill.basiskomponenten.mathe.b�ndel;

public interface B�ndelFabrik<B extends B�ndel<KEY, ELEMENT>,KEY, ELEMENT > {
    B create();
}
