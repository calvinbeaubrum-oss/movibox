package o5;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.e0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Ordering<e> f72329c = Ordering.natural().onResultOf(new com.google.common.base.f() { // from class: o5.f
        @Override // com.google.common.base.f
        public final Object apply(Object obj) {
            return g.c((e) obj);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<ImmutableList<y3.a>> f72330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f72331b;

    /* JADX WARN: Code duplicated, block: B:23:0x00b1  */
    /* JADX WARN: Multi-variable type inference failed */
    public g(List<e> list) {
        if (list.size() == 1) {
            e eVar = (e) e0.j(list);
            long jD = d(eVar.f72326b);
            if (eVar.f72327c == C.TIME_UNSET) {
                this.f72330a = ImmutableList.of(eVar.f72325a);
                this.f72331b = new long[]{jD};
                return;
            } else {
                this.f72330a = ImmutableList.of((ImmutableList) eVar.f72325a, ImmutableList.of());
                this.f72331b = new long[]{jD, jD + eVar.f72327c};
                return;
            }
        }
        long[] jArr = new long[list.size() * 2];
        this.f72331b = jArr;
        Arrays.fill(jArr, Long.MAX_VALUE);
        ArrayList arrayList = new ArrayList();
        ImmutableList immutableListSortedCopyOf = ImmutableList.sortedCopyOf(f72329c, list);
        int i11 = 0;
        for (int i12 = 0; i12 < immutableListSortedCopyOf.size(); i12++) {
            e eVar2 = (e) immutableListSortedCopyOf.get(i12);
            long jD2 = d(eVar2.f72326b);
            long j11 = eVar2.f72327c + jD2;
            if (i11 != 0) {
                int i13 = i11 - 1;
                long j12 = this.f72331b[i13];
                if (j12 < jD2) {
                    this.f72331b[i11] = jD2;
                    arrayList.add(eVar2.f72325a);
                    i11++;
                } else if (j12 == jD2 && ((ImmutableList) arrayList.get(i13)).isEmpty()) {
                    arrayList.set(i13, eVar2.f72325a);
                } else {
                    z3.o.h("CuesWithTimingSubtitle", "Truncating unsupported overlapping cues.");
                    this.f72331b[i13] = jD2;
                    arrayList.set(i13, eVar2.f72325a);
                }
            } else {
                this.f72331b[i11] = jD2;
                arrayList.add(eVar2.f72325a);
                i11++;
            }
            if (eVar2.f72327c != C.TIME_UNSET) {
                this.f72331b[i11] = j11;
                arrayList.add(ImmutableList.of());
                i11++;
            }
        }
        this.f72330a = ImmutableList.copyOf((Collection) arrayList);
    }

    public static /* synthetic */ Comparable c(e eVar) {
        return Long.valueOf(d(eVar.f72326b));
    }

    public static long d(long j11) {
        if (j11 == C.TIME_UNSET) {
            return 0L;
        }
        return j11;
    }

    @Override // o5.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ImmutableList<y3.a> getCues(long j11) {
        int iH = u0.h(this.f72331b, j11, true, false);
        return iH == -1 ? ImmutableList.of() : this.f72330a.get(iH);
    }

    @Override // o5.k
    public long getEventTime(int i11) {
        z3.a.a(i11 < this.f72330a.size());
        return this.f72331b[i11];
    }

    @Override // o5.k
    public int getEventTimeCount() {
        return this.f72330a.size();
    }

    @Override // o5.k
    public int getNextEventTimeIndex(long j11) {
        int iD = u0.d(this.f72331b, j11, false, false);
        if (iD < this.f72330a.size()) {
            return iD;
        }
        return -1;
    }
}
