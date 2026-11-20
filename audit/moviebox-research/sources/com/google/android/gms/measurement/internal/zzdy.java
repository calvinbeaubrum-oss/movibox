package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.android.gms.internal.measurement.zzpj;
import com.hisavana.common.constant.ComConstants;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdy extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    public zzdy(zzfr zzfrVar, long j11) {
        super(zzfrVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j11;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:37:0x0101  */
    /* JADX WARN: Code duplicated, block: B:38:0x0111  */
    /* JADX WARN: Code duplicated, block: B:39:0x0121  */
    /* JADX WARN: Code duplicated, block: B:40:0x0131  */
    /* JADX WARN: Code duplicated, block: B:41:0x0141  */
    /* JADX WARN: Code duplicated, block: B:42:0x0151  */
    /* JADX WARN: Code duplicated, block: B:45:0x016b  */
    /* JADX WARN: Code duplicated, block: B:48:0x018b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0194 A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:59:0x01bf, B:61:0x01d5, B:63:0x01da, B:62:0x01d8), top: B:90:0x0173 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:54:0x01ae A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:59:0x01bf, B:61:0x01d5, B:63:0x01da, B:62:0x01d8), top: B:90:0x0173 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01bf A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:59:0x01bf, B:61:0x01d5, B:63:0x01da, B:62:0x01d8), top: B:90:0x0173 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x01d5 A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:59:0x01bf, B:61:0x01d5, B:63:0x01da, B:62:0x01d8), top: B:90:0x0173 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x01d8 A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:59:0x01bf, B:61:0x01d5, B:63:0x01da, B:62:0x01d8), top: B:90:0x0173 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0208  */
    /* JADX WARN: Code duplicated, block: B:71:0x020e  */
    /* JADX WARN: Code duplicated, block: B:72:0x021e  */
    /* JADX WARN: Code duplicated, block: B:75:0x0228  */
    /* JADX WARN: Code duplicated, block: B:78:0x023d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0241  */
    /* JADX WARN: Code duplicated, block: B:82:0x024e  */
    /* JADX WARN: Code duplicated, block: B:92:0x023d A[SYNTHETIC] */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final void zzd() {
        String str;
        String string;
        boolean z11;
        int iZza;
        List listZzp;
        Iterator it;
        String strZzc;
        String str2;
        Context contextZzau;
        String strZzz;
        String packageName = this.zzt.zzau().getPackageName();
        PackageManager packageManager = this.zzt.zzau().getPackageManager();
        int i11 = Integer.MIN_VALUE;
        String installerPackageName = AppLovinMediationProvider.UNKNOWN;
        String str3 = "Unknown";
        try {
            if (packageManager != null) {
                try {
                    installerPackageName = packageManager.getInstallerPackageName(packageName);
                } catch (IllegalArgumentException unused) {
                    this.zzt.zzay().zzd().zzb("Error retrieving app installer package name. appId", zzeh.zzn(packageName));
                }
                if (installerPackageName == null) {
                    installerPackageName = "manual_install";
                } else if ("com.android.vending".equals(installerPackageName)) {
                    installerPackageName = "";
                }
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(this.zzt.zzau().getPackageName(), 0);
                    if (packageInfo != null) {
                        CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                        string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                        try {
                            str3 = packageInfo.versionName;
                            i11 = packageInfo.versionCode;
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str = str3;
                            str3 = string;
                            this.zzt.zzay().zzd().zzc("Error retrieving package info. appId, appName", zzeh.zzn(packageName), str3);
                            string = str3;
                            str3 = str;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = "Unknown";
                }
                this.zza = packageName;
                this.zzd = installerPackageName;
                this.zzb = str3;
                this.zzc = i11;
                this.zze = string;
                this.zzf = 0L;
                if (TextUtils.isEmpty(this.zzt.zzw()) && "am".equals(this.zzt.zzx())) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                iZza = this.zzt.zza();
                switch (iZza) {
                    case 0:
                        this.zzt.zzay().zzj().zza("App measurement collection enabled");
                        break;
                    case 1:
                        this.zzt.zzay().zzi().zza("App measurement deactivated via the manifest");
                        break;
                    case 2:
                        this.zzt.zzay().zzj().zza("App measurement deactivated via the init parameters");
                        break;
                    case 3:
                        this.zzt.zzay().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                        break;
                    case 4:
                        this.zzt.zzay().zzi().zza("App measurement disabled via the manifest");
                        break;
                    case 5:
                        this.zzt.zzay().zzj().zza("App measurement disabled via the init parameters");
                        break;
                    case 6:
                        this.zzt.zzay().zzl().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                        break;
                    case 7:
                        this.zzt.zzay().zzi().zza("App measurement disabled via the global data collection setting");
                        break;
                    default:
                        this.zzt.zzay().zzi().zza("App measurement disabled due to denied storage consent");
                        break;
                }
                this.zzk = "";
                this.zzl = "";
                this.zzt.zzaw();
                if (z11) {
                    this.zzl = this.zzt.zzw();
                }
                strZzc = zzid.zzc(this.zzt.zzau(), "google_app_id", this.zzt.zzz());
                this.zzk = true != TextUtils.isEmpty(strZzc) ? strZzc : "";
                if (!TextUtils.isEmpty(strZzc)) {
                    contextZzau = this.zzt.zzau();
                    strZzz = this.zzt.zzz();
                    Preconditions.checkNotNull(contextZzau);
                    Resources resources = contextZzau.getResources();
                    if (!TextUtils.isEmpty(strZzz)) {
                        strZzz = zzfj.zza(contextZzau);
                    }
                    this.zzl = zzfj.zzb("admob_app_id", resources, strZzz);
                }
                if (iZza == 0) {
                    zzef zzefVarZzj = this.zzt.zzay().zzj();
                    String str4 = this.zza;
                    if (TextUtils.isEmpty(this.zzk)) {
                        str2 = this.zzl;
                    } else {
                        str2 = this.zzk;
                    }
                    zzefVarZzj.zzc("App measurement enabled for app package, google app id", str4, str2);
                }
                this.zzh = null;
                this.zzt.zzaw();
                listZzp = this.zzt.zzf().zzp("analytics.safelisted_events");
                if (listZzp != null) {
                    this.zzh = listZzp;
                } else if (listZzp.isEmpty()) {
                    this.zzt.zzay().zzl().zza("Safelisted event list is empty. Ignoring");
                } else {
                    it = listZzp.iterator();
                    do {
                        if (it.hasNext()) {
                            this.zzh = listZzp;
                        }
                    } while (this.zzt.zzv().zzab("safelisted event", (String) it.next()));
                }
                if (packageManager != null) {
                    this.zzj = InstantApps.isInstantApp(this.zzt.zzau()) ? 1 : 0;
                } else {
                    this.zzj = 0;
                }
            }
            this.zzt.zzay().zzd().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzeh.zzn(packageName));
            strZzc = zzid.zzc(this.zzt.zzau(), "google_app_id", this.zzt.zzz());
            this.zzk = true != TextUtils.isEmpty(strZzc) ? strZzc : "";
            if (!TextUtils.isEmpty(strZzc)) {
                contextZzau = this.zzt.zzau();
                strZzz = this.zzt.zzz();
                Preconditions.checkNotNull(contextZzau);
                Resources resources2 = contextZzau.getResources();
                if (!TextUtils.isEmpty(strZzz)) {
                    strZzz = zzfj.zza(contextZzau);
                }
                this.zzl = zzfj.zzb("admob_app_id", resources2, strZzz);
            }
            if (iZza == 0) {
                zzef zzefVarZzj2 = this.zzt.zzay().zzj();
                String str5 = this.zza;
                if (TextUtils.isEmpty(this.zzk)) {
                    str2 = this.zzl;
                } else {
                    str2 = this.zzk;
                }
                zzefVarZzj2.zzc("App measurement enabled for app package, google app id", str5, str2);
            }
        } catch (IllegalStateException e11) {
            this.zzt.zzay().zzd().zzc("Fetching Google App Id failed with exception. appId", zzeh.zzn(packageName), e11);
        }
        string = "Unknown";
        this.zza = packageName;
        this.zzd = installerPackageName;
        this.zzb = str3;
        this.zzc = i11;
        this.zze = string;
        this.zzf = 0L;
        if (TextUtils.isEmpty(this.zzt.zzw())) {
            z11 = false;
        } else {
            z11 = false;
        }
        iZza = this.zzt.zza();
        switch (iZza) {
            case 0:
                this.zzt.zzay().zzj().zza("App measurement collection enabled");
                break;
            case 1:
                this.zzt.zzay().zzi().zza("App measurement deactivated via the manifest");
                break;
            case 2:
                this.zzt.zzay().zzj().zza("App measurement deactivated via the init parameters");
                break;
            case 3:
                this.zzt.zzay().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                break;
            case 4:
                this.zzt.zzay().zzi().zza("App measurement disabled via the manifest");
                break;
            case 5:
                this.zzt.zzay().zzj().zza("App measurement disabled via the init parameters");
                break;
            case 6:
                this.zzt.zzay().zzl().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                break;
            case 7:
                this.zzt.zzay().zzi().zza("App measurement disabled via the global data collection setting");
                break;
            default:
                this.zzt.zzay().zzi().zza("App measurement disabled due to denied storage consent");
                break;
        }
        this.zzk = "";
        this.zzl = "";
        this.zzt.zzaw();
        if (z11) {
            this.zzl = this.zzt.zzw();
        }
        this.zzh = null;
        this.zzt.zzaw();
        listZzp = this.zzt.zzf().zzp("analytics.safelisted_events");
        if (listZzp != null) {
            this.zzh = listZzp;
        } else if (listZzp.isEmpty()) {
            this.zzt.zzay().zzl().zza("Safelisted event list is empty. Ignoring");
        } else {
            it = listZzp.iterator();
            do {
                if (it.hasNext()) {
                    this.zzh = listZzp;
                }
            } while (this.zzt.zzv().zzab("safelisted event", (String) it.next()));
        }
        if (packageManager != null) {
            this.zzj = InstantApps.isInstantApp(this.zzt.zzau()) ? 1 : 0;
        } else {
            this.zzj = 0;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return true;
    }

    public final int zzh() {
        zza();
        return this.zzj;
    }

    public final int zzi() {
        zza();
        return this.zzc;
    }

    public final zzq zzj(String str) {
        String str2;
        String str3;
        long j11;
        String str4;
        String str5;
        zzg();
        String strZzl = zzl();
        String strZzm = zzm();
        zza();
        String str6 = this.zzb;
        zza();
        long j12 = this.zzc;
        zza();
        Preconditions.checkNotNull(this.zzd);
        String str7 = this.zzd;
        this.zzt.zzf().zzh();
        zza();
        zzg();
        long j13 = this.zzf;
        if (j13 == 0) {
            zzlb zzlbVarZzv = this.zzt.zzv();
            Context contextZzau = this.zzt.zzau();
            String packageName = this.zzt.zzau().getPackageName();
            zzlbVarZzv.zzg();
            Preconditions.checkNotNull(contextZzau);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = contextZzau.getPackageManager();
            MessageDigest messageDigestZzF = zzlb.zzF();
            long jZzp = -1;
            if (messageDigestZzF == null) {
                zzlbVarZzv.zzt.zzay().zzd().zza("Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (zzlbVarZzv.zzag(contextZzau, packageName)) {
                            jZzp = 0;
                        } else {
                            Signature[] signatureArr = Wrappers.packageManager(contextZzau).getPackageInfo(zzlbVarZzv.zzt.zzau().getPackageName(), 64).signatures;
                            if (signatureArr == null || signatureArr.length <= 0) {
                                zzlbVarZzv.zzt.zzay().zzk().zza("Could not get signatures");
                            } else {
                                jZzp = zzlb.zzp(messageDigestZzF.digest(signatureArr[0].toByteArray()));
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e11) {
                        zzlbVarZzv.zzt.zzay().zzd().zzb("Package name not found", e11);
                        j13 = 0;
                    }
                }
                j13 = 0;
                this.zzf = j13;
            }
            j13 = jZzp;
            this.zzf = j13;
        }
        long j14 = j13;
        boolean zZzJ = this.zzt.zzJ();
        boolean z11 = !this.zzt.zzm().zzl;
        zzg();
        if (this.zzt.zzJ()) {
            zzpj.zzc();
            if (this.zzt.zzf().zzs(null, zzdu.zzaa)) {
                this.zzt.zzay().zzj().zza("Disabled IID for tests.");
            } else {
                try {
                    Class<?> clsLoadClass = this.zzt.zzau().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                    if (clsLoadClass != null) {
                        try {
                            Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzt.zzau());
                            if (objInvoke == null) {
                                str2 = null;
                            } else {
                                try {
                                    str2 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                                } catch (Exception unused) {
                                    this.zzt.zzay().zzl().zza("Failed to retrieve Firebase Instance Id");
                                    str2 = null;
                                }
                            }
                        } catch (Exception unused2) {
                            this.zzt.zzay().zzm().zza("Failed to obtain Firebase Analytics instance");
                        }
                    }
                } catch (ClassNotFoundException unused3) {
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        zzfr zzfrVar = this.zzt;
        long jZza = zzfrVar.zzm().zzc.zza();
        long jMin = jZza == 0 ? zzfrVar.zzc : Math.min(zzfrVar.zzc, jZza);
        zza();
        int i11 = this.zzj;
        boolean zZzr = this.zzt.zzf().zzr();
        zzew zzewVarZzm = this.zzt.zzm();
        zzewVarZzm.zzg();
        boolean z12 = zzewVarZzm.zza().getBoolean("deferred_analytics_collection", false);
        zza();
        String str8 = this.zzl;
        Boolean boolZzk = this.zzt.zzf().zzk("google_analytics_default_allow_ad_personalization_signals");
        Boolean boolValueOf = boolZzk == null ? null : Boolean.valueOf(!boolZzk.booleanValue());
        long j15 = this.zzg;
        List list = this.zzh;
        String strZzh = this.zzt.zzm().zzc().zzh();
        if (this.zzi == null) {
            str3 = str8;
            j11 = j15;
            if (this.zzt.zzf().zzs(null, zzdu.zzap)) {
                this.zzi = this.zzt.zzv().zzC();
            } else {
                this.zzi = "";
            }
        } else {
            str3 = str8;
            j11 = j15;
        }
        String str9 = this.zzi;
        zzpd.zzc();
        if (this.zzt.zzf().zzs(null, zzdu.zzam)) {
            zzg();
            if (this.zzn == 0) {
                str4 = str9;
            } else {
                str4 = str9;
                long jCurrentTimeMillis = this.zzt.zzav().currentTimeMillis() - this.zzn;
                if (this.zzm != null && jCurrentTimeMillis > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED && this.zzo == null) {
                    zzo();
                }
            }
            if (this.zzm == null) {
                zzo();
            }
            str5 = this.zzm;
        } else {
            str4 = str9;
            str5 = null;
        }
        return new zzq(strZzl, strZzm, str6, j12, str7, 74029L, j14, str, zZzJ, z11, str2, 0L, jMin, i11, zZzr, z12, str3, boolValueOf, j11, list, (String) null, strZzh, str4, str5);
    }

    public final String zzk() {
        zza();
        return this.zzl;
    }

    public final String zzl() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    public final String zzm() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    public final List zzn() {
        return this.zzh;
    }

    public final void zzo() {
        String str;
        zzg();
        if (this.zzt.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            this.zzt.zzv().zzG().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            this.zzt.zzay().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        }
        zzef zzefVarZzc = this.zzt.zzay().zzc();
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? "null" : "not null";
        zzefVarZzc.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = str;
        this.zzn = this.zzt.zzav().currentTimeMillis();
    }

    public final boolean zzp(String str) {
        String str2 = this.zzo;
        boolean z11 = false;
        if (str2 != null && !str2.equals(str)) {
            z11 = true;
        }
        this.zzo = str;
        return z11;
    }
}
