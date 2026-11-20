package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbp;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzblw;
import com.google.android.gms.internal.ads.zzbly;
import com.google.android.gms.internal.ads.zzbvw;
import com.google.android.gms.internal.ads.zzbwm;
import com.google.android.gms.internal.ads.zzbws;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcjk;
import com.google.android.gms.internal.ads.zzcjx;
import com.google.android.gms.internal.ads.zzckw;
import com.google.android.gms.internal.ads.zzcky;
import com.google.android.gms.internal.ads.zzcla;
import com.google.android.gms.internal.ads.zzdbk;
import com.google.android.gms.internal.ads.zzdiu;
import com.google.android.gms.internal.ads.zzeht;
import com.google.android.gms.internal.ads.zzehu;
import com.google.android.gms.internal.ads.zzfod;
import com.google.android.gms.internal.ads.zzftt;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zzm extends zzbws implements zzae {
    static final int zza = Color.argb(0, 0, 0, 0);
    protected final Activity zzb;

    @Nullable
    AdOverlayInfoParcel zzc;
    zzcjk zzd;
    zzi zze;
    zzs zzf;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    zzh zzl;
    private Runnable zzq;
    private boolean zzr;
    private boolean zzs;
    private Toolbar zzw;
    boolean zzg = false;
    boolean zzj = false;
    boolean zzk = false;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzo = new Object();
    private final View.OnClickListener zzp = new zzf(this);
    private boolean zzt = false;
    private boolean zzu = false;
    private boolean zzv = true;

    public zzm(Activity activity) {
        this.zzb = activity;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:17:0x0036 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0038  */
    private final void zzJ(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzj zzjVar;
        int i11;
        com.google.android.gms.ads.internal.zzj zzjVar2;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = (adOverlayInfoParcel2 == null || (zzjVar2 = adOverlayInfoParcel2.zzo) == null || !zzjVar2.zzb) ? false : true;
        boolean zZzd = com.google.android.gms.ads.internal.zzt.zzq().zzd(this.zzb, configuration);
        if (!this.zzk || z13) {
            if (zZzd) {
                if (((Boolean) zzba.zzc().zza(zzbgc.zzaE)).booleanValue()) {
                    z11 = false;
                }
            }
            adOverlayInfoParcel = this.zzc;
            if (adOverlayInfoParcel != null && (zzjVar = adOverlayInfoParcel.zzo) != null && zzjVar.zzg) {
                z12 = true;
            }
        } else if (((Boolean) zzba.zzc().zza(zzbgc.zzaF)).booleanValue()) {
            if (zZzd) {
                if (((Boolean) zzba.zzc().zza(zzbgc.zzaE)).booleanValue()) {
                    z11 = false;
                }
            }
            adOverlayInfoParcel = this.zzc;
            if (adOverlayInfoParcel != null) {
                z12 = true;
            }
        } else {
            z11 = false;
        }
        Window window = this.zzb.getWindow();
        if (((Boolean) zzba.zzc().zza(zzbgc.zzbe)).booleanValue()) {
            View decorView = window.getDecorView();
            if (z11) {
                i11 = z12 ? 5894 : 5380;
            } else {
                i11 = 256;
            }
            decorView.setSystemUiVisibility(i11);
            return;
        }
        if (!z11) {
            window.addFlags(2048);
            window.clearFlags(1024);
            return;
        }
        window.addFlags(1024);
        window.clearFlags(2048);
        if (z12) {
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        }
    }

    private static final void zzK(@Nullable zzfod zzfodVar, @Nullable View view) {
        if (zzfodVar == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzA().zzh(zzfodVar, view);
    }

    public final void zzA(int i11) {
        if (this.zzb.getApplicationInfo().targetSdkVersion >= ((Integer) zzba.zzc().zza(zzbgc.zzfY)).intValue()) {
            if (this.zzb.getApplicationInfo().targetSdkVersion <= ((Integer) zzba.zzc().zza(zzbgc.zzfZ)).intValue()) {
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= ((Integer) zzba.zzc().zza(zzbgc.zzga)).intValue()) {
                    if (i12 <= ((Integer) zzba.zzc().zza(zzbgc.zzgb)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(i11);
        } catch (Throwable th2) {
            com.google.android.gms.ads.internal.zzt.zzo().zzv(th2, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzB(boolean z11) {
        if (z11) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    public final void zzC(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzb);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView(this.zzh);
        this.zzs = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    public final void zzD(boolean z11) throws zzg {
        boolean z12;
        if (!this.zzs) {
            this.zzb.requestWindowFeature(1);
        }
        Window window = this.zzb.getWindow();
        if (window == null) {
            throw new zzg("Invalid activity, no window available.");
        }
        zzcjk zzcjkVar = this.zzc.zzd;
        zzcky zzckyVarZzN = zzcjkVar != null ? zzcjkVar.zzN() : null;
        boolean z13 = zzckyVarZzN != null && zzckyVarZzN.zzL();
        this.zzm = false;
        if (z13) {
            int i11 = this.zzc.zzj;
            if (i11 == 6) {
                z12 = this.zzb.getResources().getConfiguration().orientation == 1;
                this.zzm = z12;
            } else if (i11 == 7) {
                z12 = this.zzb.getResources().getConfiguration().orientation == 2;
                this.zzm = z12;
            } else {
                z12 = false;
            }
        } else {
            z12 = false;
        }
        zzcec.zze("Delay onShow to next orientation change: " + z12);
        zzA(this.zzc.zzj);
        window.setFlags(16777216, 16777216);
        zzcec.zze("Hardware acceleration on the AdActivity window enabled.");
        if (this.zzk) {
            this.zzl.setBackgroundColor(zza);
        } else {
            this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.zzb.setContentView(this.zzl);
        this.zzs = true;
        if (z11) {
            try {
                com.google.android.gms.ads.internal.zzt.zzz();
                Activity activity = this.zzb;
                zzcjk zzcjkVar2 = this.zzc.zzd;
                zzcla zzclaVarZzO = zzcjkVar2 != null ? zzcjkVar2.zzO() : null;
                zzcjk zzcjkVar3 = this.zzc.zzd;
                String strZzT = zzcjkVar3 != null ? zzcjkVar3.zzT() : null;
                AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
                zzcei zzceiVar = adOverlayInfoParcel.zzm;
                zzcjk zzcjkVar4 = adOverlayInfoParcel.zzd;
                zzcjk zzcjkVarZza = zzcjx.zza(activity, zzclaVarZzO, strZzT, true, z13, null, null, zzceiVar, null, null, zzcjkVar4 != null ? zzcjkVar4.zzj() : null, zzbbp.zza(), null, null, null, null);
                this.zzd = zzcjkVarZza;
                zzcky zzckyVarZzN2 = zzcjkVarZza.zzN();
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                zzblw zzblwVar = adOverlayInfoParcel2.zzp;
                zzbly zzblyVar = adOverlayInfoParcel2.zze;
                zzaa zzaaVar = adOverlayInfoParcel2.zzi;
                zzcjk zzcjkVar5 = adOverlayInfoParcel2.zzd;
                zzckyVarZzN2.zzN(null, zzblwVar, null, zzblyVar, zzaaVar, true, null, zzcjkVar5 != null ? zzcjkVar5.zzN().zzd() : null, null, null, null, null, null, null, null, null, null, null, null);
                this.zzd.zzN().zzB(new zzckw() { // from class: com.google.android.gms.ads.internal.overlay.zze
                    @Override // com.google.android.gms.internal.ads.zzckw
                    public final void zza(boolean z14, int i12, String str, String str2) {
                        zzcjk zzcjkVar6 = this.zza.zzd;
                        if (zzcjkVar6 != null) {
                            zzcjkVar6.zzY();
                        }
                    }
                });
                AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
                String str = adOverlayInfoParcel3.zzl;
                if (str != null) {
                    this.zzd.loadUrl(str);
                } else {
                    String str2 = adOverlayInfoParcel3.zzh;
                    if (str2 == null) {
                        throw new zzg("No URL or HTML to display in ad overlay.");
                    }
                    this.zzd.loadDataWithBaseURL(adOverlayInfoParcel3.zzf, str2, "text/html", "UTF-8", null);
                }
                zzcjk zzcjkVar6 = this.zzc.zzd;
                if (zzcjkVar6 != null) {
                    zzcjkVar6.zzat(this);
                }
            } catch (Exception e11) {
                zzcec.zzh("Error obtaining webview.", e11);
                throw new zzg("Could not obtain webview for the overlay.", e11);
            }
        } else {
            zzcjk zzcjkVar7 = this.zzc.zzd;
            this.zzd = zzcjkVar7;
            zzcjkVar7.zzal(this.zzb);
        }
        if (this.zzc.zzw) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.zzd.zzG(), false);
        }
        this.zzd.zzag(this);
        zzcjk zzcjkVar8 = this.zzc.zzd;
        if (zzcjkVar8 != null) {
            zzK(zzcjkVar8.zzR(), this.zzl);
        }
        if (this.zzc.zzk != 5) {
            ViewParent parent = this.zzd.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.zzd.zzF());
            }
            if (this.zzk) {
                this.zzd.zzak();
            }
            if (!this.zzc.zzw || Build.VERSION.SDK_INT < 24) {
                this.zzl.addView(this.zzd.zzF(), -1, -1);
            } else {
                Toolbar toolbar = new Toolbar(this.zzb);
                this.zzw = toolbar;
                toolbar.setId(View.generateViewId());
                this.zzd.zzF().setId(View.generateViewId());
                this.zzw.setBackgroundColor(-12303292);
                this.zzw.setVisibility(0);
                this.zzw.setNavigationIcon(com.google.android.gms.ads.internal.zzt.zzo().zze().getDrawable(R.drawable.admob_close_button_white_cross));
                this.zzw.setNavigationOnClickListener(this.zzp);
                this.zzw.setTitleMarginStart(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(10);
                this.zzl.addView(this.zzw, layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(3, this.zzw.getId());
                layoutParams2.addRule(12);
                this.zzl.addView(this.zzd.zzF(), layoutParams2);
            }
        }
        if (!z11 && !this.zzm) {
            zze();
        }
        if (this.zzc.zzk != 5) {
            zzw(z13);
            if (this.zzd.zzay()) {
                zzy(z13, true);
                return;
            }
            return;
        }
        Activity activity2 = this.zzb;
        zzeht zzehtVarZze = zzehu.zze();
        zzehtVarZze.zza(activity2);
        zzehtVarZze.zzb(this);
        zzehtVarZze.zzc(this.zzc.zzq);
        zzehtVarZze.zzd(this.zzc.zzr);
        try {
            zzf(zzehtVarZze.zze());
        } catch (RemoteException | zzg e12) {
            throw new zzg(e12.getMessage(), e12);
        }
    }

    public final void zzE() {
        synchronized (this.zzo) {
            try {
                this.zzr = true;
                Runnable runnable = this.zzq;
                if (runnable != null) {
                    zzftt zzfttVar = com.google.android.gms.ads.internal.util.zzt.zza;
                    zzfttVar.removeCallbacks(runnable);
                    zzfttVar.post(this.zzq);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzF() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzp zzpVar;
        if (!this.zzb.isFinishing() || this.zzt) {
            return;
        }
        this.zzt = true;
        zzcjk zzcjkVar = this.zzd;
        if (zzcjkVar != null) {
            zzcjkVar.zzX(this.zzn - 1);
            synchronized (this.zzo) {
                try {
                    if (!this.zzr && this.zzd.zzaz()) {
                        if (((Boolean) zzba.zzc().zza(zzbgc.zzeI)).booleanValue() && !this.zzu && (adOverlayInfoParcel = this.zzc) != null && (zzpVar = adOverlayInfoParcel.zzc) != null) {
                            zzpVar.zzbz();
                        }
                        Runnable runnable = new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzd
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzc();
                            }
                        };
                        this.zzq = runnable;
                        com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(runnable, ((Long) zzba.zzc().zza(zzbgc.zzaX)).longValue());
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        zzc();
    }

    @RequiresApi(api = 21)
    public final void zzG(String str) {
        Toolbar toolbar = this.zzw;
        if (toolbar != null) {
            toolbar.setSubtitle(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final boolean zzH() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (((Boolean) zzba.zzc().zza(zzbgc.zziN)).booleanValue() && this.zzd.canGoBack()) {
            this.zzd.goBack();
            return false;
        }
        boolean zZzaE = this.zzd.zzaE();
        if (!zZzaE) {
            this.zzd.zzd("onbackblocked", Collections.emptyMap());
        }
        return zZzaE;
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzk != 5) {
            return;
        }
        this.zzb.overridePendingTransition(0, 0);
    }

    public final void zzc() {
        zzcjk zzcjkVar;
        zzp zzpVar;
        if (this.zzu) {
            return;
        }
        this.zzu = true;
        zzcjk zzcjkVar2 = this.zzd;
        if (zzcjkVar2 != null) {
            this.zzl.removeView(zzcjkVar2.zzF());
            zzi zziVar = this.zze;
            if (zziVar != null) {
                this.zzd.zzal(zziVar.zzd);
                this.zzd.zzao(false);
                ViewGroup viewGroup = this.zze.zzc;
                View viewZzF = this.zzd.zzF();
                zzi zziVar2 = this.zze;
                viewGroup.addView(viewZzF, zziVar2.zza, zziVar2.zzb);
                this.zze = null;
            } else if (this.zzb.getApplicationContext() != null) {
                this.zzd.zzal(this.zzb.getApplicationContext());
            }
            this.zzd = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzpVar = adOverlayInfoParcel.zzc) != null) {
            zzpVar.zzbD(this.zzn);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        if (adOverlayInfoParcel2 == null || (zzcjkVar = adOverlayInfoParcel2.zzd) == null) {
            return;
        }
        zzK(zzcjkVar.zzR(), this.zzc.zzd.zzF());
    }

    public final void zzd() {
        this.zzl.zzb = true;
    }

    public final void zze() {
        this.zzd.zzY();
    }

    public final void zzf(zzehu zzehuVar) throws RemoteException, zzg {
        zzbwm zzbwmVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzbwmVar = adOverlayInfoParcel.zzv) == null) {
            throw new zzg("noioou");
        }
        zzbwmVar.zzg(ObjectWrapper.wrap(zzehuVar));
    }

    public final void zzg() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzA(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzs = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzh(int i11, int i12, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzi() {
        this.zzn = 1;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzae
    public final void zzj() {
        this.zzn = 2;
        this.zzb.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzk(IObjectWrapper iObjectWrapper) {
        zzJ((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public void zzl(Bundle bundle) {
        if (!this.zzs) {
            this.zzb.requestWindowFeature(1);
        }
        this.zzj = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(this.zzb.getIntent());
            this.zzc = adOverlayInfoParcelZza;
            if (adOverlayInfoParcelZza == null) {
                throw new zzg("Could not get info for ad overlay.");
            }
            if (adOverlayInfoParcelZza.zzw) {
                if (Build.VERSION.SDK_INT >= 28) {
                    this.zzb.setShowWhenLocked(true);
                } else {
                    this.zzb.getWindow().addFlags(524288);
                }
            }
            if (this.zzc.zzm.zzc > 7500000) {
                this.zzn = 4;
            }
            if (this.zzb.getIntent() != null) {
                this.zzv = this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            com.google.android.gms.ads.internal.zzj zzjVar = adOverlayInfoParcel.zzo;
            if (zzjVar != null) {
                boolean z11 = zzjVar.zza;
                this.zzk = z11;
                if (z11) {
                    if (adOverlayInfoParcel.zzk != 5 && zzjVar.zzf != -1) {
                        new zzl(this, null).zzb();
                    }
                }
            } else if (adOverlayInfoParcel.zzk == 5) {
                this.zzk = true;
                if (adOverlayInfoParcel.zzk != 5) {
                    new zzl(this, null).zzb();
                }
            } else {
                this.zzk = false;
            }
            if (bundle == null) {
                if (this.zzv) {
                    zzdbk zzdbkVar = this.zzc.zzt;
                    if (zzdbkVar != null) {
                        zzdbkVar.zze();
                    }
                    zzp zzpVar = this.zzc.zzc;
                    if (zzpVar != null) {
                        zzpVar.zzbA();
                    }
                }
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                if (adOverlayInfoParcel2.zzk != 1) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel2.zzb;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                    }
                    zzdiu zzdiuVar = this.zzc.zzu;
                    if (zzdiuVar != null) {
                        zzdiuVar.zzs();
                    }
                }
            }
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
            zzh zzhVar = new zzh(activity, adOverlayInfoParcel3.zzn, adOverlayInfoParcel3.zzm.zza, adOverlayInfoParcel3.zzs);
            this.zzl = zzhVar;
            zzhVar.setId(1000);
            com.google.android.gms.ads.internal.zzt.zzq().zzk(this.zzb);
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzc;
            int i11 = adOverlayInfoParcel4.zzk;
            if (i11 == 1) {
                zzD(false);
                return;
            }
            if (i11 == 2) {
                this.zze = new zzi(adOverlayInfoParcel4.zzd);
                zzD(false);
            } else if (i11 == 3) {
                zzD(true);
            } else {
                if (i11 != 5) {
                    throw new zzg("Could not determine ad overlay type.");
                }
                zzD(false);
            }
        } catch (zzg e11) {
            zzcec.zzj(e11.getMessage());
            this.zzn = 4;
            this.zzb.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzm() {
        zzcjk zzcjkVar = this.zzd;
        if (zzcjkVar != null) {
            try {
                this.zzl.removeView(zzcjkVar.zzF());
            } catch (NullPointerException unused) {
            }
        }
        zzF();
    }

    public final void zzn() {
        if (this.zzm) {
            this.zzm = false;
            zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzo() {
        zzp zzpVar;
        zzg();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzpVar = adOverlayInfoParcel.zzc) != null) {
            zzpVar.zzbt();
        }
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzeK)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzp(int i11, String[] strArr, int[] iArr) {
        if (i11 == 12345) {
            Activity activity = this.zzb;
            zzeht zzehtVarZze = zzehu.zze();
            zzehtVarZze.zza(activity);
            zzehtVarZze.zzb(this.zzc.zzk == 5 ? this : null);
            try {
                this.zzc.zzv.zzf(strArr, iArr, ObjectWrapper.wrap(zzehtVarZze.zze()));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzr() {
        zzp zzpVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzpVar = adOverlayInfoParcel.zzc) != null) {
            zzpVar.zzbP();
        }
        zzJ(this.zzb.getResources().getConfiguration());
        if (((Boolean) zzba.zzc().zza(zzbgc.zzeK)).booleanValue()) {
            return;
        }
        zzcjk zzcjkVar = this.zzd;
        if (zzcjkVar == null || zzcjkVar.zzaB()) {
            zzcec.zzj("The webview does not exist. Ignoring action.");
        } else {
            this.zzd.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzt() {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzeK)).booleanValue()) {
            zzcjk zzcjkVar = this.zzd;
            if (zzcjkVar == null || zzcjkVar.zzaB()) {
                zzcec.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzu() {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzeK)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzv() {
        zzp zzpVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzpVar = adOverlayInfoParcel.zzc) == null) {
            return;
        }
        zzpVar.zzbC();
    }

    public final void zzw(boolean z11) {
        if (this.zzc.zzw) {
            return;
        }
        int iIntValue = ((Integer) zzba.zzc().zza(zzbgc.zzeN)).intValue();
        boolean z12 = ((Boolean) zzba.zzc().zza(zzbgc.zzba)).booleanValue() || z11;
        zzr zzrVar = new zzr();
        zzrVar.zzd = 50;
        zzrVar.zza = true != z12 ? 0 : iIntValue;
        zzrVar.zzb = true != z12 ? iIntValue : 0;
        zzrVar.zzc = iIntValue;
        this.zzf = new zzs(this.zzb, zzrVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z12 ? 9 : 11);
        zzy(z11, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzx() {
        this.zzs = true;
    }

    public final void zzy(boolean z11, boolean z12) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzj zzjVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        com.google.android.gms.ads.internal.zzj zzjVar2;
        boolean z13 = true;
        boolean z14 = ((Boolean) zzba.zzc().zza(zzbgc.zzaY)).booleanValue() && (adOverlayInfoParcel2 = this.zzc) != null && (zzjVar2 = adOverlayInfoParcel2.zzo) != null && zzjVar2.zzh;
        boolean z15 = ((Boolean) zzba.zzc().zza(zzbgc.zzaZ)).booleanValue() && (adOverlayInfoParcel = this.zzc) != null && (zzjVar = adOverlayInfoParcel.zzo) != null && zzjVar.zzi;
        if (z11 && z12 && z14 && !z15) {
            new zzbvw(this.zzd, "useCustomClose").zzh("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzs zzsVar = this.zzf;
        if (zzsVar != null) {
            if (!z15 && (!z12 || z14)) {
                z13 = false;
            }
            zzsVar.zzb(z13);
        }
    }

    public final void zzz() {
        this.zzl.removeView(this.zzf);
        zzw(true);
    }
}
