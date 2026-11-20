package com.google.common.collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private final boolean accessOrder;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient int f38295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public transient int f38296j;
    transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public CompactLinkedHashMap(int i11) {
        this(i11, false);
    }

    public CompactLinkedHashMap(int i11, boolean z11) {
        super(i11);
        this.accessOrder = z11;
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i11) {
        return new CompactLinkedHashMap<>(i11);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int i11) {
        if (this.accessOrder) {
            x(s(i11), getSuccessor(i11));
            x(this.f38296j, i11);
            x(i11, -2);
            incrementModCount();
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int i11, int i12) {
        return i11 >= size() ? i12 : i11;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int allocArrays() {
        int iAllocArrays = super.allocArrays();
        this.links = new long[iAllocArrays];
        return iAllocArrays;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.f38295i = -2;
        this.f38296j = -2;
        long[] jArr = this.links;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> mapConvertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return mapConvertToHashFloodingResistantImplementation;
    }

    @Override // com.google.common.collect.CompactHashMap
    public Map<K, V> createHashFloodingResistantDelegate(int i11) {
        return new LinkedHashMap(i11, 1.0f, this.accessOrder);
    }

    @Override // com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        return this.f38295i;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int getSuccessor(int i11) {
        return ((int) t(i11)) - 1;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void init(int i11) {
        super.init(i11);
        this.f38295i = -2;
        this.f38296j = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int i11, K k11, V v11, int i12, int i13) {
        super.insertEntry(i11, k11, v11, i12, i13);
        x(this.f38296j, i11);
        x(i11, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int i11, int i12) {
        int size = size() - 1;
        super.moveLastEntry(i11, i12);
        x(s(i11), getSuccessor(i11));
        if (i11 < size) {
            x(s(size), i11);
            x(i11, getSuccessor(size));
        }
        v(size, 0L);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int i11) {
        super.resizeEntries(i11);
        this.links = Arrays.copyOf(u(), i11);
    }

    public final int s(int i11) {
        return ((int) (t(i11) >>> 32)) - 1;
    }

    public final long t(int i11) {
        return u()[i11];
    }

    public final long[] u() {
        long[] jArr = this.links;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    public final void v(int i11, long j11) {
        u()[i11] = j11;
    }

    public final void w(int i11, int i12) {
        v(i11, (t(i11) & 4294967295L) | (((long) (i12 + 1)) << 32));
    }

    public final void x(int i11, int i12) {
        if (i11 == -2) {
            this.f38295i = i12;
        } else {
            y(i11, i12);
        }
        if (i12 == -2) {
            this.f38296j = i11;
        } else {
            w(i12, i11);
        }
    }

    public final void y(int i11, int i12) {
        v(i11, (t(i11) & (-4294967296L)) | (((long) (i12 + 1)) & 4294967295L));
    }
}
