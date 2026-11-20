package com.transsion.baselib.helper;

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
public final class ReferrerBean implements Parcelable {
    public static final Parcelable.Creator<ReferrerBean> CREATOR = new a();
    private String utmCampaign;
    private String utmContent;
    private String utmMedium;
    private String utmSource;
    private String utmTerm;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<ReferrerBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ReferrerBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new ReferrerBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ReferrerBean[] newArray(int i11) {
            return new ReferrerBean[i11];
        }
    }

    public ReferrerBean() {
        this(null, null, null, null, null, 31, null);
    }

    public ReferrerBean(String str, String str2, String str3, String str4, String str5) {
        this.utmSource = str;
        this.utmContent = str2;
        this.utmTerm = str3;
        this.utmMedium = str4;
        this.utmCampaign = str5;
    }

    public /* synthetic */ ReferrerBean(String str, String str2, String str3, String str4, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5);
    }

    public static /* synthetic */ ReferrerBean copy$default(ReferrerBean referrerBean, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = referrerBean.utmSource;
        }
        if ((i11 & 2) != 0) {
            str2 = referrerBean.utmContent;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = referrerBean.utmTerm;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = referrerBean.utmMedium;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = referrerBean.utmCampaign;
        }
        return referrerBean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.utmSource;
    }

    public final String component2() {
        return this.utmContent;
    }

    public final String component3() {
        return this.utmTerm;
    }

    public final String component4() {
        return this.utmMedium;
    }

    public final String component5() {
        return this.utmCampaign;
    }

    public final ReferrerBean copy(String str, String str2, String str3, String str4, String str5) {
        return new ReferrerBean(str, str2, str3, str4, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReferrerBean)) {
            return false;
        }
        ReferrerBean referrerBean = (ReferrerBean) obj;
        return Intrinsics.b(this.utmSource, referrerBean.utmSource) && Intrinsics.b(this.utmContent, referrerBean.utmContent) && Intrinsics.b(this.utmTerm, referrerBean.utmTerm) && Intrinsics.b(this.utmMedium, referrerBean.utmMedium) && Intrinsics.b(this.utmCampaign, referrerBean.utmCampaign);
    }

    public final String getUtmCampaign() {
        return this.utmCampaign;
    }

    public final String getUtmContent() {
        return this.utmContent;
    }

    public final String getUtmMedium() {
        return this.utmMedium;
    }

    public final String getUtmSource() {
        return this.utmSource;
    }

    public final String getUtmTerm() {
        return this.utmTerm;
    }

    public int hashCode() {
        String str = this.utmSource;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.utmContent;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.utmTerm;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.utmMedium;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.utmCampaign;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setUtmCampaign(String str) {
        this.utmCampaign = str;
    }

    public final void setUtmContent(String str) {
        this.utmContent = str;
    }

    public final void setUtmMedium(String str) {
        this.utmMedium = str;
    }

    public final void setUtmSource(String str) {
        this.utmSource = str;
    }

    public final void setUtmTerm(String str) {
        this.utmTerm = str;
    }

    public String toString() {
        return "ReferrerBean(utmSource=" + this.utmSource + ", utmContent=" + this.utmContent + ", utmTerm=" + this.utmTerm + ", utmMedium=" + this.utmMedium + ", utmCampaign=" + this.utmCampaign + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.utmSource);
        out.writeString(this.utmContent);
        out.writeString(this.utmTerm);
        out.writeString(this.utmMedium);
        out.writeString(this.utmCampaign);
    }
}
