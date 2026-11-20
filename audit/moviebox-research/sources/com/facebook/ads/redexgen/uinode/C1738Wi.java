package com.facebook.ads.redexgen.uinode;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1738Wi implements DQ {
    public static byte[] A02;
    public MediaCodecInfo[] A00;
    public final int A01;

    static {
        A02();
    }

    public C1738Wi(boolean z11) {
        this.A01 = z11 ? 1 : 0;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 45);
        }
        return new String(bArrCopyOfRange);
    }

    private void A01() {
        if (this.A00 == null) {
            this.A00 = new MediaCodecList(this.A01).getCodecInfos();
        }
    }

    public static void A02() {
        A02 = new byte[]{3, -11, -13, 5, 2, -11, -67, 0, -4, -15, 9, -14, -15, -13, -5};
    }

    @Override // com.facebook.ads.redexgen.uinode.DQ
    public final int A6U() {
        A01();
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.uinode.DQ
    public final MediaCodecInfo A6V(int i11) {
        A01();
        return this.A00[i11];
    }

    @Override // com.facebook.ads.redexgen.uinode.DQ
    public final boolean A9H(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A00(0, 15, 99));
    }

    @Override // com.facebook.ads.redexgen.uinode.DQ
    public final boolean AFf() {
        return true;
    }
}
