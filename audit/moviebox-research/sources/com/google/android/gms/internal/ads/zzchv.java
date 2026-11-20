package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzchv implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzchw zze;

    public zzchv(zzchw zzchwVar, String str, String str2, String str3, String str4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = zzchwVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x00ab  */
    @Override // java.lang.Runnable
    public final void run() {
        byte b11;
        HashMap map = new HashMap();
        map.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
        map.put("src", this.zza);
        if (!TextUtils.isEmpty(this.zzb)) {
            map.put("cachedSrc", this.zzb);
        }
        switch (this.zzc) {
            case "interrupted":
                b11 = 3;
                break;
            case "badUrl":
                b11 = 8;
                break;
            case "inProgress":
                b11 = 2;
                break;
            case "downloadTimeout":
                b11 = 9;
                break;
            case "contentLengthMissing":
                b11 = 0;
                break;
            case "playerFailed":
                b11 = 5;
                break;
            case "sizeExceeded":
                b11 = Ascii.VT;
                break;
            case "externalAbort":
                b11 = 10;
                break;
            case "noop":
                b11 = 4;
                break;
            case "error":
                b11 = 1;
                break;
            case "expireFailed":
                b11 = 6;
                break;
            case "noCacheDir":
                b11 = 7;
                break;
            default:
                b11 = -1;
                break;
        }
        String str = "internal";
        switch (b11) {
            case 6:
            case 7:
                str = "io";
                break;
            case 8:
            case 9:
                str = "network";
                break;
            case 10:
            case 11:
                str = "policy";
                break;
        }
        map.put("type", str);
        map.put("reason", this.zzc);
        if (!TextUtils.isEmpty(this.zzd)) {
            map.put("message", this.zzd);
        }
        zzchw.zze(this.zze, "onPrecacheEvent", map);
    }
}
