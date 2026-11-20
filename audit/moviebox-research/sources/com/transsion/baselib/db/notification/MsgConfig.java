package com.transsion.baselib.db.notification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class MsgConfig implements Parcelable {
    public static final Parcelable.Creator<MsgConfig> CREATOR = new a();
    private Boolean brightScreen;
    private Boolean enable;
    private String endTime;
    private Boolean floatingWindow;
    private String pushGap;
    private Boolean ring;
    private Boolean shock;
    private String startTime;
    private Boolean unlock;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MsgConfig> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MsgConfig createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Boolean boolValueOf3;
            Boolean boolValueOf4;
            Boolean boolValueOf5;
            Boolean boolValueOf6;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf3 = null;
            } else {
                boolValueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf4 = null;
            } else {
                boolValueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf5 = null;
            } else {
                boolValueOf5 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf6 = null;
            } else {
                boolValueOf6 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new MsgConfig(boolValueOf, boolValueOf2, string, boolValueOf3, string2, boolValueOf4, boolValueOf5, string3, boolValueOf6);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MsgConfig[] newArray(int i11) {
            return new MsgConfig[i11];
        }
    }

    public MsgConfig(Boolean bool, Boolean bool2, String str, Boolean bool3, String str2, Boolean bool4, Boolean bool5, String str3, Boolean bool6) {
        this.brightScreen = bool;
        this.enable = bool2;
        this.endTime = str;
        this.floatingWindow = bool3;
        this.pushGap = str2;
        this.ring = bool4;
        this.shock = bool5;
        this.startTime = str3;
        this.unlock = bool6;
    }

    public final Boolean component1() {
        return this.brightScreen;
    }

    public final Boolean component2() {
        return this.enable;
    }

    public final String component3() {
        return this.endTime;
    }

    public final Boolean component4() {
        return this.floatingWindow;
    }

    public final String component5() {
        return this.pushGap;
    }

    public final Boolean component6() {
        return this.ring;
    }

    public final Boolean component7() {
        return this.shock;
    }

    public final String component8() {
        return this.startTime;
    }

    public final Boolean component9() {
        return this.unlock;
    }

    public final MsgConfig copy(Boolean bool, Boolean bool2, String str, Boolean bool3, String str2, Boolean bool4, Boolean bool5, String str3, Boolean bool6) {
        return new MsgConfig(bool, bool2, str, bool3, str2, bool4, bool5, str3, bool6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MsgConfig)) {
            return false;
        }
        MsgConfig msgConfig = (MsgConfig) obj;
        return Intrinsics.b(this.brightScreen, msgConfig.brightScreen) && Intrinsics.b(this.enable, msgConfig.enable) && Intrinsics.b(this.endTime, msgConfig.endTime) && Intrinsics.b(this.floatingWindow, msgConfig.floatingWindow) && Intrinsics.b(this.pushGap, msgConfig.pushGap) && Intrinsics.b(this.ring, msgConfig.ring) && Intrinsics.b(this.shock, msgConfig.shock) && Intrinsics.b(this.startTime, msgConfig.startTime) && Intrinsics.b(this.unlock, msgConfig.unlock);
    }

    public final Boolean getBrightScreen() {
        return this.brightScreen;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final Boolean getFloatingWindow() {
        return this.floatingWindow;
    }

    public final String getPushGap() {
        return this.pushGap;
    }

    public final Boolean getRing() {
        return this.ring;
    }

    public final Boolean getShock() {
        return this.shock;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final Boolean getUnlock() {
        return this.unlock;
    }

    public int hashCode() {
        Boolean bool = this.brightScreen;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.enable;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.endTime;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool3 = this.floatingWindow;
        int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str2 = this.pushGap;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool4 = this.ring;
        int iHashCode6 = (iHashCode5 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.shock;
        int iHashCode7 = (iHashCode6 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        String str3 = this.startTime;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool6 = this.unlock;
        return iHashCode8 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public final void setBrightScreen(Boolean bool) {
        this.brightScreen = bool;
    }

    public final void setEnable(Boolean bool) {
        this.enable = bool;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final void setFloatingWindow(Boolean bool) {
        this.floatingWindow = bool;
    }

    public final void setPushGap(String str) {
        this.pushGap = str;
    }

    public final void setRing(Boolean bool) {
        this.ring = bool;
    }

    public final void setShock(Boolean bool) {
        this.shock = bool;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
    }

    public final void setUnlock(Boolean bool) {
        this.unlock = bool;
    }

    public String toString() {
        return "MsgConfig(brightScreen=" + this.brightScreen + ", enable=" + this.enable + ", endTime=" + this.endTime + ", floatingWindow=" + this.floatingWindow + ", pushGap=" + this.pushGap + ", ring=" + this.ring + ", shock=" + this.shock + ", startTime=" + this.startTime + ", unlock=" + this.unlock + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        Boolean bool = this.brightScreen;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.enable;
        if (bool2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        out.writeString(this.endTime);
        Boolean bool3 = this.floatingWindow;
        if (bool3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        out.writeString(this.pushGap);
        Boolean bool4 = this.ring;
        if (bool4 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        Boolean bool5 = this.shock;
        if (bool5 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool5.booleanValue() ? 1 : 0);
        }
        out.writeString(this.startTime);
        Boolean bool6 = this.unlock;
        if (bool6 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool6.booleanValue() ? 1 : 0);
        }
    }
}
