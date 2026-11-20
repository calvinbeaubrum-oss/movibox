package com.facebook.ads.redexgen.uinode;

import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XX implements InterfaceC1233Bs {
    public static byte[] A0p;
    public static String[] A0q = {"WhKu7pkuAeXCsVE8uRhv3EZwgBp9riSc", "wrDeNyGLCWUv14ZggE2zPWUzu5gjoOIg", "xUs1VEgTJlmvEesGlKYim2mGX89Mn6Ap", "W8YnXYO8xf4ClNYvDZVYWX", "B88t6KSt5rHqx0X", "mP1RKkMa67OSAD0gBpbGTYhDs7d4UNMk", "rmkWP1gG3PZnRTV6Vu72xnpKfVt", "q3NSDD9bEbAX3BTi5XmjKvgCV917aeoR"};
    public static final InterfaceC1236Bv A0r;
    public static final UUID A0s;
    public static final byte[] A0t;
    public static final byte[] A0u;
    public static final byte[] A0v;
    public static final byte[] A0w;
    public static final byte[] A0x;
    public byte A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public long A0C;
    public long A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public InterfaceC1235Bu A0N;
    public CE A0O;
    public C1366Hp A0P;
    public C1366Hp A0Q;
    public ByteBuffer A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public int[] A0b;
    public final SparseArray<CE> A0c;
    public final CA A0d;
    public final CH A0e;
    public final C1376Hz A0f;
    public final C1376Hz A0g;
    public final C1376Hz A0h;
    public final C1376Hz A0i;
    public final C1376Hz A0j;
    public final C1376Hz A0k;
    public final C1376Hz A0l;
    public final C1376Hz A0m;
    public final C1376Hz A0n;
    public final boolean A0o;

    static {
        A06();
        A0r = new XZ();
        A0w = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        A0x = new byte[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
        A0t = IF.A0i(A03(539, 90, 83));
        A0u = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        A0v = new byte[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
        A0s = new UUID(72057594037932032L, -9223371306706625679L);
    }

    public XX() {
        this(0);
    }

    public XX(int i11) {
        this(new C1756Xa(), i11);
    }

    public XX(CA ca2, int i11) {
        this.A0K = -1L;
        this.A0M = C.TIME_UNSET;
        this.A0G = C.TIME_UNSET;
        this.A0H = C.TIME_UNSET;
        this.A0F = -1L;
        this.A0J = -1L;
        this.A0E = C.TIME_UNSET;
        this.A0d = ca2;
        ca2.A8p(new XY(this, null));
        this.A0o = (i11 & 1) == 0;
        this.A0e = new CH();
        this.A0c = new SparseArray<>();
        this.A0k = new C1376Hz(4);
        this.A0n = new C1376Hz(ByteBuffer.allocate(4).putInt(-1).array());
        this.A0l = new C1376Hz(4);
        this.A0i = new C1376Hz(AbstractC1372Hv.A03);
        this.A0h = new C1376Hz(4);
        this.A0j = new C1376Hz();
        this.A0m = new C1376Hz();
        this.A0f = new C1376Hz(8);
        this.A0g = new C1376Hz();
    }

    private int A00(InterfaceC1234Bt interfaceC1234Bt, C4 c11, int i11) throws InterruptedException, IOException {
        int iAFQ;
        int iA04 = this.A0j.A04();
        if (iA04 > 0) {
            iAFQ = Math.min(i11, iA04);
            c11.AFR(this.A0j, iAFQ);
        } else {
            iAFQ = c11.AFQ(interfaceC1234Bt, i11, false);
        }
        this.A07 += iAFQ;
        this.A08 += iAFQ;
        return iAFQ;
    }

    private long A01(long j11) throws C11849v {
        long j12 = this.A0M;
        if (j12 != C.TIME_UNSET) {
            return IF.A0F(j11, j12, 1000L);
        }
        throw new C11849v(A03(PsExtractor.PRIVATE_STREAM_1, 54, 68));
    }

    private C1 A02() {
        C1366Hp c1366Hp;
        C1366Hp c1366Hp2;
        if (this.A0K == -1 || this.A0H == C.TIME_UNSET || (c1366Hp = this.A0Q) == null || c1366Hp.A02() == 0 || (c1366Hp2 = this.A0P) == null || c1366Hp2.A02() != this.A0Q.A02()) {
            this.A0Q = null;
            this.A0P = null;
            return new C1765Xj(this.A0H);
        }
        int iA02 = this.A0Q.A02();
        int[] iArr = new int[iA02];
        long[] jArr = new long[iA02];
        long[] jArr2 = new long[iA02];
        long[] jArr3 = new long[iA02];
        for (int i11 = 0; i11 < iA02; i11++) {
            jArr3[i11] = this.A0Q.A03(i11);
            jArr[i11] = this.A0K + this.A0P.A03(i11);
        }
        for (int i12 = 0; i12 < iA02 - 1; i12++) {
            iArr[i12] = (int) (jArr[i12 + 1] - jArr[i12]);
            jArr2[i12] = jArr3[i12 + 1] - jArr3[i12];
        }
        iArr[iA02 - 1] = (int) ((this.A0K + this.A0L) - jArr[iA02 - 1]);
        jArr2[iA02 - 1] = this.A0H - jArr3[iA02 - 1];
        this.A0Q = null;
        this.A0P = null;
        return new C1770Xo(iArr, jArr, jArr2, jArr3);
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0p, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 12);
        }
        return new String(bArrCopyOfRange);
    }

    private void A05() {
        this.A07 = 0;
        this.A08 = 0;
        this.A09 = 0;
        this.A0S = false;
        this.A0X = false;
        this.A0U = false;
        this.A0A = 0;
        this.A00 = (byte) 0;
        this.A0T = false;
        this.A0j.A0V();
    }

    public static void A06() {
        A0p = new byte[]{65, -113, -112, -107, 65, -108, -106, -111, -111, -112, -109, -107, -122, -123, -98, -87, -86, -35, -77, -98, -87, -85, -35, -77, -98, -87, -85, -35, -77, -98, -87, -85, -35, 56, 67, 69, 119, 77, 56, 67, 69, 119, 77, 56, 67, 69, 119, Utf8.REPLACEMENT_BYTE, 56, 67, 70, 119, -107, -103, -89, -89, -71, -56, -56, -67, -62, -69, -57, -105, -67, -60, -68, -71, -58, -95, -61, -72, -71, 116, -53, -23, -53, -53, -51, -55, -25, -55, -53, -69, -81, -51, -78, -62, -63, -117, -87, -114, -98, -99, 121, -113, -94, -102, -100, -113, -99, -99, -93, -63, -90, -74, -75, -111, -82, -79, -75, -75, -82, -89, -75, -75, -120, -90, -116, -120, -118, 122, 94, 124, 99, 105, 94, 96, -77, -47, -65, -62, -73, -71, -95, -66, -92, 85, 115, 97, 100, 89, 91, 67, 96, 71, 116, -110, -128, -122, 98, 116, 118, -128, -77, -47, -63, -62, -57, -59, -100, -70, -85, -98, -88, -118, -92, -87, -81, -118, -89, -92, -81, -117, -87, -98, -100, -97, -113, -110, -114, -92, -62, -71, -78, -75, -91, -84, -74, -109, -79, -66, 119, -60, 112, -61, -77, -79, -68, -75, 112, -60, -71, -67, -75, -77, -65, -76, -75, 112, -64, -62, -71, -65, -62, 112, -60, -65, 112, -60, -71, -67, -75, -77, -65, -76, -75, -93, -77, -79, -68, -75, 112, -78, -75, -71, -66, -73, 112, -61, -75, -60, 126, 89, -123, -125, 120, Ascii.DEL, -124, Ascii.DEL, -124, 125, 54, 123, -124, 121, -120, -113, -122, -118, Ascii.DEL, -123, -124, 54, 119, -124, 122, 54, 121, -123, -125, -122, -120, 123, -119, -119, Ascii.DEL, -123, -124, 54, Ascii.DEL, -119, 54, -124, -123, -118, 54, -119, -117, -122, -122, -123, -120, -118, 123, 122, -69, -25, -26, -20, -35, -26, -20, -69, -25, -27, -24, -71, -28, -33, -25, -104, -111, -67, -68, -62, -77, -68, -62, -109, -68, -79, -113, -70, -75, -67, 110, -89, -45, -46, -40, -55, -46, -40, -87, -46, -57, -45, -56, -51, -46, -53, -77, -42, -56, -55, -42, -124, 120, -92, -93, -87, -102, -93, -87, 122, -93, -104, -92, -103, -98, -93, -100, -120, -104, -92, -91, -102, 85, -59, -16, -28, -43, -6, -15, -26, -95, 94, -119, 125, 110, -109, -118, Ascii.DEL, 108, Ascii.DEL, 123, 126, 112, Ascii.DEL, -116, -115, -125, -119, -120, 58, -68, -71, -60, -61, -105, -29, -40, -38, -32, -27, -34, -105, -22, -40, -28, -25, -29, -36, -105, -22, -32, -15, -36, -105, -26, -20, -21, -105, -26, -35, -105, -23, -40, -27, -34, -36, -91, -79, -82, -71, -72, -66, -47, -51, -48, -62, -47, -34, -33, -43, -37, -38, -116, -60, -19, -30, -15, -8, -17, -13, -28, -29, -97, -45, -15, -32, -30, -22, -97, -27, -18, -12, -19, -29, -97, -31, -12, -13, -97, -62, -18, -19, -13, -28, -19, -13, -60, -19, -30, -54, -28, -8, -56, -61, -97, -10, -32, -14, -97, -19, -18, -13, -97, -27, -18, -12, -19, -29, 103, -102, -106, -121, -112, -107, -117, -111, -112, 66, -124, -117, -106, 66, -117, -107, 66, -107, -121, -106, 66, -117, -112, 66, -107, -117, -119, -112, -125, -114, 66, -124, -101, -106, -121, -91, -50, -47, -52, -64, -45, -103, Ascii.DEL, -78, -45, -64, -47, -45, -117, Ascii.DEL, -92, -51, -61, -117, Ascii.DEL, -79, -60, -64, -61, -82, -47, -61, -60, -47, -117, Ascii.DEL, -85, -64, -40, -60, -47, -117, Ascii.DEL, -78, -45, -40, -53, -60, -117, Ascii.DEL, -83, -64, -52, -60, -117, Ascii.DEL, -84, -64, -47, -58, -56, -51, -85, -117, Ascii.DEL, -84, -64, -47, -58, -56, -51, -79, -117, Ascii.DEL, -84, -64, -47, -58, -56, -51, -75, -117, Ascii.DEL, -92, -59, -59, -60, -62, -45, -117, Ascii.DEL, -77, -60, -41, -45, -99, -78, -76, -70, -65, -72, 113, -64, -65, -67, -54, 113, -60, -58, -63, -63, -64, -61, -59, -74, -75, 113, -70, -65, 113, -92, -70, -66, -63, -67, -74, -109, -67, -64, -76, -68, -60, Ascii.DEL, 115, -121, -108, -118, -121, -102, -107, -104, -97, 70, -117, -110, -117, -109, -117, -108, -102, 70, 121, -117, -117, -111, 111, 106, 70, -107, -104, 70, 121, -117, -117, -111, 118, -107, -103, -113, -102, -113, -107, -108, 70, -108, -107, -102, 70, -116, -107, -101, -108, -118, -54, -14, -23, -15, -26, -19, -23, -30, -99, -48, -30, -28, -22, -30, -21, -15, -99, -30, -23, -30, -22, -30, -21, -15, -16, -99, -21, -20, -15, -99, -16, -14, -19, -19, -20, -17, -15, -30, -31, -102, -69, 108, -62, -83, -72, -75, -80, 108, -64, -66, -83, -81, -73, -65, 108, -61, -79, -66, -79, 108, -78, -69, -63, -70, -80, 119, -104, 73, -97, -118, -107, -110, -115, 73, -97, -118, -101, -110, -105, -99, 73, -107, -114, -105, -112, -99, -111, 73, -106, -118, -100, -108, 73, -113, -104, -98, -105, -115, 112, 124, 97, 115, 95, 112, 114, 95, -44, -32, -55, -59, -50, -41, -80, -47, -56, -44, -104, -92, -103, -118, -99, -103, 116, -122, -104, -104, -72, -60, -71, -86, -67, -71, -108, -70, -71, -85, -99, -42, -30, -39, -46, -59, -42, -40, -59, 104, -127, 120, -117, -125, 120, 118, -121, 120, 119, 51, 124, 119, 77, 51, Ascii.DEL, -104, -113, -94, -102, -113, -115, -98, -113, -114, 74, -106, -117, -115, -109, -104, -111, 74, -96, -117, -106, -97, -113, 100, 74, -86, -77, -95, -92, -103, -101, -122, -38, -29, -47, -44, -55, -53, -72, -77, -51, -41, -45, -77, -59, -44, -72, -63, -81, -78, -89, -87, -106, -111, -85, -75, -79, -111, -93, -75, -78, 122, -125, 113, 116, 105, 107, 88, 83, 109, 119, 115, 83, 101, 122, 103, -53, -44, -62, -59, -70, -68, -87, -92, -66, -56, -60, -92, -56, -59, 116, 125, 107, 110, 99, 101, 102, 77, 103, 113, 109, 77, 102, 99, 116, 97, -47, -38, -56, -50, -86, -47, -63, -46, -86, -63, -54, -48, -51, -66, -66, -67, -58, 
        -69, -81, -84, -74, -71, -88, -100, -91, -100, -106, 126, 118, Ascii.DEL, 118, 112, 89, -13, -25, -6, -8, -11, -7, -15, -25, -63, -76, -81, -80, -70, 122, -62, -80, -83, -72, -12, -30, -33, -22};
    }

    private void A07(InterfaceC1234Bt interfaceC1234Bt, int i11) throws InterruptedException, IOException {
        if (this.A0k.A07() >= i11) {
            return;
        }
        if (this.A0k.A05() < i11) {
            C1376Hz c1376Hz = this.A0k;
            c1376Hz.A0b(Arrays.copyOf(c1376Hz.A00, Math.max(this.A0k.A00.length * 2, i11)), this.A0k.A07());
        }
        byte[] bArr = this.A0k.A00;
        int iA07 = this.A0k.A07();
        if (A0q[6].length() != 27) {
            throw new RuntimeException();
        }
        String[] strArr = A0q;
        strArr[0] = "ZmQc4cegfKT6TM2j1HdEhTMrEsYvVAK8";
        strArr[2] = "PLs1alOmXmQPSsdSdZUe4T02xUG6CaQT";
        interfaceC1234Bt.readFully(bArr, iA07, i11 - this.A0k.A07());
        this.A0k.A0X(i11);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0296 A[EDGE_INSN: B:101:0x0296->B:94:0x0296 BREAK  A[LOOP:1: B:90:0x028a->B:92:0x028e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x0231 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x024a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:68:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:73:0x020b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0250  */
    /* JADX WARN: Code duplicated, block: B:81:0x025f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0273  */
    /* JADX WARN: Code duplicated, block: B:86:0x0277  */
    /* JADX WARN: Code duplicated, block: B:88:0x027f  */
    /* JADX WARN: Code duplicated, block: B:92:0x028e A[LOOP:1: B:90:0x028a->B:92:0x028e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:93:0x0294  */
    /* JADX WARN: Code duplicated, block: B:96:0x02a8  */
    private void A08(InterfaceC1234Bt interfaceC1234Bt, CE ce2, int i11) throws InterruptedException, IOException {
        int iA07;
        byte[] bArr;
        int i12;
        int i13;
        int i14;
        int iA00;
        String[] strArr;
        String[] strArr2;
        int i15;
        boolean z11;
        int i16;
        if (A03(843, 11, 89).equals(ce2.A0Y)) {
            A09(interfaceC1234Bt, A0w, i11);
            return;
        }
        if (A03(833, 10, 57).equals(ce2.A0Y)) {
            A09(interfaceC1234Bt, A0u, i11);
            return;
        }
        C4 c11 = ce2.A0W;
        if (this.A0S) {
            iA07 = i11 + this.A0j.A07();
            if (!A03(938, 15, 24).equals(ce2.A0Y)) {
                strArr2 = A0q;
                if (strArr2[3].length() != strArr2[4].length()) {
                    A0q[7] = "RszYuFLetKptIKAzZi5TrivHGyzVJlzF";
                    if (A03(967, 16, 18).equals(ce2.A0Y)) {
                        if (ce2.A0X != null) {
                            if (this.A0j.A07() == 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            AbstractC1351Ha.A04(z11);
                            ce2.A0X.A01(interfaceC1234Bt, this.A01, iA07);
                        }
                        while (true) {
                            i15 = this.A07;
                            if (i15 < iA07) {
                                break;
                                break;
                            }
                            A00(interfaceC1234Bt, c11, iA07 - i15);
                        }
                    } else {
                        bArr = this.A0h.A00;
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                        i12 = ce2.A0M;
                        i13 = 4 - ce2.A0M;
                        while (this.A07 < iA07) {
                            i14 = this.A09;
                            if (i14 == 0) {
                                A0A(interfaceC1234Bt, bArr, i13, i12);
                                this.A0h.A0Y(0);
                                this.A09 = this.A0h.A0H();
                                this.A0i.A0Y(0);
                                c11.AFR(this.A0i, 4);
                                this.A08 += 4;
                            } else {
                                iA00 = i14 - A00(interfaceC1234Bt, c11, i14);
                                strArr = A0q;
                                if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                    String[] strArr3 = A0q;
                                    strArr3[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                                    strArr3[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                                    this.A09 = iA00;
                                }
                            }
                        }
                    }
                } else {
                    String[] strArr4 = A0q;
                    strArr4[0] = "n5KvGwKmSVXSgkcPIzRNIJsu4vgaIOKI";
                    strArr4[2] = "bzKZ8kTny4n19sCxh6YTLkMgvo4kJK45";
                    if (A03(967, 16, 18).equals(ce2.A0Y)) {
                        if (ce2.A0X != null) {
                            if (this.A0j.A07() == 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            AbstractC1351Ha.A04(z11);
                            ce2.A0X.A01(interfaceC1234Bt, this.A01, iA07);
                        }
                        while (true) {
                            i15 = this.A07;
                            if (i15 < iA07) {
                                break;
                            } else {
                                A00(interfaceC1234Bt, c11, iA07 - i15);
                            }
                        }
                    } else {
                        bArr = this.A0h.A00;
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                        i12 = ce2.A0M;
                        i13 = 4 - ce2.A0M;
                        while (this.A07 < iA07) {
                            i14 = this.A09;
                            if (i14 == 0) {
                                A0A(interfaceC1234Bt, bArr, i13, i12);
                                this.A0h.A0Y(0);
                                this.A09 = this.A0h.A0H();
                                this.A0i.A0Y(0);
                                c11.AFR(this.A0i, 4);
                                this.A08 += 4;
                            } else {
                                iA00 = i14 - A00(interfaceC1234Bt, c11, i14);
                                strArr = A0q;
                                if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                    String[] strArr5 = A0q;
                                    strArr5[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                                    strArr5[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                                    this.A09 = iA00;
                                }
                            }
                        }
                    }
                }
            } else {
                bArr = this.A0h.A00;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                i12 = ce2.A0M;
                i13 = 4 - ce2.A0M;
                while (this.A07 < iA07) {
                    i14 = this.A09;
                    if (i14 == 0) {
                        A0A(interfaceC1234Bt, bArr, i13, i12);
                        this.A0h.A0Y(0);
                        this.A09 = this.A0h.A0H();
                        this.A0i.A0Y(0);
                        c11.AFR(this.A0i, 4);
                        this.A08 += 4;
                    } else {
                        iA00 = i14 - A00(interfaceC1234Bt, c11, i14);
                        strArr = A0q;
                        if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                            String[] strArr6 = A0q;
                            strArr6[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                            strArr6[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                            this.A09 = iA00;
                        }
                    }
                }
            }
            if (A03(181, 8, 87).equals(ce2.A0Y)) {
                this.A0n.A0Y(0);
                c11.AFR(this.A0n, 4);
                this.A08 += 4;
                return;
            }
            return;
        }
        if (ce2.A0c) {
            this.A01 &= -1073741825;
            if (!this.A0X) {
                interfaceC1234Bt.readFully(this.A0k.A00, 0, 1);
                this.A07++;
                if ((this.A0k.A00[0] & 128) == 128) {
                    throw new C11849v(A03(504, 35, 22));
                }
                this.A00 = this.A0k.A00[0];
                this.A0X = true;
            }
            byte b11 = this.A00;
            if ((b11 & 1) == 1) {
                boolean z12 = (b11 & 2) == 2;
                this.A01 |= 1073741824;
                if (!this.A0T) {
                    interfaceC1234Bt.readFully(this.A0f.A00, 0, 8);
                    this.A07 += 8;
                    this.A0T = true;
                    this.A0k.A00[0] = (byte) ((z12 ? 128 : 0) | 8);
                    this.A0k.A0Y(0);
                    c11.AFR(this.A0k, 1);
                    this.A08++;
                    this.A0f.A0Y(0);
                    c11.AFR(this.A0f, 8);
                    this.A08 += 8;
                }
                if (z12) {
                    if (!this.A0U) {
                        interfaceC1234Bt.readFully(this.A0k.A00, 0, 1);
                        this.A07++;
                        this.A0k.A0Y(0);
                        this.A0A = this.A0k.A0E();
                        this.A0U = true;
                    }
                    int i17 = this.A0A * 4;
                    this.A0k.A0W(i17);
                    interfaceC1234Bt.readFully(this.A0k.A00, 0, i17);
                    this.A07 += i17;
                    short s11 = (short) ((this.A0A / 2) + 1);
                    int i18 = (s11 * 6) + 2;
                    ByteBuffer byteBuffer = this.A0R;
                    if (byteBuffer == null || byteBuffer.capacity() < i18) {
                        this.A0R = ByteBuffer.allocate(i18);
                    }
                    this.A0R.position(0);
                    if (A0q[7].charAt(2) != 'J') {
                        String[] strArr7 = A0q;
                        strArr7[3] = "THDQpgmvr4cFRBgiNMs8PF";
                        strArr7[4] = "1poAoCQZUv3pf1E";
                        this.A0R.putShort(s11);
                        int iA0H = 0;
                        int i19 = 0;
                        while (true) {
                            i16 = this.A0A;
                            if (i19 >= i16) {
                                break;
                            }
                            int i21 = iA0H;
                            iA0H = this.A0k.A0H();
                            if (i19 % 2 == 0) {
                                this.A0R.putShort((short) (iA0H - i21));
                            } else {
                                this.A0R.putInt(iA0H - i21);
                            }
                            i19++;
                        }
                        int i22 = (i11 - this.A07) - iA0H;
                        if (i16 % 2 == 1) {
                            this.A0R.putInt(i22);
                        } else {
                            this.A0R.putShort((short) i22);
                            this.A0R.putInt(0);
                        }
                        this.A0g.A0b(this.A0R.array(), i18);
                        c11.AFR(this.A0g, i18);
                        this.A08 += i18;
                    }
                }
            }
        } else if (ce2.A0f != null) {
            this.A0j.A0b(ce2.A0f, ce2.A0f.length);
        }
        this.A0S = true;
        iA07 = i11 + this.A0j.A07();
        if (!A03(938, 15, 24).equals(ce2.A0Y)) {
            strArr2 = A0q;
            if (strArr2[3].length() != strArr2[4].length()) {
                A0q[7] = "RszYuFLetKptIKAzZi5TrivHGyzVJlzF";
                if (A03(967, 16, 18).equals(ce2.A0Y)) {
                    if (ce2.A0X != null) {
                        if (this.A0j.A07() == 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        AbstractC1351Ha.A04(z11);
                        ce2.A0X.A01(interfaceC1234Bt, this.A01, iA07);
                    }
                    while (true) {
                        i15 = this.A07;
                        if (i15 < iA07) {
                            break;
                            break;
                        }
                        A00(interfaceC1234Bt, c11, iA07 - i15);
                    }
                } else {
                    bArr = this.A0h.A00;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    i12 = ce2.A0M;
                    i13 = 4 - ce2.A0M;
                    while (this.A07 < iA07) {
                        i14 = this.A09;
                        if (i14 == 0) {
                            A0A(interfaceC1234Bt, bArr, i13, i12);
                            this.A0h.A0Y(0);
                            this.A09 = this.A0h.A0H();
                            this.A0i.A0Y(0);
                            c11.AFR(this.A0i, 4);
                            this.A08 += 4;
                        } else {
                            iA00 = i14 - A00(interfaceC1234Bt, c11, i14);
                            strArr = A0q;
                            if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                String[] strArr8 = A0q;
                                strArr8[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                                strArr8[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                                this.A09 = iA00;
                            }
                        }
                    }
                }
            } else {
                String[] strArr9 = A0q;
                strArr9[0] = "n5KvGwKmSVXSgkcPIzRNIJsu4vgaIOKI";
                strArr9[2] = "bzKZ8kTny4n19sCxh6YTLkMgvo4kJK45";
                if (A03(967, 16, 18).equals(ce2.A0Y)) {
                    if (ce2.A0X != null) {
                        if (this.A0j.A07() == 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        AbstractC1351Ha.A04(z11);
                        ce2.A0X.A01(interfaceC1234Bt, this.A01, iA07);
                    }
                    while (true) {
                        i15 = this.A07;
                        if (i15 < iA07) {
                            break;
                            break;
                        }
                        A00(interfaceC1234Bt, c11, iA07 - i15);
                    }
                } else {
                    bArr = this.A0h.A00;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    i12 = ce2.A0M;
                    i13 = 4 - ce2.A0M;
                    while (this.A07 < iA07) {
                        i14 = this.A09;
                        if (i14 == 0) {
                            A0A(interfaceC1234Bt, bArr, i13, i12);
                            this.A0h.A0Y(0);
                            this.A09 = this.A0h.A0H();
                            this.A0i.A0Y(0);
                            c11.AFR(this.A0i, 4);
                            this.A08 += 4;
                        } else {
                            iA00 = i14 - A00(interfaceC1234Bt, c11, i14);
                            strArr = A0q;
                            if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                String[] strArr10 = A0q;
                                strArr10[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                                strArr10[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                                this.A09 = iA00;
                            }
                        }
                    }
                }
            }
        } else {
            bArr = this.A0h.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            i12 = ce2.A0M;
            i13 = 4 - ce2.A0M;
            while (this.A07 < iA07) {
                i14 = this.A09;
                if (i14 == 0) {
                    A0A(interfaceC1234Bt, bArr, i13, i12);
                    this.A0h.A0Y(0);
                    this.A09 = this.A0h.A0H();
                    this.A0i.A0Y(0);
                    c11.AFR(this.A0i, 4);
                    this.A08 += 4;
                } else {
                    iA00 = i14 - A00(interfaceC1234Bt, c11, i14);
                    strArr = A0q;
                    if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                        String[] strArr11 = A0q;
                        strArr11[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                        strArr11[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                        this.A09 = iA00;
                    }
                }
            }
        }
        if (A03(181, 8, 87).equals(ce2.A0Y)) {
            this.A0n.A0Y(0);
            c11.AFR(this.A0n, 4);
            this.A08 += 4;
            return;
        }
        return;
        throw new RuntimeException();
    }

    private void A09(InterfaceC1234Bt interfaceC1234Bt, byte[] bArr, int i11) throws InterruptedException, IOException {
        int length = bArr.length + i11;
        if (this.A0m.A05() < length) {
            this.A0m.A00 = Arrays.copyOf(bArr, length + i11);
        } else {
            System.arraycopy(bArr, 0, this.A0m.A00, 0, bArr.length);
        }
        interfaceC1234Bt.readFully(this.A0m.A00, bArr.length, i11);
        this.A0m.A0W(length);
    }

    private void A0A(InterfaceC1234Bt interfaceC1234Bt, byte[] bArr, int i11, int i12) throws InterruptedException, IOException {
        int iMin = Math.min(i12, this.A0j.A04());
        interfaceC1234Bt.readFully(bArr, i11 + iMin, i12 - iMin);
        if (iMin > 0) {
            this.A0j.A0c(bArr, i11, iMin);
        }
        this.A07 += i12;
    }

    private void A0B(CE ce2, long j11) {
        if (ce2.A0X != null) {
            CF cf2 = ce2.A0X;
            if (A0q[6].length() != 27) {
                throw new RuntimeException();
            }
            A0q[6] = "nKrIVrdQs7NkqXN01cL0onp1lFd";
            cf2.A03(ce2, j11);
        } else {
            if (A03(843, 11, 89).equals(ce2.A0Y)) {
                A0C(ce2, A03(33, 19, 7), 19, 1000L, A0x);
            } else if (A03(833, 10, 57).equals(ce2.A0Y)) {
                A0C(ce2, A03(14, 19, 109), 21, 10000L, A0v);
            }
            ce2.A0W.AFS(j11, this.A01, this.A08, 0, ce2.A0V);
        }
        this.A0V = true;
        A05();
    }

    private void A0C(CE ce2, String str, int i11, long j11, byte[] bArr) {
        A0D(this.A0m.A00, this.A0C, str, i11, j11, bArr);
        C4 c11 = ce2.A0W;
        C1376Hz c1376Hz = this.A0m;
        c11.AFR(c1376Hz, c1376Hz.A07());
        this.A08 += this.A0m.A07();
    }

    public static void A0D(byte[] bArr, long j11, String str, int i11, long j12, byte[] bArr2) {
        byte[] bArrA0i;
        if (j11 == C.TIME_UNSET) {
            bArrA0i = bArr2;
        } else {
            int i12 = (int) (j11 / 3600000000L);
            long j13 = j11 - (((long) (i12 * 3600)) * 1000000);
            int i13 = (int) (j13 / 60000000);
            long j14 = j13 - (((long) (i13 * 60)) * 1000000);
            int i14 = (int) (j14 / 1000000);
            bArrA0i = IF.A0i(String.format(Locale.US, str, Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf((int) ((j14 - (((long) i14) * 1000000)) / j12))));
        }
        System.arraycopy(bArrA0i, 0, bArr, i11, bArr2.length);
    }

    private boolean A0E(C1238Bz c1238Bz, long j11) {
        if (this.A0Y) {
            this.A0J = j11;
            c1238Bz.A00 = this.A0F;
            this.A0Y = false;
            return true;
        }
        boolean z11 = this.A0a;
        String[] strArr = A0q;
        if (strArr[0].charAt(31) == strArr[2].charAt(31)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0q;
        strArr2[1] = "bgcuSmmv9nMD5qNgR1ZnJGCWOsXR4zDF";
        strArr2[5] = "rXrXJdml0w7r8hjghYXvJH5LLiJomjK3";
        if (z11) {
            long j12 = this.A0J;
            if (j12 != -1) {
                c1238Bz.A00 = j12;
                this.A0J = -1L;
                return true;
            }
        }
        return false;
    }

    public static boolean A0F(String str) {
        if (!A03(PointerIconCompat.TYPE_CELL, 5, 58).equals(str) && !A03(1011, 5, 20).equals(str) && !A03(902, 7, 72).equals(str)) {
            String strA03 = A03(953, 14, 105);
            String[] strArr = A0q;
            if (strArr[1].charAt(15) == strArr[5].charAt(15)) {
                A0q[7] = "rYhgwmDh4TKBcj4Uwcvshsmah3Wf4ae0";
                if (!strA03.equals(str) && !A03(923, 15, 86).equals(str) && !A03(909, 14, 120).equals(str) && !A03(938, 15, 24).equals(str) && !A03(967, 16, 18).equals(str) && !A03(983, 15, 111).equals(str)) {
                    String[] strArr2 = A0q;
                    if (strArr2[1].charAt(15) != strArr2[5].charAt(15)) {
                        throw new RuntimeException();
                    }
                    A0q[6] = "rlxG2GXYid9bCHwXApke8Gz33sW";
                    if (!A03(998, 8, 91).equals(str) && !A03(154, 6, 102).equals(str) && !A03(181, 8, 87).equals(str) && !A03(74, 5, WebSocketProtocol.PAYLOAD_SHORT).equals(str) && !A03(128, 9, 102).equals(str) && !A03(137, 9, 8).equals(str) && !A03(79, 5, 124).equals(str) && !A03(116, 6, 59).equals(str) && !A03(173, 8, 62).equals(str) && !A03(84, 5, 98).equals(str) && !A03(89, 13, 62).equals(str) && !A03(102, 14, 86).equals(str) && !A03(122, 6, 17).equals(str) && !A03(146, 8, 39).equals(str) && !A03(160, 13, 79).equals(str)) {
                        boolean zEquals = A03(843, 11, 89).equals(str);
                        String[] strArr3 = A0q;
                        if (strArr3[0].charAt(31) != strArr3[2].charAt(31)) {
                            String[] strArr4 = A0q;
                            strArr4[1] = "DfP1dlVZEdoO22ggDOih4DhJX4h9DttB";
                            strArr4[5] = "iPMsbxRLvFu5COzgJWPWeI2fmUuAHT3S";
                            if (!zEquals && !A03(833, 10, 57).equals(str) && !A03(854, 8, 119).equals(str) && !A03(823, 10, 117).equals(str) && !A03(815, 8, 17).equals(str)) {
                                return false;
                            }
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return true;
    }

    public static int[] A0H(int[] iArr, int i11) {
        if (iArr == null) {
            return new int[i11];
        }
        return iArr.length >= i11 ? iArr : new int[Math.max(iArr.length * 2, i11)];
    }

    public final void A0I(int i11) throws C11849v {
        switch (i11) {
            case 160:
                if (this.A04 != 2) {
                    return;
                }
                if (!this.A0W) {
                    this.A01 = 1 | this.A01;
                }
                A0B(this.A0c.get(this.A05), this.A0D);
                this.A04 = 0;
                return;
            case 174:
                if (A0F(this.A0O.A0Y)) {
                    CE ce2 = this.A0O;
                    ce2.A09(this.A0N, ce2.A0N);
                    this.A0c.put(this.A0O.A0N, this.A0O);
                }
                this.A0O = null;
                return;
            case 19899:
                int i12 = this.A0B;
                if (i12 != -1) {
                    long j11 = this.A0I;
                    if (j11 != -1) {
                        if (i12 == 475249515) {
                            this.A0F = j11;
                            return;
                        }
                        return;
                    }
                }
                throw new C11849v(A03(667, 50, 26));
            case 25152:
                if (this.A0O.A0c) {
                    if (this.A0O.A0V == null) {
                        throw new C11849v(A03(449, 55, 115));
                    }
                    this.A0O.A0U = new DrmInitData(new DrmInitData.SchemeData(C9W.A04, A03(1024, 10, 63), this.A0O.A0V.A03));
                    return;
                }
                return;
            case 28032:
                if (this.A0O.A0c && this.A0O.A0f != null) {
                    throw new C11849v(A03(243, 53, 10));
                }
                return;
            case 357149030:
                if (this.A0M == C.TIME_UNSET) {
                    this.A0M = 1000000L;
                }
                long j12 = this.A0G;
                if (j12 != C.TIME_UNSET) {
                    this.A0H = A01(j12);
                    return;
                }
                return;
            case 374648427:
                if (this.A0c.size() == 0) {
                    throw new C11849v(A03(756, 26, 64));
                }
                this.A0N.A5Y();
                return;
            case 475249515:
                if (this.A0a) {
                    return;
                }
                this.A0N.AFi(A02());
                this.A0a = true;
                return;
            default:
                return;
        }
    }

    public final void A0J(int i11, double d11) {
        switch (i11) {
            case 181:
                this.A0O.A0O = (int) d11;
                break;
            case 17545:
                this.A0G = (long) d11;
                break;
            case 21969:
                this.A0O.A06 = (float) d11;
                break;
            case 21970:
                this.A0O.A07 = (float) d11;
                break;
            case 21971:
                this.A0O.A04 = (float) d11;
                break;
            case 21972:
                this.A0O.A05 = (float) d11;
                break;
            case 21973:
                this.A0O.A02 = (float) d11;
                break;
            case 21974:
                this.A0O.A03 = (float) d11;
                break;
            case 21975:
                this.A0O.A08 = (float) d11;
                break;
            case 21976:
                this.A0O.A09 = (float) d11;
                break;
            case 21977:
                this.A0O.A00 = (float) d11;
                break;
            case 21978:
                this.A0O.A01 = (float) d11;
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0311  */
    /* JADX WARN: Code duplicated, block: B:103:0x0324  */
    /* JADX WARN: Code duplicated, block: B:108:0x0340  */
    /* JADX WARN: Code duplicated, block: B:109:0x0346 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x0383  */
    /* JADX WARN: Code duplicated, block: B:123:0x025c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x0349 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x028b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x0373 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x0363 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x0363 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x0363 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x0337 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x02ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x02fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x02f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x01f8 A[PHI: r3
  0x01f8: PHI (r3v14 int[]) = (r3v6 int[]), (r3v15 int[]) binds: [B:64:0x021e, B:58:0x01f6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x0221  */
    /* JADX WARN: Code duplicated, block: B:67:0x0233 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x0235  */
    /* JADX WARN: Code duplicated, block: B:71:0x023e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0268 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x026a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0273  */
    /* JADX WARN: Code duplicated, block: B:84:0x0291  */
    /* JADX WARN: Code duplicated, block: B:86:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:88:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:92:0x02cf A[LOOP:4: B:91:0x02cd->B:92:0x02cf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:93:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:98:0x0300  */
    public final void A0K(int i11, int i12, InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        int[] iArrA0H;
        int i13;
        int i14;
        int i15;
        int i16;
        String[] strArr;
        long j11;
        int i17;
        int i18;
        int[] iArr;
        int i19;
        int i21;
        String[] strArr2;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        String[] strArr3;
        int i31 = 0;
        int i32 = 1;
        switch (i11) {
            case 161:
            case 163:
                if (this.A04 == 0) {
                    this.A05 = (int) this.A0e.A05(interfaceC1234Bt, false, true, 8);
                    this.A06 = this.A0e.A04();
                    this.A0C = C.TIME_UNSET;
                    this.A04 = 1;
                    this.A0k.A0V();
                }
                CE ce2 = this.A0c.get(this.A05);
                if (ce2 == null) {
                    interfaceC1234Bt.AGP(i12 - this.A06);
                    this.A04 = 0;
                    return;
                }
                if (this.A04 == 1) {
                    A07(interfaceC1234Bt, 3);
                    int i33 = (this.A0k.A00[2] & 6) >> 1;
                    if (i33 == 0) {
                        this.A02 = 1;
                        int[] iArrA0H2 = A0H(this.A0b, 1);
                        this.A0b = iArrA0H2;
                        iArrA0H2[0] = (i12 - this.A06) - 3;
                    } else {
                        if (i11 != 163) {
                            throw new C11849v(A03(629, 38, 69));
                        }
                        A07(interfaceC1234Bt, 4);
                        int i34 = (this.A0k.A00[3] & 255) + 1;
                        this.A02 = i34;
                        int[] iArr2 = this.A0b;
                        String[] strArr4 = A0q;
                        if (strArr4[0].charAt(31) != strArr4[2].charAt(31)) {
                            String[] strArr5 = A0q;
                            strArr5[3] = "RwuJZhEYbPwrYhgspkpAZU";
                            strArr5[4] = "DTAVHXJ2rXJnopR";
                            iArrA0H = A0H(iArr2, i34);
                            this.A0b = iArrA0H;
                            if (i33 == 2) {
                                i28 = (i12 - this.A06) - 4;
                                i29 = this.A02;
                                strArr3 = A0q;
                                if (strArr3[1].charAt(15) == strArr3[5].charAt(15)) {
                                    String[] strArr6 = A0q;
                                    strArr6[1] = "RQftDwpqwbIXAF1g5dDgy2XjM3R9Fufd";
                                    strArr6[5] = "50lzYqnE8by0N6RgVVPD3M33x9kk99sn";
                                    Arrays.fill(iArrA0H, 0, i29, i28 / i29);
                                }
                            } else if (i33 == 1) {
                                i22 = 0;
                                i23 = 4;
                                i24 = 0;
                                while (true) {
                                    i25 = this.A02;
                                    if (i24 < i25 - 1) {
                                        this.A0b[i24] = 0;
                                        do {
                                            i23++;
                                            A07(interfaceC1234Bt, i23);
                                            i26 = this.A0k.A00[i23 - 1] & 255;
                                            int[] iArr3 = this.A0b;
                                            i27 = iArr3[i24] + i26;
                                            iArr3[i24] = i27;
                                        } while (i26 == 255);
                                        i22 += i27;
                                        i24++;
                                    } else {
                                        this.A0b[i25 - 1] = ((i12 - this.A06) - i23) - i22;
                                    }
                                }
                            } else {
                                if (i33 == 3) {
                                    throw new C11849v(A03(877, 25, 30) + i33);
                                }
                                i13 = 0;
                                i14 = 4;
                                i15 = 0;
                                while (true) {
                                    i16 = this.A02;
                                    if (i15 < i16 - 1) {
                                        this.A0b[i15] = i31;
                                        strArr = A0q;
                                        if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                            throw new RuntimeException();
                                        }
                                        A0q[6] = "AJCSp0dPwFu9XZoKvCoy3nlmL9O";
                                        i14++;
                                        A07(interfaceC1234Bt, i14);
                                        if (this.A0k.A00[i14 - 1] != 0) {
                                            throw new C11849v(A03(782, 33, 29));
                                        }
                                        j11 = 0;
                                        i17 = 0;
                                        while (i17 < 8) {
                                            i19 = i32 << (7 - i17);
                                            if ((this.A0k.A00[i14 - 1] & i19) != 0) {
                                                int i35 = i14 - 1;
                                                i14 += i17;
                                                A07(interfaceC1234Bt, i14);
                                                j11 = this.A0k.A00[i35] & 255 & (i19 ^ (-1));
                                                for (i21 = i35 + 1; i21 < i14; i21++) {
                                                    j11 = (j11 << 8) | ((long) (this.A0k.A00[i21] & 255));
                                                }
                                                if (i15 > 0) {
                                                    j11 -= (1 << ((i17 * 7) + 6)) - 1;
                                                }
                                                if (j11 < -2147483648L) {
                                                    if (A0q[7].charAt(2) != 'J') {
                                                        String[] strArr7 = A0q;
                                                        strArr7[3] = "iXrhrupjbccuPW1gfooQkR";
                                                        strArr7[4] = "StwCIbMJGGxOC39";
                                                        if (j11 > 2147483647L) {
                                                        }
                                                        i18 = (int) j11;
                                                        iArr = this.A0b;
                                                        if (i15 == 0) {
                                                            i18 += iArr[i15 - 1];
                                                        }
                                                        iArr[i15] = i18;
                                                        i13 += i18;
                                                        i15++;
                                                        i31 = 0;
                                                        i32 = 1;
                                                    } else {
                                                        if (j11 > 2147483647L) {
                                                        }
                                                        i18 = (int) j11;
                                                        iArr = this.A0b;
                                                        if (i15 == 0) {
                                                            i18 += iArr[i15 - 1];
                                                        }
                                                        iArr[i15] = i18;
                                                        i13 += i18;
                                                        i15++;
                                                        i31 = 0;
                                                        i32 = 1;
                                                    }
                                                }
                                                throw new C11849v(A03(396, 37, 107));
                                            }
                                            i17++;
                                            strArr2 = A0q;
                                            if (strArr2[0].charAt(31) != strArr2[2].charAt(31)) {
                                                A0q[7] = "JvemuAcSz5vc2l4QyutSma8u3cOiXxC4";
                                                i32 = 1;
                                            } else {
                                                i32 = 1;
                                            }
                                        }
                                        if (j11 < -2147483648L) {
                                            if (A0q[7].charAt(2) != 'J') {
                                                String[] strArr8 = A0q;
                                                strArr8[3] = "iXrhrupjbccuPW1gfooQkR";
                                                strArr8[4] = "StwCIbMJGGxOC39";
                                                if (j11 > 2147483647L) {
                                                }
                                                i18 = (int) j11;
                                                iArr = this.A0b;
                                                if (i15 == 0) {
                                                    i18 += iArr[i15 - 1];
                                                }
                                                iArr[i15] = i18;
                                                i13 += i18;
                                                i15++;
                                                i31 = 0;
                                                i32 = 1;
                                            } else {
                                                if (j11 > 2147483647L) {
                                                }
                                                i18 = (int) j11;
                                                iArr = this.A0b;
                                                if (i15 == 0) {
                                                    i18 += iArr[i15 - 1];
                                                }
                                                iArr[i15] = i18;
                                                i13 += i18;
                                                i15++;
                                                i31 = 0;
                                                i32 = 1;
                                            }
                                        }
                                        throw new C11849v(A03(396, 37, 107));
                                    }
                                    this.A0b[i16 - 1] = ((i12 - this.A06) - i14) - i13;
                                }
                            }
                        } else {
                            iArrA0H = A0H(iArr2, i34);
                            this.A0b = iArrA0H;
                            if (i33 == 2) {
                                i28 = (i12 - this.A06) - 4;
                                i29 = this.A02;
                                strArr3 = A0q;
                                if (strArr3[1].charAt(15) == strArr3[5].charAt(15)) {
                                    String[] strArr9 = A0q;
                                    strArr9[1] = "RQftDwpqwbIXAF1g5dDgy2XjM3R9Fufd";
                                    strArr9[5] = "50lzYqnE8by0N6RgVVPD3M33x9kk99sn";
                                    Arrays.fill(iArrA0H, 0, i29, i28 / i29);
                                }
                            } else if (i33 == 1) {
                                i22 = 0;
                                i23 = 4;
                                i24 = 0;
                                while (true) {
                                    i25 = this.A02;
                                    if (i24 < i25 - 1) {
                                        this.A0b[i24] = 0;
                                        do {
                                            i23++;
                                            A07(interfaceC1234Bt, i23);
                                            i26 = this.A0k.A00[i23 - 1] & 255;
                                            int[] iArr4 = this.A0b;
                                            i27 = iArr4[i24] + i26;
                                            iArr4[i24] = i27;
                                        } while (i26 == 255);
                                        i22 += i27;
                                        i24++;
                                    } else {
                                        this.A0b[i25 - 1] = ((i12 - this.A06) - i23) - i22;
                                    }
                                }
                            } else {
                                if (i33 == 3) {
                                    throw new C11849v(A03(877, 25, 30) + i33);
                                }
                                i13 = 0;
                                i14 = 4;
                                i15 = 0;
                                while (true) {
                                    i16 = this.A02;
                                    if (i15 < i16 - 1) {
                                        this.A0b[i15] = i31;
                                        strArr = A0q;
                                        if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                            throw new RuntimeException();
                                        }
                                        A0q[6] = "AJCSp0dPwFu9XZoKvCoy3nlmL9O";
                                        i14++;
                                        A07(interfaceC1234Bt, i14);
                                        if (this.A0k.A00[i14 - 1] != 0) {
                                            throw new C11849v(A03(782, 33, 29));
                                        }
                                        j11 = 0;
                                        i17 = 0;
                                        while (i17 < 8) {
                                            i19 = i32 << (7 - i17);
                                            if ((this.A0k.A00[i14 - 1] & i19) != 0) {
                                                int i36 = i14 - 1;
                                                i14 += i17;
                                                A07(interfaceC1234Bt, i14);
                                                j11 = this.A0k.A00[i36] & 255 & (i19 ^ (-1));
                                                while (i21 < i14) {
                                                    j11 = (j11 << 8) | ((long) (this.A0k.A00[i21] & 255));
                                                }
                                                if (i15 > 0) {
                                                    j11 -= (1 << ((i17 * 7) + 6)) - 1;
                                                }
                                                if (j11 < -2147483648L) {
                                                    if (A0q[7].charAt(2) != 'J') {
                                                        String[] strArr10 = A0q;
                                                        strArr10[3] = "iXrhrupjbccuPW1gfooQkR";
                                                        strArr10[4] = "StwCIbMJGGxOC39";
                                                        if (j11 > 2147483647L) {
                                                        }
                                                        i18 = (int) j11;
                                                        iArr = this.A0b;
                                                        if (i15 == 0) {
                                                            i18 += iArr[i15 - 1];
                                                        }
                                                        iArr[i15] = i18;
                                                        i13 += i18;
                                                        i15++;
                                                        i31 = 0;
                                                        i32 = 1;
                                                    } else {
                                                        if (j11 > 2147483647L) {
                                                        }
                                                        i18 = (int) j11;
                                                        iArr = this.A0b;
                                                        if (i15 == 0) {
                                                            i18 += iArr[i15 - 1];
                                                        }
                                                        iArr[i15] = i18;
                                                        i13 += i18;
                                                        i15++;
                                                        i31 = 0;
                                                        i32 = 1;
                                                    }
                                                }
                                                throw new C11849v(A03(396, 37, 107));
                                            }
                                            i17++;
                                            strArr2 = A0q;
                                            if (strArr2[0].charAt(31) != strArr2[2].charAt(31)) {
                                                A0q[7] = "JvemuAcSz5vc2l4QyutSma8u3cOiXxC4";
                                                i32 = 1;
                                            } else {
                                                i32 = 1;
                                            }
                                        }
                                        if (j11 < -2147483648L) {
                                            if (A0q[7].charAt(2) != 'J') {
                                                String[] strArr11 = A0q;
                                                strArr11[3] = "iXrhrupjbccuPW1gfooQkR";
                                                strArr11[4] = "StwCIbMJGGxOC39";
                                                if (j11 > 2147483647L) {
                                                }
                                                i18 = (int) j11;
                                                iArr = this.A0b;
                                                if (i15 == 0) {
                                                    i18 += iArr[i15 - 1];
                                                }
                                                iArr[i15] = i18;
                                                i13 += i18;
                                                i15++;
                                                i31 = 0;
                                                i32 = 1;
                                            } else {
                                                if (j11 > 2147483647L) {
                                                }
                                                i18 = (int) j11;
                                                iArr = this.A0b;
                                                if (i15 == 0) {
                                                    i18 += iArr[i15 - 1];
                                                }
                                                iArr[i15] = i18;
                                                i13 += i18;
                                                i15++;
                                                i31 = 0;
                                                i32 = 1;
                                            }
                                        }
                                        throw new C11849v(A03(396, 37, 107));
                                    }
                                    this.A0b[i16 - 1] = ((i12 - this.A06) - i14) - i13;
                                }
                            }
                        }
                    }
                    this.A0D = this.A0E + A01((this.A0k.A00[0] << 8) | (this.A0k.A00[1] & 255));
                    this.A01 = (ce2.A0Q == 2 || (i11 == 163 && (this.A0k.A00[2] & 128) == 128) ? 1 : 0) | ((this.A0k.A00[2] & 8) == 8 ? Integer.MIN_VALUE : 0);
                    this.A04 = 2;
                    this.A03 = 0;
                }
                if (i11 != 163) {
                    A08(interfaceC1234Bt, ce2, this.A0b[0]);
                    return;
                }
                while (true) {
                    int i37 = this.A03;
                    if (i37 >= this.A02) {
                        this.A04 = 0;
                        return;
                    }
                    A08(interfaceC1234Bt, ce2, this.A0b[i37]);
                    A0B(ce2, this.A0D + ((long) ((this.A03 * ce2.A0F) / 1000)));
                    int i38 = this.A03;
                    String[] strArr12 = A0q;
                    if (strArr12[3].length() != strArr12[4].length()) {
                        String[] strArr13 = A0q;
                        strArr13[3] = "D8CgfCqU2RyOXDgpSzfJOF";
                        strArr13[4] = "qE8wnFvtme9ZmNp";
                        this.A03 = i38 + 1;
                    } else {
                        String[] strArr14 = A0q;
                        strArr14[0] = "QTaMrDGiQsJaoOEX9JrEklVzvDfFq8um";
                        strArr14[2] = "wfV4ykUdaNXbzihAU76Od3hvCzrHPeln";
                        this.A03 = i38 + 1;
                    }
                }
                break;
            case 16981:
                this.A0O.A0f = new byte[i12];
                byte[] bArr = this.A0O.A0f;
                String[] strArr15 = A0q;
                if (strArr15[1].charAt(15) == strArr15[5].charAt(15)) {
                    A0q[6] = "apQqLvL9mVkkZpyD1gGQRufbtxV";
                    interfaceC1234Bt.readFully(bArr, 0, i12);
                    return;
                }
                break;
            case 18402:
                byte[] bArr2 = new byte[i12];
                interfaceC1234Bt.readFully(bArr2, 0, i12);
                this.A0O.A0V = new C3(1, bArr2, 0, 0);
                return;
            case 21419:
                Arrays.fill(this.A0l.A00, (byte) 0);
                interfaceC1234Bt.readFully(this.A0l.A00, 4 - i12, i12);
                this.A0l.A0Y(0);
                this.A0B = (int) this.A0l.A0M();
                return;
            case 25506:
                this.A0O.A0d = new byte[i12];
                interfaceC1234Bt.readFully(this.A0O.A0d, 0, i12);
                return;
            case 30322:
                this.A0O.A0e = new byte[i12];
                interfaceC1234Bt.readFully(this.A0O.A0e, 0, i12);
                return;
            default:
                throw new C11849v(A03(862, 15, 7) + i11);
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code duplicated, block: B:95:0x01e5  */
    public final void A0L(int i11, long j11) throws C11849v {
        boolean z11 = false;
        String strA03 = A03(0, 14, 21);
        switch (i11) {
            case 131:
                this.A0O.A0Q = (int) j11;
                return;
            case 136:
                CE ce2 = this.A0O;
                String[] strArr = A0q;
                if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                    String[] strArr2 = A0q;
                    strArr2[1] = "dnlPxGSMw9IfVDogfualtgwGzOIqKL0v";
                    strArr2[5] = "sfCl2vw1fgJd0VDghIrSAi3kGetUjpNf";
                    if (j11 == 1) {
                        z11 = true;
                    }
                } else {
                    String[] strArr3 = A0q;
                    strArr3[1] = "e8S13q37f3oqi2Xgxg7oDCnYjszKvzMZ";
                    strArr3[5] = "sUUQ807hVNhLoz0ge5jS5NLDJS8BF8yk";
                    if (j11 == 1) {
                        z11 = true;
                    }
                }
                ce2.A0Z = z11;
                return;
            case 155:
                this.A0C = A01(j11);
                return;
            case 159:
                this.A0O.A0B = (int) j11;
                return;
            case 176:
                this.A0O.A0R = (int) j11;
                return;
            case 179:
                this.A0Q.A04(A01(j11));
                return;
            case 186:
                this.A0O.A0J = (int) j11;
                return;
            case 215:
                this.A0O.A0N = (int) j11;
                return;
            case 231:
                this.A0E = A01(j11);
                return;
            case 241:
                if (this.A0Z) {
                    return;
                }
                C1366Hp c1366Hp = this.A0P;
                String[] strArr4 = A0q;
                if (strArr4[0].charAt(31) == strArr4[2].charAt(31)) {
                    throw new RuntimeException();
                }
                String[] strArr5 = A0q;
                strArr5[3] = "PHYzuIxoVCpcvyGp46FNV8";
                strArr5[4] = "jONBlxc6dKLj6ao";
                c1366Hp.A04(j11);
                this.A0Z = true;
                return;
            case 251:
                this.A0W = true;
                return;
            case 16980:
                if (j11 != 3) {
                    throw new C11849v(A03(296, 16, 108) + j11 + strA03);
                }
                return;
            case 17029:
                if (j11 < 1 || j11 > 2) {
                    throw new C11849v(A03(377, 19, 14) + j11 + strA03);
                }
                return;
            case 17143:
                if (j11 != 1) {
                    throw new C11849v(A03(433, 16, 96) + j11 + strA03);
                }
                return;
            case 18401:
                if (j11 != 5) {
                    throw new C11849v(A03(312, 15, 66) + j11 + strA03);
                }
                return;
            case 18408:
                if (j11 != 1) {
                    throw new C11849v(A03(52, 22, 72) + j11 + strA03);
                }
                return;
            case 20529:
                if (j11 != 0) {
                    throw new C11849v(A03(327, 21, 88) + j11 + strA03);
                }
                return;
            case 20530:
                if (j11 != 1) {
                    throw new C11849v(A03(348, 21, 41) + j11 + strA03);
                }
                return;
            case 21420:
                this.A0I = this.A0K + j11;
                return;
            case 21432:
                switch ((int) j11) {
                    case 0:
                        this.A0O.A0P = 0;
                        return;
                    case 1:
                        this.A0O.A0P = 2;
                        return;
                    case 3:
                        this.A0O.A0P = 1;
                        return;
                    case 15:
                        this.A0O.A0P = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                this.A0O.A0I = (int) j11;
                return;
            case 21682:
                this.A0O.A0H = (int) j11;
                return;
            case 21690:
                this.A0O.A0G = (int) j11;
                return;
            case 21930:
                CE ce3 = this.A0O;
                if (A0q[7].charAt(2) != 'J') {
                    A0q[7] = "jzNtO6nbghsOK2zNzcbiuAHR0hMudXvD";
                    ce3.A0a = j11 == 1;
                    return;
                }
                break;
            case 21945:
                switch ((int) j11) {
                    case 1:
                        this.A0O.A0C = 2;
                        return;
                    case 2:
                        this.A0O.A0C = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                switch ((int) j11) {
                    case 1:
                    case 6:
                    case 7:
                        CE ce4 = this.A0O;
                        String[] strArr6 = A0q;
                        if (strArr6[3].length() != strArr6[4].length()) {
                            A0q[7] = "mV5wi4RdAtLICzfql5r9CviPSqv5gEzL";
                            ce4.A0E = 3;
                            return;
                        }
                        break;
                    case 16:
                        this.A0O.A0E = 6;
                        return;
                    case 18:
                        this.A0O.A0E = 7;
                        return;
                    default:
                        return;
                }
                break;
            case 21947:
                this.A0O.A0b = true;
                switch ((int) j11) {
                    case 1:
                        this.A0O.A0D = 1;
                        return;
                    case 2:
                    case 3:
                    case 8:
                    default:
                        return;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        CE ce5 = this.A0O;
                        if (A0q[6].length() == 27) {
                            String[] strArr7 = A0q;
                            strArr7[0] = "a0uWSiKj3FE77SqtP8skZXqIoOHsVkha";
                            strArr7[2] = "zxuZMYlEoYkqiqBcXObqrQLJbRKLzsvV";
                            ce5.A0D = 2;
                            return;
                        }
                        break;
                    case 9:
                        this.A0O.A0D = 6;
                        return;
                }
                break;
            case 21948:
                this.A0O.A0K = (int) j11;
                return;
            case 21949:
                CE ce6 = this.A0O;
                int i12 = (int) j11;
                if (A0q[6].length() == 27) {
                    A0q[7] = "cRzVQdX7r3sNL6uNWZqYIbMTncmWUqDN";
                    ce6.A0L = i12;
                    return;
                }
                break;
            case 22186:
                this.A0O.A0S = j11;
                return;
            case 22203:
                this.A0O.A0T = j11;
                return;
            case 25188:
                this.A0O.A0A = (int) j11;
                return;
            case 2352003:
                this.A0O.A0F = (int) j11;
                return;
            case 2807729:
                this.A0M = j11;
                return;
            default:
                return;
        }
        throw new RuntimeException();
    }

    public final void A0M(int i11, long j11, long j12) throws C11849v {
        switch (i11) {
            case 160:
                this.A0W = false;
                return;
            case 174:
                this.A0O = new CE(null);
                return;
            case 187:
                this.A0Z = false;
                return;
            case 19899:
                this.A0B = -1;
                this.A0I = -1L;
                return;
            case 20533:
                this.A0O.A0c = true;
                return;
            case 21968:
                this.A0O.A0b = true;
                return;
            case 25152:
            default:
                return;
            case 408125543:
                long j13 = this.A0K;
                if (j13 != -1 && j13 != j11) {
                    throw new C11849v(A03(717, 39, 113));
                }
                this.A0K = j11;
                this.A0L = j12;
                return;
            case 475249515:
                this.A0Q = new C1366Hp();
                this.A0P = new C1366Hp();
                return;
            case 524531317:
                if (this.A0a) {
                    return;
                }
                if (this.A0o && this.A0F != -1) {
                    this.A0Y = true;
                    return;
                } else {
                    this.A0N.AFi(new C1765Xj(this.A0H));
                    this.A0a = true;
                    return;
                }
        }
    }

    public final void A0N(int i11, String str) throws C11849v {
        switch (i11) {
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
                this.A0O.A0Y = str;
                return;
            case 17026:
                if (!A03(1034, 4, 113).equals(str) && !A03(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, 8, 122).equals(str)) {
                    throw new C11849v(A03(369, 8, 117) + str + A03(0, 14, 21));
                }
                return;
            case 2274716:
                this.A0O.A0g = str;
                return;
            default:
                return;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void A8o(InterfaceC1235Bu interfaceC1235Bu) {
        this.A0N = interfaceC1235Bu;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final int AEH(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        this.A0V = false;
        boolean zAEJ = true;
        while (zAEJ && !this.A0V) {
            zAEJ = this.A0d.AEJ(interfaceC1234Bt);
            if (zAEJ && A0E(c1238Bz, interfaceC1234Bt.A7i())) {
                return 1;
            }
        }
        if (zAEJ) {
            return 0;
        }
        int i11 = 0;
        while (true) {
            SparseArray<CE> sparseArray = this.A0c;
            String[] strArr = A0q;
            if (strArr[0].charAt(31) == strArr[2].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0q;
            strArr2[3] = "Tajypdz7aNAm7FibYO8x24";
            strArr2[4] = "TBunjD0UUDKaUo7";
            if (i11 >= sparseArray.size()) {
                return -1;
            }
            this.A0c.valueAt(i11).A07();
            i11++;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void AFh(long j11, long j12) {
        this.A0E = C.TIME_UNSET;
        this.A04 = 0;
        this.A0d.reset();
        this.A0e.A06();
        A05();
        for (int i11 = 0; i11 < this.A0c.size(); i11++) {
            this.A0c.valueAt(i11).A08();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final boolean AGR(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        return new CG().A01(interfaceC1234Bt);
    }
}
