package com.transsion.ga;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f51961a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f51962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f51963c;

    public e(String str, Bundle bundle) {
        super(str, null);
        this.f51962b = str;
        this.f51963c = bundle;
    }

    public e(String str, Throwable th2) {
        super(str, th2);
        this.f51962b = str;
        this.f51963c = null;
    }

    public static void a(String str, Throwable th2) {
        l.a().c(new e(str, th2));
    }

    public String a() {
        return this.f51962b;
    }

    public Bundle b() {
        return this.f51963c;
    }
}
