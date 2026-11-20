package com.transsion.search.bean;

import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Staff;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class SearchValuesRelatedCollectionEntity implements Serializable {
    private final Staff staff;
    private final String title;
    private final int type;
    private final VerticalRank verticalRank;

    public SearchValuesRelatedCollectionEntity(int i11, String title, VerticalRank verticalRank, Staff staff) {
        Intrinsics.g(title, "title");
        this.type = i11;
        this.title = title;
        this.verticalRank = verticalRank;
        this.staff = staff;
    }

    public static /* synthetic */ SearchValuesRelatedCollectionEntity copy$default(SearchValuesRelatedCollectionEntity searchValuesRelatedCollectionEntity, int i11, String str, VerticalRank verticalRank, Staff staff, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = searchValuesRelatedCollectionEntity.type;
        }
        if ((i12 & 2) != 0) {
            str = searchValuesRelatedCollectionEntity.title;
        }
        if ((i12 & 4) != 0) {
            verticalRank = searchValuesRelatedCollectionEntity.verticalRank;
        }
        if ((i12 & 8) != 0) {
            staff = searchValuesRelatedCollectionEntity.staff;
        }
        return searchValuesRelatedCollectionEntity.copy(i11, str, verticalRank, staff);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.title;
    }

    public final VerticalRank component3() {
        return this.verticalRank;
    }

    public final Staff component4() {
        return this.staff;
    }

    public final SearchValuesRelatedCollectionEntity copy(int i11, String title, VerticalRank verticalRank, Staff staff) {
        Intrinsics.g(title, "title");
        return new SearchValuesRelatedCollectionEntity(i11, title, verticalRank, staff);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchValuesRelatedCollectionEntity)) {
            return false;
        }
        SearchValuesRelatedCollectionEntity searchValuesRelatedCollectionEntity = (SearchValuesRelatedCollectionEntity) obj;
        return this.type == searchValuesRelatedCollectionEntity.type && Intrinsics.b(this.title, searchValuesRelatedCollectionEntity.title) && Intrinsics.b(this.verticalRank, searchValuesRelatedCollectionEntity.verticalRank) && Intrinsics.b(this.staff, searchValuesRelatedCollectionEntity.staff);
    }

    public final Staff getStaff() {
        return this.staff;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final VerticalRank getVerticalRank() {
        return this.verticalRank;
    }

    public int hashCode() {
        int iHashCode = ((this.type * 31) + this.title.hashCode()) * 31;
        VerticalRank verticalRank = this.verticalRank;
        int iHashCode2 = (iHashCode + (verticalRank == null ? 0 : verticalRank.hashCode())) * 31;
        Staff staff = this.staff;
        return iHashCode2 + (staff != null ? staff.hashCode() : 0);
    }

    public String toString() {
        return "SearchValuesRelatedCollectionEntity(type=" + this.type + ", title=" + this.title + ", verticalRank=" + this.verticalRank + ", staff=" + this.staff + ")";
    }
}
