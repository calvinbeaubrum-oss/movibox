package com.cloud.hisavana.sdk.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class VastData implements Parcelable {
    public static final Parcelable.Creator<VastData> CREATOR = new Creator();
    private String buttonTxt;
    private String description;
    private Integer duration;
    private VastIcon icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f29410id;
    private List<String> impression;
    private Boolean isCached;
    private Boolean isVideoCached;
    private Boolean isVideoType;
    private VastMedia mainAd;
    private ProgressData progressData;
    private Integer skipOffSet;
    private String title;
    private VastClick vastClick;
    private VastTracking vastTrack;
    private String version;
    private VideoMask videoMask;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<VastData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VastData createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Boolean boolValueOf3;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            VastIcon vastIconCreateFromParcel = parcel.readInt() == 0 ? null : VastIcon.CREATOR.createFromParcel(parcel);
            VastTracking vastTrackingCreateFromParcel = parcel.readInt() == 0 ? null : VastTracking.CREATOR.createFromParcel(parcel);
            VastClick vastClickCreateFromParcel = parcel.readInt() == 0 ? null : VastClick.CREATOR.createFromParcel(parcel);
            VastMedia vastMediaCreateFromParcel = parcel.readInt() == 0 ? null : VastMedia.CREATOR.createFromParcel(parcel);
            VideoMask videoMaskCreateFromParcel = parcel.readInt() == 0 ? null : VideoMask.CREATOR.createFromParcel(parcel);
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            ProgressData progressDataCreateFromParcel = parcel.readInt() == 0 ? null : ProgressData.CREATOR.createFromParcel(parcel);
            Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string5 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf3 = null;
            } else {
                boolValueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new VastData(string, string2, vastIconCreateFromParcel, vastTrackingCreateFromParcel, vastClickCreateFromParcel, vastMediaCreateFromParcel, videoMaskCreateFromParcel, arrayListCreateStringArrayList, string3, string4, numValueOf, boolValueOf, progressDataCreateFromParcel, numValueOf2, string5, boolValueOf2, boolValueOf3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VastData[] newArray(int i11) {
            return new VastData[i11];
        }
    }

    public VastData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public VastData(String str, String str2, VastIcon vastIcon, VastTracking vastTracking, VastClick vastClick, VastMedia vastMedia, VideoMask videoMask, List<String> list, String str3, String str4, Integer num, Boolean bool, ProgressData progressData, Integer num2, String str5, Boolean bool2, Boolean bool3) {
        this.f29410id = str;
        this.title = str2;
        this.icon = vastIcon;
        this.vastTrack = vastTracking;
        this.vastClick = vastClick;
        this.mainAd = vastMedia;
        this.videoMask = videoMask;
        this.impression = list;
        this.version = str3;
        this.description = str4;
        this.duration = num;
        this.isCached = bool;
        this.progressData = progressData;
        this.skipOffSet = num2;
        this.buttonTxt = str5;
        this.isVideoType = bool2;
        this.isVideoCached = bool3;
    }

    public /* synthetic */ VastData(String str, String str2, VastIcon vastIcon, VastTracking vastTracking, VastClick vastClick, VastMedia vastMedia, VideoMask videoMask, List list, String str3, String str4, Integer num, Boolean bool, ProgressData progressData, Integer num2, String str5, Boolean bool2, Boolean bool3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : vastIcon, (i11 & 8) != 0 ? null : vastTracking, (i11 & 16) != 0 ? null : vastClick, (i11 & 32) != 0 ? null : vastMedia, (i11 & 64) != 0 ? null : videoMask, (i11 & 128) != 0 ? new ArrayList() : list, (i11 & 256) != 0 ? null : str3, (i11 & 512) != 0 ? null : str4, (i11 & 1024) != 0 ? null : num, (i11 & 2048) != 0 ? Boolean.FALSE : bool, (i11 & 4096) != 0 ? null : progressData, (i11 & 8192) != 0 ? 0 : num2, (i11 & 16384) != 0 ? null : str5, (i11 & 32768) != 0 ? Boolean.TRUE : bool2, (i11 & 65536) != 0 ? Boolean.FALSE : bool3);
    }

    public final boolean checkVast() {
        VastMedia vastMedia = this.mainAd;
        return !TextUtils.isEmpty(vastMedia != null ? vastMedia.getMediaResource() : null);
    }

    public final String component1() {
        return this.f29410id;
    }

    public final String component10() {
        return this.description;
    }

    public final Integer component11() {
        return this.duration;
    }

    public final Boolean component12() {
        return this.isCached;
    }

    public final ProgressData component13() {
        return this.progressData;
    }

    public final Integer component14() {
        return this.skipOffSet;
    }

    public final String component15() {
        return this.buttonTxt;
    }

    public final Boolean component16() {
        return this.isVideoType;
    }

    public final Boolean component17() {
        return this.isVideoCached;
    }

    public final String component2() {
        return this.title;
    }

    public final VastIcon component3() {
        return this.icon;
    }

    public final VastTracking component4() {
        return this.vastTrack;
    }

    public final VastClick component5() {
        return this.vastClick;
    }

    public final VastMedia component6() {
        return this.mainAd;
    }

    public final VideoMask component7() {
        return this.videoMask;
    }

    public final List<String> component8() {
        return this.impression;
    }

    public final String component9() {
        return this.version;
    }

    public final VastData copy(String str, String str2, VastIcon vastIcon, VastTracking vastTracking, VastClick vastClick, VastMedia vastMedia, VideoMask videoMask, List<String> list, String str3, String str4, Integer num, Boolean bool, ProgressData progressData, Integer num2, String str5, Boolean bool2, Boolean bool3) {
        return new VastData(str, str2, vastIcon, vastTracking, vastClick, vastMedia, videoMask, list, str3, str4, num, bool, progressData, num2, str5, bool2, bool3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastData)) {
            return false;
        }
        VastData vastData = (VastData) obj;
        return Intrinsics.b(this.f29410id, vastData.f29410id) && Intrinsics.b(this.title, vastData.title) && Intrinsics.b(this.icon, vastData.icon) && Intrinsics.b(this.vastTrack, vastData.vastTrack) && Intrinsics.b(this.vastClick, vastData.vastClick) && Intrinsics.b(this.mainAd, vastData.mainAd) && Intrinsics.b(this.videoMask, vastData.videoMask) && Intrinsics.b(this.impression, vastData.impression) && Intrinsics.b(this.version, vastData.version) && Intrinsics.b(this.description, vastData.description) && Intrinsics.b(this.duration, vastData.duration) && Intrinsics.b(this.isCached, vastData.isCached) && Intrinsics.b(this.progressData, vastData.progressData) && Intrinsics.b(this.skipOffSet, vastData.skipOffSet) && Intrinsics.b(this.buttonTxt, vastData.buttonTxt) && Intrinsics.b(this.isVideoType, vastData.isVideoType) && Intrinsics.b(this.isVideoCached, vastData.isVideoCached);
    }

    public final String getButtonTxt() {
        return this.buttonTxt;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final VastIcon getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f29410id;
    }

    public final List<String> getImpression() {
        return this.impression;
    }

    public final VastMedia getMainAd() {
        return this.mainAd;
    }

    public final ProgressData getProgressData() {
        return this.progressData;
    }

    public final Integer getSkipOffSet() {
        return this.skipOffSet;
    }

    public final String getTitle() {
        return this.title;
    }

    public final VastClick getVastClick() {
        return this.vastClick;
    }

    public final VastTracking getVastTrack() {
        return this.vastTrack;
    }

    public final String getVersion() {
        return this.version;
    }

    public final VideoMask getVideoMask() {
        return this.videoMask;
    }

    public int hashCode() {
        String str = this.f29410id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        VastIcon vastIcon = this.icon;
        int iHashCode3 = (iHashCode2 + (vastIcon == null ? 0 : vastIcon.hashCode())) * 31;
        VastTracking vastTracking = this.vastTrack;
        int iHashCode4 = (iHashCode3 + (vastTracking == null ? 0 : vastTracking.hashCode())) * 31;
        VastClick vastClick = this.vastClick;
        int iHashCode5 = (iHashCode4 + (vastClick == null ? 0 : vastClick.hashCode())) * 31;
        VastMedia vastMedia = this.mainAd;
        int iHashCode6 = (iHashCode5 + (vastMedia == null ? 0 : vastMedia.hashCode())) * 31;
        VideoMask videoMask = this.videoMask;
        int iHashCode7 = (iHashCode6 + (videoMask == null ? 0 : videoMask.hashCode())) * 31;
        List<String> list = this.impression;
        int iHashCode8 = (iHashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.version;
        int iHashCode9 = (iHashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int iHashCode10 = (iHashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.duration;
        int iHashCode11 = (iHashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isCached;
        int iHashCode12 = (iHashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        ProgressData progressData = this.progressData;
        int iHashCode13 = (iHashCode12 + (progressData == null ? 0 : progressData.hashCode())) * 31;
        Integer num2 = this.skipOffSet;
        int iHashCode14 = (iHashCode13 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.buttonTxt;
        int iHashCode15 = (iHashCode14 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool2 = this.isVideoType;
        int iHashCode16 = (iHashCode15 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isVideoCached;
        return iHashCode16 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public final Boolean isCached() {
        return this.isCached;
    }

    public final Boolean isVideoCached() {
        return this.isVideoCached;
    }

    public final Boolean isVideoType() {
        return this.isVideoType;
    }

    public final void setButtonTxt(String str) {
        this.buttonTxt = str;
    }

    public final void setCached(Boolean bool) {
        this.isCached = bool;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setDuration(Integer num) {
        this.duration = num;
    }

    public final void setIcon(VastIcon vastIcon) {
        this.icon = vastIcon;
    }

    public final void setId(String str) {
        this.f29410id = str;
    }

    public final void setImpression(List<String> list) {
        this.impression = list;
    }

    public final void setMainAd(VastMedia vastMedia) {
        this.mainAd = vastMedia;
    }

    public final void setProgressData(ProgressData progressData) {
        this.progressData = progressData;
    }

    public final void setSkipOffSet(Integer num) {
        this.skipOffSet = num;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setVastClick(VastClick vastClick) {
        this.vastClick = vastClick;
    }

    public final void setVastTrack(VastTracking vastTracking) {
        this.vastTrack = vastTracking;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final void setVideoCached(Boolean bool) {
        this.isVideoCached = bool;
    }

    public final void setVideoMask(VideoMask videoMask) {
        this.videoMask = videoMask;
    }

    public final void setVideoType(Boolean bool) {
        this.isVideoType = bool;
    }

    public String toString() {
        return "VastData(id=" + this.f29410id + ", title=" + this.title + ", icon=" + this.icon + ", vastTrack=" + this.vastTrack + ", vastClick=" + this.vastClick + ", mainAd=" + this.mainAd + ", videoMask=" + this.videoMask + ", impression=" + this.impression + ", version=" + this.version + ", description=" + this.description + ", duration=" + this.duration + ", isCached=" + this.isCached + ", progressData=" + this.progressData + ", skipOffSet=" + this.skipOffSet + ", buttonTxt=" + this.buttonTxt + ", isVideoType=" + this.isVideoType + ", isVideoCached=" + this.isVideoCached + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f29410id);
        out.writeString(this.title);
        VastIcon vastIcon = this.icon;
        if (vastIcon == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            vastIcon.writeToParcel(out, i11);
        }
        VastTracking vastTracking = this.vastTrack;
        if (vastTracking == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            vastTracking.writeToParcel(out, i11);
        }
        VastClick vastClick = this.vastClick;
        if (vastClick == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            vastClick.writeToParcel(out, i11);
        }
        VastMedia vastMedia = this.mainAd;
        if (vastMedia == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            vastMedia.writeToParcel(out, i11);
        }
        VideoMask videoMask = this.videoMask;
        if (videoMask == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            videoMask.writeToParcel(out, i11);
        }
        out.writeStringList(this.impression);
        out.writeString(this.version);
        out.writeString(this.description);
        Integer num = this.duration;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Boolean bool = this.isCached;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        ProgressData progressData = this.progressData;
        if (progressData == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            progressData.writeToParcel(out, i11);
        }
        Integer num2 = this.skipOffSet;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        out.writeString(this.buttonTxt);
        Boolean bool2 = this.isVideoType;
        if (bool2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.isVideoCached;
        if (bool3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool3.booleanValue() ? 1 : 0);
        }
    }
}
