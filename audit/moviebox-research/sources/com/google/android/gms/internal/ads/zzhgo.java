package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzhgo implements Iterator, Closeable, zzarn {
    private static final zzarm zza = new zzhgn("eof ");
    private static final zzhgv zzb = zzhgv.zzb(zzhgo.class);
    protected zzarj zzc;
    protected zzhgp zzd;
    zzarm zze = null;
    long zzf = 0;
    long zzg = 0;
    private final List zzh = new ArrayList();

    public void close() throws IOException {
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzarm zzarmVar = this.zze;
        if (zzarmVar == zza) {
            return false;
        }
        if (zzarmVar != null) {
            return true;
        }
        try {
            this.zze = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zze = zza;
            return false;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("[");
        for (int i11 = 0; i11 < this.zzh.size(); i11++) {
            if (i11 > 0) {
                sb2.append(";");
            }
            sb2.append(((zzarm) this.zzh.get(i11)).toString());
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzarm next() {
        zzarm zzarmVarZzb;
        zzarm zzarmVar = this.zze;
        if (zzarmVar != null && zzarmVar != zza) {
            this.zze = null;
            return zzarmVar;
        }
        zzhgp zzhgpVar = this.zzd;
        if (zzhgpVar == null || this.zzf >= this.zzg) {
            this.zze = zza;
            throw new NoSuchElementException();
        }
        try {
            synchronized (zzhgpVar) {
                this.zzd.zze(this.zzf);
                zzarmVarZzb = this.zzc.zzb(this.zzd, this);
                this.zzf = this.zzd.zzb();
            }
            return zzarmVarZzb;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public final List zze() {
        return (this.zzd == null || this.zze == zza) ? this.zzh : new zzhgu(this.zzh, this);
    }

    public final void zzf(zzhgp zzhgpVar, long j11, zzarj zzarjVar) throws IOException {
        this.zzd = zzhgpVar;
        this.zzf = zzhgpVar.zzb();
        zzhgpVar.zze(zzhgpVar.zzb() + j11);
        this.zzg = zzhgpVar.zzb();
        this.zzc = zzarjVar;
    }
}
