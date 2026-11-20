package com.transsion.videodetail.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class MusicLikedRemoteActionBean implements Parcelable {
    public static final Parcelable.Creator<MusicLikedRemoteActionBean> CREATOR = new a();
    private Integer action;
    private MusicLikedRemoteItemBean item;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MusicLikedRemoteActionBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MusicLikedRemoteActionBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MusicLikedRemoteActionBean(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), MusicLikedRemoteItemBean.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MusicLikedRemoteActionBean[] newArray(int i11) {
            return new MusicLikedRemoteActionBean[i11];
        }
    }

    public MusicLikedRemoteActionBean(Integer num, MusicLikedRemoteItemBean item) {
        Intrinsics.g(item, "item");
        this.action = num;
        this.item = item;
    }

    public /* synthetic */ MusicLikedRemoteActionBean(Integer num, MusicLikedRemoteItemBean musicLikedRemoteItemBean, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : num, musicLikedRemoteItemBean);
    }

    public static /* synthetic */ MusicLikedRemoteActionBean copy$default(MusicLikedRemoteActionBean musicLikedRemoteActionBean, Integer num, MusicLikedRemoteItemBean musicLikedRemoteItemBean, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = musicLikedRemoteActionBean.action;
        }
        if ((i11 & 2) != 0) {
            musicLikedRemoteItemBean = musicLikedRemoteActionBean.item;
        }
        return musicLikedRemoteActionBean.copy(num, musicLikedRemoteItemBean);
    }

    public final Integer component1() {
        return this.action;
    }

    public final MusicLikedRemoteItemBean component2() {
        return this.item;
    }

    public final MusicLikedRemoteActionBean copy(Integer num, MusicLikedRemoteItemBean item) {
        Intrinsics.g(item, "item");
        return new MusicLikedRemoteActionBean(num, item);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicLikedRemoteActionBean)) {
            return false;
        }
        MusicLikedRemoteActionBean musicLikedRemoteActionBean = (MusicLikedRemoteActionBean) obj;
        return Intrinsics.b(this.action, musicLikedRemoteActionBean.action) && Intrinsics.b(this.item, musicLikedRemoteActionBean.item);
    }

    public final Integer getAction() {
        return this.action;
    }

    public final MusicLikedRemoteItemBean getItem() {
        return this.item;
    }

    public int hashCode() {
        Integer num = this.action;
        return ((num == null ? 0 : num.hashCode()) * 31) + this.item.hashCode();
    }

    public final void setAction(Integer num) {
        this.action = num;
    }

    public final void setItem(MusicLikedRemoteItemBean musicLikedRemoteItemBean) {
        Intrinsics.g(musicLikedRemoteItemBean, "<set-?>");
        this.item = musicLikedRemoteItemBean;
    }

    public String toString() {
        return "MusicLikedRemoteActionBean(action=" + this.action + ", item=" + this.item + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        int iIntValue;
        Intrinsics.g(out, "out");
        Integer num = this.action;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
        this.item.writeToParcel(out, i11);
    }
}
