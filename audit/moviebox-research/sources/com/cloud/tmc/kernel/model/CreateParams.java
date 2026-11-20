package com.cloud.tmc.kernel.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
public final class CreateParams extends b implements Parcelable {
    public static final a CREATOR = new a(null);
    private int containerHeight;
    private int containerWidth;
    private ArrayList<String> resourceUrls;

    @JvmField
    public Bundle startParams;

    @JvmField
    public sc.a urlVisitListener;

    @JvmField
    public boolean useForEmbed;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CreateParams> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CreateParams createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CreateParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CreateParams[] newArray(int i11) {
            return new CreateParams[i11];
        }
    }

    public CreateParams() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreateParams(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        this.startParams = parcel.readBundle(CreateParams.class.getClassLoader());
        this.containerWidth = parcel.readInt();
        this.containerHeight = parcel.readInt();
        this.useForEmbed = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getContainerHeight() {
        return this.containerHeight;
    }

    public final int getContainerWidth() {
        return this.containerWidth;
    }

    public final ArrayList<String> getResourceUrls() {
        return this.resourceUrls;
    }

    public final void setContainerHeight(int i11) {
        this.containerHeight = i11;
    }

    public final void setContainerWidth(int i11) {
        this.containerWidth = i11;
    }

    public final void setResourceUrls(ArrayList<String> arrayList) {
        this.resourceUrls = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeBundle(this.startParams);
        parcel.writeInt(this.containerWidth);
        parcel.writeInt(this.containerHeight);
        parcel.writeByte(this.useForEmbed ? (byte) 1 : (byte) 0);
    }
}
