package com.transsion.baseui.music;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.baseui.R$anim;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.R$layout;
import com.transsion.baseui.activity.BaseMusicFloatActivity;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.player.mediasession.MediaItem;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MusicFloatView extends FrameLayout {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fs.e f51413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f51414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f51415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f51416d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f51417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f51418g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.lifecycle.f {
        public a() {
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onCreate(u uVar) {
            androidx.lifecycle.e.a(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public void onDestroy(u owner) {
            Intrinsics.g(owner, "owner");
            androidx.lifecycle.e.b(this, owner);
            owner.getLifecycle().d(this);
            MusicFloatView.this.getMHandler().removeCallbacksAndMessages(null);
        }

        @Override // androidx.lifecycle.f
        public void onPause(u owner) {
            Intrinsics.g(owner, "owner");
            androidx.lifecycle.e.c(this, owner);
            MusicFloatView.this.getMHandler().removeCallbacks(MusicFloatView.this.f51415c);
        }

        @Override // androidx.lifecycle.f
        public void onResume(u owner) {
            Intrinsics.g(owner, "owner");
            androidx.lifecycle.e.d(this, owner);
            MusicFloatView.this.refresh();
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStart(u uVar) {
            androidx.lifecycle.e.e(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStop(u uVar) {
            androidx.lifecycle.e.f(this, uVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f51420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MusicFloatView f51421b;

        public b(View view, MusicFloatView musicFloatView) {
            this.f51420a = view;
            this.f51421b = musicFloatView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f51420a.setVisibility(8);
            RoundedCornerLayout roundedCornerLayout = this.f51421b.f51413a.f65276i;
            Intrinsics.f(roundedCornerLayout, "binding.roundFold");
            so.c.k(roundedCornerLayout);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MusicFloatView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MusicFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicFloatView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f51414b = "";
        this.f51415c = new Runnable() { // from class: com.transsion.baseui.music.d
            @Override // java.lang.Runnable
            public final void run() {
                MusicFloatView.p(this.f51432a);
            }
        };
        this.f51416d = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.baseui.music.MusicFloatView$mHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        fs.e eVarA = fs.e.a(LayoutInflater.from(getContext()).inflate(R$layout.music_float_layout, (ViewGroup) this, true));
        Intrinsics.f(eVarA, "bind(root)");
        this.f51413a = eVarA;
        setExpand(MusicFloatManager.f51403i.b().t());
        i();
        h();
        q();
    }

    private final String getClassTag() {
        String simpleName = MusicFloatView.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getMHandler() {
        return (Handler) this.f51416d.getValue();
    }

    public static final void j(MusicFloatView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.setExpand(true);
        this$0.q();
    }

    public static final void k(View view) {
        Intent clickIntent;
        MediaItem mediaItemO = MusicFloatManager.f51403i.b().o();
        if (mediaItemO == null || (clickIntent = mediaItemO.getClickIntent()) == null) {
            return;
        }
        clickIntent.addFlags(ASTNode.DEOP);
        String stringExtra = clickIntent.getStringExtra(MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        String stringExtra2 = clickIntent.getStringExtra("id");
        String stringExtra3 = clickIntent.getStringExtra("extra_resource_id");
        String stringExtra4 = clickIntent.getStringExtra("extra_local_path");
        boolean booleanExtra = clickIntent.getBooleanExtra("isMusicLikedFragment", false);
        Log.e("m_d_log", "initListener -->  path = " + stringExtra + " -- id = " + stringExtra2 + " -- isMusicLikedFragment = " + booleanExtra);
        com.alibaba.android.arouter.launcher.a.d().b(stringExtra).withString("id", stringExtra2).withBoolean("is_music_liked_fragment", booleanExtra).withString("extra_resource_id", stringExtra3).withString("extra_local_path", stringExtra4).withBoolean("isMusicFloatViewClick", true).navigation();
    }

    public static final void l(final MusicFloatView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        MusicFloatManager.a aVar = MusicFloatManager.f51403i;
        com.transsion.player.orplayer.f fVarQ = aVar.b().q();
        if (fVarQ != null) {
            fVarQ.pause();
        }
        aVar.b().z(null);
        this$0.setVisibility(8);
        this$0.f51414b = "";
        this$0.post(new Runnable() { // from class: com.transsion.baseui.music.i
            @Override // java.lang.Runnable
            public final void run() {
                MusicFloatView.m(this.f51436a);
            }
        });
        com.transsion.player.mediasession.c.f54613a.p();
    }

    public static final void m(MusicFloatView this$0) {
        Intrinsics.g(this$0, "this$0");
        Context context = this$0.getContext();
        BaseMusicFloatActivity baseMusicFloatActivity = context instanceof BaseMusicFloatActivity ? (BaseMusicFloatActivity) context : null;
        if (baseMusicFloatActivity != null) {
            baseMusicFloatActivity.onCloseMusicFloating();
        }
    }

    public static final void n(MusicFloatView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baseui.util.d.b(0L, new MusicFloatView$initListener$4$1(this$0), 1, null);
    }

    public static final void p(MusicFloatView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.refresh();
    }

    public static final void r(MusicFloatView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.setExpand(false);
    }

    public final void h() {
        Lifecycle lifecycle;
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (lifecycle = appCompatActivity.getLifecycle()) == null) {
            return;
        }
        lifecycle.a(new a());
    }

    public final void i() {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        RoundedCornerLayout roundedCornerLayout;
        this.f51413a.f65276i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.baseui.music.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MusicFloatView.j(this.f51433a, view);
            }
        });
        fs.e eVar = this.f51413a;
        if (eVar != null && (roundedCornerLayout = eVar.f65275h) != null) {
            roundedCornerLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.baseui.music.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MusicFloatView.k(view);
                }
            });
        }
        fs.e eVar2 = this.f51413a;
        if (eVar2 != null && (appCompatImageView2 = eVar2.f65270b) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.baseui.music.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MusicFloatView.l(this.f51434a, view);
                }
            });
        }
        fs.e eVar3 = this.f51413a;
        if (eVar3 == null || (appCompatImageView = eVar3.f65273f) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.baseui.music.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MusicFloatView.n(this.f51435a, view);
            }
        });
    }

    public final void o(MediaItem mediaItem) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        Long position = mediaItem.getPosition();
        long jLongValue = position != null ? position.longValue() : 0L;
        if (jLongValue != this.f51417f) {
            this.f51417f = jLongValue;
            this.f51418g = 0;
        } else {
            this.f51418g++;
        }
        if (!TextUtils.isEmpty(mediaItem.getTitle())) {
            fs.e eVar = this.f51413a;
            AppCompatTextView appCompatTextView = eVar != null ? eVar.f65278k : null;
            if (appCompatTextView != null) {
                appCompatTextView.setText(mediaItem.getTitle());
            }
        }
        Long duration = mediaItem.getDuration();
        long jLongValue2 = duration != null ? duration.longValue() : 0L;
        Long position2 = mediaItem.getPosition();
        long jLongValue3 = position2 != null ? position2.longValue() : 0L;
        if (jLongValue2 > 0) {
            this.f51413a.f65274g.setProgress((int) ((jLongValue3 * 10000.0f) / jLongValue2));
        }
        if (!TextUtils.equals(this.f51414b, mediaItem.getCoverUrl())) {
            this.f51414b = mediaItem.getCoverUrl();
            fs.e eVar2 = this.f51413a;
            if (eVar2 != null && (appCompatImageView3 = eVar2.f65271c) != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = getContext();
                Intrinsics.f(context, "context");
                String coverUrl = mediaItem.getCoverUrl();
                if (coverUrl == null) {
                    coverUrl = "";
                }
                companion.r(context, appCompatImageView3, coverUrl, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            }
        }
        com.transsion.player.orplayer.f fVarQ = MusicFloatManager.f51403i.b().q();
        if (fVarQ == null || !fVarQ.isPlaying()) {
            fs.e eVar3 = this.f51413a;
            if (eVar3 != null && (appCompatImageView = eVar3.f65273f) != null) {
                appCompatImageView.setImageResource(R$drawable.music_float_pause);
            }
        } else {
            fs.e eVar4 = this.f51413a;
            if (eVar4 != null && (appCompatImageView2 = eVar4.f65273f) != null) {
                appCompatImageView2.setImageResource(R$drawable.music_float_play);
            }
        }
        getMHandler().removeCallbacks(this.f51415c);
        getMHandler().postDelayed(this.f51415c, 1000L);
    }

    public final void q() {
        getMHandler().removeCallbacksAndMessages(null);
        getMHandler().postDelayed(new Runnable() { // from class: com.transsion.baseui.music.c
            @Override // java.lang.Runnable
            public final void run() {
                MusicFloatView.r(this.f51431a);
            }
        }, 10000L);
    }

    public final void refresh() {
        MediaItem mediaItemO = MusicFloatManager.f51403i.b().o();
        if (mediaItemO == null) {
            com.transsion.player.mediasession.d.f54622a.a(getClassTag() + " --> refresh() --> musicFloatBean == null --> 没有数据不展示UI");
            setVisibility(8);
            return;
        }
        if (!Intrinsics.b(mediaItemO.isMusic(), Boolean.FALSE)) {
            mediaItemO.setPageName("music_float");
            setVisibility(0);
            o(mediaItemO);
            return;
        }
        com.transsion.player.mediasession.d.f54622a.a(getClassTag() + " --> refresh() --> musicFloatBean.isMusic == false --> 当前不是Music类型，不展示悬浮窗");
        setVisibility(8);
    }

    public final void s(View view) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.music_slide_left);
        animationLoadAnimation.setAnimationListener(new b(view, this));
        view.startAnimation(animationLoadAnimation);
    }

    public final void setExpand(boolean z11) {
        MusicFloatManager.f51403i.b().y(z11);
        if (z11) {
            RoundedCornerLayout roundedCornerLayout = this.f51413a.f65275h;
            Intrinsics.f(roundedCornerLayout, "binding.roundExpand");
            t(roundedCornerLayout);
        } else {
            RoundedCornerLayout roundedCornerLayout2 = this.f51413a.f65275h;
            Intrinsics.f(roundedCornerLayout2, "binding.roundExpand");
            s(roundedCornerLayout2);
        }
    }

    public final void t(View view) {
        view.setVisibility(0);
        RoundedCornerLayout roundedCornerLayout = this.f51413a.f65276i;
        Intrinsics.f(roundedCornerLayout, "binding.roundFold");
        so.c.g(roundedCornerLayout);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.music_slide_right);
        animationLoadAnimation.setAnimationListener(new c());
        view.startAnimation(animationLoadAnimation);
    }
}
