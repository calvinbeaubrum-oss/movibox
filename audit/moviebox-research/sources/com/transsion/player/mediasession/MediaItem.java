package com.transsion.player.mediasession;

import android.app.PendingIntent;
import android.content.Intent;
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
public final class MediaItem implements Parcelable {
    public static final String MUSIC_FLOAT_STATE_COMPLETION = "completion";
    public static final String MUSIC_FLOAT_STATE_ERROR = "error";
    public static final String MUSIC_FLOAT_STATE_IDEA = "idea";
    public static final String MUSIC_FLOAT_STATE_PAUSE = "pause";
    public static final String MUSIC_FLOAT_STATE_PLAY = "play";
    private Intent clickIntent;
    private String coverUrl;
    private Long duration;
    private Boolean inBackground;
    private Boolean isMusic;
    private String mediaId;
    private String ops;
    private String pageName;
    private PendingIntent pendingIntent;
    private Long position;
    private String state;
    private String subTitle;
    private String subjectId;
    private String title;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<MediaItem> CREATOR = new b();

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
    public static final class b implements Parcelable.Creator<MediaItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MediaItem createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long lValueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String string4 = parcel.readString();
            PendingIntent pendingIntent = (PendingIntent) parcel.readParcelable(MediaItem.class.getClassLoader());
            Intent intent = (Intent) parcel.readParcelable(MediaItem.class.getClassLoader());
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string7 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new MediaItem(string, string2, string3, lValueOf, lValueOf2, string4, pendingIntent, intent, string5, string6, boolValueOf, string7, boolValueOf2, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MediaItem[] newArray(int i11) {
            return new MediaItem[i11];
        }
    }

    public MediaItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public MediaItem(String str, String str2, String str3, Long l11, Long l12, String str4, PendingIntent pendingIntent, Intent intent, String str5, String str6, Boolean bool, String str7, Boolean bool2, String str8) {
        this.title = str;
        this.subTitle = str2;
        this.coverUrl = str3;
        this.duration = l11;
        this.position = l12;
        this.state = str4;
        this.pendingIntent = pendingIntent;
        this.clickIntent = intent;
        this.subjectId = str5;
        this.mediaId = str6;
        this.isMusic = bool;
        this.pageName = str7;
        this.inBackground = bool2;
        this.ops = str8;
    }

    public /* synthetic */ MediaItem(String str, String str2, String str3, Long l11, Long l12, String str4, PendingIntent pendingIntent, Intent intent, String str5, String str6, Boolean bool, String str7, Boolean bool2, String str8, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : l11, (i11 & 16) != 0 ? null : l12, (i11 & 32) != 0 ? MUSIC_FLOAT_STATE_IDEA : str4, (i11 & 64) != 0 ? null : pendingIntent, (i11 & 128) != 0 ? null : intent, (i11 & 256) != 0 ? null : str5, (i11 & 512) != 0 ? null : str6, (i11 & 1024) != 0 ? null : bool, (i11 & 2048) != 0 ? "" : str7, (i11 & 4096) != 0 ? Boolean.FALSE : bool2, (i11 & 8192) == 0 ? str8 : null);
    }

    public final String component1() {
        return this.title;
    }

    public final String component10() {
        return this.mediaId;
    }

    public final Boolean component11() {
        return this.isMusic;
    }

    public final String component12() {
        return this.pageName;
    }

    public final Boolean component13() {
        return this.inBackground;
    }

    public final String component14() {
        return this.ops;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final String component3() {
        return this.coverUrl;
    }

    public final Long component4() {
        return this.duration;
    }

    public final Long component5() {
        return this.position;
    }

    public final String component6() {
        return this.state;
    }

    public final PendingIntent component7() {
        return this.pendingIntent;
    }

    public final Intent component8() {
        return this.clickIntent;
    }

    public final String component9() {
        return this.subjectId;
    }

    public final MediaItem copy(String str, String str2, String str3, Long l11, Long l12, String str4, PendingIntent pendingIntent, Intent intent, String str5, String str6, Boolean bool, String str7, Boolean bool2, String str8) {
        return new MediaItem(str, str2, str3, l11, l12, str4, pendingIntent, intent, str5, str6, bool, str7, bool2, str8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        return Intrinsics.b(this.title, mediaItem.title) && Intrinsics.b(this.subTitle, mediaItem.subTitle) && Intrinsics.b(this.coverUrl, mediaItem.coverUrl) && Intrinsics.b(this.duration, mediaItem.duration) && Intrinsics.b(this.position, mediaItem.position) && Intrinsics.b(this.state, mediaItem.state) && Intrinsics.b(this.pendingIntent, mediaItem.pendingIntent) && Intrinsics.b(this.clickIntent, mediaItem.clickIntent) && Intrinsics.b(this.subjectId, mediaItem.subjectId) && Intrinsics.b(this.mediaId, mediaItem.mediaId) && Intrinsics.b(this.isMusic, mediaItem.isMusic) && Intrinsics.b(this.pageName, mediaItem.pageName) && Intrinsics.b(this.inBackground, mediaItem.inBackground) && Intrinsics.b(this.ops, mediaItem.ops);
    }

    public final Intent getClickIntent() {
        return this.clickIntent;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Boolean getInBackground() {
        return this.inBackground;
    }

    public final String getMediaId() {
        return this.mediaId;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final Long getPosition() {
        return this.position;
    }

    public final String getState() {
        return this.state;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subTitle;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.coverUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l11 = this.duration;
        int iHashCode4 = (iHashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.position;
        int iHashCode5 = (iHashCode4 + (l12 == null ? 0 : l12.hashCode())) * 31;
        String str4 = this.state;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        PendingIntent pendingIntent = this.pendingIntent;
        int iHashCode7 = (iHashCode6 + (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 31;
        Intent intent = this.clickIntent;
        int iHashCode8 = (iHashCode7 + (intent == null ? 0 : intent.hashCode())) * 31;
        String str5 = this.subjectId;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mediaId;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.isMusic;
        int iHashCode11 = (iHashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str7 = this.pageName;
        int iHashCode12 = (iHashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool2 = this.inBackground;
        int iHashCode13 = (iHashCode12 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str8 = this.ops;
        return iHashCode13 + (str8 != null ? str8.hashCode() : 0);
    }

    public final Boolean isMusic() {
        return this.isMusic;
    }

    public final void setClickIntent(Intent intent) {
        this.clickIntent = intent;
    }

    public final void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public final void setDuration(Long l11) {
        this.duration = l11;
    }

    public final void setInBackground(Boolean bool) {
        this.inBackground = bool;
    }

    public final void setMediaId(String str) {
        this.mediaId = str;
    }

    public final void setMusic(Boolean bool) {
        this.isMusic = bool;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPageName(String str) {
        this.pageName = str;
    }

    public final void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }

    public final void setPosition(Long l11) {
        this.position = l11;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "MediaItem(title=" + this.title + ", subTitle=" + this.subTitle + ", coverUrl=" + this.coverUrl + ", duration=" + this.duration + ", position=" + this.position + ", state=" + this.state + ", pendingIntent=" + this.pendingIntent + ", clickIntent=" + this.clickIntent + ", subjectId=" + this.subjectId + ", mediaId=" + this.mediaId + ", isMusic=" + this.isMusic + ", pageName=" + this.pageName + ", inBackground=" + this.inBackground + ", ops=" + this.ops + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.title);
        out.writeString(this.subTitle);
        out.writeString(this.coverUrl);
        Long l11 = this.duration;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
        Long l12 = this.position;
        if (l12 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l12.longValue());
        }
        out.writeString(this.state);
        out.writeParcelable(this.pendingIntent, i11);
        out.writeParcelable(this.clickIntent, i11);
        out.writeString(this.subjectId);
        out.writeString(this.mediaId);
        Boolean bool = this.isMusic;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        out.writeString(this.pageName);
        Boolean bool2 = this.inBackground;
        if (bool2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        out.writeString(this.ops);
    }
}
