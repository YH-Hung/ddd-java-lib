package org.hle.spec.match;

import org.hle.spec.single.Specification;

import java.util.Arrays;
import java.util.stream.StreamSupport;

public interface MatchSpecification<T, U> {

    static <T, U> MatchSpecification<T, U> allOf(Iterable<MatchSpecification<T, U>> matchSpecifications) {
        return StreamSupport.stream(matchSpecifications.spliterator(), false)
                .reduce(new AndIdentityMatchSpecification<>(), MatchSpecification::and);
    }

    @SafeVarargs
    static <T, U> MatchSpecification<T, U> allOf(MatchSpecification<T, U>... matchSpecifications) {
        return allOf(Arrays.asList(matchSpecifications));
    }

    static <T, U> MatchSpecification<T, U> anyOf(Iterable<MatchSpecification<T, U>> matchSpecifications) {
        return StreamSupport.stream(matchSpecifications.spliterator(), false)
                .reduce(new OrIdentityMatchSpecification<>(), MatchSpecification::or);
    }

    @SafeVarargs
    static <T, U> MatchSpecification<T, U> anyOf(MatchSpecification<T, U>... matchSpecifications) {
        return anyOf(Arrays.asList(matchSpecifications));
    }

    static <T, U> MatchSpecification<T, U> not(MatchSpecification<T, U> matchSpecification) {
        return new NotMatchSpecification<>(matchSpecification);
    }

    boolean match(T t, U u);

    default MatchSpecification<T, U> and(MatchSpecification<T, U> other) {
        return new AndMatchSpecification<>(this, other);
    }

    default MatchSpecification<T, U> or(MatchSpecification<T, U> other) {
        return new OrMatchSpecification<>(this, other);
    }

    default Specification<U> applyLeft(T t) {
        return u -> match(t, u);
    }

    default Specification<T> applyRight(U u) {
        return t -> match(t, u);
    }
}
