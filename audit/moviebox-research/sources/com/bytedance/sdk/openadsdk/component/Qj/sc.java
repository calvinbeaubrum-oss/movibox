package com.bytedance.sdk.openadsdk.component.Qj;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class sc {
    private long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f27749sc;

    public long pFF() {
        return this.pFF;
    }

    public float sc() {
        return this.f27749sc;
    }

    public void sc(float f11) {
        StringBuilder sb2 = new StringBuilder("setTotalTime() called with: time = [");
        sb2.append(f11);
        sb2.append("]");
        this.f27749sc = f11;
    }

    public void sc(long j11) {
        this.pFF = j11;
    }
}
