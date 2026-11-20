package jm;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f68101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f68102b;

    public d(a aVar) {
        this.f68101a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f68102b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    public final b a(int i11) {
        if (i11 >= this.f68102b.size()) {
            List<b> list = this.f68102b;
            b bVarI = list.get(list.size() - 1);
            for (int size = this.f68102b.size(); size <= i11; size++) {
                a aVar = this.f68101a;
                bVarI = bVarI.i(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f68102b.add(bVarI);
            }
        }
        return this.f68102b.get(i11);
    }

    public void b(int[] iArr, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i11;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b bVarA = a(i11);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrE = new b(this.f68101a, iArr2).j(i11, 1).b(bVarA)[1].e();
        int length2 = i11 - iArrE.length;
        for (int i12 = 0; i12 < length2; i12++) {
            iArr[length + i12] = 0;
        }
        System.arraycopy(iArrE, 0, iArr, length + length2, iArrE.length);
    }
}
