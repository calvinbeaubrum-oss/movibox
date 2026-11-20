package com.transsion.payment.lib.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public final class SkuData implements Parcelable {
    public static final Parcelable.Creator<SkuData> CREATOR = new a();
    private List<SkuBean> skuList;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SkuData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SkuData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(SkuBean.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new SkuData(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SkuData[] newArray(int i11) {
            return new SkuData[i11];
        }
    }

    public SkuData(List<SkuBean> list) {
        this.skuList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuData copy$default(SkuData skuData, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = skuData.skuList;
        }
        return skuData.copy(list);
    }

    public final List<SkuBean> component1() {
        return this.skuList;
    }

    public final SkuData copy(List<SkuBean> list) {
        return new SkuData(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SkuData) && Intrinsics.b(this.skuList, ((SkuData) obj).skuList);
    }

    public final List<SkuBean> getSkuList() {
        return this.skuList;
    }

    public int hashCode() {
        List<SkuBean> list = this.skuList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setSkuList(List<SkuBean> list) {
        this.skuList = list;
    }

    public String toString() {
        return "SkuData(skuList=" + this.skuList + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<SkuBean> list = this.skuList;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        Iterator<SkuBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i11);
        }
    }
}
