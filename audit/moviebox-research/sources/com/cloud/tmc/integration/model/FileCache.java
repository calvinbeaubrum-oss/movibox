package com.cloud.tmc.integration.model;

import java.io.File;
import java.lang.ref.WeakReference;
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
public final class FileCache extends b {
    private final WeakHashMap<String, WeakReference<File>> fileCache;
    private final WeakHashMap<String, String> flags;

    /* JADX WARN: Multi-variable type inference failed */
    public FileCache() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public FileCache(WeakHashMap<String, WeakReference<File>> fileCache, WeakHashMap<String, String> flags) {
        Intrinsics.g(fileCache, "fileCache");
        Intrinsics.g(flags, "flags");
        this.fileCache = fileCache;
        this.flags = flags;
    }

    public /* synthetic */ FileCache(WeakHashMap weakHashMap, WeakHashMap weakHashMap2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new WeakHashMap() : weakHashMap, (i11 & 2) != 0 ? new WeakHashMap() : weakHashMap2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileCache copy$default(FileCache fileCache, WeakHashMap weakHashMap, WeakHashMap weakHashMap2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            weakHashMap = fileCache.fileCache;
        }
        if ((i11 & 2) != 0) {
            weakHashMap2 = fileCache.flags;
        }
        return fileCache.copy(weakHashMap, weakHashMap2);
    }

    public final WeakHashMap<String, WeakReference<File>> component1() {
        return this.fileCache;
    }

    public final WeakHashMap<String, String> component2() {
        return this.flags;
    }

    public final FileCache copy(WeakHashMap<String, WeakReference<File>> fileCache, WeakHashMap<String, String> flags) {
        Intrinsics.g(fileCache, "fileCache");
        Intrinsics.g(flags, "flags");
        return new FileCache(fileCache, flags);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileCache)) {
            return false;
        }
        FileCache fileCache = (FileCache) obj;
        return Intrinsics.b(this.fileCache, fileCache.fileCache) && Intrinsics.b(this.flags, fileCache.flags);
    }

    public final WeakHashMap<String, WeakReference<File>> getFileCache() {
        return this.fileCache;
    }

    public final WeakHashMap<String, String> getFlags() {
        return this.flags;
    }

    public int hashCode() {
        return (this.fileCache.hashCode() * 31) + this.flags.hashCode();
    }

    public String toString() {
        return "FileCache(fileCache=" + this.fileCache + ", flags=" + this.flags + ')';
    }
}
