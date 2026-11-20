package com.transsion.ad.monopoly.intercept;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.io.Serializable;
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
public final class ShowedTimesMemoryBean implements Parcelable, Serializable {
    public static final Parcelable.Creator<ShowedTimesMemoryBean> CREATOR = new a();
    private String date;
    private int showedTimes;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<ShowedTimesMemoryBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ShowedTimesMemoryBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new ShowedTimesMemoryBean(parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ShowedTimesMemoryBean[] newArray(int i11) {
            return new ShowedTimesMemoryBean[i11];
        }
    }

    public ShowedTimesMemoryBean(int i11, String date) {
        Intrinsics.g(date, "date");
        this.showedTimes = i11;
        this.date = date;
    }

    public static /* synthetic */ ShowedTimesMemoryBean copy$default(ShowedTimesMemoryBean showedTimesMemoryBean, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = showedTimesMemoryBean.showedTimes;
        }
        if ((i12 & 2) != 0) {
            str = showedTimesMemoryBean.date;
        }
        return showedTimesMemoryBean.copy(i11, str);
    }

    public final int component1() {
        return this.showedTimes;
    }

    public final String component2() {
        return this.date;
    }

    public final ShowedTimesMemoryBean copy(int i11, String date) {
        Intrinsics.g(date, "date");
        return new ShowedTimesMemoryBean(i11, date);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowedTimesMemoryBean)) {
            return false;
        }
        ShowedTimesMemoryBean showedTimesMemoryBean = (ShowedTimesMemoryBean) obj;
        return this.showedTimes == showedTimesMemoryBean.showedTimes && Intrinsics.b(this.date, showedTimesMemoryBean.date);
    }

    public final String getDate() {
        return this.date;
    }

    public final int getShowedTimes() {
        return this.showedTimes;
    }

    public int hashCode() {
        return (this.showedTimes * 31) + this.date.hashCode();
    }

    public final void setDate(String str) {
        Intrinsics.g(str, "<set-?>");
        this.date = str;
    }

    public final void setShowedTimes(int i11) {
        this.showedTimes = i11;
    }

    public String toString() {
        return "ShowedTimesMemoryBean(showedTimes=" + this.showedTimes + ", date=" + this.date + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.showedTimes);
        out.writeString(this.date);
    }
}
