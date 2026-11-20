package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache;

import java.util.AbstractMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    private RemovalNotification(K k11, V v11, RemovalCause removalCause) {
        super(k11, v11);
        this.cause = (RemovalCause) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> create(K k11, V v11, RemovalCause removalCause) {
        return new RemovalNotification<>(k11, v11, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
