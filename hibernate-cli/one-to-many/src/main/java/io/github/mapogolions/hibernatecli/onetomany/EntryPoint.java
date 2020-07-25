package io.github.mapogolions.hibernatecli.onetomany;

import static io.github.mapogolions.hibernatecli.jpacore.JpaCore.*;

public class EntryPoint {
    public static void main(String[] args) {
        db(atomicBlock(em -> {})).accept("hibernate-cli.one-to-many");
    }
}
