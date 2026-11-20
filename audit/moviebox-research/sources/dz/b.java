package dz;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.message.UserMessageType;
import com.transsion.usercenter.message.bean.MessageEntity;
import h9.f;
import h9.i;
import h9.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class b extends BaseQuickAdapter<MessageEntity, BaseViewHolder> implements j {
    public b(int i11) {
        super(i11, null, 2, null);
    }

    public /* synthetic */ b(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? R$layout.item_room_message : i11);
    }

    private final void G0(BaseViewHolder baseViewHolder, MessageEntity messageEntity) {
        int i11;
        String url;
        View view = baseViewHolder.getView(R$id.iv_avatar);
        Intrinsics.e(view, "null cannot be cast to non-null type com.google.android.material.imageview.ShapeableImageView");
        ShapeableImageView shapeableImageView = (ShapeableImageView) view;
        baseViewHolder.setText(R$id.tv_avatar, messageEntity.getNickname());
        int i12 = R$id.tv_date;
        com.transsion.usercenter.message.b.a aVar = com.transsion.usercenter.message.b.f59473a;
        baseViewHolder.setText(i12, aVar.b(Long.parseLong(messageEntity.getCreatedAt())));
        ImageHelper.Companion companion = ImageHelper.f51371a;
        companion.r(getContext(), shapeableImageView, messageEntity.getAvator(), (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        AppCompatTextView appCompatTextView = (AppCompatTextView) baseViewHolder.getView(R$id.tv_content);
        String content = messageEntity.getContent();
        if (content == null || content.length() == 0) {
            appCompatTextView.setVisibility(8);
        } else {
            appCompatTextView.setText(messageEntity.getContent());
            appCompatTextView.setVisibility(0);
        }
        ShapeableImageView shapeableImageView2 = (ShapeableImageView) baseViewHolder.getView(R$id.comment_cover);
        List<Image> commentImages = messageEntity.getCommentImages();
        if (commentImages == null || !(!commentImages.isEmpty())) {
            shapeableImageView2.setVisibility(8);
        } else {
            shapeableImageView2.setVisibility(0);
            Context context = shapeableImageView2.getContext();
            Intrinsics.f(context, "this.context");
            List<Image> commentImages2 = messageEntity.getCommentImages();
            Intrinsics.d(commentImages2);
            String url2 = commentImages2.get(0).getUrl();
            companion.r(context, shapeableImageView2, url2 == null ? "" : url2, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        baseViewHolder.setText(R$id.tv_date, I0(messageEntity.getType()) + " " + aVar.b(Long.parseLong(messageEntity.getCreatedAt())));
        ShapeableImageView shapeableImageView3 = (ShapeableImageView) baseViewHolder.getView(R$id.iv_comment);
        Cover image = messageEntity.getImage();
        String url3 = image != null ? image.getUrl() : null;
        if (url3 == null || url3.length() == 0) {
            i11 = 0;
            shapeableImageView3.setVisibility(8);
        } else {
            Context context2 = getContext();
            Cover image2 = messageEntity.getImage();
            companion.r(context2, shapeableImageView3, (image2 == null || (url = image2.getUrl()) == null) ? "" : url, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            i11 = 0;
            shapeableImageView3.setVisibility(0);
        }
        baseViewHolder.setVisible(R$id.view_red_blank, Intrinsics.b(messageEntity.getStatus(), "UNREAD"));
        if (Intrinsics.b(messageEntity.getStatus(), "UNREAD")) {
            baseViewHolder.itemView.setBackgroundColor(z2.a.getColor(getContext(), R$color.white_10));
        } else {
            baseViewHolder.itemView.setBackgroundColor(i11);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, MessageEntity item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        G0(holder, item);
    }

    public final String I0(String str) {
        if (Intrinsics.b(str, UserMessageType.LIKE.getValue())) {
            String string = getContext().getString(R$string.message_like_type);
            Intrinsics.f(string, "context.getString(R.string.message_like_type)");
            return string;
        }
        if (Intrinsics.b(str, UserMessageType.LIKE_COMMENT.getValue())) {
            String string2 = getContext().getString(R$string.message_like_comment_type);
            Intrinsics.f(string2, "context.getString(R.stri…essage_like_comment_type)");
            return string2;
        }
        if (Intrinsics.b(str, UserMessageType.COMMENT.getValue())) {
            String string3 = getContext().getString(R$string.message_comment_type);
            Intrinsics.f(string3, "context.getString(R.string.message_comment_type)");
            return string3;
        }
        if (!Intrinsics.b(str, UserMessageType.REPLY_COMMENT.getValue())) {
            return "";
        }
        String string4 = getContext().getString(R$string.message_reply_comment_type);
        Intrinsics.f(string4, "context.getString(R.stri…ssage_reply_comment_type)");
        return string4;
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
