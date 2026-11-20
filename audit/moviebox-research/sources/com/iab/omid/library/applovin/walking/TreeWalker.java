package com.iab.omid.library.applovin.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.applovin.utils.f;
import com.iab.omid.library.applovin.utils.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TreeWalker implements com.iab.omid.library.applovin.processor.a.InterfaceC0463a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static TreeWalker f42174i = new TreeWalker();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Handler f42175j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Handler f42176k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Runnable f42177l = new b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Runnable f42178m = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f42180b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f42186h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f42179a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f42181c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.iab.omid.library.applovin.weakreference.a> f42182d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.applovin.walking.a f42184f = new com.iab.omid.library.applovin.walking.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.iab.omid.library.applovin.processor.b f42183e = new com.iab.omid.library.applovin.processor.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.iab.omid.library.applovin.walking.b f42185g = new com.iab.omid.library.applovin.walking.b(new com.iab.omid.library.applovin.walking.async.c());

    /* JADX INFO: compiled from: source.java */
    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i11, long j11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i11, long j11);
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.f42185g.b();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.getInstance().l();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.f42176k != null) {
                TreeWalker.f42176k.post(TreeWalker.f42177l);
                TreeWalker.f42176k.postDelayed(TreeWalker.f42178m, 200L);
            }
        }
    }

    private void a(long j11) {
        if (this.f42179a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f42179a) {
                treeWalkerTimeLogger.onTreeProcessed(this.f42180b, TimeUnit.NANOSECONDS.toMillis(j11));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f42180b, j11);
                }
            }
        }
    }

    private void a(View view, com.iab.omid.library.applovin.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.applovin.walking.c cVar, boolean z11) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.applovin.walking.c.PARENT_VIEW, z11);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.applovin.processor.a aVarB = this.f42183e.b();
        String strB = this.f42184f.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.applovin.utils.c.a(jSONObjectA, str);
            com.iab.omid.library.applovin.utils.c.b(jSONObjectA, strB);
            com.iab.omid.library.applovin.utils.c.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        com.iab.omid.library.applovin.walking.a.C0465a c0465aC = this.f42184f.c(view);
        if (c0465aC == null) {
            return false;
        }
        com.iab.omid.library.applovin.utils.c.a(jSONObject, c0465aC);
        return true;
    }

    private boolean b(View view, JSONObject jSONObject) {
        String strD = this.f42184f.d(view);
        if (strD == null) {
            return false;
        }
        com.iab.omid.library.applovin.utils.c.a(jSONObject, strD);
        com.iab.omid.library.applovin.utils.c.a(jSONObject, Boolean.valueOf(this.f42184f.f(view)));
        this.f42184f.d();
        return true;
    }

    private void d() {
        a(f.b() - this.f42186h);
    }

    private void e() {
        this.f42180b = 0;
        this.f42182d.clear();
        this.f42181c = false;
        Iterator<com.iab.omid.library.applovin.adsession.a> it = com.iab.omid.library.applovin.internal.c.c().a().iterator();
        while (it.hasNext()) {
            if (it.next().e()) {
                this.f42181c = true;
                break;
            }
        }
        this.f42186h = f.b();
    }

    public static TreeWalker getInstance() {
        return f42174i;
    }

    private void i() {
        if (f42176k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f42176k = handler;
            handler.post(f42177l);
            f42176k.postDelayed(f42178m, 200L);
        }
    }

    private void k() {
        Handler handler = f42176k;
        if (handler != null) {
            handler.removeCallbacks(f42178m);
            f42176k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e();
        f();
        d();
    }

    @Override // com.iab.omid.library.applovin.processor.a.InterfaceC0463a
    public void a(View view, com.iab.omid.library.applovin.processor.a aVar, JSONObject jSONObject, boolean z11) {
        com.iab.omid.library.applovin.walking.c cVarE;
        if (h.d(view) && (cVarE = this.f42184f.e(view)) != com.iab.omid.library.applovin.walking.c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.applovin.utils.c.a(jSONObject, jSONObjectA);
            if (!b(view, jSONObjectA)) {
                boolean z12 = z11 || a(view, jSONObjectA);
                if (this.f42181c && cVarE == com.iab.omid.library.applovin.walking.c.OBSTRUCTION_VIEW && !z12) {
                    this.f42182d.add(new com.iab.omid.library.applovin.weakreference.a(view));
                }
                a(view, aVar, jSONObjectA, cVarE, z12);
            }
            this.f42180b++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f42179a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f42179a.add(treeWalkerTimeLogger);
    }

    public void f() {
        this.f42184f.e();
        long jB = f.b();
        com.iab.omid.library.applovin.processor.a aVarA = this.f42183e.a();
        if (this.f42184f.b().size() > 0) {
            for (String str : this.f42184f.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.f42184f.a(str), jSONObjectA);
                com.iab.omid.library.applovin.utils.c.b(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.f42185g.a(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f42184f.c().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            a(null, aVarA, jSONObjectA2, com.iab.omid.library.applovin.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.applovin.utils.c.b(jSONObjectA2);
            this.f42185g.b(jSONObjectA2, this.f42184f.c(), jB);
            if (this.f42181c) {
                Iterator<com.iab.omid.library.applovin.adsession.a> it = com.iab.omid.library.applovin.internal.c.c().a().iterator();
                while (it.hasNext()) {
                    it.next().a(this.f42182d);
                }
            }
        } else {
            this.f42185g.b();
        }
        this.f42184f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f42179a.clear();
        f42175j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f42179a.contains(treeWalkerTimeLogger)) {
            this.f42179a.remove(treeWalkerTimeLogger);
        }
    }
}
