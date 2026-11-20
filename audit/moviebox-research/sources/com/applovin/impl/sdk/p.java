package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue f22819a = new LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f22820b = new Object();

    public AppLovinAdImpl a() {
        AppLovinAdImpl appLovinAdImpl;
        synchronized (this.f22820b) {
            try {
                appLovinAdImpl = !c() ? (AppLovinAdImpl) this.f22819a.poll() : null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return appLovinAdImpl;
    }

    public void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f22820b) {
            try {
                if (b() <= 25) {
                    this.f22819a.offer(appLovinAdImpl);
                } else {
                    n.h("AppLovinSdk", "Maximum queue capacity reached - discarding ad...");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int b() {
        int size;
        synchronized (this.f22820b) {
            size = this.f22819a.size();
        }
        return size;
    }

    public void b(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f22820b) {
            this.f22819a.remove(appLovinAdImpl);
        }
    }

    public boolean c() {
        boolean z11;
        synchronized (this.f22820b) {
            z11 = b() == 0;
        }
        return z11;
    }

    public AppLovinAdImpl d() {
        AppLovinAdImpl appLovinAdImpl;
        synchronized (this.f22820b) {
            appLovinAdImpl = (AppLovinAdImpl) this.f22819a.peek();
        }
        return appLovinAdImpl;
    }
}
