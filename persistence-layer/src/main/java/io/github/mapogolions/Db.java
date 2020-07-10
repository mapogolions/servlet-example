package io.github.mapogolions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

public class Db implements Closeable {
    private final EntityManagerFactory factory;

    public Db(String unit) {
        this.factory = Persistence.createEntityManagerFactory(unit);
    }

    public void transaction(Consumer<EntityManager> ...fs) {
        var entityManager = factory.createEntityManager();
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Arrays.stream(fs).forEach(fn -> fn.accept(entityManager));
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void close() throws IOException {
        factory.close();
    }
}
