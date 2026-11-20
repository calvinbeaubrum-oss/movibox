package com.facebook.ads.redexgen.uinode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YB implements AnonymousClass96 {
    public final List<C9B> A00 = new ArrayList();
    public final boolean A01;
    public final /* synthetic */ YA A02;

    public YB(YA ya2, List<AnonymousClass92> list, boolean z11) throws IOException {
        this.A02 = ya2;
        this.A01 = z11;
        for (AnonymousClass92 anonymousClass92 : list) {
            AnonymousClass91 anonymousClass91A01 = anonymousClass92.A01();
            this.A00.add(new C9B(new C11638z(anonymousClass92.A00(), anonymousClass91A01.A01()), anonymousClass91A01.A00() - anonymousClass91A01.A01(), anonymousClass91A01.A00()));
        }
    }

    public final C9B A00() {
        return this.A00.get(0);
    }

    public final C9B A01() {
        List<C9B> list = this.A00;
        return list.get(list.size() - 1);
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass96
    public final void A52() throws C9G {
        this.A02.A03(this);
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass96
    public final synchronized int A5g() {
        int i11;
        i11 = 0;
        Iterator<C9B> it = this.A00.iterator();
        while (it.hasNext()) {
            i11 += it.next().A01;
        }
        return i11;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass96
    public final boolean AAK() {
        return this.A01;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A02.A06(this);
    }
}
