package com.facebook.ads.redexgen.uinode;

import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X5 implements DB {
    public static byte[] A02;
    public static String[] A03 = {"W3zpeZwD9Fi1kBaR", "uMdULlbYt84VxY86rM0TiEJbhaqKcXZ1", "Usin4k2UYlEJmIUoIPMyl4MixoDpG9ii", "hBZpg4XSGRsBFeFqV0aqL6EoVOREEldE", "UimonN4w5kzXtUMO8SJw69s6gFNeuD2Z", "uuKAqm4Yer5CcRyJ", "zRTcmdaM3Tn4RRVoPrSr5tVrwuK6PMWw", "taTU185R1PVUiY2ntZzDAqagtcVNoAEE"};
    public final int A00;
    public final List<Format> A01;

    static {
        A02();
    }

    public X5() {
        this(0);
    }

    public X5(int i11) {
        this(i11, Collections.emptyList());
    }

    public X5(int i11, List<Format> list) {
        this.A00 = i11;
        if (!A03(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.A00(null, A01(0, 19, 66), 0, null));
        }
        this.A01 = list;
    }

    private D7 A00(DA da2) {
        String strA01;
        int i11;
        if (A03(32)) {
            return new D7(this.A01);
        }
        C1376Hz c1376Hz = new C1376Hz(da2.A03);
        List<Format> arrayList = this.A01;
        while (c1376Hz.A04() > 0) {
            int iA0E = c1376Hz.A0E();
            int iA06 = c1376Hz.A06() + c1376Hz.A0E();
            if (iA0E == 134) {
                arrayList = new ArrayList<>();
                int iA0E2 = c1376Hz.A0E() & 31;
                for (int i12 = 0; i12 < iA0E2; i12++) {
                    String strA0S = c1376Hz.A0S(3);
                    int iA0E3 = c1376Hz.A0E();
                    if ((iA0E3 & 128) != 0) {
                        strA01 = A01(19, 19, 101);
                        i11 = iA0E3 & 63;
                    } else {
                        strA01 = A01(0, 19, 66);
                        i11 = 1;
                    }
                    arrayList.add(Format.A08(null, strA01, null, -1, 0, strA0S, i11, null));
                    c1376Hz.A0Z(2);
                }
            }
            c1376Hz.A0Y(iA06);
        }
        return new D7(arrayList);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{Ascii.DLE, 1, 1, Ascii.GS, Ascii.CAN, Ascii.DC2, Ascii.DLE, 5, Ascii.CAN, Ascii.RS, Ascii.US, 94, Ascii.DC2, Ascii.DC4, Ascii.DLE, 92, 71, 65, 73, 55, 38, 38, 58, Utf8.REPLACEMENT_BYTE, 53, 55, 34, Utf8.REPLACEMENT_BYTE, 57, 56, 121, 53, 51, 55, 123, 97, 102, 110};
    }

    private boolean A03(int i11) {
        return (this.A00 & i11) != 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.DB
    public final SparseArray<DD> A4d() {
        return new SparseArray<>();
    }

    @Override // com.facebook.ads.redexgen.uinode.DB
    public final DD A4j(int i11, DA da2) {
        switch (i11) {
            case 2:
                return new C1752Ww(new X2());
            case 3:
            case 4:
                return new C1752Ww(new C1753Wx(da2.A01));
            case 15:
                if (A03(2)) {
                    return null;
                }
                return new C1752Ww(new X6(false, da2.A01));
            case 17:
                boolean zA03 = A03(2);
                String[] strArr = A03;
                if (strArr[4].charAt(2) == strArr[3].charAt(2)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A03;
                strArr2[2] = "Zsc3HcoanD4hgKlowrimr1mcCeCJ4aqm";
                strArr2[6] = "fbfbpCk06enibsJo0cAFVF7ae3oKLvDz";
                if (zA03) {
                    return null;
                }
                return new C1752Ww(new C1754Wy(da2.A01));
            case 21:
                return new C1752Ww(new C1755Wz());
            case 27:
                boolean zA04 = A03(4);
                String[] strArr3 = A03;
                if (strArr3[7].charAt(13) != strArr3[1].charAt(13)) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A03;
                strArr4[2] = "MnHqmUaQQZIE89AoLzdx0BMakHNAXRZh";
                strArr4[6] = "UBVzW5fdc0gZ9W3oa8if0wBLwl14wyCB";
                if (zA04) {
                    return null;
                }
                return new C1752Ww(new X1(A00(da2), A03(1), A03(8)));
            case 36:
                return new C1752Ww(new X0(A00(da2)));
            case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                return new C1752Ww(new X3(da2.A02));
            case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
            case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
                return new C1752Ww(new X9(da2.A01));
            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
            case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                return new C1752Ww(new X4(da2.A01));
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
                if (A03(16)) {
                    return null;
                }
                return new C1749Wt(new C1748Ws());
            default:
                return null;
        }
    }
}
