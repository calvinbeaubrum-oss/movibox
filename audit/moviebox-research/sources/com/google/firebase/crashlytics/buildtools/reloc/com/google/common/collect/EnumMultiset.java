package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class EnumMultiset<E extends Enum<E>> extends t<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private transient int[] counts;
    private transient int distinctElements;
    private transient E[] enumConstants;
    private transient long size;
    private transient Class<E> type;

    /* JADX INFO: compiled from: source.java */
    public class a extends EnumMultiset<E>.c<E> {
        public a() {
            super();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.EnumMultiset.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(int i11) {
            return (E) EnumMultiset.this.enumConstants[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends EnumMultiset<E>.c<l6.a<E>> {

        /* JADX INFO: compiled from: source.java */
        public class a extends Multisets.b<E> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f39303a;

            public a(int i11) {
                this.f39303a = i11;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public E getElement() {
                return (E) EnumMultiset.this.enumConstants[this.f39303a];
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6.a
            public int getCount() {
                return EnumMultiset.this.counts[this.f39303a];
            }
        }

        public b() {
            super();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.EnumMultiset.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public l6.a<E> a(int i11) {
            return new a(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f39305a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39306b = -1;

        public c() {
        }

        public abstract T a(int i11);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.f39305a < EnumMultiset.this.enumConstants.length) {
                int[] iArr = EnumMultiset.this.counts;
                int i11 = this.f39305a;
                if (iArr[i11] > 0) {
                    return true;
                }
                this.f39305a = i11 + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tA = a(this.f39305a);
            int i11 = this.f39305a;
            this.f39306b = i11;
            this.f39305a = i11 + 1;
            return tA;
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(this.f39306b >= 0);
            if (EnumMultiset.this.counts[this.f39306b] > 0) {
                EnumMultiset.access$210(EnumMultiset.this);
                EnumMultiset.this.size -= (long) EnumMultiset.this.counts[this.f39306b];
                EnumMultiset.this.counts[this.f39306b] = 0;
            }
            this.f39306b = -1;
        }
    }

    private EnumMultiset(Class<E> cls) {
        this.type = cls;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
    }

    public static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int i11 = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i11 - 1;
        return i11;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
        j5.a(enumMultiset, iterable);
        return enumMultiset;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> enumMultisetCreate = create(cls);
        j5.a(enumMultisetCreate, iterable);
        return enumMultisetCreate;
    }

    private boolean isActuallyE(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r11 = (Enum) obj;
        int iOrdinal = r11.ordinal();
        E[] eArr = this.enumConstants;
        return iOrdinal < eArr.length && eArr[iOrdinal] == r11;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.type = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
        y6.f(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        y6.k(this, objectOutputStream);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int add(E e11, int i11) {
        checkIsE(e11);
        n1.b(i11, "occurrences");
        if (i11 == 0) {
            return count(e11);
        }
        int iOrdinal = e11.ordinal();
        int i12 = this.counts[iOrdinal];
        long j11 = i11;
        long j12 = ((long) i12) + j11;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.h(j12 <= 2147483647L, "too many occurrences: %s", j12);
        this.counts[iOrdinal] = (int) j12;
        if (i12 == 0) {
            this.distinctElements++;
        }
        this.size += j11;
        return i12;
    }

    public void checkIsE(Object obj) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(obj);
        if (isActuallyE(obj)) {
            return;
        }
        throw new ClassCastException("Expected an " + this.type + " but got " + obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0L;
        this.distinctElements = 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int count(Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public int distinctElements() {
        return this.distinctElements;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public Iterator<l6.a<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(objIntConsumer);
        int i11 = 0;
        while (true) {
            E[] eArr = this.enumConstants;
            if (i11 >= eArr.length) {
                return;
            }
            int i12 = this.counts[i11];
            if (i12 > 0) {
                objIntConsumer.accept(eArr[i11], i12);
            }
            i11++;
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int remove(Object obj, int i11) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        Enum r11 = (Enum) obj;
        n1.b(i11, "occurrences");
        if (i11 == 0) {
            return count(obj);
        }
        int iOrdinal = r11.ordinal();
        int[] iArr = this.counts;
        int i12 = iArr[iOrdinal];
        if (i12 == 0) {
            return 0;
        }
        if (i12 <= i11) {
            iArr[iOrdinal] = 0;
            this.distinctElements--;
            this.size -= (long) i12;
        } else {
            iArr[iOrdinal] = i12 - i11;
            this.size -= (long) i11;
        }
        return i12;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int setCount(E e11, int i11) {
        checkIsE(e11);
        n1.b(i11, "count");
        int iOrdinal = e11.ordinal();
        int[] iArr = this.counts;
        int i12 = iArr[iOrdinal];
        iArr[iOrdinal] = i11;
        this.size += (long) (i11 - i12);
        if (i12 == 0 && i11 > 0) {
            this.distinctElements++;
        } else if (i12 > 0 && i11 == 0) {
            this.distinctElements--;
        }
        return i12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int size() {
        return Ints.i(this.size);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return k6.c(this);
    }
}
