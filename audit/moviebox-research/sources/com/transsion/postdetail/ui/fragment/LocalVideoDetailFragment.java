package com.transsion.postdetail.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv;
import com.transsion.baselib.helper.ScreenRotationHelper;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.utils.PlayMode;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.music.MusicFloatManager;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.player.MediaSource;
import com.transsion.player.config.RenderType;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$array;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.layer.local.LocalUiType;
import com.transsion.postdetail.layer.local.LocalVideoLandLayer;
import com.transsion.postdetail.layer.local.LocalVideoMiddleLayer;
import com.transsion.postdetail.util.LocalFloatManager;
import com.transsion.postdetail.util.LocalVideoAdHelper;
import com.transsion.push.api.IPushProvider;
import com.transsion.push.bean.MsgStyle;
import com.transsion.quickjs.QuickJSHelper;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.subtitle.VideoSubtitleManager;
import com.transsion.videofloat.VideoFloatManager;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
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
public final class LocalVideoDetailFragment extends PageStatusFragment<tv.j> implements com.transsion.player.orplayer.e, RoomActivityLifecycleCallbacks.a {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final a f55662w0 = new a(null);
    public DownloadBean B;
    public final Lazy E;
    public long F;
    public float G;
    public long H;
    public int I;
    public int J;
    public int K;
    public int L;
    public List<vx.a> M;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public boolean Q;
    public boolean R;
    public long S;
    public boolean T;
    public boolean U;
    public boolean V;
    public AtomicInteger W;
    public VideoSubtitleControl X;
    public final int Y;
    public final Lazy Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public LocalUiType f55663a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f55664b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public LocalVideoAdHelper f55665c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public PlayError f55666d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f55667e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f55668f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final Lazy f55669g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final Handler f55670h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public String f55671i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final Lazy f55672j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Lazy f55674k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.transsion.player.orplayer.f f55675l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f55676l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ORPlayerView f55677m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public long f55678m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.transsion.postdetail.layer.local.o f55679n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public long f55680n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public long f55682o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final int f55684p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final Lazy f55686q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final LocalVideoDetailFragment$playerListener$1 f55688r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final Runnable f55690s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final b f55692t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final Runnable f55694u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public LocalUiType f55696v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f55697w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f55698x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f55699y;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f55673k = "LocalVideoDetail";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f55681o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f55683p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f55685q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f55687r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f55689s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f55691t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f55693u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f55695v = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f55700z = true;
    public boolean A = true;
    public final Lazy C = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$handler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            Looper looperMyLooper = Looper.myLooper();
            Intrinsics.d(looperMyLooper);
            return new Handler(looperMyLooper);
        }
    });
    public final Handler D = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalVideoDetailFragment a(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, String str8, Integer num, Integer num2, Integer num3, Integer num4) {
            LocalVideoDetailFragment localVideoDetailFragment = new LocalVideoDetailFragment();
            localVideoDetailFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_local_path", str), TuplesKt.a("extra_url", str2), TuplesKt.a("extra_proxy_url", str7), TuplesKt.a("extra_name", str3), TuplesKt.a("extra_resource_id", str4), TuplesKt.a("extra_subject_id", str6), TuplesKt.a("extra_post_id", str5), TuplesKt.a("extra_completed", bool), TuplesKt.a("extra_is_series", bool2), TuplesKt.a("extra_page_from", str8), TuplesKt.a("extra_height", num), TuplesKt.a("extra_width", num2), TuplesKt.a("extra_parent_position", num3), TuplesKt.a("extra_position", num4)));
            return localVideoDetailFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends g00.d {
        public b() {
        }

        @Override // g00.d
        public void h(DownloadBean bean, int i11) {
            com.transsion.postdetail.layer.local.o oVar;
            Intrinsics.g(bean, "bean");
            LocalVideoDetailFragment.this.D2().h(LayerFlag.DOWNLOAD_CALLBACK, bean);
            if (Intrinsics.b(LocalVideoDetailFragment.this.f55687r, bean.getResourceId())) {
                if (bean.getStatus() == 6 && (oVar = LocalVideoDetailFragment.this.f55679n) != null) {
                    DownloadException exception = bean.getException();
                    oVar.G(1, exception != null ? exception.getMessage() : null);
                }
                if (bean.getSize() != null) {
                    Long size = bean.getSize();
                    if ((size != null ? size.longValue() : 0L) <= 0) {
                        return;
                    }
                    LocalVideoDetailFragment.this.B = bean;
                    if (bean.getStatus() == 2 || bean.getStatus() == 5) {
                        LocalVideoDetailFragment.this.m3(bean);
                        com.transsion.postdetail.layer.a aVarD2 = LocalVideoDetailFragment.this.D2();
                        LayerFlag layerFlag = LayerFlag.DOWNLOAD_SPEED;
                        Object[] objArr = new Object[1];
                        objArr[0] = bean.getStatus() == 5 ? "" : com.transsion.baseui.util.i.f51464a.a(bean.getProgress());
                        aVarD2.h(layerFlag, objArr);
                        LocalVideoDetailFragment.this.F3(bean, false);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements wv.b {
        public c() {
        }

        @Override // wv.b
        public void a(LocalUiType uiType) {
            Intrinsics.g(uiType, "uiType");
            LocalVideoDetailFragment.this.H3(uiType);
            VideoSubtitleControl videoSubtitleControl = LocalVideoDetailFragment.this.X;
            if (videoSubtitleControl != null) {
                videoSubtitleControl.N(com.transsion.postdetail.util.l.c(uiType));
            }
            LocalVideoDetailFragment.this.L3(uiType);
            LocalVideoDetailFragment.this.f55665c0.j0(uiType, LocalVideoDetailFragment.this.f55675l);
            com.transsion.postdetail.layer.local.o oVar = LocalVideoDetailFragment.this.f55679n;
            if (oVar != null) {
                oVar.k(uiType);
            }
        }

        @Override // wv.b
        public void b(DownloadBean downloadBean) {
            com.transsion.postdetail.layer.local.o oVar = LocalVideoDetailFragment.this.f55679n;
            if (oVar != null) {
                oVar.o();
            }
            com.transsion.postdetail.layer.local.o oVar2 = LocalVideoDetailFragment.this.f55679n;
            if (oVar2 != null) {
                oVar2.g();
            }
            com.transsion.postdetail.layer.local.o oVar3 = LocalVideoDetailFragment.this.f55679n;
            if (oVar3 != null) {
                oVar3.a();
            }
            com.transsion.postdetail.layer.local.o oVar4 = LocalVideoDetailFragment.this.f55679n;
            if (oVar4 != null) {
                oVar4.n();
            }
        }

        @Override // wv.b
        public void c(DownloadBean downloadBean) {
            LocalVideoDetailFragment.this.f55668f0 = true;
        }

        @Override // wv.b
        public void d(DownloadBean downloadBean) {
            LocalVideoDetailFragment.this.K3();
            com.transsion.postdetail.layer.local.o oVar = LocalVideoDetailFragment.this.f55679n;
            if (oVar != null) {
                com.transsion.postdetail.layer.local.o.c(oVar, false, 1, null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements wv.c {
        public d() {
        }

        public static final void d(LocalVideoDetailFragment this$0) {
            Intrinsics.g(this$0, "this$0");
            if (this$0.f55698x) {
                return;
            }
            uo.b.a.f(uo.b.f78622a, this$0.f55673k, "2------ playNextVideo, postDelayed start video", false, 4, null);
            this$0.w2();
        }

        @Override // wv.c
        public void a(DownloadBean bean, boolean z11) {
            Intrinsics.g(bean, "bean");
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.s(aVar, "LocalVideoMiddle", "onNext", false, 4, null);
            LocalVideoDetailFragment localVideoDetailFragment = LocalVideoDetailFragment.this;
            localVideoDetailFragment.A3(localVideoDetailFragment.B, LocalVideoDetailFragment.this.F, z11);
            LocalVideoDetailFragment.this.z2().G();
            LocalVideoDetailFragment.this.z2().o();
            LocalVideoDetailFragment.this.K3();
            com.transsion.postdetail.layer.local.o oVar = LocalVideoDetailFragment.this.f55679n;
            if (oVar != null) {
                com.transsion.postdetail.layer.local.o.c(oVar, false, 1, null);
            }
            com.transsion.postdetail.layer.local.o oVar2 = LocalVideoDetailFragment.this.f55679n;
            if (oVar2 != null) {
                oVar2.g();
            }
            com.transsion.postdetail.layer.local.o oVar3 = LocalVideoDetailFragment.this.f55679n;
            if (oVar3 != null) {
                oVar3.a();
            }
            LocalVideoDetailFragment.this.T = false;
            LocalVideoDetailFragment.this.Q = false;
            LocalVideoDetailFragment localVideoDetailFragment2 = LocalVideoDetailFragment.this;
            String name = bean.getName();
            if (name == null) {
                name = "";
            }
            localVideoDetailFragment2.f55689s = name;
            LocalVideoDetailFragment localVideoDetailFragment3 = LocalVideoDetailFragment.this;
            String postId = bean.getPostId();
            if (postId == null) {
                postId = "";
            }
            localVideoDetailFragment3.f55691t = postId;
            LocalVideoDetailFragment localVideoDetailFragment4 = LocalVideoDetailFragment.this;
            String subjectId = bean.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            localVideoDetailFragment4.f55693u = subjectId;
            LocalVideoDetailFragment.this.f55700z = bean.getStatus() == 5;
            LocalVideoDetailFragment localVideoDetailFragment5 = LocalVideoDetailFragment.this;
            localVideoDetailFragment5.f55697w = true ^ localVideoDetailFragment5.f55700z;
            LocalVideoDetailFragment localVideoDetailFragment6 = LocalVideoDetailFragment.this;
            String resourceId = bean.getResourceId();
            if (resourceId == null) {
                resourceId = "";
            }
            localVideoDetailFragment6.f55687r = resourceId;
            LocalVideoDetailFragment.this.f55683p = bean.getUrl();
            LocalVideoDetailFragment localVideoDetailFragment7 = LocalVideoDetailFragment.this;
            String path = bean.getPath();
            localVideoDetailFragment7.f55681o = path != null ? path : "";
            if (LocalVideoDetailFragment.this.f55697w) {
                LocalVideoDetailFragment.this.z2().j(bean);
                LocalVideoDetailFragment localVideoDetailFragment8 = LocalVideoDetailFragment.this;
                localVideoDetailFragment8.f55685q = localVideoDetailFragment8.z2().h(bean);
            }
            LocalVideoDetailFragment.this.B = bean;
            LocalVideoDetailFragment.this.a3();
            LocalVideoDetailFragment.this.M.clear();
            VideoSubtitleControl videoSubtitleControl = LocalVideoDetailFragment.this.X;
            if (videoSubtitleControl != null) {
                videoSubtitleControl.W();
            }
            LocalVideoDetailFragment.this.W2(false);
            uo.b.a.f(aVar, LocalVideoDetailFragment.this.f55673k, "playNextVideo, episode = :" + bean.getEpse() + "， isDownloadingPlay = " + LocalVideoDetailFragment.this.f55697w, false, 4, null);
            LocalVideoDetailFragment.this.F = 0L;
            LocalVideoDetailFragment.this.f55699y = false;
            LocalVideoDetailFragment.this.G = 0.0f;
        }

        @Override // wv.c
        public void b(DownloadBean bean) {
            Intrinsics.g(bean, "bean");
            LocalVideoDetailFragment.this.f55698x = false;
            Handler handler = LocalVideoDetailFragment.this.D;
            final LocalVideoDetailFragment localVideoDetailFragment = LocalVideoDetailFragment.this;
            handler.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.o
                @Override // java.lang.Runnable
                public final void run() {
                    LocalVideoDetailFragment.d.d(localVideoDetailFragment);
                }
            }, 5000L);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements xx.a {
        public e() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends androidx.activity.p {
        public f() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            uo.b.a.f(uo.b.f78622a, LocalVideoDetailFragment.this.f55673k, "----------handleOnBackPressed", false, 4, null);
            LocalVideoDetailFragment.this.D2().h(LayerFlag.BACK_PRESSED, new Object[0]);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55706a;

        public g(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55706a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55706a;
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
            this.f55706a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h implements com.transsion.quickjs.a {
        public h() {
        }

        @Override // com.transsion.quickjs.a
        public void a(String str, int i11) {
            uo.b.f78622a.c(LocalVideoDetailFragment.this.f55673k, "quickjs onWatch failed: " + str, true);
        }

        @Override // com.transsion.quickjs.a
        public void onSuccess(Object obj) {
            uo.b.a.f(uo.b.f78622a, LocalVideoDetailFragment.this.f55673k, "quickjs onWatch success", false, 4, null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$playerListener$1] */
    public LocalVideoDetailFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.E = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new Function0<com.transsion.postdetail.layer.a>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$layerManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsion.postdetail.layer.a invoke() {
                return new com.transsion.postdetail.layer.a();
            }
        });
        this.K = -1;
        this.L = -1;
        this.M = new ArrayList();
        this.N = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$videoDetailPlayDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoDetailPlayDao invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).O0();
            }
        });
        this.O = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$downloadManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsnet.downloader.manager.a invoke() {
                return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
            }
        });
        this.P = LazyKt__LazyJVMKt.b(new Function0<ScreenRotationHelper>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$screenHelper$2

            /* JADX INFO: renamed from: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$screenHelper$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Boolean> {
                public AnonymousClass1(Object obj) {
                    super(0, obj, LocalVideoDetailFragment.class, "isCloseAutoRotation", "isCloseAutoRotation()Z", 0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(((LocalVideoDetailFragment) this.receiver).i3());
                }
            }

            /* JADX INFO: renamed from: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$screenHelper$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
                public AnonymousClass2(Object obj) {
                    super(1, obj, LocalVideoDetailFragment.class, "autoScreenRotation", "autoScreenRotation(Z)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    ((LocalVideoDetailFragment) this.receiver).r2(z11);
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ScreenRotationHelper invoke() {
                Context contextRequireContext = this.this$0.requireContext();
                Intrinsics.f(contextRequireContext, "requireContext()");
                return new ScreenRotationHelper(contextRequireContext, new AnonymousClass1(this.this$0), new AnonymousClass2(this.this$0));
            }
        });
        this.W = new AtomicInteger(0);
        this.Y = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        this.Z = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new Function0<IAudioApi>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$audioApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IAudioApi invoke() {
                return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
            }
        });
        this.f55665c0 = new LocalVideoAdHelper();
        this.f55667e0 = true;
        this.f55669g0 = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.postdetail.ui.dialog.j.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final androidx.lifecycle.x0 invoke() {
                androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$special$$inlined$activityViewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final androidx.lifecycle.v0.c invoke() {
                androidx.lifecycle.v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f55670h0 = new Handler(Looper.getMainLooper());
        this.f55672j0 = LazyKt__LazyJVMKt.b(new Function0<Long>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$playTimeout$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                Long lN;
                ConfigBean configBeanB = ConfigManager.f53111c.a().b("sb_lv_play_timeout", true);
                String value = configBeanB != null ? configBeanB.getValue() : null;
                long jLongValue = 8000;
                if (value != null && value.length() != 0 && (lN = kotlin.text.k.n(value)) != null) {
                    jLongValue = lN.longValue();
                }
                return Long.valueOf(jLongValue);
            }
        });
        this.f55674k0 = LazyKt__LazyJVMKt.b(new Function0<Long>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$playTimeoutDp$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                Long lN;
                ConfigBean configBeanB = ConfigManager.f53111c.a().b("sb_lv_play_timeout_dp", true);
                String value = configBeanB != null ? configBeanB.getValue() : null;
                long jLongValue = 12000;
                if (value != null && value.length() != 0 && (lN = kotlin.text.k.n(value)) != null) {
                    jLongValue = lN.longValue();
                }
                return Long.valueOf(jLongValue);
            }
        });
        this.f55684p0 = com.blankj.utilcode.util.d.c();
        this.f55686q0 = LazyKt__LazyJVMKt.b(new Function0<com.transsion.postdetail.util.j>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$orientationEventListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsion.postdetail.util.j invoke() {
                FragmentActivity activity = this.this$0.getActivity();
                if (activity == null) {
                    return null;
                }
                final LocalVideoDetailFragment localVideoDetailFragment = this.this$0;
                return new com.transsion.postdetail.util.j(activity, new Function1<Integer, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$orientationEventListener$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(int i11) {
                        if (i11 == 1 || i11 == 3) {
                            localVideoDetailFragment.D2().h(LayerFlag.UPDATE_ROTATION, Integer.valueOf(i11));
                        }
                    }
                });
            }
        });
        this.f55688r0 = new com.transsion.player.orplayer.e() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$playerListener$1
            @Override // com.transsion.player.orplayer.e
            public void initPlayer() {
                com.transsion.player.orplayer.e.a.a(this);
            }

            @Override // com.transsion.player.orplayer.e
            public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
                com.transsion.postdetail.layer.local.o oVar = this.f55710a.f55679n;
                if (oVar == null) {
                    return;
                }
                oVar.y(true);
            }

            @Override // com.transsion.player.orplayer.e
            public void onBufferedPosition(long j11, MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onCompletion(MediaSource mediaSource) {
                com.transsion.postdetail.layer.local.o oVar = this.f55710a.f55679n;
                if (oVar != null) {
                    oVar.h();
                }
                uo.b.a.f(uo.b.f78622a, this.f55710a.f55673k, "onCompletion", false, 4, null);
                this.f55710a.o3();
                this.f55710a.f55678m0 = 0L;
                this.f55710a.f55680n0 = 0L;
                this.f55710a.f55665c0.h0();
            }

            @Override // com.transsion.player.orplayer.e
            public void onFocusChange(boolean z11) {
                com.transsion.player.orplayer.e.a.f(this, z11);
            }

            @Override // com.transsion.player.orplayer.e
            public void onIsPlayingChanged(boolean z11) {
                uo.b.a.f(uo.b.f78622a, this.f55710a.f55673k, "onIsPlayingChanged：" + z11, false, 4, null);
                VideoSubtitleControl videoSubtitleControl = this.f55710a.X;
                if (videoSubtitleControl == null) {
                    return;
                }
                videoSubtitleControl.a0(z11);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingBegin(MediaSource mediaSource) {
                com.transsion.postdetail.layer.local.o oVar = this.f55710a.f55679n;
                if (oVar != null) {
                    oVar.i();
                }
                uo.b.a.f(uo.b.f78622a, this.f55710a.f55673k, "onLoadingBegin", false, 4, null);
                this.f55710a.D2().g(LayerFlag.LOADING_BEGIN, Boolean.FALSE);
                if (this.f55710a.f55697w) {
                    this.f55710a.u2();
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingEnd(MediaSource mediaSource) {
                com.transsion.postdetail.layer.local.o oVar = this.f55710a.f55679n;
                if (oVar != null) {
                    oVar.j();
                }
                uo.b.a.f(uo.b.f78622a, this.f55710a.f55673k, "onLoadingEnd", false, 4, null);
                this.f55710a.B2().removeCallbacksAndMessages(null);
                this.f55710a.D2().g(LayerFlag.LOADING_END, Boolean.FALSE);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.l(this, i11, f11, mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoopingStart() {
                uo.b.a.f(uo.b.f78622a, this.f55710a.f55673k, "onLoopingStart", false, 4, null);
                this.f55710a.D2().g(LayerFlag.LOOPING_START, new Object[0]);
            }

            @Override // com.transsion.player.orplayer.e
            public void onMediaItemTransition(String str) {
                com.transsion.player.orplayer.e.a.o(this, str);
            }

            @Override // com.transsion.player.orplayer.e
            public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
                Intrinsics.g(errorInfo, "errorInfo");
                this.f55710a.z3();
                this.f55710a.f55666d0 = errorInfo;
                com.transsion.postdetail.layer.local.o oVar = this.f55710a.f55679n;
                if (oVar != null) {
                    oVar.l(errorInfo);
                }
                uo.b.a aVar = uo.b.f78622a;
                aVar.h("long_video_play", "onPlayError()  errorCode:" + errorInfo.getErrorCode() + " errorMessage:" + errorInfo.getErrorMessage() + "  playProgress = " + this.f55710a.F + " url:" + (mediaSource != null ? mediaSource.j() : null) + " --> 长播放失败了", true);
                this.f55710a.D2().g(LayerFlag.PLAY_ERROR, errorInfo);
                LocalVideoDetailFragment localVideoDetailFragment = this.f55710a;
                Integer errorCode = errorInfo.getErrorCode();
                localVideoDetailFragment.R = errorCode != null && errorCode.intValue() == 537067524;
                if (this.f55710a.F > 0) {
                    LocalVideoDetailFragment localVideoDetailFragment2 = this.f55710a;
                    LocalVideoDetailFragment.B3(localVideoDetailFragment2, localVideoDetailFragment2.B, this.f55710a.F, false, 4, null);
                }
                if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    if (this.f55710a.R) {
                        return;
                    }
                    aVar.t("long_video_play", "video error，reload~~ from onPlayError", true);
                    LocalVideoDetailFragment.x3(this.f55710a, false, 1, null);
                    return;
                }
                uo.b.a.f(aVar, this.f55710a.f55673k, "onPlayError， not net----", false, 4, null);
                DownloadBean downloadBean = this.f55710a.B;
                if ((downloadBean != null ? downloadBean.getProgress() : 0L) > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                    this.f55710a.D2().g(LayerFlag.LOADING_END, new Object[0]);
                    this.f55710a.D2().h(LayerFlag.NETWORK_CHANGE, Boolean.FALSE);
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onPlayerRelease(MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.s(this, mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onPlayerReset() {
                uo.b.a.f(uo.b.f78622a, this.f55710a.f55673k, "onPlayerReset", false, 4, null);
                this.f55710a.D2().g(LayerFlag.PLAYER_RESET, new Object[0]);
                this.f55710a.f55665c0.i0();
            }

            @Override // com.transsion.player.orplayer.e
            public void onPrepare(MediaSource mediaSource) {
                this.f55710a.z3();
                this.f55710a.R = false;
                this.f55710a.f55699y = true;
                uo.b.a aVar = uo.b.f78622a;
                String str = this.f55710a.f55673k;
                DownloadBean downloadBean = this.f55710a.B;
                uo.b.a.f(aVar, str, "onPrepare, epse = " + (downloadBean != null ? Integer.valueOf(downloadBean.getEpse()) : null), false, 4, null);
                if (this.f55710a.B == null) {
                    kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this.f55710a), kotlinx.coroutines.w0.b(), null, new LocalVideoDetailFragment$playerListener$1$onPrepare$1(this.f55710a, null), 2, null);
                } else {
                    kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this.f55710a), kotlinx.coroutines.w0.c(), null, new LocalVideoDetailFragment$playerListener$1$onPrepare$2(this.f55710a, null), 2, null);
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onProgress(long j11, MediaSource mediaSource) {
                com.transsion.postdetail.layer.local.o oVar = this.f55710a.f55679n;
                if (oVar != null) {
                    oVar.m(j11);
                }
                this.f55710a.F = j11;
                this.f55710a.D2().g(LayerFlag.PROGRESS, Long.valueOf(j11));
                this.f55710a.s2(j11);
            }

            @Override // com.transsion.player.orplayer.e
            public void onRenderFirstFrame() {
                com.transsion.postdetail.layer.local.o oVar = this.f55710a.f55679n;
                if (oVar != null) {
                    oVar.n();
                }
                uo.b.a.f(uo.b.f78622a, this.f55710a.f55673k, "onRenderFirstFrame", false, 4, null);
                this.f55710a.D2().g(LayerFlag.RENDER_FIRST_FRAME, new Object[0]);
            }

            @Override // com.transsion.player.orplayer.e
            public void onSetDataSource() {
                com.transsion.player.orplayer.e.a.A(this);
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksAudioBitrateChange(int i11) {
                com.transsion.player.orplayer.e.a.B(this, i11);
                com.transsion.postdetail.layer.local.o oVar = this.f55710a.f55679n;
                if (oVar != null) {
                    oVar.t(i11);
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksChange(ov.c cVar) {
                com.transsion.player.orplayer.e.a.C(this, cVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksVideoBitrateChange(int i11) {
                com.transsion.player.orplayer.e.a.D(this, i11);
                com.transsion.postdetail.layer.local.o oVar = this.f55710a.f55679n;
                if (oVar != null) {
                    oVar.u(i11);
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoPause(MediaSource mediaSource) {
                this.f55710a.I3(true);
                com.transsion.postdetail.layer.local.o oVar = this.f55710a.f55679n;
                if (oVar != null) {
                    oVar.v();
                }
                uo.b.a.f(uo.b.f78622a, this.f55710a.f55673k, "onVideoPause", false, 4, null);
                FragmentActivity activity = this.f55710a.getActivity();
                if (activity != null) {
                    com.transsion.postdetail.util.k.f56221a.b(activity, false);
                }
                this.f55710a.D2().g(LayerFlag.VIDEO_PAUSE, new Object[0]);
                this.f55710a.f55678m0 += (System.currentTimeMillis() - this.f55710a.f55680n0) / ((long) 1000);
                this.f55710a.f55680n0 = System.currentTimeMillis();
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoSizeChanged(int i11, int i12) {
                this.f55710a.I = i11;
                this.f55710a.J = i12;
                uo.b.a aVar = uo.b.f78622a;
                uo.b.a.f(aVar, this.f55710a.f55673k, "onVideoSizeChanged", false, 4, null);
                uo.b.a.f(aVar, this.f55710a.f55673k, "onVideoSizeChanged width:" + i11 + ",height:" + i12, false, 4, null);
                this.f55710a.D2().g(LayerFlag.VIDEO_SIZE_CHANGED, Integer.valueOf(i11), Integer.valueOf(i12));
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoStart(MediaSource mediaSource) {
                this.f55710a.z3();
                this.f55710a.I3(false);
                com.transsion.postdetail.layer.local.o oVar = this.f55710a.f55679n;
                if (oVar != null) {
                    oVar.w();
                }
                uo.b.a.f(uo.b.f78622a, this.f55710a.f55673k, "onVideoStart", false, 4, null);
                this.f55710a.D.removeCallbacks(this.f55710a.f55694u0);
                this.f55710a.D2().g(LayerFlag.VIDEO_START, new Object[0]);
                this.f55710a.D2().g(LayerFlag.LOADING_END, new Object[0]);
                this.f55710a.x2().pause();
                this.f55710a.M3();
                this.f55710a.f55680n0 = System.currentTimeMillis();
                this.f55710a.f55665c0.l0();
            }

            @Override // com.transsion.player.orplayer.e
            public void setOnSeekCompleteListener() {
                com.transsion.player.orplayer.e.a.J(this);
            }
        };
        this.f55690s0 = new Runnable() { // from class: com.transsion.postdetail.ui.fragment.h
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoDetailFragment.r3(this.f55886a);
            }
        };
        this.f55692t0 = new b();
        this.f55694u0 = new Runnable() { // from class: com.transsion.postdetail.ui.fragment.i
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoDetailFragment.l3(this.f55889a);
            }
        };
        this.f55696v0 = LocalUiType.MIDDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler B2() {
        return (Handler) this.C.getValue();
    }

    public static /* synthetic */ void B3(LocalVideoDetailFragment localVideoDetailFragment, DownloadBean downloadBean, long j11, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        localVideoDetailFragment.A3(downloadBean, j11, z11);
    }

    private final Intent C2(String str) {
        IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
        DownloadBean downloadBean = this.B;
        boolean zIsCompleted = downloadBean != null ? downloadBean.isCompleted() : false;
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb2.append("/video/detail");
        sb2.append("&");
        sb2.append("extra_resource_id");
        sb2.append("=");
        DownloadBean downloadBean2 = this.B;
        sb2.append(downloadBean2 != null ? downloadBean2.getResourceId() : null);
        sb2.append("&");
        sb2.append("extra_local_path");
        sb2.append("=");
        DownloadBean downloadBean3 = this.B;
        sb2.append(downloadBean3 != null ? downloadBean3.getPath() : null);
        sb2.append("&");
        sb2.append("extra_url");
        sb2.append("=");
        DownloadBean downloadBean4 = this.B;
        sb2.append(downloadBean4 != null ? downloadBean4.getUrl() : null);
        sb2.append("&");
        sb2.append("extra_page_from");
        sb2.append("=");
        sb2.append(str);
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

    private final MediaItem E2() {
        DownloadBean downloadBean = this.B;
        String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
        String str = this.f55693u;
        DownloadBean downloadBean2 = this.B;
        String cover = downloadBean2 != null ? downloadBean2.getCover() : null;
        String strR = MusicFloatManager.f51403i.b().r(this.f55693u);
        PendingIntent pendingIntentF2 = F2();
        Intent intentY2 = y2();
        DownloadBean downloadBean3 = this.B;
        boolean z11 = downloadBean3 != null && downloadBean3.getType() == 6;
        DownloadBean downloadBean4 = this.B;
        return new MediaItem(totalTitleName, "", cover, null, null, null, pendingIntentF2, intentY2, str, strR, Boolean.valueOf(z11), "local_detail", null, downloadBean4 != null ? downloadBean4.getOps() : null, 4152, null);
    }

    private final PendingIntent F2() {
        return PendingIntent.getActivity(Utils.a(), 0, C2("media_notification"), H2());
    }

    public static final void G3(LocalVideoDetailFragment this$0, Map progressList) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(progressList, "$progressList");
        this$0.D2().h(LayerFlag.DOWNLOAD_PROGRESS, progressList);
    }

    private final int H2() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    private final void P2() {
        AppCompatImageView appCompatImageView;
        LocalVideoAdHelper localVideoAdHelper = this.f55665c0;
        tv.j mViewBinding = getMViewBinding();
        DownloadBean downloadBean = this.B;
        localVideoAdHelper.W(mViewBinding, downloadBean != null ? downloadBean.getGenre() : null, new Function1<Boolean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$initAd$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                com.transsion.player.orplayer.f fVar;
                com.transsion.player.orplayer.f fVar2;
                this.this$0.f55676l0 = z11;
                if (!z11 || (fVar = this.this$0.f55675l) == null || !fVar.isPlaying() || (fVar2 = this.this$0.f55675l) == null) {
                    return;
                }
                fVar2.pause();
            }
        });
        tv.j mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (appCompatImageView = mViewBinding2.f77806o) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoDetailFragment.Q2(this.f55896a, view);
            }
        });
    }

    public static final void Q2(LocalVideoDetailFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        LocalUiType localUiType = this$0.f55663a0;
        LocalUiType localUiType2 = LocalUiType.LAND;
        if (localUiType == localUiType2) {
            localUiType2 = LocalUiType.MIDDLE;
        }
        this$0.D2().h(LayerFlag.SCREEN_ORIENTATION_CHANGED, localUiType2);
    }

    private final void R2() {
        RoomActivityLifecycleCallbacks.f51239a.b(this);
    }

    private final void T2() {
        x2().addPlayerListener(this);
        x2().pause();
    }

    private final void U2() {
        S2();
        V2();
        c3();
        W2(true);
        g3();
        T2();
        d3(this.B);
        X2();
        P2();
        e3();
        MediaItem mediaItemO = MusicFloatManager.f51403i.b().o();
        if (mediaItemO == null) {
            return;
        }
        mediaItemO.setPageName("local_detail");
    }

    public static final void Y2(LocalVideoDetailFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f55698x) {
            return;
        }
        this$0.w2();
    }

    private final void e3() {
        ConstraintLayout constraintLayoutB;
        tv.j mViewBinding = getMViewBinding();
        if (mViewBinding == null || (constraintLayoutB = mViewBinding.getRoot()) == null) {
            return;
        }
        constraintLayoutB.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.j
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoDetailFragment.f3(this.f55892a);
            }
        });
    }

    public static final void f3(LocalVideoDetailFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            VideoFloatManager.f60019a.b().b(activity, this$0.f55693u, "local_video_detail");
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initView() {
        tv.y yVar;
        tv.w wVar;
        tv.a0 a0Var;
        tv.j mViewBinding = getMViewBinding();
        ConstraintLayout constraintLayout = null;
        ConstraintLayout constraintLayoutB = mViewBinding != null ? mViewBinding.getRoot() : null;
        if (constraintLayoutB != null) {
            constraintLayoutB.setKeepScreenOn(true);
        }
        tv.j mViewBinding2 = getMViewBinding();
        ConstraintLayout constraintLayout2 = (mViewBinding2 == null || (a0Var = mViewBinding2.f77805n) == null) ? null : a0Var.f77672j;
        if (constraintLayout2 != null) {
            D2().h(LayerFlag.INIT_VIEW_TYPE, constraintLayout2, LocalUiType.PORTRAIT);
        }
        tv.j mViewBinding3 = getMViewBinding();
        ConstraintLayout constraintLayout3 = (mViewBinding3 == null || (wVar = mViewBinding3.f77803l) == null) ? null : wVar.f77992m;
        if (constraintLayout3 != null) {
            D2().h(LayerFlag.INIT_VIEW_TYPE, constraintLayout3, LocalUiType.LAND);
        }
        tv.j mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (yVar = mViewBinding4.f77804m) != null) {
            constraintLayout = yVar.f78029s;
        }
        if (constraintLayout != null) {
            D2().h(LayerFlag.INIT_VIEW_TYPE, constraintLayout, LocalUiType.MIDDLE);
        }
        L3(LocalUiType.PORTRAIT);
        R2();
        Context context = getContext();
        if (context == null || com.transsion.baseui.util.b.a(context)) {
            return;
        }
        K2().g();
    }

    public static final void l3(LocalVideoDetailFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, this$0.f55673k, "---------no net， show error", false, 4, null);
        this$0.D2().h(LayerFlag.NETWORK_CHANGE, Boolean.FALSE);
    }

    public static final void r3(LocalVideoDetailFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        String str = this$0.f55671i0;
        if (str != null) {
            com.transsion.player.orplayer.f fVar = this$0.f55675l;
            if (fVar != null) {
                fVar.reset();
            }
            com.transsion.player.orplayer.f fVar2 = this$0.f55675l;
            if (fVar2 != null) {
                fVar2.stop();
            }
            com.transsion.postdetail.layer.local.o oVar = this$0.f55679n;
            if (oVar != null) {
                oVar.L(true);
            }
            String strValueOf = String.valueOf(str.hashCode());
            uo.b.f78622a.c("long_video_play", "playerTimeout,change 2 software decoder, id:" + strValueOf + ", path = " + str, true);
            com.transsion.player.orplayer.f fVar3 = this$0.f55675l;
            if (fVar3 != null) {
                fVar3.enableHardwareDecoder(false);
            }
            com.transsion.player.orplayer.f fVar4 = this$0.f55675l;
            if (fVar4 != null) {
                MediaSource mediaSource = new MediaSource(strValueOf, str, 0, null, this$0.E2(), 12, null);
                MusicFloatManager.a aVar = MusicFloatManager.f51403i;
                aVar.b().A(mediaSource.e());
                aVar.b().z(mediaSource.h());
                fVar4.setDataSource(mediaSource);
            }
            com.transsion.player.orplayer.f fVar5 = this$0.f55675l;
            if (fVar5 != null) {
                fVar5.prepare();
            }
        }
    }

    public static final void v2(LocalVideoDetailFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.D2().h(LayerFlag.SHOW_TOAST, Utils.a().getString(R$string.downloading_play_wait_msg));
    }

    public static /* synthetic */ void x3(LocalVideoDetailFragment localVideoDetailFragment, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        localVideoDetailFragment.w3(z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.a z2() {
        return (com.transsnet.downloader.manager.a) this.O.getValue();
    }

    public final List<DubsInfo> A2() {
        DownloadBean downloadBean = this.B;
        String currentDubLanName = downloadBean != null ? downloadBean.getCurrentDubLanName() : null;
        if (currentDubLanName == null || currentDubLanName.length() == 0) {
            return kotlin.collections.g.l();
        }
        String str = this.f55693u;
        DownloadBean downloadBean2 = this.B;
        String currentDubLanName2 = downloadBean2 != null ? downloadBean2.getCurrentDubLanName() : null;
        DownloadBean downloadBean3 = this.B;
        DubsInfo dubsInfo = new DubsInfo(str, currentDubLanName2, downloadBean3 != null ? downloadBean3.getCurrentDubLanCode() : null, false, 8, null);
        dubsInfo.setSelected(true);
        return kotlin.collections.f.e(dubsInfo);
    }

    public final void A3(DownloadBean downloadBean, long j11, boolean z11) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.b()), null, null, new LocalVideoDetailFragment$save$1(z11, this, j11, downloadBean, null), 3, null);
    }

    public final Object C3(DownloadBean downloadBean, Continuation<? super Unit> continuation) {
        String subjectId = downloadBean.getSubjectId();
        String str = subjectId == null ? "" : subjectId;
        String resourceId = downloadBean.getResourceId();
        String str2 = resourceId == null ? "" : resourceId;
        int ep2 = downloadBean.getEp();
        int se2 = downloadBean.getSe();
        long readProgress = downloadBean.getReadProgress();
        Long duration = downloadBean.getDuration();
        String subjectName = downloadBean.getSubjectName();
        if (subjectName == null) {
            subjectName = downloadBean.getFileName();
        }
        String str3 = subjectName;
        String url = downloadBean.getUrl();
        long lastPlayTimeStamp = downloadBean.getLastPlayTimeStamp();
        String cover = downloadBean.getCover();
        String thumbnail = downloadBean.getThumbnail();
        String averageHueLight = downloadBean.getAverageHueLight();
        Integer subjectDurationSeconds = downloadBean.getSubjectDurationSeconds();
        Long lE = subjectDurationSeconds != null ? Boxing.e(subjectDurationSeconds.intValue()) : null;
        int subjectType = downloadBean.getSubjectType();
        String value = PlayMode.DOWNLOAD.getValue();
        String url2 = downloadBean.getUrl();
        String path = downloadBean.getPath();
        Long size = downloadBean.getSize();
        Object objQ = M2().q(new VideoDetailPlayBean(str, str2, ep2, se2, readProgress, str3, cover, thumbnail, url, lastPlayTimeStamp, null, duration, lE, averageHueLight, Boxing.d(subjectType), false, value, url2, path, size != null ? size.longValue() : 0L, null, null, null, false, false, false, 66061312, null), continuation);
        return objQ == kotlin.coroutines.intrinsics.a.e() ? objQ : Unit.f68710a;
    }

    public final com.transsion.postdetail.layer.a D2() {
        return (com.transsion.postdetail.layer.a) this.E.getValue();
    }

    public final void D3(long j11, float f11) {
        com.transsion.postdetail.layer.local.o oVar = this.f55679n;
        if (oVar != null) {
            oVar.p();
        }
        if (!this.f55699y) {
            this.G = f11;
        }
        this.F = j11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final void E3(DownloadBean downloadBean) {
        QuickJSHelper.ExecuteBuilder executeBuilderM = new QuickJSHelper.ExecuteBuilder().l("watch_info").m("onWatch");
        String strJ = com.blankj.utilcode.util.n.j(downloadBean);
        Intrinsics.f(strJ, "toJson(bean)");
        executeBuilderM.i(strJ).j(new h()).n();
    }

    public final void F3(DownloadBean downloadBean, boolean z11) {
        int iLongValue;
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j11 = this.H;
        long j12 = 10000;
        long j13 = 0;
        int i11 = j11 > 0 ? (int) ((this.F / j11) * 10000) : 0;
        boolean z12 = false;
        boolean z13 = false;
        for (DownloadRange downloadRange : downloadBean.getDownloadRanges()) {
            float start = downloadRange.getStart();
            Long size = downloadBean.getSize();
            Intrinsics.d(size);
            float fLongValue = start / size.longValue();
            float f11 = j12;
            int i12 = (int) (fLongValue * f11);
            if (downloadRange.getProgress() == j13) {
                iLongValue = 0;
            } else {
                float f12 = downloadRange.totalProgress();
                Long size2 = downloadBean.getSize();
                Intrinsics.d(size2);
                iLongValue = (int) ((f12 / size2.longValue()) * f11);
            }
            if (z12) {
                if (i11 < i12) {
                    if (iLongValue < i11) {
                        iLongValue = i11;
                        i12 = iLongValue;
                    } else {
                        i12 = i11;
                    }
                }
                z12 = false;
                z13 = true;
            }
            if (i11 > 0 && !z13 && i11 > iLongValue) {
                z12 = true;
            }
            linkedHashMap.put(Integer.valueOf(i12), Integer.valueOf(iLongValue));
            j12 = 10000;
            j13 = 0;
        }
        if (!z11) {
            this.D.removeCallbacksAndMessages(null);
            D2().h(LayerFlag.DOWNLOAD_PROGRESS, linkedHashMap);
            return;
        }
        uo.b.a.f(uo.b.f78622a, this.f55673k, "start setDownloadedProgress, progressList = " + linkedHashMap, false, 4, null);
        this.D.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.m
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoDetailFragment.G3(this.f55900a, linkedHashMap);
            }
        }, 1000L);
    }

    public final com.transsion.postdetail.util.j G2() {
        return (com.transsion.postdetail.util.j) this.f55686q0.getValue();
    }

    public final void H3(LocalUiType localUiType) {
        this.f55663a0 = localUiType;
    }

    public final long I2() {
        return ((Number) this.f55672j0.getValue()).longValue();
    }

    public final void I3(boolean z11) {
        this.f55664b0 = z11;
    }

    public final long J2() {
        return ((Number) this.f55674k0.getValue()).longValue();
    }

    public final void J3() {
        DownloadBean downloadBean = this.B;
        if (downloadBean == null || !downloadBean.isVideo()) {
            return;
        }
        DownloadBean downloadBean2 = this.B;
        if (downloadBean2 == null || !downloadBean2.isMusic()) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.a()), null, null, new LocalVideoDetailFragment$setSubtitle$1(this, null), 3, null);
        }
    }

    public final ScreenRotationHelper K2() {
        return (ScreenRotationHelper) this.P.getValue();
    }

    public final void K3() {
        Map<vx.a, Long> mapE;
        Map<vx.a, Long> mapE2;
        VideoSubtitleControl videoSubtitleControl = this.X;
        if (videoSubtitleControl != null) {
            com.transsion.postdetail.layer.local.o oVar = this.f55679n;
            if (oVar != null && (mapE2 = oVar.e()) != null) {
                mapE2.clear();
            }
            com.transsion.postdetail.layer.local.o oVar2 = this.f55679n;
            if (oVar2 == null || (mapE = oVar2.e()) == null) {
                return;
            }
            mapE.putAll(videoSubtitleControl.E());
        }
    }

    public final com.transsion.postdetail.ui.dialog.j L2() {
        return (com.transsion.postdetail.ui.dialog.j) this.f55669g0.getValue();
    }

    public final void L3(LocalUiType localUiType) {
        ImageView imageView;
        tv.j mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (imageView = mViewBinding.f77807p) == null) ? null : imageView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).topMargin = localUiType == LocalUiType.LAND ? 0 : this.f55684p0;
    }

    public final VideoDetailPlayDao M2() {
        return (VideoDetailPlayDao) this.N.getValue();
    }

    public final void M3() {
        DownloadBean downloadBean;
        com.transsnet.downloader.util.e.f61155a.c("5");
        if (!this.f55697w || (downloadBean = this.B) == null) {
            return;
        }
        DownloadUtil downloadUtil = DownloadUtil.f61136a;
        Intrinsics.d(downloadBean);
        downloadUtil.u(downloadBean);
        DownloadBean downloadBean2 = this.B;
        Intrinsics.d(downloadBean2);
        F3(downloadBean2, true);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: N2, reason: merged with bridge method [inline-methods] */
    public tv.j getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tv.j jVarC = tv.j.c(inflater);
        Intrinsics.f(jVarC, "inflate(inflater)");
        return jVarC;
    }

    public final void O2() {
        VideoSubtitleControl videoSubtitleControl;
        if (!isAdded() || isDetached() || isRemoving() || this.U) {
            return;
        }
        uo.b.a.o(uo.b.f78622a, "ORSubtitle", new String[]{"没字幕准备提示用户"}, false, 4, null);
        if (!RoomAppMMKV.f51271a.a().getBoolean("no_subtitle_tip_again", true) || (videoSubtitleControl = this.X) == null) {
            return;
        }
        VideoSubtitleControl.j0(videoSubtitleControl, true, false, 2, null);
    }

    public final void S2() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("extra_local_path");
            if (string == null) {
                string = "";
            }
            this.f55681o = string;
            String string2 = arguments.getString("extra_url");
            if (string2 == null) {
                string2 = "";
            }
            this.f55683p = string2;
            String string3 = arguments.getString("extra_proxy_url");
            if (string3 == null) {
                string3 = "";
            }
            this.f55685q = string3;
            String string4 = arguments.getString("extra_resource_id");
            if (string4 == null) {
                string4 = "";
            }
            this.f55687r = string4;
            String string5 = arguments.getString("extra_subject_id");
            if (string5 == null) {
                string5 = "";
            }
            this.f55693u = string5;
            String string6 = arguments.getString("extra_name");
            if (string6 == null) {
                string6 = "";
            }
            this.f55689s = string6;
            String string7 = arguments.getString("extra_post_id");
            if (string7 == null) {
                string7 = "";
            }
            this.f55691t = string7;
            this.f55700z = arguments.getBoolean("extra_completed");
            this.A = arguments.getBoolean("extra_is_series");
            String string8 = arguments.getString("extra_page_from");
            this.f55695v = string8 != null ? string8 : "";
            this.J = arguments.getInt("extra_height");
            this.I = arguments.getInt("extra_width");
            this.K = arguments.getInt("extra_parent_position", -1);
            this.L = arguments.getInt("extra_position", -1);
            this.f55697w = !this.f55700z;
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void V() {
        super.V();
        uo.b.f78622a.c("VideoFloat", "local onRecentClick", true);
        D2().h(LayerFlag.SHOW_FLOAT_2_WINDOW, FloatActionType.HOME);
    }

    public final void V2() {
        com.transsion.postdetail.layer.local.o oVar = new com.transsion.postdetail.layer.local.o();
        this.f55679n = oVar;
        oVar.g();
        com.transsion.postdetail.layer.local.o oVar2 = this.f55679n;
        if (oVar2 != null) {
            oVar2.B(this.L);
        }
        com.transsion.postdetail.layer.local.o oVar3 = this.f55679n;
        if (oVar3 != null) {
            oVar3.A(this.K);
        }
        D2().h(LayerFlag.LAYER_EVENT, new c());
    }

    public final void W2(boolean z11) {
        String name;
        DownloadBean downloadBean;
        DownloadBean downloadBean2;
        DownloadBean downloadBean3;
        DownloadBean downloadBean4;
        z2().f(this.f55692t0);
        DownloadBean downloadBeanL = DownloadEsHelper.f60994m.a().l(this.f55687r);
        this.B = downloadBeanL;
        this.A = downloadBeanL != null ? downloadBeanL.isSeries() : this.A;
        String subjectId = this.f55693u;
        String str = "";
        if (subjectId.length() == 0 && ((downloadBean4 = this.B) == null || (subjectId = downloadBean4.getSubjectId()) == null)) {
            subjectId = "";
        }
        this.f55693u = subjectId;
        String postId = this.f55691t;
        if (postId.length() == 0 && ((downloadBean3 = this.B) == null || (postId = downloadBean3.getPostId()) == null)) {
            postId = "";
        }
        this.f55691t = postId;
        if (Intrinsics.b(this.f55695v, MsgStyle.SOURCE_PUSH) && ((downloadBean = this.B) == null || ((downloadBean != null && downloadBean.getStatus() == 7) || ((downloadBean2 = this.B) != null && downloadBean2.getStatus() == 0)))) {
            zp.b.f82110a.d(R$string.video_has_delete_tip);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        D2().h(LayerFlag.UPDATE_DOWNLOAD_DATA, this.B, this.f55695v, Boolean.valueOf(z11));
        VideoSubtitleControl videoSubtitleControl = this.X;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.g0(this.B);
        }
        com.transsion.postdetail.layer.local.o oVar = this.f55679n;
        if (oVar != null) {
            oVar.z(this.B, this.f55695v);
        }
        if (this.f55697w) {
            DownloadBean downloadBean5 = this.B;
            if ((downloadBean5 != null ? downloadBean5.getProgress() : 0L) > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED && !this.f55698x) {
                uo.b.a.f(uo.b.f78622a, this.f55673k, "3--------initDownloadBean, start video", false, 4, null);
                w2();
            }
        }
        J3();
        if (z11) {
            com.transsion.postdetail.layer.a aVarD2 = D2();
            LayerFlag layerFlag = LayerFlag.REQUEST_FORYOU;
            Object[] objArr = new Object[2];
            DownloadBean downloadBean6 = this.B;
            objArr[0] = Boolean.valueOf(downloadBean6 == null || !downloadBean6.isInnerRes() || this.f55693u.length() == 0);
            DownloadBean downloadBean7 = this.B;
            if (downloadBean7 == null || !downloadBean7.isInnerRes() || this.f55693u.length() <= 0) {
                DownloadBean downloadBean8 = this.B;
                if (downloadBean8 != null && (name = downloadBean8.getName()) != null) {
                    str = name;
                }
            } else {
                str = this.f55693u;
            }
            objArr[1] = str;
            aVarD2.h(layerFlag, objArr);
            if (this.A) {
                D2().h(LayerFlag.SERIES_INIT, this.f55693u, this.f55687r);
                b3();
            }
        }
        if (this.f55697w && !com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this.D.postDelayed(this.f55694u0, 6000L);
        }
        VideoSubtitleControl videoSubtitleControl2 = this.X;
        if (videoSubtitleControl2 != null) {
            videoSubtitleControl2.n0(A2());
        }
        this.f55665c0.r0(this.B);
    }

    public final void X2() {
        if (this.f55697w) {
            this.T = false;
            this.f55698x = false;
            z2().A();
            this.D.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.l
                @Override // java.lang.Runnable
                public final void run() {
                    LocalVideoDetailFragment.Y2(this.f55898a);
                }
            }, 5000L);
        }
    }

    public final void Z2(boolean z11) {
        com.transsion.player.orplayer.f fVar;
        MediaSource mediaSourceCurrentMediaSource;
        com.transsion.postdetail.layer.local.o oVar;
        DownloadBean downloadBean = this.B;
        boolean zIsMusic = downloadBean != null ? downloadBean.isMusic() : false;
        this.U = zIsMusic;
        if (zIsMusic && (oVar = this.f55679n) != null) {
            oVar.D("music_play");
        }
        if (!this.U || !z11) {
            this.V = false;
            iv.d dVar = new iv.d(RenderType.SURFACE_VIEW, false, 1000, 0, 0, 0, 3, 0, 0L, 0, this.Y, false, false, false, false, false, null, 129976, null);
            com.transsion.player.orplayer.f fVar2 = this.f55675l;
            if (fVar2 != null) {
                fVar2.setPlayerConfig(dVar);
                return;
            }
            return;
        }
        com.transsion.player.orplayer.f fVar3 = this.f55675l;
        if (fVar3 != null && (mediaSourceCurrentMediaSource = fVar3.currentMediaSource()) != null) {
            MusicFloatManager.a aVar = MusicFloatManager.f51403i;
            aVar.b().A(mediaSourceCurrentMediaSource.e());
            aVar.b().z(mediaSourceCurrentMediaSource.h());
        }
        this.V = true;
        com.transsion.player.orplayer.f fVar4 = this.f55675l;
        if (fVar4 == null || fVar4.isPlaying() || (fVar = this.f55675l) == null) {
            return;
        }
        fVar.play();
    }

    public final void a3() {
        HashMap<String, String> mapG;
        HashMap map = new HashMap();
        map.put("resource_id", this.f55687r);
        map.put("subject_id", this.f55693u);
        map.put("post_id", this.f55691t);
        map.put("url", this.f55683p);
        DownloadBean downloadBean = this.B;
        map.put("ops", downloadBean != null ? downloadBean.getOps() : null);
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (mapG = logViewConfig.g()) == null) {
            return;
        }
        mapG.putAll(map);
    }

    public final void b3() {
        uo.b.a.f(uo.b.f78622a, this.f55673k, "---------initSeries", false, 4, null);
        D2().h(LayerFlag.SERIES_EVENT, new d());
    }

    public final void c3() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        float fC = LocalVideoPlayerConfigMmkv.f51172a.c();
        List<DubsInfo> listA2 = A2();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        VideoSubtitleControl videoSubtitleControl = new VideoSubtitleControl(fragmentActivityRequireActivity, "local_video_detail", fC, listA2, new Function1<Boolean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$initSubtitle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                this.this$0.D2().g(z11 ? LayerFlag.LOADING_BEGIN : LayerFlag.LOADING_END, new Object[0]);
            }
        }, new Function2<Boolean, Boolean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$initSubtitle$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11, boolean z12) {
                if (z11) {
                    this.this$0.D2().h(LayerFlag.BOTTOM_CONTROL, Boolean.TRUE, Boolean.valueOf(z12));
                } else {
                    this.this$0.D2().h(LayerFlag.BOTTOM_CONTROL, Boolean.FALSE, Boolean.TRUE);
                }
            }
        }, new Function3<String, String, Integer, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$initSubtitle$3
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, Integer num) {
                invoke(str, str2, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(String lanName, String lan, int i11) {
                Intrinsics.g(lanName, "lanName");
                Intrinsics.g(lan, "lan");
                com.transsion.postdetail.layer.local.o oVar = this.this$0.f55679n;
                if (oVar != null) {
                    oVar.r(lanName, lan, i11);
                }
            }
        }, new Function1<DubsInfo, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$initSubtitle$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DubsInfo dubsInfo) {
                invoke2(dubsInfo);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DubsInfo it) {
                Intrinsics.g(it, "it");
            }
        }, new Function1<List<vx.a>, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$initSubtitle$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<vx.a> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<vx.a> it) {
                Intrinsics.g(it, "it");
            }
        }, null, new Function2<String, String, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$initSubtitle$6
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(String str, String str2) {
                com.transsion.postdetail.layer.local.o oVar = this.this$0.f55679n;
                if (oVar == null) {
                    return null;
                }
                oVar.s(str, str2);
                return Unit.f68710a;
            }
        }, 512, null);
        D2().h(LayerFlag.SUBTITLE_CONTROL, videoSubtitleControl);
        this.X = videoSubtitleControl;
    }

    public final void d3(DownloadBean downloadBean) {
        if (downloadBean != null) {
            String path = this.f55681o;
            if (path.length() == 0 && (path = downloadBean.getPath()) == null) {
                path = "";
            }
            this.f55681o = path;
            String url = this.f55683p;
            if (url.length() == 0) {
                url = downloadBean.getUrl();
            }
            this.f55683p = url;
            String subjectId = this.f55693u;
            if (subjectId.length() == 0 && (subjectId = downloadBean.getSubjectId()) == null) {
                subjectId = "";
            }
            this.f55693u = subjectId;
            String name = this.f55689s;
            if (name.length() == 0 && (name = downloadBean.getName()) == null) {
                name = "";
            }
            this.f55689s = name;
            String str = this.f55691t;
            if (str.length() == 0) {
                String postId = downloadBean.getPostId();
                str = postId != null ? postId : "";
            }
            this.f55691t = str;
            this.f55700z = downloadBean.getStatus() == 5 || !downloadBean.isInnerRes();
            this.A = downloadBean.isSeries();
            this.J = downloadBean.getVideoHeight();
            this.I = downloadBean.getVideoWidth();
            boolean z11 = !this.f55700z;
            this.f55697w = z11;
            if (z11 && this.f55685q.length() == 0 && !this.V) {
                this.f55685q = z2().h(downloadBean);
            }
        }
        j3(this.f55681o);
        D2().h(LayerFlag.INIT_DATA, this.f55687r, this.f55693u, this.f55691t, Boolean.valueOf(this.f55697w), Boolean.valueOf(this.A));
        D2().h(LayerFlag.LOCAL_UI_CHANGED, LocalUiType.MIDDLE);
        a3();
        this.Q = false;
        VideoSubtitleControl videoSubtitleControl = this.X;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.f0(new e());
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f4  */
    public final void g3() {
        boolean z11;
        com.transsion.player.orplayer.f fVar;
        com.transsion.postdetail.layer.local.o oVar;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
        this.f55677m = new ORPlayerView(fragmentActivityRequireActivity, RenderType.SURFACE_VIEW);
        com.transsnet.downloader.util.e.f61155a.d("1");
        String str = this.f55697w ? this.f55685q : this.f55681o;
        com.transsion.videofloat.manager.v vVar = com.transsion.videofloat.manager.v.f60111a;
        LocalFloatManager localFloatManager = LocalFloatManager.f56167b;
        String str2 = this.f55693u;
        DownloadBean downloadBean = this.B;
        int se2 = downloadBean != null ? downloadBean.getSe() : 0;
        DownloadBean downloadBean2 = this.B;
        com.transsion.player.orplayer.f fVarB = vVar.b(localFloatManager.i(str2 + se2 + (downloadBean2 != null ? downloadBean2.getEp() : 0)));
        String strValueOf = String.valueOf(str.hashCode());
        TnPlayerManager tnPlayerManager = TnPlayerManager.f54684a;
        com.transsion.player.orplayer.f fVarA = tnPlayerManager.a(strValueOf);
        boolean z12 = fVarA == null && fVarB == null;
        this.f55667e0 = z12;
        uo.b.a aVar = uo.b.f78622a;
        aVar.c(this.f55673k, "initVideoPlayer, subjectId:" + this.f55693u + ", isNewPlayer:" + z12 + ", id:" + strValueOf, true);
        if (fVarB == null) {
            if (fVarA != null) {
                uo.b.a.f(aVar, this.f55673k, "initVideoPlayer, music player复用", false, 4, null);
                fVarB = fVarA;
            } else {
                fVarB = tnPlayerManager.i();
                z11 = false;
            }
            this.f55675l = fVarB;
            VideoFloatManager.a.a(VideoFloatManager.f60019a.b(), false, 1, null);
            Z2(z11);
            fVar = this.f55675l;
            if (fVar != null) {
                ORPlayerView oRPlayerView = this.f55677m;
                fVar.setSurfaceView(oRPlayerView != null ? oRPlayerView.getSurface() : null);
                fVar.setLooping(false);
                fVar.addPlayerListener(this.f55688r0);
                LocalVideoPlayerConfigMmkv localVideoPlayerConfigMmkv = LocalVideoPlayerConfigMmkv.f51172a;
                fVar.setSpeed(localVideoPlayerConfigMmkv.c());
                fVar.setScaleMode(localVideoPlayerConfigMmkv.b());
                oVar = this.f55679n;
                if (oVar != null) {
                    oVar.H(fVar);
                }
            }
            D2().e(LayerFlag.SET_PLAYER, this.f55675l, this.f55677m);
            L2().b().j(this, new g(new Function1<Float, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$initVideoPlayer$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f11) {
                    invoke2(f11);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Float it) {
                    com.transsion.player.orplayer.f fVar2 = this.this$0.f55675l;
                    if (fVar2 != null) {
                        Intrinsics.f(it, "it");
                        fVar2.setSpeed(it.floatValue());
                    }
                    this.this$0.D2().h(LayerFlag.UPDATE_SPEED, it);
                }
            }));
        }
        uo.b.a.f(aVar, this.f55673k, "initVideoPlayer, float player复用", false, 4, null);
        z11 = true;
        this.f55675l = fVarB;
        VideoFloatManager.a.a(VideoFloatManager.f60019a.b(), false, 1, null);
        Z2(z11);
        fVar = this.f55675l;
        if (fVar != null) {
            ORPlayerView oRPlayerView2 = this.f55677m;
            fVar.setSurfaceView(oRPlayerView2 != null ? oRPlayerView2.getSurface() : null);
            fVar.setLooping(false);
            fVar.addPlayerListener(this.f55688r0);
            LocalVideoPlayerConfigMmkv localVideoPlayerConfigMmkv2 = LocalVideoPlayerConfigMmkv.f51172a;
            fVar.setSpeed(localVideoPlayerConfigMmkv2.c());
            fVar.setScaleMode(localVideoPlayerConfigMmkv2.b());
            oVar = this.f55679n;
            if (oVar != null) {
                oVar.H(fVar);
            }
        }
        D2().e(LayerFlag.SET_PLAYER, this.f55675l, this.f55677m);
        L2().b().j(this, new g(new Function1<Float, Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$initVideoPlayer$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f11) {
                invoke2(f11);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Float it) {
                com.transsion.player.orplayer.f fVar2 = this.this$0.f55675l;
                if (fVar2 != null) {
                    Intrinsics.f(it, "it");
                    fVar2.setSpeed(it.floatValue());
                }
                this.this$0.D2().h(LayerFlag.UPDATE_SPEED, it);
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.transsion.baselib.utils.DeviceKeyMonitor.b
    public void h() {
        super.h();
        uo.b.f78622a.c("VideoFloat", "local onHomeClick", true);
        D2().h(LayerFlag.SHOW_FLOAT_2_WINDOW, FloatActionType.HOME);
    }

    public final boolean h3() {
        return this.f55676l0;
    }

    public final boolean i3() {
        return VideoPipManager.f60024a.a().k();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    public final void j3(String str) {
        int i11;
        int i12 = this.J;
        if (i12 <= 0 || (i11 = this.I) <= 0) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.c()), null, null, new LocalVideoDetailFragment$localVideoPrepare$1(str, this, null), 3, null);
            uo.b.a.f(uo.b.f78622a, this.f55673k, "play path = " + str, false, 4, null);
            return;
        }
        uo.b.a.s(uo.b.f78622a, this.f55673k, "localVideoPrepare, videoWidth  = " + i11 + ",videoHeight = " + i12, false, 4, null);
        p3(this.I, this.J, str);
    }

    public final void k3(boolean z11) {
        com.transsion.postdetail.layer.local.o oVar = this.f55679n;
        if (oVar == null) {
            return;
        }
        oVar.E(z11);
    }

    public final void m3(DownloadBean downloadBean) {
        this.S = SystemClock.elapsedRealtime();
        if (!this.f55698x && downloadBean.getProgress() >= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
            uo.b.a.f(uo.b.f78622a, this.f55673k, "1------ onDownloading, start video", false, 4, null);
            w2();
            return;
        }
        if (downloadBean.getProgress() < 10485760 || this.f55699y || SystemClock.elapsedRealtime() - this.S <= this.Y) {
            return;
        }
        uo.b.f78622a.t("long_video_play", "video error，reload~~ from onDownloading progress=" + downloadBean.getProgress() + ",isPrepare=" + this.f55699y + ",waitTime=" + (System.currentTimeMillis() - this.S), true);
        this.S = SystemClock.elapsedRealtime();
        x3(this, false, 1, null);
    }

    public final void n3() {
        this.f55665c0.V();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("local_video_detail", false, 2, null);
    }

    public final void o3() {
        D2().g(LayerFlag.COMPLETION, new Object[0]);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.b(this, mediaSource);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.g(context, "context");
        super.onAttach(context);
        D2().d(new com.transsion.postdetail.layer.local.c0(this));
        D2().d(new LocalVideoLandLayer(this));
        D2().d(new LocalVideoMiddleLayer(this));
        D2().e(LayerFlag.SET_MANAGER, D2());
        requireActivity().getOnBackPressedDispatcher().i(this, new f());
    }

    @Override // com.transsion.baselib.report.RoomActivityLifecycleCallbacks.a
    public void onBackgroundStatusChange(boolean z11) {
        com.transsion.postdetail.layer.local.o oVar;
        if (!z11 || (oVar = this.f55679n) == null) {
            return;
        }
        oVar.b(true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.d(this, mediaSource);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        uo.b.a.f(uo.b.f78622a, this.f55673k, "onConfigurationChanged " + newConfig.orientation, false, 4, null);
        int i11 = newConfig.orientation;
        if (i11 == 2) {
            x2().pause();
        } else if (i11 == 1) {
            ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).show();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        com.transsion.player.orplayer.f fVar;
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        DownloadBean downloadBean = this.B;
        if (downloadBean != null) {
            uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), "网络连接成功开始检测字幕,name:" + downloadBean.getTotalTitleName() + ", subtitleResId:" + downloadBean.getSubtitleResId(), true);
            VideoSubtitleManager.a.a(VideoSubtitleManager.f58109a.a(), downloadBean, null, 2, null);
        }
        if (this.f55697w && isResumed()) {
            DownloadBean downloadBean2 = this.B;
            if (downloadBean2 != null) {
                z2().j(downloadBean2);
            }
            uo.b.a.s(uo.b.f78622a, this.f55673k, "onNetworkConnected", false, 4, null);
            com.transsion.player.orplayer.f fVar2 = this.f55675l;
            if ((fVar2 != null && !fVar2.isPlaying()) || ((fVar = this.f55675l) != null && fVar.isLoading())) {
                D2().g(LayerFlag.LOADING_BEGIN, new Object[0]);
                u2();
                if (this.f55666d0 != null || this.f55676l0) {
                    w3(false);
                } else {
                    com.transsion.player.orplayer.f fVar3 = this.f55675l;
                    if (fVar3 != null) {
                        fVar3.play();
                    }
                }
            }
            D2().h(LayerFlag.NETWORK_CHANGE, Boolean.TRUE);
            if (this.R) {
                D2().h(LayerFlag.PLAYER_TIMEOUT_TIPS, new Object[0]);
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        uo.b.a.f(uo.b.f78622a, this.f55673k, "onDestroy", false, 4, null);
        DownloadBean downloadBean = this.B;
        if (downloadBean != null) {
            downloadBean.setQuitDPRestart(true);
            downloadBean.setDownloadingPlay(false);
        }
        RoomActivityLifecycleCallbacks.f51239a.k(this);
        if (this.f55697w) {
            z2().d();
        }
        K3();
        com.transsion.postdetail.layer.local.o oVar = this.f55679n;
        if (oVar != null) {
            com.transsion.postdetail.layer.local.o.c(oVar, false, 1, null);
        }
        tv.j mViewBinding = getMViewBinding();
        ConstraintLayout constraintLayoutB = mViewBinding != null ? mViewBinding.getRoot() : null;
        if (constraintLayoutB != null) {
            constraintLayoutB.setKeepScreenOn(false);
        }
        VideoSubtitleControl videoSubtitleControl = this.X;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.L();
        }
        D2().h(LayerFlag.FRAGMENT_DESTROY, new Object[0]);
        x2().removePlayerListener(this);
        z2().o();
        z2().v(this.f55692t0);
        this.f55665c0.I();
        com.transsion.player.orplayer.f fVar = this.f55675l;
        if (fVar != null) {
            fVar.removePlayerListener(this.f55688r0);
        }
        this.f55670h0.removeCallbacks(this.f55690s0);
        Context context = getContext();
        if (context == null || com.transsion.baseui.util.b.a(context)) {
            return;
        }
        K2().h();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
        if (this.f55697w) {
            uo.b.a aVar = uo.b.f78622a;
            com.transsion.player.orplayer.f fVar = this.f55675l;
            Boolean boolValueOf = fVar != null ? Boolean.valueOf(fVar.isLoading()) : null;
            aVar.c("long_video_play", "onNetworkDisconnected  isLoading= " + boolValueOf + ", isPrepare = " + this.f55699y + ", isDownloadingPlayStart =" + this.f55698x, true);
            com.transsion.player.orplayer.f fVar2 = this.f55675l;
            if ((fVar2 == null || !fVar2.isLoading()) && this.f55698x && this.f55699y) {
                return;
            }
            D2().h(LayerFlag.NETWORK_CHANGE, Boolean.FALSE);
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

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.U) {
            return;
        }
        D2().h(LayerFlag.FRAGMENT_PAUSE, new Object[0]);
        com.transsion.postdetail.util.j jVarG2 = G2();
        if (jVarG2 != null) {
            jVarG2.disable();
        }
        this.f55665c0.m0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean z11) {
        super.onPictureInPictureModeChanged(z11);
        D2().h(LayerFlag.INTO_PIP, Boolean.valueOf(z11));
        VideoPipManager.f60024a.a().onPipModeChanged(z11);
        com.transsion.postdetail.layer.local.o oVar = this.f55679n;
        if (oVar == null) {
            return;
        }
        oVar.C(z11);
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
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.U) {
            return;
        }
        D2().h(LayerFlag.FRAGMENT_RESUME, new Object[0]);
        com.transsion.postdetail.util.j jVarG2 = G2();
        if (jVarG2 != null) {
            jVarG2.enable();
        }
        this.f55665c0.n0();
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        com.transsion.player.orplayer.e.a.A(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        B3(this, this.B, this.F, false, 4, null);
        if (!this.U) {
            D2().h(LayerFlag.FRAGMENT_STOP, new Object[0]);
        }
        super.onStop();
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

    public final void p3(int i11, int i12, String str) {
        D2().h(LayerFlag.ADD_SURFACE, Integer.valueOf(i11), Integer.valueOf(i12));
        if (!this.f55697w) {
            this.f55699y = false;
            com.transsnet.downloader.util.e.f61155a.b("2");
            com.transsion.postdetail.layer.local.o oVar = this.f55679n;
            if (oVar != null) {
                oVar.a();
            }
            t3(str);
            return;
        }
        com.transsion.player.orplayer.f fVar = this.f55675l;
        if (fVar != null && !fVar.isPlaying()) {
            D2().g(LayerFlag.LOADING_BEGIN, new Object[0]);
        }
        DownloadBean downloadBean = this.B;
        if ((downloadBean != null ? downloadBean.getProgress() : 0L) >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED || com.tn.lib.util.networkinfo.f.f49475a.e()) {
            return;
        }
        D2().h(LayerFlag.NETWORK_CHANGE, Boolean.FALSE);
    }

    public final void q3() {
        com.transsion.player.orplayer.f fVar;
        com.transsion.player.orplayer.f fVar2 = this.f55675l;
        if (fVar2 == null || fVar2.isPlaying() || this.f55676l0 || (fVar = this.f55675l) == null) {
            return;
        }
        fVar.play();
    }

    public final void r2(boolean z11) {
        LocalUiType localUiType = this.f55696v0;
        boolean zIsResumed = isResumed();
        LocalUiType localUiType2 = this.f55663a0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("竖屏: ");
        sb2.append(z11);
        sb2.append("，curUiRation: ");
        sb2.append(localUiType);
        sb2.append(", isResumed");
        sb2.append(zIsResumed);
        sb2.append(", ui:");
        sb2.append(localUiType2);
        com.transsion.postdetail.layer.local.o oVar = this.f55679n;
        if (oVar == null || !oVar.d()) {
            if (z11) {
                y3();
            }
            LocalUiType localUiType3 = z11 ? LocalUiType.MIDDLE : LocalUiType.LAND;
            if (!isResumed() || this.f55696v0 == localUiType3 || localUiType3 == this.f55663a0) {
                this.f55696v0 = localUiType3;
                return;
            }
            this.f55696v0 = localUiType3;
            com.transsion.baselib.report.m.f51277a.n("auto_screen", kotlin.collections.r.f(new Pair("orientation", localUiType3 == LocalUiType.LAND ? "land" : "port")));
            D2().h(LayerFlag.SCREEN_ORIENTATION_CHANGED, localUiType3);
        }
    }

    public final void s2(long j11) {
        long j12 = this.f55682o0;
        if (j12 == 0) {
            this.f55682o0 = j11;
            return;
        }
        if (Math.abs(j11 - j12) > 5000) {
            this.f55682o0 = j11;
            this.f55678m0 += System.currentTimeMillis() - this.f55680n0;
            this.f55680n0 = System.currentTimeMillis();
        }
        if (this.f55676l0 || this.f55678m0 < this.f55665c0.T() || !this.f55665c0.c0()) {
            return;
        }
        this.f55665c0.B0(new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$checkShowInterpolateAd$1
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
                com.transsion.player.orplayer.f fVar = this.this$0.f55675l;
                if (fVar != null) {
                    fVar.play();
                }
                this.this$0.f55678m0 = 0L;
                this.this$0.f55680n0 = System.currentTimeMillis();
            }
        });
    }

    public final void s3(long j11) {
        if (this.V || !this.f55667e0) {
            return;
        }
        com.transsion.player.orplayer.f fVar = this.f55675l;
        if (fVar != null) {
            fVar.seekTo(j11);
        }
        com.transsion.player.orplayer.f fVar2 = this.f55675l;
        if (fVar2 != null) {
            fVar2.play();
        }
        if (this.G <= 0.0f && j11 >= 1000 && !this.T) {
            D2().h(LayerFlag.SHOW_TOAST, Utils.a().getString(R$string.last_played_time) + " " + com.transsion.postdetail.util.i.d(j11));
        }
        if (!this.f55697w || this.T) {
            return;
        }
        com.transsion.postdetail.layer.a aVarD2 = D2();
        LayerFlag layerFlag = LayerFlag.SHOW_TOAST;
        String string = Utils.a().getString(R$string.analysing_from);
        String[] stringArray = Utils.a().getResources().getStringArray(R$array.analysing_array);
        Intrinsics.f(stringArray, "getApp().resources.getSt…(R.array.analysing_array)");
        aVarD2.h(layerFlag, string + " [" + kotlin.collections.d.r0(stringArray, Random.Default) + "]");
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final void t2(String str, String str2) {
        D2().h(LayerFlag.SERIES_PLAY, str, str2);
    }

    public final void t3(String str) {
        VideoSubtitleControl videoSubtitleControl;
        uo.b.a aVar = uo.b.f78622a;
        boolean z11 = this.V;
        DownloadBean downloadBean = this.B;
        String subjectId = downloadBean != null ? downloadBean.getSubjectId() : null;
        DownloadBean downloadBean2 = this.B;
        String totalTitleName = downloadBean2 != null ? downloadBean2.getTotalTitleName() : null;
        DownloadBean downloadBean3 = this.B;
        String resourceId = downloadBean3 != null ? downloadBean3.getResourceId() : null;
        DownloadBean downloadBean4 = this.B;
        String createAtFormat = downloadBean4 != null ? downloadBean4.getCreateAtFormat() : null;
        aVar.c("long_video_play", "playerSetDataSource, isBgPlaying = " + z11 + ", subjectId = " + subjectId + ", name:" + totalTitleName + "resourceId = " + resourceId + ", downloadTime:" + createAtFormat + "， orPlayer:" + this.f55675l + ", path = " + str, true);
        if (!this.f55667e0 && (videoSubtitleControl = this.X) != null) {
            videoSubtitleControl.a0(true);
        }
        if (this.V || !this.f55667e0) {
            this.f55667e0 = true;
            return;
        }
        com.transsion.player.orplayer.f fVar = this.f55675l;
        if (fVar != null) {
            fVar.clearScreen();
        }
        DownloadBean downloadBean5 = this.B;
        if (downloadBean5 != null) {
            downloadBean5.setPlayingUrl(str);
        }
        com.transsion.player.orplayer.f fVar2 = this.f55675l;
        if (fVar2 != null) {
            MediaSource mediaSource = new MediaSource(String.valueOf(str.hashCode()), str, 0, null, E2(), 12, null);
            MusicFloatManager.a aVar2 = MusicFloatManager.f51403i;
            aVar2.b().A(mediaSource.e());
            aVar2.b().z(mediaSource.h());
            fVar2.setDataSource(mediaSource);
        }
        com.transsion.player.orplayer.f fVar3 = this.f55675l;
        if (fVar3 != null) {
            fVar3.prepare();
        }
        z3();
        this.f55671i0 = str;
        this.f55670h0.postDelayed(this.f55690s0, this.f55697w ? J2() : I2());
    }

    public final void u2() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            uo.b.a.f(uo.b.f78622a, this.f55673k, "---------has net， delay show toast", false, 4, null);
            B2().postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.n
                @Override // java.lang.Runnable
                public final void run() {
                    LocalVideoDetailFragment.v2(this.f55903a);
                }
            }, 10000L);
        } else {
            uo.b.a.f(uo.b.f78622a, this.f55673k, "---------no net， show error", false, 4, null);
            D2().h(LayerFlag.NETWORK_CHANGE, Boolean.FALSE);
        }
    }

    public final void u3(DownloadBean downloadBean) {
        com.transsion.player.orplayer.f fVar = this.f55675l;
        this.H = fVar != null ? fVar.getDuration() : 0L;
        uo.b.f78622a.c("long_video_play", "onPrepare history progress " + (downloadBean != null ? Long.valueOf(downloadBean.getReadProgress()) : null) + "， duration = " + this.H + ", unplaySeekProgress = " + this.G + ", id =" + (downloadBean != null ? downloadBean.getResourceId() : null) + ", epse = " + (downloadBean != null ? Integer.valueOf(downloadBean.getEpse()) : null), true);
        Ref.LongRef longRef = new Ref.LongRef();
        long readProgress = downloadBean != null ? downloadBean.getReadProgress() : 0L;
        longRef.element = readProgress;
        if (Math.abs(readProgress - this.H) < 100) {
            longRef.element = 0L;
        }
        float f11 = this.G;
        if (f11 > 0.0f) {
            longRef.element = (long) (f11 * this.H);
        }
        this.f55665c0.H0(new LocalVideoDetailFragment$prepare$1(this, longRef));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        MusicFloatManager.f51403i.b().s();
        initView();
        U2();
    }

    public final void v3() {
        if (!this.U) {
            D2().h(LayerFlag.RELEASE_PLAYER, new Object[0]);
        }
        z3();
    }

    public final void w2() {
        this.f55699y = false;
        this.f55698x = true;
        com.transsion.postdetail.layer.local.o oVar = this.f55679n;
        if (oVar != null) {
            oVar.a();
        }
        com.transsnet.downloader.util.e.f61155a.b("2");
        t3(this.f55685q);
    }

    public final void w3(boolean z11) {
        if (this.V || !this.f55667e0) {
            return;
        }
        if (z11) {
            this.W.set(0);
        }
        if (this.W.get() > 2) {
            return;
        }
        this.f55666d0 = null;
        this.W.getAndAdd(1);
        uo.b.f78622a.t("long_video_play", "video error，reload~~", true);
        com.transsion.player.orplayer.f fVar = this.f55675l;
        if (fVar != null) {
            fVar.stop();
        }
        com.transsion.player.orplayer.f fVar2 = this.f55675l;
        if (fVar2 != null) {
            fVar2.reset();
        }
        this.f55699y = false;
        this.T = true;
        D2().g(LayerFlag.LOADING_BEGIN, new Object[0]);
        t3(!this.f55697w ? this.f55681o : this.f55685q);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    public final IAudioApi x2() {
        Object value = this.Z.getValue();
        Intrinsics.f(value, "<get-audioApi>(...)");
        return (IAudioApi) value;
    }

    public final Intent y2() {
        Intent intent = new Intent();
        intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "/video/detail");
        intent.putExtra("id", this.f55693u);
        DownloadBean downloadBean = this.B;
        intent.putExtra("extra_resource_id", downloadBean != null ? downloadBean.getResourceId() : null);
        DownloadBean downloadBean2 = this.B;
        intent.putExtra("extra_local_path", downloadBean2 != null ? downloadBean2.getPath() : null);
        return intent;
    }

    public final void y3() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        List<Fragment> fragments = getParentFragmentManager().getFragments();
        Intrinsics.f(fragments, "parentFragmentManager.fragments");
        for (Fragment fragment : fragments) {
            if (fragment instanceof BaseDialog) {
                try {
                    Result.Companion companion = Result.Companion;
                    ((BaseDialog) fragment).dismissAllowingStateLoss();
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean z0() {
        return true;
    }

    public final void z3() {
        this.f55671i0 = null;
        com.transsion.postdetail.layer.local.o oVar = this.f55679n;
        if (oVar != null) {
            oVar.L(false);
        }
        this.f55670h0.removeCallbacks(this.f55690s0);
    }
}
