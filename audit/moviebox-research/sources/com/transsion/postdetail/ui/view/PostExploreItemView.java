package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.User;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.w0;

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
public final class PostExploreItemView extends PostBaseItemView {

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.view.PostExploreItemView$setHeaderData$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.view.PostExploreItemView$setHeaderData$1", f = "PostExploreItemView.kt", l = {49}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ PostSubjectItem $item;
        int label;
        final /* synthetic */ PostExploreItemView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PostSubjectItem postSubjectItem, PostExploreItemView postExploreItemView, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$item = postSubjectItem;
            this.this$0 = postExploreItemView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$item, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String avatar;
            AssetManager assets;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                Group group = this.$item.getGroup();
                if (group != null && (avatar = group.getAvatar()) != null) {
                    PostExploreItemView postExploreItemView = this.this$0;
                    Context context = postExploreItemView.getViewBinding().f77933g.getContext();
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(avatar));
                    a2 a2VarC = w0.c();
                    PostExploreItemView$setHeaderData$1$1$1 postExploreItemView$setHeaderData$1$1$1 = new PostExploreItemView$setHeaderData$1$1$1(postExploreItemView, bitmapDecodeStream, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(a2VarC, postExploreItemView$setHeaderData$1$1$1, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.view.PostExploreItemView$setHeaderData$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.view.PostExploreItemView$setHeaderData$4", f = "PostExploreItemView.kt", l = {82}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ PostSubjectItem $item;
        int label;
        final /* synthetic */ PostExploreItemView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(PostSubjectItem postSubjectItem, PostExploreItemView postExploreItemView, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$item = postSubjectItem;
            this.this$0 = postExploreItemView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$item, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String avatar;
            AssetManager assets;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                User user = this.$item.getUser();
                if (user != null && (avatar = user.getAvatar()) != null) {
                    PostExploreItemView postExploreItemView = this.this$0;
                    Context context = postExploreItemView.getViewBinding().f77934h.getContext();
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(avatar));
                    a2 a2VarC = w0.c();
                    PostExploreItemView$setHeaderData$4$1$1 postExploreItemView$setHeaderData$4$1$1 = new PostExploreItemView$setHeaderData$4$1$1(postExploreItemView, bitmapDecodeStream, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(a2VarC, postExploreItemView$setHeaderData$4$1$1, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostExploreItemView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostExploreItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostExploreItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
    }

    @Override // com.transsion.postdetail.ui.view.PostBaseItemView
    public void setHeaderData(PostSubjectItem item) {
        Unit unit;
        String avatar;
        String name;
        String avatar2;
        String nickname;
        Long lN;
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = getViewBinding().f77933g;
        Intrinsics.f(shapeableImageView, "viewBinding.ivRoomCover");
        so.c.k(shapeableImageView);
        ShapeableImageView shapeableImageView2 = getViewBinding().f77934h;
        Intrinsics.f(shapeableImageView2, "viewBinding.ivUserAvatar");
        so.c.k(shapeableImageView2);
        BLView bLView = getViewBinding().f77950x;
        if (bLView != null) {
            so.c.k(bLView);
        }
        ShapeableImageView shapeableImageView3 = getViewBinding().f77935i;
        Intrinsics.f(shapeableImageView3, "viewBinding.ivUserAvatar2");
        so.c.g(shapeableImageView3);
        BLView bLView2 = getViewBinding().f77951y;
        if (bLView2 != null) {
            so.c.g(bLView2);
        }
        if (item.getBuiltIn()) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.b()), null, null, new AnonymousClass1(item, this, null), 3, null);
        } else {
            Group group = item.getGroup();
            if (group == null || (avatar = group.getAvatar()) == null) {
                unit = null;
            } else {
                getViewBinding().f77933g.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = getContext();
                Intrinsics.f(context, "context");
                ShapeableImageView shapeableImageView4 = getViewBinding().f77933g;
                Intrinsics.f(shapeableImageView4, "viewBinding.ivRoomCover");
                companion.o(context, shapeableImageView4, avatar, (32704 & 8) != 0 ? R$color.skeleton : R$color.transparent, (32704 & 16) != 0 ? companion.d() : getDp36(), (32704 & 32) != 0 ? companion.c() : getDp36(), (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
                unit = Unit.f68710a;
            }
            if (unit == null) {
                getViewBinding().f77933g.setScaleType(ImageView.ScaleType.CENTER);
                getViewBinding().f77933g.setImageResource(R$drawable.ic_group_def_bg);
            }
        }
        AppCompatTextView appCompatTextView = getViewBinding().f77943q;
        Group group2 = item.getGroup();
        if (group2 == null || (name = group2.getName()) == null) {
            name = "Moviebox Community";
        }
        appCompatTextView.setText(name);
        AppCompatTextView appCompatTextView2 = getViewBinding().f77941o;
        String createdAt = item.getCreatedAt();
        appCompatTextView2.setText(com.transsion.postdetail.util.i.b((createdAt == null || (lN = kotlin.text.k.n(createdAt)) == null) ? 0L : lN.longValue()));
        String str = "";
        if (item.getBuiltIn()) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.b()), null, null, new AnonymousClass4(item, this, null), 3, null);
        } else {
            ImageHelper.Companion companion2 = ImageHelper.f51371a;
            Context context2 = getContext();
            Intrinsics.f(context2, "context");
            ShapeableImageView shapeableImageView5 = getViewBinding().f77934h;
            Intrinsics.f(shapeableImageView5, "viewBinding.ivUserAvatar");
            User user = item.getUser();
            companion2.r(context2, shapeableImageView5, (user == null || (avatar2 = user.getAvatar()) == null) ? "" : avatar2, (4088 & 8) != 0 ? companion2.d() : getDp16(), (4088 & 16) != 0 ? companion2.c() : getDp16(), (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        String poiName = item.getPoiName();
        if (poiName != null && poiName.length() != 0) {
            AppCompatImageView appCompatImageView = getViewBinding().f77931d;
            Intrinsics.f(appCompatImageView, "viewBinding.ivLocationIcon");
            so.c.k(appCompatImageView);
            View view = getViewBinding().f77946t;
            Intrinsics.f(view, "viewBinding.vLocationLine");
            so.c.k(view);
            getViewBinding().f77944r.setText(item.getPoiName());
            return;
        }
        AppCompatImageView appCompatImageView2 = getViewBinding().f77931d;
        Intrinsics.f(appCompatImageView2, "viewBinding.ivLocationIcon");
        so.c.g(appCompatImageView2);
        View view2 = getViewBinding().f77946t;
        Intrinsics.f(view2, "viewBinding.vLocationLine");
        so.c.g(view2);
        AppCompatTextView appCompatTextView3 = getViewBinding().f77944r;
        User user2 = item.getUser();
        if (user2 != null && (nickname = user2.getNickname()) != null) {
            str = nickname;
        }
        appCompatTextView3.setText(str);
    }

    @Override // com.transsion.postdetail.ui.view.PostBaseItemView
    public void setSubjectAndRoomContent(PostSubjectItem item) {
        Intrinsics.g(item, "item");
        if (item.getSubject() == null) {
            setBottomSubjectAndRoomVisibility(false, false);
        } else {
            setBottomSubjectAndRoomVisibility(true, false);
            setBottomSubjectModuleData(item);
        }
    }
}
