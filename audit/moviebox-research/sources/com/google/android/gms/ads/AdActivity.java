package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbwt;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class AdActivity extends Activity {

    @NonNull
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";

    @Nullable
    private zzbwt zza;

    private final void zza() {
        zzbwt zzbwtVar = this.zza;
        if (zzbwtVar != null) {
            try {
                zzbwtVar.zzx();
            } catch (RemoteException e11) {
                zzcec.zzl("#007 Could not call remote method.", e11);
            }
        }
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i11, int i12, @NonNull Intent intent) {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzh(i11, i12, intent);
            }
        } catch (Exception e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
        }
        super.onActivityResult(i11, i12, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null && !zzbwtVar.zzH()) {
                return;
            }
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
        }
        super.onBackPressed();
        try {
            zzbwt zzbwtVar2 = this.zza;
            if (zzbwtVar2 != null) {
                zzbwtVar2.zzi();
            }
        } catch (RemoteException e12) {
            zzcec.zzl("#007 Could not call remote method.", e12);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzk(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        zzbwt zzbwtVarZzo = zzay.zza().zzo(this);
        this.zza = zzbwtVarZzo;
        if (zzbwtVarZzo == null) {
            zzcec.zzl("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzbwtVarZzo.zzl(bundle);
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzm();
            }
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onPause() {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzo();
            }
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzp(i11, strArr, iArr);
            }
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
        }
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzq();
            }
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzr();
            }
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzs(bundle);
            }
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzt();
            }
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzu();
            }
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbwt zzbwtVar = this.zza;
            if (zzbwtVar != null) {
                zzbwtVar.zzv();
            }
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i11) {
        super.setContentView(i11);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(@NonNull View view) {
        super.setContentView(view);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(@NonNull View view, @NonNull ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
