package com.mbridge.msdk.newreward.function.d.c;

import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends a<File> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y f46356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f46357c;

    public n(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar) {
        super(bVar, aVar);
        this.f46356b = new y(a(), b(), this, 100);
    }

    public final void a(File file) {
        this.f46357c = file;
    }

    public final File f() {
        return this.f46357c;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.o
    public final boolean g() {
        ArrayList<Integer> rsIgnoreCheckRule;
        if (b() == null || b().g() == null || (rsIgnoreCheckRule = b().g().getRsIgnoreCheckRule()) == null) {
            return false;
        }
        return rsIgnoreCheckRule.contains(0);
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.o
    public final int h() {
        return 1;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.o
    public final boolean i() {
        return true;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.a, com.mbridge.msdk.newreward.function.d.c.o
    public final String j() {
        return (b() == null || b().g() == null) ? "" : b().g().getVideoUrlEncode();
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.a, com.mbridge.msdk.newreward.function.d.c.o
    public final q k() {
        return this.f46356b;
    }
}
