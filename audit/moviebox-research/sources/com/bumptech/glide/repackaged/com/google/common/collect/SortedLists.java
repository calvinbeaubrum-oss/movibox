package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class SortedLists {

    /* JADX INFO: compiled from: source.java */
    public enum KeyAbsentBehavior {
        NEXT_LOWER { // from class: com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior.1
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i11) {
                return i11 - 1;
            }
        },
        NEXT_HIGHER { // from class: com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior.2
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i11) {
                return i11;
            }
        },
        INVERTED_INSERTION_INDEX { // from class: com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior.3
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i11) {
                return ~i11;
            }
        };

        public abstract int resultIndex(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public enum KeyPresentBehavior {
        ANY_PRESENT { // from class: com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior.1
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                return i11;
            }
        },
        LAST_PRESENT { // from class: com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
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
        FIRST_PRESENT { // from class: com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
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
        FIRST_AFTER { // from class: com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior.4
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e11, list, i11) + 1;
            }
        },
        LAST_BEFORE { // from class: com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior.5
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e11, list, i11) - 1;
            }
        };

        public abstract <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11);
    }

    public static <E> int binarySearch(List<? extends E> list, E e11, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(keyPresentBehavior);
        Preconditions.checkNotNull(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.newArrayList(list);
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
