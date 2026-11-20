package com.transsion.ad.ps.model;

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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class SafeTag implements Parcelable {
    public static final Parcelable.Creator<SafeTag> CREATOR = new a();
    private String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Integer f50557id;
    private Integer isDeleted;
    private String name;
    private Integer priority;
    private Integer type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SafeTag> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SafeTag createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new SafeTag(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SafeTag[] newArray(int i11) {
            return new SafeTag[i11];
        }
    }

    public SafeTag(String str, Integer num, Integer num2, String str2, Integer num3, Integer num4) {
        this.icon = str;
        this.f50557id = num;
        this.isDeleted = num2;
        this.name = str2;
        this.priority = num3;
        this.type = num4;
    }

    public static /* synthetic */ SafeTag copy$default(SafeTag safeTag, String str, Integer num, Integer num2, String str2, Integer num3, Integer num4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = safeTag.icon;
        }
        if ((i11 & 2) != 0) {
            num = safeTag.f50557id;
        }
        Integer num5 = num;
        if ((i11 & 4) != 0) {
            num2 = safeTag.isDeleted;
        }
        Integer num6 = num2;
        if ((i11 & 8) != 0) {
            str2 = safeTag.name;
        }
        String str3 = str2;
        if ((i11 & 16) != 0) {
            num3 = safeTag.priority;
        }
        Integer num7 = num3;
        if ((i11 & 32) != 0) {
            num4 = safeTag.type;
        }
        return safeTag.copy(str, num5, num6, str3, num7, num4);
    }

    public final String component1() {
        return this.icon;
    }

    public final Integer component2() {
        return this.f50557id;
    }

    public final Integer component3() {
        return this.isDeleted;
    }

    public final String component4() {
        return this.name;
    }

    public final Integer component5() {
        return this.priority;
    }

    public final Integer component6() {
        return this.type;
    }

    public final SafeTag copy(String str, Integer num, Integer num2, String str2, Integer num3, Integer num4) {
        return new SafeTag(str, num, num2, str2, num3, num4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SafeTag)) {
            return false;
        }
        SafeTag safeTag = (SafeTag) obj;
        return Intrinsics.b(this.icon, safeTag.icon) && Intrinsics.b(this.f50557id, safeTag.f50557id) && Intrinsics.b(this.isDeleted, safeTag.isDeleted) && Intrinsics.b(this.name, safeTag.name) && Intrinsics.b(this.priority, safeTag.priority) && Intrinsics.b(this.type, safeTag.type);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final Integer getId() {
        return this.f50557id;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.icon;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.f50557id;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.isDeleted;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.name;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.priority;
        int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.type;
        return iHashCode5 + (num4 != null ? num4.hashCode() : 0);
    }

    public final Integer isDeleted() {
        return this.isDeleted;
    }

    public final void setDeleted(Integer num) {
        this.isDeleted = num;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setId(Integer num) {
        this.f50557id = num;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPriority(Integer num) {
        this.priority = num;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public String toString() {
        return "SafeTag(icon=" + this.icon + ", id=" + this.f50557id + ", isDeleted=" + this.isDeleted + ", name=" + this.name + ", priority=" + this.priority + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.icon);
        Integer num = this.f50557id;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.isDeleted;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        out.writeString(this.name);
        Integer num3 = this.priority;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        Integer num4 = this.type;
        if (num4 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num4.intValue());
        }
    }
}
