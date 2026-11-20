package com.facebook.ads.redexgen.uinode;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9I extends QS {
    public int A00;
    public boolean A01;
    public final AbstractC11578s<C9H> A02;
    public final AbstractC11578s<AnonymousClass98> A03;
    public final AbstractC11578s<O8> A04;
    public final AbstractC11578s<AnonymousClass93> A05;
    public final AbstractC11578s<C1491Mr> A06;
    public final AbstractC11578s<C1479Mf> A07;
    public final AbstractC11578s<C1474Ma> A08;
    public final AbstractC11578s<MU> A09;
    public final AbstractC11578s<C1468Lu> A0A;
    public final SA A0B;
    public final NX A0C;
    public final MV A0D;

    public C9I(C1795Yn c1795Yn, J2 j11, SA sa2, String str) {
        this(c1795Yn, j11, sa2, new ArrayList(), str);
    }

    public C9I(C1795Yn c1795Yn, J2 j11, SA sa2, String str, Bundle bundle) {
        this(c1795Yn, j11, sa2, new ArrayList(), str, bundle, null);
    }

    public C9I(C1795Yn c1795Yn, J2 j11, SA sa2, String str, Map<String, String> map) {
        this(c1795Yn, j11, sa2, new ArrayList(), str, null, map);
    }

    public C9I(C1795Yn c1795Yn, J2 j11, SA sa2, List<C2P> list, String str) {
        super(c1795Yn, j11, sa2, list, str, !sa2.A0h(), new QR(c1795Yn, sa2));
        MV mv2 = new MV() { // from class: com.facebook.ads.redexgen.X.9J
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(MW mw2) {
                this.A00.A0a();
            }
        };
        this.A0D = mv2;
        S7 s11 = new S7(this);
        this.A07 = s11;
        S3 s12 = new S3(this);
        this.A03 = s12;
        RH rh2 = new RH(this);
        this.A04 = rh2;
        RA ra2 = new RA(this);
        this.A05 = ra2;
        C1581Qd c1581Qd = new C1581Qd(this);
        this.A02 = c1581Qd;
        C1580Qc c1580Qc = new C1580Qc(this);
        this.A06 = c1580Qc;
        C1578Qa c1578Qa = new C1578Qa(this);
        this.A09 = c1578Qa;
        QV qv2 = new QV(this);
        this.A0A = qv2;
        S9 s13 = new S9(this);
        this.A08 = s13;
        NX nx2 = new NX() { // from class: com.facebook.ads.redexgen.X.9K
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C1513Nn c1513Nn) {
                C9I c9i = this.A00;
                c9i.A00 = c9i.A0B.getDuration();
            }
        };
        this.A0C = nx2;
        this.A01 = false;
        this.A0B = sa2;
        sa2.getEventBus().A03(mv2, ra2, s11, rh2, s12, c1581Qd, c1580Qc, c1578Qa, qv2, nx2, s13);
    }

    public C9I(C1795Yn c1795Yn, J2 j11, SA sa2, List<C2P> list, String str, Bundle bundle, Map<String, String> map) {
        super(c1795Yn, j11, sa2, list, str, !sa2.A0h(), bundle, map, new QR(c1795Yn, sa2));
        MV mv2 = new MV() { // from class: com.facebook.ads.redexgen.X.9J
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(MW mw2) {
                this.A00.A0a();
            }
        };
        this.A0D = mv2;
        S7 s11 = new S7(this);
        this.A07 = s11;
        S3 s12 = new S3(this);
        this.A03 = s12;
        RH rh2 = new RH(this);
        this.A04 = rh2;
        RA ra2 = new RA(this);
        this.A05 = ra2;
        C1581Qd c1581Qd = new C1581Qd(this);
        this.A02 = c1581Qd;
        C1580Qc c1580Qc = new C1580Qc(this);
        this.A06 = c1580Qc;
        C1578Qa c1578Qa = new C1578Qa(this);
        this.A09 = c1578Qa;
        QV qv2 = new QV(this);
        this.A0A = qv2;
        S9 s13 = new S9(this);
        this.A08 = s13;
        this.A0C = new NX() { // from class: com.facebook.ads.redexgen.X.9K
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C1513Nn c1513Nn) {
                C9I c9i = this.A00;
                c9i.A00 = c9i.A0B.getDuration();
            }
        };
        this.A01 = false;
        this.A0B = sa2;
        sa2.getEventBus().A03(mv2, ra2, s11, rh2, s12, c1581Qd, c1580Qc, c1578Qa, qv2, s13);
    }

    public final void A0i() {
        S8 s11 = new S8(this);
        if (this.A0B.A0l()) {
            ExecutorC1456Li.A00(s11);
        } else {
            this.A0B.getStateHandler().post(s11);
        }
    }
}
