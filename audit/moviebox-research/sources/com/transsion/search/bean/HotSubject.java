package com.transsion.search.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.blankj.utilcode.util.h0;
import com.blankj.utilcode.util.z;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
@SourceDebugExtension
public final class HotSubject implements Parcelable {
    public static final Parcelable.Creator<HotSubject> CREATOR = new a();
    private String corner;
    private String countryName;
    private HotCover cover;
    private String genre;
    private String imdbRatingValue;
    private String ops;
    private String releaseDate;
    private String subjectId;
    private Integer subjectType;
    private String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<HotSubject> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HotSubject createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new HotSubject(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? HotCover.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HotSubject[] newArray(int i11) {
            return new HotSubject[i11];
        }
    }

    public HotSubject(String str, Integer num, String str2, String str3, String str4, String str5, HotCover hotCover, String str6, String str7, String str8) {
        this.subjectId = str;
        this.subjectType = num;
        this.title = str2;
        this.ops = str3;
        this.releaseDate = str4;
        this.genre = str5;
        this.cover = hotCover;
        this.countryName = str6;
        this.imdbRatingValue = str7;
        this.corner = str8;
    }

    public /* synthetic */ HotSubject(String str, Integer num, String str2, String str3, String str4, String str5, HotCover hotCover, String str6, String str7, String str8, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, num, str2, str3, str4, str5, hotCover, str6, str7, (i11 & 512) != 0 ? null : str8);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final String component10() {
        return this.corner;
    }

    public final Integer component2() {
        return this.subjectType;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.ops;
    }

    public final String component5() {
        return this.releaseDate;
    }

    public final String component6() {
        return this.genre;
    }

    public final HotCover component7() {
        return this.cover;
    }

    public final String component8() {
        return this.countryName;
    }

    public final String component9() {
        return this.imdbRatingValue;
    }

    public final HotSubject copy(String str, Integer num, String str2, String str3, String str4, String str5, HotCover hotCover, String str6, String str7, String str8) {
        return new HotSubject(str, num, str2, str3, str4, str5, hotCover, str6, str7, str8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HotSubject)) {
            return false;
        }
        HotSubject hotSubject = (HotSubject) obj;
        return Intrinsics.b(this.subjectId, hotSubject.subjectId) && Intrinsics.b(this.subjectType, hotSubject.subjectType) && Intrinsics.b(this.title, hotSubject.title) && Intrinsics.b(this.ops, hotSubject.ops) && Intrinsics.b(this.releaseDate, hotSubject.releaseDate) && Intrinsics.b(this.genre, hotSubject.genre) && Intrinsics.b(this.cover, hotSubject.cover) && Intrinsics.b(this.countryName, hotSubject.countryName) && Intrinsics.b(this.imdbRatingValue, hotSubject.imdbRatingValue) && Intrinsics.b(this.corner, hotSubject.corner);
    }

    public final String getCorner() {
        return this.corner;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final HotCover getCover() {
        return this.cover;
    }

    public final String getDisplayFull() {
        Date dateK = h0.k(this.releaseDate, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateK);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
        if (!TextUtils.isEmpty(this.countryName)) {
            spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) this.countryName);
        }
        String[] strArrA = z.a(this.genre, ",");
        if (strArrA != null) {
            for (String str : strArrA) {
                spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) str);
            }
        }
        String string = spannableStringBuilder.toString();
        Intrinsics.f(string, "sb.toString()");
        return string;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final String getImdbRatingValue() {
        return this.imdbRatingValue;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.subjectId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.subjectType;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ops;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.releaseDate;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.genre;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        HotCover hotCover = this.cover;
        int iHashCode7 = (iHashCode6 + (hotCover == null ? 0 : hotCover.hashCode())) * 31;
        String str6 = this.countryName;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.imdbRatingValue;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.corner;
        return iHashCode9 + (str8 != null ? str8.hashCode() : 0);
    }

    public final boolean isMusicType() {
        Integer num = this.subjectType;
        SubjectType subjectType = SubjectType.MUSIC;
        if (!Intrinsics.b(num, subjectType != null ? Integer.valueOf(subjectType.getValue()) : null)) {
            Integer num2 = this.subjectType;
            SubjectType subjectType2 = SubjectType.AUDIO;
            if (!Intrinsics.b(num2, subjectType2 != null ? Integer.valueOf(subjectType2.getValue()) : null)) {
                return false;
            }
        }
        return true;
    }

    public final void setCorner(String str) {
        this.corner = str;
    }

    public final void setCountryName(String str) {
        this.countryName = str;
    }

    public final void setCover(HotCover hotCover) {
        this.cover = hotCover;
    }

    public final void setGenre(String str) {
        this.genre = str;
    }

    public final void setImdbRatingValue(String str) {
        this.imdbRatingValue = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectType(Integer num) {
        this.subjectType = num;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "HotSubject(subjectId=" + this.subjectId + ", subjectType=" + this.subjectType + ", title=" + this.title + ", ops=" + this.ops + ", releaseDate=" + this.releaseDate + ", genre=" + this.genre + ", cover=" + this.cover + ", countryName=" + this.countryName + ", imdbRatingValue=" + this.imdbRatingValue + ", corner=" + this.corner + ")";
    }

    public final Subject transferSubject() {
        String str = this.subjectId;
        Integer num = this.subjectType;
        String str2 = this.title;
        String str3 = this.ops;
        return new Subject(str, num, str2, this.countryName, null, this.releaseDate, null, null, null, this.genre, null, null, this.imdbRatingValue, null, null, null, null, null, null, str3, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, this.corner, null, null, null, -528944, 3932159, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.subjectId);
        Integer num = this.subjectType;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.title);
        out.writeString(this.ops);
        out.writeString(this.releaseDate);
        out.writeString(this.genre);
        HotCover hotCover = this.cover;
        if (hotCover == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            hotCover.writeToParcel(out, i11);
        }
        out.writeString(this.countryName);
        out.writeString(this.imdbRatingValue);
        out.writeString(this.corner);
    }
}
