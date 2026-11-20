package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6X, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C6X implements Callable<Boolean> {
    public final BlockingQueue<Boolean> A00 = new LinkedBlockingQueue();
    public final /* synthetic */ C11006c A01;

    public C6X(C11006c c11006c, C6Y c6y) {
        this.A01 = c11006c;
        new Handler(Looper.getMainLooper()).post(new C1798Yq(this, c11006c, c6y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Boolean call() throws Exception {
        return this.A00.take();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(C6Y c6y) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        R0 r0A05 = R0.A05(this.A01.A04.A01());
        Uri uriA00 = AbstractC1446Ky.A00(c6y.A08);
        long jA0O = c6y.A00;
        if (jA0O == -1) {
            jA0O = C1384Ih.A0O(this.A01.A04);
        }
        r0A05.A0G(uriA00, new C1797Yp(this, c6y, jA0O, jCurrentTimeMillis), jA0O);
    }
}
