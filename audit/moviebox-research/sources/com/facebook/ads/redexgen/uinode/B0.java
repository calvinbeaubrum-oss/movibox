package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
import java.util.HashMap;
import okio.Utf8;
import org.mvel2.ast.ASTNode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class B0 extends FrameLayout implements TD {
    public static byte[] A0A;
    public static String[] A0B = {"gR8VXB3ia", "OJTiurBFiCqcREvzh7o4PkhSqDGudpIq", "iaBHwIBC1utH6CwOSIC2yyAu4ZYXfJ61", "YdU4", "YcTfP9iPeB3iMp", "vsmHP1kkKyGC9kag", "2EZKw0n31g6TC4", "KAWIkc2sX"};
    public RE A00;
    public final int A01;
    public final AbstractC1898b5 A02;
    public final C1795Yn A03;
    public final J2 A04;
    public final C1454Lg A05;
    public final P0 A06;
    public final PB A07;
    public final String A08;
    public final boolean A09;

    static {
        A02();
    }

    public B0(C1795Yn c1795Yn, J2 j11, P0 p11, AbstractC1898b5 abstractC1898b5, String str, int i11, C1454Lg c1454Lg) {
        super(c1795Yn);
        this.A03 = c1795Yn;
        this.A04 = j11;
        this.A02 = abstractC1898b5;
        this.A08 = str;
        this.A06 = p11;
        this.A01 = i11;
        PB pbA02 = PC.A02(abstractC1898b5.A0S());
        if (pbA02 != null) {
            this.A07 = pbA02;
            this.A09 = true;
        } else {
            PB pb2 = new PB(c1795Yn, abstractC1898b5, j11, i11);
            this.A07 = pb2;
            PC.A03(abstractC1898b5, pb2);
            this.A09 = false;
        }
        if (c1454Lg != null) {
            this.A05 = c1454Lg;
            this.A07.A0Z(c1454Lg);
        } else {
            this.A05 = this.A07.A0L();
        }
        this.A07.A0c(new TK(this));
        this.A07.A0a(p11);
        LI.A04(this, LI.A0A);
        if (C1384Ih.A1W(c1795Yn)) {
            c1795Yn.A0A().AGx(this.A07.A0O(), abstractC1898b5.A12(), false, false, true);
        }
        A04();
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{118, 84, 91, Ascii.DC2, 65, Ascii.NAK, 70, 65, 84, 71, 65, Ascii.NAK, 116, 64, 81, 92, 80, 91, 86, 80, 123, 80, 65, 66, 90, 71, 94, 116, 86, 65, 92, 67, 92, 65, 76, Ascii.ESC, Ascii.NAK, 120, 84, 94, 80, Ascii.NAK, 70, 64, 71, 80, Ascii.NAK, 65, 93, 84, 65, Ascii.NAK, 92, 65, Ascii.DC2, 70, Ascii.NAK, 92, 91, Ascii.NAK, 76, 90, 64, 71, Ascii.NAK, 116, 91, 81, 71, 90, 92, 81, 120, 84, 91, 92, 83, 80, 70, 65, Ascii.ESC, 77, 88, 89, Ascii.NAK, 83, 92, 89, 80, Ascii.ESC, Ascii.RS, Ascii.SUB, Ascii.EM, 45, 60, 49, 61, 54, 59, 61, Ascii.SYN, 61, 44, 47, 55, 42, 51, 54, 57, 8, 54, 52, 35, 62, 33, 62, 35, 46, 77, 66, 71, 77, 69, 113, 93, 65, 91, 92, 77, 75, 55, 56, 45, 48, 47, 60, Ascii.CAN, 61, Ascii.GS, 56, 45, 56, Ascii.ESC, 44, 55, 61, 53, 60, 33, 39, 49, 38, 55, 56, 61, 55, Utf8.REPLACEMENT_BYTE, Ascii.SYN, 9, 5, Ascii.ETB, 52, Ascii.EM, Ascii.DLE, 5};
    }

    private final void A03() {
        this.A07.A0d(this);
        if (this.A09) {
            this.A03.A0E().A5I();
            String[] strArr = A0B;
            if (strArr[6].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[6] = "EW3rEVX7vA8fzU";
            strArr2[4] = "ztAtYR2DvpL08d";
            if (this.A07.A0k()) {
                if (this.A01 == 4) {
                    P0 p11 = this.A06;
                    if (p11 != null) {
                        p11.ABO(this);
                    }
                    if (C1384Ih.A1W(this.A03)) {
                        this.A03.A0A().ABG();
                    }
                } else {
                    AGY();
                }
            }
        } else {
            this.A03.A0E().A5H();
            this.A07.A0X();
        }
        A08();
    }

    private final void A04() {
        PB.A0B().incrementAndGet();
        A03();
        this.A07.A0W();
    }

    private void A05(Intent intent, AbstractC1898b5 abstractC1898b5) {
        intent.putExtra(A01(157, 8, 17), KB.A07);
        intent.putExtra(A01(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 18, 40), abstractC1898b5);
        intent.addFlags(ASTNode.DEOP);
    }

    private final void A06(AbstractC1898b5 abstractC1898b5) {
        AdActivityIntent adActivityIntentA04 = C1433Kj.A04(this.A03);
        A05(adActivityIntentA04, abstractC1898b5);
        try {
            C1433Kj.A0A(this.A03, adActivityIntentA04);
        } catch (Exception e11) {
            this.A03.A07().A9a(A01(107, 11, 38), C8A.A0D, new C8B(e11));
            Log.e(A01(90, 17, 41), A01(0, 90, 68), e11);
        }
    }

    private void A07(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C1517Nr c1517Nr = new C1517Nr(this.A03, this.A08, this.A00, this.A05, this.A04, this.A02.A0y());
        HashMap map = new HashMap();
        map.put(A01(118, 12, 95), A01(148, 9, 37));
        c1517Nr.A07(this.A02.A12(), str, map);
    }

    public final void A08() {
        AbstractC1462Lo.A0J(this.A07.A0O());
        addView(this.A07.A0O(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void A8S() {
        A07(this.A02.A0x().A0F().A05());
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void A8T(String str) {
        A07(str);
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void A8X() {
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void A9K() {
        new Handler(Looper.getMainLooper()).post(new TJ(this));
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void ABb() {
        A06(this.A02);
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void ABf() {
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void ACL(boolean z11) {
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void AD8() {
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void ADc(boolean z11) {
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void ADe(boolean z11) {
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void ADr(String str) {
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void AGY() {
        P0 p11 = this.A06;
        if (p11 != null) {
            p11.ABO(this);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.TD
    public final void close() {
    }

    public J2 getAdEventManager() {
        return this.A04;
    }

    public PB getDynamicWebViewController() {
        return this.A07;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setAdViewabilityChecker(RE re2) {
        this.A00 = re2;
        this.A07.A0e(re2);
    }
}
