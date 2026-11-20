package com.transsion.push.tpush;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
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
@Metadata
public enum TMsgType {
    LikePost("1"),
    Follow("2"),
    LikeComment("3"),
    JoinGroup("4"),
    GroupPost("5"),
    Customize(PrepareException.ERROR_NO_URL),
    GroupPostTop("7"),
    Group(PrepareException.ERROR_MANIFEST_INFO),
    Manual(PrepareException.ERROR_MINI_APP_CLOSE),
    SubjectSeeking(PrepareException.ERROR_MINI_APPID);

    private final String type;

    TMsgType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
