package com.transsion.member.constants;

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
@Metadata
public enum TaskType {
    TITLE(0),
    WATCH_AD(1),
    INVITE_USER(2),
    WATCH(3),
    DOWNLOAD_APP(4),
    OPEN_APP(5),
    PLAY_GAME(6),
    DOWNLOAD_MOVIE(7),
    CHECK_IN(8),
    PALM_PAY(10),
    GAME_RES_BROWSE(11),
    GAME_RES_APP_DOWNLOAD(12);

    private final int value;

    TaskType(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
