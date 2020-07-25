package io.github.mapogolions.hibernatecli.manytoone;

import static io.github.mapogolions.hibernatecli.jpacore.JpaCore.*;

public class EntryPoint {
    public static void main(String[] args) {
        db(atomicBlock(em -> {})).accept("hibernate-cli.many-to-one");
    }
}
