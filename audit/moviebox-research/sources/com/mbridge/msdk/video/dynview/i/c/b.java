package com.mbridge.msdk.video.dynview.i.c;

import android.os.CountDownTimer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f47633a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f47634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.i.c.a f47635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f47636d;

    /* JADX INFO: compiled from: source.java */
    public static class a extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.video.dynview.i.c.a f47637a;

        public a(long j11, long j12) {
            super(j11, j12);
        }

        public final void a(com.mbridge.msdk.video.dynview.i.c.a aVar) {
            this.f47637a = aVar;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            com.mbridge.msdk.video.dynview.i.c.a aVar = this.f47637a;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j11) {
            com.mbridge.msdk.video.dynview.i.c.a aVar = this.f47637a;
            if (aVar != null) {
                aVar.a(j11);
            }
        }
    }

    private void c() {
        a aVar = this.f47636d;
        if (aVar != null) {
            aVar.cancel();
            this.f47636d = null;
        }
        if (this.f47634b <= 0) {
            this.f47634b = this.f47633a + 1000;
        }
        a aVar2 = new a(this.f47633a, this.f47634b);
        this.f47636d = aVar2;
        aVar2.a(this.f47635c);
    }

    public final b a(long j11) {
        if (j11 < 0) {
            j11 = 1000;
        }
        this.f47634b = j11;
        return this;
    }

    public final b a(com.mbridge.msdk.video.dynview.i.c.a aVar) {
        this.f47635c = aVar;
        return this;
    }

    public final void a() {
        if (this.f47636d == null) {
            c();
        }
        this.f47636d.start();
    }

    public final void a(long j11, com.mbridge.msdk.video.dynview.i.c.a aVar) {
        this.f47633a = j11;
        this.f47635c = aVar;
        c();
        a aVar2 = this.f47636d;
        if (aVar2 != null) {
            aVar2.start();
        }
    }

    public final b b(long j11) {
        this.f47633a = j11;
        return this;
    }

    public final void b() {
        a aVar = this.f47636d;
        if (aVar != null) {
            aVar.cancel();
            this.f47636d = null;
        }
    }
}
