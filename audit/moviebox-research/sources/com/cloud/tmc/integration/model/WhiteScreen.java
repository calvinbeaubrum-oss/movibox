package com.cloud.tmc.integration.model;

import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class WhiteScreen implements Serializable {
    private int[] checkIntervalArray;
    private long checkNowDelay;
    private float grayScale;

    public WhiteScreen() {
        this(0.0f, 0L, null, 7, null);
    }

    public WhiteScreen(float f11, long j11, int[] checkIntervalArray) {
        Intrinsics.g(checkIntervalArray, "checkIntervalArray");
        this.grayScale = f11;
        this.checkNowDelay = j11;
        this.checkIntervalArray = checkIntervalArray;
    }

    public /* synthetic */ WhiteScreen(float f11, long j11, int[] iArr, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? 0L : j11, (i11 & 4) != 0 ? new int[0] : iArr);
    }

    public static /* synthetic */ WhiteScreen copy$default(WhiteScreen whiteScreen, float f11, long j11, int[] iArr, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = whiteScreen.grayScale;
        }
        if ((i11 & 2) != 0) {
            j11 = whiteScreen.checkNowDelay;
        }
        if ((i11 & 4) != 0) {
            iArr = whiteScreen.checkIntervalArray;
        }
        return whiteScreen.copy(f11, j11, iArr);
    }

    public final float component1() {
        return this.grayScale;
    }

    public final long component2() {
        return this.checkNowDelay;
    }

    public final int[] component3() {
        return this.checkIntervalArray;
    }

    public final WhiteScreen copy(float f11, long j11, int[] checkIntervalArray) {
        Intrinsics.g(checkIntervalArray, "checkIntervalArray");
        return new WhiteScreen(f11, j11, checkIntervalArray);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhiteScreen)) {
            return false;
        }
        WhiteScreen whiteScreen = (WhiteScreen) obj;
        return Float.compare(this.grayScale, whiteScreen.grayScale) == 0 && this.checkNowDelay == whiteScreen.checkNowDelay && Intrinsics.b(this.checkIntervalArray, whiteScreen.checkIntervalArray);
    }

    public final int[] getCheckIntervalArray() {
        return this.checkIntervalArray;
    }

    public final long getCheckNowDelay() {
        return this.checkNowDelay;
    }

    public final float getGrayScale() {
        return this.grayScale;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.grayScale) * 31) + p.a(this.checkNowDelay)) * 31) + Arrays.hashCode(this.checkIntervalArray);
    }

    public final void setCheckIntervalArray(int[] iArr) {
        Intrinsics.g(iArr, "<set-?>");
        this.checkIntervalArray = iArr;
    }

    public final void setCheckNowDelay(long j11) {
        this.checkNowDelay = j11;
    }

    public final void setGrayScale(float f11) {
        this.grayScale = f11;
    }

    public String toString() {
        return "WhiteScreen(grayScale=" + this.grayScale + ", checkNowDelay=" + this.checkNowDelay + ", checkIntervalArray=" + Arrays.toString(this.checkIntervalArray) + ')';
    }
}
