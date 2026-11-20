package com.facebook.ads.redexgen.uinode;

import android.util.SparseArray;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4v, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C4v {
    public static String[] A02 = {"hO0SXlIn7n5HXEBLx", "jESNVpuYnHPlnh4DZ", "CDLwN7DwmtArlNd144q1QIOvLDqs4yZF", "JntNhgZ58kYFXbwiJ6hzeVdvPNGn00kF", "yTsWpbzmHeCmcQEDkb0QkT5J3TV6CkfD", "Lh9pded4Clz2", "gnDNjs3GBImfOnnM5uEQWokXBd1c", "C4tnEN178k9sL9bIxtVolUttiI5dEdE5"};
    public SparseArray<C10674u> A00 = new SparseArray<>();
    public int A01 = 0;

    private final long A00(long j11, long j12) {
        if (j11 == 0) {
            return j12;
        }
        long j13 = j11 / 4;
        String[] strArr = A02;
        if (strArr[3].charAt(9) != strArr[7].charAt(9)) {
            throw new RuntimeException();
        }
        A02[4] = "GTVZcsVJP0WVKaHbsMtSVk9gu6Gyk4Ss";
        return (j13 * 3) + (j12 / 4);
    }

    private C10674u A01(int i11) {
        C10674u c10674u = this.A00.get(i11);
        if (c10674u != null) {
            return c10674u;
        }
        C10674u c10674u2 = new C10674u();
        this.A00.put(i11, c10674u2);
        return c10674u2;
    }

    private final void A02() {
        for (int i11 = 0; i11 < this.A00.size(); i11++) {
            this.A00.valueAt(i11).A03.clear();
        }
    }

    public final AnonymousClass56 A03(int i11) {
        C10674u c10674u = this.A00.get(i11);
        if (c10674u == null || c10674u.A03.isEmpty()) {
            return null;
        }
        ArrayList<AnonymousClass56> arrayList = c10674u.A03;
        if (A02[4].charAt(1) != 'T') {
            throw new RuntimeException();
        }
        A02[6] = "6zOEmNGiTAHU1v9SGa3";
        return arrayList.remove(arrayList.size() - 1);
    }

    public final void A04() {
        this.A01--;
    }

    public final void A05(int i11, long j11) {
        C10674u c10674uA01 = A01(i11);
        c10674uA01.A01 = A00(c10674uA01.A01, j11);
    }

    public final void A06(int i11, long j11) {
        C10674u c10674uA01 = A01(i11);
        c10674uA01.A02 = A00(c10674uA01.A02, j11);
    }

    public final void A07(AbstractC10494c abstractC10494c) {
        this.A01++;
    }

    public final void A08(AbstractC10494c abstractC10494c, AbstractC10494c abstractC10494c2, boolean z11) {
        if (abstractC10494c != null) {
            A04();
        }
        if (!z11 && this.A01 == 0) {
            A02();
        }
        if (abstractC10494c2 != null) {
            A07(abstractC10494c2);
        }
    }

    public final void A09(AnonymousClass56 anonymousClass56) {
        int iA0H = anonymousClass56.A0H();
        ArrayList<AnonymousClass56> arrayList = A01(iA0H).A03;
        if (this.A00.get(iA0H).A00 <= arrayList.size()) {
            return;
        }
        anonymousClass56.A0Q();
        String[] strArr = A02;
        if (strArr[3].charAt(9) != strArr[7].charAt(9)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[1] = "TnDeXYrDbfmyODeGX";
        strArr2[5] = "ziritv0xfrad";
        arrayList.add(anonymousClass56);
    }

    public final boolean A0A(int i11, long j11, long j12) {
        long j13 = A01(i11).A01;
        return j13 == 0 || j11 + j13 < j12;
    }

    public final boolean A0B(int i11, long j11, long j12) {
        long j13 = A01(i11).A02;
        return j13 == 0 || j11 + j13 < j12;
    }
}
