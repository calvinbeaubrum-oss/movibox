package com.transsion.subtitle_download.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
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
public final class SubtitleListBean implements Parcelable, Serializable {
    public static final Parcelable.Creator<SubtitleListBean> CREATOR = new a();

    @SerializedName("extCaptions")
    private List<SubtitleItem> extSubtitle;

    @SerializedName("subjectId")
    private String subjectId;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<SubtitleListBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SubtitleListBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            String string = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(SubtitleItem.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new SubtitleListBean(string, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SubtitleListBean[] newArray(int i11) {
            return new SubtitleListBean[i11];
        }
    }

    public SubtitleListBean(String str, List<SubtitleItem> list) {
        this.subjectId = str;
        this.extSubtitle = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubtitleListBean copy$default(SubtitleListBean subtitleListBean, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subtitleListBean.subjectId;
        }
        if ((i11 & 2) != 0) {
            list = subtitleListBean.extSubtitle;
        }
        return subtitleListBean.copy(str, list);
    }

    public final String component1() {
        return this.subjectId;
    }

    public final List<SubtitleItem> component2() {
        return this.extSubtitle;
    }

    public final SubtitleListBean copy(String str, List<SubtitleItem> list) {
        return new SubtitleListBean(str, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubtitleListBean)) {
            return false;
        }
        SubtitleListBean subtitleListBean = (SubtitleListBean) obj;
        return Intrinsics.b(this.subjectId, subtitleListBean.subjectId) && Intrinsics.b(this.extSubtitle, subtitleListBean.extSubtitle);
    }

    public final List<SubtitleItem> getExtSubtitle() {
        return this.extSubtitle;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public int hashCode() {
        String str = this.subjectId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<SubtitleItem> list = this.extSubtitle;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setExtSubtitle(List<SubtitleItem> list) {
        this.extSubtitle = list;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public String toString() {
        return "SubtitleListBean(subjectId=" + this.subjectId + ", extSubtitle=" + this.extSubtitle + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.subjectId);
        List<SubtitleItem> list = this.extSubtitle;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        Iterator<SubtitleItem> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i11);
        }
    }
}
