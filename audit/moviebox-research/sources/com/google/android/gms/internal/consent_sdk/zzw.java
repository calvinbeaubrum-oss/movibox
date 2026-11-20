package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzw {
    private final zzx zza;
    private final zzck zzb;
    private int zzc = 0;
    private ConsentInformation.PrivacyOptionsRequirementStatus zzd = ConsentInformation.PrivacyOptionsRequirementStatus.UNKNOWN;

    public zzw(zzx zzxVar, zzck zzckVar) {
        this.zza = zzxVar;
        this.zzb = zzckVar;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0099  */
    public final zzz zza() throws zzg {
        String str;
        zzck zzckVar = this.zzb;
        int i11 = zzckVar.zzf;
        int i12 = i11 - 1;
        if (i11 == 0) {
            throw null;
        }
        switch (i12) {
            case 1:
            case 2:
            case 3:
                this.zzc = 3;
                break;
            case 4:
                this.zzc = 2;
                break;
            case 5:
                this.zzc = 1;
                break;
            case 6:
                throw new zzg(1, "Invalid response from server: ".concat(String.valueOf(zzckVar.zzc)));
            case 7:
                throw new zzg(3, "Publisher misconfiguration: ".concat(String.valueOf(zzckVar.zzc)));
            default:
                throw new zzg(1, "Invalid response from server.");
        }
        int i13 = zzckVar.zzg;
        int i14 = i13 - 1;
        if (i13 == 0) {
            throw null;
        }
        if (i14 == 1) {
            this.zzd = ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED;
        } else {
            if (i14 != 2) {
                throw new zzg(1, "Invalid response from server.");
            }
            this.zzd = ConsentInformation.PrivacyOptionsRequirementStatus.NOT_REQUIRED;
        }
        String str2 = zzckVar.zza;
        zzbp zzbpVar = str2 == null ? null : new zzbp(zzckVar.zzb, str2);
        this.zza.zzc.zzi(new HashSet(zzckVar.zzd));
        for (zzcj zzcjVar : this.zzb.zze) {
            int i15 = zzcjVar.zzb;
            int i16 = i15 - 1;
            if (i15 == 0) {
                throw null;
            }
            if (i16 == 0) {
                str = null;
            } else if (i16 == 1) {
                str = "write";
            } else if (i16 != 2) {
                str = null;
            } else {
                str = "clear";
            }
            if (str != null) {
                zzx zzxVar = this.zza;
                zzxVar.zza.zzb(str, zzcjVar.zza, zzxVar.zzb);
            }
        }
        return new zzz(this.zzc, this.zzd, zzbpVar, null);
    }
}
