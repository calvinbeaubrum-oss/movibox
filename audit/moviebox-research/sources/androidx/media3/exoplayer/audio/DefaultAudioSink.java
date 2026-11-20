package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.f0;
import androidx.media3.common.g0;
import androidx.media3.common.y;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.u;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.g1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import e4.x3;
import f4.b0;
import f4.e0;
import f4.h1;
import f4.n1;
import f4.p1;
import f4.q1;
import f4.r1;
import f4.y0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import u4.j0;
import u4.k0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class DefaultAudioSink implements AudioSink {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static boolean f9839m0 = false;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final Object f9840n0 = new Object();

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @Nullable
    public static ExecutorService f9841o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static int f9842p0;

    @Nullable
    public j A;
    public androidx.media3.common.d B;

    @Nullable
    public i C;
    public i D;
    public g0 E;
    public boolean F;

    @Nullable
    public ByteBuffer G;
    public int H;
    public long I;
    public long J;
    public long K;
    public long L;
    public int M;
    public boolean N;
    public boolean O;
    public long P;
    public float Q;

    @Nullable
    public ByteBuffer R;
    public int S;

    @Nullable
    public ByteBuffer T;
    public byte[] U;
    public int V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f9843a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f9844a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x3.a f9845b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public androidx.media3.common.g f9846b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9847c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @Nullable
    public f4.k f9848c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f9849d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f9850d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r1 f9851e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f9852e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImmutableList<AudioProcessor> f9853f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f9854f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImmutableList<AudioProcessor> f9855g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f9856g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z3.g f9857h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f9858h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.media3.exoplayer.audio.d f9859i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @Nullable
    public Looper f9860i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayDeque<i> f9861j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public long f9862j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f9863k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public long f9864k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f9865l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public Handler f9866l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public m f9867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k<AudioSink.InitializationException> f9868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final k<AudioSink.WriteException> f9869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f9870p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f9871q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public final u.a f9872r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public x3 f9873s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public AudioSink.b f9874t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public g f9875u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public g f9876v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public androidx.media3.common.audio.a f9877w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public AudioTrack f9878x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f4.e f9879y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public androidx.media3.exoplayer.audio.a f9880z;

    /* JADX INFO: compiled from: source.java */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static final class b {
        public static void a(AudioTrack audioTrack, @Nullable f4.k kVar) {
            audioTrack.setPreferredDevice(kVar == null ? null : kVar.f64562a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class c {
        public static void a(AudioTrack audioTrack, x3 x3Var) {
            LogSessionId logSessionIdA = x3Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            audioTrack.setLogSessionId(logSessionIdA);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        androidx.media3.exoplayer.audio.b a(y yVar, androidx.media3.common.d dVar);
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f9881a = new androidx.media3.exoplayer.audio.g.a().h();

        int a(int i11, int i12, int i13, int i14, int i15, int i16, double d11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Context f9882a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public x3.a f9884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f9885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f9886e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f9887f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public d f9889h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public u.a f9890i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f4.e f9883b = f4.e.f64553c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public e f9888g = e.f9881a;

        public f(Context context) {
            this.f9882a = context;
        }

        public DefaultAudioSink i() {
            z3.a.g(!this.f9887f);
            this.f9887f = true;
            if (this.f9884c == null) {
                this.f9884c = new h(new AudioProcessor[0]);
            }
            if (this.f9889h == null) {
                this.f9889h = new androidx.media3.exoplayer.audio.f(this.f9882a);
            }
            return new DefaultAudioSink(this);
        }

        public f j(x3.a aVar) {
            z3.a.e(aVar);
            this.f9884c = aVar;
            return this;
        }

        public f k(AudioProcessor[] audioProcessorArr) {
            z3.a.e(audioProcessorArr);
            return j(new h(audioProcessorArr));
        }

        public f l(boolean z11) {
            this.f9886e = z11;
            return this;
        }

        public f m(boolean z11) {
            this.f9885d = z11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f9891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f9892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f9894d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f9895e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f9896f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f9897g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f9898h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final androidx.media3.common.audio.a f9899i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f9900j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f9901k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f9902l;

        public g(y yVar, int i11, int i12, int i13, int i14, int i15, int i16, int i17, androidx.media3.common.audio.a aVar, boolean z11, boolean z12, boolean z13) {
            this.f9891a = yVar;
            this.f9892b = i11;
            this.f9893c = i12;
            this.f9894d = i13;
            this.f9895e = i14;
            this.f9896f = i15;
            this.f9897g = i16;
            this.f9898h = i17;
            this.f9899i = aVar;
            this.f9900j = z11;
            this.f9901k = z12;
            this.f9902l = z13;
        }

        @RequiresApi(21)
        public static AudioAttributes j(androidx.media3.common.d dVar, boolean z11) {
            return z11 ? k() : dVar.a().f9136a;
        }

        @RequiresApi(21)
        public static AudioAttributes k() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(androidx.media3.common.d dVar, int i11) throws AudioSink.InitializationException {
            try {
                AudioTrack audioTrackE = e(dVar, i11);
                int state = audioTrackE.getState();
                if (state == 1) {
                    return audioTrackE;
                }
                try {
                    audioTrackE.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.f9895e, this.f9896f, this.f9898h, this.f9891a, m(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e11) {
                throw new AudioSink.InitializationException(0, this.f9895e, this.f9896f, this.f9898h, this.f9891a, m(), e11);
            }
        }

        public AudioSink.a b() {
            return new AudioSink.a(this.f9897g, this.f9895e, this.f9896f, this.f9902l, this.f9893c == 1, this.f9898h);
        }

        public boolean c(g gVar) {
            return gVar.f9893c == this.f9893c && gVar.f9897g == this.f9897g && gVar.f9895e == this.f9895e && gVar.f9896f == this.f9896f && gVar.f9894d == this.f9894d && gVar.f9900j == this.f9900j && gVar.f9901k == this.f9901k;
        }

        public g d(int i11) {
            return new g(this.f9891a, this.f9892b, this.f9893c, this.f9894d, this.f9895e, this.f9896f, this.f9897g, i11, this.f9899i, this.f9900j, this.f9901k, this.f9902l);
        }

        public final AudioTrack e(androidx.media3.common.d dVar, int i11) {
            int i12 = u0.f81838a;
            if (i12 >= 29) {
                return g(dVar, i11);
            }
            return i12 >= 21 ? f(dVar, i11) : h(dVar, i11);
        }

        @RequiresApi(21)
        public final AudioTrack f(androidx.media3.common.d dVar, int i11) {
            return new AudioTrack(j(dVar, this.f9902l), u0.L(this.f9895e, this.f9896f, this.f9897g), this.f9898h, 1, i11);
        }

        @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
        public final AudioTrack g(androidx.media3.common.d dVar, int i11) {
            return y0.a().setAudioAttributes(j(dVar, this.f9902l)).setAudioFormat(u0.L(this.f9895e, this.f9896f, this.f9897g)).setTransferMode(1).setBufferSizeInBytes(this.f9898h).setSessionId(i11).setOffloadedPlayback(this.f9893c == 1).build();
        }

        public final AudioTrack h(androidx.media3.common.d dVar, int i11) {
            int iP0 = u0.p0(dVar.f9132c);
            return i11 == 0 ? new AudioTrack(iP0, this.f9895e, this.f9896f, this.f9897g, this.f9898h, 1) : new AudioTrack(iP0, this.f9895e, this.f9896f, this.f9897g, this.f9898h, 1, i11);
        }

        public long i(long j11) {
            return u0.e1(j11, this.f9895e);
        }

        public long l(long j11) {
            return u0.e1(j11, this.f9891a.A);
        }

        public boolean m() {
            return this.f9893c == 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h implements x3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioProcessor[] f9903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p1 f9904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.media3.common.audio.c f9905c;

        public h(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new p1(), new androidx.media3.common.audio.c());
        }

        public h(AudioProcessor[] audioProcessorArr, p1 p1Var, androidx.media3.common.audio.c cVar) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f9903a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f9904b = p1Var;
            this.f9905c = cVar;
            audioProcessorArr2[audioProcessorArr.length] = p1Var;
            audioProcessorArr2[audioProcessorArr.length + 1] = cVar;
        }

        @Override // x3.a
        public boolean a(boolean z11) {
            this.f9904b.y(z11);
            return z11;
        }

        @Override // x3.a
        public g0 b(g0 g0Var) {
            this.f9905c.d(g0Var.f9222a);
            this.f9905c.c(g0Var.f9223b);
            return g0Var;
        }

        @Override // x3.a
        public AudioProcessor[] getAudioProcessors() {
            return this.f9903a;
        }

        @Override // x3.a
        public long getMediaDuration(long j11) {
            return this.f9905c.b(j11);
        }

        @Override // x3.a
        public long getSkippedOutputFrameCount() {
            return this.f9904b.p();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g0 f9906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f9907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f9908c;

        public i(g0 g0Var, long j11, long j12) {
            this.f9906a = g0Var;
            this.f9907b = j11;
            this.f9908c = j12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioTrack f9909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.media3.exoplayer.audio.a f9910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public AudioRouting.OnRoutingChangedListener f9911c = new AudioRouting.OnRoutingChangedListener() { // from class: f4.k1
            @Override // android.media.AudioRouting.OnRoutingChangedListener
            public final void onRoutingChanged(AudioRouting audioRouting) {
                this.f64563a.b(audioRouting);
            }
        };

        public j(AudioTrack audioTrack, androidx.media3.exoplayer.audio.a aVar) {
            this.f9909a = audioTrack;
            this.f9910b = aVar;
            audioTrack.addOnRoutingChangedListener(this.f9911c, new Handler(Looper.myLooper()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AudioRouting audioRouting) {
            if (this.f9911c == null || audioRouting.getRoutedDevice() == null) {
                return;
            }
            this.f9910b.i(audioRouting.getRoutedDevice());
        }

        public void c() {
            this.f9909a.removeOnRoutingChangedListener(h1.a(z3.a.e(this.f9911c)));
            this.f9911c = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k<T extends Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f9912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public T f9913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9914c;

        public k(long j11) {
            this.f9912a = j11;
        }

        public void a() {
            this.f9913b = null;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: T extends java.lang.Exception */
        public void b(T t11) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f9913b == null) {
                this.f9913b = t11;
                this.f9914c = this.f9912a + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.f9914c) {
                T t12 = this.f9913b;
                if (t12 != t11) {
                    t12.addSuppressed(t11);
                }
                T t13 = this.f9913b;
                a();
                throw t13;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class l implements androidx.media3.exoplayer.audio.d.a {
        public l() {
        }

        @Override // androidx.media3.exoplayer.audio.d.a
        public void b(long j11) {
            if (DefaultAudioSink.this.f9874t != null) {
                DefaultAudioSink.this.f9874t.b(j11);
            }
        }

        @Override // androidx.media3.exoplayer.audio.d.a
        public void onInvalidLatency(long j11) {
            o.h("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j11);
        }

        @Override // androidx.media3.exoplayer.audio.d.a
        public void onPositionFramesMismatch(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j11 + ", " + j12 + ", " + j13 + ", " + j14 + ", " + DefaultAudioSink.this.I() + ", " + DefaultAudioSink.this.J();
            if (DefaultAudioSink.f9839m0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            o.h("DefaultAudioSink", str);
        }

        @Override // androidx.media3.exoplayer.audio.d.a
        public void onSystemTimeUsMismatch(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j11 + ", " + j12 + ", " + j13 + ", " + j14 + ", " + DefaultAudioSink.this.I() + ", " + DefaultAudioSink.this.J();
            if (DefaultAudioSink.f9839m0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            o.h("DefaultAudioSink", str);
        }

        @Override // androidx.media3.exoplayer.audio.d.a
        public void onUnderrun(int i11, long j11) {
            if (DefaultAudioSink.this.f9874t != null) {
                DefaultAudioSink.this.f9874t.onUnderrun(i11, j11, SystemClock.elapsedRealtime() - DefaultAudioSink.this.f9854f0);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f9916a = new Handler(Looper.myLooper());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioTrack.StreamEventCallback f9917b;

        /* JADX INFO: compiled from: source.java */
        public class a extends AudioTrack.StreamEventCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DefaultAudioSink f9919a;

            public a(DefaultAudioSink defaultAudioSink) {
                this.f9919a = defaultAudioSink;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i11) {
                if (audioTrack.equals(DefaultAudioSink.this.f9878x) && DefaultAudioSink.this.f9874t != null && DefaultAudioSink.this.Y) {
                    DefaultAudioSink.this.f9874t.d();
                }
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(AudioTrack audioTrack) {
                if (audioTrack.equals(DefaultAudioSink.this.f9878x) && DefaultAudioSink.this.f9874t != null && DefaultAudioSink.this.Y) {
                    DefaultAudioSink.this.f9874t.d();
                }
            }
        }

        public m() {
            this.f9917b = new a(DefaultAudioSink.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f9916a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new n1(handler), this.f9917b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f9917b);
            this.f9916a.removeCallbacksAndMessages(null);
        }
    }

    public DefaultAudioSink(f fVar) {
        Context context = fVar.f9882a;
        this.f9843a = context;
        androidx.media3.common.d dVar = androidx.media3.common.d.f9123g;
        this.B = dVar;
        this.f9879y = context != null ? f4.e.e(context, dVar, null) : fVar.f9883b;
        this.f9845b = fVar.f9884c;
        int i11 = u0.f81838a;
        this.f9847c = i11 >= 21 && fVar.f9885d;
        this.f9863k = i11 >= 23 && fVar.f9886e;
        this.f9865l = 0;
        this.f9870p = fVar.f9888g;
        this.f9871q = (d) z3.a.e(fVar.f9889h);
        z3.g gVar = new z3.g(z3.d.f81767a);
        this.f9857h = gVar;
        gVar.f();
        this.f9859i = new androidx.media3.exoplayer.audio.d(new l());
        b0 b0Var = new b0();
        this.f9849d = b0Var;
        r1 r1Var = new r1();
        this.f9851e = r1Var;
        this.f9853f = ImmutableList.of((r1) new androidx.media3.common.audio.d(), (r1) b0Var, r1Var);
        this.f9855g = ImmutableList.of(new q1());
        this.Q = 1.0f;
        this.f9844a0 = 0;
        this.f9846b0 = new androidx.media3.common.g(0, 0.0f);
        g0 g0Var = g0.f9218d;
        this.D = new i(g0Var, 0L, 0L);
        this.E = g0Var;
        this.F = false;
        this.f9861j = new ArrayDeque<>();
        this.f9868n = new k<>(100L);
        this.f9869o = new k<>(100L);
        this.f9872r = fVar.f9890i;
    }

    public static int G(int i11, int i12, int i13) {
        int minBufferSize = AudioTrack.getMinBufferSize(i11, i12, i13);
        z3.a.g(minBufferSize != -2);
        return minBufferSize;
    }

    public static int H(int i11, ByteBuffer byteBuffer) {
        switch (i11) {
            case 5:
            case 6:
            case 18:
                return u4.b.e(byteBuffer);
            case 7:
            case 8:
                return u4.o.f(byteBuffer);
            case 9:
                int iM = j0.m(u0.O(byteBuffer, byteBuffer.position()));
                if (iM != -1) {
                    return iM;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            case 19:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i11);
            case 14:
                int iB = u4.b.b(byteBuffer);
                if (iB == -1) {
                    return 0;
                }
                return u4.b.i(byteBuffer, iB) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return u4.c.c(byteBuffer);
            case 20:
                return k0.h(byteBuffer);
        }
    }

    public static boolean M(int i11) {
        return (u0.f81838a >= 24 && i11 == -6) || i11 == -32;
    }

    public static boolean O(AudioTrack audioTrack) {
        return u0.f81838a >= 29 && audioTrack.isOffloadedPlayback();
    }

    public static /* synthetic */ void Q(AudioTrack audioTrack, final AudioSink.b bVar, Handler handler, final AudioSink.a aVar, z3.g gVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (bVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: f4.u0
                    @Override // java.lang.Runnable
                    public final void run() {
                        bVar.l(aVar);
                    }
                });
            }
            gVar.f();
            synchronized (f9840n0) {
                try {
                    int i11 = f9842p0 - 1;
                    f9842p0 = i11;
                    if (i11 == 0) {
                        f9841o0.shutdown();
                        f9841o0 = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            if (bVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: f4.u0
                    @Override // java.lang.Runnable
                    public final void run() {
                        bVar.l(aVar);
                    }
                });
            }
            gVar.f();
            synchronized (f9840n0) {
                try {
                    int i12 = f9842p0 - 1;
                    f9842p0 = i12;
                    if (i12 == 0) {
                        f9841o0.shutdown();
                        f9841o0 = null;
                    }
                    throw th3;
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }
    }

    public static void Y(final AudioTrack audioTrack, final z3.g gVar, @Nullable final AudioSink.b bVar, final AudioSink.a aVar) {
        gVar.d();
        final Handler handler = new Handler(Looper.myLooper());
        synchronized (f9840n0) {
            try {
                if (f9841o0 == null) {
                    f9841o0 = u0.T0("ExoPlayer:AudioTrackReleaseThread");
                }
                f9842p0++;
                f9841o0.execute(new Runnable() { // from class: f4.s0
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultAudioSink.Q(audioTrack, bVar, handler, aVar, gVar);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @RequiresApi(21)
    public static void d0(AudioTrack audioTrack, float f11) {
        audioTrack.setVolume(f11);
    }

    public static void e0(AudioTrack audioTrack, float f11) {
        audioTrack.setStereoVolume(f11, f11);
    }

    @RequiresApi(21)
    public static int k0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11) {
        return audioTrack.write(byteBuffer, i11, 1);
    }

    public final void A(long j11) {
        g0 g0VarB;
        if (i0()) {
            g0VarB = g0.f9218d;
        } else {
            g0VarB = g0() ? this.f9845b.b(this.E) : g0.f9218d;
            this.E = g0VarB;
        }
        g0 g0Var = g0VarB;
        this.F = g0() ? this.f9845b.a(this.F) : false;
        this.f9861j.add(new i(g0Var, Math.max(0L, j11), this.f9876v.i(J())));
        f0();
        AudioSink.b bVar = this.f9874t;
        if (bVar != null) {
            bVar.onSkipSilenceEnabledChanged(this.F);
        }
    }

    public final long B(long j11) {
        while (!this.f9861j.isEmpty() && j11 >= this.f9861j.getFirst().f9908c) {
            this.D = this.f9861j.remove();
        }
        i iVar = this.D;
        long j12 = j11 - iVar.f9908c;
        if (iVar.f9906a.equals(g0.f9218d)) {
            return this.D.f9907b + j12;
        }
        if (this.f9861j.isEmpty()) {
            return this.D.f9907b + this.f9845b.getMediaDuration(j12);
        }
        i first = this.f9861j.getFirst();
        return first.f9907b - u0.h0(first.f9908c - j11, this.D.f9906a.f9222a);
    }

    public final long C(long j11) {
        long skippedOutputFrameCount = this.f9845b.getSkippedOutputFrameCount();
        long jI = j11 + this.f9876v.i(skippedOutputFrameCount);
        long j12 = this.f9862j0;
        if (skippedOutputFrameCount > j12) {
            long jI2 = this.f9876v.i(skippedOutputFrameCount - j12);
            this.f9862j0 = skippedOutputFrameCount;
            K(jI2);
        }
        return jI;
    }

    public final AudioTrack D(g gVar) throws AudioSink.InitializationException {
        try {
            AudioTrack audioTrackA = gVar.a(this.B, this.f9844a0);
            u.a aVar = this.f9872r;
            if (aVar != null) {
                aVar.y(O(audioTrackA));
            }
            return audioTrackA;
        } catch (AudioSink.InitializationException e11) {
            AudioSink.b bVar = this.f9874t;
            if (bVar != null) {
                bVar.a(e11);
            }
            throw e11;
        }
    }

    public final AudioTrack E() throws AudioSink.InitializationException {
        try {
            return D((g) z3.a.e(this.f9876v));
        } catch (AudioSink.InitializationException e11) {
            g gVar = this.f9876v;
            if (gVar.f9898h > 1000000) {
                g gVarD = gVar.d(1000000);
                try {
                    AudioTrack audioTrackD = D(gVarD);
                    this.f9876v = gVarD;
                    return audioTrackD;
                } catch (AudioSink.InitializationException e12) {
                    e11.addSuppressed(e12);
                    R();
                    throw e11;
                }
            }
            R();
            throw e11;
        }
    }

    public final boolean F() throws Exception {
        if (!this.f9877w.f()) {
            ByteBuffer byteBuffer = this.T;
            if (byteBuffer == null) {
                return true;
            }
            j0(byteBuffer, Long.MIN_VALUE);
            return this.T == null;
        }
        this.f9877w.h();
        W(Long.MIN_VALUE);
        if (!this.f9877w.e()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.T;
        return byteBuffer2 == null || !byteBuffer2.hasRemaining();
    }

    public final long I() {
        g gVar = this.f9876v;
        return gVar.f9893c == 0 ? this.I / ((long) gVar.f9892b) : this.J;
    }

    public final long J() {
        g gVar = this.f9876v;
        return gVar.f9893c == 0 ? u0.l(this.K, gVar.f9894d) : this.L;
    }

    public final void K(long j11) {
        this.f9864k0 += j11;
        if (this.f9866l0 == null) {
            this.f9866l0 = new Handler(Looper.myLooper());
        }
        this.f9866l0.removeCallbacksAndMessages(null);
        this.f9866l0.postDelayed(new Runnable() { // from class: f4.r0
            @Override // java.lang.Runnable
            public final void run() {
                this.f64598a.S();
            }
        }, 100L);
    }

    public final boolean L() throws AudioSink.InitializationException {
        androidx.media3.exoplayer.audio.a aVar;
        x3 x3Var;
        if (!this.f9857h.e()) {
            return false;
        }
        AudioTrack audioTrackE = E();
        this.f9878x = audioTrackE;
        if (O(audioTrackE)) {
            X(this.f9878x);
            g gVar = this.f9876v;
            if (gVar.f9901k) {
                AudioTrack audioTrack = this.f9878x;
                y yVar = gVar.f9891a;
                audioTrack.setOffloadDelayPadding(yVar.C, yVar.D);
            }
        }
        int i11 = u0.f81838a;
        if (i11 >= 31 && (x3Var = this.f9873s) != null) {
            c.a(this.f9878x, x3Var);
        }
        this.f9844a0 = this.f9878x.getAudioSessionId();
        androidx.media3.exoplayer.audio.d dVar = this.f9859i;
        AudioTrack audioTrack2 = this.f9878x;
        g gVar2 = this.f9876v;
        dVar.s(audioTrack2, gVar2.f9893c == 2, gVar2.f9897g, gVar2.f9894d, gVar2.f9898h);
        c0();
        int i12 = this.f9846b0.f9216a;
        if (i12 != 0) {
            this.f9878x.attachAuxEffect(i12);
            this.f9878x.setAuxEffectSendLevel(this.f9846b0.f9217b);
        }
        f4.k kVar = this.f9848c0;
        if (kVar != null && i11 >= 23) {
            b.a(this.f9878x, kVar);
            androidx.media3.exoplayer.audio.a aVar2 = this.f9880z;
            if (aVar2 != null) {
                aVar2.i(this.f9848c0.f64562a);
            }
        }
        if (i11 >= 24 && (aVar = this.f9880z) != null) {
            this.A = new j(this.f9878x, aVar);
        }
        this.O = true;
        AudioSink.b bVar = this.f9874t;
        if (bVar != null) {
            bVar.k(this.f9876v.b());
        }
        return true;
    }

    public final boolean N() {
        return this.f9878x != null;
    }

    public final void R() {
        if (this.f9876v.m()) {
            this.f9856g0 = true;
        }
    }

    public final void S() {
        if (this.f9864k0 >= 300000) {
            this.f9874t.e();
            this.f9864k0 = 0L;
        }
    }

    public final void T() {
        if (this.f9880z != null || this.f9843a == null) {
            return;
        }
        this.f9860i0 = Looper.myLooper();
        androidx.media3.exoplayer.audio.a aVar = new androidx.media3.exoplayer.audio.a(this.f9843a, new androidx.media3.exoplayer.audio.a.f() { // from class: f4.t0
            @Override // androidx.media3.exoplayer.audio.a.f
            public final void a(e eVar) {
                this.f64617a.U(eVar);
            }
        }, this.B, this.f9848c0);
        this.f9880z = aVar;
        this.f9879y = aVar.g();
    }

    public void U(f4.e eVar) {
        z3.a.g(this.f9860i0 == Looper.myLooper());
        if (eVar.equals(this.f9879y)) {
            return;
        }
        this.f9879y = eVar;
        AudioSink.b bVar = this.f9874t;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void V() {
        if (this.X) {
            return;
        }
        this.X = true;
        this.f9859i.g(J());
        this.f9878x.stop();
        this.H = 0;
    }

    public final void W(long j11) throws Exception {
        ByteBuffer byteBufferD;
        if (!this.f9877w.f()) {
            ByteBuffer byteBuffer = this.R;
            if (byteBuffer == null) {
                byteBuffer = AudioProcessor.f8908a;
            }
            j0(byteBuffer, j11);
            return;
        }
        while (!this.f9877w.e()) {
            do {
                byteBufferD = this.f9877w.d();
                if (byteBufferD.hasRemaining()) {
                    j0(byteBufferD, j11);
                } else {
                    ByteBuffer byteBuffer2 = this.R;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.f9877w.i(this.R);
                    }
                }
            } while (!byteBufferD.hasRemaining());
            return;
        }
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final void X(AudioTrack audioTrack) {
        if (this.f9867m == null) {
            this.f9867m = new m();
        }
        this.f9867m.a(audioTrack);
    }

    public final void Z() {
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.L = 0L;
        this.f9858h0 = false;
        this.M = 0;
        this.D = new i(this.E, 0L, 0L);
        this.P = 0L;
        this.C = null;
        this.f9861j.clear();
        this.R = null;
        this.S = 0;
        this.T = null;
        this.X = false;
        this.W = false;
        this.G = null;
        this.H = 0;
        this.f9851e.i();
        f0();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean a(y yVar) {
        return p(yVar) != 0;
    }

    public final void a0(g0 g0Var) {
        i iVar = new i(g0Var, C.TIME_UNSET, C.TIME_UNSET);
        if (N()) {
            this.C = iVar;
        } else {
            this.D = iVar;
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void b(g0 g0Var) {
        this.E = new g0(u0.o(g0Var.f9222a, 0.1f, 8.0f), u0.o(g0Var.f9223b, 0.1f, 8.0f));
        if (i0()) {
            b0();
        } else {
            a0(g0Var);
        }
    }

    @RequiresApi(23)
    public final void b0() {
        if (N()) {
            try {
                this.f9878x.setPlaybackParams(e0.a().allowDefaults().setSpeed(this.E.f9222a).setPitch(this.E.f9223b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e11) {
                o.i("DefaultAudioSink", "Failed to set playback params", e11);
            }
            g0 g0Var = new g0(this.f9878x.getPlaybackParams().getSpeed(), this.f9878x.getPlaybackParams().getPitch());
            this.E = g0Var;
            this.f9859i.t(g0Var.f9222a);
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean c(ByteBuffer byteBuffer, long j11, int i11) throws Exception {
        ByteBuffer byteBuffer2 = this.R;
        z3.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f9875u != null) {
            if (!F()) {
                return false;
            }
            if (this.f9875u.c(this.f9876v)) {
                this.f9876v = this.f9875u;
                this.f9875u = null;
                AudioTrack audioTrack = this.f9878x;
                if (audioTrack != null && O(audioTrack) && this.f9876v.f9901k) {
                    if (this.f9878x.getPlayState() == 3) {
                        this.f9878x.setOffloadEndOfStream();
                        this.f9859i.a();
                    }
                    AudioTrack audioTrack2 = this.f9878x;
                    y yVar = this.f9876v.f9891a;
                    audioTrack2.setOffloadDelayPadding(yVar.C, yVar.D);
                    this.f9858h0 = true;
                }
            } else {
                V();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            }
            A(j11);
        }
        if (!N()) {
            try {
                if (!L()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e11) {
                if (e11.isRecoverable) {
                    throw e11;
                }
                this.f9868n.b(e11);
                return false;
            }
        }
        this.f9868n.a();
        if (this.O) {
            this.P = Math.max(0L, j11);
            this.N = false;
            this.O = false;
            if (i0()) {
                b0();
            }
            A(j11);
            if (this.Y) {
                play();
            }
        }
        if (!this.f9859i.k(J())) {
            return false;
        }
        if (this.R == null) {
            z3.a.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            g gVar = this.f9876v;
            if (gVar.f9893c != 0 && this.M == 0) {
                int iH = H(gVar.f9897g, byteBuffer);
                this.M = iH;
                if (iH == 0) {
                    return true;
                }
            }
            if (this.C != null) {
                if (!F()) {
                    return false;
                }
                A(j11);
                this.C = null;
            }
            long jL = this.P + this.f9876v.l(I() - this.f9851e.h());
            if (!this.N && Math.abs(jL - j11) > 200000) {
                AudioSink.b bVar = this.f9874t;
                if (bVar != null) {
                    bVar.a(new AudioSink.UnexpectedDiscontinuityException(j11, jL));
                }
                this.N = true;
            }
            if (this.N) {
                if (!F()) {
                    return false;
                }
                long j12 = j11 - jL;
                this.P += j12;
                this.N = false;
                A(j11);
                AudioSink.b bVar2 = this.f9874t;
                if (bVar2 != null && j12 != 0) {
                    bVar2.onPositionDiscontinuity();
                }
            }
            if (this.f9876v.f9893c == 0) {
                this.I += (long) byteBuffer.remaining();
            } else {
                this.J += ((long) this.M) * ((long) i11);
            }
            this.R = byteBuffer;
            this.S = i11;
        }
        W(j11);
        if (!this.R.hasRemaining()) {
            this.R = null;
            this.S = 0;
            return true;
        }
        if (!this.f9859i.j(J())) {
            return false;
        }
        o.h("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    public final void c0() {
        if (N()) {
            if (u0.f81838a >= 21) {
                d0(this.f9878x, this.Q);
            } else {
                e0(this.f9878x, this.Q);
            }
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void d(z3.d dVar) {
        this.f9859i.u(dVar);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void disableTunneling() {
        if (this.f9850d0) {
            this.f9850d0 = false;
            flush();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void e() {
        z3.a.g(u0.f81838a >= 21);
        z3.a.g(this.Z);
        if (this.f9850d0) {
            return;
        }
        this.f9850d0 = true;
        flush();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void f(boolean z11) {
        this.F = z11;
        a0(i0() ? g0.f9218d : this.E);
    }

    public final void f0() {
        androidx.media3.common.audio.a aVar = this.f9876v.f9899i;
        this.f9877w = aVar;
        aVar.b();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void flush() {
        j jVar;
        if (N()) {
            Z();
            if (this.f9859i.i()) {
                this.f9878x.pause();
            }
            if (O(this.f9878x)) {
                ((m) z3.a.e(this.f9867m)).b(this.f9878x);
            }
            int i11 = u0.f81838a;
            if (i11 < 21 && !this.Z) {
                this.f9844a0 = 0;
            }
            AudioSink.a aVarB = this.f9876v.b();
            g gVar = this.f9875u;
            if (gVar != null) {
                this.f9876v = gVar;
                this.f9875u = null;
            }
            this.f9859i.q();
            if (i11 >= 24 && (jVar = this.A) != null) {
                jVar.c();
                this.A = null;
            }
            Y(this.f9878x, this.f9857h, this.f9874t, aVarB);
            this.f9878x = null;
        }
        this.f9869o.a();
        this.f9868n.a();
        this.f9862j0 = 0L;
        this.f9864k0 = 0L;
        Handler handler = this.f9866l0;
        if (handler != null) {
            ((Handler) z3.a.e(handler)).removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void g(androidx.media3.common.d dVar) {
        if (this.B.equals(dVar)) {
            return;
        }
        this.B = dVar;
        if (this.f9850d0) {
            return;
        }
        androidx.media3.exoplayer.audio.a aVar = this.f9880z;
        if (aVar != null) {
            aVar.h(dVar);
        }
        flush();
    }

    public final boolean g0() {
        if (!this.f9850d0) {
            g gVar = this.f9876v;
            if (gVar.f9893c == 0 && !h0(gVar.f9891a.B)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public long getCurrentPositionUs(boolean z11) {
        if (!N() || this.O) {
            return Long.MIN_VALUE;
        }
        return C(B(Math.min(this.f9859i.d(z11), this.f9876v.i(J()))));
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public g0 getPlaybackParameters() {
        return this.E;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public androidx.media3.exoplayer.audio.b h(y yVar) {
        return this.f9856g0 ? androidx.media3.exoplayer.audio.b.f9936d : this.f9871q.a(yVar, this.B);
    }

    public final boolean h0(int i11) {
        return this.f9847c && u0.H0(i11);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void handleDiscontinuity() {
        this.N = true;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean hasPendingData() {
        return N() && this.f9859i.h(J());
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    @RequiresApi(23)
    public void i(@Nullable AudioDeviceInfo audioDeviceInfo) {
        this.f9848c0 = audioDeviceInfo == null ? null : new f4.k(audioDeviceInfo);
        androidx.media3.exoplayer.audio.a aVar = this.f9880z;
        if (aVar != null) {
            aVar.i(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.f9878x;
        if (audioTrack != null) {
            b.a(audioTrack, this.f9848c0);
        }
    }

    public final boolean i0() {
        g gVar = this.f9876v;
        return gVar != null && gVar.f9900j && u0.f81838a >= 23;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean isEnded() {
        return !N() || (this.W && !hasPendingData());
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void j(AudioSink.b bVar) {
        this.f9874t = bVar;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00c2  */
    public final void j0(ByteBuffer byteBuffer, long j11) throws Exception {
        int iK0;
        AudioSink.b bVar;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.T;
            boolean z11 = true;
            if (byteBuffer2 != null) {
                z3.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.T = byteBuffer;
                if (u0.f81838a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.U;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.U = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.U, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.V = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (u0.f81838a < 21) {
                int iC = this.f9859i.c(this.K);
                if (iC > 0) {
                    iK0 = this.f9878x.write(this.U, this.V, Math.min(iRemaining2, iC));
                    if (iK0 > 0) {
                        this.V += iK0;
                        byteBuffer.position(byteBuffer.position() + iK0);
                    }
                } else {
                    iK0 = 0;
                }
            } else if (this.f9850d0) {
                z3.a.g(j11 != C.TIME_UNSET);
                if (j11 == Long.MIN_VALUE) {
                    j11 = this.f9852e0;
                } else {
                    this.f9852e0 = j11;
                }
                iK0 = l0(this.f9878x, byteBuffer, iRemaining2, j11);
            } else {
                iK0 = k0(this.f9878x, byteBuffer, iRemaining2);
            }
            this.f9854f0 = SystemClock.elapsedRealtime();
            if (iK0 < 0) {
                if (!M(iK0)) {
                    z11 = false;
                } else if (J() <= 0) {
                    if (O(this.f9878x)) {
                        R();
                    } else {
                        z11 = false;
                    }
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(iK0, this.f9876v.f9891a, z11);
                AudioSink.b bVar2 = this.f9874t;
                if (bVar2 != null) {
                    bVar2.a(writeException);
                }
                if (writeException.isRecoverable) {
                    this.f9879y = f4.e.f64553c;
                    throw writeException;
                }
                this.f9869o.b(writeException);
                return;
            }
            this.f9869o.a();
            if (O(this.f9878x)) {
                if (this.L > 0) {
                    this.f9858h0 = false;
                }
                if (this.Y && (bVar = this.f9874t) != null && iK0 < iRemaining2 && !this.f9858h0) {
                    bVar.c();
                }
            }
            int i11 = this.f9876v.f9893c;
            if (i11 == 0) {
                this.K += (long) iK0;
            }
            if (iK0 == iRemaining2) {
                if (i11 != 0) {
                    z3.a.g(byteBuffer == this.R);
                    this.L += ((long) this.M) * ((long) this.S);
                }
                this.T = null;
            }
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public void k(int i11) {
        z3.a.g(u0.f81838a >= 29);
        this.f9865l = i11;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void l(@Nullable x3 x3Var) {
        this.f9873s = x3Var;
    }

    @RequiresApi(21)
    public final int l0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11, long j11) {
        if (u0.f81838a >= 26) {
            return audioTrack.write(byteBuffer, i11, 1, j11 * 1000);
        }
        if (this.G == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.G = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.G.putInt(1431633921);
        }
        if (this.H == 0) {
            this.G.putInt(4, i11);
            this.G.putLong(8, j11 * 1000);
            this.G.position(0);
            this.H = i11;
        }
        int iRemaining = this.G.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.G, iRemaining, 1);
            if (iWrite < 0) {
                this.H = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iK0 = k0(audioTrack, byteBuffer, i11);
        if (iK0 < 0) {
            this.H = 0;
            return iK0;
        }
        this.H -= iK0;
        return iK0;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void m(y yVar, int i11, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        androidx.media3.common.audio.a aVar;
        int i12;
        int iIntValue;
        int i13;
        boolean z11;
        int iL0;
        int iL1;
        int i14;
        boolean z12;
        int[] iArr2;
        T();
        if (MimeTypes.AUDIO_RAW.equals(yVar.f9501m)) {
            z3.a.a(u0.I0(yVar.B));
            iL0 = u0.l0(yVar.B, yVar.f9514z);
            ImmutableList.a aVar2 = new ImmutableList.a();
            if (h0(yVar.B)) {
                aVar2.k(this.f9855g);
            } else {
                aVar2.k(this.f9853f);
                aVar2.j(this.f9845b.getAudioProcessors());
            }
            androidx.media3.common.audio.a aVar3 = new androidx.media3.common.audio.a(aVar2.m());
            if (aVar3.equals(this.f9877w)) {
                aVar3 = this.f9877w;
            }
            this.f9851e.j(yVar.C, yVar.D);
            if (u0.f81838a < 21 && yVar.f9514z == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i15 = 0; i15 < 6; i15++) {
                    iArr2[i15] = i15;
                }
            } else {
                iArr2 = iArr;
            }
            this.f9849d.h(iArr2);
            try {
                AudioProcessor.a aVarA = aVar3.a(new AudioProcessor.a(yVar));
                int i16 = aVarA.f8912c;
                int i17 = aVarA.f8910a;
                int iM = u0.M(aVarA.f8911b);
                iL1 = u0.l0(i16, aVarA.f8911b);
                aVar = aVar3;
                i12 = i17;
                iIntValue = iM;
                z11 = this.f9863k;
                i14 = 0;
                z12 = false;
                i13 = i16;
            } catch (AudioProcessor.UnhandledAudioFormatException e11) {
                throw new AudioSink.ConfigurationException(e11, yVar);
            }
        } else {
            androidx.media3.common.audio.a aVar4 = new androidx.media3.common.audio.a(ImmutableList.of());
            int i18 = yVar.A;
            androidx.media3.exoplayer.audio.b bVarH = this.f9865l != 0 ? h(yVar) : androidx.media3.exoplayer.audio.b.f9936d;
            if (this.f9865l == 0 || !bVarH.f9937a) {
                Pair<Integer, Integer> pairI = this.f9879y.i(yVar, this.B);
                if (pairI == null) {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + yVar, yVar);
                }
                int iIntValue2 = ((Integer) pairI.first).intValue();
                aVar = aVar4;
                i12 = i18;
                iIntValue = ((Integer) pairI.second).intValue();
                i13 = iIntValue2;
                z11 = this.f9863k;
                iL0 = -1;
                iL1 = -1;
                i14 = 2;
                z12 = false;
            } else {
                int iF = f0.f((String) z3.a.e(yVar.f9501m), yVar.f9498j);
                int iM2 = u0.M(yVar.f9514z);
                aVar = aVar4;
                i12 = i18;
                z12 = bVarH.f9938b;
                i13 = iF;
                iIntValue = iM2;
                iL0 = -1;
                iL1 = -1;
                i14 = 1;
                z11 = true;
            }
        }
        if (i13 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i14 + ") for: " + yVar, yVar);
        }
        if (iIntValue == 0) {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i14 + ") for: " + yVar, yVar);
        }
        int i19 = yVar.f9497i;
        int iA = i11 != 0 ? i11 : this.f9870p.a(G(i12, iIntValue, i13), i13, i14, iL1 != -1 ? iL1 : 1, i12, (MimeTypes.AUDIO_DTS_EXPRESS.equals(yVar.f9501m) && i19 == -1) ? 768000 : i19, z11 ? 8.0d : 1.0d);
        this.f9856g0 = false;
        g gVar = new g(yVar, iL0, i14, iL1, i12, iIntValue, i13, iA, aVar, z11, z12, this.f9850d0);
        if (N()) {
            this.f9875u = gVar;
        } else {
            this.f9876v = gVar;
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public void n(int i11, int i12) {
        g gVar;
        AudioTrack audioTrack = this.f9878x;
        if (audioTrack == null || !O(audioTrack) || (gVar = this.f9876v) == null || !gVar.f9901k) {
            return;
        }
        this.f9878x.setOffloadDelayPadding(i11, i12);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public /* synthetic */ void o(long j11) {
        f4.y.a(this, j11);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public int p(y yVar) {
        T();
        if (!MimeTypes.AUDIO_RAW.equals(yVar.f9501m)) {
            return this.f9879y.k(yVar, this.B) ? 2 : 0;
        }
        if (u0.I0(yVar.B)) {
            int i11 = yVar.B;
            return (i11 == 2 || (this.f9847c && i11 == 4)) ? 2 : 1;
        }
        o.h("DefaultAudioSink", "Invalid PCM encoding: " + yVar.B);
        return 0;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void pause() {
        this.Y = false;
        if (N()) {
            if (this.f9859i.p() || O(this.f9878x)) {
                this.f9878x.pause();
            }
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void play() {
        this.Y = true;
        if (N()) {
            this.f9859i.v();
            this.f9878x.play();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.W && N() && F()) {
            V();
            this.W = true;
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void q(androidx.media3.common.g gVar) {
        if (this.f9846b0.equals(gVar)) {
            return;
        }
        int i11 = gVar.f9216a;
        float f11 = gVar.f9217b;
        AudioTrack audioTrack = this.f9878x;
        if (audioTrack != null) {
            if (this.f9846b0.f9216a != i11) {
                audioTrack.attachAuxEffect(i11);
            }
            if (i11 != 0) {
                this.f9878x.setAuxEffectSendLevel(f11);
            }
        }
        this.f9846b0 = gVar;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void release() {
        androidx.media3.exoplayer.audio.a aVar = this.f9880z;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void reset() {
        flush();
        g1<AudioProcessor> it = this.f9853f.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
        g1<AudioProcessor> it2 = this.f9855g.iterator();
        while (it2.hasNext()) {
            it2.next().reset();
        }
        androidx.media3.common.audio.a aVar = this.f9877w;
        if (aVar != null) {
            aVar.j();
        }
        this.Y = false;
        this.f9856g0 = false;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setAudioSessionId(int i11) {
        if (this.f9844a0 != i11) {
            this.f9844a0 = i11;
            this.Z = i11 != 0;
            flush();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setVolume(float f11) {
        if (this.Q != f11) {
            this.Q = f11;
            c0();
        }
    }
}
