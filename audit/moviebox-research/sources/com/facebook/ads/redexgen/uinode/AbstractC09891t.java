package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC09891t {
    public static byte[] A00;
    public static String[] A01 = {"SZD1gnuwYC0ZDT5XCpN5wGg04vpvlXtv", "38Pkme0hctlwOycqXgIFmSt4EwGMsPu", "PZ5YSJhnqoOlFoXIJ", "MKZOkal4amZt32sY0duMnYWyMVrdvNv7", "PmMqC", "MtvBWYcgrX5nN2Ecp9gb0xGXALHF8kJ8", "836OSMulKGxVhnpon", "Ud77gBKi5ZcurXFgX0oEk2YfAMQgAhDP"};

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Ascii.EM, 95, 67, 90, 91, 103, 96, 122, 107, 124, 125, 122, 103, 122, 103, 111, 98, 3, Ascii.DC4, 6, Ascii.DLE, 3, Ascii.NAK, Ascii.DC4, Ascii.NAK, 46, 7, Ascii.CAN, Ascii.NAK, Ascii.DC4, Ascii.RS};
    }

    public static void A02(C1795Yn c1795Yn, C11006c c11006c, FS fs2) {
        c11006c.A0c(new C10986a(fs2.A10().A01(), C1566Po.A04, C1566Po.A04, fs2.A0S(), A00(17, 14, 99)));
        boolean zA0m = fs2.A0m();
        if (zA0m) {
            C6Y c6y = new C6Y(fs2.A0M(), fs2.A0S(), A00(17, 14, 99));
            c6y.A04 = true;
            c6y.A03 = A00(0, 5, 37);
            c11006c.A0X(c6y);
        }
        boolean zA2R = C1384Ih.A2R(c1795Yn, C1600Qw.A03());
        C6Y c6y2 = new C6Y(fs2.A0x().A0D().A08(), fs2.A0S(), A00(17, 14, 99), fs2.A0x().A0D().A05());
        if (!zA0m || zA2R) {
            c11006c.A0a(c6y2);
        } else {
            c11006c.A0X(c6y2);
        }
        c11006c.A0c(new C10986a(fs2.A0x().A0D().A07(), AbstractC09841o.A00(fs2.A0x().A0D()), AbstractC09841o.A01(fs2.A0x().A0D()), fs2.A0S(), A00(17, 14, 99)));
        Iterator<String> it = fs2.A0x().A0G().A01().iterator();
        while (it.hasNext()) {
            c11006c.A0c(new C10986a(it.next(), -1, -1, fs2.A0S(), A00(17, 14, 99)));
        }
    }

    public static void A03(C1795Yn c1795Yn, C11006c c11006c, FS fs2) {
        int i11 = 0;
        for (C1G c1g : fs2.A14()) {
            C10986a c10986a = new C10986a(c1g.A0D().A07(), AbstractC09841o.A00(c1g.A0D()), AbstractC09841o.A01(c1g.A0D()), fs2.A0S(), A00(5, 12, 28));
            if (i11 == 0) {
                c11006c.A0b(c10986a);
            } else {
                c11006c.A0c(c10986a);
            }
            Iterator<String> it = c1g.A0G().A01().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                String[] strArr = A01;
                if (strArr[2].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[0] = "d4OGgqInyGax2uUwuJ6rocUy9OK0g6RJ";
                strArr2[7] = "8ZRzgNChvbJeQD0ONiajCC1PQNrhJWUQ";
                if (zHasNext) {
                    c11006c.A0c(new C10986a(it.next(), -1, -1, fs2.A0S(), A00(5, 12, 28)));
                }
            }
            if (!TextUtils.isEmpty(c1g.A0D().A08())) {
                new C6Y(c1g.A0D().A08(), fs2.A0S(), A00(5, 12, 28), c1g.A0D().A05()).A04 = false;
            }
            i11++;
        }
    }
}
