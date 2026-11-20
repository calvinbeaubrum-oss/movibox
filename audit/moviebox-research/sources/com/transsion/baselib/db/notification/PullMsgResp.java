package com.transsion.baselib.db.notification;

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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class PullMsgResp implements Parcelable {
    public static final Parcelable.Creator<PullMsgResp> CREATOR = new a();
    private MsgConfig config;
    private List<MsgBean> items;
    private List<MsgBean> seekingItems;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PullMsgResp> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PullMsgResp createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(parcel.readInt() == 0 ? null : MsgBean.CREATOR.createFromParcel(parcel));
                }
            }
            MsgConfig msgConfigCreateFromParcel = parcel.readInt() == 0 ? null : MsgConfig.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int i13 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList3.add(parcel.readInt() == 0 ? null : MsgBean.CREATOR.createFromParcel(parcel));
                }
                arrayList2 = arrayList3;
            }
            return new PullMsgResp(arrayList, msgConfigCreateFromParcel, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PullMsgResp[] newArray(int i11) {
            return new PullMsgResp[i11];
        }
    }

    public PullMsgResp(List<MsgBean> list, MsgConfig msgConfig, List<MsgBean> list2) {
        this.items = list;
        this.config = msgConfig;
        this.seekingItems = list2;
    }

    public /* synthetic */ PullMsgResp(List list, MsgConfig msgConfig, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, msgConfig, (i11 & 4) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PullMsgResp copy$default(PullMsgResp pullMsgResp, List list, MsgConfig msgConfig, List list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = pullMsgResp.items;
        }
        if ((i11 & 2) != 0) {
            msgConfig = pullMsgResp.config;
        }
        if ((i11 & 4) != 0) {
            list2 = pullMsgResp.seekingItems;
        }
        return pullMsgResp.copy(list, msgConfig, list2);
    }

    public final List<MsgBean> component1() {
        return this.items;
    }

    public final MsgConfig component2() {
        return this.config;
    }

    public final List<MsgBean> component3() {
        return this.seekingItems;
    }

    public final PullMsgResp copy(List<MsgBean> list, MsgConfig msgConfig, List<MsgBean> list2) {
        return new PullMsgResp(list, msgConfig, list2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PullMsgResp)) {
            return false;
        }
        PullMsgResp pullMsgResp = (PullMsgResp) obj;
        return Intrinsics.b(this.items, pullMsgResp.items) && Intrinsics.b(this.config, pullMsgResp.config) && Intrinsics.b(this.seekingItems, pullMsgResp.seekingItems);
    }

    public final MsgConfig getConfig() {
        return this.config;
    }

    public final List<MsgBean> getItems() {
        return this.items;
    }

    public final List<MsgBean> getSeekingItems() {
        return this.seekingItems;
    }

    public int hashCode() {
        List<MsgBean> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        MsgConfig msgConfig = this.config;
        int iHashCode2 = (iHashCode + (msgConfig == null ? 0 : msgConfig.hashCode())) * 31;
        List<MsgBean> list2 = this.seekingItems;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setConfig(MsgConfig msgConfig) {
        this.config = msgConfig;
    }

    public final void setItems(List<MsgBean> list) {
        this.items = list;
    }

    public final void setSeekingItems(List<MsgBean> list) {
        this.seekingItems = list;
    }

    public String toString() {
        return "PullMsgResp(items=" + this.items + ", config=" + this.config + ", seekingItems=" + this.seekingItems + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<MsgBean> list = this.items;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            for (MsgBean msgBean : list) {
                if (msgBean == null) {
                    out.writeInt(0);
                } else {
                    out.writeInt(1);
                    msgBean.writeToParcel(out, i11);
                }
            }
        }
        MsgConfig msgConfig = this.config;
        if (msgConfig == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            msgConfig.writeToParcel(out, i11);
        }
        List<MsgBean> list2 = this.seekingItems;
        if (list2 == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list2.size());
        for (MsgBean msgBean2 : list2) {
            if (msgBean2 == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                msgBean2.writeToParcel(out, i11);
            }
        }
    }
}
