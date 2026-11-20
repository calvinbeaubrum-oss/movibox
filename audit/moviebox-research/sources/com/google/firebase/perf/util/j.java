package com.google.firebase.perf.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URL f41035a;

    public j(URL url) {
        this.f41035a = url;
    }

    public URLConnection a() throws IOException {
        return this.f41035a.openConnection();
    }

    public String toString() {
        return this.f41035a.toString();
    }
}
