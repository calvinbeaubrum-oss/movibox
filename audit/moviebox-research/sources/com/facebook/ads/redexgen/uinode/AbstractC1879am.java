package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.am, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1879am implements K3 {
    public static byte[] A0D;
    public static String[] A0E = {"4yJhIog9RzpC9w4XHjq79o6hmz2pMXrt", "bLneqHgNlbzxjE", "P7gevZ65hMGDm5VmgpkLcWEi46YxYduR", "Pajg2XTKXpS0pN0AoGLcPnQoa2IWF6Z7", "YyJRdl3XxpBTstTmsw", "OvgbPt0JG7dlaj99kqPbJKVmb9CPKTVr", "21VbiQWRKHmC0d4xB3zoTsbqXtN2ZOxw", "Q3Y9mBD7X4l0uaedlY7FP5X0xCsXbtIX"};
    public static final Handler A0F;
    public static final C09640u A0G = null;
    public static final K4 A0H = null;
    public static final String A0I;
    public InterfaceC09590p A00;
    public InterfaceC09590p A01;
    public C8S A04;
    public K1 A05;
    public AbstractC09600q A06;
    public final C09901u A07;
    public final J2 A08;
    public final C09640u A09;
    public final K4 A0A;
    public final C1795Yn A0B;
    public volatile boolean A0C;
    public long A03 = -1;
    public String A02 = null;

    static {
        A08();
        AbstractC1464Lq.A02();
        A0I = AbstractC1879am.class.getSimpleName();
        A0F = new Handler(Looper.getMainLooper());
    }

    public AbstractC1879am(C1795Yn c1795Yn, C09901u c09901u) {
        this.A0B = c1795Yn;
        this.A07 = c09901u;
        K4 k11 = A0H;
        if (k11 != null) {
            this.A0A = k11;
        } else {
            this.A0A = new K4(c1795Yn);
        }
        this.A0A.A0P(this);
        C09640u c09640u = A0G;
        if (c09640u != null) {
            this.A09 = c09640u;
        } else {
            this.A09 = new C09640u();
        }
        DynamicLoaderFactory.makeLoader(c1795Yn).getInitApi().onAdLoadInvoked(c1795Yn);
        this.A08 = c1795Yn.A09();
        c1795Yn.A0E().A4r();
    }

    public static String A07(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0D = new byte[]{75, 110, 107, 122, 126, 111, 120, 42, 110, 101, 111, 121, 42, 100, 101, 126, 42, 111, 114, 99, 121, 126, 78, 107, 110, Ascii.DEL, 123, 106, 125, 47, 102, 124, 47, 97, 122, 99, 99, 47, 39, 108, 103, 110, 102, 97, 47, 97, 96, 123, 47, 99, 96, 110, 107, 106, 107, 38, 57, Ascii.FS, Ascii.EM, 8, Ascii.FF, Ascii.GS, 10, 88, 17, Ascii.VT, 88, Ascii.SYN, Ascii.CR, Ascii.DC4, Ascii.DC4, 88, 80, Ascii.ESC, Ascii.DLE, Ascii.EM, 17, Ascii.SYN, Ascii.GS, Ascii.FS, 81, 45, 8, Ascii.CR, Ascii.FS, Ascii.CAN, 9, Ascii.RS, 76, 5, Ascii.US, 76, 2, Ascii.EM, 0, 0, 76, 68, 2, 3, 76, Ascii.SI, 4, Ascii.CR, 5, 2, 69, 78, 107, 110, Ascii.DEL, 123, 106, 125, 47, 102, 124, 47, 97, 122, 99, 99, 47, 96, 97, 47, 124, 123, 110, 125, 123, 78, 107, 5, 36, 107, 38, 36, 57, 46, 107, 42, 47, 107, 40, 42, 37, 47, 34, 47, 42, Utf8.REPLACEMENT_BYTE, 46, 56, 101, 122, 95, 66, 67, 74, Ascii.CR, 76, 73, 76, 93, 89, 72, 95, Ascii.CR, 89, 84, 93, 72, 3, 46, 43, 111, 46, 35, 61, 42, 46, 43, 54, 111, 60, 59, 46, 61, 59, 42, 43, 94, 91, 76, 52, 37, 60, Ascii.SUB, 17, Ascii.CAN, Ascii.DLE, Ascii.ETB, 38, 9, Ascii.CAN, Ascii.VT, Ascii.CAN, Ascii.DC4, 10, 76, 91, 74, 79, 90, 79, 97, 76, 68, 75, 77, 90, Ascii.SO, 71, 93, Ascii.SO, 64, 91, 66, 66, 38, 45, 32, 49, 58, 51, 55, 38, 39, Ascii.FS, 42, 39, 122, 113, 105, 118, 109, 112, 113, 114, 122, 113, 107, Utf8.REPLACEMENT_BYTE, 118, 108, Utf8.REPLACEMENT_BYTE, 122, 114, 111, 107, 102, 38, 50, 37, 49, 53, 37, 46, 35, 57, Ascii.US, 35, 33, 48, 48, 41, 46, 39, Ascii.FS, Ascii.ESC, 3, Ascii.DC4, Ascii.EM, Ascii.FS, 17, 85, 5, Ascii.EM, Ascii.DC4, Ascii.SYN, Ascii.DLE, Ascii.CAN, Ascii.DLE, Ascii.ESC, 1, 85, Ascii.FS, Ascii.ESC, 85, 7, Ascii.DLE, 6, 5, Ascii.SUB, Ascii.ESC, 6, Ascii.DLE, 10, 9, 7, 2, 57, Ascii.DC2, Ascii.SI, Ascii.VT, 3, 57, Ascii.VT, Ascii.NAK, 44, 59, 47, 43, 59, 45, 42, 1, 55, 58};
    }

    private void A09(C1697Up c1697Up) {
        C8S c8sA00 = c1697Up.A00();
        if (c8sA00 == null || c8sA00.A05() == null) {
            String strA07 = A07(279, 29, 125);
            C1401Jb c1401Jb = new C1401Jb(AdErrorType.NO_AD_PLACEMENT, strA07);
            this.A0B.A0E().A4t(c1401Jb.A03().getErrorCode(), strA07);
            AbstractC09600q abstractC09600q = this.A06;
            if (abstractC09600q != null) {
                abstractC09600q.A0G(c1401Jb);
                return;
            }
            return;
        }
        this.A04 = c8sA00;
        this.A00 = null;
        C8S c8s = this.A04;
        JSONObject jSONObjectA09 = c8s.A09();
        String strA08 = A07(195, 3, 93);
        if (jSONObjectA09 == null) {
            C8Q c8qA04 = c8s.A04();
            if (A0D(c8s, c8qA04)) {
                if (this.A00 != null) {
                    A0O(this.A00, c8s, c8qA04, new C09911v(c8qA04.A04(), c8s.A05(), this.A07.A0A, c8s.A05().A0C()));
                    return;
                }
                this.A0B.A07().A9a(strA08, C8A.A0a, new C8B(A07(81, 26, 100), c8qA04.A02()));
                ABR(C1401Jb.A00(AdErrorType.INTERNAL_ERROR));
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        C8Q c8qA05 = c8s.A04();
        do {
            if (arrayList.isEmpty()) {
                if (!A0D(c8s, c8qA05)) {
                    return;
                } else {
                    arrayList.add(c8qA05);
                }
            } else if (A0C(c8qA05)) {
                arrayList.add(c8qA05);
            }
            c8qA05 = c8s.A04();
        } while (c8qA05 != null);
        if (this.A00 == null) {
            this.A0B.A07().A9a(strA08, C8A.A0a, new C8B(A07(56, 25, 112), ((C8Q) arrayList.get(0)).A02()));
            ABR(C1401Jb.A00(AdErrorType.INTERNAL_ERROR));
            return;
        }
        boolean z11 = false;
        try {
            if (arrayList.size() > 1 && this.A00.AGd()) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((C8Q) it.next()).A04());
                }
                jSONObject.put(A07(PsExtractor.AUDIO_STREAM, 3, 55), jSONArray);
                jSONObject.put(A07(198, 12, 113), c8s.A09());
                A0O(this.A00, c8s, c8qA05, new C09911v(jSONObject, c8s.A05(), this.A07.A0A, c8s.A05().A0C()));
                z11 = true;
            }
        } catch (Exception unused) {
            z11 = false;
        }
        if (z11) {
            return;
        }
        if (arrayList.isEmpty()) {
            C1401Jb c1401JbA01 = C1401Jb.A01(AdErrorType.NO_FILL, A07(0, 0, 73));
            this.A0B.A0E().A4t(c1401JbA01.A03().getErrorCode(), A07(133, 22, 67));
            AbstractC09600q abstractC09600q2 = this.A06;
            if (abstractC09600q2 != null) {
                abstractC09600q2.A0G(c1401JbA01);
                return;
            }
            return;
        }
        InterfaceC09590p interfaceC09590p = this.A00;
        String[] strArr = A0E;
        if (strArr[4].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[0] = "F2ixlBYVHNYJB4bAHADqJrSynawwg1yM";
        strArr2[5] = "djkwyiiWLTaQwWMcVWQWfq0o8Ww2Jgo9";
        if (interfaceC09590p != null) {
            C8Q c8q = (C8Q) arrayList.get(0);
            A0O(this.A00, c8s, c8q, new C09911v(c8q.A04(), c8s.A05(), this.A07.A0A, c8s.A05().A0C()));
        } else {
            this.A0B.A07().A9a(strA08, C8A.A0a, new C8B(A07(22, 34, 7), ((C8Q) arrayList.get(0)).A02()));
            ABR(C1401Jb.A00(AdErrorType.INTERNAL_ERROR));
        }
    }

    private final void A0A(String str, AdExperienceType adExperienceType) {
        this.A0B.A0E().A4u(str != null);
        this.A03 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT < 17) {
            ABR(new C1401Jb(AdErrorType.API_NOT_SUPPORTED, A07(0, 0, 73)));
            return;
        }
        try {
            K1 k1A01 = this.A07.A01(this.A0B, new C1410Jl(this.A0B, str, this.A07.A0A, this.A07.A09), adExperienceType);
            this.A05 = k1A01;
            this.A0A.A0O(k1A01);
        } catch (C1402Jc e11) {
            C1401Jb c1401JbA02 = C1401Jb.A02(e11);
            if (A0E[6].charAt(21) == '6') {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[4] = "3q2wB1pMY3UXfOrLgu";
            strArr[1] = "CsXqAZILgfX2KA";
            ABR(c1401JbA02);
        }
    }

    private void A0B(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.A02 = jSONObject.optString(A07(230, 12, 75));
            C09660w.A01(this.A0B).A0O(jSONObject);
        }
    }

    private boolean A0C(C8Q c8q) {
        return (c8q == null || c8q.A04() == null) ? false : true;
    }

    private boolean A0D(C8S c8s, C8Q c8q) {
        String strA07 = A07(0, 0, 73);
        if (c8q == null) {
            C1401Jb c1401JbA01 = C1401Jb.A01(AdErrorType.NO_FILL, strA07);
            this.A0B.A0E().A4t(c1401JbA01.A03().getErrorCode(), A07(133, 22, 67));
            AbstractC09600q abstractC09600q = this.A06;
            if (abstractC09600q != null) {
                abstractC09600q.A0G(c1401JbA01);
            }
            return false;
        }
        String strA02 = c8q.A02();
        InterfaceC09590p interfaceC09590pA00 = this.A09.A00(this.A0B, c8s.A05().A0D());
        if (interfaceC09590pA00 == null) {
            this.A0B.A07().A9a(A07(195, 3, 93), C8A.A0a, new C8B(A07(0, 22, 2), strA02));
            ABR(C1401Jb.A00(AdErrorType.INTERNAL_ERROR));
            return false;
        }
        if (this.A07.A00() != interfaceC09590pA00.A7e()) {
            C1401Jb c1401JbA02 = C1401Jb.A01(AdErrorType.INTERNAL_ERROR, strA07);
            this.A0B.A0E().A4t(c1401JbA02.A03().getErrorCode(), A07(155, 19, 37));
            AbstractC09600q abstractC09600q2 = this.A06;
            if (abstractC09600q2 != null) {
                abstractC09600q2.A0G(c1401JbA02);
            }
            return false;
        }
        this.A00 = interfaceC09590pA00;
        String[] strArr = A0E;
        if (strArr[4].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[0] = "MKxF4EMWgzzLH5X7HNcHVA2i4zdAiZz9";
        strArr2[5] = "4tfdEW2uI31voJBW941pIR5b1aNGKiQe";
        JSONObject jSONObjectA04 = c8q.A04();
        if (jSONObjectA04 == null) {
            String strA08 = A07(212, 18, 38);
            C1401Jb c1401JbA03 = C1401Jb.A01(AdErrorType.UNKNOWN_ERROR, strA08);
            this.A0B.A0E().A4t(c1401JbA03.A03().getErrorCode(), strA08);
            AbstractC09600q abstractC09600q3 = this.A06;
            if (abstractC09600q3 != null) {
                abstractC09600q3.A0G(c1401JbA03);
            }
            return false;
        }
        String strOptString = jSONObjectA04.optString(A07(320, 10, 86));
        this.A0B.A0E().AGD(strOptString);
        this.A0B.A0C(strOptString);
        C1794Ym c1794YmA00 = AbstractC11227e.A00();
        if (c1794YmA00 != null) {
            c1794YmA00.A0C(strOptString);
        }
        A0B(jSONObjectA04.optJSONObject(A07(262, 17, 72)));
        if (this.A05 != null) {
            return true;
        }
        String strA09 = A07(242, 20, 23);
        C1401Jb c1401JbA04 = C1401Jb.A01(AdErrorType.UNKNOWN_ERROR, strA09);
        this.A0B.A0E().A4t(c1401JbA04.A03().getErrorCode(), strA09);
        AbstractC09600q abstractC09600q4 = this.A06;
        if (abstractC09600q4 != null) {
            abstractC09600q4.A0G(c1401JbA04);
        }
        return false;
    }

    public final long A0E() {
        C8S c8s = this.A04;
        if (c8s != null) {
            return c8s.A03();
        }
        return -1L;
    }

    public final Handler A0F() {
        return A0F;
    }

    public C1F A0G() {
        return ((AbstractC1902b9) this.A01).A0H();
    }

    public final C8T A0H() {
        C8S c8s = this.A04;
        if (c8s == null) {
            return null;
        }
        return c8s.A05();
    }

    public final void A0I() {
        String strA6T;
        this.A0B.A0E().A2q(C1453Lf.A01(this.A03));
        InterfaceC09590p interfaceC09590p = this.A01;
        if (interfaceC09590p == null || (strA6T = interfaceC09590p.A6T()) == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(A07(308, 12, Worker.WHAT_QUIT), C1453Lf.A04(this.A03));
        new JA(strA6T, this.A08).A04(J9.A08, map);
    }

    public final void A0J() {
        InterfaceC09590p interfaceC09590p = this.A01;
        String strA07 = A07(195, 3, 93);
        if (interfaceC09590p == null) {
            String strA08 = A07(107, 26, 7);
            this.A0B.A07().A9a(strA07, C8A.A0Q, new C8B(strA08));
            AdErrorType adErrorType = AdErrorType.INTERNAL_ERROR;
            this.A0B.A0E().A4t(adErrorType.getErrorCode(), strA08);
            AbstractC09600q abstractC09600q = this.A06;
            if (abstractC09600q != null) {
                abstractC09600q.A0G(C1401Jb.A01(adErrorType, adErrorType.getDefaultErrorMessage()));
            }
            this.A0B.A0E().A4w();
            return;
        }
        if (!this.A0C) {
            if (!TextUtils.isEmpty(this.A01.A6T())) {
                this.A08.AA3(this.A01.A6T());
            }
            this.A0B.A0E().A4x();
            this.A0C = true;
            A0M();
            return;
        }
        String strA09 = A07(174, 18, 71);
        this.A0B.A07().A9a(strA07, C8A.A0M, new C8B(strA09));
        AdErrorType adErrorType2 = AdErrorType.AD_ALREADY_STARTED;
        this.A0B.A0E().A4t(adErrorType2.getErrorCode(), strA09);
        AbstractC09600q abstractC09600q2 = this.A06;
        if (abstractC09600q2 != null) {
            abstractC09600q2.A0G(C1401Jb.A01(adErrorType2, adErrorType2.getDefaultErrorMessage()));
        }
        this.A0B.A0E().A4v();
    }

    public final void A0K() {
        A0V(false);
    }

    public final void A0L() {
        if (this.A02 != null) {
            C09660w.A01(this.A0B).A0N(this.A02);
        }
    }

    public abstract void A0M();

    public final void A0N(InterfaceC09590p interfaceC09590p) {
        if (interfaceC09590p != null) {
            interfaceC09590p.onDestroy();
        }
    }

    public abstract void A0O(InterfaceC09590p interfaceC09590p, C8S c8s, C8Q c8q, C09911v c09911v);

    public final void A0P(AbstractC09600q abstractC09600q) {
        this.A06 = abstractC09600q;
    }

    public final void A0Q(C09911v c09911v) {
        A0S(c09911v.A03().optString(A07(210, 2, 39)));
    }

    public void A0R(String str) {
        A0A(str, null);
    }

    public final void A0S(String str) {
        this.A0B.A0E().A4q();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new JA(str, this.A08).A04(J9.A04, null);
    }

    public final void A0T(String str) {
        A0R(str);
    }

    public final void A0U(String str, AdExperienceType adExperienceType) {
        A0A(str, adExperienceType);
    }

    public void A0V(boolean z11) {
        if (z11 || this.A0C) {
            this.A0B.A0E().A4y();
            A0N(this.A01);
            this.A0C = false;
        }
    }

    public final boolean A0W() {
        C8S c8s = this.A04;
        return c8s == null || c8s.A0C();
    }

    @Override // com.facebook.ads.redexgen.uinode.K3
    public final synchronized void ABR(C1401Jb c1401Jb) {
        A0F().post(new C1880an(this, c1401Jb));
    }

    @Override // com.facebook.ads.redexgen.uinode.K3
    public final synchronized void ADG(C1697Up c1697Up) {
        try {
            A09(c1697Up);
        } catch (Exception e11) {
            this.A0B.A07().A9a(A07(195, 3, 93), C8A.A0T, new C8B(e11));
        }
    }
}
