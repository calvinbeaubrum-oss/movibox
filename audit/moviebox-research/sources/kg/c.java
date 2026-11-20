package kg;

import com.google.android.datatransport.runtime.o;
import com.google.android.datatransport.runtime.t;
import fg.k;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import lg.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f68552f = Logger.getLogger(t.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f68553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f68554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fg.d f68555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final mg.d f68556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ng.a f68557e;

    public c(Executor executor, fg.d dVar, u uVar, mg.d dVar2, ng.a aVar) {
        this.f68554b = executor;
        this.f68555c = dVar;
        this.f68553a = uVar;
        this.f68556d = dVar2;
        this.f68557e = aVar;
    }

    @Override // kg.e
    public void a(final o oVar, final com.google.android.datatransport.runtime.i iVar, final cg.i iVar2) {
        this.f68554b.execute(new Runnable() { // from class: kg.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f68545a.e(oVar, iVar2, iVar);
            }
        });
    }

    public final /* synthetic */ Object d(o oVar, com.google.android.datatransport.runtime.i iVar) {
        this.f68556d.o0(oVar, iVar);
        this.f68553a.a(oVar, 1);
        return null;
    }

    public final /* synthetic */ void e(final o oVar, cg.i iVar, com.google.android.datatransport.runtime.i iVar2) {
        try {
            k kVarA = this.f68555c.a(oVar.b());
            if (kVarA == null) {
                String str = String.format("Transport backend '%s' is not registered", oVar.b());
                f68552f.warning(str);
                iVar.a(new IllegalArgumentException(str));
            } else {
                final com.google.android.datatransport.runtime.i iVarA = kVarA.a(iVar2);
                this.f68557e.d(new ng.a.InterfaceC0770a() { // from class: kg.b
                    @Override // ng.a.InterfaceC0770a
                    public final Object execute() {
                        return this.f68549a.d(oVar, iVarA);
                    }
                });
                iVar.a(null);
            }
        } catch (Exception e11) {
            f68552f.warning("Error scheduling event " + e11.getMessage());
            iVar.a(e11);
        }
    }
}
