package com.mbridge.msdk.e.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Comparator<byte[]> f43741a = new Comparator<byte[]>() { // from class: com.mbridge.msdk.e.a.a.c.1
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<byte[]> f43742b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<byte[]> f43743c = new ArrayList(64);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43744d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f43745e;

    public c(int i11) {
        this.f43745e = i11;
    }

    private synchronized void a() {
        while (this.f43744d > this.f43745e) {
            byte[] bArrRemove = this.f43742b.remove(0);
            this.f43743c.remove(bArrRemove);
            this.f43744d -= bArrRemove.length;
        }
    }

    public final synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f43745e) {
                this.f43742b.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f43743c, bArr, f43741a);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f43743c.add(iBinarySearch, bArr);
                this.f43744d += bArr.length;
                a();
            }
        }
    }

    public final synchronized byte[] a(int i11) {
        for (int i12 = 0; i12 < this.f43743c.size(); i12++) {
            byte[] bArr = this.f43743c.get(i12);
            if (bArr.length >= i11) {
                this.f43744d -= bArr.length;
                this.f43743c.remove(i12);
                this.f43742b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i11];
    }
}
