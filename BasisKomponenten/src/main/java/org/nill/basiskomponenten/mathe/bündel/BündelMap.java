package org.nill.basiskomponenten.mathe.b�ndel;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class B�ndelMap<KEY, VALUE> extends HashMap<KEY, VALUE> implements
        B�ndel<KEY, VALUE> {
    
    private B�ndelFabrik<B�ndel<KEY, VALUE>,KEY,VALUE> fabrik;
    
    public B�ndelMap() {
        this(new B�ndelMapFabrik<>());
    }
    
    public B�ndelMap(B�ndelFabrik<B�ndel<KEY, VALUE>,KEY,VALUE> fabrik) {
        super();
        this.fabrik = fabrik;
    }


    public B�ndelMap(int initialCapacity) {
        super(initialCapacity);
        this.fabrik = new B�ndelMapFabrik<>();
    }

    public B�ndelMap(B�ndel<KEY, VALUE> b�ndel) {
        this(b�ndel.getFabrik());
        Objects.requireNonNull(b�ndel);

        for (KEY k : b�ndel.getKeys()) {
            put(k, b�ndel.getValue(k));
        }
    }

    public B�ndelMap(int initialCapacity, float loadFactor) {
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
    public B�ndelFabrik<B�ndel<KEY, VALUE>,KEY, VALUE> getFabrik() {
        return fabrik;
    }

    public void setFabrik(B�ndelFabrik<B�ndel<KEY, VALUE>, KEY, VALUE> fabrik) {
        this.fabrik = fabrik;
    }

}