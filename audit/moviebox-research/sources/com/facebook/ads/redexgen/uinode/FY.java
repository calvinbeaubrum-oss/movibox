package com.facebook.ads.redexgen.uinode;

import android.content.ContentResolver;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.ws.WebSocketProtocol;
import org.mvel2.ast.ASTNode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FY extends AbstractC1902b9 {
    public static C11006c A0D;
    public static byte[] A0E;
    public static String[] A0F = {"YJVWhBFSVFKs7NrWmWULGh", "0GvTyPfIpVaCupDTXIuhVv", "vKmpQ0k2zgunQxdAFsx7Wlk6dmYtSCUc", "dqRYVPDeGy45RCRFCWIUPRHRtp9NBigI", "NSweCua6lZ8ChPFZ3cKnaOBscLcsrWLc", "HenZyTRrHhMHTWT00jKprDJGPW9d4C4V", "lvvcgtkpn6JHhS0LrJ19j3FN0lJsZZOv", "GmBDkEWrzwPugE8SLtTHysECIxUFQGpg"};
    public long A00;
    public AnonymousClass18 A01;
    public AnonymousClass19 A02;
    public C1F A03;
    public C1795Yn A04;
    public KB A05;
    public PB A06;
    public String A07;
    public String A08;
    public String A09;
    public String A0A;
    public final String A0B = UUID.randomUUID().toString();
    public final AtomicBoolean A0C = new AtomicBoolean();

    static {
        A08();
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ WebSocketProtocol.PAYLOAD_SHORT);
        }
        return new String(bArrCopyOfRange);
    }

    private void A06() {
        C10102o c10102oA00 = C10102o.A00(this.A04);
        AnonymousClass19 anonymousClass19 = this.A02;
        c10102oA00.A06(anonymousClass19, anonymousClass19.A00());
    }

    private void A07() {
        if (this.A02 != null) {
            try {
                C10102o.A00(this.A04).A05(this.A02);
            } catch (Exception unused) {
            }
        }
    }

    public static void A08() {
        A0E = new byte[]{56, 52, 54, 54, 48, 57, 48, 39, 58, 56, 48, 33, 48, 39, 10, 39, 58, 33, 52, 33, 60, 58, 59, 108, 99, 82, 108, 110, 121, 100, 123, 100, 121, 116, 9, 2, Ascii.VT, 3, 4, Ascii.SI, Ascii.SO, 43, Ascii.SO, 46, Ascii.VT, Ascii.RS, Ascii.VT, 40, Ascii.US, 4, Ascii.SO, 6, Ascii.SI, 68, 76, 77, 64, 72, 93, 64, 70, 71, 109, 72, 93, 72, Ascii.FF, Ascii.DLE, Ascii.GS, Ascii.US, Ascii.EM, 17, Ascii.EM, Ascii.DC2, 8, 53, Ascii.CAN, 87, 85, 66, 67, 66, 65, 78, 73, 66, 67, 104, 85, 78, 66, 73, 83, 70, 83, 78, 72, 73, 108, 66, 94, 4, 19, 7, 3, 19, 5, 2, 34, Ascii.US, Ascii.ESC, 19, 104, Ascii.DEL, 109, 123, 104, 126, 73, Ascii.DEL, 104, 108, Ascii.DEL, 104, 79, 72, 86, Ascii.EM, Ascii.SO, Ascii.FS, 10, Ascii.EM, Ascii.SI, Ascii.SO, Ascii.SI, 61, 2, Ascii.SI, Ascii.SO, 4, 42, Ascii.SI, 47, 10, Ascii.US, 10, 41, Ascii.RS, 5, Ascii.SI, 7, Ascii.SO, 87, 64, 82, 68, 87, 65, 64, 65, 122, 83, 76, 65, 64, 74, 124, 103, 96, 120, 124, 108, 64, 109, 83, 76, 64, 82, 113, 92, 85, 64};
    }

    private void A09(Intent intent) {
        int i11 = super.A00;
        String strA04 = A04(77, 24, 89);
        if (i11 != -1) {
            ContentResolver contentResolver = this.A04.getContentResolver();
            if (A0F[3].charAt(29) != 'i') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[7] = "ryaiaZaF8EzuUPZd67FeoIG9jUALGHZG";
            strArr[6] = "XITZtpYy2wf6QHmOozCOnY6Xlkm3ca51";
            if (Settings.System.getInt(contentResolver, A04(1, 22, 43), 0) != 1) {
                int i12 = super.A00;
                if (A0F[2].charAt(2) != 'm') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0F;
                strArr2[1] = "mo2n49jFbf8CHvb7nubztA";
                strArr2[0] = "3h0LYrxRFByrgEG7Z48zJG";
                intent.putExtra(strA04, i12);
                return;
            }
        }
        if (C1384Ih.A0d(this.A04)) {
            return;
        }
        intent.putExtra(strA04, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B(C1795Yn c1795Yn, C1896b3 c1896b3, int i11) {
        if (i11 >= c1896b3.A0s()) {
            return;
        }
        FS fs2 = (FS) c1896b3.A0v(i11);
        C11006c c11006c = new C11006c(c1795Yn);
        A0D = c11006c;
        c11006c.A0d(new JA(fs2.A12(), c1795Yn.A09()));
        AbstractC09891t.A02(c1795Yn, A0D, fs2);
        A0D.A0W(new FZ(this, i11 == 0, c1795Yn, fs2, c1896b3, i11), new C6V(fs2.A0S(), A04(152, 14, 91), i11));
    }

    private void A0C(boolean z11) {
        if (this.A05 == KB.A0F) {
            A0E(z11);
            return;
        }
        KB kb2 = this.A05;
        String[] strArr = A0F;
        if (strArr[1].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0F;
        strArr2[4] = "1yOiFacRiwJanRzqDJ6A5hJ77lYfziAe";
        strArr2[5] = "McEelBumOV7dKb1zb6BdvUT5HG6VvrgI";
        if (kb2 == KB.A0H) {
            A0F(z11);
        } else if (this.A05 == KB.A0G) {
            A0D(z11);
        } else {
            A0F(z11);
        }
    }

    private void A0D(boolean z11) {
        C11006c c11006c = new C11006c(this.A04);
        boolean z12 = C1384Ih.A1n(this.A04) && AnonymousClass62.A0A(this.A03.A0V());
        if (!z12) {
            AbstractC09881s.A02(this.A04, (AbstractC1898b5) this.A03, z11, new C1907bE(this));
            return;
        }
        AnonymousClass62 anonymousClass62 = new AnonymousClass62(c11006c, this.A03.A0V(), this.A03.A0P(), this.A03.A0S(), z12, new C1908bF(this));
        c11006c.A0d(new JA(((AbstractC1898b5) this.A03).A12(), this.A04.A09()));
        anonymousClass62.A0B();
    }

    private void A0E(boolean z11) {
        C11006c c11006c = new C11006c(this.A04);
        c11006c.A0d(new JA(((AbstractC1898b5) this.A03).A12(), this.A04.A09()));
        AbstractC09891t.A03(this.A04, c11006c, (FS) this.A03);
        c11006c.A0W(new C1912bJ(this), new C6V(this.A03.A0S(), A04(152, 14, 91)));
    }

    private void A0F(boolean z11) {
        boolean z12 = false;
        if (this.A03.A0j()) {
            C1896b3 c1896b3 = (C1896b3) this.A03;
            for (int i11 = 0; i11 < c1896b3.A0s(); i11++) {
                if (TextUtils.isEmpty(c1896b3.A0v(i11).A0x().A0D().A08())) {
                    this.A01.AD1(this, AdError.INTERNAL_ERROR);
                    return;
                }
            }
            A0B(this.A04, c1896b3, 0);
            return;
        }
        C11006c c11006c = new C11006c(this.A04);
        c11006c.A0d(new JA(((AbstractC1898b5) this.A03).A12(), this.A04.A09()));
        if (C1384Ih.A1n(this.A04) && AnonymousClass62.A0A(this.A03.A0V())) {
            z12 = true;
        }
        boolean zA0m = this.A03.A0m();
        if (z12) {
            new AnonymousClass62(c11006c, this.A03.A0V(), this.A03.A0P(), this.A03.A0S(), z12, new C1910bH(this, zA0m)).A0B();
            return;
        }
        FS fs2 = (FS) this.A03;
        if (TextUtils.isEmpty(fs2.A0x().A0D().A08())) {
            this.A01.AD1(this, AdError.INTERNAL_ERROR);
        } else {
            AbstractC09891t.A02(this.A04, c11006c, fs2);
            c11006c.A0W(new C1303Fa(this, z11, zA0m, fs2, this), new C6V(fs2.A0S(), A04(152, 14, 91)));
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1902b9
    public final int A0G() {
        C1F c1f = this.A03;
        if (c1f != null) {
            return c1f.A0G();
        }
        String[] strArr = A0F;
        if (strArr[4].charAt(5) == strArr[5].charAt(5)) {
            throw new RuntimeException();
        }
        A0F[3] = "zy8kAWNFspHhc9OUOOhBHMIK4AaCMilm";
        return -1;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1902b9
    public final C1F A0H() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1902b9
    public final boolean A0I() {
        if (!this.A0C.get()) {
            return false;
        }
        this.A03.A0X(super.A01);
        String strA03 = Q7.A03(super.A02, this.A0B, this.A07);
        this.A03.A0Y(super.A02);
        this.A03.A0c(strA03);
        AdActivityIntent adActivityIntentA04 = C1433Kj.A04(this.A04);
        adActivityIntentA04.putExtra(A04(174, 8, 91), this.A05);
        adActivityIntentA04.putExtra(A04(127, 25, 21), this.A03);
        adActivityIntentA04.putExtra(A04(34, 19, 20), this.A03);
        adActivityIntentA04.putExtra(A04(166, 8, 119), this.A0B);
        if (strA03 != null) {
            adActivityIntentA04.putExtra(A04(112, 15, 100), strA03);
        }
        adActivityIntentA04.putExtra(A04(66, 11, 2), this.A0A);
        adActivityIntentA04.putExtra(A04(101, 11, 8), this.A00);
        String str = this.A09;
        if (str != null) {
            adActivityIntentA04.putExtra(A04(53, 13, 87), str);
        }
        A09(adActivityIntentA04);
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            adActivityIntentA04.setFlags(adActivityIntentA04.getFlags() | ASTNode.DEOP);
        }
        ActivityUtils.A03(this.A04);
        try {
            if (!ProcessUtils.isRemoteRenderingProcess()) {
                C1433Kj.A0A(this.A04, adActivityIntentA04);
                return true;
            }
            if (C1433Kj.A0J(this.A04, adActivityIntentA04)) {
                return true;
            }
            this.A04.A0E().AF0();
            AnonymousClass18 anonymousClass18 = this.A01;
            if (anonymousClass18 != null) {
                anonymousClass18.AD1(this, AdError.AD_PRESENTATION_ERROR);
            }
            return false;
        } catch (C1431Kh e11) {
            Throwable cause = e11.getCause();
            C1431Kh cause2 = e11;
            if (cause != null) {
                cause2 = e11.getCause();
            }
            this.A04.A07().A9a(A04(23, 11, 115), C8A.A01, new C8B(cause2));
            return true;
        }
    }

    public final void A0J(C1795Yn c1795Yn, AnonymousClass18 anonymousClass18, C09911v c09911v, boolean z11, String str, String str2) {
        this.A0C.set(false);
        this.A04 = c1795Yn;
        this.A01 = anonymousClass18;
        this.A0A = c09911v.A02();
        this.A00 = c09911v.A00();
        this.A09 = str2;
        String str3 = this.A0A;
        this.A07 = str3 != null ? str3.split(A04(0, 1, 25))[0] : A04(0, 0, 20);
        C1F c1fA00 = C1F.A00(c09911v.A03(), this.A04);
        this.A03 = c1fA00;
        c1fA00.A0a(str);
        this.A03.A0W(c09911v.A01().A06());
        if (this.A03.A0j()) {
            this.A08 = ((C1896b3) this.A03).A0y();
        } else {
            AbstractC1898b5 abstractC1898b5 = (AbstractC1898b5) this.A03;
            String[] strArr = A0F;
            if (strArr[7].charAt(31) != strArr[6].charAt(31)) {
                String[] strArr2 = A0F;
                strArr2[7] = "FFkeuuVk1meHqgTyMiNT7tgr8739x7mc";
                strArr2[6] = "JwuXN3bqyC9CcnquHiHDyzq7R0rb3kLZ";
                this.A08 = abstractC1898b5.A12();
            } else {
                String[] strArr3 = A0F;
                strArr3[7] = "QuYSy7nqZhyT9avsyztjWhd8F7hW1wjU";
                strArr3[6] = "5b6UXiMlNaCol2aZqv4zpvCfEMtgCuxD";
                this.A08 = abstractC1898b5.A12();
            }
        }
        boolean zA0m = this.A03.A0m();
        String[] strArr4 = A0F;
        if (strArr4[7].charAt(31) == strArr4[6].charAt(31)) {
            throw new RuntimeException();
        }
        String[] strArr5 = A0F;
        strArr5[7] = "T6UzDEu82kzY1KsvV3iHB7OkWnIxnMBs";
        strArr5[6] = "PWXGgNcAlDXPEXP1mMx0dPQCA8p68UI5";
        if (!zA0m) {
            switch (this.A03.A0F()) {
                case 0:
                    this.A05 = KB.A0H;
                    C0S c0sA0E = this.A04.A0E();
                    if (A0F[3].charAt(29) != 'i') {
                        A0F[3] = "i1vVIMuEE2CogviWDEosGc55NgD83ibP";
                        c0sA0E.AGG(EnumC09490e.A0C);
                    } else {
                        A0F[2] = "e7mQJdX4ST7JevLzoIctPRomcGPYY6Su";
                        c0sA0E.AGG(EnumC09490e.A0C);
                    }
                    break;
                case 1:
                    this.A05 = KB.A0G;
                    this.A04.A0E().AGG(EnumC09490e.A0B);
                    break;
                case 2:
                    this.A05 = KB.A05;
                    this.A04.A0E().AGG(EnumC09490e.A04);
                    break;
                case 3:
                    this.A05 = KB.A0F;
                    this.A04.A0E().AGG(EnumC09490e.A03);
                    break;
            }
        } else {
            this.A05 = KB.A08;
            if (this.A03.A0g()) {
                this.A04.A0E().AGG(EnumC09490e.A07);
            } else {
                this.A04.A0E().AGG(EnumC09490e.A09);
            }
        }
        if (C1384Ih.A0q(c1795Yn)) {
            if (this.A03.A0j()) {
                C1896b3 c1896b3 = (C1896b3) this.A03;
                for (int iA0s = c1896b3.A0s() - 1; iA0s >= 0; iA0s--) {
                    AbstractC1898b5 abstractC1898b5A0v = c1896b3.A0v(iA0s);
                    if (AbstractC09560l.A06(this.A04, AbstractC09560l.A01(c1795Yn, abstractC1898b5A0v.A0V(), abstractC1898b5A0v.A12()), c1795Yn.A09())) {
                        this.A04.A0E().A4K();
                        c1896b3.A10(iA0s);
                        return;
                    }
                }
                if (c1896b3.A0s() == 0) {
                    this.A01.AD1(this, AdError.NO_FILL);
                    return;
                }
            } else if (AbstractC09560l.A06(this.A04, AbstractC09560l.A01(c1795Yn, c09911v.A03(), ((AbstractC1898b5) this.A03).A12()), c1795Yn.A09())) {
                this.A04.A0E().A4K();
                this.A01.AD1(this, AdError.NO_FILL);
                return;
            }
        }
        this.A02 = new AnonymousClass19(this.A0B, this, anonymousClass18);
        A06();
        A0C(z11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09590p
    public final String A6T() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09590p
    public final boolean AGd() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09590p
    public final void onDestroy() {
        A07();
    }
}
