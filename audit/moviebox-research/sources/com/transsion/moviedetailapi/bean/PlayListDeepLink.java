package com.transsion.moviedetailapi.bean;

import android.net.Uri;
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
public final class PlayListDeepLink implements Parcelable {
    private String category;
    private String label;
    private String recType;
    private String type;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<PlayListDeepLink> CREATOR = new b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayListDeepLink a(String str) {
            if (str == null) {
                return null;
            }
            Uri uri = Uri.parse(str);
            return new PlayListDeepLink(uri.getQueryParameter("type"), uri.getQueryParameter("category"), uri.getQueryParameter("recType"), uri.getQueryParameter("label"));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Parcelable.Creator<PlayListDeepLink> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PlayListDeepLink createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PlayListDeepLink(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PlayListDeepLink[] newArray(int i11) {
            return new PlayListDeepLink[i11];
        }
    }

    public PlayListDeepLink(String str, String str2, String str3, String str4) {
        this.type = str;
        this.category = str2;
        this.recType = str3;
        this.label = str4;
    }

    public static /* synthetic */ PlayListDeepLink copy$default(PlayListDeepLink playListDeepLink, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = playListDeepLink.type;
        }
        if ((i11 & 2) != 0) {
            str2 = playListDeepLink.category;
        }
        if ((i11 & 4) != 0) {
            str3 = playListDeepLink.recType;
        }
        if ((i11 & 8) != 0) {
            str4 = playListDeepLink.label;
        }
        return playListDeepLink.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.category;
    }

    public final String component3() {
        return this.recType;
    }

    public final String component4() {
        return this.label;
    }

    public final PlayListDeepLink copy(String str, String str2, String str3, String str4) {
        return new PlayListDeepLink(str, str2, str3, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayListDeepLink)) {
            return false;
        }
        PlayListDeepLink playListDeepLink = (PlayListDeepLink) obj;
        return Intrinsics.b(this.type, playListDeepLink.type) && Intrinsics.b(this.category, playListDeepLink.category) && Intrinsics.b(this.recType, playListDeepLink.recType) && Intrinsics.b(this.label, playListDeepLink.label);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getRecType() {
        return this.recType;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.category;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.recType;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.label;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final void setRecType(String str) {
        this.recType = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "PlayListDeepLink(type=" + this.type + ", category=" + this.category + ", recType=" + this.recType + ", label=" + this.label + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.type);
        out.writeString(this.category);
        out.writeString(this.recType);
        out.writeString(this.label);
    }
}
