package com.facebook.ads.redexgen.uinode;

import android.content.DialogInterface;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class M0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ UY A00;

    public M0(UY uy2) {
        this.A00 = uy2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i11) {
        dialogInterface.cancel();
    }
}
