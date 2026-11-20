package vh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f78855a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f78856b = new m();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deque<n> f78857c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f78858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f78859e;

    /* JADX INFO: compiled from: source.java */
    public class a extends n {
        public a() {
        }

        @Override // com.google.android.exoplayer2.decoder.f
        public void m() {
            g.this.e(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f78861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImmutableList<vh.b> f78862b;

        public b(long j11, ImmutableList<vh.b> immutableList) {
            this.f78861a = j11;
            this.f78862b = immutableList;
        }

        @Override // vh.i
        public List<vh.b> getCues(long j11) {
            return j11 >= this.f78861a ? this.f78862b : ImmutableList.of();
        }

        @Override // vh.i
        public long getEventTime(int i11) {
            com.google.android.exoplayer2.util.a.a(i11 == 0);
            return this.f78861a;
        }

        @Override // vh.i
        public int getEventTimeCount() {
            return 1;
        }

        @Override // vh.i
        public int getNextEventTimeIndex(long j11) {
            return this.f78861a > j11 ? 0 : -1;
        }
    }

    public g() {
        for (int i11 = 0; i11 < 2; i11++) {
            this.f78857c.addFirst(new a());
        }
        this.f78858d = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        com.google.android.exoplayer2.util.a.g(this.f78857c.size() < 2);
        com.google.android.exoplayer2.util.a.a(!this.f78857c.contains(nVar));
        nVar.b();
        this.f78857c.addFirst(nVar);
    }

    @Override // com.google.android.exoplayer2.decoder.d
    @Nullable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m dequeueInputBuffer() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.g(!this.f78859e);
        if (this.f78858d != 0) {
            return null;
        }
        this.f78858d = 1;
        return this.f78856b;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n dequeueOutputBuffer() throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.g(!this.f78859e);
        if (this.f78858d != 2 || this.f78857c.isEmpty()) {
            return null;
        }
        n nVarRemoveFirst = this.f78857c.removeFirst();
        if (this.f78856b.i()) {
            nVarRemoveFirst.a(4);
        } else {
            m mVar = this.f78856b;
            nVarRemoveFirst.n(this.f78856b.f33032f, new b(mVar.f33032f, this.f78855a.a(((ByteBuffer) com.google.android.exoplayer2.util.a.e(mVar.f33030c)).array())), 0L);
        }
        this.f78856b.b();
        this.f78858d = 0;
        return nVarRemoveFirst;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(m mVar) throws SubtitleDecoderException {
        com.google.android.exoplayer2.util.a.g(!this.f78859e);
        com.google.android.exoplayer2.util.a.g(this.f78858d == 1);
        com.google.android.exoplayer2.util.a.a(this.f78856b == mVar);
        this.f78858d = 2;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    public void flush() {
        com.google.android.exoplayer2.util.a.g(!this.f78859e);
        this.f78856b.b();
        this.f78858d = 0;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    public void release() {
        this.f78859e = true;
    }

    @Override // vh.j
    public void setPositionUs(long j11) {
    }
}
