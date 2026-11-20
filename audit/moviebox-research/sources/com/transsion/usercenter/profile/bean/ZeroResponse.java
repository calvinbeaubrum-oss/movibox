package com.transsion.usercenter.profile.bean;

import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ZeroResponse implements Serializable {
    private final List<ZeroInfo> items;

    public ZeroResponse(List<ZeroInfo> items) {
        Intrinsics.g(items, "items");
        this.items = items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ZeroResponse copy$default(ZeroResponse zeroResponse, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = zeroResponse.items;
        }
        return zeroResponse.copy(list);
    }

    public final List<ZeroInfo> component1() {
        return this.items;
    }

    public final ZeroResponse copy(List<ZeroInfo> items) {
        Intrinsics.g(items, "items");
        return new ZeroResponse(items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZeroResponse) && Intrinsics.b(this.items, ((ZeroResponse) obj).items);
    }

    public final List<ZeroInfo> getItems() {
        return this.items;
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    public String toString() {
        return "ZeroResponse(items=" + this.items + ")";
    }
}
