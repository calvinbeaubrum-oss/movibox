package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.internal.Preconditions;
import com.tn.lib.view.FlowLayout;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcfz extends FrameLayout implements zzcfq {
    final zzcgn zza;
    private final zzcgl zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbgu zze;
    private final long zzf;

    @Nullable
    private final zzcfr zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    public zzcfz(Context context, zzcgl zzcglVar, int i11, boolean z11, zzbgu zzbguVar, zzcgk zzcgkVar) {
        super(context);
        this.zzb = zzcglVar;
        this.zze = zzbguVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzc = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzcglVar.zzj());
        zzcfs zzcfsVar = zzcglVar.zzj().zza;
        zzcfr zzchdVar = i11 == 2 ? new zzchd(context, new zzcgm(context, zzcglVar.zzn(), zzcglVar.zzbr(), zzbguVar, zzcglVar.zzk()), zzcglVar, z11, zzcfs.zza(zzcglVar), zzcgkVar) : new zzcfp(context, zzcglVar, z11, zzcfs.zza(zzcglVar), zzcgkVar, new zzcgm(context, zzcglVar.zzn(), zzcglVar.zzbr(), zzbguVar, zzcglVar.zzk()));
        this.zzg = zzchdVar;
        View view = new View(context);
        this.zzd = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzchdVar, new FrameLayout.LayoutParams(-1, -1, 17));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzF)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzC)).booleanValue()) {
            zzn();
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzI)).longValue();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzE)).booleanValue();
        this.zzk = zBooleanValue;
        if (zzbguVar != null) {
            zzbguVar.zzd("spinner_used", true != zBooleanValue ? "0" : "1");
        }
        this.zza = new zzcgn(this);
        zzchdVar.zzr(this);
    }

    private final void zzJ() {
        if (this.zzb.zzi() == null || !this.zzi || this.zzj) {
            return;
        }
        this.zzb.zzi().getWindow().clearFlags(128);
        this.zzi = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzK(String str, String... strArr) {
        HashMap map = new HashMap();
        Integer numZzl = zzl();
        if (numZzl != null) {
            map.put("playerId", numZzl.toString());
        }
        map.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                map.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zzd("onVideoEvent", map);
    }

    private final boolean zzL() {
        return this.zzq.getParent() != null;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            final zzcfr zzcfrVar = this.zzg;
            if (zzcfrVar != null) {
                zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcft
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcfrVar.zzt();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z11) {
        super.onWindowFocusChanged(z11);
        if (z11) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfv
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzq(z11);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcfq
    public final void onWindowVisibilityChanged(int i11) {
        boolean z11;
        super.onWindowVisibilityChanged(i11);
        if (i11 == 0) {
            this.zza.zzb();
            z11 = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z11 = false;
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfy(this, z11));
    }

    public final void zzA(int i11) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzz(i11);
    }

    public final void zzB(int i11) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzA(i11);
    }

    public final void zzC(int i11) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzF)).booleanValue()) {
            this.zzc.setBackgroundColor(i11);
            this.zzd.setBackgroundColor(i11);
        }
    }

    public final void zzD(int i11) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzB(i11);
    }

    public final void zzE(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzF(int i11, int i12, int i13, int i14) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Set video bounds to x:" + i11 + ";y:" + i12 + ";w:" + i13 + ";h:" + i14);
        }
        if (i13 == 0 || i14 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i13, i14);
        layoutParams.setMargins(i11, i12, 0, 0);
        this.zzc.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzG(float f11) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzb.zze(f11);
        zzcfrVar.zzn();
    }

    public final void zzH(float f11, float f12) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar != null) {
            zzcfrVar.zzu(f11, f12);
        }
    }

    public final void zzI() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzb.zzd(false);
        zzcfrVar.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbS)).booleanValue()) {
            this.zza.zza();
        }
        zzK("ended", new String[0]);
        zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzb(String str, @Nullable String str2) {
        zzK("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzc(String str, @Nullable String str2) {
        zzK("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzd() {
        zzK("pause", new String[0]);
        zzJ();
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbS)).booleanValue()) {
            this.zza.zzb();
        }
        if (this.zzb.zzi() != null && !this.zzi) {
            boolean z11 = (this.zzb.zzi().getWindow().getAttributes().flags & 128) != 0;
            this.zzj = z11;
            if (!z11) {
                this.zzb.zzi().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzf() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar != null && this.zzm == 0) {
            float fZzc = zzcfrVar.zzc();
            zzcfr zzcfrVar2 = this.zzg;
            zzK("canplaythrough", "duration", String.valueOf(fZzc / 1000.0f), "videoWidth", String.valueOf(zzcfrVar2.zze()), "videoHeight", String.valueOf(zzcfrVar2.zzd()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzg() {
        this.zzd.setVisibility(4);
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzp();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzh() {
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfw(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzL()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzc.addView(this.zzq, new FrameLayout.LayoutParams(-1, -1));
            this.zzc.bringChildToFront(this.zzq);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfx(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzj(int i11, int i12) {
        if (this.zzk) {
            zzbfu zzbfuVar = zzbgc.zzH;
            int iMax = Math.max(i11 / ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar)).intValue(), 1);
            int iMax2 = Math.max(i12 / ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap != null && bitmap.getWidth() == iMax && this.zzp.getHeight() == iMax2) {
                return;
            }
            this.zzp = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            this.zzr = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfq
    public final void zzk() {
        if (this.zzh && zzL()) {
            this.zzc.removeView(this.zzq);
        }
        if (this.zzg == null || this.zzp == null) {
            return;
        }
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        if (this.zzg.getBitmap(this.zzp) != null) {
            this.zzr = true;
        }
        long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Spinner frame grab took " + jElapsedRealtime2 + "ms");
        }
        if (jElapsedRealtime2 > this.zzf) {
            zzcec.zzj("Spinner frame grab crossed jank threshold! Suspending spinner.");
            this.zzk = false;
            this.zzp = null;
            zzbgu zzbguVar = this.zze;
            if (zzbguVar != null) {
                zzbguVar.zzd("spinner_jank", Long.toString(jElapsedRealtime2));
            }
        }
    }

    @Nullable
    public final Integer zzl() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar != null) {
            return zzcfrVar.zzw();
        }
        return null;
    }

    public final void zzn() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        TextView textView = new TextView(zzcfrVar.getContext());
        Resources resourcesZze = com.google.android.gms.ads.internal.zzt.zzo().zze();
        textView.setText(String.valueOf(resourcesZze == null ? "AdMob - " : resourcesZze.getString(R.string.watermark_label_prefix)).concat(this.zzg.zzj()));
        textView.setTextColor(FlowLayout.SPACING_AUTO);
        textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
        this.zzc.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzc.bringChildToFront(textView);
    }

    public final void zzo() {
        this.zza.zza();
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar != null) {
            zzcfrVar.zzt();
        }
        zzJ();
    }

    public final /* synthetic */ void zzp() {
        zzK("firstFrameRendered", new String[0]);
    }

    public final /* synthetic */ void zzq(boolean z11) {
        zzK("windowFocusChanged", "hasWindowFocus", String.valueOf(z11));
    }

    public final void zzr(Integer num) {
        if (this.zzg == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzn)) {
            zzK("no_src", new String[0]);
        } else {
            this.zzg.zzC(this.zzn, this.zzo, num);
        }
    }

    public final void zzs() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzb.zzd(true);
        zzcfrVar.zzn();
    }

    public final void zzt() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        long jZza = zzcfrVar.zza();
        if (this.zzl == jZza || jZza <= 0) {
            return;
        }
        float f11 = jZza / 1000.0f;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue()) {
            zzK("timeupdate", "time", String.valueOf(f11), "totalBytes", String.valueOf(this.zzg.zzh()), "qoeCachedBytes", String.valueOf(this.zzg.zzf()), "qoeLoadedBytes", String.valueOf(this.zzg.zzg()), "droppedFrames", String.valueOf(this.zzg.zzb()), "reportTime", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
        } else {
            zzK("timeupdate", "time", String.valueOf(f11));
        }
        this.zzl = jZza;
    }

    public final void zzu() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzo();
    }

    public final void zzv() {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzp();
    }

    public final void zzw(int i11) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzq(i11);
    }

    public final void zzx(MotionEvent motionEvent) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzy(int i11) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzx(i11);
    }

    public final void zzz(int i11) {
        zzcfr zzcfrVar = this.zzg;
        if (zzcfrVar == null) {
            return;
        }
        zzcfrVar.zzy(i11);
    }
}
