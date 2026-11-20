package com.facebook.ads.redexgen.uinode;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class QL extends ContentObserver {
    public final QS A00;

    public QL(Handler handler, QS qs2) {
        super(handler);
        this.A00 = qs2;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return false;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z11) {
        this.A00.A0a();
    }
}
