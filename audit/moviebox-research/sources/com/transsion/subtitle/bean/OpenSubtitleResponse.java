package com.transsion.subtitle.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class OpenSubtitleResponse {
    private final List<OpenSubtitleData> data;
    private final int page;

    @SerializedName("per_page")
    private final int perPage;

    @SerializedName("total_count")
    private final int totalCount;

    @SerializedName("total_pages")
    private final int totalPages;

    public OpenSubtitleResponse(int i11, int i12, int i13, int i14, List<OpenSubtitleData> list) {
        this.totalPages = i11;
        this.totalCount = i12;
        this.perPage = i13;
        this.page = i14;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenSubtitleResponse copy$default(OpenSubtitleResponse openSubtitleResponse, int i11, int i12, int i13, int i14, List list, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = openSubtitleResponse.totalPages;
        }
        if ((i15 & 2) != 0) {
            i12 = openSubtitleResponse.totalCount;
        }
        int i16 = i12;
        if ((i15 & 4) != 0) {
            i13 = openSubtitleResponse.perPage;
        }
        int i17 = i13;
        if ((i15 & 8) != 0) {
            i14 = openSubtitleResponse.page;
        }
        int i18 = i14;
        if ((i15 & 16) != 0) {
            list = openSubtitleResponse.data;
        }
        return openSubtitleResponse.copy(i11, i16, i17, i18, list);
    }

    public final int component1() {
        return this.totalPages;
    }

    public final int component2() {
        return this.totalCount;
    }

    public final int component3() {
        return this.perPage;
    }

    public final int component4() {
        return this.page;
    }

    public final List<OpenSubtitleData> component5() {
        return this.data;
    }

    public final OpenSubtitleResponse copy(int i11, int i12, int i13, int i14, List<OpenSubtitleData> list) {
        return new OpenSubtitleResponse(i11, i12, i13, i14, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenSubtitleResponse)) {
            return false;
        }
        OpenSubtitleResponse openSubtitleResponse = (OpenSubtitleResponse) obj;
        return this.totalPages == openSubtitleResponse.totalPages && this.totalCount == openSubtitleResponse.totalCount && this.perPage == openSubtitleResponse.perPage && this.page == openSubtitleResponse.page && Intrinsics.b(this.data, openSubtitleResponse.data);
    }

    public final List<OpenSubtitleData> getData() {
        return this.data;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final int getTotalPages() {
        return this.totalPages;
    }

    public int hashCode() {
        int i11 = ((((((this.totalPages * 31) + this.totalCount) * 31) + this.perPage) * 31) + this.page) * 31;
        List<OpenSubtitleData> list = this.data;
        return i11 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "OpenSubtitleResponse(totalPages=" + this.totalPages + ", totalCount=" + this.totalCount + ", perPage=" + this.perPage + ", page=" + this.page + ", data=" + this.data + ")";
    }
}
