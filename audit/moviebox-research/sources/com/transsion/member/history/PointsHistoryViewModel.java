package com.transsion.member.history;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.member.bean.PointsHistoryData;
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
public final class PointsHistoryViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f53339a = LazyKt__LazyJVMKt.b(new Function0<pu.a>() { // from class: com.transsion.member.history.PointsHistoryViewModel$memberApi$2
        @Override // kotlin.jvm.functions.Function0
        public final pu.a invoke() {
            return (pu.a) NetServiceGenerator.f49399d.a().i(pu.a.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<PointsHistoryData> f53340b = new c0<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final pu.a e() {
        return (pu.a) this.f53339a.getValue();
    }

    public final void c(String page) {
        Intrinsics.g(page, "page");
        j.d(u0.a(this), w0.b(), null, new PointsHistoryViewModel$fetchHistory$1(this, page, null), 2, null);
    }

    public final c0<PointsHistoryData> d() {
        return this.f53340b;
    }
}
