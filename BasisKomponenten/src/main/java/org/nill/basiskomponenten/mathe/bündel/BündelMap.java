package org.nill.basiskomponenten.mathe.bündel;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class BündelMap<KEY, VALUE> extends HashMap<KEY, VALUE> implements
        Bündel<KEY, VALUE> {
    
    private BündelFabrik<Bündel<KEY, VALUE>,KEY,VALUE> fabrik;
    
    public BündelMap() {
        this(new BündelMapFabrik<>());
    }
    
    public BündelMap(BündelFabrik<Bündel<KEY, VALUE>,KEY,VALUE> fabrik) {
        super();
        this.fabrik = fabrik;
    }


    public BündelMap(int initialCapacity) {
        super(initialCapacity);
        this.fabrik = new BündelMapFabrik<>();
    }

    public BündelMap(Bündel<KEY, VALUE> bündel) {
        this(bündel.getFabrik());
        Objects.requireNonNull(bündel);

        for (KEY k : bündel.getKeys()) {
            put(k, bündel.getValue(k));
        }
    }

    public BündelMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public Set<KEY> getKeys() {
        return keySet();
    }

    @Override
    public VALUE getValue(KEY position) {
        return get(Objects.requireNonNull(position));
    }

    @Override
    public BündelFabrik<Bündel<KEY, VALUE>,KEY, VALUE> getFabrik() {
        return fabrik;
    }

    public void setFabrik(BündelFabrik<Bündel<KEY, VALUE>, KEY, VALUE> fabrik) {
        this.fabrik = fabrik;
    }

}