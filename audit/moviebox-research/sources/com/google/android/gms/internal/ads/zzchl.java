package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzchl implements zzbng {
    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgl zzcglVar = (zzcgl) obj;
        zzcki zzckiVarZzq = zzcglVar.zzq();
        if (zzckiVarZzq == null) {
            try {
                zzcki zzckiVar = new zzcki(zzcglVar, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzcglVar.zzC(zzckiVar);
                zzckiVarZzq = zzckiVar;
            } catch (NullPointerException e11) {
                e = e11;
                zzcec.zzh("Unable to parse videoMeta message.", e);
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e12) {
                e = e12;
                zzcec.zzh("Unable to parse videoMeta message.", e);
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float f11 = Float.parseFloat((String) map.get("duration"));
        boolean zEquals = "1".equals(map.get("muted"));
        float f12 = Float.parseFloat((String) map.get("currentTime"));
        int i11 = Integer.parseInt((String) map.get("playbackState"));
        int i12 = 0;
        if (i11 >= 0 && i11 <= 3) {
            i12 = i11;
        }
        String str = (String) map.get("aspectRatio");
        float f13 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (zzcec.zzm(3)) {
            zzcec.zze("Video Meta GMSG: currentTime : " + f12 + " , duration : " + f11 + " , isMuted : " + zEquals + " , playbackState : " + i12 + " , aspectRatio : " + str);
        }
        zzckiVarZzq.zzc(f12, f11, i12, zEquals, f13);
    }
}
