package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.maps.internal.zzba;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzj extends zzba {
    private final /* synthetic */ GoogleMap.OnMyLocationClickListener zzr;

    public zzj(GoogleMap googleMap, GoogleMap.OnMyLocationClickListener onMyLocationClickListener) {
        this.zzr = onMyLocationClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzaz
    public final void onMyLocationClick(@NonNull Location location) throws RemoteException {
        this.zzr.onMyLocationClick(location);
    }
}
