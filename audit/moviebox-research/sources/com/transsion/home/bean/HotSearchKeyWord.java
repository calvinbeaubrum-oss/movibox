package com.transsion.home.bean;

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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class HotSearchKeyWord implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<HotSearchKeyWord> CREATOR = new a();
    private String title;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<HotSearchKeyWord> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HotSearchKeyWord createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new HotSearchKeyWord(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HotSearchKeyWord[] newArray(int i11) {
            return new HotSearchKeyWord[i11];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HotSearchKeyWord() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public HotSearchKeyWord(String str) {
        this.title = str;
    }

    public /* synthetic */ HotSearchKeyWord(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str);
    }

    public static /* synthetic */ HotSearchKeyWord copy$default(HotSearchKeyWord hotSearchKeyWord, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = hotSearchKeyWord.title;
        }
        return hotSearchKeyWord.copy(str);
    }

    public final String component1() {
        return this.title;
    }

    public final HotSearchKeyWord copy(String str) {
        return new HotSearchKeyWord(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HotSearchKeyWord) && Intrinsics.b(this.title, ((HotSearchKeyWord) obj).title);
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "HotSearchKeyWord(title=" + this.title + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.title);
    }
}
