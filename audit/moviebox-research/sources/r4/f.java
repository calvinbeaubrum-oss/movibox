package r4;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.e0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<o5.e> f75119a = new ArrayList<>();

    @Override // r4.a
    public ImmutableList<y3.a> a(long j11) {
        int iF = f(j11);
        if (iF == 0) {
            return ImmutableList.of();
        }
        o5.e eVar = this.f75119a.get(iF - 1);
        long j12 = eVar.f72328d;
        return (j12 == C.TIME_UNSET || j11 < j12) ? eVar.f72325a : ImmutableList.of();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0025  */
    @Override // r4.a
    public boolean b(o5.e eVar, long j11) {
        boolean z11;
        z3.a.a(eVar.f72326b != C.TIME_UNSET);
        if (eVar.f72326b <= j11) {
            long j12 = eVar.f72328d;
            if (j12 == C.TIME_UNSET || j11 < j12) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        for (int size = this.f75119a.size() - 1; size >= 0; size--) {
            if (eVar.f72326b >= this.f75119a.get(size).f72326b) {
                this.f75119a.add(size + 1, eVar);
                return z11;
            }
            if (this.f75119a.get(size).f72326b <= j11) {
                z11 = false;
            }
        }
        this.f75119a.add(0, eVar);
        return z11;
    }

    @Override // r4.a
    public long c(long j11) {
        if (this.f75119a.isEmpty() || j11 < this.f75119a.get(0).f72326b) {
            return C.TIME_UNSET;
        }
        for (int i11 = 1; i11 < this.f75119a.size(); i11++) {
            long j12 = this.f75119a.get(i11).f72326b;
            if (j11 == j12) {
                return j12;
            }
            if (j11 < j12) {
                o5.e eVar = this.f75119a.get(i11 - 1);
                long j13 = eVar.f72328d;
                return (j13 == C.TIME_UNSET || j13 > j11) ? eVar.f72326b : j13;
            }
        }
        o5.e eVar2 = (o5.e) e0.g(this.f75119a);
        long j14 = eVar2.f72328d;
        return (j14 == C.TIME_UNSET || j11 < j14) ? eVar2.f72326b : j14;
    }

    @Override // r4.a
    public void clear() {
        this.f75119a.clear();
    }

    @Override // r4.a
    public long d(long j11) {
        if (this.f75119a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j11 < this.f75119a.get(0).f72326b) {
            return this.f75119a.get(0).f72326b;
        }
        for (int i11 = 1; i11 < this.f75119a.size(); i11++) {
            o5.e eVar = this.f75119a.get(i11);
            if (j11 < eVar.f72326b) {
                long j12 = this.f75119a.get(i11 - 1).f72328d;
                return (j12 == C.TIME_UNSET || j12 <= j11 || j12 >= eVar.f72326b) ? eVar.f72326b : j12;
            }
        }
        long j13 = ((o5.e) e0.g(this.f75119a)).f72328d;
        if (j13 == C.TIME_UNSET || j11 >= j13) {
            return Long.MIN_VALUE;
        }
        return j13;
    }

    @Override // r4.a
    public void e(long j11) {
        int iF = f(j11);
        if (iF > 0) {
            this.f75119a.subList(0, iF).clear();
        }
    }

    public final int f(long j11) {
        for (int i11 = 0; i11 < this.f75119a.size(); i11++) {
            if (j11 < this.f75119a.get(i11).f72326b) {
                return i11;
            }
        }
        return this.f75119a.size();
    }
}
