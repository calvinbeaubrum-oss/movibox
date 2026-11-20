package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.sync.SyncModifiableBundle;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11166x implements InterfaceC1360Hj, InterfaceC1618Ro {
    public static byte[] A0A;
    public static String[] A0B = {"5Oiv1GLvIq7zEHzIHOTPzi3kaYzi9CKu", "OYJ8Vha7o3AKqeq5fQgjy4YAYzCEKBrH", "4fHxCa0vWIAizdOtLSYViH6HX8wZM136", "7SeobKfCaIBp1RCtBr0PVzHsRPnznuT1", "fOxTiSwrZex6", "3vZIMeafrjOpHP1eiyT8MHuy7IIJRNdQ", "XI5vdZH0G6FndxBvW8fNBqRq2FpLqBJ1", "pJZH6qXQIaEu24ksEJ9XliOUqsc1pAkZ"};
    public final C11237f A00;
    public final InterfaceC11357w A01;
    public final RK A02;
    public final InterfaceC1619Rp A03;
    public final C1627Rx A04;
    public final InterfaceC1628Ry A05;
    public final String A06;
    public final Map<EnumC1614Rk, C1373Hw> A09 = new HashMap();
    public final Map<EnumC1614Rk, AnonymousClass74> A08 = new HashMap();
    public final List<S2> A07 = new ArrayList();

    static {
        A05();
    }

    public C11166x(C11237f c11237f, InterfaceC11357w interfaceC11357w, RK rk2, String str, InterfaceC1628Ry interfaceC1628Ry, C1627Rx c1627Rx, InterfaceC1617Rn interfaceC1617Rn) {
        this.A00 = c11237f;
        this.A01 = interfaceC11357w;
        this.A02 = rk2;
        this.A06 = str;
        this.A05 = interfaceC1628Ry;
        this.A04 = c1627Rx;
        this.A03 = interfaceC1617Rn.A4V(this);
    }

    public static int A00(JSONObject jSONObject) throws JSONException {
        int i11 = jSONObject.getJSONObject(A01(335, 7, 80)).getInt(A01(446, 16, 70));
        if (i11 > 0) {
            return i11;
        }
        throw new JSONException(String.format(Locale.US, A01(TsExtractor.TS_STREAM_TYPE_AC3, 24, 117), Integer.valueOf(i11)));
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 17);
        }
        return new String(bArrCopyOfRange);
    }

    private Set<S1> A02(JSONObject jSONObject) throws JSONException {
        HashSet hashSet = new HashSet();
        JSONObject jSONObject2 = jSONObject.getJSONObject(A01(369, 8, 65));
        JSONObject jSONObject3 = jSONObject.getJSONObject(A01(298, 7, 38));
        for (final C1373Hw c1373Hw : this.A09.values()) {
            switch (S0.A01[S6.A00(jSONObject2.getString(c1373Hw.A7A().A03())).ordinal()]) {
                case 1:
                    final JSONObject jSONObject4 = jSONObject3.getJSONObject(c1373Hw.A7A().A03()).getJSONObject(A01(312, 4, 17));
                    final JSONObject jSONObjectOptJSONObject = jSONObject3.getJSONObject(c1373Hw.A7A().A03()).optJSONObject(A01(316, 11, 48));
                    hashSet.add(new HN(c1373Hw, jSONObject4, jSONObjectOptJSONObject) { // from class: com.facebook.ads.redexgen.X.70
                        public final JSONObject A00;
                        public final JSONObject A01;

                        {
                            S6 s11 = S6.A03;
                            this.A00 = jSONObject4;
                            this.A01 = jSONObjectOptJSONObject;
                        }

                        @Override // com.facebook.ads.redexgen.uinode.HN, com.facebook.ads.redexgen.uinode.S1
                        public final void A3Z(Map<InterfaceC1613Rj, S6> map, Map<SyncModifiableBundle, EnumC1623Rt> map2) {
                            super.A00.A03(this.A00, this.A01);
                            super.A3Z(map, map2);
                        }
                    });
                    break;
                case 2:
                    hashSet.add(new HN(c1373Hw) { // from class: com.facebook.ads.redexgen.X.6z
                        {
                            S6 s11 = S6.A04;
                        }
                    });
                    break;
                default:
                    throw new AssertionError();
            }
        }
        Iterator<AnonymousClass74> it = this.A08.values().iterator();
        while (it.hasNext()) {
            it.next();
            final AnonymousClass74 anonymousClass74 = null;
            switch (S0.A00[EnumC1623Rt.A00(jSONObject2.getString(anonymousClass74.A7A().A03())).ordinal()]) {
                case 1:
                    hashSet.add(new HT(anonymousClass74) { // from class: com.facebook.ads.redexgen.X.73
                        {
                            EnumC1623Rt enumC1623Rt = EnumC1623Rt.A04;
                        }
                    });
                    break;
                case 2:
                    hashSet.add(new HT(anonymousClass74) { // from class: com.facebook.ads.redexgen.X.6y
                        public static byte[] A00;

                        static {
                            A01();
                        }

                        {
                            EnumC1623Rt enumC1623Rt = EnumC1623Rt.A05;
                        }

                        public static String A00(int i11, int i12, int i13) {
                            byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
                            for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
                                bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 52);
                            }
                            return new String(bArrCopyOfRange);
                        }

                        public static void A01() {
                            A00 = new byte[]{19, 5, Ascii.DC4, 50, 5, 17, Ascii.NAK, 9, Ascii.DC2, 5, 19, 51, Ascii.EM, Ascii.SO, 3};
                        }

                        @Override // com.facebook.ads.redexgen.uinode.HT, com.facebook.ads.redexgen.uinode.S1
                        public final void A3Z(Map<InterfaceC1613Rj, S6> map, Map<SyncModifiableBundle, EnumC1623Rt> map2) {
                            throw new NullPointerException(A00(0, 15, 84));
                        }
                    });
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return hashSet;
    }

    private JSONObject A03(Map<InterfaceC1613Rj, S5> map, Map<SyncModifiableBundle, EnumC1622Rs> map2, Map<SyncModifiableBundle, JSONObject> map3, Map<SyncModifiableBundle, JSONObject> map4) throws JSONException {
        String strA01;
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<InterfaceC1613Rj, S5> entry : map.entrySet()) {
            jSONObject.put(entry.getKey().A7A().A03(), entry.getValue().A02());
        }
        for (Map.Entry<SyncModifiableBundle, EnumC1622Rs> entry2 : map2.entrySet()) {
            entry2.getKey();
            InterfaceC1613Rj interfaceC1613Rj = null;
            jSONObject.put(interfaceC1613Rj.A7A().A03(), entry2.getValue().A02());
        }
        JSONObject jSONObject2 = new JSONObject();
        Iterator<Map.Entry<InterfaceC1613Rj, S5>> it = map.entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            strA01 = A01(316, 11, 48);
            if (!zHasNext) {
                break;
            }
            Map.Entry<InterfaceC1613Rj, S5> next = it.next();
            if (next.getValue() == S5.A04) {
                JSONObject jSONObject3 = new JSONObject();
                InterfaceC1613Rj key = next.getKey();
                jSONObject2.put(key.A7A().A03(), jSONObject3);
                if (next.getKey().A7A().A04()) {
                    jSONObject3.put(strA01, key.A75());
                } else {
                    jSONObject3.put(strA01, JSONObject.NULL);
                }
                jSONObject2.put(key.A7A().A03(), jSONObject3);
            }
        }
        for (Map.Entry<SyncModifiableBundle, EnumC1622Rs> entry3 : map2.entrySet()) {
            JSONObject jSONObject4 = new JSONObject();
            InterfaceC1613Rj key2 = entry3.getKey();
            jSONObject4.put(strA01, map4.get(entry3.getKey()));
            if (entry3.getValue() == EnumC1622Rs.A05) {
                jSONObject4.put(A01(312, 4, 17), map3.get(key2));
                jSONObject2.put(key2.A7A().A03(), jSONObject4);
            } else {
                String strA03 = key2.A7A().A03();
                String[] strArr = A0B;
                if (strArr[1].charAt(20) == strArr[6].charAt(20)) {
                    throw new RuntimeException();
                }
                A0B[5] = "j6hI8A69HBwx3QyEu85lNgwu8aXeWQ7U";
                jSONObject2.put(strA03, jSONObject4);
            }
        }
        JSONObject jSONObject5 = new JSONObject();
        for (Map.Entry<String, String> entry4 : this.A05.A6x().entrySet()) {
            if (entry4.getValue() != null) {
                jSONObject5.put(entry4.getKey(), entry4.getValue());
            }
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put(A01(342, 7, 85), jSONObject);
        jSONObject6.put(A01(298, 7, 38), jSONObject2);
        jSONObject6.put(A01(305, 7, 33), jSONObject5);
        return jSONObject6;
    }

    private void A04() throws Throwable {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        synchronized (this) {
            for (C1373Hw c1373Hw : this.A09.values()) {
                if (c1373Hw.A9C()) {
                    map.put(c1373Hw, S5.A04);
                } else {
                    map.put(c1373Hw, S5.A03);
                }
            }
            new AtomicReference();
            new AtomicReference();
            Iterator<AnonymousClass74> it = this.A08.values().iterator();
            while (it.hasNext()) {
                it.next();
                InterfaceC1613Rj interfaceC1613Rj = null;
                if (interfaceC1613Rj.A9C()) {
                    throw new NullPointerException(A01(349, 20, 91));
                }
            }
            Iterator<S2> it2 = this.A07.iterator();
            if (it2.hasNext()) {
                it2.next();
                throw new NullPointerException(A01(424, 22, 50));
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        JSONObject jSONObjectA03 = A03(map, map2, map3, map4);
        String.format(Locale.US, A01(188, 33, 55), this.A06, jSONObjectA03.toString(2));
        this.A02.AE0(this.A06, (A01(327, 8, 88) + URLEncoder.encode(jSONObjectA03.toString())).getBytes(), new HY(this, atomicReference, atomicReference2, countDownLatch));
        while (countDownLatch.getCount() > 0) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (atomicReference2.get() != null) {
                throw ((Throwable) atomicReference2.get());
            }
            Set<S1> setA02 = A02((JSONObject) atomicReference.get());
            HashMap map5 = new HashMap();
            HashMap map6 = new HashMap();
            Iterator<S1> it3 = setA02.iterator();
            while (it3.hasNext()) {
                it3.next().A3Z(map5, map6);
            }
            this.A03.A5k(A00((JSONObject) atomicReference.get()));
            Iterator<S2> it4 = this.A07.iterator();
            if (it4.hasNext()) {
                it4.next();
                throw new NullPointerException(A01(401, 23, 80));
            }
        }
    }

    public static void A05() {
        A0A = new byte[]{101, -82, -72, 101, -73, -86, -72, -71, -73, -82, -88, -71, -86, -87, 115, 101, -104, -80, -82, -75, -75, -82, -77, -84, 101, -72, -66, -77, -88, -48, -1, -1, -81, -8, -3, -81, -15, -16, -14, -6, -10, 1, -2, 4, -3, -13, -67, -54, -24, -11, -11, -10, -5, -89, -22, -7, -20, -24, -5, -20, -89, -6, -20, -7, -3, -20, -7, -89, -23, -4, -11, -21, -13, -20, -89, -2, -16, -5, -17, -89, -11, -10, -11, -76, -6, -20, -7, -3, -20, -7, -89, -10, -2, -11, -20, -21, -89, -23, -4, -11, -21, -13, -20, -89, -48, -53, -85, -56, -37, -56, -121, -41, -39, -42, -54, -52, -38, -38, -48, -43, -50, -121, -42, -41, -37, -48, -42, -43, -121, -49, -12, -4, -25, -14, -17, -22, -90, -8, -21, -20, -8, -21, -7, -18, -90, -6, -17, -13, -21, -64, -90, -85, -22, -79, -56, -38, -125, -42, -56, -43, -39, -56, -43, -112, -46, -38, -47, -56, -57, -125, -59, -40, -47, -57, -49, -56, -125, -58, -43, -56, -60, -41, -56, -57, -99, -125, -120, -42, -101, -63, -74, -85, -80, -70, -73, -74, -79, -62, -87, -68, -79, -73, -74, 104, -70, -83, -71, -67, -83, -69, -68, 104, -68, -73, 104, 109, -69, -126, 82, 109, -69, -88, -50, -61, -72, -67, -57, -60, -61, -66, -49, -74, -55, -66, -60, -61, 117, -57, -70, -56, -59, -60, -61, -56, -70, -113, 95, 122, -56, 114, -104, -115, -126, -121, -111, -114, -115, -120, -103, -128, -109, -120, -114, -115, Utf8.REPLACEMENT_BYTE, -111, -108, -115, Utf8.REPLACEMENT_BYTE, -123, -128, -120, -117, -124, -125, 90, Utf8.REPLACEMENT_BYTE, -123, -114, -111, -126, -120, -115, -122, Utf8.REPLACEMENT_BYTE, -120, -115, Utf8.REPLACEMENT_BYTE, 68, -125, Utf8.REPLACEMENT_BYTE, -110, -124, -126, -114, -115, -125, -110, -103, -84, -91, -101, -93, -100, -86, -107, -95, -96, -90, -105, -86, -90, -122, -125, -106, -125, -89, -86, -81, -88, -90, -77, -79, -77, -86, -81, -75, -39, -54, -30, -43, -40, -54, -51, -90, -45, -58, -57, -45, -58, -44, -55, -40, -53, -41, -37, -53, -39, -38, -34, -47, -35, -31, -43, -34, -47, -33, -65, -27, -38, -49, -83, -38, -48, -66, -47, -33, -47, -32, -60, -73, -59, -62, -63, -64, -59, -73, -19, -33, -20, -16, -33, -20, -55, -15, -24, -33, -34, -68, -17, -24, -34, -26, -33, -67, -20, -33, -37, -18, -33, -34, -44, -38, -49, -60, -55, -45, -48, -49, -54, -37, -62, -43, -54, -48, -49, -89, -54, -49, -54, -44, -55, -58, -59, -74, -68, -79, -90, -85, -75, -78, -79, -84, -67, -92, -73, -84, -78, -79, -106, -73, -92, -75, -73, -88, -89, -53, -72, -55, -66, -68, -53, -74, -55, -68, -67, -55, -68, -54, -65, -74, -54};
    }

    public static void A06(String str, AtomicReference<JSONObject> atomicReference, AtomicReference<Throwable> atomicReference2) {
        String.format(Locale.US, A01(221, 28, 68), str);
        try {
            atomicReference.set((JSONObject) new JSONTokener(str).nextValue());
        } catch (ClassCastException | JSONException e11) {
            atomicReference2.set(e11);
        }
    }

    private synchronized void A08(Throwable th2) {
        Iterator<S2> it = this.A07.iterator();
        if (it.hasNext()) {
            it.next();
            new HashMap();
            new HashMap();
            throw new NullPointerException(A01(401, 23, 80));
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1360Hj
    public final synchronized InterfaceC1613Rj A4i(EnumC1614Rk enumC1614Rk) {
        if (enumC1614Rk.A02() != EnumC1616Rm.A03) {
            throw new IllegalArgumentException(A01(47, 59, 118));
        }
        if (this.A09.containsKey(enumC1614Rk)) {
            return this.A09.get(enumC1614Rk);
        }
        C1373Hw c1373Hw = new C1373Hw(enumC1614Rk);
        this.A09.put(enumC1614Rk, c1373Hw);
        Iterator<S2> it = this.A07.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NullPointerException(A01(377, 24, 105));
        }
        String.format(Locale.US, A01(153, 35, 82), enumC1614Rk);
        return c1373Hw;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1360Hj, com.facebook.ads.redexgen.uinode.InterfaceC11277l
    public final void A5m() {
        this.A03.A5l();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1618Ro
    public final void AFP() {
        if (this.A01.A9F()) {
            String str = A01(106, 23, 86) + this.A01.A6i().A07() + A01(0, 29, 52);
            A08(new S4());
            return;
        }
        try {
            if (C1384Ih.A1e(this.A00) && !this.A00.A03().A94()) {
                throw new IllegalStateException(A01(29, 18, WebSocketProtocol.PAYLOAD_SHORT));
            }
            A04();
        } catch (Throwable th2) {
            String.format(Locale.US, A01(249, 49, 14), Integer.valueOf(this.A04.A01()));
            A08(th2);
            this.A03.A5k(this.A04.A01());
        }
    }
}
