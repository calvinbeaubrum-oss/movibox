package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.56, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AnonymousClass56 {
    public static byte[] A0I;
    public static String[] A0J = {"RjjM", "koSvj4DxhDjUOCe4EMKks9dnOG3CuiGu", "aGHSBrQSfGZtxcbyILmCKrnGyIhpjEzu", "3xCBACovNHKuv2JvT7we0utPzpikn", "cVLYlYPRz01pIgpGABaAmbt5GOW22sRw", "rNQ6SroUNOr34Wm88sisB9VlrwVLSnji", "gjKr", "5vAD1AgEgb1ZXBUPAvYh"};
    public static final List<Object> A0K;
    public C1278Eb A08;
    public WeakReference<C1278Eb> A09;
    public int A0C;
    public final View A0H;
    public int A03 = -1;
    public int A01 = -1;
    public long A05 = -1;
    public int A00 = -1;
    public int A04 = -1;
    public AnonymousClass56 A06 = null;
    public AnonymousClass56 A07 = null;
    public List<Object> A0A = null;
    public List<Object> A0B = null;
    public int A0D = 0;
    public C10684w A0F = null;
    public boolean A0G = false;
    public int A0E = 0;
    public int A02 = -1;

    static {
        A04();
        A0K = Collections.EMPTY_LIST;
    }

    public AnonymousClass56(View view) {
        if (view == null) {
            throw new IllegalArgumentException(A02(264, 24, 92));
        }
        this.A0H = view;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 42);
        }
        return new String(bArrCopyOfRange);
    }

    private void A03() {
        if (this.A0A == null) {
            ArrayList arrayList = new ArrayList();
            this.A0A = arrayList;
            this.A0B = Collections.unmodifiableList(arrayList);
        }
    }

    public static void A04() {
        A0I = new byte[]{120, 49, 60, 101, 89, Ascii.DLE, Ascii.RS, Ascii.ETB, Ascii.SYN, Ascii.VT, Ascii.FS, Ascii.GS, 107, 34, 37, 61, 42, 39, 34, 47, 9, 71, 70, 9, 89, 72, 91, 76, 71, 93, Ascii.DC4, 90, 91, 64, Ascii.DC4, 70, 81, 87, 77, 87, 88, 85, 86, 88, 81, Ascii.FS, 123, 43, 52, 40, 50, 47, 50, 52, 53, 102, 114, 32, 55, Utf8.REPLACEMENT_BYTE, 61, 36, 55, 54, Ascii.DC2, 65, 81, 64, 83, 66, Ascii.DC2, Ascii.EM, 77, 84, 73, 125, 92, 77, 88, 90, 81, 92, 93, 58, 111, 116, 120, 117, 111, 116, 126, 100, 49, 42, 32, 33, 34, 45, 42, 33, 32, 100, 37, 32, 37, 52, 48, 33, 54, 100, 52, 43, 55, 45, 48, 45, 43, 42, 41, 124, 121, 109, 104, 125, 108, 81, Ascii.SYN, Ascii.SUB, 85, 86, 94, 106, 85, 73, 7, 76, 64, Ascii.DLE, 44, Ascii.DLE, Ascii.SI, 19, 90, 96, 95, 83, 65, 69, 122, 118, 100, 91, 124, Ascii.DEL, 119, 118, 97, 104, 118, 76, 89, 89, 76, 78, 69, 72, 73, 126, 78, 95, 76, 93, 112, 95, 103, 108, 101, 106, 99, 97, 87, 103, 118, 101, 116, 89, 48, 42, Ascii.VT, 60, 58, 32, 58, 53, 56, 59, 53, 60, 121, 61, 60, 58, 43, 60, 52, 60, 55, 45, 60, 61, 121, 59, 60, 53, 54, 46, 121, 105, 99, 121, 44, 55, 52, 56, 45, 58, 49, 60, 61, 121, 41, 56, 48, 43, 121, 54, Utf8.REPLACEMENT_BYTE, 121, 42, 60, 45, Ascii.DLE, 42, Ascii.VT, 60, 58, 32, 56, 59, 53, 60, 113, 112, 121, 58, 56, 53, 53, 42, 121, Utf8.REPLACEMENT_BYTE, 54, 43, 121, Ascii.US, 2, 19, Ascii.ESC, 32, Ascii.US, 19, 1, 86, Ascii.ESC, Ascii.ETB, Ascii.SI, 86, Ascii.CAN, Ascii.EM, 2, 86, Ascii.DC4, 19, 86, Ascii.CAN, 3, Ascii.SUB, Ascii.SUB, 19};
        String[] strArr = A0J;
        if (strArr[5].charAt(21) != strArr[1].charAt(21)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0J;
        strArr2[5] = "ATZarWDBMn8zDwozKxOA19Yjdj8cqMYP";
        strArr2[1] = "9Y2h7opSRjFz5DGljetO79QOLWaAi3pM";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(C1278Eb c1278Eb) {
        this.A0E = C3T.A00(this.A0H);
        c1278Eb.A1x(this, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(C1278Eb c1278Eb) {
        c1278Eb.A1x(this, this.A0E);
        this.A0E = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A09() {
        return (this.A0C & 16) == 0 && C3T.A0G(this.A0H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0A() {
        return (this.A0C & 16) != 0;
    }

    private final boolean A0B() {
        return (this.A0C & 512) != 0 || A0Z();
    }

    public final int A0G() {
        C1278Eb c1278Eb = this.A08;
        if (c1278Eb == null) {
            return -1;
        }
        return c1278Eb.A1C(this);
    }

    public final int A0H() {
        return this.A00;
    }

    public final int A0I() {
        int i11 = this.A04;
        return i11 == -1 ? this.A03 : i11;
    }

    public final int A0J() {
        return this.A01;
    }

    public final long A0K() {
        return this.A05;
    }

    public final List<Object> A0L() {
        if ((this.A0C & 1024) != 0) {
            return A0K;
        }
        List<Object> list = this.A0A;
        if (list != null) {
            int size = list.size();
            if (A0J[2].charAt(8) == 'd') {
                throw new RuntimeException();
            }
            String[] strArr = A0J;
            strArr[5] = "2DcmVbWbN7IXAuYZB7QLz9ixHDr4nD2H";
            strArr[1] = "B34awafHihlIJm5KsMjOG9HfWfhHTq0p";
            if (size != 0) {
                return this.A0B;
            }
        }
        return A0K;
    }

    public final void A0M() {
        this.A01 = -1;
        this.A04 = -1;
    }

    public final void A0N() {
        List<Object> list = this.A0A;
        if (list != null) {
            list.clear();
        }
        this.A0C &= -1025;
    }

    public final void A0O() {
        this.A0C &= -33;
    }

    public final void A0P() {
        this.A0C &= -257;
    }

    public final void A0Q() {
        this.A0C = 0;
        this.A03 = -1;
        this.A01 = -1;
        this.A05 = -1L;
        this.A04 = -1;
        this.A0D = 0;
        this.A06 = null;
        this.A07 = null;
        A0N();
        this.A0E = 0;
        this.A02 = -1;
        C1278Eb.A0s(this);
    }

    public final void A0R() {
        if (this.A01 == -1) {
            this.A01 = this.A03;
        }
    }

    public final void A0S() {
        this.A0F.A0Y(this);
    }

    public final void A0T(int i11) {
        this.A0C |= i11;
    }

    public final void A0U(int i11, int i12) {
        this.A0C = (this.A0C & (i12 ^ (-1))) | (i11 & i12);
    }

    public final void A0V(C10684w c10684w, boolean z11) {
        this.A0F = c10684w;
        this.A0G = z11;
    }

    public final void A0W(Object obj) {
        if (obj == null) {
            A0T(1024);
        } else if ((1024 & this.A0C) == 0) {
            A03();
            this.A0A.add(obj);
        }
    }

    public final void A0X(boolean z11) {
        int i11 = this.A0D;
        int i12 = z11 ? i11 - 1 : i11 + 1;
        this.A0D = i12;
        if (A0J[4].charAt(7) != 'R') {
            throw new RuntimeException();
        }
        A0J[7] = "l8mjsSEKM";
        if (i12 < 0) {
            this.A0D = 0;
            Log.e(A02(143, 4, 28), A02(186, 78, 115) + this);
            return;
        }
        if (z11 || i12 != 1) {
            if (z11 && i12 == 0) {
                this.A0C &= -17;
                return;
            }
            return;
        }
        int i13 = this.A0C | 16;
        String[] strArr = A0J;
        if (strArr[5].charAt(21) != strArr[1].charAt(21)) {
            throw new RuntimeException();
        }
        A0J[2] = "drml3nLoX5pQWQBc32bzozsnTExNEnJK";
        this.A0C = i13;
    }

    public final boolean A0Y() {
        return (this.A0C & 1) != 0;
    }

    public final boolean A0Z() {
        return (this.A0C & 4) != 0;
    }

    public final boolean A0a() {
        return (this.A0C & 8) != 0;
    }

    public final boolean A0b() {
        return this.A0F != null;
    }

    public final boolean A0c() {
        return (this.A0C & 256) != 0;
    }

    public final boolean A0d() {
        return (this.A0C & 2) != 0;
    }

    public final boolean A0e() {
        return (this.A0C & 2) != 0;
    }

    public final boolean A0f() {
        return (this.A0C & 128) != 0;
    }

    public final boolean A0g() {
        return (this.A0C & 32) != 0;
    }

    public final boolean A0h() {
        return (this.A0C & 16) == 0 && !C3T.A0G(this.A0H);
    }

    public final boolean A0i(int i11) {
        return (this.A0C & i11) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x01b5  */
    public final String toString() {
        String strA02;
        StringBuilder sb2 = new StringBuilder(A02(147, 11, 57) + Integer.toHexString(hashCode()) + A02(46, 10, 113) + this.A03 + A02(0, 4, 114) + this.A05 + A02(WebSocketProtocol.PAYLOAD_SHORT, 9, 16) + this.A01 + A02(TsExtractor.TS_STREAM_TYPE_E_AC3, 8, 74) + this.A04);
        if (A0b()) {
            StringBuilder sbAppend = sb2.append(A02(64, 7, 24));
            if (this.A0G) {
                String[] strArr = A0J;
                if (strArr[0].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                A0J[4] = "j0Vj1oVRIqCq1XZaWhj1lvw8KAw9tpFK";
                strA02 = A02(173, 13, 46);
            } else {
                strA02 = A02(158, 15, 7);
            }
            sbAppend.append(strA02);
        }
        if (A0Z()) {
            sb2.append(A02(12, 8, 97));
        }
        if (!A0Y()) {
            sb2.append(A02(83, 8, 48));
        }
        if (A0e()) {
            if (A0J[4].charAt(7) != 'R') {
                throw new RuntimeException();
            }
            A0J[3] = "foGMuj5MEatDallcaM1f2EXlxkDRS";
            sb2.append(A02(118, 7, 35));
        }
        if (A0a()) {
            sb2.append(A02(56, 8, 120));
        }
        if (A0f()) {
            sb2.append(A02(4, 8, 83));
        }
        if (A0c()) {
            sb2.append(A02(71, 12, 19));
        }
        if (!A0h()) {
            sb2.append(A02(30, 16, 30) + this.A0D + A02(125, 1, 82));
        }
        if (A0B()) {
            sb2.append(A02(91, 27, Worker.WHAT_QUIT));
        }
        View view = this.A0H;
        String[] strArr2 = A0J;
        if (strArr2[0].length() != strArr2[6].length()) {
            A0J[3] = "v49slmZH3G5n79cGGvxOHO9vt1V64";
            if (view.getParent() == null) {
                sb2.append(A02(20, 10, 3));
            }
        } else {
            String[] strArr3 = A0J;
            strArr3[5] = "W0NVeHZD2y4aXmdfyR2eL940vqkefCMI";
            strArr3[1] = "YJ6uhs8dg1u1qe09RVpCk9ETEVw4FjVT";
            if (view.getParent() == null) {
                sb2.append(A02(20, 10, 3));
            }
        }
        sb2.append(A02(288, 1, 68));
        return sb2.toString();
    }
}
