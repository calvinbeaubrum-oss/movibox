package com.transsion.moviedetail.preload;

import androidx.lifecycle.c0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import lu.b;

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
public final class MovieDetailResourcesSeasonLoader extends b<ResourcesSeasonList> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f53723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f53724g;

    public MovieDetailResourcesSeasonLoader(String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        this.f53723f = subjectId;
        this.f53724g = LazyKt__LazyJVMKt.b(new Function0<i00.a>() { // from class: com.transsion.moviedetail.preload.MovieDetailResourcesSeasonLoader$serviceDownload$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i00.a invoke() {
                return (i00.a) NetServiceGenerator.f49399d.a().i(i00.a.class);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i00.a l() {
        return (i00.a) this.f53724g.getValue();
    }

    @Override // lu.b
    public void h(c0<ResourcesSeasonList> c0Var) {
        j(j.d(l0.a(w0.b()), null, null, new MovieDetailResourcesSeasonLoader$loadDataFromService$1(this, null), 3, null));
    }

    public final String m() {
        return this.f53723f;
    }

    public final void n(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f53723f = str;
    }
}
