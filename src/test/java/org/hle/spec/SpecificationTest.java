package org.hle.spec;

import org.hle.model.Girl;
import org.hle.model.GirlAttribute;
import org.hle.spec.single.Specification;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SpecificationTest {

    @Test
    void allOf() {
        var wan = new Girl("wan", 36, 169, List.of(GirlAttribute.builder().attributeName("food").attributeValue("sushi").build()));
        Specification<Girl> ageSpec = (Girl g) -> g.age() < 40;
        Specification<Girl> foodSpec = (Girl g) -> g.characteristic().stream().anyMatch(a -> a.getAttributeName().equals("food") && a.getAttributeValue().equals("sushi"));

        assertThat(Specification.allOf(List.of(ageSpec, foodSpec)).isSatisfiedBy(wan)).isTrue();
    }

//    @Test
    void anyOf() {
    }

    @Test
    void isSatisfiedBy_true() {
        var wan = new Girl("wan", 36, 169, Collections.emptyList());
        Specification<Girl> ageSpec = (Girl g) -> g.height() > 165;
        assertThat(ageSpec.isSatisfiedBy(wan)).isTrue();
    }

    @Test
    void isSatisfiedBy_false() {
        var wan = new Girl("wan", 36, 169, Collections.emptyList());
        Specification<Girl> ageSpec = (Girl g) -> g.age() < 35;
        assertThat(ageSpec.isSatisfiedBy(wan)).isFalse();
    }

    @Test
    void and_true() {
        var wan = new Girl("wan", 36, 169, Collections.emptyList());
        Specification<Girl> ageSpec = (Girl g) -> g.age() < 40;
        Specification<Girl> nameSpec = (Girl g) -> g.name().equals("wan");
        assertThat(ageSpec.and(nameSpec).isSatisfiedBy(wan)).isTrue();
    }

    @Test
    void and_false() {
        var wan = new Girl("wan", 36, 169, Collections.emptyList());
        Specification<Girl> ageSpec = (Girl g) -> g.age() < 30;
        Specification<Girl> nameSpec = (Girl g) -> g.name().equals("wan");
        assertThat(ageSpec.and(nameSpec).isSatisfiedBy(wan)).isFalse();
    }

//    @Test
    void or() {
    }

//    @Test
    void not() {
    }
}