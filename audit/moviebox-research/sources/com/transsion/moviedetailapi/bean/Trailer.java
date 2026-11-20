package com.transsion.moviedetailapi.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Trailer implements Serializable {

    @SerializedName("cover")
    private Cover cover;
    private String musicName;
    private String subjectId;
    private int subjectType;

    @SerializedName(alternate = {"VideoAddress"}, value = "videoAddress")
    private PreVideoAddress videoAddress;

    public Trailer() {
        this(0, null, null, null, null, 31, null);
    }

    public Trailer(int i11, PreVideoAddress preVideoAddress, Cover cover, String str, String str2) {
        this.subjectType = i11;
        this.videoAddress = preVideoAddress;
        this.cover = cover;
        this.subjectId = str;
        this.musicName = str2;
    }

    public /* synthetic */ Trailer(int i11, PreVideoAddress preVideoAddress, Cover cover, String str, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, (i12 & 2) != 0 ? null : preVideoAddress, (i12 & 4) == 0 ? cover : null, (i12 & 8) != 0 ? "" : str, (i12 & 16) != 0 ? "" : str2);
    }

    public static /* synthetic */ Trailer copy$default(Trailer trailer, int i11, PreVideoAddress preVideoAddress, Cover cover, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = trailer.subjectType;
        }
        if ((i12 & 2) != 0) {
            preVideoAddress = trailer.videoAddress;
        }
        PreVideoAddress preVideoAddress2 = preVideoAddress;
        if ((i12 & 4) != 0) {
            cover = trailer.cover;
        }
        Cover cover2 = cover;
        if ((i12 & 8) != 0) {
            str = trailer.subjectId;
        }
        String str3 = str;
        if ((i12 & 16) != 0) {
            str2 = trailer.musicName;
        }
        return trailer.copy(i11, preVideoAddress2, cover2, str3, str2);
    }

    public final int component1() {
        return this.subjectType;
    }

    public final PreVideoAddress component2() {
        return this.videoAddress;
    }

    public final Cover component3() {
        return this.cover;
    }

    public final String component4() {
        return this.subjectId;
    }

    public final String component5() {
        return this.musicName;
    }

    public final Trailer copy(int i11, PreVideoAddress preVideoAddress, Cover cover, String str, String str2) {
        return new Trailer(i11, preVideoAddress, cover, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trailer)) {
            return false;
        }
        Trailer trailer = (Trailer) obj;
        return this.subjectType == trailer.subjectType && Intrinsics.b(this.videoAddress, trailer.videoAddress) && Intrinsics.b(this.cover, trailer.cover) && Intrinsics.b(this.subjectId, trailer.subjectId) && Intrinsics.b(this.musicName, trailer.musicName);
    }

    public final Cover getCover() {
        return this.cover;
    }

    public final String getMusicName() {
        return this.musicName;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final int getSubjectType() {
        return this.subjectType;
    }

    public final PreVideoAddress getVideoAddress() {
        return this.videoAddress;
    }

    public int hashCode() {
        int i11 = this.subjectType * 31;
        PreVideoAddress preVideoAddress = this.videoAddress;
        int iHashCode = (i11 + (preVideoAddress == null ? 0 : preVideoAddress.hashCode())) * 31;
        Cover cover = this.cover;
        int iHashCode2 = (iHashCode + (cover == null ? 0 : cover.hashCode())) * 31;
        String str = this.subjectId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.musicName;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setCover(Cover cover) {
        this.cover = cover;
    }

    public final void setMusicName(String str) {
        this.musicName = str;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectType(int i11) {
        this.subjectType = i11;
    }

    public final void setVideoAddress(PreVideoAddress preVideoAddress) {
        this.videoAddress = preVideoAddress;
    }

    public String toString() {
        return "Trailer(subjectType=" + this.subjectType + ", videoAddress=" + this.videoAddress + ", cover=" + this.cover + ", subjectId=" + this.subjectId + ", musicName=" + this.musicName + ")";
    }
}
