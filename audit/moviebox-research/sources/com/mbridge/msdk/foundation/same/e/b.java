package com.mbridge.msdk.foundation.same.e;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.foundation.tools.af;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ThreadPoolExecutor f44505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    HashMap<Long, a> f44506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    WeakReference<Context> f44507c;

    public b(Context context) {
        if (af.a().a("c_t_l_t_p", true)) {
            this.f44505a = c.a();
        } else {
            if (af.a().a("c_t_p_t_l", true)) {
                int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
                this.f44505a = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.f44505a = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.f44505a.allowCoreThreadTimeOut(true);
        }
        this.f44506b = new HashMap<>();
        this.f44507c = new WeakReference<>(context);
    }

    public b(Context context, int i11) {
        if (af.a().a("c_t_l_t_p", true)) {
            this.f44505a = c.a();
        } else {
            if (i11 == 0) {
                this.f44505a = new ThreadPoolExecutor(1, 5, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.f44505a = new ThreadPoolExecutor(i11, (i11 * 2) + 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.f44505a.allowCoreThreadTimeOut(true);
        }
        this.f44506b = new HashMap<>();
        this.f44507c = new WeakReference<>(context);
    }

    private synchronized void b(final a aVar, final a.InterfaceC0489a interfaceC0489a) {
        this.f44506b.put(Long.valueOf(aVar.getId()), aVar);
        aVar.setOnStateChangeListener(new a.InterfaceC0489a() { // from class: com.mbridge.msdk.foundation.same.e.b.1
            @Override // com.mbridge.msdk.foundation.same.e.a.InterfaceC0489a
            public final void a(a.b bVar) {
                if (bVar == a.b.CANCEL || bVar == a.b.FINISH) {
                    b.this.f44506b.remove(Long.valueOf(aVar.getId()));
                } else if (bVar == a.b.RUNNING && b.this.f44507c.get() == null) {
                    b.this.a();
                }
                a.InterfaceC0489a interfaceC0489a2 = interfaceC0489a;
                if (interfaceC0489a2 != null) {
                    interfaceC0489a2.a(bVar);
                }
            }
        });
    }

    public final synchronized void a() {
        try {
            Iterator<Map.Entry<Long, a>> it = this.f44506b.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().cancel();
            }
            this.f44506b.clear();
        } catch (Exception unused) {
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void a(a aVar) {
        b(aVar, null);
        this.f44505a.execute(aVar);
    }

    public final void a(a aVar, a.InterfaceC0489a interfaceC0489a) {
        b(aVar, interfaceC0489a);
        this.f44505a.execute(aVar);
    }
}
