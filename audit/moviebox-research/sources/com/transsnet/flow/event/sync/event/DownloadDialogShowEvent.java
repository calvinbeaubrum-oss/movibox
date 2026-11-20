package com.transsnet.flow.event.sync.event;

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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class DownloadDialogShowEvent implements Serializable {
    private final boolean show;

    public DownloadDialogShowEvent(boolean z11) {
        this.show = z11;
    }

    public static /* synthetic */ DownloadDialogShowEvent copy$default(DownloadDialogShowEvent downloadDialogShowEvent, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = downloadDialogShowEvent.show;
        }
        return downloadDialogShowEvent.copy(z11);
    }

    public final boolean component1() {
        return this.show;
    }

    public final DownloadDialogShowEvent copy(boolean z11) {
        return new DownloadDialogShowEvent(z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DownloadDialogShowEvent) && this.show == ((DownloadDialogShowEvent) obj).show;
    }

    public final boolean getShow() {
        return this.show;
    }

    public int hashCode() {
        boolean z11 = this.show;
        if (z11) {
            return 1;
        }
        return z11 ? 1 : 0;
    }

    public String toString() {
        return "DownloadDialogShowEvent(show=" + this.show + ")";
    }
}
