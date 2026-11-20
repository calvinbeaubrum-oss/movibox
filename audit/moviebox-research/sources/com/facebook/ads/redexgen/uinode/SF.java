package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SF implements QF {
    public static byte[] A0B;
    public boolean A00;
    public boolean A01;
    public final C1795Yn A02;
    public final J2 A03;
    public final SA A04;
    public final AbstractC1572Pu A05;
    public final AbstractC1563Pl A06;
    public final AbstractC1539On A07;
    public final SY A08;
    public final String A09;
    public final Map<String, String> A0A;

    static {
        A09();
    }

    public SF(C1795Yn c1795Yn, J2 j11, SA sa2, String str, QS qs2, Map<String, String> map) {
        AbstractC1563Pl abstractC1563Pl = new AbstractC1563Pl() { // from class: com.facebook.ads.redexgen.X.9N
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C9F c9f) {
                if (!this.A00.A01) {
                    this.A00.A01 = true;
                    this.A00.A02.A0E().AFU();
                }
                SZ sz2 = new SZ(this.A00.A09, c9f.A03(), c9f.A01(), c9f.A02());
                if (c9f.A00() >= 0.05d) {
                    sz2.A06(c9f.A01());
                }
                this.A00.A08.A0C(sz2);
            }
        };
        this.A06 = abstractC1563Pl;
        AbstractC1539On abstractC1539On = new AbstractC1539On() { // from class: com.facebook.ads.redexgen.X.9M
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(AnonymousClass98 anonymousClass98) {
                this.A00.A02.A0E().AFb();
                this.A00.A0D();
            }
        };
        this.A07 = abstractC1539On;
        AbstractC1572Pu abstractC1572Pu = new AbstractC1572Pu() { // from class: com.facebook.ads.redexgen.X.9L
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C9H c9h) {
                this.A00.A02.A0E().AFZ();
                this.A00.A0D();
            }
        };
        this.A05 = abstractC1572Pu;
        this.A00 = false;
        this.A01 = false;
        this.A02 = c1795Yn;
        this.A03 = j11;
        this.A09 = str;
        this.A0A = map;
        this.A04 = sa2;
        this.A08 = new SY(str);
        if (!C1384Ih.A1i(c1795Yn)) {
            c1795Yn.A0E().AFX();
            sa2.getEventBus().A03(abstractC1563Pl, abstractC1539On, abstractC1572Pu);
        } else {
            c1795Yn.A0E().AFW();
            qs2.A0h(this);
            sa2.getEventBus().A05(abstractC1563Pl);
        }
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 96);
        }
        return new String(bArrCopyOfRange);
    }

    private Map<String, String> A08(String str) {
        HashMap map = new HashMap();
        Map<String, String> map2 = this.A0A;
        if (map2 != null) {
            map.putAll(map2);
        }
        map.put(A06(0, 6, 123), str);
        return map;
    }

    public static void A09() {
        A0B = new byte[]{125, 105, 122, 118, 126, 104};
    }

    public final void A0C() {
        SG sg2 = new SG(this);
        if (this.A04.A0l()) {
            ExecutorC1456Li.A00(sg2);
        } else {
            this.A04.getStateHandler().post(sg2);
        }
    }

    public final synchronized void A0D() {
        String strA04 = SY.A04(this.A08.A0B());
        if (strA04 != null) {
            this.A02.A0E().AFc();
            this.A03.AA1(this.A09, A08(strA04));
        } else if (this.A00) {
            this.A02.A0E().AFe();
        } else {
            this.A02.A0E().AFV();
            this.A03.AA1(this.A09, A08(A06(0, 0, 56)));
            this.A00 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.QF
    public final void AC8() {
        this.A02.A0E().AFa();
        A0D();
    }
}
