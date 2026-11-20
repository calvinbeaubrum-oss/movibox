package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzezh implements zzexq {
    private final Context zza;
    private final String zzb;
    private final zzgey zzc;

    public zzezh(@Nullable zzbzg zzbzgVar, Context context, String str, zzgey zzgeyVar) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzgeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 42;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzezg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzezi(new JSONObject());
            }
        });
    }
}
