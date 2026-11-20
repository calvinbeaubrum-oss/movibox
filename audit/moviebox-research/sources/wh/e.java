package wh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import vh.i;
import vh.j;
import vh.m;
import vh.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<b> f79510a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<n> f79511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriorityQueue<b> f79512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public b f79513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f79514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f79515f;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends m implements Comparable<b> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f79516k;

        public b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (i() != bVar.i()) {
                return i() ? 1 : -1;
            }
            long j11 = this.f33032f - bVar.f33032f;
            if (j11 == 0) {
                j11 = this.f79516k - bVar.f79516k;
                if (j11 == 0) {
                    return 0;
                }
            }
            return j11 > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends n {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.android.exoplayer2.decoder.f.a<c> f79517g;

        public c(com.google.android.exoplayer2.decoder.f.a<c> aVar) {
            this.f79517g = aVar;
        }

        @Override // com.google.android.exoplayer2.decoder.f
        public final void m() {
            this.f79517g.a(this);
        }
    }

    public e() {
        for (int i11 = 0; i11 < 10; i11++) {
            this.f79510a.add(new b());
        }
        this.f79511b = new ArrayDeque<>();
        for (int i12 = 0; i12 < 2; i12++) {
            this.f79511b.add(new c(new com.google.android.exoplayer2.decoder.f.a() { // from class: wh.d
                @Override // com.google.android.exoplayer2.decoder.f.a
                public final void a(com.google.android.exoplayer2.decoder.f fVar) {
                    this.f79509a.j((e.c) fVar);
                }
            }));
        }
        this.f79512c = new PriorityQueue<>();
    }

    public abstract i a();

    public abstract void b(m mVar);

    @Override // com.google.android.exoplayer2.decoder.d
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public m dequeueInputBuffer() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.g(this.f79513d == null);
        if (this.f79510a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.f79510a.pollFirst();
        this.f79513d = bVarPollFirst;
        return bVarPollFirst;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    @Nullable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public n dequeueOutputBuffer() throws SubtitleDecoderException {
        if (this.f79511b.isEmpty()) {
            return null;
        }
        while (!this.f79512c.isEmpty() && ((b) o0.j(this.f79512c.peek())).f33032f <= this.f79514e) {
            b bVar = (b) o0.j(this.f79512c.poll());
            if (bVar.i()) {
                n nVar = (n) o0.j(this.f79511b.pollFirst());
                nVar.a(4);
                i(bVar);
                return nVar;
            }
            b(bVar);
            if (g()) {
                i iVarA = a();
                n nVar2 = (n) o0.j(this.f79511b.pollFirst());
                nVar2.n(bVar.f33032f, iVarA, Long.MAX_VALUE);
                i(bVar);
                return nVar2;
            }
            i(bVar);
        }
        return null;
    }

    @Nullable
    public final n e() {
        return this.f79511b.pollFirst();
    }

    public final long f() {
        return this.f79514e;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    public void flush() {
        this.f79515f = 0L;
        this.f79514e = 0L;
        while (!this.f79512c.isEmpty()) {
            i((b) o0.j(this.f79512c.poll()));
        }
        b bVar = this.f79513d;
        if (bVar != null) {
            i(bVar);
            this.f79513d = null;
        }
    }

    public abstract boolean g();

    @Override // com.google.android.exoplayer2.decoder.d
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(m mVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.a(mVar == this.f79513d);
        b bVar = (b) mVar;
        if (bVar.h()) {
            i(bVar);
        } else {
            long j11 = this.f79515f;
            this.f79515f = 1 + j11;
            bVar.f79516k = j11;
            this.f79512c.add(bVar);
        }
        this.f79513d = null;
    }

    public final void i(b bVar) {
        bVar.b();
        this.f79510a.add(bVar);
    }

    public void j(n nVar) {
        nVar.b();
        this.f79511b.add(nVar);
    }

    @Override // com.google.android.exoplayer2.decoder.d
    public void release() {
    }

    @Override // vh.j
    public void setPositionUs(long j11) {
        this.f79514e = j11;
    }
}
