package com.facebook.ads.redexgen.uinode;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1406Jh implements RK {
    public static byte[] A07;
    public static String[] A08 = {"Z3ZBH3trhaxMswGoeO0i3WMhBsCqcWgs", "P814sFImmOC", "INcscN3Z5kcfIuBeknVxelrdNm8ANoXs", "RvJjsajerkLdUat3TDI8NPR3DDSWtO", "ZLSXhw", "wxtWSqUF9a7Aw2d1StIocmcoa4QX", "58xAXbC3p", "Zj1UZNXOzFX"};
    public static final String A09;
    public AnonymousClass89 A00;
    public Executor A01;
    public boolean A02;
    public RP A03;
    public final RU A04 = new C1417Js();
    public final RZ A05;
    public final InterfaceC1604Ra A06;

    static {
        A0A();
        A09 = RK.class.getSimpleName();
    }

    public C1406Jh(RP rp2, AnonymousClass89 anonymousClass89, Executor executor) {
        A0B();
        this.A03 = rp2;
        final JN jn2 = new JN(rp2.A04());
        this.A06 = jn2;
        this.A05 = new AbstractC1416Jr(jn2) { // from class: com.facebook.ads.redexgen.X.76
        };
        this.A01 = executor;
        this.A00 = anonymousClass89;
    }

    private final int A00(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStreamADq = null;
        try {
            outputStreamADq = this.A05.ADq(httpURLConnection);
            if (outputStreamADq != null) {
                this.A05.AHG(outputStreamADq, bArr);
            }
            return httpURLConnection.getResponseCode();
        } finally {
            if (outputStreamADq != null) {
                try {
                    outputStreamADq.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    private final RJ A01(RW rw2) throws RX {
        String strA07 = A07(220, 7, 7);
        HttpURLConnection httpURLConnection = null;
        C1411Jm c1411JmA05 = null;
        boolean z11 = false;
        try {
            try {
                this.A02 = false;
                HttpURLConnection httpURLConnectionA08 = A08(rw2.A05(), L0.A04() ? A09() : null);
                A0H(httpURLConnectionA08, rw2);
                A0G(httpURLConnectionA08, rw2);
                if (this.A06.A98()) {
                    this.A06.A9y(httpURLConnectionA08, rw2.A06());
                }
                httpURLConnectionA08.connect();
                this.A02 = true;
                Set<String> setA01 = this.A03.A01();
                Set<String> setA02 = this.A03.A02();
                boolean z12 = (setA01 == null || setA01.isEmpty()) ? false : true;
                if (setA02 != null && !setA02.isEmpty()) {
                    z11 = true;
                }
                if ((httpURLConnectionA08 instanceof HttpsURLConnection) && (z12 || z11)) {
                    try {
                        AbstractC1605Rb.A03((HttpsURLConnection) httpURLConnectionA08, setA01, setA02);
                    } catch (CertificateException e11) {
                        this.A00.AA2(strA07, C8A.A1z, new C8B(e11));
                    } catch (Exception e12) {
                        this.A00.AA2(strA07, C8A.A1y, new C8B(e12));
                    }
                }
                if (httpURLConnectionA08.getDoOutput() && rw2.A06() != null) {
                    A00(httpURLConnectionA08, rw2.A06());
                }
                C1411Jm c1411JmA06 = httpURLConnectionA08.getDoInput() ? A06(httpURLConnectionA08) : new C1411Jm(httpURLConnectionA08, null);
                if (this.A06.A98()) {
                    this.A06.A9z(c1411JmA06);
                }
                if (httpURLConnectionA08 != null) {
                    httpURLConnectionA08.disconnect();
                }
                return c1411JmA06;
            } catch (Exception e13) {
                try {
                    try {
                        c1411JmA05 = A05(null);
                        if (c1411JmA05 == null || c1411JmA05.A83() <= 0) {
                            throw new RX(e13, c1411JmA05);
                        }
                        if (this.A06.A98()) {
                            this.A06.A9z(c1411JmA05);
                        }
                        if (0 != 0) {
                            httpURLConnection.disconnect();
                        }
                        return c1411JmA05;
                    } catch (Exception unused) {
                        Log.e(getClass().getSimpleName(), A07(117, 13, 53), e13);
                        if (c1411JmA05 == null || c1411JmA05.A83() <= 0) {
                            throw new RX(e13, c1411JmA05);
                        }
                        if (this.A06.A98()) {
                            InterfaceC1604Ra interfaceC1604Ra = this.A06;
                            String[] strArr = A08;
                            if (strArr[0].charAt(28) == strArr[2].charAt(28)) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A08;
                            strArr2[0] = "IlkFDbfWlXmKaUvETbHYmdNk6OEHYi1H";
                            strArr2[2] = "BN3YcSqfdOqAJI6hng3gZMbRThXyngdJ";
                            interfaceC1604Ra.A9z(c1411JmA05);
                        }
                        if (0 != 0) {
                            httpURLConnection.disconnect();
                        }
                        return c1411JmA05;
                    }
                } catch (Throwable unused2) {
                    if (c1411JmA05 == null || c1411JmA05.A83() <= 0) {
                        throw new RX(e13, c1411JmA05);
                    }
                    if (this.A06.A98()) {
                        this.A06.A9z(c1411JmA05);
                    }
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    return c1411JmA05;
                }
            }
        } catch (Throwable th2) {
            if (this.A06.A98()) {
                this.A06.A9z(c1411JmA05);
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th2;
        }
    }

    private final RJ A02(RW rw2) {
        if (this.A03.A04()) {
            A0C(rw2);
        }
        RJ rjA01 = null;
        try {
            rjA01 = A01(rw2);
            return rjA01;
        } catch (RX e11) {
            this.A05.ABU(e11);
            return rjA01;
        } catch (Exception e12) {
            this.A05.ABU(new RX(e12, rjA01));
            return rjA01;
        }
    }

    private final RJ A03(String str, RY ry2, RS rs2) {
        return A02(new C1413Jo(str, ry2, rs2));
    }

    private final RJ A04(String str, String str2, byte[] bArr, RS rs2) {
        return A02(new C1412Jn(str, null, str2, bArr, rs2));
    }

    private final C1411Jm A05(HttpURLConnection httpURLConnection) throws Exception {
        InputStream errorStream = null;
        try {
            errorStream = httpURLConnection.getErrorStream();
            C1411Jm c1411Jm = new C1411Jm(httpURLConnection, errorStream != null ? this.A05.AEO(errorStream) : null);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused) {
                }
            }
            return c1411Jm;
        } catch (Throwable th2) {
            if (A08[5].length() != 28) {
                throw new RuntimeException();
            }
            A08[4] = "eS";
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th2;
        }
    }

    private final C1411Jm A06(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStreamADp = null;
        try {
            inputStreamADp = this.A05.ADp(httpURLConnection);
            return new C1411Jm(httpURLConnection, inputStreamADp != null ? this.A05.AEO(inputStreamADp) : null);
        } finally {
            if (inputStreamADp != null) {
                try {
                    inputStreamADp.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    public static String A07(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 93);
        }
        return new String(bArrCopyOfRange);
    }

    private final HttpURLConnection A08(String str, Proxy proxy) throws IOException {
        try {
            new URL(str);
            TrafficStats.setThreadStatsTag(61453);
            return this.A05.ADo(str, proxy);
        } catch (MalformedURLException e11) {
            throw new IllegalArgumentException(str + A07(18, 19, 115), e11);
        }
    }

    public static Proxy A09() {
        Proxy proxy = Proxy.NO_PROXY;
        String property = System.getProperty(A07(PsExtractor.AUDIO_STREAM, 14, 45));
        String property2 = System.getProperty(A07(206, 14, 74));
        int i11 = -1;
        if (property2 != null) {
            try {
                i11 = Integer.parseInt(property2);
            } catch (NumberFormatException unused) {
                return proxy;
            }
        }
        boolean zIsEmpty = TextUtils.isEmpty(property);
        String[] strArr = A08;
        if (strArr[0].charAt(28) == strArr[2].charAt(28)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[3] = "UW2PAxLqNCWQ7bdKo0A7Pw4nSyNkIv";
        strArr2[6] = "26yRDH09B";
        return (zIsEmpty || i11 <= 0 || i11 > 65535) ? proxy : new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, i11));
    }

    public static void A0A() {
        A07 = new byte[]{Ascii.DLE, Ascii.DC2, 55, 58, 95, 55, 53, 74, 71, Ascii.SO, 74, 72, Ascii.SI, 76, 90, 93, 67, Ascii.SI, Ascii.SO, 71, 93, Ascii.SO, 64, 65, 90, Ascii.SO, 79, Ascii.SO, 88, 79, 66, 71, 74, Ascii.SO, 123, 124, 98, Ascii.SO, 65, 72, Ascii.SO, 94, 102, 106, 9, Ascii.RS, 106, 119, 106, Ascii.FS, Ascii.DLE, 98, 100, Ascii.DLE, Ascii.CR, Ascii.DLE, 55, 59, 111, 105, 98, 114, 117, 124, 59, 81, 17, 59, 50, Utf8.REPLACEMENT_BYTE, 46, 45, 59, 58, 94, 42, 55, 51, 59, 94, 67, 94, 1, 35, 50, 50, 47, 40, 33, 102, 50, 46, 35, 102, 46, 50, 50, 54, 102, 52, 35, 53, 54, 41, 40, 53, 35, 102, 50, 47, 43, 35, 34, 102, 41, 51, 50, 38, Ascii.CR, Ascii.FS, Ascii.US, 7, Ascii.SUB, 3, 72, Ascii.CR, Ascii.SUB, Ascii.SUB, 7, Ascii.SUB, 34, 35, 49, 90, 79, 122, 107, 107, 119, 114, 120, 122, 111, 114, 116, 117, 52, 99, 54, 108, 108, 108, 54, 125, 116, 105, 118, 54, 110, 105, 119, 126, 117, 120, 116, Ascii.DEL, 126, Ascii.DEL, 32, 120, 115, 122, 105, 104, 126, 111, 38, 78, 79, 93, 54, 35, 47, 57, 62, 32, 108, 97, 39, 108, 97, 37, Ascii.CAN, 4, 4, 0, 94, 0, 2, Ascii.US, 8, 9, 56, Ascii.US, 3, 4, Ascii.DEL, 99, 99, 103, 57, 103, 101, 120, 111, 110, 71, 120, 101, 99, 52, Utf8.REPLACEMENT_BYTE, 46, 45, 53, 40, 49};
    }

    public static synchronized void A0B() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private void A0C(RW rw2) {
        StringBuilder sb2 = new StringBuilder(A07(182, 10, 17));
        boolean zEquals = rw2.A03().equals(RV.A06);
        String strA07 = A07(41, 1, 33);
        if (zEquals && rw2.A06() != null) {
            sb2.append(A07(7, 5, 55));
            sb2.append(new String(rw2.A06(), Charset.forName(A07(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 5, 42))));
            sb2.append(strA07);
        }
        Map<String, String> mapA06 = rw2.A02().A06();
        String[] strArr = A08;
        if (strArr[1].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[3] = "s0c02ga9sXqOOqZgqzjFkG4II3gfLx";
        strArr2[6] = "iECV1gT3x";
        for (Map.Entry<String, String> entry : mapA06.entrySet()) {
            sb2.append(A07(2, 5, 74));
            sb2.append(entry.getKey());
            sb2.append(A07(66, 1, 118));
            sb2.append(entry.getValue());
            sb2.append(strA07);
        }
        sb2.append(A07(0, 2, 109));
        sb2.append(rw2.A05());
        sb2.append(strA07);
        String string = sb2.toString();
        A0E(string, 1, (string.length() / 4000) + 1);
    }

    private void A0D(RW rw2, RL rl2) {
        this.A04.A63(this, rl2, this.A01).A04(rw2);
        if (this.A03.A04()) {
            A0C(rw2);
        }
    }

    private void A0E(String str, int i11, int i12) {
        String str2 = A09 + A07(12, 6, 114) + i11 + A07(65, 1, 35) + i12;
        if (str.length() > 4000) {
            str.substring(0, 4000);
            A0E(str.substring(4000), i11 + 1, i12);
        }
    }

    private void A0F(String str, String str2, byte[] bArr, RL rl2, RS rs2) {
        A0D(new C1412Jn(str, null, str2, bArr, rs2), rl2);
    }

    private void A0G(HttpURLConnection httpURLConnection, RW rw2) {
        Map<String, String> mapA06 = rw2.A02().A06();
        RI riA05 = rw2.A02().A05();
        for (String str : mapA06.keySet()) {
            httpURLConnection.setRequestProperty(str, mapA06.get(str));
        }
        if (riA05 != null) {
            Map<String, String> mapA5o = riA05.A5o(this.A03.A03());
            for (String str2 : mapA5o.keySet()) {
                httpURLConnection.setRequestProperty(str2, mapA5o.get(str2));
            }
        }
    }

    private final void A0H(HttpURLConnection httpURLConnection, RW rw2) throws IOException {
        RS rsA02 = rw2.A02();
        httpURLConnection.setConnectTimeout(rsA02.A00());
        httpURLConnection.setReadTimeout(rsA02.A02());
        this.A05.AE6(httpURLConnection, rw2.A03(), rw2.A04());
    }

    private final boolean A0I(Throwable th2, long j11, RW rw2) {
        RS rsA02 = rw2.A02();
        long jCurrentTimeMillis = (System.currentTimeMillis() - j11) + 10;
        if (this.A06.A98()) {
            String str = A07(67, 15, 35) + jCurrentTimeMillis + A07(42, 7, 23) + rsA02.A00() + A07(49, 7, 109) + rsA02.A02();
        }
        if (this.A02) {
            return jCurrentTimeMillis >= ((long) rsA02.A02());
        }
        long jA00 = rsA02.A00();
        if (A08[5].length() != 28) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[3] = "UT6xnSlzbr9JaeC9T1uoRQiwoDXC3Y";
        strArr[6] = "g5URFCrsk";
        return jCurrentTimeMillis >= jA00;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:44:0x011b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0121  */
    /* JADX WARN: Code duplicated, block: B:49:0x0125  */
    /* JADX WARN: Code duplicated, block: B:52:0x0131  */
    /* JADX WARN: Code duplicated, block: B:53:0x0136  */
    /* JADX WARN: Code duplicated, block: B:70:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0108 A[EDGE_INSN: B:79:0x0108->B:40:0x0108 BREAK  A[LOOP:0: B:3:0x002a->B:26:0x00cd], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00cd A[SYNTHETIC] */
    public final RJ A0J(RW rw2) throws RX {
        RJ rjA00;
        long length;
        long length2;
        int iA83;
        int i11 = 0;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iA01 = rw2.A02().A01();
        long jA03 = rw2.A02().A03();
        long jCurrentTimeMillis2 = System.currentTimeMillis() + ((long) rw2.A02().A04());
        while (true) {
            if (A08[5].length() == 28) {
                A08[5] = "uw7CndVwumsNWx3tR5uVNB4kWYqq";
                if (i11 >= iA01 || jCurrentTimeMillis2 <= System.currentTimeMillis()) {
                    this.A00.A9t(jCurrentTimeMillis, System.currentTimeMillis() - jCurrentTimeMillis, 0L, rw2.A04 == null ? 0L : rw2.A04.length, 0, new TimeoutException(A07(82, 35, 27)));
                    return null;
                }
                try {
                    if (this.A06.A98()) {
                        String str = (i11 + 1) + A07(37, 4, 115) + iA01 + A07(56, 9, 70) + rw2.A05();
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    RJ rjA01 = A01(rw2);
                    if (rjA01 != null) {
                        this.A00.A9t(jCurrentTimeMillis, System.currentTimeMillis() - jCurrentTimeMillis, rjA01.A68().length, rw2.A04 == null ? 0L : rw2.A04.length, rjA01.A83(), null);
                        return rjA01;
                    }
                    continue;
                } catch (RX e11) {
                    if (!A0I(e11, jCurrentTimeMillis, rw2) || i11 >= iA01 - 1) {
                        RZ rz2 = this.A05;
                        if (A08[5].length() == 28) {
                            A08[4] = "QCV1DKlppK5B8d9XgS0nl0pavHf";
                            if (!rz2.ABU(e11)) {
                                break;
                            }
                            if (i11 < iA01 - 1) {
                                break;
                                break;
                            }
                            if (jA03 > 0) {
                                Thread.sleep(jA03);
                            } else {
                                continue;
                            }
                        } else {
                            A08[4] = "RTCgSwX4E1qAS9DeUF79c1CzYGzjCcSq";
                            if (!rz2.ABU(e11)) {
                                break;
                            }
                            if (i11 < iA01 - 1) {
                                break;
                            }
                            if (jA03 > 0) {
                                try {
                                    Thread.sleep(jA03);
                                } catch (InterruptedException e12) {
                                    this.A00.A9t(jCurrentTimeMillis, System.currentTimeMillis() - jCurrentTimeMillis, 0L, rw2.A04 != null ? rw2.A04.length : 0L, 0, e12);
                                    throw e11;
                                }
                            } else {
                                continue;
                            }
                        }
                        rjA00 = e11.A00();
                        AnonymousClass89 anonymousClass89 = this.A00;
                        long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                        if (rjA00 == null) {
                            length = 0;
                        } else {
                            length = 0;
                        }
                        if (rw2.A04 == null) {
                            length2 = 0;
                        } else {
                            length2 = rw2.A04.length;
                        }
                        if (rjA00 == null) {
                            iA83 = 0;
                        } else {
                            iA83 = rjA00.A83();
                        }
                        anonymousClass89.A9t(jCurrentTimeMillis, jCurrentTimeMillis3, length, length2, iA83, e11);
                        throw e11;
                    }
                    continue;
                }
                i11++;
            }
            throw new RuntimeException();
        }
        rjA00 = e11.A00();
        AnonymousClass89 anonymousClass810 = this.A00;
        long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (rjA00 == null && rjA00.A68() != null) {
            byte[] bArrA68 = rjA00.A68();
            String[] strArr = A08;
            if (strArr[3].length() != strArr[6].length()) {
                String[] strArr2 = A08;
                strArr2[3] = "kZCGiI5zGihRv0GXktBIsysHbk9bX5";
                strArr2[6] = "FynZg164G";
                length = bArrA68.length;
            }
            throw new RuntimeException();
        }
        length = 0;
        if (rw2.A04 == null) {
            length2 = 0;
        } else {
            length2 = rw2.A04.length;
        }
        if (rjA00 == null) {
            iA83 = 0;
        } else {
            iA83 = rjA00.A83();
        }
        anonymousClass810.A9t(jCurrentTimeMillis, jCurrentTimeMillis4, length, length2, iA83, e11);
        throw e11;
    }

    public final RP A0K() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.RK
    @Deprecated
    public final RJ ADy(String str, Map<String, String> map) {
        return A03(str, new RY(map), this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.uinode.RK
    @Deprecated
    public final RJ ADz(String str, byte[] bArr) {
        return A04(str, A07(TsExtractor.TS_STREAM_TYPE_E_AC3, 47, 70), bArr, this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.uinode.RK
    public final void AE0(String str, byte[] bArr, RL rl2) {
        A0F(str, A07(TsExtractor.TS_STREAM_TYPE_E_AC3, 47, 70), bArr, rl2, this.A03.A00());
    }
}
