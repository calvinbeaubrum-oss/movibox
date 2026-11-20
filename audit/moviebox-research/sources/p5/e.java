package p5;

import androidx.annotation.Nullable;
import androidx.media3.decoder.h;
import androidx.media3.extractor.text.SubtitleDecoderException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import o5.k;
import o5.l;
import o5.o;
import o5.p;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<b> f73696a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<p> f73697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriorityQueue<b> f73698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public b f73699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f73700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f73701f;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends o implements Comparable<b> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f73702k;

        public b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (isEndOfStream() != bVar.isEndOfStream()) {
                return isEndOfStream() ? 1 : -1;
            }
            long j11 = this.f9782f - bVar.f9782f;
            if (j11 == 0) {
                j11 = this.f73702k - bVar.f73702k;
                if (j11 == 0) {
                    return 0;
                }
            }
            return j11 > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h.a<c> f73703c;

        public c(h.a<c> aVar) {
            this.f73703c = aVar;
        }

        @Override // androidx.media3.decoder.h
        public final void release() {
            this.f73703c.a(this);
        }
    }

    public e() {
        for (int i11 = 0; i11 < 10; i11++) {
            this.f73696a.add(new b());
        }
        this.f73697b = new ArrayDeque<>();
        for (int i12 = 0; i12 < 2; i12++) {
            this.f73697b.add(new c(new h.a() { // from class: p5.d
                @Override // androidx.media3.decoder.h.a
                public final void a(h hVar) {
                    this.f73695a.l((e.c) hVar);
                }
            }));
        }
        this.f73698c = new PriorityQueue<>();
    }

    @Override // androidx.media3.decoder.g
    public final void a(long j11) {
    }

    public abstract k c();

    public abstract void d(o oVar);

    @Override // androidx.media3.decoder.g
    @Nullable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public o dequeueInputBuffer() throws SubtitleDecoderException {
        z3.a.g(this.f73699d == null);
        if (this.f73696a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.f73696a.pollFirst();
        this.f73699d = bVarPollFirst;
        return bVarPollFirst;
    }

    @Override // androidx.media3.decoder.g
    @Nullable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public p dequeueOutputBuffer() throws SubtitleDecoderException {
        if (this.f73697b.isEmpty()) {
            return null;
        }
        while (!this.f73698c.isEmpty() && ((b) u0.i(this.f73698c.peek())).f9782f <= this.f73700e) {
            b bVar = (b) u0.i(this.f73698c.poll());
            if (bVar.isEndOfStream()) {
                p pVar = (p) u0.i(this.f73697b.pollFirst());
                pVar.addFlag(4);
                k(bVar);
                return pVar;
            }
            d(bVar);
            if (i()) {
                k kVarC = c();
                p pVar2 = (p) u0.i(this.f73697b.pollFirst());
                pVar2.a(bVar.f9782f, kVarC, Long.MAX_VALUE);
                k(bVar);
                return pVar2;
            }
            k(bVar);
        }
        return null;
    }

    @Override // androidx.media3.decoder.g
    public void flush() {
        this.f73701f = 0L;
        this.f73700e = 0L;
        while (!this.f73698c.isEmpty()) {
            k((b) u0.i(this.f73698c.poll()));
        }
        b bVar = this.f73699d;
        if (bVar != null) {
            k(bVar);
            this.f73699d = null;
        }
    }

    @Nullable
    public final p g() {
        return this.f73697b.pollFirst();
    }

    public final long h() {
        return this.f73700e;
    }

    public abstract boolean i();

    @Override // androidx.media3.decoder.g
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(o oVar) throws SubtitleDecoderException {
        z3.a.a(oVar == this.f73699d);
        b bVar = (b) oVar;
        if (bVar.isDecodeOnly()) {
            k(bVar);
        } else {
            long j11 = this.f73701f;
            this.f73701f = 1 + j11;
            bVar.f73702k = j11;
            this.f73698c.add(bVar);
        }
        this.f73699d = null;
    }

    public final void k(b bVar) {
        bVar.clear();
        this.f73696a.add(bVar);
    }

    public void l(p pVar) {
        pVar.clear();
        this.f73697b.add(pVar);
    }

    @Override // androidx.media3.decoder.g
    public void release() {
    }

    @Override // o5.l
    public void setPositionUs(long j11) {
        this.f73700e = j11;
    }
}
