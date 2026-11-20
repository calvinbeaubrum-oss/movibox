package com.mbridge.msdk.foundation.same.net;

import android.os.Process;
import com.mbridge.msdk.foundation.same.net.stack.OkHttpStack;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f44651a = "h";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f44652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f44653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.net.stack.b f44654d;

    public h(c cVar) {
        a();
        this.f44653c = new com.mbridge.msdk.foundation.same.net.f.a(this.f44654d, cVar);
        this.f44652b = cVar;
    }

    public h(c cVar, com.mbridge.msdk.foundation.same.net.stack.b bVar) {
        if (bVar == null) {
            a();
        } else {
            this.f44654d = bVar;
        }
        this.f44653c = new com.mbridge.msdk.foundation.same.net.f.a(this.f44654d, cVar);
        this.f44652b = cVar;
    }

    private void a() {
        try {
            if (com.mbridge.msdk.f.c.b()) {
                this.f44654d = new com.mbridge.msdk.foundation.same.net.stack.a();
                return;
            }
        } catch (Throwable th2) {
            ad.b(f44651a, th2.getMessage());
        }
        this.f44654d = new OkHttpStack();
    }

    public final void a(i iVar) {
        Process.setThreadPriority(10);
        try {
            this.f44652b.d(iVar);
            if (iVar.q()) {
                iVar.a("network-discard-cancelled");
                this.f44652b.a(iVar);
                this.f44652b.b(iVar);
            } else {
                this.f44652b.c(iVar);
                this.f44652b.a((i<?>) iVar, iVar.a(this.f44653c.a(iVar)));
            }
        } catch (com.mbridge.msdk.foundation.same.net.b.a e11) {
            this.f44652b.a((i<?>) iVar, e11);
        } catch (Exception e12) {
            ad.b(f44651a, "Unhandled exception " + e12.getMessage());
            this.f44652b.a((i<?>) iVar, new com.mbridge.msdk.foundation.same.net.b.a(4, null));
        }
    }
}
