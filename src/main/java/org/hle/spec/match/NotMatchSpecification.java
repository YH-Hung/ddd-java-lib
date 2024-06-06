package org.hle.spec.match;

public class NotMatchSpecification<T, U> implements MatchSpecification<T, U> {
    private final MatchSpecification<T, U> matchSpecification;

    public NotMatchSpecification(MatchSpecification<T, U> matchSpecification) {
        this.matchSpecification = matchSpecification;
    }

    @Override
    public boolean match(T t, U u) {
        return !matchSpecification.match(t, u);
    }
}
