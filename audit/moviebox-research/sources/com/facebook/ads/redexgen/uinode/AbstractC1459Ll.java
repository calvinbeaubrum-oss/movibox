package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.media.AudioManager;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ll, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1459Ll {
    public static byte[] A00;
    public static String[] A01 = {"", "SXw", "dejWMVKCcsRHbrwAIECa6aRABNrvRLL1", "Mpo", "dfeQdAe6W2quBxkeKKSlZfT5B8UcRWSp", "PPqjaOYWzYRlppBEr7ot7ueRFIAfsGXr", "QjvNArJcMH0SA20xehHAs5TxpNTDNPBN", "WLwkcjK3klW5xWY"};

    static {
        A02();
    }

    public static float A00(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(A01(2, 5, 39));
        if (audioManager == null) {
            return 0.0f;
        }
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        if (streamMaxVolume <= 0) {
            return 0.0f;
        }
        float f11 = streamVolume * 1.0f;
        float f12 = streamMaxVolume;
        if (A01[6].charAt(22) != 'T') {
            throw new RuntimeException();
        }
        A01[2] = "0x0JMOwm3zHAjWtXS56jSdeaa6cHcp3J";
        return f11 / f12;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 80);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-8, -44, -40, -20, -37, -32, -26, -35, -15, -16, -21, -20, -24, -35, -11, -1, 4, 2, -1, 4, -5};
    }

    public static void A03(Map<String, String> map, boolean z11, boolean z12) {
        String strA01 = A01(1, 1, 83);
        String strA02 = A01(0, 1, 120);
        map.put(A01(7, 8, 44), z11 ? strA01 : strA02);
        if (!z12) {
            strA01 = strA02;
        }
        map.put(A01(15, 6, 70), strA01);
    }
}
