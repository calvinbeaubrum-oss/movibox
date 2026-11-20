package com.transsion.postdetail.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.d0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.logging.type.LogSeverity;
import com.noober.background.drawable.DrawableCreator;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.postdetail.R$dimen;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import yi.n;

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
public final class RoomPostContentImageAdapter extends BaseQuickAdapter<Image, BaseViewHolder> {
    public final int H;
    public final boolean I;
    public final String J;
    public final String K;
    public final PostSubjectItem L;
    public final int M;
    public final int N;
    public final int O;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomPostContentImageAdapter(int i11, boolean z11, String str, String str2, PostSubjectItem item) {
        super(R$layout.item_room_post_content_image, null, 2, null);
        Intrinsics.g(item, "item");
        this.H = i11;
        this.I = z11;
        this.J = str;
        this.K = str2;
        this.L = item;
        this.M = z11 ? gs.a.a(LogSeverity.NOTICE_VALUE) : d0.e() - gs.a.a(72);
        this.N = gs.a.a(78);
        this.O = gs.a.a(280);
    }

    public static final void J0(RoomPostContentImageAdapter this$0, BaseViewHolder holder, ShapeableImageView ivCover, Image item) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(holder, "$holder");
        Intrinsics.g(ivCover, "$ivCover");
        Intrinsics.g(item, "$item");
        if (this$0.L.getBuiltIn()) {
            j.d(l0.a(w0.b()), null, null, new RoomPostContentImageAdapter$convert$1$1(item, ivCover, null), 3, null);
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = holder.itemView.getContext();
        Intrinsics.f(context, "holder.itemView.context");
        String url = item.getUrl();
        if (url == null) {
            url = "";
        }
        String thumbnail = item.getThumbnail();
        companion.q(context, ivCover, url, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail == null ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
    }

    public static final void K0(RoomPostContentImageAdapter this$0, BaseViewHolder holder, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(holder, "$holder");
        Intrinsics.f(it, "it");
        this$0.L0(it, holder.getLayoutPosition(), this$0.D());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void x(final BaseViewHolder holder, final Image item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        final ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getView(R$id.iv_cover);
        M0(shapeableImageView, item);
        N0(holder, shapeableImageView);
        holder.itemView.post(new Runnable() { // from class: com.transsion.postdetail.ui.adapter.e
            @Override // java.lang.Runnable
            public final void run() {
                RoomPostContentImageAdapter.J0(this.f55570a, holder, shapeableImageView, item);
            }
        });
        shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.adapter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomPostContentImageAdapter.K0(this.f55574a, holder, view);
            }
        });
    }

    public final void L0(View view, int i11, List<Image> list) {
        String str = this.J;
        if (str != null) {
            com.transsion.postdetail.helper.a.f55063a.l(this.L, str, this.K);
        }
        try {
            Result.Companion companion = Result.Companion;
            Intent intent = new Intent(view.getContext(), (Class<?>) GifImagePreviewActivity.class);
            Intrinsics.e(list, "null cannot be cast to non-null type java.io.Serializable");
            intent.putExtra(GifImagePreviewActivity.IMAGE_LIST, (Serializable) list);
            intent.putExtra("CURRENT_ITEM", i11);
            intent.putExtra(GifImagePreviewActivity.IS_BUILTIN, this.L.getBuiltIn());
            view.getContext().startActivity(intent);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void M0(ImageView imageView, Image image) {
        int i11;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i12 = this.H;
        if (i12 == 1) {
            Integer height = image.getHeight();
            int iIntValue = height != null ? height.intValue() : 0;
            Integer width = image.getWidth();
            int iIntValue2 = width != null ? width.intValue() : 0;
            if (iIntValue <= 0 || iIntValue2 <= 0) {
                marginLayoutParams.width = -1;
                marginLayoutParams.height = this.M;
            } else {
                boolean z11 = iIntValue > iIntValue2;
                int i13 = z11 ? this.M - this.N : -1;
                int i14 = z11 ? (iIntValue * i13) / iIntValue2 : (this.M * iIntValue) / iIntValue2;
                if (z11 && i14 > (i11 = this.O)) {
                    i14 = i11;
                }
                marginLayoutParams.width = i13;
                marginLayoutParams.height = i14;
            }
        } else if (i12 != 2) {
            marginLayoutParams.width = -1;
            marginLayoutParams.height = (this.M - gs.a.a(6)) / 3;
        } else {
            marginLayoutParams.width = -1;
            marginLayoutParams.height = (this.M - gs.a.a(6)) / 2;
        }
        imageView.setLayoutParams(marginLayoutParams);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    /* JADX WARN: Code duplicated, block: B:20:0x0062  */
    /* JADX WARN: Code duplicated, block: B:27:0x0074 A[PHI: r13
  0x0074: PHI (r13v1 float) = (r13v0 float), (r13v0 float), (r13v3 float) binds: [B:22:0x0068, B:24:0x006c, B:26:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    public final void N0(BaseViewHolder baseViewHolder, ShapeableImageView shapeableImageView) {
        float f11;
        float f12;
        int i11;
        float f13;
        int i12;
        float f14;
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        float dimension = baseViewHolder.itemView.getResources().getDimension(R$dimen.corner_radius);
        n.b bVarA = n.a();
        Intrinsics.f(bVarA, "builder()");
        int size = D().size();
        boolean z11 = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        DrawableCreator.Builder builder = new DrawableCreator.Builder();
        int i13 = this.H;
        if (i13 != 1) {
            float f15 = 0.0f;
            if (i13 != 2) {
                float fA = gs.a.a(4);
                if (bindingAdapterPosition == 0) {
                    if (z11) {
                        bVarA.J(0, dimension);
                        f12 = fA;
                        f11 = 0.0f;
                    } else {
                        bVarA.E(0, dimension);
                        f11 = fA;
                    }
                    if (bindingAdapterPosition == 2) {
                        if (z11) {
                            bVarA.E(0, dimension);
                            f11 = fA;
                        } else {
                            bVarA.J(0, dimension);
                            f12 = fA;
                        }
                    }
                    i11 = size - 1;
                    if (bindingAdapterPosition == i11 || size % 3 != 0) {
                        f13 = 0.0f;
                    } else if (z11) {
                        bVarA.t(0, dimension);
                        f15 = fA;
                        f13 = 0.0f;
                    } else {
                        bVarA.y(0, dimension);
                        f13 = fA;
                    }
                    i12 = size % 3;
                    if ((i12 != 1 && bindingAdapterPosition == i11) || ((i12 == 2 && bindingAdapterPosition == size - 2) || (i12 == 0 && bindingAdapterPosition == size - 3))) {
                        if (z11) {
                            bVarA.y(0, dimension);
                            f14 = fA;
                            fA = f15;
                        } else {
                            bVarA.t(0, dimension);
                        }
                        builder.setCornersRadius(fA, f14, f11, f12);
                    }
                    f14 = f13;
                    builder.setCornersRadius(fA, f14, f11, f12);
                } else {
                    f11 = 0.0f;
                }
                f12 = 0.0f;
                if (bindingAdapterPosition == 2) {
                    if (z11) {
                        bVarA.E(0, dimension);
                        f11 = fA;
                    } else {
                        bVarA.J(0, dimension);
                        f12 = fA;
                    }
                }
                i11 = size - 1;
                if (bindingAdapterPosition == i11) {
                    f13 = 0.0f;
                } else {
                    f13 = 0.0f;
                }
                i12 = size % 3;
                fA = i12 != 1 ? f15 : f15;
                f14 = f13;
                builder.setCornersRadius(fA, f14, f11, f12);
            } else {
                if (bindingAdapterPosition == 0) {
                    if (z11) {
                        bVarA.J(0, dimension);
                        builder.setCornersRadius(0.0f, 0.0f, 0.0f, gs.a.a(4));
                    } else {
                        bVarA.E(0, dimension);
                        builder.setCornersRadius(0.0f, 0.0f, gs.a.a(4), 0.0f);
                    }
                }
                if (bindingAdapterPosition == 1) {
                    if (z11) {
                        bVarA.E(0, dimension);
                        builder.setCornersRadius(0.0f, 0.0f, gs.a.a(4), 0.0f);
                    } else {
                        bVarA.J(0, dimension);
                        builder.setCornersRadius(0.0f, 0.0f, 0.0f, gs.a.a(4));
                    }
                }
                if (bindingAdapterPosition == size - 1 && size % 2 == 0) {
                    if (z11) {
                        bVarA.t(0, dimension);
                        builder.setCornersRadius(gs.a.a(4), 0.0f, 0.0f, 0.0f);
                    } else {
                        bVarA.y(0, dimension);
                        builder.setCornersRadius(0.0f, gs.a.a(4), 0.0f, 0.0f);
                    }
                }
                if (bindingAdapterPosition == size - 2 && size >= 2 && size % 2 == 0) {
                    if (z11) {
                        bVarA.y(0, dimension);
                        builder.setCornersRadius(0.0f, gs.a.a(4), 0.0f, 0.0f);
                    } else {
                        bVarA.t(0, dimension);
                        builder.setCornersRadius(gs.a.a(4), 0.0f, 0.0f, 0.0f);
                    }
                }
            }
        } else {
            bVarA.q(0, dimension);
            builder.setCornersRadius(gs.a.a(4));
        }
        baseViewHolder.getView(R$id.v_stroke).setBackground(builder.setStrokeColor(Utils.a().getResources().getColor(R$color.white_10)).setStrokeWidth(gs.a.a(1)).build());
        shapeableImageView.setShapeAppearanceModel(bVarA.m());
    }
}
