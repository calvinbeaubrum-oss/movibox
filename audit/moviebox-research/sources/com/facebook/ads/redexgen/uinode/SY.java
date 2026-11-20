package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.Nullable;
import okhttp3.internal.ws.WebSocketProtocol;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SY {
    public static byte[] A03;
    public static String[] A04 = {"VT4fMDut957REDv81Zf67ZRXVgx5T5a8", CampaignEx.JSON_KEY_AD_R, "Z8Owoyb", "FnQ4OiwpcdZoDsiJ2m5WJ2Um26YCJsc9", "WRxJAxd2kL6ougEGyIG1Du6QramXeho", "YseYEaNGGUDDQ4eQqZOUPTvdjgKCIPcf", "c4hktFWkJWdy9he8EQ0DeAgF43U5wP0s", "DRA64HFd"};
    public BlockingDeque<SZ> A00;
    public final int A01;

    @Nullable
    public final String A02;

    static {
        A08();
    }

    public SY(@Nullable String str) {
        this(str, 2000);
    }

    public SY(@Nullable String str, int i11) {
        this.A02 = str;
        this.A01 = i11;
        this.A00 = new LinkedBlockingDeque();
    }

    public static long A00(long j11) {
        return (j11 << 1) ^ (j11 >> 63);
    }

    public static long A01(List<SZ> list, int i11, int i12) {
        HashMap map = new HashMap();
        for (int i13 = i11 + 1; i13 < i11 + i12; i13++) {
            long jA03 = list.get(i13).A03();
            long jA01 = list.get(i13).A01();
            if (map.containsKey(Long.valueOf(jA03))) {
                map.put(Long.valueOf(jA03), Integer.valueOf(((Integer) map.get(Long.valueOf(jA03))).intValue() + 1));
            } else {
                map.put(Long.valueOf(jA03), 1);
            }
            if (map.containsKey(Long.valueOf(jA01))) {
                map.put(Long.valueOf(jA01), Integer.valueOf(((Integer) map.get(Long.valueOf(jA01))).intValue() + 1));
            } else {
                Long lValueOf = Long.valueOf(jA01);
                if (A04[2].length() == 25) {
                    throw new RuntimeException();
                }
                String[] strArr = A04;
                strArr[6] = "1vNPfVBSY4dOMHCgW1yzfdLMrSn5bdwR";
                strArr[0] = "JWbjY4s0cXOj2VlFs0Pom5JqAlb5V7T0";
                map.put(lValueOf, 1);
            }
        }
        long jLongValue = 3333;
        int i14 = 0;
        for (Map.Entry entry : map.entrySet()) {
            int iIntValue = ((Integer) entry.getValue()).intValue();
            if (i14 < iIntValue) {
                i14 = iIntValue;
                jLongValue = ((Long) entry.getKey()).longValue();
            }
        }
        for (int i15 = i11 + 1; i15 < i11 + i12; i15++) {
            list.get(i15).A09(list.get(i15).A03() - jLongValue);
            list.get(i15).A07(list.get(i15).A01() - jLongValue);
            if (A04[7].length() == 7) {
                throw new RuntimeException();
            }
            A04[4] = "Qmxl";
        }
        return jLongValue;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A03(String str) {
        String strA02 = A02(0, 64, 117);
        StringBuilder sb2 = new StringBuilder(str);
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        int length = sb2.length() % 3;
        if (length > 0) {
            while (length < 3) {
                String[] strArr = A04;
                if (strArr[6].charAt(27) != strArr[0].charAt(27)) {
                    throw new RuntimeException();
                }
                A04[2] = "LfiGB0y4";
                sb4.append('=');
                sb2.append((char) 0);
                length++;
            }
        }
        for (int i11 = 0; i11 < sb2.length(); i11 += 3) {
            int iCharAt = (sb2.charAt(i11) << 16) + (sb2.charAt(i11 + 1) << '\b') + sb2.charAt(i11 + 2);
            sb3.append(strA02.charAt((iCharAt >> 18) & 63)).append(strA02.charAt((iCharAt >> 12) & 63)).append(strA02.charAt((iCharAt >> 6) & 63)).append(strA02.charAt(iCharAt & 63));
        }
        return sb3.substring(0, sb3.length() - sb4.length()) + ((Object) sb4);
    }

    @Nullable
    public static String A04(@Nullable List<SZ> list) {
        if (list == null) {
            return null;
        }
        return A06(list, 0, list.size(), false);
    }

    public static String A05(List<Long> list) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            A09(sb2, A00(it.next().longValue()));
        }
        return A03(sb2.toString());
    }

    @Nullable
    public static String A06(@Nullable List<SZ> list, int i11, int i12, boolean z11) {
        if (list == null || list.isEmpty() || i11 < 0 || i11 >= list.size() || i12 <= 0 || i11 + i12 > list.size()) {
            return null;
        }
        HashMap map = new HashMap();
        map.put(A02(73, 2, 35), list.get(i11).A05());
        map.put(A02(115, 7, 118), 1);
        boolean z12 = false;
        boolean z13 = false;
        if (i12 > 1) {
            A0A(list, i11, i12);
            map.put(A02(64, 9, 58), Long.valueOf(A01(list, i11, i12)));
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i13 = i11 + 1; i13 < i11 + i12; i13++) {
                arrayList.add(Long.valueOf(list.get(i13).A03()));
                arrayList.add(Long.valueOf(list.get(i13).A01()));
                arrayList.add(Long.valueOf(list.get(i13).A02()));
                arrayList2.add(Long.valueOf(list.get(i13).A00()));
                if (list.get(i13).A00() != 0) {
                    z12 = true;
                }
                if (z11) {
                    arrayList3.add(Long.valueOf(list.get(i13).A04()));
                    if (list.get(i13).A04() != 0) {
                        z13 = true;
                    }
                }
            }
            map.put(A02(92, 2, 29), A05(arrayList));
            map.put(A02(75, 6, 36), A05(arrayList2));
            map.put(A02(94, 9, 20), Boolean.valueOf(z12));
            if (z11) {
                map.put(A02(81, 11, 55), A05(arrayList3));
                map.put(A02(Worker.WHAT_SYNC_DATA, 12, WebSocketProtocol.PAYLOAD_SHORT), Boolean.valueOf(z13));
            }
        }
        String strA07 = A07(map);
        if (A04[1].length() == 28) {
            throw new RuntimeException();
        }
        A04[2] = "";
        return strA07.length() > 900000 ? A02(122, 29, 5) : strA07;
    }

    public static String A07(Map<String, Object> map) {
        return new JSONObject(map).toString();
    }

    public static void A08() {
        A03 = new byte[]{92, 95, 94, 89, 88, 91, 90, 85, 84, 87, 86, 81, 80, 83, 82, 77, 76, 79, 78, 73, 72, 75, 74, 69, 68, 71, 124, Ascii.DEL, 126, 121, 120, 123, 122, 117, 116, 119, 118, 113, 112, 115, 114, 109, 108, 111, 110, 105, 104, 107, 106, 101, 100, 103, 45, 44, 47, 46, 41, 40, 43, 42, 37, 36, 54, 50, 48, 51, 33, 55, Ascii.SYN, 55, 62, 38, 51, 45, 123, 42, Ascii.CR, 57, 40, 37, 35, 57, 9, 54, 58, 40, 62, 61, 51, 58, 106, 111, 19, Ascii.ESC, Ascii.NAK, Ascii.SI, 47, 19, 9, Ascii.DC2, Ascii.CAN, 51, Ascii.DC2, Ascii.DEL, 101, 64, Ascii.DEL, 115, 97, 119, 116, 122, 115, 35, 38, 104, 123, 108, 109, 119, 113, 112, Ascii.SYN, 79, 8, Ascii.US, Ascii.US, 79, 87, 79, 62, 36, 55, 40, 50, 40, 53, 46, 40, 40, 41, 50, 32, 44, 53, 50, 46, 44, 61, 79, Ascii.DLE};
    }

    public static void A09(StringBuilder sb2, long j11) {
        while (j11 >= 128) {
            char c11 = (char) ((((long) (128 - 1)) & j11) | ((long) 128));
            j11 >>= 7;
            sb2.append(c11);
        }
        char c12 = (char) j11;
        String[] strArr = A04;
        if (strArr[6].charAt(27) != strArr[0].charAt(27)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[6] = "TgLp8xzira9J3G7G7T0jqPUigov5tglm";
        strArr2[0] = "pcTwByMvDCDs4QWUJjAKPoIFXFV5AKB6";
        sb2.append(c12);
    }

    public static void A0A(List<SZ> list, int i11, int i12) {
        for (int i13 = (i11 + i12) - 1; i13 > i11; i13--) {
            list.get(i13).A09(list.get(i13).A03() - list.get(i13 - 1).A03());
            list.get(i13).A07(list.get(i13).A01() - list.get(i13 - 1).A01());
            list.get(i13).A08(list.get(i13).A02() - list.get(i13 - 1).A02());
            long jA04 = 0;
            list.get(i13).A06(list.get(i13 + (-1)).A00() == -1 ? 0L : list.get(i13).A00() - list.get(i13 - 1).A00());
            SZ sz2 = list.get(i13);
            if (list.get(i13 - 1).A04() != -1) {
                jA04 = list.get(i13).A04() - list.get(i13 - 1).A04();
            }
            sz2.A0A(jA04);
            list.get(i13).A08(list.get(i13).A02() - list.get(i13).A01());
        }
    }

    public final List<SZ> A0B() {
        ArrayList arrayList = new ArrayList();
        this.A00.drainTo(arrayList);
        return arrayList;
    }

    public final void A0C(SZ sz2) {
        SZ szPeekLast = this.A00.peekLast();
        if (szPeekLast != null) {
            long jA03 = szPeekLast.A03();
            if (A04[7].length() == 7) {
                throw new RuntimeException();
            }
            A04[1] = "fQhMIvl";
            if (jA03 == sz2.A03() && szPeekLast.A01() == sz2.A01()) {
                return;
            }
        }
        this.A00.add(sz2);
    }
}
