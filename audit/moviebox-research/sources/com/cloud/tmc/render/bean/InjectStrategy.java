package com.cloud.tmc.render.bean;

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
public final class InjectStrategy extends b {
    private String script;
    private String strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public InjectStrategy() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public InjectStrategy(String strategy, String script) {
        Intrinsics.g(strategy, "strategy");
        Intrinsics.g(script, "script");
        this.strategy = strategy;
        this.script = script;
    }

    public /* synthetic */ InjectStrategy(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2);
    }

    public static /* synthetic */ InjectStrategy copy$default(InjectStrategy injectStrategy, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = injectStrategy.strategy;
        }
        if ((i11 & 2) != 0) {
            str2 = injectStrategy.script;
        }
        return injectStrategy.copy(str, str2);
    }

    public final String component1() {
        return this.strategy;
    }

    public final String component2() {
        return this.script;
    }

    public final InjectStrategy copy(String strategy, String script) {
        Intrinsics.g(strategy, "strategy");
        Intrinsics.g(script, "script");
        return new InjectStrategy(strategy, script);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InjectStrategy)) {
            return false;
        }
        InjectStrategy injectStrategy = (InjectStrategy) obj;
        return Intrinsics.b(this.strategy, injectStrategy.strategy) && Intrinsics.b(this.script, injectStrategy.script);
    }

    public final String getScript() {
        return this.script;
    }

    public final String getStrategy() {
        return this.strategy;
    }

    public int hashCode() {
        return (this.strategy.hashCode() * 31) + this.script.hashCode();
    }

    public final void setScript(String str) {
        Intrinsics.g(str, "<set-?>");
        this.script = str;
    }

    public final void setStrategy(String str) {
        Intrinsics.g(str, "<set-?>");
        this.strategy = str;
    }

    public String toString() {
        return "InjectStrategy(strategy=" + this.strategy + ", script=" + this.script + ')';
    }
}
