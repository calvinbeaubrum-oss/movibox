package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.m2;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import f4.n1;
import f4.y0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import qg.u1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class DefaultAudioSink implements AudioSink {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static boolean f32707c0 = false;
    public int A;
    public long B;
    public long C;
    public long D;
    public long E;
    public int F;
    public boolean G;
    public boolean H;
    public long I;
    public float J;
    public AudioProcessor[] K;
    public ByteBuffer[] L;

    @Nullable
    public ByteBuffer M;
    public int N;

    @Nullable
    public ByteBuffer O;
    public byte[] P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public int W;
    public u X;
    public boolean Y;
    public long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.audio.f f32708a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f32709a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f32710b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f32711b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f32712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f32713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h0 f32714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AudioProcessor[] f32715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AudioProcessor[] f32716g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.h f32717h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t f32718i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayDeque<g> f32719j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f32720k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f32721l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public j f32722m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h<AudioSink.InitializationException> f32723n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h<AudioSink.WriteException> f32724o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f32725p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public u1 f32726q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public AudioSink.a f32727r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public e f32728s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public e f32729t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public AudioTrack f32730u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.google.android.exoplayer2.audio.e f32731v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public g f32732w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g f32733x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public m2 f32734y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public ByteBuffer f32735z;

    /* JADX INFO: compiled from: source.java */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class a {
        public static void a(AudioTrack audioTrack, u1 u1Var) {
            LogSessionId logSessionIdA = u1Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            audioTrack.setLogSessionId(logSessionIdA);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        boolean a(boolean z11);

        m2 b(m2 m2Var);

        AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long j11);

        long getSkippedOutputFrameCount();
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f32736a = new x.a().g();

        int a(int i11, int i12, int i13, int i14, int i15, double d11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public b f32738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f32739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f32740d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.google.android.exoplayer2.audio.f f32737a = com.google.android.exoplayer2.audio.f.f32832c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f32741e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f32742f = c.f32736a;

        public DefaultAudioSink f() {
            if (this.f32738b == null) {
                this.f32738b = new f(new AudioProcessor[0]);
            }
            return new DefaultAudioSink(this);
        }

        public d g(com.google.android.exoplayer2.audio.f fVar) {
            com.google.android.exoplayer2.util.a.e(fVar);
            this.f32737a = fVar;
            return this;
        }

        public d h(boolean z11) {
            this.f32740d = z11;
            return this;
        }

        public d i(boolean z11) {
            this.f32739c = z11;
            return this;
        }

        public d j(int i11) {
            this.f32741e = i11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m1 f32743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f32745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f32746d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f32747e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f32748f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f32749g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f32750h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final AudioProcessor[] f32751i;

        public e(m1 m1Var, int i11, int i12, int i13, int i14, int i15, int i16, int i17, AudioProcessor[] audioProcessorArr) {
            this.f32743a = m1Var;
            this.f32744b = i11;
            this.f32745c = i12;
            this.f32746d = i13;
            this.f32747e = i14;
            this.f32748f = i15;
            this.f32749g = i16;
            this.f32750h = i17;
            this.f32751i = audioProcessorArr;
        }

        @RequiresApi(21)
        public static AudioAttributes i(com.google.android.exoplayer2.audio.e eVar, boolean z11) {
            return z11 ? j() : eVar.b().f32814a;
        }

        @RequiresApi(21)
        public static AudioAttributes j() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(boolean z11, com.google.android.exoplayer2.audio.e eVar, int i11) throws AudioSink.InitializationException {
            try {
                AudioTrack audioTrackD = d(z11, eVar, i11);
                int state = audioTrackD.getState();
                if (state == 1) {
                    return audioTrackD;
                }
                try {
                    audioTrackD.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.f32747e, this.f32748f, this.f32750h, this.f32743a, l(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e11) {
                throw new AudioSink.InitializationException(0, this.f32747e, this.f32748f, this.f32750h, this.f32743a, l(), e11);
            }
        }

        public boolean b(e eVar) {
            return eVar.f32745c == this.f32745c && eVar.f32749g == this.f32749g && eVar.f32747e == this.f32747e && eVar.f32748f == this.f32748f && eVar.f32746d == this.f32746d;
        }

        public e c(int i11) {
            return new e(this.f32743a, this.f32744b, this.f32745c, this.f32746d, this.f32747e, this.f32748f, this.f32749g, i11, this.f32751i);
        }

        public final AudioTrack d(boolean z11, com.google.android.exoplayer2.audio.e eVar, int i11) {
            int i12 = o0.f35608a;
            if (i12 >= 29) {
                return f(z11, eVar, i11);
            }
            return i12 >= 21 ? e(z11, eVar, i11) : g(eVar, i11);
        }

        @RequiresApi(21)
        public final AudioTrack e(boolean z11, com.google.android.exoplayer2.audio.e eVar, int i11) {
            return new AudioTrack(i(eVar, z11), DefaultAudioSink.B(this.f32747e, this.f32748f, this.f32749g), this.f32750h, 1, i11);
        }

        @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
        public final AudioTrack f(boolean z11, com.google.android.exoplayer2.audio.e eVar, int i11) {
            return y0.a().setAudioAttributes(i(eVar, z11)).setAudioFormat(DefaultAudioSink.B(this.f32747e, this.f32748f, this.f32749g)).setTransferMode(1).setBufferSizeInBytes(this.f32750h).setSessionId(i11).setOffloadedPlayback(this.f32745c == 1).build();
        }

        public final AudioTrack g(com.google.android.exoplayer2.audio.e eVar, int i11) {
            int iG0 = o0.g0(eVar.f32810c);
            return i11 == 0 ? new AudioTrack(iG0, this.f32747e, this.f32748f, this.f32749g, this.f32750h, 1) : new AudioTrack(iG0, this.f32747e, this.f32748f, this.f32749g, this.f32750h, 1, i11);
        }

        public long h(long j11) {
            return (j11 * 1000000) / ((long) this.f32747e);
        }

        public long k(long j11) {
            return (j11 * 1000000) / ((long) this.f32743a.A);
        }

        public boolean l() {
            return this.f32745c == 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioProcessor[] f32752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e0 f32753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g0 f32754c;

        public f(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new e0(), new g0());
        }

        public f(AudioProcessor[] audioProcessorArr, e0 e0Var, g0 g0Var) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f32752a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f32753b = e0Var;
            this.f32754c = g0Var;
            audioProcessorArr2[audioProcessorArr.length] = e0Var;
            audioProcessorArr2[audioProcessorArr.length + 1] = g0Var;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public boolean a(boolean z11) {
            this.f32753b.q(z11);
            return z11;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public m2 b(m2 m2Var) {
            this.f32754c.d(m2Var.f33487a);
            this.f32754c.c(m2Var.f33488b);
            return m2Var;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public AudioProcessor[] getAudioProcessors() {
            return this.f32752a;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long getMediaDuration(long j11) {
            return this.f32754c.b(j11);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long getSkippedOutputFrameCount() {
            return this.f32753b.k();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m2 f32755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f32756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f32757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f32758d;

        public g(m2 m2Var, boolean z11, long j11, long j12) {
            this.f32755a = m2Var;
            this.f32756b = z11;
            this.f32757c = j11;
            this.f32758d = j12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h<T extends Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f32759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public T f32760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f32761c;

        public h(long j11) {
            this.f32759a = j11;
        }

        public void a() {
            this.f32760b = null;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: T extends java.lang.Exception */
        public void b(T t11) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f32760b == null) {
                this.f32760b = t11;
                this.f32761c = this.f32759a + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.f32761c) {
                T t12 = this.f32760b;
                if (t12 != t11) {
                    t12.addSuppressed(t11);
                }
                T t13 = this.f32760b;
                a();
                throw t13;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class i implements t.a {
        public i() {
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void b(long j11) {
            if (DefaultAudioSink.this.f32727r != null) {
                DefaultAudioSink.this.f32727r.b(j11);
            }
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void onInvalidLatency(long j11) {
            com.google.android.exoplayer2.util.s.i("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j11);
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void onPositionFramesMismatch(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j11 + ", " + j12 + ", " + j13 + ", " + j14 + ", " + DefaultAudioSink.this.I() + ", " + DefaultAudioSink.this.J();
            if (DefaultAudioSink.f32707c0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            com.google.android.exoplayer2.util.s.i("DefaultAudioSink", str);
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void onSystemTimeUsMismatch(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j11 + ", " + j12 + ", " + j13 + ", " + j14 + ", " + DefaultAudioSink.this.I() + ", " + DefaultAudioSink.this.J();
            if (DefaultAudioSink.f32707c0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            com.google.android.exoplayer2.util.s.i("DefaultAudioSink", str);
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void onUnderrun(int i11, long j11) {
            if (DefaultAudioSink.this.f32727r != null) {
                DefaultAudioSink.this.f32727r.onUnderrun(i11, j11, SystemClock.elapsedRealtime() - DefaultAudioSink.this.Z);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f32763a = new Handler();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioTrack.StreamEventCallback f32764b;

        /* JADX INFO: compiled from: source.java */
        public class a extends AudioTrack.StreamEventCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DefaultAudioSink f32766a;

            public a(DefaultAudioSink defaultAudioSink) {
                this.f32766a = defaultAudioSink;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i11) {
                com.google.android.exoplayer2.util.a.g(audioTrack == DefaultAudioSink.this.f32730u);
                if (DefaultAudioSink.this.f32727r == null || !DefaultAudioSink.this.U) {
                    return;
                }
                DefaultAudioSink.this.f32727r.d();
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(AudioTrack audioTrack) {
                com.google.android.exoplayer2.util.a.g(audioTrack == DefaultAudioSink.this.f32730u);
                if (DefaultAudioSink.this.f32727r == null || !DefaultAudioSink.this.U) {
                    return;
                }
                DefaultAudioSink.this.f32727r.d();
            }
        }

        public j() {
            this.f32764b = new a(DefaultAudioSink.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f32763a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new n1(handler), this.f32764b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f32764b);
            this.f32763a.removeCallbacksAndMessages(null);
        }
    }

    public DefaultAudioSink(d dVar) {
        this.f32708a = dVar.f32737a;
        b bVar = dVar.f32738b;
        this.f32710b = bVar;
        int i11 = o0.f35608a;
        this.f32712c = i11 >= 21 && dVar.f32739c;
        this.f32720k = i11 >= 23 && dVar.f32740d;
        this.f32721l = i11 >= 29 ? dVar.f32741e : 0;
        this.f32725p = dVar.f32742f;
        com.google.android.exoplayer2.util.h hVar = new com.google.android.exoplayer2.util.h(com.google.android.exoplayer2.util.e.f35556a);
        this.f32717h = hVar;
        hVar.f();
        this.f32718i = new t(new i());
        w wVar = new w();
        this.f32713d = wVar;
        h0 h0Var = new h0();
        this.f32714e = h0Var;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new d0(), wVar, h0Var);
        Collections.addAll(arrayList, bVar.getAudioProcessors());
        this.f32715f = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.f32716g = new AudioProcessor[]{new z()};
        this.J = 1.0f;
        this.f32731v = com.google.android.exoplayer2.audio.e.f32806h;
        this.W = 0;
        this.X = new u(0, 0.0f);
        m2 m2Var = m2.f33485d;
        this.f32733x = new g(m2Var, false, 0L, 0L);
        this.f32734y = m2Var;
        this.R = -1;
        this.K = new AudioProcessor[0];
        this.L = new ByteBuffer[0];
        this.f32719j = new ArrayDeque<>();
        this.f32723n = new h<>(100L);
        this.f32724o = new h<>(100L);
    }

    @RequiresApi(21)
    public static AudioFormat B(int i11, int i12, int i13) {
        return new AudioFormat.Builder().setSampleRate(i11).setChannelMask(i12).setEncoding(i13).build();
    }

    public static int D(int i11, int i12, int i13) {
        int minBufferSize = AudioTrack.getMinBufferSize(i11, i12, i13);
        com.google.android.exoplayer2.util.a.g(minBufferSize != -2);
        return minBufferSize;
    }

    public static int E(int i11, ByteBuffer byteBuffer) {
        switch (i11) {
            case 5:
            case 6:
            case 18:
                return com.google.android.exoplayer2.audio.b.d(byteBuffer);
            case 7:
            case 8:
                return y.e(byteBuffer);
            case 9:
                int iM = b0.m(o0.I(byteBuffer, byteBuffer.position()));
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
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i11);
            case 14:
                int iA = com.google.android.exoplayer2.audio.b.a(byteBuffer);
                if (iA == -1) {
                    return 0;
                }
                return com.google.android.exoplayer2.audio.b.h(byteBuffer, iA) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return com.google.android.exoplayer2.audio.c.c(byteBuffer);
        }
    }

    public static boolean L(int i11) {
        return (o0.f35608a >= 24 && i11 == -6) || i11 == -32;
    }

    public static boolean N(AudioTrack audioTrack) {
        return o0.f35608a >= 29 && audioTrack.isOffloadedPlayback();
    }

    @RequiresApi(21)
    public static void W(AudioTrack audioTrack, float f11) {
        audioTrack.setVolume(f11);
    }

    public static void X(AudioTrack audioTrack, float f11) {
        audioTrack.setStereoVolume(f11, f11);
    }

    @RequiresApi(21)
    public static int d0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11) {
        return audioTrack.write(byteBuffer, i11, 1);
    }

    public final void A() {
        int i11 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.K;
            if (i11 >= audioProcessorArr.length) {
                return;
            }
            AudioProcessor audioProcessor = audioProcessorArr[i11];
            audioProcessor.flush();
            this.L[i11] = audioProcessor.getOutput();
            i11++;
        }
    }

    public final m2 C() {
        return F().f32755a;
    }

    public final g F() {
        g gVar = this.f32732w;
        if (gVar != null) {
            return gVar;
        }
        return !this.f32719j.isEmpty() ? this.f32719j.getLast() : this.f32733x;
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    @SuppressLint({"InlinedApi"})
    public final int G(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        int i11 = o0.f35608a;
        if (i11 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return (i11 == 30 && o0.f35611d.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    public boolean H() {
        return F().f32756b;
    }

    public final long I() {
        e eVar = this.f32729t;
        return eVar.f32745c == 0 ? this.B / ((long) eVar.f32744b) : this.C;
    }

    public final long J() {
        e eVar = this.f32729t;
        return eVar.f32745c == 0 ? this.D / ((long) eVar.f32746d) : this.E;
    }

    public final boolean K() throws AudioSink.InitializationException {
        u1 u1Var;
        if (!this.f32717h.e()) {
            return false;
        }
        AudioTrack audioTrackY = y();
        this.f32730u = audioTrackY;
        if (N(audioTrackY)) {
            R(this.f32730u);
            if (this.f32721l != 3) {
                AudioTrack audioTrack = this.f32730u;
                m1 m1Var = this.f32729t.f32743a;
                audioTrack.setOffloadDelayPadding(m1Var.C, m1Var.D);
            }
        }
        if (o0.f35608a >= 31 && (u1Var = this.f32726q) != null) {
            a.a(this.f32730u, u1Var);
        }
        this.W = this.f32730u.getAudioSessionId();
        t tVar = this.f32718i;
        AudioTrack audioTrack2 = this.f32730u;
        e eVar = this.f32729t;
        tVar.s(audioTrack2, eVar.f32745c == 2, eVar.f32749g, eVar.f32746d, eVar.f32750h);
        V();
        int i11 = this.X.f32946a;
        if (i11 != 0) {
            this.f32730u.attachAuxEffect(i11);
            this.f32730u.setAuxEffectSendLevel(this.X.f32947b);
        }
        this.H = true;
        return true;
    }

    public final boolean M() {
        return this.f32730u != null;
    }

    public final void O() {
        if (this.f32729t.l()) {
            this.f32709a0 = true;
        }
    }

    public final void P() {
        if (this.T) {
            return;
        }
        this.T = true;
        this.f32718i.g(J());
        this.f32730u.stop();
        this.A = 0;
    }

    public final void Q(long j11) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.K.length;
        int i11 = length;
        while (i11 >= 0) {
            if (i11 > 0) {
                byteBuffer = this.L[i11 - 1];
            } else {
                byteBuffer = this.M;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.f32701a;
                }
            }
            if (i11 == length) {
                c0(byteBuffer, j11);
            } else {
                AudioProcessor audioProcessor = this.K[i11];
                if (i11 > this.R) {
                    audioProcessor.queueInput(byteBuffer);
                }
                ByteBuffer output = audioProcessor.getOutput();
                this.L[i11] = output;
                if (output.hasRemaining()) {
                    i11++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i11--;
            }
        }
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public final void R(AudioTrack audioTrack) {
        if (this.f32722m == null) {
            this.f32722m = new j();
        }
        this.f32722m.a(audioTrack);
    }

    public final void S() {
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.f32711b0 = false;
        this.F = 0;
        this.f32733x = new g(C(), H(), 0L, 0L);
        this.I = 0L;
        this.f32732w = null;
        this.f32719j.clear();
        this.M = null;
        this.N = 0;
        this.O = null;
        this.T = false;
        this.S = false;
        this.R = -1;
        this.f32735z = null;
        this.A = 0;
        this.f32714e.i();
        A();
    }

    public final void T(m2 m2Var, boolean z11) {
        g gVarF = F();
        if (m2Var.equals(gVarF.f32755a) && z11 == gVarF.f32756b) {
            return;
        }
        g gVar = new g(m2Var, z11, C.TIME_UNSET, C.TIME_UNSET);
        if (M()) {
            this.f32732w = gVar;
        } else {
            this.f32733x = gVar;
        }
    }

    @RequiresApi(23)
    public final void U(m2 m2Var) {
        if (M()) {
            try {
                this.f32730u.setPlaybackParams(f4.e0.a().allowDefaults().setSpeed(m2Var.f33487a).setPitch(m2Var.f33488b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e11) {
                com.google.android.exoplayer2.util.s.j("DefaultAudioSink", "Failed to set playback params", e11);
            }
            m2Var = new m2(this.f32730u.getPlaybackParams().getSpeed(), this.f32730u.getPlaybackParams().getPitch());
            this.f32718i.t(m2Var.f33487a);
        }
        this.f32734y = m2Var;
    }

    public final void V() {
        if (M()) {
            if (o0.f35608a >= 21) {
                W(this.f32730u, this.J);
            } else {
                X(this.f32730u, this.J);
            }
        }
    }

    public final void Y() {
        AudioProcessor[] audioProcessorArr = this.f32729t.f32751i;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.K = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.L = new ByteBuffer[size];
        A();
    }

    public final boolean Z() {
        return (this.Y || !MimeTypes.AUDIO_RAW.equals(this.f32729t.f32743a.f33445m) || a0(this.f32729t.f32743a.B)) ? false : true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(m1 m1Var) {
        return i(m1Var) != 0;
    }

    public final boolean a0(int i11) {
        return this.f32712c && o0.t0(i11);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void b(m2 m2Var) {
        m2 m2Var2 = new m2(o0.p(m2Var.f33487a, 0.1f, 8.0f), o0.p(m2Var.f33488b, 0.1f, 8.0f));
        if (!this.f32720k || o0.f35608a < 23) {
            T(m2Var2, H());
        } else {
            U(m2Var2);
        }
    }

    public final boolean b0(m1 m1Var, com.google.android.exoplayer2.audio.e eVar) {
        int iF;
        int iG;
        int iG2;
        if (o0.f35608a < 29 || this.f32721l == 0 || (iF = com.google.android.exoplayer2.util.w.f((String) com.google.android.exoplayer2.util.a.e(m1Var.f33445m), m1Var.f33442j)) == 0 || (iG = o0.G(m1Var.f33458z)) == 0 || (iG2 = G(B(m1Var.A, iG, iF), eVar.b().f32814a)) == 0) {
            return false;
        }
        if (iG2 == 1) {
            return ((m1Var.C != 0 || m1Var.D != 0) && (this.f32721l == 1)) ? false : true;
        }
        if (iG2 == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean c(ByteBuffer byteBuffer, long j11, int i11) throws Exception {
        ByteBuffer byteBuffer2 = this.M;
        com.google.android.exoplayer2.util.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f32728s != null) {
            if (!z()) {
                return false;
            }
            if (this.f32728s.b(this.f32729t)) {
                this.f32729t = this.f32728s;
                this.f32728s = null;
                if (N(this.f32730u) && this.f32721l != 3) {
                    if (this.f32730u.getPlayState() == 3) {
                        this.f32730u.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.f32730u;
                    m1 m1Var = this.f32729t.f32743a;
                    audioTrack.setOffloadDelayPadding(m1Var.C, m1Var.D);
                    this.f32711b0 = true;
                }
            } else {
                P();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            }
            u(j11);
        }
        if (!M()) {
            try {
                if (!K()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e11) {
                if (e11.isRecoverable) {
                    throw e11;
                }
                this.f32723n.b(e11);
                return false;
            }
        }
        this.f32723n.a();
        if (this.H) {
            this.I = Math.max(0L, j11);
            this.G = false;
            this.H = false;
            if (this.f32720k && o0.f35608a >= 23) {
                U(this.f32734y);
            }
            u(j11);
            if (this.U) {
                play();
            }
        }
        if (!this.f32718i.k(J())) {
            return false;
        }
        if (this.M == null) {
            com.google.android.exoplayer2.util.a.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            e eVar = this.f32729t;
            if (eVar.f32745c != 0 && this.F == 0) {
                int iE = E(eVar.f32749g, byteBuffer);
                this.F = iE;
                if (iE == 0) {
                    return true;
                }
            }
            if (this.f32732w != null) {
                if (!z()) {
                    return false;
                }
                u(j11);
                this.f32732w = null;
            }
            long jK = this.I + this.f32729t.k(I() - this.f32714e.h());
            if (!this.G && Math.abs(jK - j11) > 200000) {
                this.f32727r.a(new AudioSink.UnexpectedDiscontinuityException(j11, jK));
                this.G = true;
            }
            if (this.G) {
                if (!z()) {
                    return false;
                }
                long j12 = j11 - jK;
                this.I += j12;
                this.G = false;
                u(j11);
                AudioSink.a aVar = this.f32727r;
                if (aVar != null && j12 != 0) {
                    aVar.onPositionDiscontinuity();
                }
            }
            if (this.f32729t.f32745c == 0) {
                this.B += (long) byteBuffer.remaining();
            } else {
                this.C += ((long) this.F) * ((long) i11);
            }
            this.M = byteBuffer;
            this.N = i11;
        }
        Q(j11);
        if (!this.M.hasRemaining()) {
            this.M = null;
            this.N = 0;
            return true;
        }
        if (!this.f32718i.j(J())) {
            return false;
        }
        com.google.android.exoplayer2.util.s.i("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    public final void c0(ByteBuffer byteBuffer, long j11) throws Exception {
        int iD0;
        AudioSink.a aVar;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.O;
            if (byteBuffer2 != null) {
                com.google.android.exoplayer2.util.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.O = byteBuffer;
                if (o0.f35608a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.P;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.P = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.P, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.Q = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (o0.f35608a < 21) {
                int iC = this.f32718i.c(this.D);
                if (iC > 0) {
                    iD0 = this.f32730u.write(this.P, this.Q, Math.min(iRemaining2, iC));
                    if (iD0 > 0) {
                        this.Q += iD0;
                        byteBuffer.position(byteBuffer.position() + iD0);
                    }
                } else {
                    iD0 = 0;
                }
            } else if (this.Y) {
                com.google.android.exoplayer2.util.a.g(j11 != C.TIME_UNSET);
                iD0 = e0(this.f32730u, byteBuffer, iRemaining2, j11);
            } else {
                iD0 = d0(this.f32730u, byteBuffer, iRemaining2);
            }
            this.Z = SystemClock.elapsedRealtime();
            if (iD0 < 0) {
                boolean zL = L(iD0);
                if (zL) {
                    O();
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(iD0, this.f32729t.f32743a, zL);
                AudioSink.a aVar2 = this.f32727r;
                if (aVar2 != null) {
                    aVar2.a(writeException);
                }
                if (writeException.isRecoverable) {
                    throw writeException;
                }
                this.f32724o.b(writeException);
                return;
            }
            this.f32724o.a();
            if (N(this.f32730u)) {
                if (this.E > 0) {
                    this.f32711b0 = false;
                }
                if (this.U && (aVar = this.f32727r) != null && iD0 < iRemaining2 && !this.f32711b0) {
                    aVar.c();
                }
            }
            int i11 = this.f32729t.f32745c;
            if (i11 == 0) {
                this.D += (long) iD0;
            }
            if (iD0 == iRemaining2) {
                if (i11 != 0) {
                    com.google.android.exoplayer2.util.a.g(byteBuffer == this.M);
                    this.E += ((long) this.F) * ((long) this.N);
                }
                this.O = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void d(@Nullable u1 u1Var) {
        this.f32726q = u1Var;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        if (this.Y) {
            this.Y = false;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void e() {
        com.google.android.exoplayer2.util.a.g(o0.f35608a >= 21);
        com.google.android.exoplayer2.util.a.g(this.V);
        if (this.Y) {
            return;
        }
        this.Y = true;
        flush();
    }

    @RequiresApi(21)
    public final int e0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11, long j11) {
        if (o0.f35608a >= 26) {
            return audioTrack.write(byteBuffer, i11, 1, j11 * 1000);
        }
        if (this.f32735z == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.f32735z = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.f32735z.putInt(1431633921);
        }
        if (this.A == 0) {
            this.f32735z.putInt(4, i11);
            this.f32735z.putLong(8, j11 * 1000);
            this.f32735z.position(0);
            this.A = i11;
        }
        int iRemaining = this.f32735z.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.f32735z, iRemaining, 1);
            if (iWrite < 0) {
                this.A = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iD0 = d0(audioTrack, byteBuffer, i11);
        if (iD0 < 0) {
            this.A = 0;
            return iD0;
        }
        this.A -= iD0;
        return iD0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void f(boolean z11) {
        T(C(), z11);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (M()) {
            S();
            if (this.f32718i.i()) {
                this.f32730u.pause();
            }
            if (N(this.f32730u)) {
                ((j) com.google.android.exoplayer2.util.a.e(this.f32722m)).b(this.f32730u);
            }
            final AudioTrack audioTrack = this.f32730u;
            this.f32730u = null;
            if (o0.f35608a < 21 && !this.V) {
                this.W = 0;
            }
            e eVar = this.f32728s;
            if (eVar != null) {
                this.f32729t = eVar;
                this.f32728s = null;
            }
            this.f32718i.q();
            this.f32717h.d();
            new Thread("ExoPlayer:AudioTrackReleaseThread") { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.f32717h.f();
                    }
                }
            }.start();
        }
        this.f32724o.a();
        this.f32723n.a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void g(com.google.android.exoplayer2.audio.e eVar) {
        if (this.f32731v.equals(eVar)) {
            return;
        }
        this.f32731v = eVar;
        if (this.Y) {
            return;
        }
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z11) {
        if (!M() || this.H) {
            return Long.MIN_VALUE;
        }
        return w(v(Math.min(this.f32718i.d(z11), this.f32729t.h(J()))));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public m2 getPlaybackParameters() {
        return this.f32720k ? this.f32734y : C();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void h(AudioSink.a aVar) {
        this.f32727r = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        this.G = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return M() && this.f32718i.h(J());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int i(m1 m1Var) {
        if (!MimeTypes.AUDIO_RAW.equals(m1Var.f33445m)) {
            return ((this.f32709a0 || !b0(m1Var, this.f32731v)) && !this.f32708a.h(m1Var)) ? 0 : 2;
        }
        if (o0.u0(m1Var.B)) {
            int i11 = m1Var.B;
            return (i11 == 2 || (this.f32712c && i11 == 4)) ? 2 : 1;
        }
        com.google.android.exoplayer2.util.s.i("DefaultAudioSink", "Invalid PCM encoding: " + m1Var.B);
        return 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return !M() || (this.S && !hasPendingData());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void j() {
        if (o0.f35608a < 25) {
            flush();
            return;
        }
        this.f32724o.a();
        this.f32723n.a();
        if (M()) {
            S();
            if (this.f32718i.i()) {
                this.f32730u.pause();
            }
            this.f32730u.flush();
            this.f32718i.q();
            t tVar = this.f32718i;
            AudioTrack audioTrack = this.f32730u;
            e eVar = this.f32729t;
            tVar.s(audioTrack, eVar.f32745c == 2, eVar.f32749g, eVar.f32746d, eVar.f32750h);
            this.H = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void k(u uVar) {
        if (this.X.equals(uVar)) {
            return;
        }
        int i11 = uVar.f32946a;
        float f11 = uVar.f32947b;
        AudioTrack audioTrack = this.f32730u;
        if (audioTrack != null) {
            if (this.X.f32946a != i11) {
                audioTrack.attachAuxEffect(i11);
            }
            if (i11 != 0) {
                this.f32730u.setAuxEffectSendLevel(f11);
            }
        }
        this.X = uVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void l(m1 m1Var, int i11, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessor[] audioProcessorArr;
        int i12;
        int iIntValue;
        int iF;
        int i13;
        int i14;
        int iE0;
        int[] iArr2;
        if (MimeTypes.AUDIO_RAW.equals(m1Var.f33445m)) {
            com.google.android.exoplayer2.util.a.a(o0.u0(m1Var.B));
            int iE1 = o0.e0(m1Var.B, m1Var.f33458z);
            AudioProcessor[] audioProcessorArr2 = a0(m1Var.B) ? this.f32716g : this.f32715f;
            this.f32714e.j(m1Var.C, m1Var.D);
            if (o0.f35608a < 21 && m1Var.f33458z == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i15 = 0; i15 < 6; i15++) {
                    iArr2[i15] = i15;
                }
            } else {
                iArr2 = iArr;
            }
            this.f32713d.h(iArr2);
            AudioProcessor.a aVar = new AudioProcessor.a(m1Var.A, m1Var.f33458z, m1Var.B);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.a aVarA = audioProcessor.a(aVar);
                    if (audioProcessor.isActive()) {
                        aVar = aVarA;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e11) {
                    throw new AudioSink.ConfigurationException(e11, m1Var);
                }
            }
            int i16 = aVar.f32705c;
            int i17 = aVar.f32703a;
            int iG = o0.G(aVar.f32704b);
            audioProcessorArr = audioProcessorArr2;
            iE0 = o0.e0(i16, aVar.f32704b);
            iF = i16;
            i12 = i17;
            iIntValue = iG;
            i14 = iE1;
            i13 = 0;
        } else {
            audioProcessorArr = new AudioProcessor[0];
            i12 = m1Var.A;
            if (b0(m1Var, this.f32731v)) {
                iF = com.google.android.exoplayer2.util.w.f((String) com.google.android.exoplayer2.util.a.e(m1Var.f33445m), m1Var.f33442j);
                iIntValue = o0.G(m1Var.f33458z);
                i13 = 1;
            } else {
                Pair<Integer, Integer> pairF = this.f32708a.f(m1Var);
                if (pairF == null) {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + m1Var, m1Var);
                }
                int iIntValue2 = ((Integer) pairF.first).intValue();
                iIntValue = ((Integer) pairF.second).intValue();
                iF = iIntValue2;
                i13 = 2;
            }
            i14 = -1;
            iE0 = -1;
        }
        int iA = i11 != 0 ? i11 : this.f32725p.a(D(i12, iIntValue, iF), iF, i13, iE0, i12, this.f32720k ? 8.0d : 1.0d);
        if (iF == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i13 + ") for: " + m1Var, m1Var);
        }
        if (iIntValue == 0) {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i13 + ") for: " + m1Var, m1Var);
        }
        this.f32709a0 = false;
        e eVar = new e(m1Var, i14, i13, iE0, i12, iIntValue, iF, iA, audioProcessorArr);
        if (M()) {
            this.f32728s = eVar;
        } else {
            this.f32729t = eVar;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.U = false;
        if (M() && this.f32718i.p()) {
            this.f32730u.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.U = true;
        if (M()) {
            this.f32718i.u();
            this.f32730u.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.S && M() && z()) {
            P();
            this.S = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        for (AudioProcessor audioProcessor : this.f32715f) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.f32716g) {
            audioProcessor2.reset();
        }
        this.U = false;
        this.f32709a0 = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i11) {
        if (this.W != i11) {
            this.W = i11;
            this.V = i11 != 0;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f11) {
        if (this.J != f11) {
            this.J = f11;
            V();
        }
    }

    public final void u(long j11) {
        m2 m2VarB = Z() ? this.f32710b.b(C()) : m2.f33485d;
        boolean zA = Z() ? this.f32710b.a(H()) : false;
        this.f32719j.add(new g(m2VarB, zA, Math.max(0L, j11), this.f32729t.h(J())));
        Y();
        AudioSink.a aVar = this.f32727r;
        if (aVar != null) {
            aVar.onSkipSilenceEnabledChanged(zA);
        }
    }

    public final long v(long j11) {
        while (!this.f32719j.isEmpty() && j11 >= this.f32719j.getFirst().f32758d) {
            this.f32733x = this.f32719j.remove();
        }
        g gVar = this.f32733x;
        long j12 = j11 - gVar.f32758d;
        if (gVar.f32755a.equals(m2.f33485d)) {
            return this.f32733x.f32757c + j12;
        }
        if (this.f32719j.isEmpty()) {
            return this.f32733x.f32757c + this.f32710b.getMediaDuration(j12);
        }
        g first = this.f32719j.getFirst();
        return first.f32757c - o0.a0(first.f32758d - j11, this.f32733x.f32755a.f33487a);
    }

    public final long w(long j11) {
        return j11 + this.f32729t.h(this.f32710b.getSkippedOutputFrameCount());
    }

    public final AudioTrack x(e eVar) throws AudioSink.InitializationException {
        try {
            return eVar.a(this.Y, this.f32731v, this.W);
        } catch (AudioSink.InitializationException e11) {
            AudioSink.a aVar = this.f32727r;
            if (aVar != null) {
                aVar.a(e11);
            }
            throw e11;
        }
    }

    public final AudioTrack y() throws AudioSink.InitializationException {
        try {
            return x((e) com.google.android.exoplayer2.util.a.e(this.f32729t));
        } catch (AudioSink.InitializationException e11) {
            e eVar = this.f32729t;
            if (eVar.f32750h > 1000000) {
                e eVarC = eVar.c(1000000);
                try {
                    AudioTrack audioTrackX = x(eVarC);
                    this.f32729t = eVarC;
                    return audioTrackX;
                } catch (AudioSink.InitializationException e12) {
                    e11.addSuppressed(e12);
                    O();
                    throw e11;
                }
            }
            O();
            throw e11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    /* JADX WARN: Code duplicated, block: B:14:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final boolean z() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.R
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto Lb
            r9.R = r2
        L9:
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            int r4 = r9.R
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.K
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.queueEndOfStream()
        L1f:
            r9.Q(r7)
            boolean r0 = r4.isEnded()
            if (r0 != 0) goto L29
            return r2
        L29:
            int r0 = r9.R
            int r0 = r0 + r1
            r9.R = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L3b
            r9.c0(r0, r7)
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L3b
            return r2
        L3b:
            r9.R = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.z():boolean");
    }
}
