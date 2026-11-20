package com.pgl.ssdk;

import android.os.HandlerThread;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class x0 extends a1 implements y0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f48860b;

    public x0(HandlerThread handlerThread, a1.a aVar) {
        super(handlerThread.getLooper(), aVar);
        this.f48860b = handlerThread;
    }

    public void a(a1.a aVar) {
        this.f48716a = new WeakReference<>(aVar);
    }

    public void a(String str) {
        HandlerThread handlerThread = this.f48860b;
        if (handlerThread != null) {
            handlerThread.setName(str);
        }
    }
}
