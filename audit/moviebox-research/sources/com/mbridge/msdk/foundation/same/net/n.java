package com.mbridge.msdk.foundation.same.net;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static n f44707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f44708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.net.e.b f44709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private j f44710d;

    private n() {
    }

    public static com.mbridge.msdk.foundation.same.net.e.b a() {
        n nVar = f44707a;
        if (nVar != null) {
            com.mbridge.msdk.foundation.same.net.e.b bVar = nVar.f44709c;
            if (bVar != null) {
                return bVar;
            }
            nVar.f44709c = new com.mbridge.msdk.foundation.same.net.e.b(b(), 3);
            return f44707a.f44709c;
        }
        n nVar2 = new n();
        f44707a = nVar2;
        if (nVar2.f44709c == null) {
            nVar2.f44709c = new com.mbridge.msdk.foundation.same.net.e.b(b(), 3);
        }
        return f44707a.f44709c;
    }

    public static void a(Context context) {
        if (f44707a == null) {
            n nVar = new n();
            f44707a = nVar;
            nVar.f44710d = new j(context.getApplicationContext());
            f44707a.f44709c = new com.mbridge.msdk.foundation.same.net.e.b(b(), 3);
        }
    }

    public static void a(i iVar) {
        b().a(iVar);
    }

    private static j b() {
        n nVar = f44707a;
        if (nVar != null) {
            j jVar = nVar.f44710d;
            if (jVar != null) {
                return jVar;
            }
            nVar.f44710d = new j(com.mbridge.msdk.foundation.controller.c.m().c());
            return f44707a.f44710d;
        }
        n nVar2 = new n();
        f44707a = nVar2;
        if (nVar2.f44710d == null) {
            nVar2.f44710d = new j(com.mbridge.msdk.foundation.controller.c.m().c());
        }
        return f44707a.f44710d;
    }

    public static void b(i iVar) {
        n nVar = f44707a;
        if (nVar == null) {
            n nVar2 = new n();
            f44707a = nVar2;
            if (nVar2.f44708b == null) {
                nVar2.f44708b = new j(com.mbridge.msdk.foundation.controller.c.m().c(), null);
            }
        } else if (nVar.f44708b == null) {
            nVar.f44708b = new j(com.mbridge.msdk.foundation.controller.c.m().c(), null);
        }
        f44707a.f44708b.a(iVar);
    }
}
