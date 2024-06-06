package org.hle.model;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.Objects;

@Getter
@Builder
@Jacksonized
@ToString
public class GirlAttribute {
    private String attributeName;
    private String attributeValue;
    private String otherField;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GirlAttribute that = (GirlAttribute) o;
        return Objects.equals(attributeName, that.attributeName) && Objects.equals(attributeValue, that.attributeValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeName, attributeValue);
    }
}
