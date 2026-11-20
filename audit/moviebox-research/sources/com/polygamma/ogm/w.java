package com.polygamma.ogm;

import androidx.compose.animation.core.j0;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p007do.c f48889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ eo.z f48890b;

    public w(eo.z zVar, p007do.c cVar) {
        this.f48890b = zVar;
        this.f48889a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        eo.z zVar = this.f48890b;
        while (zVar.f64335e.get() == this) {
            try {
                p007do.c cVar = this.f48889a;
                WeakReference weakReference = zVar.f64336f;
                if (cVar != (weakReference == null ? null : (p007do.c) weakReference.get())) {
                    break;
                }
                String str = (String) zVar.f64334d.poll();
                if (str == null) {
                    Lock lockWriteLock = zVar.f64333c.writeLock();
                    lockWriteLock.lock();
                    try {
                        if (zVar.f64334d.isEmpty()) {
                            lockWriteLock.unlock();
                            break;
                        }
                        lockWriteLock.unlock();
                    } catch (Throwable th2) {
                        lockWriteLock.unlock();
                        throw th2;
                    }
                } else {
                    this.f48889a.f63437e.evaluateJavascript(str, null);
                    com.google.common.util.concurrent.s sVar = eo.z.f64330j;
                }
            } catch (Throwable th3) {
                j0.a(zVar.f64335e, this, null);
                throw th3;
            }
        }
        j0.a(zVar.f64335e, this, null);
    }
}
