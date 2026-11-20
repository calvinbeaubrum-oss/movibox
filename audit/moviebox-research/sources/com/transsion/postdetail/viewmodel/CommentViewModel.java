package com.transsion.postdetail.viewmodel;

import android.app.Application;
import androidx.lifecycle.b;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.postdetail.bean.CommentBean;
import com.transsion.postdetail.bean.CommentBody;
import com.transsion.postdetail.bean.CommentLikeBean;
import com.transsion.postdetail.bean.CommentLikeBody;
import com.transsion.postdetail.bean.CommentListBean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import rv.c;
import xv.a;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CommentViewModel extends b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f56249j = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<CommentBean> f56250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<CommentListBean> f56251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<c> f56252d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<CommentLikeBean> f56253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<BaseDto<String>> f56254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<String> f56255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f56256i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f56250b = new c0<>();
        this.f56251c = new c0<>();
        this.f56252d = new c0<>();
        this.f56253f = new c0<>();
        this.f56254g = new c0<>();
        this.f56255h = new c0<>();
        this.f56256i = LazyKt__LazyJVMKt.b(new Function0<xv.a>() { // from class: com.transsion.postdetail.viewmodel.CommentViewModel$commentNetApi$2
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return (a) NetServiceGenerator.f49399d.a().i(a.class);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xv.a g() {
        return (xv.a) this.f56256i.getValue();
    }

    public final void e(String commentId) {
        Intrinsics.g(commentId, "commentId");
        j.d(u0.a(this), null, null, new CommentViewModel$deleteComment$1(this, commentId, null), 3, null);
    }

    public final void f(String postId, String rootCommentId, String page, int i11, String locCommentId) {
        Intrinsics.g(postId, "postId");
        Intrinsics.g(rootCommentId, "rootCommentId");
        Intrinsics.g(page, "page");
        Intrinsics.g(locCommentId, "locCommentId");
        j.d(u0.a(this), null, null, new CommentViewModel$getCommentList$1(this, postId, rootCommentId, page, locCommentId, i11, null), 3, null);
    }

    public final c0<BaseDto<String>> h() {
        return this.f56254g;
    }

    public final c0<CommentListBean> i() {
        return this.f56251c;
    }

    public final c0<c> j() {
        return this.f56252d;
    }

    public final c0<CommentLikeBean> k() {
        return this.f56253f;
    }

    public final c0<CommentBean> l() {
        return this.f56250b;
    }

    public final c0<String> m() {
        return this.f56255h;
    }

    public final void n(rv.a info, String page, int i11) {
        Intrinsics.g(info, "info");
        Intrinsics.g(page, "page");
        j.d(u0.a(this), null, null, new CommentViewModel$getSubCommentList$1(this, info, page, i11, null), 3, null);
    }

    public final void o(CommentLikeBody commentBody) {
        Intrinsics.g(commentBody, "commentBody");
        j.d(u0.a(this), null, null, new CommentViewModel$likeComment$1(commentBody, this, null), 3, null);
    }

    public final void p(String str) {
        uo.b.a.f(uo.b.f78622a, "CommentViewModel", str, false, 4, null);
    }

    public final void q(CommentBody commentBody) {
        Intrinsics.g(commentBody, "commentBody");
        j.d(u0.a(this), null, null, new CommentViewModel$postComment$1(commentBody, this, null), 3, null);
    }

    public final void r(String commentId) {
        Intrinsics.g(commentId, "commentId");
        this.f56255h.q(commentId);
    }
}
