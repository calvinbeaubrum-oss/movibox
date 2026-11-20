package com.facebook.ads.redexgen.uinode;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1744Wo implements InterfaceC1233Bs {
    public static byte[] A0C;
    public static String[] A0D = {"1uxTk9uu8NGqb4bRD7SiE7", "Ssi3SEW4IwUGp9bqpG4lGM81x4BmU482", "xmiG4gye91jMk16VeYAf2JsNYB9ZLAXn", "P3M63oXZ4RlItM7d6tCP0FhU4UJB0VVm", "pvrI0I2hPgkxZ7mKqcVNCE", "IViSy7bNMMRqTObQqgQHZJ03ioQVAxI3", "AKSfxMAYbymYkKmkIHXjHayRWnu0Srjs", "XaZNcJans0E3GSdApjoK7oUba6xaED3H"};
    public static final InterfaceC1236Bv A0E;
    public static final long A0F;
    public static final long A0G;
    public static final long A0H;
    public int A00;
    public int A01;
    public InterfaceC1235Bu A02;
    public DD A03;
    public boolean A04;
    public final int A05;
    public final SparseArray<DD> A06;
    public final SparseBooleanArray A07;
    public final SparseIntArray A08;
    public final DB A09;
    public final C1376Hz A0A;
    public final List<IB> A0B;

    static {
        A0G();
        A0E = new C1747Wr();
        A0F = IF.A08(A0D(0, 4, 102));
        A0G = IF.A08(A0D(62, 4, 21));
        A0H = IF.A08(A0D(66, 4, 106));
    }

    public C1744Wo() {
        this(0);
    }

    public C1744Wo(int i11) {
        this(1, i11);
    }

    public C1744Wo(int i11, int i12) {
        this(i11, new IB(0L), new X5(i12));
    }

    public C1744Wo(int i11, IB ib2, DB db2) {
        this.A09 = (DB) AbstractC1351Ha.A01(db2);
        this.A05 = i11;
        if (i11 == 1 || i11 == 2) {
            this.A0B = Collections.singletonList(ib2);
        } else {
            ArrayList arrayList = new ArrayList();
            this.A0B = arrayList;
            arrayList.add(ib2);
        }
        this.A0A = new C1376Hz(new byte[9400], 0);
        this.A07 = new SparseBooleanArray();
        this.A06 = new SparseArray<>();
        this.A08 = new SparseIntArray();
        A0F();
    }

    public static /* synthetic */ int A01(C1744Wo c1744Wo) {
        int i11 = c1744Wo.A01;
        c1744Wo.A01 = i11 + 1;
        return i11;
    }

    public static String A0D(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 25);
        }
        return new String(bArrCopyOfRange);
    }

    private void A0F() {
        this.A07.clear();
        this.A06.clear();
        SparseArray<DD> sparseArrayA4d = this.A09.A4d();
        int size = sparseArrayA4d.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.A06.put(sparseArrayA4d.keyAt(i11), sparseArrayA4d.valueAt(i11));
        }
        this.A06.put(0, new C1749Wt(new C1746Wq(this)));
        this.A03 = null;
    }

    public static void A0G() {
        A0C = new byte[]{-64, -62, -84, -78, -106, -76, -63, -63, -62, -57, 115, -71, -68, -63, -73, 115, -58, -52, -63, -74, 115, -75, -52, -57, -72, -127, 115, -96, -62, -58, -57, 115, -65, -68, -66, -72, -65, -52, 115, -63, -62, -57, 115, -76, 115, -89, -59, -76, -63, -58, -61, -62, -59, -57, 115, -90, -57, -59, -72, -76, -64, -127, 115, 111, 113, 97, -53, -56, -39, -58};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void A8o(InterfaceC1235Bu interfaceC1235Bu) {
        this.A02 = interfaceC1235Bu;
        interfaceC1235Bu.AFi(new C1765Xj(C.TIME_UNSET));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005d  */
    /* JADX WARN: Code duplicated, block: B:16:0x006b  */
    /* JADX WARN: Code duplicated, block: B:18:0x0084  */
    /* JADX WARN: Code duplicated, block: B:21:0x0095  */
    /* JADX WARN: Code duplicated, block: B:32:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:41:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:43:0x010b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0116  */
    /* JADX WARN: Code duplicated, block: B:47:0x011c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0122  */
    /* JADX WARN: Code duplicated, block: B:52:0x0136  */
    /* JADX WARN: Code duplicated, block: B:54:0x013c A[PHI: r1
  0x013c: PHI (r1v14 int) = (r1v10 int), (r1v15 int) binds: [B:65:0x0167, B:53:0x013a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x0143  */
    /* JADX WARN: Code duplicated, block: B:60:0x014d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0153  */
    /* JADX WARN: Code duplicated, block: B:63:0x0155  */
    /* JADX WARN: Code duplicated, block: B:64:0x0157  */
    /* JADX WARN: Code duplicated, block: B:67:0x016a A[PHI: r1
  0x016a: PHI (r1v11 int) = (r1v10 int), (r1v15 int) binds: [B:65:0x0167, B:53:0x013a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x016c  */
    /* JADX WARN: Code duplicated, block: B:69:0x016e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0172  */
    /* JADX WARN: Code duplicated, block: B:73:0x0183  */
    /* JADX WARN: Code duplicated, block: B:75:0x018a  */
    /* JADX WARN: Code duplicated, block: B:77:0x0190  */
    /* JADX WARN: Code duplicated, block: B:79:0x0195  */
    /* JADX WARN: Code duplicated, block: B:82:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0057 A[EDGE_INSN: B:84:0x0057->B:12:0x0057 BREAK  A[LOOP:0: B:10:0x0042->B:24:0x00a6], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:47:0x011c, please report this as an issue */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final int AEH(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        int iA04;
        int iA07;
        int iA06;
        int i11;
        int iA08;
        boolean z11;
        int i12;
        int i13;
        boolean z12;
        DD dd2;
        int i14;
        int i15;
        C1376Hz c1376Hz;
        int iA09;
        String[] strArr;
        int i16;
        int i17;
        byte[] bArr = this.A0A.A00;
        if (9400 - this.A0A.A06() < 188) {
            C1376Hz c1376Hz2 = this.A0A;
            String[] strArr2 = A0D;
            if (strArr2[6].charAt(6) != strArr2[5].charAt(6)) {
                A0D[2] = "ymaFHNFZf9gck8KWGcKKw0IXvc03QQI3";
                int iA05 = c1376Hz2.A04();
                if (iA05 > 0) {
                    System.arraycopy(bArr, this.A0A.A06(), bArr, 0, iA05);
                }
                this.A0A.A0b(bArr, iA05);
                while (true) {
                    iA04 = this.A0A.A04();
                    if (A0D[3].charAt(10) != 'l') {
                        break;
                    }
                    String[] strArr3 = A0D;
                    strArr3[7] = "MGe5GBh04RQe2KloppfecB6ZEIGbEoYE";
                    strArr3[1] = "8AA3i6ilZVOjG9C6pEzYz1yKwgxBoNn5";
                    if (iA04 < 188) {
                        iA07 = this.A0A.A07();
                        iA06 = this.A0A.A06();
                        while (iA06 < iA07 && bArr[iA06] != 71) {
                            iA06++;
                        }
                        this.A0A.A0Y(iA06);
                        i11 = iA06 + 188;
                        if (i11 > iA07) {
                            int i18 = this.A00 + (iA06 - iA06);
                            this.A00 = i18;
                            if (this.A05 == 2 || i18 <= 376) {
                                return 0;
                            }
                            throw new C11849v(A0D(4, 58, 58));
                        }
                        this.A00 = 0;
                        iA08 = this.A0A.A08();
                        if ((8388608 & iA08) != 0) {
                            c1376Hz = this.A0A;
                            if (A0D[2].charAt(24) != 'y') {
                                throw new RuntimeException();
                            }
                            A0D[2] = "qLJ3C4wpvTds0ZGN514bh2BsPTU2CCIl";
                            c1376Hz.A0Y(i11);
                            return 0;
                        }
                        if ((4194304 & iA08) != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        i12 = 2096896 & iA08;
                        if (A0D[3].charAt(10) != 'l') {
                            i13 = i12 >> 8;
                            if ((iA08 & 32) != 0) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                        } else {
                            String[] strArr4 = A0D;
                            strArr4[6] = "UZBxTRohCkbmbL8TgZyccBrw6EXqioJ8";
                            strArr4[5] = "skRCCiBSOhxOXswyaciW8E5zJph5e4sW";
                            i13 = i12 >> 8;
                            if ((iA08 & 32) != 0) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                        }
                        if ((iA08 & 16) != 0) {
                            dd2 = this.A06.get(i13);
                        } else {
                            dd2 = null;
                        }
                        if (dd2 == null) {
                            this.A0A.A0Y(i11);
                            return 0;
                        }
                        if (this.A05 != 2) {
                            i14 = iA08 & 15;
                            i15 = this.A08.get(i13, i14 - 1);
                            this.A08.put(i13, i14);
                            if (i15 == i14) {
                                this.A0A.A0Y(i11);
                                return 0;
                            }
                            if (i14 != ((i15 + 1) & 15)) {
                                dd2.AFg();
                            }
                        }
                        if (z12) {
                            this.A0A.A0Z(this.A0A.A0E());
                        }
                        this.A0A.A0X(i11);
                        dd2.A4S(this.A0A, z11);
                        this.A0A.A0X(iA07);
                        this.A0A.A0Y(i11);
                        return 0;
                    }
                    iA09 = this.A0A.A07();
                    strArr = A0D;
                    if (strArr[6].charAt(6) != strArr[5].charAt(6)) {
                        A0D[2] = "eAgKulLwfpKF0SfrtEP0OqsbKpe9pzNg";
                        i16 = interfaceC1234Bt.read(bArr, iA09, 9400 - iA09);
                        i17 = -1;
                        if (i16 == -1) {
                            return i17;
                        }
                        this.A0A.A0X(iA09 + i16);
                    } else {
                        A0D[2] = "ccJ4V0ZamX9fhOj5uoAuEbTRuDAY2nBM";
                        i16 = interfaceC1234Bt.read(bArr, iA09, 9400 - iA09);
                        i17 = -1;
                        if (i16 == -1) {
                            return i17;
                        }
                        this.A0A.A0X(iA09 + i16);
                    }
                }
            }
        } else {
            while (true) {
                iA04 = this.A0A.A04();
                if (A0D[3].charAt(10) != 'l') {
                    break;
                    break;
                }
                String[] strArr5 = A0D;
                strArr5[7] = "MGe5GBh04RQe2KloppfecB6ZEIGbEoYE";
                strArr5[1] = "8AA3i6ilZVOjG9C6pEzYz1yKwgxBoNn5";
                if (iA04 < 188) {
                    iA07 = this.A0A.A07();
                    iA06 = this.A0A.A06();
                    while (iA06 < iA07) {
                        iA06++;
                    }
                    this.A0A.A0Y(iA06);
                    i11 = iA06 + 188;
                    if (i11 > iA07) {
                        int i19 = this.A00 + (iA06 - iA06);
                        this.A00 = i19;
                        if (this.A05 == 2) {
                        }
                        return 0;
                    }
                    this.A00 = 0;
                    iA08 = this.A0A.A08();
                    if ((8388608 & iA08) != 0) {
                        c1376Hz = this.A0A;
                        if (A0D[2].charAt(24) != 'y') {
                            throw new RuntimeException();
                        }
                        A0D[2] = "qLJ3C4wpvTds0ZGN514bh2BsPTU2CCIl";
                        c1376Hz.A0Y(i11);
                        return 0;
                    }
                    if ((4194304 & iA08) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    i12 = 2096896 & iA08;
                    if (A0D[3].charAt(10) != 'l') {
                        i13 = i12 >> 8;
                        if ((iA08 & 32) != 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                    } else {
                        String[] strArr6 = A0D;
                        strArr6[6] = "UZBxTRohCkbmbL8TgZyccBrw6EXqioJ8";
                        strArr6[5] = "skRCCiBSOhxOXswyaciW8E5zJph5e4sW";
                        i13 = i12 >> 8;
                        if ((iA08 & 32) != 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                    }
                    if ((iA08 & 16) != 0) {
                        dd2 = this.A06.get(i13);
                    } else {
                        dd2 = null;
                    }
                    if (dd2 == null) {
                        this.A0A.A0Y(i11);
                        return 0;
                    }
                    if (this.A05 != 2) {
                        i14 = iA08 & 15;
                        i15 = this.A08.get(i13, i14 - 1);
                        this.A08.put(i13, i14);
                        if (i15 == i14) {
                            this.A0A.A0Y(i11);
                            return 0;
                        }
                        if (i14 != ((i15 + 1) & 15)) {
                            dd2.AFg();
                        }
                    }
                    if (z12) {
                        this.A0A.A0Z(this.A0A.A0E());
                    }
                    this.A0A.A0X(i11);
                    dd2.A4S(this.A0A, z11);
                    this.A0A.A0X(iA07);
                    this.A0A.A0Y(i11);
                    return 0;
                }
                iA09 = this.A0A.A07();
                strArr = A0D;
                if (strArr[6].charAt(6) != strArr[5].charAt(6)) {
                    A0D[2] = "eAgKulLwfpKF0SfrtEP0OqsbKpe9pzNg";
                    i16 = interfaceC1234Bt.read(bArr, iA09, 9400 - iA09);
                    i17 = -1;
                    if (i16 == -1) {
                        return i17;
                    }
                    this.A0A.A0X(iA09 + i16);
                } else {
                    A0D[2] = "ccJ4V0ZamX9fhOj5uoAuEbTRuDAY2nBM";
                    i16 = interfaceC1234Bt.read(bArr, iA09, 9400 - iA09);
                    i17 = -1;
                    if (i16 == -1) {
                        return i17;
                    }
                    this.A0A.A0X(iA09 + i16);
                }
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void AFh(long j11, long j12) {
        int size = this.A0B.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.A0B.get(i11).A08();
        }
        this.A0A.A0V();
        this.A08.clear();
        A0F();
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final boolean AGR(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        byte[] bArr = this.A0A.A00;
        interfaceC1234Bt.ADv(bArr, 0, 940);
        for (int i11 = 0; i11 < 188; i11++) {
            int i12 = 0;
            while (true) {
                if (i12 == 5) {
                    interfaceC1234Bt.AGP(i11);
                    return true;
                }
                if (bArr[(i12 * 188) + i11] != 71) {
                    break;
                }
                i12++;
            }
        }
        return false;
    }
}
