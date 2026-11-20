package com.transsnet.downloader.bean;

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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class StartRequestBean implements Parcelable {
    public static final Parcelable.Creator<StartRequestBean> CREATOR = new a();
    private List<StartlDownloadBean> items;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<StartRequestBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final StartRequestBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(StartlDownloadBean.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new StartRequestBean(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final StartRequestBean[] newArray(int i11) {
            return new StartRequestBean[i11];
        }
    }

    public StartRequestBean(List<StartlDownloadBean> list) {
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StartRequestBean copy$default(StartRequestBean startRequestBean, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = startRequestBean.items;
        }
        return startRequestBean.copy(list);
    }

    public final List<StartlDownloadBean> component1() {
        return this.items;
    }

    public final StartRequestBean copy(List<StartlDownloadBean> list) {
        return new StartRequestBean(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StartRequestBean) && Intrinsics.b(this.items, ((StartRequestBean) obj).items);
    }

    public final List<StartlDownloadBean> getItems() {
        return this.items;
    }

    public int hashCode() {
        List<StartlDownloadBean> list = this.items;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setItems(List<StartlDownloadBean> list) {
        this.items = list;
    }

    public String toString() {
        return "StartRequestBean(items=" + this.items + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<StartlDownloadBean> list = this.items;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        Iterator<StartlDownloadBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i11);
        }
    }
}
