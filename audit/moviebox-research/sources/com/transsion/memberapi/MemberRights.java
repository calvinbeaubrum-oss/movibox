package com.transsion.memberapi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
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
@Keep
@Metadata
public final class MemberRights implements Parcelable {
    public static final Parcelable.Creator<MemberRights> CREATOR = new a();
    private final String description;
    private final String icon;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<MemberRights> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MemberRights createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MemberRights(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MemberRights[] newArray(int i11) {
            return new MemberRights[i11];
        }
    }

    public MemberRights(String icon, String description) {
        Intrinsics.g(icon, "icon");
        Intrinsics.g(description, "description");
        this.icon = icon;
        this.description = description;
    }

    public static /* synthetic */ MemberRights copy$default(MemberRights memberRights, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = memberRights.icon;
        }
        if ((i11 & 2) != 0) {
            str2 = memberRights.description;
        }
        return memberRights.copy(str, str2);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.description;
    }

    public final MemberRights copy(String icon, String description) {
        Intrinsics.g(icon, "icon");
        Intrinsics.g(description, "description");
        return new MemberRights(icon, description);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberRights)) {
            return false;
        }
        MemberRights memberRights = (MemberRights) obj;
        return Intrinsics.b(this.icon, memberRights.icon) && Intrinsics.b(this.description, memberRights.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon() {
        return this.icon;
    }

    public int hashCode() {
        return (this.icon.hashCode() * 31) + this.description.hashCode();
    }

    public String toString() {
        return "MemberRights(icon=" + this.icon + ", description=" + this.description + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.icon);
        out.writeString(this.description);
    }
}
