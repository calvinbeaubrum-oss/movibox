package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzgds extends zzgdb.zzi {
    private static final zzgdo zzba;
    private static final zzgex zzbb = new zzgex(zzgds.class);
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    static {
        zzgdo zzgdrVar;
        Throwable th2;
        zzgdq zzgdqVar = null;
        try {
            zzgdrVar = new zzgdp(AtomicReferenceFieldUpdater.newUpdater(zzgds.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzgds.class, "remaining"));
            th2 = null;
        } catch (Throwable th3) {
            zzgdrVar = new zzgdr(zzgdqVar);
            th2 = th3;
        }
        zzba = zzgdrVar;
        if (th2 != null) {
            zzbb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
    }

    public zzgds(int i11) {
        this.remaining = i11;
    }

    public final int zzA() {
        return zzba.zza(this);
    }

    public final Set zzC() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zze(setNewSetFromMap);
        zzba.zzb(this, null, setNewSetFromMap);
        Set<Throwable> set2 = this.seenExceptions;
        Objects.requireNonNull(set2);
        return set2;
    }

    public final void zzF() {
        this.seenExceptions = null;
    }

    public abstract void zze(Set set);
}
