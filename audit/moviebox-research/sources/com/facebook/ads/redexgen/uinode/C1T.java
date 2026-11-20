package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1T, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1T {
    public static int A06;
    public static byte[] A07;
    public static String[] A08 = {"Du56ltgKKs1OVAX5", "GkTmjkH3MPiTFcKSZdtZeP", "KEGdoxZZnAdDUnYCV96i9ePmYlw0nVcs", "eeVVi2jaa6aVR", "fQADRcl3z4I9sbyUvoxt9O6e4jXdGtkI", "3SSpimwT8orOGywmbz8JxKLw4xXAqR", "PizR3LI8tsUKIk44MqfkEczppTSirtIQ", "PpMlGdJ0WRh5qmood9xHloOk"};
    public int A00;
    public int A01;
    public long A03;
    public String A04;
    public int A02 = 0;
    public LinkedList<Integer> A05 = new LinkedList<>();

    static {
        A03();
        A06 = 50;
    }

    public C1T(String str) {
        this.A04 = str;
    }

    public static int A00() {
        return A06;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 106);
        }
        return new String(bArrCopyOfRange);
    }

    private void A02() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        while (!this.A05.isEmpty() && this.A05.peekFirst() != null && jCurrentTimeMillis - ((long) this.A05.peekFirst().intValue()) >= this.A00) {
            this.A05.removeFirst();
        }
    }

    public static void A03() {
        A07 = new byte[]{70, Ascii.ESC, Ascii.FF, 109, 60, 8, Ascii.US, Ascii.VT, Ascii.SI, Ascii.US, Ascii.DC4, Ascii.EM, 3, 90, 57, Ascii.ESC, 10, 10, 19, Ascii.DC4, Ascii.GS, 90, 62, Ascii.ESC, Ascii.SO, Ascii.ESC, 64, 90, Ascii.DC4, Ascii.NAK, Ascii.DC4, Ascii.US, 90, 51, Ascii.DC4, Ascii.SO, Ascii.US, Ascii.GS, Ascii.US, 8, 90, Ascii.NAK, Ascii.EM, Ascii.EM, Ascii.SI, 8, 8, Ascii.US, Ascii.DC4, Ascii.EM, Ascii.US, 1, Ascii.VT, 9, Ascii.CAN, 53, 62, 51, 34, 41, 32, 36, 53, 52, Ascii.SI, 57, 52, 53, 57, 32, 7, 59, 57, 40, 40, 61, 60, 7, 57, 42, 42, 57, 33, 7, 52, 61, 54, Utf8.REPLACEMENT_BYTE, 44, 48, 104, 100, 100, 114, 117, 117, 98, 105, 100, 98, 116, 49, 36, 51, 40, 46, 37, 102, 113, 107, 106, 65, 113, 125, 125, 107, 108, 108, 123, 112, 125, 123, 65, 109, 123, 125, 109, 33, 54, 44, 45, 6, 41, 60, 43, 48, 54, 61, Ascii.GS, 5};
    }

    public final void A04(int i11) {
        this.A02 = i11;
    }

    public final void A05(int i11, int i12, long j11, int i13) {
        this.A00 = i11;
        this.A01 = i12;
        this.A03 = j11;
        A06 = i13;
    }

    public final void A06(JSONArray jSONArray) throws JSONException {
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            if (!(jSONArray.get(i11) instanceof Integer)) {
                throw new JSONException(A01(4, 47, 16));
            }
            this.A05.addLast((Integer) jSONArray.get(i11));
        }
    }

    public final void A07(boolean z11) {
        if (z11) {
            this.A05.addLast(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        }
        A02();
    }

    public final boolean A08() {
        return ((long) this.A05.size()) >= this.A03;
    }

    public final boolean A09() {
        return (System.currentTimeMillis() / 1000) - ((long) this.A02) <= ((long) this.A01);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(A01(TsExtractor.TS_STREAM_TYPE_DTS, 1, 12));
        sb2.append(A01(55, 12, 58));
        String strA01 = A01(1, 1, 75);
        sb2.append(strA01);
        sb2.append(this.A04);
        String strA02 = A01(0, 1, 0);
        sb2.append(strA02);
        sb2.append(A01(101, 6, 43));
        sb2.append(strA01);
        sb2.append(this.A00);
        sb2.append(strA02);
        sb2.append(A01(127, 11, 51));
        sb2.append(strA01);
        sb2.append(this.A01);
        sb2.append(strA02);
        sb2.append(A01(52, 3, 2));
        sb2.append(strA01);
        sb2.append(this.A03);
        sb2.append(strA02);
        sb2.append(A01(107, 20, 116));
        sb2.append(strA01);
        sb2.append(this.A02);
        sb2.append(strA02);
        sb2.append(A01(67, 23, 50));
        sb2.append(strA01);
        sb2.append(A06);
        sb2.append(strA02);
        sb2.append(A01(90, 11, 109));
        sb2.append(A01(2, 2, 92));
        Iterator<Integer> it = this.A05.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A08[1].length() != 22) {
                throw new RuntimeException();
            }
            A08[7] = "ktnl640oaPGPfDqOI7";
            if (!zHasNext) {
                sb2.append(A01(51, 1, 54));
                sb2.append(A01(139, 1, 18));
                return sb2.toString();
            }
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(strA02);
            }
        }
    }
}
