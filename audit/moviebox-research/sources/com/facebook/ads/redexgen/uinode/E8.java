package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class E8 implements Runnable {
    public static byte[] A02;
    public final /* synthetic */ EG A00;
    public final /* synthetic */ DownloadAction[] A01;

    static {
        A01();
    }

    public E8(EG eg2, DownloadAction[] downloadActionArr) {
        this.A00 = eg2;
        this.A01 = downloadActionArr;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ WebSocketProtocol.PAYLOAD_SHORT);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{Ascii.RS, 53, 45, 52, 54, 53, 59, 62, Ascii.ETB, 59, 52, 59, 61, Utf8.REPLACEMENT_BYTE, 40, 105, 92, 75, 74, 80, 74, 77, 80, 87, 94, Ascii.EM, 88, 90, 77, 80, 86, 87, 74, Ascii.EM, 95, 88, 80, 85, 92, 93, Ascii.ETB};
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            try {
                this.A00.A09.A02(this.A01);
            } catch (IOException e11) {
                Log.e(A00(0, 15, 36), A00(15, 26, 71), e11);
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
