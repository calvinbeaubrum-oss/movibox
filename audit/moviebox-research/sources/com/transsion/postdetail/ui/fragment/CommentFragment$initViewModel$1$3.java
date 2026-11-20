package com.transsion.postdetail.ui.fragment;

import android.text.Editable;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.bean.CommentBean;
import com.transsion.postdetail.bean.CommentListBean;
import com.transsion.postdetail.bean.Pager;
import com.transsnet.flow.event.sync.SyncManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class CommentFragment$initViewModel$1$3 extends Lambda implements Function1<CommentBean, Unit> {
    final /* synthetic */ CommentFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentFragment$initViewModel$1$3(CommentFragment commentFragment) {
        super(1);
        this.this$0 = commentFragment;
    }

    public static final void c(CommentFragment this$0) {
        RecyclerView.m layoutManager;
        Intrinsics.g(this$0, "this$0");
        try {
            RecyclerView recyclerView = this$0.f55633a;
            if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
                return;
            }
            layoutManager.scrollToPosition(0);
        } catch (Exception unused) {
        }
    }

    public static final void d(CommentFragment this$0, int i11) {
        RecyclerView.m layoutManager;
        Intrinsics.g(this$0, "this$0");
        try {
            RecyclerView recyclerView = this$0.f55633a;
            if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
                return;
            }
            layoutManager.scrollToPosition(i11);
        } catch (Exception unused) {
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CommentBean commentBean) {
        invoke2(commentBean);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CommentBean commentBean) {
        List<CommentBean> commentList;
        Iterable iterableD;
        List<CommentBean> arrayList;
        com.transsion.postdetail.comment.k kVarL;
        com.transsion.postdetail.comment.k kVarL2;
        Editable editableH;
        final int i11 = 0;
        this.this$0.f55649r = false;
        com.transsion.postdetail.comment.e eVar = this.this$0.f55638g;
        if (eVar != null) {
            eVar.j();
        }
        if (commentBean == null) {
            zp.b.f82110a.d(R$string.comment_failed);
            return;
        }
        CommentFragment commentFragment = this.this$0;
        zp.b.f82110a.d(R$string.comment_success);
        com.transsion.postdetail.comment.e eVar2 = commentFragment.f55638g;
        if (eVar2 != null && (kVarL2 = eVar2.l()) != null && (editableH = kVarL2.h()) != null) {
            editableH.clear();
        }
        com.transsion.postdetail.comment.e eVar3 = commentFragment.f55638g;
        if (eVar3 != null && (kVarL = eVar3.l()) != null) {
            kVarL.u();
        }
        com.transsion.postdetail.comment.e eVar4 = commentFragment.f55638g;
        if (eVar4 != null) {
            eVar4.dismiss();
        }
        final CommentFragment commentFragment2 = this.this$0;
        if (commentFragment2.f55648q != null) {
            commentFragment2.f55644m++;
            CommentListBean commentListBean = commentFragment2.f55639h;
            if (commentListBean != null && (commentList = commentListBean.getCommentList()) != null) {
                for (CommentBean commentBean2 : commentList) {
                    if (Intrinsics.b(commentBean2.getCommentId(), commentBean.getRootCommentId())) {
                        List<CommentBean> subComments = commentBean2.getSubComments();
                        if (subComments != null) {
                            subComments.add(commentBean);
                        }
                        commentBean2.setSubCommentCnt(commentBean2.getSubCommentCnt() + 1);
                        commentFragment2.g1();
                        commentFragment2.i1(commentFragment2.f55639h);
                        com.transsion.postdetail.comment.l lVar = commentFragment2.f55635c;
                        if (lVar != null && (iterableD = lVar.D()) != null) {
                            for (Object obj : iterableD) {
                                int i12 = i11 + 1;
                                if (i11 < 0) {
                                    kotlin.collections.g.u();
                                }
                                if (Intrinsics.b((e9.a) obj, commentBean)) {
                                    RecyclerView recyclerView = commentFragment2.f55633a;
                                    if (recyclerView == null) {
                                        break;
                                    }
                                    recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.f
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            CommentFragment$initViewModel$1$3.d(commentFragment2, i11);
                                        }
                                    });
                                    break;
                                }
                                i11 = i12;
                            }
                            break;
                        }
                        break;
                        break;
                    }
                }
            }
        } else {
            if (commentFragment2.f55639h == null) {
                commentFragment2.f55639h = new CommentListBean(kotlin.collections.g.h(commentBean), new Pager(Boolean.FALSE, "2", "1", 10, 1));
            } else {
                CommentListBean commentListBean2 = commentFragment2.f55639h;
                if (commentListBean2 != null) {
                    CommentListBean commentListBean3 = commentFragment2.f55639h;
                    if (commentListBean3 == null || (arrayList = commentListBean3.getCommentList()) == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(0, commentBean);
                    commentListBean2.setCommentList(arrayList);
                }
                commentFragment2.f55644m++;
            }
            commentFragment2.g1();
            commentFragment2.i1(commentFragment2.f55639h);
            RecyclerView recyclerView2 = commentFragment2.f55633a;
            if (recyclerView2 != null) {
                recyclerView2.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        CommentFragment$initViewModel$1$3.c(commentFragment2);
                    }
                });
            }
        }
        SyncManager syncManagerA = SyncManager.f61414a.a();
        String commentId = commentBean.getCommentId();
        if (commentId == null) {
            commentId = "";
        }
        syncManagerA.b(1, commentId, String.valueOf(commentFragment2.f55644m), commentFragment2.f55641j);
    }
}
