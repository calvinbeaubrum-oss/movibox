package com.transsion.search.fragment.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.search.bean.VerticalRank;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class ResultWrapData implements Parcelable {
    public static final Parcelable.Creator<ResultWrapData> CREATOR = new a();
    private final Group groups;
    private final String moreTabId;
    private final Staff staff;
    private final Subject subject;
    private final String title;
    private final ResultType type;
    private final VerticalRank verticalRank;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<ResultWrapData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ResultWrapData createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new ResultWrapData(ResultType.valueOf(parcel.readString()), (Subject) parcel.readSerializable(), (Staff) parcel.readSerializable(), (Group) parcel.readSerializable(), parcel.readInt() == 0 ? null : VerticalRank.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ResultWrapData[] newArray(int i11) {
            return new ResultWrapData[i11];
        }
    }

    public ResultWrapData(ResultType type, Subject subject, Staff staff, Group group, VerticalRank verticalRank, String str, String str2) {
        Intrinsics.g(type, "type");
        this.type = type;
        this.subject = subject;
        this.staff = staff;
        this.groups = group;
        this.verticalRank = verticalRank;
        this.title = str;
        this.moreTabId = str2;
    }

    public /* synthetic */ ResultWrapData(ResultType resultType, Subject subject, Staff staff, Group group, VerticalRank verticalRank, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(resultType, (i11 & 2) != 0 ? null : subject, (i11 & 4) != 0 ? null : staff, (i11 & 8) != 0 ? null : group, (i11 & 16) != 0 ? null : verticalRank, (i11 & 32) != 0 ? null : str, (i11 & 64) == 0 ? str2 : null);
    }

    public static /* synthetic */ ResultWrapData copy$default(ResultWrapData resultWrapData, ResultType resultType, Subject subject, Staff staff, Group group, VerticalRank verticalRank, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            resultType = resultWrapData.type;
        }
        if ((i11 & 2) != 0) {
            subject = resultWrapData.subject;
        }
        Subject subject2 = subject;
        if ((i11 & 4) != 0) {
            staff = resultWrapData.staff;
        }
        Staff staff2 = staff;
        if ((i11 & 8) != 0) {
            group = resultWrapData.groups;
        }
        Group group2 = group;
        if ((i11 & 16) != 0) {
            verticalRank = resultWrapData.verticalRank;
        }
        VerticalRank verticalRank2 = verticalRank;
        if ((i11 & 32) != 0) {
            str = resultWrapData.title;
        }
        String str3 = str;
        if ((i11 & 64) != 0) {
            str2 = resultWrapData.moreTabId;
        }
        return resultWrapData.copy(resultType, subject2, staff2, group2, verticalRank2, str3, str2);
    }

    public final ResultType component1() {
        return this.type;
    }

    public final Subject component2() {
        return this.subject;
    }

    public final Staff component3() {
        return this.staff;
    }

    public final Group component4() {
        return this.groups;
    }

    public final VerticalRank component5() {
        return this.verticalRank;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.moreTabId;
    }

    public final ResultWrapData copy(ResultType type, Subject subject, Staff staff, Group group, VerticalRank verticalRank, String str, String str2) {
        Intrinsics.g(type, "type");
        return new ResultWrapData(type, subject, staff, group, verticalRank, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResultWrapData)) {
            return false;
        }
        ResultWrapData resultWrapData = (ResultWrapData) obj;
        return this.type == resultWrapData.type && Intrinsics.b(this.subject, resultWrapData.subject) && Intrinsics.b(this.staff, resultWrapData.staff) && Intrinsics.b(this.groups, resultWrapData.groups) && Intrinsics.b(this.verticalRank, resultWrapData.verticalRank) && Intrinsics.b(this.title, resultWrapData.title) && Intrinsics.b(this.moreTabId, resultWrapData.moreTabId);
    }

    public final Group getGroups() {
        return this.groups;
    }

    public final String getMoreTabId() {
        return this.moreTabId;
    }

    public final Staff getStaff() {
        return this.staff;
    }

    public final Subject getSubject() {
        return this.subject;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ResultType getType() {
        return this.type;
    }

    public final VerticalRank getVerticalRank() {
        return this.verticalRank;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Subject subject = this.subject;
        int iHashCode2 = (iHashCode + (subject == null ? 0 : subject.hashCode())) * 31;
        Staff staff = this.staff;
        int iHashCode3 = (iHashCode2 + (staff == null ? 0 : staff.hashCode())) * 31;
        Group group = this.groups;
        int iHashCode4 = (iHashCode3 + (group == null ? 0 : group.hashCode())) * 31;
        VerticalRank verticalRank = this.verticalRank;
        int iHashCode5 = (iHashCode4 + (verticalRank == null ? 0 : verticalRank.hashCode())) * 31;
        String str = this.title;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.moreTabId;
        return iHashCode6 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ResultWrapData(type=" + this.type + ", subject=" + this.subject + ", staff=" + this.staff + ", groups=" + this.groups + ", verticalRank=" + this.verticalRank + ", title=" + this.title + ", moreTabId=" + this.moreTabId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.type.name());
        out.writeSerializable(this.subject);
        out.writeSerializable(this.staff);
        out.writeSerializable(this.groups);
        VerticalRank verticalRank = this.verticalRank;
        if (verticalRank == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            verticalRank.writeToParcel(out, i11);
        }
        out.writeString(this.title);
        out.writeString(this.moreTabId);
    }
}
