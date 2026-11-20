package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfdr {
    public static void zza(AtomicReference atomicReference, zzfdq zzfdqVar) {
        Object obj = atomicReference.get();
        if (obj == null) {
            return;
        }
        try {
            zzfdqVar.zza(obj);
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
        } catch (NullPointerException e12) {
            zzcec.zzk("NullPointerException occurs when invoking a method from a delegating listener.", e12);
        }
    }
}
