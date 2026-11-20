package com.transsion.home.bean;

import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Serializable;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class Item implements Serializable {
    public static final int $stable = 8;

    @SerializedName("filterType")
    private final String filterType;

    @SerializedName("filterValsV2")
    private final List<FilterVal> filterValsV2;

    @SerializedName("rangeVals")
    private final RangeValue rangeVals;

    @SerializedName("showOut")
    private final String showOut;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private final String title;

    public Item(String filterType, String title, String showOut, List<FilterVal> filterValsV2, RangeValue rangeValue) {
        Intrinsics.g(filterType, "filterType");
        Intrinsics.g(title, "title");
        Intrinsics.g(showOut, "showOut");
        Intrinsics.g(filterValsV2, "filterValsV2");
        this.filterType = filterType;
        this.title = title;
        this.showOut = showOut;
        this.filterValsV2 = filterValsV2;
        this.rangeVals = rangeValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, List list, RangeValue rangeValue, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = item.filterType;
        }
        if ((i11 & 2) != 0) {
            str2 = item.title;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            str3 = item.showOut;
        }
        String str5 = str3;
        if ((i11 & 8) != 0) {
            list = item.filterValsV2;
        }
        List list2 = list;
        if ((i11 & 16) != 0) {
            rangeValue = item.rangeVals;
        }
        return item.copy(str, str4, str5, list2, rangeValue);
    }

    public final String component1() {
        return this.filterType;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.showOut;
    }

    public final List<FilterVal> component4() {
        return this.filterValsV2;
    }

    public final RangeValue component5() {
        return this.rangeVals;
    }

    public final Item copy(String filterType, String title, String showOut, List<FilterVal> filterValsV2, RangeValue rangeValue) {
        Intrinsics.g(filterType, "filterType");
        Intrinsics.g(title, "title");
        Intrinsics.g(showOut, "showOut");
        Intrinsics.g(filterValsV2, "filterValsV2");
        return new Item(filterType, title, showOut, filterValsV2, rangeValue);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item item = (Item) obj;
        return Intrinsics.b(this.filterType, item.filterType) && Intrinsics.b(this.title, item.title) && Intrinsics.b(this.showOut, item.showOut) && Intrinsics.b(this.filterValsV2, item.filterValsV2) && Intrinsics.b(this.rangeVals, item.rangeVals);
    }

    public final String getFilterType() {
        return this.filterType;
    }

    public final List<FilterVal> getFilterValsV2() {
        return this.filterValsV2;
    }

    public final RangeValue getRangeVals() {
        return this.rangeVals;
    }

    public final String getShowOut() {
        return this.showOut;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((((this.filterType.hashCode() * 31) + this.title.hashCode()) * 31) + this.showOut.hashCode()) * 31) + this.filterValsV2.hashCode()) * 31;
        RangeValue rangeValue = this.rangeVals;
        return iHashCode + (rangeValue == null ? 0 : rangeValue.hashCode());
    }

    public String toString() {
        return "Item(filterType=" + this.filterType + ", title=" + this.title + ", showOut=" + this.showOut + ", filterValsV2=" + this.filterValsV2 + ", rangeVals=" + this.rangeVals + ")";
    }
}
