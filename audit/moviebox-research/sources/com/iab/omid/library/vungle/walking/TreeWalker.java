package com.iab.omid.library.vungle.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import un.d;
import un.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TreeWalker implements tn.a.InterfaceC0855a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static TreeWalker f42458g = new TreeWalker();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Handler f42459h = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Handler f42460i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Runnable f42461j = new Runnable() { // from class: com.iab.omid.library.vungle.walking.TreeWalker.2
        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.p().q();
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Runnable f42462k = new Runnable() { // from class: com.iab.omid.library.vungle.walking.TreeWalker.3
        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.f42460i != null) {
                TreeWalker.f42460i.post(TreeWalker.f42461j);
                TreeWalker.f42460i.postDelayed(TreeWalker.f42462k, 200L);
            }
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42464b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f42468f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<b> f42463a = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.iab.omid.library.vungle.walking.a f42466d = new com.iab.omid.library.vungle.walking.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public tn.b f42465c = new tn.b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.iab.omid.library.vungle.walking.b f42467e = new com.iab.omid.library.vungle.walking.b(new wn.c());

    /* JADX INFO: compiled from: source.java */
    public interface a extends b {
        void onTreeProcessedNano(int i11, long j11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void onTreeProcessed(int i11, long j11);
    }

    public static TreeWalker p() {
        return f42458g;
    }

    @Override // tn.a.InterfaceC0855a
    public void a(View view, tn.a aVar, JSONObject jSONObject) {
        c cVarI;
        if (f.d(view) && (cVarI = this.f42466d.i(view)) != c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            un.b.h(jSONObject, jSONObjectA);
            if (!g(view, jSONObjectA)) {
                i(view, jSONObjectA);
                e(view, aVar, jSONObjectA, cVarI);
            }
            this.f42464b++;
        }
    }

    public void c() {
        t();
    }

    public final void d(long j11) {
        if (this.f42463a.size() > 0) {
            for (b bVar : this.f42463a) {
                bVar.onTreeProcessed(this.f42464b, TimeUnit.NANOSECONDS.toMillis(j11));
                if (bVar instanceof a) {
                    ((a) bVar).onTreeProcessedNano(this.f42464b, j11);
                }
            }
        }
    }

    public final void e(View view, tn.a aVar, JSONObject jSONObject, c cVar) {
        aVar.a(view, jSONObject, this, cVar == c.PARENT_VIEW);
    }

    public final void f(String str, View view, JSONObject jSONObject) {
        tn.a aVarB = this.f42465c.b();
        String strB = this.f42466d.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            un.b.f(jSONObjectA, str);
            un.b.k(jSONObjectA, strB);
            un.b.h(jSONObject, jSONObjectA);
        }
    }

    public final boolean g(View view, JSONObject jSONObject) {
        String strA = this.f42466d.a(view);
        if (strA == null) {
            return false;
        }
        un.b.f(jSONObject, strA);
        this.f42466d.m();
        return true;
    }

    public void h() {
        k();
        this.f42463a.clear();
        f42459h.post(new Runnable() { // from class: com.iab.omid.library.vungle.walking.TreeWalker.1
            @Override // java.lang.Runnable
            public void run() {
                TreeWalker.this.f42467e.a();
            }
        });
    }

    public final void i(View view, JSONObject jSONObject) {
        com.iab.omid.library.vungle.walking.a.C0472a c0472aG = this.f42466d.g(view);
        if (c0472aG != null) {
            un.b.e(jSONObject, c0472aG);
        }
    }

    public void k() {
        u();
    }

    public void l() {
        this.f42466d.j();
        long jA = d.a();
        tn.a aVarA = this.f42465c.a();
        if (this.f42466d.h().size() > 0) {
            for (String str : this.f42466d.h()) {
                JSONObject jSONObjectA = aVarA.a(null);
                f(str, this.f42466d.f(str), jSONObjectA);
                un.b.d(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.f42467e.c(jSONObjectA, hashSet, jA);
            }
        }
        if (this.f42466d.c().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            e(null, aVarA, jSONObjectA2, c.PARENT_VIEW);
            un.b.d(jSONObjectA2);
            this.f42467e.b(jSONObjectA2, this.f42466d.c(), jA);
        } else {
            this.f42467e.a();
        }
        this.f42466d.l();
    }

    public final void q() {
        r();
        l();
        s();
    }

    public final void r() {
        this.f42464b = 0;
        this.f42468f = d.a();
    }

    public final void s() {
        d(d.a() - this.f42468f);
    }

    public final void t() {
        if (f42460i == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f42460i = handler;
            handler.post(f42461j);
            f42460i.postDelayed(f42462k, 200L);
        }
    }

    public final void u() {
        Handler handler = f42460i;
        if (handler != null) {
            handler.removeCallbacks(f42462k);
            f42460i = null;
        }
    }
}
