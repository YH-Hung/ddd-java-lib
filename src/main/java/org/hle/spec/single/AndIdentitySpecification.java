package org.hle.spec.single;

public class AndIdentitySpecification<T> implements Specification<T> {
    @Override
    public boolean isSatisfiedBy(T t) {
        return true;
    }
}
