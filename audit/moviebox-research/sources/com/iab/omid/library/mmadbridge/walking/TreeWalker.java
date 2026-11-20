package com.iab.omid.library.mmadbridge.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kn.g;
import nn.f;
import nn.h;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TreeWalker implements mn.a.InterfaceC0761a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static TreeWalker f42391i = new TreeWalker();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Handler f42392j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Handler f42393k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Runnable f42394l = new b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Runnable f42395m = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42397b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f42403h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<e> f42396a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f42398c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<pn.a> f42399d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.iab.omid.library.mmadbridge.walking.a f42401f = new com.iab.omid.library.mmadbridge.walking.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public mn.b f42400e = new mn.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.iab.omid.library.mmadbridge.walking.b f42402g = new com.iab.omid.library.mmadbridge.walking.b(new on.c());

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.f42402g.c();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.p().u();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.f42393k != null) {
                TreeWalker.f42393k.post(TreeWalker.f42394l);
                TreeWalker.f42393k.postDelayed(TreeWalker.f42395m, 200L);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d extends e {
        void onTreeProcessedNano(int i11, long j11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void onTreeProcessed(int i11, long j11);
    }

    public static TreeWalker p() {
        return f42391i;
    }

    @Override // mn.a.InterfaceC0761a
    public void a(View view, mn.a aVar, JSONObject jSONObject, boolean z11) {
        com.iab.omid.library.mmadbridge.walking.c cVarM;
        if (h.d(view) && (cVarM = this.f42401f.m(view)) != com.iab.omid.library.mmadbridge.walking.c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            nn.c.j(jSONObject, jSONObjectA);
            if (!j(view, jSONObjectA)) {
                boolean z12 = z11 || g(view, jSONObjectA);
                if (this.f42398c && cVarM == com.iab.omid.library.mmadbridge.walking.c.OBSTRUCTION_VIEW && !z12) {
                    this.f42399d.add(new pn.a(view));
                }
                e(view, aVar, jSONObjectA, cVarM, z12);
            }
            this.f42397b++;
        }
    }

    public final void d(long j11) {
        if (this.f42396a.size() > 0) {
            for (e eVar : this.f42396a) {
                eVar.onTreeProcessed(this.f42397b, TimeUnit.NANOSECONDS.toMillis(j11));
                if (eVar instanceof d) {
                    ((d) eVar).onTreeProcessedNano(this.f42397b, j11);
                }
            }
        }
    }

    public final void e(View view, mn.a aVar, JSONObject jSONObject, com.iab.omid.library.mmadbridge.walking.c cVar, boolean z11) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.mmadbridge.walking.c.PARENT_VIEW, z11);
    }

    public final void f(String str, View view, JSONObject jSONObject) {
        mn.a aVarB = this.f42400e.b();
        String strG = this.f42401f.g(str);
        if (strG != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            nn.c.h(jSONObjectA, str);
            nn.c.n(jSONObjectA, strG);
            nn.c.j(jSONObject, jSONObjectA);
        }
    }

    public final boolean g(View view, JSONObject jSONObject) {
        com.iab.omid.library.mmadbridge.walking.a.C0471a c0471aI = this.f42401f.i(view);
        if (c0471aI == null) {
            return false;
        }
        nn.c.f(jSONObject, c0471aI);
        return true;
    }

    public final boolean j(View view, JSONObject jSONObject) {
        String strK = this.f42401f.k(view);
        if (strK == null) {
            return false;
        }
        nn.c.h(jSONObject, strK);
        nn.c.g(jSONObject, Boolean.valueOf(this.f42401f.o(view)));
        this.f42401f.l();
        return true;
    }

    public final void l() {
        d(f.b() - this.f42403h);
    }

    public final void m() {
        this.f42397b = 0;
        this.f42399d.clear();
        this.f42398c = false;
        Iterator<g> it = com.iab.omid.library.mmadbridge.internal.c.e().a().iterator();
        while (it.hasNext()) {
            if (it.next().s()) {
                this.f42398c = true;
                break;
            }
        }
        this.f42403h = f.b();
    }

    public void n() {
        this.f42401f.n();
        long jB = f.b();
        mn.a aVarA = this.f42400e.a();
        if (this.f42401f.h().size() > 0) {
            for (String str : this.f42401f.h()) {
                JSONObject jSONObjectA = aVarA.a(null);
                f(str, this.f42401f.a(str), jSONObjectA);
                nn.c.m(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.f42402g.b(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f42401f.j().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            e(null, aVarA, jSONObjectA2, com.iab.omid.library.mmadbridge.walking.c.PARENT_VIEW, false);
            nn.c.m(jSONObjectA2);
            this.f42402g.d(jSONObjectA2, this.f42401f.j(), jB);
            if (this.f42398c) {
                Iterator<g> it = com.iab.omid.library.mmadbridge.internal.c.e().a().iterator();
                while (it.hasNext()) {
                    it.next().k(this.f42399d);
                }
            }
        } else {
            this.f42402g.c();
        }
        this.f42401f.c();
    }

    public void o() {
        t();
    }

    public void q() {
        r();
    }

    public final void r() {
        if (f42393k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f42393k = handler;
            handler.post(f42394l);
            f42393k.postDelayed(f42395m, 200L);
        }
    }

    public void s() {
        o();
        this.f42396a.clear();
        f42392j.post(new a());
    }

    public final void t() {
        Handler handler = f42393k;
        if (handler != null) {
            handler.removeCallbacks(f42395m);
            f42393k = null;
        }
    }

    public final void u() {
        m();
        n();
        l();
    }
}
