package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class HQ {
    public static String[] A00 = {"QVkvGuTrNYCOXAoNAePTggpZ9p9y8rjH", "Ru98bprrD7b3UUfLrlKs", "", "dJgVNsDePsDRNqW", "8CeCwhAARX5BeZctdCHITAez339E1kKv", "TdcchyCe9I3Btqth6iKX4VQ7acLjRTHE", "dxVA2OdEqxN0v6bZFx4Cf7LzvY6ZoBAr", "aJerxmZYtdmBHI5cIDnwKt2ezc6XXR2j"};

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x009e: INVOKE (r3 I:com.facebook.ads.redexgen.X.Gu) STATIC call: com.facebook.ads.redexgen.X.IF.A0W(com.facebook.ads.redexgen.X.Gu):void A[MD:(com.facebook.ads.redexgen.X.Gu):void (m)], block:B:37:0x009e */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00ae: INVOKE (r3 I:com.facebook.ads.redexgen.X.Gu) STATIC call: com.facebook.ads.redexgen.X.IF.A0W(com.facebook.ads.redexgen.X.Gu):void A[MD:(com.facebook.ads.redexgen.X.Gu):void (m)], block:B:43:0x00ae */
    public static long A00(C1350Gy c1350Gy, long j11, long j12, InterfaceC1346Gu interfaceC1346Gu, byte[] bArr, I3 i11, int i12, HP hp2) throws InterruptedException, IOException {
        InterfaceC1346Gu interfaceC1346GuA0W;
        InterfaceC1346Gu interfaceC1346GuA0W2;
        while (true) {
            if (i11 != null) {
                i11.A01(i12);
            }
            try {
                break;
            } catch (I2 unused) {
                IF.A0W(interfaceC1346GuA0W2);
            } catch (Throwable th2) {
                IF.A0W(interfaceC1346GuA0W);
                throw th2;
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        C1350Gy c1350Gy2 = new C1350Gy(c1350Gy.A04, c1350Gy.A06, j11, (c1350Gy.A03 + j11) - c1350Gy.A01, -1L, c1350Gy.A05, c1350Gy.A00 | 2);
        long jADl = interfaceC1346Gu.ADl(c1350Gy2);
        if (hp2.A01 == -1 && jADl != -1) {
            hp2.A01 = c1350Gy2.A01 + jADl;
        }
        long j13 = 0;
        while (j13 != j12) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int i13 = interfaceC1346Gu.read(bArr, 0, j12 != -1 ? (int) Math.min(bArr.length, j12 - j13) : bArr.length);
            if (A00[3].length() != 15) {
                throw new RuntimeException();
            }
            A00[1] = "Mr4dmhY4u";
            if (i13 == -1) {
                if (hp2.A01 != -1) {
                    break;
                }
                hp2.A01 = c1350Gy2.A01 + j13;
                break;
            }
            j13 += (long) i13;
            hp2.A02 += (long) i13;
        }
        IF.A0W(interfaceC1346Gu);
        return j13;
    }

    public static String A01(Uri uri) {
        return uri.toString();
    }

    public static String A02(C1350Gy c1350Gy) {
        if (c1350Gy.A05 != null) {
            return c1350Gy.A05;
        }
        Uri uri = c1350Gy.A04;
        if (A00[0].charAt(11) != 'O') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[5] = "cu8QQJDviMrw4mI2sOy5Vu7yKrvbPHoQ";
        strArr[7] = "0ihZqD29ZbZOvC3sCo5KdBScvHoXIGQ7";
        return A01(uri);
    }

    public static void A03(C1350Gy c1350Gy, HK hk2, C1717Vk c1717Vk, byte[] bArr, I3 i11, int i12, HP hp2, AtomicBoolean atomicBoolean, boolean z11) throws InterruptedException, IOException {
        HP hp3 = hp2;
        AbstractC1351Ha.A01(c1717Vk);
        AbstractC1351Ha.A01(bArr);
        if (hp3 != null) {
            A04(c1350Gy, hk2, hp3);
        } else {
            hp3 = new HP();
        }
        String strA02 = A02(c1350Gy);
        long j11 = c1350Gy.A01;
        long jA6W = c1350Gy.A02 != -1 ? c1350Gy.A02 : hk2.A6W(strA02);
        while (true) {
            long j12 = 0;
            if (jA6W == 0) {
                return;
            }
            if (atomicBoolean != null && atomicBoolean.get()) {
                throw new InterruptedException();
            }
            long jA6G = hk2.A6G(strA02, j11, jA6W != -1 ? jA6W : Long.MAX_VALUE);
            if (jA6G <= 0) {
                long j13 = -jA6G;
                jA6G = j13;
                if (A00(c1350Gy, j11, j13, c1717Vk, bArr, i11, i12, hp3) < jA6G) {
                    if (z11 && jA6W != -1) {
                        throw new EOFException();
                    }
                    return;
                }
            }
            j11 += jA6G;
            if (jA6W != -1) {
                j12 = jA6G;
            }
            jA6W -= j12;
        }
    }

    public static void A04(C1350Gy c1350Gy, HK hk2, HP hp2) {
        String strA02 = A02(c1350Gy);
        long j11 = c1350Gy.A01;
        long jA6W = c1350Gy.A02 != -1 ? c1350Gy.A02 : hk2.A6W(strA02);
        hp2.A01 = jA6W;
        hp2.A00 = 0L;
        hp2.A02 = 0L;
        while (jA6W != 0) {
            long jA6G = hk2.A6G(strA02, j11, jA6W != -1 ? jA6W : Long.MAX_VALUE);
            if (jA6G > 0) {
                hp2.A00 += jA6G;
            } else {
                jA6G = -jA6G;
                if (jA6G == Long.MAX_VALUE) {
                    return;
                }
            }
            j11 += jA6G;
            if (jA6W == -1) {
                jA6G = 0;
            }
            jA6W -= jA6G;
        }
    }

    public static void A05(HK hk2, String str) {
        Iterator<HO> it = hk2.A6H(str).iterator();
        while (it.hasNext()) {
            try {
                hk2.AF9(it.next());
            } catch (HI unused) {
            }
        }
    }
}
