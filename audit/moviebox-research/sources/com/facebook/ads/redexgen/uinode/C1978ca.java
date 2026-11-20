package com.facebook.ads.redexgen.uinode;

import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ca, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1978ca<ModelType, StateType> {
    public static byte[] A06;
    public static String[] A07 = {"K3IBH5IY5D9A1s0otTNJJ1EDvo1qLs", "HR7iyfZ1MOS5huP42RSdRpCkeBunQMOf", "", "bEqFTGguyIKgMYqaAFudqvCpFKGvMgpm", "3wGEEC73gwsSkVWXWqLxZk", "wIAJ3aMEmj6qTKsV0aDgjtipvoJzkW0C", "SCvpsyQDnQo4JnEbtI83SB", "GSqpB1BwT3x"};
    public static final C1978ca A08;
    public boolean A00;
    public final C1978ca A01;
    public final ModelType A02;
    public final StateType A03;
    public final String A04;
    public final List<InterfaceC1981cd<ModelType, StateType>> A05;

    static {
        A02();
        A08 = new C1978ca(null, null, A01(48, 5, 42), Collections.emptyList(), A08);
    }

    public C1978ca(C1979cb<ModelType, StateType> c1979cb) {
        this(c1979cb.A02, c1979cb.A03, c1979cb.A04, c1979cb.A01 == null ? Collections.emptyList() : c1979cb.A01, c1979cb.A00);
    }

    public C1978ca(ModelType modeltype, StateType statetype, String str, List<InterfaceC1981cd<ModelType, StateType>> list, C1978ca c1978ca) {
        if (modeltype instanceof View) {
            throw new IllegalArgumentException(A01(0, 48, 123));
        }
        this.A02 = modeltype;
        this.A03 = statetype;
        this.A04 = str;
        this.A01 = c1978ca;
        this.A00 = false;
        this.A05 = list;
    }

    public static <ModelType, StateType> C1979cb<ModelType, StateType> A00(ModelType modeltype, StateType statetype, String str) {
        return new C1979cb<>(modeltype, statetype, str);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{66, 85, 81, 99, 92, 91, 85, 90, 96, 48, 77, 96, 77, Ascii.FF, 95, 84, 91, 97, 88, 80, Ascii.FF, 90, 91, 96, Ascii.FF, 79, 91, 90, 96, 77, 85, 90, Ascii.FF, 77, Ascii.FF, 98, 85, 81, 99, Ascii.FF, 77, 95, Ascii.FF, 89, 91, 80, 81, 88, 0, 8, Ascii.VT, Ascii.SI, Ascii.DC4};
    }

    public final void A03(InterfaceC1968cP interfaceC1968cP) {
        Iterator<InterfaceC1981cd<ModelType, StateType>> it = this.A05.iterator();
        while (it.hasNext()) {
            it.next().A5c(this, interfaceC1968cP);
        }
        EnumC1969cQ enumC1969cQA8J = interfaceC1968cP.A8J(this);
        String[] strArr = A07;
        if (strArr[1].charAt(23) == strArr[3].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[7] = "xMDdEaQw2xH";
        strArr2[2] = "";
        if (enumC1969cQA8J == EnumC1969cQ.A02) {
            this.A00 = true;
        }
    }

    public final boolean A04() {
        return this.A00;
    }
}
