package com.facebook.ads.redexgen.uinode;

import android.os.Process;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.80, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass80 implements Thread.UncaughtExceptionHandler {
    public static byte[] A04;
    public final C1794Ym A00;
    public final AnonymousClass87 A01;
    public final Thread.UncaughtExceptionHandler A02;
    public final Map<String, String> A03;

    static {
        A01();
    }

    public AnonymousClass80(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C1794Ym c1794Ym, InterfaceC11387z interfaceC11387z) {
        this(uncaughtExceptionHandler, c1794Ym, interfaceC11387z, AnonymousClass88.A00());
    }

    public AnonymousClass80(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C1794Ym c1794Ym, InterfaceC11387z interfaceC11387z, AnonymousClass87 anonymousClass87) {
        this.A02 = uncaughtExceptionHandler;
        if (c1794Ym == null) {
            throw new IllegalArgumentException(A00(2, 15, 82));
        }
        this.A00 = c1794Ym;
        this.A03 = interfaceC11387z.A7z(c1794Ym);
        this.A01 = anonymousClass87;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{42, Ascii.FS, 94, 122, 96, 96, 122, 125, 116, 51, 80, 124, 125, 103, 118, 107, 103, Ascii.VT, 7, 5, 70, Ascii.SO, 9, Ascii.VT, Ascii.CR, 10, 7, 7, 3, 70, 9, Ascii.FF, Ascii.ESC, 71, 86, 69, 87, 76, Ascii.DC4, Ascii.DC2, 5, 19, Ascii.RS, Ascii.ETB, 2, 80, 86, 65, 87, 90, 83, 70, 124, 64, 76, 71, 70};
    }

    public static void A02() {
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
        try {
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }

    private void A03(Thread thread, Throwable th2) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.A02;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        } else {
            A02();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th2) {
        try {
            String strA03 = LW.A03(this.A00, th2);
            if (!TextUtils.isEmpty(strA03) && strA03.contains(A00(17, 16, 41))) {
                Map<String, String> mapA02 = new C11377y(strA03, this.A03).A02();
                mapA02.put(A00(38, 7, 38), A00(33, 5, 101));
                Throwable thA00 = KG.A00();
                String strA00 = A00(45, 12, 98);
                if (thA00 == th2) {
                    mapA02.put(strA00, A00(1, 1, 108));
                } else {
                    mapA02.put(strA00, A00(0, 1, 91));
                }
                this.A01.AHF(new C8E(this.A00.A08().A01(), this.A00.A08().A02(), mapA02), this.A00);
                if (C1384Ih.A1h(this.A00)) {
                    C1384Ih.A0a(this.A00);
                }
            }
        } catch (Exception unused) {
        }
        A03(thread, th2);
    }
}
