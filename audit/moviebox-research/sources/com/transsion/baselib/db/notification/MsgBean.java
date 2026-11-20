package com.transsion.baselib.db.notification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Settings;

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
public final class MsgBean implements Parcelable {
    public static final Parcelable.Creator<MsgBean> CREATOR = new a();
    private boolean builtIn;
    private String deeplink;
    private String desc;
    private boolean forceShow;
    private boolean hasScreenOn;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f51075id;
    private String imageList;
    private boolean isFloat;
    private boolean isPermanent;
    private boolean isRefresh;
    private String messageId;
    private int msgStatus;
    private int permanentMsgPosition;
    private int permanentMsgSize;
    private int permanentMsgStatus;
    private Long receiveTime;
    private Long showTime;
    private String source;
    private String style;
    private String title;
    private int triggerSource;
    private String type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MsgBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MsgBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MsgBean(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MsgBean[] newArray(int i11) {
            return new MsgBean[i11];
        }
    }

    public MsgBean() {
        this(0, null, null, null, null, null, null, null, null, null, 0, null, false, false, false, 0, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
    }

    public MsgBean(int i11, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long l11, int i12, Long l12, boolean z11, boolean z12, boolean z13, int i13) {
        this.f51075id = i11;
        this.deeplink = str;
        this.desc = str2;
        this.imageList = str3;
        this.messageId = str4;
        this.source = str5;
        this.style = str6;
        this.title = str7;
        this.type = str8;
        this.receiveTime = l11;
        this.msgStatus = i12;
        this.showTime = l12;
        this.forceShow = z11;
        this.hasScreenOn = z12;
        this.builtIn = z13;
        this.permanentMsgStatus = i13;
        this.permanentMsgPosition = 1;
        this.permanentMsgSize = 1;
    }

    public /* synthetic */ MsgBean(int i11, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long l11, int i12, Long l12, boolean z11, boolean z12, boolean z13, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? 0 : i11, (i14 & 2) != 0 ? null : str, (i14 & 4) != 0 ? null : str2, (i14 & 8) != 0 ? null : str3, (i14 & 16) != 0 ? null : str4, (i14 & 32) != 0 ? null : str5, (i14 & 64) != 0 ? null : str6, (i14 & 128) != 0 ? null : str7, (i14 & 256) == 0 ? str8 : null, (i14 & 512) != 0 ? 0L : l11, (i14 & 1024) != 0 ? 0 : i12, (i14 & 2048) != 0 ? 0L : l12, (i14 & 4096) != 0 ? false : z11, (i14 & 8192) != 0 ? false : z12, (i14 & 16384) != 0 ? false : z13, (i14 & 32768) != 0 ? 0 : i13);
    }

    public static /* synthetic */ void getPermanentMsgPosition$annotations() {
    }

    public static /* synthetic */ void getPermanentMsgSize$annotations() {
    }

    public static /* synthetic */ void getTriggerSource$annotations() {
    }

    public static /* synthetic */ void isFloat$annotations() {
    }

    public static /* synthetic */ void isPermanent$annotations() {
    }

    public static /* synthetic */ void isRefresh$annotations() {
    }

    public final int component1() {
        return this.f51075id;
    }

    public final Long component10() {
        return this.receiveTime;
    }

    public final int component11() {
        return this.msgStatus;
    }

    public final Long component12() {
        return this.showTime;
    }

    public final boolean component13() {
        return this.forceShow;
    }

    public final boolean component14() {
        return this.hasScreenOn;
    }

    public final boolean component15() {
        return this.builtIn;
    }

    public final int component16() {
        return this.permanentMsgStatus;
    }

    public final String component2() {
        return this.deeplink;
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
        return this.source;
    }

    public final String component7() {
        return this.style;
    }

    public final String component8() {
        return this.title;
    }

    public final String component9() {
        return this.type;
    }

    public final MsgBean copy(int i11, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long l11, int i12, Long l12, boolean z11, boolean z12, boolean z13, int i13) {
        return new MsgBean(i11, str, str2, str3, str4, str5, str6, str7, str8, l11, i12, l12, z11, z12, z13, i13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MsgBean)) {
            return false;
        }
        MsgBean msgBean = (MsgBean) obj;
        return this.f51075id == msgBean.f51075id && Intrinsics.b(this.deeplink, msgBean.deeplink) && Intrinsics.b(this.desc, msgBean.desc) && Intrinsics.b(this.imageList, msgBean.imageList) && Intrinsics.b(this.messageId, msgBean.messageId) && Intrinsics.b(this.source, msgBean.source) && Intrinsics.b(this.style, msgBean.style) && Intrinsics.b(this.title, msgBean.title) && Intrinsics.b(this.type, msgBean.type) && Intrinsics.b(this.receiveTime, msgBean.receiveTime) && this.msgStatus == msgBean.msgStatus && Intrinsics.b(this.showTime, msgBean.showTime) && this.forceShow == msgBean.forceShow && this.hasScreenOn == msgBean.hasScreenOn && this.builtIn == msgBean.builtIn && this.permanentMsgStatus == msgBean.permanentMsgStatus;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getForceShow() {
        return this.forceShow;
    }

    public final boolean getHasScreenOn() {
        return this.hasScreenOn;
    }

    public final int getId() {
        return this.f51075id;
    }

    public final String getImageList() {
        return this.imageList;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final int getMsgStatus() {
        return this.msgStatus;
    }

    public final int getPermanentMsgPosition() {
        return this.permanentMsgPosition;
    }

    public final int getPermanentMsgSize() {
        return this.permanentMsgSize;
    }

    public final int getPermanentMsgStatus() {
        return this.permanentMsgStatus;
    }

    public final Long getReceiveTime() {
        return this.receiveTime;
    }

    public final Long getShowTime() {
        return this.showTime;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTriggerSource() {
        return this.triggerSource;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32, types: [int] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int i11 = this.f51075id * 31;
        String str = this.deeplink;
        int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.desc;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageList;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.messageId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.source;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.style;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.title;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.type;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Long l11 = this.receiveTime;
        int iHashCode9 = (((iHashCode8 + (l11 == null ? 0 : l11.hashCode())) * 31) + this.msgStatus) * 31;
        Long l12 = this.showTime;
        int iHashCode10 = (iHashCode9 + (l12 != null ? l12.hashCode() : 0)) * 31;
        boolean z11 = this.forceShow;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i12 = (iHashCode10 + r11) * 31;
        boolean z12 = this.hasScreenOn;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i13 = (i12 + r12) * 31;
        boolean z13 = this.builtIn;
        return ((i13 + (z13 ? 1 : z13)) * 31) + this.permanentMsgStatus;
    }

    public final boolean isFloat() {
        return this.isFloat;
    }

    public final boolean isPermanent() {
        return this.isPermanent;
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    public final void setBuiltIn(boolean z11) {
        this.builtIn = z11;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setFloat(boolean z11) {
        this.isFloat = z11;
    }

    public final void setForceShow(boolean z11) {
        this.forceShow = z11;
    }

    public final void setHasScreenOn(boolean z11) {
        this.hasScreenOn = z11;
    }

    public final void setId(int i11) {
        this.f51075id = i11;
    }

    public final void setImageList(String str) {
        this.imageList = str;
    }

    public final void setMessageId(String str) {
        this.messageId = str;
    }

    public final void setMsgStatus(int i11) {
        this.msgStatus = i11;
    }

    public final void setPermanent(boolean z11) {
        this.isPermanent = z11;
    }

    public final void setPermanentMsgPosition(int i11) {
        this.permanentMsgPosition = i11;
    }

    public final void setPermanentMsgSize(int i11) {
        this.permanentMsgSize = i11;
    }

    public final void setPermanentMsgStatus(int i11) {
        this.permanentMsgStatus = i11;
    }

    public final void setReceiveTime(Long l11) {
        this.receiveTime = l11;
    }

    public final void setRefresh(boolean z11) {
        this.isRefresh = z11;
    }

    public final void setShowTime(Long l11) {
        this.showTime = l11;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final void setStyle(String str) {
        this.style = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTriggerSource(int i11) {
        this.triggerSource = i11;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "MsgBean(id=" + this.f51075id + ", deeplink=" + this.deeplink + ", desc=" + this.desc + ", imageList=" + this.imageList + ", messageId=" + this.messageId + ", source=" + this.source + ", style=" + this.style + ", title=" + this.title + ", type=" + this.type + ", receiveTime=" + this.receiveTime + ", msgStatus=" + this.msgStatus + ", showTime=" + this.showTime + ", forceShow=" + this.forceShow + ", hasScreenOn=" + this.hasScreenOn + ", builtIn=" + this.builtIn + ", permanentMsgStatus=" + this.permanentMsgStatus + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.f51075id);
        out.writeString(this.deeplink);
        out.writeString(this.desc);
        out.writeString(this.imageList);
        out.writeString(this.messageId);
        out.writeString(this.source);
        out.writeString(this.style);
        out.writeString(this.title);
        out.writeString(this.type);
        Long l11 = this.receiveTime;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
        out.writeInt(this.msgStatus);
        Long l12 = this.showTime;
        if (l12 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l12.longValue());
        }
        out.writeInt(this.forceShow ? 1 : 0);
        out.writeInt(this.hasScreenOn ? 1 : 0);
        out.writeInt(this.builtIn ? 1 : 0);
        out.writeInt(this.permanentMsgStatus);
    }
}
