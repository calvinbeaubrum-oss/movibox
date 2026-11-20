package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class CacheLoader<K, V> {

    /* JADX INFO: compiled from: source.java */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
    }

    public abstract V a(K k11) throws Exception;

    public abstract i0<V> b(K k11, V v11) throws Exception;
}
