package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class R0 {
    public static R0 A09;
    public static byte[] A0A;
    public static final DownloadAction.Deserializer[] A0B;
    public EG A00;
    public HK A01;
    public File A02;
    public boolean A03;
    public final C1794Ym A06;
    public final E9 A07;
    public final Handler A04 = new Handler(Looper.getMainLooper());
    public final SparseArray<C1602Qy> A05 = new SparseArray<>();
    public final Runnable A08 = new RunnableC1601Qx(this);

    static {
        A0C();
        A0B = new DownloadAction.Deserializer[]{WY.A03};
    }

    public R0(C1794Ym c1794Ym, EG eg2) {
        C1421Jw c1421Jw = new C1421Jw(this);
        this.A07 = c1421Jw;
        this.A06 = c1794Ym;
        if (eg2 != null) {
            this.A00 = eg2;
            eg2.A0Q(c1421Jw);
        }
        A01().A0P();
    }

    private synchronized EG A01() {
        if (this.A00 == null) {
            EG eg2 = new EG(new EL(A03(), A02()), 10, 5, new File(A06(), A07(52, 12, 89)), A0B);
            this.A00 = eg2;
            eg2.A0Q(this.A07);
        }
        return this.A00;
    }

    private AnonymousClass41 A02() {
        return new AnonymousClass41(A07(78, 3, 89), null);
    }

    private final synchronized HK A03() {
        if (this.A01 == null) {
            this.A01 = new C1713Vg(new File(A06(), A07(64, 14, 16)), new C1225Bk(C1384Ih.A0P(this.A06)));
        }
        return this.A01;
    }

    public static C1716Vj A04(C1732Vz c1732Vz, HK hk2) {
        return new C1716Vj(hk2, c1732Vz, new C1728Vv(), null, 2, null);
    }

    public static synchronized R0 A05(C1794Ym c1794Ym) {
        if (A09 == null) {
            A09 = new R0(c1794Ym, null);
        }
        return A09;
    }

    private File A06() {
        if (this.A02 == null) {
            this.A02 = this.A06.getCacheDir();
        }
        return this.A02;
    }

    public static String A07(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A08(C1794Ym c1794Ym, Uri uri) {
        try {
            if (C1384Ih.A1T(c1794Ym)) {
                return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment()).toString();
            }
            return null;
        } catch (URISyntaxException e11) {
            c1794Ym.A07().A9a(A07(81, 5, 14), C8A.A0u, new C8B(e11));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09() {
        for (EF ef2 : A01().A0S()) {
            int i11 = ef2.A02;
            C1602Qy c1602Qy = this.A05.get(i11);
            if (c1602Qy != null) {
                int i12 = ef2.A01;
                if (i12 == 2 || ef2.A03 > c1602Qy.A00) {
                    String str = A07(15, 19, 61) + i12 + A07(0, 8, 18) + ef2.A03;
                    c1602Qy.A01.ABL(c1602Qy.A02);
                    this.A05.remove(i11);
                } else if (i12 == 4 || i12 == 3) {
                    String str2 = A07(34, 14, 111) + i12;
                    c1602Qy.A01.ABT(ef2.A05);
                    this.A05.remove(i11);
                }
            }
            String str3 = A07(48, 4, 25) + i11 + A07(8, 7, 52) + ef2.A03;
        }
    }

    private void A0A() {
        if (this.A03) {
            return;
        }
        this.A03 = true;
        this.A04.post(this.A08);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B() {
        this.A04.removeCallbacks(this.A08);
        this.A03 = false;
    }

    public static void A0C() {
        A0A = new byte[]{-103, -69, -14, -19, -34, -20, -77, -103, -69, -3, Ascii.DC4, Ascii.SI, 0, Ascii.SO, -69, -24, 19, Ascii.ESC, Ascii.DC2, Ascii.DLE, 19, 5, 8, 9, 8, -46, -60, -9, Ascii.CAN, 5, Ascii.CAN, 9, -34, -60, Ascii.ESC, 72, 72, 69, 72, 4, -10, 41, 74, 55, 74, 59, Ascii.DLE, -10, -44, -31, -13, -21, 33, 36, 46, 55, -19, 33, 35, 52, 41, 47, 46, 51, -40, -37, -27, -18, -92, -37, -26, -18, -27, -29, -26, -40, -37, -22, 33, 36, 51, -40, -42, -40, -35, -38};
    }

    public final C1716Vj A0F(Context context) {
        return A04(new C1732Vz(context, (HG<? super InterfaceC1346Gu>) null, A02()), A03());
    }

    public final void A0G(Uri uri, InterfaceC1603Qz interfaceC1603Qz, long j11) {
        String strA08 = A08(this.A06, uri);
        if (strA08 == null) {
            strA08 = uri.toString();
        }
        boolean zA0H = A0H(strA08);
        this.A05.put(A01().A0O(new WY(uri, false, null, strA08)), new C1602Qy(interfaceC1603Qz, j11, zA0H, null));
        A0A();
    }

    public final boolean A0H(String str) {
        return A03().A6G(str, 0L, 1L) > 0;
    }
}
