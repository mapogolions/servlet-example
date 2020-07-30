package io.github.mapogolions.hibernatecli.onetoone.mappedby;

import static io.github.mapogolions.hibernatecli.jpacore.JpaCore.*;

public class EntryPoint {
    public static void main(String[] args) {
        persistenceUnit("hibernate-cli.one-to-one.mapped-by").accept(
                db(atomicBlock(em -> {}))
        );
    }
}
