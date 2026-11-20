package com.transsion.baselib.db.notification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
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
public final class PermanentMsgResp implements Parcelable {
    public static final Parcelable.Creator<PermanentMsgResp> CREATOR = new a();
    private Boolean enable;
    private List<PermanentMsgBean> items;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PermanentMsgResp> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PermanentMsgResp createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            ArrayList arrayList = null;
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() != 0) {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(parcel.readInt() == 0 ? null : PermanentMsgBean.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new PermanentMsgResp(boolValueOf, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PermanentMsgResp[] newArray(int i11) {
            return new PermanentMsgResp[i11];
        }
    }

    public PermanentMsgResp(Boolean bool, List<PermanentMsgBean> list) {
        this.enable = bool;
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PermanentMsgResp copy$default(PermanentMsgResp permanentMsgResp, Boolean bool, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = permanentMsgResp.enable;
        }
        if ((i11 & 2) != 0) {
            list = permanentMsgResp.items;
        }
        return permanentMsgResp.copy(bool, list);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final List<PermanentMsgBean> component2() {
        return this.items;
    }

    public final PermanentMsgResp copy(Boolean bool, List<PermanentMsgBean> list) {
        return new PermanentMsgResp(bool, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermanentMsgResp)) {
            return false;
        }
        PermanentMsgResp permanentMsgResp = (PermanentMsgResp) obj;
        return Intrinsics.b(this.enable, permanentMsgResp.enable) && Intrinsics.b(this.items, permanentMsgResp.items);
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final List<PermanentMsgBean> getItems() {
        return this.items;
    }

    public int hashCode() {
        Boolean bool = this.enable;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        List<PermanentMsgBean> list = this.items;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setEnable(Boolean bool) {
        this.enable = bool;
    }

    public final void setItems(List<PermanentMsgBean> list) {
        this.items = list;
    }

    public String toString() {
        return "PermanentMsgResp(enable=" + this.enable + ", items=" + this.items + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        Boolean bool = this.enable;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        List<PermanentMsgBean> list = this.items;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        for (PermanentMsgBean permanentMsgBean : list) {
            if (permanentMsgBean == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                permanentMsgBean.writeToParcel(out, i11);
            }
        }
    }
}
