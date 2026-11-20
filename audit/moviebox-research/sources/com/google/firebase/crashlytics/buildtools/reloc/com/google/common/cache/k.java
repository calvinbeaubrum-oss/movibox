package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface k<K, V> {
    long getAccessTime();

    int getHash();

    K getKey();

    k<K, V> getNext();

    k<K, V> getNextInAccessQueue();

    k<K, V> getNextInWriteQueue();

    k<K, V> getPreviousInAccessQueue();

    k<K, V> getPreviousInWriteQueue();

    LocalCache.s<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long j11);

    void setNextInAccessQueue(k<K, V> kVar);

    void setNextInWriteQueue(k<K, V> kVar);

    void setPreviousInAccessQueue(k<K, V> kVar);

    void setPreviousInWriteQueue(k<K, V> kVar);

    void setValueReference(LocalCache.s<K, V> sVar);

    void setWriteTime(long j11);
}
