package com.cloud.hisavana.sdk.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class VastClick implements Parcelable {
    public static final Parcelable.Creator<VastClick> CREATOR = new Creator();
    private List<String> clickTrack;
    private String videoClick;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Creator implements Parcelable.Creator<VastClick> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VastClick createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new VastClick(parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VastClick[] newArray(int i11) {
            return new VastClick[i11];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VastClick() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public VastClick(String str, List<String> clickTrack) {
        Intrinsics.g(clickTrack, "clickTrack");
        this.videoClick = str;
        this.clickTrack = clickTrack;
    }

    public /* synthetic */ VastClick(String str, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? new ArrayList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VastClick copy$default(VastClick vastClick, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = vastClick.videoClick;
        }
        if ((i11 & 2) != 0) {
            list = vastClick.clickTrack;
        }
        return vastClick.copy(str, list);
    }

    public final String component1() {
        return this.videoClick;
    }

    public final List<String> component2() {
        return this.clickTrack;
    }

    public final VastClick copy(String str, List<String> clickTrack) {
        Intrinsics.g(clickTrack, "clickTrack");
        return new VastClick(str, clickTrack);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastClick)) {
            return false;
        }
        VastClick vastClick = (VastClick) obj;
        return Intrinsics.b(this.videoClick, vastClick.videoClick) && Intrinsics.b(this.clickTrack, vastClick.clickTrack);
    }

    public final List<String> getClickTrack() {
        return this.clickTrack;
    }

    public final String getVideoClick() {
        return this.videoClick;
    }

    public int hashCode() {
        String str = this.videoClick;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.clickTrack.hashCode();
    }

    public final void setClickTrack(List<String> list) {
        Intrinsics.g(list, "<set-?>");
        this.clickTrack = list;
    }

    public final void setVideoClick(String str) {
        this.videoClick = str;
    }

    public String toString() {
        return "VastClick(videoClick=" + this.videoClick + ", clickTrack=" + this.clickTrack + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.videoClick);
        out.writeStringList(this.clickTrack);
    }
}
