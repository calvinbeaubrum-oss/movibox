package com.transsion.search.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Cover;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class VerticalRank implements Parcelable, Serializable {
    public static final Parcelable.Creator<VerticalRank> CREATOR = new a();
    private Integer count;
    private Cover cover;
    private String deeplink;
    private String description;
    private String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<VerticalRank> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final VerticalRank createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new VerticalRank(parcel.readString(), parcel.readString(), parcel.readString(), (Cover) parcel.readSerializable(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final VerticalRank[] newArray(int i11) {
            return new VerticalRank[i11];
        }
    }

    public VerticalRank(String str, String str2, String str3, Cover cover, Integer num) {
        this.title = str;
        this.description = str2;
        this.deeplink = str3;
        this.cover = cover;
        this.count = num;
    }

    public static /* synthetic */ VerticalRank copy$default(VerticalRank verticalRank, String str, String str2, String str3, Cover cover, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = verticalRank.title;
        }
        if ((i11 & 2) != 0) {
            str2 = verticalRank.description;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            str3 = verticalRank.deeplink;
        }
        String str5 = str3;
        if ((i11 & 8) != 0) {
            cover = verticalRank.cover;
        }
        Cover cover2 = cover;
        if ((i11 & 16) != 0) {
            num = verticalRank.count;
        }
        return verticalRank.copy(str, str4, str5, cover2, num);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.deeplink;
    }

    public final Cover component4() {
        return this.cover;
    }

    public final Integer component5() {
        return this.count;
    }

    public final VerticalRank copy(String str, String str2, String str3, Cover cover, Integer num) {
        return new VerticalRank(str, str2, str3, cover, num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerticalRank)) {
            return false;
        }
        VerticalRank verticalRank = (VerticalRank) obj;
        return Intrinsics.b(this.title, verticalRank.title) && Intrinsics.b(this.description, verticalRank.description) && Intrinsics.b(this.deeplink, verticalRank.deeplink) && Intrinsics.b(this.cover, verticalRank.cover) && Intrinsics.b(this.count, verticalRank.count);
    }

    public final Integer getCount() {
        return this.count;
    }

    public final Cover getCover() {
        return this.cover;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deeplink;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Cover cover = this.cover;
        int iHashCode4 = (iHashCode3 + (cover == null ? 0 : cover.hashCode())) * 31;
        Integer num = this.count;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    public final void setCount(Integer num) {
        this.count = num;
    }

    public final void setCover(Cover cover) {
        this.cover = cover;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "VerticalRank(title=" + this.title + ", description=" + this.description + ", deeplink=" + this.deeplink + ", cover=" + this.cover + ", count=" + this.count + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        int iIntValue;
        Intrinsics.g(out, "out");
        out.writeString(this.title);
        out.writeString(this.description);
        out.writeString(this.deeplink);
        out.writeSerializable(this.cover);
        Integer num = this.count;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
    }
}
