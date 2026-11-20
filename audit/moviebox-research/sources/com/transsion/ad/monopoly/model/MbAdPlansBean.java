package com.transsion.ad.monopoly.model;

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
public final class MbAdPlansBean implements Parcelable {
    public static final Parcelable.Creator<MbAdPlansBean> CREATOR = new a();
    private final List<AdPlans> adPlans;
    private final String adSceneConfigData;
    private CtxAttributeConfig ctxAttributeConfig;
    private String genre;
    private final String version;
    private final String versionAdScene;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MbAdPlansBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MbAdPlansBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList.add(AdPlans.CREATOR.createFromParcel(parcel));
                }
            }
            return new MbAdPlansBean(string, arrayList, parcel.readInt() != 0 ? CtxAttributeConfig.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MbAdPlansBean[] newArray(int i11) {
            return new MbAdPlansBean[i11];
        }
    }

    public MbAdPlansBean() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MbAdPlansBean(String str, List<AdPlans> list, CtxAttributeConfig ctxAttributeConfig, String str2, String str3, String str4) {
        this.version = str;
        this.adPlans = list;
        this.ctxAttributeConfig = ctxAttributeConfig;
        this.genre = str2;
        this.versionAdScene = str3;
        this.adSceneConfigData = str4;
    }

    public /* synthetic */ MbAdPlansBean(String str, List list, CtxAttributeConfig ctxAttributeConfig, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : list, (i11 & 4) != 0 ? null : ctxAttributeConfig, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? null : str4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MbAdPlansBean copy$default(MbAdPlansBean mbAdPlansBean, String str, List list, CtxAttributeConfig ctxAttributeConfig, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = mbAdPlansBean.version;
        }
        if ((i11 & 2) != 0) {
            list = mbAdPlansBean.adPlans;
        }
        List list2 = list;
        if ((i11 & 4) != 0) {
            ctxAttributeConfig = mbAdPlansBean.ctxAttributeConfig;
        }
        CtxAttributeConfig ctxAttributeConfig2 = ctxAttributeConfig;
        if ((i11 & 8) != 0) {
            str2 = mbAdPlansBean.genre;
        }
        String str5 = str2;
        if ((i11 & 16) != 0) {
            str3 = mbAdPlansBean.versionAdScene;
        }
        String str6 = str3;
        if ((i11 & 32) != 0) {
            str4 = mbAdPlansBean.adSceneConfigData;
        }
        return mbAdPlansBean.copy(str, list2, ctxAttributeConfig2, str5, str6, str4);
    }

    public final String component1() {
        return this.version;
    }

    public final List<AdPlans> component2() {
        return this.adPlans;
    }

    public final CtxAttributeConfig component3() {
        return this.ctxAttributeConfig;
    }

    public final String component4() {
        return this.genre;
    }

    public final String component5() {
        return this.versionAdScene;
    }

    public final String component6() {
        return this.adSceneConfigData;
    }

    public final MbAdPlansBean copy(String str, List<AdPlans> list, CtxAttributeConfig ctxAttributeConfig, String str2, String str3, String str4) {
        return new MbAdPlansBean(str, list, ctxAttributeConfig, str2, str3, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MbAdPlansBean)) {
            return false;
        }
        MbAdPlansBean mbAdPlansBean = (MbAdPlansBean) obj;
        return Intrinsics.b(this.version, mbAdPlansBean.version) && Intrinsics.b(this.adPlans, mbAdPlansBean.adPlans) && Intrinsics.b(this.ctxAttributeConfig, mbAdPlansBean.ctxAttributeConfig) && Intrinsics.b(this.genre, mbAdPlansBean.genre) && Intrinsics.b(this.versionAdScene, mbAdPlansBean.versionAdScene) && Intrinsics.b(this.adSceneConfigData, mbAdPlansBean.adSceneConfigData);
    }

    public final List<AdPlans> getAdPlans() {
        return this.adPlans;
    }

    public final String getAdSceneConfigData() {
        return this.adSceneConfigData;
    }

    public final CtxAttributeConfig getCtxAttributeConfig() {
        return this.ctxAttributeConfig;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getVersionAdScene() {
        return this.versionAdScene;
    }

    public int hashCode() {
        String str = this.version;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<AdPlans> list = this.adPlans;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        CtxAttributeConfig ctxAttributeConfig = this.ctxAttributeConfig;
        int iHashCode3 = (iHashCode2 + (ctxAttributeConfig == null ? 0 : ctxAttributeConfig.hashCode())) * 31;
        String str2 = this.genre;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.versionAdScene;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.adSceneConfigData;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setCtxAttributeConfig(CtxAttributeConfig ctxAttributeConfig) {
        this.ctxAttributeConfig = ctxAttributeConfig;
    }

    public final void setGenre(String str) {
        this.genre = str;
    }

    public String toString() {
        return "MbAdPlansBean(version=" + this.version + ", adPlans=" + this.adPlans + ", ctxAttributeConfig=" + this.ctxAttributeConfig + ", genre=" + this.genre + ", versionAdScene=" + this.versionAdScene + ", adSceneConfigData=" + this.adSceneConfigData + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.version);
        List<AdPlans> list = this.adPlans;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<AdPlans> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i11);
            }
        }
        CtxAttributeConfig ctxAttributeConfig = this.ctxAttributeConfig;
        if (ctxAttributeConfig == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            ctxAttributeConfig.writeToParcel(out, i11);
        }
        out.writeString(this.genre);
        out.writeString(this.versionAdScene);
        out.writeString(this.adSceneConfigData);
    }
}
