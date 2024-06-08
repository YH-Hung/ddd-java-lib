package org.hle.spec.single;

public class OrIdentitySpecification<T> implements Specification<T> {
    @Override
    public boolean isSatisfiedBy(T t) {
        return false;
    }
}
