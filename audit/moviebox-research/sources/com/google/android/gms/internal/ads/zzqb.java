package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface zzqb {
    int zza(zzam zzamVar);

    long zzb(boolean z11);

    zzcg zzc();

    zzpg zzd(zzam zzamVar);

    void zze(zzam zzamVar, int i11, @Nullable int[] iArr) throws zzpw;

    void zzf();

    void zzg();

    void zzh();

    void zzi();

    void zzj() throws zzqa;

    void zzk();

    void zzl(zzk zzkVar);

    void zzm(int i11);

    void zzn(zzl zzlVar);

    void zzo(zzel zzelVar);

    void zzp(zzpy zzpyVar);

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    void zzq(int i11, int i12);

    void zzr(zzcg zzcgVar);

    void zzs(@Nullable zzpb zzpbVar);

    @RequiresApi(23)
    void zzt(@Nullable AudioDeviceInfo audioDeviceInfo);

    void zzu(boolean z11);

    void zzv(float f11);

    boolean zzw(ByteBuffer byteBuffer, long j11, int i11) throws zzqa, zzpx;

    boolean zzx();

    boolean zzy();

    boolean zzz(zzam zzamVar);
}
