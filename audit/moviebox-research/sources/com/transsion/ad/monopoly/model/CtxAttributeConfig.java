package com.transsion.ad.monopoly.model;

import android.os.Parcel;
import android.os.Parcelable;
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
public final class CtxAttributeConfig implements Parcelable {
    public static final Parcelable.Creator<CtxAttributeConfig> CREATOR = new a();
    private final List<String> attrs;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CtxAttributeConfig> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CtxAttributeConfig createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CtxAttributeConfig(parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CtxAttributeConfig[] newArray(int i11) {
            return new CtxAttributeConfig[i11];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CtxAttributeConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CtxAttributeConfig(List<String> list) {
        this.attrs = list;
    }

    public /* synthetic */ CtxAttributeConfig(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CtxAttributeConfig copy$default(CtxAttributeConfig ctxAttributeConfig, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = ctxAttributeConfig.attrs;
        }
        return ctxAttributeConfig.copy(list);
    }

    public final List<String> component1() {
        return this.attrs;
    }

    public final CtxAttributeConfig copy(List<String> list) {
        return new CtxAttributeConfig(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CtxAttributeConfig) && Intrinsics.b(this.attrs, ((CtxAttributeConfig) obj).attrs);
    }

    public final List<String> getAttrs() {
        return this.attrs;
    }

    public int hashCode() {
        List<String> list = this.attrs;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "CtxAttributeConfig(attrs=" + this.attrs + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeStringList(this.attrs);
    }
}
