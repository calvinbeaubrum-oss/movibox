package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.moviedetailapi.bean.CategoryItemBean;
import com.transsion.moviedetailapi.bean.Pager;
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
public final class CategoryBean implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<CategoryBean> CREATOR = new a();
    private String desc;
    private List<CategoryItemBean> list;
    private String ops;
    private Pager pager;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CategoryBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CategoryBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(parcel.readParcelable(CategoryBean.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new CategoryBean(string, arrayList, (Pager) parcel.readSerializable(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CategoryBean[] newArray(int i11) {
            return new CategoryBean[i11];
        }
    }

    public CategoryBean(String str, List<CategoryItemBean> list, Pager pager, String ops) {
        Intrinsics.g(ops, "ops");
        this.desc = str;
        this.list = list;
        this.pager = pager;
        this.ops = ops;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryBean copy$default(CategoryBean categoryBean, String str, List list, Pager pager, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = categoryBean.desc;
        }
        if ((i11 & 2) != 0) {
            list = categoryBean.list;
        }
        if ((i11 & 4) != 0) {
            pager = categoryBean.pager;
        }
        if ((i11 & 8) != 0) {
            str2 = categoryBean.ops;
        }
        return categoryBean.copy(str, list, pager, str2);
    }

    public final String component1() {
        return this.desc;
    }

    public final List<CategoryItemBean> component2() {
        return this.list;
    }

    public final Pager component3() {
        return this.pager;
    }

    public final String component4() {
        return this.ops;
    }

    public final CategoryBean copy(String str, List<CategoryItemBean> list, Pager pager, String ops) {
        Intrinsics.g(ops, "ops");
        return new CategoryBean(str, list, pager, ops);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryBean)) {
            return false;
        }
        CategoryBean categoryBean = (CategoryBean) obj;
        return Intrinsics.b(this.desc, categoryBean.desc) && Intrinsics.b(this.list, categoryBean.list) && Intrinsics.b(this.pager, categoryBean.pager) && Intrinsics.b(this.ops, categoryBean.ops);
    }

    public final String getDesc() {
        return this.desc;
    }

    public final List<CategoryItemBean> getList() {
        return this.list;
    }

    public final String getOps() {
        return this.ops;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public int hashCode() {
        String str = this.desc;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<CategoryItemBean> list = this.list;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Pager pager = this.pager;
        return ((iHashCode2 + (pager != null ? pager.hashCode() : 0)) * 31) + this.ops.hashCode();
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setList(List<CategoryItemBean> list) {
        this.list = list;
    }

    public final void setOps(String str) {
        Intrinsics.g(str, "<set-?>");
        this.ops = str;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public String toString() {
        return "CategoryBean(desc=" + this.desc + ", list=" + this.list + ", pager=" + this.pager + ", ops=" + this.ops + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.desc);
        List<CategoryItemBean> list = this.list;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<CategoryItemBean> it = list.iterator();
            while (it.hasNext()) {
                out.writeParcelable(it.next(), i11);
            }
        }
        out.writeSerializable(this.pager);
        out.writeString(this.ops);
    }
}
