package com.cloud.tmc.integration.model;

import bc.a;
import java.util.HashMap;
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
public final class WebViewStore extends b {
    private final HashMap<String, a> onDownloads;

    /* JADX WARN: Multi-variable type inference failed */
    public WebViewStore() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public WebViewStore(HashMap<String, a> onDownloads) {
        Intrinsics.g(onDownloads, "onDownloads");
        this.onDownloads = onDownloads;
    }

    public /* synthetic */ WebViewStore(HashMap map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new HashMap() : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebViewStore copy$default(WebViewStore webViewStore, HashMap map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = webViewStore.onDownloads;
        }
        return webViewStore.copy(map);
    }

    public final HashMap<String, a> component1() {
        return this.onDownloads;
    }

    public final WebViewStore copy(HashMap<String, a> onDownloads) {
        Intrinsics.g(onDownloads, "onDownloads");
        return new WebViewStore(onDownloads);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WebViewStore) && Intrinsics.b(this.onDownloads, ((WebViewStore) obj).onDownloads);
    }

    public final HashMap<String, a> getOnDownloads() {
        return this.onDownloads;
    }

    public int hashCode() {
        return this.onDownloads.hashCode();
    }

    public String toString() {
        return "WebViewStore(onDownloads=" + this.onDownloads + ')';
    }
}
