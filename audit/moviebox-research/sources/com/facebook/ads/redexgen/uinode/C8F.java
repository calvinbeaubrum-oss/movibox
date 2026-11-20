package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8F, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C8F {
    public static byte[] A00;
    public static String[] A01 = {"a6IxlCkVmcf1QOD6ZYjDV7INHBfwC5pE", "pjHGmgbtiOqji60ouNqSwKm8iDwdL2il", "jT1wBn6CKnjHaXeX1", "64rNhN6ZFhDWGxpIQ", "ze8vByysvbBiliYVuotBM6Di85tpEUzv", "oRRmyqjSmqskFAvbDRZ10d57ZrKFDjEI", "44vbl6FfanMIMy7ytQNCDD1eXfOrnFTF", "rkbwsxy0OcV7GrP7ELmdkRDeQR2uGuGh"};

    static {
        A02();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            int i15 = bArrCopyOfRange[i14] - i13;
            if (A01[1].charAt(1) == 'a') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "1M2Y98BwTvEPUGLlCwxj254fliWahs1n";
            strArr[0] = "azYACSqPfJkxfvivKERNz1YXvsYHtm8K";
            bArrCopyOfRange[i14] = (byte) (i15 - 68);
        }
        return new String(bArrCopyOfRange);
    }

    public static JSONObject A01(C11237f c11237f, long j11, long j12, long j13, long j14, int i11, Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put(A00(69, 10, 88), j11);
                String strA00 = A00(21, 8, 36);
                double d11 = j12;
                if (A01[1].charAt(1) == 'a') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[5] = "jMg5lz9yrKYKrG7ow7Rg5ttUcJr1AiZd";
                strArr[6] = "pmFVBxkrFRXwpMq5qFraASgBsRnTrBpW";
                try {
                    jSONObject.put(strA00, d11 / 1000.0d);
                    try {
                        jSONObject.put(A00(57, 12, 38), j13);
                        try {
                            jSONObject.put(A00(79, 11, 31), j14);
                            try {
                                jSONObject.put(A00(34, 16, 75), i11);
                                if (exc != null) {
                                    jSONObject.put(A00(29, 5, 115), exc.getMessage());
                                }
                            } catch (JSONException e11) {
                                e = e11;
                                c11237f.A07().A3c(e);
                            }
                        } catch (JSONException e12) {
                            e = e12;
                        }
                    } catch (JSONException e13) {
                        e = e13;
                    }
                } catch (JSONException e14) {
                    e = e14;
                }
                return jSONObject;
            } catch (JSONException e15) {
                e = e15;
            }
        } catch (JSONException e16) {
            e = e16;
        }
    }

    public static void A02() {
        A00 = new byte[]{-47, -12, -20, -20, -18, -13, -20, -91, -45, -22, -7, -4, -12, -9, -16, -91, -54, -5, -22, -13, -7, -52, -35, -38, -55, -36, -47, -41, -42, Ascii.FS, 41, 41, 38, 41, -9, 3, 3, -1, -18, 2, 3, -16, 3, 4, 2, -18, -14, -2, -13, -12, Ascii.SYN, Ascii.CR, Ascii.FS, Ascii.US, Ascii.ETB, Ascii.SUB, 19, -38, -53, -29, -42, -39, -53, -50, -55, -35, -45, -28, -49, Ascii.SI, Ascii.DLE, -3, Ascii.SO, Ascii.DLE, -5, Ascii.DLE, 5, 9, 1, -40, -45, -49, -46, -60, -57, -62, -42, -52, -35, -56};
    }

    public static void A03(C11237f c11237f, long j11, long j12, long j13, long j14, int i11, Exception exc) {
        C8B c8b = new C8B(A00(0, 21, 65));
        c8b.A05(1);
        c8b.A07(A01(c11237f, j11, j12, j13, j14, i11, exc));
        c11237f.A07().AAA(A00(50, 7, 100), C8A.A20, c8b);
    }
}
