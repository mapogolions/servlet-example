package io.github.mapogolions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

public class Db implements Closeable  {
    private final EntityManagerFactory emf;

    public Db(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }

    public EntityManagerFactory entityManagerFactory() {
        return emf;
    }

    public static void session(Unit ...units) {
        session(context(units));
    }

    public static void session(PersistenceContext...contexts) {
        try (var db = new Db("io.github.mapogolions")) {
            Arrays.asList(contexts).forEach(ctx -> ctx.apply(db.entityManagerFactory()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PersistenceContext context(Unit ...units) {
        return new PersistenceContext(units);
    }

    public static Unit unit(Consumer<EntityManager> ...fs) {
        return new Unit(fs);
    }

    @Override
    public void close() throws IOException {
        emf.close();
    }

    public static class PersistenceContext {
        private final Unit[] units;

        PersistenceContext(Unit...transactions) {
            this.units = transactions;
        }

        public void apply(EntityManagerFactory emf) {
            var em = emf.createEntityManager();
            try {
                Arrays.asList(units).forEach(unit -> unit.apply(em));
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                em.close();
            }
        }
    }

    public static class Unit {
        private final Consumer<EntityManager>[] fs;

        Unit(Consumer<EntityManager> ...fs) {
            this.fs = fs;
        }

        public void apply(EntityManager em) {
            var transaction = em.getTransaction();
            try {
                transaction.begin();
                Arrays.asList(fs).forEach(fn -> fn.accept(em));
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

}
