package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ze {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f24844a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(ge geVar);
    }

    public void a(ge geVar) {
        Iterator it = new ArrayList(this.f24844a).iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(geVar);
        }
    }

    public void a(a aVar) {
        this.f24844a.add(aVar);
    }

    public void b(a aVar) {
        this.f24844a.remove(aVar);
    }
}
