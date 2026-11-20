package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1717Vk implements InterfaceC1346Gu {
    public static byte[] A0L;
    public static String[] A0M = {"BZiYu5nwNf87X3b9kN", "UgTeeMN2jxyMd9Kylf", "PJ", "CPqLt3pCFfCSwfi", "XN4Dvc1", "tWEaaCCiJhgiXtacO5se5vgeqa", "S002dfR", "J7ycXdK5d"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public Uri A05;
    public Uri A06;
    public InterfaceC1346Gu A07;
    public HO A08;
    public String A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final InterfaceC1346Gu A0D;
    public final InterfaceC1346Gu A0E;
    public final InterfaceC1346Gu A0F;
    public final HK A0G;
    public final HM A0H;
    public final boolean A0I;
    public final boolean A0J;
    public final boolean A0K;

    static {
        A06();
    }

    public C1717Vk(HK hk2, InterfaceC1346Gu interfaceC1346Gu, InterfaceC1346Gu interfaceC1346Gu2, InterfaceC1344Gs interfaceC1344Gs, int i11, HM hm2) {
        this.A0G = hk2;
        this.A0D = interfaceC1346Gu2;
        this.A0I = (i11 & 1) != 0;
        this.A0K = (i11 & 2) != 0;
        this.A0J = (i11 & 4) != 0;
        this.A0F = interfaceC1346Gu;
        if (interfaceC1344Gs != null) {
            this.A0E = new C1720Vn(interfaceC1346Gu, interfaceC1344Gs);
        } else {
            this.A0E = null;
        }
        this.A0H = hm2;
    }

    private int A00(C1350Gy c1350Gy) {
        if (this.A0K) {
            boolean z11 = this.A0C;
            String[] strArr = A0M;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[3] = "r97zDVaaptRGknr";
            strArr2[6] = "AimjfMN";
            if (z11) {
                if (A0M[7].length() != 14) {
                    A0M[7] = "lgdHkpCnxjAeRqVRog4eGXXV3TVVS";
                    return 0;
                }
                A0M[4] = "GvTYan8nqvP";
                return 0;
            }
        }
        return (this.A0J && c1350Gy.A02 == -1) ? 1 : -1;
    }

    public static Uri A01(HK hk2, String str, Uri uri) {
        Uri uriA01 = HV.A01(hk2.A6X(str));
        return uriA01 == null ? uri : uriA01;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0L, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 35);
        }
        return new String(bArrCopyOfRange);
    }

    private void A03() throws IOException {
        InterfaceC1346Gu interfaceC1346Gu = this.A07;
        if (interfaceC1346Gu == null) {
            return;
        }
        try {
            interfaceC1346Gu.close();
            this.A07 = null;
            this.A0A = false;
            HO ho2 = this.A08;
            if (A0M[5].length() != 26) {
                throw new RuntimeException();
            }
            String[] strArr = A0M;
            strArr[3] = "f78PdfdQFRIsoy9";
            strArr[6] = "Xl8bArW";
            if (ho2 != null) {
                this.A0G.AEZ(ho2);
                this.A08 = null;
            }
        } catch (Throwable th2) {
            this.A07 = null;
            this.A0A = false;
            HO ho3 = this.A08;
            if (ho3 != null) {
                this.A0G.AEZ(ho3);
                this.A08 = null;
            }
            throw th2;
        }
    }

    private void A04() {
        if (0 == 0 || this.A04 <= 0) {
            return;
        }
        this.A0G.A6F();
        throw new NullPointerException(A02(0, 17, 18));
    }

    private void A05() throws IOException {
        this.A01 = 0L;
        if (A0C()) {
            this.A0G.AFx(this.A09, this.A03);
        }
    }

    public static void A06() {
        A0L = new byte[]{-92, -93, 120, -106, -104, -99, -102, -103, 119, -82, -87, -102, -88, -121, -102, -106, -103};
    }

    private void A07(IOException iOException) {
        if (A0A() || (iOException instanceof HI)) {
            this.A0C = true;
        }
    }

    private void A08(boolean z11) throws IOException {
        HO hoAGV;
        long jMin;
        C1350Gy c1350Gy;
        InterfaceC1346Gu interfaceC1346Gu;
        if (this.A0B) {
            hoAGV = null;
        } else if (this.A0I) {
            try {
                hoAGV = this.A0G.AGV(this.A09, this.A03);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            hoAGV = this.A0G.AGW(this.A09, this.A03);
        }
        if (hoAGV == null) {
            interfaceC1346Gu = this.A0F;
            c1350Gy = new C1350Gy(this.A06, this.A03, this.A01, this.A09, this.A00);
        } else if (hoAGV.A05) {
            Uri uriFromFile = Uri.fromFile(hoAGV.A03);
            long j11 = this.A03 - hoAGV.A02;
            long jMin2 = hoAGV.A01 - j11;
            long j12 = this.A01;
            if (j12 != -1) {
                jMin2 = Math.min(jMin2, j12);
            }
            c1350Gy = new C1350Gy(uriFromFile, this.A03, j11, jMin2, this.A09, this.A00);
            interfaceC1346Gu = this.A0D;
        } else {
            if (hoAGV.A02()) {
                jMin = this.A01;
            } else {
                jMin = hoAGV.A01;
                long j13 = this.A01;
                if (j13 != -1) {
                    jMin = Math.min(jMin, j13);
                }
            }
            c1350Gy = new C1350Gy(this.A06, this.A03, jMin, this.A09, this.A00);
            if (this.A0E != null) {
                interfaceC1346Gu = this.A0E;
            } else {
                interfaceC1346Gu = this.A0F;
                this.A0G.AEZ(hoAGV);
                hoAGV = null;
            }
        }
        this.A02 = (this.A0B || interfaceC1346Gu != this.A0F) ? Long.MAX_VALUE : this.A03 + OSSConstants.MIN_PART_SIZE_LIMIT;
        if (z11) {
            AbstractC1351Ha.A04(A09());
            if (interfaceC1346Gu == this.A0F) {
                return;
            }
            try {
                A03();
            } catch (Throwable th2) {
                if (hoAGV.A01()) {
                    this.A0G.AEZ(hoAGV);
                }
                throw th2;
            }
        }
        if (hoAGV != null && hoAGV.A01()) {
            this.A08 = hoAGV;
        }
        this.A07 = interfaceC1346Gu;
        this.A0A = c1350Gy.A02 == -1;
        long jADl = interfaceC1346Gu.ADl(c1350Gy);
        HW hw2 = new HW();
        if (this.A0A) {
            if (A0M[2].length() != 2) {
                throw new RuntimeException();
            }
            A0M[7] = "GQ8HbidAJ3";
            if (jADl != -1) {
                this.A01 = jADl;
                HV.A05(hw2, this.A03 + jADl);
            }
        }
        if (A0B()) {
            Uri uriA8E = this.A07.A8E();
            this.A05 = uriA8E;
            if (true ^ this.A06.equals(uriA8E)) {
                Uri uri = this.A05;
                if (A0M[5].length() != 26) {
                    HV.A06(hw2, uri);
                } else {
                    A0M[4] = "mDcPGOd9V6d2O";
                    HV.A06(hw2, uri);
                }
            } else {
                HV.A04(hw2);
            }
        }
        if (A0C()) {
            this.A0G.A3a(this.A09, hw2);
        }
    }

    private boolean A09() {
        return this.A07 == this.A0F;
    }

    private boolean A0A() {
        return this.A07 == this.A0D;
    }

    private boolean A0B() {
        return !A0A();
    }

    private boolean A0C() {
        return this.A07 == this.A0E;
    }

    public static boolean A0D(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof C1347Gv) && ((C1347Gv) cause).A00 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final Uri A8E() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final long ADl(C1350Gy c1350Gy) throws IOException {
        try {
            this.A09 = HQ.A02(c1350Gy);
            Uri uri = c1350Gy.A04;
            this.A06 = uri;
            this.A05 = A01(this.A0G, this.A09, uri);
            this.A00 = c1350Gy.A00;
            this.A03 = c1350Gy.A03;
            this.A0B = A00(c1350Gy) != -1;
            if (c1350Gy.A02 != -1 || this.A0B) {
                this.A01 = c1350Gy.A02;
            } else {
                long jA6W = this.A0G.A6W(this.A09);
                this.A01 = jA6W;
                if (jA6W != -1) {
                    long j11 = jA6W - c1350Gy.A03;
                    this.A01 = j11;
                    if (j11 <= 0) {
                        throw new C1347Gv(0);
                    }
                }
            }
            A08(false);
            return this.A01;
        } catch (IOException e11) {
            A07(e11);
            throw e11;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final void close() throws IOException {
        this.A06 = null;
        this.A05 = null;
        A04();
        try {
            A03();
        } catch (IOException e11) {
            A07(e11);
            throw e11;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1346Gu
    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        if (this.A01 == 0) {
            return -1;
        }
        try {
            if (this.A03 >= this.A02) {
                A08(true);
            }
            int i13 = this.A07.read(bArr, i11, i12);
            if (i13 != -1) {
                if (A0A()) {
                    this.A04 += (long) i13;
                }
                this.A03 += (long) i13;
                long j11 = this.A01;
                if (j11 != -1) {
                    this.A01 = j11 - ((long) i13);
                }
            } else {
                if (!this.A0A) {
                    long j12 = this.A01;
                    if (j12 <= 0) {
                        if (j12 == -1) {
                        }
                    }
                    A03();
                    A08(false);
                    return read(bArr, i11, i12);
                }
                A05();
            }
            return i13;
        } catch (IOException e11) {
            if (this.A0A && A0D(e11)) {
                A05();
                return -1;
            }
            A07(e11);
            throw e11;
        }
    }
}
