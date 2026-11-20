package com.squareup.okhttp.internal;

import com.squareup.okhttp.Route;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Route> f49088a = new LinkedHashSet();

    public synchronized void a(Route route) {
        this.f49088a.remove(route);
    }

    public synchronized void b(Route route) {
        this.f49088a.add(route);
    }

    public synchronized boolean c(Route route) {
        return this.f49088a.contains(route);
    }
}
