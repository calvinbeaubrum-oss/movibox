package com.mbridge.msdk.newreward.function.d.c;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f46355c;

    public m(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar, String str) {
        super(bVar, aVar);
        this.f46355c = str;
        b(true);
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.c
    public final boolean a_() {
        return true;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.o
    public final int h() {
        return 7;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.a, com.mbridge.msdk.newreward.function.d.c.o
    public final String j() {
        return TextUtils.isEmpty(this.f46355c) ? "" : this.f46355c;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.a, com.mbridge.msdk.newreward.function.d.c.o
    public final q k() {
        return new v(a(), b(), this);
    }
}
