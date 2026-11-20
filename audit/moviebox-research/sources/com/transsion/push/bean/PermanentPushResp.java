package com.transsion.push.bean;

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
public final class PermanentPushResp implements Parcelable {
    public static final Parcelable.Creator<PermanentPushResp> CREATOR = new Creator();
    private final PermanentConfig cfg;
    private final List<PermanentItemBean> items;
    private final PagerConfig pager;
    private final String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<PermanentPushResp> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermanentPushResp createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            ArrayList arrayList = null;
            PagerConfig pagerConfigCreateFromParcel = parcel.readInt() == 0 ? null : PagerConfig.CREATOR.createFromParcel(parcel);
            PermanentConfig permanentConfigCreateFromParcel = parcel.readInt() == 0 ? null : PermanentConfig.CREATOR.createFromParcel(parcel);
            String string = parcel.readString();
            if (parcel.readInt() != 0) {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(PermanentItemBean.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new PermanentPushResp(pagerConfigCreateFromParcel, permanentConfigCreateFromParcel, string, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermanentPushResp[] newArray(int i11) {
            return new PermanentPushResp[i11];
        }
    }

    public PermanentPushResp(PagerConfig pagerConfig, PermanentConfig permanentConfig, String str, List<PermanentItemBean> list) {
        this.pager = pagerConfig;
        this.cfg = permanentConfig;
        this.title = str;
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PermanentPushResp copy$default(PermanentPushResp permanentPushResp, PagerConfig pagerConfig, PermanentConfig permanentConfig, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            pagerConfig = permanentPushResp.pager;
        }
        if ((i11 & 2) != 0) {
            permanentConfig = permanentPushResp.cfg;
        }
        if ((i11 & 4) != 0) {
            str = permanentPushResp.title;
        }
        if ((i11 & 8) != 0) {
            list = permanentPushResp.items;
        }
        return permanentPushResp.copy(pagerConfig, permanentConfig, str, list);
    }

    public final PagerConfig component1() {
        return this.pager;
    }

    public final PermanentConfig component2() {
        return this.cfg;
    }

    public final String component3() {
        return this.title;
    }

    public final List<PermanentItemBean> component4() {
        return this.items;
    }

    public final PermanentPushResp copy(PagerConfig pagerConfig, PermanentConfig permanentConfig, String str, List<PermanentItemBean> list) {
        return new PermanentPushResp(pagerConfig, permanentConfig, str, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermanentPushResp)) {
            return false;
        }
        PermanentPushResp permanentPushResp = (PermanentPushResp) obj;
        return Intrinsics.b(this.pager, permanentPushResp.pager) && Intrinsics.b(this.cfg, permanentPushResp.cfg) && Intrinsics.b(this.title, permanentPushResp.title) && Intrinsics.b(this.items, permanentPushResp.items);
    }

    public final PermanentConfig getCfg() {
        return this.cfg;
    }

    public final List<PermanentItemBean> getItems() {
        return this.items;
    }

    public final PagerConfig getPager() {
        return this.pager;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        PagerConfig pagerConfig = this.pager;
        int iHashCode = (pagerConfig == null ? 0 : pagerConfig.hashCode()) * 31;
        PermanentConfig permanentConfig = this.cfg;
        int iHashCode2 = (iHashCode + (permanentConfig == null ? 0 : permanentConfig.hashCode())) * 31;
        String str = this.title;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<PermanentItemBean> list = this.items;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "PermanentPushResp(pager=" + this.pager + ", cfg=" + this.cfg + ", title=" + this.title + ", items=" + this.items + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        PagerConfig pagerConfig = this.pager;
        if (pagerConfig == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            pagerConfig.writeToParcel(out, i11);
        }
        PermanentConfig permanentConfig = this.cfg;
        if (permanentConfig == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            permanentConfig.writeToParcel(out, i11);
        }
        out.writeString(this.title);
        List<PermanentItemBean> list = this.items;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        Iterator<PermanentItemBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i11);
        }
    }
}
