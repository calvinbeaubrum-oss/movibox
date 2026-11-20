package com.iab.omid.library.bytedance2.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.bytedance2.utils.f;
import com.iab.omid.library.bytedance2.utils.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TreeWalker implements com.iab.omid.library.bytedance2.processor.a.InterfaceC0467a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static TreeWalker f42303i = new TreeWalker();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Handler f42304j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Handler f42305k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Runnable f42306l = new b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Runnable f42307m = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f42309b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f42315h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f42308a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f42310c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.iab.omid.library.bytedance2.weakreference.a> f42311d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.bytedance2.walking.a f42313f = new com.iab.omid.library.bytedance2.walking.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.iab.omid.library.bytedance2.processor.b f42312e = new com.iab.omid.library.bytedance2.processor.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.iab.omid.library.bytedance2.walking.b f42314g = new com.iab.omid.library.bytedance2.walking.b(new com.iab.omid.library.bytedance2.walking.async.c());

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
            TreeWalker.this.f42314g.b();
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
            if (TreeWalker.f42305k != null) {
                TreeWalker.f42305k.post(TreeWalker.f42306l);
                TreeWalker.f42305k.postDelayed(TreeWalker.f42307m, 200L);
            }
        }
    }

    private void a(long j11) {
        if (this.f42308a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f42308a) {
                treeWalkerTimeLogger.onTreeProcessed(this.f42309b, TimeUnit.NANOSECONDS.toMillis(j11));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f42309b, j11);
                }
            }
        }
    }

    private void a(View view, com.iab.omid.library.bytedance2.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.bytedance2.walking.c cVar, boolean z11) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.bytedance2.walking.c.PARENT_VIEW, z11);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.bytedance2.processor.a aVarB = this.f42312e.b();
        String strB = this.f42313f.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.bytedance2.utils.c.a(jSONObjectA, str);
            com.iab.omid.library.bytedance2.utils.c.b(jSONObjectA, strB);
            com.iab.omid.library.bytedance2.utils.c.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        com.iab.omid.library.bytedance2.walking.a.C0469a c0469aC = this.f42313f.c(view);
        if (c0469aC == null) {
            return false;
        }
        com.iab.omid.library.bytedance2.utils.c.a(jSONObject, c0469aC);
        return true;
    }

    private boolean b(View view, JSONObject jSONObject) {
        String strD = this.f42313f.d(view);
        if (strD == null) {
            return false;
        }
        com.iab.omid.library.bytedance2.utils.c.a(jSONObject, strD);
        com.iab.omid.library.bytedance2.utils.c.a(jSONObject, Boolean.valueOf(this.f42313f.f(view)));
        this.f42313f.d();
        return true;
    }

    private void d() {
        a(f.b() - this.f42315h);
    }

    private void e() {
        this.f42309b = 0;
        this.f42311d.clear();
        this.f42310c = false;
        Iterator<com.iab.omid.library.bytedance2.adsession.a> it = com.iab.omid.library.bytedance2.internal.c.c().a().iterator();
        while (it.hasNext()) {
            if (it.next().e()) {
                this.f42310c = true;
                break;
            }
        }
        this.f42315h = f.b();
    }

    public static TreeWalker getInstance() {
        return f42303i;
    }

    private void i() {
        if (f42305k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f42305k = handler;
            handler.post(f42306l);
            f42305k.postDelayed(f42307m, 200L);
        }
    }

    private void k() {
        Handler handler = f42305k;
        if (handler != null) {
            handler.removeCallbacks(f42307m);
            f42305k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e();
        f();
        d();
    }

    @Override // com.iab.omid.library.bytedance2.processor.a.InterfaceC0467a
    public void a(View view, com.iab.omid.library.bytedance2.processor.a aVar, JSONObject jSONObject, boolean z11) {
        com.iab.omid.library.bytedance2.walking.c cVarE;
        if (h.d(view) && (cVarE = this.f42313f.e(view)) != com.iab.omid.library.bytedance2.walking.c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.bytedance2.utils.c.a(jSONObject, jSONObjectA);
            if (!b(view, jSONObjectA)) {
                boolean z12 = z11 || a(view, jSONObjectA);
                if (this.f42310c && cVarE == com.iab.omid.library.bytedance2.walking.c.OBSTRUCTION_VIEW && !z12) {
                    this.f42311d.add(new com.iab.omid.library.bytedance2.weakreference.a(view));
                }
                a(view, aVar, jSONObjectA, cVarE, z12);
            }
            this.f42309b++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f42308a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f42308a.add(treeWalkerTimeLogger);
    }

    public void f() {
        this.f42313f.e();
        long jB = f.b();
        com.iab.omid.library.bytedance2.processor.a aVarA = this.f42312e.a();
        if (this.f42313f.b().size() > 0) {
            for (String str : this.f42313f.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.f42313f.a(str), jSONObjectA);
                com.iab.omid.library.bytedance2.utils.c.b(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.f42314g.a(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f42313f.c().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            a(null, aVarA, jSONObjectA2, com.iab.omid.library.bytedance2.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.bytedance2.utils.c.b(jSONObjectA2);
            this.f42314g.b(jSONObjectA2, this.f42313f.c(), jB);
            if (this.f42310c) {
                Iterator<com.iab.omid.library.bytedance2.adsession.a> it = com.iab.omid.library.bytedance2.internal.c.c().a().iterator();
                while (it.hasNext()) {
                    it.next().a(this.f42311d);
                }
            }
        } else {
            this.f42314g.b();
        }
        this.f42313f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f42308a.clear();
        f42304j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f42308a.contains(treeWalkerTimeLogger)) {
            this.f42308a.remove(treeWalkerTimeLogger);
        }
    }
}
