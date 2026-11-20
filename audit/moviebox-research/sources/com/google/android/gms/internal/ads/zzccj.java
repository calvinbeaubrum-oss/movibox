package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzccj {
    public static Uri zza(String str, String str2, String str3) {
        int iIndexOf = str.indexOf("&adurl");
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("?adurl");
        }
        if (iIndexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i11 = iIndexOf + 1;
        return Uri.parse(str.substring(0, i11) + str2 + "=" + str3 + "&" + str.substring(i11));
    }

    public static String zzb(Uri uri, Context context) {
        String strZza;
        if (com.google.android.gms.ads.internal.zzt.zzn().zzp(context) && (strZza = com.google.android.gms.ads.internal.zzt.zzn().zza(context)) != null) {
            String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzae);
            String string = uri.toString();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzad)).booleanValue() && string.contains(str)) {
                com.google.android.gms.ads.internal.zzt.zzn().zzj(context, strZza);
                return zzd(string, context).replace(str, strZza);
            }
            if (!TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
                return string;
            }
            String string2 = zza(zzd(string, context), "fbs_aeid", strZza).toString();
            com.google.android.gms.ads.internal.zzt.zzn().zzj(context, strZza);
            return string2;
        }
        return uri.toString();
    }

    public static String zzc(String str, Context context, boolean z11) {
        String strZza;
        if ((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzal)).booleanValue() && !z11) || !com.google.android.gms.ads.internal.zzt.zzn().zzp(context) || TextUtils.isEmpty(str) || (strZza = com.google.android.gms.ads.internal.zzt.zzn().zza(context)) == null) {
            return str;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzae);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzad)).booleanValue() && str.contains(str2)) {
            if (com.google.android.gms.ads.internal.zzt.zzp().zzi(str)) {
                com.google.android.gms.ads.internal.zzt.zzn().zzj(context, strZza);
                return zzd(str, context).replace(str2, strZza);
            }
            if (!com.google.android.gms.ads.internal.zzt.zzp().zzj(str)) {
                return str;
            }
            com.google.android.gms.ads.internal.zzt.zzn().zzk(context, strZza);
            return zzd(str, context).replace(str2, strZza);
        }
        if (str.contains("fbs_aeid")) {
            return str;
        }
        if (com.google.android.gms.ads.internal.zzt.zzp().zzi(str)) {
            com.google.android.gms.ads.internal.zzt.zzn().zzj(context, strZza);
            return zza(zzd(str, context), "fbs_aeid", strZza).toString();
        }
        if (!com.google.android.gms.ads.internal.zzt.zzp().zzj(str)) {
            return str;
        }
        com.google.android.gms.ads.internal.zzt.zzn().zzk(context, strZza);
        return zza(zzd(str, context), "fbs_aeid", strZza).toString();
    }

    private static String zzd(String str, Context context) {
        String strZzd = com.google.android.gms.ads.internal.zzt.zzn().zzd(context);
        String strZzb = com.google.android.gms.ads.internal.zzt.zzn().zzb(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(strZzd)) {
            str = zza(str, "gmp_app_id", strZzd).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(strZzb)) ? str : zza(str, "fbs_aiid", strZzb).toString();
    }
}
