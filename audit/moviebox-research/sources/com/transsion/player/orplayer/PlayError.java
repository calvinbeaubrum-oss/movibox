package com.transsion.player.orplayer;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class PlayError {
    public static final a Companion = new a(null);
    public static final int ERROR_LOADING_TIMEOUT = 537067524;
    private final Integer errorCode;
    private String errorMessage;
    private Throwable exoCause;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlayError() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public PlayError(Integer num, String str) {
        this.errorCode = num;
        this.errorMessage = str;
    }

    public /* synthetic */ PlayError(Integer num, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : str);
    }

    public static /* synthetic */ PlayError copy$default(PlayError playError, Integer num, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = playError.errorCode;
        }
        if ((i11 & 2) != 0) {
            str = playError.errorMessage;
        }
        return playError.copy(num, str);
    }

    public final Integer component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final PlayError copy(Integer num, String str) {
        return new PlayError(num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayError)) {
            return false;
        }
        PlayError playError = (PlayError) obj;
        return Intrinsics.b(this.errorCode, playError.errorCode) && Intrinsics.b(this.errorMessage, playError.errorMessage);
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final Throwable getExoCause() {
        return this.exoCause;
    }

    public int hashCode() {
        Integer num = this.errorCode;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.errorMessage;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setExoCause(Throwable th2) {
        this.exoCause = th2;
    }

    public String toString() {
        return "PlayError(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ")";
    }
}
