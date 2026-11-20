package com.facebook.ads.redexgen.uinode;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GB {
    public static byte[] A0B;
    public static String[] A0C = {"Hmn5H7dKMosREh7xDGtPQt", "MVFk1kMfS5SlcrGDFoR78llsa87kBULK", "h0eABJsxuPyKyti7S1", "4r", "Rhyi3ngCGHQeUf1AOTuidE5Gtet8RupN", "ehbUKYCtrZOQmz5rtd9aLf3tehAVerO2", "Bs", "nZrAaS4dU3xOh9dXHIvavDKiiL"};
    public List<GB> A00;
    public final long A01;
    public final long A02;
    public final GH A03;
    public final String A04;
    public final String A05;
    public final String A06;
    public final boolean A07;
    public final HashMap<String, Integer> A08;
    public final HashMap<String, Integer> A09;
    public final String[] A0A;

    static {
        A07();
    }

    public GB(String str, String str2, long j11, long j12, GH gh2, String[] strArr, String str3) {
        this.A05 = str;
        this.A06 = str2;
        this.A03 = gh2;
        this.A0A = strArr;
        this.A07 = str2 != null;
        this.A02 = j11;
        this.A01 = j12;
        this.A04 = (String) AbstractC1351Ha.A01(str3);
        this.A09 = new HashMap<>();
        this.A08 = new HashMap<>();
    }

    private final int A00() {
        List<GB> list = this.A00;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private SpannableStringBuilder A01(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (spannableStringBuilder.charAt(i11) == ' ') {
                int i12 = i11 + 1;
                while (i12 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i12) == ' ') {
                    i12++;
                }
                int i13 = i12 - (i11 + 1);
                if (i13 > 0) {
                    spannableStringBuilder.delete(i11, i11 + i13);
                    length -= i13;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        for (int i14 = 0; i14 < length - 1; i14++) {
            if (spannableStringBuilder.charAt(i14) == '\n' && spannableStringBuilder.charAt(i14 + 1) == ' ') {
                spannableStringBuilder.delete(i14 + 1, i14 + 2);
                length--;
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(length - 1) == ' ') {
            spannableStringBuilder.delete(length - 1, length);
            length--;
        }
        for (int i15 = 0; i15 < length - 1; i15++) {
            if (spannableStringBuilder.charAt(i15) == ' ') {
                int i16 = i15 + 1;
                String[] strArr = A0C;
                if (strArr[3].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                A0C[2] = "m4xyST6fTPwcFIAJdQ5";
                if (spannableStringBuilder.charAt(i16) == '\n') {
                    spannableStringBuilder.delete(i15, i15 + 1);
                    length--;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(length - 1) == '\n') {
            spannableStringBuilder.delete(length - 1, length);
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder A02(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    private final GB A03(int i11) {
        List<GB> list = this.A00;
        if (list != null) {
            return list.get(i11);
        }
        throw new IndexOutOfBoundsException();
    }

    public static GB A04(String str) {
        return new GB(null, GD.A02(str), C.TIME_UNSET, C.TIME_UNSET, null, null, A06(0, 0, 53));
    }

    public static GB A05(String str, long j11, long j12, GH gh2, String[] strArr, String str2) {
        return new GB(str, null, j11, j12, gh2, strArr, str2);
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0B = new byte[]{52, 36, 48, 56, 41, 60, 57, 60, 41, 60, 93};
    }

    private void A08(long j11, Map<String, GH> map, Map<String, SpannableStringBuilder> map2) {
        if (A0C(j11)) {
            for (Map.Entry<String, Integer> entry : this.A08.entrySet()) {
                String key = entry.getKey();
                int iIntValue = this.A09.containsKey(key) ? this.A09.get(key).intValue() : 0;
                int iIntValue2 = entry.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    A0A(map, map2.get(key), iIntValue, iIntValue2);
                }
            }
            for (int i11 = 0; i11 < A00(); i11++) {
                A03(i11).A08(j11, map, map2);
            }
        }
    }

    private void A09(long j11, boolean z11, String str, Map<String, SpannableStringBuilder> map) {
        String str2 = str;
        this.A09.clear();
        this.A08.clear();
        if (A06(2, 8, 108).equals(this.A05)) {
            return;
        }
        if (!A06(0, 0, 53).equals(this.A04)) {
            str2 = this.A04;
        }
        if (this.A07 && z11) {
            A02(str2, map).append((CharSequence) this.A06);
            return;
        }
        if (A06(0, 2, Worker.WHAT_SYNC_DATA).equals(this.A05) && z11) {
            A02(str2, map).append('\n');
            return;
        }
        if (A0C(j11)) {
            for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
                this.A09.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
            }
            boolean zEquals = A06(10, 1, 28).equals(this.A05);
            for (int i11 = 0; i11 < A00(); i11++) {
                A03(i11).A09(j11, z11 || zEquals, str2, map);
            }
            if (zEquals) {
                GD.A04(A02(str2, map));
            }
            for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                this.A08.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
            }
        }
    }

    private void A0A(Map<String, GH> map, SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
        GH ghA00 = GD.A00(this.A03, this.A0A, map);
        if (ghA00 != null) {
            GD.A05(spannableStringBuilder, i11, i12, ghA00);
        }
    }

    private void A0B(TreeSet<Long> treeSet, boolean z11) {
        boolean zEquals = A06(10, 1, 28).equals(this.A05);
        if (z11 || zEquals) {
            long j11 = this.A02;
            if (j11 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j11));
            }
            long j12 = this.A01;
            if (j12 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j12));
            }
        }
        if (this.A00 == null) {
            return;
        }
        int i11 = 0;
        while (true) {
            List<GB> list = this.A00;
            if (A0C[7].length() != 26) {
                throw new RuntimeException();
            }
            A0C[5] = "6yeVGp3kLPk4WI3MPF9gLyaIhJRFIlFb";
            if (i11 >= list.size()) {
                return;
            }
            this.A00.get(i11).A0B(treeSet, z11 || zEquals);
            i11++;
        }
    }

    private final boolean A0C(long j11) {
        long j12 = this.A02;
        return (j12 == C.TIME_UNSET && this.A01 == C.TIME_UNSET) || (j12 <= j11 && this.A01 == C.TIME_UNSET) || ((j12 == C.TIME_UNSET && j11 < this.A01) || (j12 <= j11 && j11 < this.A01));
    }

    public final List<C1314Fn> A0D(long j11, Map<String, GH> map, Map<String, GC> map2) {
        TreeMap treeMap = new TreeMap();
        A09(j11, false, this.A04, treeMap);
        A08(j11, map, treeMap);
        ArrayList arrayList = new ArrayList();
        Iterator it = treeMap.entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0C[5].charAt(20) != 'L') {
                throw new RuntimeException();
            }
            A0C[0] = "Y7XV0FXPovcWGO3cFNRk8a";
            if (!zHasNext) {
                return arrayList;
            }
            Map.Entry entry = (Map.Entry) it.next();
            GC gc2 = map2.get(entry.getKey());
            arrayList.add(new C1314Fn(A01((SpannableStringBuilder) entry.getValue()), (Layout.Alignment) null, gc2.A00, gc2.A05, gc2.A04, gc2.A01, Integer.MIN_VALUE, gc2.A03, gc2.A06, gc2.A02));
        }
    }

    public final void A0E(GB gb2) {
        if (this.A00 == null) {
            this.A00 = new ArrayList();
        }
        this.A00.add(gb2);
    }

    public final long[] A0F() {
        TreeSet<Long> treeSet = new TreeSet<>();
        A0B(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        int i11 = 0;
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i11] = it.next().longValue();
            i11++;
        }
        return jArr;
    }
}
