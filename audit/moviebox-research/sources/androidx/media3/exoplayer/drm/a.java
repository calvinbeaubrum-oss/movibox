package androidx.media3.exoplayer.drm;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.b0;
import com.google.common.collect.g1;
import com.google.common.primitives.Ints;
import i4.u;
import java.util.Map;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10282a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0.f f10283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f10284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public androidx.media3.datasource.a.InterfaceC0090a f10285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public String f10286e;

    @Override // i4.u
    public c a(b0 b0Var) {
        c cVar;
        z3.a.e(b0Var.f8951b);
        b0.f fVar = b0Var.f8951b.f9049c;
        if (fVar == null || u0.f81838a < 18) {
            return c.f10292a;
        }
        synchronized (this.f10282a) {
            try {
                if (!u0.c(fVar, this.f10283b)) {
                    this.f10283b = fVar;
                    this.f10284c = b(fVar);
                }
                cVar = (c) z3.a.e(this.f10284c);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    @RequiresApi(18)
    public final c b(b0.f fVar) {
        androidx.media3.datasource.a.InterfaceC0090a interfaceC0090aC = this.f10285d;
        if (interfaceC0090aC == null) {
            interfaceC0090aC = new androidx.media3.datasource.c.b().c(this.f10286e);
        }
        Uri uri = fVar.f9004c;
        i iVar = new i(uri == null ? null : uri.toString(), fVar.f9009h, interfaceC0090aC);
        g1<Map.Entry<String, String>> it = fVar.f9006e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            iVar.e(next.getKey(), next.getValue());
        }
        DefaultDrmSessionManager defaultDrmSessionManagerA = new DefaultDrmSessionManager.b().e(fVar.f9002a, h.f10301d).b(fVar.f9007f).c(fVar.f9008g).d(Ints.m(fVar.f9011j)).a(iVar);
        defaultDrmSessionManagerA.E(0, fVar.c());
        return defaultDrmSessionManagerA;
    }
}
