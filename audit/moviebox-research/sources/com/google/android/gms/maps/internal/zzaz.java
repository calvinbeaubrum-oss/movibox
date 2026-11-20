package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface zzaz extends IInterface {
    void onMyLocationClick(Location location) throws RemoteException;
}
