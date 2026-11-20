package com.iab.omid.library.bytedance2.walking;

import android.view.View;
import com.iab.omid.library.bytedance2.internal.e;
import com.iab.omid.library.bytedance2.utils.h;
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
    private final HashMap<View, String> f42317a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0469a> f42318b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f42319c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f42320d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashSet<String> f42321e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f42322f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, String> f42323g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<View, Boolean> f42324h = new WeakHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f42325i;

    /* JADX INFO: renamed from: com.iab.omid.library.bytedance2.walking.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0469a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f42326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f42327b = new ArrayList<>();

        public C0469a(e eVar, String str) {
            this.f42326a = eVar;
            a(str);
        }

        public e a() {
            return this.f42326a;
        }

        public void a(String str) {
            this.f42327b.add(str);
        }

        public ArrayList<String> b() {
            return this.f42327b;
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
        this.f42320d.addAll(hashSet);
        return null;
    }

    private void a(com.iab.omid.library.bytedance2.adsession.a aVar) {
        Iterator<e> it = aVar.d().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.bytedance2.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0469a c0469a = this.f42318b.get(view);
        if (c0469a != null) {
            c0469a.a(aVar.getAdSessionId());
        } else {
            this.f42318b.put(view, new C0469a(eVar, aVar.getAdSessionId()));
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f42324h.remove(view);
            return Boolean.FALSE;
        }
        if (this.f42324h.containsKey(view)) {
            return this.f42324h.get(view);
        }
        Map<View, Boolean> map = this.f42324h;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public View a(String str) {
        return this.f42319c.get(str);
    }

    public void a() {
        this.f42317a.clear();
        this.f42318b.clear();
        this.f42319c.clear();
        this.f42320d.clear();
        this.f42321e.clear();
        this.f42322f.clear();
        this.f42323g.clear();
        this.f42325i = false;
    }

    public String b(String str) {
        return this.f42323g.get(str);
    }

    public HashSet<String> b() {
        return this.f42322f;
    }

    public C0469a c(View view) {
        C0469a c0469a = this.f42318b.get(view);
        if (c0469a != null) {
            this.f42318b.remove(view);
        }
        return c0469a;
    }

    public HashSet<String> c() {
        return this.f42321e;
    }

    public String d(View view) {
        if (this.f42317a.size() == 0) {
            return null;
        }
        String str = this.f42317a.get(view);
        if (str != null) {
            this.f42317a.remove(view);
        }
        return str;
    }

    public void d() {
        this.f42325i = true;
    }

    public c e(View view) {
        if (this.f42320d.contains(view)) {
            return c.PARENT_VIEW;
        }
        return this.f42325i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void e() {
        com.iab.omid.library.bytedance2.internal.c cVarC = com.iab.omid.library.bytedance2.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.bytedance2.adsession.a aVar : cVarC.a()) {
                View viewC = aVar.c();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewC != null) {
                        String strA = a(viewC);
                        if (strA == null) {
                            this.f42321e.add(adSessionId);
                            this.f42317a.put(viewC, adSessionId);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f42322f.add(adSessionId);
                            this.f42319c.put(adSessionId, viewC);
                            this.f42323g.put(adSessionId, strA);
                        }
                    } else {
                        this.f42322f.add(adSessionId);
                        this.f42323g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public boolean f(View view) {
        if (!this.f42324h.containsKey(view)) {
            return true;
        }
        this.f42324h.put(view, Boolean.TRUE);
        return false;
    }
}
