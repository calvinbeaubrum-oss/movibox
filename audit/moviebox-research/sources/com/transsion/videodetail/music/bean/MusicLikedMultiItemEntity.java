package com.transsion.videodetail.music.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.android.arouter.utils.d;
import com.transsion.baselib.db.music.MusicLikedDbBean;
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
public final class MusicLikedMultiItemEntity implements e9.a, Parcelable {
    public static final int ITEM_TYPE_AD = 2;
    public static final int ITEM_TYPE_MUSIC_BEAN = 1;
    private final MusicLikedDbBean musicLikedDbBean;
    private MusicLikedItemStateEnum state;
    private final int type;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<MusicLikedMultiItemEntity> CREATOR = new b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Parcelable.Creator<MusicLikedMultiItemEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MusicLikedMultiItemEntity createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MusicLikedMultiItemEntity((MusicLikedDbBean) parcel.readParcelable(MusicLikedMultiItemEntity.class.getClassLoader()), parcel.readInt(), MusicLikedItemStateEnum.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MusicLikedMultiItemEntity[] newArray(int i11) {
            return new MusicLikedMultiItemEntity[i11];
        }
    }

    public MusicLikedMultiItemEntity() {
        this(null, 0, null, 7, null);
    }

    public MusicLikedMultiItemEntity(MusicLikedDbBean musicLikedDbBean, int i11, MusicLikedItemStateEnum state) {
        Intrinsics.g(state, "state");
        this.musicLikedDbBean = musicLikedDbBean;
        this.type = i11;
        this.state = state;
    }

    public /* synthetic */ MusicLikedMultiItemEntity(MusicLikedDbBean musicLikedDbBean, int i11, MusicLikedItemStateEnum musicLikedItemStateEnum, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? null : musicLikedDbBean, (i12 & 2) != 0 ? 1 : i11, (i12 & 4) != 0 ? MusicLikedItemStateEnum.NONE : musicLikedItemStateEnum);
    }

    public static /* synthetic */ MusicLikedMultiItemEntity copy$default(MusicLikedMultiItemEntity musicLikedMultiItemEntity, MusicLikedDbBean musicLikedDbBean, int i11, MusicLikedItemStateEnum musicLikedItemStateEnum, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            musicLikedDbBean = musicLikedMultiItemEntity.musicLikedDbBean;
        }
        if ((i12 & 2) != 0) {
            i11 = musicLikedMultiItemEntity.type;
        }
        if ((i12 & 4) != 0) {
            musicLikedItemStateEnum = musicLikedMultiItemEntity.state;
        }
        return musicLikedMultiItemEntity.copy(musicLikedDbBean, i11, musicLikedItemStateEnum);
    }

    public final MusicLikedDbBean component1() {
        return this.musicLikedDbBean;
    }

    public final int component2() {
        return this.type;
    }

    public final MusicLikedItemStateEnum component3() {
        return this.state;
    }

    public final MusicLikedMultiItemEntity copy(MusicLikedDbBean musicLikedDbBean, int i11, MusicLikedItemStateEnum state) {
        Intrinsics.g(state, "state");
        return new MusicLikedMultiItemEntity(musicLikedDbBean, i11, state);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicLikedMultiItemEntity)) {
            return false;
        }
        MusicLikedMultiItemEntity musicLikedMultiItemEntity = (MusicLikedMultiItemEntity) obj;
        return Intrinsics.b(this.musicLikedDbBean, musicLikedMultiItemEntity.musicLikedDbBean) && this.type == musicLikedMultiItemEntity.type && this.state == musicLikedMultiItemEntity.state;
    }

    @Override // e9.a
    public int getItemType() {
        return this.type;
    }

    public final MusicLikedDbBean getMusicLikedDbBean() {
        return this.musicLikedDbBean;
    }

    public final MusicLikedItemStateEnum getState() {
        return this.state;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        MusicLikedDbBean musicLikedDbBean = this.musicLikedDbBean;
        return ((((musicLikedDbBean == null ? 0 : musicLikedDbBean.hashCode()) * 31) + this.type) * 31) + this.state.hashCode();
    }

    public final boolean isDownloaded() {
        MusicLikedDbBean musicLikedDbBean = this.musicLikedDbBean;
        return !d.b(musicLikedDbBean != null ? musicLikedDbBean.getPath() : null);
    }

    public final void setState(MusicLikedItemStateEnum musicLikedItemStateEnum) {
        Intrinsics.g(musicLikedItemStateEnum, "<set-?>");
        this.state = musicLikedItemStateEnum;
    }

    public String toString() {
        return "MusicLikedMultiItemEntity(musicLikedDbBean=" + this.musicLikedDbBean + ", type=" + this.type + ", state=" + this.state + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeParcelable(this.musicLikedDbBean, i11);
        out.writeInt(this.type);
        out.writeString(this.state.name());
    }
}
