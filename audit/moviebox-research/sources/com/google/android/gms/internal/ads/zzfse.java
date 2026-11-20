package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfse implements zzfqu {
    private final Object zza;
    private final zzfsf zzb;
    private final zzfsq zzc;
    private final zzfqr zzd;

    public zzfse(@NonNull Object obj, @NonNull zzfsf zzfsfVar, @NonNull zzfsq zzfsqVar, @NonNull zzfqr zzfqrVar) {
        this.zza = obj;
        this.zzb = zzfsfVar;
        this.zzc = zzfsqVar;
        this.zzd = zzfqrVar;
    }

    @Nullable
    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzatp zzatpVarZza = zzatq.zza();
        zzatpVarZza.zzc(5);
        zzatpVarZza.zza(zzgyl.zzv(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzatq) zzatpVarZza.zzal()).zzax(), 11);
    }

    @Nullable
    private final synchronized byte[] zzj(Map map, Map map2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e11) {
            this.zzd.zzc(2007, System.currentTimeMillis() - jCurrentTimeMillis, e11);
            return null;
        }
        return (byte[]) this.zza.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.zza, null, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzfqu
    @Nullable
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map mapZza;
        mapZza = this.zzc.zza();
        mapZza.put("f", "c");
        mapZza.put("ctx", context);
        mapZza.put("cs", str2);
        mapZza.put("aid", null);
        mapZza.put(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, view);
        mapZza.put("act", activity);
        return zzi(zzj(null, mapZza));
    }

    @Override // com.google.android.gms.internal.ads.zzfqu
    @Nullable
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map mapZzc;
        mapZzc = this.zzc.zzc();
        mapZzc.put("f", "v");
        mapZzc.put("ctx", context);
        mapZzc.put("aid", null);
        mapZzc.put(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, view);
        mapZzc.put("act", activity);
        return zzi(zzj(null, mapZzc));
    }

    @Override // com.google.android.gms.internal.ads.zzfqu
    @Nullable
    public final synchronized String zzc(Context context, String str) {
        Map mapZzb;
        mapZzb = this.zzc.zzb();
        mapZzb.put("f", CampaignEx.JSON_KEY_AD_Q);
        mapZzb.put("ctx", context);
        mapZzb.put("aid", null);
        return zzi(zzj(null, mapZzb));
    }

    @Override // com.google.android.gms.internal.ads.zzfqu
    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzfso {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap map = new HashMap();
            map.put("t", new Throwable());
            map.put("aid", null);
            map.put("evt", motionEvent);
            this.zza.getClass().getDeclaredMethod("he", Map.class).invoke(this.zza, map);
            this.zzd.zzd(3003, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e11) {
            throw new zzfso(2005, e11);
        }
    }

    public final synchronized int zze() throws zzfso {
        try {
        } catch (Exception e11) {
            throw new zzfso(2006, e11);
        }
        return ((Integer) this.zza.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zza, new Object[0])).intValue();
    }

    public final zzfsf zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() throws zzfso {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.zza.getClass().getDeclaredMethod(CampaignEx.JSON_NATIVE_VIDEO_CLOSE, new Class[0]).invoke(this.zza, new Object[0]);
            this.zzd.zzd(3001, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e11) {
            throw new zzfso(2003, e11);
        }
    }

    public final synchronized boolean zzh() throws zzfso {
        try {
        } catch (Exception e11) {
            throw new zzfso(2001, e11);
        }
        return ((Boolean) this.zza.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zza, new Object[0])).booleanValue();
    }
}
