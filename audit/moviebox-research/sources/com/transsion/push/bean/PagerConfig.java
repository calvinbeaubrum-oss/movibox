package com.transsion.push.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class PagerConfig implements Parcelable {
    public static final Parcelable.Creator<PagerConfig> CREATOR = new Creator();
    private final boolean hasMore;
    private final String nextPage;
    private final String page;
    private final int perPage;
    private final int totalCount;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<PagerConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PagerConfig createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PagerConfig(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PagerConfig[] newArray(int i11) {
            return new PagerConfig[i11];
        }
    }

    public PagerConfig(boolean z11, String str, String str2, int i11, int i12) {
        this.hasMore = z11;
        this.nextPage = str;
        this.page = str2;
        this.perPage = i11;
        this.totalCount = i12;
    }

    public /* synthetic */ PagerConfig(boolean z11, String str, String str2, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, (i13 & 2) != 0 ? null : str, (i13 & 4) != 0 ? null : str2, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? 0 : i12);
    }

    public static /* synthetic */ PagerConfig copy$default(PagerConfig pagerConfig, boolean z11, String str, String str2, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            z11 = pagerConfig.hasMore;
        }
        if ((i13 & 2) != 0) {
            str = pagerConfig.nextPage;
        }
        String str3 = str;
        if ((i13 & 4) != 0) {
            str2 = pagerConfig.page;
        }
        String str4 = str2;
        if ((i13 & 8) != 0) {
            i11 = pagerConfig.perPage;
        }
        int i14 = i11;
        if ((i13 & 16) != 0) {
            i12 = pagerConfig.totalCount;
        }
        return pagerConfig.copy(z11, str3, str4, i14, i12);
    }

    public final boolean component1() {
        return this.hasMore;
    }

    public final String component2() {
        return this.nextPage;
    }

    public final String component3() {
        return this.page;
    }

    public final int component4() {
        return this.perPage;
    }

    public final int component5() {
        return this.totalCount;
    }

    public final PagerConfig copy(boolean z11, String str, String str2, int i11, int i12) {
        return new PagerConfig(z11, str, str2, i11, i12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PagerConfig)) {
            return false;
        }
        PagerConfig pagerConfig = (PagerConfig) obj;
        return this.hasMore == pagerConfig.hasMore && Intrinsics.b(this.nextPage, pagerConfig.nextPage) && Intrinsics.b(this.page, pagerConfig.page) && this.perPage == pagerConfig.perPage && this.totalCount == pagerConfig.totalCount;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNextPage() {
        return this.nextPage;
    }

    public final String getPage() {
        return this.page;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z11 = this.hasMore;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        String str = this.nextPage;
        int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.page;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.perPage) * 31) + this.totalCount;
    }

    public String toString() {
        return "PagerConfig(hasMore=" + this.hasMore + ", nextPage=" + this.nextPage + ", page=" + this.page + ", perPage=" + this.perPage + ", totalCount=" + this.totalCount + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.hasMore ? 1 : 0);
        out.writeString(this.nextPage);
        out.writeString(this.page);
        out.writeInt(this.perPage);
        out.writeInt(this.totalCount);
    }
}
