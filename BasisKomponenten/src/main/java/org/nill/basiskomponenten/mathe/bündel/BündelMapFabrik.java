package org.nill.basiskomponenten.mathe.b�ndel;

public class B�ndelMapFabrik<KEY, ELEMENT> implements B�ndelFabrik<B�ndel<KEY, ELEMENT>,KEY, ELEMENT> {
    public B�ndel<KEY, ELEMENT> create() {
        return new B�ndelMap<>();
    };
}
