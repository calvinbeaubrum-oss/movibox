package com.transsion.postdetail.viewmodel;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.postdetail.bean.CommentListBean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import xv.a;

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
public final class PostDetailCommentsFragmentViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f56270a = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.postdetail.viewmodel.PostDetailCommentsFragmentViewModel$commentNetApi$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<CommentListBean> f56271b = new c0<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final a d() {
        return (a) this.f56270a.getValue();
    }

    public final void c(String postId, String rootCommentId, String page, int i11) {
        Intrinsics.g(postId, "postId");
        Intrinsics.g(rootCommentId, "rootCommentId");
        Intrinsics.g(page, "page");
        j.d(u0.a(this), null, null, new PostDetailCommentsFragmentViewModel$getCommentList$1(this, postId, rootCommentId, page, i11, null), 3, null);
    }

    public final c0<CommentListBean> e() {
        return this.f56271b;
    }
}
