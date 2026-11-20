package com.transsion.transfer.androidasync.http;

import android.os.Build;
import com.google.android.gms.security.ProviderInstaller;
import java.lang.reflect.Field;
import java.util.Hashtable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b0 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable<String, a> f58632a = new Hashtable<>();

    /* JADX INFO: compiled from: source.java */
    public static class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Field f58633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Field f58634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Field f58635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Field f58636d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f58637e;

        public a(Class cls) {
            try {
                Field declaredField = cls.getSuperclass().getDeclaredField("peerHost");
                this.f58633a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getSuperclass().getDeclaredField("peerPort");
                this.f58634b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("sslParameters");
                this.f58635c = declaredField3;
                declaredField3.setAccessible(true);
                Field declaredField4 = this.f58635c.getType().getDeclaredField("useSni");
                this.f58636d = declaredField4;
                declaredField4.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        }

        @Override // com.transsion.transfer.androidasync.http.m
        public SSLEngine a(SSLContext sSLContext, String str, int i11) {
            return null;
        }

        @Override // com.transsion.transfer.androidasync.http.m
        public void b(SSLEngine sSLEngine, g.a aVar, String str, int i11) {
            if (this.f58636d == null || this.f58637e) {
                return;
            }
            try {
                this.f58633a.set(sSLEngine, str);
                this.f58634b.set(sSLEngine, Integer.valueOf(i11));
                this.f58636d.set(this.f58635c.get(sSLEngine), Boolean.TRUE);
            } catch (IllegalAccessException unused) {
            }
        }
    }

    @Override // com.transsion.transfer.androidasync.http.m
    public SSLEngine a(SSLContext sSLContext, String str, int i11) {
        return (ProviderInstaller.PROVIDER_NAME.equals(sSLContext.getProvider().getName()) || Build.VERSION.SDK_INT >= 23) ? sSLContext.createSSLEngine(str, i11) : sSLContext.createSSLEngine();
    }

    @Override // com.transsion.transfer.androidasync.http.m
    public void b(SSLEngine sSLEngine, g.a aVar, String str, int i11) {
        c(sSLEngine).b(sSLEngine, aVar, str, i11);
    }

    public a c(SSLEngine sSLEngine) {
        String canonicalName = sSLEngine.getClass().getCanonicalName();
        a aVar = this.f58632a.get(canonicalName);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(sSLEngine.getClass());
        this.f58632a.put(canonicalName, aVar2);
        return aVar2;
    }
}
