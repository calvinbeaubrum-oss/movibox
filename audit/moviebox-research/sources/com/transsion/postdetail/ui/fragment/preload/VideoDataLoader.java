package com.transsion.postdetail.ui.fragment.preload;

import androidx.lifecycle.c0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class VideoDataLoader extends b<PostSubjectBean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f55913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f55914g;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoDataLoader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public VideoDataLoader(String postId) {
        Intrinsics.g(postId, "postId");
        this.f55913f = postId;
        this.f55914g = LazyKt__LazyJVMKt.b(new Function0<xv.b>() { // from class: com.transsion.postdetail.ui.fragment.preload.VideoDataLoader$service$2
            @Override // kotlin.jvm.functions.Function0
            public final xv.b invoke() {
                return (xv.b) NetServiceGenerator.f49399d.a().i(xv.b.class);
            }
        });
    }

    public /* synthetic */ VideoDataLoader(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str);
    }

    @Override // lu.b
    public void h(c0<PostSubjectBean> c0Var) {
        j(j.d(l0.a(w0.b()), null, null, new VideoDataLoader$loadDataFromService$1(this, null), 3, null));
    }

    public final String l() {
        return this.f55913f;
    }

    public final xv.b m() {
        return (xv.b) this.f55914g.getValue();
    }

    public final void n(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f55913f = str;
    }
}
