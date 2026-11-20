package com.applovin.impl;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface o8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o8 f21466a = new o8() { // from class: com.applovin.impl.p00
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return q00.b();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    k8[] a();

    k8[] a(Uri uri, Map map);
}
