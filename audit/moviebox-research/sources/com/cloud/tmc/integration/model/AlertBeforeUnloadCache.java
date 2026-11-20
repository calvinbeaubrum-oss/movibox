package com.cloud.tmc.integration.model;

import java.io.Serializable;
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
public final class AlertBeforeUnloadCache extends b implements Serializable {
    private boolean enabled;
    private String message;

    /* JADX WARN: Multi-variable type inference failed */
    public AlertBeforeUnloadCache() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public AlertBeforeUnloadCache(boolean z11, String str) {
        this.enabled = z11;
        this.message = str;
    }

    public /* synthetic */ AlertBeforeUnloadCache(boolean z11, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? null : str);
    }

    public static /* synthetic */ AlertBeforeUnloadCache copy$default(AlertBeforeUnloadCache alertBeforeUnloadCache, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = alertBeforeUnloadCache.enabled;
        }
        if ((i11 & 2) != 0) {
            str = alertBeforeUnloadCache.message;
        }
        return alertBeforeUnloadCache.copy(z11, str);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.message;
    }

    public final AlertBeforeUnloadCache copy(boolean z11, String str) {
        return new AlertBeforeUnloadCache(z11, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlertBeforeUnloadCache)) {
            return false;
        }
        AlertBeforeUnloadCache alertBeforeUnloadCache = (AlertBeforeUnloadCache) obj;
        return this.enabled == alertBeforeUnloadCache.enabled && Intrinsics.b(this.message, alertBeforeUnloadCache.message);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z11 = this.enabled;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        String str = this.message;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    public final void setEnabled(boolean z11) {
        this.enabled = z11;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "AlertBeforeUnloadCache(enabled=" + this.enabled + ", message=" + this.message + ')';
    }
}
