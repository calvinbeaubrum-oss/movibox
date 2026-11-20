package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import org.mvel2.ast.ASTNode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class NH implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ NJ A00;

    static {
        A01();
    }

    public NH(NJ nj2) {
        this.A00 = nj2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-58, -57, -44, -38, -39, -97, -57, -47, -58, -45, -48, Ascii.DC4, 33, Ascii.DC2, Ascii.DC4, Ascii.SYN, 39, Ascii.FS, 41, Ascii.FS, 39, 44, -60, -47, -57, -43, -46, -52, -57, -111, -52, -47, -41, -56, -47, -41, -111, -60, -58, -41, -52, -46, -47, -111, -71, -84, -88, -70};
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.A00.A07) && !A00(0, 11, 35).equals(this.A00.A07)) {
                Intent intent = new Intent(A00(22, 26, 33), AbstractC1446Ky.A00(this.A00.A07));
                intent.addFlags(ASTNode.DEOP);
                this.A00.A0B.A0E().A8g();
                try {
                    C1433Kj.A0C(this.A00.A0B, intent);
                    this.A00.A05.ACR();
                } catch (C1431Kh e11) {
                    Throwable cause = e11.getCause();
                    C1431Kh cause2 = e11;
                    if (cause != null) {
                        cause2 = e11.getCause();
                    }
                    this.A00.A0B.A07().A9a(A00(11, 11, 113), C8A.A00, new C8B(cause2));
                }
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
