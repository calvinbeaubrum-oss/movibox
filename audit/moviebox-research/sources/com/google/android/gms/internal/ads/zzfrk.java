package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfrk {
    private final Context zza;
    private final Executor zzb;
    private final zzfqr zzc;
    private final zzfqt zzd;
    private final zzfrj zze;
    private final zzfrj zzf;
    private Task zzg;
    private Task zzh;

    public zzfrk(Context context, Executor executor, zzfqr zzfqrVar, zzfqt zzfqtVar, zzfrh zzfrhVar, zzfri zzfriVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfqrVar;
        this.zzd = zzfqtVar;
        this.zze = zzfrhVar;
        this.zzf = zzfriVar;
    }

    public static zzfrk zze(@NonNull Context context, @NonNull Executor executor, @NonNull zzfqr zzfqrVar, @NonNull zzfqt zzfqtVar) {
        final zzfrk zzfrkVar = new zzfrk(context, executor, zzfqrVar, zzfqtVar, new zzfrh(), new zzfri());
        if (zzfrkVar.zzd.zzd()) {
            zzfrkVar.zzg = zzfrkVar.zzh(new Callable() { // from class: com.google.android.gms.internal.ads.zzfre
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzc();
                }
            });
        } else {
            zzfrkVar.zzg = Tasks.forResult(zzfrkVar.zze.zza());
        }
        zzfrkVar.zzh = zzfrkVar.zzh(new Callable() { // from class: com.google.android.gms.internal.ads.zzfrf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzd();
            }
        });
        return zzfrkVar;
    }

    private static zzatd zzg(@NonNull Task task, @NonNull zzatd zzatdVar) {
        return !task.isSuccessful() ? zzatdVar : (zzatd) task.getResult();
    }

    private final Task zzh(@NonNull Callable callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, new OnFailureListener() { // from class: com.google.android.gms.internal.ads.zzfrg
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.zza.zzf(exc);
            }
        });
    }

    public final zzatd zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzatd zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    public final /* synthetic */ zzatd zzc() throws Exception {
        zzasg zzasgVarZza = zzatd.zza();
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zza);
        String id2 = advertisingIdInfo.getId();
        if (id2 != null && id2.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID uuidFromString = UUID.fromString(id2);
            byte[] bArr = new byte[16];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.putLong(uuidFromString.getMostSignificantBits());
            byteBufferWrap.putLong(uuidFromString.getLeastSignificantBits());
            id2 = Base64.encodeToString(bArr, 11);
        }
        if (id2 != null) {
            zzasgVarZza.zzs(id2);
            zzasgVarZza.zzr(advertisingIdInfo.isLimitAdTrackingEnabled());
            zzasgVarZza.zzab(6);
        }
        return (zzatd) zzasgVarZza.zzal();
    }

    public final /* synthetic */ zzatd zzd() throws Exception {
        Context context = this.zza;
        return zzfqz.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    public final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1L, exc);
    }
}
