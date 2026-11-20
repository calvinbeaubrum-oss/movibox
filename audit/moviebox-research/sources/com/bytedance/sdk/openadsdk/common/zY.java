package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends Tf {
    public zY(@NonNull Context context) {
        super(context);
        this.pFF = false;
    }

    @Override // com.bytedance.sdk.openadsdk.common.Tf
    public void sc() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.zY.1
            @Override // java.lang.Runnable
            public void run() {
                zY zYVar = zY.this;
                if (zYVar.f27694sc != null) {
                    zYVar.setVisibility(0);
                }
            }
        });
    }

    public void sc(Sfl sfl, String str, int i11, String str2, long j11, boolean z11, int i12, long j12) {
        if (getVisibility() != 8) {
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, i11, str2, SystemClock.elapsedRealtime() - j11, z11, i12, j12);
            super.pFF();
        }
    }
}
