package com.mbridge.msdk.e.a;

import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f43785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f43786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f43787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f43788d;

    public f() {
        this(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 1, 1.0f);
    }

    public f(int i11, int i12, float f11) {
        this.f43785a = i11;
        this.f43787c = i12;
        this.f43788d = f11;
    }

    @Override // com.mbridge.msdk.e.a.v
    public final int a() {
        return this.f43785a;
    }

    @Override // com.mbridge.msdk.e.a.v
    public final void a(z zVar) throws z {
        int i11 = this.f43786b + 1;
        this.f43786b = i11;
        int i12 = this.f43785a;
        this.f43785a = i12 + ((int) (i12 * this.f43788d));
        if (i11 > this.f43787c) {
            throw zVar;
        }
    }

    @Override // com.mbridge.msdk.e.a.v
    public final int b() {
        return this.f43786b;
    }
}
