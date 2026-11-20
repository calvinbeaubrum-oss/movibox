package com.transsion.postdetail.comment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.bean.CommentBean;
import com.transsion.postdetail.bean.CommentListBean;
import com.transsion.postdetail.bean.Pager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class l extends BaseMultiItemQuickAdapter<e9.a, BaseViewHolder> implements h9.j {
    public static final a K = new a(null);
    public y I;
    public final HashMap<String, CommentBean> J;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public l(y yVar) {
        super(null, 1, null);
        this.I = yVar;
        this.J = new HashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, e9.a item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        if (holder instanceof z) {
            ((z) holder).b(P(item), item, this.I);
        }
    }

    public final rv.a J0(CommentBean commentBean, int i11) {
        Long createdAt;
        List<CommentBean> subComments = commentBean.getSubComments();
        if (subComments == null) {
            return null;
        }
        String commentId = commentBean.getCommentId();
        int subCommentCnt = commentBean.getSubCommentCnt();
        int size = subComments.size();
        CommentBean commentBean2 = subComments.get(subComments.size() - 1);
        return new rv.a(commentId, subCommentCnt, size, false, (commentBean2 == null || (createdAt = commentBean2.getCreatedAt()) == null) ? 0L : createdAt.longValue(), commentBean.getTopicId(), i11);
    }

    public final List<e9.a> K0(CommentListBean commentListBean) {
        List<CommentBean> commentList;
        Integer perPage;
        ArrayList arrayList = new ArrayList();
        this.J.clear();
        if (commentListBean != null && (commentList = commentListBean.getCommentList()) != null) {
            for (CommentBean commentBean : commentList) {
                if (!this.J.containsKey(commentBean.getCommentId())) {
                    arrayList.add(commentBean);
                    HashMap<String, CommentBean> map = this.J;
                    String commentId = commentBean.getCommentId();
                    Intrinsics.d(commentId);
                    map.put(commentId, commentBean);
                    List<CommentBean> subComments = commentBean.getSubComments();
                    if (subComments != null) {
                        for (CommentBean commentBean2 : subComments) {
                            if (!this.J.containsKey(commentBean2 != null ? commentBean2.getCommentId() : null)) {
                                HashMap<String, CommentBean> map2 = this.J;
                                String commentId2 = commentBean2 != null ? commentBean2.getCommentId() : null;
                                Intrinsics.d(commentId2);
                                map2.put(commentId2, commentBean2);
                                arrayList.add(commentBean2);
                            }
                        }
                    }
                    List<CommentBean> subComments2 = commentBean.getSubComments();
                    int size = subComments2 != null ? subComments2.size() : 0;
                    List<CommentBean> subComments3 = commentBean.getSubComments();
                    if (subComments3 != null && (!subComments3.isEmpty()) && commentBean.getSubCommentCnt() > size) {
                        Pager pager = commentListBean.getPager();
                        rv.a aVarJ0 = J0(commentBean, M0(size, (pager == null || (perPage = pager.getPerPage()) == null) ? 10 : perPage.intValue()));
                        if (aVarJ0 != null) {
                            arrayList.add(aVarJ0);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final HashMap<String, CommentBean> L0() {
        return this.J;
    }

    public final int M0(int i11, int i12) {
        return ((i11 - 3) / i12) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewRecycled(holder);
        ImageView imageView = ((holder instanceof CommentHolder) || (holder instanceof CommentSubHolder)) ? (ImageView) holder.itemView.findViewById(R$id.item_comment_user_avatar) : null;
        if (imageView != null) {
            Context context = getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null || !activity.isDestroyed()) {
                Context context2 = getContext();
                Activity activity2 = context2 instanceof Activity ? (Activity) context2 : null;
                if (activity2 == null || !activity2.isFinishing()) {
                    Glide.with(imageView).clear(imageView);
                }
            }
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void O0(CommentListBean commentListBean) {
        w0(K0(commentListBean));
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g0 */
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int i11) {
        BaseViewHolder commentHolder;
        Intrinsics.g(parent, "parent");
        if (i11 == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_comment, parent, false);
            Intrinsics.f(view, "view");
            commentHolder = new CommentHolder(view);
        } else if (i11 == 1) {
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_comment_sub, parent, false);
            Intrinsics.f(view2, "view");
            commentHolder = new CommentSubHolder(view2);
        } else {
            if (i11 != 2) {
                return super.onCreateViewHolder(parent, i11);
            }
            View view3 = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_comment_sub_more, parent, false);
            Intrinsics.f(view3, "view");
            commentHolder = new CommentSubMoreHolder(view3);
        }
        return commentHolder;
    }
}
