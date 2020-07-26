package io.github.mapogolions.hibernatecli.manytoone;

import static io.github.mapogolions.hibernatecli.jpacore.JpaCore.*;

public class EntryPoint {
    public static void main(String[] args) {
        persistenceUnit("hibernate-cli.many-to-one").accept(
                db(atomicBlock(em -> {}))
        );
    }
}
