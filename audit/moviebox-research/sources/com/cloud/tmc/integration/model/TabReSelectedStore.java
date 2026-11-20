package com.cloud.tmc.integration.model;

import bc.a;
import java.util.WeakHashMap;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class TabReSelectedStore extends b {
    private final WeakHashMap<String, a> pageCache;

    /* JADX WARN: Multi-variable type inference failed */
    public TabReSelectedStore() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TabReSelectedStore(WeakHashMap<String, a> pageCache) {
        Intrinsics.g(pageCache, "pageCache");
        this.pageCache = pageCache;
    }

    public /* synthetic */ TabReSelectedStore(WeakHashMap weakHashMap, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new WeakHashMap() : weakHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabReSelectedStore copy$default(TabReSelectedStore tabReSelectedStore, WeakHashMap weakHashMap, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            weakHashMap = tabReSelectedStore.pageCache;
        }
        return tabReSelectedStore.copy(weakHashMap);
    }

    public final WeakHashMap<String, a> component1() {
        return this.pageCache;
    }

    public final TabReSelectedStore copy(WeakHashMap<String, a> pageCache) {
        Intrinsics.g(pageCache, "pageCache");
        return new TabReSelectedStore(pageCache);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TabReSelectedStore) && Intrinsics.b(this.pageCache, ((TabReSelectedStore) obj).pageCache);
    }

    public final WeakHashMap<String, a> getPageCache() {
        return this.pageCache;
    }

    public int hashCode() {
        return this.pageCache.hashCode();
    }

    public String toString() {
        return "TabReSelectedStore(pageCache=" + this.pageCache + ')';
    }
}
