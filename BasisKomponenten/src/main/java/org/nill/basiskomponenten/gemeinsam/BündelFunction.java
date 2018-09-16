package org.nill.basiskomponenten.gemeinsam;

import java.util.function.Function;

import org.nill.basiskomponenten.mathe.bündel.Bündel;

public interface BündelFunction<KEY, ELEMENT> extends
        Function<Bündel<KEY, ELEMENT>, Bündel<KEY, ELEMENT>> {

}
