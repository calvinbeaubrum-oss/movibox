package vh;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.android.exoplayer2.x2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p extends com.google.android.exoplayer2.e implements Handler.Callback {

    @Nullable
    public n A;
    public int B;
    public long C;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public final Handler f78880o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final o f78881p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final k f78882q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final n1 f78883r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f78884s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f78885t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f78886u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f78887v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public m1 f78888w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public j f78889x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public m f78890y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public n f78891z;

    public p(o oVar, @Nullable Looper looper) {
        this(oVar, looper, k.f78865a);
    }

    public p(o oVar, @Nullable Looper looper, k kVar) {
        super(3);
        this.f78881p = (o) com.google.android.exoplayer2.util.a.e(oVar);
        this.f78880o = looper == null ? null : o0.v(looper, this);
        this.f78882q = kVar;
        this.f78883r = new n1();
        this.C = C.TIME_UNSET;
    }

    public final long A() {
        if (this.B == -1) {
            return Long.MAX_VALUE;
        }
        com.google.android.exoplayer2.util.a.e(this.f78891z);
        if (this.B >= this.f78891z.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.f78891z.getEventTime(this.B);
    }

    public final void B(SubtitleDecoderException subtitleDecoderException) {
        s.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f78888w, subtitleDecoderException);
        z();
        G();
    }

    public final void C() {
        this.f78886u = true;
        this.f78889x = this.f78882q.b((m1) com.google.android.exoplayer2.util.a.e(this.f78888w));
    }

    public final void D(List<b> list) {
        this.f78881p.onCues(list);
        this.f78881p.onCues(new f(list));
    }

    public final void E() {
        this.f78890y = null;
        this.B = -1;
        n nVar = this.f78891z;
        if (nVar != null) {
            nVar.m();
            this.f78891z = null;
        }
        n nVar2 = this.A;
        if (nVar2 != null) {
            nVar2.m();
            this.A = null;
        }
    }

    public final void F() {
        E();
        ((j) com.google.android.exoplayer2.util.a.e(this.f78889x)).release();
        this.f78889x = null;
        this.f78887v = 0;
    }

    public final void G() {
        F();
        C();
    }

    public void H(long j11) {
        com.google.android.exoplayer2.util.a.g(isCurrentStreamFinal());
        this.C = j11;
    }

    public final void I(List<b> list) {
        Handler handler = this.f78880o;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            D(list);
        }
    }

    @Override // com.google.android.exoplayer2.y2
    public int a(m1 m1Var) {
        if (this.f78882q.a(m1Var)) {
            return x2.a(m1Var.F == 0 ? 4 : 2);
        }
        return w.r(m1Var.f33445m) ? x2.a(1) : x2.a(0);
    }

    @Override // com.google.android.exoplayer2.w2, com.google.android.exoplayer2.y2
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        D((List) message.obj);
        return true;
    }

    @Override // com.google.android.exoplayer2.w2
    public boolean isEnded() {
        return this.f78885t;
    }

    @Override // com.google.android.exoplayer2.w2
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.e
    public void p() {
        this.f78888w = null;
        this.C = C.TIME_UNSET;
        z();
        F();
    }

    @Override // com.google.android.exoplayer2.e
    public void r(long j11, boolean z11) {
        z();
        this.f78884s = false;
        this.f78885t = false;
        this.C = C.TIME_UNSET;
        if (this.f78887v != 0) {
            G();
        } else {
            E();
            ((j) com.google.android.exoplayer2.util.a.e(this.f78889x)).flush();
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00a9  */
    @Override // com.google.android.exoplayer2.w2
    public void render(long j11, long j12) throws DecoderException {
        boolean z11;
        if (isCurrentStreamFinal()) {
            long j13 = this.C;
            if (j13 != C.TIME_UNSET && j11 >= j13) {
                E();
                this.f78885t = true;
            }
        }
        if (this.f78885t) {
            return;
        }
        if (this.A == null) {
            ((j) com.google.android.exoplayer2.util.a.e(this.f78889x)).setPositionUs(j11);
            try {
                this.A = ((j) com.google.android.exoplayer2.util.a.e(this.f78889x)).dequeueOutputBuffer();
            } catch (SubtitleDecoderException e11) {
                B(e11);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.f78891z != null) {
            long jA = A();
            z11 = false;
            while (jA <= j11) {
                this.B++;
                jA = A();
                z11 = true;
            }
        } else {
            z11 = false;
        }
        n nVar = this.A;
        if (nVar != null) {
            if (!nVar.i()) {
                if (nVar.f33074b <= j11) {
                    n nVar2 = this.f78891z;
                    if (nVar2 != null) {
                        nVar2.m();
                    }
                    this.B = nVar.getNextEventTimeIndex(j11);
                    this.f78891z = nVar;
                    this.A = null;
                }
                com.google.android.exoplayer2.util.a.e(this.f78891z);
                I(this.f78891z.getCues(j11));
            } else if (!z11 && A() == Long.MAX_VALUE) {
                if (this.f78887v == 2) {
                    G();
                } else {
                    E();
                    this.f78885t = true;
                }
            }
            if (z11) {
                com.google.android.exoplayer2.util.a.e(this.f78891z);
                I(this.f78891z.getCues(j11));
            }
        } else if (z11) {
            com.google.android.exoplayer2.util.a.e(this.f78891z);
            I(this.f78891z.getCues(j11));
        }
        if (this.f78887v == 2) {
            return;
        }
        while (!this.f78884s) {
            try {
                m mVarDequeueInputBuffer = this.f78890y;
                if (mVarDequeueInputBuffer == null) {
                    mVarDequeueInputBuffer = ((j) com.google.android.exoplayer2.util.a.e(this.f78889x)).dequeueInputBuffer();
                    if (mVarDequeueInputBuffer == null) {
                        return;
                    } else {
                        this.f78890y = mVarDequeueInputBuffer;
                    }
                }
                if (this.f78887v == 1) {
                    mVarDequeueInputBuffer.l(4);
                    ((j) com.google.android.exoplayer2.util.a.e(this.f78889x)).queueInputBuffer(mVarDequeueInputBuffer);
                    this.f78890y = null;
                    this.f78887v = 2;
                    return;
                }
                int iW = w(this.f78883r, mVarDequeueInputBuffer, 0);
                if (iW == -4) {
                    if (mVarDequeueInputBuffer.i()) {
                        this.f78884s = true;
                        this.f78886u = false;
                    } else {
                        m1 m1Var = this.f78883r.f33603b;
                        if (m1Var == null) {
                            return;
                        }
                        mVarDequeueInputBuffer.f78877j = m1Var.f33449q;
                        mVarDequeueInputBuffer.o();
                        this.f78886u &= !mVarDequeueInputBuffer.k();
                    }
                    if (!this.f78886u) {
                        ((j) com.google.android.exoplayer2.util.a.e(this.f78889x)).queueInputBuffer(mVarDequeueInputBuffer);
                        this.f78890y = null;
                    }
                } else if (iW == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e12) {
                B(e12);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.e
    public void v(m1[] m1VarArr, long j11, long j12) {
        this.f78888w = m1VarArr[0];
        if (this.f78889x != null) {
            this.f78887v = 1;
        } else {
            C();
        }
    }

    public final void z() {
        I(Collections.emptyList());
    }
}
