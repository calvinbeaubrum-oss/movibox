package com.transsion.moviedetailapi.bean;

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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class PlayListBean implements Parcelable {
    public static final Parcelable.Creator<PlayListBean> CREATOR = new a();
    private List<PlayListItem> items;
    private Pager pager;
    private String version;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<PlayListBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PlayListBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(PlayListItem.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new PlayListBean(arrayList, (Pager) parcel.readSerializable(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PlayListBean[] newArray(int i11) {
            return new PlayListBean[i11];
        }
    }

    public PlayListBean(List<PlayListItem> list, Pager pager, String str) {
        this.items = list;
        this.pager = pager;
        this.version = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayListBean copy$default(PlayListBean playListBean, List list, Pager pager, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = playListBean.items;
        }
        if ((i11 & 2) != 0) {
            pager = playListBean.pager;
        }
        if ((i11 & 4) != 0) {
            str = playListBean.version;
        }
        return playListBean.copy(list, pager, str);
    }

    public final List<PlayListItem> component1() {
        return this.items;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final String component3() {
        return this.version;
    }

    public final PlayListBean copy(List<PlayListItem> list, Pager pager, String str) {
        return new PlayListBean(list, pager, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayListBean)) {
            return false;
        }
        PlayListBean playListBean = (PlayListBean) obj;
        return Intrinsics.b(this.items, playListBean.items) && Intrinsics.b(this.pager, playListBean.pager) && Intrinsics.b(this.version, playListBean.version);
    }

    public final List<PlayListItem> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        List<PlayListItem> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Pager pager = this.pager;
        int iHashCode2 = (iHashCode + (pager == null ? 0 : pager.hashCode())) * 31;
        String str = this.version;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setItems(List<PlayListItem> list) {
        this.items = list;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "PlayListBean(items=" + this.items + ", pager=" + this.pager + ", version=" + this.version + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<PlayListItem> list = this.items;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<PlayListItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        out.writeSerializable(this.pager);
        out.writeString(this.version);
    }
}
