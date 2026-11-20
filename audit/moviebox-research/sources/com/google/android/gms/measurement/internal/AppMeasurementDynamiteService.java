package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@DynamiteApi
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzcb {

    @VisibleForTesting
    zzfr zza = null;
    private final Map zzb = new a();

    private final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str) {
        zzb();
        this.zza.zzv().zzV(zzcfVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void beginAdUnitExposure(@NonNull String str, long j11) throws RemoteException {
        zzb();
        this.zza.zzd().zzd(str, j11);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        zzb();
        this.zza.zzq().zzA(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void clearMeasurementEnabled(long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzU(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void endAdUnitExposure(@NonNull String str, long j11) throws RemoteException {
        zzb();
        this.zza.zzd().zze(str, j11);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void generateEventId(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        long jZzq = this.zza.zzv().zzq();
        zzb();
        this.zza.zzv().zzU(zzcfVar, jZzq);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new zzi(this, zzcfVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        zzc(zzcfVar, this.zza.zzq().zzo());
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new zzm(this, zzcfVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        zzc(zzcfVar, this.zza.zzq().zzp());
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        zzc(zzcfVar, this.zza.zzq().zzq());
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        String strZzc;
        zzb();
        zzhx zzhxVarZzq = this.zza.zzq();
        if (zzhxVarZzq.zzt.zzw() != null) {
            strZzc = zzhxVarZzq.zzt.zzw();
        } else {
            try {
                strZzc = zzid.zzc(zzhxVarZzq.zzt.zzau(), "google_app_id", zzhxVarZzq.zzt.zzz());
            } catch (IllegalStateException e11) {
                zzhxVarZzq.zzt.zzay().zzd().zzb("getGoogleAppId failed with exception", e11);
                strZzc = null;
            }
        }
        zzc(zzcfVar, strZzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        this.zza.zzq().zzh(str);
        zzb();
        this.zza.zzv().zzT(zzcfVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getSessionId(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        zzhx zzhxVarZzq = this.zza.zzq();
        zzhxVarZzq.zzt.zzaz().zzp(new zzhk(zzhxVarZzq, zzcfVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getTestFlag(com.google.android.gms.internal.measurement.zzcf zzcfVar, int i11) throws RemoteException {
        zzb();
        if (i11 == 0) {
            this.zza.zzv().zzV(zzcfVar, this.zza.zzq().zzr());
            return;
        }
        if (i11 == 1) {
            this.zza.zzv().zzU(zzcfVar, this.zza.zzq().zzm().longValue());
            return;
        }
        if (i11 != 2) {
            if (i11 == 3) {
                this.zza.zzv().zzT(zzcfVar, this.zza.zzq().zzl().intValue());
                return;
            } else {
                if (i11 != 4) {
                    return;
                }
                this.zza.zzv().zzP(zzcfVar, this.zza.zzq().zzi().booleanValue());
                return;
            }
        }
        zzlb zzlbVarZzv = this.zza.zzv();
        double dDoubleValue = this.zza.zzq().zzj().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble(CampaignEx.JSON_KEY_AD_R, dDoubleValue);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e11) {
            zzlbVarZzv.zzt.zzay().zzk().zzb("Error returning double value to wrapper", e11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void getUserProperties(String str, String str2, boolean z11, com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new zzk(this, zzcfVar, str, str2, z11));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void initForTests(@NonNull Map map) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzcl zzclVar, long j11) throws RemoteException {
        zzfr zzfrVar = this.zza;
        if (zzfrVar == null) {
            this.zza = zzfr.zzp((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzclVar, Long.valueOf(j11));
        } else {
            zzfrVar.zzay().zzk().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzcf zzcfVar) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new zzn(this, zzcfVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z11, boolean z12, long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzE(str, str2, bundle, z11, z12, j11);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzcf zzcfVar, long j11) throws RemoteException {
        zzb();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        this.zza.zzaz().zzp(new zzj(this, zzcfVar, new zzaw(str2, new zzau(bundle), MBridgeConstans.DYNAMIC_VIEW_WX_APP, j11), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void logHealthData(int i11, @NonNull String str, @NonNull IObjectWrapper iObjectWrapper, @NonNull IObjectWrapper iObjectWrapper2, @NonNull IObjectWrapper iObjectWrapper3) throws RemoteException {
        zzb();
        this.zza.zzay().zzt(i11, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityCreated(@NonNull IObjectWrapper iObjectWrapper, @NonNull Bundle bundle, long j11) throws RemoteException {
        zzb();
        zzhw zzhwVar = this.zza.zzq().zza;
        if (zzhwVar != null) {
            this.zza.zzq().zzB();
            zzhwVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityDestroyed(@NonNull IObjectWrapper iObjectWrapper, long j11) throws RemoteException {
        zzb();
        zzhw zzhwVar = this.zza.zzq().zza;
        if (zzhwVar != null) {
            this.zza.zzq().zzB();
            zzhwVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityPaused(@NonNull IObjectWrapper iObjectWrapper, long j11) throws RemoteException {
        zzb();
        zzhw zzhwVar = this.zza.zzq().zza;
        if (zzhwVar != null) {
            this.zza.zzq().zzB();
            zzhwVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityResumed(@NonNull IObjectWrapper iObjectWrapper, long j11) throws RemoteException {
        zzb();
        zzhw zzhwVar = this.zza.zzq().zza;
        if (zzhwVar != null) {
            this.zza.zzq().zzB();
            zzhwVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzcf zzcfVar, long j11) throws RemoteException {
        zzb();
        zzhw zzhwVar = this.zza.zzq().zza;
        Bundle bundle = new Bundle();
        if (zzhwVar != null) {
            this.zza.zzq().zzB();
            zzhwVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e11) {
            this.zza.zzay().zzk().zzb("Error returning bundle value to wrapper", e11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityStarted(@NonNull IObjectWrapper iObjectWrapper, long j11) throws RemoteException {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzB();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void onActivityStopped(@NonNull IObjectWrapper iObjectWrapper, long j11) throws RemoteException {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzB();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzcf zzcfVar, long j11) throws RemoteException {
        zzb();
        zzcfVar.zze(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzci zzciVar) throws RemoteException {
        zzgs zzpVar;
        zzb();
        synchronized (this.zzb) {
            try {
                zzpVar = (zzgs) this.zzb.get(Integer.valueOf(zzciVar.zzd()));
                if (zzpVar == null) {
                    zzpVar = new zzp(this, zzciVar);
                    this.zzb.put(Integer.valueOf(zzciVar.zzd()), zzpVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.zza.zzq().zzJ(zzpVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void resetAnalyticsData(long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzK(j11);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConditionalUserProperty(@NonNull Bundle bundle, long j11) throws RemoteException {
        zzb();
        if (bundle == null) {
            this.zza.zzay().zzd().zza("Conditional user property must not be null");
        } else {
            this.zza.zzq().zzQ(bundle, j11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConsent(@NonNull final Bundle bundle, final long j11) throws RemoteException {
        zzb();
        final zzhx zzhxVarZzq = this.zza.zzq();
        zzhxVarZzq.zzt.zzaz().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzgv
            @Override // java.lang.Runnable
            public final void run() {
                zzhx zzhxVar = zzhxVarZzq;
                Bundle bundle2 = bundle;
                long j12 = j11;
                if (TextUtils.isEmpty(zzhxVar.zzt.zzh().zzm())) {
                    zzhxVar.zzR(bundle2, 0, j12);
                } else {
                    zzhxVar.zzt.zzay().zzl().zza("Using developer consent only; google app id found");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setConsentThirdParty(@NonNull Bundle bundle, long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzR(bundle, -20, j11);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setCurrentScreen(@NonNull IObjectWrapper iObjectWrapper, @NonNull String str, @NonNull String str2, long j11) throws RemoteException {
        zzb();
        this.zza.zzs().zzw((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setDataCollectionEnabled(boolean z11) throws RemoteException {
        zzb();
        zzhx zzhxVarZzq = this.zza.zzq();
        zzhxVarZzq.zza();
        zzhxVarZzq.zzt.zzaz().zzp(new zzht(zzhxVarZzq, z11));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        zzb();
        final zzhx zzhxVarZzq = this.zza.zzq();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        zzhxVarZzq.zzt.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzgw
            @Override // java.lang.Runnable
            public final void run() {
                zzhxVarZzq.zzC(bundle2);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzci zzciVar) throws RemoteException {
        zzb();
        zzo zzoVar = new zzo(this, zzciVar);
        if (this.zza.zzaz().zzs()) {
            this.zza.zzq().zzT(zzoVar);
        } else {
            this.zza.zzaz().zzp(new zzl(this, zzoVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzck zzckVar) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setMeasurementEnabled(boolean z11, long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzU(Boolean.valueOf(z11));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setMinimumSessionDuration(long j11) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setSessionTimeoutDuration(long j11) throws RemoteException {
        zzb();
        zzhx zzhxVarZzq = this.zza.zzq();
        zzhxVarZzq.zzt.zzaz().zzp(new zzha(zzhxVarZzq, j11));
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setUserId(@NonNull final String str, long j11) throws RemoteException {
        zzb();
        final zzhx zzhxVarZzq = this.zza.zzq();
        if (str != null && TextUtils.isEmpty(str)) {
            zzhxVarZzq.zzt.zzay().zzk().zza("User ID must be non-empty or null");
        } else {
            zzhxVarZzq.zzt.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzgx
                @Override // java.lang.Runnable
                public final void run() {
                    zzhx zzhxVar = zzhxVarZzq;
                    if (zzhxVar.zzt.zzh().zzp(str)) {
                        zzhxVar.zzt.zzh().zzo();
                    }
                }
            });
            zzhxVarZzq.zzX(null, "_id", str, true, j11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull IObjectWrapper iObjectWrapper, boolean z11, long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzX(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z11, j11);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzci zzciVar) throws RemoteException {
        zzgs zzpVar;
        zzb();
        synchronized (this.zzb) {
            zzpVar = (zzgs) this.zzb.remove(Integer.valueOf(zzciVar.zzd()));
        }
        if (zzpVar == null) {
            zzpVar = new zzp(this, zzciVar);
        }
        this.zza.zzq().zzZ(zzpVar);
    }
}
