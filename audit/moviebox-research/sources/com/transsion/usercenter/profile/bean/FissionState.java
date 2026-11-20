package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class FissionState implements Serializable {
    private String boundInviteCode;
    private boolean isNew;

    public FissionState(boolean z11, String str) {
        this.isNew = z11;
        this.boundInviteCode = str;
    }

    public /* synthetic */ FissionState(boolean z11, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, str);
    }

    public static /* synthetic */ FissionState copy$default(FissionState fissionState, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = fissionState.isNew;
        }
        if ((i11 & 2) != 0) {
            str = fissionState.boundInviteCode;
        }
        return fissionState.copy(z11, str);
    }

    public final boolean component1() {
        return this.isNew;
    }

    public final String component2() {
        return this.boundInviteCode;
    }

    public final FissionState copy(boolean z11, String str) {
        return new FissionState(z11, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FissionState)) {
            return false;
        }
        FissionState fissionState = (FissionState) obj;
        return this.isNew == fissionState.isNew && Intrinsics.b(this.boundInviteCode, fissionState.boundInviteCode);
    }

    public final String getBoundInviteCode() {
        return this.boundInviteCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z11 = this.isNew;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        String str = this.boundInviteCode;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final void setBoundInviteCode(String str) {
        this.boundInviteCode = str;
    }

    public final void setNew(boolean z11) {
        this.isNew = z11;
    }

    public String toString() {
        return "FissionState(isNew=" + this.isNew + ", boundInviteCode=" + this.boundInviteCode + ")";
    }
}
