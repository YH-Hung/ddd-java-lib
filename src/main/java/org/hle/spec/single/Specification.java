package org.hle.spec.single;

import java.util.Arrays;
import java.util.stream.StreamSupport;

@FunctionalInterface
public interface Specification<T> {

    static <T> Specification<T> allOf(Iterable<Specification<T>> specifications) {
        return StreamSupport.stream(specifications.spliterator(), false)
                .reduce(new AndIdentitySpecification<>(), Specification::and);
    }

    @SafeVarargs
    static <T> Specification<T> allOf(Specification<T>... specifications) {
        return allOf(Arrays.asList(specifications));
    }

    static <T> Specification<T> anyOf(Iterable<Specification<T>> specifications) {
        return StreamSupport.stream(specifications.spliterator(), false)
                .reduce(new OrIdentitySpecification<>(), Specification::or);
    }

    @SafeVarargs
    static <T> Specification<T> anyOf(Specification<T>... specifications) {
        return anyOf(Arrays.asList(specifications));
    }

    static <T> Specification<T> not(Specification<T> specification) {
        return new NotSpecification<>(specification);
    }

    boolean isSatisfiedBy(T t);

    default Specification<T> and(Specification<T> specification) {
        return new AndSpecification<>(this, specification);
    }

    default Specification<T> or(Specification<T> specification) {
        return new OrSpecification<>(this, specification);
    }

}
