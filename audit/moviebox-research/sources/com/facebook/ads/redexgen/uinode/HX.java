package com.facebook.ads.redexgen.uinode;

import android.os.ConditionVariable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class HX extends Thread {
    public final /* synthetic */ ConditionVariable A00;
    public final /* synthetic */ C1713Vg A01;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HX(C1713Vg c1713Vg, String str, ConditionVariable conditionVariable) {
        super(str);
        this.A01 = c1713Vg;
        this.A00 = conditionVariable;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x001a */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            synchronized (this.A01) {
                try {
                    this.A00.open();
                    this.A01.A04();
                } catch (Throwable th2) {
                    th = th2;
                    while (true) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th3) {
            KL.A00(th3, this);
        }
    }
}
