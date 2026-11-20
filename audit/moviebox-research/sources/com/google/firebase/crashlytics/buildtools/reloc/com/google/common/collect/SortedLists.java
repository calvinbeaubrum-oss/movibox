package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class SortedLists {

    /* JADX INFO: compiled from: source.java */
    public enum KeyAbsentBehavior {
        NEXT_LOWER { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyAbsentBehavior.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i11) {
                return i11 - 1;
            }
        },
        NEXT_HIGHER { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyAbsentBehavior.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i11) {
                return i11;
            }
        },
        INVERTED_INSERTION_INDEX { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyAbsentBehavior.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i11) {
                return ~i11;
            }
        };

        public abstract int resultIndex(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public enum KeyPresentBehavior {
        ANY_PRESENT { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyPresentBehavior.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                return i11;
            }
        },
        LAST_PRESENT { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyPresentBehavior.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                int size = list.size() - 1;
                while (i11 < size) {
                    int i12 = ((i11 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i12), e11) > 0) {
                        size = i12 - 1;
                    } else {
                        i11 = i12;
                    }
                }
                return i11;
            }
        },
        FIRST_PRESENT { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyPresentBehavior.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                int i12 = 0;
                while (i12 < i11) {
                    int i13 = (i12 + i11) >>> 1;
                    if (comparator.compare(list.get(i13), e11) < 0) {
                        i12 = i13 + 1;
                    } else {
                        i11 = i13;
                    }
                }
                return i12;
            }
        },
        FIRST_AFTER { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyPresentBehavior.4
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e11, list, i11) + 1;
            }
        },
        LAST_BEFORE { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyPresentBehavior.5
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e11, list, i11) - 1;
            }
        };

        public abstract <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11);
    }

    public static <E, K extends Comparable> int a(List<E> list, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super E, K> dVar, K k11, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return b(list, dVar, k11, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int b(List<E> list, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super E, K> dVar, K k11, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return c(Lists.m(list, dVar), k11, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int c(List<? extends E> list, E e11, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(list);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(keyPresentBehavior);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.i(list);
        }
        int size = list.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) >>> 1;
            int iCompare = comparator.compare(e11, list.get(i12));
            if (iCompare < 0) {
                size = i12 - 1;
            } else {
                if (iCompare <= 0) {
                    return i11 + keyPresentBehavior.resultIndex(comparator, e11, list.subList(i11, size + 1), i12 - i11);
                }
                i11 = i12 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i11);
    }
}
