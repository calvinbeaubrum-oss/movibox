package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.transsion.push.PushConstants;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbmo implements zzbng {
    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        if (TextUtils.isEmpty((CharSequence) map.get(PushConstants.PROVIDER_FIELD_APP_ID))) {
            com.google.android.gms.ads.internal.util.zze.zza("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzfvm zzfvmVarZzl = zzfvn.zzl();
        zzfvmVarZzl.zzb((String) map.get(PushConstants.PROVIDER_FIELD_APP_ID));
        zzfvmVarZzl.zzh(zzcjkVar.getWidth());
        zzfvmVarZzl.zzg(zzcjkVar.zzF().getWindowToken());
        if (map.containsKey("gravityX") && map.containsKey("gravityY")) {
            zzfvmVarZzl.zzd(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        } else {
            zzfvmVarZzl.zzd(81);
        }
        if (map.containsKey("verticalMargin")) {
            zzfvmVarZzl.zze(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzfvmVarZzl.zze(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzfvmVarZzl.zza((String) map.get("enifd"));
        }
        try {
            com.google.android.gms.ads.internal.zzt.zzj().zzj(zzcjkVar, zzfvmVarZzl.zzi());
        } catch (NullPointerException e11) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "DefaultGmsgHandlers.ShowLMDOverlay");
            com.google.android.gms.ads.internal.util.zze.zza("Missing parameters for LMD Overlay show request");
        }
    }
}
