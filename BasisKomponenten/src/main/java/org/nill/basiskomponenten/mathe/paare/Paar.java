package org.nill.basiskomponenten.mathe.paare;

import java.util.Objects;

import lombok.NonNull;
import lombok.Value;

@Value
public class Paar<L, R> {
    private R r;
    private L l;
}
