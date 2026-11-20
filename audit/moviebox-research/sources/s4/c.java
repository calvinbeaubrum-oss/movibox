package s4;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.n0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f75994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f75995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f75996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f75997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.media3.common.y[] f75998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f75999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f76000g;

    public c(n0 n0Var, int... iArr) {
        this(n0Var, iArr, 0);
    }

    public c(n0 n0Var, int[] iArr, int i11) {
        int i12 = 0;
        z3.a.g(iArr.length > 0);
        this.f75997d = i11;
        this.f75994a = (n0) z3.a.e(n0Var);
        int length = iArr.length;
        this.f75995b = length;
        this.f75998e = new androidx.media3.common.y[length];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            this.f75998e[i13] = n0Var.a(iArr[i13]);
        }
        Arrays.sort(this.f75998e, new Comparator() { // from class: s4.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.j((androidx.media3.common.y) obj, (androidx.media3.common.y) obj2);
            }
        });
        this.f75996c = new int[this.f75995b];
        while (true) {
            int i14 = this.f75995b;
            if (i12 >= i14) {
                this.f75999f = new long[i14];
                return;
            } else {
                this.f75996c[i12] = n0Var.b(this.f75998e[i12]);
                i12++;
            }
        }
    }

    public static /* synthetic */ int j(androidx.media3.common.y yVar, androidx.media3.common.y yVar2) {
        return yVar2.f9497i - yVar.f9497i;
    }

    @Override // s4.z
    public /* synthetic */ void a() {
        y.a(this);
    }

    @Override // s4.z
    public /* synthetic */ void b(boolean z11) {
        y.b(this, z11);
    }

    @Override // s4.z
    public /* synthetic */ void c() {
        y.c(this);
    }

    @Override // s4.z
    public boolean d(int i11, long j11) {
        return this.f75999f[i11] > j11;
    }

    @Override // s4.z
    public void disable() {
    }

    @Override // s4.c0
    public final int e(androidx.media3.common.y yVar) {
        for (int i11 = 0; i11 < this.f75995b; i11++) {
            if (this.f75998e[i11] == yVar) {
                return i11;
            }
        }
        return -1;
    }

    @Override // s4.z
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
        return this.f75994a.equals(cVar.f75994a) && Arrays.equals(this.f75996c, cVar.f75996c);
    }

    @Override // s4.z
    public int evaluateQueueSize(long j11, List<? extends q4.m> list) {
        return list.size();
    }

    @Override // s4.z
    public boolean f(int i11, long j11) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zD = d(i11, jElapsedRealtime);
        int i12 = 0;
        while (i12 < this.f75995b && !zD) {
            zD = (i12 == i11 || d(i12, jElapsedRealtime)) ? false : true;
            i12++;
        }
        if (!zD) {
            return false;
        }
        long[] jArr = this.f75999f;
        jArr[i11] = Math.max(jArr[i11], u0.b(jElapsedRealtime, j11, Long.MAX_VALUE));
        return true;
    }

    @Override // s4.z
    public /* synthetic */ boolean g(long j11, q4.e eVar, List list) {
        return y.d(this, j11, eVar, list);
    }

    @Override // s4.c0
    public final androidx.media3.common.y getFormat(int i11) {
        return this.f75998e[i11];
    }

    @Override // s4.c0
    public final int getIndexInTrackGroup(int i11) {
        return this.f75996c[i11];
    }

    @Override // s4.z
    public final androidx.media3.common.y getSelectedFormat() {
        return this.f75998e[getSelectedIndex()];
    }

    @Override // s4.z
    public final int getSelectedIndexInTrackGroup() {
        return this.f75996c[getSelectedIndex()];
    }

    @Override // s4.c0
    public final n0 getTrackGroup() {
        return this.f75994a;
    }

    public int hashCode() {
        if (this.f76000g == 0) {
            this.f76000g = (System.identityHashCode(this.f75994a) * 31) + Arrays.hashCode(this.f75996c);
        }
        return this.f76000g;
    }

    @Override // s4.c0
    public final int indexOf(int i11) {
        for (int i12 = 0; i12 < this.f75995b; i12++) {
            if (this.f75996c[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }

    @Override // s4.c0
    public final int length() {
        return this.f75996c.length;
    }

    @Override // s4.z
    public void onPlaybackSpeed(float f11) {
    }
}
