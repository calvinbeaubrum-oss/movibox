package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class yl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f24689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f24690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f24691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f24692d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f24693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f24694g;

    public yl(String str, com.applovin.impl.sdk.j jVar) {
        this(str, jVar, false, null);
    }

    public yl(String str, com.applovin.impl.sdk.j jVar, String str2) {
        this(str, jVar, false, str2);
    }

    public yl(String str, com.applovin.impl.sdk.j jVar, boolean z11) {
        this(str, jVar, z11, null);
    }

    public yl(String str, com.applovin.impl.sdk.j jVar, boolean z11, String str2) {
        this.f24690b = str;
        this.f24689a = jVar;
        this.f24691c = jVar.J();
        this.f24692d = com.applovin.impl.sdk.j.l();
        this.f24694g = z11;
        this.f24693f = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Thread thread, long j11) {
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("name", thread.getState().name());
        if (StringUtils.isValidString(this.f24693f)) {
            mapHashMap.put("details", this.f24693f);
        }
        this.f24689a.E().a(la.Q, this.f24690b, (Map) mapHashMap);
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.k(this.f24690b, "Task has been executing for over " + TimeUnit.MILLISECONDS.toSeconds(j11) + " seconds");
        }
    }

    public Context a() {
        return this.f24692d;
    }

    public void a(String str) {
        this.f24693f = str;
    }

    public void a(Throwable th2) {
        Map map = CollectionUtils.map("source", this.f24690b);
        map.put("top_main_method", th2.toString());
        map.put("details", StringUtils.emptyIfNull(this.f24693f));
        this.f24689a.E().a(la.P, map);
    }

    public void a(boolean z11) {
        this.f24694g = z11;
    }

    public com.applovin.impl.sdk.j b() {
        return this.f24689a;
    }

    public ScheduledFuture b(final Thread thread, final long j11) {
        if (j11 <= 0) {
            return null;
        }
        return this.f24689a.j0().b(new jn(this.f24689a, "timeout:" + this.f24690b, new Runnable() { // from class: com.applovin.impl.z90
            @Override // java.lang.Runnable
            public final void run() {
                this.f24826a.a(thread, j11);
            }
        }), tm.b.TIMEOUT, j11);
    }

    public String c() {
        return this.f24690b;
    }

    public boolean d() {
        return this.f24694g;
    }
}
