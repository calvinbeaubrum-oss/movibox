package com.transsion.commercialization.aha;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.bean.AhaGameResponse;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;

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
public final class GameRecommendViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<AhaGameResponse> f51615a = new c0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f51616b = LazyKt__LazyJVMKt.b(new Function0<d>() { // from class: com.transsion.commercialization.aha.GameRecommendViewModel$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final d invoke() {
            return (d) NetServiceGenerator.f49399d.a().i(d.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f51617c;

    public final c0<AhaGameResponse> g() {
        return this.f51615a;
    }

    public final void h() {
        j.d(u0.a(this), w0.b(), null, new GameRecommendViewModel$getAllGame$1(this, null), 2, null);
    }

    public final String i() {
        String simpleName = GameRecommendViewModel.class.getSimpleName();
        Intrinsics.f(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }

    public final d j() {
        return (d) this.f51616b.getValue();
    }
}
