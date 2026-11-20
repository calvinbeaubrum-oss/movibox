package com.iab.omid.library.mmadbridge.walking;

import android.view.View;
import com.iab.omid.library.mmadbridge.internal.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kn.g;
import nn.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<View, String> f42405a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<View, C0471a> f42406b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, View> f42407c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<View> f42408d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet<String> f42409e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet<String> f42410f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, String> f42411g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<View, Boolean> f42412h = new WeakHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f42413i;

    /* JADX INFO: renamed from: com.iab.omid.library.mmadbridge.walking.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0471a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f42414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<String> f42415b = new ArrayList<>();

        public C0471a(e eVar, String str) {
            this.f42414a = eVar;
            b(str);
        }

        public e a() {
            return this.f42414a;
        }

        public void b(String str) {
            this.f42415b.add(str);
        }

        public ArrayList<String> c() {
            return this.f42415b;
        }
    }

    public View a(String str) {
        return this.f42407c.get(str);
    }

    public final String b(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (f(view).booleanValue()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String strA = h.a(view);
            if (strA != null) {
                return strA;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f42408d.addAll(hashSet);
        return null;
    }

    public void c() {
        this.f42405a.clear();
        this.f42406b.clear();
        this.f42407c.clear();
        this.f42408d.clear();
        this.f42409e.clear();
        this.f42410f.clear();
        this.f42411g.clear();
        this.f42413i = false;
    }

    public final void d(e eVar, g gVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0471a c0471a = this.f42406b.get(view);
        if (c0471a != null) {
            c0471a.b(gVar.v());
        } else {
            this.f42406b.put(view, new C0471a(eVar, gVar.v()));
        }
    }

    public final void e(g gVar) {
        Iterator<e> it = gVar.q().iterator();
        while (it.hasNext()) {
            d(it.next(), gVar);
        }
    }

    public final Boolean f(View view) {
        if (view.hasWindowFocus()) {
            this.f42412h.remove(view);
            return Boolean.FALSE;
        }
        if (this.f42412h.containsKey(view)) {
            return this.f42412h.get(view);
        }
        Map<View, Boolean> map = this.f42412h;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public String g(String str) {
        return this.f42411g.get(str);
    }

    public HashSet<String> h() {
        return this.f42410f;
    }

    public C0471a i(View view) {
        C0471a c0471a = this.f42406b.get(view);
        if (c0471a != null) {
            this.f42406b.remove(view);
        }
        return c0471a;
    }

    public HashSet<String> j() {
        return this.f42409e;
    }

    public String k(View view) {
        if (this.f42405a.size() == 0) {
            return null;
        }
        String str = this.f42405a.get(view);
        if (str != null) {
            this.f42405a.remove(view);
        }
        return str;
    }

    public void l() {
        this.f42413i = true;
    }

    public c m(View view) {
        if (this.f42408d.contains(view)) {
            return c.PARENT_VIEW;
        }
        return this.f42413i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void n() {
        com.iab.omid.library.mmadbridge.internal.c cVarE = com.iab.omid.library.mmadbridge.internal.c.e();
        if (cVarE != null) {
            for (g gVar : cVarE.a()) {
                View viewO = gVar.o();
                if (gVar.t()) {
                    String strV = gVar.v();
                    if (viewO != null) {
                        String strB = b(viewO);
                        if (strB == null) {
                            this.f42409e.add(strV);
                            this.f42405a.put(viewO, strV);
                            e(gVar);
                        } else if (strB != "noWindowFocus") {
                            this.f42410f.add(strV);
                            this.f42407c.put(strV, viewO);
                            this.f42411g.put(strV, strB);
                        }
                    } else {
                        this.f42410f.add(strV);
                        this.f42411g.put(strV, "noAdView");
                    }
                }
            }
        }
    }

    public boolean o(View view) {
        if (!this.f42412h.containsKey(view)) {
            return true;
        }
        this.f42412h.put(view, Boolean.TRUE);
        return false;
    }
}
