package com.transsion.memberapi;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class PointInfo implements Serializable {
    private int point;

    public PointInfo(int i11) {
        this.point = i11;
    }

    public static /* synthetic */ PointInfo copy$default(PointInfo pointInfo, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = pointInfo.point;
        }
        return pointInfo.copy(i11);
    }

    public final int component1() {
        return this.point;
    }

    public final PointInfo copy(int i11) {
        return new PointInfo(i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PointInfo) && this.point == ((PointInfo) obj).point;
    }

    public final int getPoint() {
        return this.point;
    }

    public int hashCode() {
        return this.point;
    }

    public final void setPoint(int i11) {
        this.point = i11;
    }

    public String toString() {
        return "PointInfo(point=" + this.point + ")";
    }
}
