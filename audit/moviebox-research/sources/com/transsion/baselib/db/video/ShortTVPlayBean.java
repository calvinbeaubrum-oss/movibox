package com.transsion.baselib.db.video;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
@Keep
@Metadata
public final class ShortTVPlayBean {
    private final String coverUrl;
    private final String description;

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    private final int f51089ep;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f51090id;
    private final long progress;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    private final int f51091se;
    private final String subjectId;
    private final String thumbnail;
    private final long timeStamp;
    private final String title;
    private final int totalEp;
    private final String videoId;
    private final String videoUrl;

    public ShortTVPlayBean(String subjectId, String id2, int i11, int i12, int i13, long j11, String str, String str2, String str3, String str4, String str5, String str6, long j12) {
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(id2, "id");
        this.subjectId = subjectId;
        this.f51090id = id2;
        this.f51089ep = i11;
        this.f51091se = i12;
        this.totalEp = i13;
        this.progress = j11;
        this.title = str;
        this.description = str2;
        this.coverUrl = str3;
        this.thumbnail = str4;
        this.videoId = str5;
        this.videoUrl = str6;
        this.timeStamp = j12;
    }

    public /* synthetic */ ShortTVPlayBean(String str, String str2, int i11, int i12, int i13, long j11, String str3, String str4, String str5, String str6, String str7, String str8, long j12, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i14 & 4) != 0 ? 0 : i11, (i14 & 8) != 0 ? 0 : i12, (i14 & 16) != 0 ? 0 : i13, (i14 & 32) != 0 ? 0L : j11, (i14 & 64) != 0 ? null : str3, (i14 & 128) != 0 ? null : str4, (i14 & 256) != 0 ? null : str5, (i14 & 512) != 0 ? null : str6, (i14 & 1024) != 0 ? null : str7, (i14 & 2048) != 0 ? null : str8, (i14 & 4096) != 0 ? 0L : j12);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final String component10() {
        return this.thumbnail;
    }

    public final String component11() {
        return this.videoId;
    }

    public final String component12() {
        return this.videoUrl;
    }

    public final long component13() {
        return this.timeStamp;
    }

    public final String component2() {
        return this.f51090id;
    }

    public final int component3() {
        return this.f51089ep;
    }

    public final int component4() {
        return this.f51091se;
    }

    public final int component5() {
        return this.totalEp;
    }

    public final long component6() {
        return this.progress;
    }

    public final String component7() {
        return this.title;
    }

    public final String component8() {
        return this.description;
    }

    public final String component9() {
        return this.coverUrl;
    }

    public final ShortTVPlayBean copy(String subjectId, String id2, int i11, int i12, int i13, long j11, String str, String str2, String str3, String str4, String str5, String str6, long j12) {
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(id2, "id");
        return new ShortTVPlayBean(subjectId, id2, i11, i12, i13, j11, str, str2, str3, str4, str5, str6, j12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShortTVPlayBean)) {
            return false;
        }
        ShortTVPlayBean shortTVPlayBean = (ShortTVPlayBean) obj;
        return Intrinsics.b(this.subjectId, shortTVPlayBean.subjectId) && Intrinsics.b(this.f51090id, shortTVPlayBean.f51090id) && this.f51089ep == shortTVPlayBean.f51089ep && this.f51091se == shortTVPlayBean.f51091se && this.totalEp == shortTVPlayBean.totalEp && this.progress == shortTVPlayBean.progress && Intrinsics.b(this.title, shortTVPlayBean.title) && Intrinsics.b(this.description, shortTVPlayBean.description) && Intrinsics.b(this.coverUrl, shortTVPlayBean.coverUrl) && Intrinsics.b(this.thumbnail, shortTVPlayBean.thumbnail) && Intrinsics.b(this.videoId, shortTVPlayBean.videoId) && Intrinsics.b(this.videoUrl, shortTVPlayBean.videoUrl) && this.timeStamp == shortTVPlayBean.timeStamp;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getEp() {
        return this.f51089ep;
    }

    public final String getId() {
        return this.f51090id;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final int getSe() {
        return this.f51091se;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTotalEp() {
        return this.totalEp;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.subjectId.hashCode() * 31) + this.f51090id.hashCode()) * 31) + this.f51089ep) * 31) + this.f51091se) * 31) + this.totalEp) * 31) + p.a(this.progress)) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.coverUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.thumbnail;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.videoId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.videoUrl;
        return ((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + p.a(this.timeStamp);
    }

    public String toString() {
        return "ShortTVPlayBean(subjectId=" + this.subjectId + ", id=" + this.f51090id + ", ep=" + this.f51089ep + ", se=" + this.f51091se + ", totalEp=" + this.totalEp + ", progress=" + this.progress + ", title=" + this.title + ", description=" + this.description + ", coverUrl=" + this.coverUrl + ", thumbnail=" + this.thumbnail + ", videoId=" + this.videoId + ", videoUrl=" + this.videoUrl + ", timeStamp=" + this.timeStamp + ")";
    }
}
