package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class x4 extends ec {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.applovin.impl.sdk.j f24219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f24220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f24221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f24222i;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        RECENT_ADS,
        COUNT
    }

    public x4(Context context) {
        super(context);
        this.f24221h = new AtomicBoolean();
        this.f24222i = new ArrayList();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new v6((w6) it.next(), this.f18683a));
        }
        return arrayList;
    }

    public void a(List list, com.applovin.impl.sdk.j jVar) {
        Activity activityN0;
        this.f24219f = jVar;
        this.f24220g = list;
        if (!(this.f18683a instanceof Activity) && (activityN0 = jVar.n0()) != null) {
            this.f18683a = activityN0;
        }
        if (list != null && this.f24221h.compareAndSet(false, true)) {
            this.f24222i = a(this.f24220g);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.v80
            @Override // java.lang.Runnable
            public final void run() {
                this.f23785a.notifyDataSetChanged();
            }
        });
    }

    @Override // com.applovin.impl.ec
    public int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.ec
    public List c(int i11) {
        return this.f24222i;
    }

    @Override // com.applovin.impl.ec
    public int d(int i11) {
        return this.f24222i.size();
    }

    public List d() {
        return this.f24220g;
    }

    @Override // com.applovin.impl.ec
    public dc e(int i11) {
        return new fj("RECENT ADS");
    }

    public com.applovin.impl.sdk.j e() {
        return this.f24219f;
    }

    public boolean f() {
        return this.f24222i.size() == 0;
    }

    public void g() {
        this.f24221h.compareAndSet(true, false);
    }

    public String toString() {
        return "CreativeDebuggerListAdapter{isInitialized=" + this.f24221h.get() + "}";
    }
}
