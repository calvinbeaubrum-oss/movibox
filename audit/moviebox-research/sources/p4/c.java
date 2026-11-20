package p4;

import androidx.media3.exoplayer.w1;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements androidx.media3.exoplayer.source.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<a> f73533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f73534b;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements androidx.media3.exoplayer.source.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.exoplayer.source.t f73535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImmutableList<Integer> f73536b;

        public a(androidx.media3.exoplayer.source.t tVar, List<Integer> list) {
            this.f73535a = tVar;
            this.f73536b = ImmutableList.copyOf((Collection) list);
        }

        @Override // androidx.media3.exoplayer.source.t
        public boolean a(w1 w1Var) {
            return this.f73535a.a(w1Var);
        }

        public ImmutableList<Integer> c() {
            return this.f73536b;
        }

        @Override // androidx.media3.exoplayer.source.t
        public long getBufferedPositionUs() {
            return this.f73535a.getBufferedPositionUs();
        }

        @Override // androidx.media3.exoplayer.source.t
        public long getNextLoadPositionUs() {
            return this.f73535a.getNextLoadPositionUs();
        }

        @Override // androidx.media3.exoplayer.source.t
        public boolean isLoading() {
            return this.f73535a.isLoading();
        }

        @Override // androidx.media3.exoplayer.source.t
        public void reevaluateBuffer(long j11) {
            this.f73535a.reevaluateBuffer(j11);
        }
    }

    public c(List<? extends androidx.media3.exoplayer.source.t> list, List<List<Integer>> list2) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        z3.a.a(list.size() == list2.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            aVarBuilder.a(new a(list.get(i11), list2.get(i11)));
        }
        this.f73533a = aVarBuilder.m();
        this.f73534b = C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        boolean zA;
        boolean z11 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            zA = false;
            for (int i11 = 0; i11 < this.f73533a.size(); i11++) {
                long nextLoadPositionUs2 = this.f73533a.get(i11).getNextLoadPositionUs();
                boolean z12 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= w1Var.f11756a;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z12) {
                    zA |= this.f73533a.get(i11).a(w1Var);
                }
            }
            z11 |= zA;
        } while (zA);
        return z11;
    }

    @Override // androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < this.f73533a.size(); i11++) {
            a aVar = this.f73533a.get(i11);
            long bufferedPositionUs = aVar.getBufferedPositionUs();
            if ((aVar.c().contains(1) || aVar.c().contains(2) || aVar.c().contains(4)) && bufferedPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, bufferedPositionUs);
            }
            if (bufferedPositionUs != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, bufferedPositionUs);
            }
        }
        if (jMin != Long.MAX_VALUE) {
            this.f73534b = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j11 = this.f73534b;
        return j11 != C.TIME_UNSET ? j11 : jMin2;
    }

    @Override // androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (int i11 = 0; i11 < this.f73533a.size(); i11++) {
            long nextLoadPositionUs = this.f73533a.get(i11).getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, nextLoadPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        for (int i11 = 0; i11 < this.f73533a.size(); i11++) {
            if (this.f73533a.get(i11).isLoading()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
        for (int i11 = 0; i11 < this.f73533a.size(); i11++) {
            this.f73533a.get(i11).reevaluateBuffer(j11);
        }
    }
}
