package com.transsion.search.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class SuggestEntity implements Parcelable {
    public static final Parcelable.Creator<SuggestEntity> CREATOR = new a();
    private Staff staff;
    private Subject subject;
    private Integer type;
    private VerticalRank verticalRank;
    private String word;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SuggestEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SuggestEntity createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new SuggestEntity(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() != 0 ? VerticalRank.CREATOR.createFromParcel(parcel) : null, (Subject) parcel.readSerializable(), (Staff) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SuggestEntity[] newArray(int i11) {
            return new SuggestEntity[i11];
        }
    }

    public SuggestEntity(Integer num, String str, VerticalRank verticalRank, Subject subject, Staff staff) {
        this.type = num;
        this.word = str;
        this.verticalRank = verticalRank;
        this.subject = subject;
        this.staff = staff;
    }

    public static /* synthetic */ SuggestEntity copy$default(SuggestEntity suggestEntity, Integer num, String str, VerticalRank verticalRank, Subject subject, Staff staff, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = suggestEntity.type;
        }
        if ((i11 & 2) != 0) {
            str = suggestEntity.word;
        }
        String str2 = str;
        if ((i11 & 4) != 0) {
            verticalRank = suggestEntity.verticalRank;
        }
        VerticalRank verticalRank2 = verticalRank;
        if ((i11 & 8) != 0) {
            subject = suggestEntity.subject;
        }
        Subject subject2 = subject;
        if ((i11 & 16) != 0) {
            staff = suggestEntity.staff;
        }
        return suggestEntity.copy(num, str2, verticalRank2, subject2, staff);
    }

    public final Integer component1() {
        return this.type;
    }

    public final String component2() {
        return this.word;
    }

    public final VerticalRank component3() {
        return this.verticalRank;
    }

    public final Subject component4() {
        return this.subject;
    }

    public final Staff component5() {
        return this.staff;
    }

    public final SuggestEntity copy(Integer num, String str, VerticalRank verticalRank, Subject subject, Staff staff) {
        return new SuggestEntity(num, str, verticalRank, subject, staff);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuggestEntity)) {
            return false;
        }
        SuggestEntity suggestEntity = (SuggestEntity) obj;
        return Intrinsics.b(this.type, suggestEntity.type) && Intrinsics.b(this.word, suggestEntity.word) && Intrinsics.b(this.verticalRank, suggestEntity.verticalRank) && Intrinsics.b(this.subject, suggestEntity.subject) && Intrinsics.b(this.staff, suggestEntity.staff);
    }

    public final Staff getStaff() {
        return this.staff;
    }

    public final Subject getSubject() {
        return this.subject;
    }

    public final Integer getType() {
        return this.type;
    }

    public final VerticalRank getVerticalRank() {
        return this.verticalRank;
    }

    public final String getWord() {
        return this.word;
    }

    public int hashCode() {
        Integer num = this.type;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.word;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        VerticalRank verticalRank = this.verticalRank;
        int iHashCode3 = (iHashCode2 + (verticalRank == null ? 0 : verticalRank.hashCode())) * 31;
        Subject subject = this.subject;
        int iHashCode4 = (iHashCode3 + (subject == null ? 0 : subject.hashCode())) * 31;
        Staff staff = this.staff;
        return iHashCode4 + (staff != null ? staff.hashCode() : 0);
    }

    public final void setStaff(Staff staff) {
        this.staff = staff;
    }

    public final void setSubject(Subject subject) {
        this.subject = subject;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final void setVerticalRank(VerticalRank verticalRank) {
        this.verticalRank = verticalRank;
    }

    public final void setWord(String str) {
        this.word = str;
    }

    public String toString() {
        return "SuggestEntity(type=" + this.type + ", word=" + this.word + ", verticalRank=" + this.verticalRank + ", subject=" + this.subject + ", staff=" + this.staff + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        Integer num = this.type;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.word);
        VerticalRank verticalRank = this.verticalRank;
        if (verticalRank == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            verticalRank.writeToParcel(out, i11);
        }
        out.writeSerializable(this.subject);
        out.writeSerializable(this.staff);
    }
}
