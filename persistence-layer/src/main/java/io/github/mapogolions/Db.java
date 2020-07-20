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

    public static void db(AtomicBlock ...blocks) {
        db(session(blocks));
    }

    public static void db(UnitOfWork ...units) {
        try (var db = new Db("io.github.mapogolions")) {
            Arrays.asList(units).forEach(ctx -> ctx.apply(db.entityManagerFactory()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UnitOfWork session(AtomicBlock ...blocks) {
        return new UnitOfWork(blocks);
    }

    public static AtomicBlock atomicBlock(Consumer<EntityManager> ...fs) {
        return new AtomicBlock(fs);
    }

    @Override
    public void close() throws IOException {
        emf.close();
    }

    public static class UnitOfWork {
        private final AtomicBlock[] blocks;

        UnitOfWork(AtomicBlock ...blocks) {
            this.blocks = blocks;
        }

        public void apply(EntityManagerFactory emf) {
            var em = emf.createEntityManager();
            try {
                Arrays.asList(blocks).forEach(block -> block.apply(em));
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                em.close();
            }
        }
    }

    public static class AtomicBlock {
        private final Consumer<EntityManager>[] fs;

        AtomicBlock(Consumer<EntityManager> ... fs) {
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
