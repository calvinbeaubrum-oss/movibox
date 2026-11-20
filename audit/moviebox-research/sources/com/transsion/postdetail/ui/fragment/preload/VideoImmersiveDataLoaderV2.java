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
public final class VideoImmersiveDataLoaderV2 extends b<PostSubjectBean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f55919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f55920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f55921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f55922i;

    public VideoImmersiveDataLoaderV2() {
        this(null, null, 0, 7, null);
    }

    public VideoImmersiveDataLoaderV2(String postId, String page, int i11) {
        Intrinsics.g(postId, "postId");
        Intrinsics.g(page, "page");
        this.f55919f = postId;
        this.f55920g = page;
        this.f55921h = i11;
        this.f55922i = LazyKt__LazyJVMKt.b(new Function0<xv.b>() { // from class: com.transsion.postdetail.ui.fragment.preload.VideoImmersiveDataLoaderV2$service$2
            @Override // kotlin.jvm.functions.Function0
            public final xv.b invoke() {
                return (xv.b) NetServiceGenerator.f49399d.a().i(xv.b.class);
            }
        });
    }

    public /* synthetic */ VideoImmersiveDataLoaderV2(String str, String str2, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? "0" : str, (i12 & 2) != 0 ? "1" : str2, (i12 & 4) != 0 ? 5 : i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xv.b o() {
        return (xv.b) this.f55922i.getValue();
    }

    @Override // lu.b
    public void h(c0<PostSubjectBean> c0Var) {
        j(j.d(l0.a(w0.b()), null, null, new VideoImmersiveDataLoaderV2$loadDataFromService$1(this, null), 3, null));
    }

    public final String l() {
        return this.f55920g;
    }

    public final int m() {
        return this.f55921h;
    }

    public final String n() {
        return this.f55919f;
    }

    public final void p(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f55920g = str;
    }

    public final void q(int i11) {
        this.f55921h = i11;
    }

    public final void r(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f55919f = str;
    }
}
