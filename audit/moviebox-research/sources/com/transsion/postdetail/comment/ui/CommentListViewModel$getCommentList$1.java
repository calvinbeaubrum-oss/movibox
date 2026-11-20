package com.transsion.postdetail.comment.ui;

import com.blankj.utilcode.util.n;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.postdetail.bean.CommentBean;
import com.transsion.postdetail.bean.MyCommentListBean;
import com.transsion.postdetail.bean.Pager;
import com.transsion.postdetail.bean.PagerBody;
import ip.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import okhttp3.RequestBody;

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
@DebugMetadata(c = "com.transsion.postdetail.comment.ui.CommentListViewModel$getCommentList$1", f = "CommentListViewModel.kt", l = {49}, m = "invokeSuspend")
public final class CommentListViewModel$getCommentList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CommentListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentListViewModel$getCommentList$1(CommentListViewModel commentListViewModel, Continuation<? super CommentListViewModel$getCommentList$1> continuation) {
        super(2, continuation);
        this.this$0 = commentListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CommentListViewModel$getCommentList$1 commentListViewModel$getCommentList$1 = new CommentListViewModel$getCommentList$1(this.this$0, continuation);
        commentListViewModel$getCommentList$1.L$0 = obj;
        return commentListViewModel$getCommentList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((CommentListViewModel$getCommentList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Throwable thM166exceptionOrNullimpl;
        CommentListViewModel commentListViewModel;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                CommentListViewModel commentListViewModel2 = this.this$0;
                Result.Companion companion = Result.Companion;
                b.a aVar = b.f67591a;
                String strJ = n.j(new PagerBody(commentListViewModel2.f54978f, Boxing.d(commentListViewModel2.f54979g)));
                Intrinsics.f(strJ, "toJson(PagerBody(mPage, mLimit))");
                RequestBody requestBodyA = aVar.a(strJ);
                if (requestBodyA != null) {
                    xv.a aVarJ = commentListViewModel2.j();
                    this.L$0 = commentListViewModel2;
                    this.label = 1;
                    Object objA = xv.a.C0906a.a(aVarJ, requestBodyA, null, this, 2, null);
                    if (objA == objE) {
                        return objE;
                    }
                    commentListViewModel = commentListViewModel2;
                    obj = objA;
                }
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("error:");
                    sb2.append(thM166exceptionOrNullimpl);
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            commentListViewModel = (CommentListViewModel) this.L$0;
            ResultKt.b(obj);
            MyCommentListBean myCommentListBean = (MyCommentListBean) ((BaseDto) obj).getData();
            if (myCommentListBean != null) {
                Pager pager = myCommentListBean.getPager();
                if (pager != null) {
                    commentListViewModel.f54978f = String.valueOf(pager.getNextPage());
                    pager.getNextPage();
                    commentListViewModel.f54980h = Intrinsics.b(pager.getHasMore(), Boxing.a(true));
                }
                List list = commentListViewModel.f54977d;
                List<CommentBean> commentList = myCommentListBean.getCommentList();
                if (commentList == null) {
                    commentList = g.l();
                }
                list.addAll(commentList);
                commentListViewModel.k().n(commentListViewModel.f54977d);
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("error:");
            sb3.append(thM166exceptionOrNullimpl);
        }
        return Unit.f68710a;
    }
}
