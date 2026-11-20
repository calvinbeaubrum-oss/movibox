package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@SafeParcelable.Class(creator = "ClientIdentityCreator")
@SafeParcelable.Reserved({2, 5})
@SourceDebugExtension
public final class zze extends AbstractSafeParcelable {

    @SafeParcelable.Field(getter = "getUid", id = 1)
    private final int zzb;

    @SafeParcelable.Field(getter = "getPackageName", id = 3)
    private final String zzc;

    @SafeParcelable.Field(getter = "getAttributionTag", id = 4)
    private final String zzd;

    @SafeParcelable.Field(getter = "getListenerId", id = 6)
    private final String zze;

    @SafeParcelable.Field(getter = "getClientFeatures", id = 8)
    private final List zzf;

    @SafeParcelable.Field(getter = "getImpersonator", id = 7)
    private final zze zzg;
    public static final zzd zza = new zzd(null);

    @JvmField
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    static {
        Process.myUid();
        Process.myPid();
    }

    @Deprecated
    @SafeParcelable.Constructor
    public zze(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 3) String packageName, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 8) List list, @SafeParcelable.Param(id = 7) zze zzeVar) {
        Intrinsics.g(packageName, "packageName");
        if (zzeVar != null && zzeVar.zza()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.zzb = i11;
        this.zzc = packageName;
        this.zzd = str;
        if (str2 == null) {
            str2 = zzeVar != null ? zzeVar.zze : null;
        }
        this.zze = str2;
        if (list == null) {
            list = zzeVar != null ? zzeVar.zzf : null;
            if (list == null) {
                list = zzex.zzi();
                Intrinsics.f(list, "of(...)");
            }
        }
        Intrinsics.g(list, "<this>");
        zzex zzexVarZzj = zzex.zzj(list);
        Intrinsics.f(zzexVarZzj, "copyOf(...)");
        this.zzf = zzexVarZzj;
        this.zzg = zzeVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zze) {
            zze zzeVar = (zze) obj;
            if (this.zzb == zzeVar.zzb && Intrinsics.b(this.zzc, zzeVar.zzc) && Intrinsics.b(this.zzd, zzeVar.zzd) && Intrinsics.b(this.zze, zzeVar.zze) && Intrinsics.b(this.zzg, zzeVar.zzg) && Intrinsics.b(this.zzf, zzeVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze, this.zzg});
    }

    public final String toString() {
        int length = this.zzc.length() + 18;
        String str = this.zzd;
        StringBuilder sb2 = new StringBuilder(length + (str != null ? str.length() : 0));
        sb2.append(this.zzb);
        sb2.append("/");
        sb2.append(this.zzc);
        String str2 = this.zzd;
        if (str2 != null) {
            sb2.append("[");
            if (l.L(str2, this.zzc, false, 2, null)) {
                sb2.append((CharSequence) str2, this.zzc.length(), str2.length());
            } else {
                sb2.append(str2);
            }
            sb2.append("]");
        }
        if (this.zze != null) {
            sb2.append("/");
            String str3 = this.zze;
            sb2.append(Integer.toHexString(str3 != null ? str3.hashCode() : 0));
        }
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i11) {
        Intrinsics.g(dest, "dest");
        int i12 = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeInt(dest, 1, i12);
        SafeParcelWriter.writeString(dest, 3, this.zzc, false);
        SafeParcelWriter.writeString(dest, 4, this.zzd, false);
        SafeParcelWriter.writeString(dest, 6, this.zze, false);
        SafeParcelWriter.writeParcelable(dest, 7, this.zzg, i11, false);
        SafeParcelWriter.writeTypedList(dest, 8, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(dest, iBeginObjectHeader);
    }

    public final boolean zza() {
        return this.zzg != null;
    }
}
