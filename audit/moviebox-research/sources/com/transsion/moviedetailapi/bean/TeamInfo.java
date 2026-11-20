package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class TeamInfo implements Parcelable {
    public static final Parcelable.Creator<TeamInfo> CREATOR = new a();
    private String avatar;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f53889id;
    private String name;
    private String score;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<TeamInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TeamInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new TeamInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TeamInfo[] newArray(int i11) {
            return new TeamInfo[i11];
        }
    }

    public TeamInfo() {
        this(null, null, null, null, 15, null);
    }

    public TeamInfo(String str, String str2, String str3, String str4) {
        this.f53889id = str;
        this.name = str2;
        this.avatar = str3;
        this.score = str4;
    }

    public /* synthetic */ TeamInfo(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4);
    }

    public static /* synthetic */ TeamInfo copy$default(TeamInfo teamInfo, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = teamInfo.f53889id;
        }
        if ((i11 & 2) != 0) {
            str2 = teamInfo.name;
        }
        if ((i11 & 4) != 0) {
            str3 = teamInfo.avatar;
        }
        if ((i11 & 8) != 0) {
            str4 = teamInfo.score;
        }
        return teamInfo.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.f53889id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.score;
    }

    public final TeamInfo copy(String str, String str2, String str3, String str4) {
        return new TeamInfo(str, str2, str3, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeamInfo)) {
            return false;
        }
        TeamInfo teamInfo = (TeamInfo) obj;
        return Intrinsics.b(this.f53889id, teamInfo.f53889id) && Intrinsics.b(this.name, teamInfo.name) && Intrinsics.b(this.avatar, teamInfo.avatar) && Intrinsics.b(this.score, teamInfo.score);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getId() {
        return this.f53889id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getScore() {
        return this.score;
    }

    public int hashCode() {
        String str = this.f53889id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.score;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setId(String str) {
        this.f53889id = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setScore(String str) {
        this.score = str;
    }

    public String toString() {
        return "TeamInfo(id=" + this.f53889id + ", name=" + this.name + ", avatar=" + this.avatar + ", score=" + this.score + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f53889id);
        out.writeString(this.name);
        out.writeString(this.avatar);
        out.writeString(this.score);
    }
}
