package com.transsnet.downloader.bean;

import com.google.gson.annotations.SerializedName;
import com.transsion.moviedetailapi.bean.SubtitleItem;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SubtitleListBean implements Serializable {

    @SerializedName("extCaptions")
    private List<SubtitleItem> extSubtitle;

    @SerializedName("subjectId")
    private String subjectId;

    public SubtitleListBean(String str, List<SubtitleItem> list) {
        this.subjectId = str;
        this.extSubtitle = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubtitleListBean copy$default(SubtitleListBean subtitleListBean, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subtitleListBean.subjectId;
        }
        if ((i11 & 2) != 0) {
            list = subtitleListBean.extSubtitle;
        }
        return subtitleListBean.copy(str, list);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final List<SubtitleItem> component2() {
        return this.extSubtitle;
    }

    public final SubtitleListBean copy(String str, List<SubtitleItem> list) {
        return new SubtitleListBean(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubtitleListBean)) {
            return false;
        }
        SubtitleListBean subtitleListBean = (SubtitleListBean) obj;
        return Intrinsics.b(this.subjectId, subtitleListBean.subjectId) && Intrinsics.b(this.extSubtitle, subtitleListBean.extSubtitle);
    }

    public final List<SubtitleItem> getExtSubtitle() {
        return this.extSubtitle;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public int hashCode() {
        String str = this.subjectId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<SubtitleItem> list = this.extSubtitle;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setExtSubtitle(List<SubtitleItem> list) {
        this.extSubtitle = list;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public String toString() {
        return "SubtitleListBean(subjectId=" + this.subjectId + ", extSubtitle=" + this.extSubtitle + ")";
    }
}
