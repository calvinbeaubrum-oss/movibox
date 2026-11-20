package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class DubsInfoData {
    private final List<DubsInfo> dubs;

    public DubsInfoData(List<DubsInfo> list) {
        this.dubs = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DubsInfoData copy$default(DubsInfoData dubsInfoData, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = dubsInfoData.dubs;
        }
        return dubsInfoData.copy(list);
    }

    public final List<DubsInfo> component1() {
        return this.dubs;
    }

    public final DubsInfoData copy(List<DubsInfo> list) {
        return new DubsInfoData(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DubsInfoData) && Intrinsics.b(this.dubs, ((DubsInfoData) obj).dubs);
    }

    public final List<DubsInfo> getDubs() {
        return this.dubs;
    }

    public int hashCode() {
        List<DubsInfo> list = this.dubs;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "DubsInfoData(dubs=" + this.dubs + ")";
    }
}
