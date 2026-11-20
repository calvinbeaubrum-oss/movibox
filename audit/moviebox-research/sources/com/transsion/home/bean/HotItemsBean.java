package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
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
public final class HotItemsBean implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<HotItemsBean> CREATOR = new a();
    private final List<Subject> items;
    private final Pager pager;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<HotItemsBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HotItemsBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            Pager pager = (Pager) parcel.readSerializable();
            int i11 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 != i11; i12++) {
                arrayList.add(parcel.readSerializable());
            }
            return new HotItemsBean(pager, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HotItemsBean[] newArray(int i11) {
            return new HotItemsBean[i11];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HotItemsBean(Pager pager, List<? extends Subject> items) {
        Intrinsics.g(pager, "pager");
        Intrinsics.g(items, "items");
        this.pager = pager;
        this.items = items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HotItemsBean copy$default(HotItemsBean hotItemsBean, Pager pager, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            pager = hotItemsBean.pager;
        }
        if ((i11 & 2) != 0) {
            list = hotItemsBean.items;
        }
        return hotItemsBean.copy(pager, list);
    }

    public final Pager component1() {
        return this.pager;
    }

    public final List<Subject> component2() {
        return this.items;
    }

    public final HotItemsBean copy(Pager pager, List<? extends Subject> items) {
        Intrinsics.g(pager, "pager");
        Intrinsics.g(items, "items");
        return new HotItemsBean(pager, items);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HotItemsBean)) {
            return false;
        }
        HotItemsBean hotItemsBean = (HotItemsBean) obj;
        return Intrinsics.b(this.pager, hotItemsBean.pager) && Intrinsics.b(this.items, hotItemsBean.items);
    }

    public final List<Subject> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public int hashCode() {
        return (this.pager.hashCode() * 31) + this.items.hashCode();
    }

    public String toString() {
        return "HotItemsBean(pager=" + this.pager + ", items=" + this.items + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeSerializable(this.pager);
        List<Subject> list = this.items;
        out.writeInt(list.size());
        Iterator<Subject> it = list.iterator();
        while (it.hasNext()) {
            out.writeSerializable(it.next());
        }
    }
}
