package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j0<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f35584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public V[] f35585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f35587d;

    public j0() {
        this(10);
    }

    public j0(int i11) {
        this.f35584a = new long[i11];
        this.f35585b = (V[]) f(i11);
    }

    public static <V> V[] f(int i11) {
        return (V[]) new Object[i11];
    }

    public synchronized void a(long j11, V v11) {
        d(j11);
        e();
        b(j11, v11);
    }

    public final void b(long j11, V v11) {
        int i11 = this.f35586c;
        int i12 = this.f35587d;
        V[] vArr = this.f35585b;
        int length = (i11 + i12) % vArr.length;
        this.f35584a[length] = j11;
        vArr[length] = v11;
        this.f35587d = i12 + 1;
    }

    public synchronized void c() {
        this.f35586c = 0;
        this.f35587d = 0;
        Arrays.fill(this.f35585b, (Object) null);
    }

    public final void d(long j11) {
        int i11 = this.f35587d;
        if (i11 > 0) {
            if (j11 <= this.f35584a[((this.f35586c + i11) - 1) % this.f35585b.length]) {
                c();
            }
        }
    }

    public final void e() {
        int length = this.f35585b.length;
        if (this.f35587d < length) {
            return;
        }
        int i11 = length * 2;
        long[] jArr = new long[i11];
        V[] vArr = (V[]) f(i11);
        int i12 = this.f35586c;
        int i13 = length - i12;
        System.arraycopy(this.f35584a, i12, jArr, 0, i13);
        System.arraycopy(this.f35585b, this.f35586c, vArr, 0, i13);
        int i14 = this.f35586c;
        if (i14 > 0) {
            System.arraycopy(this.f35584a, 0, jArr, i13, i14);
            System.arraycopy(this.f35585b, 0, vArr, i13, this.f35586c);
        }
        this.f35584a = jArr;
        this.f35585b = vArr;
        this.f35586c = 0;
    }

    @Nullable
    public synchronized V g(long j11) {
        return h(j11, false);
    }

    @Nullable
    public final V h(long j11, boolean z11) {
        V vK = null;
        long j12 = Long.MAX_VALUE;
        while (this.f35587d > 0) {
            long j13 = j11 - this.f35584a[this.f35586c];
            if (j13 < 0 && (z11 || (-j13) >= j12)) {
                break;
            }
            vK = k();
            j12 = j13;
        }
        return vK;
    }

    @Nullable
    public synchronized V i() {
        return this.f35587d == 0 ? null : k();
    }

    @Nullable
    public synchronized V j(long j11) {
        return h(j11, true);
    }

    @Nullable
    public final V k() {
        a.g(this.f35587d > 0);
        V[] vArr = this.f35585b;
        int i11 = this.f35586c;
        V v11 = vArr[i11];
        vArr[i11] = null;
        this.f35586c = (i11 + 1) % vArr.length;
        this.f35587d--;
        return v11;
    }

    public synchronized int l() {
        return this.f35587d;
    }
}
