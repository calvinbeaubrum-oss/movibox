package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YS implements C7v {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 62);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{0, 5, Ascii.DLE, 5, Ascii.ESC, Ascii.DC4, Ascii.SYN, Ascii.VT, 7, 1, Ascii.ETB, Ascii.ETB, Ascii.CR, 10, 3, Ascii.ESC, Ascii.VT, Ascii.DC4, Ascii.DLE, Ascii.CR, Ascii.VT, 10, Ascii.ETB, Ascii.ESC, 7, Ascii.VT, 17, 10, Ascii.DLE, Ascii.SYN, Ascii.GS, Ascii.ESC, Ascii.SI, 1, Ascii.GS, 39, 34, 55, 34, 60, 51, 49, 44, 32, 38, 48, 48, 42, 45, 36, 60, 44, 51, 55, 42, 44, 45, 48, 60, 40, 38, 58, 36, 33, 52, 33, Utf8.REPLACEMENT_BYTE, 48, 50, 47, 35, 37, 51, 51, 41, 46, 39, Utf8.REPLACEMENT_BYTE, 47, 48, 52, 41, 47, 46, 51, Utf8.REPLACEMENT_BYTE, 51, 52, 33, 52, 37, Utf8.REPLACEMENT_BYTE, 43, 37, 57};
    }

    @Override // com.facebook.ads.redexgen.uinode.C7v
    public final void AAQ(InterfaceC11347u interfaceC11347u) {
        String[] stringArray;
        Integer integer;
        Integer integer2;
        if (AdInternalSettings.sDataProcessingOptionsUpdate.getAndSet(false)) {
            synchronized (AdInternalSettings.sSettingsBundle) {
                stringArray = AdInternalSettings.sSettingsBundle.getStringArray(A00(35, 27, 93));
                integer = AdInternalSettings.sSettingsBundle.getInteger(A00(0, 35, 122));
                integer2 = AdInternalSettings.sSettingsBundle.getInteger(A00(62, 33, 94));
            }
            interfaceC11347u.AD5(stringArray, integer, integer2);
        }
    }
}
