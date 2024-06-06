package org.hle.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WifeRuleAttribute {
    private String attributeName;
    private String attributeValue;
    private String otherField;
}
