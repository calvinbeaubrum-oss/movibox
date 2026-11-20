package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcbt implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private final zzcch zzd;
    private String zze = "-1";
    private int zzf = -1;

    public zzcbt(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar, zzcch zzcchVar) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzgVar;
        this.zza = context;
        this.zzd = zzcchVar;
    }

    private final void zzb() {
        this.zzc.zzH(true);
        com.google.android.gms.ads.internal.util.zzad.zzc(this.zza);
    }

    private final void zzc(String str, int i11) {
        Context context;
        boolean z11 = true;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaw)).booleanValue() ? !(str.isEmpty() || str.charAt(0) != '1') : !(i11 == 0 || str.isEmpty() || (str.charAt(0) != '1' && !str.equals("-1")))) {
            z11 = false;
        }
        this.zzc.zzH(z11);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgj)).booleanValue() && z11 && (context = this.zza) != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0091  */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        byte b11;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzay)).booleanValue()) {
            if (Objects.equals(str, "gad_has_consent_for_cookies")) {
                int i11 = sharedPreferences.getInt("gad_has_consent_for_cookies", -1);
                if (i11 != this.zzc.zzb()) {
                    zzb();
                }
                this.zzc.zzE(i11);
                return;
            }
            if (Objects.equals(str, "IABTCF_gdprApplies") || Objects.equals(str, "IABTCF_TCString") || Objects.equals(str, "IABTCF_PurposeConsents")) {
                String string = sharedPreferences.getString(str, "-1");
                if (string != null && !string.equals(this.zzc.zzn(str))) {
                    zzb();
                }
                this.zzc.zzF(str, string);
                return;
            }
            return;
        }
        String string2 = sharedPreferences.getString("IABTCF_PurposeConsents", "-1");
        int i12 = sharedPreferences.getInt("gad_has_consent_for_cookies", -1);
        String strValueOf = String.valueOf(str);
        int iHashCode = strValueOf.hashCode();
        if (iHashCode != -2004976699) {
            if (iHashCode == -527267622 && strValueOf.equals("gad_has_consent_for_cookies")) {
                b11 = 1;
            } else {
                b11 = -1;
            }
        } else if (strValueOf.equals("IABTCF_PurposeConsents")) {
            b11 = 0;
        } else {
            b11 = -1;
        }
        if (b11 == 0) {
            if (string2.equals("-1") || this.zze.equals(string2)) {
                return;
            }
            this.zze = string2;
            zzc(string2, i12);
            return;
        }
        if (b11 != 1) {
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaw)).booleanValue() || i12 == -1 || this.zzf == i12) {
            return;
        }
        this.zzf = i12;
        zzc(string2, i12);
    }

    public final void zza() {
        this.zzb.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzb, "gad_has_consent_for_cookies");
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzay)).booleanValue()) {
            onSharedPreferenceChanged(this.zzb, "IABTCF_PurposeConsents");
        } else {
            onSharedPreferenceChanged(this.zzb, "IABTCF_gdprApplies");
            onSharedPreferenceChanged(this.zzb, "IABTCF_TCString");
        }
    }
}
