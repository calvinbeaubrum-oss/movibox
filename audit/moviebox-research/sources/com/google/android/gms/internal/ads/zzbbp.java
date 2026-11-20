package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbbp {
    private final zzbbv zza;
    private final zzbde zzb;
    private final boolean zzc;

    private zzbbp() {
        this.zzb = zzbdf.zzd();
        this.zzc = false;
        this.zza = new zzbbv();
    }

    public zzbbp(zzbbv zzbbvVar) {
        this.zzb = zzbdf.zzd();
        this.zza = zzbbvVar;
        this.zzc = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeO)).booleanValue();
    }

    public static zzbbp zza() {
        return new zzbbp();
    }

    private final synchronized String zzd(int i11) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", this.zzb.zzk(), Long.valueOf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime()), Integer.valueOf(i11 - 1), Base64.encodeToString(((zzbdf) this.zzb.zzal()).zzax(), 3));
    }

    private final synchronized void zze(int i11) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
            try {
                try {
                    fileOutputStream.write(zzd(i11).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        com.google.android.gms.ads.internal.util.zze.zza("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    com.google.android.gms.ads.internal.util.zze.zza("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        com.google.android.gms.ads.internal.util.zze.zza("Could not close Clearcut output stream.");
                    }
                }
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                    com.google.android.gms.ads.internal.util.zze.zza("Could not close Clearcut output stream.");
                }
                throw th2;
            }
        } catch (FileNotFoundException unused5) {
            com.google.android.gms.ads.internal.util.zze.zza("Could not find file for Clearcut");
        }
    }

    private final synchronized void zzf(int i11) {
        zzbde zzbdeVar = this.zzb;
        zzbdeVar.zzd();
        zzbdeVar.zzc(com.google.android.gms.ads.internal.util.zzt.zzd());
        zzbbu zzbbuVar = new zzbbu(this.zza, ((zzbdf) this.zzb.zzal()).zzax(), null);
        int i12 = i11 - 1;
        zzbbuVar.zza(i12);
        zzbbuVar.zzc();
        com.google.android.gms.ads.internal.util.zze.zza("Logging Event with event code : ".concat(String.valueOf(Integer.toString(i12, 10))));
    }

    public final synchronized void zzb(zzbbo zzbboVar) {
        if (this.zzc) {
            try {
                zzbboVar.zza(this.zzb);
            } catch (NullPointerException e11) {
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "AdMobClearcutLogger.modify");
            }
        }
    }

    public final synchronized void zzc(int i11) {
        if (this.zzc) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeP)).booleanValue()) {
                zze(i11);
            } else {
                zzf(i11);
            }
        }
    }
}
