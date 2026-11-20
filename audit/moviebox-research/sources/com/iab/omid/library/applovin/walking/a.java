package com.iab.omid.library.applovin.walking;

import android.view.View;
import com.iab.omid.library.applovin.internal.e;
import com.iab.omid.library.applovin.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f42188a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0465a> f42189b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f42190c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f42191d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashSet<String> f42192e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f42193f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, String> f42194g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<View, Boolean> f42195h = new WeakHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f42196i;

    /* JADX INFO: renamed from: com.iab.omid.library.applovin.walking.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0465a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f42197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f42198b = new ArrayList<>();

        public C0465a(e eVar, String str) {
            this.f42197a = eVar;
            a(str);
        }

        public e a() {
            return this.f42197a;
        }

        public void a(String str) {
            this.f42198b.add(str);
        }

        public ArrayList<String> b() {
            return this.f42198b;
        }
    }

    private String a(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (b(view).booleanValue()) {
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
        this.f42191d.addAll(hashSet);
        return null;
    }

    private void a(com.iab.omid.library.applovin.adsession.a aVar) {
        Iterator<e> it = aVar.d().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.applovin.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0465a c0465a = this.f42189b.get(view);
        if (c0465a != null) {
            c0465a.a(aVar.getAdSessionId());
        } else {
            this.f42189b.put(view, new C0465a(eVar, aVar.getAdSessionId()));
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f42195h.remove(view);
            return Boolean.FALSE;
        }
        if (this.f42195h.containsKey(view)) {
            return this.f42195h.get(view);
        }
        Map<View, Boolean> map = this.f42195h;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public View a(String str) {
        return this.f42190c.get(str);
    }

    public void a() {
        this.f42188a.clear();
        this.f42189b.clear();
        this.f42190c.clear();
        this.f42191d.clear();
        this.f42192e.clear();
        this.f42193f.clear();
        this.f42194g.clear();
        this.f42196i = false;
    }

    public String b(String str) {
        return this.f42194g.get(str);
    }

    public HashSet<String> b() {
        return this.f42193f;
    }

    public C0465a c(View view) {
        C0465a c0465a = this.f42189b.get(view);
        if (c0465a != null) {
            this.f42189b.remove(view);
        }
        return c0465a;
    }

    public HashSet<String> c() {
        return this.f42192e;
    }

    public String d(View view) {
        if (this.f42188a.size() == 0) {
            return null;
        }
        String str = this.f42188a.get(view);
        if (str != null) {
            this.f42188a.remove(view);
        }
        return str;
    }

    public void d() {
        this.f42196i = true;
    }

    public c e(View view) {
        if (this.f42191d.contains(view)) {
            return c.PARENT_VIEW;
        }
        return this.f42196i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void e() {
        com.iab.omid.library.applovin.internal.c cVarC = com.iab.omid.library.applovin.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.applovin.adsession.a aVar : cVarC.a()) {
                View viewC = aVar.c();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewC != null) {
                        String strA = a(viewC);
                        if (strA == null) {
                            this.f42192e.add(adSessionId);
                            this.f42188a.put(viewC, adSessionId);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f42193f.add(adSessionId);
                            this.f42190c.put(adSessionId, viewC);
                            this.f42194g.put(adSessionId, strA);
                        }
                    } else {
                        this.f42193f.add(adSessionId);
                        this.f42194g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public boolean f(View view) {
        if (!this.f42195h.containsKey(view)) {
            return true;
        }
        this.f42195h.put(view, Boolean.TRUE);
        return false;
    }
}
