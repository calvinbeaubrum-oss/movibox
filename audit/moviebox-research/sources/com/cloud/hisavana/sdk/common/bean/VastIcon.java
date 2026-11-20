package com.cloud.hisavana.sdk.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
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
public final class VastIcon implements Parcelable {
    public static final Parcelable.Creator<VastIcon> CREATOR = new Creator();
    private Integer duration;
    private Integer height;
    private String iconClick;
    private List<String> iconClickTracking;
    private String iconResource;
    private String offset;
    private String program;
    private Integer width;
    private Integer xPosition;
    private Integer yPosition;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<VastIcon> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VastIcon createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new VastIcon(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VastIcon[] newArray(int i11) {
            return new VastIcon[i11];
        }
    }

    public VastIcon() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public VastIcon(String str, Integer num, Integer num2, Integer num3, Integer num4, String str2, Integer num5, String str3, String str4, List<String> iconClickTracking) {
        Intrinsics.g(iconClickTracking, "iconClickTracking");
        this.program = str;
        this.width = num;
        this.height = num2;
        this.xPosition = num3;
        this.yPosition = num4;
        this.offset = str2;
        this.duration = num5;
        this.iconResource = str3;
        this.iconClick = str4;
        this.iconClickTracking = iconClickTracking;
    }

    public /* synthetic */ VastIcon(String str, Integer num, Integer num2, Integer num3, Integer num4, String str2, Integer num5, String str3, String str4, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 0 : num, (i11 & 4) != 0 ? 0 : num2, (i11 & 8) != 0 ? -1 : num3, (i11 & 16) != 0 ? -1 : num4, (i11 & 32) != 0 ? null : str2, (i11 & 64) != 0 ? 0 : num5, (i11 & 128) != 0 ? null : str3, (i11 & 256) == 0 ? str4 : null, (i11 & 512) != 0 ? new ArrayList() : list);
    }

    public final String component1() {
        return this.program;
    }

    public final List<String> component10() {
        return this.iconClickTracking;
    }

    public final Integer component2() {
        return this.width;
    }

    public final Integer component3() {
        return this.height;
    }

    public final Integer component4() {
        return this.xPosition;
    }

    public final Integer component5() {
        return this.yPosition;
    }

    public final String component6() {
        return this.offset;
    }

    public final Integer component7() {
        return this.duration;
    }

    public final String component8() {
        return this.iconResource;
    }

    public final String component9() {
        return this.iconClick;
    }

    public final VastIcon copy(String str, Integer num, Integer num2, Integer num3, Integer num4, String str2, Integer num5, String str3, String str4, List<String> iconClickTracking) {
        Intrinsics.g(iconClickTracking, "iconClickTracking");
        return new VastIcon(str, num, num2, num3, num4, str2, num5, str3, str4, iconClickTracking);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastIcon)) {
            return false;
        }
        VastIcon vastIcon = (VastIcon) obj;
        return Intrinsics.b(this.program, vastIcon.program) && Intrinsics.b(this.width, vastIcon.width) && Intrinsics.b(this.height, vastIcon.height) && Intrinsics.b(this.xPosition, vastIcon.xPosition) && Intrinsics.b(this.yPosition, vastIcon.yPosition) && Intrinsics.b(this.offset, vastIcon.offset) && Intrinsics.b(this.duration, vastIcon.duration) && Intrinsics.b(this.iconResource, vastIcon.iconResource) && Intrinsics.b(this.iconClick, vastIcon.iconClick) && Intrinsics.b(this.iconClickTracking, vastIcon.iconClickTracking);
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getIconClick() {
        return this.iconClick;
    }

    public final List<String> getIconClickTracking() {
        return this.iconClickTracking;
    }

    public final String getIconResource() {
        return this.iconResource;
    }

    public final String getOffset() {
        return this.offset;
    }

    public final String getProgram() {
        return this.program;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Integer getXPosition() {
        return this.xPosition;
    }

    public final Integer getYPosition() {
        return this.yPosition;
    }

    public int hashCode() {
        String str = this.program;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.width;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.height;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.xPosition;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.yPosition;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str2 = this.offset;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num5 = this.duration;
        int iHashCode7 = (iHashCode6 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str3 = this.iconResource;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.iconClick;
        return ((iHashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.iconClickTracking.hashCode();
    }

    public final void setDuration(Integer num) {
        this.duration = num;
    }

    public final void setHeight(Integer num) {
        this.height = num;
    }

    public final void setIconClick(String str) {
        this.iconClick = str;
    }

    public final void setIconClickTracking(List<String> list) {
        Intrinsics.g(list, "<set-?>");
        this.iconClickTracking = list;
    }

    public final void setIconResource(String str) {
        this.iconResource = str;
    }

    public final void setOffset(String str) {
        this.offset = str;
    }

    public final void setProgram(String str) {
        this.program = str;
    }

    public final void setWidth(Integer num) {
        this.width = num;
    }

    public final void setXPosition(Integer num) {
        this.xPosition = num;
    }

    public final void setYPosition(Integer num) {
        this.yPosition = num;
    }

    public String toString() {
        return "VastIcon(program=" + this.program + ", width=" + this.width + ", height=" + this.height + ", xPosition=" + this.xPosition + ", yPosition=" + this.yPosition + ", offset=" + this.offset + ", duration=" + this.duration + ", iconResource=" + this.iconResource + ", iconClick=" + this.iconClick + ", iconClickTracking=" + this.iconClickTracking + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.program);
        Integer num = this.width;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.height;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        Integer num3 = this.xPosition;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        Integer num4 = this.yPosition;
        if (num4 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num4.intValue());
        }
        out.writeString(this.offset);
        Integer num5 = this.duration;
        if (num5 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num5.intValue());
        }
        out.writeString(this.iconResource);
        out.writeString(this.iconClick);
        out.writeStringList(this.iconClickTracking);
    }
}
