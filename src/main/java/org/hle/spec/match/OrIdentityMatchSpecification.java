package org.hle.spec.match;

public class OrIdentityMatchSpecification<T, U> implements MatchSpecification<T, U> {
    @Override
    public boolean match(T t, U u) {
        return false;
    }
}
