package com.mbridge.msdk.newreward.function.d.c;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends c {
    public i(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar) {
        super(bVar, aVar);
        b(true);
        a(false);
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.c
    public final boolean a_() {
        return true;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.o
    public final int h() {
        return 3;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.a, com.mbridge.msdk.newreward.function.d.c.o
    public final String j() {
        if (b() == null) {
            return "";
        }
        String strZ = a().z();
        return TextUtils.isEmpty(strZ) ? "" : strZ;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.a, com.mbridge.msdk.newreward.function.d.c.o
    public final q k() {
        return new z(a(), b(), this);
    }
}
