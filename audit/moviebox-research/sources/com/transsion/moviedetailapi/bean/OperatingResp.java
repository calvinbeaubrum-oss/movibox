package com.transsion.moviedetailapi.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
public final class OperatingResp implements Parcelable {
    public static final Parcelable.Creator<OperatingResp> CREATOR = new a();
    private List<OperateItem> ops;
    private List<PlayListItemBean> playList;
    private transient String sourceFrom;
    private String version;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<OperatingResp> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final OperatingResp createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(OperateItem.CREATOR.createFromParcel(parcel));
                }
            }
            String string = parcel.readString();
            if (parcel.readInt() != 0) {
                int i13 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList3.add(PlayListItemBean.CREATOR.createFromParcel(parcel));
                }
                arrayList2 = arrayList3;
            }
            return new OperatingResp(arrayList, string, arrayList2, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final OperatingResp[] newArray(int i11) {
            return new OperatingResp[i11];
        }
    }

    public OperatingResp() {
        this(null, null, null, null, 15, null);
    }

    public OperatingResp(List<OperateItem> list, String str, List<PlayListItemBean> list2, String sourceFrom) {
        Intrinsics.g(sourceFrom, "sourceFrom");
        this.ops = list;
        this.version = str;
        this.playList = list2;
        this.sourceFrom = sourceFrom;
    }

    public /* synthetic */ OperatingResp(List list, String str, List list2, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : list2, (i11 & 8) != 0 ? "" : str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OperatingResp copy$default(OperatingResp operatingResp, List list, String str, List list2, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = operatingResp.ops;
        }
        if ((i11 & 2) != 0) {
            str = operatingResp.version;
        }
        if ((i11 & 4) != 0) {
            list2 = operatingResp.playList;
        }
        if ((i11 & 8) != 0) {
            str2 = operatingResp.sourceFrom;
        }
        return operatingResp.copy(list, str, list2, str2);
    }

    public final List<OperateItem> component1() {
        return this.ops;
    }

    public final String component2() {
        return this.version;
    }

    public final List<PlayListItemBean> component3() {
        return this.playList;
    }

    public final String component4() {
        return this.sourceFrom;
    }

    public final OperatingResp copy(List<OperateItem> list, String str, List<PlayListItemBean> list2, String sourceFrom) {
        Intrinsics.g(sourceFrom, "sourceFrom");
        return new OperatingResp(list, str, list2, sourceFrom);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OperatingResp)) {
            return false;
        }
        OperatingResp operatingResp = (OperatingResp) obj;
        return Intrinsics.b(this.ops, operatingResp.ops) && Intrinsics.b(this.version, operatingResp.version) && Intrinsics.b(this.playList, operatingResp.playList) && Intrinsics.b(this.sourceFrom, operatingResp.sourceFrom);
    }

    public final List<BannerData> getBanners() {
        Object objM163constructorimpl;
        OperateItem operateItem;
        BannerBean banner;
        try {
            Result.Companion companion = Result.Companion;
            List<OperateItem> list = this.ops;
            objM163constructorimpl = Result.m163constructorimpl((list == null || (operateItem = list.get(0)) == null || (banner = operateItem.getBanner()) == null) ? null : banner.getBanners());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        return (List) (Result.m169isFailureimpl(objM163constructorimpl) ? null : objM163constructorimpl);
    }

    public final List<OperateItem> getOps() {
        return this.ops;
    }

    public final List<PlayListItemBean> getPlayList() {
        return this.playList;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        List<OperateItem> list = this.ops;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.version;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<PlayListItemBean> list2 = this.playList;
        return ((iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.sourceFrom.hashCode();
    }

    public final void setOps(List<OperateItem> list) {
        this.ops = list;
    }

    public final void setPlayList(List<PlayListItemBean> list) {
        this.playList = list;
    }

    public final void setSourceFrom(String str) {
        Intrinsics.g(str, "<set-?>");
        this.sourceFrom = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "OperatingResp(ops=" + this.ops + ", version=" + this.version + ", playList=" + this.playList + ", sourceFrom=" + this.sourceFrom + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<OperateItem> list = this.ops;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<OperateItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeString(this.version);
        List<PlayListItemBean> list2 = this.playList;
        if (list2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list2.size());
            Iterator<PlayListItemBean> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(out, i11);
            }
        }
        out.writeString(this.sourceFrom);
    }
}
