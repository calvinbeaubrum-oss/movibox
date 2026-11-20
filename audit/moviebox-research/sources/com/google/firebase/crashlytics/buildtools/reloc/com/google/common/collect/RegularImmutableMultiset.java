package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final ImmutableMultiset<Object> EMPTY = create(ImmutableList.of());
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_HASH_BUCKET_LENGTH = 9;
    static final double MAX_LOAD_FACTOR = 1.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Multisets.ImmutableEntry<E>[] f39560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Multisets.ImmutableEntry<E>[] f39561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f39562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f39563d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient ImmutableSet<E> f39564f;

    /* JADX INFO: compiled from: source.java */
    public static final class NonTerminalEntry<E> extends Multisets.ImmutableEntry<E> {
        private final Multisets.ImmutableEntry<E> nextInBucket;

        public NonTerminalEntry(E e11, int i11, Multisets.ImmutableEntry<E> immutableEntry) {
            super(e11, i11);
            this.nextInBucket = immutableEntry;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multisets.ImmutableEntry
        public Multisets.ImmutableEntry<E> nextInBucket() {
            return this.nextInBucket;
        }
    }

    public RegularImmutableMultiset(Multisets.ImmutableEntry<E>[] immutableEntryArr, Multisets.ImmutableEntry<E>[] immutableEntryArr2, int i11, int i12, ImmutableSet<E> immutableSet) {
        this.f39560a = immutableEntryArr;
        this.f39561b = immutableEntryArr2;
        this.f39562c = i11;
        this.f39563d = i12;
        this.f39564f = immutableSet;
    }

    public static <E> ImmutableMultiset<E> create(Collection<? extends l6.a<? extends E>> collection) {
        int size = collection.size();
        Multisets.ImmutableEntry[] immutableEntryArr = new Multisets.ImmutableEntry[size];
        if (size == 0) {
            return new RegularImmutableMultiset(immutableEntryArr, null, 0, 0, ImmutableSet.of());
        }
        int iA = y2.a(size, 1.0d);
        int i11 = iA - 1;
        Multisets.ImmutableEntry[] immutableEntryArr2 = new Multisets.ImmutableEntry[iA];
        int i12 = 0;
        long j11 = 0;
        int i13 = 0;
        for (l6.a<? extends E> aVar : collection) {
            Object objN = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(aVar.getElement());
            int count = aVar.getCount();
            int iHashCode = objN.hashCode();
            int iC = y2.c(iHashCode) & i11;
            Multisets.ImmutableEntry immutableEntry = immutableEntryArr2[iC];
            Multisets.ImmutableEntry immutableEntry2 = immutableEntry == null ? (!(aVar instanceof Multisets.ImmutableEntry) || (aVar instanceof NonTerminalEntry)) ? new Multisets.ImmutableEntry(objN, count) : (Multisets.ImmutableEntry) aVar : new NonTerminalEntry(objN, count, immutableEntry);
            i13 += iHashCode ^ count;
            immutableEntryArr[i12] = immutableEntry2;
            immutableEntryArr2[iC] = immutableEntry2;
            j11 += (long) count;
            i12++;
        }
        return g(immutableEntryArr2) ? JdkBackedImmutableMultiset.create(ImmutableList.asImmutableList(immutableEntryArr)) : new RegularImmutableMultiset(immutableEntryArr, immutableEntryArr2, Ints.i(j11), i13, null);
    }

    public static boolean g(Multisets.ImmutableEntry<?>[] immutableEntryArr) {
        for (Multisets.ImmutableEntry<?> immutableEntryNextInBucket : immutableEntryArr) {
            int i11 = 0;
            for (; immutableEntryNextInBucket != null; immutableEntryNextInBucket = immutableEntryNextInBucket.nextInBucket()) {
                i11++;
                if (i11 > 9) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int count(Object obj) {
        Multisets.ImmutableEntry<E>[] immutableEntryArr = this.f39561b;
        if (obj != null && immutableEntryArr != null) {
            for (Multisets.ImmutableEntry<E> immutableEntryNextInBucket = immutableEntryArr[y2.d(obj) & (immutableEntryArr.length - 1)]; immutableEntryNextInBucket != null; immutableEntryNextInBucket = immutableEntryNextInBucket.nextInBucket()) {
                if (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(obj, immutableEntryNextInBucket.getElement())) {
                    return immutableEntryNextInBucket.getCount();
                }
            }
        }
        return 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.f39564f;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableMultiset.ElementSet elementSet = new ImmutableMultiset.ElementSet(Arrays.asList(this.f39560a), this);
        this.f39564f = elementSet;
        return elementSet;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        k6.b(this, objIntConsumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset
    public l6.a<E> getEntry(int i11) {
        return this.f39560a[i11];
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int hashCode() {
        return this.f39563d;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int size() {
        return this.f39562c;
    }
}
