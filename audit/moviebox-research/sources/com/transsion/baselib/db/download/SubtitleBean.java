package com.transsion.baselib.db.download;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

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
public final class SubtitleBean {
    public static final a Companion = new a(null);
    public static final int STATUS_COMPLETED = 2;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_LOADING = 3;
    public static final int STATUS_NONE = 0;
    public static final int TYPE_INNER = 1;
    public static final int TYPE_LOCAL = 3;
    public static final int TYPE_OPEN_SUBTITLES = 4;
    public static final int TYPE_OPEN_SUBTITLES_NEW = 5;
    public static final int TYPE_SEARCH_DOWNLOAD = 2;
    private Long delayDuration;

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    private int f51071ep;
    private int errorCount;
    private String fileCharsetName;
    private boolean isSelect;
    private String lan;
    private String lanName;
    private String pageName;
    private String path;
    private String postId;
    private int resolution;
    private String resourceId;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    private int f51072se;
    private Long size;
    private int status;
    private String subjectId;
    private String subtitleName;
    private int type;
    private String url;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SubtitleBean(String resourceId, String str, String str2, String str3, String str4, String lanName, String str5, Long l11, Long l12, int i11, int i12, String str6, String str7, int i13, int i14, int i15) {
        Intrinsics.g(resourceId, "resourceId");
        Intrinsics.g(lanName, "lanName");
        this.resourceId = resourceId;
        this.postId = str;
        this.url = str2;
        this.path = str3;
        this.lan = str4;
        this.lanName = lanName;
        this.subtitleName = str5;
        this.size = l11;
        this.delayDuration = l12;
        this.status = i11;
        this.type = i12;
        this.fileCharsetName = str6;
        this.subjectId = str7;
        this.f51071ep = i13;
        this.f51072se = i14;
        this.resolution = i15;
        this.pageName = "";
    }

    public /* synthetic */ SubtitleBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l11, Long l12, int i11, int i12, String str8, String str9, int i13, int i14, int i15, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) != 0 ? "" : str4, (i16 & 16) != 0 ? "" : str5, str6, (i16 & 64) != 0 ? "" : str7, (i16 & 128) != 0 ? 0L : l11, (i16 & 256) != 0 ? 0L : l12, (i16 & 512) != 0 ? 0 : i11, (i16 & 1024) != 0 ? 1 : i12, (i16 & 2048) != 0 ? Charsets.f69091b.name() : str8, (i16 & 4096) != 0 ? "" : str9, (i16 & 8192) != 0 ? 0 : i13, (i16 & 16384) != 0 ? 0 : i14, (i16 & 32768) != 0 ? 0 : i15);
    }

    public final String component1() {
        return this.resourceId;
    }

    public final int component10() {
        return this.status;
    }

    public final int component11() {
        return this.type;
    }

    public final String component12() {
        return this.fileCharsetName;
    }

    public final String component13() {
        return this.subjectId;
    }

    public final int component14() {
        return this.f51071ep;
    }

    public final int component15() {
        return this.f51072se;
    }

    public final int component16() {
        return this.resolution;
    }

    public final String component2() {
        return this.postId;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.path;
    }

    public final String component5() {
        return this.lan;
    }

    public final String component6() {
        return this.lanName;
    }

    public final String component7() {
        return this.subtitleName;
    }

    public final Long component8() {
        return this.size;
    }

    public final Long component9() {
        return this.delayDuration;
    }

    public final SubtitleBean copy(String resourceId, String str, String str2, String str3, String str4, String lanName, String str5, Long l11, Long l12, int i11, int i12, String str6, String str7, int i13, int i14, int i15) {
        Intrinsics.g(resourceId, "resourceId");
        Intrinsics.g(lanName, "lanName");
        return new SubtitleBean(resourceId, str, str2, str3, str4, lanName, str5, l11, l12, i11, i12, str6, str7, i13, i14, i15);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.b(SubtitleBean.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.baselib.db.download.SubtitleBean");
        return Intrinsics.b(this.resourceId, ((SubtitleBean) obj).resourceId);
    }

    public final Long getDelayDuration() {
        return this.delayDuration;
    }

    public final String getDiffId() {
        return this.resourceId;
    }

    public final int getEp() {
        return this.f51071ep;
    }

    public final int getErrorCount() {
        return this.errorCount;
    }

    public final String getFileCharsetName() {
        return this.fileCharsetName;
    }

    public final String getLan() {
        return this.lan;
    }

    public final String getLanName() {
        return this.lanName;
    }

    public final String getName() {
        if (this.type == 1) {
            return this.lanName;
        }
        String str = this.subtitleName;
        return str == null ? "" : str;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final int getResolution() {
        return this.resolution;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getSe() {
        return this.f51072se;
    }

    public final Long getSize() {
        return this.size;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getSubtitleName() {
        return this.subtitleName;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.resourceId.hashCode();
    }

    public final boolean isDownloaded() {
        return this.status == 2;
    }

    public final boolean isInner() {
        return this.type == 1;
    }

    public final boolean isOpensub() {
        int i11 = this.type;
        return i11 == 4 || i11 == 5;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setDelayDuration(Long l11) {
        this.delayDuration = l11;
    }

    public final void setEp(int i11) {
        this.f51071ep = i11;
    }

    public final void setErrorCount(int i11) {
        this.errorCount = i11;
    }

    public final void setFileCharsetName(String str) {
        this.fileCharsetName = str;
    }

    public final void setLan(String str) {
        this.lan = str;
    }

    public final void setLanName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.lanName = str;
    }

    public final void setPageName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.pageName = str;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setResolution(int i11) {
        this.resolution = i11;
    }

    public final void setResourceId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.resourceId = str;
    }

    public final void setSe(int i11) {
        this.f51072se = i11;
    }

    public final void setSelect(boolean z11) {
        this.isSelect = z11;
    }

    public final void setSize(Long l11) {
        this.size = l11;
    }

    public final void setStatus(int i11) {
        this.status = i11;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubtitleName(String str) {
        this.subtitleName = str;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "SubtitleBean(resourceId=" + this.resourceId + ", postId=" + this.postId + ", url=" + this.url + ", path=" + this.path + ", lan=" + this.lan + ", lanName=" + this.lanName + ", subtitleName=" + this.subtitleName + ", size=" + this.size + ", delayDuration=" + this.delayDuration + ", status=" + this.status + ", type=" + this.type + ", fileCharsetName=" + this.fileCharsetName + ", subjectId=" + this.subjectId + ", ep=" + this.f51071ep + ", se=" + this.f51072se + ", resolution=" + this.resolution + ")";
    }
}
