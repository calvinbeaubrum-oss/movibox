package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.Nullable;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.common.util.concurrent.s;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeij {

    @Nullable
    private MeasurementManagerFutures zza;
    private final Context zzb;

    public zzeij(Context context) {
        this.zzb = context;
    }

    public final s zza() {
        MeasurementManagerFutures measurementManagerFuturesA = MeasurementManagerFutures.a(this.zzb);
        this.zza = measurementManagerFuturesA;
        return measurementManagerFuturesA == null ? zzgen.zzg(new IllegalStateException("MeasurementManagerFutures is null")) : measurementManagerFuturesA.b();
    }

    public final s zzb(Uri uri, InputEvent inputEvent) {
        MeasurementManagerFutures measurementManagerFutures = this.zza;
        Objects.requireNonNull(measurementManagerFutures);
        return measurementManagerFutures.c(uri, inputEvent);
    }
}
