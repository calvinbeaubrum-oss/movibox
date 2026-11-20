package com.mbridge.msdk.newreward.function.d.c;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f46351b;

    public e(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar) {
        super(bVar, aVar);
        this.f46351b = new s(a(), b(), this);
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.o
    public final int h() {
        return 3;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.a, com.mbridge.msdk.newreward.function.d.c.o
    public final String j() {
        return (a() == null || TextUtils.isEmpty(a().z())) ? "" : a().z();
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.a, com.mbridge.msdk.newreward.function.d.c.o
    public final q k() {
        return this.f46351b;
    }
}
