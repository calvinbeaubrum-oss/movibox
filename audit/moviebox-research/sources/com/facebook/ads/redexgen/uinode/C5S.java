package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5S, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C5S {
    public static byte[] A04;
    public final Intent A00;
    public final C5V A01;
    public final C1795Yn A02;
    public final J2 A03;

    static {
        A0T();
    }

    public C5S(C5V c5v, Intent intent, J2 j11, C1795Yn c1795Yn) {
        this.A01 = c5v;
        this.A00 = intent;
        this.A03 = j11;
        this.A02 = c1795Yn;
    }

    public /* synthetic */ C5S(C5V c5v, Intent intent, J2 j11, C1795Yn c1795Yn, C5R c5r) {
        this(c5v, intent, j11, c1795Yn);
    }

    private FU A00() {
        return (FU) this.A00.getSerializableExtra(A0S(2, 14, 51));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MD A02() {
        C5R c5r = null;
        if (!C1384Ih.A2N(this.A02)) {
            C5V c5v = this.A01;
            return new UT(c5v, this.A02, this.A03, new ZW(c5v, c5r));
        }
        String stringExtra = this.A00.getStringExtra(A0S(45, 23, 41));
        C5V c5v2 = this.A01;
        C1795Yn c1795Yn = this.A02;
        J2 j11 = this.A03;
        ZW zw2 = new ZW(c5v2, c5r);
        String stringExtra2 = this.A00.getStringExtra(A0S(16, 10, 116));
        if (stringExtra == null) {
            stringExtra = A0S(0, 2, 29);
        }
        return new ViewOnClickListenerC1223Bi(c5v2, c1795Yn, j11, zw2, stringExtra2, Integer.parseInt(stringExtra));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UD A0G() {
        return new UD(this.A02, this.A03, new ZW(this.A01, null), A00(), null, new U9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UD A0H() {
        FS fs2 = (FS) this.A00.getSerializableExtra(A0S(86, 25, 43));
        return new UD(this.A02, this.A03, new C1277Ea(this.A01, null), fs2, fs2.A0T(), new U8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UA A0I(RelativeLayout relativeLayout) {
        UA ua2 = new UA(this.A02, new ZV(this), this.A03, new ZW(this.A01, null));
        ua2.A05(relativeLayout);
        ua2.A04(this.A00.getIntExtra(A0S(111, 27, 118), 200));
        AbstractC1462Lo.A0M(relativeLayout, ViewCompat.MEASURED_STATE_MASK);
        return ua2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public B3 A0J() {
        return new B3(this.A02, this.A03, new ZW(this.A01, null), A00(), new U9(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public B3 A0K() {
        return new B3(this.A02, this.A03, new ZW(this.A01, null), (FS) this.A00.getSerializableExtra(A0S(86, 25, 43)), new U8(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TI A0L() {
        PB pbA02;
        AbstractC1898b5 abstractC1898b5 = (AbstractC1898b5) this.A00.getSerializableExtra(A0S(68, 18, 21));
        C5R c5r = null;
        if (abstractC1898b5 == null || (pbA02 = PC.A02(abstractC1898b5.A0S())) == null) {
            return null;
        }
        return new TI(this.A02, new ZW(this.A01, c5r), pbA02, abstractC1898b5.A12());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1644So A0M(KB kb2) {
        InterfaceC1483Mj u11;
        MC c1277Ea;
        C1896b3 c1896b3 = (C1896b3) this.A00.getSerializableExtra(A0S(26, 19, 124));
        C5R c5r = null;
        if (kb2 == KB.A04) {
            u11 = new U9();
            c1277Ea = new ZW(this.A01, c5r);
        } else {
            u11 = new U8();
            c1277Ea = new C1277Ea(this.A01, c5r);
        }
        return new C1644So(this.A02, u11, this.A03, c1896b3, new C11006c(this.A02), c1277Ea);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C9Y A0N() {
        return new C9Y(this.A02, new U9(), this.A03, A00(), new C11006c(this.A02), new ZW(this.A01, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C9Q A0O() {
        return new C9Q(this.A02, new U9(), this.A03, A00(), new C11006c(this.A02), new ZW(this.A01, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C9Q A0P() {
        return new C9Q(this.A02, new U8(), this.A03, (FS) this.A00.getSerializableExtra(A0S(86, 25, 43)), new C11006c(this.A02), new C1277Ea(this.A01, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C9P A0Q() {
        FU fuA00 = A00();
        fuA00.A0Z(this.A01.A0C);
        return new C9P(this.A02, this.A03, new C11006c(this.A02), new ZW(this.A01, null), fuA00);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C9P A0R() {
        FS fs2 = (FS) this.A00.getSerializableExtra(A0S(86, 25, 43));
        fs2.A0Z(this.A01.A0C);
        return new C9P(this.A02, this.A03, new C11006c(this.A02), new ZW(this.A01, null), fs2);
    }

    public static String A0S(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0T() {
        A04 = new byte[]{Ascii.DEL, 99, Ascii.GS, Ascii.CAN, 35, Ascii.CAN, Ascii.GS, 8, Ascii.GS, 35, Ascii.RS, 9, Ascii.DC2, Ascii.CAN, Ascii.DLE, Ascii.EM, 88, 90, 87, 87, 94, 73, 111, 66, 75, 94, 80, 91, 82, 90, 93, 86, 87, 114, 87, 119, 82, 71, 82, 113, 70, 93, 87, 95, 86, 0, Ascii.SI, 10, Ascii.DC2, 3, Ascii.DC4, 3, 2, 57, 5, 10, Ascii.SI, 5, Ascii.CR, 57, 2, 3, 10, 7, Ascii.US, 57, Ascii.VT, Ascii.NAK, 52, 59, 46, 51, 44, Utf8.REPLACEMENT_BYTE, Ascii.ESC, 62, Ascii.RS, 59, 46, 59, Ascii.CAN, 47, 52, 62, 54, Utf8.REPLACEMENT_BYTE, Ascii.SYN, 1, 19, 5, Ascii.SYN, 0, 1, 0, 50, Ascii.CR, 0, 1, Ascii.VT, 37, 0, 32, 5, Ascii.DLE, 5, 38, 17, 10, 0, 8, 1, 79, 80, 93, 92, 86, 102, 77, 80, 84, 92, 102, 73, 86, 85, 85, 80, 87, 94, 102, 80, 87, 77, 92, 75, 79, 88, 85};
    }

    public final UC A0U() {
        return new UC(this.A02, this.A01);
    }
}
