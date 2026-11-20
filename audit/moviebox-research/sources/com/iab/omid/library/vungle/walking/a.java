package com.iab.omid.library.vungle.walking;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import sn.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<View, String> f42470a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<View, C0472a> f42471b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, View> f42472c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<View> f42473d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet<String> f42474e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet<String> f42475f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, String> f42476g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f42477h;

    /* JADX INFO: renamed from: com.iab.omid.library.vungle.walking.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0472a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.iab.omid.library.vungle.b.c f42478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<String> f42479b = new ArrayList<>();

        public C0472a(com.iab.omid.library.vungle.b.c cVar, String str) {
            this.f42478a = cVar;
            b(str);
        }

        public com.iab.omid.library.vungle.b.c a() {
            return this.f42478a;
        }

        public void b(String str) {
            this.f42479b.add(str);
        }

        public ArrayList<String> c() {
            return this.f42479b;
        }
    }

    public String a(View view) {
        if (this.f42470a.size() == 0) {
            return null;
        }
        String str = this.f42470a.get(view);
        if (str != null) {
            this.f42470a.remove(view);
        }
        return str;
    }

    public String b(String str) {
        return this.f42476g.get(str);
    }

    public HashSet<String> c() {
        return this.f42474e;
    }

    public final void d(com.iab.omid.library.vungle.b.c cVar, f fVar) {
        View view = cVar.a().get();
        if (view == null) {
            return;
        }
        C0472a c0472a = this.f42471b.get(view);
        if (c0472a != null) {
            c0472a.b(fVar.j());
        } else {
            this.f42471b.put(view, new C0472a(cVar, fVar.j()));
        }
    }

    public final void e(f fVar) {
        Iterator<com.iab.omid.library.vungle.b.c> it = fVar.e().iterator();
        while (it.hasNext()) {
            d(it.next(), fVar);
        }
    }

    public View f(String str) {
        return this.f42472c.get(str);
    }

    public C0472a g(View view) {
        C0472a c0472a = this.f42471b.get(view);
        if (c0472a != null) {
            this.f42471b.remove(view);
        }
        return c0472a;
    }

    public HashSet<String> h() {
        return this.f42475f;
    }

    public c i(View view) {
        if (this.f42473d.contains(view)) {
            return c.PARENT_VIEW;
        }
        return this.f42477h ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void j() {
        com.iab.omid.library.vungle.b.a aVarA = com.iab.omid.library.vungle.b.a.a();
        if (aVarA != null) {
            for (f fVar : aVarA.e()) {
                View viewG = fVar.g();
                if (fVar.i()) {
                    String strJ = fVar.j();
                    if (viewG != null) {
                        String strK = k(viewG);
                        if (strK == null) {
                            this.f42474e.add(strJ);
                            this.f42470a.put(viewG, strJ);
                            e(fVar);
                        } else {
                            this.f42475f.add(strJ);
                            this.f42472c.put(strJ, viewG);
                            this.f42476g.put(strJ, strK);
                        }
                    } else {
                        this.f42475f.add(strJ);
                        this.f42476g.put(strJ, "noAdView");
                    }
                }
            }
        }
    }

    public final String k(View view) {
        if (!view.hasWindowFocus()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String strE = un.f.e(view);
            if (strE != null) {
                return strE;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f42473d.addAll(hashSet);
        return null;
    }

    public void l() {
        this.f42470a.clear();
        this.f42471b.clear();
        this.f42472c.clear();
        this.f42473d.clear();
        this.f42474e.clear();
        this.f42475f.clear();
        this.f42476g.clear();
        this.f42477h = false;
    }

    public void m() {
        this.f42477h = true;
    }
}
