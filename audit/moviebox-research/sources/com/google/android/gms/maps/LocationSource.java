package com.google.android.gms.maps;

import android.location.Location;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface LocationSource {

    /* JADX INFO: compiled from: source.java */
    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
