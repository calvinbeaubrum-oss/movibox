package com.transsion.postdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
public final class ForYouBean implements Parcelable {
    public static final Parcelable.Creator<ForYouBean> CREATOR = new a();
    private List<? extends Subject> items;
    private Pager pager;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<ForYouBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ForYouBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(parcel.readSerializable());
                }
                arrayList = arrayList2;
            }
            return new ForYouBean(arrayList, (Pager) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ForYouBean[] newArray(int i11) {
            return new ForYouBean[i11];
        }
    }

    public ForYouBean(List<? extends Subject> list, Pager pager) {
        this.items = list;
        this.pager = pager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ForYouBean copy$default(ForYouBean forYouBean, List list, Pager pager, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = forYouBean.items;
        }
        if ((i11 & 2) != 0) {
            pager = forYouBean.pager;
        }
        return forYouBean.copy(list, pager);
    }

    public final List<Subject> component1() {
        return this.items;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final ForYouBean copy(List<? extends Subject> list, Pager pager) {
        return new ForYouBean(list, pager);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ForYouBean)) {
            return false;
        }
        ForYouBean forYouBean = (ForYouBean) obj;
        return Intrinsics.b(this.items, forYouBean.items) && Intrinsics.b(this.pager, forYouBean.pager);
    }

    public final List<Subject> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public int hashCode() {
        List<? extends Subject> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Pager pager = this.pager;
        return iHashCode + (pager != null ? pager.hashCode() : 0);
    }

    public final void setItems(List<? extends Subject> list) {
        this.items = list;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public String toString() {
        return "ForYouBean(items=" + this.items + ", pager=" + this.pager + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<? extends Subject> list = this.items;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<? extends Subject> it = list.iterator();
            while (it.hasNext()) {
                out.writeSerializable(it.next());
            }
        }
        out.writeSerializable(this.pager);
    }
}
