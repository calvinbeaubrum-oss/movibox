package com.mbridge.msdk.newreward.function.d.c;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a<Resource> implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.d.a.b f46343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.d.a.a f46344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f46345d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f46346e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f46347f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f46342a = false;

    public a(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar) {
        this.f46343b = bVar;
        this.f46344c = aVar;
    }

    public final com.mbridge.msdk.newreward.function.d.a.b a() {
        return this.f46343b;
    }

    public final void a(int i11) {
        this.f46345d = i11;
    }

    public final void a(boolean z11) {
        this.f46342a = z11;
    }

    public final com.mbridge.msdk.newreward.function.d.a.a b() {
        return this.f46344c;
    }

    public final void b(boolean z11) {
        this.f46346e = z11;
    }

    public boolean c() {
        return TextUtils.isEmpty(j()) || g() || this.f46346e;
    }

    public boolean d() {
        return TextUtils.isEmpty(j()) || i() || this.f46347f;
    }

    public final int e() {
        return this.f46345d;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.o
    public abstract /* synthetic */ String j();

    @Override // com.mbridge.msdk.newreward.function.d.c.o
    public abstract /* synthetic */ q k();
}
