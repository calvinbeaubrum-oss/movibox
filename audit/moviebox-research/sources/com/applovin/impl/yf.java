package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class yf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f24663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f24664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f24665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24666e;

    public yf(int i11, int i12) {
        this.f24662a = i11;
        byte[] bArr = new byte[i12 + 3];
        this.f24665d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i11, int i12) {
        if (this.f24663b) {
            int i13 = i12 - i11;
            byte[] bArr2 = this.f24665d;
            int length = bArr2.length;
            int i14 = this.f24666e + i13;
            if (length < i14) {
                this.f24665d = Arrays.copyOf(bArr2, i14 * 2);
            }
            System.arraycopy(bArr, i11, this.f24665d, this.f24666e, i13);
            this.f24666e += i13;
        }
    }

    public boolean a() {
        return this.f24664c;
    }

    public boolean a(int i11) {
        if (!this.f24663b) {
            return false;
        }
        this.f24666e -= i11;
        this.f24663b = false;
        this.f24664c = true;
        return true;
    }

    public void b() {
        this.f24663b = false;
        this.f24664c = false;
    }

    public void b(int i11) {
        b1.b(!this.f24663b);
        boolean z11 = i11 == this.f24662a;
        this.f24663b = z11;
        if (z11) {
            this.f24666e = 3;
            this.f24664c = false;
        }
    }
}
