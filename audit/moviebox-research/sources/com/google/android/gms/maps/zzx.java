package com.google.android.gms.maps;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzx extends com.google.android.gms.maps.internal.zzo {
    private final /* synthetic */ GoogleMap.OnCameraIdleListener zzaf;

    public zzx(GoogleMap googleMap, GoogleMap.OnCameraIdleListener onCameraIdleListener) {
        this.zzaf = onCameraIdleListener;
    }

    @Override // com.google.android.gms.maps.internal.zzn
    public final void onCameraIdle() {
        this.zzaf.onCameraIdle();
    }
}
