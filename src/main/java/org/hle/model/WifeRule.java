package org.hle.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class WifeRule {
    private int age;
    private String food;

    @Singular
    private List<WifeRuleAttribute> attributes;
}
