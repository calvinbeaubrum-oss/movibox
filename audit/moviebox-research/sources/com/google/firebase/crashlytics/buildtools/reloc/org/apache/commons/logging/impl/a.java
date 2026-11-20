package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl;

import java.security.PrivilegedAction;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f40088a;

    public a(String str) {
        this.f40088a = str;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        ClassLoader contextClassLoader = SimpleLog.getContextClassLoader();
        return contextClassLoader != null ? contextClassLoader.getResourceAsStream(this.f40088a) : ClassLoader.getSystemResourceAsStream(this.f40088a);
    }
}
