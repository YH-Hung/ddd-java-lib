package org.hle.spec.match;

public class OrMatchSpecification<T, U> implements MatchSpecification<T, U> {
    private final MatchSpecification<T, U> left;
    private final MatchSpecification<T, U> right;

    public OrMatchSpecification(MatchSpecification<T, U> left, MatchSpecification<T, U> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean match(T t, U u) {
        return left.match(t, u) || right.match(t, u);
    }
}
