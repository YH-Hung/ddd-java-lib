package org.hle.spec.single;

@FunctionalInterface
public interface Specification<T> {

    static <T> Specification<T> allOf(Iterable<Specification<T>> specifications) {
        Specification<T> identity = t -> true;
        for (Specification<T> specification : specifications) {
            identity = identity.and(specification);
        }

        return identity;
    }

    static <T> Specification<T> anyOf(Iterable<Specification<T>> specifications) {
        Specification<T> identity = t -> false;
        for (Specification<T> specification : specifications) {
            identity = identity.or(specification);
        }

        return identity;
    }

    boolean isSatisfiedBy(T t);

    default Specification<T> and(Specification<T> specification) {
        return new AndSpecification<>(this, specification);
    }

    default Specification<T> or(Specification<T> specification) {
        return new OrSpecification<>(this, specification);
    }

    default Specification<T> not() {
        return new NotSpecification<>(this);
    }
}
