package io.github.mapogolions.hibernatecli.onetoone.bidirectional;

import static io.github.mapogolions.hibernatecli.jpacore.JpaCore.*;

public class EntryPoint {
    public static void main(String[] args) {
        persistenceUnit("hibernate-cli.one-to-one.bidirectional").accept(
                db(atomicBlock(em -> {}))
        );
    }
}
