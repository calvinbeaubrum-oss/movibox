package com.transsion.moviedetailapi;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.SubtitleItem;
import java.io.Serializable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class DownloadItem implements Serializable {

    @SerializedName("duration")
    private Long duration;

    /* JADX INFO: renamed from: ep, reason: collision with root package name */
    @SerializedName("ep")
    private int f53877ep;

    @SerializedName("episode")
    private Integer epse;

    @SerializedName("extCaptions")
    private List<SubtitleItem> extSubtitle;

    @SerializedName("linkType")
    private int linkType;

    @SerializedName("memberIcon")
    private String memberIcon;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private String name;

    @SerializedName("postId")
    private String postId;

    @SerializedName("requireMemberType")
    private Integer requireMemberType;

    @SerializedName("resolution")
    private Integer resolution;

    @SerializedName("resourceId")
    private String resourceId;

    /* JADX INFO: renamed from: se, reason: collision with root package name */
    @SerializedName("se")
    private int f53878se;

    @SerializedName("size")
    private Long size;

    @SerializedName("sourceUrl")
    private String sourceUrl;
    private transient Integer status;

    @SerializedName("uploadBy")
    private String uploadBy;

    @SerializedName("resourceLink")
    private String url;

    public DownloadItem(String str, String str2, String str3, int i11, Long l11, String str4, String str5, Integer num, List<SubtitleItem> list, int i12, int i13, Integer num2, String str6, Integer num3, Integer num4, String str7) {
        this.resourceId = str;
        this.name = str2;
        this.url = str3;
        this.linkType = i11;
        this.size = l11;
        this.uploadBy = str4;
        this.postId = str5;
        this.epse = num;
        this.extSubtitle = list;
        this.f53878se = i12;
        this.f53877ep = i13;
        this.status = num2;
        this.sourceUrl = str6;
        this.resolution = num3;
        this.requireMemberType = num4;
        this.memberIcon = str7;
    }

    public /* synthetic */ DownloadItem(String str, String str2, String str3, int i11, Long l11, String str4, String str5, Integer num, List list, int i12, int i13, Integer num2, String str6, Integer num3, Integer num4, String str7, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i11, l11, str4, str5, (i14 & 128) != 0 ? 0 : num, list, i12, i13, num2, str6, num3, num4, str7);
    }

    @Deprecated
    public static /* synthetic */ void getEpse$annotations() {
    }

    public final String component1() {
        return this.resourceId;
    }

    public final int component10() {
        return this.f53878se;
    }

    public final int component11() {
        return this.f53877ep;
    }

    public final Integer component12() {
        return this.status;
    }

    public final String component13() {
        return this.sourceUrl;
    }

    public final Integer component14() {
        return this.resolution;
    }

    public final Integer component15() {
        return this.requireMemberType;
    }

    public final String component16() {
        return this.memberIcon;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.url;
    }

    public final int component4() {
        return this.linkType;
    }

    public final Long component5() {
        return this.size;
    }

    public final String component6() {
        return this.uploadBy;
    }

    public final String component7() {
        return this.postId;
    }

    public final Integer component8() {
        return this.epse;
    }

    public final List<SubtitleItem> component9() {
        return this.extSubtitle;
    }

    public final DownloadItem copy(String str, String str2, String str3, int i11, Long l11, String str4, String str5, Integer num, List<SubtitleItem> list, int i12, int i13, Integer num2, String str6, Integer num3, Integer num4, String str7) {
        return new DownloadItem(str, str2, str3, i11, l11, str4, str5, num, list, i12, i13, num2, str6, num3, num4, str7);
    }

    public boolean equals(Object obj) {
        return (obj instanceof DownloadItem) && !TextUtils.isEmpty(this.resourceId) && TextUtils.equals(this.resourceId, ((DownloadItem) obj).resourceId);
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final int getEp() {
        return this.f53877ep;
    }

    public final Integer getEpse() {
        return this.epse;
    }

    public final List<SubtitleItem> getExtSubtitle() {
        return this.extSubtitle;
    }

    public final int getLinkType() {
        return this.linkType;
    }

    public final String getMemberIcon() {
        return this.memberIcon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final Integer getRequireMemberType() {
        return this.requireMemberType;
    }

    public final Integer getResolution() {
        return this.resolution;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getSe() {
        return this.f53878se;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getUploadBy() {
        return this.uploadBy;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.resourceId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final void setDuration(Long l11) {
        this.duration = l11;
    }

    public final void setEp(int i11) {
        this.f53877ep = i11;
    }

    public final void setEpse(Integer num) {
        this.epse = num;
    }

    public final void setExtSubtitle(List<SubtitleItem> list) {
        this.extSubtitle = list;
    }

    public final void setLinkType(int i11) {
        this.linkType = i11;
    }

    public final void setMemberIcon(String str) {
        this.memberIcon = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setRequireMemberType(Integer num) {
        this.requireMemberType = num;
    }

    public final void setResolution(Integer num) {
        this.resolution = num;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final void setSe(int i11) {
        this.f53878se = i11;
    }

    public final void setSize(Long l11) {
        this.size = l11;
    }

    public final void setSourceUrl(String str) {
        this.sourceUrl = str;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final void setUploadBy(String str) {
        this.uploadBy = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final DownloadBean toDownloadBean() {
        String str = this.url;
        String str2 = str == null ? "" : str;
        String str3 = this.resourceId;
        String str4 = str3 == null ? "" : str3;
        String str5 = this.name;
        DownloadBean downloadBean = new DownloadBean(str2, str4, str5 == null ? "" : str5, "", this.size, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
        String str6 = this.uploadBy;
        if (str6 == null) {
            str6 = "";
        }
        downloadBean.setUploadBy(str6);
        String str7 = this.sourceUrl;
        if (str7 == null) {
            str7 = "";
        }
        downloadBean.setSourceUrl(str7);
        downloadBean.setPostId(this.postId);
        Integer num = this.epse;
        downloadBean.setEpse(num != null ? num.intValue() : 0);
        downloadBean.setEp(this.f53877ep);
        downloadBean.setSe(this.f53878se);
        downloadBean.setDuration(this.duration);
        Integer num2 = this.resolution;
        downloadBean.setResolution(num2 != null ? num2.intValue() : 0);
        return downloadBean;
    }

    public String toString() {
        return "DownloadItem(resourceId=" + this.resourceId + ", name=" + this.name + ", url=" + this.url + ", linkType=" + this.linkType + ", size=" + this.size + ", uploadBy=" + this.uploadBy + ", postId=" + this.postId + ", epse=" + this.epse + ", extSubtitle=" + this.extSubtitle + ", se=" + this.f53878se + ", ep=" + this.f53877ep + ", status=" + this.status + ", sourceUrl=" + this.sourceUrl + ", resolution=" + this.resolution + ", requireMemberType=" + this.requireMemberType + ", memberIcon=" + this.memberIcon + ")";
    }
}
