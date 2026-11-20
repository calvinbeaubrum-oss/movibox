package com.transsion.publish.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.bumptech.glide.Glide;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.view.clip.ClipImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class ClippingImageActivity extends BaseActivity<ew.a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f56481k = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f56482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h10.b f56483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f56484c = "ClipHandler";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f56485d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f56486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f56487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f56488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f56489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f56490j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(a aVar, Activity activity, String str, int i11, b1.b bVar, int i12, Object obj) {
            if ((i12 & 8) != 0) {
                bVar = null;
            }
            aVar.a(activity, str, i11, bVar);
        }

        public final void a(Activity context, String uri, int i11, b1.b<Intent> bVar) {
            Intrinsics.g(context, "context");
            Intrinsics.g(uri, "uri");
            Intent intent = new Intent(context, (Class<?>) ClippingImageActivity.class);
            intent.putExtra("uri", uri);
            intent.putExtra("source", i11);
            if (bVar != null) {
                bVar.a(intent);
            } else {
                context.startActivityForResult(intent, 10002);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements io.reactivex.rxjava3.core.o<File> {
        public b() {
        }

        @Override // io.reactivex.rxjava3.core.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(File file) {
            Intrinsics.g(file, "file");
            uo.b.a.f(uo.b.f78622a, ClippingImageActivity.this.f56484c, "onNext e:" + file.getAbsolutePath(), false, 4, null);
            Intent intent = new Intent();
            PhotoEntity photoEntity = new PhotoEntity();
            photoEntity.setWidth(ClippingImageActivity.this.f56487g);
            photoEntity.setHeight(ClippingImageActivity.this.f56488h);
            photoEntity.setLocalPath(file.getAbsolutePath());
            photoEntity.setImageSize(ClippingImageActivity.this.f56489i);
            intent.putExtra("clip_result", photoEntity);
            ClippingImageActivity.this.setResult(10003, intent);
            ClippingImageActivity.this.finish();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            ProgressBar progressBar = ((ew.a) ClippingImageActivity.this.getMViewBinding()).f64362d;
            Intrinsics.f(progressBar, "mViewBinding.clipLoading");
            so.c.g(progressBar);
            h10.b bVar = ClippingImageActivity.this.f56483b;
            if (bVar != null) {
                bVar.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable e11) {
            Intrinsics.g(e11, "e");
            ProgressBar progressBar = ((ew.a) ClippingImageActivity.this.getMViewBinding()).f64362d;
            Intrinsics.f(progressBar, "mViewBinding.clipLoading");
            so.c.g(progressBar);
            uo.b.a.f(uo.b.f78622a, ClippingImageActivity.this.f56484c, "onError e:" + e11, false, 4, null);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b d11) {
            Intrinsics.g(d11, "d");
            ClippingImageActivity.this.f56483b = d11;
        }
    }

    public static final void Z(ClippingImageActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a0(ClippingImageActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ProgressBar progressBar = ((ew.a) this$0.getMViewBinding()).f64362d;
        Intrinsics.f(progressBar, "mViewBinding.clipLoading");
        so.c.k(progressBar);
        ClipImageView clipImageView = ((ew.a) this$0.getMViewBinding()).f64364g;
        Intrinsics.f(clipImageView, "mViewBinding.srcPic");
        this$0.e0(clipImageView);
    }

    public static final void f0(ClippingImageActivity this$0, ClipImageView clipImageView, io.reactivex.rxjava3.core.k emitter) throws Throwable {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(clipImageView, "$clipImageView");
        Intrinsics.g(emitter, "emitter");
        uo.b.a.f(uo.b.f78622a, this$0.f56484c, "start....", false, 4, null);
        File fileX = this$0.X(clipImageView);
        if (emitter.isDisposed() || fileX == null) {
            return;
        }
        emitter.onNext(fileX);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        this.f56490j = getIntent().getIntExtra("source", 0);
        String stringExtra = getIntent().getStringExtra("uri");
        ((ew.a) getMViewBinding()).f64363f.setStart(0);
        if (stringExtra != null) {
            ClipImageView clipImageView = ((ew.a) getMViewBinding()).f64364g;
            Intrinsics.f(clipImageView, "mViewBinding.srcPic");
            b0(clipImageView, stringExtra);
        }
        ((ew.a) getMViewBinding()).f64360b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClippingImageActivity.Z(this.f56577a, view);
            }
        });
        ((ew.a) getMViewBinding()).f64365h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClippingImageActivity.a0(this.f56579a, view);
            }
        });
        int i11 = this.f56490j;
        if (i11 == 0 || 5 == i11) {
            this.f56485d = com.blankj.utilcode.util.d0.b() - 2;
            this.f56486f = iw.f.f67743a.a(this, 202.0f);
            ((ew.a) getMViewBinding()).f64363f.setSizeNeedChange(false);
            ((ew.a) getMViewBinding()).f64363f.setStartWH(this.f56485d, this.f56486f);
            ((ew.a) getMViewBinding()).f64363f.setSizeNeedChange(false);
            ((ew.a) getMViewBinding()).f64364g.setCropWH(this.f56485d, this.f56486f);
        } else {
            ((ew.a) getMViewBinding()).f64363f.setStart(1);
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null) {
            return;
        }
        logViewConfig.j(true);
    }

    private final void initView() {
        c0(this);
    }

    /* JADX WARN: Code duplicated, block: B:66:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public final File X(ClipImageView clipImageView) throws Throwable {
        FileOutputStream fileOutputStream;
        Bitmap bitmapClip;
        FileOutputStream fileOutputStream2 = null;
        try {
            int i11 = this.f56490j;
            if (i11 == 0 || 5 == i11) {
                Rect rect = ((ew.a) getMViewBinding()).f64363f.rect();
                Intrinsics.f(rect, "mViewBinding.clipview.rect()");
                bitmapClip = ((ew.a) getMViewBinding()).f64364g.clip(rect);
            } else {
                bitmapClip = ((ew.a) getMViewBinding()).f64364g.clip();
            }
            File file = new File(this.f56482a);
            String str = System.currentTimeMillis() + "temp_crop.png";
            if (!file.exists() && !file.mkdirs()) {
                uo.b.a.f(uo.b.f78622a, this.f56484c, "cropImage, mkdirs failed, file is " + file.getAbsolutePath(), false, 4, null);
            }
            File file2 = new File(file, str);
            fileOutputStream = new FileOutputStream(file2);
            if (bitmapClip != null) {
                try {
                    try {
                        bitmapClip.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    } catch (IOException e11) {
                        e = e11;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e15) {
                            e15.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            Integer numValueOf = bitmapClip != null ? Integer.valueOf(bitmapClip.getWidth()) : null;
            Intrinsics.d(numValueOf);
            this.f56487g = numValueOf.intValue();
            Integer numValueOf2 = bitmapClip != null ? Integer.valueOf(bitmapClip.getHeight()) : null;
            Intrinsics.d(numValueOf2);
            int iIntValue = numValueOf2.intValue();
            this.f56488h = iIntValue;
            this.f56489i = this.f56487g * iIntValue;
            try {
                fileOutputStream.flush();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            return file2;
        } catch (IOException e18) {
            e = e18;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream2 != null) {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public ew.a getViewBinding() {
        ew.a aVarC = ew.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    public final void b0(ClipImageView clipImageView, String str) {
        Glide.with(clipImageView).load2(Uri.fromFile(new File(str))).into(clipImageView);
    }

    public final void c0(Context context) {
        String str;
        String str2 = this.f56482a;
        if (str2 == null || (str2 != null && kotlin.text.l.L(str2, "/data/user/", false, 2, null))) {
            File fileA = iw.d.a(context);
            if (fileA != null) {
                str = fileA.getAbsolutePath() + "/crop/";
            } else {
                str = context.getCacheDir().getAbsolutePath() + "/crop/";
            }
            this.f56482a = str;
        }
        d0(this.f56482a);
    }

    public final void d0(String str) {
        if (str == null) {
            return;
        }
        com.blankj.utilcode.util.m.b(str);
    }

    public final void e0(final ClipImageView clipImageView) {
        io.reactivex.rxjava3.core.j.f(new io.reactivex.rxjava3.core.l() { // from class: com.transsion.publish.ui.c
            @Override // io.reactivex.rxjava3.core.l
            public final void a(io.reactivex.rxjava3.core.k kVar) throws Throwable {
                ClippingImageActivity.f0(this.f56581a, clipImageView, kVar);
            }
        }).r(io.reactivex.rxjava3.android.schedulers.b.c()).A(q10.a.b()).subscribe(new b());
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("clipping_image", false, 2, null);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }
}
