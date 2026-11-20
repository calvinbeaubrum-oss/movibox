package com.applovin.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class fi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f19000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f19002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f19003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f19004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Object f19005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile Object f19006g;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(Object obj);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(boolean z11, Object obj, Object obj2);
    }

    public fi() {
        this(null);
    }

    public fi(String str) {
        this.f19000a = new Object();
        this.f19002c = new ArrayList();
        this.f19003d = false;
        this.f19004e = false;
        this.f19001b = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, boolean z11, Object obj, Object obj2) {
        if (z11) {
            return;
        }
        aVar.a(obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Runnable runnable, boolean z11, Object obj, Object obj2) {
        if (z11) {
            runnable.run();
        }
    }

    private void a(boolean z11, Object obj, Object obj2) {
        synchronized (this.f19000a) {
            try {
                if (this.f19003d) {
                    return;
                }
                this.f19005f = obj;
                this.f19006g = obj2;
                this.f19004e = z11;
                this.f19003d = true;
                Iterator it = this.f19002c.iterator();
                while (it.hasNext()) {
                    b((b) it.next());
                }
                this.f19002c.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void b(b bVar) {
        try {
            bVar.a(this.f19004e, this.f19005f, this.f19006g);
        } catch (Throwable th2) {
            q6.a(th2, "Promise callbacks must not throw exceptions", new Object[0]);
        }
    }

    public static fi c(Object obj) {
        return new fi().b(obj);
    }

    public fi a(Object obj) {
        a(false, null, obj);
        return this;
    }

    public Object a() {
        q6.a(d());
        return this.f19006g;
    }

    public void a(final a aVar) {
        a(new b() { // from class: com.applovin.impl.qv
            @Override // com.applovin.impl.fi.b
            public final void a(boolean z11, Object obj, Object obj2) {
                fi.a(aVar, z11, obj, obj2);
            }
        });
    }

    public void a(b bVar) {
        synchronized (this.f19000a) {
            try {
                if (this.f19003d) {
                    b(bVar);
                } else {
                    this.f19002c.add(bVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(final Runnable runnable) {
        a(new b() { // from class: com.applovin.impl.rv
            @Override // com.applovin.impl.fi.b
            public final void a(boolean z11, Object obj, Object obj2) {
                fi.a(runnable, z11, obj, obj2);
            }
        });
    }

    public fi b(Object obj) {
        a(true, obj, null);
        return this;
    }

    public String b() {
        String str = this.f19001b;
        return str != null ? str : super.toString();
    }

    public boolean c() {
        return this.f19003d;
    }

    public boolean d() {
        return this.f19003d && !this.f19004e;
    }

    public String toString() {
        String str;
        if (!this.f19003d) {
            str = "Waiting";
        } else if (this.f19004e) {
            str = "Success -> " + this.f19005f;
        } else {
            str = "Failed -> " + this.f19006g;
        }
        return "Promise(" + b() + ": " + str + ")";
    }
}
