package com.facebook.ads.redexgen.uinode;

import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Od, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC1529Od implements View.OnTouchListener {
    public static byte[] A01;
    public static String[] A02 = {"IWk7s29a8CW3vlleHCDfAgE1s7GaPrN3", "GotOGy6JfY2C1poOz", "x44JkRqxpQdN5pJ4eQtPel4KzpxiNC69", "v", "k9cdUP", "QJZej3OaVhi0ilgrZ4I0rwFZFutNGTLV", "rZG0Brknx8nKyFnDp5S4OHtWYrbyN", "xZOvT4LNrEJqThSUBKywP"};
    public final /* synthetic */ TT A00;

    static {
        A01();
    }

    public ViewOnTouchListenerC1529Od(TT tt2) {
        this.A00 = tt2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{69, 67, 85, 66, 111, 83, 92, 89, 83, 91, 111, 89, 81, 82, 41, 47, 57, 46, 3, 55, 57, 37, 44, 61, 56, 3, Utf8.REPLACEMENT_BYTE, 48, 53, Utf8.REPLACEMENT_BYTE, 55, 3, 53, 61, 62};
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (!this.A00.A0S && this.A00.A0B != null && this.A00.A0B.isAcceptingText()) {
                    this.A00.A0S = true;
                    this.A00.A0f(A00(14, 21, 22));
                }
                break;
            case 1:
                TT.A05(this.A00);
                if (!this.A00.A0R && this.A00.A08 >= 5) {
                    this.A00.A0R = true;
                    this.A00.A0f(A00(0, 14, 122));
                }
                break;
        }
        String[] strArr = A02;
        if (strArr[5].charAt(7) != strArr[0].charAt(7)) {
            throw new RuntimeException();
        }
        A02[7] = "cX8Lo";
        return false;
    }
}
