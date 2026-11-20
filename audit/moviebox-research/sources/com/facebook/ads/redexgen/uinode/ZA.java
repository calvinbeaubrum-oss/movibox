package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.NativeAdBase;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZA implements InterfaceC09941y {
    public static byte[] A03;
    public C10845m A00;
    public C1795Yn A01;
    public final NativeAdBase.MediaCacheFlag A02;

    static {
        A03();
    }

    public ZA(C10845m c10845m, C1795Yn c1795Yn, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = c10845m;
        this.A01 = c1795Yn;
        this.A02 = mediaCacheFlag;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 87);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{59, 52, 33, 60, 35, 48, 100, Ascii.DEL, 122, Ascii.DEL, 126, 102, Ascii.DEL};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09941y
    public final void ABR(C1401Jb c1401Jb) {
        KK.A00(new ZD(this, c1401Jb));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09941y
    public final void ACP(List<C1913bK> list) {
        C11006c c11006c = new C11006c(this.A01);
        String strA02 = A02(6, 7, 70);
        for (C1913bK c1913bK : list) {
            if (A02(6, 7, 70).equals(strA02)) {
                strA02 = c1913bK.A0G();
            }
            if (this.A02.equals(NativeAdBase.MediaCacheFlag.ALL)) {
                if (c1913bK.A0E().A0G() != null) {
                    c11006c.A0b(new C10986a(c1913bK.A0E().A0G().getUrl(), c1913bK.A0E().A0G().getHeight(), c1913bK.A0E().A0G().getWidth(), c1913bK.A0G(), A02(0, 6, 2)));
                }
                if (c1913bK.A0E().A0F() != null) {
                    c11006c.A0b(new C10986a(c1913bK.A0E().A0F().getUrl(), c1913bK.A0E().A0F().getHeight(), c1913bK.A0E().A0F().getWidth(), c1913bK.A0G(), A02(0, 6, 2)));
                }
                if (!TextUtils.isEmpty(c1913bK.A0E().A0d())) {
                    c11006c.A0a(new C6Y(c1913bK.A0E().A0d(), c1913bK.A0G(), A02(0, 6, 2), c1913bK.A0E().A0A()));
                }
            }
        }
        c11006c.A0W(new ZB(this, list), new C6V(strA02, A02(0, 6, 2)));
    }
}
