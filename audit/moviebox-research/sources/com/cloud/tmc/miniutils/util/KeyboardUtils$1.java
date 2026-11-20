package com.cloud.tmc.miniutils.util;

import android.os.Bundle;
import android.os.ResultReceiver;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class KeyboardUtils$1 extends ResultReceiver {
    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i11, Bundle bundle) {
        if (i11 == 1 || i11 == 3) {
            p.c();
        }
    }
}
