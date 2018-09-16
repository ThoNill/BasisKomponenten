package org.nill.basiskomponenten.mathe.bündel;

public class BündelMapFabrik<KEY, ELEMENT> implements BündelFabrik<Bündel<KEY, ELEMENT>,KEY, ELEMENT> {
    public Bündel<KEY, ELEMENT> create() {
        return new BündelMap<>();
    };
}
