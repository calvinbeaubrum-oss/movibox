package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {

    /* JADX INFO: compiled from: source.java */
    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            this(4);
        }

        public Builder(int i11) {
            super(i11);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E e11) {
            super.add((Object) e11);
            return this;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }

        public ImmutableSet<E> build() {
            ImmutableSet<E> immutableSetConstruct = ImmutableSet.construct(this.size, this.contents);
            this.size = immutableSetConstruct.size();
            return immutableSetConstruct;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class Indexed<E> extends ImmutableSet<E> {
        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
        public ImmutableList<E> createAsList() {
            return new ImmutableAsList<E>() { // from class: com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet.Indexed.1
                @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableAsList
                public Indexed<E> delegateCollection() {
                    return Indexed.this;
                }

                @Override // java.util.List
                public E get(int i11) {
                    return (E) Indexed.this.get(i11);
                }
            };
        }

        public abstract E get(int i11);

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public UnmodifiableIterator<E> iterator() {
            return asList().iterator();
        }
    }

    public static int chooseTableSize(int i11) {
        if (i11 >= 751619276) {
            Preconditions.checkArgument(i11 < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(i11 - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < i11) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i11, Object... objArr) {
        if (i11 == 0) {
            return of();
        }
        if (i11 == 1) {
            return of(objArr[0]);
        }
        int iChooseTableSize = chooseTableSize(i11);
        Object[] objArr2 = new Object[iChooseTableSize];
        int i12 = iChooseTableSize - 1;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i11; i15++) {
            Object objCheckElementNotNull = ObjectArrays.checkElementNotNull(objArr[i15], i15);
            int iHashCode = objCheckElementNotNull.hashCode();
            int iSmear = Hashing.smear(iHashCode);
            while (true) {
                int i16 = iSmear & i12;
                Object obj = objArr2[i16];
                if (obj == null) {
                    objArr[i13] = objCheckElementNotNull;
                    objArr2[i16] = objCheckElementNotNull;
                    i14 += iHashCode;
                    i13++;
                    break;
                }
                if (obj.equals(objCheckElementNotNull)) {
                    break;
                }
                iSmear++;
            }
        }
        Arrays.fill(objArr, i13, i11, (Object) null);
        if (i13 == 1) {
            return new SingletonImmutableSet(objArr[0], i14);
        }
        if (iChooseTableSize != chooseTableSize(i13)) {
            return construct(i13, objArr);
        }
        if (i13 < objArr.length) {
            objArr = ObjectArrays.arraysCopyOf(objArr, i13);
        }
        return new RegularImmutableSet(objArr, i14, objArr2, i12);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof ImmutableSortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        } else if (collection instanceof EnumSet) {
            return copyOfEnumSet((EnumSet) collection);
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        return !it.hasNext() ? of((Object) next) : new Builder().add((Object) next).addAll((Iterator) it).build();
    }

    private static ImmutableSet copyOfEnumSet(EnumSet enumSet) {
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(enumSet));
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    public static <E> ImmutableSet<E> of(E e11) {
        return new SingletonImmutableSet(e11);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12) {
        return construct(2, e11, e12);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.equalsImpl(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract UnmodifiableIterator<E> iterator();
}
