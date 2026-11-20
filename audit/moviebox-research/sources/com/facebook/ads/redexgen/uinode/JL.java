package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.NativeAdBase;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public enum JL {
    A05(0, NativeAdBase.MediaCacheFlag.NONE),
    A04(1, NativeAdBase.MediaCacheFlag.ALL);

    public static byte[] A02;
    public final long A00;
    public final NativeAdBase.MediaCacheFlag A01;

    static {
        A02();
    }

    JL(long j11, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = j11;
        this.A01 = mediaCacheFlag;
    }

    public static JL A00(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        for (JL jl2 : values()) {
            if (jl2.A01 == mediaCacheFlag) {
                return jl2;
            }
        }
        return null;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 111);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{70, 75, 75, 34, 35, 34, 41};
    }
}
