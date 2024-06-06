package org.hle.spec.single;

public class NotSpecification <T> implements Specification<T> {

    private final Specification<T> specification;

    public NotSpecification(Specification<T> specification) {
        this.specification = specification;
    }


    @Override
    public boolean isSatisfiedBy(T t) {
        return !specification.isSatisfiedBy(t);
    }
}
