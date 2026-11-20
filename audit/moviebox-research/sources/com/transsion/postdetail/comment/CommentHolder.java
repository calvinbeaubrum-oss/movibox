package com.transsion.postdetail.comment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.bean.CommentBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class CommentHolder extends BaseViewHolder implements z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f54896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f54897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatTextView f54898d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f54899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f54900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f54901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f54902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f54903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f54904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ShapeableImageView f54905l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentHolder(View view) {
        super(view);
        Intrinsics.g(view, "view");
        this.f54896b = (ImageView) view.findViewById(R$id.item_comment_user_avatar);
        this.f54897c = (TextView) view.findViewById(R$id.item_comment_user_name);
        this.f54898d = (AppCompatTextView) view.findViewById(R$id.item_comment_content);
        this.f54899f = (ImageView) view.findViewById(R$id.item_comment_like_icon);
        this.f54901h = (TextView) view.findViewById(R$id.item_comment_like_count);
        this.f54902i = (TextView) view.findViewById(R$id.item_comment_data);
        this.f54903j = view.findViewById(R$id.item_comment_reply);
        this.f54900g = view.findViewById(R$id.item_comment_like_click_bg);
        this.f54904k = view.findViewById(R$id.item_comment_top_line);
        this.f54905l = (ShapeableImageView) view.findViewById(R$id.comment_cover);
        ImageView imageView = this.f54896b;
        if (imageView != null) {
            imageView.setClipToOutline(true);
            imageView.setOutlineProvider(new is.f(f0.a(16.0f)));
        }
    }

    public static final void j(e9.a aVar, CommentHolder this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        List<Cover> imageList = ((CommentBean) aVar).getImageList();
        if (imageList != null) {
            for (Cover cover : imageList) {
                Image image = new Image(null, null, null, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, 0, 16383, null);
                image.setUrl(cover != null ? cover.getUrl() : null);
                arrayList.add(image);
            }
        }
        Context context = this$0.itemView.getContext();
        Intrinsics.f(context, "itemView.context");
        this$0.o(context, 1, arrayList);
    }

    public static final void k(y yVar, e9.a aVar, View view) {
        if (yVar != null) {
            yVar.s((CommentBean) aVar);
        }
    }

    public static final void l(CommentHolder this$0, e9.a aVar, y yVar, View view) {
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.base_net_err);
            return;
        }
        ImageView imageView = this$0.f54899f;
        if (imageView != null) {
            if (imageView.isEnabled()) {
                imageView.setEnabled(false);
                TextView textView = this$0.f54901h;
                if (textView != null) {
                    textView.setEnabled(false);
                }
                CommentBean commentBean = (CommentBean) aVar;
                commentBean.setLikeStatu(Boolean.FALSE);
                if (commentBean.getLikeCnt() > 0) {
                    commentBean.setLikeCnt(commentBean.getLikeCnt() - 1);
                }
            } else {
                imageView.setEnabled(true);
                TextView textView2 = this$0.f54901h;
                if (textView2 != null) {
                    textView2.setEnabled(true);
                }
                CommentBean commentBean2 = (CommentBean) aVar;
                commentBean2.setLikeStatu(Boolean.TRUE);
                commentBean2.setLikeCnt(commentBean2.getLikeCnt() + 1);
            }
        }
        CommentBean commentBean3 = (CommentBean) aVar;
        this$0.p(this$0.f54901h, commentBean3.getLikeCnt());
        if (yVar != null) {
            yVar.t(commentBean3);
        }
    }

    public static final void m(y yVar, e9.a aVar, View view) {
        if (yVar != null) {
            yVar.G((CommentBean) aVar);
        }
    }

    public static final boolean n(y yVar, e9.a aVar, View view) {
        if (yVar == null) {
            return true;
        }
        yVar.e((CommentBean) aVar);
        return true;
    }

    @Override // com.transsion.postdetail.comment.z
    public void b(int i11, final e9.a aVar, final y yVar) {
        String url;
        if (aVar instanceof CommentBean) {
            CommentBean commentBean = (CommentBean) aVar;
            ImageView imageView = this.f54896b;
            if (imageView != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = imageView.getContext();
                Intrinsics.f(context, "this.context");
                String avatarUrl = commentBean.getAvatarUrl();
                companion.r(context, imageView, avatarUrl == null ? "" : avatarUrl, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CommentHolder.k(yVar, aVar, view);
                    }
                });
            }
            List<Cover> imageList = commentBean.getImageList();
            if (imageList == null || !(!imageList.isEmpty())) {
                ShapeableImageView shapeableImageView = this.f54905l;
                if (shapeableImageView != null) {
                    shapeableImageView.setVisibility(8);
                }
            } else {
                ShapeableImageView shapeableImageView2 = this.f54905l;
                if (shapeableImageView2 != null) {
                    shapeableImageView2.setVisibility(0);
                    ImageHelper.Companion companion2 = ImageHelper.f51371a;
                    Context context2 = shapeableImageView2.getContext();
                    Intrinsics.f(context2, "this.context");
                    List<Cover> imageList2 = commentBean.getImageList();
                    Intrinsics.d(imageList2);
                    Cover cover = imageList2.get(0);
                    companion2.r(context2, shapeableImageView2, (cover == null || (url = cover.getUrl()) == null) ? "" : url, (4088 & 8) != 0 ? companion2.d() : 0, (4088 & 16) != 0 ? companion2.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
                }
            }
            TextView textView = this.f54897c;
            if (textView != null) {
                String nickName = commentBean.getNickName();
                if (nickName == null) {
                    nickName = "";
                }
                textView.setText(nickName);
            }
            AppCompatTextView appCompatTextView = this.f54898d;
            if (appCompatTextView != null) {
                com.transsion.baseui.util.k.e(appCompatTextView, commentBean.getContent(), null);
            }
            ImageView imageView2 = this.f54899f;
            if (imageView2 != null) {
                Boolean likeStatu = commentBean.getLikeStatu();
                imageView2.setEnabled(likeStatu != null ? likeStatu.booleanValue() : false);
            }
            TextView textView2 = this.f54901h;
            if (textView2 != null) {
                Boolean likeStatu2 = commentBean.getLikeStatu();
                textView2.setEnabled(likeStatu2 != null ? likeStatu2.booleanValue() : false);
            }
            p(this.f54901h, commentBean.getLikeCnt());
            TextView textView3 = this.f54902i;
            if (textView3 != null) {
                r rVar = r.f54963a;
                Context context3 = this.itemView.getContext();
                Intrinsics.f(context3, "itemView.context");
                Long createdAt = commentBean.getCreatedAt();
                textView3.setText(rVar.c(context3, createdAt != null ? createdAt.longValue() : 0L));
            }
            if (i11 > 0) {
                View view = this.f54904k;
                if (view != null) {
                    view.setVisibility(0);
                }
            } else {
                View view2 = this.f54904k;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            View view3 = this.f54900g;
            if (view3 != null) {
                view3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        CommentHolder.l(this.f54954a, aVar, yVar, view4);
                    }
                });
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    CommentHolder.m(yVar, aVar, view4);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.transsion.postdetail.comment.p
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view4) {
                    return CommentHolder.n(yVar, aVar, view4);
                }
            });
            ShapeableImageView shapeableImageView3 = this.f54905l;
            if (shapeableImageView3 != null) {
                shapeableImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        CommentHolder.j(aVar, this, view4);
                    }
                });
            }
        }
    }

    public final void o(Context context, int i11, List<Image> list) {
        Intent intent = new Intent(context, (Class<?>) GifImagePreviewActivity.class);
        Intrinsics.e(list, "null cannot be cast to non-null type java.io.Serializable");
        intent.putExtra(GifImagePreviewActivity.IMAGE_LIST, (Serializable) list);
        intent.putExtra("CURRENT_ITEM", i11);
        context.startActivity(intent);
    }

    public final void p(TextView textView, int i11) {
        if (textView == null) {
            return;
        }
        textView.setText(i11 > 0 ? r.f54963a.a(i11) : "");
    }
}
