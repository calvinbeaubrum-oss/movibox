package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgnd {
    private static final Logger zza = Logger.getLogger(zzgnd.class.getName());
    private static final zzgnd zzb = new zzgnd();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    public static zzgnd zzc() {
        return zzb;
    }

    private final synchronized zzgnc zzg(String str) throws GeneralSecurityException {
        if (!this.zzc.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzgnc) this.zzc.get(str);
    }

    private final synchronized void zzh(zzgnc zzgncVar, boolean z11, boolean z12) throws GeneralSecurityException {
        try {
            String str = ((zzgnm) zzgncVar.zza).zza;
            if (this.zzd.containsKey(str) && !((Boolean) this.zzd.get(str)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
            }
            zzgnc zzgncVar2 = (zzgnc) this.zzc.get(str);
            if (zzgncVar2 != null && !zzgncVar2.zza().equals(zzgncVar.zza())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(str));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, zzgncVar2.zza().getName(), zzgncVar.zza().getName()));
            }
            this.zzc.putIfAbsent(str, zzgncVar);
            this.zzd.put(str, Boolean.TRUE);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final zzggd zza(String str, Class cls) throws GeneralSecurityException {
        zzgnc zzgncVarZzg = zzg(str);
        if (zzgncVarZzg.zzb().contains(cls)) {
            if (((zzgnm) zzgncVarZzg.zza).zzb.equals(cls)) {
                return zzgncVarZzg.zza;
            }
            throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
        }
        String name = cls.getName();
        String strValueOf = String.valueOf(zzgncVarZzg.zza());
        Set<Class> setZzb = zzgncVarZzg.zzb();
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = true;
        for (Class cls2 : setZzb) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append(cls2.getCanonicalName());
            z11 = false;
        }
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + strValueOf + ", supported primitives: " + sb2.toString());
    }

    public final zzggd zzb(String str) throws GeneralSecurityException {
        return zzg(str).zza;
    }

    public final synchronized void zzd(zzggd zzggdVar, boolean z11) throws GeneralSecurityException {
        zzf(zzggdVar, 1, true);
    }

    public final boolean zze(String str) {
        return ((Boolean) this.zzd.get(str)).booleanValue();
    }

    public final synchronized void zzf(zzggd zzggdVar, int i11, boolean z11) throws GeneralSecurityException {
        if (!zzgmv.zza(i11)) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        zzh(new zzgnc(zzggdVar), false, true);
    }
}
