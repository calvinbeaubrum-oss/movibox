package com.google.android.gms.maps;

import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzy extends com.google.android.gms.maps.internal.zzak {
    private final /* synthetic */ GoogleMap.OnMapClickListener zzag;

    public zzy(GoogleMap googleMap, GoogleMap.OnMapClickListener onMapClickListener) {
        this.zzag = onMapClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzaj
    public final void onMapClick(LatLng latLng) {
        this.zzag.onMapClick(latLng);
    }
}
