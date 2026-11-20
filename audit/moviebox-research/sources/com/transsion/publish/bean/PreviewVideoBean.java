package com.transsion.publish.bean;

import androidx.annotation.Keep;
import com.transsion.publish.api.VsMediaInfo;
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
public final class PreviewVideoBean implements Serializable {
    private Integer from = 0;
    private Integer operator = 0;
    private VsMediaInfo select;

    public final Integer getFrom() {
        return this.from;
    }

    public final Integer getOperator() {
        return this.operator;
    }

    public final VsMediaInfo getSelect() {
        return this.select;
    }

    public final void setFrom(Integer num) {
        this.from = num;
    }

    public final void setOperator(Integer num) {
        this.operator = num;
    }

    public final void setSelect(VsMediaInfo vsMediaInfo) {
        this.select = vsMediaInfo;
    }
}
