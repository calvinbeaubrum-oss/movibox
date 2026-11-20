package fi;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import nh.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f64955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f64957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f64958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m1[] f64959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f64960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f64961g;

    public c(i0 i0Var, int... iArr) {
        this(i0Var, iArr, 0);
    }

    public c(i0 i0Var, int[] iArr, int i11) {
        int i12 = 0;
        com.google.android.exoplayer2.util.a.g(iArr.length > 0);
        this.f64958d = i11;
        this.f64955a = (i0) com.google.android.exoplayer2.util.a.e(i0Var);
        int length = iArr.length;
        this.f64956b = length;
        this.f64959e = new m1[length];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            this.f64959e[i13] = i0Var.c(iArr[i13]);
        }
        Arrays.sort(this.f64959e, new Comparator() { // from class: fi.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.i((m1) obj, (m1) obj2);
            }
        });
        this.f64957c = new int[this.f64956b];
        while (true) {
            int i14 = this.f64956b;
            if (i12 >= i14) {
                this.f64960f = new long[i14];
                return;
            } else {
                this.f64957c[i12] = i0Var.d(this.f64959e[i12]);
                i12++;
            }
        }
    }

    public static /* synthetic */ int i(m1 m1Var, m1 m1Var2) {
        return m1Var2.f33441i - m1Var.f33441i;
    }

    @Override // fi.s
    public /* synthetic */ void a() {
        r.a(this);
    }

    @Override // fi.s
    public /* synthetic */ void b(boolean z11) {
        r.b(this, z11);
    }

    @Override // fi.s
    public boolean blacklist(int i11, long j11) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zE = e(i11, jElapsedRealtime);
        int i12 = 0;
        while (i12 < this.f64956b && !zE) {
            zE = (i12 == i11 || e(i12, jElapsedRealtime)) ? false : true;
            i12++;
        }
        if (!zE) {
            return false;
        }
        long[] jArr = this.f64960f;
        jArr[i11] = Math.max(jArr[i11], o0.b(jElapsedRealtime, j11, Long.MAX_VALUE));
        return true;
    }

    @Override // fi.s
    public /* synthetic */ void c() {
        r.c(this);
    }

    @Override // fi.s
    public void disable() {
    }

    @Override // fi.s
    public boolean e(int i11, long j11) {
        return this.f64960f[i11] > j11;
    }

    @Override // fi.s
    public void enable() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f64955a == cVar.f64955a && Arrays.equals(this.f64957c, cVar.f64957c);
    }

    @Override // fi.s
    public int evaluateQueueSize(long j11, List<? extends ph.n> list) {
        return list.size();
    }

    @Override // fi.s
    public /* synthetic */ boolean f(long j11, ph.f fVar, List list) {
        return r.d(this, j11, fVar, list);
    }

    @Override // fi.v
    public final int g(m1 m1Var) {
        for (int i11 = 0; i11 < this.f64956b; i11++) {
            if (this.f64959e[i11] == m1Var) {
                return i11;
            }
        }
        return -1;
    }

    @Override // fi.v
    public final m1 getFormat(int i11) {
        return this.f64959e[i11];
    }

    @Override // fi.v
    public final int getIndexInTrackGroup(int i11) {
        return this.f64957c[i11];
    }

    @Override // fi.s
    public final m1 getSelectedFormat() {
        return this.f64959e[getSelectedIndex()];
    }

    @Override // fi.s
    public final int getSelectedIndexInTrackGroup() {
        return this.f64957c[getSelectedIndex()];
    }

    @Override // fi.v
    public final i0 getTrackGroup() {
        return this.f64955a;
    }

    public int hashCode() {
        if (this.f64961g == 0) {
            this.f64961g = (System.identityHashCode(this.f64955a) * 31) + Arrays.hashCode(this.f64957c);
        }
        return this.f64961g;
    }

    @Override // fi.v
    public final int indexOf(int i11) {
        for (int i12 = 0; i12 < this.f64956b; i12++) {
            if (this.f64957c[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }

    @Override // fi.v
    public final int length() {
        return this.f64957c.length;
    }

    @Override // fi.s
    public void onPlaybackSpeed(float f11) {
    }
}
