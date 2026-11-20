package com.transsion.http;

import android.os.Looper;
import androidx.annotation.NonNull;
import au.g;
import bu.a;
import com.transsion.http.impl.s;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import vt.b;
import vt.d;
import wt.h;
import wt.j;
import zt.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class HttpRequestTask implements Runnable, Comparable<HttpRequestTask> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f52809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f52810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f52811c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f52812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f52813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakReference<Object> f52814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f52815g;

    public HttpRequestTask(b bVar, s sVar) {
        this.f52809a = sVar;
        g gVarD = bVar.d();
        this.f52810b = gVarD;
        this.f52812d = bVar.b();
        this.f52814f = new WeakReference<>(gVarD.d().m());
        this.f52815g = bVar.c().o();
    }

    private void a() throws IOException {
        s sVar;
        s sVar2;
        try {
            this.f52810b.h();
            if (isCancelled()) {
                return;
            }
            byte[] bArrD = a.d(a.b(this.f52810b.c()));
            if (!this.f52815g && (sVar2 = this.f52809a) != null) {
                sVar2.f(this.f52810b.f(), bArrD, this.f52810b.g());
            }
            String strB = (!this.f52810b.d().p() || this.f52812d == null) ? null : ((wt.b) this.f52812d).b(new d(this.f52810b.d().n()), new j(new wt.a(), ByteBuffer.wrap(bArrD)));
            if (this.f52815g && (sVar = this.f52809a) != null) {
                sVar.c(this.f52810b.f(), bArrD, strB);
            }
        } finally {
            this.f52810b.a();
        }
    }

    private synchronized void b() {
        s sVar;
        if (!this.f52813e && this.f52811c.get() && (sVar = this.f52809a) != null) {
            sVar.g();
        }
    }

    public boolean cancel() {
        this.f52811c.set(true);
        this.f52810b.a();
        return isCancelled();
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull HttpRequestTask httpRequestTask) {
        return 0;
    }

    public Object getTag() {
        return this.f52814f;
    }

    public boolean isCancelled() {
        boolean z11 = this.f52811c.get();
        if (z11) {
            b();
        }
        return z11;
    }

    public boolean isDone() {
        return isCancelled() || this.f52813e;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0119 A[PHI: r0
  0x0119: PHI (r0v5 wt.h) = (r0v4 wt.h), (r0v11 wt.h) binds: [B:56:0x0117, B:48:0x00f9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.lang.Runnable
    public void run() {
        h hVar;
        s sVar;
        h hVar2;
        File fileA;
        c cVar = zt.a.f82154a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("run Current Looper:");
        sb2.append(Looper.myLooper() == Looper.getMainLooper() ? "Main Looper" : "thread Looper");
        cVar.d("book", sb2.toString());
        if (isCancelled()) {
            return;
        }
        s sVar2 = this.f52809a;
        if (sVar2 != null) {
            sVar2.a();
        }
        try {
            try {
                if (!this.f52810b.d().p() || (hVar2 = this.f52812d) == null || (fileA = ((wt.b) hVar2).a(new d(this.f52810b.d().n()))) == null || !fileA.exists() || fileA.length() <= 0) {
                    a();
                } else {
                    c cVar2 = zt.a.f82154a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("image url:");
                    sb3.append(this.f52810b.d().n());
                    cVar2.d("image", sb3.toString());
                    c cVar3 = zt.a.f82154a;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("image path:");
                    sb4.append(fileA.getPath());
                    cVar3.d("image", sb4.toString());
                    if (isCancelled()) {
                        this.f52810b.a();
                        h hVar3 = this.f52812d;
                        if (hVar3 != null) {
                            ((wt.b) hVar3).c();
                            return;
                        }
                        return;
                    }
                    s sVar3 = this.f52809a;
                    if (sVar3 != null) {
                        if (this.f52815g) {
                            sVar3.c(250, a.d(a.a(fileA)), fileA.getPath());
                        } else {
                            sVar3.d(250, a.d(a.a(fileA)));
                        }
                    }
                }
                this.f52810b.a();
                hVar = this.f52812d;
                if (hVar != null) {
                    ((wt.b) hVar).c();
                }
            } catch (Exception e11) {
                if (!isCancelled() && (sVar = this.f52809a) != null) {
                    sVar.e(this.f52810b.f(), null, e11);
                }
                this.f52810b.a();
                hVar = this.f52812d;
                if (hVar != null) {
                    ((wt.b) hVar).c();
                }
            }
            if (isCancelled()) {
                return;
            }
            s sVar4 = this.f52809a;
            if (sVar4 != null) {
                sVar4.b();
            }
            this.f52813e = true;
        } catch (Throwable th2) {
            this.f52810b.a();
            h hVar4 = this.f52812d;
            if (hVar4 != null) {
                ((wt.b) hVar4).c();
            }
            throw th2;
        }
    }
}
