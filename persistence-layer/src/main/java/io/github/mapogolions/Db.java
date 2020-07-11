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

    public void atomic(Consumer<EntityManager> ...chunks) {
        var entityManager = factory.createEntityManager();
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Arrays.stream(chunks).forEach(chunk -> chunk.accept(entityManager));
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            entityManager.close();
            factory.close();
        }
    }

    public static Db unit(String unit) {
        return new Db(unit);
    }

    public static void session(Consumer<EntityManager> ...chunks) {
        try (var db = new Db("hibernate.cli.test.unit")) {
            db.atomic(chunks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        factory.close();
    }
}
