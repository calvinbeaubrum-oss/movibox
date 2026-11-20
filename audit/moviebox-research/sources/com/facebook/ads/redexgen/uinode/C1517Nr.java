package com.facebook.ads.redexgen.uinode;

import android.content.ActivityNotFoundException;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Map;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1517Nr {
    public static long A0C;
    public static byte[] A0D;
    public static String[] A0E = {"Dlx9HUQ", "3SJpPR4POSYtfyo20zogCoACzZ0TFz6K", "kjKhSI2oz7rhTngoHOUaCo24OHJZbpIQ", "a4Zk7jMDxn", "WU0c1Yk7xIFA3rTFxMg", "", "SjppttcIPjZ3F", "aZkh9z8pdJw1o0Uivju"};
    public AbstractC1898b5 A00;
    public InterfaceC1516Nq A01;
    public OG A02;
    public boolean A03;
    public boolean A04;
    public final C1U A05;
    public final C1795Yn A06;
    public final J2 A07;
    public final C1454Lg A08;
    public final MC A09;
    public final RE A0A;
    public final String A0B;

    static {
        A01();
        A0C = 0L;
    }

    public C1517Nr(C1795Yn c1795Yn, String str, RE re2, C1454Lg c1454Lg, J2 j11, C1U c1u) {
        this(c1795Yn, str, re2, c1454Lg, j11, c1u, new C1668Tm());
    }

    public C1517Nr(C1795Yn c1795Yn, String str, RE re2, C1454Lg c1454Lg, J2 j11, C1U c1u, MC mc2) {
        this.A03 = true;
        this.A06 = c1795Yn;
        this.A0B = str;
        this.A0A = re2;
        this.A08 = c1454Lg;
        this.A07 = j11;
        this.A05 = c1u;
        this.A09 = mc2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0D = new byte[]{Ascii.US, 8, Ascii.GS, Ascii.RS, 41, 40, 40, 51, 50, Ascii.US, 48, 53, Utf8.REPLACEMENT_BYTE, 55, Ascii.DLE, 53, 47, 40, 57, 50, 57, 46, 114, 69, 69, 88, 69, Ascii.ETB, 82, 79, 82, 84, 66, 67, 94, 89, 80, Ascii.ETB, 86, 84, 67, 94, 88, 89, 73, 126, 126, 99, 126, 44, 123, 100, 101, 96, 105, 44, 99, 124, 105, 98, 101, 98, 107, 44};
    }

    private void A02(String str, String str2, Map<String, String> map) {
        String strA00 = A00(0, 22, 52);
        try {
            AbstractC1462Lo.A0Z(map, this.A00);
            AbstractC09520h abstractC09520hA01 = C09530i.A01(this.A06, this.A07, str, AbstractC1446Ky.A00(str2), new C1508Ni(map).A03(this.A0A).A02(this.A08).A05(), this.A03, this.A04, this.A05);
            if (abstractC09520hA01 instanceof C1309Fg) {
                ((C1309Fg) abstractC09520hA01).A0H(this.A02);
            }
            EnumC09510g enumC09510gA0C = EnumC09510g.A08;
            if (abstractC09520hA01 != null) {
                enumC09510gA0C = abstractC09520hA01.A0C();
            }
            if ((((abstractC09520hA01 instanceof C1307Fe) || (abstractC09520hA01 instanceof C1309Fg)) && AbstractC1462Lo.A0e(this.A06, enumC09510gA0C, map)) || enumC09510gA0C == EnumC09510g.A05) {
                return;
            }
            InterfaceC1516Nq interfaceC1516Nq = this.A01;
            if (interfaceC1516Nq != null) {
                interfaceC1516Nq.ABE();
            }
            this.A09.A43(this.A0B);
        } catch (ActivityNotFoundException e11) {
            Log.e(strA00, A00(44, 20, 100) + str2, e11);
        } catch (Exception e12) {
            Log.e(strA00, A00(22, 22, 95), e12);
        }
    }

    public static boolean A03(C1795Yn c1795Yn) {
        boolean zA2N = C1384Ih.A2N(c1795Yn);
        int iA06 = C1384Ih.A06(c1795Yn);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = A0C;
        long j12 = jCurrentTimeMillis - j11;
        if (zA2N) {
            String[] strArr = A0E;
            if (strArr[0].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[7] = "iHhMWVvnkjnFrqYtRUL";
            strArr2[4] = "26cGs68neeVahMKc5kl";
            if (j11 > 0 && j12 < iA06) {
                return true;
            }
        }
        A0C = System.currentTimeMillis();
        return false;
    }

    public final void A04(AbstractC1898b5 abstractC1898b5) {
        this.A00 = abstractC1898b5;
    }

    public final void A05(InterfaceC1516Nq interfaceC1516Nq) {
        this.A01 = interfaceC1516Nq;
    }

    public final void A06(OG og2) {
        this.A02 = og2;
    }

    public final void A07(String str, String str2, Map<String, String> map) {
        new JA(str, this.A07).A04(J9.A0J, map);
        if (this.A08.A09(this.A06)) {
            this.A07.A9W(str, map);
        } else {
            A02(str, str2, map);
        }
    }

    public final void A08(boolean z11) {
        this.A04 = z11;
    }
}
