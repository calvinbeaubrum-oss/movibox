package com.transsion.postdetail.layer.listener;

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
public enum LayerFlag {
    INIT_PLAY,
    RENDER_FIRST_FRAME,
    COMPLETION,
    VIDEO_PAUSE,
    VIDEO_START,
    PLAY_ERROR,
    VIDEO_SIZE_CHANGED,
    LOADING_BEGIN,
    PROGRESS,
    LOADING_END,
    PLAYER_RESET,
    INIT_VIEW,
    INIT_VIEW_TYPE,
    INIT_DATA,
    ADD_SURFACE,
    SCREEN_ORIENTATION_CHANGED,
    LOCAL_UI_CHANGED,
    LAYER_EVENT,
    SET_PARAMS,
    UPDATE_DATA,
    UPDATE_DOWNLOAD_DATA,
    UPDATE_TITLE,
    SET_PLAYER,
    SET_MANAGER,
    BACK_PRESSED,
    LOOPING_START,
    BOTTOM_CONTROL,
    SUBTITLE_CONTROL,
    DOWNLOAD_PROGRESS,
    DOWNLOAD_SPEED,
    DOWNLOAD_CALLBACK,
    SHOW_TOAST,
    REMOVE_TOAST,
    NETWORK_CHANGE,
    PLAYER_TIMEOUT_TIPS,
    REQUEST_FORYOU,
    SERIES_INIT,
    SERIES_EVENT,
    SERIES_PLAY,
    SERIES_LOCAL2NET,
    UPDATE_SPEED,
    UPDATE_ROTATION,
    RELEASE_PLAYER,
    SHOW_FLOAT_2_WINDOW,
    INTO_PIP,
    FRAGMENT_PAUSE,
    FRAGMENT_STOP,
    FRAGMENT_RESUME,
    FRAGMENT_DESTROY
}
