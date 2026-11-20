package r4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.x2;
import androidx.media3.extractor.text.SubtitleDecoderException;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Objects;
import o5.l;
import o5.o;
import o5.p;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends m implements Handler.Callback {

    @Nullable
    public p A;

    @Nullable
    public p B;
    public int C;

    @Nullable
    public final Handler D;
    public final h E;
    public final t1 F;
    public boolean G;
    public boolean H;

    @Nullable
    public y I;
    public long J;
    public long K;
    public long L;
    public boolean M;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final o5.b f75122s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DecoderInputBuffer f75123t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a f75124u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g f75125v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f75126w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f75127x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public l f75128y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public o f75129z;

    public i(h hVar, @Nullable Looper looper) {
        this(hVar, looper, g.f75120a);
    }

    public i(h hVar, @Nullable Looper looper, g gVar) {
        super(3);
        this.E = (h) z3.a.e(hVar);
        this.D = looper == null ? null : u0.z(looper, this);
        this.f75125v = gVar;
        this.f75122s = new o5.b();
        this.f75123t = new DecoderInputBuffer(1);
        this.F = new t1();
        this.L = C.TIME_UNSET;
        this.J = C.TIME_UNSET;
        this.K = C.TIME_UNSET;
        this.M = true;
    }

    private long R(long j11) {
        z3.a.g(j11 != C.TIME_UNSET);
        z3.a.g(this.J != C.TIME_UNSET);
        return j11 - this.J;
    }

    public static boolean V(y yVar) {
        return Objects.equals(yVar.f9501m, "application/x-media3-cues");
    }

    @Override // androidx.media3.exoplayer.m
    public void C(long j11, boolean z11) {
        this.K = j11;
        a aVar = this.f75124u;
        if (aVar != null) {
            aVar.clear();
        }
        O();
        this.G = false;
        this.H = false;
        this.L = C.TIME_UNSET;
        y yVar = this.I;
        if (yVar == null || V(yVar)) {
            return;
        }
        if (this.f75127x != 0) {
            b0();
        } else {
            X();
            ((l) z3.a.e(this.f75128y)).flush();
        }
    }

    @Override // androidx.media3.exoplayer.m
    public void I(y[] yVarArr, long j11, long j12, androidx.media3.exoplayer.source.l.b bVar) {
        this.J = j12;
        y yVar = yVarArr[0];
        this.I = yVar;
        if (V(yVar)) {
            this.f75124u = this.I.F == 1 ? new e() : new f();
            return;
        }
        N();
        if (this.f75128y != null) {
            this.f75127x = 1;
        } else {
            T();
        }
    }

    public final void N() {
        z3.a.h(this.M || Objects.equals(this.I.f9501m, MimeTypes.APPLICATION_CEA608) || Objects.equals(this.I.f9501m, MimeTypes.APPLICATION_MP4CEA608) || Objects.equals(this.I.f9501m, MimeTypes.APPLICATION_CEA708), "Legacy decoding is disabled, can't handle " + this.I.f9501m + " samples (expected application/x-media3-cues).");
    }

    public final void O() {
        d0(new y3.b(ImmutableList.of(), R(this.K)));
    }

    public final long P(long j11) {
        int nextEventTimeIndex = this.A.getNextEventTimeIndex(j11);
        if (nextEventTimeIndex == 0 || this.A.getEventTimeCount() == 0) {
            return this.A.timeUs;
        }
        if (nextEventTimeIndex != -1) {
            return this.A.getEventTime(nextEventTimeIndex - 1);
        }
        p pVar = this.A;
        return pVar.getEventTime(pVar.getEventTimeCount() - 1);
    }

    public final long Q() {
        if (this.C == -1) {
            return Long.MAX_VALUE;
        }
        z3.a.e(this.A);
        if (this.C >= this.A.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.A.getEventTime(this.C);
    }

    public final void S(SubtitleDecoderException subtitleDecoderException) {
        z3.o.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.I, subtitleDecoderException);
        O();
        b0();
    }

    public final void T() {
        this.f75126w = true;
        this.f75128y = this.f75125v.b((y) z3.a.e(this.I));
    }

    public final void U(y3.b bVar) {
        this.E.onCues(bVar.f81147a);
        this.E.onCues(bVar);
    }

    public final boolean W(long j11) {
        if (this.G || K(this.F, this.f75123t, 0) != -4) {
            return false;
        }
        if (this.f75123t.isEndOfStream()) {
            this.G = true;
            return false;
        }
        this.f75123t.c();
        ByteBuffer byteBuffer = (ByteBuffer) z3.a.e(this.f75123t.f9780c);
        o5.e eVarA = this.f75122s.a(this.f75123t.f9782f, byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        this.f75123t.clear();
        return this.f75124u.b(eVarA, j11);
    }

    public final void X() {
        this.f75129z = null;
        this.C = -1;
        p pVar = this.A;
        if (pVar != null) {
            pVar.release();
            this.A = null;
        }
        p pVar2 = this.B;
        if (pVar2 != null) {
            pVar2.release();
            this.B = null;
        }
    }

    public final void Y() {
        X();
        ((l) z3.a.e(this.f75128y)).release();
        this.f75128y = null;
        this.f75127x = 0;
    }

    public final void Z(long j11) {
        boolean zW = W(j11);
        long jD = this.f75124u.d(this.K);
        if (jD == Long.MIN_VALUE && this.G && !zW) {
            this.H = true;
        }
        if ((jD != Long.MIN_VALUE && jD <= j11) || zW) {
            ImmutableList<y3.a> immutableListA = this.f75124u.a(j11);
            long jC = this.f75124u.c(j11);
            d0(new y3.b(immutableListA, R(jC)));
            this.f75124u.e(jC);
        }
        this.K = j11;
    }

    @Override // androidx.media3.exoplayer.y2
    public int a(y yVar) {
        if (V(yVar) || this.f75125v.a(yVar)) {
            return x2.a(yVar.I == 0 ? 4 : 2);
        }
        return f0.r(yVar.f9501m) ? x2.a(1) : x2.a(0);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x008c  */
    public final void a0(long j11) throws DecoderException {
        boolean z11;
        this.K = j11;
        if (this.B == null) {
            ((l) z3.a.e(this.f75128y)).setPositionUs(j11);
            try {
                this.B = ((l) z3.a.e(this.f75128y)).dequeueOutputBuffer();
            } catch (SubtitleDecoderException e11) {
                S(e11);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.A != null) {
            long jQ = Q();
            z11 = false;
            while (jQ <= j11) {
                this.C++;
                jQ = Q();
                z11 = true;
            }
        } else {
            z11 = false;
        }
        p pVar = this.B;
        if (pVar != null) {
            if (!pVar.isEndOfStream()) {
                if (pVar.timeUs <= j11) {
                    p pVar2 = this.A;
                    if (pVar2 != null) {
                        pVar2.release();
                    }
                    this.C = pVar.getNextEventTimeIndex(j11);
                    this.A = pVar;
                    this.B = null;
                }
                z3.a.e(this.A);
                d0(new y3.b(this.A.getCues(j11), R(P(j11))));
            } else if (!z11 && Q() == Long.MAX_VALUE) {
                if (this.f75127x == 2) {
                    b0();
                } else {
                    X();
                    this.H = true;
                }
            }
            if (z11) {
                z3.a.e(this.A);
                d0(new y3.b(this.A.getCues(j11), R(P(j11))));
            }
        } else if (z11) {
            z3.a.e(this.A);
            d0(new y3.b(this.A.getCues(j11), R(P(j11))));
        }
        if (this.f75127x == 2) {
            return;
        }
        while (!this.G) {
            try {
                o oVarDequeueInputBuffer = this.f75129z;
                if (oVarDequeueInputBuffer == null) {
                    oVarDequeueInputBuffer = ((l) z3.a.e(this.f75128y)).dequeueInputBuffer();
                    if (oVarDequeueInputBuffer == null) {
                        return;
                    } else {
                        this.f75129z = oVarDequeueInputBuffer;
                    }
                }
                if (this.f75127x == 1) {
                    oVarDequeueInputBuffer.setFlags(4);
                    ((l) z3.a.e(this.f75128y)).queueInputBuffer(oVarDequeueInputBuffer);
                    this.f75129z = null;
                    this.f75127x = 2;
                    return;
                }
                int iK = K(this.F, oVarDequeueInputBuffer, 0);
                if (iK == -4) {
                    if (oVarDequeueInputBuffer.isEndOfStream()) {
                        this.G = true;
                        this.f75126w = false;
                    } else {
                        y yVar = this.F.f11382b;
                        if (yVar == null) {
                            return;
                        }
                        oVarDequeueInputBuffer.f72348j = yVar.f9505q;
                        oVarDequeueInputBuffer.c();
                        this.f75126w &= !oVarDequeueInputBuffer.isKeyFrame();
                    }
                    if (!this.f75126w) {
                        if (oVarDequeueInputBuffer.f9782f < v()) {
                            oVarDequeueInputBuffer.addFlag(Integer.MIN_VALUE);
                        }
                        ((l) z3.a.e(this.f75128y)).queueInputBuffer(oVarDequeueInputBuffer);
                        this.f75129z = null;
                    }
                } else if (iK == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e12) {
                S(e12);
                return;
            }
        }
    }

    public final void b0() {
        Y();
        T();
    }

    public void c0(long j11) {
        z3.a.g(isCurrentStreamFinal());
        this.L = j11;
    }

    public final void d0(y3.b bVar) {
        Handler handler = this.D;
        if (handler != null) {
            handler.obtainMessage(0, bVar).sendToTarget();
        } else {
            U(bVar);
        }
    }

    @Override // androidx.media3.exoplayer.w2, androidx.media3.exoplayer.y2
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        U((y3.b) message.obj);
        return true;
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isEnded() {
        return this.H;
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isReady() {
        return true;
    }

    @Override // androidx.media3.exoplayer.w2
    public void render(long j11, long j12) throws DecoderException {
        if (isCurrentStreamFinal()) {
            long j13 = this.L;
            if (j13 != C.TIME_UNSET && j11 >= j13) {
                X();
                this.H = true;
            }
        }
        if (this.H) {
            return;
        }
        if (V((y) z3.a.e(this.I))) {
            z3.a.e(this.f75124u);
            Z(j11);
        } else {
            N();
            a0(j11);
        }
    }

    @Override // androidx.media3.exoplayer.m
    public void z() {
        this.I = null;
        this.L = C.TIME_UNSET;
        O();
        this.J = C.TIME_UNSET;
        this.K = C.TIME_UNSET;
        if (this.f75128y != null) {
            Y();
        }
    }
}
