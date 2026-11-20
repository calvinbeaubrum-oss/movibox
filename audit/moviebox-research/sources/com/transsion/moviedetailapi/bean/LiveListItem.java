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
public final class LiveListItem implements Parcelable {
    public static final Parcelable.Creator<LiveListItem> CREATOR = new a();
    private String content;
    private String deepLink;
    private Image image;
    private String matchId;
    private String ops;
    private Long startTime;
    private String status;
    private TeamInfo team1;
    private TeamInfo team2;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<LiveListItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LiveListItem createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new LiveListItem(parcel.readString(), (Image) parcel.readSerializable(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TeamInfo.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TeamInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final LiveListItem[] newArray(int i11) {
            return new LiveListItem[i11];
        }
    }

    public LiveListItem() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public LiveListItem(String str, Image image, Long l11, String str2, String str3, String str4, TeamInfo teamInfo, TeamInfo teamInfo2, String str5) {
        this.matchId = str;
        this.image = image;
        this.startTime = l11;
        this.content = str2;
        this.status = str3;
        this.deepLink = str4;
        this.team1 = teamInfo;
        this.team2 = teamInfo2;
        this.ops = str5;
    }

    public /* synthetic */ LiveListItem(String str, Image image, Long l11, String str2, String str3, String str4, TeamInfo teamInfo, TeamInfo teamInfo2, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : image, (i11 & 4) != 0 ? 0L : l11, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? null : str4, (i11 & 64) != 0 ? null : teamInfo, (i11 & 128) != 0 ? null : teamInfo2, (i11 & 256) == 0 ? str5 : null);
    }

    public final String component1() {
        return this.matchId;
    }

    public final Image component2() {
        return this.image;
    }

    public final Long component3() {
        return this.startTime;
    }

    public final String component4() {
        return this.content;
    }

    public final String component5() {
        return this.status;
    }

    public final String component6() {
        return this.deepLink;
    }

    public final TeamInfo component7() {
        return this.team1;
    }

    public final TeamInfo component8() {
        return this.team2;
    }

    public final String component9() {
        return this.ops;
    }

    public final LiveListItem copy(String str, Image image, Long l11, String str2, String str3, String str4, TeamInfo teamInfo, TeamInfo teamInfo2, String str5) {
        return new LiveListItem(str, image, l11, str2, str3, str4, teamInfo, teamInfo2, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveListItem)) {
            return false;
        }
        LiveListItem liveListItem = (LiveListItem) obj;
        return Intrinsics.b(this.matchId, liveListItem.matchId) && Intrinsics.b(this.image, liveListItem.image) && Intrinsics.b(this.startTime, liveListItem.startTime) && Intrinsics.b(this.content, liveListItem.content) && Intrinsics.b(this.status, liveListItem.status) && Intrinsics.b(this.deepLink, liveListItem.deepLink) && Intrinsics.b(this.team1, liveListItem.team1) && Intrinsics.b(this.team2, liveListItem.team2) && Intrinsics.b(this.ops, liveListItem.ops);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final Image getImage() {
        return this.image;
    }

    public final String getMatchId() {
        return this.matchId;
    }

    public final String getOps() {
        return this.ops;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final String getStatus() {
        return this.status;
    }

    public final TeamInfo getTeam1() {
        return this.team1;
    }

    public final TeamInfo getTeam2() {
        return this.team2;
    }

    public int hashCode() {
        String str = this.matchId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Image image = this.image;
        int iHashCode2 = (iHashCode + (image == null ? 0 : image.hashCode())) * 31;
        Long l11 = this.startTime;
        int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str2 = this.content;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.status;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.deepLink;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        TeamInfo teamInfo = this.team1;
        int iHashCode7 = (iHashCode6 + (teamInfo == null ? 0 : teamInfo.hashCode())) * 31;
        TeamInfo teamInfo2 = this.team2;
        int iHashCode8 = (iHashCode7 + (teamInfo2 == null ? 0 : teamInfo2.hashCode())) * 31;
        String str5 = this.ops;
        return iHashCode8 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final void setImage(Image image) {
        this.image = image;
    }

    public final void setMatchId(String str) {
        this.matchId = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setStartTime(Long l11) {
        this.startTime = l11;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void setTeam1(TeamInfo teamInfo) {
        this.team1 = teamInfo;
    }

    public final void setTeam2(TeamInfo teamInfo) {
        this.team2 = teamInfo;
    }

    public String toString() {
        return "LiveListItem(matchId=" + this.matchId + ", image=" + this.image + ", startTime=" + this.startTime + ", content=" + this.content + ", status=" + this.status + ", deepLink=" + this.deepLink + ", team1=" + this.team1 + ", team2=" + this.team2 + ", ops=" + this.ops + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.matchId);
        out.writeSerializable(this.image);
        Long l11 = this.startTime;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
        out.writeString(this.content);
        out.writeString(this.status);
        out.writeString(this.deepLink);
        TeamInfo teamInfo = this.team1;
        if (teamInfo == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            teamInfo.writeToParcel(out, i11);
        }
        TeamInfo teamInfo2 = this.team2;
        if (teamInfo2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            teamInfo2.writeToParcel(out, i11);
        }
        out.writeString(this.ops);
    }
}
