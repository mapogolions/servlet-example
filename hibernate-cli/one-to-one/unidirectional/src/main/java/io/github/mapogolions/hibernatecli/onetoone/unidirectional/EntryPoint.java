package io.github.mapogolions.hibernatecli.onetoone.unidirectional;

import static io.github.mapogolions.hibernatecli.jpacore.JpaCore.*;

public class EntryPoint {
    public static void main(String[] args) {
        persistenceUnit("hibernate-cli.one-to-one.unidirectional").accept(
                db(atomicBlock(em -> {}))
        );
    }
}
