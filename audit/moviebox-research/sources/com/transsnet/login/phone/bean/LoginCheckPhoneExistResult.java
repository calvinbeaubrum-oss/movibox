package com.transsnet.login.phone.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class LoginCheckPhoneExistResult implements Serializable {
    private boolean exists;

    @SerializedName("hasPassword")
    private boolean hasPassword;
    private boolean reset;

    public final boolean getExists() {
        return this.exists;
    }

    public final boolean getHasPassword() {
        return this.hasPassword;
    }

    public final boolean getReset() {
        return this.reset;
    }

    public final void setExists(boolean z11) {
        this.exists = z11;
    }

    public final void setHasPassword(boolean z11) {
        this.hasPassword = z11;
    }

    public final void setReset(boolean z11) {
        this.reset = z11;
    }
}
