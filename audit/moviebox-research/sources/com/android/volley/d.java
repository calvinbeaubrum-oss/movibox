package com.android.volley;

import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f16501d;

    public d() {
        this(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 1, 1.0f);
    }

    public d(int i11, int i12, float f11) {
        this.f16498a = i11;
        this.f16500c = i12;
        this.f16501d = f11;
    }

    @Override // com.android.volley.k
    public int a() {
        return this.f16499b;
    }

    @Override // com.android.volley.k
    public void b(VolleyError volleyError) throws VolleyError {
        this.f16499b++;
        int i11 = this.f16498a;
        this.f16498a = i11 + ((int) (i11 * this.f16501d));
        if (!d()) {
            throw volleyError;
        }
    }

    @Override // com.android.volley.k
    public int c() {
        return this.f16498a;
    }

    public boolean d() {
        return this.f16499b <= this.f16500c;
    }
}
