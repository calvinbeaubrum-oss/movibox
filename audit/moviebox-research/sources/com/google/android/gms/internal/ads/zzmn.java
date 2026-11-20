package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzmn {

    @Nullable
    private final PowerManager zza;

    public zzmn(Context context) {
        this.zza = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
