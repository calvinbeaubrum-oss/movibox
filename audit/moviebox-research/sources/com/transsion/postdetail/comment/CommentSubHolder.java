package com.transsion.postdetail.comment;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
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
import kotlin.text.StringsKt__StringsKt;

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
public final class CommentSubHolder extends BaseViewHolder implements z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f54906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f54907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f54908d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f54909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f54910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f54911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f54912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f54913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f54914k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f54915l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ShapeableImageView f54916m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentSubHolder(View view) {
        super(view);
        Intrinsics.g(view, "view");
        this.f54906b = (ImageView) view.findViewById(R$id.item_comment_sub_user_avatar);
        this.f54907c = (TextView) view.findViewById(R$id.item_comment_sub_user_name);
        this.f54908d = (TextView) view.findViewById(R$id.item_comment_sub_content);
        this.f54909f = (ImageView) view.findViewById(R$id.item_comment_sub_like_icon);
        this.f54913j = (TextView) view.findViewById(R$id.item_comment_sub_like_count);
        this.f54914k = (TextView) view.findViewById(R$id.item_comment_sub_data);
        this.f54915l = view.findViewById(R$id.item_comment_sub_reply);
        this.f54911h = view.findViewById(R$id.iv_comment_reply);
        this.f54912i = (TextView) view.findViewById(R$id.tv_comment_sub_reply_user_name);
        this.f54910g = view.findViewById(R$id.item_comment_sub_like_click_bg);
        this.f54916m = (ShapeableImageView) view.findViewById(R$id.sub_comment_cover);
        ImageView imageView = this.f54906b;
        if (imageView != null) {
            imageView.setClipToOutline(true);
            imageView.setOutlineProvider(new is.f(f0.a(10.0f)));
        }
    }

    public static final void k(e9.a aVar, CommentSubHolder this$0, View view) {
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
        this$0.p(context, 1, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(y yVar, e9.a aVar, View view) {
        if (yVar != null) {
            yVar.s((CommentBean) aVar);
        }
    }

    public static final void m(CommentSubHolder this$0, y yVar, e9.a aVar, View view) {
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.base_net_err);
            return;
        }
        ImageView imageView = this$0.f54909f;
        if (imageView != null) {
            if (imageView.isEnabled()) {
                imageView.setEnabled(false);
                TextView textView = this$0.f54913j;
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
                CommentBean commentBean2 = (CommentBean) aVar;
                commentBean2.setLikeStatu(Boolean.TRUE);
                commentBean2.setLikeCnt(commentBean2.getLikeCnt() + 1);
                TextView textView2 = this$0.f54913j;
                if (textView2 != null) {
                    textView2.setEnabled(true);
                }
            }
            this$0.q(this$0.f54913j, ((CommentBean) aVar).getLikeCnt());
        }
        if (yVar != null) {
            yVar.t((CommentBean) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(y yVar, e9.a aVar, View view) {
        if (yVar != null) {
            yVar.G((CommentBean) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(y yVar, e9.a aVar, View view) {
        if (yVar == null) {
            return true;
        }
        yVar.e((CommentBean) aVar);
        return true;
    }

    private final void p(Context context, int i11, List<Image> list) {
        Intent intent = new Intent(context, (Class<?>) GifImagePreviewActivity.class);
        Intrinsics.e(list, "null cannot be cast to non-null type java.io.Serializable");
        intent.putExtra(GifImagePreviewActivity.IMAGE_LIST, (Serializable) list);
        intent.putExtra("CURRENT_ITEM", i11);
        context.startActivity(intent);
    }

    private final void q(TextView textView, int i11) {
        if (textView == null) {
            return;
        }
        textView.setText(i11 > 0 ? r.f54963a.a(i11) : "");
    }

    @Override // com.transsion.postdetail.comment.z
    public void b(int i11, final e9.a aVar, final y yVar) {
        String replyedNickName;
        String url;
        if (aVar instanceof CommentBean) {
            CommentBean commentBean = (CommentBean) aVar;
            ImageView imageView = this.f54906b;
            if (imageView != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = imageView.getContext();
                Intrinsics.f(context, "this.context");
                String avatarUrl = commentBean.getAvatarUrl();
                companion.r(context, imageView, avatarUrl == null ? "" : avatarUrl, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CommentSubHolder.l(yVar, aVar, view);
                    }
                });
            }
            List<Cover> imageList = commentBean.getImageList();
            if (imageList == null || !(!imageList.isEmpty())) {
                ShapeableImageView shapeableImageView = this.f54916m;
                if (shapeableImageView != null) {
                    shapeableImageView.setVisibility(8);
                }
            } else {
                ShapeableImageView shapeableImageView2 = this.f54916m;
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
            TextView textView = this.f54907c;
            if (textView != null) {
                String nickName = commentBean.getNickName();
                if (nickName == null) {
                    nickName = "";
                }
                textView.setText(nickName);
            }
            TextView textView2 = this.f54908d;
            if (textView2 != null) {
                com.transsion.baseui.util.k.e(textView2, commentBean.getContent(), null);
                if (commentBean.getRootCommentId() == null || Intrinsics.b(commentBean.getRootCommentId(), commentBean.getReplyedCommentId()) || (replyedNickName = commentBean.getReplyedNickName()) == null || replyedNickName.length() == 0 || Intrinsics.b(commentBean.getReplyedCommentId(), "0")) {
                    textView2.setText(commentBean.getContent());
                } else {
                    String str = textView2.getContext().getString(R$string.comment_reply) + " " + commentBean.getReplyedNickName() + " " + commentBean.getContent();
                    String replyedNickName2 = commentBean.getReplyedNickName();
                    if (replyedNickName2 == null) {
                        replyedNickName2 = "";
                    }
                    textView2.setText(j(str, replyedNickName2));
                }
            }
            q(this.f54913j, commentBean.getLikeCnt());
            ImageView imageView2 = this.f54909f;
            if (imageView2 != null) {
                Boolean likeStatu = commentBean.getLikeStatu();
                imageView2.setEnabled(likeStatu != null ? likeStatu.booleanValue() : false);
            }
            TextView textView3 = this.f54914k;
            if (textView3 != null) {
                r rVar = r.f54963a;
                Context context3 = this.itemView.getContext();
                Intrinsics.f(context3, "itemView.context");
                Long createdAt = commentBean.getCreatedAt();
                textView3.setText(rVar.c(context3, createdAt != null ? createdAt.longValue() : 0L));
            }
            View view = this.f54910g;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        CommentSubHolder.m(this.f54966a, yVar, aVar, view2);
                    }
                });
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommentSubHolder.n(yVar, aVar, view2);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.transsion.postdetail.comment.v
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return CommentSubHolder.o(yVar, aVar, view2);
                }
            });
            ShapeableImageView shapeableImageView3 = this.f54916m;
            if (shapeableImageView3 != null) {
                shapeableImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.comment.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        CommentSubHolder.k(aVar, this, view2);
                    }
                });
            }
        }
    }

    public final SpannableString j(String str, String str2) {
        int iD0 = StringsKt__StringsKt.d0(str, str2, 0, false, 6, null);
        SpannableString spannableString = new SpannableString(str);
        if (iD0 >= 0) {
            spannableString.setSpan(new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_60)), iD0, str2.length() + iD0, 33);
        }
        return spannableString;
    }
}
