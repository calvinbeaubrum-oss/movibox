package com.transsion.home.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LayoutStyle implements Serializable {
    public static final int $stable = 0;

    @SerializedName("colNum")
    private final int colNum;

    @SerializedName("shape")
    private final String shape;

    public LayoutStyle(int i11, String shape) {
        Intrinsics.g(shape, "shape");
        this.colNum = i11;
        this.shape = shape;
    }

    public static /* synthetic */ LayoutStyle copy$default(LayoutStyle layoutStyle, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = layoutStyle.colNum;
        }
        if ((i12 & 2) != 0) {
            str = layoutStyle.shape;
        }
        return layoutStyle.copy(i11, str);
    }

    public final int component1() {
        return this.colNum;
    }

    public final String component2() {
        return this.shape;
    }

    public final LayoutStyle copy(int i11, String shape) {
        Intrinsics.g(shape, "shape");
        return new LayoutStyle(i11, shape);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LayoutStyle)) {
            return false;
        }
        LayoutStyle layoutStyle = (LayoutStyle) obj;
        return this.colNum == layoutStyle.colNum && Intrinsics.b(this.shape, layoutStyle.shape);
    }

    public final int getColNum() {
        return this.colNum;
    }

    public final String getShape() {
        return this.shape;
    }

    public int hashCode() {
        return (this.colNum * 31) + this.shape.hashCode();
    }

    public String toString() {
        return "LayoutStyle(colNum=" + this.colNum + ", shape=" + this.shape + ")";
    }
}
