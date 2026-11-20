package com.facebook.ads.redexgen.uinode;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W9 implements InterfaceC1315Fo {
    public static byte[] A04;
    public final int A00;
    public final List<WA> A01;
    public final long[] A02;
    public final long[] A03;

    static {
        A01();
    }

    public W9(List<WA> list) {
        this.A01 = list;
        int size = list.size();
        this.A00 = size;
        this.A02 = new long[size * 2];
        for (int i11 = 0; i11 < this.A00; i11++) {
            WA wa2 = list.get(i11);
            int i12 = i11 * 2;
            this.A02[i12] = wa2.A01;
            this.A02[i12 + 1] = wa2.A00;
        }
        long[] jArr = this.A02;
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        this.A03 = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{19};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final List<C1314Fn> A6Z(long j11) {
        ArrayList arrayList = null;
        WA wa2 = null;
        SpannableStringBuilder spannableStringBuilder = null;
        for (int i11 = 0; i11 < this.A00; i11++) {
            long[] jArr = this.A02;
            if (jArr[i11 * 2] <= j11 && j11 < jArr[(i11 * 2) + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                WA wa3 = this.A01.get(i11);
                if (!wa3.A00()) {
                    arrayList.add(wa3);
                } else if (wa2 == null) {
                    wa2 = wa3;
                } else {
                    String strA00 = A00(0, 1, 53);
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append(wa2.A0C).append((CharSequence) strA00).append(wa3.A0C);
                    } else {
                        spannableStringBuilder.append((CharSequence) strA00).append(wa3.A0C);
                    }
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new WA(spannableStringBuilder));
        } else if (wa2 != null) {
            arrayList.add(wa2);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final long A70(int i11) {
        AbstractC1351Ha.A03(i11 >= 0);
        AbstractC1351Ha.A03(i11 < this.A03.length);
        return this.A03[i11];
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A71() {
        return this.A03.length;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1315Fo
    public final int A7T(long j11) {
        int iA0A = IF.A0A(this.A03, j11, false, false);
        if (iA0A < this.A03.length) {
            return iA0A;
        }
        return -1;
    }
}
