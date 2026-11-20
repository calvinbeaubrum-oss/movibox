package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbvv extends zzbvw implements zzbng {
    DisplayMetrics zza;
    int zzb;
    int zzc;
    int zzd;
    int zze;
    int zzf;
    int zzg;
    private final zzcjk zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbfm zzk;
    private float zzl;
    private int zzm;

    public zzbvv(zzcjk zzcjkVar, Context context, zzbfm zzbfmVar) {
        super(zzcjkVar, "");
        this.zzb = -1;
        this.zzc = -1;
        this.zzd = -1;
        this.zze = -1;
        this.zzf = -1;
        this.zzg = -1;
        this.zzh = zzcjkVar;
        this.zzi = context;
        this.zzk = zzbfmVar;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectPut;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        com.google.android.gms.ads.internal.client.zzay.zzb();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = zzcdv.zzv(displayMetrics, displayMetrics.widthPixels);
        com.google.android.gms.ads.internal.client.zzay.zzb();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = zzcdv.zzv(displayMetrics2, displayMetrics2.heightPixels);
        Activity activityZzi = this.zzh.zzi();
        if (activityZzi == null || activityZzi.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            com.google.android.gms.ads.internal.zzt.zzp();
            int[] iArrZzP = com.google.android.gms.ads.internal.util.zzt.zzP(activityZzi);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            this.zzd = zzcdv.zzv(this.zza, iArrZzP[0]);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            this.zze = zzcdv.zzv(this.zza, iArrZzP[1]);
        }
        if (this.zzh.zzO().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            this.zzh.measure(0, 0);
        }
        zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbvu zzbvuVar = new zzbvu();
        zzbfm zzbfmVar = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbvuVar.zze(zzbfmVar.zza(intent));
        zzbfm zzbfmVar2 = this.zzk;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbvuVar.zzc(zzbfmVar2.zza(intent2));
        zzbvuVar.zza(this.zzk.zzb());
        zzbvuVar.zzd(this.zzk.zzc());
        zzbvuVar.zzb(true);
        boolean z11 = zzbvuVar.zza;
        boolean z12 = zzbvuVar.zzb;
        boolean z13 = zzbvuVar.zzc;
        boolean z14 = zzbvuVar.zzd;
        boolean z15 = zzbvuVar.zze;
        zzcjk zzcjkVar = this.zzh;
        try {
            jSONObjectPut = new JSONObject().put("sms", z11).put("tel", z12).put("calendar", z13).put("storePicture", z14).put("inlineVideo", z15);
        } catch (JSONException e11) {
            zzcec.zzh("Error occurred while obtaining the MRAID capabilities.", e11);
            jSONObjectPut = null;
        }
        zzcjkVar.zze("onDeviceFeaturesReceived", jSONObjectPut);
        int[] iArr = new int[2];
        this.zzh.getLocationOnScreen(iArr);
        zzb(com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, iArr[0]), com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, iArr[1]));
        if (zzcec.zzm(2)) {
            zzcec.zzi("Dispatching Ready Event.");
        }
        zzi(this.zzh.zzn().zza);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006b A[PHI: r3
  0x006b: PHI (r3v1 int) = (r3v0 int), (r3v4 int) binds: [B:11:0x0042, B:17:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    public final void zzb(int i11, int i12) {
        int i13;
        Context context = this.zzi;
        int i14 = 0;
        if (context instanceof Activity) {
            com.google.android.gms.ads.internal.zzt.zzp();
            i13 = com.google.android.gms.ads.internal.util.zzt.zzQ((Activity) context)[0];
        } else {
            i13 = 0;
        }
        if (this.zzh.zzO() == null || !this.zzh.zzO().zzi()) {
            zzcjk zzcjkVar = this.zzh;
            int width = zzcjkVar.getWidth();
            int height = zzcjkVar.getHeight();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzR)).booleanValue()) {
                if (width == 0) {
                    width = this.zzh.zzO() != null ? this.zzh.zzO().zzb : 0;
                }
                if (height != 0) {
                    i14 = height;
                } else if (this.zzh.zzO() != null) {
                    i14 = this.zzh.zzO().zza;
                }
            } else {
                i14 = height;
            }
            this.zzf = com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, width);
            this.zzg = com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, i14);
        }
        zzg(i11, i12 - i13, this.zzf, this.zzg);
        this.zzh.zzN().zzC(i11, i12);
    }
}
