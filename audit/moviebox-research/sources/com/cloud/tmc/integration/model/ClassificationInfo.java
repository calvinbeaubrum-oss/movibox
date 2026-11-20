package com.cloud.tmc.integration.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.d;
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
public final class ClassificationInfo extends b implements Serializable, Parcelable {
    public static final a CREATOR = new a(null);
    private List<Long> ids;
    private Integer type;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<ClassificationInfo> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ClassificationInfo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new ClassificationInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ClassificationInfo[] newArray(int i11) {
            return new ClassificationInfo[i11];
        }
    }

    public ClassificationInfo() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClassificationInfo(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        long[] jArrCreateLongArray = parcel.createLongArray();
        this.ids = jArrCreateLongArray != null ? d.z0(jArrCreateLongArray) : null;
        this.type = Integer.valueOf(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<Long> getIds() {
        return this.ids;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setIds(List<Long> list) {
        this.ids = list;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i11) {
        Intrinsics.g(dest, "dest");
        List<Long> list = this.ids;
        dest.writeLongArray(list != null ? CollectionsKt___CollectionsKt.K0(list) : null);
        Integer num = this.type;
        dest.writeInt(num != null ? num.intValue() : 0);
    }
}
