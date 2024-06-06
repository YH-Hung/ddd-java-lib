package org.hle.spec.match;

public interface MatchSpecification<T, U> {

    static <T, U> MatchSpecification<T, U> allOf(MatchSpecification<T, U>... matchSpecifications) {
        MatchSpecification<T, U> identity = (t, v) -> true;
        for (MatchSpecification<T, U> matchSpecification : matchSpecifications) {
            identity = identity.and(matchSpecification);
        }

        return identity;
    }

    boolean match(T t, U u);

    default MatchSpecification<T, U> and(MatchSpecification<T, U> other) {
        return new AndMatchSpecification<>(this, other);
    }

    default MatchSpecification<T, U> or(MatchSpecification<T, U> other) {
        return new OrMatchSpecification<>(this, other);
    }

    default MatchSpecification<T, U> not() {
        return new NotMatchSpecification<>(this);
    }
}
