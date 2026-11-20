package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcep;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzdzd;
import com.google.android.gms.internal.ads.zzgey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzau {
    private final Context zza;
    private final zzdzd zzb;
    private String zzc;
    private String zzd;
    private String zze;

    @Nullable
    private String zzf;
    private int zzg;
    private int zzh;
    private PointF zzi;
    private PointF zzj;
    private Handler zzk;
    private Runnable zzl;

    public zzau(Context context) {
        this.zzg = 0;
        this.zzl = new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzah
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzg();
            }
        };
        this.zza = context;
        this.zzh = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzt.zzt().zzb();
        this.zzk = com.google.android.gms.ads.internal.zzt.zzt().zza();
        this.zzb = com.google.android.gms.ads.internal.zzt.zzs().zza();
    }

    public zzau(Context context, String str) {
        this(context);
        this.zzc = str;
    }

    private final void zzs(Context context) {
        final int i11;
        ArrayList arrayList = new ArrayList();
        int iZzu = zzu(arrayList, "None", true);
        final int iZzu2 = zzu(arrayList, "Shake", true);
        final int iZzu3 = zzu(arrayList, "Flick", true);
        zzdyz zzdyzVar = zzdyz.NONE;
        int iOrdinal = this.zzb.zza().ordinal();
        if (iOrdinal != 1) {
            i11 = iOrdinal != 2 ? iZzu : iZzu3;
        } else {
            i11 = iZzu2;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder builderZzJ = zzt.zzJ(context);
        final AtomicInteger atomicInteger = new AtomicInteger(i11);
        builderZzJ.setTitle("Setup gesture");
        builderZzJ.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i11, new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzap
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                atomicInteger.set(i12);
            }
        });
        builderZzJ.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzaq
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                this.zza.zzr();
            }
        });
        builderZzJ.setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzar
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                this.zza.zzh(atomicInteger, i11, iZzu2, iZzu3, dialogInterface, i12);
            }
        });
        builderZzJ.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.ads.internal.util.zzas
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.zza.zzr();
            }
        });
        builderZzJ.create().show();
    }

    private final boolean zzt(float f11, float f12, float f13, float f14) {
        return Math.abs(this.zzi.x - f11) < ((float) this.zzh) && Math.abs(this.zzi.y - f12) < ((float) this.zzh) && Math.abs(this.zzj.x - f13) < ((float) this.zzh) && Math.abs(this.zzj.y - f14) < ((float) this.zzh);
    }

    private static final int zzu(List list, String str, boolean z11) {
        if (!z11) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(100);
        sb2.append("{Dialog: ");
        sb2.append(this.zzc);
        sb2.append(",DebugSignal: ");
        sb2.append(this.zzf);
        sb2.append(",AFMA Version: ");
        sb2.append(this.zze);
        sb2.append(",Ad Unit ID: ");
        sb2.append(this.zzd);
        sb2.append("}");
        return sb2.toString();
    }

    public final /* synthetic */ void zza() {
        zzs(this.zza);
    }

    public final /* synthetic */ void zzb() {
        zzs(this.zza);
    }

    public final /* synthetic */ void zzc(zzgey zzgeyVar) {
        if (com.google.android.gms.ads.internal.zzt.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzgeyVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzan
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            });
        } else {
            com.google.android.gms.ads.internal.zzt.zzs().zzd(this.zza, this.zzd, this.zze);
        }
    }

    public final /* synthetic */ void zzd(zzgey zzgeyVar) {
        if (com.google.android.gms.ads.internal.zzt.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzgeyVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzam
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzf();
                }
            });
        } else {
            com.google.android.gms.ads.internal.zzt.zzs().zzd(this.zza, this.zzd, this.zze);
        }
    }

    public final /* synthetic */ void zze() {
        com.google.android.gms.ads.internal.zzt.zzs().zzc(this.zza);
    }

    public final /* synthetic */ void zzf() {
        com.google.android.gms.ads.internal.zzt.zzs().zzc(this.zza);
    }

    public final /* synthetic */ void zzg() {
        this.zzg = 4;
        zzr();
    }

    public final /* synthetic */ void zzh(AtomicInteger atomicInteger, int i11, int i12, int i13, DialogInterface dialogInterface, int i14) {
        if (atomicInteger.get() != i11) {
            if (atomicInteger.get() == i12) {
                this.zzb.zzl(zzdyz.SHAKE);
            } else if (atomicInteger.get() == i13) {
                this.zzb.zzl(zzdyz.FLICK);
            } else {
                this.zzb.zzl(zzdyz.NONE);
            }
        }
        zzr();
    }

    public final /* synthetic */ void zzi(String str, DialogInterface dialogInterface, int i11) {
        com.google.android.gms.ads.internal.zzt.zzp();
        zzt.zzS(this.zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    public final /* synthetic */ void zzj(int i11, int i12, int i13, int i14, int i15, DialogInterface dialogInterface, int i16) {
        if (i16 != i11) {
            if (i16 == i12) {
                zzcec.zze("Debug mode [Creative Preview] selected.");
                zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzai
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzl();
                    }
                });
                return;
            }
            if (i16 == i13) {
                zzcec.zze("Debug mode [Troubleshooting] selected.");
                zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzag
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzk();
                    }
                });
                return;
            }
            if (i16 == i14) {
                zzdzd zzdzdVar = this.zzb;
                final zzgey zzgeyVar = zzcep.zze;
                zzgey zzgeyVar2 = zzcep.zza;
                if (zzdzdVar.zzp()) {
                    zzgeyVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzat
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze();
                        }
                    });
                    return;
                } else {
                    zzgeyVar2.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaf
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzd(zzgeyVar);
                        }
                    });
                    return;
                }
            }
            if (i16 == i15) {
                zzdzd zzdzdVar2 = this.zzb;
                final zzgey zzgeyVar3 = zzcep.zze;
                zzgey zzgeyVar4 = zzcep.zza;
                if (zzdzdVar2.zzp()) {
                    zzgeyVar3.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzae
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zza();
                        }
                    });
                    return;
                } else {
                    zzgeyVar4.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzal
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzc(zzgeyVar3);
                        }
                    });
                    return;
                }
            }
            return;
        }
        if (!(this.zza instanceof Activity)) {
            zzcec.zzi("Can not create dialog without Activity Context");
            return;
        }
        String str = this.zzc;
        final String str2 = "No debug information";
        if (!TextUtils.isEmpty(str)) {
            Uri uriBuild = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
            StringBuilder sb2 = new StringBuilder();
            com.google.android.gms.ads.internal.zzt.zzp();
            Map mapZzO = zzt.zzO(uriBuild);
            for (String str3 : mapZzO.keySet()) {
                sb2.append(str3);
                sb2.append(" = ");
                sb2.append((String) mapZzO.get(str3));
                sb2.append("\n\n");
            }
            String strTrim = sb2.toString().trim();
            if (!TextUtils.isEmpty(strTrim)) {
                str2 = strTrim;
            }
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder builderZzJ = zzt.zzJ(this.zza);
        builderZzJ.setMessage(str2);
        builderZzJ.setTitle("Ad Information");
        builderZzJ.setPositiveButton("Share", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzaj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i17) {
                this.zza.zzi(str2, dialogInterface2, i17);
            }
        });
        builderZzJ.setNegativeButton("Close", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzak
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i17) {
            }
        });
        builderZzJ.create().show();
    }

    public final /* synthetic */ void zzk() {
        zzay zzayVarZzs = com.google.android.gms.ads.internal.zzt.zzs();
        String str = this.zzd;
        String str2 = this.zze;
        String str3 = this.zzf;
        boolean zZzm = zzayVarZzs.zzm();
        Context context = this.zza;
        zzayVarZzs.zzh(zzayVarZzs.zzj(context, str, str2));
        if (!zzayVarZzs.zzm()) {
            zzayVarZzs.zzd(context, str, str2);
            return;
        }
        if (!zZzm && !TextUtils.isEmpty(str3)) {
            zzayVarZzs.zze(context, str2, str3, str);
        }
        zzcec.zze("Device is linked for debug signals.");
        zzayVarZzs.zzi(context, "The device is successfully linked for troubleshooting.", false, true);
    }

    public final /* synthetic */ void zzl() {
        zzay zzayVarZzs = com.google.android.gms.ads.internal.zzt.zzs();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        if (!zzayVarZzs.zzk(context, str, str2)) {
            zzayVarZzs.zzi(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(zzayVarZzs.zza)) {
            zzcec.zze("Creative is not pushed for this device.");
            zzayVarZzs.zzi(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(zzayVarZzs.zza)) {
            zzcec.zze("The app is not linked for creative preview.");
            zzayVarZzs.zzd(context, str, str2);
        } else if ("0".equals(zzayVarZzs.zza)) {
            zzcec.zze("Device is linked for in app preview.");
            zzayVarZzs.zzi(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zzm(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzg = 0;
            this.zzi = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i11 = this.zzg;
        if (i11 == -1) {
            return;
        }
        if (i11 == 0) {
            if (actionMasked == 5) {
                this.zzg = 5;
                this.zzj = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                this.zzk.postDelayed(this.zzl, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeB)).longValue());
                return;
            }
            return;
        }
        if (i11 == 5) {
            if (pointerCount == 2) {
                if (actionMasked != 2) {
                    return;
                }
                boolean z11 = false;
                for (int i12 = 0; i12 < historySize; i12++) {
                    z11 |= !zzt(motionEvent.getHistoricalX(0, i12), motionEvent.getHistoricalY(0, i12), motionEvent.getHistoricalX(1, i12), motionEvent.getHistoricalY(1, i12));
                }
                if (zzt(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z11) {
                    return;
                }
            }
            this.zzg = -1;
            this.zzk.removeCallbacks(this.zzl);
        }
    }

    public final void zzn(String str) {
        this.zzd = str;
    }

    public final void zzo(String str) {
        this.zze = str;
    }

    public final void zzp(String str) {
        this.zzc = str;
    }

    public final void zzq(String str) {
        this.zzf = str;
    }

    public final void zzr() {
        try {
            if (!(this.zza instanceof Activity)) {
                zzcec.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(com.google.android.gms.ads.internal.zzt.zzs().zzb())) {
                str = "Creative preview";
            }
            String str2 = true != com.google.android.gms.ads.internal.zzt.zzs().zzm() ? "Troubleshooting" : "Troubleshooting (enabled)";
            ArrayList arrayList = new ArrayList();
            final int iZzu = zzu(arrayList, "Ad information", true);
            final int iZzu2 = zzu(arrayList, str, true);
            final int iZzu3 = zzu(arrayList, str2, true);
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue();
            final int iZzu4 = zzu(arrayList, "Open ad inspector", zBooleanValue);
            final int iZzu5 = zzu(arrayList, "Ad inspector settings", zBooleanValue);
            com.google.android.gms.ads.internal.zzt.zzp();
            AlertDialog.Builder builderZzJ = zzt.zzJ(this.zza);
            builderZzJ.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzao
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    this.zza.zzj(iZzu, iZzu2, iZzu3, iZzu4, iZzu5, dialogInterface, i11);
                }
            });
            builderZzJ.create().show();
        } catch (WindowManager.BadTokenException e11) {
            zze.zzb("", e11);
        }
    }
}
