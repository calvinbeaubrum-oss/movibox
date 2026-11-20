package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import com.hisavana.common.constant.ComConstants;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import z2.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaq extends zzgl {
    private long zza;
    private String zzb;
    private AccountManager zzc;
    private Boolean zzd;
    private long zze;

    public zzaq(zzfr zzfrVar) {
        super(zzfrVar);
    }

    public final long zza() {
        zzg();
        return this.zze;
    }

    public final long zzb() {
        zzu();
        return this.zza;
    }

    public final String zzc() {
        zzu();
        return this.zzb;
    }

    public final void zzd() {
        zzg();
        this.zzd = null;
        this.zze = 0L;
    }

    public final boolean zze() {
        zzg();
        long jCurrentTimeMillis = this.zzt.zzav().currentTimeMillis();
        if (jCurrentTimeMillis - this.zze > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
            this.zzd = null;
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (a.checkSelfPermission(this.zzt.zzau(), "android.permission.GET_ACCOUNTS") != 0) {
            this.zzt.zzay().zzm().zza("Permission error checking for dasher/unicorn accounts");
            this.zze = jCurrentTimeMillis;
            this.zzd = Boolean.FALSE;
            return false;
        }
        if (this.zzc == null) {
            this.zzc = AccountManager.get(this.zzt.zzau());
        }
        try {
            Account[] result = this.zzc.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
            if (result != null && result.length > 0) {
                this.zzd = Boolean.TRUE;
                this.zze = jCurrentTimeMillis;
                return true;
            }
            Account[] result2 = this.zzc.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
            if (result2 != null && result2.length > 0) {
                this.zzd = Boolean.TRUE;
                this.zze = jCurrentTimeMillis;
                return true;
            }
            this.zze = jCurrentTimeMillis;
            this.zzd = Boolean.FALSE;
            return false;
        } catch (AuthenticatorException e11) {
            e = e11;
            this.zzt.zzay().zzh().zzb("Exception checking account types", e);
        } catch (OperationCanceledException e12) {
            e = e12;
            this.zzt.zzay().zzh().zzb("Exception checking account types", e);
        } catch (IOException e13) {
            e = e13;
            this.zzt.zzay().zzh().zzb("Exception checking account types", e);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zzf() {
        Calendar calendar = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.zzb = language.toLowerCase(locale2) + "-" + locale.getCountry().toLowerCase(locale2);
        return false;
    }
}
