package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.transsion.gslb.Worker;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XN implements InterfaceC1233Bs {
    public static byte[] A0X;
    public static String[] A0Y = {"XdJWu", "FUlE3E4RGCFuY0n1jkLa4sDNStY", "LTfWg4MeBgD", "ea2mTe", "5aN4xnjUR54", "JRDUjTwIRED0cdRjG5ryaKaac6vLzQ8c", "s80pf3iUB", "VFz"};
    public static final InterfaceC1236Bv A0Z;
    public static final int A0a;
    public static final Format A0b;
    public static final byte[] A0c;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public InterfaceC1235Bu A0C;
    public CV A0D;
    public C1376Hz A0E;
    public boolean A0F;
    public boolean A0G;
    public C4[] A0H;
    public C4[] A0I;
    public final int A0J;
    public final SparseArray<CV> A0K;
    public final DrmInitData A0L;
    public final C4 A0M;
    public final C1242Ce A0N;
    public final C1376Hz A0O;
    public final C1376Hz A0P;
    public final C1376Hz A0Q;
    public final C1376Hz A0R;
    public final IB A0S;
    public final ArrayDeque<XT> A0T;
    public final ArrayDeque<CU> A0U;
    public final List<Format> A0V;
    public final byte[] A0W;

    static {
        A0D();
        A0Z = new XO();
        A0a = IF.A08(A0A(682, 4, 23));
        A0c = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        A0b = Format.A02(null, A0A(664, 18, 25), Long.MAX_VALUE);
    }

    public XN() {
        this(0);
    }

    public XN(int i11) {
        this(i11, null);
    }

    public XN(int i11, IB ib2) {
        this(i11, ib2, null, null);
    }

    public XN(int i11, IB ib2, C1242Ce c1242Ce, DrmInitData drmInitData) {
        this(i11, ib2, c1242Ce, drmInitData, Collections.emptyList());
    }

    public XN(int i11, IB ib2, C1242Ce c1242Ce, DrmInitData drmInitData, List<Format> list) {
        this(i11, ib2, c1242Ce, drmInitData, list, null);
    }

    public XN(int i11, IB ib2, C1242Ce c1242Ce, DrmInitData drmInitData, List<Format> list, C4 c11) {
        this.A0J = (c1242Ce != null ? 8 : 0) | i11;
        this.A0S = ib2;
        this.A0N = c1242Ce;
        this.A0L = drmInitData;
        this.A0V = Collections.unmodifiableList(list);
        this.A0M = c11;
        this.A0O = new C1376Hz(16);
        this.A0R = new C1376Hz(AbstractC1372Hv.A03);
        this.A0Q = new C1376Hz(5);
        this.A0P = new C1376Hz();
        this.A0W = new byte[16];
        this.A0T = new ArrayDeque<>();
        this.A0U = new ArrayDeque<>();
        this.A0K = new SparseArray<>();
        this.A08 = C.TIME_UNSET;
        this.A0A = C.TIME_UNSET;
        this.A0B = C.TIME_UNSET;
        A0B();
    }

    public static int A00(CV cv2, int i11, long j11, int i12, C1376Hz c1376Hz, int i13) {
        int iA0H;
        int iA08;
        int i14 = i13;
        long j12 = j11;
        c1376Hz.A0Y(8);
        int iA00 = CJ.A00(c1376Hz.A08());
        C1242Ce c1242Ce = cv2.A05;
        C1244Cg c1244Cg = cv2.A07;
        CP cp2 = c1244Cg.A07;
        c1244Cg.A0E[i11] = c1376Hz.A0H();
        c1244Cg.A0G[i11] = c1244Cg.A05;
        if ((iA00 & 1) != 0) {
            long[] jArr = c1244Cg.A0G;
            jArr[i11] = jArr[i11] + ((long) c1376Hz.A08());
        }
        boolean z11 = (iA00 & 4) != 0;
        int iA0H2 = cp2.A01;
        if (z11) {
            iA0H2 = c1376Hz.A0H();
        }
        boolean z12 = (iA00 & 256) != 0;
        boolean z13 = (iA00 & 512) != 0;
        boolean z14 = (iA00 & 1024) != 0;
        boolean z15 = (iA00 & 2048) != 0;
        long jA0F = 0;
        if (c1242Ce.A08 != null && c1242Ce.A08.length == 1 && c1242Ce.A08[0] == 0) {
            jA0F = IF.A0F(c1242Ce.A09[0], 1000L, c1242Ce.A06);
        }
        int[] iArr = c1244Cg.A0D;
        int[] iArr2 = c1244Cg.A0C;
        long[] jArr2 = c1244Cg.A0F;
        boolean[] zArr = c1244Cg.A0I;
        boolean z16 = c1242Ce.A03 == 2 && (i12 & 1) != 0;
        int i15 = i14 + c1244Cg.A0E[i11];
        long j13 = c1242Ce.A06;
        if (i11 > 0) {
            j12 = c1244Cg.A06;
        }
        while (i14 < i15) {
            int iA0H3 = z12 ? c1376Hz.A0H() : cp2.A00;
            if (z13) {
                iA0H = c1376Hz.A0H();
            } else {
                iA0H = cp2.A03;
                if (A0Y[5].charAt(2) == 'C') {
                    throw new RuntimeException();
                }
                A0Y[6] = "dkwnFPd0";
            }
            if (i14 == 0 && z11) {
                iA08 = iA0H2;
            } else {
                iA08 = z14 ? c1376Hz.A08() : cp2.A01;
            }
            if (z15) {
                iArr2[i14] = (int) ((((long) c1376Hz.A08()) * 1000) / j13);
            } else {
                iArr2[i14] = 0;
            }
            jArr2[i14] = IF.A0F(j12, 1000L, j13) - jA0F;
            iArr[i14] = iA0H;
            zArr[i14] = ((iA08 >> 16) & 1) == 0 && (!z16 || i14 == 0);
            j12 += (long) iA0H3;
            i14++;
        }
        c1244Cg.A06 = j12;
        return i15;
    }

    public static long A01(C1376Hz c1376Hz) {
        c1376Hz.A0Y(8);
        return CJ.A01(c1376Hz.A08()) == 0 ? c1376Hz.A0M() : c1376Hz.A0N();
    }

    public static long A02(C1376Hz c1376Hz) {
        c1376Hz.A0Y(8);
        return CJ.A01(c1376Hz.A08()) == 1 ? c1376Hz.A0N() : c1376Hz.A0M();
    }

    public static Pair<Integer, CP> A03(C1376Hz c1376Hz) {
        c1376Hz.A0Y(12);
        return Pair.create(Integer.valueOf(c1376Hz.A08()), new CP(c1376Hz.A0H() - 1, c1376Hz.A0H(), c1376Hz.A0H(), c1376Hz.A08()));
    }

    public static Pair<Long, C1770Xo> A04(C1376Hz c1376Hz, long j11) throws C11849v {
        long jA0N;
        long jA0N2;
        c1376Hz.A0Y(8);
        int iA01 = CJ.A01(c1376Hz.A08());
        c1376Hz.A0Z(4);
        long jA0M = c1376Hz.A0M();
        if (iA01 == 0) {
            jA0N = c1376Hz.A0M();
            jA0N2 = j11 + c1376Hz.A0M();
        } else {
            jA0N = c1376Hz.A0N();
            jA0N2 = j11 + c1376Hz.A0N();
        }
        long jA0F = IF.A0F(jA0N, 1000000L, jA0M);
        c1376Hz.A0Z(2);
        int iA0I = c1376Hz.A0I();
        int[] iArr = new int[iA0I];
        long[] jArr = new long[iA0I];
        long[] jArr2 = new long[iA0I];
        long[] jArr3 = new long[iA0I];
        long jA0F2 = jA0F;
        for (int i11 = 0; i11 < iA0I; i11++) {
            int iA08 = c1376Hz.A08();
            if ((Integer.MIN_VALUE & iA08) != 0) {
                throw new C11849v(A0A(581, 28, WebSocketProtocol.PAYLOAD_SHORT));
            }
            long jA0M2 = c1376Hz.A0M();
            iArr[i11] = Integer.MAX_VALUE & iA08;
            jArr[i11] = jA0N2;
            jArr3[i11] = jA0F2;
            jA0N += jA0M2;
            jA0F2 = IF.A0F(jA0N, 1000000L, jA0M);
            jArr2[i11] = jA0F2 - jArr3[i11];
            c1376Hz.A0Z(4);
            jA0N2 += (long) iArr[i11];
        }
        return Pair.create(Long.valueOf(jA0F), new C1770Xo(iArr, jArr, jArr2, jArr3));
    }

    public static DrmInitData A05(List<XS> list) {
        ArrayList arrayList = null;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            XS xs2 = list.get(i11);
            if (((CJ) xs2).A00 == CJ.A0s) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = xs2.A00.A00;
                UUID uuidA02 = AbstractC1240Cb.A02(bArr);
                if (A0Y[3].length() != 6) {
                    throw new RuntimeException();
                }
                A0Y[7] = "tzO";
                if (uuidA02 == null) {
                    Log.w(A0A(128, 22, 24), A0A(437, 42, 58));
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidA02, A0A(696, 9, 23), bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private CP A06(SparseArray<CP> sparseArray, int i11) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : (CP) AbstractC1351Ha.A01(sparseArray.get(i11));
    }

    public static CV A07(SparseArray<CV> sparseArray) {
        CV cv2 = null;
        long j11 = Long.MAX_VALUE;
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            CV cvValueAt = sparseArray.valueAt(i11);
            int i12 = cvValueAt.A02;
            if (A0Y[1].length() == 5) {
                throw new RuntimeException();
            }
            A0Y[0] = "VXm0n";
            if (i12 != cvValueAt.A07.A02) {
                long j12 = cvValueAt.A07.A0G[cvValueAt.A02];
                if (j12 < j11) {
                    cv2 = cvValueAt;
                    j11 = j12;
                }
            }
        }
        return cv2;
    }

    public static CV A08(SparseArray<CV> sparseArray, int i11) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : sparseArray.get(i11);
    }

    public static CV A09(C1376Hz c1376Hz, SparseArray<CV> sparseArray) {
        c1376Hz.A0Y(8);
        int iA00 = CJ.A00(c1376Hz.A08());
        CV cvA08 = A08(sparseArray, c1376Hz.A08());
        if (cvA08 == null) {
            return null;
        }
        if ((iA00 & 1) != 0) {
            long jA0N = c1376Hz.A0N();
            cvA08.A07.A05 = jA0N;
            cvA08.A07.A04 = jA0N;
        }
        CP cp2 = cvA08.A04;
        cvA08.A07.A07 = new CP((iA00 & 2) != 0 ? c1376Hz.A0H() - 1 : cp2.A02, (iA00 & 8) != 0 ? c1376Hz.A0H() : cp2.A00, (iA00 & 16) != 0 ? c1376Hz.A0H() : cp2.A03, (iA00 & 32) != 0 ? c1376Hz.A0H() : cp2.A01);
        return cvA08;
    }

    public static String A0A(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0X, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ Worker.WHAT_SYNC_DATA);
        }
        return new String(bArrCopyOfRange);
    }

    private void A0B() {
        this.A02 = 0;
        this.A00 = 0;
    }

    private void A0C() {
        if (this.A0I == null) {
            C4[] c4Arr = new C4[2];
            this.A0I = c4Arr;
            int i11 = 0;
            C4 c11 = this.A0M;
            if (c11 != null) {
                c4Arr[0] = c11;
                i11 = 0 + 1;
            }
            if ((this.A0J & 4) != 0) {
                c4Arr[i11] = this.A0C.AGi(this.A0K.size(), 4);
                i11++;
            }
            C4[] c4Arr2 = (C4[]) Arrays.copyOf(this.A0I, i11);
            this.A0I = c4Arr2;
            for (C4 c12 : c4Arr2) {
                c12.A5n(A0b);
            }
        }
        C4[] c4Arr3 = this.A0H;
        if (A0Y[6].length() == 17) {
            throw new RuntimeException();
        }
        A0Y[3] = "8HQd7O";
        if (c4Arr3 == null) {
            this.A0H = new C4[this.A0V.size()];
            for (int i12 = 0; i12 < this.A0H.length; i12++) {
                C4 c4AGi = this.A0C.AGi(this.A0K.size() + 1 + i12, 3);
                c4AGi.A5n(this.A0V.get(i12));
                this.A0H[i12] = c4AGi;
            }
        }
    }

    public static void A0D() {
        A0X = new byte[]{117, 121, 84, 97, 122, 120, 53, 102, 124, 111, 112, 53, 121, 112, 102, 102, 53, 97, 125, 116, 123, 53, 125, 112, 116, 113, 112, 103, 53, 121, 112, 123, 114, 97, 125, 53, 61, 96, 123, 102, 96, 101, 101, 122, 103, 97, 112, 113, 60, 59, 114, 89, 67, 69, 78, Ascii.ETB, 84, 88, 66, 89, 67, Ascii.ETB, 94, 89, Ascii.ETB, 68, 85, 80, 71, Ascii.ETB, Ascii.SYN, 10, Ascii.ETB, 6, Ascii.ETB, Ascii.US, 66, 89, 68, 66, 71, 71, 88, 69, 67, 82, 83, Ascii.RS, Ascii.EM, 119, 92, 70, 64, 75, Ascii.DC2, 81, 93, 71, 92, 70, Ascii.DC2, 91, 92, Ascii.DC2, 65, 85, 66, 86, Ascii.DC2, 19, Ascii.SI, Ascii.DC2, 3, Ascii.DC2, Ascii.SUB, 71, 92, 65, 71, 66, 66, 93, 64, 70, 87, 86, Ascii.ESC, Ascii.FS, 57, Ascii.CR, Ascii.RS, Ascii.CAN, Ascii.DC2, Ascii.SUB, 17, Ascii.VT, Ascii.SUB, Ascii.ESC, 50, Ascii.SI, 75, 58, 7, Ascii.VT, Ascii.CR, Ascii.RS, Ascii.FS, Ascii.VT, Ascii.DLE, Ascii.CR, 0, 46, 39, 38, 59, 32, 39, 46, 105, 39, 44, 46, 40, 61, 32, Utf8.REPLACEMENT_BYTE, 44, 105, 38, 47, 47, 58, 44, 61, 105, 61, 38, 105, 58, 40, 36, 57, 37, 44, 105, 45, 40, 61, 40, 103, 51, Ascii.SUB, Ascii.RS, Ascii.EM, 95, Ascii.RS, Ascii.VT, Ascii.DLE, Ascii.DC2, 95, Ascii.ESC, Ascii.SUB, Ascii.EM, Ascii.SYN, 17, Ascii.SUB, Ascii.FF, 95, Ascii.SUB, 7, Ascii.VT, Ascii.SUB, 17, Ascii.ESC, Ascii.SUB, Ascii.ESC, 95, Ascii.RS, Ascii.VT, Ascii.DLE, Ascii.DC2, 95, Ascii.FF, Ascii.SYN, 5, Ascii.SUB, 95, 87, 10, 17, Ascii.FF, 10, Ascii.SI, Ascii.SI, Ascii.DLE, Ascii.CR, Ascii.VT, Ascii.SUB, Ascii.ESC, 86, 81, Ascii.RS, 55, 51, 52, 114, 51, 38, 61, Utf8.REPLACEMENT_BYTE, 114, 37, 59, 38, 58, 114, 62, 55, 60, 53, 38, 58, 114, 108, 114, 96, 99, 102, 101, 102, 106, 97, 100, 102, 101, 114, 122, 39, 60, 33, 39, 34, 34, 61, 32, 38, 55, 54, 123, 124, Utf8.REPLACEMENT_BYTE, Ascii.SYN, Ascii.GS, Ascii.DC4, 7, Ascii.ESC, 83, Ascii.RS, Ascii.SUB, 0, Ascii.RS, Ascii.DC2, 7, Ascii.DLE, Ascii.ESC, 73, 83, Ascii.SI, 38, 38, 51, 37, 52, 96, 52, 47, 96, 37, 46, 35, 50, 57, 48, 52, 41, 47, 46, 96, 36, 33, 52, 33, 96, 55, 33, 51, 96, 46, 37, 39, 33, 52, 41, 54, 37, 110, Ascii.DLE, 57, 57, 44, 58, 43, Ascii.DEL, 43, 48, Ascii.DEL, 58, 49, 59, Ascii.DEL, 48, 57, Ascii.DEL, 50, 59, 62, 43, Ascii.DEL, 40, 62, 44, Ascii.DEL, 49, 58, 56, 62, 43, 54, 41, 58, 113, 106, 83, 64, 87, 87, 76, 65, 76, 75, 66, 5, 113, 87, 68, 70, 78, 96, 75, 70, 87, 92, 85, 81, 76, 74, 75, 103, 74, 93, 5, 85, 68, 87, 68, 72, 64, 81, 64, 87, 86, 5, 76, 86, 5, 80, 75, 86, 80, 85, 85, 74, 87, 81, 64, 65, Ascii.VT, Ascii.SO, 54, 52, 45, 45, 56, 57, 125, 45, 46, 46, 53, 125, 60, 41, 50, 48, 125, 117, 59, 60, 52, 49, 56, 57, 125, 41, 50, 125, 56, 37, 41, 47, 60, 62, 41, 125, 40, 40, 52, 57, 116, 54, Ascii.SO, Ascii.FF, Ascii.NAK, Ascii.NAK, Ascii.FF, Ascii.VT, 2, 69, 4, 17, 10, 8, 69, Ascii.DC2, Ascii.FF, 17, Ascii.CR, 69, 9, 0, Ascii.VT, 2, 17, Ascii.CR, 69, 91, 69, 87, 84, 81, 82, 81, 93, 86, 83, 81, 82, 69, 77, Ascii.DLE, Ascii.VT, Ascii.SYN, Ascii.DLE, Ascii.NAK, Ascii.NAK, 10, Ascii.ETB, 17, 0, 1, 76, 75, 62, 5, Ascii.SO, 19, Ascii.ESC, Ascii.SO, 8, Ascii.US, Ascii.SO, Ascii.SI, 75, 6, 4, 4, Ascii.GS, 75, 9, 4, 19, 69, Ascii.CR, 54, 61, 32, 40, 61, 59, 44, 61, 60, 120, 43, 57, 49, 55, 120, 61, 54, 44, 42, 33, 120, 59, 55, 45, 54, 44, 98, 120, 76, 119, 113, 120, 119, 125, 117, 124, 125, 57, 112, 119, 125, 112, 107, 124, 122, 109, 57, 107, 124, Ascii.DEL, 124, 107, 124, 119, 122, 124, 58, Ascii.CR, Ascii.RS, 5, Ascii.CR, Ascii.SO, 0, 9, 76, 0, 9, 2, Ascii.VT, Ascii.CAN, 4, 76, 8, 9, Ascii.US, Ascii.SI, Ascii.RS, 5, Ascii.FS, Ascii.CAN, 5, 3, 2, 76, 5, 2, 76, Ascii.US, Ascii.VT, Ascii.FS, 8, 76, 10, 3, Ascii.EM, 2, 8, 76, 68, Ascii.EM, 2, Ascii.US, Ascii.EM, Ascii.FS, Ascii.FS, 3, Ascii.RS, Ascii.CAN, 9, 8, 69, Ascii.US, Ascii.SO, Ascii.SO, Ascii.DC2, Ascii.ETB, Ascii.GS, Ascii.US, 10, Ascii.ETB, 17, Ascii.DLE, 81, 6, 83, Ascii.ESC, 19, Ascii.CR, Ascii.EM, 3, Ascii.NAK, Ascii.EM, Ascii.ETB, Ascii.ETB, 8, 5, 4, Ascii.SO, 78, 9, 4, Ascii.ETB, 2, 6, Ascii.EM, Ascii.DC4, Ascii.NAK, Ascii.US, 95, Ascii.GS, 0, 68};
    }

    private void A0E(long j11) {
        while (!this.A0U.isEmpty()) {
            CU cuRemoveFirst = this.A0U.removeFirst();
            this.A03 -= cuRemoveFirst.A00;
            long jA06 = j11 + cuRemoveFirst.A01;
            IB ib2 = this.A0S;
            if (ib2 != null) {
                jA06 = ib2.A06(jA06);
            }
            C4[] c4Arr = this.A0I;
            if (A0Y[7].length() != 3) {
                throw new RuntimeException();
            }
            A0Y[7] = "ltl";
            for (C4 c11 : c4Arr) {
                c11.AFS(jA06, 1, cuRemoveFirst.A00, this.A03, null);
            }
        }
    }

    private void A0F(long j11) throws C11849v {
        while (!this.A0T.isEmpty() && this.A0T.peek().A00 == j11) {
            A0I(this.A0T.pop());
        }
        A0B();
    }

    private void A0G(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        int i11 = ((int) this.A07) - this.A00;
        C1376Hz c1376Hz = this.A0E;
        if (c1376Hz != null) {
            interfaceC1234Bt.readFully(c1376Hz.A00, 8, i11);
            A0O(new XS(this.A01, this.A0E), interfaceC1234Bt.A7i());
        } else {
            interfaceC1234Bt.AGP(i11);
        }
        A0F(interfaceC1234Bt.A7i());
        String[] strArr = A0Y;
        if (strArr[2].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        A0Y[1] = "jmSEpbOdW733bHBoDHkBty1cmj";
    }

    private void A0H(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        CV cvValueAt = null;
        long j11 = Long.MAX_VALUE;
        int size = this.A0K.size();
        for (int i11 = 0; i11 < size; i11++) {
            C1244Cg c1244Cg = this.A0K.valueAt(i11).A07;
            if (c1244Cg.A0B && c1244Cg.A04 < j11) {
                j11 = c1244Cg.A04;
                cvValueAt = this.A0K.valueAt(i11);
            }
        }
        if (cvValueAt == null) {
            this.A02 = 3;
            return;
        }
        int iA7i = (int) (j11 - interfaceC1234Bt.A7i());
        if (iA7i < 0) {
            throw new C11849v(A0A(307, 39, 39));
        }
        interfaceC1234Bt.AGP(iA7i);
        cvValueAt.A07.A04(interfaceC1234Bt);
    }

    private void A0I(XT xt2) throws C11849v {
        if (((CJ) xt2).A00 == CJ.A0k) {
            A0K(xt2);
            return;
        }
        int i11 = ((CJ) xt2).A00;
        int i12 = CJ.A0j;
        String[] strArr = A0Y;
        if (strArr[2].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        A0Y[6] = "QeKmRdkmErMZReeQj8";
        if (i11 == i12) {
            A0J(xt2);
            return;
        }
        if (this.A0T.isEmpty()) {
            return;
        }
        XT xtPeek = this.A0T.peek();
        if (A0Y[6].length() != 17) {
            A0Y[1] = "g8UpS1NyodMZ5eBXtPatKQwsoR";
            xtPeek.A08(xt2);
        } else {
            A0Y[5] = "mkv5is6F5Mu6y6USr0b4mkDGodGLaqlp";
            xtPeek.A08(xt2);
        }
    }

    private void A0J(XT xt2) throws C11849v {
        DrmInitData drmInitDataA05;
        A0L(xt2, this.A0K, this.A0J, this.A0W);
        if (this.A0L != null) {
            drmInitDataA05 = null;
        } else {
            List<XS> list = xt2.A02;
            if (A0Y[3].length() != 6) {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[2] = "YTpzURZBrt0";
            strArr[4] = "jDJUPBNch9x";
            drmInitDataA05 = A05(list);
        }
        if (drmInitDataA05 != null) {
            int size = this.A0K.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.A0K.valueAt(i11).A06(drmInitDataA05);
            }
        }
        if (this.A0A != C.TIME_UNSET) {
            int size2 = this.A0K.size();
            for (int i12 = 0; i12 < size2; i12++) {
                this.A0K.valueAt(i12).A05(this.A0A);
            }
            this.A0A = C.TIME_UNSET;
        }
    }

    private void A0K(XT xt2) throws C11849v {
        AbstractC1351Ha.A06(this.A0N == null, A0A(532, 20, 12));
        DrmInitData drmInitDataA05 = this.A0L;
        if (drmInitDataA05 == null) {
            drmInitDataA05 = A05(xt2.A02);
        }
        XT xtA06 = xt2.A06(CJ.A0n);
        SparseArray<CP> sparseArray = new SparseArray<>();
        long jA01 = C.TIME_UNSET;
        int size = xtA06.A02.size();
        for (int i11 = 0; i11 < size; i11++) {
            XS xs2 = xtA06.A02.get(i11);
            if (((CJ) xs2).A00 == CJ.A1N) {
                Pair<Integer, CP> pairA03 = A03(xs2.A00);
                sparseArray.put(((Integer) pairA03.first).intValue(), (CP) pairA03.second);
            } else if (((CJ) xs2).A00 == CJ.A0g) {
                jA01 = A01(xs2.A00);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = xt2.A01.size();
        for (int i12 = 0; i12 < size2; i12++) {
            XT xt3 = xt2.A01.get(i12);
            if (((CJ) xt3).A00 == CJ.A1M) {
                C1242Ce c1242CeA0C = CO.A0C(xt3, xt2.A07(CJ.A0o), jA01, drmInitDataA05, (this.A0J & 16) != 0, false);
                if (c1242CeA0C != null) {
                    sparseArray2.put(c1242CeA0C.A00, c1242CeA0C);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.A0K.size() != 0) {
            AbstractC1351Ha.A04(this.A0K.size() == size3);
            for (int i13 = 0; i13 < size3; i13++) {
                C1242Ce c1242Ce = (C1242Ce) sparseArray2.valueAt(i13);
                this.A0K.get(c1242Ce.A00).A07(c1242Ce, A06(sparseArray, c1242Ce.A00));
            }
            return;
        }
        for (int i14 = 0; i14 < size3; i14++) {
            C1242Ce c1242Ce2 = (C1242Ce) sparseArray2.valueAt(i14);
            CV cv2 = new CV(this.A0C.AGi(i14, c1242Ce2.A03));
            cv2.A07(c1242Ce2, A06(sparseArray, c1242Ce2.A00));
            this.A0K.put(c1242Ce2.A00, cv2);
            this.A08 = Math.max(this.A08, c1242Ce2.A04);
        }
        A0C();
        this.A0C.A5Y();
    }

    public static void A0L(XT xt2, SparseArray<CV> sparseArray, int i11, byte[] bArr) throws C11849v {
        int size = xt2.A01.size();
        for (int i12 = 0; i12 < size; i12++) {
            XT xt3 = xt2.A01.get(i12);
            if (((CJ) xt3).A00 == CJ.A1L) {
                A0M(xt3, sparseArray, i11, bArr);
            }
        }
    }

    public static void A0M(XT xt2, SparseArray<CV> sparseArray, int i11, byte[] bArr) throws C11849v {
        CV cvA09 = A09(xt2.A07(CJ.A1J).A00, sparseArray);
        if (cvA09 == null) {
            return;
        }
        C1244Cg c1244Cg = cvA09.A07;
        long jA02 = c1244Cg.A06;
        cvA09.A04();
        if (xt2.A07(CJ.A1I) != null && (i11 & 2) == 0) {
            jA02 = A02(xt2.A07(CJ.A1I).A00);
        }
        A0N(xt2, cvA09, jA02, i11);
        C1243Cf c1243CfA00 = cvA09.A05.A00(c1244Cg.A07.A02);
        XS xsA07 = xt2.A07(CJ.A0v);
        if (xsA07 != null) {
            A0P(c1243CfA00, xsA07.A00, c1244Cg);
        }
        XS xsA08 = xt2.A07(CJ.A0u);
        if (xsA08 != null) {
            A0S(xsA08.A00, c1244Cg);
        }
        XS xsA09 = xt2.A07(CJ.A11);
        if (xsA09 != null) {
            A0T(xsA09.A00, c1244Cg);
        }
        XS xsA010 = xt2.A07(CJ.A0y);
        XS xsA011 = xt2.A07(CJ.A12);
        if (xsA010 != null && xsA011 != null) {
            A0V(xsA010.A00, xsA011.A00, c1243CfA00 != null ? c1243CfA00.A02 : null, c1244Cg);
        }
        int size = xt2.A02.size();
        for (int i12 = 0; i12 < size; i12++) {
            XS xs2 = xt2.A02.get(i12);
            if (A0Y[7].length() != 3) {
                throw new RuntimeException();
            }
            A0Y[7] = "89j";
            XS xs3 = xs2;
            if (((CJ) xs3).A00 == CJ.A1R) {
                A0U(xs3.A00, c1244Cg, bArr);
            }
        }
    }

    public static void A0N(XT xt2, CV cv2, long j11, int i11) {
        int i12 = 0;
        int i13 = 0;
        List<XS> list = xt2.A02;
        int size = list.size();
        for (int i14 = 0; i14 < size; i14++) {
            XS xs2 = list.get(i14);
            if (((CJ) xs2).A00 == CJ.A1O) {
                C1376Hz c1376Hz = xs2.A00;
                c1376Hz.A0Y(12);
                int iA0H = c1376Hz.A0H();
                if (iA0H > 0) {
                    i13 += iA0H;
                    i12++;
                }
            }
        }
        cv2.A02 = 0;
        cv2.A00 = 0;
        cv2.A01 = 0;
        cv2.A07.A03(i12, i13);
        int i15 = 0;
        int iA00 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            XS xs3 = list.get(i16);
            if (((CJ) xs3).A00 == CJ.A1O) {
                iA00 = A00(cv2, i15, j11, i11, xs3.A00, iA00);
                i15++;
            }
        }
    }

    private void A0O(XS xs2, long j11) throws C11849v {
        if (!this.A0T.isEmpty()) {
            this.A0T.peek().A09(xs2);
            return;
        }
        if (((CJ) xs2).A00 != CJ.A13) {
            if (((CJ) xs2).A00 == CJ.A0Q) {
                A0Q(xs2.A00);
            }
        } else {
            Pair<Long, C1770Xo> pairA04 = A04(xs2.A00, j11);
            this.A0B = ((Long) pairA04.first).longValue();
            this.A0C.AFi((C1) pairA04.second);
            this.A0F = true;
        }
    }

    public static void A0P(C1243Cf c1243Cf, C1376Hz c1376Hz, C1244Cg c1244Cg) throws C11849v {
        int i11 = c1243Cf.A00;
        c1376Hz.A0Y(8);
        if ((CJ.A00(c1376Hz.A08()) & 1) == 1) {
            c1376Hz.A0Z(8);
        }
        int iA0E = c1376Hz.A0E();
        int iA0H = c1376Hz.A0H();
        if (iA0H != c1244Cg.A00) {
            throw new C11849v(A0A(290, 17, 20) + iA0H + A0A(0, 2, 62) + c1244Cg.A00);
        }
        int i12 = 0;
        if (iA0E == 0) {
            boolean[] zArr = c1244Cg.A0H;
            for (int i13 = 0; i13 < iA0H; i13++) {
                int iA0E2 = c1376Hz.A0E();
                i12 += iA0E2;
                zArr[i13] = iA0E2 > i11;
            }
        } else {
            i12 = 0 + (iA0E * iA0H);
            Arrays.fill(c1244Cg.A0H, 0, iA0H, iA0E > i11);
        }
        c1244Cg.A02(i12);
        if (A0Y[6].length() == 17) {
            throw new RuntimeException();
        }
        String[] strArr = A0Y;
        strArr[2] = "tC3WLCXP6DZ";
        strArr[4] = "0Zxl8CEli3D";
    }

    private void A0Q(C1376Hz c1376Hz) {
        C4[] c4Arr = this.A0I;
        if (c4Arr == null || c4Arr.length == 0) {
            return;
        }
        c1376Hz.A0Y(12);
        int iA04 = c1376Hz.A04();
        c1376Hz.A0Q();
        c1376Hz.A0Q();
        long jA0F = IF.A0F(c1376Hz.A0M(), 1000000L, c1376Hz.A0M());
        for (C4 c11 : this.A0I) {
            c1376Hz.A0Y(12);
            c11.AFR(c1376Hz, iA04);
        }
        long j11 = this.A0B;
        if (j11 == C.TIME_UNSET) {
            this.A0U.addLast(new CU(jA0F, iA04));
            this.A03 += iA04;
            return;
        }
        long jA06 = j11 + jA0F;
        IB ib2 = this.A0S;
        if (ib2 != null) {
            jA06 = ib2.A06(jA06);
        }
        for (C4 c12 : this.A0I) {
            c12.AFS(jA06, 1, iA04, 0, null);
        }
    }

    public static void A0R(C1376Hz c1376Hz, int i11, C1244Cg c1244Cg) throws C11849v {
        c1376Hz.A0Y(i11 + 8);
        int iA00 = CJ.A00(c1376Hz.A08());
        if ((iA00 & 1) != 0) {
            throw new C11849v(A0A(381, 56, 66));
        }
        boolean z11 = (iA00 & 2) != 0;
        int iA0H = c1376Hz.A0H();
        if (iA0H != c1244Cg.A00) {
            throw new C11849v(A0A(290, 17, 20) + iA0H + A0A(0, 2, 62) + c1244Cg.A00);
        }
        Arrays.fill(c1244Cg.A0H, 0, iA0H, z11);
        c1244Cg.A02(c1376Hz.A04());
        c1244Cg.A05(c1376Hz);
    }

    public static void A0S(C1376Hz c1376Hz, C1244Cg c1244Cg) throws C11849v {
        c1376Hz.A0Y(8);
        int iA08 = c1376Hz.A08();
        if ((CJ.A00(iA08) & 1) == 1) {
            c1376Hz.A0Z(8);
        }
        int iA0H = c1376Hz.A0H();
        if (iA0H != 1) {
            throw new C11849v(A0A(552, 29, 63) + iA0H);
        }
        c1244Cg.A04 += CJ.A01(iA08) == 0 ? c1376Hz.A0M() : c1376Hz.A0N();
    }

    public static void A0T(C1376Hz c1376Hz, C1244Cg c1244Cg) throws C11849v {
        A0R(c1376Hz, 0, c1244Cg);
    }

    public static void A0U(C1376Hz c1376Hz, C1244Cg c1244Cg, byte[] bArr) throws C11849v {
        c1376Hz.A0Y(8);
        c1376Hz.A0c(bArr, 0, 16);
        if (Arrays.equals(bArr, A0c)) {
            A0R(c1376Hz, 16, c1244Cg);
        }
    }

    public static void A0V(C1376Hz c1376Hz, C1376Hz c1376Hz2, String str, C1244Cg c1244Cg) throws C11849v {
        c1376Hz.A0Y(8);
        int iA08 = c1376Hz.A08();
        int iA09 = c1376Hz.A08();
        int i11 = A0a;
        if (iA09 != i11) {
            return;
        }
        if (CJ.A01(iA08) == 1) {
            c1376Hz.A0Z(4);
        }
        if (c1376Hz.A08() != 1) {
            throw new C11849v(A0A(50, 39, 80));
        }
        c1376Hz2.A0Y(8);
        int iA010 = c1376Hz2.A08();
        if (c1376Hz2.A08() != i11) {
            return;
        }
        int iA01 = CJ.A01(iA010);
        if (iA01 == 1) {
            if (c1376Hz2.A0M() == 0) {
                throw new C11849v(A0A(609, 55, 11));
            }
        } else if (iA01 >= 2) {
            c1376Hz2.A0Z(4);
        }
        if (c1376Hz2.A0M() != 1) {
            throw new C11849v(A0A(89, 39, 85));
        }
        c1376Hz2.A0Z(1);
        int iA0E = c1376Hz2.A0E();
        int i12 = (iA0E & 240) >> 4;
        int i13 = iA0E & 15;
        boolean z11 = c1376Hz2.A0E() == 1;
        if (z11) {
            int iA0E2 = c1376Hz2.A0E();
            byte[] bArr = new byte[16];
            c1376Hz2.A0c(bArr, 0, bArr.length);
            byte[] bArr2 = null;
            if (z11 && iA0E2 == 0) {
                int iA0E3 = c1376Hz2.A0E();
                bArr2 = new byte[iA0E3];
                c1376Hz2.A0c(bArr2, 0, iA0E3);
            }
            c1244Cg.A0A = true;
            c1244Cg.A08 = new C1243Cf(z11, str, iA0E2, bArr, i12, i13, bArr2);
        }
    }

    public static boolean A0W(int i11) {
        return i11 == CJ.A0k || i11 == CJ.A1M || i11 == CJ.A0e || i11 == CJ.A0i || i11 == CJ.A17 || i11 == CJ.A0j || i11 == CJ.A1L || i11 == CJ.A0n || i11 == CJ.A0O;
    }

    public static boolean A0X(int i11) {
        if (i11 != CJ.A0W && i11 != CJ.A0d && i11 != CJ.A0o && i11 != CJ.A13 && i11 != CJ.A1B) {
            int i12 = CJ.A1I;
            if (A0Y[6].length() != 17) {
                A0Y[0] = "0bfDB";
                if (i11 != i12 && i11 != CJ.A1J && i11 != CJ.A1K && i11 != CJ.A1N && i11 != CJ.A1O && i11 != CJ.A0s && i11 != CJ.A0v) {
                    int i13 = CJ.A0u;
                    if (A0Y[1].length() != 5) {
                        A0Y[5] = "GM1eDi9JpLsxcWxFcWWsCjSZthCJdr4f";
                        if (i11 != i13 && i11 != CJ.A11 && i11 != CJ.A1R && i11 != CJ.A0y && i11 != CJ.A12 && i11 != CJ.A0P) {
                            int i14 = CJ.A0g;
                            if (A0Y[3].length() == 6) {
                                A0Y[7] = "Eu3";
                                if (i11 != i14 && i11 != CJ.A0Q) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x007c, code lost:
    
        if (r2 >= r8) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007e, code lost:
    
        r0 = r11.A7i() - ((long) r10.A00);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008a, code lost:
    
        if (r10.A01 != com.facebook.ads.redexgen.uinode.CJ.A0j) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008c, code lost:
    
        r9 = r10.A0K.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
    
        if (r8 >= r9) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0095, code lost:
    
        r2 = r10.A0K.valueAt(r8).A07;
        r2.A03 = r0;
        r2.A04 = r0;
        r2.A05 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00af, code lost:
    
        if (com.facebook.ads.redexgen.uinode.XN.A0Y[3].length() == 6) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b1, code lost:
    
        r7 = com.facebook.ads.redexgen.uinode.XN.A0Y;
        r7[2] = "tKeeSnEBB5V";
        r7[4] = "1ppH9MP2kpM";
        r8 = r8 + 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c0, code lost:
    
        com.facebook.ads.redexgen.uinode.XN.A0Y[0] = "GrBVN";
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d4, code lost:
    
        if (r2 >= r8) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012c, code lost:
    
        if (r10.A01 != com.facebook.ads.redexgen.uinode.CJ.A0c) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012e, code lost:
    
        r10.A0D = null;
        r10.A09 = r10.A07 + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0137, code lost:
    
        if (r10.A0F != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0139, code lost:
    
        r10.A0C.AFi(new com.facebook.ads.redexgen.uinode.C1765Xj(r10.A08, r0));
        r10.A0F = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0147, code lost:
    
        r10.A02 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x014a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0151, code lost:
    
        if (A0W(r10.A01) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0153, code lost:
    
        r5 = (r11.A7i() + r10.A07) - 8;
        r10.A0T.push(new com.facebook.ads.redexgen.uinode.XT(r10.A01, r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0170, code lost:
    
        if (r10.A07 != r10.A00) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0172, code lost:
    
        A0F(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0176, code lost:
    
        A0B();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0188, code lost:
    
        throw new com.facebook.ads.redexgen.uinode.C11849v(A0A(2, 48, 114));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0192, code lost:
    
        if (A0X(r10.A01) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0194, code lost:
    
        r3 = r10.A00;
        r2 = com.facebook.ads.redexgen.uinode.XN.A0Y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01a6, code lost:
    
        if (r2[2].length() == r2[4].length()) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b2, code lost:
    
        if (r10.A07 > 2147483647L) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b4, code lost:
    
        r10.A0E = null;
        r10.A02 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b9, code lost:
    
        com.facebook.ads.redexgen.uinode.XN.A0Y[7] = "6Yw";
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01c0, code lost:
    
        if (r3 != 8) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01c2, code lost:
    
        r2 = r10.A07;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01c6, code lost:
    
        if (r2 > 2147483647L) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01c8, code lost:
    
        r10.A0E = new com.facebook.ads.redexgen.uinode.C1376Hz((int) r2);
        java.lang.System.arraycopy(r10.A0O.A00, 0, r10.A0E.A00, 0, 8);
        r10.A02 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01dd, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01ed, code lost:
    
        throw new com.facebook.ads.redexgen.uinode.C11849v(A0A(241, 49, 53));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01fd, code lost:
    
        throw new com.facebook.ads.redexgen.uinode.C11849v(A0A(190, 51, 24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x020c, code lost:
    
        throw new com.facebook.ads.redexgen.uinode.C11849v(A0A(479, 53, 2));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A0Y(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        if (this.A00 == 0) {
            if (!interfaceC1234Bt.AEM(this.A0O.A00, 0, 8, true)) {
                return false;
            }
            this.A00 = 8;
            this.A0O.A0Y(0);
            this.A07 = this.A0O.A0M();
            this.A01 = this.A0O.A08();
        }
        long j11 = this.A07;
        if (j11 == 1) {
            interfaceC1234Bt.readFully(this.A0O.A00, 8, 8);
            this.A00 += 8;
            if (A0Y[5].charAt(2) != 'C') {
                A0Y[6] = "6cAY2NAyMtL9j2hMAwiIzwyy";
                this.A07 = this.A0O.A0N();
            }
            throw new RuntimeException();
        }
        if (j11 == 0) {
            long jA7I = interfaceC1234Bt.A7I();
            if (jA7I == -1 && !this.A0T.isEmpty()) {
                ArrayDeque<XT> arrayDeque = this.A0T;
                if (A0Y[6].length() != 17) {
                    A0Y[0] = "9SBPW";
                    jA7I = arrayDeque.peek().A00;
                } else {
                    jA7I = arrayDeque.peek().A00;
                }
            }
            if (jA7I != -1) {
                this.A07 = (jA7I - interfaceC1234Bt.A7i()) + ((long) this.A00);
            }
        }
        long j12 = this.A07;
        int i11 = this.A00;
        if (A0Y[1].length() != 5) {
            String[] strArr = A0Y;
            strArr[2] = "YhN2vmsMCgc";
            strArr[4] = "GXPkMa8ctqb";
        } else {
            A0Y[7] = "I3p";
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0107 A[PHI: r0 r1 r4 r5 r6
  0x0107: PHI (r0v80 com.facebook.ads.redexgen.X.IB) = (r0v9 com.facebook.ads.redexgen.X.IB), (r0v84 com.facebook.ads.redexgen.X.IB) binds: [B:62:0x020c, B:36:0x0105] A[DONT_GENERATE, DONT_INLINE]
  0x0107: PHI (r1v6 long) = (r1v4 long), (r1v10 long) binds: [B:62:0x020c, B:36:0x0105] A[DONT_GENERATE, DONT_INLINE]
  0x0107: PHI (r4v3 int) = (r4v1 int), (r4v4 int) binds: [B:62:0x020c, B:36:0x0105] A[DONT_GENERATE, DONT_INLINE]
  0x0107: PHI (r5v2 com.facebook.ads.redexgen.X.C4) = (r5v0 com.facebook.ads.redexgen.X.C4), (r5v3 com.facebook.ads.redexgen.X.C4) binds: [B:62:0x020c, B:36:0x0105] A[DONT_GENERATE, DONT_INLINE]
  0x0107: PHI (r6v2 com.facebook.ads.redexgen.X.Ce) = (r6v0 com.facebook.ads.redexgen.X.Ce), (r6v3 com.facebook.ads.redexgen.X.Ce) binds: [B:62:0x020c, B:36:0x0105] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:53:0x0188  */
    /* JADX WARN: Code duplicated, block: B:58:0x0191  */
    /* JADX WARN: Code duplicated, block: B:60:0x01ec  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean A0Z(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        C1242Ce c1242Ce;
        C4 c11;
        int i11;
        long jA00;
        IB ib2;
        boolean z11;
        int iAFQ;
        int i12 = 4;
        int i13 = 1;
        int i14 = 0;
        if (this.A02 == 3) {
            if (this.A0D == null) {
                CV cvA07 = A07(this.A0K);
                if (cvA07 == null) {
                    int iA7i = (int) (this.A09 - interfaceC1234Bt.A7i());
                    if (iA7i < 0) {
                        throw new C11849v(A0A(346, 35, 56));
                    }
                    interfaceC1234Bt.AGP(iA7i);
                    A0B();
                    return false;
                }
                int iA7i2 = (int) (cvA07.A07.A0G[cvA07.A02] - interfaceC1234Bt.A7i());
                if (iA7i2 < 0) {
                    Log.w(A0A(128, 22, 24), A0A(150, 40, 46));
                    iA7i2 = 0;
                }
                interfaceC1234Bt.AGP(iA7i2);
                if (A0Y[6].length() == 17) {
                    throw new RuntimeException();
                }
                A0Y[3] = "TF0FBE";
                this.A0D = cvA07;
            }
            this.A06 = this.A0D.A07.A0D[this.A0D.A01];
            if (this.A0D.A01 < this.A0D.A03) {
                interfaceC1234Bt.AGP(this.A06);
                this.A0D.A01();
                if (!this.A0D.A08()) {
                    this.A0D = null;
                }
                this.A02 = 3;
                return true;
            }
            if (this.A0D.A05.A02 == 1) {
                this.A06 -= 8;
                interfaceC1234Bt.AGP(8);
            }
            int iA03 = this.A0D.A03();
            this.A04 = iA03;
            this.A06 += iA03;
            this.A02 = 4;
            this.A05 = 0;
        }
        C1244Cg c1244Cg = this.A0D.A07;
        CV cv2 = this.A0D;
        String[] strArr = A0Y;
        if (strArr[2].length() != strArr[4].length()) {
            A0Y[7] = "Pqi";
            c1242Ce = cv2.A05;
            c11 = this.A0D.A06;
            i11 = this.A0D.A01;
            jA00 = c1244Cg.A00(i11) * 1000;
            ib2 = this.A0S;
            if (ib2 != null) {
                jA00 = ib2.A06(jA00);
            }
        } else {
            A0Y[0] = "M6XHB";
            c1242Ce = cv2.A05;
            c11 = this.A0D.A06;
            i11 = this.A0D.A01;
            jA00 = c1244Cg.A00(i11) * 1000;
            ib2 = this.A0S;
            if (ib2 != null) {
                jA00 = ib2.A06(jA00);
            }
        }
        if (c1242Ce.A01 == 0) {
            while (true) {
                int i15 = this.A04;
                int i16 = this.A06;
                if (i15 >= i16) {
                    break;
                }
                this.A04 += c11.AFQ(interfaceC1234Bt, i16 - i15, false);
            }
        } else {
            byte[] bArr = this.A0Q.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i17 = c1242Ce.A01 + 1;
            int i18 = 4 - c1242Ce.A01;
            while (this.A04 < this.A06) {
                int i19 = this.A05;
                if (A0Y[1].length() != 5) {
                    String[] strArr2 = A0Y;
                    strArr2[2] = "oY9Cfc6NZLH";
                    strArr2[4] = "IHvoiGll8tT";
                    if (i19 == 0) {
                        interfaceC1234Bt.readFully(bArr, i18, i17);
                        this.A0Q.A0Y(i14);
                        this.A05 = this.A0Q.A0H() - i13;
                        this.A0R.A0Y(i14);
                        c11.AFR(this.A0R, i12);
                        c11.AFR(this.A0Q, i13);
                        if (this.A0H.length > 0 || !AbstractC1372Hv.A0C(c1242Ce.A07.A0O, bArr[i12])) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        this.A0G = z11;
                        this.A04 += 5;
                        this.A06 += i18;
                    } else {
                        if (this.A0G) {
                            this.A0P.A0W(i19);
                            interfaceC1234Bt.readFully(this.A0P.A00, i14, this.A05);
                            c11.AFR(this.A0P, this.A05);
                            iAFQ = this.A05;
                            int iA02 = AbstractC1372Hv.A02(this.A0P.A00, this.A0P.A07());
                            this.A0P.A0Y(A0A(686, 10, 6).equals(c1242Ce.A07.A0O) ? 1 : 0);
                            this.A0P.A0X(iA02);
                            AbstractC1325Fy.A03(jA00, this.A0P, this.A0H);
                        } else {
                            iAFQ = c11.AFQ(interfaceC1234Bt, i19, false);
                        }
                        this.A04 += iAFQ;
                        this.A05 -= iAFQ;
                        i12 = 4;
                        i13 = 1;
                        i14 = 0;
                    }
                } else if (i19 == 0) {
                    interfaceC1234Bt.readFully(bArr, i18, i17);
                    this.A0Q.A0Y(i14);
                    this.A05 = this.A0Q.A0H() - i13;
                    this.A0R.A0Y(i14);
                    c11.AFR(this.A0R, i12);
                    c11.AFR(this.A0Q, i13);
                    if (this.A0H.length > 0) {
                        z11 = false;
                    } else {
                        z11 = false;
                    }
                    this.A0G = z11;
                    this.A04 += 5;
                    this.A06 += i18;
                } else {
                    if (this.A0G) {
                        this.A0P.A0W(i19);
                        interfaceC1234Bt.readFully(this.A0P.A00, i14, this.A05);
                        c11.AFR(this.A0P, this.A05);
                        iAFQ = this.A05;
                        int iA04 = AbstractC1372Hv.A02(this.A0P.A00, this.A0P.A07());
                        this.A0P.A0Y(A0A(686, 10, 6).equals(c1242Ce.A07.A0O) ? 1 : 0);
                        this.A0P.A0X(iA04);
                        AbstractC1325Fy.A03(jA00, this.A0P, this.A0H);
                    } else {
                        iAFQ = c11.AFQ(interfaceC1234Bt, i19, false);
                    }
                    this.A04 += iAFQ;
                    this.A05 -= iAFQ;
                    i12 = 4;
                    i13 = 1;
                    i14 = 0;
                }
            }
        }
        boolean z12 = c1244Cg.A0I[i11];
        C3 c12 = null;
        int i21 = z12;
        if (c1244Cg.A0A) {
            int i22 = (z12 ? 1 : 0) | 1073741824;
            c12 = (c1244Cg.A08 != null ? c1244Cg.A08 : c1242Ce.A00(c1244Cg.A07.A02)).A01;
            i21 = i22;
        }
        c11.AFS(jA00, i21, this.A06, 0, c12);
        A0E(jA00);
        if (!this.A0D.A08()) {
            this.A0D = null;
        }
        this.A02 = 3;
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void A8o(InterfaceC1235Bu interfaceC1235Bu) {
        this.A0C = interfaceC1235Bu;
        C1242Ce c1242Ce = this.A0N;
        if (c1242Ce != null) {
            CV cv2 = new CV(interfaceC1235Bu.AGi(0, c1242Ce.A03));
            cv2.A07(this.A0N, new CP(0, 0, 0, 0));
            this.A0K.put(0, cv2);
            A0C();
            this.A0C.A5Y();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final int AEH(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        while (true) {
            int i11 = this.A02;
            if (A0Y[6].length() == 17) {
                throw new RuntimeException();
            }
            A0Y[6] = "Adcvl3OLLWBEEjCvRjB7l1tHvWvuGk";
            switch (i11) {
                case 0:
                    if (!A0Y(interfaceC1234Bt)) {
                        return -1;
                    }
                    break;
                    break;
                case 1:
                    A0G(interfaceC1234Bt);
                    break;
                case 2:
                    A0H(interfaceC1234Bt);
                    break;
                default:
                    if (A0Z(interfaceC1234Bt)) {
                        return 0;
                    }
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void AFh(long j11, long j12) {
        int size = this.A0K.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.A0K.valueAt(i11).A04();
        }
        this.A0U.clear();
        this.A03 = 0;
        this.A0A = j12;
        this.A0T.clear();
        A0B();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final boolean AGR(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        return AbstractC1241Cc.A03(interfaceC1234Bt);
    }
}
