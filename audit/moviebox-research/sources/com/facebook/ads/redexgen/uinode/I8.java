package com.facebook.ads.redexgen.uinode;

import java.util.Comparator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class I8 implements Comparator<I9> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(I9 i11, I9 i12) {
        if (i11.A00 < i12.A00) {
            return -1;
        }
        return i12.A00 < i11.A00 ? 1 : 0;
    }
}
