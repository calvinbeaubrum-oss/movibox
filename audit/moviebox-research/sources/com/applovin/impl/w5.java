package com.applovin.impl;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w5 implements i5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f24055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final xo f24056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i5.a f24057c;

    public w5(Context context, xo xoVar, i5.a aVar) {
        this.f24055a = context.getApplicationContext();
        this.f24056b = xoVar;
        this.f24057c = aVar;
    }

    public w5(Context context, String str) {
        this(context, str, (xo) null);
    }

    public w5(Context context, String str, xo xoVar) {
        this(context, xoVar, new d6.b().a(str));
    }

    @Override // com.applovin.impl.i5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v5 a() {
        v5 v5Var = new v5(this.f24055a, this.f24057c.a());
        xo xoVar = this.f24056b;
        if (xoVar != null) {
            v5Var.a(xoVar);
        }
        return v5Var;
    }
}
