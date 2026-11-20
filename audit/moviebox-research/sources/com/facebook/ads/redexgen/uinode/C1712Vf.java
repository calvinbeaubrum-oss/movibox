package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1712Vf extends HO {
    public static byte[] A00;
    public static final Pattern A01;
    public static final Pattern A02;
    public static final Pattern A03;

    static {
        A07();
        A01 = Pattern.compile(A06(8, 29, 57), 32);
        A02 = Pattern.compile(A06(37, 29, 60), 32);
        A03 = Pattern.compile(A06(66, 30, 46), 32);
    }

    public C1712Vf(String str, long j11, long j12, long j13, File file) {
        super(str, j11, j12, j13, file);
    }

    public static C1712Vf A00(File file, HS hs2) {
        String name = file.getName();
        if (!name.endsWith(A06(1, 7, 12))) {
            file = A05(file, hs2);
            if (file == null) {
                return null;
            }
            name = file.getName();
        }
        Matcher matcher = A03.matcher(name);
        if (!matcher.matches()) {
            return null;
        }
        long length = file.length();
        String strA0C = hs2.A0C(Integer.parseInt(matcher.group(1)));
        if (strA0C == null) {
            return null;
        }
        return new C1712Vf(strA0C, Long.parseLong(matcher.group(2)), length, Long.parseLong(matcher.group(3)), file);
    }

    public static C1712Vf A01(String str, long j11) {
        return new C1712Vf(str, j11, -1L, C.TIME_UNSET, null);
    }

    public static C1712Vf A02(String str, long j11) {
        return new C1712Vf(str, j11, -1L, C.TIME_UNSET, null);
    }

    public static C1712Vf A03(String str, long j11, long j12) {
        return new C1712Vf(str, j11, j12, C.TIME_UNSET, null);
    }

    public static File A04(File file, int i11, long j11, long j12) {
        StringBuilder sbAppend = new StringBuilder().append(i11);
        String strA06 = A06(0, 1, 9);
        return new File(file, sbAppend.append(strA06).append(j11).append(strA06).append(j12).append(A06(1, 7, 12)).toString());
    }

    public static File A05(File file, HS hs2) {
        String strGroup;
        String name = file.getName();
        Matcher matcher = A02.matcher(name);
        if (matcher.matches()) {
            strGroup = IF.A0O(matcher.group(1));
            if (strGroup == null) {
                return null;
            }
        } else {
            matcher = A01.matcher(name);
            if (!matcher.matches()) {
                return null;
            }
            strGroup = matcher.group(1);
        }
        File fileA04 = A04(file.getParentFile(), hs2.A08(strGroup), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
        if (file.renameTo(fileA04)) {
            return fileA04;
        }
        return null;
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{64, 67, -117, 72, 67, 122, -115, -124, -96, 106, 112, 109, 107, -98, 112, 106, -98, -90, 109, 107, -98, 112, 106, -98, -90, 109, 107, -98, 112, -72, 115, -98, 112, -89, -70, -79, 102, -93, 109, 115, 112, 110, -95, 115, 109, -95, -87, 112, 110, -95, 115, 109, -95, -87, 112, 110, -95, 115, -69, 119, -95, 115, -86, -67, -76, 105, -107, 95, -109, -101, 98, 96, -109, 101, 95, -109, -101, 98, 96, -109, 101, 95, -109, -101, 98, 96, -109, 101, -83, 106, -109, 101, -100, -81, -90, 91};
    }

    public final C1712Vf A08(int i11) {
        AbstractC1351Ha.A04(this.A05);
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new C1712Vf(this.A04, this.A02, this.A01, jCurrentTimeMillis, A04(this.A03.getParentFile(), i11, this.A02, jCurrentTimeMillis));
    }
}
