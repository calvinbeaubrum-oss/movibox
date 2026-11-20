package com.transsion.postdetail.layer.local;

import android.R;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import com.alibaba.android.arouter.facade.Postcard;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.MBridgeConstans;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.music.MusicFloatManager;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.layer.BaseLayer;
import com.transsion.postdetail.layer.SystemTimeManager;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment;
import com.transsion.postdetail.util.LocalFloatManager;
import com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel;
import com.transsion.push.api.IPushProvider;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsion.videofloat.VideoFloatManager;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsnet.downloader.util.LocalVideoNotExistUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
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
@SourceDebugExtension
public abstract class BaseLocalVideoLayer extends BaseLayer implements wv.d, com.transsion.player.orplayer.e, RoomActivityLifecycleCallbacks.a {
    public boolean A;
    public boolean B;
    public View C;
    public View D;
    public float E;
    public long F;
    public final Lazy G;
    public final Lazy H;
    public DownloadBean I;
    public String J;
    public String K;
    public String L;
    public boolean M;
    public wv.c N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public final Lazy V;
    public final Runnable W;
    public String[] X;
    public int Y;
    public final Runnable Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final Runnable f55123a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public long f55124b0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f55125k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Fragment f55126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f55127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f55128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f55129o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f55130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f55131q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f55132r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f55133s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SystemTimeManager f55134t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public wv.b f55135u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public VideoSubtitleControl f55136v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.transsion.player.helper.g f55137w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public f0 f55138x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f55139y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f55140z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55141a;

        static {
            int[] iArr = new int[LocalUiType.values().length];
            try {
                iArr[LocalUiType.MIDDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LocalUiType.LAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LocalUiType.PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f55141a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements is.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f55142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f55143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f55144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f55145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f55146e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f55147f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f55148g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f55150i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f55151j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f55152k;

        public b(boolean z11, int i11, int i12) {
            this.f55150i = z11;
            this.f55151j = i11;
            this.f55152k = i12;
        }

        @Override // is.c.a
        public void a() {
            Group groupB2 = BaseLocalVideoLayer.this.B2();
            if (groupB2 == null || groupB2.getVisibility() != 8) {
                BaseLocalVideoLayer.this.f1(true);
            } else {
                BaseLocalVideoLayer.e2(BaseLocalVideoLayer.this, false, 1, null);
            }
        }

        @Override // is.c.a
        public void b(float f11, float f12) {
            long j11 = 0;
            if (!this.f55144c) {
                SecondariesSeekBar secondariesSeekBarW1 = BaseLocalVideoLayer.this.W1();
                this.f55147f = secondariesSeekBarW1 != null ? secondariesSeekBarW1.getProgress() : 0L;
                BaseLocalVideoLayer.this.d2(false);
            }
            BaseLocalVideoLayer.this.f55133s = true;
            this.f55144c = true;
            BaseLocalVideoLayer.this.H0().removeCallbacks(BaseLocalVideoLayer.this.W);
            float f13 = this.f55150i ? f11 - f12 : f12 - f11;
            float f14 = 10000L;
            long j12 = (long) (this.f55147f + ((f13 * f14) / (this.f55151j * 4)));
            if (j12 >= 0) {
                j11 = j12 > 10000 ? 10000L : j12;
            }
            SecondariesSeekBar secondariesSeekBarW2 = BaseLocalVideoLayer.this.W1();
            if (secondariesSeekBarW2 != null) {
                secondariesSeekBarW2.setProgress(j11);
            }
            this.f55143b = (j11 * 1.0f) / f14;
            long jY0 = (long) (BaseLocalVideoLayer.this.Y0() * this.f55143b);
            this.f55142a = jY0;
            BaseLocalVideoLayer.this.F = jY0;
            BaseLocalVideoLayer.this.E2(true, this.f55142a);
        }

        @Override // is.c.a
        public void c(float f11, float f12) {
            com.transsion.player.helper.g gVar = null;
            if (!this.f55146e) {
                com.transsion.player.helper.g gVar2 = BaseLocalVideoLayer.this.f55137w;
                if (gVar2 == null) {
                    Intrinsics.y("volumeControl");
                    gVar2 = null;
                }
                gVar2.f(false);
                com.transsion.player.helper.g gVar3 = BaseLocalVideoLayer.this.f55137w;
                if (gVar3 == null) {
                    Intrinsics.y("volumeControl");
                    gVar3 = null;
                }
                this.f55148g = gVar3.b();
                this.f55146e = true;
            }
            float f13 = ((f11 - f12) * 2) / this.f55152k;
            com.transsion.player.helper.g gVar4 = BaseLocalVideoLayer.this.f55137w;
            if (gVar4 == null) {
                Intrinsics.y("volumeControl");
            } else {
                gVar = gVar4;
            }
            gVar.a(this.f55148g, f13);
        }

        @Override // is.c.a
        public void d(float f11, float f12) {
            com.transsion.player.helper.g gVar = null;
            if (!this.f55145d) {
                com.transsion.player.helper.g gVar2 = BaseLocalVideoLayer.this.f55137w;
                if (gVar2 == null) {
                    Intrinsics.y("volumeControl");
                    gVar2 = null;
                }
                gVar2.f(false);
                this.f55145d = true;
            }
            com.transsion.player.helper.g gVar3 = BaseLocalVideoLayer.this.f55137w;
            if (gVar3 == null) {
                Intrinsics.y("volumeControl");
            } else {
                gVar = gVar3;
            }
            gVar.d(f11, f12, this.f55152k);
        }

        @Override // is.c.a
        public void e() {
            com.transsion.player.orplayer.f fVarG;
            if (this.f55144c) {
                com.transsion.player.orplayer.f fVarG2 = BaseLocalVideoLayer.this.G();
                if (fVarG2 != null) {
                    fVarG2.seekTo(this.f55142a);
                }
                com.transsion.player.orplayer.f fVarG3 = BaseLocalVideoLayer.this.G();
                if (fVarG3 != null && !fVarG3.isPlaying() && (fVarG = BaseLocalVideoLayer.this.G()) != null) {
                    fVarG.play();
                }
                Fragment fragment = BaseLocalVideoLayer.this.f55126l;
                LocalVideoDetailFragment localVideoDetailFragment = fragment instanceof LocalVideoDetailFragment ? (LocalVideoDetailFragment) fragment : null;
                if (localVideoDetailFragment != null) {
                    localVideoDetailFragment.D3(this.f55142a, this.f55143b);
                }
                BaseLocalVideoLayer.this.E2(false, 0L);
                BaseLocalVideoLayer.this.f1(false);
            }
            BaseLocalVideoLayer.this.f55133s = false;
            this.f55144c = false;
            this.f55145d = false;
            this.f55146e = false;
            BaseLocalVideoLayer.this.y0();
        }

        @Override // is.c.a
        public void onDoubleTap(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            View viewM0 = BaseLocalVideoLayer.this.M0();
            if (viewM0 == null || !viewM0.isSelected()) {
                BaseLocalVideoLayer.this.J1(e11, true);
            }
        }

        @Override // is.c.a
        public void onLongPress(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            View viewM0 = BaseLocalVideoLayer.this.M0();
            if (viewM0 == null || !viewM0.isSelected()) {
                BaseLocalVideoLayer.this.n2();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.tn.lib.view.p {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f55154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.FloatRef f55155c;

        public c(Ref.LongRef longRef, Ref.FloatRef floatRef) {
            this.f55154b = longRef;
            this.f55155c = floatRef;
        }

        @Override // com.tn.lib.view.p
        public void a(SecondariesSeekBar seekBar) {
            com.transsion.player.orplayer.f fVarG;
            Intrinsics.g(seekBar, "seekBar");
            uo.b.a aVar = uo.b.f78622a;
            String TAG = BaseLocalVideoLayer.this.X0();
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "onStopTrackingTouch targetProgress:" + this.f55154b.element + " ", false, 4, null);
            BaseLocalVideoLayer.this.f55133s = false;
            com.transsion.player.orplayer.f fVarG2 = BaseLocalVideoLayer.this.G();
            if (fVarG2 != null) {
                fVarG2.seekTo(this.f55154b.element);
            }
            com.transsion.player.orplayer.f fVarG3 = BaseLocalVideoLayer.this.G();
            if (fVarG3 != null && !fVarG3.isPlaying() && (fVarG = BaseLocalVideoLayer.this.G()) != null) {
                fVarG.play();
            }
            Fragment fragment = BaseLocalVideoLayer.this.f55126l;
            LocalVideoDetailFragment localVideoDetailFragment = fragment instanceof LocalVideoDetailFragment ? (LocalVideoDetailFragment) fragment : null;
            if (localVideoDetailFragment != null) {
                localVideoDetailFragment.D3(this.f55154b.element, this.f55155c.element);
            }
            BaseLocalVideoLayer.this.F = seekBar.getProgress();
            BaseLocalVideoLayer.this.E2(false, 0L);
            BaseLocalVideoLayer.this.f1(false);
        }

        @Override // com.tn.lib.view.p
        public void b(SecondariesSeekBar seekBar, long j11, boolean z11) {
            View viewR0;
            Intrinsics.g(seekBar, "seekBar");
            if (z11) {
                View viewR1 = BaseLocalVideoLayer.this.R0();
                if (viewR1 != null && so.c.i(viewR1) && (viewR0 = BaseLocalVideoLayer.this.R0()) != null) {
                    so.c.g(viewR0);
                }
                BaseLocalVideoLayer.this.f55133s = z11;
                BaseLocalVideoLayer.this.H0().removeCallbacks(BaseLocalVideoLayer.this.W);
                float f11 = j11 / 10000;
                if (BaseLocalVideoLayer.this.Y0() > 0) {
                    this.f55154b.element = (long) (BaseLocalVideoLayer.this.Y0() * f11);
                } else {
                    this.f55155c.element = f11;
                }
                BaseLocalVideoLayer.this.F = this.f55154b.element;
                BaseLocalVideoLayer.this.E2(true, this.f55154b.element);
            }
        }

        @Override // com.tn.lib.view.p
        public void c(SecondariesSeekBar seekBar) {
            Intrinsics.g(seekBar, "seekBar");
            uo.b.a aVar = uo.b.f78622a;
            String TAG = BaseLocalVideoLayer.this.X0();
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "onStartTrackingTouch ", false, 4, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements SystemTimeManager.a {
        public d() {
        }

        public static final void c(BaseLocalVideoLayer this$0) {
            Intrinsics.g(this$0, "this$0");
            this$0.F2();
        }

        @Override // com.transsion.postdetail.layer.SystemTimeManager.a
        public long a() {
            FragmentActivity activity = BaseLocalVideoLayer.this.f55126l.getActivity();
            if (activity == null) {
                return 30000L;
            }
            final BaseLocalVideoLayer baseLocalVideoLayer = BaseLocalVideoLayer.this;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.postdetail.layer.local.n
                @Override // java.lang.Runnable
                public final void run() {
                    BaseLocalVideoLayer.d.c(baseLocalVideoLayer);
                }
            });
            return 30000L;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55157a;

        public e(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55157a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55157a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f55157a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements yz.a {
        @Override // yz.a
        public void a(vz.a aVar) {
            LocalFloatManager localFloatManager = LocalFloatManager.f56167b;
            localFloatManager.j();
            localFloatManager.m(aVar);
        }

        @Override // yz.a
        public boolean b(vz.a aVar) {
            return LocalFloatManager.f56167b.l(aVar);
        }

        @Override // yz.a
        public void c(vz.a aVar) {
            LocalFloatManager.f56167b.k(aVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLocalVideoLayer(final Fragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
        this.f55125k = getClass().getSimpleName();
        this.f55126l = fragment;
        this.f55128n = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                Looper looperMyLooper = Looper.myLooper();
                Intrinsics.d(looperMyLooper);
                return new Handler(looperMyLooper);
            }
        });
        this.f55129o = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$loadingHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                Looper looperMyLooper = Looper.myLooper();
                Intrinsics.d(looperMyLooper);
                return new Handler(looperMyLooper);
            }
        });
        this.f55130p = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$errorHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                Looper looperMyLooper = Looper.myLooper();
                Intrinsics.d(looperMyLooper);
                return new Handler(looperMyLooper);
            }
        });
        this.f55139y = "";
        this.G = LazyKt__LazyJVMKt.b(new Function0<LocalVideoDetailViewModel>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LocalVideoDetailViewModel invoke() {
                FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
                Intrinsics.f(fragmentActivityRequireActivity, "fragment.requireActivity()");
                return (LocalVideoDetailViewModel) new v0(fragmentActivityRequireActivity, new v0.d()).a(LocalVideoDetailViewModel.class);
            }
        });
        this.H = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$downloadManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsnet.downloader.manager.a invoke() {
                return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
            }
        });
        this.J = "";
        this.K = "";
        this.L = "";
        this.R = 1;
        this.S = 8;
        this.T = 1;
        this.U = 1;
        this.V = LazyKt__LazyJVMKt.b(new Function0<is.c>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$gestureControl$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final is.c invoke() {
                return new is.c(fragment.requireContext(), this.A0());
            }
        });
        this.W = new Runnable() { // from class: com.transsion.postdetail.layer.local.f
            @Override // java.lang.Runnable
            public final void run() {
                BaseLocalVideoLayer.U1(this.f55241a);
            }
        };
        this.X = new String[]{InstructionFileId.DOT, "..", "..."};
        this.Z = new Runnable() { // from class: com.transsion.postdetail.layer.local.g
            @Override // java.lang.Runnable
            public final void run() {
                BaseLocalVideoLayer.z1(this.f55251a);
            }
        };
        this.f55123a0 = new Runnable() { // from class: com.transsion.postdetail.layer.local.h
            @Override // java.lang.Runnable
            public final void run() {
                BaseLocalVideoLayer.i2(this.f55254a);
            }
        };
    }

    private final Intent B0() {
        Intent intent = new Intent();
        intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "/video/detail");
        intent.putExtra("id", this.L);
        return intent;
    }

    private final vz.a F0() {
        DownloadBean downloadBean = this.I;
        vz.a aVar = null;
        if (downloadBean == null) {
            return null;
        }
        if (H() != null && G() != null) {
            uo.b.a aVar2 = uo.b.f78622a;
            aVar2.c("VideoFloat", "local--showFloat, name:" + downloadBean.getTotalTitleName(), true);
            ArrayList arrayList = new ArrayList();
            if (downloadBean.isSeries()) {
                List<DownloadBean> listF = Z0().h().f();
                if (listF == null) {
                    listF = new ArrayList<>();
                }
                Iterator<DownloadBean> it = listF.iterator();
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i12 = -1;
                        break;
                    }
                    if (Intrinsics.b(it.next().getResourceId(), downloadBean.getResourceId())) {
                        break;
                    }
                    i12++;
                }
                uo.b.f78622a.c("VideoFloat", "local--showFloat, 电视剧:" + i12, true);
                if (i12 >= 0) {
                    arrayList.addAll(listF);
                } else {
                    int size = listF.size();
                    int i13 = 0;
                    while (i11 < size && listF.get(i11).getEp() < downloadBean.getEp()) {
                        i13 = i11 + 1;
                        i11 = i13;
                    }
                    arrayList.addAll(listF);
                    if (listF.size() <= i13) {
                        arrayList.add(downloadBean);
                    } else {
                        arrayList.add(i13, downloadBean);
                    }
                }
            } else {
                aVar2.c("VideoFloat", "local--showFloat, 电影", true);
                arrayList.add(downloadBean);
            }
            LocalFloatManager.f56167b.p(arrayList);
            ORPlayerView oRPlayerViewH = H();
            Intrinsics.d(oRPlayerViewH);
            com.transsion.player.orplayer.f fVarG = G();
            Intrinsics.d(fVarG);
            ViewGroup viewGroupW2 = w2();
            Intrinsics.d(viewGroupW2);
            FloatPlayType floatPlayType = FloatPlayType.LOCAL;
            String subjectId = downloadBean.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            aVar = new vz.a(oRPlayerViewH, fVarG, viewGroupW2, floatPlayType, subjectId, downloadBean.getSe(), downloadBean.getEp(), "", "local_video_detail");
            aVar.D(downloadBean.getResourceId());
            aVar.G(Integer.valueOf(downloadBean.getSubjectType()));
            aVar.z(com.transsion.postdetail.util.l.b(this.I));
            aVar.x(downloadBean.getOps());
            aVar.B(downloadBean.getPostId());
            aVar.y(downloadBean.getPageFrom());
        }
        return aVar;
    }

    private final void G2(long j11) {
        SecondariesSeekBar secondariesSeekBarW1;
        VideoSubtitleControl videoSubtitleControl = this.f55136v;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.o0(j11);
        }
        if (this.f55127m <= 0) {
            com.transsion.player.orplayer.f fVarG = G();
            if (fVarG == null) {
                return;
            } else {
                this.f55127m = fVarG.getDuration();
            }
        }
        if (!this.f55133s) {
            long j12 = this.f55127m;
            if (j12 > 0) {
                long j13 = (int) ((j11 / j12) * 10000);
                if (j13 >= this.F && (secondariesSeekBarW1 = W1()) != null) {
                    secondariesSeekBarW1.setProgress(j13);
                }
            }
        }
        H2(j11, this.f55127m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler H0() {
        return (Handler) this.f55128n.getValue();
    }

    private final void I2() {
        String name;
        DownloadBean downloadBean;
        String subjectName;
        DownloadBean downloadBean2;
        String subjectName2;
        DownloadBean downloadBean3 = this.I;
        if (downloadBean3 == null || !downloadBean3.isSeries() || (downloadBean2 = this.I) == null || (subjectName2 = downloadBean2.getSubjectName()) == null || subjectName2.length() <= 0) {
            DownloadBean downloadBean4 = this.I;
            if (downloadBean4 == null || downloadBean4.getResolution() <= 0 || (downloadBean = this.I) == null || (subjectName = downloadBean.getSubjectName()) == null || subjectName.length() <= 0) {
                DownloadBean downloadBean5 = this.I;
                if (downloadBean5 == null || (name = downloadBean5.getName()) == null) {
                    name = "";
                }
            } else {
                DownloadBean downloadBean6 = this.I;
                Integer numValueOf = downloadBean6 != null ? Integer.valueOf(downloadBean6.getResolution()) : null;
                DownloadBean downloadBean7 = this.I;
                name = numValueOf + "P " + (downloadBean7 != null ? downloadBean7.getSubjectName() : null);
            }
        } else {
            DownloadBean downloadBean8 = this.I;
            String subjectName3 = downloadBean8 != null ? downloadBean8.getSubjectName() : null;
            DownloadBean downloadBean9 = this.I;
            name = subjectName3 + " " + (downloadBean9 != null ? DownloadBean.getEpTitleName$default(downloadBean9, false, 1, null) : null);
        }
        updateTitle(name);
    }

    private final Intent J0() {
        IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
        DownloadBean downloadBean = this.I;
        boolean zIsCompleted = downloadBean != null ? downloadBean.isCompleted() : false;
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb2.append("/video/detail");
        sb2.append("&");
        sb2.append("extra_resource_id");
        sb2.append("=");
        DownloadBean downloadBean2 = this.I;
        sb2.append(downloadBean2 != null ? downloadBean2.getResourceId() : null);
        sb2.append("&");
        sb2.append("extra_local_path");
        sb2.append("=");
        DownloadBean downloadBean3 = this.I;
        sb2.append(downloadBean3 != null ? downloadBean3.getPath() : null);
        sb2.append("&");
        sb2.append("extra_url");
        sb2.append("=");
        DownloadBean downloadBean4 = this.I;
        sb2.append(downloadBean4 != null ? downloadBean4.getUrl() : null);
        sb2.append("&");
        sb2.append("extra_page_from");
        sb2.append("=");
        sb2.append("media_notification");
        sb2.append("&");
        sb2.append("extra_completed");
        sb2.append("=");
        sb2.append(zIsCompleted);
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intentD1 = iPushProvider.d1(applicationA);
        intentD1.addFlags(603979776);
        intentD1.setData(Uri.parse(sb2.toString()));
        return intentD1;
    }

    public static /* synthetic */ void K1(BaseLocalVideoLayer baseLocalVideoLayer, MotionEvent motionEvent, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pause");
        }
        if ((i11 & 1) != 0) {
            motionEvent = null;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        baseLocalVideoLayer.J1(motionEvent, z11);
    }

    private final Handler L0() {
        return (Handler) this.f55129o.getValue();
    }

    private final MediaItem N0() {
        DownloadBean downloadBean = this.I;
        String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
        DownloadBean downloadBean2 = this.I;
        String subjectId = downloadBean2 != null ? downloadBean2.getSubjectId() : null;
        DownloadBean downloadBean3 = this.I;
        String cover = downloadBean3 != null ? downloadBean3.getCover() : null;
        DownloadBean downloadBean4 = this.I;
        String resourceId = downloadBean4 != null ? downloadBean4.getResourceId() : null;
        PendingIntent pendingIntentO0 = O0();
        Intent intentB0 = B0();
        DownloadBean downloadBean5 = this.I;
        boolean z11 = false;
        if (downloadBean5 != null && downloadBean5.getType() == 6) {
            z11 = true;
        }
        return new MediaItem(totalTitleName, "", cover, null, null, null, pendingIntentO0, intentB0, subjectId, resourceId, Boolean.valueOf(z11), null, null, null, 14392, null);
    }

    private final PendingIntent O0() {
        return PendingIntent.getActivity(Utils.a(), 0, J0(), Q0());
    }

    private final int Q0() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    public static final void U1(BaseLocalVideoLayer this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.h1();
    }

    public static /* synthetic */ void e2(BaseLocalVideoLayer baseLocalVideoLayer, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBottomController");
        }
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        baseLocalVideoLayer.d2(z11);
    }

    private final void f2(int i11) {
        com.transsion.player.orplayer.f fVarG;
        if (this.C == null) {
            ViewStub viewStubN2 = N2();
            this.C = viewStubN2 != null ? viewStubN2.inflate() : null;
        }
        View view = this.D;
        if (view != null) {
            so.c.g(view);
        }
        if (C2() == LocalUiType.MIDDLE) {
            a2(false);
        }
        if (isVisible() && (fVarG = G()) != null) {
            fVarG.pause();
        }
        View view2 = this.C;
        if (view2 != null) {
            so.c.k(view2);
        }
        View view3 = this.C;
        if (view3 != null) {
            view3.setTag(Integer.valueOf(i11));
        }
        View view4 = this.C;
        if (view4 != null) {
            ((TextView) view4.findViewById(R$id.tv_fail_left_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    BaseLocalVideoLayer.g2(this.f55230a, view5);
                }
            });
            ((TextView) view4.findViewById(R$id.tv_fail_right_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    BaseLocalVideoLayer.h2(this.f55239a, view5);
                }
            });
        }
    }

    public static final void g2(BaseLocalVideoLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.I1();
    }

    public static final void h2(BaseLocalVideoLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        uo.b.f78622a.t("long_video_play", "video error，reload~~ from errorLayout click", true);
        Fragment fragment = this$0.f55126l;
        LocalVideoDetailFragment localVideoDetailFragment = fragment instanceof LocalVideoDetailFragment ? (LocalVideoDetailFragment) fragment : null;
        if (localVideoDetailFragment != null) {
            localVideoDetailFragment.w3(true);
        }
    }

    public static final void i2(BaseLocalVideoLayer this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f55139y = "";
        this$0.f2(0);
        this$0.f55140z = true;
        this$0.f1(true);
        Group groupB2 = this$0.B2();
        if (groupB2 != null) {
            groupB2.setVisibility(0);
        }
        this$0.g1(true);
    }

    private final void j1() {
        View viewN0 = n0();
        if (viewN0 != null) {
            viewN0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLocalVideoLayer.k1(this.f55256a, view);
                }
            });
        }
        ImageView imageViewL1 = L1();
        if (imageViewL1 != null) {
            imageViewL1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLocalVideoLayer.l1(this.f55258a, view);
                }
            });
        }
        View viewV1 = V1();
        if (viewV1 != null) {
            viewV1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLocalVideoLayer.m1(this.f55260a, view);
                }
            });
        }
        ImageView imageViewZ0 = z0();
        if (imageViewZ0 != null) {
            imageViewZ0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLocalVideoLayer.n1(this.f55261a, view);
                }
            });
        }
        View viewO1 = O1();
        if (viewO1 != null) {
            viewO1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLocalVideoLayer.o1(this.f55262a, view);
                }
            });
        }
        View viewX1 = x1();
        if (viewX1 != null) {
            viewX1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLocalVideoLayer.p1(this.f55232a, view);
                }
            });
        }
        View viewU0 = U0();
        if (viewU0 != null) {
            viewU0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLocalVideoLayer.q1(this.f55234a, view);
                }
            });
        }
    }

    private final void j2() {
        wv.b bVar;
        View view = this.C;
        if (view == null || view.getVisibility() != 0) {
            if (C2() == LocalUiType.MIDDLE) {
                f1(true);
            } else {
                d2(false);
            }
            a2(false);
            f0 f0Var = this.f55138x;
            if (f0Var != null) {
                f0Var.d();
            }
            if (isVisible() && (bVar = this.f55135u) != null) {
                bVar.d(this.I);
            }
            if (this.D == null) {
                ViewStub viewStubO2 = O2();
                this.D = viewStubO2 != null ? viewStubO2.inflate() : null;
            }
            View view2 = this.D;
            if (view2 != null) {
                so.c.k(view2);
            }
            View view3 = this.D;
            if (view3 != null) {
                F1();
                ((TextView) view3.findViewById(R$id.tv_replay)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        BaseLocalVideoLayer.k2(this.f55237a, view4);
                    }
                });
            }
        }
    }

    public static final void k1(BaseLocalVideoLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.B1();
    }

    public static final void k2(BaseLocalVideoLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.K2();
    }

    public static final void l1(BaseLocalVideoLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Fragment fragment = this$0.f55126l;
        Intrinsics.e(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment");
        iv.c cVar = iv.c.f67718a;
        com.transsion.baselib.report.h logViewConfig = ((LocalVideoDetailFragment) fragment).getLogViewConfig();
        cVar.a(logViewConfig != null ? logViewConfig.f() : null, this$0.L, false);
        K1(this$0, null, false, 3, null);
    }

    public static final void m1(BaseLocalVideoLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.E1();
    }

    public static final void n1(BaseLocalVideoLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_PLAY").withString("subject_id", this$0.L);
        DownloadBean downloadBean = this$0.I;
        if (downloadBean != null && downloadBean.getType() == 3) {
            postcardWithString.withParcelable("TV_DATA", new FbTvData(this$0.L, downloadBean.getSe(), downloadBean.getEp()));
        }
        postcardWithString.navigation();
    }

    public static final void o1(BaseLocalVideoLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baselib.report.m.f51277a.m(this$0.J, "click", this$0.S0());
        this$0.P1();
    }

    public static final void p1(BaseLocalVideoLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.f(FloatActionType.ICON);
    }

    public static final void q1(BaseLocalVideoLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.E1();
    }

    private final void s1() {
        Ref.LongRef longRef = new Ref.LongRef();
        Ref.FloatRef floatRef = new Ref.FloatRef();
        SecondariesSeekBar secondariesSeekBarW1 = W1();
        if (secondariesSeekBarW1 != null) {
            secondariesSeekBarW1.setMax(10000L);
        }
        SecondariesSeekBar secondariesSeekBarW2 = W1();
        if (secondariesSeekBarW2 != null) {
            secondariesSeekBarW2.setOnSeekBarChangeListener(new c(longRef, floatRef));
        }
    }

    private final void y1() {
        L0().postDelayed(this.Z, 1000L);
    }

    public static final void z1(BaseLocalVideoLayer this$0) {
        Intrinsics.g(this$0, "this$0");
        int i11 = this$0.Y;
        boolean z11 = false;
        if (i11 >= 2) {
            this$0.Y = 0;
        } else {
            this$0.Y = i11 + 1;
        }
        TextView textViewU0 = this$0.u0();
        if (textViewU0 != null) {
            textViewU0.setText(Utils.a().getString(R$string.play_loading) + this$0.X[this$0.Y]);
        }
        if (this$0.I != null) {
            com.transsnet.downloader.manager.a aVarD0 = this$0.D0();
            DownloadBean downloadBean = this$0.I;
            Intrinsics.d(downloadBean);
            z11 = aVarD0.z(downloadBean);
        }
        if (this$0.f55139y.length() > 0 && !z11) {
            this$0.f55139y = "";
        }
        TextView textViewT0 = this$0.t0();
        if (textViewT0 != null) {
            String str = this$0.f55139y;
            textViewT0.setText(str.length() != 0 ? str : "");
        }
        this$0.y1();
    }

    @Override // wv.d
    public void A() {
        String playingUrl;
        wv.d.a.e(this);
        if (com.transsion.videofloat.a.f60027a.c(G())) {
            return;
        }
        if (com.transsion.videofloat.manager.v.f60111a.c(G())) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this.f55125k;
            Intrinsics.f(TAG, "TAG");
            aVar.c(TAG, "local 播放器在缓存中，这里不能release", true);
            return;
        }
        com.transsion.player.orplayer.f fVarG = G();
        if (fVarG != null) {
            DownloadBean downloadBean = this.I;
            fVarG.release((downloadBean == null || (playingUrl = downloadBean.getPlayingUrl()) == null) ? null : Integer.valueOf(playingUrl.hashCode()).toString());
        }
    }

    public abstract View A0();

    public final void A1(boolean z11) {
        ConstraintLayout constraintLayoutT1;
        ConstraintLayout constraintLayoutT2 = T1();
        if (constraintLayoutT2 != null) {
            constraintLayoutT2.setVisibility(z11 ? 0 : 8);
        }
        if (!z11 || (constraintLayoutT1 = T1()) == null) {
            return;
        }
        constraintLayoutT1.setFocusableInTouchMode(true);
        constraintLayoutT1.requestFocus();
    }

    public abstract TextView A2();

    @Override // wv.d
    public void B(VideoSubtitleControl control) {
        Intrinsics.g(control, "control");
        this.f55136v = control;
        control.Y(com.transsion.postdetail.util.l.c(C2()), t2(), x2(), v2(), p2(), true);
        control.h0(new Function1<Boolean, Unit>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$setSubtitleControl$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                ProgressBar progressBarR2 = this.this$0.r2();
                if (progressBarR2 != null) {
                    progressBarR2.setVisibility(z11 ? 0 : 8);
                }
                ImageView imageViewQ2 = this.this$0.q2();
                if (imageViewQ2 != null) {
                    imageViewQ2.setVisibility(z11 ^ true ? 0 : 8);
                }
                TextView textViewS2 = this.this$0.s2();
                if (textViewS2 == null) {
                    return;
                }
                textViewS2.setText(Utils.a().getString(z11 ? R$string.play_loading : R$string.turn_on_short));
            }
        });
        control.D(com.transsion.postdetail.util.l.c(C2()), new Function2<View, Boolean, Unit>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$setSubtitleControl$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Boolean bool) {
                invoke(view, bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(View switchView, boolean z11) {
                Intrinsics.g(switchView, "switchView");
                this.this$0.H1(switchView, z11);
            }
        }, new Function1<View, Unit>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$setSubtitleControl$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View settingView) {
                Intrinsics.g(settingView, "settingView");
                this.this$0.G1(settingView);
            }
        });
    }

    public abstract void B1();

    public abstract Group B2();

    @Override // wv.d
    public void C(int i11) {
        wv.d.a.m(this, i11);
    }

    public final DownloadBean C0() {
        return this.I;
    }

    public void C1(boolean z11) {
    }

    public abstract LocalUiType C2();

    @Override // wv.d
    public void D(DownloadBean downloadBean) {
        wv.d.a.c(this, downloadBean);
    }

    public final com.transsnet.downloader.manager.a D0() {
        return (com.transsnet.downloader.manager.a) this.H.getValue();
    }

    public final void D1(long j11) {
        List<DownloadBean> list;
        long j12 = this.f55127m;
        if (j12 <= 0 || j12 - j11 >= 5000) {
            return;
        }
        List<DownloadBean> listF = Z0().h().f();
        if (!this.M || (list = listF) == null || list.isEmpty() || this.O) {
            return;
        }
        this.O = true;
        int size = listF.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            DownloadBean downloadBean = listF.get(i11);
            String resourceId = downloadBean.getResourceId();
            DownloadBean downloadBean2 = this.I;
            if (Intrinsics.b(resourceId, downloadBean2 != null ? downloadBean2.getResourceId() : null)) {
                z11 = true;
            } else if (z11) {
                R1(downloadBean);
                return;
            }
        }
    }

    public void D2(boolean z11) {
        try {
            Result.Companion companion = Result.Companion;
            FragmentActivity activity = this.f55126l.getActivity();
            if (activity == null || activity.isDestroyed() || activity.isFinishing() || !RoomAppMMKV.f51271a.a().getBoolean("k_pip_enable", true)) {
                return;
            }
            VideoPipManager videoPipManagerA = VideoPipManager.f60024a.a();
            ORPlayerView oRPlayerViewH = H();
            ViewParent parent = oRPlayerViewH != null ? oRPlayerViewH.getParent() : null;
            Result.m163constructorimpl(videoPipManagerA.i(activity, false, z11, parent instanceof ViewGroup ? (ViewGroup) parent : null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final Handler E0() {
        return (Handler) this.f55130p.getValue();
    }

    public void E1() {
        FragmentActivity activity;
        int i11;
        com.transsion.player.orplayer.f fVarG;
        View view;
        com.transsion.player.orplayer.f fVarG2 = G();
        if (fVarG2 != null && !fVarG2.isPlaying() && (fVarG = G()) != null && !fVarG.isComplete() && !v1()) {
            com.transsion.player.orplayer.f fVarG3 = G();
            if (fVarG3 != null) {
                fVarG3.play();
            }
            View view2 = this.D;
            if (view2 != null && so.c.i(view2) && (view = this.D) != null) {
                so.c.g(view);
            }
        }
        com.transsion.player.orplayer.f fVarG4 = G();
        if (fVarG4 != null) {
            fVarG4.setScaleMode(LocalVideoPlayerConfigMmkv.f51172a.b());
        }
        int i12 = this.f55131q;
        LocalUiType localUiType = (i12 <= 0 || (i11 = this.f55132r) <= 0 || i11 <= i12) ? LocalUiType.LAND : LocalUiType.PORTRAIT;
        if (localUiType == LocalUiType.LAND && (activity = this.f55126l.getActivity()) != null) {
            activity.setRequestedOrientation(6);
        }
        com.transsion.videofloat.a.f60027a.a();
        E(LayerFlag.LOCAL_UI_CHANGED, localUiType);
    }

    public final void E2(boolean z11, long j11) {
        this.B = z11;
        View view = this.C;
        if (view == null || view.getVisibility() != 0) {
            if (!z11) {
                VideoSubtitleControl videoSubtitleControl = this.f55136v;
                if (videoSubtitleControl != null) {
                    videoSubtitleControl.S();
                }
                TextView textViewV0 = v0();
                if (textViewV0 != null) {
                    textViewV0.setVisibility(8);
                }
                View viewS0 = s0();
                if (viewS0 == null) {
                    return;
                }
                viewS0.setVisibility(this.A ? 0 : 8);
                return;
            }
            TextView textViewV1 = v0();
            if (textViewV1 != null) {
                textViewV1.setVisibility(0);
            }
            TextView textViewV2 = v0();
            if (textViewV2 != null) {
                FragmentActivity activity = this.f55126l.getActivity();
                textViewV2.setText(Html.fromHtml(activity != null ? activity.getString(R$string.post_progress_tx_style, com.transsion.postdetail.util.i.d(j11), com.transsion.postdetail.util.i.d(this.f55127m)) : null));
            }
            VideoSubtitleControl videoSubtitleControl2 = this.f55136v;
            if (videoSubtitleControl2 != null) {
                videoSubtitleControl2.o0(j11);
            }
            View viewS1 = s0();
            if (viewS1 == null) {
                return;
            }
            viewS1.setVisibility(8);
        }
    }

    public void F1() {
    }

    public final void F2() {
        TextView textViewN1 = N1();
        if (textViewN1 == null) {
            return;
        }
        textViewN1.setText(com.transsion.postdetail.util.l.d());
    }

    public final is.c G0() {
        return (is.c) this.V.getValue();
    }

    public void G1(View view) {
        Intrinsics.g(view, "view");
    }

    public void H1(View view, boolean z11) {
        Intrinsics.g(view, "view");
        d2(true);
        String string = Utils.a().getString(z11 ? com.transsion.subtitle.R$string.subtitle_turn_on_toast : com.transsion.subtitle.R$string.subtitle_turn_off_toast);
        Intrinsics.f(string, "getApp()\n               ….subtitle_turn_off_toast)");
        wv.d.a.k(this, string, 0L, 2, null);
    }

    public final void H2(long j11, long j12) {
        TextView textViewJ2 = J2();
        if (textViewJ2 != null) {
            textViewJ2.setText(com.transsion.postdetail.util.i.d(this.f55127m));
            TextView textViewM2 = M2();
            if (textViewM2 == null) {
                return;
            }
            textViewM2.setText(com.transsion.postdetail.util.i.d(j11));
            return;
        }
        String str = com.transsion.postdetail.util.i.d(j11) + "/" + com.transsion.postdetail.util.i.d(j12);
        TextView textViewM3 = M2();
        if (textViewM3 == null) {
            return;
        }
        textViewM3.setText(str);
    }

    public final int I0() {
        return this.f55132r;
    }

    public final void I1() {
        Utils.a().startActivity(new Intent("android.settings.WIFI_SETTINGS").setFlags(ASTNode.DEOP));
    }

    public final void J1(MotionEvent motionEvent, boolean z11) {
        com.transsion.baseui.util.c cVar = com.transsion.baseui.util.c.f51452a;
        ImageView imageViewL1 = L1();
        if (cVar.a(imageViewL1 != null ? imageViewL1.getId() : 9527, 500L)) {
            return;
        }
        View view = this.C;
        if (view != null && view.getVisibility() == 0) {
            View view2 = this.C;
            if (view2 == null || !Intrinsics.b(view2.getTag(), 1)) {
                if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    return;
                }
                com.tn.lib.widget.toast.core.h.f50034a.k(com.transsion.baseui.R$string.base_network_fail);
                return;
            } else {
                uo.b.f78622a.t("long_video_play", "video error，reload~~ from errorLayout", true);
                Fragment fragment = this.f55126l;
                LocalVideoDetailFragment localVideoDetailFragment = fragment instanceof LocalVideoDetailFragment ? (LocalVideoDetailFragment) fragment : null;
                if (localVideoDetailFragment != null) {
                    LocalVideoDetailFragment.x3(localVideoDetailFragment, false, 1, null);
                    return;
                }
                return;
            }
        }
        com.transsion.player.orplayer.f fVarG = G();
        if (fVarG != null && fVarG.isComplete()) {
            if (u1()) {
                return;
            }
            K2();
            return;
        }
        com.transsion.player.orplayer.f fVarG2 = G();
        if (fVarG2 != null && fVarG2.isPlaying()) {
            d1(motionEvent, z11);
            return;
        }
        O(false);
        a2(true);
        com.transsion.videofloat.a.f60027a.a();
        com.transsion.player.orplayer.f fVarG3 = G();
        if (fVarG3 != null) {
            fVarG3.play();
        }
    }

    public abstract TextView J2();

    public final wv.b K0() {
        return this.f55135u;
    }

    public void K2() {
        wv.b bVar = this.f55135u;
        if (bVar != null) {
            bVar.b(this.I);
        }
        View view = this.D;
        if (view != null) {
            so.c.g(view);
        }
        this.F = 0L;
        com.transsion.player.orplayer.f fVarG = G();
        if (fVarG != null) {
            fVarG.seekTo(0L);
        }
        com.transsion.player.orplayer.f fVarG2 = G();
        if (fVarG2 != null) {
            fVarG2.play();
        }
    }

    @Override // com.transsion.postdetail.layer.BaseLayer
    public void L(com.transsion.player.orplayer.f orPlayer, ORPlayerView orPlayerView) {
        Intrinsics.g(orPlayer, "orPlayer");
        Intrinsics.g(orPlayerView, "orPlayerView");
        super.L(orPlayer, orPlayerView);
        com.transsion.player.helper.g gVar = this.f55137w;
        if (gVar == null) {
            Intrinsics.y("volumeControl");
            gVar = null;
        }
        gVar.e(orPlayer);
    }

    public abstract ImageView L1();

    public abstract FrameLayout L2();

    public View M0() {
        return wv.d.a.a(this);
    }

    public abstract ViewGroup M1();

    public abstract TextView M2();

    public abstract TextView N1();

    public abstract ViewStub N2();

    public abstract View O1();

    public abstract ViewStub O2();

    public final String P0() {
        return this.J;
    }

    public final boolean P1() {
        if (this.P) {
            return true;
        }
        List<DownloadBean> listF = Z0().h().f();
        if (listF != null && this.M && (!listF.isEmpty())) {
            int size = listF.size();
            boolean z11 = false;
            for (int i11 = 0; i11 < size; i11++) {
                DownloadBean downloadBean = listF.get(i11);
                String resourceId = downloadBean.getResourceId();
                DownloadBean downloadBean2 = this.I;
                if (Intrinsics.b(resourceId, downloadBean2 != null ? downloadBean2.getResourceId() : null)) {
                    z11 = true;
                } else if (z11 && downloadBean.getCanPlay()) {
                    if (downloadBean.isCompleted() && !downloadBean.isFileExist()) {
                        return false;
                    }
                    X1(downloadBean, false);
                    return true;
                }
            }
        }
        return false;
    }

    public abstract View Q1();

    public final View R0() {
        return this.D;
    }

    public final void R1(DownloadBean downloadBean) {
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55125k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "onPlayProgress next tips name = " + downloadBean.getName() + ", epse = " + downloadBean.getEpse() + ", status = " + downloadBean.getStatus() + " ", false, 4, null);
        if (downloadBean.getCanPlay()) {
            DownloadBean downloadBean2 = this.I;
            if (downloadBean2 != null && downloadBean2.getStatus() == 5 && downloadBean.getStatus() != 5) {
                D0().j(downloadBean);
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String string = Utils.a().getString(R$string.series_next_play_tips);
            Intrinsics.f(string, "getApp().getString(R.string.series_next_play_tips)");
            Object[] objArr = new Object[2];
            String subjectName = downloadBean.getSubjectName();
            if (subjectName == null) {
                subjectName = "";
            }
            objArr[0] = subjectName;
            objArr[1] = downloadBean.getEp() > 0 ? com.transsion.baseui.util.l.b(downloadBean.getEp(), downloadBean.getSe(), true) : com.transsion.baseui.util.l.c(downloadBean.getEpse(), true);
            String str = String.format(string, Arrays.copyOf(objArr, 2));
            Intrinsics.f(str, "format(...)");
            j(str, 3000L);
        }
    }

    public final Map<String, String> S0() {
        return kotlin.collections.s.k(new Pair("module_name", "play_next"), new Pair("subject_id", this.L), new Pair("resource_id", this.K));
    }

    public final void S1(ORPlayerView oRPlayerView) {
        ViewParent parent = oRPlayerView.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).removeView(oRPlayerView);
        }
    }

    public final String T0() {
        return this.K;
    }

    public abstract ConstraintLayout T1();

    public abstract View U0();

    public final String V0() {
        return this.L;
    }

    public abstract View V1();

    public final SystemTimeManager W0() {
        return this.f55134t;
    }

    public abstract SecondariesSeekBar W1();

    public final String X0() {
        return this.f55125k;
    }

    public final void X1(DownloadBean nextVideoBean, boolean z11) {
        Intrinsics.g(nextVideoBean, "nextVideoBean");
        if (z11 && nextVideoBean.isCompleted() && !nextVideoBean.isFileExist()) {
            FragmentActivity activity = this.f55126l.getActivity();
            if (activity != null) {
                LocalVideoNotExistUtil.f61140a.n(activity, nextVideoBean, -1);
                return;
            }
            return;
        }
        View view = this.D;
        if (view != null) {
            so.c.g(view);
        }
        DownloadBean downloadBean = this.I;
        if (downloadBean != null) {
            downloadBean.setPlaying(false);
        }
        Z0().e().q(this.I);
        this.P = true;
        SecondariesSeekBar secondariesSeekBarW1 = W1();
        if (secondariesSeekBarW1 != null) {
            secondariesSeekBarW1.setProgress(0L);
        }
        G2(0L);
        if (isVisible()) {
            wv.c cVar = this.N;
            if (cVar != null) {
                cVar.a(nextVideoBean, !z11);
            }
            com.transsion.player.orplayer.f fVarG = G();
            if (fVarG != null) {
                fVarG.clearScreen();
            }
            com.transsion.player.orplayer.f fVarG2 = G();
            if (fVarG2 != null) {
                fVarG2.stop();
            }
            com.transsion.player.orplayer.f fVarG3 = G();
            if (fVarG3 != null) {
                fVarG3.reset();
            }
        }
        this.O = false;
        s();
        String postId = nextVideoBean.getPostId();
        if (postId == null) {
            postId = "";
        }
        N(postId);
        String subjectId = nextVideoBean.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        this.L = subjectId;
        this.I = nextVideoBean;
        nextVideoBean.setPlaying(true);
        l(new LinkedHashMap());
        boolean z12 = nextVideoBean.getStatus() != 5;
        com.transsion.player.orplayer.e.a.i(this, null, 1, null);
        if (isVisible()) {
            com.transsnet.downloader.util.e.f61155a.d("1");
            if (z12) {
                wv.c cVar2 = this.N;
                if (cVar2 != null) {
                    cVar2.b(nextVideoBean);
                    return;
                }
                return;
            }
            uo.b.f78622a.c("long_video_play", "series playerSetDataSource, subjectId = " + nextVideoBean.getSubjectId() + ",resourceId = " + nextVideoBean.getResourceId() + ", path = " + nextVideoBean.getPath(), true);
            com.transsion.player.orplayer.f fVarG4 = G();
            if (fVarG4 != null) {
                fVarG4.clearScreen();
            }
            com.transsion.player.orplayer.f fVarG5 = G();
            if (fVarG5 != null) {
                DownloadBean downloadBean2 = this.I;
                String resourceId = downloadBean2 != null ? downloadBean2.getResourceId() : null;
                String path = nextVideoBean.getPath();
                MediaSource mediaSource = new MediaSource(resourceId, path == null ? "" : path, 0, null, N0(), 12, null);
                MusicFloatManager.a aVar = MusicFloatManager.f51403i;
                aVar.b().A(mediaSource.e());
                aVar.b().z(mediaSource.h());
                fVarG5.setDataSource(mediaSource);
            }
            com.transsion.player.orplayer.f fVarG6 = G();
            if (fVarG6 != null) {
                fVarG6.prepare();
            }
        }
    }

    public final long Y0() {
        return this.f55127m;
    }

    public final void Y1(String str) {
        ImageView imageView;
        FrameLayout frameLayoutL2 = L2();
        if (frameLayoutL2 == null || (imageView = (ImageView) frameLayoutL2.findViewById(R$id.id_local_video_cover)) == null) {
            imageView = new ImageView(this.f55126l.requireContext());
            FrameLayout frameLayoutL3 = L2();
            if (frameLayoutL3 != null) {
                frameLayoutL3.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        J(imageView);
        ImageView imageViewF = F();
        if (imageViewF != null) {
            int iF = com.transsion.core.utils.e.f();
            ImageHelper.Companion companion = ImageHelper.f51371a;
            if (str == null) {
                str = "";
            }
            com.transsion.baseui.image.a.a(imageViewF).load(companion.e(str, (124 & 2) != 0 ? 0 : iF, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0)).into(imageViewF);
        }
    }

    public final LocalVideoDetailViewModel Z0() {
        return (LocalVideoDetailViewModel) this.G.getValue();
    }

    public final void Z1(int i11) {
        this.f55132r = i11;
    }

    @Override // wv.d
    public void a(LocalUiType uiType) {
        wv.b bVar;
        Intrinsics.g(uiType, "uiType");
        if (!isVisible() || (bVar = this.f55135u) == null) {
            return;
        }
        bVar.a(uiType);
    }

    public final int a1() {
        return this.f55131q;
    }

    public void a2(boolean z11) {
        C1(z11);
        ImageView imageViewL1 = L1();
        if (imageViewL1 != null) {
            imageViewL1.setTag(Boolean.valueOf(z11));
        }
        if (z11) {
            ImageView imageViewL2 = L1();
            if (imageViewL2 != null) {
                imageViewL2.setImageResource(R$mipmap.icon_player_pause);
                return;
            }
            return;
        }
        ImageView imageViewL3 = L1();
        if (imageViewL3 != null) {
            imageViewL3.setImageResource(R$mipmap.icon_player_play);
        }
    }

    @Override // wv.d
    public void b(boolean z11, boolean z12) {
        if (z11) {
            d2(z12);
        } else {
            f1(z12);
        }
    }

    public abstract View b1();

    public final void b2(String str) {
        Intrinsics.g(str, "<set-?>");
        this.L = str;
    }

    @Override // wv.d
    public void c() {
        DownloadBean downloadBean = this.I;
        if (downloadBean != null) {
            downloadBean.setPlaying(false);
        }
        SystemTimeManager systemTimeManager = this.f55134t;
        if (systemTimeManager != null) {
            systemTimeManager.c();
        }
        H0().removeCallbacksAndMessages(null);
        L0().removeCallbacksAndMessages(null);
        E0().removeCallbacksAndMessages(null);
        RoomActivityLifecycleCallbacks.f51239a.k(this);
    }

    public abstract View c1();

    public final void c2(int i11) {
        this.f55131q = i11;
    }

    @Override // wv.d
    public void d() {
        wv.d.a.i(this);
    }

    public void d1(MotionEvent motionEvent, boolean z11) {
        this.Q = false;
        O(true);
        a2(false);
        com.transsion.player.orplayer.f fVarG = G();
        if (fVarG != null) {
            fVarG.pause();
        }
        Fragment fragment = this.f55126l;
        LocalVideoDetailFragment localVideoDetailFragment = fragment instanceof LocalVideoDetailFragment ? (LocalVideoDetailFragment) fragment : null;
        if (localVideoDetailFragment != null) {
            localVideoDetailFragment.n3();
        }
        l2(false);
    }

    public void d2(boolean z11) {
        if (this.f55140z || this.Q || !com.blankj.utilcode.util.c.j()) {
            return;
        }
        View viewM0 = M0();
        if (viewM0 != null) {
            if (viewM0.isSelected()) {
                viewM0.setVisibility((viewM0.getVisibility() == 0) ^ true ? 0 : 8);
                return;
            }
            viewM0.setVisibility(0);
        }
        H0().removeCallbacks(this.W);
        if (z11) {
            f1(false);
        }
        ViewGroup viewGroupQ0 = q0();
        if (viewGroupQ0 != null) {
            viewGroupQ0.setVisibility(0);
        }
        Group groupB2 = B2();
        if (groupB2 != null) {
            groupB2.setVisibility(0);
        }
        ViewGroup viewGroupM1 = M1();
        if (viewGroupM1 != null) {
            viewGroupM1.setVisibility(0);
        }
        View viewC1 = c1();
        if (viewC1 != null) {
            viewC1.setVisibility(0);
        }
        View viewN0 = n0();
        if (viewN0 != null) {
            viewN0.setVisibility(0);
        }
        View viewB1 = b1();
        if (viewB1 != null) {
            viewB1.setVisibility(0);
        }
        ViewGroup viewGroupR0 = r0();
        if (viewGroupR0 != null) {
            viewGroupR0.setVisibility(0);
        }
        ConstraintLayout constraintLayoutT1 = T1();
        View viewFindViewById = constraintLayoutT1 != null ? constraintLayoutT1.findViewById(R.id.message) : null;
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    @Override // wv.d
    public void e(wv.b event) {
        Intrinsics.g(event, "event");
        this.f55135u = event;
    }

    public final boolean e1() {
        List<DownloadBean> listF = Z0().h().f();
        if (listF != null && this.M && (!listF.isEmpty())) {
            int size = listF.size();
            boolean z11 = false;
            for (int i11 = 0; i11 < size; i11++) {
                DownloadBean downloadBean = listF.get(i11);
                String resourceId = downloadBean.getResourceId();
                DownloadBean downloadBean2 = this.I;
                if (Intrinsics.b(resourceId, downloadBean2 != null ? downloadBean2.getResourceId() : null)) {
                    z11 = true;
                } else if (z11 && downloadBean.getCanPlay()) {
                    return !downloadBean.isCompleted() || downloadBean.isFileExist();
                }
            }
        }
        return false;
    }

    @Override // wv.d
    public boolean f(FloatActionType actionType) {
        FragmentActivity activity;
        Intrinsics.g(actionType, "actionType");
        DownloadBean downloadBean = this.I;
        if ((downloadBean == null || !downloadBean.isMusic()) && (activity = this.f55126l.getActivity()) != null && !activity.isDestroyed() && !activity.isFinishing()) {
            FloatActionType floatActionType = FloatActionType.ICON;
            if (actionType != floatActionType && !RoomAppMMKV.f51271a.a().getBoolean("k_pip_enable", true)) {
                uo.b.f78622a.c("VideoFloat", "local 设置页pip开关被关闭了", true);
                return false;
            }
            vz.a aVarF0 = F0();
            if (aVarF0 != null) {
                if (actionType != floatActionType && !aVarF0.e().isPlaying()) {
                    uo.b.f78622a.c("VideoFloat-pip", "local 视频暂停，无需触发画中画", true);
                    return false;
                }
                VideoPipManager.Companion companion = VideoPipManager.f60024a;
                if (companion.a().b()) {
                    f1(true);
                    uo.b.a.f(uo.b.f78622a, "VideoFloat-pip", "local 当前可用画中画，使用画中画播放", false, 4, null);
                    companion.a().j(activity, aVarF0, actionType, C2() == LocalUiType.LAND);
                    return true;
                }
                VideoFloatManager.f60019a.b().e(activity, aVarF0, actionType == floatActionType, C2() == LocalUiType.LAND, new Function1<Boolean, Unit>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$showFloat2Window$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(boolean z11) {
                        if (z11) {
                            wv.b bVarK0 = this.this$0.K0();
                            if (bVarK0 != null) {
                                bVarK0.c(this.this$0.C0());
                            }
                            FragmentActivity activity2 = this.this$0.f55126l.getActivity();
                            if (activity2 != null) {
                                activity2.finish();
                            }
                        }
                    }
                }, new f());
            }
        }
        return false;
    }

    public final void f1(boolean z11) {
        if (com.blankj.utilcode.util.c.j()) {
            if (z11) {
                h1();
                return;
            }
            com.transsion.player.orplayer.f fVarG = G();
            if (fVarG == null || !fVarG.isPlaying()) {
                return;
            }
            H0().removeCallbacks(this.W);
            H0().postDelayed(this.W, 3000L);
        }
    }

    @Override // wv.d
    public void g(boolean z11, String str) {
        wv.d.a.h(this, z11, str);
    }

    public final void g1(boolean z11) {
        if (!z11) {
            FrameLayout frameLayoutL2 = L2();
            if (frameLayoutL2 != null) {
                so.c.k(frameLayoutL2);
                return;
            }
            return;
        }
        SimpleSubtitleView simpleSubtitleViewU2 = u2();
        if (simpleSubtitleViewU2 != null) {
            so.c.h(simpleSubtitleViewU2);
        }
        FrameLayout frameLayoutL3 = L2();
        if (frameLayoutL3 != null) {
            so.c.g(frameLayoutL3);
        }
        l2(false);
    }

    @Override // wv.d
    public void h() {
        l2(false);
        f2(1);
        this.f55139y = "";
        this.f55140z = true;
        f1(true);
        Group groupB2 = B2();
        if (groupB2 != null) {
            groupB2.setVisibility(0);
        }
        g1(true);
    }

    public final void h1() {
        Group groupB2;
        ViewGroup viewGroupQ0;
        if (!p0() && (viewGroupQ0 = q0()) != null) {
            viewGroupQ0.setVisibility(8);
        }
        if (!this.f55140z && (groupB2 = B2()) != null) {
            groupB2.setVisibility(8);
        }
        View viewN0 = n0();
        if (viewN0 != null) {
            viewN0.setVisibility(8);
        }
        ViewGroup viewGroupR0 = r0();
        if (viewGroupR0 != null) {
            viewGroupR0.setVisibility(8);
        }
        ViewGroup viewGroupM1 = M1();
        if (viewGroupM1 != null) {
            viewGroupM1.setVisibility(8);
        }
        View viewC1 = c1();
        if (viewC1 != null) {
            viewC1.setVisibility(8);
        }
        View viewB1 = b1();
        if (viewB1 != null) {
            viewB1.setVisibility(8);
        }
        View viewM0 = M0();
        if (viewM0 == null) {
            return;
        }
        viewM0.setVisibility(8);
    }

    @Override // wv.d
    public void i(String subjectId, String resourceId) {
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(resourceId, "resourceId");
        this.L = subjectId;
        this.M = true;
        FragmentActivity activity = this.f55126l.getActivity();
        if (activity != null) {
            Z0().h().j(activity, new e(new Function1<List<? extends DownloadBean>, Unit>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$initSeries$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends DownloadBean> list) {
                    invoke2(list);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends DownloadBean> list) {
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    uo.b.a aVar = uo.b.f78622a;
                    String TAG = this.this$0.X0();
                    Intrinsics.f(TAG, "TAG");
                    uo.b.a.f(aVar, TAG, "2--fragment, on get series from local, size = " + list.size() + ", uiType = " + this.this$0.C2(), false, 4, null);
                    this.this$0.w0();
                }
            }));
        }
    }

    public final void i1() {
        com.transsion.player.helper.g.a aVar = com.transsion.player.helper.g.f54361a;
        Context contextRequireContext = this.f55126l.requireContext();
        Intrinsics.f(contextRequireContext, "fragment.requireContext()");
        com.transsion.player.helper.g gVarA = aVar.a(contextRequireContext, T1());
        this.f55137w = gVarA;
        if (gVarA == null) {
            Intrinsics.y("volumeControl");
            gVarA = null;
        }
        gVarA.g();
        boolean zF = so.c.f();
        int iC = com.blankj.utilcode.util.d0.c();
        int iE = com.blankj.utilcode.util.d0.e();
        int i11 = a.f55141a[C2().ordinal()];
        if (i11 != 1) {
            if (i11 == 3) {
            }
            G0().s(new b(zF, iC, iE));
        }
        iC = (iE * 9) / 16;
        iE = iC;
        iC = iE;
        G0().s(new b(zF, iC, iE));
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.f fVarG;
        com.transsion.player.orplayer.e.a.a(this);
        View view = this.D;
        if (view != null) {
            so.c.g(view);
        }
        if (this.f55127m > 0 || (fVarG = G()) == null) {
            return;
        }
        long duration = fVarG.getDuration();
        this.f55127m = duration;
        if (duration > 0) {
            H2(0L, duration);
        }
    }

    @Override // wv.d
    public boolean isVisible() {
        ConstraintLayout constraintLayoutT1 = T1();
        return constraintLayoutT1 != null && constraintLayoutT1.getVisibility() == 0;
    }

    @Override // wv.d
    public void j(String content, long j11) {
        Intrinsics.g(content, "content");
        f0 f0Var = this.f55138x;
        if (f0Var != null) {
            f0Var.h(content, j11);
        }
    }

    @Override // wv.d
    public void k(DownloadBean downloadBean, String pageFrom, boolean z11) {
        Long duration;
        Long duration2;
        Intrinsics.g(pageFrom, "pageFrom");
        this.I = downloadBean;
        Z0().d().q(downloadBean);
        this.J = pageFrom;
        if (((downloadBean == null || (duration2 = downloadBean.getDuration()) == null) ? 0L : duration2.longValue()) > 30000) {
            H2(0L, (downloadBean == null || (duration = downloadBean.getDuration()) == null) ? 0L : duration.longValue());
        }
        View viewX1 = x1();
        if (viewX1 != null) {
            viewX1.setVisibility(w1() ? 0 : 8);
        }
        if (downloadBean != null) {
            downloadBean.setPlaying(true);
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55125k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "updateInfo,name = " + (downloadBean != null ? downloadBean.getName() : null) + ", epse = " + (downloadBean != null ? Integer.valueOf(downloadBean.getEpse()) : null), false, 4, null);
        I2();
    }

    @Override // wv.d
    public void l(Map<Integer, Integer> progress) {
        Intrinsics.g(progress, "progress");
        SecondariesSeekBar secondariesSeekBarW1 = W1();
        if (secondariesSeekBarW1 != null) {
            secondariesSeekBarW1.setSecondariesProgress(progress);
        }
    }

    public void l2(boolean z11) {
        View viewS0;
        if (this.A == z11) {
            return;
        }
        this.A = z11;
        if (z11) {
            if (!this.B && (viewS0 = s0()) != null) {
                viewS0.setVisibility(0);
            }
            m2();
            return;
        }
        o2();
        View viewS1 = s0();
        if (viewS1 == null) {
            return;
        }
        viewS1.setVisibility(8);
    }

    @Override // wv.d
    public void m(LocalUiType localUiType) {
        wv.d.a.f(this, localUiType);
    }

    public final void m0() {
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55125k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "addLandSurface 宽:" + this.f55131q + ",高:" + this.f55132r, false, 4, null);
        ORPlayerView oRPlayerViewH = H();
        if (oRPlayerViewH != null) {
            S1(oRPlayerViewH);
        }
        FrameLayout frameLayoutL2 = L2();
        if (frameLayoutL2 != null) {
            frameLayoutL2.addView(H(), 0, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void m2() {
        o2();
        L0().post(this.Z);
    }

    @Override // wv.d
    public void n() {
        com.transsion.player.orplayer.f fVarG = G();
        if (fVarG != null) {
            fVarG.pause();
        }
    }

    public abstract View n0();

    public final void n2() {
        com.transsion.player.orplayer.f fVarG = G();
        if (fVarG == null || fVarG.isPlaying()) {
            this.f55124b0 = SystemClock.elapsedRealtime();
            this.E = LocalVideoPlayerConfigMmkv.f51172a.c();
            com.transsion.player.orplayer.f fVarG2 = G();
            if (fVarG2 != null) {
                fVarG2.setSpeed(this.E * 2.0f);
            }
            h1();
            f1(true);
            View viewQ1 = Q1();
            if (viewQ1 != null) {
                so.c.k(viewQ1);
            }
            com.transsion.baselib.utils.k.a(this.J, this.L, Float.valueOf(this.E));
        }
    }

    @Override // wv.d
    public void o(float f11) {
        wv.d.a.n(this, f11);
        VideoSubtitleControl videoSubtitleControl = this.f55136v;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.p0(f11);
        }
    }

    public void o0(Subject subject) {
    }

    public final void o2() {
        L0().removeCallbacks(this.Z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.b(this, mediaSource);
    }

    @Override // com.transsion.baselib.report.RoomActivityLifecycleCallbacks.a
    public void onBackgroundStatusChange(boolean z11) {
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.d(this, mediaSource);
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55125k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "onCompletion, uiType = " + C2(), false, 4, null);
        if (u1()) {
            a2(false);
        } else {
            x0();
        }
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
        this.f55140z = false;
        l2(true);
        View view = this.C;
        if (view != null) {
            so.c.g(view);
        }
        g1(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        l2(false);
        E0().removeCallbacksAndMessages(null);
        this.f55140z = false;
        View view = this.C;
        if (view != null) {
            so.c.g(view);
        }
        g1(false);
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
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Intrinsics.g(errorInfo, "errorInfo");
        this.F = 0L;
        Integer errorCode = errorInfo.getErrorCode();
        if (errorCode != null && errorCode.intValue() == 537067524) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this.f55125k;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "--onPlayError，net time out ,", false, 4, null);
            if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                h();
            } else {
                E0().postDelayed(this.f55123a0, 500L);
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.s(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55125k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "onPlayerReset", false, 4, null);
        this.f55140z = false;
        this.f55127m = 0L;
        this.F = 0L;
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.v(this, mediaSource);
        this.F = 0L;
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        ImageView imageViewL1;
        G2(j11);
        if (C2() == LocalUiType.MIDDLE && (imageViewL1 = L1()) != null && Intrinsics.b(imageViewL1.getTag(), Boolean.FALSE)) {
            a2(true);
        }
        if (this.A) {
            l2(false);
        }
        D1(j11);
        VideoSubtitleControl videoSubtitleControl = this.f55136v;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.Q(j11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        ImageView imageViewL1;
        com.transsion.player.orplayer.e.a.z(this);
        if (C2() == LocalUiType.MIDDLE && (imageViewL1 = L1()) != null && Intrinsics.b(imageViewL1.getTag(), Boolean.FALSE)) {
            a2(true);
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
        D2(false);
        a2(false);
        if (!v1()) {
            e2(this, false, 1, null);
        }
        VideoSubtitleControl videoSubtitleControl = this.f55136v;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.P();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
        if ((i11 <= 0 || this.f55131q == i11) && (i12 <= 0 || this.f55132r == i12)) {
            return;
        }
        this.f55132r = i12;
        this.f55131q = i11;
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        D2(true);
        a2(true);
        f1(false);
        VideoSubtitleControl videoSubtitleControl = this.f55136v;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.R();
        }
        l2(false);
        this.P = false;
        View view = this.D;
        if (view != null) {
            so.c.g(view);
        }
        w0();
    }

    @Override // wv.d
    public void onViewPause() {
        wv.d.a.g(this);
    }

    @Override // wv.d
    public void onViewResume() {
        com.transsion.player.orplayer.f fVarG;
        if (I() || !com.tn.lib.util.networkinfo.f.f49475a.e() || com.transsion.videofloat.a.f60027a.d() || v1() || (fVarG = G()) == null) {
            return;
        }
        fVarG.play();
    }

    @Override // wv.d
    public void p(String resourceId, String subjectId, String postId, boolean z11, boolean z12) {
        Intrinsics.g(resourceId, "resourceId");
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(postId, "postId");
        this.K = resourceId;
        this.L = subjectId;
        N(postId);
        FragmentActivity activity = this.f55126l.getActivity();
        if (activity != null) {
            Z0().f().j(activity, new e(new Function1<Subject, Unit>() { // from class: com.transsion.postdetail.layer.local.BaseLocalVideoLayer$initData$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Subject subject) {
                    invoke2(subject);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Subject subject) {
                    this.this$0.o0(subject);
                }
            }));
        }
    }

    public abstract boolean p0();

    public abstract ViewGroup p2();

    @Override // wv.d
    public void q(int i11, int i12) {
        this.f55132r = i12;
        this.f55131q = i11;
    }

    public abstract ViewGroup q0();

    public abstract ImageView q2();

    @Override // wv.d
    public void r(View rootView, LocalUiType uiType) {
        Intrinsics.g(rootView, "rootView");
        Intrinsics.g(uiType, "uiType");
        this.M = false;
        this.O = false;
        A1(false);
        RoomActivityLifecycleCallbacks.f51239a.b(this);
        View viewS0 = s0();
        if (viewS0 != null) {
            viewS0.setVisibility(8);
        }
        j1();
        s1();
        t1();
        r1();
        i1();
    }

    public abstract ViewGroup r0();

    public final void r1() {
        this.f55138x = new f0(z2(), A2());
    }

    public abstract ProgressBar r2();

    @Override // wv.d
    public void s() {
        f0 f0Var = this.f55138x;
        if (f0Var != null) {
            f0Var.d();
        }
    }

    public abstract View s0();

    public abstract TextView s2();

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }

    @Override // wv.d
    public void t(boolean z11) {
        FragmentActivity activity;
        vz.a aVarF0;
        wv.d.a.d(this, z11);
        if (!z11 || (activity = this.f55126l.getActivity()) == null || activity.isDestroyed() || activity.isFinishing() || (aVarF0 = F0()) == null || Build.VERSION.SDK_INT < 31) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "VideoFloat-pip", "onPictureInPictureModeChanged local--- updateData", false, 4, null);
        VideoPipManager.f60024a.a().c(activity, aVarF0);
    }

    public abstract TextView t0();

    public final void t1() {
        this.f55134t = new SystemTimeManager(new d());
    }

    public abstract TextView t2();

    @Override // wv.d
    public void u(String str, String str2) {
        wv.d.a.j(this, str, str2);
    }

    public abstract TextView u0();

    public boolean u1() {
        return false;
    }

    public abstract SimpleSubtitleView u2();

    @Override // wv.d
    public void updateTitle(String title) {
        Intrinsics.g(title, "title");
        TextView textViewY2 = y2();
        if (textViewY2 == null) {
            return;
        }
        textViewY2.setText(title);
    }

    @Override // wv.d
    public void v(boolean z11) {
        com.transsion.player.orplayer.f fVarG;
        if (!z11) {
            E0().postDelayed(this.f55123a0, 1000L);
            return;
        }
        g1(false);
        this.f55140z = false;
        View view = this.C;
        if (view != null && view.getVisibility() == 0 && !I() && (fVarG = G()) != null) {
            fVarG.play();
        }
        View view2 = this.C;
        if (view2 != null) {
            so.c.g(view2);
        }
    }

    public abstract TextView v0();

    public final boolean v1() {
        Fragment fragment = this.f55126l;
        Intrinsics.e(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment");
        return ((LocalVideoDetailFragment) fragment).h3();
    }

    public abstract SimpleSubtitleView v2();

    @Override // wv.d
    public void w(PostSubjectItem postSubjectItem) {
        wv.d.a.l(this, postSubjectItem);
    }

    public final void w0() {
        ViewGroup viewGroupQ0;
        boolean zE1 = e1();
        View viewO1 = O1();
        if (viewO1 != null) {
            viewO1.setVisibility(zE1 ? 0 : 8);
        }
        if (zE1 && (viewGroupQ0 = q0()) != null && viewGroupQ0.getVisibility() == 0) {
            com.transsion.baselib.report.m.f51277a.t(this.J, "browse", S0());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("vis = ");
        sb2.append(zE1);
    }

    public final boolean w1() {
        Function0<Boolean> function0G;
        DownloadBean downloadBean = this.I;
        return (downloadBean == null || !downloadBean.isMusic()) && (function0G = TnPlayerManager.f54684a.g()) != null && function0G.invoke().booleanValue();
    }

    public abstract ViewGroup w2();

    @Override // wv.d
    public void x(wv.c event) {
        Intrinsics.g(event, "event");
        this.N = event;
    }

    public final void x0() {
        if (P1()) {
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55125k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "onCompletion, showReplay", false, 4, null);
        j2();
    }

    public abstract View x1();

    public abstract SimpleSubtitleView x2();

    @Override // wv.d
    public void y(String speed) {
        Intrinsics.g(speed, "speed");
        this.f55139y = speed;
    }

    public final void y0() {
        if (this.E > 0.0f) {
            com.transsion.player.orplayer.f fVarG = G();
            if (fVarG != null) {
                fVarG.setSpeed(this.E);
            }
            View viewQ1 = Q1();
            if (viewQ1 != null) {
                so.c.g(viewQ1);
            }
            com.transsion.baselib.utils.k.b(this.J, SystemClock.elapsedRealtime() - this.f55124b0, this.L, Float.valueOf(this.E));
            this.E = 0.0f;
        }
    }

    public abstract TextView y2();

    @Override // wv.d
    public void z(View view, boolean z11) {
        wv.d.a.b(this, view, z11);
    }

    public abstract ImageView z0();

    public abstract TextView z2();
}
