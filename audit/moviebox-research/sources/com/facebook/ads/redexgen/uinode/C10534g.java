package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4g, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10534g extends C8 {
    public static byte[] A05;
    public static String[] A06 = {"qvo0GMLMlCI9r2KvubgW", "xANfLU", "vfLxBByg2WxKhxozFOdEyd4oNWbI2yKZ", "M6AXkYe8VdVGq", "jqpt9kLQVEpjtzmdo0kCC28NolZOOofM", "wQfQ1ikODVE5", "8nxGlLt3aQnzE5X", "LzSrLgRmD2ZM4QoK2ANM"};
    public static final Pattern A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public final boolean A04;

    static {
        A03();
        A07 = Pattern.compile(A02(1, 35, 77));
    }

    public C10534g() {
        this(null);
    }

    public C10534g(List<byte[]> list) {
        super(A02(182, 10, 38));
        if (list == null || list.isEmpty()) {
            this.A04 = false;
            return;
        }
        this.A04 = true;
        String strA0Q = IF.A0Q(list.get(0));
        AbstractC1351Ha.A03(strA0Q.startsWith(A02(47, 8, 49)));
        A06(strA0Q);
        A04(new C1376Hz(list.get(1)));
    }

    public static long A00(String str) {
        Matcher matcher = A07.matcher(str);
        return !matcher.matches() ? C.TIME_UNSET : (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.C8
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final WF A0b(byte[] bArr, int i11, boolean z11) {
        ArrayList arrayList = new ArrayList();
        C1366Hp c1366Hp = new C1366Hp();
        C1376Hz c1376Hz = new C1376Hz(bArr, i11);
        if (!this.A04) {
            A04(c1376Hz);
        }
        A05(c1376Hz, arrayList, c1366Hp);
        C1314Fn[] c1314FnArr = new C1314Fn[arrayList.size()];
        arrayList.toArray(c1314FnArr);
        return new WF(c1314FnArr, c1366Hp.A05());
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{7, 81, 70, 67, 81, 37, Ascii.GS, 82, 80, 67, 80, 70, 81, 37, Ascii.GS, 82, 80, 67, 81, 37, Ascii.GS, 82, 80, 81, 70, 67, 67, 5, 37, 87, 80, 81, 37, Ascii.GS, 82, 80, 49, 108, 65, 73, 68, 71, 79, 93, 77, Ascii.DC2, 8, 67, 106, 119, 104, 100, 113, Utf8.REPLACEMENT_BYTE, 37, 76, 116, 118, 111, 111, 118, 113, 120, Utf8.REPLACEMENT_BYTE, 123, 118, 126, 115, 112, 120, 106, 122, Utf8.REPLACEMENT_BYTE, 115, 118, 113, 122, Utf8.REPLACEMENT_BYTE, 125, 122, 121, 112, 109, 122, Utf8.REPLACEMENT_BYTE, 124, 112, 114, 111, 115, 122, 107, 122, Utf8.REPLACEMENT_BYTE, 121, 112, 109, 114, 126, 107, 37, Utf8.REPLACEMENT_BYTE, 32, Ascii.CAN, Ascii.SUB, 3, 3, Ascii.SUB, Ascii.GS, Ascii.DC4, 83, Ascii.ETB, Ascii.SUB, Ascii.DC2, Ascii.US, Ascii.FS, Ascii.DC4, 6, Ascii.SYN, 83, Ascii.US, Ascii.SUB, Ascii.GS, Ascii.SYN, 83, 4, Ascii.SUB, 7, Ascii.ESC, 83, Ascii.NAK, Ascii.SYN, 4, Ascii.SYN, 1, 83, Ascii.DLE, Ascii.FS, Ascii.US, 6, Ascii.RS, Ascii.GS, 0, 83, 7, Ascii.ESC, Ascii.DC2, Ascii.GS, 83, Ascii.NAK, Ascii.FS, 1, Ascii.RS, Ascii.DC2, 7, 73, 83, 8, 48, 50, 43, 43, 50, 53, 60, 123, 50, 53, 45, 58, 55, 50, Utf8.REPLACEMENT_BYTE, 123, 47, 50, 54, 50, 53, 60, 97, 123, 65, 97, 115, 86, 119, 113, 125, 118, 119, 96, Ascii.SUB, 4, 55, 36, 47, 53, 50, Ascii.FS, 70, 70, 84, 90, 90, 104, 85, 114, 39, 35, 54, 85, 116, 110, 101, 111, 102, 97, 116, 103, 97, Ascii.DC2, 3, Ascii.RS, Ascii.DC2};
    }

    private void A04(C1376Hz c1376Hz) {
        String strA0P;
        do {
            strA0P = c1376Hz.A0P();
            if (strA0P == null) {
                return;
            }
        } while (!strA0P.startsWith(A02(PsExtractor.AUDIO_STREAM, 8, 117)));
    }

    private void A05(C1376Hz c1376Hz, List<C1314Fn> list, C1366Hp c1366Hp) {
        while (true) {
            String strA0P = c1376Hz.A0P();
            if (strA0P == null) {
                return;
            }
            if (!this.A04 && strA0P.startsWith(A02(47, 8, 49))) {
                A06(strA0P);
            } else if (strA0P.startsWith(A02(37, 10, 28))) {
                A07(strA0P, list, c1366Hp);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0040  */
    private void A06(String str) {
        String[] strArrSplit = TextUtils.split(str.substring(A02(47, 8, 49).length()), A02(36, 1, 41));
        this.A01 = strArrSplit.length;
        this.A02 = -1;
        this.A00 = -1;
        this.A03 = -1;
        int i11 = 0;
        while (true) {
            byte b11 = 0;
            if (i11 >= this.A01) {
                if (this.A02 == -1 || this.A00 == -1 || this.A03 == -1) {
                    this.A01 = 0;
                    return;
                }
                return;
            }
            String strA0M = IF.A0M(strArrSplit[i11].trim());
            switch (strA0M.hashCode()) {
                case 100571:
                    if (!strA0M.equals(A02(213, 3, 63))) {
                        b11 = -1;
                    } else {
                        b11 = 1;
                    }
                    break;
                case 3556653:
                    if (!strA0M.equals(A02(221, 4, 82))) {
                        b11 = -1;
                    } else {
                        b11 = 2;
                    }
                    break;
                case 109757538:
                    if (!strA0M.equals(A02(216, 5, 33))) {
                        b11 = -1;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            switch (b11) {
                case 0:
                    this.A02 = i11;
                    break;
                case 1:
                    this.A00 = i11;
                    break;
                case 2:
                    this.A03 = i11;
                    break;
            }
            i11++;
        }
    }

    private void A07(String str, List<C1314Fn> list, C1366Hp c1366Hp) {
        int i11 = this.A01;
        String strA02 = A02(182, 10, 38);
        if (i11 == 0) {
            Log.w(strA02, A02(55, 47, 43) + str);
            return;
        }
        String[] strArrSplit = str.substring(A02(37, 10, 28).length()).split(A02(36, 1, 41), this.A01);
        if (strArrSplit.length != this.A01) {
            Log.w(strA02, A02(102, 55, 71) + str);
            return;
        }
        long jA00 = A00(strArrSplit[this.A02]);
        String strA03 = A02(157, 25, 111);
        if (jA00 == C.TIME_UNSET) {
            Log.w(strA02, strA03 + str);
            return;
        }
        long jA01 = C.TIME_UNSET;
        String str2 = strArrSplit[this.A00];
        if (!str2.trim().isEmpty()) {
            jA01 = A00(str2);
            if (jA01 == C.TIME_UNSET) {
                Log.w(strA02, strA03 + str);
                return;
            }
        }
        String strReplaceAll = strArrSplit[this.A03].replaceAll(A02(206, 7, 61), A02(0, 0, 97));
        String strA04 = A02(200, 3, 46);
        String strA05 = A02(0, 1, 57);
        list.add(new C1314Fn(strReplaceAll.replaceAll(strA04, strA05).replaceAll(A02(203, 3, 50), strA05)));
        c1366Hp.A04(jA00);
        if (jA01 != C.TIME_UNSET) {
            list.add(null);
            String[] strArr = A06;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[3] = "QluocDWeuHRDa";
            strArr2[6] = "JZgOBObbaiMn4tK";
            c1366Hp.A04(jA01);
        }
    }
}
