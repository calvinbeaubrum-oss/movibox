package com.applovin.impl.sdk;

import com.applovin.impl.ge;
import com.applovin.impl.q6;
import com.transsion.push.PushConstants;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f22491b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f22492c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f22493d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f22494e = new Object();

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f22495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f22497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f22498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f22499e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f22500f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f22501g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f22502h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f22503i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final ArrayDeque f22504j;

        private b(ge geVar, c cVar) {
            this.f22504j = new ArrayDeque();
            this.f22495a = geVar.getAdUnitId();
            this.f22496b = geVar.getFormat().getLabel();
            this.f22497c = geVar.c();
            this.f22498d = geVar.b();
            this.f22499e = geVar.A();
            this.f22500f = geVar.C();
            this.f22501g = geVar.getCreativeId();
            this.f22502h = geVar.hashCode();
            a(cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar) {
            this.f22503i = System.currentTimeMillis();
            this.f22504j.add(cVar);
        }

        public String a() {
            return this.f22495a;
        }

        public String b() {
            return this.f22498d;
        }

        public String c() {
            return this.f22497c;
        }

        public String d() {
            return this.f22499e;
        }

        public String e() {
            return this.f22500f;
        }

        public String f() {
            return this.f22501g;
        }

        public String g() {
            return this.f22496b;
        }

        public int h() {
            return this.f22502h;
        }

        public c i() {
            return (c) this.f22504j.getLast();
        }

        public String toString() {
            return "AdInfo{state='" + i() + "', adUnitId='" + this.f22495a + "', format='" + this.f22496b + "', adapterName='" + this.f22497c + "', adapterClass='" + this.f22498d + "', adapterVersion='" + this.f22499e + "', bCode='" + this.f22500f + "', creativeId='" + this.f22501g + "', updated=" + this.f22503i + '}';
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum c {
        LOAD("load"),
        SHOW(PushConstants.PUSH_SERVICE_TYPE_SHOW),
        HIDE("hide"),
        CLICK("click"),
        DESTROY(PushConstants.PROVIDER_FIELD_DESTROY),
        SHOW_ERROR("show_error");


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Set f22511i = new HashSet(Arrays.asList(values()));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f22513a;

        c(String str) {
            this.f22513a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f22513a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(b bVar);
    }

    public e(j jVar) {
        this.f22490a = jVar;
        a();
    }

    private Set a(c cVar) {
        synchronized (this.f22492c) {
            try {
                Set set = (Set) this.f22491b.get(cVar);
                if (q6.a(set)) {
                    return set;
                }
                return new HashSet();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void a(b bVar, c cVar) {
        synchronized (this.f22492c) {
            try {
                Iterator it = a(cVar).iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a(bVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a() {
        synchronized (this.f22492c) {
            try {
                for (c cVar : c.values()) {
                    this.f22491b.put(cVar, new HashSet());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(ge geVar, c cVar) {
        synchronized (this.f22494e) {
            try {
                int iHashCode = geVar.hashCode();
                b bVar = (b) this.f22493d.get(Integer.valueOf(iHashCode));
                if (bVar == null) {
                    if (cVar == c.DESTROY) {
                        return;
                    }
                    bVar = new b(geVar, cVar);
                    this.f22493d.put(Integer.valueOf(iHashCode), bVar);
                } else if (bVar.i() == cVar) {
                    return;
                } else {
                    bVar.a(cVar);
                }
                if (cVar == c.DESTROY) {
                    this.f22493d.remove(Integer.valueOf(iHashCode));
                }
                a(bVar, cVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(d dVar) {
        synchronized (this.f22492c) {
            try {
                Iterator it = this.f22491b.keySet().iterator();
                while (it.hasNext()) {
                    a((c) it.next()).remove(dVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(d dVar, Set set) {
        synchronized (this.f22492c) {
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    a((c) it.next()).add(dVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
