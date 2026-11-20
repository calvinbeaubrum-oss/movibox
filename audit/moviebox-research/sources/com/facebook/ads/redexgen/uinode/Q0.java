package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Q0 extends FrameLayout {
    public static byte[] A0C;
    public static String[] A0D = {"2LrpfYyae0azpeRldXrTpIs5j5WolZYJ", "aTWFoH17M5HvBaS06GyoTMgY8LK09kB1", "ZT9jJV1ne", "vwbwskwEgIVHj6V8wHV", "a8UIfMhCahgZVDol7QIaAFMNjSR7v8Rm", "pauq9xVSe1TSbn6Nh8iDWIypG", "tig0s2h3zWgeN1kA13N6tuAlrnUP1dby", "gu60Pcp0oAdbO9RcUpkXMIBgrMh0CW0V"};
    public static final float A0E;
    public static final RelativeLayout.LayoutParams A0F;
    public int A00;
    public long A01;
    public Map<String, String> A02;
    public final AbstractC1898b5 A03;
    public final C09721c A04;
    public final C1795Yn A05;
    public final J2 A06;
    public final InterfaceC1501Nb A07;
    public final C1674Ts A08;
    public final InterfaceC1576Py A09;
    public final AtomicBoolean A0A;
    public final AtomicBoolean A0B;

    static {
        A09();
        A0E = (int) (LD.A02 * 4.0f);
        A0F = new RelativeLayout.LayoutParams(-1, -1);
    }

    public Q0(C1795Yn c1795Yn, AbstractC1898b5 abstractC1898b5, C09721c c09721c, J2 j11, InterfaceC1576Py interfaceC1576Py, Map<String, String> map) {
        super(c1795Yn);
        this.A0A = new AtomicBoolean(false);
        this.A0B = new AtomicBoolean(false);
        this.A01 = -1L;
        this.A00 = 0;
        this.A07 = new AbstractC1677Tv() { // from class: com.facebook.ads.redexgen.X.9O
            @Override // com.facebook.ads.redexgen.uinode.InterfaceC1501Nb
            public final void AAn() {
            }

            @Override // com.facebook.ads.redexgen.uinode.AbstractC1677Tv, com.facebook.ads.redexgen.uinode.InterfaceC1501Nb
            public final void ABW(int i11, String str) {
                this.A00.A0B.set(true);
                this.A00.A09.AC4();
            }

            @Override // com.facebook.ads.redexgen.uinode.InterfaceC1501Nb
            public final void ABj() {
                if (this.A00.A0B.get() || !this.A00.A0A.compareAndSet(false, true)) {
                    return;
                }
                this.A00.A09.ABj();
            }

            @Override // com.facebook.ads.redexgen.uinode.InterfaceC1501Nb
            public final void ADj() {
                this.A00.A09.ADj();
            }
        };
        this.A05 = c1795Yn;
        this.A03 = abstractC1898b5;
        this.A04 = c09721c;
        this.A06 = j11;
        this.A09 = interfaceC1576Py;
        this.A02 = map;
        C1674Ts c1674TsA04 = A04();
        this.A08 = c1674TsA04;
        if (C1384Ih.A1W(c1795Yn)) {
            c1795Yn.A0A().AGv(c1674TsA04, abstractC1898b5.A12(), false);
        }
        addView(c1674TsA04, A0F);
    }

    public static /* synthetic */ int A00(Q0 q11) {
        int i11 = q11.A00;
        q11.A00 = i11 + 1;
        return i11;
    }

    private C1674Ts A04() {
        C1674Ts c1674Ts = new C1674Ts(this.A05, (WeakReference<InterfaceC1501Nb>) new WeakReference(this.A07), 10, C1384Ih.A1f(this.A05));
        c1674Ts.setCornerRadius(A0E);
        c1674Ts.setLogMultipleImpressions(false);
        c1674Ts.setCheckAssetsByJavascriptBridge(false);
        c1674Ts.setWebViewTimeoutInMillis(this.A04.A08());
        c1674Ts.setRequestId(this.A03.A0S());
        c1674Ts.setOnTouchListener(new ViewOnTouchListenerC1577Pz(this));
        WebSettings settings = c1674Ts.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
        }
        if (Build.VERSION.SDK_INT > 16) {
            c1674Ts.addJavascriptInterface(new Q1(this.A05, this, this.A06, this.A02, this.A03.A12()), A06(0, 12, 104));
        }
        return c1674Ts;
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            int i15 = bArrCopyOfRange[i14] ^ i13;
            if (A0D[5].length() != 25) {
                throw new RuntimeException();
            }
            A0D[4] = "2xsSJQdmJTzWNKbVkLPVv70adF3crTtp";
            bArrCopyOfRange[i14] = (byte) (i15 ^ 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0C = new byte[]{Ascii.VT, 47, Ascii.GS, 33, 44, 52, 44, 47, 33, 40, Ascii.FF, 41, 52, 5, Ascii.SYN, Ascii.ETB, Ascii.CR, 10, 3, 68, 1, Ascii.SYN, Ascii.SYN, Ascii.VT, Ascii.SYN, 52, 8, 5, Ascii.GS, 5, 6, 8, 1, 68, 0, Ascii.VT, 39, Ascii.DLE, 5, 39, 8, Ascii.CR, 7, Ascii.SI, 68, Ascii.DLE, Ascii.SYN, Ascii.CR, 3, 3, 1, Ascii.SYN, 1, 0, 68, 19, Ascii.CR, Ascii.DLE, Ascii.FF, 68, Ascii.DC4, Ascii.SYN, 1, 73, 1, Ascii.DC2, 1, 10, Ascii.DLE, 68, 7, 8, Ascii.CR, 7, Ascii.SI, Ascii.ETB, 68, 7, Ascii.VT, 17, 10, Ascii.DLE, 68, 5, 10, 0, 68, 32, 1, 8, 5, Ascii.GS, 106, 86, 91, 67, 91, 88, 86, 95, 123, 94, 73, 108, 83, 95, 77, 102, 97, 99, 109, 106, 36, 104, 107, 101, 96, 109, 106, 99, 36, 118, 97, 105, 107, 112, 97, 36, 116, 104, 101, 125, 101, 102, 104, 97, 61, 50, 55, 61, 53, 45, 112, 113, 120, 117, 109, 93, 65, 76, 84, 76, 79, 65, 72, 55, 43, 38, 62, 38, 37, 43, 34, Ascii.CAN, 53, 34, 42, 40, 51, 34, Ascii.NAK, 2, 10, 8, 19, 2, 56, Ascii.DC4, 2, Ascii.DC4, Ascii.DC4, Ascii.SO, 8, 9, 56, Ascii.SO, 3, Ascii.DC4, Ascii.SI, Ascii.VT, 5, Ascii.SO, 107, 121, 126, 67, 106, 117, 121, 107};
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00b8, code lost:
    
        if (r3 <= com.facebook.ads.redexgen.uinode.C1384Ih.A0H(r8)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00ba, code lost:
    
        r3 = r9.A09;
        r2 = com.facebook.ads.redexgen.uinode.Q0.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ce, code lost:
    
        if (r2[0].charAt(14) == r2[7].charAt(14)) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00d0, code lost:
    
        r3.ABD();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00d3, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d4, code lost:
    
        r2 = com.facebook.ads.redexgen.uinode.Q0.A0D;
        r2[0] = "1qrV4xG42mjJ5wR1PYF4mguO0xYm8sMw";
        r2[7] = "To2gWJFbGkwQ4PRGYAw3BZd3UXo54AHv";
        r3.ABD();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00f2, code lost:
    
        if (r3 <= com.facebook.ads.redexgen.uinode.C1384Ih.A0H(r8)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00f5, code lost:
    
        r7.A05(0);
        r9.A05.A07().A9a(r6, com.facebook.ads.redexgen.uinode.C8A.A2E, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0A() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.A01;
        C8B c8b = new C8B(A06(25, 67, 65));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A06(136, 6, 123), this.A00);
            jSONObject.put(A06(142, 5, 49), jCurrentTimeMillis);
            jSONObject.put(A06(187, 5, 69), this.A03.A12());
        } catch (JSONException e11) {
            Log.e(A06(92, 15, 31), A06(12, 13, 65), e11);
        }
        c8b.A07(jSONObject);
        c8b.A05(1);
        C1795Yn c1795Yn = this.A05;
        if (A0D[2].length() == 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[0] = "lhJ8s2Q4sCds7IROMAxOWHrUi0xft2U2";
        strArr[7] = "JiEJ4GJfM63VUjRSw5kXmgHmRai0omG0";
        AnonymousClass89 anonymousClass89A07 = c1795Yn.A07();
        int i11 = C8A.A2D;
        String strA06 = A06(147, 8, 8);
        anonymousClass89A07.A9b(strA06, i11, c8b);
        this.A00 = 0;
        if (!C1384Ih.A1S(this.A05)) {
            this.A09.ABD();
        } else {
            C1795Yn c1795Yn2 = this.A05;
            if (A0D[6].charAt(9) == 'W') {
                A0D[3] = "";
            }
        }
    }

    public final void A0B() {
        if (this.A04.A0J()) {
            C8B c8b = new C8B(A06(107, 29, 33));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(A06(170, 17, 66), this.A04.A0F());
                jSONObject.put(A06(187, 5, 69), this.A03.A12());
            } catch (JSONException e11) {
                Log.e(A06(92, 15, 31), A06(12, 13, 65), e11);
            }
            c8b.A07(jSONObject);
            c8b.A05(1);
            AnonymousClass89 anonymousClass89A07 = this.A05.A07();
            if (A0D[4].charAt(0) == 'P') {
                throw new RuntimeException();
            }
            A0D[1] = "TEDpWyR4sKSlO4xRZxixfnQAFgDgpHMF";
            int i11 = C8A.A2G;
            String strA06 = A06(155, 15, 98);
            anonymousClass89A07.A9b(strA06, i11, c8b);
            if (C1384Ih.A0m(this.A05) && AbstractC1451Ld.A00(this.A05) == EnumC1450Lc.A07) {
                this.A05.A07().A9b(strA06, C8A.A2F, c8b);
                this.A07.ABW(0, null);
                return;
            }
        }
        try {
            this.A08.loadUrl(!TextUtils.isEmpty(this.A04.A0B()) ? this.A04.A0B() : this.A04.A0E());
        } catch (Exception e12) {
            this.A05.A07().A9a(A06(PsExtractor.AUDIO_STREAM, 8, 57), C8A.A2d, new C8B(e12));
        }
    }

    public final void A0C() {
        if (C1384Ih.A1W(this.A05)) {
            C1795Yn c1795Yn = this.A05;
            if (A0D[2].length() == 31) {
                throw new RuntimeException();
            }
            A0D[1] = "2a9geg5CZy9bcTekyOeVTlcxLNQduX9G";
            c1795Yn.A0A().AGk(this.A08);
        }
        this.A08.removeJavascriptInterface(A06(0, 12, 104));
        if (A0D[3].length() == 23) {
            this.A08.destroy();
        } else {
            A0D[6] = "33aduEcFLWt6pdjLdZ5sJJvVvr5WDkst";
            this.A08.destroy();
        }
    }

    public C1454Lg getTouchDataRecorder() {
        return this.A08.getTouchDataRecorder();
    }

    public RE getViewabilityChecker() {
        return this.A08.getViewabilityChecker();
    }
}
