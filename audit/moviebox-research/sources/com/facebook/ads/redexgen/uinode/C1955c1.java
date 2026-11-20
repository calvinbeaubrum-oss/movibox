package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.c1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\nJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\rJ\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000fJ%\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b\u001dJ\u0019\u0010\u001e\u001a\u00020\u00042\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlin/collections/AbstractList$Companion;", "", "()V", "maxArraySize", "", "checkBoundsIndexes", "", "startIndex", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class C1955c1 {
    public static byte[] A00;
    public static String[] A01 = {"KuTCkc88m5Khn4CyGrhwL", "IxLDI0IPbZApfW", "JVK2BzSuCceVtUDdSj5I07", "lBsBUWPEcrP06ZbqPLvUU4J", "22gZmP1JxBFCsFHb94EDAJ1IphHRhPLW", "4VOii7FoXK5P7l8zZ6nforp6Ebd", "RjeQAgQKhl5JskIp4JuQN5iIalMDBvKB", "EBwOVG6Ugh4W3c0PQTNtiW44jE9"};

    static {
        A01();
    }

    public C1955c1() {
    }

    public /* synthetic */ C1955c1(AbstractC1950bv abstractC1950bv) {
        this();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 70);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-105, -75, -105, -21, -26, -64, -27, -37, -36, -17, -79, -105, -113, -125, -42, -52, -35, -56, -99, -125, -120, 124, -48, -53, -91, -54, -64, -63, -44, -106, 124, Ascii.GS, 3, Ascii.SI, Ascii.FF, 10, -26, Ascii.VT, 1, 2, Ascii.NAK, -41, -67, -30, -25, -35, -34, -15, -77, -103, 37, 42, Ascii.RS, Ascii.ESC, 40};
    }

    /* JADX WARN: Code duplicated, block: B:11:0x005b  */
    /* JADX WARN: Code duplicated, block: B:15:0x0064  */
    public final int A02(Collection<?> collection) {
        int iHashCode;
        C1949bu.A07(collection, A00(31, 1, 116));
        int i11 = 1;
        Iterator<?> it = collection.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[3].length() == strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "SCwB4moZZna0suClCc4GjhLyaW7wqAtq";
            strArr2[4] = "mduzLj9uz3KnspGGdaJJ9nMm6LkrQb3g";
            if (!zHasNext) {
                return i11;
            }
            Object next = it.next();
            int i12 = i11 * 31;
            String[] strArr3 = A01;
            if (strArr3[3].length() != strArr3[2].length()) {
                String[] strArr4 = A01;
                strArr4[6] = "hMwjEsxw7wl5skWc3rQN1oqLejAug6sa";
                strArr4[4] = "wRbKU8F1FGogs5q469JLSPNenN0joauE";
                if (next != null) {
                    iHashCode = next.hashCode();
                } else {
                    iHashCode = 0;
                }
            } else if (next != null) {
                iHashCode = next.hashCode();
            } else {
                iHashCode = 0;
            }
            i11 = i12 + iHashCode;
        }
    }

    public final void A03(int i11, int i12) {
        if (i11 < 0 || i11 >= i12) {
            throw new IndexOutOfBoundsException(A00(43, 7, 51) + i11 + A00(12, 8, 29) + i12);
        }
    }

    public final void A04(int i11, int i12) {
        if (i11 < 0 || i11 > i12) {
            throw new IndexOutOfBoundsException(A00(43, 7, 51) + i11 + A00(12, 8, 29) + i12);
        }
    }

    public final void A05(int i11, int i12, int i13) {
        String strA00 = A00(32, 11, 87);
        if (i11 < 0 || i12 > i13) {
            throw new IndexOutOfBoundsException(strA00 + i11 + A00(20, 11, 22) + i12 + A00(12, 8, 29) + i13);
        }
        if (i11 > i12) {
            throw new IllegalArgumentException(strA00 + i11 + A00(0, 12, 49) + i12);
        }
    }

    public final boolean A06(Collection<?> collection, Collection<?> collection2) {
        C1949bu.A07(collection, A00(31, 1, 116));
        C1949bu.A07(collection2, A00(50, 5, 112));
        if (collection.size() != collection2.size()) {
            return false;
        }
        Iterator<?> it = collection2.iterator();
        Iterator<?> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!C1949bu.A0A(it2.next(), it.next())) {
                return false;
            }
        }
        return true;
    }
}
