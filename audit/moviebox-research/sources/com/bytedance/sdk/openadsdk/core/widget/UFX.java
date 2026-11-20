package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX extends Qj {
    private long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f28542sc;

    public UFX(@NonNull Context context) {
        super(context);
        setVisibility(8);
        setClickable(true);
    }

    public boolean We() {
        return this.f28542sc > 0 && this.pFF > 0;
    }

    public long getDisplayDuration() {
        if (this.f28542sc == 0) {
            return 0L;
        }
        if (this.pFF == 0) {
            this.pFF = SystemClock.elapsedRealtime();
        }
        return this.pFF - this.f28542sc;
    }

    public void pFF(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11) {
        if (isShown()) {
            return;
        }
        pFF();
        setVisibility(0);
        this.f28542sc = SystemClock.elapsedRealtime();
        sc(sfl, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.Qj
    public boolean sc() {
        return false;
    }

    public void zY() {
        setVisibility(8);
        if (this.f28542sc != 0) {
            this.pFF = SystemClock.elapsedRealtime();
        }
    }
}
