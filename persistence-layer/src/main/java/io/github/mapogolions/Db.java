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

    public EntityManagerFactory factory() {
        return factory;
    }

    public static void session(Unit ...units) {
        session(context(units));
    }

    public static void session(PersistentContext ...ctxs) {
        try (var db = new Db("io.github.mapogolions")) {
            Arrays.asList(ctxs).forEach(ctx -> ctx.apply(db.factory()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PersistentContext context(Unit ...units) {
        return new PersistentContext(units);
    }

    public static Unit unit(Consumer<EntityManager> ...fs) {
        return new Unit(fs);
    }

    @Override
    public void close() throws IOException {
        factory.close();
    }

    public static class PersistentContext {
        private final Unit[] units;

        PersistentContext(Unit...transactions) {
            this.units = transactions;
        }

        public void apply(EntityManagerFactory factory) {
            var entityManager = factory.createEntityManager();
            try {
                Arrays.asList(units).forEach(unit -> unit.apply(entityManager));
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                entityManager.close();
            }
        }
    }

    public static class Unit {
        private final Consumer<EntityManager>[] fs;

        Unit(Consumer<EntityManager> ...fs) {
            this.fs = fs;
        }

        public void apply(EntityManager entityManager) {
            var transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                Arrays.asList(fs).forEach(fn -> fn.accept(entityManager));
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

}
