package com.transsion.ad.monopoly.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.transsion.ad.ps.model.RecommendInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.UnixStat;

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
public final class AdMaterialList implements Parcelable {
    public static final String NON_AD_TYPE_TEXT = "TextAdMaterial";
    public static final String NON_AD_TYPE_VIDEO = "VideoAdMaterial";
    private String buttonText;
    private final String deeplink;
    private String desc;
    private boolean downloadMaterialSuccess;
    private final String h5Link;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f50535id;
    private MbAdImage image;
    private String psLink;
    private RecommendInfo psRecommendInfo;
    private String title;
    private String type;
    private final MbAdVideo video;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<AdMaterialList> CREATOR = new b();

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
    public static final class b implements Parcelable.Creator<AdMaterialList> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AdMaterialList createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new AdMaterialList(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : MbAdImage.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : MbAdVideo.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readInt() != 0 ? RecommendInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AdMaterialList[] newArray(int i11) {
            return new AdMaterialList[i11];
        }
    }

    public AdMaterialList() {
        this(null, null, null, null, null, null, null, null, null, false, null, null, UnixStat.PERM_MASK, null);
    }

    public AdMaterialList(String str, String str2, String str3, String str4, String str5, String str6, String str7, MbAdImage mbAdImage, MbAdVideo mbAdVideo, boolean z11, RecommendInfo recommendInfo, String str8) {
        this.f50535id = str;
        this.type = str2;
        this.title = str3;
        this.desc = str4;
        this.buttonText = str5;
        this.h5Link = str6;
        this.deeplink = str7;
        this.image = mbAdImage;
        this.video = mbAdVideo;
        this.downloadMaterialSuccess = z11;
        this.psRecommendInfo = recommendInfo;
        this.psLink = str8;
    }

    public /* synthetic */ AdMaterialList(String str, String str2, String str3, String str4, String str5, String str6, String str7, MbAdImage mbAdImage, MbAdVideo mbAdVideo, boolean z11, RecommendInfo recommendInfo, String str8, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7, (i11 & 128) != 0 ? null : mbAdImage, (i11 & 256) != 0 ? null : mbAdVideo, (i11 & 512) != 0 ? false : z11, (i11 & 1024) != 0 ? null : recommendInfo, (i11 & 2048) == 0 ? str8 : null);
    }

    public final String component1() {
        return this.f50535id;
    }

    public final boolean component10() {
        return this.downloadMaterialSuccess;
    }

    public final RecommendInfo component11() {
        return this.psRecommendInfo;
    }

    public final String component12() {
        return this.psLink;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.desc;
    }

    public final String component5() {
        return this.buttonText;
    }

    public final String component6() {
        return this.h5Link;
    }

    public final String component7() {
        return this.deeplink;
    }

    public final MbAdImage component8() {
        return this.image;
    }

    public final MbAdVideo component9() {
        return this.video;
    }

    public final AdMaterialList copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, MbAdImage mbAdImage, MbAdVideo mbAdVideo, boolean z11, RecommendInfo recommendInfo, String str8) {
        return new AdMaterialList(str, str2, str3, str4, str5, str6, str7, mbAdImage, mbAdVideo, z11, recommendInfo, str8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdMaterialList)) {
            return false;
        }
        AdMaterialList adMaterialList = (AdMaterialList) obj;
        return Intrinsics.b(this.f50535id, adMaterialList.f50535id) && Intrinsics.b(this.type, adMaterialList.type) && Intrinsics.b(this.title, adMaterialList.title) && Intrinsics.b(this.desc, adMaterialList.desc) && Intrinsics.b(this.buttonText, adMaterialList.buttonText) && Intrinsics.b(this.h5Link, adMaterialList.h5Link) && Intrinsics.b(this.deeplink, adMaterialList.deeplink) && Intrinsics.b(this.image, adMaterialList.image) && Intrinsics.b(this.video, adMaterialList.video) && this.downloadMaterialSuccess == adMaterialList.downloadMaterialSuccess && Intrinsics.b(this.psRecommendInfo, adMaterialList.psRecommendInfo) && Intrinsics.b(this.psLink, adMaterialList.psLink);
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getDownloadMaterialSuccess() {
        return this.downloadMaterialSuccess;
    }

    public final String getH5Link() {
        return this.h5Link;
    }

    public final String getId() {
        return this.f50535id;
    }

    public final MbAdImage getImage() {
        return this.image;
    }

    public final String getPsLink() {
        return this.psLink;
    }

    public final RecommendInfo getPsRecommendInfo() {
        return this.psRecommendInfo;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final MbAdVideo getVideo() {
        return this.video;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v40 */
    public int hashCode() {
        String str = this.f50535id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.desc;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.buttonText;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.h5Link;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.deeplink;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        MbAdImage mbAdImage = this.image;
        int iHashCode8 = (iHashCode7 + (mbAdImage == null ? 0 : mbAdImage.hashCode())) * 31;
        MbAdVideo mbAdVideo = this.video;
        int iHashCode9 = (iHashCode8 + (mbAdVideo == null ? 0 : mbAdVideo.hashCode())) * 31;
        boolean z11 = this.downloadMaterialSuccess;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode9 + r11) * 31;
        RecommendInfo recommendInfo = this.psRecommendInfo;
        int iHashCode10 = (i11 + (recommendInfo == null ? 0 : recommendInfo.hashCode())) * 31;
        String str8 = this.psLink;
        return iHashCode10 + (str8 != null ? str8.hashCode() : 0);
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setDownloadMaterialSuccess(boolean z11) {
        this.downloadMaterialSuccess = z11;
    }

    public final void setImage(MbAdImage mbAdImage) {
        this.image = mbAdImage;
    }

    public final void setPsLink(String str) {
        this.psLink = str;
    }

    public final void setPsRecommendInfo(RecommendInfo recommendInfo) {
        this.psRecommendInfo = recommendInfo;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "AdMaterialList(id=" + this.f50535id + ", type=" + this.type + ", title=" + this.title + ", desc=" + this.desc + ", buttonText=" + this.buttonText + ", h5Link=" + this.h5Link + ", deeplink=" + this.deeplink + ", image=" + this.image + ", video=" + this.video + ", downloadMaterialSuccess=" + this.downloadMaterialSuccess + ", psRecommendInfo=" + this.psRecommendInfo + ", psLink=" + this.psLink + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f50535id);
        out.writeString(this.type);
        out.writeString(this.title);
        out.writeString(this.desc);
        out.writeString(this.buttonText);
        out.writeString(this.h5Link);
        out.writeString(this.deeplink);
        MbAdImage mbAdImage = this.image;
        if (mbAdImage == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            mbAdImage.writeToParcel(out, i11);
        }
        MbAdVideo mbAdVideo = this.video;
        if (mbAdVideo == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            mbAdVideo.writeToParcel(out, i11);
        }
        out.writeInt(this.downloadMaterialSuccess ? 1 : 0);
        RecommendInfo recommendInfo = this.psRecommendInfo;
        if (recommendInfo == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            recommendInfo.writeToParcel(out, i11);
        }
        out.writeString(this.psLink);
    }
}
