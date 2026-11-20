package com.mbridge.msdk.foundation.same.net;

import com.hisavana.common.constant.ComConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f44543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f44544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f44545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f44546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f44547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f44548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f44549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f44550h;

    public b() {
        this(ComConstants.AD_TIMEOUT_MILLIS, 0);
    }

    public b(int i11, int i12) {
        this.f44544b = 0;
        this.f44545c = 0;
        this.f44548f = 0;
        this.f44549g = 0;
        this.f44550h = 2;
        this.f44547e = i11 <= 0 ? ComConstants.AD_TIMEOUT_MILLIS : i11;
        this.f44543a = i12;
    }

    public b(int i11, int i12, int i13, int i14, int i15) {
        this.f44544b = 0;
        this.f44545c = 0;
        this.f44548f = 0;
        this.f44549g = 0;
        this.f44550h = 2;
        this.f44545c = Math.max(i11, 0);
        this.f44548f = Math.max(i12, 0);
        this.f44549g = Math.max(i13, 0);
        this.f44544b = Math.max(i14, 0);
        this.f44543a = Math.max(i15, 0);
    }

    public b(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f44544b = 0;
        this.f44545c = 0;
        this.f44548f = 0;
        this.f44549g = 0;
        this.f44550h = 2;
        this.f44545c = Math.max(i11, 0);
        this.f44548f = Math.max(i12, 0);
        this.f44549g = Math.max(i13, 0);
        this.f44544b = Math.max(i14, 0);
        this.f44543a = Math.max(i15, 0);
        this.f44550h = i16;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int a() {
        return this.f44547e;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final boolean a(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        int i11 = this.f44546d + 1;
        this.f44546d = i11;
        return i11 <= this.f44543a;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int b() {
        return this.f44543a;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int c() {
        return this.f44545c;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int d() {
        return this.f44548f;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int e() {
        return this.f44549g;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int f() {
        return this.f44544b;
    }
}
