package vh;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import tg.a0;
import tg.e0;
import tg.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class l implements tg.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f78866a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m1 f78869d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public tg.n f78872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e0 f78873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f78874i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f78867b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f78868c = new c0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Long> f78870e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<c0> f78871f = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f78875j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f78876k = C.TIME_UNSET;

    public l(j jVar, m1 m1Var) {
        this.f78866a = jVar;
        this.f78869d = m1Var.b().e0("text/x-exoplayer-cues").I(m1Var.f33445m).E();
    }

    public final void a() throws IOException, DecoderException {
        try {
            m mVarDequeueInputBuffer = this.f78866a.dequeueInputBuffer();
            while (mVarDequeueInputBuffer == null) {
                Thread.sleep(5L);
                mVarDequeueInputBuffer = this.f78866a.dequeueInputBuffer();
            }
            mVarDequeueInputBuffer.n(this.f78874i);
            mVarDequeueInputBuffer.f33030c.put(this.f78868c.d(), 0, this.f78874i);
            mVarDequeueInputBuffer.f33030c.limit(this.f78874i);
            this.f78866a.queueInputBuffer(mVarDequeueInputBuffer);
            n nVarDequeueOutputBuffer = this.f78866a.dequeueOutputBuffer();
            while (nVarDequeueOutputBuffer == null) {
                Thread.sleep(5L);
                nVarDequeueOutputBuffer = this.f78866a.dequeueOutputBuffer();
            }
            for (int i11 = 0; i11 < nVarDequeueOutputBuffer.getEventTimeCount(); i11++) {
                byte[] bArrA = this.f78867b.a(nVarDequeueOutputBuffer.getCues(nVarDequeueOutputBuffer.getEventTime(i11)));
                this.f78870e.add(Long.valueOf(nVarDequeueOutputBuffer.getEventTime(i11)));
                this.f78871f.add(new c0(bArrA));
            }
            nVarDequeueOutputBuffer.m();
        } catch (SubtitleDecoderException e11) {
            throw ParserException.createForMalformedContainer("SubtitleDecoder failed.", e11);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    @Override // tg.l
    public boolean b(tg.m mVar) throws IOException {
        return true;
    }

    @Override // tg.l
    public int c(tg.m mVar, a0 a0Var) throws IOException, DecoderException {
        int i11 = this.f78875j;
        com.google.android.exoplayer2.util.a.g((i11 == 0 || i11 == 5) ? false : true);
        if (this.f78875j == 1) {
            this.f78868c.L(mVar.getLength() != -1 ? Ints.d(mVar.getLength()) : 1024);
            this.f78874i = 0;
            this.f78875j = 2;
        }
        if (this.f78875j == 2 && e(mVar)) {
            a();
            g();
            this.f78875j = 4;
        }
        if (this.f78875j == 3 && f(mVar)) {
            g();
            this.f78875j = 4;
        }
        return this.f78875j == 4 ? -1 : 0;
    }

    @Override // tg.l
    public void d(tg.n nVar) {
        com.google.android.exoplayer2.util.a.g(this.f78875j == 0);
        this.f78872g = nVar;
        this.f78873h = nVar.track(0, 3);
        this.f78872g.endTracks();
        this.f78872g.g(new z(new long[]{0}, new long[]{0}, C.TIME_UNSET));
        this.f78873h.e(this.f78869d);
        this.f78875j = 1;
    }

    public final boolean e(tg.m mVar) throws IOException {
        int iB = this.f78868c.b();
        int i11 = this.f78874i;
        if (iB == i11) {
            this.f78868c.c(i11 + 1024);
        }
        int i12 = mVar.read(this.f78868c.d(), this.f78874i, this.f78868c.b() - this.f78874i);
        if (i12 != -1) {
            this.f78874i += i12;
        }
        long length = mVar.getLength();
        return (length != -1 && ((long) this.f78874i) == length) || i12 == -1;
    }

    public final boolean f(tg.m mVar) throws IOException {
        return mVar.skip((mVar.getLength() > (-1L) ? 1 : (mVar.getLength() == (-1L) ? 0 : -1)) != 0 ? Ints.d(mVar.getLength()) : 1024) == -1;
    }

    public final void g() {
        com.google.android.exoplayer2.util.a.i(this.f78873h);
        com.google.android.exoplayer2.util.a.g(this.f78870e.size() == this.f78871f.size());
        long j11 = this.f78876k;
        for (int iG = j11 == C.TIME_UNSET ? 0 : o0.g(this.f78870e, Long.valueOf(j11), true, true); iG < this.f78871f.size(); iG++) {
            c0 c0Var = this.f78871f.get(iG);
            c0Var.P(0);
            int length = c0Var.d().length;
            this.f78873h.c(c0Var, length);
            this.f78873h.d(this.f78870e.get(iG).longValue(), 1, length, 0, null);
        }
    }

    @Override // tg.l
    public void release() {
        if (this.f78875j == 5) {
            return;
        }
        this.f78866a.release();
        this.f78875j = 5;
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        int i11 = this.f78875j;
        com.google.android.exoplayer2.util.a.g((i11 == 0 || i11 == 5) ? false : true);
        this.f78876k = j12;
        if (this.f78875j == 2) {
            this.f78875j = 1;
        }
        if (this.f78875j == 4) {
            this.f78875j = 3;
        }
    }
}
