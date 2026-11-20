package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.dto.AdCookieData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Utf8;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8T, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8T {
    public static byte[] A0F;
    public static final AdPlacementType A0G;
    public static final String A0H;
    public int A00;
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
    public AdPlacementType A0B;
    public boolean A0D;
    public List<AdCookieData> A0C = null;
    public final long A0E = System.currentTimeMillis();

    static {
        A02();
        A0H = C8T.class.getSimpleName();
        A0G = AdPlacementType.UNKNOWN;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0056  */
    public C8T(Map<String, String> map) {
        byte b11;
        this.A01 = -1;
        this.A00 = -1;
        this.A0B = A0G;
        this.A03 = 1;
        this.A0A = 0;
        this.A04 = 0;
        this.A05 = 20;
        this.A08 = 0;
        this.A09 = 1000;
        this.A06 = 10000;
        this.A07 = 200;
        this.A02 = 3600;
        this.A0D = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            switch (key.hashCode()) {
                case -1561601017:
                    if (key.equals(A01(105, 17, 70))) {
                        b11 = 4;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -856794442:
                    if (key.equals(A01(199, 26, 64))) {
                        b11 = 10;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -726276175:
                    if (key.equals(A01(122, 15, 35))) {
                        b11 = Ascii.VT;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -634541425:
                    if (key.equals(A01(9, 32, 87))) {
                        b11 = 5;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -553208868:
                    if (key.equals(A01(0, 9, 102))) {
                        b11 = 6;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 3575610:
                    if (key.equals(A01(137, 4, 17))) {
                        b11 = 0;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 700812481:
                    if (key.equals(A01(41, 26, 72))) {
                        b11 = 1;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 858630459:
                    if (key.equals(A01(225, 24, 94))) {
                        b11 = 2;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 986744879:
                    if (key.equals(A01(141, 27, 73))) {
                        b11 = Ascii.FF;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 1085444827:
                    if (key.equals(A01(98, 7, 62))) {
                        b11 = 3;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 1183549815:
                    if (key.equals(A01(168, 31, 73))) {
                        b11 = 9;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 1503616961:
                    if (key.equals(A01(67, 16, 3))) {
                        b11 = 8;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 2002133996:
                    if (key.equals(A01(83, 15, 59))) {
                        b11 = 7;
                    } else {
                        b11 = -1;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            switch (b11) {
                case 0:
                    this.A0B = AdPlacementType.fromString(entry.getValue());
                    break;
                case 1:
                    this.A03 = Integer.parseInt(entry.getValue());
                    break;
                case 2:
                    this.A0A = Integer.parseInt(entry.getValue());
                    break;
                case 3:
                    this.A04 = Integer.parseInt(entry.getValue());
                    break;
                case 4:
                    this.A05 = Integer.parseInt(entry.getValue());
                    break;
                case 5:
                    this.A02 = Integer.parseInt(entry.getValue());
                    break;
                case 6:
                    this.A0D = Boolean.valueOf(entry.getValue()).booleanValue();
                    break;
                case 7:
                    this.A01 = Integer.parseInt(entry.getValue());
                    break;
                case 8:
                    this.A00 = Integer.parseInt(entry.getValue());
                    break;
                case 9:
                    this.A08 = Integer.parseInt(entry.getValue());
                    break;
                case 10:
                    this.A09 = Integer.parseInt(entry.getValue());
                    break;
                case 11:
                    this.A06 = Integer.parseInt(entry.getValue());
                    break;
                case 12:
                    try {
                        this.A07 = Integer.parseInt(entry.getValue());
                    } catch (NumberFormatException unused) {
                        this.A07 = 200;
                    }
                    break;
            }
        }
    }

    public static C8T A00(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        HashMap map = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, String.valueOf(jSONObject.opt(next)));
        }
        return new C8T(map);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 114);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0F = new byte[]{119, 117, 119, 124, 113, 117, 118, 120, 113, 76, 75, 83, 68, 73, 76, 65, 68, 81, 76, 74, 75, 122, 65, 80, 87, 68, 81, 76, 74, 75, 122, 76, 75, 122, 86, 64, 70, 74, 75, 65, 86, 87, 83, 84, 101, 76, 83, 95, 77, 91, 88, 83, 86, 83, 78, 67, 101, 74, 95, 72, 89, 95, 84, 78, 91, 93, 95, 1, Ascii.GS, Ascii.DLE, Ascii.DC2, Ascii.DC4, Ascii.FS, Ascii.DC4, Ascii.US, 5, 46, Ascii.EM, Ascii.DC4, Ascii.CAN, Ascii.SYN, Ascii.EM, 5, 57, 37, 40, 42, 44, 36, 44, 39, 61, Ascii.SYN, 62, 32, 45, 61, 33, 62, 41, 42, 62, 41, Utf8.REPLACEMENT_BYTE, 36, 70, 81, 82, 70, 81, 71, 92, 107, 64, 92, 70, 81, 71, 92, 91, 88, 80, 35, 52, 32, 36, 52, 34, 37, Ascii.SO, 37, 56, 60, 52, 62, 36, 37, Ascii.ETB, Ascii.SUB, 19, 6, 77, 82, 95, 94, 84, 100, 79, 82, 86, 94, 100, 75, 84, 87, 87, 82, 85, 92, 100, 82, 85, 79, 94, 73, 77, 90, 87, 77, 82, 94, 76, 90, 89, 82, 87, 82, 79, 66, 100, 88, 83, 94, 88, 80, 100, 82, 85, 82, 79, 82, 90, 87, 100, 95, 94, 87, 90, 66, 68, 91, 87, 69, 83, 80, 91, 94, 91, 70, 75, 109, 81, 90, 87, 81, 89, 109, 91, 92, 70, 87, 64, 68, 83, 94, 90, 69, 73, 91, 77, 78, 69, 64, 69, 88, 85, 115, 79, 68, 73, 79, 71, 115, 88, 69, 79, 71, 73, 94};
    }

    public final int A03() {
        return this.A02 * 1000;
    }

    public final int A04() {
        return this.A03;
    }

    public final int A05() {
        return this.A06;
    }

    public final int A06() {
        return this.A07;
    }

    public final int A07() {
        return this.A08;
    }

    public final int A08() {
        return this.A09;
    }

    public final int A09() {
        return this.A0A;
    }

    public final long A0A() {
        return this.A04 * 1000;
    }

    public final long A0B() {
        return this.A05 * 1000;
    }

    public final long A0C() {
        return this.A0E;
    }

    public final AdPlacementType A0D() {
        return this.A0B;
    }

    public final boolean A0E() {
        return this.A0D;
    }
}
