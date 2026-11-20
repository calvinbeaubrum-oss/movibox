package com.bytedance.sdk.component.TRI.sc.zY;

import com.bytedance.sdk.component.TRI.sc.ExN;
import com.bytedance.sdk.component.TRI.sc.Qj;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    public static void sc(AtomicLong atomicLong, int i11) {
        ExN exNDE = Qj.qr().dE();
        if (exNDE == null || !exNDE.qr() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i11);
    }
}
