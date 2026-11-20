package com.mbridge.msdk.f.a;

import android.os.CountDownTimer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.f.a.a f43974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f43975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f43976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f43977d = 0;

    /* JADX INFO: compiled from: source.java */
    public static class a extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.f.a.a f43978a;

        public a(long j11, long j12) {
            super(j11, j12);
        }

        public final void a(com.mbridge.msdk.f.a.a aVar) {
            this.f43978a = aVar;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            com.mbridge.msdk.f.a.a aVar = this.f43978a;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j11) {
            com.mbridge.msdk.f.a.a aVar = this.f43978a;
            if (aVar != null) {
                aVar.onTick(j11);
            }
        }
    }

    public final b a(long j11) {
        if (j11 < 0) {
            j11 = 1000;
        }
        this.f43975b = j11;
        return this;
    }

    public final b a(com.mbridge.msdk.f.a.a aVar) {
        this.f43974a = aVar;
        return this;
    }

    public final void a() {
        a aVar = this.f43976c;
        if (aVar != null) {
            aVar.cancel();
            this.f43976c = null;
        }
    }

    public final b b(long j11) {
        this.f43977d = j11;
        return this;
    }

    public final void b() {
        a aVar = this.f43976c;
        if (aVar == null) {
            if (aVar != null) {
                aVar.cancel();
                this.f43976c = null;
            }
            if (this.f43975b <= 0) {
                this.f43975b = this.f43977d + 1000;
            }
            a aVar2 = new a(this.f43977d, this.f43975b);
            this.f43976c = aVar2;
            aVar2.a(this.f43974a);
        }
        this.f43976c.start();
    }
}
