package com.facebook.ads.redexgen.uinode;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Unexpected interfaces in signature: [com.facebook.ads.internal.util.common.Stateful<android.os.Bundle>] */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class QS {
    public static byte[] A0E;
    public static String[] A0F = {"nkjKj1MvUJoP2SJPYcgbaBjYPy4EsWOF", "UEaFlSlVJfgDxU2HAGuUlGjRHCZL3UC5", "HKOtxcgqDUvcB7Zt0rEFxuoEqCvYEtNO", "rowCAjgGiKT2zEBSq3xmGSL0Kf3UrlyG", "EJAz0i2eNdRPLBpGYGjYpv17GQTuD6uU", "hVbT72qq2pp8XHiEw", "RwROuq5e2nKVw7hJaeybV0hHAIDx5UQQ", "neuOh54FNoDLqHEFUxNtW4G7fWRiy4GW"};
    public int A00;
    public int A01;
    public QF A02;
    public String A03;
    public boolean A04;
    public final C1846aF A05;
    public final C1795Yn A06;
    public final J2 A07;
    public final QE A08;
    public final QK A09;
    public final QL A0A;
    public final Object A0B;
    public final String A0C;
    public final Map<String, String> A0D;

    static {
        A0N();
    }

    public QS(C1795Yn c1795Yn, J2 j11, QE qe2, List<C2P> list, String str, boolean z11, Bundle bundle, QK qk2) {
        this(c1795Yn, j11, qe2, list, str, z11, bundle, null, qk2);
    }

    public QS(C1795Yn c1795Yn, J2 j11, QE qe2, List<C2P> list, String str, boolean z11, Bundle bundle, Map<String, String> map, QK qk2) {
        this.A0B = new Object();
        this.A01 = 0;
        this.A00 = 0;
        this.A03 = null;
        this.A06 = c1795Yn;
        this.A07 = j11;
        this.A08 = qe2;
        this.A0C = str;
        this.A0D = map;
        this.A04 = z11;
        this.A09 = qk2;
        list.add(new QU(this, 0.5d, -1.0d, 2.0d, true));
        list.add(new QT(this, 1.0E-7d, -1.0d, 0.001d, false));
        if (bundle != null) {
            this.A05 = new C1846aF(list, bundle.getBundle(A0F(6, 16, 29)), qk2);
            this.A01 = bundle.getInt(A0F(57, 18, 2));
            this.A00 = bundle.getInt(A0F(39, 18, 44));
        } else {
            this.A05 = new C1846aF(list, qk2);
        }
        this.A0A = new QL(new Handler(), this);
    }

    public QS(C1795Yn c1795Yn, J2 j11, QE qe2, List<C2P> list, String str, boolean z11, QK qk2) {
        this(c1795Yn, j11, qe2, list, str, z11, null, qk2);
    }

    private final float A0E() {
        return AbstractC1459Ll.A00(this.A06) * this.A08.getVolume();
    }

    public static String A0F(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 48);
        }
        return new String(bArrCopyOfRange);
    }

    private Map<String, String> A0H(int i11) {
        HashMap<String, String> map = new HashMap<>();
        AbstractC1459Ll.A03(map, this.A08.getVideoStartReason() == QM.A02, !this.A08.A95());
        A0T(map);
        A0S(map);
        A0V(map, i11);
        A0U(map);
        A0R(map);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A0I(QG qg2) {
        return A0J(qg2, this.A08.getCurrentPositionInMillis());
    }

    private Map<String, String> A0J(QG qg2, int i11) {
        Map<String, String> mapA0H = A0H(i11);
        mapA0H.put(A0F(0, 6, 122), String.valueOf(qg2.A00));
        return mapA0H;
    }

    private void A0L() {
        A0Q(this.A0C, A0I(QG.A04));
    }

    private void A0M() {
        A0Q(this.A0C, A0I(QG.A0A));
    }

    public static void A0N() {
        A0E = new byte[]{Ascii.VT, Ascii.CR, Ascii.RS, 19, Ascii.EM, Ascii.CAN, -82, -79, -98, -62, -82, -71, -74, -63, -58, -102, -82, -69, -82, -76, -78, -65, -18, 1, -10, -6, -14, -20, -6, 0, -96, -77, -86, -85, -89, -100, -76, -96, -83, -56, -67, -49, -48, -98, -53, -47, -54, -64, -67, -50, -43, -80, -59, -55, -63, -87, -81, -98, -109, -91, -90, -126, -92, -95, -103, -92, -105, -91, -91, -122, -101, -97, -105, Ascii.DEL, -123, -21, -31, -33, -14, -35, -21, -15, -23, -33, -14, -16, -37, -23, -17, Ascii.DC4, Ascii.FF, -33, -37, -45, -43, -56, -45, Ascii.SUB, Ascii.RS, Ascii.CR, 17, 6, 10, 2, Ascii.ESC, 34, -87, -98, -94, -102, 37, Ascii.ESC, Ascii.DLE, -16, -26, -25, 19, 9, 10, -2, Ascii.NAK, -64, -70, -78, 10, 4, Ascii.VT, 5, 3, -8, -4, -12, -18, -4, 2, -64, -63, -87, -68, -67, -72, 0, 1, -21, -9, -8, -18, 5, 6, -4, -16, 7, -73, -87, -82, -92, -81, -73};
    }

    private final void A0O(int i11, boolean z11, boolean z12) {
        int i12;
        if (i11 <= 0.0d || i11 < (i12 = this.A01)) {
            return;
        }
        if (i11 > i12) {
            this.A05.A06((i11 - i12) / 1000.0f, A0E());
            this.A01 = i11;
            if (z12 || i11 - this.A00 >= 5000) {
                A0Q(this.A0C, A0J(QG.A09, i11));
                if (A0F[5].length() == 0) {
                    throw new RuntimeException();
                }
                String[] strArr = A0F;
                strArr[1] = "IXDsMs8MiMzYVjpFmNZXbOdNx8hS7U1p";
                strArr[6] = "KaqaEYbZ8TBX2kyM8fVmd1OK78kemUif";
                this.A00 = this.A01;
                this.A05.A05();
                return;
            }
        }
        if (z11) {
            A0Q(this.A0C, A0J(QG.A09, i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0Q(String str, Map<String, String> map) {
        this.A07.AAB(str, map);
        QF qf2 = this.A02;
        if (qf2 != null) {
            qf2.AC8();
        }
    }

    private void A0R(HashMap<String, String> map) {
        Map<String, String> map2 = this.A0D;
        if (map2 != null) {
            map.putAll(map2);
        }
    }

    private void A0S(Map<String, String> map) {
        C2R c2rA03 = this.A05.A03();
        C2Q c2qA00 = c2rA03.A00();
        map.put(A0F(141, 3, 90), String.valueOf(c2qA00.A00()));
        map.put(A0F(144, 3, 81), String.valueOf(c2qA00.A05()));
        map.put(A0F(147, 5, 95), String.valueOf(c2qA00.A02()));
        map.put(A0F(127, 8, 95), String.valueOf(c2qA00.A01() * 1000.0d));
        map.put(A0F(82, 7, 76), String.valueOf(c2qA00.A03() * 1000.0d));
        String str = this.A03;
        if (str != null) {
            map.put(A0F(TsExtractor.TS_STREAM_TYPE_E_AC3, 6, 26), str);
        }
        C2Q c2qA01 = c2rA03.A01();
        map.put(A0F(Worker.WHAT_QUIT, 3, 127), String.valueOf(c2qA01.A00()));
        map.put(A0F(113, 3, 74), String.valueOf(c2qA01.A05()));
        map.put(A0F(116, 5, 109), String.valueOf(c2qA01.A02()));
        map.put(A0F(22, 8, 93), String.valueOf(c2qA01.A01() * 1000.0d));
        map.put(A0F(75, 7, 78), String.valueOf(c2qA01.A03() * 1000.0d));
    }

    private void A0T(Map<String, String> map) {
        map.put(A0F(30, 9, 11), String.valueOf(this.A08.A92()));
        map.put(A0F(93, 4, 51), Long.toString(this.A08.getInitialBufferTime()));
    }

    private void A0U(Map<String, String> map) {
        Rect rect = new Rect();
        this.A08.getGlobalVisibleRect(rect);
        map.put(A0F(97, 2, 122), String.valueOf(rect.top));
        map.put(A0F(91, 2, 63), String.valueOf(rect.left));
        map.put(A0F(89, 2, 116), String.valueOf(this.A08.getMeasuredHeight()));
        map.put(A0F(104, 2, 123), String.valueOf(this.A08.getMeasuredWidth()));
        WindowManager windowManager = (WindowManager) this.A06.getSystemService(A0F(152, 6, 16));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        map.put(A0F(121, 3, 26), String.valueOf(displayMetrics.heightPixels));
        map.put(A0F(124, 3, 100), String.valueOf(displayMetrics.widthPixels));
    }

    private void A0V(Map<String, String> map, int i11) {
        map.put(A0F(99, 5, 109), String.valueOf(this.A00 / 1000.0f));
        map.put(A0F(106, 4, 5), String.valueOf(i11 / 1000.0f));
    }

    public final int A0W() {
        return this.A01;
    }

    public final Bundle A0X() {
        A0g(A0W(), A0W());
        Bundle bundle = new Bundle();
        bundle.putInt(A0F(57, 18, 2), this.A01);
        bundle.putInt(A0F(39, 18, 44), this.A00);
        bundle.putBundle(A0F(6, 16, 29), this.A05.A02());
        return bundle;
    }

    public final void A0Y() {
        A0Q(this.A0C, A0I(QG.A07));
    }

    public final void A0Z() {
        A0Q(this.A0C, A0I(QG.A08));
    }

    public final void A0a() {
        if (A0E() < 0.05d) {
            synchronized (this.A0B) {
                if (this.A04) {
                    A0L();
                    this.A04 = false;
                }
            }
            return;
        }
        synchronized (this.A0B) {
            if (!this.A04) {
                A0M();
                this.A04 = true;
            }
        }
    }

    public final void A0b() {
        this.A06.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.A0A);
    }

    public final void A0c() {
        this.A06.getContentResolver().unregisterContentObserver(this.A0A);
    }

    public final void A0d(int i11) {
        this.A05.A04();
        A0Q(this.A0C, A0I(QG.A05));
        A0O(i11, false, ((double) i11) < 2000.0d);
    }

    public final void A0e(int i11) {
        A0O(i11, true, false);
        this.A00 = 0;
        this.A01 = 0;
        this.A05.A05();
        this.A05.A04();
    }

    public final void A0f(int i11) {
        A0O(i11, false, false);
    }

    public final void A0g(int i11, int i12) {
        A0O(i11, true, false);
        this.A00 = i12;
        this.A01 = i12;
        this.A05.A05();
        this.A05.A04();
    }

    public final void A0h(QF qf2) {
        this.A02 = qf2;
    }
}
