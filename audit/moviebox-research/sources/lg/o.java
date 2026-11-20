package lg;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f70254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fg.d f70255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mg.d f70256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f70257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f70258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ng.a f70259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final og.a f70260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final og.a f70261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final mg.c f70262i;

    public o(Context context, fg.d dVar, mg.d dVar2, u uVar, Executor executor, ng.a aVar, og.a aVar2, og.a aVar3, mg.c cVar) {
        this.f70254a = context;
        this.f70255b = dVar;
        this.f70256c = dVar2;
        this.f70257d = uVar;
        this.f70258e = executor;
        this.f70259f = aVar;
        this.f70260g = aVar2;
        this.f70261h = aVar3;
        this.f70262i = cVar;
    }

    public com.google.android.datatransport.runtime.i j(fg.k kVar) {
        ng.a aVar = this.f70259f;
        final mg.c cVar = this.f70262i;
        Objects.requireNonNull(cVar);
        return kVar.a(com.google.android.datatransport.runtime.i.a().i(this.f70260g.a()).l(this.f70261h.a()).k("GDT_CLIENT_METRICS").h(new com.google.android.datatransport.runtime.h(cg.c.b("proto"), ((hg.a) aVar.d(new ng.a.InterfaceC0770a() { // from class: lg.e
            @Override // ng.a.InterfaceC0770a
            public final Object execute() {
                return cVar.b();
            }
        })).f())).d());
    }

    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f70254a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final /* synthetic */ Boolean l(com.google.android.datatransport.runtime.o oVar) {
        return Boolean.valueOf(this.f70256c.P(oVar));
    }

    public final /* synthetic */ Iterable m(com.google.android.datatransport.runtime.o oVar) {
        return this.f70256c.T(oVar);
    }

    public final /* synthetic */ Object n(Iterable iterable, com.google.android.datatransport.runtime.o oVar, long j11) {
        this.f70256c.Q(iterable);
        this.f70256c.G(oVar, this.f70260g.a() + j11);
        return null;
    }

    public final /* synthetic */ Object o(Iterable iterable) {
        this.f70256c.C(iterable);
        return null;
    }

    public final /* synthetic */ Object p() {
        this.f70262i.a();
        return null;
    }

    public final /* synthetic */ Object q(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f70262i.c(((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    public final /* synthetic */ Object r(com.google.android.datatransport.runtime.o oVar, long j11) {
        this.f70256c.G(oVar, this.f70260g.a() + j11);
        return null;
    }

    public final /* synthetic */ Object s(com.google.android.datatransport.runtime.o oVar, int i11) {
        this.f70257d.a(oVar, i11 + 1);
        return null;
    }

    public final /* synthetic */ void t(final com.google.android.datatransport.runtime.o oVar, final int i11, Runnable runnable) {
        try {
            try {
                ng.a aVar = this.f70259f;
                final mg.d dVar = this.f70256c;
                Objects.requireNonNull(dVar);
                aVar.d(new ng.a.InterfaceC0770a() { // from class: lg.f
                    @Override // ng.a.InterfaceC0770a
                    public final Object execute() {
                        return Integer.valueOf(dVar.B());
                    }
                });
                if (k()) {
                    u(oVar, i11);
                } else {
                    this.f70259f.d(new ng.a.InterfaceC0770a() { // from class: lg.g
                        @Override // ng.a.InterfaceC0770a
                        public final Object execute() {
                            return this.f70235a.s(oVar, i11);
                        }
                    });
                }
            } catch (SynchronizationException unused) {
                this.f70257d.a(oVar, i11 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    public BackendResponse u(final com.google.android.datatransport.runtime.o oVar, int i11) {
        BackendResponse backendResponseB;
        fg.k kVarA = this.f70255b.a(oVar.b());
        long jMax = 0;
        BackendResponse backendResponseE = BackendResponse.e(0L);
        while (true) {
            final long j11 = jMax;
            while (true) {
                if (!((Boolean) this.f70259f.d(new ng.a.InterfaceC0770a() { // from class: lg.h
                    @Override // ng.a.InterfaceC0770a
                    public final Object execute() {
                        return this.f70238a.l(oVar);
                    }
                })).booleanValue()) {
                    this.f70259f.d(new ng.a.InterfaceC0770a() { // from class: lg.n
                        @Override // ng.a.InterfaceC0770a
                        public final Object execute() {
                            return this.f70251a.r(oVar, j11);
                        }
                    });
                    return backendResponseE;
                }
                final Iterable iterable = (Iterable) this.f70259f.d(new ng.a.InterfaceC0770a() { // from class: lg.i
                    @Override // ng.a.InterfaceC0770a
                    public final Object execute() {
                        return this.f70240a.m(oVar);
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return backendResponseE;
                }
                if (kVarA == null) {
                    ig.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", oVar);
                    backendResponseB = BackendResponse.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((mg.k) it.next()).b());
                    }
                    if (oVar.e()) {
                        arrayList.add(j(kVarA));
                    }
                    backendResponseB = kVarA.b(fg.e.a().b(arrayList).c(oVar.c()).a());
                }
                backendResponseE = backendResponseB;
                if (backendResponseE.c() == BackendResponse.Status.TRANSIENT_ERROR) {
                    this.f70259f.d(new ng.a.InterfaceC0770a() { // from class: lg.j
                        @Override // ng.a.InterfaceC0770a
                        public final Object execute() {
                            return this.f70242a.n(iterable, oVar, j11);
                        }
                    });
                    this.f70257d.b(oVar, i11 + 1, true);
                    return backendResponseE;
                }
                this.f70259f.d(new ng.a.InterfaceC0770a() { // from class: lg.k
                    @Override // ng.a.InterfaceC0770a
                    public final Object execute() {
                        return this.f70246a.o(iterable);
                    }
                });
                if (backendResponseE.c() == BackendResponse.Status.OK) {
                    break;
                }
                if (backendResponseE.c() == BackendResponse.Status.INVALID_PAYLOAD) {
                    final HashMap map = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String strK = ((mg.k) it2.next()).b().k();
                        if (map.containsKey(strK)) {
                            map.put(strK, Integer.valueOf(((Integer) map.get(strK)).intValue() + 1));
                        } else {
                            map.put(strK, 1);
                        }
                    }
                    this.f70259f.d(new ng.a.InterfaceC0770a() { // from class: lg.m
                        @Override // ng.a.InterfaceC0770a
                        public final Object execute() {
                            return this.f70249a.q(map);
                        }
                    });
                }
            }
            jMax = Math.max(j11, backendResponseE.b());
            if (oVar.e()) {
                this.f70259f.d(new ng.a.InterfaceC0770a() { // from class: lg.l
                    @Override // ng.a.InterfaceC0770a
                    public final Object execute() {
                        return this.f70248a.p();
                    }
                });
            }
        }
    }

    public void v(final com.google.android.datatransport.runtime.o oVar, final int i11, final Runnable runnable) {
        this.f70258e.execute(new Runnable() { // from class: lg.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f70229a.t(oVar, i11, runnable);
            }
        });
    }
}
