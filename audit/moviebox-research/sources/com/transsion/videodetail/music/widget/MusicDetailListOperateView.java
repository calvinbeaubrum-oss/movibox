package com.transsion.videodetail.music.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import com.tn.lib.widget.R$color;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.videodetail.R$drawable;
import com.transsion.videodetail.music.bean.MusicStateEnum;
import com.transsion.videodetail.music.ui.MusicDetailLikedFragment;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rz.k;
import sz.c;

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
public final class MusicDetailListOperateView extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MusicDetailLikedFragment f59988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super String, ? super String, Unit> f59989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f59990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f59991d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MusicStateEnum f59992f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f59993a;

        static {
            int[] iArr = new int[MusicStateEnum.values().length];
            try {
                iArr[MusicStateEnum.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MusicStateEnum.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MusicStateEnum.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f59993a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public MusicDetailListOperateView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MusicDetailListOperateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        MusicStateEnum musicStateEnum = MusicStateEnum.CLOSE;
        this.f59992f = musicStateEnum;
        k kVarC = k.c(LayoutInflater.from(context), this, false);
        this.f59990c = kVarC;
        addView(kVarC != null ? kVarC.getRoot() : null);
        setState(musicStateEnum);
        g();
        c();
    }

    public /* synthetic */ MusicDetailListOperateView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final void c() {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        k kVar = this.f59990c;
        if (kVar != null && (appCompatImageView2 = kVar.f75883b) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.widget.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MusicDetailListOperateView.d(this.f59994a, view);
                }
            });
        }
        k kVar2 = this.f59990c;
        if (kVar2 == null || (appCompatImageView = kVar2.f75885d) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.music.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MusicDetailListOperateView.e(this.f59995a, view);
            }
        });
    }

    public static final void d(MusicDetailListOperateView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        MusicStateEnum musicStateEnum = this$0.f59992f;
        int i11 = musicStateEnum == null ? -1 : a.f59993a[musicStateEnum.ordinal()];
        if (i11 == 1) {
            this$0.i();
            this$0.f59992f = MusicStateEnum.OPEN;
        } else {
            if (i11 != 2) {
                return;
            }
            this$0.f59992f = MusicStateEnum.CLOSE;
            this$0.h();
        }
    }

    public static final void e(MusicDetailListOperateView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        c.f76641a.c();
        this$0.j();
    }

    private final void g() {
        AppCompatImageView appCompatImageView;
        k kVar = this.f59990c;
        if (kVar != null && (appCompatImageView = kVar.f75884c) != null) {
            try {
                Result.Companion companion = Result.Companion;
                appCompatImageView.setImageResource(R$drawable.video_detail_ic_playing);
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
        k(true);
        j();
    }

    private final String getClassTag() {
        String simpleName = MusicDetailListOperateView.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void f(FragmentManager fragmentManager, int i11, String str) {
        MusicDetailLikedFragment musicDetailLikedFragment = new MusicDetailLikedFragment();
        musicDetailLikedFragment.y1(this);
        musicDetailLikedFragment.w1(this.f59989b);
        musicDetailLikedFragment.x1(str, new Function2<Integer, Integer, Unit>() { // from class: com.transsion.videodetail.music.widget.MusicDetailListOperateView$initMusicListFragment$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i12, int i13) {
                String str2;
                if (i13 == 0) {
                    str2 = "Now playing";
                } else {
                    str2 = "Now playing " + i12 + "/" + i13;
                }
                k kVar = this.this$0.f59990c;
                AppCompatTextView appCompatTextView = kVar != null ? kVar.f75887g : null;
                if (appCompatTextView != null) {
                    appCompatTextView.setText(str2);
                }
                this.this$0.k(true);
            }
        });
        this.f59988a = musicDetailLikedFragment;
        fragmentManager.beginTransaction().add(i11, musicDetailLikedFragment).commit();
    }

    public final MusicDetailLikedFragment getMusicDetailLikedFragment() {
        return this.f59988a;
    }

    public final void h() {
        AppCompatImageView appCompatImageView;
        k kVar = this.f59990c;
        if (kVar != null && (appCompatImageView = kVar.f75883b) != null) {
            appCompatImageView.setImageResource(R$drawable.music_iv_right);
        }
        k kVar2 = this.f59990c;
        AppCompatImageView appCompatImageView2 = kVar2 != null ? kVar2.f75886f : null;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(8);
        }
        k kVar3 = this.f59990c;
        AppCompatImageView appCompatImageView3 = kVar3 != null ? kVar3.f75885d : null;
        if (appCompatImageView3 != null) {
            appCompatImageView3.setVisibility(8);
        }
        k kVar4 = this.f59990c;
        AppCompatImageView appCompatImageView4 = kVar4 != null ? kVar4.f75884c : null;
        if (appCompatImageView4 != null) {
            appCompatImageView4.setVisibility(0);
        }
        FrameLayout frameLayout = this.f59991d;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public final void i() {
        AppCompatImageView appCompatImageView;
        k kVar = this.f59990c;
        if (kVar != null && (appCompatImageView = kVar.f75883b) != null) {
            appCompatImageView.setImageResource(R$drawable.music_iv_close);
        }
        k kVar2 = this.f59990c;
        AppCompatImageView appCompatImageView2 = kVar2 != null ? kVar2.f75884c : null;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(8);
        }
        FrameLayout frameLayout = this.f59991d;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        k kVar3 = this.f59990c;
        AppCompatImageView appCompatImageView3 = kVar3 != null ? kVar3.f75885d : null;
        if (appCompatImageView3 == null) {
            return;
        }
        appCompatImageView3.setVisibility(0);
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.a(this);
    }

    public final void j() {
        AppCompatImageView appCompatImageView;
        k kVar = this.f59990c;
        if (kVar != null && (appCompatImageView = kVar.f75885d) != null) {
            c cVar = c.f76641a;
            appCompatImageView.setImageDrawable(cVar.a(cVar.b()));
        }
        sz.a.f76638a.a(getClassTag() + " --> showLoopIcon() --> 当前播放模式是 = " + c.f76641a.b());
    }

    public final void k(boolean z11) {
        AppCompatImageView appCompatImageView;
        k kVar = this.f59990c;
        if (kVar == null || (appCompatImageView = kVar.f75884c) == null) {
            return;
        }
        appCompatImageView.setColorFilter(z11 ? new PorterDuffColorFilter(z2.a.getColor(appCompatImageView.getContext(), R$color.brand), PorterDuff.Mode.SRC_ATOP) : new PorterDuffColorFilter(z2.a.getColor(appCompatImageView.getContext(), R$color.line_02), PorterDuff.Mode.SRC_ATOP));
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        e.a.b(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        e.a.c(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        e.a.d(this, mediaSource);
        k(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        e.a.f(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z11) {
        e.a.g(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(MediaSource mediaSource) {
        e.a.h(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        e.a.j(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        e.a.l(this, i11, f11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.n(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.o(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, MediaSource mediaSource) {
        e.a.p(this, playError, mediaSource);
    }

    public void onPlayErrorChangePayer(TnPlayerType tnPlayerType, MediaSource mediaSource) {
        e.a.r(this, tnPlayerType, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        e.a.s(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.u(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        e.a.v(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        e.a.x(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.z(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.A(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        e.a.B(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c cVar) {
        e.a.C(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        e.a.D(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        e.a.E(this, mediaSource);
        k(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        e.a.H(this, mediaSource);
        k(true);
    }

    public final void setContainer(String str, FrameLayout frameLayout, FragmentManager childFragmentManager, int i11, Function2<? super String, ? super String, Unit> onItemCLick) {
        Intrinsics.g(childFragmentManager, "childFragmentManager");
        Intrinsics.g(onItemCLick, "onItemCLick");
        this.f59991d = frameLayout;
        this.f59989b = onItemCLick;
        f(childFragmentManager, i11, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.J(this);
    }

    public final void setState(MusicStateEnum state) {
        Intrinsics.g(state, "state");
        this.f59992f = state;
        int i11 = a.f59993a[state.ordinal()];
        if (i11 == 1) {
            h();
        } else if (i11 == 2) {
            i();
        } else {
            if (i11 != 3) {
                return;
            }
            setVisibility(8);
        }
    }
}
