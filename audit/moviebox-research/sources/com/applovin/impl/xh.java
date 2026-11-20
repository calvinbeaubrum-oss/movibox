package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class xh extends dc {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final a4.a f24324n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Context f24325o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f24326p;

    public xh(a4.a aVar, boolean z11, Context context) {
        super(dc.c.RIGHT_DETAIL);
        this.f24324n = aVar;
        this.f24325o = context;
        this.f18405c = new SpannedString(aVar.a());
        this.f24326p = z11;
    }

    @Override // com.applovin.impl.dc
    public SpannedString f() {
        return new SpannedString(this.f24324n.a(this.f24325o));
    }

    @Override // com.applovin.impl.dc
    public boolean o() {
        return false;
    }

    @Override // com.applovin.impl.dc
    public boolean p() {
        Boolean boolB = this.f24324n.b(this.f24325o);
        if (boolB != null) {
            return boolB.equals(Boolean.valueOf(this.f24326p));
        }
        return false;
    }
}
