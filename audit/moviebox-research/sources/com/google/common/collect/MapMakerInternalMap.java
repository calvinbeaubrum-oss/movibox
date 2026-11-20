package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.h;
import com.google.common.primitives.Ints;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class MapMakerInternalMap<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final v<Object, Object, d> UNSET_WEAK_VALUE_REFERENCE = new a();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient i<K, V, E, S> entryHelper;
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;
    transient Collection<V> values;

    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractSerializationProxy<K, V> extends com.google.common.collect.s<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        public AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i11, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i11;
            this.delegate = concurrentMap;
        }

        @Override // com.google.common.collect.s, com.google.common.collect.u, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public ConcurrentMap<K, V> u() {
            return this.delegate;
        }

        public void readEntries(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            while (true) {
                Object object = objectInputStream.readObject();
                if (object == null) {
                    return;
                }
                this.delegate.put((K) object, (V) objectInputStream.readObject());
            }
        }

        public MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().g(objectInputStream.readInt()).j(this.keyStrength).k(this.valueStrength).h(this.keyEquivalence).a(this.concurrencyLevel);
        }

        public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class CleanupMapTask implements Runnable {
        final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> mapReference;

        public CleanupMapTask(MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap) {
            this.mapReference = new WeakReference<>(mapMakerInternalMap);
        }

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap = this.mapReference.get();
            if (mapMakerInternalMap == null) {
                throw new CancellationException();
            }
            for (Segment<?, ?, E, S> segment : mapMakerInternalMap.segments) {
                segment.runCleanup();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class Segment<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;

        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        volatile AtomicReferenceArray<E> table;
        int threshold;

        public Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i11) {
            this.map = mapMakerInternalMap;
            initTable(newEntryArray(i11));
        }

        public static <K, V, E extends h<K, V, E>> boolean isCollected(E e11) {
            return e11.getValue() == null;
        }

        public abstract E castForTesting(h<K, V, ?> hVar);

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i11 = 0; i11 < atomicReferenceArray.length(); i11++) {
                        atomicReferenceArray.set(i11, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        public boolean clearValueForTesting(K k11, int i11, v<K, V, ? extends h<K, V, ?>> vVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                E e11 = atomicReferenceArray.get(length);
                for (h next = e11; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.keyEquivalence.equivalent(k11, key)) {
                        if (((u) next).getValueReference() != vVar) {
                            return false;
                        }
                        atomicReferenceArray.set(length, (E) removeFromChain(e11, next));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public boolean containsKey(Object obj, int i11) {
            try {
                boolean z11 = false;
                if (this.count == 0) {
                    return false;
                }
                h liveEntry = getLiveEntry(obj, i11);
                if (liveEntry != null && liveEntry.getValue() != null) {
                    z11 = true;
                }
                return z11;
            } finally {
                postReadCleanup();
            }
        }

        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i11 = 0; i11 < length; i11++) {
                        for (E next = atomicReferenceArray.get(i11); next != null; next = next.getNext()) {
                            V liveValue = getLiveValue(next);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
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

        public E copyEntry(E e11, E e12) {
            return (E) this.map.entryHelper.d(self(), e11, e12);
        }

        public E copyForTesting(h<K, V, ?> hVar, h<K, V, ?> hVar2) {
            return (E) this.map.entryHelper.d(self(), castForTesting(hVar), castForTesting(hVar2));
        }

        public void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i11 = 0;
            do {
                Reference<? extends K> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.reclaimKey((h) referencePoll);
                i11++;
            } while (i11 != 16);
        }

        public void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i11 = 0;
            do {
                Reference<? extends V> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.reclaimValue((v) referencePoll);
                i11++;
            } while (i11 != 16);
        }

        public void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i11 = this.count;
            AtomicReferenceArray<E> atomicReferenceArrayNewEntryArray = newEntryArray(length << 1);
            this.threshold = (atomicReferenceArrayNewEntryArray.length() * 3) / 4;
            int length2 = atomicReferenceArrayNewEntryArray.length() - 1;
            for (int i12 = 0; i12 < length; i12++) {
                E next = atomicReferenceArray.get(i12);
                if (next != null) {
                    h next2 = next.getNext();
                    int hash = next.getHash() & length2;
                    if (next2 == null) {
                        atomicReferenceArrayNewEntryArray.set(hash, next);
                    } else {
                        h hVar = next;
                        while (next2 != null) {
                            int hash2 = next2.getHash() & length2;
                            if (hash2 != hash) {
                                hVar = next2;
                                hash = hash2;
                            }
                            next2 = next2.getNext();
                        }
                        atomicReferenceArrayNewEntryArray.set(hash, hVar);
                        while (next != hVar) {
                            int hash3 = next.getHash() & length2;
                            h hVarCopyEntry = copyEntry(next, (h) atomicReferenceArrayNewEntryArray.get(hash3));
                            if (hVarCopyEntry != null) {
                                atomicReferenceArrayNewEntryArray.set(hash3, hVarCopyEntry);
                            } else {
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

        public V get(Object obj, int i11) {
            try {
                h liveEntry = getLiveEntry(obj, i11);
                if (liveEntry == null) {
                    return null;
                }
                V v11 = (V) liveEntry.getValue();
                if (v11 == null) {
                    tryDrainReferenceQueues();
                }
                return v11;
            } finally {
                postReadCleanup();
            }
        }

        public E getEntry(Object obj, int i11) {
            if (this.count == 0) {
                return null;
            }
            for (E e11 = (E) getFirst(i11); e11 != null; e11 = (E) e11.getNext()) {
                if (e11.getHash() == i11) {
                    Object key = e11.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return e11;
                    }
                }
            }
            return null;
        }

        public E getFirst(int i11) {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i11 & (atomicReferenceArray.length() - 1));
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public E getLiveEntry(Object obj, int i11) {
            return (E) getEntry(obj, i11);
        }

        public V getLiveValue(E e11) {
            if (e11.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v11 = (V) e11.getValue();
            if (v11 != null) {
                return v11;
            }
            tryDrainReferenceQueues();
            return null;
        }

        public V getLiveValueForTesting(h<K, V, ?> hVar) {
            return getLiveValue(castForTesting(hVar));
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public v<K, V, E> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            this.table = atomicReferenceArray;
        }

        public void maybeClearReferenceQueues() {
        }

        public void maybeDrainReferenceQueues() {
        }

        public AtomicReferenceArray<E> newEntryArray(int i11) {
            return new AtomicReferenceArray<>(i11);
        }

        public E newEntryForTesting(K k11, int i11, h<K, V, ?> hVar) {
            return (E) this.map.entryHelper.f(self(), k11, i11, castForTesting(hVar));
        }

        public v<K, V, E> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v11) {
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & MapMakerInternalMap.DRAIN_THRESHOLD) == 0) {
                runCleanup();
            }
        }

        public void preWriteCleanup() {
            runLockedCleanup();
        }

        public V put(K k11, int i11, V v11, boolean z11) {
            lock();
            try {
                preWriteCleanup();
                int i12 = this.count + 1;
                if (i12 > this.threshold) {
                    expand();
                    i12 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                E e11 = atomicReferenceArray.get(length);
                for (h next = e11; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.keyEquivalence.equivalent(k11, key)) {
                        V v12 = (V) next.getValue();
                        if (v12 == null) {
                            this.modCount++;
                            setValue(next, v11);
                            this.count = this.count;
                            return null;
                        }
                        if (z11) {
                            return v12;
                        }
                        this.modCount++;
                        setValue(next, v11);
                        return v12;
                    }
                }
                this.modCount++;
                h hVarF = this.map.entryHelper.f(self(), k11, i11, e11);
                setValue(hVarF, v11);
                atomicReferenceArray.set(length, (E) hVarF);
                this.count = i12;
                return null;
            } finally {
                unlock();
            }
        }

        public boolean reclaimKey(E e11, int i11) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i11 & (atomicReferenceArray.length() - 1);
                E e12 = atomicReferenceArray.get(length);
                for (h next = e12; next != null; next = next.getNext()) {
                    if (next == e11) {
                        this.modCount++;
                        h hVarRemoveFromChain = removeFromChain(e12, next);
                        int i12 = this.count - 1;
                        atomicReferenceArray.set(length, (E) hVarRemoveFromChain);
                        this.count = i12;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public boolean reclaimValue(K k11, int i11, v<K, V, E> vVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                E e11 = atomicReferenceArray.get(length);
                for (h next = e11; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.keyEquivalence.equivalent(k11, key)) {
                        if (((u) next).getValueReference() != vVar) {
                            return false;
                        }
                        this.modCount++;
                        h hVarRemoveFromChain = removeFromChain(e11, next);
                        int i12 = this.count - 1;
                        atomicReferenceArray.set(length, (E) hVarRemoveFromChain);
                        this.count = i12;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public V remove(Object obj, int i11) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                E e11 = atomicReferenceArray.get(length);
                for (h next = e11; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v11 = (V) next.getValue();
                        if (v11 == null && !isCollected(next)) {
                            return null;
                        }
                        this.modCount++;
                        h hVarRemoveFromChain = removeFromChain(e11, next);
                        int i12 = this.count - 1;
                        atomicReferenceArray.set(length, (E) hVarRemoveFromChain);
                        this.count = i12;
                        return v11;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        public boolean remove(Object obj, int i11, Object obj2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                E e11 = atomicReferenceArray.get(length);
                h next = e11;
                while (true) {
                    boolean z11 = false;
                    if (next == null) {
                        return false;
                    }
                    Object key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        if (this.map.valueEquivalence().equivalent(obj2, next.getValue())) {
                            z11 = true;
                        } else if (!isCollected(next)) {
                            return false;
                        }
                        this.modCount++;
                        h hVarRemoveFromChain = removeFromChain(e11, next);
                        int i12 = this.count - 1;
                        atomicReferenceArray.set(length, (E) hVarRemoveFromChain);
                        this.count = i12;
                        return z11;
                    }
                    next = next.getNext();
                }
            } finally {
                unlock();
            }
        }

        public boolean removeEntryForTesting(E e11) {
            int hash = e11.getHash();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            E e12 = atomicReferenceArray.get(length);
            for (h next = e12; next != null; next = next.getNext()) {
                if (next == e11) {
                    this.modCount++;
                    h hVarRemoveFromChain = removeFromChain(e12, next);
                    int i11 = this.count - 1;
                    atomicReferenceArray.set(length, (E) hVarRemoveFromChain);
                    this.count = i11;
                    return true;
                }
            }
            return false;
        }

        public E removeFromChain(E e11, E e12) {
            int i11 = this.count;
            E e13 = (E) e12.getNext();
            while (e11 != e12) {
                h hVarCopyEntry = copyEntry(e11, e13);
                if (hVarCopyEntry != null) {
                    e13 = (E) hVarCopyEntry;
                } else {
                    i11--;
                }
                e11 = (E) e11.getNext();
            }
            this.count = i11;
            return e13;
        }

        public E removeFromChainForTesting(h<K, V, ?> hVar, h<K, V, ?> hVar2) {
            return (E) removeFromChain(castForTesting(hVar), castForTesting(hVar2));
        }

        public boolean removeTableEntryForTesting(h<K, V, ?> hVar) {
            return removeEntryForTesting(castForTesting(hVar));
        }

        public V replace(K k11, int i11, V v11) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                E e11 = atomicReferenceArray.get(length);
                for (h next = e11; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.keyEquivalence.equivalent(k11, key)) {
                        V v12 = (V) next.getValue();
                        if (v12 != null) {
                            this.modCount++;
                            setValue(next, v11);
                            return v12;
                        }
                        if (isCollected(next)) {
                            this.modCount++;
                            h hVarRemoveFromChain = removeFromChain(e11, next);
                            int i12 = this.count - 1;
                            atomicReferenceArray.set(length, (E) hVarRemoveFromChain);
                            this.count = i12;
                        }
                        return null;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        public boolean replace(K k11, int i11, V v11, V v12) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                E e11 = atomicReferenceArray.get(length);
                for (h next = e11; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i11 && key != null && this.map.keyEquivalence.equivalent(k11, key)) {
                        Object value = next.getValue();
                        if (value != null) {
                            if (!this.map.valueEquivalence().equivalent(v11, value)) {
                                return false;
                            }
                            this.modCount++;
                            setValue(next, v12);
                            return true;
                        }
                        if (isCollected(next)) {
                            this.modCount++;
                            h hVarRemoveFromChain = removeFromChain(e11, next);
                            int i12 = this.count - 1;
                            atomicReferenceArray.set(length, (E) hVarRemoveFromChain);
                            this.count = i12;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S self();

        public void setTableEntryForTesting(int i11, h<K, V, ?> hVar) {
            this.table.set(i11, (E) castForTesting(hVar));
        }

        public void setValue(E e11, V v11) {
            this.map.entryHelper.e(self(), e11, v11);
        }

        public void setValueForTesting(h<K, V, ?> hVar, V v11) {
            this.map.entryHelper.e(self(), castForTesting(hVar), v11);
        }

        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            throw new AssertionError();
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        public SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i11, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i11, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).i();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* synthetic */ Strength(a aVar) {
            this();
        }

        public abstract Equivalence<Object> defaultEquivalence();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {
        public StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m<K> castForTesting(h<K, MapMaker.Dummy, ?> hVar) {
            return (m) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public n<K, V> castForTesting(h<K, V, ?> hVar) {
            return (n) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public o<K, V> castForTesting(h<K, V, ?> hVar) {
            return (o) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            return castForTesting((h) hVar).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v11) {
            return new w(this.queueForValues, v11, castForTesting((h) hVar));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            o<K, V> oVarCastForTesting = castForTesting((h) hVar);
            v vVar2 = oVarCastForTesting.f38497c;
            oVarCastForTesting.f38497c = vVar;
            vVar2.clear();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public r<K> castForTesting(h<K, MapMaker.Dummy, ?> hVar) {
            return (r) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public s<K, V> castForTesting(h<K, V, ?> hVar) {
            return (s) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public t<K, V> castForTesting(h<K, V, ?> hVar) {
            return (t) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            return castForTesting((h) hVar).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v11) {
            return new w(this.queueForValues, v11, castForTesting((h) hVar));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            t<K, V> tVarCastForTesting = castForTesting((h) hVar);
            v vVar2 = tVarCastForTesting.f38506b;
            tVarCastForTesting.f38506b = vVar;
            vVar2.clear();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements v<Object, Object, d> {
        @Override // com.google.common.collect.MapMakerInternalMap.v
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public v<Object, Object, d> b(ReferenceQueue<Object> referenceQueue, d dVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public d a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b<K, V, E extends h<K, V, E>> implements h<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f38479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f38480b;

        public b(K k11, int i11) {
            this.f38479a = k11;
            this.f38480b = i11;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final int getHash() {
            return this.f38480b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final K getKey() {
            return this.f38479a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c<K, V, E extends h<K, V, E>> extends WeakReference<K> implements h<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38481a;

        public c(ReferenceQueue<K> referenceQueue, K k11, int i11) {
            super(k11, referenceQueue);
            this.f38481a = i11;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final int getHash() {
            return this.f38481a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements h<Object, Object, d> {
        public d() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class e extends MapMakerInternalMap<K, V, E, S>.g<Map.Entry<K, V>> {
        public e(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class f extends l<Map.Entry<K, V>> {
        public f() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class g<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38484b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Segment<K, V, E, S> f38485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AtomicReferenceArray<E> f38486d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public E f38487f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public MapMakerInternalMap<K, V, E, S>.x f38488g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public MapMakerInternalMap<K, V, E, S>.x f38489h;

        public g() {
            this.f38483a = MapMakerInternalMap.this.segments.length - 1;
            a();
        }

        public final void a() {
            this.f38488g = null;
            if (d() || f()) {
                return;
            }
            while (true) {
                int i11 = this.f38483a;
                if (i11 < 0) {
                    return;
                }
                Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                this.f38483a = i11 - 1;
                Segment<K, V, E, S> segment = segmentArr[i11];
                this.f38485c = segment;
                if (segment.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f38485c.table;
                    this.f38486d = atomicReferenceArray;
                    this.f38484b = atomicReferenceArray.length() - 1;
                    if (f()) {
                        return;
                    }
                }
            }
        }

        public boolean b(E e11) {
            Segment<K, V, E, S> segment;
            try {
                Object key = e11.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(e11);
                if (liveValue == null) {
                    return false;
                }
                this.f38488g = new x(key, liveValue);
                return true;
            } finally {
                this.f38485c.postReadCleanup();
            }
        }

        public MapMakerInternalMap<K, V, E, S>.x c() {
            MapMakerInternalMap<K, V, E, S>.x xVar = this.f38488g;
            if (xVar == null) {
                throw new NoSuchElementException();
            }
            this.f38489h = xVar;
            a();
            return this.f38489h;
        }

        public boolean d() {
            E e11 = this.f38487f;
            if (e11 == null) {
                return false;
            }
            while (true) {
                this.f38487f = (E) e11.getNext();
                E e12 = this.f38487f;
                if (e12 == null) {
                    return false;
                }
                if (b(e12)) {
                    return true;
                }
                e11 = this.f38487f;
            }
        }

        public boolean f() {
            while (true) {
                int i11 = this.f38484b;
                if (i11 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f38486d;
                this.f38484b = i11 - 1;
                E e11 = atomicReferenceArray.get(i11);
                this.f38487f = e11;
                if (e11 != null && (b(e11) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38488g != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.l.e(this.f38489h != null);
            MapMakerInternalMap.this.remove(this.f38489h.getKey());
            this.f38489h = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface h<K, V, E extends h<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    /* JADX INFO: compiled from: source.java */
    public interface i<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> {
        Strength a();

        Strength b();

        S c(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i11);

        E d(S s11, E e11, E e12);

        void e(S s11, E e11, V v11);

        E f(S s11, K k11, int i11, E e11);
    }

    /* JADX INFO: compiled from: source.java */
    public final class j extends MapMakerInternalMap<K, V, E, S>.g<K> {
        public j(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class k extends l<K> {
        public k() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new j(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class l<E> extends AbstractSet<E> {
        public l() {
        }

        public /* synthetic */ l(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.a(this).toArray(tArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class m<K> extends b<K, MapMaker.Dummy, m<K>> {

        /* JADX INFO: compiled from: source.java */
        public static final class a<K> implements i<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?> f38492a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f38492a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public m<K> d(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, m<K> mVar, m<K> mVar2) {
                return f(strongKeyDummyValueSegment, mVar.f38479a, mVar.f38480b, mVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public m<K> f(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k11, int i11, m<K> mVar) {
                return mVar == null ? new m<>(k11, i11, null) : new b(k11, i11, mVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyDummyValueSegment<K> c(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i11) {
                return new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void e(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, m<K> mVar, MapMaker.Dummy dummy) {
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class b<K> extends m<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final m<K> f38493c;

            public b(K k11, int i11, m<K> mVar) {
                super(k11, i11, null);
                this.f38493c = mVar;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.h
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public m<K> getNext() {
                return this.f38493c;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.m, com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ Object getValue() {
                return super.getValue();
            }
        }

        public m(K k11, int i11) {
            super(k11, i11);
        }

        public /* synthetic */ m(Object obj, int i11, a aVar) {
            this(obj, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class n<K, V> extends b<K, V, n<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile V f38494c;

        /* JADX INFO: compiled from: source.java */
        public static final class a<K, V> implements i<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f38495a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f38495a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public n<K, V> d(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, n<K, V> nVar, n<K, V> nVar2) {
                n<K, V> nVarF = f(strongKeyStrongValueSegment, nVar.f38479a, nVar.f38480b, nVar2);
                nVarF.f38494c = nVar.f38494c;
                return nVarF;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public n<K, V> f(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k11, int i11, n<K, V> nVar) {
                return nVar == null ? new n<>(k11, i11, null) : new b(k11, i11, nVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyStrongValueSegment<K, V> c(MapMakerInternalMap<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i11) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void e(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, n<K, V> nVar, V v11) {
                nVar.f38494c = v11;
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class b<K, V> extends n<K, V> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final n<K, V> f38496d;

            public b(K k11, int i11, n<K, V> nVar) {
                super(k11, i11, null);
                this.f38496d = nVar;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.h
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public n<K, V> getNext() {
                return this.f38496d;
            }
        }

        public n(K k11, int i11) {
            super(k11, i11);
            this.f38494c = null;
        }

        public /* synthetic */ n(Object obj, int i11, a aVar) {
            this(obj, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final V getValue() {
            return this.f38494c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class o<K, V> extends b<K, V, o<K, V>> implements u<K, V, o<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile v<K, V, o<K, V>> f38497c;

        /* JADX INFO: compiled from: source.java */
        public static final class a<K, V> implements i<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f38498a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f38498a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public o<K, V> d(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, o<K, V> oVar, o<K, V> oVar2) {
                if (Segment.isCollected(oVar)) {
                    return null;
                }
                o<K, V> oVarF = f(strongKeyWeakValueSegment, oVar.f38479a, oVar.f38480b, oVar2);
                oVarF.f38497c = oVar.f38497c.b(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, oVarF);
                return oVarF;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public o<K, V> f(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k11, int i11, o<K, V> oVar) {
                return oVar == null ? new o<>(k11, i11, null) : new b(k11, i11, oVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyWeakValueSegment<K, V> c(MapMakerInternalMap<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i11) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void e(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, o<K, V> oVar, V v11) {
                v vVar = oVar.f38497c;
                oVar.f38497c = new w(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, v11, oVar);
                vVar.clear();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class b<K, V> extends o<K, V> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final o<K, V> f38499d;

            public b(K k11, int i11, o<K, V> oVar) {
                super(k11, i11, null);
                this.f38499d = oVar;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.h
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public o<K, V> getNext() {
                return this.f38499d;
            }
        }

        public o(K k11, int i11) {
            super(k11, i11);
            this.f38497c = MapMakerInternalMap.unsetWeakValueReference();
        }

        public /* synthetic */ o(Object obj, int i11, a aVar) {
            this(obj, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final V getValue() {
            return this.f38497c.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public final v<K, V, o<K, V>> getValueReference() {
            return this.f38497c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class p extends MapMakerInternalMap<K, V, E, S>.g<V> {
        public p(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class q extends AbstractCollection<V> {
        public q() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new p(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.a(this).toArray(tArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class r<K> extends c<K, MapMaker.Dummy, r<K>> {

        /* JADX INFO: compiled from: source.java */
        public static final class a<K> implements i<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?> f38501a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f38501a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public r<K> d(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, r<K> rVar, r<K> rVar2) {
                K key = rVar.getKey();
                if (key == null) {
                    return null;
                }
                return f(weakKeyDummyValueSegment, key, rVar.f38481a, rVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public r<K> f(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k11, int i11, r<K> rVar) {
                return rVar == null ? new r<>(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k11, i11, null) : new b(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k11, i11, rVar, null);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyDummyValueSegment<K> c(MapMakerInternalMap<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i11) {
                return new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void e(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, r<K> rVar, MapMaker.Dummy dummy) {
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class b<K> extends r<K> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final r<K> f38502b;

            public b(ReferenceQueue<K> referenceQueue, K k11, int i11, r<K> rVar) {
                super(referenceQueue, k11, i11, null);
                this.f38502b = rVar;
            }

            public /* synthetic */ b(ReferenceQueue referenceQueue, Object obj, int i11, r rVar, a aVar) {
                this(referenceQueue, obj, i11, rVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.c, com.google.common.collect.MapMakerInternalMap.h
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public r<K> getNext() {
                return this.f38502b;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.r, com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ Object getValue() {
                return super.getValue();
            }
        }

        public r(ReferenceQueue<K> referenceQueue, K k11, int i11) {
            super(referenceQueue, k11, i11);
        }

        public /* synthetic */ r(ReferenceQueue referenceQueue, Object obj, int i11, a aVar) {
            this(referenceQueue, obj, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class s<K, V> extends c<K, V, s<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile V f38503b;

        /* JADX INFO: compiled from: source.java */
        public static final class a<K, V> implements i<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f38504a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f38504a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public s<K, V> d(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, s<K, V> sVar, s<K, V> sVar2) {
                K key = sVar.getKey();
                if (key == null) {
                    return null;
                }
                s<K, V> sVarF = f(weakKeyStrongValueSegment, key, sVar.f38481a, sVar2);
                sVarF.f38503b = sVar.f38503b;
                return sVarF;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public s<K, V> f(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k11, int i11, s<K, V> sVar) {
                return sVar == null ? new s<>(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k11, i11, null) : new b(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k11, i11, sVar, null);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyStrongValueSegment<K, V> c(MapMakerInternalMap<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i11) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void e(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, s<K, V> sVar, V v11) {
                sVar.f38503b = v11;
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class b<K, V> extends s<K, V> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final s<K, V> f38505c;

            public b(ReferenceQueue<K> referenceQueue, K k11, int i11, s<K, V> sVar) {
                super(referenceQueue, k11, i11, null);
                this.f38505c = sVar;
            }

            public /* synthetic */ b(ReferenceQueue referenceQueue, Object obj, int i11, s sVar, a aVar) {
                this(referenceQueue, obj, i11, sVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.c, com.google.common.collect.MapMakerInternalMap.h
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public s<K, V> getNext() {
                return this.f38505c;
            }
        }

        public s(ReferenceQueue<K> referenceQueue, K k11, int i11) {
            super(referenceQueue, k11, i11);
            this.f38503b = null;
        }

        public /* synthetic */ s(ReferenceQueue referenceQueue, Object obj, int i11, a aVar) {
            this(referenceQueue, obj, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final V getValue() {
            return this.f38503b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class t<K, V> extends c<K, V, t<K, V>> implements u<K, V, t<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile v<K, V, t<K, V>> f38506b;

        /* JADX INFO: compiled from: source.java */
        public static final class a<K, V> implements i<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f38507a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f38507a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength a() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public t<K, V> d(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, t<K, V> tVar, t<K, V> tVar2) {
                K key = tVar.getKey();
                if (key == null || Segment.isCollected(tVar)) {
                    return null;
                }
                t<K, V> tVarF = f(weakKeyWeakValueSegment, key, tVar.f38481a, tVar2);
                tVarF.f38506b = tVar.f38506b.b(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, tVarF);
                return tVarF;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public t<K, V> f(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k11, int i11, t<K, V> tVar) {
                return tVar == null ? new t<>(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k11, i11) : new b(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k11, i11, tVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyWeakValueSegment<K, V> c(MapMakerInternalMap<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i11) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void e(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, t<K, V> tVar, V v11) {
                v vVar = tVar.f38506b;
                tVar.f38506b = new w(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, v11, tVar);
                vVar.clear();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class b<K, V> extends t<K, V> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final t<K, V> f38508c;

            public b(ReferenceQueue<K> referenceQueue, K k11, int i11, t<K, V> tVar) {
                super(referenceQueue, k11, i11);
                this.f38508c = tVar;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.c, com.google.common.collect.MapMakerInternalMap.h
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public t<K, V> getNext() {
                return this.f38508c;
            }
        }

        public t(ReferenceQueue<K> referenceQueue, K k11, int i11) {
            super(referenceQueue, k11, i11);
            this.f38506b = MapMakerInternalMap.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final V getValue() {
            return this.f38506b.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public final v<K, V, t<K, V>> getValueReference() {
            return this.f38506b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface u<K, V, E extends h<K, V, E>> extends h<K, V, E> {
        v<K, V, E> getValueReference();
    }

    /* JADX INFO: compiled from: source.java */
    public interface v<K, V, E extends h<K, V, E>> {
        E a();

        v<K, V, E> b(ReferenceQueue<V> referenceQueue, E e11);

        void clear();

        V get();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class w<K, V, E extends h<K, V, E>> extends WeakReference<V> implements v<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final E f38509a;

        public w(ReferenceQueue<V> referenceQueue, V v11, E e11) {
            super(v11, referenceQueue);
            this.f38509a = e11;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public E a() {
            return this.f38509a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public v<K, V, E> b(ReferenceQueue<V> referenceQueue, E e11) {
            return new w(referenceQueue, get(), e11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class x extends com.google.common.collect.b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f38510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f38511b;

        public x(K k11, V v11) {
            this.f38510a = k11;
            this.f38511b = v11;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f38510a.equals(entry.getKey()) && this.f38511b.equals(entry.getValue());
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f38510a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return this.f38511b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public int hashCode() {
            return this.f38510a.hashCode() ^ this.f38511b.hashCode();
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v11) {
            V v12 = (V) MapMakerInternalMap.this.put(this.f38510a, v11);
            this.f38511b = v11;
            return v12;
        }
    }

    public MapMakerInternalMap(MapMaker mapMaker, i<K, V, E, S> iVar) {
        this.concurrencyLevel = Math.min(mapMaker.b(), 65536);
        this.keyEquivalence = mapMaker.d();
        this.entryHelper = iVar;
        int iMin = Math.min(mapMaker.c(), 1073741824);
        int i11 = 0;
        int i12 = 1;
        int i13 = 1;
        int i14 = 0;
        while (i13 < this.concurrencyLevel) {
            i14++;
            i13 <<= 1;
        }
        this.segmentShift = 32 - i14;
        this.segmentMask = i13 - 1;
        this.segments = newSegmentArray(i13);
        int i15 = iMin / i13;
        while (i12 < (i13 * i15 < iMin ? i15 + 1 : i15)) {
            i12 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i11 >= segmentArr.length) {
                return;
            }
            segmentArr[i11] = createSegment(i12);
            i11++;
        }
    }

    public static <E> ArrayList<E> a(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends h<K, V, ?>, ?> create(MapMaker mapMaker) {
        Strength strengthE = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (strengthE == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, n.a.h());
        }
        if (mapMaker.e() == strength && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, o.a.h());
        }
        Strength strengthE2 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (strengthE2 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, s.a.h());
        }
        if (mapMaker.e() == strength2 && mapMaker.f() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, t.a.h());
        }
        throw new AssertionError();
    }

    public static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends h<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        Strength strengthE = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (strengthE == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, m.a.h());
        }
        Strength strengthE2 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (strengthE2 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, r.a.h());
        }
        if (mapMaker.f() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    public static int rehash(int i11) {
        int i12 = i11 + ((i11 << 15) ^ (-12931));
        int i13 = i12 ^ (i12 >>> 10);
        int i14 = i13 + (i13 << 3);
        int i15 = i14 ^ (i14 >>> 6);
        int i16 = i15 + (i15 << 2) + (i15 << 14);
        return i16 ^ (i16 >>> 16);
    }

    public static <K, V, E extends h<K, V, E>> v<K, V, E> unsetWeakValueReference() {
        return (v<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).containsKey(obj, iHash);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j11 = -1;
        int i11 = 0;
        while (i11 < 3) {
            long j12 = 0;
            for (Segment<K, V, E, S> segment : segmentArr) {
                int i12 = segment.count;
                AtomicReferenceArray<E> atomicReferenceArray = segment.table;
                for (int i13 = 0; i13 < atomicReferenceArray.length(); i13++) {
                    for (E next = atomicReferenceArray.get(i13); next != null; next = next.getNext()) {
                        V liveValue = segment.getLiveValue(next);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j12 += (long) segment.modCount;
            }
            if (j12 == j11) {
                return false;
            }
            i11++;
            j11 = j12;
        }
        return false;
    }

    public E copyEntry(E e11, E e12) {
        return (E) segmentFor(e11.getHash()).copyEntry(e11, e12);
    }

    public Segment<K, V, E, S> createSegment(int i11) {
        return this.entryHelper.c(this, i11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.entrySet = fVar;
        return fVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).get(obj, iHash);
    }

    public E getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return (E) segmentFor(iHash).getEntry(obj, iHash);
    }

    public V getLiveValue(E e11) {
        if (e11.getKey() == null) {
            return null;
        }
        return (V) e11.getValue();
    }

    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
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

    public boolean isLiveForTesting(h<K, V, ?> hVar) {
        return segmentFor(hVar.getHash()).getLiveValueForTesting(hVar) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        k kVar = new k();
        this.keySet = kVar;
        return kVar;
    }

    public Strength keyStrength() {
        return this.entryHelper.b();
    }

    public final Segment<K, V, E, S>[] newSegmentArray(int i11) {
        return new Segment[i11];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        com.google.common.base.m.p(k11);
        com.google.common.base.m.p(v11);
        int iHash = hash(k11);
        return segmentFor(iHash).put(k11, iHash, v11, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k11, V v11) {
        com.google.common.base.m.p(k11);
        com.google.common.base.m.p(v11);
        int iHash = hash(k11);
        return segmentFor(iHash).put(k11, iHash, v11, true);
    }

    public void reclaimKey(E e11) {
        int hash = e11.getHash();
        segmentFor(hash).reclaimKey(e11, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reclaimValue(v<K, V, E> vVar) {
        h hVarA = vVar.a();
        int hash = hVarA.getHash();
        segmentFor(hash).reclaimValue(hVarA.getKey(), hash, vVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).remove(obj, iHash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).remove(obj, iHash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k11, V v11) {
        com.google.common.base.m.p(k11);
        com.google.common.base.m.p(v11);
        int iHash = hash(k11);
        return segmentFor(iHash).replace(k11, iHash, v11);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k11, V v11, V v12) {
        com.google.common.base.m.p(k11);
        com.google.common.base.m.p(v12);
        if (v11 == null) {
            return false;
        }
        int iHash = hash(k11);
        return segmentFor(iHash).replace(k11, iHash, v11, v12);
    }

    public Segment<K, V, E, S> segmentFor(int i11) {
        return this.segments[(i11 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j11 = 0;
        for (Segment<K, V, E, S> segment : this.segments) {
            j11 += (long) segment.count;
        }
        return Ints.l(j11);
    }

    public Equivalence<Object> valueEquivalence() {
        return this.entryHelper.a().defaultEquivalence();
    }

    public Strength valueStrength() {
        return this.entryHelper.a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        q qVar = new q();
        this.values = qVar;
        return qVar;
    }

    public Object writeReplace() {
        return new SerializationProxy(this.entryHelper.b(), this.entryHelper.a(), this.keyEquivalence, this.entryHelper.a().defaultEquivalence(), this.concurrencyLevel, this);
    }
}
