package ym;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b[] f81542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f81543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f81544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f81545d;

    public a(int i11, int i12) {
        b[] bVarArr = new b[i11];
        this.f81542a = bVarArr;
        int length = bVarArr.length;
        for (int i13 = 0; i13 < length; i13++) {
            this.f81542a[i13] = new b(((i12 + 4) * 17) + 1);
        }
        this.f81545d = i12 * 17;
        this.f81544c = i11;
        this.f81543b = -1;
    }

    public b a() {
        return this.f81542a[this.f81543b];
    }

    public byte[][] b(int i11, int i12) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.f81544c * i12, this.f81545d * i11);
        int i13 = this.f81544c * i12;
        for (int i14 = 0; i14 < i13; i14++) {
            bArr[(i13 - i14) - 1] = this.f81542a[i14 / i12].b(i11);
        }
        return bArr;
    }

    public void c() {
        this.f81543b++;
    }
}
