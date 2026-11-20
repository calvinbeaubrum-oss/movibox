package com.facebook.ads.redexgen.uinode;

import java.io.File;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1944bp implements AnonymousClass03<File> {
    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass03
    public final AnonymousClass02<File> A3M(File file, C0L c0l) {
        return file.exists() ? new AnonymousClass02<>(true, file) : new AnonymousClass02<>(false, null);
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass03
    public final void A4U(File file, C0L c0l) {
    }
}
