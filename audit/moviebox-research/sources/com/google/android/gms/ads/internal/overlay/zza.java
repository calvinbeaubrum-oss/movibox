package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcec;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zza {
    public static final boolean zza(Context context, Intent intent, zzaa zzaaVar, @Nullable zzy zzyVar, boolean z11) {
        if (z11) {
            return zzc(context, intent.getData(), zzaaVar, zzyVar);
        }
        try {
            com.google.android.gms.ads.internal.util.zze.zza("Launching an intent: " + intent.toURI());
            com.google.android.gms.ads.internal.zzt.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzS(context, intent);
            if (zzaaVar != null) {
                zzaaVar.zzg();
            }
            if (zzyVar != null) {
                zzyVar.zza(true);
            }
            return true;
        } catch (ActivityNotFoundException e11) {
            zzcec.zzj(e11.getMessage());
            if (zzyVar != null) {
                zzyVar.zza(false);
            }
            return false;
        }
    }

    public static final boolean zzb(Context context, @Nullable zzc zzcVar, zzaa zzaaVar, @Nullable zzy zzyVar) {
        int i11 = 0;
        if (zzcVar == null) {
            zzcec.zzj("No intent data for launcher overlay.");
            return false;
        }
        zzbgc.zza(context);
        Intent intent = zzcVar.zzh;
        if (intent != null) {
            return zza(context, intent, zzaaVar, zzyVar, zzcVar.zzj);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzcVar.zzb)) {
            zzcec.zzj("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(zzcVar.zzc)) {
            intent2.setData(Uri.parse(zzcVar.zzb));
        } else {
            String str = zzcVar.zzb;
            intent2.setDataAndType(Uri.parse(str), zzcVar.zzc);
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzcVar.zzd)) {
            intent2.setPackage(zzcVar.zzd);
        }
        if (!TextUtils.isEmpty(zzcVar.zze)) {
            String[] strArrSplit = zzcVar.zze.split("/", 2);
            if (strArrSplit.length < 2) {
                zzcec.zzj("Could not parse component name from open GMSG: ".concat(String.valueOf(zzcVar.zze)));
                return false;
            }
            intent2.setClassName(strArrSplit[0], strArrSplit[1]);
        }
        String str2 = zzcVar.zzf;
        if (!TextUtils.isEmpty(str2)) {
            try {
                i11 = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                zzcec.zzj("Could not parse intent flags.");
            }
            intent2.addFlags(i11);
        }
        if (((Boolean) zzba.zzc().zza(zzbgc.zzev)).booleanValue()) {
            intent2.addFlags(ASTNode.DEOP);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzeu)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzp();
                com.google.android.gms.ads.internal.util.zzt.zzo(context, intent2);
            }
        }
        return zza(context, intent2, zzaaVar, zzyVar, zzcVar.zzj);
    }

    private static final boolean zzc(Context context, Uri uri, zzaa zzaaVar, zzy zzyVar) {
        int iZzm;
        try {
            iZzm = com.google.android.gms.ads.internal.zzt.zzp().zzm(context, uri);
            if (zzaaVar != null) {
                zzaaVar.zzg();
            }
        } catch (ActivityNotFoundException e11) {
            zzcec.zzj(e11.getMessage());
            iZzm = 6;
        }
        if (zzyVar != null) {
            zzyVar.zzb(iZzm);
        }
        return iZzm == 5;
    }
}
