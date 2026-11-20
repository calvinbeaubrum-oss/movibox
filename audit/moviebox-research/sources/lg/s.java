package lg;

import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f70274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mg.d f70275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f70276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ng.a f70277d;

    public s(Executor executor, mg.d dVar, u uVar, ng.a aVar) {
        this.f70274a = executor;
        this.f70275b = dVar;
        this.f70276c = uVar;
        this.f70277d = aVar;
    }

    public void c() {
        this.f70274a.execute(new Runnable() { // from class: lg.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f70272a.e();
            }
        });
    }

    public final /* synthetic */ Object d() {
        Iterator<com.google.android.datatransport.runtime.o> it = this.f70275b.H().iterator();
        while (it.hasNext()) {
            this.f70276c.a(it.next(), 1);
        }
        return null;
    }

    public final /* synthetic */ void e() {
        this.f70277d.d(new ng.a.InterfaceC0770a() { // from class: lg.r
            @Override // ng.a.InterfaceC0770a
            public final Object execute() {
                return this.f70273a.d();
            }
        });
    }
}
