package com.tn.lib.net.dns.or;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AddressItem implements Parcelable {
    public static final Parcelable.Creator<AddressItem> CREATOR = new a();
    private final String host;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    private final String f49383ip;
    private boolean ipEnable;
    private final String scheme;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<AddressItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AddressItem createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new AddressItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AddressItem[] newArray(int i11) {
            return new AddressItem[i11];
        }
    }

    public AddressItem(String str, String str2, String str3, boolean z11) {
        this.host = str;
        this.f49383ip = str2;
        this.scheme = str3;
        this.ipEnable = z11;
    }

    public /* synthetic */ AddressItem(String str, String str2, String str3, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i11 & 8) != 0 ? true : z11);
    }

    public static /* synthetic */ AddressItem copy$default(AddressItem addressItem, String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = addressItem.host;
        }
        if ((i11 & 2) != 0) {
            str2 = addressItem.f49383ip;
        }
        if ((i11 & 4) != 0) {
            str3 = addressItem.scheme;
        }
        if ((i11 & 8) != 0) {
            z11 = addressItem.ipEnable;
        }
        return addressItem.copy(str, str2, str3, z11);
    }

    public final String component1() {
        return this.host;
    }

    public final String component2() {
        return this.f49383ip;
    }

    public final String component3() {
        return this.scheme;
    }

    public final boolean component4() {
        return this.ipEnable;
    }

    public final AddressItem copy(String str, String str2, String str3, boolean z11) {
        return new AddressItem(str, str2, str3, z11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressItem)) {
            return false;
        }
        AddressItem addressItem = (AddressItem) obj;
        return Intrinsics.b(this.host, addressItem.host) && Intrinsics.b(this.f49383ip, addressItem.f49383ip) && Intrinsics.b(this.scheme, addressItem.scheme) && this.ipEnable == addressItem.ipEnable;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getIp() {
        return this.f49383ip;
    }

    public final boolean getIpEnable() {
        return this.ipEnable;
    }

    public final String getScheme() {
        return this.scheme;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.host;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f49383ip;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.scheme;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z11 = this.ipEnable;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode3 + r11;
    }

    public final void setIpEnable(boolean z11) {
        this.ipEnable = z11;
    }

    public String toString() {
        return "AddressItem(host=" + this.host + ", ip=" + this.f49383ip + ", scheme=" + this.scheme + ", ipEnable=" + this.ipEnable + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.host);
        out.writeString(this.f49383ip);
        out.writeString(this.scheme);
        out.writeInt(this.ipEnable ? 1 : 0);
    }
}
