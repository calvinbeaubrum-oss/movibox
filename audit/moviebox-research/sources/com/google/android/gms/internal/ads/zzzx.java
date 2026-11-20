package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzzx implements zzdm {
    private static final zzfxu zza = zzfxx.zza(new zzfxu() { // from class: com.google.android.gms.internal.ads.zzzv
        @Override // com.google.android.gms.internal.ads.zzfxu
        public final Object zza() {
            try {
                Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                Object objInvoke = cls.getMethod("build", new Class[0]).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]);
                objInvoke.getClass();
                return (zzdm) objInvoke;
            } catch (Exception e11) {
                throw new IllegalStateException(e11);
            }
        }
    });

    private zzzx() {
    }

    public /* synthetic */ zzzx(zzzw zzzwVar) {
    }
}
