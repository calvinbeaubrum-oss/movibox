package com.transsion.publish.ui;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$string;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.bean.PreviewMediaConfirmEvent;
import com.transsion.publish.bean.PreviewVideoBean;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

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
public class VideoPreviewActivity extends BaseActivity<ew.g> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f56571g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VsMediaInfo f56572a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f56575d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f56573b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56574c = 1048576000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f56576f = 1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, VsMediaInfo data, int i11) {
            Intrinsics.g(context, "context");
            Intrinsics.g(data, "data");
            Intent intent = new Intent(context, (Class<?>) VideoPreviewActivity.class);
            intent.setFlags(ASTNode.DEOP);
            intent.putExtra("data", data);
            intent.putExtra("sourceType", i11);
            context.startActivity(intent);
        }
    }

    public static final void d0(VideoPreviewActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.Z();
    }

    public static final void e0(VideoPreviewActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.Z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g0(VideoPreviewActivity this$0, Bitmap bitmap) {
        Intrinsics.g(this$0, "this$0");
        ((ew.g) this$0.getMViewBinding()).f64409i.setImageBitmap(this$0.l0(bitmap));
    }

    public static final void h0(VideoPreviewActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    public static final void i0(final VideoPreviewActivity this$0, MediaPlayer mediaPlayer) {
        Intrinsics.g(this$0, "this$0");
        if (mediaPlayer != null) {
            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.transsion.publish.ui.v0
                @Override // android.media.MediaPlayer.OnInfoListener
                public final boolean onInfo(MediaPlayer mediaPlayer2, int i11, int i12) {
                    return VideoPreviewActivity.j0(this.f56618a, mediaPlayer2, i11, i12);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        this.f56573b = Integer.valueOf(getIntent().getIntExtra("sourceType", 2));
        if (getIntent().hasExtra("data")) {
            ProgressBar progressBar = ((ew.g) getMViewBinding()).f64407g;
            Intrinsics.f(progressBar, "mViewBinding.clipLoading");
            so.c.k(progressBar);
            Serializable serializableExtra = getIntent().getSerializableExtra("data");
            Intrinsics.e(serializableExtra, "null cannot be cast to non-null type com.transsion.publish.api.VsMediaInfo");
            VsMediaInfo vsMediaInfo = (VsMediaInfo) serializableExtra;
            this.f56572a = vsMediaInfo;
            Intrinsics.d(vsMediaInfo);
            k0(vsMediaInfo);
        }
        Integer num = this.f56573b;
        if (num != null && num.intValue() == 1) {
            ((ew.g) getMViewBinding()).f64411k.setVisibility(8);
            ((ew.g) getMViewBinding()).f64410j.setVisibility(0);
            FrameLayout frameLayout = ((ew.g) getMViewBinding()).f64410j;
            Intrinsics.f(frameLayout, "mViewBinding.flClear");
            so.c.c(frameLayout, 0L, new Function1<View, Unit>() { // from class: com.transsion.publish.ui.VideoPreviewActivity.initData.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.g(it, "it");
                    cw.a aVar = new cw.a();
                    aVar.o(1);
                    aVar.n(2);
                    FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                    String name = cw.a.class.getName();
                    Intrinsics.f(name, "T::class.java.name");
                    flowEventBus.postEvent(name, aVar, 0L);
                    VideoPreviewActivity.this.finish();
                }
            }, 1, null);
        } else if (num != null && num.intValue() == 2) {
            ((ew.g) getMViewBinding()).f64410j.setVisibility(8);
            ((ew.g) getMViewBinding()).f64411k.setVisibility(0);
            VsMediaInfo vsMediaInfo2 = this.f56572a;
            if (vsMediaInfo2 != null) {
                m0(vsMediaInfo2.getEnableSelect());
            }
            Group group = ((ew.g) getMViewBinding()).f64403b;
            Intrinsics.f(group, "mViewBinding.bottomGroup");
            so.c.k(group);
            LinearLayout linearLayout = ((ew.g) getMViewBinding()).f64411k;
            Intrinsics.f(linearLayout, "mViewBinding.llSelect");
            so.c.c(linearLayout, 0L, new Function1<View, Unit>() { // from class: com.transsion.publish.ui.VideoPreviewActivity.initData.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.g(it, "it");
                    VsMediaInfo vsMediaInfo3 = VideoPreviewActivity.this.f56572a;
                    if (vsMediaInfo3 != null) {
                        VideoPreviewActivity videoPreviewActivity = VideoPreviewActivity.this;
                        if (vsMediaInfo3.getVideoSize() > videoPreviewActivity.f56574c) {
                            zp.b.f82110a.e(Utils.a().getResources().getString(R$string.add_media_max_size_tips, 50));
                            return;
                        }
                        vsMediaInfo3.setEnableSelect(!vsMediaInfo3.getEnableSelect());
                        PreviewVideoBean previewVideoBean = new PreviewVideoBean();
                        previewVideoBean.setFrom(videoPreviewActivity.f56573b);
                        previewVideoBean.setSelect(vsMediaInfo3);
                        if (vsMediaInfo3.getEnableSelect()) {
                            previewVideoBean.setOperator(1);
                        } else {
                            previewVideoBean.setOperator(3);
                        }
                        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                        String name = PreviewVideoBean.class.getName();
                        Intrinsics.f(name, "T::class.java.name");
                        flowEventBus.postEvent(name, previewVideoBean, 0L);
                        videoPreviewActivity.m0(vsMediaInfo3.getEnableSelect());
                    }
                }
            }, 1, null);
        }
        ProgressBar progressBar2 = ((ew.g) getMViewBinding()).f64407g;
        Intrinsics.f(progressBar2, "mViewBinding.clipLoading");
        so.c.g(progressBar2);
        ((ew.g) getMViewBinding()).f64418r.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPreviewActivity.d0(this.f56610a, view);
            }
        });
        ((ew.g) getMViewBinding()).f64413m.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPreviewActivity.e0(this.f56613a, view);
            }
        });
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null) {
            return;
        }
        logViewConfig.j(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((ew.g) getMViewBinding()).f64405d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPreviewActivity.h0(this.f56606a, view);
            }
        });
        ((ew.g) getMViewBinding()).f64418r.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.transsion.publish.ui.r0
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                VideoPreviewActivity.i0(this.f56608a, mediaPlayer);
            }
        });
        TextView textView = ((ew.g) getMViewBinding()).f64408h;
        Intrinsics.f(textView, "mViewBinding.confirmTV");
        so.c.c(textView, 0L, new Function1<View, Unit>() { // from class: com.transsion.publish.ui.VideoPreviewActivity.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                PreviewMediaConfirmEvent previewMediaConfirmEvent = new PreviewMediaConfirmEvent(1);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = PreviewMediaConfirmEvent.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, previewMediaConfirmEvent, 0L);
                VideoPreviewActivity.this.finish();
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean j0(VideoPreviewActivity this$0, MediaPlayer mediaPlayer, int i11, int i12) {
        Intrinsics.g(this$0, "this$0");
        if (i11 == 3) {
            ImageView imageView = ((ew.g) this$0.getMViewBinding()).f64409i;
            Intrinsics.f(imageView, "mViewBinding.coverIV");
            so.c.g(imageView);
        }
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        ((ew.g) this$0.getMViewBinding()).f64418r.setBackgroundColor(com.blankj.utilcode.util.h.a(R$color.transparent));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(boolean z11) {
        TextView textView = ((ew.g) getMViewBinding()).f64414n;
        Intrinsics.f(textView, "mViewBinding.selectNumTV");
        textView.setVisibility(z11 > 0 ? 0 : 8);
        ((ew.g) getMViewBinding()).f64414n.setText(getString(R$string.video_select_num_tips, Integer.valueOf(z11 ? 1 : 0), Integer.valueOf(this.f56576f)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z() {
        if (((ew.g) getMViewBinding()).f64418r.isPlaying()) {
            n0();
        } else {
            o0();
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public ew.g getViewBinding() {
        ew.g gVarC = ew.g.c(getLayoutInflater());
        Intrinsics.f(gVarC, "inflate(layoutInflater)");
        return gVarC;
    }

    public final void b0() {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (getSupportActionBar() != null) {
            androidx.appcompat.app.a supportActionBar = getSupportActionBar();
            Intrinsics.d(supportActionBar);
            supportActionBar.k();
        }
        if (getActionBar() != null) {
            ActionBar actionBar = getActionBar();
            Intrinsics.d(actionBar);
            actionBar.hide();
        }
    }

    public final void c0() {
        View decorView = getWindow().getDecorView();
        Intrinsics.f(decorView, "window.decorView");
        decorView.setSystemUiVisibility(4102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f0(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        final Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 2);
        ((ew.g) getMViewBinding()).getRoot().post(new Runnable() { // from class: com.transsion.publish.ui.u0
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreviewActivity.g0(this.f56615a, frameAtTime);
            }
        });
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void k0(VsMediaInfo vsMediaInfo) {
        try {
            String videoPath = vsMediaInfo.getVideoPath();
            f0(videoPath);
            ((ew.g) getMViewBinding()).f64418r.setVideoPath(videoPath);
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message != null) {
                uo.b.a.g(uo.b.f78622a, message, false, 2, null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Bitmap l0(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        ImageView imageView = ((ew.g) getMViewBinding()).f64409i;
        Intrinsics.f(imageView, "mViewBinding.coverIV");
        return (height <= 0 || width <= 0 || width > imageView.getWidth() || height > imageView.getHeight()) ? bitmap : to.a.b(bitmap, imageView.getWidth(), imageView.getHeight(), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m0(boolean z11) {
        if (z11) {
            ((ew.g) getMViewBinding()).f64416p.setText("1");
            ((ew.g) getMViewBinding()).f64416p.setBackgroundResource(R$drawable.bg_linear_r16);
        } else {
            ((ew.g) getMViewBinding()).f64416p.setBackgroundResource(R$drawable.ic_select_number_bro);
        }
        Y(z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n0() {
        ((ew.g) getMViewBinding()).f64418r.pause();
        ImageView imageView = ((ew.g) getMViewBinding()).f64412l;
        Intrinsics.f(imageView, "mViewBinding.playIV");
        so.c.k(imageView);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("video_preview", false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o0() {
        ((ew.g) getMViewBinding()).f64418r.start();
        ImageView imageView = ((ew.g) getMViewBinding()).f64412l;
        Intrinsics.f(imageView, "mViewBinding.playIV");
        so.c.g(imageView);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        b0();
        c0();
        super.onCreate(bundle);
        initView();
        initData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ProgressBar progressBar = ((ew.g) getMViewBinding()).f64407g;
        Intrinsics.f(progressBar, "mViewBinding.clipLoading");
        so.c.g(progressBar);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f56575d) {
            this.f56575d = false;
            VsMediaInfo vsMediaInfo = this.f56572a;
            Intrinsics.d(vsMediaInfo);
            k0(vsMediaInfo);
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f56575d = true;
        n0();
    }
}
