package com.facebook.ads.redexgen.uinode;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DA {
    public final int A00;
    public final String A01;
    public final List<D9> A02;
    public final byte[] A03;

    public DA(int i11, String str, List<D9> list, byte[] bArr) {
        this.A00 = i11;
        this.A01 = str;
        this.A02 = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.A03 = bArr;
    }
}
