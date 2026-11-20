package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9w, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11859w {
    public final int A00;
    public final long A01;
    public final long A02;
    public final AH A03;
    public final C1291Eo A04;
    public final TrackGroupArray A05;
    public final C1336Gk A06;
    public final Object A07;
    public final boolean A08;
    public volatile long A09;
    public volatile long A0A;

    public C11859w(AH ah2, long j11, TrackGroupArray trackGroupArray, C1336Gk c1336Gk) {
        this(ah2, null, new C1291Eo(0), j11, C.TIME_UNSET, 1, false, trackGroupArray, c1336Gk);
    }

    public C11859w(AH ah2, Object obj, C1291Eo c1291Eo, long j11, long j12, int i11, boolean z11, TrackGroupArray trackGroupArray, C1336Gk c1336Gk) {
        this.A03 = ah2;
        this.A07 = obj;
        this.A04 = c1291Eo;
        this.A02 = j11;
        this.A01 = j12;
        this.A0A = j11;
        this.A09 = j11;
        this.A00 = i11;
        this.A08 = z11;
        this.A05 = trackGroupArray;
        this.A06 = c1336Gk;
    }

    public static void A00(C11859w c11859w, C11859w c11859w2) {
        c11859w2.A0A = c11859w.A0A;
        c11859w2.A09 = c11859w.A09;
    }

    public final C11859w A01(int i11) {
        C11859w c11859w = new C11859w(this.A03, this.A07, this.A04.A00(i11), this.A02, this.A01, this.A00, this.A08, this.A05, this.A06);
        A00(this, c11859w);
        return c11859w;
    }

    public final C11859w A02(int i11) {
        C11859w c11859w = new C11859w(this.A03, this.A07, this.A04, this.A02, this.A01, i11, this.A08, this.A05, this.A06);
        A00(this, c11859w);
        return c11859w;
    }

    public final C11859w A03(AH ah2, Object obj) {
        C11859w c11859w = new C11859w(ah2, obj, this.A04, this.A02, this.A01, this.A00, this.A08, this.A05, this.A06);
        A00(this, c11859w);
        return c11859w;
    }

    public final C11859w A04(C1291Eo c1291Eo, long j11, long j12) {
        long j13 = j12;
        AH ah2 = this.A03;
        Object obj = this.A07;
        if (!c1291Eo.A01()) {
            j13 = C.TIME_UNSET;
        }
        return new C11859w(ah2, obj, c1291Eo, j11, j13, this.A00, this.A08, this.A05, this.A06);
    }

    public final C11859w A05(TrackGroupArray trackGroupArray, C1336Gk c1336Gk) {
        C11859w c11859w = new C11859w(this.A03, this.A07, this.A04, this.A02, this.A01, this.A00, this.A08, trackGroupArray, c1336Gk);
        A00(this, c11859w);
        return c11859w;
    }

    public final C11859w A06(boolean z11) {
        C11859w c11859w = new C11859w(this.A03, this.A07, this.A04, this.A02, this.A01, this.A00, z11, this.A05, this.A06);
        A00(this, c11859w);
        return c11859w;
    }
}
