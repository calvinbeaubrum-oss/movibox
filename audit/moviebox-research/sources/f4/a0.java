package f4;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final a f64540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f64541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f64542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f64543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f64544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f64545f;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(19)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioTrack f64546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioTimestamp f64547b = new AudioTimestamp();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f64548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f64549d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f64550e;

        public a(AudioTrack audioTrack) {
            this.f64546a = audioTrack;
        }

        public long a() {
            return this.f64550e;
        }

        public long b() {
            return this.f64547b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f64546a.getTimestamp(this.f64547b);
            if (timestamp) {
                long j11 = this.f64547b.framePosition;
                if (this.f64549d > j11) {
                    this.f64548c++;
                }
                this.f64549d = j11;
                this.f64550e = j11 + (this.f64548c << 32);
            }
            return timestamp;
        }
    }

    public a0(AudioTrack audioTrack) {
        if (z3.u0.f81838a >= 19) {
            this.f64540a = new a(audioTrack);
            g();
        } else {
            this.f64540a = null;
            h(3);
        }
    }

    public void a() {
        if (this.f64541b == 4) {
            g();
        }
    }

    @TargetApi(19)
    public long b() {
        a aVar = this.f64540a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    @TargetApi(19)
    public long c() {
        a aVar = this.f64540a;
        return aVar != null ? aVar.b() : C.TIME_UNSET;
    }

    public boolean d() {
        return this.f64541b == 2;
    }

    @TargetApi(19)
    public boolean e(long j11) {
        a aVar = this.f64540a;
        if (aVar == null || j11 - this.f64544e < this.f64543d) {
            return false;
        }
        this.f64544e = j11;
        boolean zC = aVar.c();
        int i11 = this.f64541b;
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
            } else if (this.f64540a.a() > this.f64545f) {
                h(2);
            }
        } else if (zC) {
            if (this.f64540a.b() < this.f64542c) {
                return false;
            }
            this.f64545f = this.f64540a.a();
            h(1);
        } else if (j11 - this.f64542c > 500000) {
            h(3);
        }
        return zC;
    }

    public void f() {
        h(4);
    }

    public void g() {
        if (this.f64540a != null) {
            h(0);
        }
    }

    public final void h(int i11) {
        this.f64541b = i11;
        if (i11 == 0) {
            this.f64544e = 0L;
            this.f64545f = -1L;
            this.f64542c = System.nanoTime() / 1000;
            this.f64543d = 10000L;
            return;
        }
        if (i11 == 1) {
            this.f64543d = 10000L;
            return;
        }
        if (i11 == 2 || i11 == 3) {
            this.f64543d = 10000000L;
        } else {
            if (i11 != 4) {
                throw new IllegalStateException();
            }
            this.f64543d = 500000L;
        }
    }
}
