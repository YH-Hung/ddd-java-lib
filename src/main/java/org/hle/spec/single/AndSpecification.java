package org.hle.spec.single;

public class AndSpecification<T> implements Specification<T> {

    private final Specification<T> left;
    private final Specification<T> right;

    public AndSpecification(Specification<T> left, Specification<T> right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public boolean isSatisfiedBy(T t) {
        return left.isSatisfiedBy(t) && right.isSatisfiedBy(t);
    }
}
