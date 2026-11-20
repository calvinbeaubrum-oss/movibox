package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f35443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final byte[] f35445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f35446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f35447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a[] f35449g;

    public o(boolean z11, int i11) {
        this(z11, i11, 0);
    }

    public o(boolean z11, int i11, int i12) {
        com.google.android.exoplayer2.util.a.a(i11 > 0);
        com.google.android.exoplayer2.util.a.a(i12 >= 0);
        this.f35443a = z11;
        this.f35444b = i11;
        this.f35448f = i12;
        this.f35449g = new a[i12 + 100];
        if (i12 <= 0) {
            this.f35445c = null;
            return;
        }
        this.f35445c = new byte[i12 * i11];
        for (int i13 = 0; i13 < i12; i13++) {
            this.f35449g[i13] = new a(this.f35445c, i13 * i11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(@Nullable b.a aVar) {
        while (aVar != null) {
            try {
                a[] aVarArr = this.f35449g;
                int i11 = this.f35448f;
                this.f35448f = i11 + 1;
                aVarArr[i11] = aVar.a();
                this.f35447e--;
                aVar = aVar.next();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized a allocate() {
        a aVar;
        try {
            this.f35447e++;
            int i11 = this.f35448f;
            if (i11 > 0) {
                a[] aVarArr = this.f35449g;
                int i12 = i11 - 1;
                this.f35448f = i12;
                aVar = (a) com.google.android.exoplayer2.util.a.e(aVarArr[i12]);
                this.f35449g[this.f35448f] = null;
            } else {
                aVar = new a(new byte[this.f35444b], 0);
                int i13 = this.f35447e;
                a[] aVarArr2 = this.f35449g;
                if (i13 > aVarArr2.length) {
                    this.f35449g = (a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void b(a aVar) {
        a[] aVarArr = this.f35449g;
        int i11 = this.f35448f;
        this.f35448f = i11 + 1;
        aVarArr[i11] = aVar;
        this.f35447e--;
        notifyAll();
    }

    public synchronized int c() {
        return this.f35447e * this.f35444b;
    }

    public synchronized void d() {
        if (this.f35443a) {
            e(0);
        }
    }

    public synchronized void e(int i11) {
        boolean z11 = i11 < this.f35446d;
        this.f35446d = i11;
        if (z11) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public int getIndividualAllocationLength() {
        return this.f35444b;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void trim() {
        try {
            int i11 = 0;
            int iMax = Math.max(0, o0.l(this.f35446d, this.f35444b) - this.f35447e);
            int i12 = this.f35448f;
            if (iMax >= i12) {
                return;
            }
            if (this.f35445c != null) {
                int i13 = i12 - 1;
                while (i11 <= i13) {
                    a aVar = (a) com.google.android.exoplayer2.util.a.e(this.f35449g[i11]);
                    if (aVar.f35254a == this.f35445c) {
                        i11++;
                    } else {
                        a aVar2 = (a) com.google.android.exoplayer2.util.a.e(this.f35449g[i13]);
                        if (aVar2.f35254a != this.f35445c) {
                            i13--;
                        } else {
                            a[] aVarArr = this.f35449g;
                            aVarArr[i11] = aVar2;
                            aVarArr[i13] = aVar;
                            i13--;
                            i11++;
                        }
                    }
                }
                iMax = Math.max(iMax, i11);
                if (iMax >= this.f35448f) {
                    return;
                }
            }
            Arrays.fill(this.f35449g, iMax, this.f35448f, (Object) null);
            this.f35448f = iMax;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
