package com.google.android.gms.internal.ads;

import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzzy implements zzcp {
    private final zzdm zza;

    public zzzy(zzdm zzdmVar) {
        this.zza = zzdmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcq zza(Context context, zzt zztVar, zzt zztVar2, zzw zzwVar, zzdn zzdnVar, Executor executor, List list, long j11) throws zzdl {
        try {
            Constructor<?> constructor = Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(zzdm.class);
            Object[] objArr = new Object[1];
            try {
                objArr[0] = this.zza;
                return ((zzcp) constructor.newInstance(objArr)).zza(context, zztVar, zztVar2, zzwVar, zzdnVar, executor, list, 0L);
            } catch (Exception e11) {
                e = e11;
                if (e instanceof zzdl) {
                    throw ((zzdl) e);
                }
                throw new zzdl(e, C.TIME_UNSET);
            }
        } catch (Exception e12) {
            e = e12;
        }
    }
}
