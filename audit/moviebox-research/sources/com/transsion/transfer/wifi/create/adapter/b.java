package com.transsion.transfer.wifi.create.adapter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;

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
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qy.a f59181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.transfer.wifi.create.a f59182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k0 f59183c;

    public abstract Object a(Continuation<? super Unit> continuation);

    public final String b() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final k0 c() {
        return this.f59183c;
    }

    public final com.transsion.transfer.wifi.create.a d() {
        return this.f59182b;
    }

    public final qy.a e() {
        return this.f59181a;
    }

    public abstract void f();

    public final void g(k0 k0Var) {
        this.f59183c = k0Var;
    }

    public final void h(com.transsion.transfer.wifi.create.a aVar) {
        this.f59182b = aVar;
    }

    public final Object i(qy.a aVar, com.transsion.transfer.wifi.create.a aVar2, k0 k0Var, Continuation<? super Unit> continuation) {
        this.f59181a = aVar;
        this.f59182b = aVar2;
        this.f59183c = k0Var;
        Object objA = a(continuation);
        return objA == kotlin.coroutines.intrinsics.a.e() ? objA : Unit.f68710a;
    }
}
