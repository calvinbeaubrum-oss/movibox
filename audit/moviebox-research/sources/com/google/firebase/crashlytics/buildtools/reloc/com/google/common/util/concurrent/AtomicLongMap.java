package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class AtomicLongMap<K> implements Serializable {
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, Long> map;

    private AtomicLongMap(ConcurrentHashMap<K, Long> concurrentHashMap) {
        this.map = (ConcurrentHashMap) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map) {
        AtomicLongMap<K> atomicLongMapCreate = create();
        atomicLongMapCreate.putAll(map);
        return atomicLongMapCreate;
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(this.map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ long lambda$accumulateAndGet$2(LongBinaryOperator longBinaryOperator, long j11, long j12) {
        return longBinaryOperator.applyAsLong(j12, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ long lambda$getAndAccumulate$3(LongBinaryOperator longBinaryOperator, long j11, long j12) {
        return longBinaryOperator.applyAsLong(j12, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$getAndUpdate$1(AtomicLong atomicLong, LongUnaryOperator longUnaryOperator, Object obj, Long l11) {
        long jLongValue = l11 == null ? 0L : l11.longValue();
        atomicLong.set(jLongValue);
        return Long.valueOf(longUnaryOperator.applyAsLong(jLongValue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ long lambda$put$4(long j11, long j12) {
        return j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$putIfAbsent$6(AtomicBoolean atomicBoolean, long j11, Object obj, Long l11) {
        if (l11 != null && l11.longValue() != 0) {
            return l11;
        }
        atomicBoolean.set(true);
        return Long.valueOf(j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeAllZeros$5(Long l11) {
        return l11.longValue() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$updateAndGet$0(LongUnaryOperator longUnaryOperator, Object obj, Long l11) {
        return Long.valueOf(longUnaryOperator.applyAsLong(l11 == null ? 0L : l11.longValue()));
    }

    public long accumulateAndGet(K k11, final long j11, final LongBinaryOperator longBinaryOperator) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(longBinaryOperator);
        return updateAndGet(k11, new LongUnaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.u
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j12) {
                return AtomicLongMap.lambda$accumulateAndGet$2(longBinaryOperator, j11, j12);
            }
        });
    }

    public long addAndGet(K k11, long j11) {
        return accumulateAndGet(k11, j11, new t());
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<K, Long> mapCreateAsMap = createAsMap();
        this.asMap = mapCreateAsMap;
        return mapCreateAsMap;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public long decrementAndGet(K k11) {
        return addAndGet(k11, -1L);
    }

    public long get(K k11) {
        return ((Long) this.map.getOrDefault(k11, 0L)).longValue();
    }

    public long getAndAccumulate(K k11, final long j11, final LongBinaryOperator longBinaryOperator) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(longBinaryOperator);
        return getAndUpdate(k11, new LongUnaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.x
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j12) {
                return AtomicLongMap.lambda$getAndAccumulate$3(longBinaryOperator, j11, j12);
            }
        });
    }

    public long getAndAdd(K k11, long j11) {
        return getAndAccumulate(k11, j11, new t());
    }

    public long getAndDecrement(K k11) {
        return getAndAdd(k11, -1L);
    }

    public long getAndIncrement(K k11) {
        return getAndAdd(k11, 1L);
    }

    public long getAndUpdate(K k11, final LongUnaryOperator longUnaryOperator) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(longUnaryOperator);
        final AtomicLong atomicLong = new AtomicLong();
        this.map.compute(k11, new BiFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.w
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return AtomicLongMap.lambda$getAndUpdate$1(atomicLong, longUnaryOperator, obj, (Long) obj2);
            }
        });
        return atomicLong.get();
    }

    public long incrementAndGet(K k11) {
        return addAndGet(k11, 1L);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public long put(K k11, final long j11) {
        return getAndUpdate(k11, new LongUnaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.r
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j12) {
                return AtomicLongMap.lambda$put$4(j11, j12);
            }
        });
    }

    public void putAll(Map<? extends K, ? extends Long> map) {
        map.forEach(new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.q
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f40030a.put(obj, ((Long) obj2).longValue());
            }
        });
    }

    public long putIfAbsent(K k11, final long j11) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Long l11 = (Long) this.map.compute(k11, new BiFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.v
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return AtomicLongMap.lambda$putIfAbsent$6(atomicBoolean, j11, obj, (Long) obj2);
            }
        });
        if (atomicBoolean.get()) {
            return 0L;
        }
        return l11.longValue();
    }

    public long remove(K k11) {
        Long lRemove = this.map.remove(k11);
        if (lRemove == null) {
            return 0L;
        }
        return lRemove.longValue();
    }

    public boolean remove(K k11, long j11) {
        return this.map.remove(k11, Long.valueOf(j11));
    }

    public void removeAllZeros() {
        this.map.values().removeIf(new Predicate() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.p
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AtomicLongMap.lambda$removeAllZeros$5((Long) obj);
            }
        });
    }

    public boolean removeIfZero(K k11) {
        return remove(k11, 0L);
    }

    public boolean replace(K k11, long j11, long j12) {
        if (j11 == 0) {
            return putIfAbsent(k11, j12) == 0;
        }
        return this.map.replace(k11, Long.valueOf(j11), Long.valueOf(j12));
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        return this.map.values().stream().mapToLong(new ToLongFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.o
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((Long) obj).longValue();
            }
        }).sum();
    }

    public String toString() {
        return this.map.toString();
    }

    public long updateAndGet(K k11, final LongUnaryOperator longUnaryOperator) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(longUnaryOperator);
        return ((Long) this.map.compute(k11, new BiFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.s
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return AtomicLongMap.lambda$updateAndGet$0(longUnaryOperator, obj, (Long) obj2);
            }
        })).longValue();
    }
}
