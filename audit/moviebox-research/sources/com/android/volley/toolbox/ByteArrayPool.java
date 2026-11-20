package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ByteArrayPool {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Comparator<byte[]> f16539e = new Comparator<byte[]>() { // from class: com.android.volley.toolbox.ByteArrayPool.1
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f16540a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<byte[]> f16541b = new ArrayList(64);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16542c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16543d;

    public ByteArrayPool(int i11) {
        this.f16543d = i11;
    }

    public synchronized byte[] a(int i11) {
        for (int i12 = 0; i12 < this.f16541b.size(); i12++) {
            byte[] bArr = this.f16541b.get(i12);
            if (bArr.length >= i11) {
                this.f16542c -= bArr.length;
                this.f16541b.remove(i12);
                this.f16540a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i11];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f16543d) {
                this.f16540a.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f16541b, bArr, f16539e);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f16541b.add(iBinarySearch, bArr);
                this.f16542c += bArr.length;
                c();
            }
        }
    }

    public final synchronized void c() {
        while (this.f16542c > this.f16543d) {
            byte[] bArrRemove = this.f16540a.remove(0);
            this.f16541b.remove(bArrRemove);
            this.f16542c -= bArrRemove.length;
        }
    }
}
