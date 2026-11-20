package androidx.media3.exoplayer.upstream;

import androidx.annotation.Nullable;
import java.util.Arrays;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final byte[] f11456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a[] f11460g;

    public h(boolean z11, int i11) {
        this(z11, i11, 0);
    }

    public h(boolean z11, int i11, int i12) {
        z3.a.a(i11 > 0);
        z3.a.a(i12 >= 0);
        this.f11454a = z11;
        this.f11455b = i11;
        this.f11459f = i12;
        this.f11460g = new a[i12 + 100];
        if (i12 <= 0) {
            this.f11456c = null;
            return;
        }
        this.f11456c = new byte[i12 * i11];
        for (int i13 = 0; i13 < i12; i13++) {
            this.f11460g[i13] = new a(this.f11456c, i13 * i11);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.b
    public synchronized void a(@Nullable b.a aVar) {
        while (aVar != null) {
            try {
                a[] aVarArr = this.f11460g;
                int i11 = this.f11459f;
                this.f11459f = i11 + 1;
                aVarArr[i11] = aVar.a();
                this.f11458e--;
                aVar = aVar.next();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        notifyAll();
    }

    @Override // androidx.media3.exoplayer.upstream.b
    public synchronized a allocate() {
        a aVar;
        try {
            this.f11458e++;
            int i11 = this.f11459f;
            if (i11 > 0) {
                a[] aVarArr = this.f11460g;
                int i12 = i11 - 1;
                this.f11459f = i12;
                aVar = (a) z3.a.e(aVarArr[i12]);
                this.f11460g[this.f11459f] = null;
            } else {
                aVar = new a(new byte[this.f11455b], 0);
                int i13 = this.f11458e;
                a[] aVarArr2 = this.f11460g;
                if (i13 > aVarArr2.length) {
                    this.f11460g = (a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return aVar;
    }

    @Override // androidx.media3.exoplayer.upstream.b
    public synchronized void b(a aVar) {
        a[] aVarArr = this.f11460g;
        int i11 = this.f11459f;
        this.f11459f = i11 + 1;
        aVarArr[i11] = aVar;
        this.f11458e--;
        notifyAll();
    }

    public synchronized int c() {
        return this.f11458e * this.f11455b;
    }

    public synchronized void d() {
        if (this.f11454a) {
            e(0);
        }
    }

    public synchronized void e(int i11) {
        boolean z11 = i11 < this.f11457d;
        this.f11457d = i11;
        if (z11) {
            trim();
        }
    }

    @Override // androidx.media3.exoplayer.upstream.b
    public int getIndividualAllocationLength() {
        return this.f11455b;
    }

    @Override // androidx.media3.exoplayer.upstream.b
    public synchronized void trim() {
        try {
            int i11 = 0;
            int iMax = Math.max(0, u0.k(this.f11457d, this.f11455b) - this.f11458e);
            int i12 = this.f11459f;
            if (iMax >= i12) {
                return;
            }
            if (this.f11456c != null) {
                int i13 = i12 - 1;
                while (i11 <= i13) {
                    a aVar = (a) z3.a.e(this.f11460g[i11]);
                    if (aVar.f11443a == this.f11456c) {
                        i11++;
                    } else {
                        a aVar2 = (a) z3.a.e(this.f11460g[i13]);
                        if (aVar2.f11443a != this.f11456c) {
                            i13--;
                        } else {
                            a[] aVarArr = this.f11460g;
                            aVarArr[i11] = aVar2;
                            aVarArr[i13] = aVar;
                            i13--;
                            i11++;
                        }
                    }
                }
                iMax = Math.max(iMax, i11);
                if (iMax >= this.f11459f) {
                    return;
                }
            }
            Arrays.fill(this.f11460g, iMax, this.f11459f, (Object) null);
            this.f11459f = iMax;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
