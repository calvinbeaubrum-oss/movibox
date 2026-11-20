package com.transsion.lib_web.zip.db;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class WebResRemoteBean implements Parcelable {
    public static final Parcelable.Creator<WebResRemoteBean> CREATOR = new a();
    private final String lastUpdateTime;
    private final List<WebViewCacheConfigData> list;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<WebResRemoteBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WebResRemoteBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(WebViewCacheConfigData.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new WebResRemoteBean(arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final WebResRemoteBean[] newArray(int i11) {
            return new WebResRemoteBean[i11];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebResRemoteBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public WebResRemoteBean(List<WebViewCacheConfigData> list, String str) {
        this.list = list;
        this.lastUpdateTime = str;
    }

    public /* synthetic */ WebResRemoteBean(List list, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebResRemoteBean copy$default(WebResRemoteBean webResRemoteBean, List list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = webResRemoteBean.list;
        }
        if ((i11 & 2) != 0) {
            str = webResRemoteBean.lastUpdateTime;
        }
        return webResRemoteBean.copy(list, str);
    }

    public final List<WebViewCacheConfigData> component1() {
        return this.list;
    }

    public final String component2() {
        return this.lastUpdateTime;
    }

    public final WebResRemoteBean copy(List<WebViewCacheConfigData> list, String str) {
        return new WebResRemoteBean(list, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebResRemoteBean)) {
            return false;
        }
        WebResRemoteBean webResRemoteBean = (WebResRemoteBean) obj;
        return Intrinsics.b(this.list, webResRemoteBean.list) && Intrinsics.b(this.lastUpdateTime, webResRemoteBean.lastUpdateTime);
    }

    public final String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final List<WebViewCacheConfigData> getList() {
        return this.list;
    }

    public int hashCode() {
        List<WebViewCacheConfigData> list = this.list;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.lastUpdateTime;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "WebResRemoteBean(list=" + this.list + ", lastUpdateTime=" + this.lastUpdateTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<WebViewCacheConfigData> list = this.list;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<WebViewCacheConfigData> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeString(this.lastUpdateTime);
    }
}
