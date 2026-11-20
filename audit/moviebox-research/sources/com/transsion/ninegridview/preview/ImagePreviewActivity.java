package com.transsion.ninegridview.preview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.applovin.sdk.AppLovinEventTypes;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.ninegridview.ImageInfo;
import com.transsion.ninegridview.R$string;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.photoview.PhotoView;
import com.transsion.web.share.ImageShareDialog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class ImagePreviewActivity extends BaseActivity<zu.b> implements ViewTreeObserver.OnPreDrawListener, TRDialogListener {
    public static final int ANIMATE_DURATION = 200;
    public static final String CURRENT_ITEM = "CURRENT_ITEM";
    public static final a Companion = new a(null);
    public static final String IMAGE_INFO = "IMAGE_INFO";
    private final String PAGE_NAME = "image_preview";
    private int currentItem;
    private int imageHeight;
    private List<? extends ImageInfo> imageInfoList;
    private l imagePreviewAdapter;
    private int imageWidth;
    private ConstraintLayout rootView;
    private int screenHeight;
    private int screenWidth;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, int i11, List<? extends ImageInfo> list) {
            Intrinsics.g(context, "context");
            Intent intent = new Intent(context, (Class<?>) ImagePreviewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(ImagePreviewActivity.IMAGE_INFO, (Serializable) list);
            bundle.putInt("CURRENT_ITEM", i11);
            intent.putExtras(bundle);
            context.startActivity(intent);
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

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.g(animation, "animation");
            ConstraintLayout constraintLayout = ImagePreviewActivity.this.rootView;
            if (constraintLayout == null) {
                Intrinsics.y("rootView");
                constraintLayout = null;
            }
            constraintLayout.setBackgroundColor(0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.g(animation, "animation");
            ImagePreviewActivity.this.finish();
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
    public static final class d extends ViewPager.k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f53977b;

        public d(TextView textView) {
            this.f53977b = textView;
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageSelected(int i11) {
            ImagePreviewActivity.this.currentItem = i11;
            TextView textView = this.f53977b;
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(ImagePreviewActivity.this.currentItem + 1);
            List list = ImagePreviewActivity.this.imageInfoList;
            if (list == null) {
                Intrinsics.y("imageInfoList");
                list = null;
            }
            objArr[1] = Integer.valueOf(list.size());
            String str = String.format("%d/%d", Arrays.copyOf(objArr, 2));
            Intrinsics.f(str, "format(...)");
            textView.setText(str);
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
            ConstraintLayout constraintLayout = ImagePreviewActivity.this.rootView;
            if (constraintLayout == null) {
                Intrinsics.y("rootView");
                constraintLayout = null;
            }
            constraintLayout.setVisibility(0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadImage() {
        saveToAlbum(new Function2<Boolean, File, Unit>() { // from class: com.transsion.ninegridview.preview.ImagePreviewActivity.downloadImage.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, File file) {
                invoke(bool.booleanValue(), file);
                return Unit.f68710a;
            }

            public final void invoke(boolean z11, File file) {
                if (z11) {
                    zp.b.f82110a.d(R$string.has_been_saved);
                } else {
                    zp.b.f82110a.d(R$string.image_save_success);
                }
            }
        });
    }

    private final int evaluateArgb(float f11, int i11, int i12) {
        int i13 = (i11 >> 24) & 255;
        int i14 = (i11 >> 16) & 255;
        int i15 = (i11 >> 8) & 255;
        int i16 = i11 & 255;
        return ((i13 + ((int) ((((i12 >> 24) & 255) - i13) * f11))) << 24) | ((i14 + ((int) ((((i12 >> 16) & 255) - i14) * f11))) << 16) | ((i15 + ((int) ((((i12 >> 8) & 255) - i15) * f11))) << 8) | (i16 + ((int) (f11 * ((i12 & 255) - i16))));
    }

    private final float evaluateFloat(float f11, Number number, Number number2) {
        float fFloatValue = number.floatValue();
        return fFloatValue + (f11 * (number2.floatValue() - fFloatValue));
    }

    private final int evaluateInt(float f11, int i11, int i12) {
        return (int) (i11 + (f11 * (i12 - i11)));
    }

    private final String getCurImgUrl() {
        int i11 = this.currentItem;
        List<? extends ImageInfo> list = this.imageInfoList;
        List<? extends ImageInfo> list2 = null;
        if (list == null) {
            Intrinsics.y("imageInfoList");
            list = null;
        }
        if (i11 >= list.size() || this.currentItem < 0) {
            return null;
        }
        List<? extends ImageInfo> list3 = this.imageInfoList;
        if (list3 == null) {
            Intrinsics.y("imageInfoList");
        } else {
            list2 = list3;
        }
        return list2.get(this.currentItem).bigImageUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void imageShareClick() {
        ((zu.b) getMViewBinding()).f82166c.setEnabled(false);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        saveToAlbum(new Function2<Boolean, File, Unit>() { // from class: com.transsion.ninegridview.preview.ImagePreviewActivity.imageShareClick.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, File file) {
                invoke(bool.booleanValue(), file);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(boolean z11, File file) {
                if (file != null) {
                    ImagePreviewActivity imagePreviewActivity = ImagePreviewActivity.this;
                    Uri imageUri = FileProvider.getUriForFile(imagePreviewActivity, imagePreviewActivity.getApplication().getPackageName() + ".download.fileprovider", file);
                    ImagePreviewActivity imagePreviewActivity2 = ImagePreviewActivity.this;
                    Intrinsics.f(imageUri, "imageUri");
                    imagePreviewActivity2.shareImage(imageUri);
                } else {
                    com.tn.lib.widget.toast.core.h.f50034a.k(com.transsion.web.R$string.share_failed_tips);
                }
                ((zu.b) ImagePreviewActivity.this.getMViewBinding()).f82166c.setEnabled(true);
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("share: 耗时=");
                sb2.append(jCurrentTimeMillis2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ImagePreviewActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finishActivityAnim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(final ImagePreviewActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baseui.util.d.b(0L, new Function0<Unit>() { // from class: com.transsion.ninegridview.preview.ImagePreviewActivity$onCreate$3$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.transsion.baselib.helper.a.f51183a.g(this.this$0.PAGE_NAME, "save_picture", (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
                this.this$0.downloadImage();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(final ImagePreviewActivity this$0, View v11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(v11, "v");
        com.transsion.baseui.util.d.b(0L, new Function0<Unit>() { // from class: com.transsion.ninegridview.preview.ImagePreviewActivity$onCreate$4$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.transsion.baselib.helper.a.f51183a.g(this.this$0.PAGE_NAME, AppLovinEventTypes.USER_SHARED_LINK, (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
                this.this$0.imageShareClick();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPreDraw$lambda$3(View view, ImagePreviewActivity this$0, ImageInfo imageData, ImageView imageView, float f11, float f12, ValueAnimator animation) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(imageData, "$imageData");
        Intrinsics.g(animation, "animation");
        long duration = animation.getDuration();
        float currentPlayTime = duration > 0 ? animation.getCurrentPlayTime() / duration : 1.0f;
        float f13 = currentPlayTime <= 1.0f ? currentPlayTime : 1.0f;
        try {
            view.setTranslationX(this$0.evaluateInt(f13, (imageData.imageViewX + (((int) imageData.imageViewWidth) / 2)) - (imageView.getWidth() / 2), 0));
            view.setTranslationY(this$0.evaluateInt(f13, (imageData.imageViewY + (((int) imageData.imageViewHeight) / 2)) - (imageView.getHeight() / 2), 0));
            view.setScaleX(this$0.evaluateFloat(f13, Float.valueOf(f11), 1));
            view.setScaleY(this$0.evaluateFloat(f13, Float.valueOf(f12), 1));
            view.setAlpha(f13);
            ConstraintLayout constraintLayout = this$0.rootView;
            if (constraintLayout == null) {
                Intrinsics.y("rootView");
                constraintLayout = null;
            }
            constraintLayout.setBackgroundColor(this$0.evaluateArgb(f13, 0, ViewCompat.MEASURED_STATE_MASK));
        } catch (Exception e11) {
            String stackTraceString = Log.getStackTraceString(e11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onAnimationUpdate: e = ");
            sb2.append(stackTraceString);
        }
    }

    private final void saveToAlbum(Function2<? super Boolean, ? super File, Unit> function2) {
        FileHelper fileHelper = FileHelper.f53955a;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        l lVar = this.imagePreviewAdapter;
        if (lVar == null) {
            Intrinsics.y("imagePreviewAdapter");
            lVar = null;
        }
        PhotoView photoViewD = lVar.d();
        Intrinsics.f(photoViewD, "imagePreviewAdapter.gePhotoView()");
        fileHelper.r(this, companion.a(photoViewD), fileHelper.j(getCurImgUrl()), function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shareImage(Uri uri) {
        try {
            if (getSupportFragmentManager().findFragmentByTag("ImageShareDialog") != null) {
                return;
            }
            ImageShareDialog imageShareDialogA = ImageShareDialog.f60203g.a(uri);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.f(supportFragmentManager, "supportFragmentManager");
            imageShareDialogA.show(supportFragmentManager, "ImageShareDialog");
        } catch (Exception unused) {
            com.tn.lib.widget.toast.core.h.f50034a.k(com.transsion.web.R$string.share_failed_tips);
        }
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

    private final void startEnterTheAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new e());
        alphaAnimation.setFillAfter(true);
        ConstraintLayout constraintLayout = this.rootView;
        if (constraintLayout == null) {
            Intrinsics.y("rootView");
            constraintLayout = null;
        }
        constraintLayout.startAnimation(alphaAnimation);
    }

    public final void finishActivityAnim() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new c());
        alphaAnimation.setFillAfter(true);
        ConstraintLayout constraintLayout = this.rootView;
        if (constraintLayout == null) {
            Intrinsics.y("rootView");
            constraintLayout = null;
        }
        constraintLayout.startAnimation(alphaAnimation);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public zu.b getViewBinding() {
        zu.b bVarC = zu.b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        return bVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isAttach() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("image_preview", false, 2, null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finishActivityAnim();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity, com.tn.lib.util.networkinfo.g
    public void onConnected() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"DefaultLocale"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        HackyViewPager hackyViewPager = ((zu.b) getMViewBinding()).f82173k;
        Intrinsics.f(hackyViewPager, "mViewBinding.viewPager");
        TextView textView = ((zu.b) getMViewBinding()).f82171i;
        Intrinsics.f(textView, "mViewBinding.tvPager");
        ConstraintLayout constraintLayout = ((zu.b) getMViewBinding()).f82168f;
        Intrinsics.f(constraintLayout, "mViewBinding.rootView");
        this.rootView = constraintLayout;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        Intent intent = getIntent();
        Serializable serializableExtra = intent.getSerializableExtra(IMAGE_INFO);
        List<? extends ImageInfo> list = null;
        List<? extends ImageInfo> arrayList = serializableExtra instanceof List ? (List) serializableExtra : null;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.imageInfoList = arrayList;
        this.currentItem = intent.getIntExtra("CURRENT_ITEM", 0);
        List<? extends ImageInfo> list2 = this.imageInfoList;
        if (list2 == null) {
            Intrinsics.y("imageInfoList");
            list2 = null;
        }
        l lVar = new l(this, list2);
        this.imagePreviewAdapter = lVar;
        hackyViewPager.setAdapter(lVar);
        hackyViewPager.setCurrentItem(this.currentItem);
        startEnterTheAnimation();
        hackyViewPager.addOnPageChangeListener(new d(textView));
        List<? extends ImageInfo> list3 = this.imageInfoList;
        if (list3 == null) {
            Intrinsics.y("imageInfoList");
            list3 = null;
        }
        if (list3.size() < 2) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.currentItem + 1);
            List<? extends ImageInfo> list4 = this.imageInfoList;
            if (list4 == null) {
                Intrinsics.y("imageInfoList");
            } else {
                list = list4;
            }
            objArr[1] = Integer.valueOf(list.size());
            String str = String.format("%d/%d", Arrays.copyOf(objArr, 2));
            Intrinsics.f(str, "format(...)");
            textView.setText(str);
        }
        ((zu.b) getMViewBinding()).f82167d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImagePreviewActivity.onCreate$lambda$0(this.f53987a, view);
            }
        });
        ((zu.b) getMViewBinding()).f82165b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImagePreviewActivity.onCreate$lambda$1(this.f53988a, view);
            }
        });
        ((zu.b) getMViewBinding()).f82166c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ninegridview.preview.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImagePreviewActivity.onCreate$lambda$2(this.f53989a, view);
            }
        });
        ((zu.b) getMViewBinding()).f82169g.getLayoutParams().height = com.blankj.utilcode.util.d.c();
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ((zu.b) getMViewBinding()).f82168f.getViewTreeObserver().removeOnPreDrawListener(this);
        l lVar = this.imagePreviewAdapter;
        List<? extends ImageInfo> list = null;
        if (lVar == null) {
            Intrinsics.y("imagePreviewAdapter");
            lVar = null;
        }
        final View viewF = lVar.f();
        l lVar2 = this.imagePreviewAdapter;
        if (lVar2 == null) {
            Intrinsics.y("imagePreviewAdapter");
            lVar2 = null;
        }
        final ImageView imageView = lVar2.e();
        Intrinsics.f(imageView, "imageView");
        computeImageWidthAndHeight(imageView);
        List<? extends ImageInfo> list2 = this.imageInfoList;
        if (list2 == null) {
            Intrinsics.y("imageInfoList");
        } else {
            list = list2;
        }
        final ImageInfo imageInfo = list.get(this.currentItem);
        final float f11 = (imageInfo.imageViewWidth * 1.0f) / this.imageWidth;
        final float f12 = (imageInfo.imageViewHeight * 1.0f) / this.imageHeight;
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.ninegridview.preview.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ImagePreviewActivity.onPreDraw$lambda$3(viewF, this, imageInfo, imageView, f11, f12, valueAnimator2);
            }
        });
        Intrinsics.f(valueAnimator, "valueAnimator");
        addIntoListener(valueAnimator);
        valueAnimator.setDuration(200L);
        valueAnimator.start();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i11, String[] permissions, int[] grantResults) {
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(grantResults, "grantResults");
        super.onRequestPermissionsResult(i11, permissions, grantResults);
        if (i11 == FileHelper.f53955a.l()) {
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

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
        com.transsion.ninegridview.helper.a.f53960a.a(this, 101);
    }
}
