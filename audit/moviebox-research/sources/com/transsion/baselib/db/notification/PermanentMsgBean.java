package com.transsion.baselib.db.notification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
public final class PermanentMsgBean implements Parcelable {
    public static final Parcelable.Creator<PermanentMsgBean> CREATOR = new a();
    private String deeplinkList;
    private String desc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f51076id;
    private String imageList;
    private String messageId;
    private String style;
    private String title;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PermanentMsgBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PermanentMsgBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PermanentMsgBean(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PermanentMsgBean[] newArray(int i11) {
            return new PermanentMsgBean[i11];
        }
    }

    public PermanentMsgBean(int i11, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f51076id = i11;
        this.deeplinkList = str;
        this.desc = str2;
        this.imageList = str3;
        this.messageId = str4;
        this.style = str5;
        this.title = str6;
    }

    public /* synthetic */ PermanentMsgBean(int i11, String str, String str2, String str3, String str4, String str5, String str6, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, str, str2, str3, str4, str5, str6);
    }

    public static /* synthetic */ PermanentMsgBean copy$default(PermanentMsgBean permanentMsgBean, int i11, String str, String str2, String str3, String str4, String str5, String str6, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = permanentMsgBean.f51076id;
        }
        if ((i12 & 2) != 0) {
            str = permanentMsgBean.deeplinkList;
        }
        String str7 = str;
        if ((i12 & 4) != 0) {
            str2 = permanentMsgBean.desc;
        }
        String str8 = str2;
        if ((i12 & 8) != 0) {
            str3 = permanentMsgBean.imageList;
        }
        String str9 = str3;
        if ((i12 & 16) != 0) {
            str4 = permanentMsgBean.messageId;
        }
        String str10 = str4;
        if ((i12 & 32) != 0) {
            str5 = permanentMsgBean.style;
        }
        String str11 = str5;
        if ((i12 & 64) != 0) {
            str6 = permanentMsgBean.title;
        }
        return permanentMsgBean.copy(i11, str7, str8, str9, str10, str11, str6);
    }

    public final int component1() {
        return this.f51076id;
    }

    public final String component2() {
        return this.deeplinkList;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.imageList;
    }

    public final String component5() {
        return this.messageId;
    }

    public final String component6() {
        return this.style;
    }

    public final String component7() {
        return this.title;
    }

    public final PermanentMsgBean copy(int i11, String str, String str2, String str3, String str4, String str5, String str6) {
        return new PermanentMsgBean(i11, str, str2, str3, str4, str5, str6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermanentMsgBean)) {
            return false;
        }
        PermanentMsgBean permanentMsgBean = (PermanentMsgBean) obj;
        return this.f51076id == permanentMsgBean.f51076id && Intrinsics.b(this.deeplinkList, permanentMsgBean.deeplinkList) && Intrinsics.b(this.desc, permanentMsgBean.desc) && Intrinsics.b(this.imageList, permanentMsgBean.imageList) && Intrinsics.b(this.messageId, permanentMsgBean.messageId) && Intrinsics.b(this.style, permanentMsgBean.style) && Intrinsics.b(this.title, permanentMsgBean.title);
    }

    public final String getDeeplinkList() {
        return this.deeplinkList;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getId() {
        return this.f51076id;
    }

    public final String getImageList() {
        return this.imageList;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i11 = this.f51076id * 31;
        String str = this.deeplinkList;
        int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.desc;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageList;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.messageId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.style;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.title;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setDeeplinkList(String str) {
        this.deeplinkList = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setId(int i11) {
        this.f51076id = i11;
    }

    public final void setImageList(String str) {
        this.imageList = str;
    }

    public final void setMessageId(String str) {
        this.messageId = str;
    }

    public final void setStyle(String str) {
        this.style = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "PermanentMsgBean(id=" + this.f51076id + ", deeplinkList=" + this.deeplinkList + ", desc=" + this.desc + ", imageList=" + this.imageList + ", messageId=" + this.messageId + ", style=" + this.style + ", title=" + this.title + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.f51076id);
        out.writeString(this.deeplinkList);
        out.writeString(this.desc);
        out.writeString(this.imageList);
        out.writeString(this.messageId);
        out.writeString(this.style);
        out.writeString(this.title);
    }
}
