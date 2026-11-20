package com.transsion.subtitle.bean;

import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.SubtitleItem;
import com.transsion.subtitle.helper.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
public final class OpenSubtitleData {
    private final OpenSubtitleDataAttributes attributes;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f58121id;
    private final String type;

    public OpenSubtitleData(OpenSubtitleDataAttributes attributes, String id2, String type) {
        Intrinsics.g(attributes, "attributes");
        Intrinsics.g(id2, "id");
        Intrinsics.g(type, "type");
        this.attributes = attributes;
        this.f58121id = id2;
        this.type = type;
    }

    public static /* synthetic */ OpenSubtitleData copy$default(OpenSubtitleData openSubtitleData, OpenSubtitleDataAttributes openSubtitleDataAttributes, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            openSubtitleDataAttributes = openSubtitleData.attributes;
        }
        if ((i11 & 2) != 0) {
            str = openSubtitleData.f58121id;
        }
        if ((i11 & 4) != 0) {
            str2 = openSubtitleData.type;
        }
        return openSubtitleData.copy(openSubtitleDataAttributes, str, str2);
    }

    public final OpenSubtitleDataAttributes component1() {
        return this.attributes;
    }

    public final String component2() {
        return this.f58121id;
    }

    public final String component3() {
        return this.type;
    }

    public final OpenSubtitleData copy(OpenSubtitleDataAttributes attributes, String id2, String type) {
        Intrinsics.g(attributes, "attributes");
        Intrinsics.g(id2, "id");
        Intrinsics.g(type, "type");
        return new OpenSubtitleData(attributes, id2, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenSubtitleData)) {
            return false;
        }
        OpenSubtitleData openSubtitleData = (OpenSubtitleData) obj;
        return Intrinsics.b(this.attributes, openSubtitleData.attributes) && Intrinsics.b(this.f58121id, openSubtitleData.f58121id) && Intrinsics.b(this.type, openSubtitleData.type);
    }

    public final OpenSubtitleDataAttributes getAttributes() {
        return this.attributes;
    }

    public final String getId() {
        return this.f58121id;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.attributes.hashCode() * 31) + this.f58121id.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "OpenSubtitleData(attributes=" + this.attributes + ", id=" + this.f58121id + ", type=" + this.type + ")";
    }

    public final SubtitleItem toSubtitleBean() {
        OpenSubtitleDataFile openSubtitleDataFile;
        List<OpenSubtitleDataFile> files = this.attributes.getFiles();
        if (files == null || (openSubtitleDataFile = (OpenSubtitleDataFile) CollectionsKt___CollectionsKt.g0(files)) == null) {
            return null;
        }
        String str = this.f58121id;
        String language = this.attributes.getLanguage();
        String strB = b.f58260a.b(this.attributes.getLanguage());
        String fileName = openSubtitleDataFile.getFileName();
        OpenSubtitleFeatureDetails featureDetails = this.attributes.getFeatureDetails();
        Integer numValueOf = featureDetails != null ? Integer.valueOf(featureDetails.getSe()) : null;
        OpenSubtitleFeatureDetails featureDetails2 = this.attributes.getFeatureDetails();
        SubtitleItem subtitleItem = new SubtitleItem(str, language, strB, fileName, null, 0L, 0L, numValueOf, featureDetails2 != null ? Integer.valueOf(featureDetails2.getEp()) : null, Integer.valueOf(this.attributes.getDownloadCount()), 5);
        subtitleItem.setFileId(openSubtitleDataFile.getFileId());
        subtitleItem.setOpenSubNewApi(true);
        return subtitleItem;
    }
}
