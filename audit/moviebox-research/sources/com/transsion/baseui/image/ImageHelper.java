package com.transsion.baseui.image;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.d0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.integration.cronet.CronetEngineSingleton;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.blurhash.BlurHash;
import com.transsion.baseui.image.blurhash.BlurHashExtKt;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import org.chromium.net.CronetEngine;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ImageHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f51371a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f51372b = d0.e() / 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f51373c = d0.b() / 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f51374d = d0.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static final BlurHash f51375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final DrawableTransitionOptions f51376f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes7.dex */
        @Metadata
        public static final class a implements RequestListener<Drawable> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f51377a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function3<Boolean, Boolean, Long, Unit> f51378b;

            /* JADX WARN: Multi-variable type inference failed */
            public a(long j11, Function3<? super Boolean, ? super Boolean, ? super Long, Unit> function3) {
                this.f51377a = j11;
                this.f51378b = function3;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f51377a;
                Function3<Boolean, Boolean, Long, Unit> function3 = this.f51378b;
                if (function3 != null) {
                    function3.invoke(Boolean.TRUE, Boolean.valueOf(dataSource != DataSource.REMOTE), Long.valueOf(jCurrentTimeMillis));
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f51377a;
                Function3<Boolean, Boolean, Long, Unit> function3 = this.f51378b;
                if (function3 == null) {
                    return false;
                }
                Boolean bool = Boolean.FALSE;
                function3.invoke(bool, bool, Long.valueOf(jCurrentTimeMillis));
                return false;
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes7.dex */
        @Metadata
        public static final class b implements RequestListener<Drawable> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f51379a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function3<Boolean, Boolean, Long, Unit> f51380b;

            /* JADX WARN: Multi-variable type inference failed */
            public b(long j11, Function3<? super Boolean, ? super Boolean, ? super Long, Unit> function3) {
                this.f51379a = j11;
                this.f51380b = function3;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f51379a;
                Function3<Boolean, Boolean, Long, Unit> function3 = this.f51380b;
                if (function3 != null) {
                    function3.invoke(Boolean.TRUE, Boolean.valueOf(dataSource != DataSource.REMOTE), Long.valueOf(jCurrentTimeMillis));
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f51379a;
                Function3<Boolean, Boolean, Long, Unit> function3 = this.f51380b;
                if (function3 == null) {
                    return false;
                }
                Boolean bool = Boolean.FALSE;
                function3.invoke(bool, bool, Long.valueOf(jCurrentTimeMillis));
                return false;
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes7.dex */
        @Metadata
        public static final class c implements RequestListener<Drawable> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f51381a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function3<Boolean, Boolean, Long, Unit> f51382b;

            /* JADX WARN: Multi-variable type inference failed */
            public c(long j11, Function3<? super Boolean, ? super Boolean, ? super Long, Unit> function3) {
                this.f51381a = j11;
                this.f51382b = function3;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f51381a;
                Function3<Boolean, Boolean, Long, Unit> function3 = this.f51382b;
                if (function3 != null) {
                    function3.invoke(Boolean.TRUE, Boolean.valueOf(dataSource != DataSource.REMOTE), Long.valueOf(jCurrentTimeMillis));
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f51381a;
                Function3<Boolean, Boolean, Long, Unit> function3 = this.f51382b;
                if (function3 == null) {
                    return false;
                }
                Boolean bool = Boolean.FALSE;
                function3.invoke(bool, bool, Long.valueOf(jCurrentTimeMillis));
                return false;
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes7.dex */
        @Metadata
        public static final class d extends CustomTarget<Bitmap> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<Bitmap, Unit> f51383a;

            /* JADX WARN: Multi-variable type inference failed */
            public d(Function1<? super Bitmap, Unit> function1) {
                this.f51383a = function1;
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
                this.f51383a.invoke(null);
                uo.b.a.f(uo.b.f78622a, "ImageHelper", "onFailure", false, 4, null);
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                Intrinsics.g(resource, "resource");
                this.f51383a.invoke(resource);
                uo.b.a.f(uo.b.f78622a, "ImageHelper", "onSuccess", false, 4, null);
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes7.dex */
        @Metadata
        public static final class e implements RequestListener<Drawable> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<Boolean, Unit> f51384a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f51385b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f51386c;

            /* JADX WARN: Multi-variable type inference failed */
            public e(Function1<? super Boolean, Unit> function1, String str, int i11) {
                this.f51384a = function1;
                this.f51385b = str;
                this.f51386c = i11;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                com.transsion.baseui.image.e.f51399a.h(this.f51385b, this.f51386c);
                Function1<Boolean, Unit> function1 = this.f51384a;
                if (function1 == null) {
                    return true;
                }
                function1.invoke(Boolean.TRUE);
                return true;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                Function1<Boolean, Unit> function1 = this.f51384a;
                if (function1 == null) {
                    return true;
                }
                function1.invoke(Boolean.FALSE);
                return true;
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void m(Companion companion, Context context, ImageView imageView, String str, int i11, int i12, int i13, int i14, boolean z11, String str2, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i15, Priority priority, Function3 function3, int i16, Object obj) {
            companion.l(context, imageView, str, (i16 & 8) != 0 ? R$color.cl37 : i11, (i16 & 16) != 0 ? 0 : i12, (i16 & 32) != 0 ? -1 : i13, (i16 & 64) != 0 ? -1 : i14, (i16 & 128) != 0 ? true : z11, (i16 & 256) != 0 ? "" : str2, (i16 & 512) != 0 ? true : z12, (i16 & 1024) != 0 ? true : z13, (i16 & 2048) != 0 ? false : z14, (i16 & 4096) != 0 ? false : z15, (i16 & 8192) != 0 ? false : z16, (i16 & 16384) != 0 ? 25 : i15, (32768 & i16) != 0 ? Priority.NORMAL : priority, (i16 & 65536) != 0 ? null : function3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void x(Companion companion, String str, String str2, int i11, Function1 function1, int i12, Object obj) {
            if ((i12 & 8) != 0) {
                function1 = null;
            }
            companion.w(str, str2, i11, function1);
        }

        public static /* synthetic */ RequestOptions z(Companion companion, int i11, int i12, int i13, int i14, Priority priority, int i15, Object obj) {
            if ((i15 & 16) != 0) {
                priority = Priority.NORMAL;
            }
            return companion.y(i11, i12, i13, i14, priority);
        }

        public final Bitmap a(ImageView imageView) {
            Intrinsics.g(imageView, "imageView");
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Intrinsics.f(bitmap, "drawable.bitmap");
                return bitmap;
            }
            if (drawable == null) {
                return null;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                intrinsicWidth = imageView.getWidth();
                intrinsicHeight = imageView.getHeight();
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Intrinsics.f(bitmapCreateBitmap, "createBitmap(width, heig… Bitmap.Config.ARGB_8888)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        }

        public final int b() {
            return ImageHelper.f51372b;
        }

        public final int c() {
            return ImageHelper.f51374d;
        }

        public final int d() {
            return ImageHelper.f51373c;
        }

        public final String e(String url, int i11, int i12, boolean z11, boolean z12, boolean z13, int i13) {
            Intrinsics.g(url, "url");
            return com.transsion.baseui.image.e.f51399a.d(url, i11, (56 & 4) != 0 ? true : z11, (56 & 8) != 0, (56 & 16) != 0 ? 0 : 0, (56 & 32) != 0 ? false : false, (56 & 64) != 0 ? false : z12, (56 & 128) != 0 ? false : z13, (56 & 256) != 0 ? 25 : i13);
        }

        public final void g(Context context, ImageView imageView, Object obj, int i11, int i12, int i13, int i14) {
            Intrinsics.g(context, "context");
            Intrinsics.g(imageView, "imageView");
            if ((context instanceof FragmentActivity) && ((FragmentActivity) context).isDestroyed()) {
                return;
            }
            RequestManager requestManagerWith = Glide.with(context);
            Intrinsics.f(requestManagerWith, "with(context)");
            i(requestManagerWith, imageView, obj, i11, i12, i13, i14);
        }

        public final void h(View view, ImageView imageView, Object obj, int i11, int i12, int i13, int i14) {
            Intrinsics.g(view, "view");
            Intrinsics.g(imageView, "imageView");
            RequestManager requestManagerWith = Glide.with(view);
            Intrinsics.f(requestManagerWith, "with(view)");
            i(requestManagerWith, imageView, obj, i11, i12, i14, i13);
        }

        public final void i(RequestManager requestManager, ImageView imageView, Object obj, int i11, int i12, int i13, int i14) {
            if (obj == null) {
                imageView.setImageResource(i11);
            } else {
                requestManager.load(obj).apply((BaseRequestOptions<?>) z(this, i11, i12, i14, i13, null, 16, null)).into(imageView);
            }
        }

        /* JADX WARN: Code duplicated, block: B:41:0x012b A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:42:0x012d  */
        /* JADX WARN: Code duplicated, block: B:43:0x013c  */
        /* JADX WARN: Code duplicated, block: B:46:0x0168  */
        /* JADX WARN: Code duplicated, block: B:47:0x016b  */
        /* JADX WARN: Code duplicated, block: B:49:0x016e  */
        public final void l(Context context, final ImageView imageView, String str, int i11, int i12, int i13, int i14, boolean z11, String str2, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i15, Priority priority, Function3<? super Boolean, ? super Boolean, ? super Long, Unit> function3) {
            String str3;
            String strA;
            String str4;
            String strD;
            long jCurrentTimeMillis;
            RequestBuilder<Drawable> requestBuilderLoad;
            int i16;
            if ((context instanceof FragmentActivity) && ((FragmentActivity) context).isDestroyed()) {
                return;
            }
            com.transsion.baseui.image.e eVar = com.transsion.baseui.image.e.f51399a;
            int iC = eVar.c(str);
            if (1 > iC || iC >= i13 + 1) {
                if (str2.length() != 0 || i13 <= 96 || iC > i13) {
                    str3 = str2;
                } else {
                    strA = eVar.a(str, 32, (56 & 4) != 0 ? true : z11, (56 & 8) != 0, (56 & 16) != 0 ? 0 : 0, (56 & 32) != 0 ? false : false, (56 & 64) != 0 ? false : z16, (56 & 128) != 0 ? 25 : i15);
                }
                str4 = str3;
                strD = eVar.d(str, i13, (56 & 4) != 0 ? true : z11, (56 & 8) != 0 ? true : z12, (56 & 16) != 0 ? 0 : i14, (56 & 32) != 0 ? false : z15, (56 & 64) != 0 ? false : false, (56 & 128) != 0 ? false : z16, (56 & 256) != 0 ? 25 : i15);
                jCurrentTimeMillis = System.currentTimeMillis();
                if (!l.L(str4, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null) || l.L(str4, "data:image", false, 2, null)) {
                    if (z13) {
                        requestBuilderLoad = (RequestBuilder) Glide.with(context).load(str4).optionalCenterCrop();
                    } else {
                        requestBuilderLoad = Glide.with(context).load(str4);
                    }
                    Intrinsics.f(requestBuilderLoad, "if (thumbScaleType) {\n  …allUrl)\n                }");
                    RequestBuilder<Drawable> requestBuilderTransition = Glide.with(context).load(strD).thumbnail(requestBuilderLoad).listener(new a(jCurrentTimeMillis, function3)).transition(ImageHelper.f51376f);
                    if (z14) {
                        i16 = i14;
                    } else {
                        i16 = -1;
                    }
                    requestBuilderTransition.apply((BaseRequestOptions<?>) y(i11, i12, i16, z14 ? i13 : -1, priority)).into(imageView);
                } else if (str4.length() >= 6) {
                    RequestBuilder<Drawable> requestBuilderLoad2 = Glide.with(context).load(strD);
                    Intrinsics.f(requestBuilderLoad2, "with(context).load(bigUrl)");
                    BlurHashExtKt.a(requestBuilderLoad2, str4, 20, 20, ImageHelper.f51375e, new Function1<RequestBuilder<Drawable>, Unit>() { // from class: com.transsion.baseui.image.ImageHelper$Companion$intoWithThumbnail$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(RequestBuilder<Drawable> requestBuilder) {
                            invoke2(requestBuilder);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(RequestBuilder<Drawable> it) {
                            Intrinsics.g(it, "it");
                            try {
                                it.into(imageView);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    });
                    requestBuilderLoad2.transition(ImageHelper.f51376f).listener(new b(jCurrentTimeMillis, function3)).apply((BaseRequestOptions<?>) y(0, i12, z14 ? i14 : -1, z14 ? i13 : -1, priority)).into(imageView);
                } else {
                    Glide.with(context).load(strD).transition(ImageHelper.f51376f).listener(new c(jCurrentTimeMillis, function3)).apply((BaseRequestOptions<?>) y(i11, i12, z14 ? i14 : -1, z14 ? i13 : -1, priority)).into(imageView);
                }
                uo.b.a.f(uo.b.f78622a, "ImageHelper", "load " + i13 + " use " + strD + " with small " + str4, false, 4, null);
            }
            strA = eVar.a(str, iC, (56 & 4) != 0 ? true : z11, (56 & 8) != 0, (56 & 16) != 0 ? 0 : 0, (56 & 32) != 0 ? false : false, (56 & 64) != 0 ? false : z16, (56 & 128) != 0 ? 25 : i15);
            str3 = strA;
            str4 = str3;
            strD = eVar.d(str, i13, (56 & 4) != 0 ? true : z11, (56 & 8) != 0 ? true : z12, (56 & 16) != 0 ? 0 : i14, (56 & 32) != 0 ? false : z15, (56 & 64) != 0 ? false : false, (56 & 128) != 0 ? false : z16, (56 & 256) != 0 ? 25 : i15);
            jCurrentTimeMillis = System.currentTimeMillis();
            if (l.L(str4, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
                if (z13) {
                    requestBuilderLoad = (RequestBuilder) Glide.with(context).load(str4).optionalCenterCrop();
                } else {
                    requestBuilderLoad = Glide.with(context).load(str4);
                }
                Intrinsics.f(requestBuilderLoad, "if (thumbScaleType) {\n  …allUrl)\n                }");
                RequestBuilder<Drawable> requestBuilderTransition2 = Glide.with(context).load(strD).thumbnail(requestBuilderLoad).listener(new a(jCurrentTimeMillis, function3)).transition(ImageHelper.f51376f);
                if (z14) {
                    i16 = i14;
                } else {
                    i16 = -1;
                }
                requestBuilderTransition2.apply((BaseRequestOptions<?>) y(i11, i12, i16, z14 ? i13 : -1, priority)).into(imageView);
            } else {
                if (z13) {
                    requestBuilderLoad = (RequestBuilder) Glide.with(context).load(str4).optionalCenterCrop();
                } else {
                    requestBuilderLoad = Glide.with(context).load(str4);
                }
                Intrinsics.f(requestBuilderLoad, "if (thumbScaleType) {\n  …allUrl)\n                }");
                RequestBuilder<Drawable> requestBuilderTransition3 = Glide.with(context).load(strD).thumbnail(requestBuilderLoad).listener(new a(jCurrentTimeMillis, function3)).transition(ImageHelper.f51376f);
                if (z14) {
                    i16 = i14;
                } else {
                    i16 = -1;
                }
                requestBuilderTransition3.apply((BaseRequestOptions<?>) y(i11, i12, i16, z14 ? i13 : -1, priority)).into(imageView);
            }
            uo.b.a.f(uo.b.f78622a, "ImageHelper", "load " + i13 + " use " + strD + " with small " + str4, false, 4, null);
        }

        public final void n(String url, Function1<? super Bitmap, Unit> callback) {
            Intrinsics.g(url, "url");
            Intrinsics.g(callback, "callback");
            Glide.with(Utils.a()).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA).load(url).into(new d(callback));
        }

        public final void o(Context context, ImageView imageView, String url, int i11, int i12, int i13, int i14, boolean z11, String thumbnail, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i15) {
            Intrinsics.g(context, "context");
            Intrinsics.g(imageView, "imageView");
            Intrinsics.g(url, "url");
            Intrinsics.g(thumbnail, "thumbnail");
            if ((context instanceof FragmentActivity) && ((FragmentActivity) context).isDestroyed()) {
                return;
            }
            if (url.length() == 0) {
                Glide.with(context).load("").transition(ImageHelper.f51376f).apply((BaseRequestOptions<?>) z(this, i11, i14, z14 ? i13 : -1, z14 ? i12 : -1, null, 16, null)).into(imageView);
                return;
            }
            try {
                m(this, context, imageView, url, i11, i14, (i12 != d() || imageView.getLayoutParams().width <= 0) ? i12 : imageView.getLayoutParams().width, i13, z11, thumbnail, z12, z13, z14, z15, z16, i15, null, null, 98304, null);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public final void p(Context context, ImageView imageView, String url, int i11, int i12, int i13, int i14, boolean z11, String thumbnail, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i15, Priority priority, Function3<? super Boolean, ? super Boolean, ? super Long, Unit> function3) {
            Intrinsics.g(context, "context");
            Intrinsics.g(imageView, "imageView");
            Intrinsics.g(url, "url");
            Intrinsics.g(thumbnail, "thumbnail");
            Intrinsics.g(priority, "priority");
            if ((context instanceof FragmentActivity) && ((FragmentActivity) context).isDestroyed()) {
                return;
            }
            if (TextUtils.isEmpty(url)) {
                Glide.with(context).load("").transition(ImageHelper.f51376f).apply((BaseRequestOptions<?>) z(this, i11, i14, z14 ? i13 : -1, z14 ? i12 : -1, null, 16, null)).into(imageView);
                return;
            }
            try {
                l(context, imageView, url, i11, i14, (i12 != d() || imageView.getLayoutParams().width <= 0) ? i12 : imageView.getLayoutParams().width, i13, z11, thumbnail, z12, z13, z14, z15, z16, i15, priority, function3);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public final void q(Context context, ImageView imageView, String url, int i11, int i12, boolean z11, String thumbnail, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i13) {
            Intrinsics.g(context, "context");
            Intrinsics.g(imageView, "imageView");
            Intrinsics.g(url, "url");
            Intrinsics.g(thumbnail, "thumbnail");
            o(context, imageView, url, R$color.skeleton, i11, i12, 0, z11, thumbnail, z12, z13, z14, z15, z16, i13);
        }

        public final void r(Context context, ImageView imageView, String url, int i11, int i12, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i13) {
            Intrinsics.g(context, "context");
            Intrinsics.g(imageView, "imageView");
            Intrinsics.g(url, "url");
            o(context, imageView, url, R$color.skeleton, i11, i12, 0, z11, "", z12, z13, z14, z15, z16, i13);
        }

        public final void w(String url, String originUrl, int i11, Function1<? super Boolean, Unit> function1) {
            Intrinsics.g(url, "url");
            Intrinsics.g(originUrl, "originUrl");
            Glide.with(Utils.a()).load(url).diskCacheStrategy(DiskCacheStrategy.DATA).addListener(new e(function1, originUrl, i11)).preload();
        }

        public final RequestOptions y(int i11, int i12, int i13, int i14, Priority priority) {
            RequestOptions requestOptionsDiskCacheStrategy = new RequestOptions().priority(priority).diskCacheStrategy(DiskCacheStrategy.DATA);
            Intrinsics.f(requestOptionsDiskCacheStrategy, "RequestOptions()\n       …y(DiskCacheStrategy.DATA)");
            RequestOptions requestOptionsCircleCropTransform = requestOptionsDiskCacheStrategy;
            if (i11 != 0) {
                RequestOptions requestOptionsPlaceholder = requestOptionsCircleCropTransform.placeholder(i11);
                Intrinsics.f(requestOptionsPlaceholder, "options.placeholder(placeHolder)");
                requestOptionsCircleCropTransform = requestOptionsPlaceholder;
            }
            if (i12 > 0) {
                RequestOptions requestOptionsTransform = requestOptionsCircleCropTransform.transform(new MultiTransformation(new CenterCrop(), new RoundedCorners(i12)));
                Intrinsics.f(requestOptionsTransform, "options.transform(MultiT…, RoundedCorners(round)))");
                requestOptionsCircleCropTransform = requestOptionsTransform;
            } else if (i12 < 0) {
                requestOptionsCircleCropTransform = RequestOptions.circleCropTransform();
                Intrinsics.f(requestOptionsCircleCropTransform, "circleCropTransform()");
            }
            if (i13 == -1 && i14 == -1) {
                return requestOptionsCircleCropTransform;
            }
            RequestOptions requestOptionsOverride = requestOptionsCircleCropTransform.override(i14, i13);
            Intrinsics.f(requestOptionsOverride, "options.override(width, height)");
            return requestOptionsOverride;
        }
    }

    static {
        try {
            CronetEngine cronetEngineBuild = new CronetEngine.Builder(Utils.a()).enableHttpCache(0, 0L).enableHttp2(true).enableQuic(true).addQuicHint("test-acdn.aoneroom.com", 443, 443).addQuicHint("acdn.aoneroom.com", 443, 443).build();
            Field[] declaredFields = CronetEngineSingleton.class.getDeclaredFields();
            Intrinsics.f(declaredFields, "CronetEngineSingleton::class.java.declaredFields");
            for (Field field : declaredFields) {
                if (Intrinsics.b(field.getType(), CronetEngine.class)) {
                    field.setAccessible(true);
                    field.set(null, cronetEngineBuild);
                    uo.b.a.f(uo.b.f78622a, "ImageHelper", "init CronetEngine", false, 4, null);
                    break;
                }
            }
        } catch (Throwable th2) {
            uo.b.a.e(uo.b.f78622a, "ImageHelper", "init CronetEngine failed", th2, false, 8, null);
        }
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        f51375e = new BlurHash(applicationA, 5, 0.6f);
        DrawableTransitionOptions drawableTransitionOptionsWith = DrawableTransitionOptions.with(new DrawableCrossFadeFactory.Builder(100).setCrossFadeEnabled(true).build());
        Intrinsics.f(drawableTransitionOptionsWith, "with(DrawableCrossFadeFa…adeEnabled(true).build())");
        f51376f = drawableTransitionOptionsWith;
    }
}
