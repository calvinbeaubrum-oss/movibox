package com.applovin.impl;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f23154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f23156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f23157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f23158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f23159f;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AudioTrack f23160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioTimestamp f23161b = new AudioTimestamp();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f23162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f23163d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f23164e;

        public a(AudioTrack audioTrack) {
            this.f23160a = audioTrack;
        }

        public long a() {
            return this.f23164e;
        }

        public long b() {
            return this.f23161b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f23160a.getTimestamp(this.f23161b);
            if (timestamp) {
                long j11 = this.f23161b.framePosition;
                if (this.f23163d > j11) {
                    this.f23162c++;
                }
                this.f23163d = j11;
                this.f23164e = j11 + (this.f23162c << 32);
            }
            return timestamp;
        }
    }

    public t1(AudioTrack audioTrack) {
        if (xp.f24372a >= 19) {
            this.f23154a = new a(audioTrack);
            f();
        } else {
            this.f23154a = null;
            a(3);
        }
    }

    private void a(int i11) {
        this.f23155b = i11;
        if (i11 == 0) {
            this.f23158e = 0L;
            this.f23159f = -1L;
            this.f23156c = System.nanoTime() / 1000;
            this.f23157d = 10000L;
            return;
        }
        if (i11 == 1) {
            this.f23157d = 10000L;
            return;
        }
        if (i11 == 2 || i11 == 3) {
            this.f23157d = 10000000L;
        } else {
            if (i11 != 4) {
                throw new IllegalStateException();
            }
            this.f23157d = 500000L;
        }
    }

    public void a() {
        if (this.f23155b == 4) {
            f();
        }
    }

    public boolean a(long j11) {
        a aVar = this.f23154a;
        if (aVar == null || j11 - this.f23158e < this.f23157d) {
            return false;
        }
        this.f23158e = j11;
        boolean zC = aVar.c();
        int i11 = this.f23155b;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (zC) {
                        f();
                    }
                } else if (!zC) {
                    f();
                }
            } else if (!zC) {
                f();
            } else if (this.f23154a.a() > this.f23159f) {
                a(2);
            }
        } else if (zC) {
            if (this.f23154a.b() < this.f23156c) {
                return false;
            }
            this.f23159f = this.f23154a.a();
            a(1);
        } else if (j11 - this.f23156c > 500000) {
            a(3);
        }
        return zC;
    }

    public long b() {
        a aVar = this.f23154a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    public long c() {
        a aVar = this.f23154a;
        return aVar != null ? aVar.b() : C.TIME_UNSET;
    }

    public boolean d() {
        return this.f23155b == 2;
    }

    public void e() {
        a(4);
    }

    public void f() {
        if (this.f23154a != null) {
            a(0);
        }
    }
}
