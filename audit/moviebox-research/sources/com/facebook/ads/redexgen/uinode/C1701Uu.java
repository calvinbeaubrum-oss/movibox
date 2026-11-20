package com.facebook.ads.redexgen.uinode;

import android.content.pm.PackageManager;
import android.util.Base64;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1701Uu extends KT {
    public static byte[] A02;
    public final /* synthetic */ K1 A00;
    public final /* synthetic */ K4 A01;

    static {
        A02();
    }

    public C1701Uu(K4 k11, K1 k12) {
        this.A01 = k11;
        this.A00 = k12;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 119);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{10, 75, 89, 68, 71, 72, 72, 67, 84, 89, 77, 67, 95, 101, 68, Ascii.VT, 69, 78, 95, 92, 68, 89, 64, Ascii.VT, 72, 68, 69, 69, 78, 72, 95, 66, 68, 69};
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        if (AbstractC1451Ld.A00(this.A01.A04) == EnumC1450Lc.A07) {
            this.A01.A09();
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String strA00 = A00(13, 21, 92);
            this.A01.A04.A0E().A2v(C1453Lf.A01(this.A01.A00), adErrorType.getErrorCode(), strA00, adErrorType.isPublicError());
            this.A01.A0D(new C1401Jb(adErrorType, strA00));
            return;
        }
        C8J.A08(this.A01.A04);
        C6E.A07(this.A01.A04);
        boolean z11 = true;
        Map<String, String> mapA09 = this.A00.A09(C11508l.A00().A01(this.A01.A04, true).A6w(this.A00.A05()));
        this.A01.A02 = mapA09;
        try {
            PackageManager packageManager = this.A01.A04.getPackageManager();
            if (packageManager != null) {
                mapA09.put(A00(1, 12, 113), new String(Base64.encode((this.A01.A04.getPackageName() + A00(0, 1, 93) + packageManager.getInstallerPackageName(this.A01.A04.getPackageName())).getBytes(), 2)));
            }
        } catch (Exception unused) {
        }
        try {
            if (this.A00.A06() != EnumC1405Jg.A03 && this.A00.A06() != EnumC1405Jg.A05 && this.A00.A06() != EnumC1405Jg.A04 && this.A00.A06() != null) {
                z11 = false;
            }
            C1606Rc.A02(z11, this.A01.A04).AE0(this.A01.A06, new RY().A05(this.A01.A02).A08(), this.A01.A02(C1453Lf.A00(), this.A00));
        } catch (Exception e11) {
            AdErrorType adErrorType2 = AdErrorType.AD_REQUEST_FAILED;
            String message = e11.getMessage();
            this.A01.A04.A0E().A2v(C1453Lf.A01(this.A01.A00), adErrorType2.getErrorCode(), message, adErrorType2.isPublicError());
            this.A01.A0D(C1401Jb.A01(adErrorType2, message));
        }
    }
}
