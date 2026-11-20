package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Equivalence;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterators;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.ExecutionError;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Futures;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.MoreExecutors;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.i0;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.l0;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.n0;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Logger f39101v = Logger.getLogger(LocalCache.class.getName());

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final s<Object, Object> f39102w = new a();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Queue<?> f39103x = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f39104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f39105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Segment<K, V>[] f39106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Equivalence<Object> f39107d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Equivalence<Object> f39108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Strength f39109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Strength f39110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f39111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.n<K, V> f39112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f39113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f39114l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f39115m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Queue<RemovalNotification<K, V>> f39116n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.l<K, V> f39117o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.s f39118p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final EntryFactory f39119q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CacheLoader<? super K, V> f39120r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Set<K> f39121s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Collection<V> f39122t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Set<Map.Entry<K, V>> f39123u;

    /* JADX INFO: compiled from: source.java */
    public enum EntryFactory {
        STRONG { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> newEntry(Segment<K, V> segment, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                return new o(k11, i11, kVar);
            }
        },
        STRONG_ACCESS { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> copyEntry(Segment<K, V> segment, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarCopyEntry = super.copyEntry(segment, kVar, kVar2);
                copyAccessEntry(kVar, kVarCopyEntry);
                return kVarCopyEntry;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> newEntry(Segment<K, V> segment, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                return new m(k11, i11, kVar);
            }
        },
        STRONG_WRITE { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> copyEntry(Segment<K, V> segment, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarCopyEntry = super.copyEntry(segment, kVar, kVar2);
                copyWriteEntry(kVar, kVarCopyEntry);
                return kVarCopyEntry;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> newEntry(Segment<K, V> segment, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                return new q(k11, i11, kVar);
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> copyEntry(Segment<K, V> segment, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarCopyEntry = super.copyEntry(segment, kVar, kVar2);
                copyAccessEntry(kVar, kVarCopyEntry);
                copyWriteEntry(kVar, kVarCopyEntry);
                return kVarCopyEntry;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> newEntry(Segment<K, V> segment, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                return new n(k11, i11, kVar);
            }
        },
        WEAK { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> newEntry(Segment<K, V> segment, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                return new w(segment.keyReferenceQueue, k11, i11, kVar);
            }
        },
        WEAK_ACCESS { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> copyEntry(Segment<K, V> segment, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarCopyEntry = super.copyEntry(segment, kVar, kVar2);
                copyAccessEntry(kVar, kVarCopyEntry);
                return kVarCopyEntry;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> newEntry(Segment<K, V> segment, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                return new u(segment.keyReferenceQueue, k11, i11, kVar);
            }
        },
        WEAK_WRITE { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> copyEntry(Segment<K, V> segment, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarCopyEntry = super.copyEntry(segment, kVar, kVar2);
                copyWriteEntry(kVar, kVarCopyEntry);
                return kVarCopyEntry;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> newEntry(Segment<K, V> segment, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                return new y(segment.keyReferenceQueue, k11, i11, kVar);
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> copyEntry(Segment<K, V> segment, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarCopyEntry = super.copyEntry(segment, kVar, kVar2);
                copyAccessEntry(kVar, kVarCopyEntry);
                copyWriteEntry(kVar, kVarCopyEntry);
                return kVarCopyEntry;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> newEntry(Segment<K, V> segment, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                return new v(segment.keyReferenceQueue, k11, i11, kVar);
            }
        };

        static final int ACCESS_MASK = 1;
        static final int WEAK_MASK = 4;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = {STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};

        /* synthetic */ EntryFactory(a aVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EntryFactory getFactory(Strength strength, boolean z11, boolean z12) {
            return factories[((strength == Strength.WEAK ? (char) 4 : (char) 0) | (z11 ? 1 : 0) ? 1 : 0) | (z12 ? 2 : 0)];
        }

        public <K, V> void copyAccessEntry(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
            kVar2.setAccessTime(kVar.getAccessTime());
            LocalCache.f(kVar.getPreviousInAccessQueue(), kVar2);
            LocalCache.f(kVar2, kVar.getNextInAccessQueue());
            LocalCache.v(kVar);
        }

        public <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> copyEntry(Segment<K, V> segment, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
            return newEntry(segment, kVar.getKey(), kVar.getHash(), kVar2);
        }

        public <K, V> void copyWriteEntry(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
            kVar2.setWriteTime(kVar.getWriteTime());
            LocalCache.g(kVar.getPreviousInWriteQueue(), kVar2);
            LocalCache.g(kVar2, kVar.getNextInWriteQueue());
            LocalCache.w(kVar);
        }

        public abstract <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> newEntry(Segment<K, V> segment, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar);
    }

    /* JADX INFO: compiled from: source.java */
    public enum NullEntry implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> {
        INSTANCE;

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public int getHash() {
            return 0;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public Object getKey() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public s<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setAccessTime(long j11) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> kVar) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> kVar) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> kVar) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> kVar) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setValueReference(s<Object, Object> sVar) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setWriteTime(long j11) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class Segment<K, V> extends ReentrantLock {
        final Queue<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> accessQueue;
        volatile int count;
        final ReferenceQueue<K> keyReferenceQueue;
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> recencyQueue;
        final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.a statsCounter;
        volatile AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> table;
        int threshold;
        long totalWeight;
        final ReferenceQueue<V> valueReferenceQueue;
        final Queue<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> writeQueue;

        public Segment(LocalCache<K, V> localCache, int i11, long j11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.a aVar) {
            this.map = localCache;
            this.maxSegmentWeight = j11;
            this.statsCounter = (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.a) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(aVar);
            initTable(newEntryArray(i11));
            this.keyReferenceQueue = localCache.J() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.K() ? new ReferenceQueue<>() : null;
            this.recencyQueue = localCache.I() ? new ConcurrentLinkedQueue<>() : LocalCache.i();
            this.writeQueue = localCache.L() ? new c0<>() : LocalCache.i();
            this.accessQueue = localCache.I() ? new e<>() : LocalCache.i();
        }

        public void cleanUp() {
            runLockedCleanup(this.map.f39118p.a());
            runUnlockedCleanup();
        }

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.f39118p.a());
                    AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                    for (int i11 = 0; i11 < atomicReferenceArray.length(); i11++) {
                        for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = atomicReferenceArray.get(i11); next != null; next = next.getNext()) {
                            if (next.getValueReference().isActive()) {
                                K key = next.getKey();
                                V v11 = next.getValueReference().get();
                                enqueueNotification(key, next.getHash(), v11, next.getValueReference().b(), (key == null || v11 == null) ? RemovalCause.COLLECTED : RemovalCause.EXPLICIT);
                            }
                        }
                    }
                    for (int i12 = 0; i12 < atomicReferenceArray.length(); i12++) {
                        atomicReferenceArray.set(i12, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        public void clearKeyReferenceQueue() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        public void clearReferenceQueues() {
            if (this.map.J()) {
                clearKeyReferenceQueue();
            }
            if (this.map.K()) {
                clearValueReferenceQueue();
            }
        }

        public void clearValueReferenceQueue() {
            while (this.valueReferenceQueue.poll() != null) {
            }
        }

        public V compute(K k11, int i11, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            s<K, V> valueReference;
            boolean z11;
            lock();
            try {
                long jA = this.map.f39118p.a();
                preWriteCleanup(jA);
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                boolean z12 = true;
                int length = i11 & (atomicReferenceArray.length() - 1);
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = atomicReferenceArray.get(length);
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarNewEntry = kVar;
                while (true) {
                    if (kVarNewEntry == null) {
                        valueReference = null;
                        z11 = true;
                        break;
                    }
                    K key = kVarNewEntry.getKey();
                    if (kVarNewEntry.getHash() == i11 && key != null && this.map.f39107d.equivalent(k11, key)) {
                        valueReference = kVarNewEntry.getValueReference();
                        if (this.map.p(kVarNewEntry, jA)) {
                            enqueueNotification(key, i11, valueReference.get(), valueReference.b(), RemovalCause.EXPIRED);
                        }
                        this.writeQueue.remove(kVarNewEntry);
                        this.accessQueue.remove(kVarNewEntry);
                        z11 = false;
                        break;
                    }
                    kVarNewEntry = kVarNewEntry.getNext();
                }
                k<K, V> kVar2 = new k<>(valueReference);
                if (kVarNewEntry == null) {
                    kVarNewEntry = newEntry(k11, i11, kVar);
                    kVarNewEntry.setValueReference(kVar2);
                    atomicReferenceArray.set(length, kVarNewEntry);
                } else {
                    kVarNewEntry.setValueReference(kVar2);
                    z12 = z11;
                }
                V vF = kVar2.f(k11, biFunction);
                if (vF != null) {
                    try {
                        V andRecordStats = getAndRecordStats(k11, i11, kVar2, Futures.f(vF));
                        unlock();
                        postWriteCleanup();
                        return andRecordStats;
                    } catch (ExecutionException unused) {
                        throw new AssertionError("impossible; Futures.immediateFuture can't throw");
                    }
                }
                if (z12) {
                    removeLoadingValue(k11, i11, kVar2);
                } else {
                    removeEntry(kVarNewEntry, i11, RemovalCause.EXPLICIT);
                }
                unlock();
                postWriteCleanup();
                return null;
            } catch (Throwable th2) {
                unlock();
                postWriteCleanup();
                throw th2;
            }
        }

        public boolean containsKey(Object obj, int i11) {
            try {
                if (this.count == 0) {
                    return false;
                }
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> liveEntry = getLiveEntry(obj, i11, this.map.f39118p.a());
                if (liveEntry == null) {
                    return false;
                }
                return liveEntry.getValueReference().get() != null;
            } finally {
                postReadCleanup();
            }
        }

        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long jA = this.map.f39118p.a();
                    AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i11 = 0; i11 < length; i11++) {
                        for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = atomicReferenceArray.get(i11); next != null; next = next.getNext()) {
                            V liveValue = getLiveValue(next, jA);
                            if (liveValue != null && this.map.f39108f.equivalent(obj, liveValue)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> copyEntry(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
            if (kVar.getKey() == null) {
                return null;
            }
            s<K, V> valueReference = kVar.getValueReference();
            V v11 = valueReference.get();
            if (v11 == null && valueReference.isActive()) {
                return null;
            }
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarCopyEntry = this.map.f39119q.copyEntry(this, kVar, kVar2);
            kVarCopyEntry.setValueReference(valueReference.e(this.valueReferenceQueue, v11, kVarCopyEntry));
            return kVarCopyEntry;
        }

        public void drainKeyReferenceQueue() {
            int i11 = 0;
            do {
                Reference<? extends K> referencePoll = this.keyReferenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.y((com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k) referencePoll);
                i11++;
            } while (i11 != 16);
        }

        public void drainRecencyQueue() {
            while (true) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarPoll = this.recencyQueue.poll();
                if (kVarPoll == null) {
                    return;
                }
                if (this.accessQueue.contains(kVarPoll)) {
                    this.accessQueue.add(kVarPoll);
                }
            }
        }

        public void drainReferenceQueues() {
            if (this.map.J()) {
                drainKeyReferenceQueue();
            }
            if (this.map.K()) {
                drainValueReferenceQueue();
            }
        }

        public void drainValueReferenceQueue() {
            int i11 = 0;
            do {
                Reference<? extends V> referencePoll = this.valueReferenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.z((s) referencePoll);
                i11++;
            } while (i11 != 16);
        }

        public void enqueueNotification(K k11, int i11, V v11, int i12, RemovalCause removalCause) {
            this.totalWeight -= (long) i12;
            if (removalCause.wasEvicted()) {
                this.statsCounter.c();
            }
            if (this.map.f39116n != LocalCache.f39103x) {
                this.map.f39116n.offer(RemovalNotification.create(k11, v11, removalCause));
            }
        }

        public void evictEntries(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            if (this.map.j()) {
                drainRecencyQueue();
                if (kVar.getValueReference().b() > this.maxSegmentWeight && !removeEntry(kVar, kVar.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        public void expand() {
            AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i11 = this.count;
            AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArrayNewEntryArray = newEntryArray(length << 1);
            this.threshold = (atomicReferenceArrayNewEntryArray.length() * 3) / 4;
            int length2 = atomicReferenceArrayNewEntryArray.length() - 1;
            for (int i12 = 0; i12 < length; i12++) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = atomicReferenceArray.get(i12);
                if (next != null) {
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next2 = next.getNext();
                    int hash = next.getHash() & length2;
                    if (next2 == null) {
                        atomicReferenceArrayNewEntryArray.set(hash, next);
                    } else {
                        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = next;
                        while (next2 != null) {
                            int hash2 = next2.getHash() & length2;
                            if (hash2 != hash) {
                                kVar = next2;
                                hash = hash2;
                            }
                            next2 = next2.getNext();
                        }
                        atomicReferenceArrayNewEntryArray.set(hash, kVar);
                        while (next != kVar) {
                            int hash3 = next.getHash() & length2;
                            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarCopyEntry = copyEntry(next, atomicReferenceArrayNewEntryArray.get(hash3));
                            if (kVarCopyEntry != null) {
                                atomicReferenceArrayNewEntryArray.set(hash3, kVarCopyEntry);
                            } else {
                                removeCollectedEntry(next);
                                i11--;
                            }
                            next = next.getNext();
                        }
                    }
                }
            }
            this.table = atomicReferenceArrayNewEntryArray;
            this.count = i11;
        }

        public void expireEntries(long j11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarPeek;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarPeek2;
            drainRecencyQueue();
            do {
                kVarPeek = this.writeQueue.peek();
                if (kVarPeek == null || !this.map.p(kVarPeek, j11)) {
                    do {
                        kVarPeek2 = this.accessQueue.peek();
                        if (kVarPeek2 == null || !this.map.p(kVarPeek2, j11)) {
                            return;
                        }
                    } while (removeEntry(kVarPeek2, kVarPeek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(kVarPeek, kVarPeek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        public V get(Object obj, int i11) {
            try {
                if (this.count != 0) {
                    long jA = this.map.f39118p.a();
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> liveEntry = getLiveEntry(obj, i11, jA);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v11 = liveEntry.getValueReference().get();
                    if (v11 != null) {
                        recordRead(liveEntry, jA);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), i11, v11, jA, this.map.f39120r);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        public V get(K k11, int i11, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> entry;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(cacheLoader);
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(k11, i11)) != null) {
                        long jA = this.map.f39118p.a();
                        V liveValue = getLiveValue(entry, jA);
                        if (liveValue != null) {
                            recordRead(entry, jA);
                            this.statsCounter.a(1);
                            V vScheduleRefresh = scheduleRefresh(entry, k11, i11, liveValue, jA, cacheLoader);
                            postReadCleanup();
                            return vScheduleRefresh;
                        }
                        s<K, V> valueReference = entry.getValueReference();
                        if (valueReference.isLoading()) {
                            V vWaitForLoadingValue = waitForLoadingValue(entry, k11, valueReference);
                            postReadCleanup();
                            return vWaitForLoadingValue;
                        }
                    }
                    V vLockedGetOrLoad = lockedGetOrLoad(k11, i11, cacheLoader);
                    postReadCleanup();
                    return vLockedGetOrLoad;
                } catch (ExecutionException e11) {
                    Throwable cause = e11.getCause();
                    if (cause instanceof Error) {
                        throw new ExecutionError((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new UncheckedExecutionException(cause);
                    }
                    throw e11;
                }
            } catch (Throwable th2) {
                postReadCleanup();
                throw th2;
            }
        }

        public V getAndRecordStats(K k11, int i11, k<K, V> kVar, i0<V> i0Var) throws Throwable {
            V v11;
            try {
                v11 = (V) n0.a(i0Var);
                try {
                    if (v11 != null) {
                        this.statsCounter.e(kVar.g());
                        storeLoadedValue(k11, i11, kVar, v11);
                        return v11;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k11 + InstructionFileId.DOT);
                } catch (Throwable th2) {
                    th = th2;
                    if (v11 == null) {
                        this.statsCounter.d(kVar.g());
                        removeLoadingValue(k11, i11, kVar);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                v11 = null;
            }
        }

        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getEntry(Object obj, int i11) {
            for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> first = getFirst(i11); first != null; first = first.getNext()) {
                if (first.getHash() == i11) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.f39107d.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getFirst(int i11) {
            AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i11 & (atomicReferenceArray.length() - 1));
        }

        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getLiveEntry(Object obj, int i11, long j11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> entry = getEntry(obj, i11);
            if (entry == null) {
                return null;
            }
            if (!this.map.p(entry, j11)) {
                return entry;
            }
            tryExpireEntries(j11);
            return null;
        }

        public V getLiveValue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, long j11) {
            if (kVar.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v11 = kVar.getValueReference().get();
            if (v11 == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.p(kVar, j11)) {
                return v11;
            }
            tryExpireEntries(j11);
            return null;
        }

        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextEvictable() {
            for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar : this.accessQueue) {
                if (kVar.getValueReference().b() > 0) {
                    return kVar;
                }
            }
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.h()) {
                int i11 = this.threshold;
                if (i11 == this.maxSegmentWeight) {
                    this.threshold = i11 + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        public k<K, V> insertLoadingValueReference(K k11, int i11, boolean z11) {
            lock();
            try {
                long jA = this.map.f39118p.a();
                preWriteCleanup(jA);
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k) atomicReferenceArray.get(length);
                for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k next = kVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.f39107d.equivalent(k11, key)) {
                        s<K, V> valueReference = next.getValueReference();
                        if (!valueReference.isLoading() && (!z11 || jA - next.getWriteTime() >= this.map.f39115m)) {
                            this.modCount++;
                            k<K, V> kVar2 = new k<>(valueReference);
                            next.setValueReference(kVar2);
                            return kVar2;
                        }
                        return null;
                    }
                }
                this.modCount++;
                k<K, V> kVar3 = new k<>();
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarNewEntry = newEntry(k11, i11, kVar);
                kVarNewEntry.setValueReference(kVar3);
                atomicReferenceArray.set(length, kVarNewEntry);
                return kVar3;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public i0<V> loadAsync(final K k11, final int i11, final k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) {
            final i0<V> i0VarJ = kVar.j(k11, cacheLoader);
            i0VarJ.addListener(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.Segment.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Segment.this.getAndRecordStats(k11, i11, kVar, i0VarJ);
                    } catch (Throwable th2) {
                        LocalCache.f39101v.log(Level.WARNING, "Exception thrown during refresh", th2);
                        kVar.l(th2);
                    }
                }
            }, MoreExecutors.a());
            return i0VarJ;
        }

        public V loadSync(K k11, int i11, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k11, i11, kVar, kVar.j(k11, cacheLoader));
        }

        public V lockedGetOrLoad(K k11, int i11, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            k<K, V> kVar;
            s<K, V> sVar;
            boolean z11;
            V vLoadSync;
            lock();
            try {
                long jA = this.map.f39118p.a();
                preWriteCleanup(jA);
                int i12 = this.count - 1;
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                int length = i11 & (atomicReferenceArray.length() - 1);
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2 = atomicReferenceArray.get(length);
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarNewEntry = kVar2;
                while (true) {
                    kVar = null;
                    if (kVarNewEntry != null) {
                        K key = kVarNewEntry.getKey();
                        if (kVarNewEntry.getHash() == i11 && key != null && this.map.f39107d.equivalent(k11, key)) {
                            s<K, V> valueReference = kVarNewEntry.getValueReference();
                            if (valueReference.isLoading()) {
                                z11 = false;
                                sVar = valueReference;
                                break;
                            }
                            V v11 = valueReference.get();
                            if (v11 == null) {
                                enqueueNotification(key, i11, v11, valueReference.b(), RemovalCause.COLLECTED);
                            } else {
                                if (!this.map.p(kVarNewEntry, jA)) {
                                    recordLockedRead(kVarNewEntry, jA);
                                    this.statsCounter.a(1);
                                    unlock();
                                    postWriteCleanup();
                                    return v11;
                                }
                                enqueueNotification(key, i11, v11, valueReference.b(), RemovalCause.EXPIRED);
                            }
                            this.writeQueue.remove(kVarNewEntry);
                            this.accessQueue.remove(kVarNewEntry);
                            this.count = i12;
                            sVar = valueReference;
                        } else {
                            kVarNewEntry = kVarNewEntry.getNext();
                        }
                    } else {
                        sVar = null;
                    }
                    z11 = true;
                    break;
                }
                if (z11) {
                    kVar = new k<>();
                    if (kVarNewEntry == null) {
                        kVarNewEntry = newEntry(k11, i11, kVar2);
                        kVarNewEntry.setValueReference(kVar);
                        atomicReferenceArray.set(length, kVarNewEntry);
                    } else {
                        kVarNewEntry.setValueReference(kVar);
                    }
                }
                unlock();
                postWriteCleanup();
                if (!z11) {
                    return waitForLoadingValue(kVarNewEntry, k11, sVar);
                }
                try {
                    synchronized (kVarNewEntry) {
                        vLoadSync = loadSync(k11, i11, kVar, cacheLoader);
                    }
                    this.statsCounter.b(1);
                    return vLoadSync;
                } catch (Throwable th2) {
                    this.statsCounter.b(1);
                    throw th2;
                }
            } catch (Throwable th3) {
                unlock();
                postWriteCleanup();
                throw th3;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> newEntry(K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            return this.map.f39119q.newEntry(this, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11), i11, kVar);
        }

        public AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> newEntryArray(int i11) {
            return new AtomicReferenceArray<>(i11);
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        public void preWriteCleanup(long j11) {
            runLockedCleanup(j11);
        }

        public V put(K k11, int i11, V v11, boolean z11) {
            int i12;
            lock();
            try {
                long jA = this.map.f39118p.a();
                preWriteCleanup(jA);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                int length = i11 & (atomicReferenceArray.length() - 1);
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = atomicReferenceArray.get(length);
                for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = kVar; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.f39107d.equivalent(k11, key)) {
                        s<K, V> valueReference = next.getValueReference();
                        V v12 = valueReference.get();
                        if (v12 != null) {
                            if (z11) {
                                recordLockedRead(next, jA);
                            } else {
                                this.modCount++;
                                enqueueNotification(k11, i11, v12, valueReference.b(), RemovalCause.REPLACED);
                                setValue(next, k11, v11, jA);
                                evictEntries(next);
                            }
                            return v12;
                        }
                        this.modCount++;
                        if (valueReference.isActive()) {
                            enqueueNotification(k11, i11, v12, valueReference.b(), RemovalCause.COLLECTED);
                            setValue(next, k11, v11, jA);
                            i12 = this.count;
                        } else {
                            setValue(next, k11, v11, jA);
                            i12 = this.count + 1;
                        }
                        this.count = i12;
                        evictEntries(next);
                        return null;
                    }
                }
                this.modCount++;
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarNewEntry = newEntry(k11, i11, kVar);
                setValue(kVarNewEntry, k11, v11, jA);
                atomicReferenceArray.set(length, kVarNewEntry);
                this.count++;
                evictEntries(kVarNewEntry);
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimKey(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, int i11) {
            lock();
            try {
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2 = atomicReferenceArray.get(length);
                for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = kVar2; next != null; next = next.getNext()) {
                    if (next == kVar) {
                        this.modCount++;
                        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarRemoveValueFromChain = removeValueFromChain(kVar2, next, next.getKey(), i11, next.getValueReference().get(), next.getValueReference(), RemovalCause.COLLECTED);
                        int i12 = this.count - 1;
                        atomicReferenceArray.set(length, kVarRemoveValueFromChain);
                        this.count = i12;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimValue(K k11, int i11, s<K, V> sVar) {
            lock();
            try {
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = atomicReferenceArray.get(length);
                for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = kVar; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.f39107d.equivalent(k11, key)) {
                        if (next.getValueReference() != sVar) {
                            return false;
                        }
                        this.modCount++;
                        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarRemoveValueFromChain = removeValueFromChain(kVar, next, key, i11, sVar.get(), sVar, RemovalCause.COLLECTED);
                        int i12 = this.count - 1;
                        atomicReferenceArray.set(length, kVarRemoveValueFromChain);
                        this.count = i12;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        public void recordLockedRead(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, long j11) {
            if (this.map.A()) {
                kVar.setAccessTime(j11);
            }
            this.accessQueue.add(kVar);
        }

        public void recordRead(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, long j11) {
            if (this.map.A()) {
                kVar.setAccessTime(j11);
            }
            this.recencyQueue.add(kVar);
        }

        public void recordWrite(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, int i11, long j11) {
            drainRecencyQueue();
            this.totalWeight += (long) i11;
            if (this.map.A()) {
                kVar.setAccessTime(j11);
            }
            if (this.map.B()) {
                kVar.setWriteTime(j11);
            }
            this.accessQueue.add(kVar);
            this.writeQueue.add(kVar);
        }

        public V refresh(K k11, int i11, CacheLoader<? super K, V> cacheLoader, boolean z11) {
            k<K, V> kVarInsertLoadingValueReference = insertLoadingValueReference(k11, i11, z11);
            if (kVarInsertLoadingValueReference == null) {
                return null;
            }
            i0<V> i0VarLoadAsync = loadAsync(k11, i11, kVarInsertLoadingValueReference, cacheLoader);
            if (i0VarLoadAsync.isDone()) {
                try {
                    return (V) n0.a(i0VarLoadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        public V remove(Object obj, int i11) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.f39118p.a());
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = atomicReferenceArray.get(length);
                for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = kVar; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.f39107d.equivalent(obj, key)) {
                        s<K, V> valueReference = next.getValueReference();
                        V v11 = valueReference.get();
                        if (v11 == null) {
                            if (!valueReference.isActive()) {
                                break;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            removalCause = RemovalCause.EXPLICIT;
                        }
                        RemovalCause removalCause2 = removalCause;
                        this.modCount++;
                        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarRemoveValueFromChain = removeValueFromChain(kVar, next, key, i11, v11, valueReference, removalCause2);
                        int i12 = this.count - 1;
                        atomicReferenceArray.set(length, kVarRemoveValueFromChain);
                        this.count = i12;
                        return v11;
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean remove(Object obj, int i11, Object obj2) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.f39118p.a());
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = atomicReferenceArray.get(length);
                for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = kVar; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.f39107d.equivalent(obj, key)) {
                        s<K, V> valueReference = next.getValueReference();
                        V v11 = valueReference.get();
                        if (!this.map.f39108f.equivalent(obj2, v11)) {
                            if (v11 != null || !valueReference.isActive()) {
                                break;
                                break;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            removalCause = RemovalCause.EXPLICIT;
                        }
                        this.modCount++;
                        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarRemoveValueFromChain = removeValueFromChain(kVar, next, key, i11, v11, valueReference, removalCause);
                        int i12 = this.count - 1;
                        atomicReferenceArray.set(length, kVarRemoveValueFromChain);
                        this.count = i12;
                        return removalCause == RemovalCause.EXPLICIT;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void removeCollectedEntry(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            enqueueNotification(kVar.getKey(), kVar.getHash(), kVar.getValueReference().get(), kVar.getValueReference().b(), RemovalCause.COLLECTED);
            this.writeQueue.remove(kVar);
            this.accessQueue.remove(kVar);
        }

        public boolean removeEntry(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, int i11, RemovalCause removalCause) {
            AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i11;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2 = atomicReferenceArray.get(length);
            for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = kVar2; next != null; next = next.getNext()) {
                if (next == kVar) {
                    this.modCount++;
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarRemoveValueFromChain = removeValueFromChain(kVar2, next, next.getKey(), i11, next.getValueReference().get(), next.getValueReference(), removalCause);
                    int i12 = this.count - 1;
                    atomicReferenceArray.set(length, kVarRemoveValueFromChain);
                    this.count = i12;
                    return true;
                }
            }
            return false;
        }

        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> removeEntryFromChain(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
            int i11 = this.count;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = kVar2.getNext();
            while (kVar != kVar2) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarCopyEntry = copyEntry(kVar, next);
                if (kVarCopyEntry != null) {
                    next = kVarCopyEntry;
                } else {
                    removeCollectedEntry(kVar);
                    i11--;
                }
                kVar = kVar.getNext();
            }
            this.count = i11;
            return next;
        }

        public boolean removeLoadingValue(K k11, int i11, k<K, V> kVar) {
            lock();
            try {
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2 = atomicReferenceArray.get(length);
                for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = kVar2; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.f39107d.equivalent(k11, key)) {
                        if (next.getValueReference() != kVar) {
                            break;
                        }
                        if (kVar.isActive()) {
                            next.setValueReference(kVar.i());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(kVar2, next));
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> removeValueFromChain(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2, K k11, int i11, V v11, s<K, V> sVar, RemovalCause removalCause) {
            enqueueNotification(k11, i11, v11, sVar.b(), removalCause);
            this.writeQueue.remove(kVar2);
            this.accessQueue.remove(kVar2);
            if (!sVar.isLoading()) {
                return removeEntryFromChain(kVar, kVar2);
            }
            sVar.c(null);
            return kVar;
        }

        public V replace(K k11, int i11, V v11) {
            lock();
            try {
                long jA = this.map.f39118p.a();
                preWriteCleanup(jA);
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                int length = i11 & (atomicReferenceArray.length() - 1);
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = atomicReferenceArray.get(length);
                for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = kVar; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i11 && key != null) {
                        if (this.map.f39107d.equivalent(k11, key)) {
                            s<K, V> valueReference = next.getValueReference();
                            V v12 = valueReference.get();
                            if (v12 != null) {
                                this.modCount++;
                                enqueueNotification(k11, i11, v12, valueReference.b(), RemovalCause.REPLACED);
                                setValue(next, k11, v11, jA);
                                evictEntries(next);
                                return v12;
                            }
                            if (!valueReference.isActive()) {
                                break;
                            }
                            this.modCount++;
                            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarRemoveValueFromChain = removeValueFromChain(kVar, next, key, i11, v12, valueReference, RemovalCause.COLLECTED);
                            int i12 = this.count - 1;
                            atomicReferenceArray.set(length, kVarRemoveValueFromChain);
                            this.count = i12;
                            break;
                        }
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean replace(K k11, int i11, V v11, V v12) {
            lock();
            try {
                long jA = this.map.f39118p.a();
                preWriteCleanup(jA);
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                int length = i11 & (atomicReferenceArray.length() - 1);
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = atomicReferenceArray.get(length);
                for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = kVar; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i11 && key != null) {
                        if (this.map.f39107d.equivalent(k11, key)) {
                            s<K, V> valueReference = next.getValueReference();
                            V v13 = valueReference.get();
                            if (v13 != null) {
                                if (!this.map.f39108f.equivalent(v11, v13)) {
                                    recordLockedRead(next, jA);
                                    break;
                                }
                                this.modCount++;
                                enqueueNotification(k11, i11, v13, valueReference.b(), RemovalCause.REPLACED);
                                setValue(next, k11, v12, jA);
                                evictEntries(next);
                                return true;
                            }
                            if (!valueReference.isActive()) {
                                break;
                            }
                            this.modCount++;
                            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarRemoveValueFromChain = removeValueFromChain(kVar, next, key, i11, v13, valueReference, RemovalCause.COLLECTED);
                            int i12 = this.count - 1;
                            atomicReferenceArray.set(length, kVarRemoveValueFromChain);
                            this.count = i12;
                            break;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void runLockedCleanup(long j11) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j11);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.x();
        }

        public V scheduleRefresh(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, K k11, int i11, V v11, long j11, CacheLoader<? super K, V> cacheLoader) {
            V vRefresh;
            return (!this.map.C() || j11 - kVar.getWriteTime() <= this.map.f39115m || kVar.getValueReference().isLoading() || (vRefresh = refresh(k11, i11, cacheLoader, true)) == null) ? v11 : vRefresh;
        }

        public void setValue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, K k11, V v11, long j11) {
            s<K, V> valueReference = kVar.getValueReference();
            int iWeigh = this.map.f39112j.weigh(k11, v11);
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.u(iWeigh >= 0, "Weights must be non-negative");
            kVar.setValueReference(this.map.f39110h.referenceValue(this, kVar, v11, iWeigh));
            recordWrite(kVar, iWeigh, j11);
            valueReference.c(v11);
        }

        public boolean storeLoadedValue(K k11, int i11, k<K, V> kVar, V v11) {
            lock();
            try {
                long jA = this.map.f39118p.a();
                preWriteCleanup(jA);
                int i12 = this.count + 1;
                if (i12 > this.threshold) {
                    expand();
                    i12 = this.count + 1;
                }
                int i13 = i12;
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.table;
                int length = i11 & (atomicReferenceArray.length() - 1);
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2 = atomicReferenceArray.get(length);
                for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = kVar2; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.f39107d.equivalent(k11, key)) {
                        s<K, V> valueReference = next.getValueReference();
                        V v12 = valueReference.get();
                        if (kVar != valueReference && (v12 != null || valueReference == LocalCache.f39102w)) {
                            enqueueNotification(k11, i11, v11, 0, RemovalCause.REPLACED);
                            return false;
                        }
                        this.modCount++;
                        if (kVar.isActive()) {
                            enqueueNotification(k11, i11, v12, kVar.b(), v12 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i13--;
                        }
                        setValue(next, k11, v11, jA);
                        this.count = i13;
                        evictEntries(next);
                        return true;
                    }
                }
                this.modCount++;
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarNewEntry = newEntry(k11, i11, kVar2);
                setValue(kVarNewEntry, k11, v11, jA);
                atomicReferenceArray.set(length, kVarNewEntry);
                this.count = i13;
                evictEntries(kVarNewEntry);
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public void tryExpireEntries(long j11) {
            if (tryLock()) {
                try {
                    expireEntries(j11);
                } finally {
                    unlock();
                }
            }
        }

        public V waitForLoadingValue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, K k11, s<K, V> sVar) throws ExecutionException {
            if (!sVar.isLoading()) {
                throw new AssertionError();
            }
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.w(!Thread.holdsLock(kVar), "Recursive load of: %s", k11);
            try {
                V vD = sVar.d();
                if (vD != null) {
                    recordRead(kVar, this.map.f39118p.a());
                    this.statsCounter.b(1);
                    return vD;
                }
                throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k11 + InstructionFileId.DOT);
            } catch (Throwable th2) {
                this.statsCounter.b(1);
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum Strength {
        STRONG { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, V v11, int i11) {
                return i11 == 1 ? new p(v11) : new a0(v11, i11);
            }
        },
        SOFT { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, V v11, int i11) {
                return i11 == 1 ? new l(segment.valueReferenceQueue, v11, kVar) : new z(segment.valueReferenceQueue, v11, kVar, i11);
            }
        },
        WEAK { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, V v11, int i11) {
                return i11 == 1 ? new x(segment.valueReferenceQueue, v11, kVar) : new b0(segment.valueReferenceQueue, v11, kVar, i11);
            }
        };

        /* synthetic */ Strength(a aVar) {
            this();
        }

        public abstract Equivalence<Object> defaultEquivalence();

        public abstract <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, V v11, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class a implements s<Object, Object> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> a() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public int b() {
            return 0;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public void c(Object obj) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public Object d() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public s<Object, Object> e(ReferenceQueue<Object> referenceQueue, Object obj, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<Object, Object> kVar) {
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public Object get() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return false;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a0<K, V> extends p<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f39124b;

        public a0(V v11, int i11) {
            super(v11);
            this.f39124b = i11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.p, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public int b() {
            return this.f39124b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends AbstractQueue<Object> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b0<K, V> extends x<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f39125b;

        public b0(ReferenceQueue<V> referenceQueue, V v11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, int i11) {
            super(referenceQueue, v11, kVar);
            this.f39125b = i11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.x, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public int b() {
            return this.f39125b;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.x, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            return new b0(referenceQueue, v11, kVar, this.f39125b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class c<T> extends AbstractSet<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentMap<?, ?> f39126a;

        public c(ConcurrentMap<?, ?> concurrentMap) {
            this.f39126a = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f39126a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f39126a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f39126a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.G(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.G(this).toArray(eArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c0<K, V> extends AbstractQueue<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39128a = new a();

        /* JADX INFO: compiled from: source.java */
        public class a extends d<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39129a = this;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39130b = this;

            public a() {
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInWriteQueue() {
                return this.f39129a;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
                return this.f39130b;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public void setNextInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                this.f39129a = kVar;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public void setPreviousInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                this.f39130b = kVar;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public void setWriteTime(long j11) {
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.w<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> {
            public b(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k kVar) {
                super(kVar);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.w
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> a(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInWriteQueue = kVar.getNextInWriteQueue();
                if (nextInWriteQueue == c0.this.f39128a) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            LocalCache.g(kVar.getPreviousInWriteQueue(), kVar.getNextInWriteQueue());
            LocalCache.g(this.f39128a.getPreviousInWriteQueue(), kVar);
            LocalCache.g(kVar, this.f39128a);
            return true;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> peek() {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInWriteQueue = this.f39128a.getNextInWriteQueue();
            if (nextInWriteQueue == this.f39128a) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInWriteQueue = this.f39128a.getNextInWriteQueue();
            while (true) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = this.f39128a;
                if (nextInWriteQueue == kVar) {
                    kVar.setNextInWriteQueue(kVar);
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2 = this.f39128a;
                    kVar2.setPreviousInWriteQueue(kVar2);
                    return;
                } else {
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.w(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> poll() {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInWriteQueue = this.f39128a.getNextInWriteQueue();
            if (nextInWriteQueue == this.f39128a) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f39128a.getNextInWriteQueue() == this.f39128a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k kVar = (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k) obj;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> previousInWriteQueue = kVar.getPreviousInWriteQueue();
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInWriteQueue = kVar.getNextInWriteQueue();
            LocalCache.g(previousInWriteQueue, nextInWriteQueue);
            LocalCache.w(kVar);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i11 = 0;
            for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInWriteQueue = this.f39128a.getNextInWriteQueue(); nextInWriteQueue != this.f39128a; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i11++;
            }
            return i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d<K, V> implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public s<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setAccessTime(long j11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setValueReference(s<K, V> sVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setWriteTime(long j11) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d0 implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f39133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f39134b;

        public d0(K k11, V v11) {
            this.f39133a = k11;
            this.f39134b = v11;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f39133a.equals(entry.getKey()) && this.f39134b.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f39133a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f39134b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f39133a.hashCode() ^ this.f39134b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v11) {
            V v12 = (V) LocalCache.this.put(this.f39133a, v11);
            this.f39134b = v11;
            return v12;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e<K, V> extends AbstractQueue<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39136a = new a();

        /* JADX INFO: compiled from: source.java */
        public class a extends d<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39137a = this;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39138b = this;

            public a() {
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInAccessQueue() {
                return this.f39137a;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
                return this.f39138b;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public void setAccessTime(long j11) {
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public void setNextInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                this.f39137a = kVar;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
            public void setPreviousInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                this.f39138b = kVar;
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.w<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> {
            public b(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k kVar) {
                super(kVar);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.w
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> a(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInAccessQueue = kVar.getNextInAccessQueue();
                if (nextInAccessQueue == e.this.f39136a) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            LocalCache.f(kVar.getPreviousInAccessQueue(), kVar.getNextInAccessQueue());
            LocalCache.f(this.f39136a.getPreviousInAccessQueue(), kVar);
            LocalCache.f(kVar, this.f39136a);
            return true;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> peek() {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInAccessQueue = this.f39136a.getNextInAccessQueue();
            if (nextInAccessQueue == this.f39136a) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInAccessQueue = this.f39136a.getNextInAccessQueue();
            while (true) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = this.f39136a;
                if (nextInAccessQueue == kVar) {
                    kVar.setNextInAccessQueue(kVar);
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2 = this.f39136a;
                    kVar2.setPreviousInAccessQueue(kVar2);
                    return;
                } else {
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.v(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> poll() {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInAccessQueue = this.f39136a.getNextInAccessQueue();
            if (nextInAccessQueue == this.f39136a) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f39136a.getNextInAccessQueue() == this.f39136a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k kVar = (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k) obj;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> previousInAccessQueue = kVar.getPreviousInAccessQueue();
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInAccessQueue = kVar.getNextInAccessQueue();
            LocalCache.f(previousInAccessQueue, nextInAccessQueue);
            LocalCache.v(kVar);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i11 = 0;
            for (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> nextInAccessQueue = this.f39136a.getNextInAccessQueue(); nextInAccessQueue != this.f39136a; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i11++;
            }
            return i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class f extends LocalCache<K, V>.h<Map.Entry<K, V>> {
        public f() {
            super();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class g extends LocalCache<K, V>.c<Map.Entry<K, V>> {
        public g(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        public static /* synthetic */ boolean b(Predicate predicate, Object obj, Object obj2) {
            return predicate.test(Maps.g(obj, obj2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.f39108f.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super Map.Entry<K, V>> predicate) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(predicate);
            return LocalCache.this.E(new BiPredicate() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.i
                @Override // java.util.function.BiPredicate
                public final boolean test(Object obj, Object obj2) {
                    return LocalCache.g.b(predicate, obj, obj2);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class h<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f39143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39144b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Segment<K, V> f39145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> f39146d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39147f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public LocalCache<K, V>.d0 f39148g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public LocalCache<K, V>.d0 f39149h;

        public h() {
            this.f39143a = LocalCache.this.f39106c.length - 1;
            a();
        }

        public final void a() {
            this.f39148g = null;
            if (d() || f()) {
                return;
            }
            while (true) {
                int i11 = this.f39143a;
                if (i11 < 0) {
                    return;
                }
                Segment<K, V>[] segmentArr = LocalCache.this.f39106c;
                this.f39143a = i11 - 1;
                Segment<K, V> segment = segmentArr[i11];
                this.f39145c = segment;
                if (segment.count != 0) {
                    AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.f39145c.table;
                    this.f39146d = atomicReferenceArray;
                    this.f39144b = atomicReferenceArray.length() - 1;
                    if (f()) {
                        return;
                    }
                }
            }
        }

        public boolean b(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            Segment<K, V> segment;
            try {
                long jA = LocalCache.this.f39118p.a();
                K key = kVar.getKey();
                Object objM = LocalCache.this.m(kVar, jA);
                if (objM == null) {
                    return false;
                }
                this.f39148g = new d0(key, objM);
                return true;
            } finally {
                this.f39145c.postReadCleanup();
            }
        }

        public LocalCache<K, V>.d0 c() {
            LocalCache<K, V>.d0 d0Var = this.f39148g;
            if (d0Var == null) {
                throw new NoSuchElementException();
            }
            this.f39149h = d0Var;
            a();
            return this.f39149h;
        }

        public boolean d() {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = this.f39147f;
            if (kVar == null) {
                return false;
            }
            while (true) {
                this.f39147f = kVar.getNext();
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2 = this.f39147f;
                if (kVar2 == null) {
                    return false;
                }
                if (b(kVar2)) {
                    return true;
                }
                kVar = this.f39147f;
            }
        }

        public boolean f() {
            while (true) {
                int i11 = this.f39144b;
                if (i11 < 0) {
                    return false;
                }
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = this.f39146d;
                this.f39144b = i11 - 1;
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar = atomicReferenceArray.get(i11);
                this.f39147f = kVar;
                if (kVar != null && (b(kVar) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39148g != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.t(this.f39149h != null);
            LocalCache.this.remove(this.f39149h.getKey());
            this.f39149h = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class i extends LocalCache<K, V>.h<K> {
        public i() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class j extends LocalCache<K, V>.c<K> {
        public j(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f39126a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.f39126a.remove(obj) != null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k<K, V> implements s<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile s<K, V> f39153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l0<V> f39154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.o f39155c;

        /* JADX INFO: compiled from: source.java */
        public class a implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<V, V> {
            public a() {
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
            public V apply(V v11) {
                k.this.k(v11);
                return v11;
            }
        }

        public k() {
            this(null);
        }

        public k(s<K, V> sVar) {
            this.f39154b = l0.b();
            this.f39155c = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.o.c();
            this.f39153a = sVar == null ? LocalCache.H() : sVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> a() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public int b() {
            return this.f39153a.b();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public void c(V v11) {
            if (v11 != null) {
                k(v11);
            } else {
                this.f39153a = LocalCache.H();
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public V d() throws ExecutionException {
            return (V) n0.a(this.f39154b);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            return this;
        }

        public V f(K k11, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            V vD;
            this.f39155c.f();
            try {
                vD = this.f39153a.d();
            } catch (ExecutionException unused) {
                vD = null;
            }
            V v11 = (V) biFunction.apply(k11, vD);
            k(v11);
            return v11;
        }

        public long g() {
            return this.f39155c.d(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public V get() {
            return this.f39153a.get();
        }

        public final i0<V> h(Throwable th2) {
            return Futures.e(th2);
        }

        public s<K, V> i() {
            return this.f39153a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return this.f39153a.isActive();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return true;
        }

        public i0<V> j(K k11, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.f39155c.f();
                V v11 = this.f39153a.get();
                if (v11 == null) {
                    V vA = cacheLoader.a(k11);
                    return k(vA) ? this.f39154b : Futures.f(vA);
                }
                i0<V> i0VarB = cacheLoader.b(k11, v11);
                return i0VarB == null ? Futures.f(null) : Futures.g(i0VarB, new a(), MoreExecutors.a());
            } catch (Throwable th2) {
                i0<V> i0VarH = l(th2) ? this.f39154b : h(th2);
                if (th2 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return i0VarH;
            }
        }

        public boolean k(V v11) {
            return this.f39154b.set(v11);
        }

        public boolean l(Throwable th2) {
            return this.f39154b.setException(th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class l<K, V> extends SoftReference<V> implements s<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39157a;

        public l(ReferenceQueue<V> referenceQueue, V v11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            super(v11, referenceQueue);
            this.f39157a = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> a() {
            return this.f39157a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public int b() {
            return 1;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public void c(V v11) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public V d() {
            return get();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            return new l(referenceQueue, v11, kVar);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class m<K, V> extends o<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile long f39158f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39159g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39160h;

        public m(K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            super(k11, i11, kVar);
            this.f39158f = Long.MAX_VALUE;
            this.f39159g = LocalCache.u();
            this.f39160h = LocalCache.u();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getAccessTime() {
            return this.f39158f;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInAccessQueue() {
            return this.f39159g;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            return this.f39160h;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setAccessTime(long j11) {
            this.f39158f = j11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39159g = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39160h = kVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class n<K, V> extends o<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile long f39161f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39162g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39163h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile long f39164i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39165j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39166k;

        public n(K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            super(k11, i11, kVar);
            this.f39161f = Long.MAX_VALUE;
            this.f39162g = LocalCache.u();
            this.f39163h = LocalCache.u();
            this.f39164i = Long.MAX_VALUE;
            this.f39165j = LocalCache.u();
            this.f39166k = LocalCache.u();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getAccessTime() {
            return this.f39161f;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInAccessQueue() {
            return this.f39162g;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInWriteQueue() {
            return this.f39165j;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            return this.f39163h;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            return this.f39166k;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getWriteTime() {
            return this.f39164i;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setAccessTime(long j11) {
            this.f39161f = j11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39162g = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39165j = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39163h = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39166k = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setWriteTime(long j11) {
            this.f39164i = j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class o<K, V> extends d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f39167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f39168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39169c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile s<K, V> f39170d = LocalCache.H();

        public o(K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39167a = k11;
            this.f39168b = i11;
            this.f39169c = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public int getHash() {
            return this.f39168b;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public K getKey() {
            return this.f39167a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNext() {
            return this.f39169c;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public s<K, V> getValueReference() {
            return this.f39170d;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setValueReference(s<K, V> sVar) {
            this.f39170d = sVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class p<K, V> implements s<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V f39171a;

        public p(V v11) {
            this.f39171a = v11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> a() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public int b() {
            return 1;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public void c(V v11) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public V d() {
            return get();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            return this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public V get() {
            return this.f39171a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class q<K, V> extends o<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile long f39172f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39173g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39174h;

        public q(K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            super(k11, i11, kVar);
            this.f39172f = Long.MAX_VALUE;
            this.f39173g = LocalCache.u();
            this.f39174h = LocalCache.u();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInWriteQueue() {
            return this.f39173g;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            return this.f39174h;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getWriteTime() {
            return this.f39172f;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39173g = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39174h = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setWriteTime(long j11) {
            this.f39172f = j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class r extends LocalCache<K, V>.h<V> {
        public r() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface s<K, V> {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> a();

        int b();

        void c(V v11);

        V d() throws ExecutionException;

        s<K, V> e(ReferenceQueue<V> referenceQueue, V v11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar);

        V get();

        boolean isActive();

        boolean isLoading();
    }

    /* JADX INFO: compiled from: source.java */
    public final class t extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentMap<?, ?> f39176a;

        public t(ConcurrentMap<?, ?> concurrentMap) {
            this.f39176a = concurrentMap;
        }

        public static /* synthetic */ boolean b(Predicate predicate, Object obj, Object obj2) {
            return predicate.test(obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f39176a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f39176a.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f39176a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new r();
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super V> predicate) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(predicate);
            return LocalCache.this.E(new BiPredicate() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.j
                @Override // java.util.function.BiPredicate
                public final boolean test(Object obj, Object obj2) {
                    return LocalCache.t.b(predicate, obj, obj2);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f39176a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.G(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.G(this).toArray(eArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class u<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f39178d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39179f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39180g;

        public u(ReferenceQueue<K> referenceQueue, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            super(referenceQueue, k11, i11, kVar);
            this.f39178d = Long.MAX_VALUE;
            this.f39179f = LocalCache.u();
            this.f39180g = LocalCache.u();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getAccessTime() {
            return this.f39178d;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInAccessQueue() {
            return this.f39179f;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            return this.f39180g;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setAccessTime(long j11) {
            this.f39178d = j11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39179f = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39180g = kVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class v<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f39181d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39182f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39183g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile long f39184h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39185i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39186j;

        public v(ReferenceQueue<K> referenceQueue, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            super(referenceQueue, k11, i11, kVar);
            this.f39181d = Long.MAX_VALUE;
            this.f39182f = LocalCache.u();
            this.f39183g = LocalCache.u();
            this.f39184h = Long.MAX_VALUE;
            this.f39185i = LocalCache.u();
            this.f39186j = LocalCache.u();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getAccessTime() {
            return this.f39181d;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInAccessQueue() {
            return this.f39182f;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInWriteQueue() {
            return this.f39185i;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            return this.f39183g;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            return this.f39186j;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getWriteTime() {
            return this.f39184h;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setAccessTime(long j11) {
            this.f39181d = j11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39182f = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39185i = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39183g = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39186j = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setWriteTime(long j11) {
            this.f39184h = j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class w<K, V> extends WeakReference<K> implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f39187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile s<K, V> f39189c;

        public w(ReferenceQueue<K> referenceQueue, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            super(k11, referenceQueue);
            this.f39189c = LocalCache.H();
            this.f39187a = i11;
            this.f39188b = kVar;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public int getHash() {
            return this.f39187a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public K getKey() {
            return get();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNext() {
            return this.f39188b;
        }

        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public s<K, V> getValueReference() {
            return this.f39189c;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j11) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setValueReference(s<K, V> sVar) {
            this.f39189c = sVar;
        }

        public void setWriteTime(long j11) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class x<K, V> extends WeakReference<V> implements s<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39190a;

        public x(ReferenceQueue<V> referenceQueue, V v11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            super(v11, referenceQueue);
            this.f39190a = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> a() {
            return this.f39190a;
        }

        public int b() {
            return 1;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public void c(V v11) {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public V d() {
            return get();
        }

        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            return new x(referenceQueue, v11, kVar);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class y<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f39191d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39192f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> f39193g;

        public y(ReferenceQueue<K> referenceQueue, K k11, int i11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            super(referenceQueue, k11, i11, kVar);
            this.f39191d = Long.MAX_VALUE;
            this.f39192f = LocalCache.u();
            this.f39193g = LocalCache.u();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getNextInWriteQueue() {
            return this.f39192f;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> getPreviousInWriteQueue() {
            return this.f39193g;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public long getWriteTime() {
            return this.f39191d;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setNextInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39192f = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setPreviousInWriteQueue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            this.f39193g = kVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.w, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k
        public void setWriteTime(long j11) {
            this.f39191d = j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class z<K, V> extends l<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f39194b;

        public z(ReferenceQueue<V> referenceQueue, V v11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, int i11) {
            super(referenceQueue, v11, kVar);
            this.f39194b = i11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.l, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public int b() {
            return this.f39194b;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.l, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
            return new z(referenceQueue, v11, kVar, this.f39194b);
        }
    }

    public static int D(int i11) {
        int i12 = i11 + ((i11 << 15) ^ (-12931));
        int i13 = i12 ^ (i12 >>> 10);
        int i14 = i13 + (i13 << 3);
        int i15 = i14 ^ (i14 >>> 6);
        int i16 = i15 + (i15 << 2) + (i15 << 14);
        return i16 ^ (i16 >>> 16);
    }

    public static <E> ArrayList<E> G(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> s<K, V> H() {
        return (s<K, V>) f39102w;
    }

    public static <K, V> void f(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
        kVar.setNextInAccessQueue(kVar2);
        kVar2.setPreviousInAccessQueue(kVar);
    }

    public static <K, V> void g(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar2) {
        kVar.setNextInWriteQueue(kVar2);
        kVar2.setPreviousInWriteQueue(kVar);
    }

    public static <E> Queue<E> i() {
        return (Queue<E>) f39103x;
    }

    public static /* synthetic */ Object q(Function function, Object obj, Object obj2, Object obj3) {
        return obj3 == null ? function.apply(obj) : obj3;
    }

    public static /* synthetic */ Object r(BiFunction biFunction, Object obj, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        return biFunction.apply(obj, obj2);
    }

    public static /* synthetic */ Object s(Object obj, BiFunction biFunction, Object obj2, Object obj3) {
        return obj3 == null ? obj : biFunction.apply(obj3, obj);
    }

    public static <K, V> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> u() {
        return NullEntry.INSTANCE;
    }

    public static <K, V> void v(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarU = u();
        kVar.setNextInAccessQueue(kVarU);
        kVar.setPreviousInAccessQueue(kVarU);
    }

    public static <K, V> void w(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarU = u();
        kVar.setNextInWriteQueue(kVarU);
        kVar.setPreviousInWriteQueue(kVarU);
    }

    public boolean A() {
        return k();
    }

    public boolean B() {
        return l() || C();
    }

    public boolean C() {
        return this.f39115m > 0;
    }

    public boolean E(BiPredicate<? super K, ? super V> biPredicate) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biPredicate);
        boolean z11 = false;
        for (K k11 : keySet()) {
            while (true) {
                V v11 = get(k11);
                if (v11 == null || !biPredicate.test(k11, v11)) {
                    break;
                }
                if (remove(k11, v11)) {
                    z11 = true;
                    break;
                }
            }
        }
        return z11;
    }

    public Segment<K, V> F(int i11) {
        return this.f39106c[(i11 >>> this.f39105b) & this.f39104a];
    }

    public boolean I() {
        return k() || j();
    }

    public boolean J() {
        return this.f39109g != Strength.STRONG;
    }

    public boolean K() {
        return this.f39110h != Strength.STRONG;
    }

    public boolean L() {
        return l();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.f39106c) {
            segment.clear();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V compute(K k11, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biFunction);
        int iN = n(k11);
        return F(iN).compute(k11, iN, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfAbsent(final K k11, final Function<? super K, ? extends V> function) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(function);
        return compute(k11, new BiFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.f
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return LocalCache.q(function, k11, obj, obj2);
            }
        });
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfPresent(K k11, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biFunction);
        return compute(k11, new BiFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.e
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return LocalCache.r(biFunction, obj, obj2);
            }
        });
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iN = n(obj);
        return F(iN).containsKey(obj, iN);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        long jA = this.f39118p.a();
        Segment<K, V>[] segmentArr = this.f39106c;
        long j11 = -1;
        int i11 = 0;
        while (i11 < 3) {
            int length = segmentArr.length;
            long j12 = 0;
            int i12 = 0;
            while (i12 < length) {
                Segment<K, V> segment = segmentArr[i12];
                int i13 = segment.count;
                AtomicReferenceArray<com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V>> atomicReferenceArray = segment.table;
                for (int i14 = 0; i14 < atomicReferenceArray.length(); i14++) {
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> next = atomicReferenceArray.get(i14);
                    while (next != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(next, jA);
                        long j13 = jA;
                        if (liveValue != null && this.f39108f.equivalent(obj, liveValue)) {
                            return true;
                        }
                        next = next.getNext();
                        segmentArr = segmentArr2;
                        jA = j13;
                    }
                }
                j12 += (long) segment.modCount;
                i12++;
                jA = jA;
            }
            long j14 = jA;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j12 == j11) {
                return false;
            }
            i11++;
            j11 = j12;
            segmentArr = segmentArr3;
            jA = j14;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f39123u;
        if (set != null) {
            return set;
        }
        g gVar = new g(this);
        this.f39123u = gVar;
        return gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iN = n(obj);
        return F(iN).get(obj, iN);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V getOrDefault(Object obj, V v11) {
        V v12 = get(obj);
        return v12 != null ? v12 : v11;
    }

    public boolean h() {
        return this.f39112j != CacheBuilder$OneWeigher.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.f39106c;
        long j11 = 0;
        for (int i11 = 0; i11 < segmentArr.length; i11++) {
            if (segmentArr[i11].count != 0) {
                return false;
            }
            j11 += (long) segmentArr[i11].modCount;
        }
        if (j11 == 0) {
            return true;
        }
        for (int i12 = 0; i12 < segmentArr.length; i12++) {
            if (segmentArr[i12].count != 0) {
                return false;
            }
            j11 -= (long) segmentArr[i12].modCount;
        }
        return j11 == 0;
    }

    public boolean j() {
        return this.f39111i >= 0;
    }

    public boolean k() {
        return this.f39113k > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f39121s;
        if (set != null) {
            return set;
        }
        j jVar = new j(this);
        this.f39121s = jVar;
        return jVar;
    }

    public boolean l() {
        return this.f39114l > 0;
    }

    public V m(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, long j11) {
        V v11;
        if (kVar.getKey() == null || (v11 = kVar.getValueReference().get()) == null || p(kVar, j11)) {
            return null;
        }
        return v11;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V merge(K k11, final V v11, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biFunction);
        return compute(k11, new BiFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.g
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return LocalCache.s(v11, biFunction, obj, obj2);
            }
        });
    }

    public int n(Object obj) {
        return D(this.f39107d.hash(obj));
    }

    public boolean p(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar, long j11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(kVar);
        if (!k() || j11 - kVar.getAccessTime() < this.f39113k) {
            return l() && j11 - kVar.getWriteTime() >= this.f39114l;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v11);
        int iN = n(k11);
        return F(iN).put(k11, iN, v11, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k11, V v11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v11);
        int iN = n(k11);
        return F(iN).put(k11, iN, v11, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iN = n(obj);
        return F(iN).remove(obj, iN);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iN = n(obj);
        return F(iN).remove(obj, iN, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k11, V v11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v11);
        int iN = n(k11);
        return F(iN).replace(k11, iN, v11);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k11, V v11, V v12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(k11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v12);
        if (v11 == null) {
            return false;
        }
        int iN = n(k11);
        return F(iN).replace(k11, iN, v11, v12);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.i(t());
    }

    public long t() {
        long jMax = 0;
        for (Segment<K, V> segment : this.f39106c) {
            jMax += (long) Math.max(0, segment.count);
        }
        return jMax;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f39122t;
        if (collection != null) {
            return collection;
        }
        t tVar = new t(this);
        this.f39122t = tVar;
        return tVar;
    }

    public void x() {
        while (true) {
            RemovalNotification<K, V> removalNotificationPoll = this.f39116n.poll();
            if (removalNotificationPoll == null) {
                return;
            }
            try {
                this.f39117o.a(removalNotificationPoll);
            } catch (Throwable th2) {
                f39101v.log(Level.WARNING, "Exception thrown by removal listener", th2);
            }
        }
    }

    public void y(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVar) {
        int hash = kVar.getHash();
        F(hash).reclaimKey(kVar, hash);
    }

    public void z(s<K, V> sVar) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.k<K, V> kVarA = sVar.a();
        int hash = kVarA.getHash();
        F(hash).reclaimValue(kVarA.getKey(), hash, sVar);
    }
}
