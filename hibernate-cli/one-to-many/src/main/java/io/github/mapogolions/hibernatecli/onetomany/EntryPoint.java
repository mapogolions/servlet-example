package io.github.mapogolions.hibernatecli.onetomany;

import static io.github.mapogolions.hibernatecli.jpacore.JpaCore.*;

public class EntryPoint {
    public static void main(String[] args) {
        persistenceUnit("hibernate-cli.one-to-many").accept(
                db(atomicBlock(em -> {}))
        );
    }
}
