package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "GassResponseParcelCreator")
public final class zzfsb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfsb> CREATOR = new zzfsc();

    @SafeParcelable.VersionField(id = 1)
    public final int zza;

    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", id = 2, type = "byte[]")
    private zzatd zzb = null;
    private byte[] zzc;

    @SafeParcelable.Constructor
    public zzfsb(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.zza = i11;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzatd zzatdVar = this.zzb;
        if (zzatdVar != null || this.zzc == null) {
            if (zzatdVar == null || this.zzc != null) {
                if (zzatdVar != null && this.zzc != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (zzatdVar != null || this.zzc != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        int i12 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i12);
        byte[] bArrZzax = this.zzc;
        if (bArrZzax == null) {
            bArrZzax = this.zzb.zzax();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArrZzax, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzatd zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzatd.zze(this.zzc, zzgzf.zza());
                this.zzc = null;
            } catch (zzhag | NullPointerException e11) {
                throw new IllegalStateException(e11);
            }
        }
        zzb();
        return this.zzb;
    }
}
