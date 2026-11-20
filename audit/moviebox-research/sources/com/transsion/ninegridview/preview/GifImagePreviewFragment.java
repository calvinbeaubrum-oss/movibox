package com.transsion.ninegridview.preview;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.d0;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.R$drawable;
import com.transsion.photoview.PhotoView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
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
public final class GifImagePreviewFragment extends BaseFragment<zu.c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f53969d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Image f53970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f53972c = Boolean.FALSE;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GifImagePreviewFragment a(Boolean bool, Image image, int i11) {
            GifImagePreviewFragment gifImagePreviewFragment = new GifImagePreviewFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(GifImagePreviewActivity.IMAGE_LIST, image);
            bundle.putInt("CURRENT_ITEM", i11);
            if (bool != null) {
                bundle.putBoolean(GifImagePreviewActivity.IS_BUILTIN, bool.booleanValue());
            }
            gifImagePreviewFragment.setArguments(bundle);
            return gifImagePreviewFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.transsion.photoview.i {
        public b() {
        }

        @Override // com.transsion.photoview.i
        public void a() {
            if (GifImagePreviewFragment.this.getContext() instanceof GifImagePreviewActivity) {
                Context context = GifImagePreviewFragment.this.getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type com.transsion.ninegridview.preview.GifImagePreviewActivity");
                ((GifImagePreviewActivity) context).finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.transsion.ninegridview.preview.GifImagePreviewFragment$initView$5, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ninegridview.preview.GifImagePreviewFragment$initView$5", f = "GifImagePreviewFragment.kt", l = {139}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ PhotoView $pv;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(String str, PhotoView photoView, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$pv = photoView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.$url, this.$pv, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AssetManager assets;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                String str = this.$url;
                if (str != null) {
                    PhotoView photoView = this.$pv;
                    Context context = photoView.getContext();
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(str));
                    a2 a2VarC = w0.c();
                    GifImagePreviewFragment$initView$5$1$1 gifImagePreviewFragment$initView$5$1$1 = new GifImagePreviewFragment$initView$5$1$1(photoView, bitmapDecodeStream, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(a2VarC, gifImagePreviewFragment$initView$5$1$1, this) == objE) {
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

    public static final void j0(GifImagePreviewFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.getContext() instanceof GifImagePreviewActivity) {
            Context context = this$0.getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type com.transsion.ninegridview.preview.GifImagePreviewActivity");
            ((GifImagePreviewActivity) context).finish();
        }
    }

    public static final void k0(GifImagePreviewFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.getContext() instanceof GifImagePreviewActivity) {
            Context context = this$0.getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type com.transsion.ninegridview.preview.GifImagePreviewActivity");
            ((GifImagePreviewActivity) context).finishActivityAnim();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public zu.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        zu.c cVarC = zu.c.c(inflater);
        Intrinsics.f(cVarC, "inflate(inflater)");
        return cVarC;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00ab  */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        PhotoView photoView;
        String url;
        GifBean gifBean;
        String videoUrl;
        GifBean gifBean2;
        PhotoView photoView2;
        PhotoView photoView3;
        Integer height;
        Integer width;
        FrameLayout frameLayout;
        Intrinsics.g(view, "view");
        zu.c mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout = mViewBinding.f82175b) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GifImagePreviewFragment.j0(this.f53985a, view2);
                }
            });
        }
        Image image = this.f53970a;
        float fE = (image == null || (width = image.getWidth()) == null) ? d0.e() : width.intValue();
        Image image2 = this.f53970a;
        float fC = (image2 == null || (height = image2.getHeight()) == null) ? d0.c() : height.intValue();
        float fE2 = d0.e();
        float f11 = (fC / fE) * fE2;
        zu.c mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (photoView3 = mViewBinding2.f82178f) != null) {
            photoView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GifImagePreviewFragment.k0(this.f53986a, view2);
                }
            });
        }
        zu.c mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (photoView2 = mViewBinding3.f82178f) != null) {
            photoView2.setSlideUpAndDownListener(new b());
        }
        zu.c mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (photoView = mViewBinding4.f82178f) == null) {
            return;
        }
        Image image3 = this.f53970a;
        if (image3 == null || (gifBean = image3.getGifBean()) == null || (videoUrl = gifBean.getVideoUrl()) == null || videoUrl.length() <= 0) {
            Image image4 = this.f53970a;
            if (image4 != null) {
                url = image4.getUrl();
            } else {
                url = null;
            }
        } else {
            Image image5 = this.f53970a;
            if (image5 == null || (gifBean2 = image5.getGifBean()) == null) {
                url = null;
            } else {
                url = gifBean2.getFirstFrameUrl();
            }
        }
        if (Intrinsics.b(this.f53972c, Boolean.TRUE)) {
            Image image6 = this.f53970a;
            if (image6 != null) {
                image6.getUrl();
            }
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new AnonymousClass5(url, photoView, null), 3, null);
            return;
        }
        Image image7 = this.f53970a;
        if (image7 != null) {
            image7.getUrl();
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        if (url == null) {
            url = "";
        }
        companion.o(contextRequireContext, photoView, url, (32704 & 8) != 0 ? R$color.skeleton : R$drawable.ic_default_color, (32704 & 16) != 0 ? companion.d() : (int) fE2, (32704 & 32) != 0 ? companion.c() : (int) f11, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0 ? true : true, (32704 & 256) != 0 ? "" : "", (32704 & 512) != 0 ? true : true, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable(GifImagePreviewActivity.IMAGE_LIST);
            this.f53970a = serializable instanceof Image ? (Image) serializable : null;
            this.f53971b = arguments.getInt("CURRENT_ITEM");
            this.f53972c = Boolean.valueOf(arguments.getBoolean(GifImagePreviewActivity.IS_BUILTIN, false));
        }
    }
}
