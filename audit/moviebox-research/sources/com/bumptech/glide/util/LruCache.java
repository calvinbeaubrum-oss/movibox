package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class LruCache<T, Y> {
    private final Map<T, Entry<Y>> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    /* JADX INFO: compiled from: source.java */
    public static final class Entry<Y> {
        final int size;
        final Y value;

        public Entry(Y y11, int i11) {
            this.value = y11;
            this.size = i11;
        }
    }

    public LruCache(long j11) {
        this.initialMaxSize = j11;
        this.maxSize = j11;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    public synchronized boolean contains(@NonNull T t11) {
        return this.cache.containsKey(t11);
    }

    @Nullable
    public synchronized Y get(@NonNull T t11) {
        Entry<Y> entry;
        entry = this.cache.get(t11);
        return entry != null ? entry.value : null;
    }

    public synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public int getSize(@Nullable Y y11) {
        return 1;
    }

    public void onItemEvicted(@NonNull T t11, @Nullable Y y11) {
    }

    @Nullable
    public synchronized Y put(@NonNull T t11, @Nullable Y y11) {
        int size = getSize(y11);
        long j11 = size;
        if (j11 >= this.maxSize) {
            onItemEvicted(t11, y11);
            return null;
        }
        if (y11 != null) {
            this.currentSize += j11;
        }
        Entry<Y> entryPut = this.cache.put(t11, y11 == null ? null : new Entry<>(y11, size));
        if (entryPut != null) {
            this.currentSize -= (long) entryPut.size;
            if (!entryPut.value.equals(y11)) {
                onItemEvicted(t11, entryPut.value);
            }
        }
        evict();
        return entryPut != null ? entryPut.value : null;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t11) {
        Entry<Y> entryRemove = this.cache.remove(t11);
        if (entryRemove == null) {
            return null;
        }
        this.currentSize -= (long) entryRemove.size;
        return entryRemove.value;
    }

    public synchronized void setSizeMultiplier(float f11) {
        try {
            if (f11 < 0.0f) {
                throw new IllegalArgumentException("Multiplier must be >= 0");
            }
            this.maxSize = Math.round(this.initialMaxSize * f11);
            evict();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void trimToSize(long j11) {
        while (this.currentSize > j11) {
            Iterator<Map.Entry<T, Entry<Y>>> it = this.cache.entrySet().iterator();
            Map.Entry<T, Entry<Y>> next = it.next();
            Entry<Y> value = next.getValue();
            this.currentSize -= (long) value.size;
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value.value);
        }
    }
}
