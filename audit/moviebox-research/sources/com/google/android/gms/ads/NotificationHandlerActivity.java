package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzbwm;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class NotificationHandlerActivity extends Activity {

    @NonNull
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.NotificationHandlerActivity";

    @Override // android.app.Activity
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            zzbwm zzbwmVarZzm = zzay.zza().zzm(this, new zzbsr());
            if (zzbwmVarZzm == null) {
                zzcec.zzg("OfflineUtils is null");
            } else {
                zzbwmVarZzm.zze(getIntent());
            }
        } catch (RemoteException e11) {
            zzcec.zzg("RemoteException calling handleNotificationIntent: ".concat(e11.toString()));
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        finish();
    }
}
