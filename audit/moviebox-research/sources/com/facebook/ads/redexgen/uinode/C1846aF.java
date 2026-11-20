package com.facebook.ads.redexgen.uinode;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Unexpected interfaces in signature: [com.facebook.ads.internal.util.common.Stateful<android.os.Bundle>] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1846aF {
    public static byte[] A03;
    public final C2R A00;
    public final QK A01;
    public final List<C1845aE> A02;

    static {
        A01();
    }

    public C1846aF(List<C2P> list, Bundle bundle, QK qk2) {
        this.A02 = new ArrayList(list.size());
        this.A01 = qk2;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A00(10, 5, 15));
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.A02.add(new C1845aE(list.get(i11), (Bundle) parcelableArrayList.get(i11)));
        }
        this.A00 = (C2R) LR.A00(bundle.getByteArray(A00(0, 10, 28)));
    }

    public C1846aF(List<C2P> list, QK qk2) {
        this.A02 = new ArrayList(list.size());
        this.A01 = qk2;
        Iterator<C2P> it = list.iterator();
        while (it.hasNext()) {
            this.A02.add(new C1845aE(it.next()));
        }
        this.A00 = new C2R();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{126, 121, 108, 121, 100, 126, 121, 100, 110, 126, 106, 123, 109, 106, 109};
    }

    public final Bundle A02() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(0, 10, 28), LR.A01(this.A00));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.A02.size());
        Iterator<C1845aE> it = this.A02.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().A05());
        }
        bundle.putParcelableArrayList(A00(10, 5, 15), arrayList);
        return bundle;
    }

    public final C2R A03() {
        return this.A00;
    }

    public final void A04() {
        this.A00.A03();
        Iterator<C1845aE> it = this.A02.iterator();
        while (it.hasNext()) {
            it.next().A06();
        }
    }

    public final void A05() {
        this.A00.A02();
    }

    public final void A06(double d11, double d12) {
        if (d12 >= 0.0d) {
            this.A00.A05(d11, d12);
        }
        double dA8K = this.A01.A8K();
        this.A00.A04(d11, dA8K);
        Iterator<C1845aE> it = this.A02.iterator();
        while (it.hasNext()) {
            it.next().A07(d11, dA8K);
        }
    }
}
