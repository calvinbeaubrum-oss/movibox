package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.f;
import androidx.core.util.g;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(@NonNull Object obj) {
        }
    };
    private static final String TAG = "FactoryPools";

    /* JADX INFO: compiled from: source.java */
    public interface Factory<T> {
        T create();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class FactoryPool<T> implements f<T> {
        private final Factory<T> factory;
        private final f<T> pool;
        private final Resetter<T> resetter;

        public FactoryPool(@NonNull f<T> fVar, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
            this.pool = fVar;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // androidx.core.util.f
        public T acquire() {
            T tAcquire = this.pool.acquire();
            if (tAcquire == null) {
                tAcquire = this.factory.create();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    Log.v(FactoryPools.TAG, "Created new " + tAcquire.getClass());
                }
            }
            if (tAcquire instanceof Poolable) {
                ((Poolable) tAcquire).getVerifier().setRecycled(false);
            }
            return tAcquire;
        }

        @Override // androidx.core.util.f
        public boolean release(@NonNull T t11) {
            if (t11 instanceof Poolable) {
                ((Poolable) t11).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t11);
            return this.pool.release(t11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface Poolable {
        @NonNull
        StateVerifier getVerifier();
    }

    /* JADX INFO: compiled from: source.java */
    public interface Resetter<T> {
        void reset(@NonNull T t11);
    }

    private FactoryPools() {
    }

    @NonNull
    private static <T extends Poolable> f<T> build(@NonNull f<T> fVar, @NonNull Factory<T> factory) {
        return build(fVar, factory, emptyResetter());
    }

    @NonNull
    private static <T> f<T> build(@NonNull f<T> fVar, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return new FactoryPool(fVar, factory, resetter);
    }

    @NonNull
    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    @NonNull
    public static <T extends Poolable> f<T> simple(int i11, @NonNull Factory<T> factory) {
        return build(new g(i11), factory);
    }

    @NonNull
    public static <T extends Poolable> f<T> threadSafe(int i11, @NonNull Factory<T> factory) {
        return build(new h(i11), factory);
    }

    @NonNull
    public static <T> f<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    @NonNull
    public static <T> f<List<T>> threadSafeList(int i11) {
        return build(new h(i11), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            @NonNull
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public void reset(@NonNull List<T> list) {
                list.clear();
            }
        });
    }
}
