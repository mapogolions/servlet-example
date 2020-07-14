package io.github.mapogolions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

public class Db implements Closeable  {
    private final EntityManagerFactory factory;

    public Db(String unit) {
        this.factory = Persistence.createEntityManagerFactory(unit);
    }

    public void runInPersistentContext(Consumer<EntityManager> fn) {
        var entityManager = factory.createEntityManager();
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            fn.accept(entityManager);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void session(Consumer<EntityManager> ...fs) {
        try (var db = new Db("io.github.mapogolions")) {
            Arrays.asList(fs).forEach(fn -> db.runInPersistentContext(fn));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Consumer<EntityManager> context(Consumer<EntityManager> ...fs) {
        return entityManager -> Arrays.asList(fs).forEach(fn -> fn.accept(entityManager));
    }

    @Override
    public void close() throws IOException {
        factory.close();
    }
}
