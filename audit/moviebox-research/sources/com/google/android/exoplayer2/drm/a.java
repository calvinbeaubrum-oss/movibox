package com.google.android.exoplayer2.drm;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.s;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.g1;
import com.google.common.primitives.Ints;
import java.util.Map;
import sg.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f33160a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u1.f f33161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f33162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public k.a f33163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public String f33164e;

    @Override // sg.u
    public c a(u1 u1Var) {
        c cVar;
        com.google.android.exoplayer2.util.a.e(u1Var.f34776b);
        u1.f fVar = u1Var.f34776b.f34841c;
        if (fVar == null || o0.f35608a < 18) {
            return c.f33170a;
        }
        synchronized (this.f33160a) {
            try {
                if (!o0.c(fVar, this.f33161b)) {
                    this.f33161b = fVar;
                    this.f33162c = b(fVar);
                }
                cVar = (c) com.google.android.exoplayer2.util.a.e(this.f33162c);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    @RequiresApi(18)
    public final c b(u1.f fVar) {
        k.a aVarB = this.f33163d;
        if (aVarB == null) {
            aVarB = new s.b().b(this.f33164e);
        }
        Uri uri = fVar.f34810c;
        i iVar = new i(uri == null ? null : uri.toString(), fVar.f34815h, aVarB);
        g1<Map.Entry<String, String>> it = fVar.f34812e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            iVar.e(next.getKey(), next.getValue());
        }
        DefaultDrmSessionManager defaultDrmSessionManagerA = new DefaultDrmSessionManager.b().e(fVar.f34808a, h.f33179d).b(fVar.f34813f).c(fVar.f34814g).d(Ints.m(fVar.f34817j)).a(iVar);
        defaultDrmSessionManagerA.E(0, fVar.c());
        return defaultDrmSessionManagerA;
    }
}
