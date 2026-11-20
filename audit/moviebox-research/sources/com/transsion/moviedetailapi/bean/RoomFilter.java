package com.transsion.moviedetailapi.bean;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RoomFilter implements Parcelable {
    public static final int NEARBY_CID = -2;
    public static final int RECOMMEND_CID = -1;
    private Integer cid;
    private transient boolean isSelected;
    private String title;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<RoomFilter> CREATOR = new b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Parcelable.Creator<RoomFilter> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RoomFilter createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new RoomFilter(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RoomFilter[] newArray(int i11) {
            return new RoomFilter[i11];
        }
    }

    public RoomFilter(Integer num, String str) {
        this.cid = num;
        this.title = str;
    }

    public static /* synthetic */ RoomFilter copy$default(RoomFilter roomFilter, Integer num, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = roomFilter.cid;
        }
        if ((i11 & 2) != 0) {
            str = roomFilter.title;
        }
        return roomFilter.copy(num, str);
    }

    public static /* synthetic */ void isSelected$annotations() {
    }

    public final Integer component1() {
        return this.cid;
    }

    public final String component2() {
        return this.title;
    }

    public final RoomFilter copy(Integer num, String str) {
        return new RoomFilter(num, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoomFilter)) {
            return false;
        }
        RoomFilter roomFilter = (RoomFilter) obj;
        return Intrinsics.b(this.cid, roomFilter.cid) && Intrinsics.b(this.title, roomFilter.title);
    }

    public final Integer getCid() {
        return this.cid;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Integer num = this.cid;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.title;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setCid(Integer num) {
        this.cid = num;
    }

    public final void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "RoomFilter(cid=" + this.cid + ", title=" + this.title + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        int iIntValue;
        Intrinsics.g(out, "out");
        Integer num = this.cid;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
        out.writeString(this.title);
    }
}
