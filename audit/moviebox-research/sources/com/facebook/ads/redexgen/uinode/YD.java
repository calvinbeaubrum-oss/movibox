package com.facebook.ads.redexgen.uinode;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.internal.util.common.Preconditions;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YD implements C8w {
    public static byte[] A03;
    public static final String A04;
    public final C1794Ym A00;
    public final AnonymousClass97<C1400Iz> A01;
    public final AnonymousClass97<C1400Iz> A02;

    static {
        A03();
        A04 = YD.class.getSimpleName();
    }

    public YD(C1794Ym c1794Ym) throws IOException {
        this.A00 = c1794Ym;
        this.A01 = new YA(AnonymousClass94.A00(A00(11, 28, 31), c1794Ym), new YF(this));
        this.A02 = new YA(AnonymousClass94.A00(A00(322, 37, 102), c1794Ym), new YE(this));
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 70);
        }
        return new String(bArrCopyOfRange);
    }

    private List<JSONObject> A01(List<JSONObject> list, byte[] bArr, int[] iArr) {
        int i11 = 0;
        for (int i12 : iArr) {
            if (i12 == 0) {
                break;
            }
            try {
                list.add(A02(bArr, i11, i12));
            } catch (JSONException e11) {
                if (this.A00.A04().A8z()) {
                    Log.e(A04, A00(85, 45, 97), e11);
                }
                A05(C8A.A2P, e11);
            }
            i11 += i12;
        }
        return list;
    }

    public static JSONObject A02(byte[] bArr, int i11, int i12) throws JSONException {
        return new JSONObject(new String(Arrays.copyOfRange(bArr, i11, i11 + i12)));
    }

    public static void A03() {
        A03 = new byte[]{102, 100, 43, 34, 100, 48, 61, 52, 33, 126, 100, Ascii.CAN, 61, Ascii.FS, 47, 60, 55, 45, 10, 45, 54, 43, 56, 62, 60, Ascii.VT, 60, 58, 54, 43, 61, Ascii.GS, 56, 45, 56, 59, 56, 42, 60, 105, 72, 65, 72, 89, 72, 73, Ascii.CR, 72, 91, 72, 67, 89, Ascii.ETB, Ascii.CR, Ascii.SI, 66, 101, 109, 104, 97, 96, 36, 112, 107, 36, 103, 104, 97, 101, 118, 36, 97, 114, 97, 106, 112, 119, 36, 119, 112, 107, 118, 101, 99, 97, 97, 70, 78, 75, 66, 67, 7, 83, 72, 7, 67, 66, 84, 66, 85, 78, 70, 75, 78, 93, 66, 7, 70, 73, 7, 66, 81, 66, 73, 83, 7, 65, 85, 72, 74, 7, 67, 70, 83, 70, 69, 70, 84, 66, 7, 107, 76, 68, 65, 72, 73, Ascii.CR, 89, 66, Ascii.CR, 64, 66, 91, 72, Ascii.CR, 72, 91, 72, 67, 89, 94, Ascii.CR, 75, 95, 66, 64, Ascii.CR, 68, 67, 0, 75, 65, 68, 74, 69, 89, Ascii.CR, 94, 89, 66, 95, 76, 74, 72, Ascii.CR, 79, 76, 78, 70, Ascii.CR, 89, 66, Ascii.CR, 72, 91, 72, 67, 89, 94, Ascii.CR, 73, 76, 89, 76, 79, 76, 94, 72, 118, 81, 89, 92, 85, 84, Ascii.DLE, 68, 95, Ascii.DLE, 64, 81, 66, 67, 85, Ascii.DLE, 81, 94, Ascii.DLE, 85, 70, 85, 94, 68, Ascii.DLE, 86, 66, 95, 93, Ascii.DLE, 89, 94, Ascii.GS, 86, 92, 89, 87, 88, 68, Ascii.DLE, 67, 68, 95, 66, 81, 87, 85, 123, 92, 84, 81, 88, 89, Ascii.GS, 73, 82, Ascii.GS, 79, 88, 92, 89, Ascii.GS, 73, 85, 88, Ascii.GS, 83, 72, 80, 95, 88, 79, Ascii.GS, 82, 91, Ascii.GS, 88, 75, 88, 83, 73, 78, Ascii.GS, 91, 79, 82, 80, Ascii.GS, 89, 92, 73, 92, 95, 92, 78, 88, Ascii.FF, 43, 35, 38, 47, 46, 106, 62, 37, 106, 57, 47, 56, 35, 43, 38, 35, 48, 47, 106, 43, 46, 106, 47, 60, 47, 36, 62, 105, 78, 70, 76, 73, 71, 72, 84, Ascii.CR, 97, 68, 101, 86, 69, 78, 84, 115, 84, 79, 82, 65, 71, 69, 114, 69, 67, 79, 82, 68, 100, 65, 84, 65, 66, 65, 83, 69, 56, Ascii.SI, 9, 5, Ascii.CAN, Ascii.SO, 74, Ascii.SO, Ascii.VT, Ascii.RS, Ascii.VT, 8, Ascii.VT, Ascii.EM, Ascii.SI, 74, Ascii.FF, Ascii.VT, 3, 6, Ascii.US, Ascii.CAN, Ascii.SI, 74, 5, 9, 9, Ascii.US, Ascii.CAN, Ascii.CAN, Ascii.SI, Ascii.SO, 74, Ascii.GS, 2, Ascii.SI, 4, 74, Ascii.CAN, Ascii.SI, Ascii.VT, Ascii.SO, 3, 4, Ascii.CR, 74, Ascii.SI, Ascii.FS, Ascii.SI, 4, Ascii.RS, Ascii.EM, 68, 61, 40, 40, 57, 49, 44, 40, Ascii.FS, Ascii.EM, Ascii.FF, Ascii.EM, 47, 34, 95, 72, 78, 66, 95, 73, 114, 73, 76, 89, 76, 79, 76, 94, 72, 65, 87, 65, 65, 91, 93, 92, 109, 91, 86, 46, 56, 46, 46, 52, 50, 51, 2, 41, 52, 48, 56, 100, 121, 125, 117, 49, 42, 46, 32, 43, 88, 85, 92, 73, Ascii.FF, Ascii.ETB, Ascii.DC2, Ascii.ETB, Ascii.SYN, Ascii.SO, Ascii.ETB};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(int i11, String str) {
        C8B c8b = new C8B(str);
        c8b.A05(1);
        this.A00.A07().A9b(A00(425, 15, 107), i11, c8b);
    }

    private void A05(int i11, Throwable th2) {
        this.A00.A07().A9a(A00(425, 15, 107), i11, new C8B(th2));
    }

    public static byte[] A07(C11237f c11237f, String str, C1400Iz c1400Iz) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(423, 2, 0), str);
            jSONObject.put(A00(466, 5, 3), c1400Iz.A08());
            jSONObject.put(A00(471, 4, 106), c1400Iz.A06().toString());
            jSONObject.put(A00(462, 4, 86), C1453Lf.A02(c1400Iz.A04()));
            jSONObject.put(A00(450, 12, 27), C1453Lf.A02(c1400Iz.A03()));
            jSONObject.put(A00(440, 10, 116), c1400Iz.A07());
            jSONObject.put(A00(419, 4, 62), new JSONObject(c1400Iz.A09()));
            jSONObject.put(A00(TTAdConstant.IMAGE_URL_CODE, 7, 26), 0);
        } catch (JSONException e11) {
            if (c11237f.A04().A8z()) {
                Log.e(A04, A00(294, 28, 12), e11);
            }
        }
        return jSONObject.toString().getBytes();
    }

    public static byte[] A09(JSONObject jSONObject) {
        return jSONObject.toString().getBytes();
    }

    public final int A0A() {
        try {
            return this.A01.A7n();
        } catch (C9G e11) {
            if (!this.A00.A04().A8z()) {
                return 0;
            }
            Log.e(A04, A00(245, 49, 123), e11);
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00f0 A[Catch: 9G -> 0x0136, TryCatch #6 {9G -> 0x0136, blocks: (B:33:0x00e4, B:35:0x00f0, B:36:0x00ff, B:22:0x0088, B:24:0x008e, B:26:0x009a, B:27:0x00da, B:39:0x0108, B:40:0x010c, B:42:0x0112, B:43:0x0122, B:44:0x0126, B:46:0x012c), top: B:63:0x00e4 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0147  */
    public final int A0B(int i11, Set<String> set, Set<String> set2) {
        String strA00 = A00(TTAdConstant.IMAGE_URL_CODE, 7, 26);
        int i12 = 0;
        int[] iArr = new int[30];
        byte[] bArr = new byte[ComConstants.AD_TIMEOUT_MILLIS];
        LinkedList linkedList = new LinkedList();
        try {
            linkedList.add(this.A02.A5f(bArr, iArr));
            List<JSONObject> listA01 = A01(new LinkedList(), bArr, iArr);
            while (((AnonymousClass96) linkedList.getLast()).AAK()) {
                Arrays.fill(iArr, 0);
                linkedList.add(this.A02.A5f(bArr, iArr));
                listA01 = A01(listA01, bArr, iArr);
            }
            Iterator<JSONObject> it = listA01.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                try {
                    String string = next.getString(A00(423, 2, 0));
                    try {
                        if (set.contains(string)) {
                            int i13 = next.getInt(strA00) + 1;
                            if (i13 < i11) {
                                try {
                                    next.put(strA00, i13);
                                    this.A01.AGb(A09(next));
                                } catch (C9G e11) {
                                    e = e11;
                                    if (this.A00.A04().A8z()) {
                                        Log.e(A04, A00(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 68, 107), e);
                                    }
                                    A05(C8A.A2L, e);
                                    return i12;
                                } catch (JSONException e12) {
                                    e = e12;
                                    try {
                                        if (this.A00.A04().A8z()) {
                                            Log.e(A04, A00(198, 47, 118), e);
                                        }
                                        A05(C8A.A2P, e);
                                    } catch (C9G e13) {
                                        e = e13;
                                        if (this.A00.A04().A8z()) {
                                            Log.e(A04, A00(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 68, 107), e);
                                        }
                                        A05(C8A.A2L, e);
                                        return i12;
                                    }
                                }
                            } else {
                                i12++;
                            }
                            it.remove();
                        } else {
                            try {
                                if (set2.contains(string)) {
                                    if (this.A00.A04().A8z()) {
                                        String str = A00(39, 16, 107) + string + A00(0, 11, 2) + next.optString(A00(471, 4, 106), A00(475, 7, 63));
                                    }
                                    it.remove();
                                }
                            } catch (JSONException e14) {
                                e = e14;
                                if (this.A00.A04().A8z()) {
                                    Log.e(A04, A00(198, 47, 118), e);
                                }
                                A05(C8A.A2P, e);
                            }
                        }
                    } catch (C9G e15) {
                        e = e15;
                    } catch (JSONException e16) {
                        e = e16;
                    }
                } catch (JSONException e17) {
                    e = e17;
                }
            }
            Iterator<JSONObject> it2 = listA01.iterator();
            while (it2.hasNext()) {
                this.A02.AGb(A09(it2.next()));
            }
            Iterator it3 = linkedList.iterator();
            while (it3.hasNext()) {
                ((AnonymousClass96) it3.next()).A52();
            }
        } catch (C9G e18) {
            e = e18;
        }
        return i12;
    }

    public final List<JSONObject> A0C(int i11) {
        boolean z11 = false;
        if (i11 == -1) {
            z11 = true;
            i11 = 30;
        }
        int[] iArr = new int[i11];
        byte[] bArr = new byte[i11 * 1000];
        List<JSONObject> linkedList = new LinkedList<>();
        LinkedList linkedList2 = new LinkedList();
        try {
            AnonymousClass96 anonymousClass96A5f = this.A01.A5f(bArr, iArr);
            linkedList2.add(anonymousClass96A5f);
            int iA5g = anonymousClass96A5f.A5g();
            linkedList = A01(linkedList, bArr, iArr);
            while (anonymousClass96A5f.AAK() && (iA5g < i11 || z11)) {
                if (z11) {
                    Arrays.fill(iArr, 0);
                } else {
                    iArr = new int[i11 - iA5g];
                }
                anonymousClass96A5f = this.A01.A5f(bArr, iArr);
                linkedList2.add(anonymousClass96A5f);
                linkedList = A01(linkedList, bArr, iArr);
            }
            Iterator<JSONObject> it = linkedList.iterator();
            while (it.hasNext()) {
                this.A02.AGb(A09(it.next()));
            }
            Iterator it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                ((AnonymousClass96) it2.next()).A52();
            }
        } catch (C9G e11) {
            if (this.A00.A04().A8z()) {
                Log.e(A04, A00(359, 53, 44), e11);
            }
            A05(C8A.A2M, e11);
        }
        return linkedList;
    }

    @Override // com.facebook.ads.redexgen.uinode.C8w
    public final void A4J() {
        try {
            this.A01.clear();
            this.A02.clear();
        } catch (C9G e11) {
            if (this.A00.A04().A8z()) {
                Log.e(A04, A00(55, 30, 66), e11);
            }
            A05(C8A.A2J, e11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C8w
    public final void AHE(final C1400Iz c1400Iz, final AbstractC11588t<String> abstractC11588t) {
        Executor executor = ExecutorC1467Lt.A07;
        final AnonymousClass97<C1400Iz> anonymousClass97 = this.A01;
        final C1794Ym c1794Ym = this.A00;
        AbstractC1464Lq.A00(executor, new AsyncTask<Void, Void, String>(c1400Iz, abstractC11588t, anonymousClass97, c1794Ym) { // from class: com.facebook.ads.redexgen.X.8x
            public static byte[] A05;
            public static String[] A06 = {"eZRg0", "9V6E8W", "xj5QhV", "OA95VIvTvwhgOpg1JzD5APn5ld4Fxl09", "KVXKxw3vFVm2nsonOqXLQ2M9", "1wiEXg5TWKy6aTJl", "hr3sX5JQ1zlqribj", "Vt9t5ut5ZgjhHbMTByjzA5y3IT5Rov5"};
            public C9G A00;
            public final C11237f A01;
            public final AbstractC11588t<String> A02;
            public final AnonymousClass97<C1400Iz> A03;
            public final C1400Iz A04;

            static {
                A02();
            }

            {
                this.A04 = c1400Iz;
                this.A03 = anonymousClass97;
                this.A02 = abstractC11588t;
                this.A01 = c1794Ym;
            }

            public static String A00(int i11, int i12, int i13) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
                for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
                    bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 55);
                }
                return new String(bArrCopyOfRange);
            }

            private final String A01(Void... voidArr) throws Throwable {
                if (KL.A02(this)) {
                    return null;
                }
                String string = null;
                try {
                    try {
                        string = UUID.randomUUID().toString();
                        this.A01.A07().A8l(this.A04.A06().toString());
                        if (TextUtils.isEmpty(this.A04.A08())) {
                            return null;
                        }
                        if (this.A01.A04().A8z()) {
                            String str = A00(29, 15, 118) + this.A04.A06().toString() + A00(0, 1, 13) + this.A04.A09().toString();
                        }
                        this.A03.AGb(YD.A07(this.A01, string, this.A04));
                        return string;
                    } catch (C9G e11) {
                        this.A00 = e11;
                        this.A01.A07().A9a(A00(44, 15, 76), C8A.A2N, new C8B(e11));
                    }
                } catch (Throwable th2) {
                    KL.A00(th2, this);
                    return null;
                }
            }

            public static void A02() {
                A05 = new byte[]{Ascii.SUB, 40, Ascii.US, Ascii.US, 2, Ascii.US, 77, 0, 8, Ascii.RS, Ascii.RS, Ascii.FF, 10, 8, 77, Ascii.SO, Ascii.FF, 3, 3, 2, Ascii.EM, 77, Ascii.SI, 8, 77, 3, Ascii.CAN, 1, 1, Ascii.CR, 46, 38, 38, 40, 47, 38, 97, 36, 55, 36, 47, 53, 123, 97, 9, Ascii.RS, Ascii.CAN, Ascii.DC4, 9, Ascii.US, 36, Ascii.US, Ascii.SUB, Ascii.SI, Ascii.SUB, Ascii.EM, Ascii.SUB, 8, Ascii.RS};
            }

            private final void A03(String str) throws Throwable {
                if (KL.A02(this)) {
                    return;
                }
                try {
                    C9G c9g = this.A00;
                    if (c9g == null) {
                        this.A02.A02(str);
                    } else {
                        this.A02.A01(0, (String) Preconditions.checkNotNull(c9g.getMessage(), A00(1, 28, 90)));
                    }
                } catch (Throwable th2) {
                    KL.A00(th2, this);
                    String[] strArr = A06;
                    if (strArr[5].length() != strArr[6].length()) {
                        throw new RuntimeException();
                    }
                    A06[1] = "UcJj";
                }
            }

            @Override // android.os.AsyncTask
            public final /* bridge */ /* synthetic */ String doInBackground(Void[] voidArr) throws Throwable {
                if (KL.A02(this)) {
                    return null;
                }
                try {
                    return A01(voidArr);
                } catch (Throwable th2) {
                    KL.A00(th2, this);
                    if (A06[7].length() != 31) {
                        throw new RuntimeException();
                    }
                    A06[1] = "V";
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            public final /* bridge */ /* synthetic */ void onPostExecute(String str) throws Throwable {
                if (KL.A02(this)) {
                    return;
                }
                try {
                    A03(str);
                } catch (Throwable th2) {
                    KL.A00(th2, this);
                }
            }
        }, new Void[0]);
    }
}
