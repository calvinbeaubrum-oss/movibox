package r4;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Ordering<o5.e> f75117b = Ordering.natural().onResultOf(new com.google.common.base.f() { // from class: r4.c
        @Override // com.google.common.base.f
        public final Object apply(Object obj) {
            return e.h((o5.e) obj);
        }
    }).compound(Ordering.natural().reverse().onResultOf(new com.google.common.base.f() { // from class: r4.d
        @Override // com.google.common.base.f
        public final Object apply(Object obj) {
            return e.i((o5.e) obj);
        }
    }));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<o5.e> f75118a = new ArrayList();

    public static /* synthetic */ Long h(o5.e eVar) {
        return Long.valueOf(eVar.f72326b);
    }

    public static /* synthetic */ Long i(o5.e eVar) {
        return Long.valueOf(eVar.f72327c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r4.a
    public ImmutableList<y3.a> a(long j11) {
        if (!this.f75118a.isEmpty()) {
            if (j11 >= this.f75118a.get(0).f72326b) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < this.f75118a.size(); i11++) {
                    o5.e eVar = this.f75118a.get(i11);
                    if (j11 >= eVar.f72326b && j11 < eVar.f72328d) {
                        arrayList.add(eVar);
                    }
                    if (j11 < eVar.f72326b) {
                        break;
                    }
                }
                ImmutableList immutableListSortedCopyOf = ImmutableList.sortedCopyOf(f75117b, arrayList);
                ImmutableList.a aVarBuilder = ImmutableList.builder();
                for (int i12 = 0; i12 < immutableListSortedCopyOf.size(); i12++) {
                    aVarBuilder.k(((o5.e) immutableListSortedCopyOf.get(i12)).f72325a);
                }
                return aVarBuilder.m();
            }
        }
        return ImmutableList.of();
    }

    @Override // r4.a
    public boolean b(o5.e eVar, long j11) {
        z3.a.a(eVar.f72326b != C.TIME_UNSET);
        z3.a.a(eVar.f72327c != C.TIME_UNSET);
        boolean z11 = eVar.f72326b <= j11 && j11 < eVar.f72328d;
        for (int size = this.f75118a.size() - 1; size >= 0; size--) {
            if (eVar.f72326b >= this.f75118a.get(size).f72326b) {
                this.f75118a.add(size + 1, eVar);
                return z11;
            }
        }
        this.f75118a.add(0, eVar);
        return z11;
    }

    @Override // r4.a
    public long c(long j11) {
        if (this.f75118a.isEmpty()) {
            return C.TIME_UNSET;
        }
        if (j11 < this.f75118a.get(0).f72326b) {
            return C.TIME_UNSET;
        }
        long jMax = this.f75118a.get(0).f72326b;
        for (int i11 = 0; i11 < this.f75118a.size(); i11++) {
            long j12 = this.f75118a.get(i11).f72326b;
            long j13 = this.f75118a.get(i11).f72328d;
            if (j13 > j11) {
                if (j12 > j11) {
                    break;
                }
                jMax = Math.max(jMax, j12);
            } else {
                jMax = Math.max(jMax, j13);
            }
        }
        return jMax;
    }

    @Override // r4.a
    public void clear() {
        this.f75118a.clear();
    }

    @Override // r4.a
    public long d(long j11) {
        long jMin = -9223372036854775807L;
        for (int i11 = 0; i11 < this.f75118a.size(); i11++) {
            long j12 = this.f75118a.get(i11).f72326b;
            long j13 = this.f75118a.get(i11).f72328d;
            if (j11 < j12) {
                if (jMin != C.TIME_UNSET) {
                    jMin = Math.min(jMin, j12);
                    break;
                }
                jMin = j12;
                break;
            }
            if (j11 < j13) {
                jMin = jMin == C.TIME_UNSET ? j13 : Math.min(jMin, j13);
            }
        }
        if (jMin != C.TIME_UNSET) {
            return jMin;
        }
        return Long.MIN_VALUE;
    }

    @Override // r4.a
    public void e(long j11) {
        int i11 = 0;
        while (i11 < this.f75118a.size()) {
            long j12 = this.f75118a.get(i11).f72326b;
            if (j11 > j12 && j11 > this.f75118a.get(i11).f72328d) {
                this.f75118a.remove(i11);
                i11--;
            } else if (j11 < j12) {
                return;
            }
            i11++;
        }
    }
}
