package com.transsion.api.gateway.dns;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c {
    private static volatile c INSTANCE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CopyOnWriteArrayList<b> f50732a = new CopyOnWriteArrayList<>();

    public static c a() {
        if (INSTANCE == null) {
            synchronized (c.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new c();
                        INSTANCE.b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return INSTANCE;
    }

    public final void b() {
        b bVar = new b("apigateway.tmctool.com");
        b bVar2 = new b("apigateway.tmctool.com");
        for (String str : com.transsion.api.gateway.config.d.f50728a) {
            bVar.a(str, 443);
        }
        for (String str2 : com.transsion.api.gateway.config.c.f50727a) {
            bVar2.a(str2, 443);
        }
        f50732a.add(bVar);
        f50732a.add(bVar2);
    }
}
