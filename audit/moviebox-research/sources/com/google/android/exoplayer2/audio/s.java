package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final a f32909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f32910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f32911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f32912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f32913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f32914f;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(19)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioTrack f32915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioTimestamp f32916b = new AudioTimestamp();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f32917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f32918d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f32919e;

        public a(AudioTrack audioTrack) {
            this.f32915a = audioTrack;
        }

        public long a() {
            return this.f32919e;
        }

        public long b() {
            return this.f32916b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f32915a.getTimestamp(this.f32916b);
            if (timestamp) {
                long j11 = this.f32916b.framePosition;
                if (this.f32918d > j11) {
                    this.f32917c++;
                }
                this.f32918d = j11;
                this.f32919e = j11 + (this.f32917c << 32);
            }
            return timestamp;
        }
    }

    public s(AudioTrack audioTrack) {
        if (o0.f35608a >= 19) {
            this.f32909a = new a(audioTrack);
            g();
        } else {
            this.f32909a = null;
            h(3);
        }
    }

    public void a() {
        if (this.f32910b == 4) {
            g();
        }
    }

    @TargetApi(19)
    public long b() {
        a aVar = this.f32909a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    @TargetApi(19)
    public long c() {
        a aVar = this.f32909a;
        return aVar != null ? aVar.b() : C.TIME_UNSET;
    }

    public boolean d() {
        return this.f32910b == 2;
    }

    @TargetApi(19)
    public boolean e(long j11) {
        a aVar = this.f32909a;
        if (aVar == null || j11 - this.f32913e < this.f32912d) {
            return false;
        }
        this.f32913e = j11;
        boolean zC = aVar.c();
        int i11 = this.f32910b;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (zC) {
                        g();
                    }
                } else if (!zC) {
                    g();
                }
            } else if (!zC) {
                g();
            } else if (this.f32909a.a() > this.f32914f) {
                h(2);
            }
        } else if (zC) {
            if (this.f32909a.b() < this.f32911c) {
                return false;
            }
            this.f32914f = this.f32909a.a();
            h(1);
        } else if (j11 - this.f32911c > 500000) {
            h(3);
        }
        return zC;
    }

    public void f() {
        h(4);
    }

    public void g() {
        if (this.f32909a != null) {
            h(0);
        }
    }

    public final void h(int i11) {
        this.f32910b = i11;
        if (i11 == 0) {
            this.f32913e = 0L;
            this.f32914f = -1L;
            this.f32911c = System.nanoTime() / 1000;
            this.f32912d = 10000L;
            return;
        }
        if (i11 == 1) {
            this.f32912d = 10000L;
            return;
        }
        if (i11 == 2 || i11 == 3) {
            this.f32912d = 10000000L;
        } else {
            if (i11 != 4) {
                throw new IllegalStateException();
            }
            this.f32912d = 500000L;
        }
    }
}
