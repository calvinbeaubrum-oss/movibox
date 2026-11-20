package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ag, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1873ag implements K3 {
    public static byte[] A0E;
    public static String[] A0F = {"Um", "5O6Pi5UhekEiJBNtL2", "ByBiFstlzS", "VNZICTTmM6bBZ", "I3ykA2cHAONkN", "xnUs6VMzToWHuFoC", "Qkjm3fg24P6DD7pmZ7L4neN1zLjqdukp", "LFB8Dcv49A6aPeUL"};
    public InterfaceC09941y A00;
    public C8S A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final Handler A05;
    public final AdSize A06;
    public final C09640u A07;
    public final C1795Yn A08;
    public final J2 A09;
    public final EnumC1405Jg A0A;
    public final K4 A0B;
    public final Runnable A0C;
    public final String A0D;

    static {
        A05();
        AbstractC1464Lq.A02();
    }

    public C1873ag(C1795Yn c1795Yn, String str, EnumC1405Jg enumC1405Jg, AdSize adSize, int i11) {
        this.A08 = c1795Yn;
        this.A0D = str;
        this.A0A = enumC1405Jg;
        this.A06 = adSize;
        this.A04 = i11;
        K4 k11 = new K4(c1795Yn);
        this.A0B = k11;
        k11.A0P(this);
        this.A07 = new C09640u();
        this.A03 = true;
        this.A05 = new Handler();
        this.A0C = new FH(this);
        this.A09 = c1795Yn.A09();
        DynamicLoaderFactory.makeLoader(c1795Yn).getInitApi().onAdLoadInvoked(c1795Yn);
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0F[2].length() != 10) {
                throw new RuntimeException();
            }
            A0F[1] = "uoxYJqIRleds8fPMMv";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 87);
            i14++;
        }
    }

    private List<C1913bK> A04() {
        C8S c8s = this.A01;
        ArrayList arrayList = new ArrayList(c8s.A02());
        for (C8Q c8qA04 = c8s.A04(); c8qA04 != null; c8qA04 = c8s.A04()) {
            InterfaceC09590p interfaceC09590pA00 = this.A07.A00(this.A08, AdPlacementType.NATIVE);
            if (interfaceC09590pA00 != null && interfaceC09590pA00.A7e() == AdPlacementType.NATIVE) {
                C1913bK c1913bK = (C1913bK) interfaceC09590pA00;
                c1913bK.A0L(this.A08, new FI(this, arrayList, c1913bK), this.A09, new C09911v(c8qA04.A04(), c8s.A05(), this.A0D, c8s.A05().A0C()), V2.A0K());
            }
        }
        return arrayList;
    }

    public static void A05() {
        byte[] bArr = {64, 65, -14, 66, 62, 51, 53, 55, Utf8.REPLACEMENT_BYTE, 55, 64, 70, -14, 59, 64, -14, 68, 55, 69, 66, 65, 64, 69, 55};
        if (A0F[0].length() != 2) {
            throw new RuntimeException();
        }
        A0F[1] = "dKV76OJFyRmVPWeRzZ";
        A0E = bArr;
    }

    public final void A06() {
        this.A03 = false;
        this.A05.removeCallbacks(this.A0C);
    }

    public final void A07() {
        try {
            C1410Jl c1410Jl = new C1410Jl(this.A08, null, null, null);
            C1795Yn c1795Yn = this.A08;
            String str = this.A0D;
            AdSize adSize = this.A06;
            this.A0B.A0O(new K1(c1795Yn, str, adSize != null ? new LQ(adSize.getWidth(), this.A06.getHeight()) : null, this.A0A, this.A04, c1410Jl, LW.A01(C1384Ih.A0J(this.A08)), this.A02, null, new C1866aZ()));
        } catch (C1402Jc e11) {
            ABR(C1401Jb.A02(e11));
        }
    }

    public final void A08(InterfaceC09941y interfaceC09941y) {
        this.A00 = interfaceC09941y;
    }

    public final void A09(String str) {
        this.A02 = str;
    }

    public final boolean A0A() {
        C8S c8s = this.A01;
        return c8s == null || c8s.A0C();
    }

    @Override // com.facebook.ads.redexgen.uinode.K3
    public final void ABR(C1401Jb c1401Jb) {
        if (this.A03) {
            this.A05.postDelayed(this.A0C, 1800000L);
        }
        InterfaceC09941y interfaceC09941y = this.A00;
        if (A0F[2].length() != 10) {
            throw new RuntimeException();
        }
        A0F[2] = "yGn7NPCZVX";
        if (interfaceC09941y != null) {
            interfaceC09941y.ABR(c1401Jb);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.K3
    public final void ADG(C1697Up c1697Up) {
        C8S c8sA00 = c1697Up.A00();
        if (c8sA00 == null) {
            throw new IllegalStateException(A03(0, 24, 123));
        }
        if (this.A03) {
            long jA0A = c8sA00.A05().A0A();
            if (jA0A == 0) {
                jA0A = 1800000;
            }
            this.A05.postDelayed(this.A0C, jA0A);
        }
        this.A01 = c8sA00;
        List<C1913bK> listA04 = A04();
        if (this.A00 != null) {
            if (listA04.isEmpty()) {
                this.A00.ABR(C1401Jb.A01(AdErrorType.NO_FILL, A03(0, 0, 68)));
            } else {
                this.A00.ACP(listA04);
            }
        }
    }
}
