package com.transsion.ninegridview.preview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.d0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.player.MediaSource;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;

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
public final class GifImagePreviewActivity extends BaseActivity<zu.a> implements TRDialogListener {
    public static final int ANIMATE_DURATION = 200;
    public static final String CURRENT_ITEM = "CURRENT_ITEM";
    public static final a Companion = new a(null);
    public static final String IMAGE_LIST = "image_list";
    public static final String IS_BUILTIN = "IS_BUILTIN";
    public static final String PICTURE_SAVE = "oneroom";
    public static final int PLAY_GIF_AGAIN = 102;
    public static final int REQUEST_PERMISSION_SETTING = 101;
    private int currentItemIndex;
    private int imageHeight;
    private List<Image> imageList;
    private com.transsion.ninegridview.preview.c imagePreviewAdapter;
    private int imageWidth;
    private m mPageChange;
    private com.transsion.player.orplayer.f mPlayer;
    private int screenHeight;
    private int screenWidth;
    private final int REQUEST_PERMISSION_STORAGE = 100;
    private Boolean isBuiltInApp = Boolean.FALSE;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final g mOnPageChangeCallback = new g();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.g(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.g(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.g(animation, "animation");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.g(animation, "animation");
            ((zu.a) GifImagePreviewActivity.this.getMViewBinding()).f82161c.setBackgroundColor(0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.g(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.g(animation, "animation");
            GifImagePreviewActivity.this.finish();
            GifImagePreviewActivity.this.overridePendingTransition(0, 0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.g(animation, "animation");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.g(animation, "animation");
            ((zu.a) GifImagePreviewActivity.this.getMViewBinding()).f82161c.setBackgroundColor(0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements RequestListener<File> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Image f53964b;

        public d(Image image) {
            this.f53964b = image;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(File file, Object model, Target<File> target, DataSource dataSource, boolean z11) {
            Intrinsics.g(model, "model");
            Intrinsics.g(target, "target");
            Intrinsics.g(dataSource, "dataSource");
            GifImagePreviewActivity gifImagePreviewActivity = GifImagePreviewActivity.this;
            Image image = this.f53964b;
            gifImagePreviewActivity.saveToAlbum(file, image != null ? image.getUrl() : null);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object model, Target<File> target, boolean z11) {
            Intrinsics.g(model, "model");
            Intrinsics.g(target, "target");
            zp.b.f82110a.d(R$string.download_failed);
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.g(animation, "animation");
            GifImagePreviewActivity.this.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.g(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.g(animation, "animation");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements com.transsion.player.orplayer.e {
        public f() {
        }

        @Override // com.transsion.player.orplayer.e
        public void initPlayer() {
            com.transsion.player.orplayer.e.a.a(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.b(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onBufferedPosition(long j11, MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onCompletion(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.d(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onFocusChange(boolean z11) {
            com.transsion.player.orplayer.e.a.f(this, z11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onIsPlayingChanged(boolean z11) {
            com.transsion.player.orplayer.e.a.g(this, z11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingBegin(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.h(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingEnd(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.j(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.l(this, i11, f11, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onLoopingStart() {
            com.transsion.player.orplayer.e.a.n(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onMediaItemTransition(String str) {
            com.transsion.player.orplayer.e.a.o(this, str);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayError(PlayError playError, MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.p(this, playError, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayerRelease(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.s(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPlayerReset() {
            com.transsion.player.orplayer.e.a.u(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onPrepare(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.v(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onProgress(long j11, MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onRenderFirstFrame() {
            com.transsion.player.orplayer.e.a.z(this);
            m mVar = GifImagePreviewActivity.this.mPageChange;
            if (mVar != null) {
                mVar.g();
            }
        }

        @Override // com.transsion.player.orplayer.e
        public void onSetDataSource() {
            com.transsion.player.orplayer.e.a.A(this);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksAudioBitrateChange(int i11) {
            com.transsion.player.orplayer.e.a.B(this, i11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksChange(ov.c cVar) {
            com.transsion.player.orplayer.e.a.C(this, cVar);
        }

        @Override // com.transsion.player.orplayer.e
        public void onTracksVideoBitrateChange(int i11) {
            com.transsion.player.orplayer.e.a.D(this, i11);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoPause(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.E(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoSizeChanged(int i11, int i12) {
            com.transsion.player.orplayer.e.a.G(this, i11, i12);
        }

        @Override // com.transsion.player.orplayer.e
        public void onVideoStart(MediaSource mediaSource) {
            com.transsion.player.orplayer.e.a.H(this, mediaSource);
        }

        @Override // com.transsion.player.orplayer.e
        public void setOnSeekCompleteListener() {
            com.transsion.player.orplayer.e.a.J(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g extends ViewPager2.OnPageChangeCallback {
        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [T, android.view.View] */
        public static final void b(Ref.ObjectRef itemView, GifImagePreviewActivity this$0, int i11) {
            Intrinsics.g(itemView, "$itemView");
            Intrinsics.g(this$0, "this$0");
            itemView.element = this$0.getItemView();
            m mVar = this$0.mPageChange;
            if (mVar != null) {
                List list = this$0.imageList;
                mVar.f(i11, list != null ? (Image) list.get(i11) : null, (View) itemView.element);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, android.view.View] */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(final int i11) {
            GifBean gifBean;
            String videoUrl;
            GifImagePreviewActivity.this.currentItemIndex = i11;
            GifImagePreviewActivity.this.showPageIndex();
            List list = GifImagePreviewActivity.this.imageList;
            Image image = list != null ? (Image) list.get(i11) : null;
            if (image == null || (gifBean = image.getGifBean()) == null || (videoUrl = gifBean.getVideoUrl()) == null || videoUrl.length() <= 0) {
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? itemView = GifImagePreviewActivity.this.getItemView();
            objectRef.element = itemView;
            if (itemView == 0) {
                Handler handler = GifImagePreviewActivity.this.handler;
                final GifImagePreviewActivity gifImagePreviewActivity = GifImagePreviewActivity.this;
                handler.postDelayed(new Runnable() { // from class: com.transsion.ninegridview.preview.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        GifImagePreviewActivity.g.b(objectRef, gifImagePreviewActivity, i11);
                    }
                }, 200L);
            } else {
                m mVar = GifImagePreviewActivity.this.mPageChange;
                if (mVar != null) {
                    List list2 = GifImagePreviewActivity.this.imageList;
                    mVar.f(i11, list2 != null ? (Image) list2.get(i11) : null, (View) objectRef.element);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h implements Animation.AnimationListener {
        public h() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.g(animation, "animation");
            ConstraintLayout constraintLayout = ((zu.a) GifImagePreviewActivity.this.getMViewBinding()).f82161c;
            Intrinsics.f(constraintLayout, "mViewBinding.rootView");
            so.c.k(constraintLayout);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.g(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.g(animation, "animation");
        }
    }

    private final void addIntoListener(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new b());
    }

    private final void addOutListener(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new c());
    }

    private final void computeImageWidthAndHeight(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int height = imageView.getHeight();
        int width = imageView.getWidth();
        if (drawable != null) {
            height = drawable.getIntrinsicHeight();
            width = drawable.getIntrinsicWidth();
        }
        float f11 = height;
        float f12 = (this.screenHeight * 1.0f) / f11;
        float f13 = width;
        float f14 = (this.screenWidth * 1.0f) / f13;
        if (f12 > f14) {
            f12 = f14;
        }
        this.imageHeight = (int) (f11 * f12);
        this.imageWidth = (int) (f13 * f12);
    }

    private final void downloadImage() {
        List<Image> list = this.imageList;
        int size = list != null ? list.size() : 0;
        int i11 = this.currentItemIndex;
        if (i11 < 0 || i11 >= size) {
            return;
        }
        List<Image> list2 = this.imageList;
        Image image = list2 != null ? list2.get(i11) : null;
        Glide.with((FragmentActivity) this).downloadOnly().load(image != null ? image.getUrl() : null).listener(new d(image)).preload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final View getItemView() {
        View childAt = ((zu.a) getMViewBinding()).f82163f.getChildAt(0);
        Intrinsics.e(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView.m layoutManager = ((RecyclerView) childAt).getLayoutManager();
        if (layoutManager != null) {
            return layoutManager.findViewByPosition(this.currentItemIndex);
        }
        return null;
    }

    private final String getNameFromUrl(String str) {
        if (str == null) {
            return null;
        }
        String[] strArr = (String[]) StringsKt__StringsKt.E0(str, new String[]{"[?]"}, false, 0, 6, null).toArray(new String[0]);
        if (!(strArr.length == 0)) {
            String[] strArr2 = (String[]) StringsKt__StringsKt.E0(strArr[0], new String[]{"/"}, false, 0, 6, null).toArray(new String[0]);
            if (!(strArr2.length == 0)) {
                return strArr2[strArr2.length - 1];
            }
        }
        return null;
    }

    private final void initPlayer() {
        ORPlayerView oRPlayerView = new ORPlayerView(this, RenderType.TEXTURE_VIEW);
        com.transsion.player.orplayer.f fVarA = new com.transsion.player.orplayer.f.a(this).a();
        fVarA.setTextureView(oRPlayerView.getTextureView());
        fVarA.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
        this.mPageChange = new m(fVarA, oRPlayerView);
        fVarA.setPlayerListener(new f());
        this.mPlayer = fVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        this.screenWidth = d0.e();
        this.screenHeight = d0.c();
        Serializable serializableExtra = getIntent().getSerializableExtra(IMAGE_LIST);
        List<Image> list = serializableExtra instanceof List ? (List) serializableExtra : null;
        this.imageList = list;
        if (list == null) {
            this.imageList = new ArrayList();
        }
        this.isBuiltInApp = Boolean.valueOf(getIntent().getBooleanExtra(IS_BUILTIN, false));
        this.currentItemIndex = getIntent().getIntExtra("CURRENT_ITEM", 0);
        com.transsion.ninegridview.preview.c cVar = new com.transsion.ninegridview.preview.c(this);
        cVar.e(this.imageList);
        cVar.d(this.isBuiltInApp);
        this.imagePreviewAdapter = cVar;
        ViewPager2 viewPager2 = ((zu.a) getMViewBinding()).f82163f;
        viewPager2.setAdapter(this.imagePreviewAdapter);
        viewPager2.registerOnPageChangeCallback(this.mOnPageChangeCallback);
        viewPager2.setCurrentItem(this.currentItemIndex, false);
        startEnterTheAnimation();
        showPageIndex();
        ((zu.a) getMViewBinding()).f82160b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GifImagePreviewActivity.initView$lambda$2(this.f53979a, view);
            }
        });
        initPlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(GifImagePreviewActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            this$0.downloadImage();
            return;
        }
        if (i11 < 23) {
            this$0.downloadImage();
        } else if (z2.a.checkSelfPermission(this$0, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && z2.a.checkSelfPermission(this$0, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            this$0.downloadImage();
        } else {
            this$0.requestPermission();
        }
    }

    private final void requestPermission() {
        ActivityCompat.g(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, this.REQUEST_PERMISSION_STORAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveToAlbum(File file, String str) {
        String nameFromUrl = getNameFromUrl(str);
        if (new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), PICTURE_SAVE + File.separator + nameFromUrl).exists()) {
            zp.b.f82110a.d(R$string.has_been_saved);
        } else {
            if (file == null || nameFromUrl == null) {
                return;
            }
            FileHelper.f53955a.g(file, this, nameFromUrl, PICTURE_SAVE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showPageIndex() {
        TextView textView = ((zu.a) getMViewBinding()).f82162d;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.currentItemIndex + 1);
        List<Image> list = this.imageList;
        objArr[1] = list != null ? Integer.valueOf(list.size()) : null;
        String str = String.format("%d/%d", Arrays.copyOf(objArr, 2));
        Intrinsics.f(str, "format(...)");
        textView.setText(str);
    }

    private final void showSettingDialog() {
        String string = getString(R$string.permission_deny_down_tip, "\"" + getString(com.transsion.baseui.R$string.base_app_name) + "\"", "\"" + getString(R$string.system_settings) + "\"");
        Intrinsics.f(string, "getString(R.string.permi…n_tip, appName, settings)");
        TRDialog.a aVarG = new TRDialog.a().g(string);
        String string2 = getString(R$string.cancel);
        Intrinsics.f(string2, "getString(R.string.cancel)");
        TRDialog.a aVarE = aVarG.e(string2);
        String string3 = getString(R$string.system_settings);
        Intrinsics.f(string3, "getString(R.string.system_settings)");
        aVarE.j(string3).f(this).a().show(getSupportFragmentManager(), "settings");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startEnterTheAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new h());
        alphaAnimation.setFillAfter(true);
        ((zu.a) getMViewBinding()).f82161c.startAnimation(alphaAnimation);
    }

    public final int evaluateArgb(float f11, int i11, int i12) {
        int i13 = (i11 >> 24) & 255;
        int i14 = (i11 >> 16) & 255;
        int i15 = (i11 >> 8) & 255;
        int i16 = i11 & 255;
        return ((i13 + ((int) ((((i12 >> 24) & 255) - i13) * f11))) << 24) | ((i14 + ((int) ((((i12 >> 16) & 255) - i14) * f11))) << 16) | ((i15 + ((int) ((((i12 >> 8) & 255) - i15) * f11))) << 8) | (i16 + ((int) (f11 * ((i12 & 255) - i16))));
    }

    public final float evaluateFloat(float f11, Number startValue, Number endValue) {
        Intrinsics.g(startValue, "startValue");
        Intrinsics.g(endValue, "endValue");
        float fFloatValue = startValue.floatValue();
        return fFloatValue + (f11 * (endValue.floatValue() - fFloatValue));
    }

    public final int evaluateInt(float f11, int i11, int i12) {
        return (int) (i11 + (f11 * (i12 - i11)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finishActivityAnim() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new e());
        alphaAnimation.setFillAfter(true);
        ((zu.a) getMViewBinding()).f82161c.startAnimation(alphaAnimation);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public zu.a getViewBinding() {
        zu.a aVarC = zu.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isAttach() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finishActivityAnim();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((zu.a) getMViewBinding()).f82163f.unregisterOnPageChangeCallback(this.mOnPageChangeCallback);
        com.transsion.player.orplayer.f fVar = this.mPlayer;
        if (fVar != null) {
            fVar.release();
        }
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.transsion.player.orplayer.f fVar = this.mPlayer;
        if (fVar != null) {
            fVar.pause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i11, String[] permissions, int[] grantResults) {
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(grantResults, "grantResults");
        super.onRequestPermissionsResult(i11, permissions, grantResults);
        if (i11 == this.REQUEST_PERMISSION_STORAGE) {
            if (grantResults.length > 1 && grantResults[0] == 0 && grantResults[1] == 0) {
                downloadImage();
            } else {
                if (ActivityCompat.j(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    return;
                }
                showSettingDialog();
            }
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.transsion.player.orplayer.f fVar = this.mPlayer;
        if (fVar != null) {
            fVar.play();
        }
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
        com.transsion.ninegridview.helper.a.f53960a.a(this, 101);
    }
}
