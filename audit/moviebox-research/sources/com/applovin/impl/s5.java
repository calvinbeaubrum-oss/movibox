package com.applovin.impl;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.PlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s5 implements r1 {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static boolean f22243a0 = false;
    private long A;
    private long B;
    private long C;
    private int D;
    private boolean E;
    private boolean F;
    private long G;
    private float H;
    private p1[] I;
    private ByteBuffer[] J;
    private ByteBuffer K;
    private int L;
    private ByteBuffer M;
    private byte[] N;
    private int O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private v1 V;
    private boolean W;
    private long X;
    private boolean Y;
    private boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f22244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f22245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f22246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d3 f22247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zo f22248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final p1[] f22249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final p1[] f22250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConditionVariable f22251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final u1 f22252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ArrayDeque f22253j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f22254k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f22255l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private i f22256m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final g f22257n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final g f22258o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private r1.c f22259p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private c f22260q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private c f22261r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private AudioTrack f22262s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private l1 f22263t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private f f22264u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private f f22265v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ph f22266w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ByteBuffer f22267x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f22268y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f22269z;

    /* JADX INFO: compiled from: source.java */
    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioTrack f22270a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, AudioTrack audioTrack) {
            super(str);
            this.f22270a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f22270a.flush();
                this.f22270a.release();
            } finally {
                s5.this.f22251h.open();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        long a(long j11);

        ph a(ph phVar);

        boolean a(boolean z11);

        p1[] a();

        long b();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f9 f22272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f22273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f22274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f22275d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f22276e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f22277f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f22278g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f22279h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final p1[] f22280i;

        public c(f9 f9Var, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z11, p1[] p1VarArr) {
            this.f22272a = f9Var;
            this.f22273b = i11;
            this.f22274c = i12;
            this.f22275d = i13;
            this.f22276e = i14;
            this.f22277f = i15;
            this.f22278g = i16;
            this.f22280i = p1VarArr;
            this.f22279h = a(i17, z11);
        }

        private int a(float f11) {
            int minBufferSize = AudioTrack.getMinBufferSize(this.f22276e, this.f22277f, this.f22278g);
            b1.b(minBufferSize != -2);
            int iA = xp.a(minBufferSize * 4, ((int) a(250000L)) * this.f22275d, Math.max(minBufferSize, ((int) a(750000L)) * this.f22275d));
            return f11 != 1.0f ? Math.round(iA * f11) : iA;
        }

        private int a(int i11, boolean z11) {
            if (i11 != 0) {
                return i11;
            }
            int i12 = this.f22274c;
            if (i12 == 0) {
                return a(z11 ? 8.0f : 1.0f);
            }
            if (i12 == 1) {
                return c(50000000L);
            }
            if (i12 == 2) {
                return c(250000L);
            }
            throw new IllegalStateException();
        }

        private static AudioAttributes a() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        private static AudioAttributes a(l1 l1Var, boolean z11) {
            return z11 ? a() : l1Var.a();
        }

        private AudioTrack a(l1 l1Var, int i11) {
            int iE = xp.e(l1Var.f20316c);
            return i11 == 0 ? new AudioTrack(iE, this.f22276e, this.f22277f, this.f22278g, this.f22279h, 1) : new AudioTrack(iE, this.f22276e, this.f22277f, this.f22278g, this.f22279h, 1, i11);
        }

        private AudioTrack b(boolean z11, l1 l1Var, int i11) {
            int i12 = xp.f24372a;
            if (i12 >= 29) {
                return d(z11, l1Var, i11);
            }
            return i12 >= 21 ? c(z11, l1Var, i11) : a(l1Var, i11);
        }

        private int c(long j11) {
            int iD = s5.d(this.f22278g);
            if (this.f22278g == 5) {
                iD *= 2;
            }
            return (int) ((j11 * ((long) iD)) / 1000000);
        }

        private AudioTrack c(boolean z11, l1 l1Var, int i11) {
            return new AudioTrack(a(l1Var, z11), s5.b(this.f22276e, this.f22277f, this.f22278g), this.f22279h, 1, i11);
        }

        private AudioTrack d(boolean z11, l1 l1Var, int i11) {
            return f4.y0.a().setAudioAttributes(a(l1Var, z11)).setAudioFormat(s5.b(this.f22276e, this.f22277f, this.f22278g)).setTransferMode(1).setBufferSizeInBytes(this.f22279h).setSessionId(i11).setOffloadedPlayback(this.f22274c == 1).build();
        }

        public long a(long j11) {
            return (j11 * ((long) this.f22276e)) / 1000000;
        }

        public AudioTrack a(boolean z11, l1 l1Var, int i11) throws r1.b {
            try {
                AudioTrack audioTrackB = b(z11, l1Var, i11);
                int state = audioTrackB.getState();
                if (state == 1) {
                    return audioTrackB;
                }
                try {
                    audioTrackB.release();
                } catch (Exception unused) {
                }
                throw new r1.b(state, this.f22276e, this.f22277f, this.f22279h, this.f22272a, b(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e11) {
                throw new r1.b(0, this.f22276e, this.f22277f, this.f22279h, this.f22272a, b(), e11);
            }
        }

        public boolean a(c cVar) {
            return cVar.f22274c == this.f22274c && cVar.f22278g == this.f22278g && cVar.f22276e == this.f22276e && cVar.f22277f == this.f22277f && cVar.f22275d == this.f22275d;
        }

        public long b(long j11) {
            return (j11 * 1000000) / ((long) this.f22276e);
        }

        public boolean b() {
            return this.f22274c == 1;
        }

        public long d(long j11) {
            return (j11 * 1000000) / ((long) this.f22272a.A);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p1[] f22281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ak f22282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ok f22283c;

        public d(p1... p1VarArr) {
            this(p1VarArr, new ak(), new ok());
        }

        public d(p1[] p1VarArr, ak akVar, ok okVar) {
            p1[] p1VarArr2 = new p1[p1VarArr.length + 2];
            this.f22281a = p1VarArr2;
            System.arraycopy(p1VarArr, 0, p1VarArr2, 0, p1VarArr.length);
            this.f22282b = akVar;
            this.f22283c = okVar;
            p1VarArr2[p1VarArr.length] = akVar;
            p1VarArr2[p1VarArr.length + 1] = okVar;
        }

        @Override // com.applovin.impl.s5.b
        public long a(long j11) {
            return this.f22283c.a(j11);
        }

        @Override // com.applovin.impl.s5.b
        public ph a(ph phVar) {
            this.f22283c.b(phVar.f21777a);
            this.f22283c.a(phVar.f21778b);
            return phVar;
        }

        @Override // com.applovin.impl.s5.b
        public boolean a(boolean z11) {
            this.f22282b.a(z11);
            return z11;
        }

        @Override // com.applovin.impl.s5.b
        public p1[] a() {
            return this.f22281a;
        }

        @Override // com.applovin.impl.s5.b
        public long b() {
            return this.f22282b.j();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends RuntimeException {
        private e(String str) {
            super(str);
        }

        public /* synthetic */ e(String str, a aVar) {
            this(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ph f22284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f22285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f22286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f22287d;

        private f(ph phVar, boolean z11, long j11, long j12) {
            this.f22284a = phVar;
            this.f22285b = z11;
            this.f22286c = j11;
            this.f22287d = j12;
        }

        public /* synthetic */ f(ph phVar, boolean z11, long j11, long j12, a aVar) {
            this(phVar, z11, j11, j12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f22288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Exception f22289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f22290c;

        public g(long j11) {
            this.f22288a = j11;
        }

        public void a() {
            this.f22289b = null;
        }

        public void a(Exception exc) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f22289b == null) {
                this.f22289b = exc;
                this.f22290c = this.f22288a + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.f22290c) {
                Exception exc2 = this.f22289b;
                if (exc2 != exc) {
                    exc2.addSuppressed(exc);
                }
                Exception exc3 = this.f22289b;
                a();
                throw exc3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class h implements u1.a {
        private h() {
        }

        public /* synthetic */ h(s5 s5Var, a aVar) {
            this();
        }

        @Override // com.applovin.impl.u1.a
        public void a(int i11, long j11) {
            if (s5.this.f22259p != null) {
                s5.this.f22259p.a(i11, j11, SystemClock.elapsedRealtime() - s5.this.X);
            }
        }

        @Override // com.applovin.impl.u1.a
        public void a(long j11) {
            if (s5.this.f22259p != null) {
                s5.this.f22259p.a(j11);
            }
        }

        @Override // com.applovin.impl.u1.a
        public void a(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j11 + ", " + j12 + ", " + j13 + ", " + j14 + ", " + s5.this.q() + ", " + s5.this.r();
            if (s5.f22243a0) {
                throw new e(str, null);
            }
            pc.d("DefaultAudioSink", str);
        }

        @Override // com.applovin.impl.u1.a
        public void b(long j11) {
            pc.d("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j11);
        }

        @Override // com.applovin.impl.u1.a
        public void b(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j11 + ", " + j12 + ", " + j13 + ", " + j14 + ", " + s5.this.q() + ", " + s5.this.r();
            if (s5.f22243a0) {
                throw new e(str, null);
            }
            pc.d("DefaultAudioSink", str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f22292a = new Handler();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioTrack.StreamEventCallback f22293b;

        /* JADX INFO: compiled from: source.java */
        public class a extends AudioTrack.StreamEventCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ s5 f22295a;

            public a(s5 s5Var) {
                this.f22295a = s5Var;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i11) {
                b1.b(audioTrack == s5.this.f22262s);
                if (s5.this.f22259p == null || !s5.this.S) {
                    return;
                }
                s5.this.f22259p.a();
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(AudioTrack audioTrack) {
                b1.b(audioTrack == s5.this.f22262s);
                if (s5.this.f22259p == null || !s5.this.S) {
                    return;
                }
                s5.this.f22259p.a();
            }
        }

        public i() {
            this.f22293b = new a(s5.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f22292a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new f4.n1(handler), this.f22293b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f22293b);
            this.f22292a.removeCallbacksAndMessages(null);
        }
    }

    public s5(n1 n1Var, b bVar, boolean z11, boolean z12, int i11) {
        this.f22244a = n1Var;
        this.f22245b = (b) b1.a(bVar);
        int i12 = xp.f24372a;
        this.f22246c = i12 >= 21 && z11;
        this.f22254k = i12 >= 23 && z12;
        this.f22255l = i12 >= 29 ? i11 : 0;
        this.f22251h = new ConditionVariable(true);
        this.f22252i = new u1(new h(this, null));
        d3 d3Var = new d3();
        this.f22247d = d3Var;
        zo zoVar = new zo();
        this.f22248e = zoVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new wi(), d3Var, zoVar);
        Collections.addAll(arrayList, bVar.a());
        this.f22249f = (p1[]) arrayList.toArray(new p1[0]);
        this.f22250g = new p1[]{new c9()};
        this.H = 1.0f;
        this.f22263t = l1.f20312g;
        this.U = 0;
        this.V = new v1(0, 0.0f);
        ph phVar = ph.f21775d;
        this.f22265v = new f(phVar, false, 0L, 0L, null);
        this.f22266w = phVar;
        this.P = -1;
        this.I = new p1[0];
        this.J = new ByteBuffer[0];
        this.f22253j = new ArrayDeque();
        this.f22257n = new g(100L);
        this.f22258o = new g(100L);
    }

    private static int a(int i11, int i12) {
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
        for (int i13 = 8; i13 > 0; i13--) {
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i11).setSampleRate(i12).setChannelMask(xp.a(i13)).build(), audioAttributesBuild)) {
                return i13;
            }
        }
        return 0;
    }

    private static int a(int i11, ByteBuffer byteBuffer) {
        switch (i11) {
            case 5:
            case 6:
            case 18:
                return k.b(byteBuffer);
            case 7:
            case 8:
                return f7.a(byteBuffer);
            case 9:
                int iD = tf.d(xp.a(byteBuffer, byteBuffer.position()));
                if (iD != -1) {
                    return iD;
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
                int iA = k.a(byteBuffer);
                if (iA == -1) {
                    return 0;
                }
                return k.a(byteBuffer, iA) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return n.a(byteBuffer);
        }
    }

    private int a(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        int i11 = xp.f24372a;
        if (i11 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return (i11 == 30 && xp.f24375d.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    private static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11) {
        return audioTrack.write(byteBuffer, i11, 1);
    }

    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11, long j11) {
        if (xp.f24372a >= 26) {
            return audioTrack.write(byteBuffer, i11, 1, j11 * 1000);
        }
        if (this.f22267x == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.f22267x = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.f22267x.putInt(1431633921);
        }
        if (this.f22268y == 0) {
            this.f22267x.putInt(4, i11);
            this.f22267x.putLong(8, j11 * 1000);
            this.f22267x.position(0);
            this.f22268y = i11;
        }
        int iRemaining = this.f22267x.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.f22267x, iRemaining, 1);
            if (iWrite < 0) {
                this.f22268y = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iA = a(audioTrack, byteBuffer, i11);
        if (iA < 0) {
            this.f22268y = 0;
            return iA;
        }
        this.f22268y -= iA;
        return iA;
    }

    private static Pair a(f9 f9Var, n1 n1Var) {
        if (n1Var == null) {
            return null;
        }
        int iB = Cif.b((String) b1.a((Object) f9Var.f18900m), f9Var.f18897j);
        int iA = 6;
        if (iB != 5 && iB != 6 && iB != 18 && iB != 17 && iB != 7 && iB != 8 && iB != 14) {
            return null;
        }
        if (iB == 18 && !n1Var.a(18)) {
            iB = 6;
        } else if (iB == 8 && !n1Var.a(8)) {
            iB = 7;
        }
        if (!n1Var.a(iB)) {
            return null;
        }
        if (iB != 18) {
            iA = f9Var.f18913z;
            if (iA > n1Var.c()) {
                return null;
            }
        } else if (xp.f24372a >= 29 && (iA = a(18, f9Var.A)) == 0) {
            pc.d("DefaultAudioSink", "E-AC3 JOC encoding supported but no channel count supported");
            return null;
        }
        int iC = c(iA);
        if (iC == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iB), Integer.valueOf(iC));
    }

    private void a(long j11) {
        ph phVarA = z() ? this.f22245b.a(n()) : ph.f21775d;
        boolean zA = z() ? this.f22245b.a(p()) : false;
        this.f22253j.add(new f(phVarA, zA, Math.max(0L, j11), this.f22261r.b(r()), null));
        y();
        r1.c cVar = this.f22259p;
        if (cVar != null) {
            cVar.a(zA);
        }
    }

    private static void a(AudioTrack audioTrack, float f11) {
        audioTrack.setVolume(f11);
    }

    private void a(ph phVar, boolean z11) {
        f fVarO = o();
        if (phVar.equals(fVarO.f22284a) && z11 == fVarO.f22285b) {
            return;
        }
        f fVar = new f(phVar, z11, C.TIME_UNSET, C.TIME_UNSET, null);
        if (t()) {
            this.f22264u = fVar;
        } else {
            this.f22265v = fVar;
        }
    }

    private void a(ByteBuffer byteBuffer, long j11) throws Exception {
        int iA;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.M;
            if (byteBuffer2 != null) {
                b1.a(byteBuffer2 == byteBuffer);
            } else {
                this.M = byteBuffer;
                if (xp.f24372a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.N;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.N = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.N, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.O = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (xp.f24372a < 21) {
                int iB = this.f22252i.b(this.B);
                if (iB > 0) {
                    iA = this.f22262s.write(this.N, this.O, Math.min(iRemaining2, iB));
                    if (iA > 0) {
                        this.O += iA;
                        byteBuffer.position(byteBuffer.position() + iA);
                    }
                } else {
                    iA = 0;
                }
            } else if (this.W) {
                b1.b(j11 != C.TIME_UNSET);
                iA = a(this.f22262s, byteBuffer, iRemaining2, j11);
            } else {
                iA = a(this.f22262s, byteBuffer, iRemaining2);
            }
            this.X = SystemClock.elapsedRealtime();
            if (iA < 0) {
                boolean zE = e(iA);
                if (zE) {
                    u();
                }
                r1.e eVar = new r1.e(iA, this.f22261r.f22272a, zE);
                r1.c cVar = this.f22259p;
                if (cVar != null) {
                    cVar.a(eVar);
                }
                if (eVar.f22020b) {
                    throw eVar;
                }
                this.f22258o.a(eVar);
                return;
            }
            this.f22258o.a();
            if (a(this.f22262s)) {
                long j12 = this.C;
                if (j12 > 0) {
                    this.Z = false;
                }
                if (this.S && this.f22259p != null && iA < iRemaining2 && !this.Z) {
                    this.f22259p.b(this.f22252i.c(j12));
                }
            }
            int i11 = this.f22261r.f22274c;
            if (i11 == 0) {
                this.B += (long) iA;
            }
            if (iA == iRemaining2) {
                if (i11 != 0) {
                    b1.b(byteBuffer == this.K);
                    this.C += (long) (this.D * this.L);
                }
                this.M = null;
            }
        }
    }

    private static boolean a(AudioTrack audioTrack) {
        return xp.f24372a >= 29 && audioTrack.isOffloadedPlayback();
    }

    private boolean a(f9 f9Var, l1 l1Var) {
        int iB;
        int iA;
        int iA2;
        if (xp.f24372a < 29 || this.f22255l == 0 || (iB = Cif.b((String) b1.a((Object) f9Var.f18900m), f9Var.f18897j)) == 0 || (iA = xp.a(f9Var.f18913z)) == 0 || (iA2 = a(b(f9Var.A, iA, iB), l1Var.a())) == 0) {
            return false;
        }
        if (iA2 == 1) {
            return ((f9Var.C != 0 || f9Var.D != 0) && (this.f22255l == 1)) ? false : true;
        }
        if (iA2 == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    private long b(long j11) {
        while (!this.f22253j.isEmpty() && j11 >= ((f) this.f22253j.getFirst()).f22287d) {
            this.f22265v = (f) this.f22253j.remove();
        }
        f fVar = this.f22265v;
        long j12 = j11 - fVar.f22287d;
        if (fVar.f22284a.equals(ph.f21775d)) {
            return this.f22265v.f22286c + j12;
        }
        if (this.f22253j.isEmpty()) {
            return this.f22265v.f22286c + this.f22245b.a(j12);
        }
        f fVar2 = (f) this.f22253j.getFirst();
        return fVar2.f22286c - xp.a(fVar2.f22287d - j11, this.f22265v.f22284a.f21777a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AudioFormat b(int i11, int i12, int i13) {
        return new AudioFormat.Builder().setSampleRate(i11).setChannelMask(i12).setEncoding(i13).build();
    }

    private void b(AudioTrack audioTrack) {
        if (this.f22256m == null) {
            this.f22256m = new i();
        }
        this.f22256m.a(audioTrack);
    }

    private static void b(AudioTrack audioTrack, float f11) {
        audioTrack.setStereoVolume(f11, f11);
    }

    private void b(ph phVar) {
        if (t()) {
            try {
                this.f22262s.setPlaybackParams(f4.e0.a().allowDefaults().setSpeed(phVar.f21777a).setPitch(phVar.f21778b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e11) {
                pc.c("DefaultAudioSink", "Failed to set playback params", e11);
            }
            phVar = new ph(this.f22262s.getPlaybackParams().getSpeed(), this.f22262s.getPlaybackParams().getPitch());
            this.f22252i.a(phVar.f21777a);
        }
        this.f22266w = phVar;
    }

    private static boolean b(f9 f9Var, n1 n1Var) {
        return a(f9Var, n1Var) != null;
    }

    private static int c(int i11) {
        int i12 = xp.f24372a;
        if (i12 <= 28) {
            if (i11 == 7) {
                i11 = 8;
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                i11 = 6;
            }
        }
        if (i12 <= 26 && "fugu".equals(xp.f24373b) && i11 == 1) {
            i11 = 2;
        }
        return xp.a(i11);
    }

    private long c(long j11) {
        return j11 + this.f22261r.b(this.f22245b.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(int i11) {
        switch (i11) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return DefaultOggSeeker.MATCH_BYTE_RANGE;
            case 11:
                return 16000;
            case 12:
                return PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
        }
    }

    private void d(long j11) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.I.length;
        int i11 = length;
        while (i11 >= 0) {
            if (i11 > 0) {
                byteBuffer = this.J[i11 - 1];
            } else {
                byteBuffer = this.K;
                if (byteBuffer == null) {
                    byteBuffer = p1.f21632a;
                }
            }
            if (i11 == length) {
                a(byteBuffer, j11);
            } else {
                p1 p1Var = this.I[i11];
                if (i11 > this.P) {
                    p1Var.a(byteBuffer);
                }
                ByteBuffer byteBufferD = p1Var.d();
                this.J[i11] = byteBufferD;
                if (byteBufferD.hasRemaining()) {
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

    private static boolean e(int i11) {
        return (xp.f24372a >= 24 && i11 == -6) || i11 == -32;
    }

    private boolean f(int i11) {
        return this.f22246c && xp.f(i11);
    }

    private AudioTrack k() throws r1.b {
        try {
            return ((c) b1.a(this.f22261r)).a(this.W, this.f22263t, this.U);
        } catch (r1.b e11) {
            u();
            r1.c cVar = this.f22259p;
            if (cVar != null) {
                cVar.a(e11);
            }
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
    private boolean l() {
        /*
            r9 = this;
            int r0 = r9.P
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto Lb
            r9.P = r2
        L9:
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            int r4 = r9.P
            com.applovin.impl.p1[] r5 = r9.I
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.e()
        L1f:
            r9.d(r7)
            boolean r0 = r4.c()
            if (r0 != 0) goto L29
            return r2
        L29:
            int r0 = r9.P
            int r0 = r0 + r1
            r9.P = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.M
            if (r0 == 0) goto L3b
            r9.a(r0, r7)
            java.nio.ByteBuffer r0 = r9.M
            if (r0 == 0) goto L3b
            return r2
        L3b:
            r9.P = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.s5.l():boolean");
    }

    private void m() {
        int i11 = 0;
        while (true) {
            p1[] p1VarArr = this.I;
            if (i11 >= p1VarArr.length) {
                return;
            }
            p1 p1Var = p1VarArr[i11];
            p1Var.b();
            this.J[i11] = p1Var.d();
            i11++;
        }
    }

    private ph n() {
        return o().f22284a;
    }

    private f o() {
        f fVar = this.f22264u;
        if (fVar != null) {
            return fVar;
        }
        return !this.f22253j.isEmpty() ? (f) this.f22253j.getLast() : this.f22265v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long q() {
        c cVar = this.f22261r;
        return cVar.f22274c == 0 ? this.f22269z / ((long) cVar.f22273b) : this.A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long r() {
        c cVar = this.f22261r;
        return cVar.f22274c == 0 ? this.B / ((long) cVar.f22275d) : this.C;
    }

    private void s() throws r1.b {
        this.f22251h.block();
        AudioTrack audioTrackK = k();
        this.f22262s = audioTrackK;
        if (a(audioTrackK)) {
            b(this.f22262s);
            if (this.f22255l != 3) {
                AudioTrack audioTrack = this.f22262s;
                f9 f9Var = this.f22261r.f22272a;
                audioTrack.setOffloadDelayPadding(f9Var.C, f9Var.D);
            }
        }
        this.U = this.f22262s.getAudioSessionId();
        u1 u1Var = this.f22252i;
        AudioTrack audioTrack2 = this.f22262s;
        c cVar = this.f22261r;
        u1Var.a(audioTrack2, cVar.f22274c == 2, cVar.f22278g, cVar.f22275d, cVar.f22279h);
        x();
        int i11 = this.V.f23726a;
        if (i11 != 0) {
            this.f22262s.attachAuxEffect(i11);
            this.f22262s.setAuxEffectSendLevel(this.V.f23727b);
        }
        this.F = true;
    }

    private boolean t() {
        return this.f22262s != null;
    }

    private void u() {
        if (this.f22261r.b()) {
            this.Y = true;
        }
    }

    private void v() {
        if (this.R) {
            return;
        }
        this.R = true;
        this.f22252i.d(r());
        this.f22262s.stop();
        this.f22268y = 0;
    }

    private void w() {
        this.f22269z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.Z = false;
        this.D = 0;
        this.f22265v = new f(n(), p(), 0L, 0L, null);
        this.G = 0L;
        this.f22264u = null;
        this.f22253j.clear();
        this.K = null;
        this.L = 0;
        this.M = null;
        this.R = false;
        this.Q = false;
        this.P = -1;
        this.f22267x = null;
        this.f22268y = 0;
        this.f22248e.k();
        m();
    }

    private void x() {
        if (t()) {
            if (xp.f24372a >= 21) {
                a(this.f22262s, this.H);
            } else {
                b(this.f22262s, this.H);
            }
        }
    }

    private void y() {
        p1[] p1VarArr = this.f22261r.f22280i;
        ArrayList arrayList = new ArrayList();
        for (p1 p1Var : p1VarArr) {
            if (p1Var.f()) {
                arrayList.add(p1Var);
            } else {
                p1Var.b();
            }
        }
        int size = arrayList.size();
        this.I = (p1[]) arrayList.toArray(new p1[size]);
        this.J = new ByteBuffer[size];
        m();
    }

    private boolean z() {
        return (this.W || !MimeTypes.AUDIO_RAW.equals(this.f22261r.f22272a.f18900m) || f(this.f22261r.f22272a.B)) ? false : true;
    }

    @Override // com.applovin.impl.r1
    public long a(boolean z11) {
        if (!t() || this.F) {
            return Long.MIN_VALUE;
        }
        return c(b(Math.min(this.f22252i.a(z11), this.f22261r.b(r()))));
    }

    @Override // com.applovin.impl.r1
    public ph a() {
        return this.f22254k ? this.f22266w : n();
    }

    @Override // com.applovin.impl.r1
    public void a(float f11) {
        if (this.H != f11) {
            this.H = f11;
            x();
        }
    }

    @Override // com.applovin.impl.r1
    public void a(int i11) {
        if (this.U != i11) {
            this.U = i11;
            this.T = i11 != 0;
            b();
        }
    }

    @Override // com.applovin.impl.r1
    public void a(f9 f9Var, int i11, int[] iArr) throws r1.a {
        p1[] p1VarArr;
        int iB;
        int iIntValue;
        int iB2;
        int i12;
        int i13;
        int i14;
        int[] iArr2;
        if (MimeTypes.AUDIO_RAW.equals(f9Var.f18900m)) {
            b1.a(xp.g(f9Var.B));
            int iB3 = xp.b(f9Var.B, f9Var.f18913z);
            p1[] p1VarArr2 = f(f9Var.B) ? this.f22250g : this.f22249f;
            this.f22248e.a(f9Var.C, f9Var.D);
            if (xp.f24372a < 21 && f9Var.f18913z == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i15 = 0; i15 < 6; i15++) {
                    iArr2[i15] = i15;
                }
            } else {
                iArr2 = iArr;
            }
            this.f22247d.a(iArr2);
            p1.a aVar = new p1.a(f9Var.A, f9Var.f18913z, f9Var.B);
            for (p1 p1Var : p1VarArr2) {
                try {
                    p1.a aVarA = p1Var.a(aVar);
                    if (p1Var.f()) {
                        aVar = aVarA;
                    }
                } catch (p1.b e11) {
                    throw new r1.a(e11, f9Var);
                }
            }
            int i16 = aVar.f21636c;
            i13 = aVar.f21634a;
            iIntValue = xp.a(aVar.f21635b);
            p1VarArr = p1VarArr2;
            iB2 = i16;
            i14 = iB3;
            iB = xp.b(i16, aVar.f21635b);
            i12 = 0;
        } else {
            p1VarArr = new p1[0];
            int i17 = f9Var.A;
            iB = -1;
            if (a(f9Var, this.f22263t)) {
                iB2 = Cif.b((String) b1.a((Object) f9Var.f18900m), f9Var.f18897j);
                iIntValue = xp.a(f9Var.f18913z);
                i12 = 1;
            } else {
                Pair pairA = a(f9Var, this.f22244a);
                if (pairA == null) {
                    throw new r1.a("Unable to configure passthrough for: " + f9Var, f9Var);
                }
                int iIntValue2 = ((Integer) pairA.first).intValue();
                iIntValue = ((Integer) pairA.second).intValue();
                iB2 = iIntValue2;
                i12 = 2;
            }
            i13 = i17;
            i14 = -1;
        }
        if (iB2 == 0) {
            throw new r1.a("Invalid output encoding (mode=" + i12 + ") for: " + f9Var, f9Var);
        }
        if (iIntValue == 0) {
            throw new r1.a("Invalid output channel config (mode=" + i12 + ") for: " + f9Var, f9Var);
        }
        this.Y = false;
        c cVar = new c(f9Var, i14, i12, iB, i13, iIntValue, iB2, i11, this.f22254k, p1VarArr);
        if (t()) {
            this.f22260q = cVar;
        } else {
            this.f22261r = cVar;
        }
    }

    @Override // com.applovin.impl.r1
    public void a(l1 l1Var) {
        if (this.f22263t.equals(l1Var)) {
            return;
        }
        this.f22263t = l1Var;
        if (this.W) {
            return;
        }
        b();
    }

    @Override // com.applovin.impl.r1
    public void a(ph phVar) {
        ph phVar2 = new ph(xp.a(phVar.f21777a, 0.1f, 8.0f), xp.a(phVar.f21778b, 0.1f, 8.0f));
        if (!this.f22254k || xp.f24372a < 23) {
            a(phVar2, p());
        } else {
            b(phVar2);
        }
    }

    @Override // com.applovin.impl.r1
    public void a(r1.c cVar) {
        this.f22259p = cVar;
    }

    @Override // com.applovin.impl.r1
    public void a(v1 v1Var) {
        if (this.V.equals(v1Var)) {
            return;
        }
        int i11 = v1Var.f23726a;
        float f11 = v1Var.f23727b;
        AudioTrack audioTrack = this.f22262s;
        if (audioTrack != null) {
            if (this.V.f23726a != i11) {
                audioTrack.attachAuxEffect(i11);
            }
            if (i11 != 0) {
                this.f22262s.setAuxEffectSendLevel(f11);
            }
        }
        this.V = v1Var;
    }

    @Override // com.applovin.impl.r1
    public boolean a(f9 f9Var) {
        return b(f9Var) != 0;
    }

    @Override // com.applovin.impl.r1
    public boolean a(ByteBuffer byteBuffer, long j11, int i11) throws Exception {
        ByteBuffer byteBuffer2 = this.K;
        b1.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f22260q != null) {
            if (!l()) {
                return false;
            }
            if (this.f22260q.a(this.f22261r)) {
                this.f22261r = this.f22260q;
                this.f22260q = null;
                if (a(this.f22262s) && this.f22255l != 3) {
                    this.f22262s.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.f22262s;
                    f9 f9Var = this.f22261r.f22272a;
                    audioTrack.setOffloadDelayPadding(f9Var.C, f9Var.D);
                    this.Z = true;
                }
            } else {
                v();
                if (g()) {
                    return false;
                }
                b();
            }
            a(j11);
        }
        if (!t()) {
            try {
                s();
            } catch (r1.b e11) {
                if (e11.f22015b) {
                    throw e11;
                }
                this.f22257n.a(e11);
                return false;
            }
        }
        this.f22257n.a();
        if (this.F) {
            this.G = Math.max(0L, j11);
            this.E = false;
            this.F = false;
            if (this.f22254k && xp.f24372a >= 23) {
                b(this.f22266w);
            }
            a(j11);
            if (this.S) {
                j();
            }
        }
        if (!this.f22252i.g(r())) {
            return false;
        }
        if (this.K == null) {
            b1.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            c cVar = this.f22261r;
            if (cVar.f22274c != 0 && this.D == 0) {
                int iA = a(cVar.f22278g, byteBuffer);
                this.D = iA;
                if (iA == 0) {
                    return true;
                }
            }
            if (this.f22264u != null) {
                if (!l()) {
                    return false;
                }
                a(j11);
                this.f22264u = null;
            }
            long jD = this.G + this.f22261r.d(q() - this.f22248e.j());
            if (!this.E && Math.abs(jD - j11) > 200000) {
                this.f22259p.a(new r1.d(j11, jD));
                this.E = true;
            }
            if (this.E) {
                if (!l()) {
                    return false;
                }
                long j12 = j11 - jD;
                this.G += j12;
                this.E = false;
                a(j11);
                r1.c cVar2 = this.f22259p;
                if (cVar2 != null && j12 != 0) {
                    cVar2.b();
                }
            }
            if (this.f22261r.f22274c == 0) {
                this.f22269z += (long) byteBuffer.remaining();
            } else {
                this.A += (long) (this.D * i11);
            }
            this.K = byteBuffer;
            this.L = i11;
        }
        d(j11);
        if (!this.K.hasRemaining()) {
            this.K = null;
            this.L = 0;
            return true;
        }
        if (!this.f22252i.f(r())) {
            return false;
        }
        pc.d("DefaultAudioSink", "Resetting stalled audio track");
        b();
        return true;
    }

    @Override // com.applovin.impl.r1
    public int b(f9 f9Var) {
        if (!MimeTypes.AUDIO_RAW.equals(f9Var.f18900m)) {
            return ((this.Y || !a(f9Var, this.f22263t)) && !b(f9Var, this.f22244a)) ? 0 : 2;
        }
        if (xp.g(f9Var.B)) {
            int i11 = f9Var.B;
            return (i11 == 2 || (this.f22246c && i11 == 4)) ? 2 : 1;
        }
        pc.d("DefaultAudioSink", "Invalid PCM encoding: " + f9Var.B);
        return 0;
    }

    @Override // com.applovin.impl.r1
    public void b() {
        if (t()) {
            w();
            if (this.f22252i.d()) {
                this.f22262s.pause();
            }
            if (a(this.f22262s)) {
                ((i) b1.a(this.f22256m)).b(this.f22262s);
            }
            AudioTrack audioTrack = this.f22262s;
            this.f22262s = null;
            if (xp.f24372a < 21 && !this.T) {
                this.U = 0;
            }
            c cVar = this.f22260q;
            if (cVar != null) {
                this.f22261r = cVar;
                this.f22260q = null;
            }
            this.f22252i.g();
            this.f22251h.close();
            new a("ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
        this.f22258o.a();
        this.f22257n.a();
    }

    @Override // com.applovin.impl.r1
    public void b(boolean z11) {
        a(n(), z11);
    }

    @Override // com.applovin.impl.r1
    public boolean c() {
        return !t() || (this.Q && !g());
    }

    @Override // com.applovin.impl.r1
    public void d() {
        if (this.W) {
            this.W = false;
            b();
        }
    }

    @Override // com.applovin.impl.r1
    public void e() {
        b1.b(xp.f24372a >= 21);
        b1.b(this.T);
        if (this.W) {
            return;
        }
        this.W = true;
        b();
    }

    @Override // com.applovin.impl.r1
    public void f() {
        if (!this.Q && t() && l()) {
            v();
            this.Q = true;
        }
    }

    @Override // com.applovin.impl.r1
    public boolean g() {
        return t() && this.f22252i.e(r());
    }

    @Override // com.applovin.impl.r1
    public void h() {
        if (xp.f24372a < 25) {
            b();
            return;
        }
        this.f22258o.a();
        this.f22257n.a();
        if (t()) {
            w();
            if (this.f22252i.d()) {
                this.f22262s.pause();
            }
            this.f22262s.flush();
            this.f22252i.g();
            u1 u1Var = this.f22252i;
            AudioTrack audioTrack = this.f22262s;
            c cVar = this.f22261r;
            u1Var.a(audioTrack, cVar.f22274c == 2, cVar.f22278g, cVar.f22275d, cVar.f22279h);
            this.F = true;
        }
    }

    @Override // com.applovin.impl.r1
    public void i() {
        this.E = true;
    }

    @Override // com.applovin.impl.r1
    public void j() {
        this.S = true;
        if (t()) {
            this.f22252i.i();
            this.f22262s.play();
        }
    }

    public boolean p() {
        return o().f22285b;
    }

    @Override // com.applovin.impl.r1
    public void pause() {
        this.S = false;
        if (t() && this.f22252i.f()) {
            this.f22262s.pause();
        }
    }

    @Override // com.applovin.impl.r1
    public void reset() {
        b();
        for (p1 p1Var : this.f22249f) {
            p1Var.reset();
        }
        for (p1 p1Var2 : this.f22250g) {
            p1Var2.reset();
        }
        this.S = false;
        this.Y = false;
    }
}
