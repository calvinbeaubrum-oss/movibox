package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.NoScrollRecyclerView2;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.adapter.RoomPostContentImageAdapter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
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
@SourceDebugExtension
public abstract class PostBaseItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f56027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f56028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f56029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f56030d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f56031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f56032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final tv.t f56033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView.s f56034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f56035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f56036k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f56037l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends DiffUtil.e<Image> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(Image oldItem, Image newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getUrl(), newItem.getUrl());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(Image oldItem, Image newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getUrl(), newItem.getUrl());
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.view.PostBaseItemView$setBottomRoomModuleData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.view.PostBaseItemView$setBottomRoomModuleData$1", f = "PostBaseItemView.kt", l = {DownloadException.EXCEPTION_IO_HTTP_RETRY}, m = "invokeSuspend")
    public static final class C20181 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ PostSubjectItem $item;
        int label;
        final /* synthetic */ PostBaseItemView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20181(PostSubjectItem postSubjectItem, PostBaseItemView postBaseItemView, Continuation<? super C20181> continuation) {
            super(2, continuation);
            this.$item = postSubjectItem;
            this.this$0 = postBaseItemView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C20181(this.$item, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C20181) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Group group;
            Cover cover;
            String url;
            AssetManager assets;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                Group group2 = this.$item.getGroup();
                if ((group2 == null || group2.getAvatar() == null) && (group = this.$item.getGroup()) != null && (cover = group.getCover()) != null && (url = cover.getUrl()) != null) {
                    PostBaseItemView postBaseItemView = this.this$0;
                    Context context = postBaseItemView.getContext();
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(url));
                    a2 a2VarC = w0.c();
                    PostBaseItemView$setBottomRoomModuleData$1$1$1 postBaseItemView$setBottomRoomModuleData$1$1$1 = new PostBaseItemView$setBottomRoomModuleData$1$1$1(postBaseItemView, bitmapDecodeStream, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(a2VarC, postBaseItemView$setBottomRoomModuleData$1$1$1, this) == objE) {
                        return objE;
                    }
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Unit unit = Unit.f68710a;
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.view.PostBaseItemView$setBottomSubjectModuleData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.view.PostBaseItemView$setBottomSubjectModuleData$1", f = "PostBaseItemView.kt", l = {386}, m = "invokeSuspend")
    public static final class C20191 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ PostSubjectItem $item;
        int label;
        final /* synthetic */ PostBaseItemView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20191(PostSubjectItem postSubjectItem, PostBaseItemView postBaseItemView, Continuation<? super C20191> continuation) {
            super(2, continuation);
            this.$item = postSubjectItem;
            this.this$0 = postBaseItemView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C20191(this.$item, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C20191) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Cover cover;
            String url;
            AssetManager assets;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                Subject subject = this.$item.getSubject();
                if (subject != null && (cover = subject.getCover()) != null && (url = cover.getUrl()) != null) {
                    PostBaseItemView postBaseItemView = this.this$0;
                    Context context = postBaseItemView.getContext();
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(url));
                    a2 a2VarC = w0.c();
                    PostBaseItemView$setBottomSubjectModuleData$1$1$1 postBaseItemView$setBottomSubjectModuleData$1$1$1 = new PostBaseItemView$setBottomSubjectModuleData$1$1$1(postBaseItemView, bitmapDecodeStream, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(a2VarC, postBaseItemView$setBottomSubjectModuleData$1$1$1, this) == objE) {
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

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.view.PostBaseItemView$setHeaderPostData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.view.PostBaseItemView$setHeaderPostData$1", f = "PostBaseItemView.kt", l = {322}, m = "invokeSuspend")
    public static final class C20201 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ PostSubjectItem $item;
        int label;
        final /* synthetic */ PostBaseItemView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20201(PostSubjectItem postSubjectItem, PostBaseItemView postBaseItemView, Continuation<? super C20201> continuation) {
            super(2, continuation);
            this.$item = postSubjectItem;
            this.this$0 = postBaseItemView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C20201(this.$item, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C20201) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
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
                    PostBaseItemView postBaseItemView = this.this$0;
                    Context context = postBaseItemView.getContext();
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(avatar));
                    a2 a2VarC = w0.c();
                    PostBaseItemView$setHeaderPostData$1$1$1 postBaseItemView$setHeaderPostData$1$1$1 = new PostBaseItemView$setHeaderPostData$1$1$1(postBaseItemView, bitmapDecodeStream, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(a2VarC, postBaseItemView$setHeaderPostData$1$1$1, this) == objE) {
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
    public PostBaseItemView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostBaseItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostBaseItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f56027a = gs.a.a(36);
        this.f56028b = gs.a.a(16);
        this.f56029c = gs.a.a(32);
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        this.f56030d = com.transsion.baseui.util.b.a(context2) ? gs.a.a(LogSeverity.NOTICE_VALUE) : com.blankj.utilcode.util.d0.e() - gs.a.a(72);
        this.f56031f = gs.a.a(78);
        this.f56032g = gs.a.a(280);
        View.inflate(getContext(), R$layout.item_provider_room_post_base_layout, this);
        setPadding(0, 0, 0, gs.a.a(4));
        tv.t tVarA = tv.t.a(this);
        Intrinsics.f(tVarA, "bind(this)");
        this.f56033h = tVarA;
    }

    public static final void A(Function0 onCLickSubject, View view) {
        Intrinsics.g(onCLickSubject, "$onCLickSubject");
        onCLickSubject.invoke();
    }

    public static final void l(PostBaseItemView this$0, String content) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(content, "$content");
        AppCompatTextView setPostContentDes$lambda$2$lambda$1 = this$0.f56033h.f77940n;
        Intrinsics.f(setPostContentDes$lambda$2$lambda$1, "setPostContentDes$lambda$2$lambda$1");
        com.transsion.baseui.util.k.g(setPostContentDes$lambda$2$lambda$1, content, null);
    }

    public static final void m(PostSubjectItem item, PostBaseItemView this$0, boolean z11) {
        FirstFrame firstFrame;
        String url;
        String thumbnail;
        Cover cover;
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        Media media = item.getMedia();
        if (media == null || (firstFrame = media.getFirstFrame()) == null || (url = firstFrame.getUrl()) == null) {
            return;
        }
        if (item.getBuiltIn()) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.b()), null, null, new PostBaseItemView$setPostVideo$1$1$1(this$0, url, null), 3, null);
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = this$0.getContext();
        ShapeableImageView ivCover = this$0.f56033h.f77937k.f77717d;
        int iA = z11 ? gs.a.a(280) : gs.a.a(162);
        int iA2 = gs.a.a(z11 ? 218 : 280);
        Media media2 = item.getMedia();
        if (media2 == null || (cover = media2.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
            thumbnail = "";
        }
        String str = thumbnail;
        Intrinsics.f(context, "context");
        Intrinsics.f(ivCover, "ivCover");
        companion.q(context, ivCover, url, (8120 & 8) != 0 ? companion.d() : iA2, (8120 & 16) != 0 ? companion.c() : iA, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : str, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
    }

    public static final void o(Function0 onCLickComment, View view) {
        Intrinsics.g(onCLickComment, "$onCLickComment");
        onCLickComment.invoke();
    }

    public static final void q(Function0 onCLickHeader, View view) {
        Intrinsics.g(onCLickHeader, "$onCLickHeader");
        onCLickHeader.invoke();
    }

    public static final void r(Function0 onCLickHeader, View view) {
        Intrinsics.g(onCLickHeader, "$onCLickHeader");
        onCLickHeader.invoke();
    }

    public static final void s(Function0 onCLickHeader, View view) {
        Intrinsics.g(onCLickHeader, "$onCLickHeader");
        onCLickHeader.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setBottomBarClick$default(PostBaseItemView postBaseItemView, PostSubjectItem postSubjectItem, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function0 function4, Function0 function5, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBottomBarClick");
        }
        postBaseItemView.setBottomBarClick(postSubjectItem, (i11 & 2) != 0 ? new Function0<Unit>() { // from class: com.transsion.postdetail.ui.view.PostBaseItemView.setBottomBarClick.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function0, (i11 & 4) != 0 ? new Function0<Unit>() { // from class: com.transsion.postdetail.ui.view.PostBaseItemView.setBottomBarClick.2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function1, (i11 & 8) != 0 ? new Function0<Unit>() { // from class: com.transsion.postdetail.ui.view.PostBaseItemView.setBottomBarClick.3
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function2, (i11 & 16) != 0 ? new Function0<Unit>() { // from class: com.transsion.postdetail.ui.view.PostBaseItemView.setBottomBarClick.4
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function3, (i11 & 32) != 0 ? new Function0<Unit>() { // from class: com.transsion.postdetail.ui.view.PostBaseItemView.setBottomBarClick.5
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function4, (i11 & 64) != 0 ? new Function0<Unit>() { // from class: com.transsion.postdetail.ui.view.PostBaseItemView.setBottomBarClick.6
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function5);
    }

    private final void setBottomBarContent(PostSubjectItem postSubjectItem) {
        AppCompatTextView appCompatTextView = this.f56033h.f77942p;
        Stat stat = postSubjectItem.getStat();
        Long likeCount = stat != null ? stat.getLikeCount() : null;
        String strA = "";
        appCompatTextView.setText((likeCount == null || likeCount.longValue() == 0) ? "" : com.transsion.baseui.util.j.a(likeCount.longValue()));
        if (Intrinsics.b(postSubjectItem.getHasLike(), Boolean.TRUE)) {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R$mipmap.ic_post_like_selected, 0, 0, 0);
        } else {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.ic_post_like, 0, 0, 0);
        }
        Stat stat2 = postSubjectItem.getStat();
        Long commentCount = stat2 != null ? stat2.getCommentCount() : null;
        AppCompatTextView appCompatTextView2 = this.f56033h.f77939m;
        if (commentCount != null && commentCount.longValue() != 0) {
            strA = com.transsion.baseui.util.j.a(commentCount.longValue());
        }
        appCompatTextView2.setText(strA);
    }

    public static /* synthetic */ void setHeaderPostData$default(PostBaseItemView postBaseItemView, PostSubjectItem postSubjectItem, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderPostData");
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        postBaseItemView.setHeaderPostData(postSubjectItem, z11);
    }

    private final void setPostContent(PostSubjectItem postSubjectItem) {
        List<Image> image;
        setPostContentDes(postSubjectItem);
        Media media = postSubjectItem.getMedia();
        String mediaType = media != null ? media.getMediaType() : null;
        if (Intrinsics.b(mediaType, MediaType.TEXT.getValue())) {
            FrameLayout frameLayout = this.f56033h.f77929b;
            Intrinsics.f(frameLayout, "viewBinding.flContent");
            so.c.g(frameLayout);
            return;
        }
        if (Intrinsics.b(mediaType, MediaType.IMAGE.getValue())) {
            FrameLayout frameLayout2 = this.f56033h.f77929b;
            Intrinsics.f(frameLayout2, "viewBinding.flContent");
            Media media2 = postSubjectItem.getMedia();
            frameLayout2.setVisibility(media2 != null && (image = media2.getImage()) != null && image.size() > 0 ? 0 : 8);
            setPostImage(postSubjectItem);
            return;
        }
        if (Intrinsics.b(mediaType, MediaType.AUDIO.getValue())) {
            FrameLayout frameLayout3 = this.f56033h.f77929b;
            Intrinsics.f(frameLayout3, "viewBinding.flContent");
            so.c.g(frameLayout3);
        } else if (!Intrinsics.b(mediaType, MediaType.VIDEO.getValue())) {
            FrameLayout frameLayout4 = this.f56033h.f77929b;
            Intrinsics.f(frameLayout4, "viewBinding.flContent");
            so.c.g(frameLayout4);
        } else {
            FrameLayout frameLayout5 = this.f56033h.f77929b;
            Intrinsics.f(frameLayout5, "viewBinding.flContent");
            so.c.k(frameLayout5);
            setPostVideo(postSubjectItem);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0018 A[PHI: r4
  0x0018: PHI (r4v11 java.lang.String) = (r4v3 java.lang.String), (r4v12 java.lang.String) binds: [B:17:0x002b, B:8:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    private final void setPostContentDes(PostSubjectItem postSubjectItem) {
        String title;
        String content = postSubjectItem.getContent();
        final String str = "";
        if (content == null || content.length() == 0) {
            String title2 = postSubjectItem.getTitle();
            if (title2 == null || title2.length() == 0) {
                AppCompatTextView appCompatTextView = this.f56033h.f77940n;
                Intrinsics.f(appCompatTextView, "viewBinding.tvPostContent");
                so.c.g(appCompatTextView);
                return;
            } else {
                title = postSubjectItem.getTitle();
                if (title != null) {
                    str = title;
                }
            }
        } else {
            title = postSubjectItem.getContent();
            if (title != null) {
                str = title;
            }
        }
        AppCompatTextView appCompatTextView2 = this.f56033h.f77940n;
        Intrinsics.f(appCompatTextView2, "viewBinding.tvPostContent");
        so.c.k(appCompatTextView2);
        if (!this.f56035j) {
            this.f56033h.f77940n.post(new Runnable() { // from class: com.transsion.postdetail.ui.view.r
                @Override // java.lang.Runnable
                public final void run() {
                    PostBaseItemView.l(this.f56157a, str);
                }
            });
            return;
        }
        AppCompatTextView setPostContentDes$lambda$0 = this.f56033h.f77940n;
        Intrinsics.f(setPostContentDes$lambda$0, "setPostContentDes$lambda$0");
        com.transsion.baseui.util.k.e(setPostContentDes$lambda$0, str, null);
    }

    private final void setPostImage(PostSubjectItem postSubjectItem) {
        List<Image> image;
        List<Image> image2;
        Media media = postSubjectItem.getMedia();
        int size = (media == null || (image2 = media.getImage()) == null) ? 0 : image2.size();
        CardView cardView = this.f56033h.f77937k.f77716c;
        Intrinsics.f(cardView, "viewBinding.layoutContentVideo.flVideo");
        so.c.g(cardView);
        if (size == 0) {
            NoScrollRecyclerView2 noScrollRecyclerView2 = this.f56033h.f77938l;
            Intrinsics.f(noScrollRecyclerView2, "viewBinding.recyclerViewPost");
            so.c.g(noScrollRecyclerView2);
            return;
        }
        NoScrollRecyclerView2 noScrollRecyclerView3 = this.f56033h.f77938l;
        Intrinsics.f(noScrollRecyclerView3, "viewBinding.recyclerViewPost");
        so.c.k(noScrollRecyclerView3);
        int i11 = 1;
        if (size != 1) {
            i11 = 2;
            if (size != 2 && size != 4) {
                i11 = 3;
            }
        }
        Media media2 = postSubjectItem.getMedia();
        if (media2 == null || (image = media2.getImage()) == null) {
            return;
        }
        Context context = getContext();
        Intrinsics.f(context, "context");
        RoomPostContentImageAdapter roomPostContentImageAdapter = new RoomPostContentImageAdapter(i11, com.transsion.baseui.util.b.a(context), this.f56036k, this.f56037l, postSubjectItem);
        roomPostContentImageAdapter.o0(new a());
        NoScrollRecyclerView2 noScrollRecyclerView4 = this.f56033h.f77938l;
        RecyclerView.s sVar = this.f56034i;
        if (sVar != null) {
            noScrollRecyclerView4.setRecycledViewPool(sVar);
        }
        noScrollRecyclerView4.setLayoutManager(new NpaGridLayoutManager(noScrollRecyclerView4.getContext(), i11));
        if (noScrollRecyclerView4.getItemDecorationCount() == 0) {
            noScrollRecyclerView4.addItemDecoration(new ro.a(gs.a.a(3), gs.a.a(3), 0, 0));
        }
        noScrollRecyclerView4.setAdapter(roomPostContentImageAdapter);
        roomPostContentImageAdapter.w0(image);
    }

    private final void setPostVideo(final PostSubjectItem postSubjectItem) {
        int i11;
        int i12;
        int i13;
        Video video;
        Integer duration;
        int i14;
        List<Video> video2;
        Video video3;
        Integer height;
        FirstFrame firstFrame;
        Integer height2;
        Cover cover;
        Integer height3;
        List<Video> video4;
        Video video5;
        Integer width;
        FirstFrame firstFrame2;
        Integer width2;
        Cover cover2;
        Integer width3;
        NoScrollRecyclerView2 noScrollRecyclerView2 = this.f56033h.f77938l;
        Intrinsics.f(noScrollRecyclerView2, "viewBinding.recyclerViewPost");
        so.c.g(noScrollRecyclerView2);
        CardView cardView = this.f56033h.f77937k.f77716c;
        Intrinsics.f(cardView, "viewBinding.layoutContentVideo.flVideo");
        so.c.k(cardView);
        Media media = postSubjectItem.getMedia();
        int iIntValue = 0;
        int iIntValue2 = (media == null || (cover2 = media.getCover()) == null || (width3 = cover2.getWidth()) == null) ? 0 : width3.intValue();
        Media media2 = postSubjectItem.getMedia();
        int iIntValue3 = (media2 == null || (firstFrame2 = media2.getFirstFrame()) == null || (width2 = firstFrame2.getWidth()) == null) ? 0 : width2.intValue();
        Media media3 = postSubjectItem.getMedia();
        int iIntValue4 = (media3 == null || (video4 = media3.getVideo()) == null || (video5 = (Video) CollectionsKt___CollectionsKt.g0(video4)) == null || (width = video5.getWidth()) == null) ? 0 : width.intValue();
        if (iIntValue2 > 0) {
            i11 = iIntValue2;
        } else if (iIntValue3 > 0) {
            i11 = iIntValue3;
        } else {
            i11 = iIntValue4 > 0 ? iIntValue4 : 0;
        }
        Media media4 = postSubjectItem.getMedia();
        int iIntValue5 = (media4 == null || (cover = media4.getCover()) == null || (height3 = cover.getHeight()) == null) ? 0 : height3.intValue();
        Media media5 = postSubjectItem.getMedia();
        int iIntValue6 = (media5 == null || (firstFrame = media5.getFirstFrame()) == null || (height2 = firstFrame.getHeight()) == null) ? 0 : height2.intValue();
        Media media6 = postSubjectItem.getMedia();
        int iIntValue7 = (media6 == null || (video2 = media6.getVideo()) == null || (video3 = (Video) CollectionsKt___CollectionsKt.g0(video2)) == null || (height = video3.getHeight()) == null) ? 0 : height.intValue();
        if (iIntValue2 <= 0) {
            if (iIntValue3 > 0) {
                iIntValue5 = iIntValue6;
            } else {
                iIntValue5 = iIntValue4 > 0 ? iIntValue7 : 0;
            }
        }
        final boolean z11 = iIntValue5 > i11;
        ViewGroup.LayoutParams layoutParams = this.f56033h.f77937k.f77716c.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (z11) {
            i12 = this.f56030d - this.f56031f;
        } else {
            Context context = getContext();
            Intrinsics.f(context, "context");
            i12 = com.transsion.baseui.util.b.a(context) ? this.f56030d : -1;
        }
        if (iIntValue5 <= 0 || i11 <= 0) {
            i13 = (this.f56030d * 9) / 16;
        } else {
            i13 = ((z11 ? i12 : this.f56030d) * iIntValue5) / i11;
        }
        if (z11 && i13 > (i14 = this.f56032g)) {
            i13 = i14;
        }
        marginLayoutParams.width = i12;
        marginLayoutParams.height = i13;
        this.f56033h.f77937k.f77716c.setLayoutParams(marginLayoutParams);
        this.f56033h.f77937k.f77716c.post(new Runnable() { // from class: com.transsion.postdetail.ui.view.p
            @Override // java.lang.Runnable
            public final void run() {
                PostBaseItemView.m(postSubjectItem, this, z11);
            }
        });
        BLTextView setPostVideo$lambda$12 = this.f56033h.f77937k.f77719g;
        Media media7 = postSubjectItem.getMedia();
        List<Video> video6 = media7 != null ? media7.getVideo() : null;
        if (video6 == null || video6.size() <= 0) {
            Intrinsics.f(setPostVideo$lambda$12, "setPostVideo$lambda$12");
            so.c.g(setPostVideo$lambda$12);
            return;
        }
        if (video6 != null && (video = video6.get(0)) != null && (duration = video.getDuration()) != null) {
            iIntValue = duration.intValue();
        }
        if (iIntValue <= 0) {
            Intrinsics.f(setPostVideo$lambda$12, "setPostVideo$lambda$12");
            so.c.g(setPostVideo$lambda$12);
        } else {
            setPostVideo$lambda$12.setText(TimeUtilKt.j(iIntValue));
            Intrinsics.f(setPostVideo$lambda$12, "setPostVideo$lambda$12");
            so.c.k(setPostVideo$lambda$12);
        }
    }

    public static final void u(Function0 onCLickLike, View view) {
        Intrinsics.g(onCLickLike, "$onCLickLike");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        onCLickLike.invoke();
    }

    public static final void w(Function0 onCLickGroup, View view) {
        Intrinsics.g(onCLickGroup, "$onCLickGroup");
        onCLickGroup.invoke();
    }

    public static final void y(Function0 onCLickShare, View view) {
        Intrinsics.g(onCLickShare, "$onCLickShare");
        onCLickShare.invoke();
    }

    public final int getDp16() {
        return this.f56028b;
    }

    public final int getDp32() {
        return this.f56029c;
    }

    public final int getDp36() {
        return this.f56027a;
    }

    public final tv.t getViewBinding() {
        return this.f56033h;
    }

    public final void n(final Function0<Unit> function0, PostSubjectItem postSubjectItem) {
        this.f56033h.f77947u.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.o(function0, view);
            }
        });
    }

    public final void p(final Function0<Unit> function0) {
        this.f56033h.f77943q.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.q(function0, view);
            }
        });
        this.f56033h.f77930c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.r(function0, view);
            }
        });
        this.f56033h.f77941o.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.s(function0, view);
            }
        });
    }

    public final void refreshLike(boolean z11, PostSubjectItem item) {
        Intrinsics.g(item, "item");
        AppCompatTextView appCompatTextView = this.f56033h.f77942p;
        Stat stat = item.getStat();
        Long likeCount = stat != null ? stat.getLikeCount() : null;
        appCompatTextView.setText((likeCount == null || likeCount.longValue() == 0) ? "" : com.transsion.baseui.util.j.a(likeCount.longValue()));
        if (z11) {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R$mipmap.ic_post_like_selected, 0, 0, 0);
        } else {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.ic_post_like, 0, 0, 0);
        }
    }

    public final void setBottomBarClick(PostSubjectItem postSubjectItem, Function0<Unit> onCLickLike, Function0<Unit> onCLickComment, Function0<Unit> onCLickShare, Function0<Unit> onCLickSubject, Function0<Unit> onCLickGroup, Function0<Unit> onCLickHeader) {
        Intrinsics.g(onCLickLike, "onCLickLike");
        Intrinsics.g(onCLickComment, "onCLickComment");
        Intrinsics.g(onCLickShare, "onCLickShare");
        Intrinsics.g(onCLickSubject, "onCLickSubject");
        Intrinsics.g(onCLickGroup, "onCLickGroup");
        Intrinsics.g(onCLickHeader, "onCLickHeader");
        t(onCLickLike, postSubjectItem);
        n(onCLickComment, postSubjectItem);
        x(onCLickShare);
        z(onCLickSubject, postSubjectItem);
        v(onCLickGroup, postSubjectItem);
        p(onCLickHeader);
    }

    public void setBottomRoomModuleData(PostSubjectItem item) {
        String str;
        Cover cover;
        String avatar;
        Intrinsics.g(item, "item");
        AppCompatTextView appCompatTextView = this.f56033h.f77936j.f77697h;
        Group group = item.getGroup();
        String url = null;
        appCompatTextView.setText(group != null ? group.getName() : null);
        if (item.getBuiltIn()) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.b()), null, null, new C20181(item, this, null), 3, null);
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        ShapeableImageView shapeableImageView = this.f56033h.f77936j.f77693c;
        Intrinsics.f(shapeableImageView, "viewBinding.layoutBottomModule.ivRoomCover");
        Group group2 = item.getGroup();
        if (group2 == null || (avatar = group2.getAvatar()) == null) {
            Group group3 = item.getGroup();
            if (group3 != null && (cover = group3.getCover()) != null) {
                url = cover.getUrl();
            }
            str = url == null ? "" : url;
        } else {
            str = avatar;
        }
        int i11 = this.f56029c;
        companion.r(context, shapeableImageView, str, (4088 & 8) != 0 ? companion.d() : i11, (4088 & 16) != 0 ? companion.c() : i11, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
    }

    public void setBottomSubjectAndRoomVisibility(boolean z11, boolean z12) {
        if (z11) {
            BLLinearLayout bLLinearLayoutB = this.f56033h.f77936j.getRoot();
            Intrinsics.f(bLLinearLayoutB, "viewBinding.layoutBottomModule.root");
            so.c.k(bLLinearLayoutB);
            ConstraintLayout constraintLayout = this.f56033h.f77936j.f77692b;
            Intrinsics.f(constraintLayout, "viewBinding.layoutBottomModule.clSubjectContent");
            so.c.k(constraintLayout);
            View view = this.f56033h.f77936j.f77703n;
            Intrinsics.f(view, "viewBinding.layoutBottomModule.vSubjectRoomLine");
            view.setVisibility(z12 ? 0 : 8);
            LinearLayout linearLayout = this.f56033h.f77936j.f77696g;
            Intrinsics.f(linearLayout, "viewBinding.layoutBottomModule.llRoomTag");
            linearLayout.setVisibility(z12 ? 0 : 8);
            return;
        }
        BLLinearLayout bLLinearLayoutB2 = this.f56033h.f77936j.getRoot();
        Intrinsics.f(bLLinearLayoutB2, "viewBinding.layoutBottomModule.root");
        bLLinearLayoutB2.setVisibility(z12 ? 0 : 8);
        ConstraintLayout constraintLayout2 = this.f56033h.f77936j.f77692b;
        Intrinsics.f(constraintLayout2, "viewBinding.layoutBottomModule.clSubjectContent");
        so.c.g(constraintLayout2);
        View view2 = this.f56033h.f77936j.f77703n;
        Intrinsics.f(view2, "viewBinding.layoutBottomModule.vSubjectRoomLine");
        so.c.g(view2);
        LinearLayout linearLayout2 = this.f56033h.f77936j.f77696g;
        Intrinsics.f(linearLayout2, "viewBinding.layoutBottomModule.llRoomTag");
        linearLayout2.setVisibility(z12 ? 0 : 8);
    }

    public void setBottomSubjectModuleData(PostSubjectItem item) {
        Cover cover;
        String thumbnail;
        Cover cover2;
        String url;
        String title;
        Subject subject;
        String genre;
        List listE0;
        String str;
        Intrinsics.g(item, "item");
        String str2 = "";
        if (item.getBuiltIn()) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.b()), null, null, new C20191(item, this, null), 3, null);
        } else {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = getContext();
            Intrinsics.f(context, "context");
            ShapeableImageView shapeableImageView = this.f56033h.f77936j.f77694d;
            Intrinsics.f(shapeableImageView, "viewBinding.layoutBottomModule.ivSubjectCover");
            Subject subject2 = item.getSubject();
            String str3 = (subject2 == null || (cover2 = subject2.getCover()) == null || (url = cover2.getUrl()) == null) ? "" : url;
            int i11 = this.f56029c;
            Subject subject3 = item.getSubject();
            companion.q(context, shapeableImageView, str3, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : i11, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (subject3 == null || (cover = subject3.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }
        AppCompatTextView appCompatTextView = this.f56033h.f77936j.f77700k;
        Subject subject4 = item.getSubject();
        if (subject4 == null || (title = subject4.getTitle()) == null) {
            title = "";
        }
        appCompatTextView.setText(title);
        Subject subject5 = item.getSubject();
        this.f56033h.f77936j.f77695f.setImageResource(com.transsion.moviedetailapi.a.a(subject5 != null ? subject5.getSubjectType() : null));
        Subject subject6 = item.getSubject();
        Date dateK = com.blankj.utilcode.util.h0.k(subject6 != null ? subject6.getReleaseDate() : null, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateK);
        this.f56033h.f77936j.f77698i.setText(String.valueOf(calendar.get(1)));
        Subject subject7 = item.getSubject();
        String genre2 = subject7 != null ? subject7.getGenre() : null;
        if (genre2 != null && genre2.length() != 0 && (subject = item.getSubject()) != null && (genre = subject.getGenre()) != null && (listE0 = StringsKt__StringsKt.E0(genre, new String[]{", "}, false, 0, 6, null)) != null && (str = (String) CollectionsKt___CollectionsKt.g0(listE0)) != null) {
            str2 = str;
        }
        AppCompatTextView appCompatTextView2 = this.f56033h.f77936j.f77699j;
        Intrinsics.f(appCompatTextView2, "viewBinding.layoutBottomModule.tvSubjectGenre");
        appCompatTextView2.setVisibility(str2.length() > 0 ? 0 : 8);
        AppCompatTextView appCompatTextView3 = this.f56033h.f77936j.f77699j;
        Intrinsics.f(appCompatTextView3, "viewBinding.layoutBottomModule.tvSubjectGenre");
        appCompatTextView3.setVisibility(str2.length() > 0 ? 0 : 8);
        this.f56033h.f77936j.f77699j.setText(str2);
    }

    public final void setCommentCount(long j11) {
        tv.t tVar = this.f56033h;
        AppCompatTextView appCompatTextView = tVar != null ? tVar.f77939m : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(j11 == 0 ? "" : com.transsion.baseui.util.j.a(j11));
    }

    public final void setContentMaxLine() {
        this.f56033h.f77940n.setMaxLines(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public final void setData(PostSubjectItem item) {
        Intrinsics.g(item, "item");
        setHeaderData(item);
        setPostContent(item);
        setSubjectAndRoomContent(item);
        setBottomBarContent(item);
    }

    public abstract void setHeaderData(PostSubjectItem postSubjectItem);

    public void setHeaderPostData(PostSubjectItem item, boolean z11) {
        String avatar;
        String poiName;
        Long lN;
        String nickname;
        Intrinsics.g(item, "item");
        String str = "";
        if (item.getBuiltIn()) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.b()), null, null, new C20201(item, this, null), 3, null);
        } else {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = getContext();
            Intrinsics.f(context, "context");
            ShapeableImageView shapeableImageView = this.f56033h.f77935i;
            Intrinsics.f(shapeableImageView, "viewBinding.ivUserAvatar2");
            User user = item.getUser();
            String str2 = (user == null || (avatar = user.getAvatar()) == null) ? "" : avatar;
            int i11 = this.f56028b;
            companion.r(context, shapeableImageView, str2, (4088 & 8) != 0 ? companion.d() : i11, (4088 & 16) != 0 ? companion.c() : i11, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        AppCompatTextView appCompatTextView = this.f56033h.f77943q;
        User user2 = item.getUser();
        if (user2 != null && (nickname = user2.getNickname()) != null) {
            str = nickname;
        }
        appCompatTextView.setText(str);
        AppCompatTextView appCompatTextView2 = this.f56033h.f77941o;
        String createdAt = item.getCreatedAt();
        appCompatTextView2.setText(com.transsion.postdetail.util.i.b((createdAt == null || (lN = kotlin.text.k.n(createdAt)) == null) ? 0L : lN.longValue()));
        View view = this.f56033h.f77946t;
        Intrinsics.f(view, "viewBinding.vLocationLine");
        so.c.g(view);
        String poiName2 = item.getPoiName();
        if (poiName2 == null || poiName2.length() == 0) {
            AppCompatImageView appCompatImageView = this.f56033h.f77931d;
            Intrinsics.f(appCompatImageView, "viewBinding.ivLocationIcon");
            so.c.g(appCompatImageView);
            AppCompatTextView appCompatTextView3 = this.f56033h.f77944r;
            Intrinsics.f(appCompatTextView3, "viewBinding.tvUserNameOrLocation");
            so.c.g(appCompatTextView3);
            return;
        }
        AppCompatTextView appCompatTextView4 = this.f56033h.f77944r;
        Intrinsics.f(appCompatTextView4, "viewBinding.tvUserNameOrLocation");
        so.c.k(appCompatTextView4);
        AppCompatImageView appCompatImageView2 = this.f56033h.f77931d;
        Intrinsics.f(appCompatImageView2, "viewBinding.ivLocationIcon");
        so.c.k(appCompatImageView2);
        String distanceStr = item.getDistanceStr();
        if (distanceStr == null || distanceStr.length() == 0 || !z11) {
            poiName = item.getPoiName();
        } else {
            poiName = item.getPoiName() + " " + item.getDistanceStr();
        }
        this.f56033h.f77944r.setText(poiName);
    }

    public final void setIsDetail(boolean z11) {
        this.f56035j = z11;
    }

    public final void setPage(String str, String str2) {
        this.f56036k = str;
        this.f56037l = str2;
    }

    public final void setRecycledViewPool(RecyclerView.s rvPool) {
        Intrinsics.g(rvPool, "rvPool");
        this.f56034i = rvPool;
    }

    public abstract void setSubjectAndRoomContent(PostSubjectItem postSubjectItem);

    public final void t(final Function0<Unit> function0, PostSubjectItem postSubjectItem) {
        this.f56033h.f77948v.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.u(function0, view);
            }
        });
        if (postSubjectItem != null) {
            setBottomBarContent(postSubjectItem);
        }
    }

    public final void v(final Function0<Unit> function0, PostSubjectItem postSubjectItem) {
        this.f56033h.f77936j.f77696g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.w(function0, view);
            }
        });
    }

    public final void x(final Function0<Unit> function0) {
        View view;
        tv.t tVar = this.f56033h;
        if (tVar == null || (view = tVar.f77949w) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PostBaseItemView.y(function0, view2);
            }
        });
    }

    public final void z(final Function0<Unit> function0, PostSubjectItem postSubjectItem) {
        this.f56033h.f77936j.f77692b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostBaseItemView.A(function0, view);
            }
        });
    }
}
