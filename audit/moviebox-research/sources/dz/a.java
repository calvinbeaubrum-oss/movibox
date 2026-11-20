package dz;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.h;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.usercenter.R$color;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.message.bean.MessageEntity;
import h9.f;
import h9.i;
import h9.j;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a extends BaseQuickAdapter<MessageEntity, BaseViewHolder> implements j {
    public static final C0653a J = new C0653a(null);
    public final String H;
    public final String I;

    /* JADX INFO: renamed from: dz.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0653a {
        public C0653a() {
        }

        public /* synthetic */ C0653a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i11) {
        super(i11, null, 2, null);
        this.H = "LIKE";
        this.I = "LIKE_COMMENT";
    }

    public /* synthetic */ a(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? R$layout.item_message_comment : i11);
    }

    public final void G0(BaseViewHolder baseViewHolder, MessageEntity messageEntity) {
        int i11 = R$id.tvContent;
        String content = messageEntity.getContent();
        baseViewHolder.setText(i11, content != null ? com.transsion.usercenter.message.a.f59472a.a("", content, h.a(R$color.color_ff999999)) : null);
    }

    public final void H0(BaseViewHolder baseViewHolder, MessageEntity messageEntity) {
        View view = baseViewHolder.getView(R$id.imAvatar);
        Intrinsics.e(view, "null cannot be cast to non-null type com.google.android.material.imageview.ShapeableImageView");
        baseViewHolder.setText(R$id.tvNickName, messageEntity.getNickname());
        baseViewHolder.setText(R$id.tvTime, com.transsion.usercenter.message.b.f59473a.b(Long.parseLong(messageEntity.getCreatedAt())));
        baseViewHolder.setVisible(R$id.view_red_blank, Intrinsics.b(messageEntity.getStatus(), "UNREAD"));
        int iA = f0.a(48.0f);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        companion.r(getContext(), (ShapeableImageView) view, messageEntity.getAvator(), (4088 & 8) != 0 ? companion.d() : iA, (4088 & 16) != 0 ? companion.c() : iA, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, MessageEntity item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        H0(holder, item);
        M0(holder, item);
    }

    public final float J0(Context context, float f11) {
        Intrinsics.g(context, "context");
        return TypedValue.applyDimension(1, f11, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public final void K0(BaseViewHolder baseViewHolder, MessageEntity messageEntity) {
        int i11 = R$id.tvContent;
        String content = messageEntity.getContent();
        baseViewHolder.setText(i11, content != null ? com.transsion.usercenter.message.a.f59472a.a("", content, h.a(R$color.color_ff999999)) : null);
    }

    public final void L0(BaseViewHolder baseViewHolder, MessageEntity messageEntity) {
        View view = baseViewHolder.getView(R$id.imCover);
        Intrinsics.e(view, "null cannot be cast to non-null type android.widget.ImageView");
        int iA = f0.a(56.0f);
        String picture = messageEntity.getPicture();
        ImageHelper.Companion companion = ImageHelper.f51371a;
        companion.o(getContext(), (ImageView) view, picture, (32704 & 8) != 0 ? com.tn.lib.widget.R$color.skeleton : h.a(R$color.color_ff999999), (32704 & 16) != 0 ? companion.d() : iA, (32704 & 32) != 0 ? companion.c() : iA, (32704 & 64) != 0 ? 0 : (int) J0(getContext(), 2.0f), (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0039  */
    public final void M0(BaseViewHolder baseViewHolder, MessageEntity messageEntity) {
        String type = messageEntity.getType();
        int iHashCode = type.hashCode();
        if (iHashCode != -1833998801) {
            if (iHashCode != 32166346) {
                if (iHashCode == 1668381247 && type.equals("COMMENT")) {
                    G0(baseViewHolder, messageEntity);
                } else {
                    baseViewHolder.setText(R$id.tvContent, messageEntity.getContent());
                }
            } else if (type.equals("REPLY_COMMENT")) {
                K0(baseViewHolder, messageEntity);
            } else {
                baseViewHolder.setText(R$id.tvContent, messageEntity.getContent());
            }
        } else if (type.equals("SYSTEM")) {
            baseViewHolder.setText(R$id.tvContent, messageEntity.getTitle());
        } else {
            baseViewHolder.setText(R$id.tvContent, messageEntity.getContent());
        }
        L0(baseViewHolder, messageEntity);
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
