package com.mbridge.msdk.foundation.same.net.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f44530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<String> f44531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CronetEngine.Builder f44532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CronetEngine f44533d;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.same.net.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0491a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f44534a = new a();
    }

    private a() {
        this.f44530a = Executors.newCachedThreadPool();
        this.f44531b = new ArrayList<>();
        if (this.f44532c == null) {
            this.f44532c = d();
        }
        this.f44533d = this.f44532c.build();
    }

    public static a a() {
        return C0491a.f44534a;
    }

    private CronetEngine.Builder d() {
        if (this.f44532c == null) {
            this.f44532c = new CronetEngine.Builder(com.mbridge.msdk.foundation.controller.c.m().c());
            this.f44532c.setStoragePath(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_OTHER)).enableHttpCache(2, 5242880L).enableHttp2(true).enableQuic(true);
        }
        return this.f44532c;
    }

    public final void a(String str) {
        try {
            if (TextUtils.isEmpty(str) || this.f44531b.contains(str)) {
                return;
            }
            this.f44531b.add(str);
            if (this.f44532c == null) {
                this.f44532c = d();
            }
            CronetEngine.Builder builder = this.f44532c;
            if (builder != null) {
                builder.addQuicHint(str, 443, 443);
            }
        } catch (Throwable th2) {
            ad.b("CronetEngineManager", th2.getMessage());
        }
    }

    public final ExecutorService b() {
        return this.f44530a;
    }

    public final CronetEngine c() {
        if (com.mbridge.msdk.foundation.controller.c.m().c() == null) {
            return null;
        }
        CronetEngine cronetEngine = this.f44533d;
        if (cronetEngine != null) {
            return cronetEngine;
        }
        if (this.f44532c == null) {
            this.f44532c = d();
        }
        CronetEngine cronetEngineBuild = this.f44532c.build();
        this.f44533d = cronetEngineBuild;
        return cronetEngineBuild;
    }
}
