package com.transsion.home.viewmodel;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.home.bean.PlayListResp;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;
import rt.a;

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
public final class PlayListViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f52743a = (a) NetServiceGenerator.f49399d.a().i(a.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f52744b = LazyKt__LazyJVMKt.b(new Function0<c0<PlayListResp>>() { // from class: com.transsion.home.viewmodel.PlayListViewModel$playListLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<PlayListResp> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f52745c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f52746d = 8;

    public final int d() {
        return this.f52745c;
    }

    public final void e(String label, String category, String recType, String topIds, int i11) {
        Intrinsics.g(label, "label");
        Intrinsics.g(category, "category");
        Intrinsics.g(recType, "recType");
        Intrinsics.g(topIds, "topIds");
        j.d(u0.a(this), w0.b(), null, new PlayListViewModel$getPlayList$1(this, label, category, recType, topIds, i11, null), 2, null);
    }

    public final c0<PlayListResp> f() {
        return (c0) this.f52744b.getValue();
    }

    public final void g(int i11) {
        this.f52745c = i11;
    }
}
