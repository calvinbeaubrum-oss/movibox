package com.cloud.tmc.fps.data;

import kotlin.Metadata;
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
public final class StackTraceData extends b {
    private int count;
    private String stackInfo;

    public StackTraceData(int i11, String stackInfo) {
        Intrinsics.g(stackInfo, "stackInfo");
        this.count = i11;
        this.stackInfo = stackInfo;
    }

    public static /* synthetic */ StackTraceData copy$default(StackTraceData stackTraceData, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = stackTraceData.count;
        }
        if ((i12 & 2) != 0) {
            str = stackTraceData.stackInfo;
        }
        return stackTraceData.copy(i11, str);
    }

    public final int component1() {
        return this.count;
    }

    public final String component2() {
        return this.stackInfo;
    }

    public final StackTraceData copy(int i11, String stackInfo) {
        Intrinsics.g(stackInfo, "stackInfo");
        return new StackTraceData(i11, stackInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StackTraceData)) {
            return false;
        }
        StackTraceData stackTraceData = (StackTraceData) obj;
        return this.count == stackTraceData.count && Intrinsics.b(this.stackInfo, stackTraceData.stackInfo);
    }

    public final int getCount() {
        return this.count;
    }

    public final String getStackInfo() {
        return this.stackInfo;
    }

    public int hashCode() {
        return (this.count * 31) + this.stackInfo.hashCode();
    }

    public final void setCount(int i11) {
        this.count = i11;
    }

    public final void setStackInfo(String str) {
        Intrinsics.g(str, "<set-?>");
        this.stackInfo = str;
    }

    public String toString() {
        return "StackTraceData(count=" + this.count + ", stackInfo=" + this.stackInfo + ')';
    }
}
