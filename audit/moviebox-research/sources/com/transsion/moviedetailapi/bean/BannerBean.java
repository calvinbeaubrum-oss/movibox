package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;
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
public final class BannerBean implements Parcelable {
    public static final String BANNER_STYLE_HORIZONTAL = "HORIZONTAL";
    private Boolean autoPlay;
    private List<BannerData> banners;
    private String interval;
    private boolean refreshAd;
    private String style;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<BannerBean> CREATOR = new b();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class b implements Parcelable.Creator<BannerBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BannerBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(parcel.readInt() == 0 ? null : BannerData.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new BannerBean(boolValueOf, arrayList, parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BannerBean[] newArray(int i11) {
            return new BannerBean[i11];
        }
    }

    public BannerBean() {
        this(null, null, null, false, null, 31, null);
    }

    public BannerBean(Boolean bool, List<BannerData> list, String str, boolean z11, String str2) {
        this.autoPlay = bool;
        this.banners = list;
        this.interval = str;
        this.refreshAd = z11;
        this.style = str2;
    }

    public /* synthetic */ BannerBean(Boolean bool, List list, String str, boolean z11, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : list, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? null : str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BannerBean copy$default(BannerBean bannerBean, Boolean bool, List list, String str, boolean z11, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = bannerBean.autoPlay;
        }
        if ((i11 & 2) != 0) {
            list = bannerBean.banners;
        }
        List list2 = list;
        if ((i11 & 4) != 0) {
            str = bannerBean.interval;
        }
        String str3 = str;
        if ((i11 & 8) != 0) {
            z11 = bannerBean.refreshAd;
        }
        boolean z12 = z11;
        if ((i11 & 16) != 0) {
            str2 = bannerBean.style;
        }
        return bannerBean.copy(bool, list2, str3, z12, str2);
    }

    public final Boolean component1() {
        return this.autoPlay;
    }

    public final List<BannerData> component2() {
        return this.banners;
    }

    public final String component3() {
        return this.interval;
    }

    public final boolean component4() {
        return this.refreshAd;
    }

    public final String component5() {
        return this.style;
    }

    public final BannerBean copy(Boolean bool, List<BannerData> list, String str, boolean z11, String str2) {
        return new BannerBean(bool, list, str, z11, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannerBean)) {
            return false;
        }
        BannerBean bannerBean = (BannerBean) obj;
        return Intrinsics.b(this.autoPlay, bannerBean.autoPlay) && Intrinsics.b(this.banners, bannerBean.banners) && Intrinsics.b(this.interval, bannerBean.interval) && this.refreshAd == bannerBean.refreshAd && Intrinsics.b(this.style, bannerBean.style);
    }

    public final Boolean getAutoPlay() {
        return this.autoPlay;
    }

    public final List<BannerData> getBanners() {
        return this.banners;
    }

    public final String getInterval() {
        return this.interval;
    }

    public final boolean getRefreshAd() {
        return this.refreshAd;
    }

    public final String getStyle() {
        return this.style;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        Boolean bool = this.autoPlay;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        List<BannerData> list = this.banners;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.interval;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z11 = this.refreshAd;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode3 + r11) * 31;
        String str2 = this.style;
        return i11 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setAutoPlay(Boolean bool) {
        this.autoPlay = bool;
    }

    public final void setBanners(List<BannerData> list) {
        this.banners = list;
    }

    public final void setInterval(String str) {
        this.interval = str;
    }

    public final void setRefreshAd(boolean z11) {
        this.refreshAd = z11;
    }

    public final void setStyle(String str) {
        this.style = str;
    }

    public String toString() {
        return "BannerBean(autoPlay=" + this.autoPlay + ", banners=" + this.banners + ", interval=" + this.interval + ", refreshAd=" + this.refreshAd + ", style=" + this.style + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        Boolean bool = this.autoPlay;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        List<BannerData> list = this.banners;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            for (BannerData bannerData : list) {
                if (bannerData == null) {
                    out.writeInt(0);
                } else {
                    out.writeInt(1);
                    bannerData.writeToParcel(out, i11);
                }
            }
        }
        out.writeString(this.interval);
        out.writeInt(this.refreshAd ? 1 : 0);
        out.writeString(this.style);
    }
}
