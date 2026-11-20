package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.Keep;
import com.transsion.ad.monopoly.model.AdPlans;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.UnixStat;

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
public final class BannerData implements Parcelable {
    public static final Parcelable.Creator<BannerData> CREATOR = new a();
    private AdPlans adData;
    private transient View adview;
    private boolean builtIn;
    private String content;
    private String deepLink;
    private Boolean hasResource;
    private Image image;
    private String ops;
    private Integer seenStatus;
    private Subject subject;
    private String subjectId;
    private int subjectType;
    private int type;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<BannerData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BannerData createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            Image image = (Image) parcel.readSerializable();
            int i11 = parcel.readInt();
            boolean z11 = parcel.readInt() != 0;
            String string3 = parcel.readString();
            int i12 = parcel.readInt();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new BannerData(string, string2, image, i11, z11, string3, i12, boolValueOf, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), (Subject) parcel.readSerializable(), (AdPlans) parcel.readParcelable(BannerData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BannerData[] newArray(int i11) {
            return new BannerData[i11];
        }
    }

    public BannerData() {
        this(null, null, null, 0, false, null, 0, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public BannerData(String str, String str2, Image image, int i11, boolean z11, String str3, int i12, Boolean bool, Integer num, String str4, Subject subject, AdPlans adPlans) {
        this.content = str;
        this.deepLink = str2;
        this.image = image;
        this.type = i11;
        this.builtIn = z11;
        this.subjectId = str3;
        this.subjectType = i12;
        this.hasResource = bool;
        this.seenStatus = num;
        this.ops = str4;
        this.subject = subject;
        this.adData = adPlans;
    }

    public /* synthetic */ BannerData(String str, String str2, Image image, int i11, boolean z11, String str3, int i12, Boolean bool, Integer num, String str4, Subject subject, AdPlans adPlans, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? null : str, (i13 & 2) != 0 ? null : str2, (i13 & 4) != 0 ? null : image, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? false : z11, (i13 & 32) != 0 ? null : str3, (i13 & 64) != 0 ? 0 : i12, (i13 & 128) != 0 ? null : bool, (i13 & 256) != 0 ? 0 : num, (i13 & 512) != 0 ? null : str4, (i13 & 1024) != 0 ? null : subject, (i13 & 2048) == 0 ? adPlans : null);
    }

    public final String component1() {
        return this.content;
    }

    public final String component10() {
        return this.ops;
    }

    public final Subject component11() {
        return this.subject;
    }

    public final AdPlans component12() {
        return this.adData;
    }

    public final String component2() {
        return this.deepLink;
    }

    public final Image component3() {
        return this.image;
    }

    public final int component4() {
        return this.type;
    }

    public final boolean component5() {
        return this.builtIn;
    }

    public final String component6() {
        return this.subjectId;
    }

    public final int component7() {
        return this.subjectType;
    }

    public final Boolean component8() {
        return this.hasResource;
    }

    public final Integer component9() {
        return this.seenStatus;
    }

    public final BannerData copy(String str, String str2, Image image, int i11, boolean z11, String str3, int i12, Boolean bool, Integer num, String str4, Subject subject, AdPlans adPlans) {
        return new BannerData(str, str2, image, i11, z11, str3, i12, bool, num, str4, subject, adPlans);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannerData)) {
            return false;
        }
        BannerData bannerData = (BannerData) obj;
        return Intrinsics.b(this.content, bannerData.content) && Intrinsics.b(this.deepLink, bannerData.deepLink) && Intrinsics.b(this.image, bannerData.image) && this.type == bannerData.type && this.builtIn == bannerData.builtIn && Intrinsics.b(this.subjectId, bannerData.subjectId) && this.subjectType == bannerData.subjectType && Intrinsics.b(this.hasResource, bannerData.hasResource) && Intrinsics.b(this.seenStatus, bannerData.seenStatus) && Intrinsics.b(this.ops, bannerData.ops) && Intrinsics.b(this.subject, bannerData.subject) && Intrinsics.b(this.adData, bannerData.adData);
    }

    public final AdPlans getAdData() {
        return this.adData;
    }

    public final View getAdview() {
        return this.adview;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final Boolean getHasResource() {
        return this.hasResource;
    }

    public final Image getImage() {
        return this.image;
    }

    public final String getOps() {
        return this.ops;
    }

    public final Integer getSeenStatus() {
        return this.seenStatus;
    }

    public final Subject getSubject() {
        return this.subject;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final int getSubjectType() {
        return this.subjectType;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public int hashCode() {
        String str = this.content;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deepLink;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Image image = this.image;
        int iHashCode3 = (((iHashCode2 + (image == null ? 0 : image.hashCode())) * 31) + this.type) * 31;
        boolean z11 = this.builtIn;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode3 + r11) * 31;
        String str3 = this.subjectId;
        int iHashCode4 = (((i11 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.subjectType) * 31;
        Boolean bool = this.hasResource;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.seenStatus;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.ops;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Subject subject = this.subject;
        int iHashCode8 = (iHashCode7 + (subject == null ? 0 : subject.hashCode())) * 31;
        AdPlans adPlans = this.adData;
        return iHashCode8 + (adPlans != null ? adPlans.hashCode() : 0);
    }

    public final void setAdData(AdPlans adPlans) {
        this.adData = adPlans;
    }

    public final void setAdview(View view) {
        this.adview = view;
    }

    public final void setBuiltIn(boolean z11) {
        this.builtIn = z11;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final void setHasResource(Boolean bool) {
        this.hasResource = bool;
    }

    public final void setImage(Image image) {
        this.image = image;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setSeenStatus(Integer num) {
        this.seenStatus = num;
    }

    public final void setSubject(Subject subject) {
        this.subject = subject;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectType(int i11) {
        this.subjectType = i11;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "BannerData(content=" + this.content + ", deepLink=" + this.deepLink + ", image=" + this.image + ", type=" + this.type + ", builtIn=" + this.builtIn + ", subjectId=" + this.subjectId + ", subjectType=" + this.subjectType + ", hasResource=" + this.hasResource + ", seenStatus=" + this.seenStatus + ", ops=" + this.ops + ", subject=" + this.subject + ", adData=" + this.adData + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.content);
        out.writeString(this.deepLink);
        out.writeSerializable(this.image);
        out.writeInt(this.type);
        out.writeInt(this.builtIn ? 1 : 0);
        out.writeString(this.subjectId);
        out.writeInt(this.subjectType);
        Boolean bool = this.hasResource;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Integer num = this.seenStatus;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        out.writeString(this.ops);
        out.writeSerializable(this.subject);
        out.writeParcelable(this.adData, i11);
    }
}
