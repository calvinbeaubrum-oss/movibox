package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f39974b = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Service f39975a = new C0421a();

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0421a extends d {
        public C0421a() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.d
        public void d() {
            a.this.g();
        }

        public String toString() {
            return a.this.toString();
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Service
    public final Service.State a() {
        return this.f39975a.a();
    }

    public abstract void c() throws Exception;

    public String d() {
        return getClass().getSimpleName();
    }

    public void e() throws Exception {
    }

    public void f() throws Exception {
    }

    public void g() {
    }

    public String toString() {
        return d() + " [" + a() + "]";
    }
}
