package org.nill.basiskomponenten.betrag;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GeldKonverter implements
        AttributeConverter<MonetaryAmount, BigDecimal> {

   
    @Override
    public BigDecimal convertToDatabaseColumn(MonetaryAmount betrag) {
        if (betrag == null) {
            return new BigDecimal(0);
        }
        return betrag.getNumber().numberValue(BigDecimal.class);
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(BigDecimal betrag) {
        if (betrag == null) {
            return Geld.createAmount(0);
        }
        return Geld.createAmount(betrag);
    }

}
