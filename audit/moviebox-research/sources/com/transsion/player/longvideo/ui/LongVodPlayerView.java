package com.transsion.player.longvideo.ui;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.common.collect.ImmutableList;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv;
import com.transsion.baselib.helper.ScreenRotationHelper;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.utils.PlayMode;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.music.MusicFloatManager;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.player.MediaSource;
import com.transsion.player.config.RenderType;
import com.transsion.player.longvideo.R$array;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$string;
import com.transsion.player.longvideo.constants.LongVodPageType;
import com.transsion.player.longvideo.constants.LongVodPlayerConfigType;
import com.transsion.player.longvideo.helper.LongVodLandForwardViewControl;
import com.transsion.player.longvideo.helper.LongVodSubtitleHelper;
import com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog;
import com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper;
import com.transsion.player.longvideo.ui.dialog.PlayerSettingDialog;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsion.player.p006enum.PlayMimeType;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.player.ui.longvideo.ORLongVodPlayerView;
import com.transsion.postdetail.layer.local.LocalUiType;
import com.transsion.postdetail.layer.local.LongVodMiddleForwardViewControl;
import com.transsion.postdetail.layer.local.f0;
import com.transsion.postdetail.ui.view.ImmScaleView;
import com.transsion.postdetail.ui.view.ImmSpeedView;
import com.transsion.push.api.IPushProvider;
import com.transsion.quickjs.QuickJSHelper;
import com.transsion.videofloat.VideoFloatManager;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
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
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
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
public final class LongVodPlayerView extends ConstraintLayout implements kv.a, RoomActivityLifecycleCallbacks.a {
    public static final a Companion = new a(null);
    public static final String PK_NEW_PLAYER_UI_KEY = "pk_player_ui_key";
    public static final String TAG = "LongVodPlayerView";
    public boolean A;
    public long A0;
    public boolean B;
    public final Runnable B0;
    public boolean C;
    public final e C0;
    public boolean D;
    public final Runnable D0;
    public boolean E;
    public boolean E0;
    public boolean F;
    public final Lazy F0;
    public String G;
    public lv.a H;
    public lv.c I;
    public View J;
    public View K;
    public FrameLayout L;
    public Handler M;
    public LongVodLandForwardViewControl N;
    public LongVodMiddleForwardViewControl O;
    public f0 P;
    public View Q;
    public lv.c R;
    public ORPlayerView S;
    public com.transsion.postdetail.layer.local.o T;
    public final Lazy U;
    public kv.a.b V;
    public LongVodSubtitleHelper W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mv.i f54447a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public com.transsion.player.longvideo.helper.h f54448a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LongVodPlayerViewAdHelper f54449b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final com.transsion.player.longvideo.helper.t f54450b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54451c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public com.transsion.player.longvideo.helper.g f54452c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f54453d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public com.transsion.player.longvideo.helper.r f54454d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public com.transsion.player.longvideo.helper.c f54455e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.transsion.player.ui.longvideo.a f54456f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f54457f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f54458g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public float f54459g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LongVodPageType f54460h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final Lazy f54461h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f54462i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final Lazy f54463i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f54464j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public ov.d f54465j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LongVodUiType f54466k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public ov.b f54467k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LongVodUiType f54468l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f54469l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f54470m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public List<lv.b> f54471m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f54472n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f54473n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f54474o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final Handler f54475o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f54476p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public MediaSource f54477p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f54478q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final Lazy f54479q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f54480r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final Lazy f54481r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f54482s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final k0 f54483s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f54484t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public Function1<? super DubsInfo, Unit> f54485t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f54486u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public List<DubsInfo> f54487u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f54488v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f54489v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f54490w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f54491w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f54492x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f54493x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f54494y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final Lazy f54495y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f54496z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final LongVodPlayerView$playerListener$1 f54497z0;

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
    public static final class b implements com.transsion.player.ui.longvideo.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f54498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f54499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f54500c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f54501d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f54503f;

        public b(boolean z11) {
            this.f54503f = z11;
        }

        @Override // com.transsion.player.ui.longvideo.a.b
        public void a() {
            LongVodPlayerView.this.F0();
        }

        @Override // com.transsion.player.ui.longvideo.a.b
        public void b(float f11, float f12) {
            if (!this.f54500c) {
                this.f54501d = LongVodPlayerView.this.f54447a.f71242o.f71272t.getProgress();
                LongVodPlayerView.this.c1(false);
            }
            LongVodPlayerView.this.f54490w = true;
            this.f54500c = true;
            LongVodPlayerView.this.M.removeCallbacks(LongVodPlayerView.this.B0);
            long j11 = (long) (this.f54501d + (((this.f54503f ? f11 - f12 : f12 - f11) * LongVodPlayerView.this.f54474o) / ((LongVodPlayerView.this.f54466k == LongVodUiType.LAND ? LongVodPlayerView.this.f54453d : LongVodPlayerView.this.f54451c) * 4)));
            if (j11 < 0) {
                j11 = 0;
            } else if (j11 > LongVodPlayerView.this.f54474o) {
                j11 = LongVodPlayerView.this.f54474o;
            }
            LongVodPlayerView.this.f54447a.f71242o.f71272t.setProgress(j11);
            LongVodPlayerView.this.f54447a.f71243p.f71290m.setProgress(j11);
            this.f54499b = (j11 * 1.0f) / LongVodPlayerView.this.f54474o;
            long j12 = (long) (LongVodPlayerView.this.f54474o * this.f54499b);
            this.f54498a = j12;
            LongVodPlayerView.this.r1(true, j12);
        }

        @Override // com.transsion.player.ui.longvideo.a.b
        public void c() {
            if (this.f54500c) {
                LongVodPlayerView.this.f54456f.seekTo(this.f54498a);
                if (!LongVodPlayerView.this.f54456f.isPlaying() && !LongVodPlayerView.this.u0()) {
                    LongVodPlayerView.this.f54456f.play();
                }
                com.transsion.postdetail.layer.local.o oVar = LongVodPlayerView.this.T;
                if (oVar != null) {
                    oVar.p();
                }
                LongVodPlayerView.this.r1(false, 0L);
                LongVodPlayerView.this.hideBottomController(false);
            }
            LongVodPlayerView.this.f54490w = false;
            this.f54500c = false;
            LongVodPlayerView.this.D();
        }

        @Override // com.transsion.player.ui.longvideo.a.b
        public void onDoubleTap(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            if (LongVodPlayerView.this.f54447a.f71242o.f71265m.isSelected()) {
                return;
            }
            uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onDoubleTap ", false, 4, null);
            LongVodPlayerView.this.v1(e11, true);
        }

        @Override // com.transsion.player.ui.longvideo.a.b
        public void onLongPress(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            LongVodPlayerView.this.A0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.tn.lib.view.p {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f54505b;

        public c(Ref.LongRef longRef) {
            this.f54505b = longRef;
        }

        @Override // com.tn.lib.view.p
        public void a(SecondariesSeekBar seekBar) {
            Intrinsics.g(seekBar, "seekBar");
            uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onStopTrackingTouch targetProgress:" + this.f54505b.element + " ", false, 4, null);
            LongVodPlayerView.this.f54490w = false;
            LongVodPlayerView.this.f54456f.seekTo(this.f54505b.element);
            if (!LongVodPlayerView.this.f54456f.isPlaying() && !LongVodPlayerView.this.u0()) {
                LongVodPlayerView.this.f54456f.play();
            }
            com.transsion.postdetail.layer.local.o oVar = LongVodPlayerView.this.T;
            if (oVar != null) {
                oVar.p();
            }
            LongVodPlayerView.this.r1(false, 0L);
            LongVodPlayerView.this.hideBottomController(false);
        }

        @Override // com.tn.lib.view.p
        public void b(SecondariesSeekBar seekBar, long j11, boolean z11) {
            View view;
            Intrinsics.g(seekBar, "seekBar");
            if (z11) {
                View view2 = LongVodPlayerView.this.K;
                if (view2 != null && so.c.i(view2) && (view = LongVodPlayerView.this.K) != null) {
                    so.c.g(view);
                }
                LongVodPlayerView.this.f54490w = true;
                LongVodPlayerView.this.M.removeCallbacks(LongVodPlayerView.this.B0);
                if (LongVodPlayerView.this.f54474o > 0) {
                    this.f54505b.element = (long) (LongVodPlayerView.this.f54474o * (j11 / LongVodPlayerView.this.f54474o));
                }
                LongVodPlayerView.this.r1(true, this.f54505b.element);
            }
        }

        @Override // com.tn.lib.view.p
        public void c(SecondariesSeekBar seekBar) {
            Intrinsics.g(seekBar, "seekBar");
            uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onStartTrackingTouch ", false, 4, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements com.transsion.player.longvideo.helper.u {
        public d() {
        }

        @Override // com.transsion.player.longvideo.helper.u
        public void b(boolean z11, boolean z12) {
            LongVodPlayerView.this.B(z11, z12);
        }

        @Override // com.transsion.player.longvideo.helper.u
        public void c(String text) {
            Intrinsics.g(text, "text");
            LongVodPlayerView.this.n1(text);
        }

        @Override // com.transsion.player.longvideo.helper.u
        public void d(String str, String str2) {
            com.transsion.postdetail.layer.local.o oVar = LongVodPlayerView.this.T;
            if (oVar != null) {
                oVar.s(str, str2);
            }
        }

        @Override // com.transsion.player.longvideo.helper.u
        public void e(List<vx.a> list) {
            Intrinsics.g(list, "list");
            com.transsion.postdetail.layer.local.o oVar = LongVodPlayerView.this.T;
            if (oVar != null) {
                oVar.q(list);
            }
        }

        @Override // com.transsion.player.longvideo.helper.u
        public void f(String str) {
            LongVodPlayerView.this.f54480r = str;
            uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onSetSelectId, selectId:" + str + " ", false, 4, null);
        }

        @Override // com.transsion.player.longvideo.helper.u
        public void g(String name, String lan, int i11) {
            Intrinsics.g(name, "name");
            Intrinsics.g(lan, "lan");
            com.transsion.postdetail.layer.local.o oVar = LongVodPlayerView.this.T;
            if (oVar != null) {
                oVar.r(name, lan, i11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements com.tn.lib.util.networkinfo.g {
        public e() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            LongVodPlayerView.this.O0();
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, LongVodPlayerView.TAG, "onConnected ", false, 4, null);
            if (!LongVodPlayerView.this.f54488v && com.tn.lib.util.networkinfo.f.f49475a.e() && LongVodPlayerView.this.f54496z) {
                aVar.c(LongVodPlayerView.TAG, "onConnected, isPrepared:" + LongVodPlayerView.this.F + " ", true);
                if (LongVodPlayerView.this.F) {
                    aVar.c(LongVodPlayerView.TAG, "onConnected play", true);
                    LongVodPlayerView.this.f54456f.play();
                } else {
                    lv.c cVar = LongVodPlayerView.this.I;
                    if (cVar != null) {
                        LongVodPlayerView longVodPlayerView = LongVodPlayerView.this;
                        aVar.c(LongVodPlayerView.TAG, "onConnected setPlayerDataSourceAdPrepare", true);
                        longVodPlayerView.setPlayerDataSourceAdPrepare(cVar);
                    }
                }
            }
            LongVodSubtitleHelper longVodSubtitleHelper = LongVodPlayerView.this.W;
            if (longVodSubtitleHelper != null) {
                longVodSubtitleHelper.w();
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f54508a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f54508a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f54508a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f54508a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g implements com.transsion.quickjs.a {
        @Override // com.transsion.quickjs.a
        public void a(String str, int i11) {
            uo.b.f78622a.c(LongVodPlayerView.TAG, "quickjs onWatch failed: " + str, true);
        }

        @Override // com.transsion.quickjs.a
        public void onSuccess(Object obj) {
            uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "quickjs onWatch success", false, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.transsion.player.longvideo.ui.LongVodPlayerView$onSaveHistory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.player.longvideo.ui.LongVodPlayerView$onSaveHistory$1", f = "LongVodPlayerView.kt", l = {2278, 2314}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class C19961 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ lv.a $bean;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ LongVodPlayerView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C19961(lv.a aVar, LongVodPlayerView longVodPlayerView, Continuation<? super C19961> continuation) {
            super(2, continuation);
            this.$bean = aVar;
            this.this$0 = longVodPlayerView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C19961(this.$bean, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C19961) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            lv.a aVar;
            LongVodPlayerView longVodPlayerView;
            Object objK;
            ArrayList arrayList;
            VideoDetailPlayBean videoDetailPlayBean;
            Long lastAdEndTimeStamp;
            Long lastAdStartTimeStamp;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    ArrayList arrayList2 = (ArrayList) this.L$2;
                    aVar = (lv.a) this.L$1;
                    LongVodPlayerView longVodPlayerView2 = (LongVodPlayerView) this.L$0;
                    ResultKt.b(obj);
                    objK = obj;
                    arrayList = arrayList2;
                    longVodPlayerView = longVodPlayerView2;
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    videoDetailPlayBean = (VideoDetailPlayBean) this.L$1;
                    longVodPlayerView = (LongVodPlayerView) this.L$0;
                    ResultKt.b(obj);
                }
                longVodPlayerView.Z0(videoDetailPlayBean);
                f00.d dVar = new f00.d(true, false);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = f00.d.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, dVar, 0L);
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            aVar = this.$bean;
            if (aVar != null) {
                longVodPlayerView = this.this$0;
                ArrayList arrayList3 = new ArrayList();
                Iterator<T> it = aVar.a().iterator();
                while (it.hasNext()) {
                    String subjectId = ((DubsInfo) it.next()).getSubjectId();
                    if (subjectId != null) {
                        arrayList3.add(subjectId);
                    }
                }
                if (arrayList3.isEmpty()) {
                    arrayList3.add(aVar.m());
                }
                VideoDetailPlayDao videoDetailPlayDao = longVodPlayerView.getVideoDetailPlayDao();
                String strM = aVar.m();
                int iK = aVar.k();
                int iD = aVar.d();
                this.L$0 = longVodPlayerView;
                this.L$1 = aVar;
                this.L$2 = arrayList3;
                this.label = 1;
                objK = videoDetailPlayDao.k(strM, iK, iD, this);
                if (objK == objE) {
                    return objE;
                }
                arrayList = arrayList3;
            }
            return Unit.f68710a;
            VideoDetailPlayBean videoDetailPlayBean2 = (VideoDetailPlayBean) objK;
            boolean rewardPlayed = videoDetailPlayBean2 != null ? videoDetailPlayBean2.getRewardPlayed() : false;
            boolean rewardFree = videoDetailPlayBean2 != null ? videoDetailPlayBean2.getRewardFree() : false;
            longVodPlayerView.f54491w0 = videoDetailPlayBean2 != null && videoDetailPlayBean2.getRewardUnlock();
            lv.c cVar = longVodPlayerView.I;
            if (cVar != null) {
                VideoDetailPlayBean videoDetailPlayBean3 = new VideoDetailPlayBean(aVar.m(), cVar.b(), aVar.d(), aVar.k(), longVodPlayerView.f54476p, aVar.n(), aVar.c(), aVar.q(), cVar.f(), System.currentTimeMillis(), null, Boxing.e(longVodPlayerView.f54474o), Boxing.e(aVar.l()), aVar.b(), aVar.p(), aVar.f(), PlayMode.STREAM.getValue(), null, null, 0L, arrayList, Boxing.e((videoDetailPlayBean2 == null || (lastAdStartTimeStamp = videoDetailPlayBean2.getLastAdStartTimeStamp()) == null) ? 0L : lastAdStartTimeStamp.longValue()), Boxing.e((videoDetailPlayBean2 == null || (lastAdEndTimeStamp = videoDetailPlayBean2.getLastAdEndTimeStamp()) == null) ? 0L : lastAdEndTimeStamp.longValue()), rewardPlayed, longVodPlayerView.f54491w0, rewardFree, 525312, null);
                if (longVodPlayerView.f54480r != null) {
                    videoDetailPlayBean3.setSubtitleSelectId(longVodPlayerView.f54480r);
                }
                VideoDetailPlayDao videoDetailPlayDao2 = longVodPlayerView.getVideoDetailPlayDao();
                this.L$0 = longVodPlayerView;
                this.L$1 = videoDetailPlayBean3;
                this.L$2 = null;
                this.label = 2;
                if (videoDetailPlayDao2.q(videoDetailPlayBean3, this) == objE) {
                    return objE;
                }
                videoDetailPlayBean = videoDetailPlayBean3;
                longVodPlayerView.Z0(videoDetailPlayBean);
                f00.d dVar2 = new f00.d(true, false);
                FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name2 = f00.d.class.getName();
                Intrinsics.f(name2, "T::class.java.name");
                flowEventBus2.postEvent(name2, dVar2, 0L);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LongVodPlayerView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LongVodPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.transsion.player.longvideo.ui.LongVodPlayerView$playerListener$1] */
    public LongVodPlayerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f54449b = new LongVodPlayerViewAdHelper();
        this.f54451c = com.blankj.utilcode.util.d0.e();
        this.f54453d = com.blankj.utilcode.util.d0.c();
        LongVodUiType longVodUiType = LongVodUiType.MIDDLE;
        this.f54466k = longVodUiType;
        this.f54468l = longVodUiType;
        this.f54496z = true;
        this.C = true;
        this.E = true;
        this.M = new Handler(Looper.getMainLooper());
        this.U = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$videoDetailPlayDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoDetailPlayDao invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).O0();
            }
        });
        this.f54461h0 = LazyKt__LazyJVMKt.b(new Function0<com.transsion.player.longvideo.ui.dialog.a>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$configViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsion.player.longvideo.ui.dialog.a invoke() {
                Context context2 = this.this$0.getContext();
                Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                return (com.transsion.player.longvideo.ui.dialog.a) new v0((FragmentActivity) context2).a(com.transsion.player.longvideo.ui.dialog.a.class);
            }
        });
        this.f54463i0 = LazyKt__LazyJVMKt.b(new Function0<com.transsion.postdetail.ui.dialog.j>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$speedViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsion.postdetail.ui.dialog.j invoke() {
                Context context2 = this.this$0.getContext();
                Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                return (com.transsion.postdetail.ui.dialog.j) new v0((FragmentActivity) context2).a(com.transsion.postdetail.ui.dialog.j.class);
            }
        });
        this.f54469l0 = true;
        this.f54471m0 = new ArrayList();
        this.f54475o0 = new Handler(Looper.getMainLooper());
        this.f54479q0 = LazyKt__LazyJVMKt.b(new Function0<Long>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$playTimeoutStream$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                Long lN;
                ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sb_lv_play_timeout_dp", false, 2, null);
                String value = configBeanC != null ? configBeanC.getValue() : null;
                long jLongValue = 12000;
                if (value != null && value.length() != 0 && (lN = kotlin.text.k.n(value)) != null) {
                    jLongValue = lN.longValue();
                }
                return Long.valueOf(jLongValue);
            }
        });
        this.f54481r0 = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$pkStyle$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), LongVodPlayerView.PK_NEW_PLAYER_UI_KEY, false, 2, null);
                String value = configBeanC != null ? configBeanC.getValue() : null;
                return Boolean.valueOf(value == null || value.length() == 0);
            }
        });
        this.f54483s0 = l0.a(w0.b());
        mv.i iVarB = mv.i.b(LayoutInflater.from(getContext()), this);
        Intrinsics.f(iVarB, "inflate(LayoutInflater.from(context), this)");
        this.f54447a = iVarB;
        ORLongVodPlayerView oRLongVodPlayerView = iVarB.f71246s;
        Intrinsics.f(oRLongVodPlayerView, "viewBinding.orLongVodView");
        this.f54456f = oRLongVodPlayerView;
        this.f54450b0 = new com.transsion.player.longvideo.helper.t();
        setClickable(true);
        C();
        this.f54495y0 = LazyKt__LazyJVMKt.b(new Function0<ScreenRotationHelper>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$screenHelper$2

            /* JADX INFO: renamed from: com.transsion.player.longvideo.ui.LongVodPlayerView$screenHelper$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Boolean> {
                public AnonymousClass1(Object obj) {
                    super(0, obj, LongVodPlayerView.class, "isCloseAutoRotation", "isCloseAutoRotation()Z", 0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(((LongVodPlayerView) this.receiver).s0());
                }
            }

            /* JADX INFO: renamed from: com.transsion.player.longvideo.ui.LongVodPlayerView$screenHelper$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
                public AnonymousClass2(Object obj) {
                    super(1, obj, LongVodPlayerView.class, "autoScreenRotation", "autoScreenRotation(Z)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    ((LongVodPlayerView) this.receiver).y(z11);
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ScreenRotationHelper invoke() {
                Context context2 = this.this$0.getContext();
                Intrinsics.f(context2, "context");
                return new ScreenRotationHelper(context2, new AnonymousClass1(this.this$0), new AnonymousClass2(this.this$0));
            }
        });
        this.f54497z0 = new com.transsion.player.orplayer.e() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$playerListener$1
            @Override // com.transsion.player.orplayer.e
            public void initPlayer() {
                com.transsion.player.orplayer.e.a.a(this);
            }

            @Override // com.transsion.player.orplayer.e
            public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
                com.transsion.postdetail.layer.local.o oVar = this.f54510a.T;
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
                this.f54510a.q1(false);
                this.f54510a.o1(false);
                this.f54510a.setPauseViewStatus(false);
                com.transsion.player.orplayer.e.a.y(this, this.f54510a.f54474o, null, 2, null);
                com.transsion.postdetail.layer.local.o oVar = this.f54510a.T;
                if (oVar != null) {
                    oVar.h();
                }
                uo.b.f78622a.c(LongVodPlayerView.TAG, "onCompletion", true);
                LongVodPlayerViewAdHelper longVodPlayerViewAdHelper = this.f54510a.getLongVodPlayerViewAdHelper();
                final LongVodPlayerView longVodPlayerView = this.f54510a;
                longVodPlayerViewAdHelper.K1(new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$playerListener$1$onCompletion$1
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
                        kv.a.b bVar = longVodPlayerView.V;
                        if (bVar != null) {
                            bVar.onCompletion();
                        }
                        if (longVodPlayerView.f54460h == LongVodPageType.TRAILER) {
                            longVodPlayerView.e1();
                            longVodPlayerView.showReplay();
                        }
                    }
                });
            }

            @Override // com.transsion.player.orplayer.e
            public void onFocusChange(boolean z11) {
                com.transsion.player.orplayer.e.a.f(this, z11);
            }

            @Override // com.transsion.player.orplayer.e
            public void onIsPlayingChanged(boolean z11) {
                LongVodSubtitleHelper longVodSubtitleHelper = this.f54510a.W;
                if (longVodSubtitleHelper != null) {
                    longVodSubtitleHelper.F(z11);
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingBegin(MediaSource mediaSource) {
                lv.c cVar;
                this.f54510a.f54482s = false;
                com.transsion.postdetail.layer.local.o oVar = this.f54510a.T;
                if (oVar != null) {
                    oVar.i();
                }
                if (com.tn.lib.util.networkinfo.f.f49475a.e() || (cVar = this.f54510a.I) == null || !cVar.h()) {
                    this.f54510a.O0();
                    this.f54510a.o1(true);
                } else {
                    uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onLoadingBegin， not net----", false, 4, null);
                    LongVodPlayerView.g1(this.f54510a, false, 1, null);
                }
                uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onLoadingBegin", false, 4, null);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingEnd(MediaSource mediaSource) {
                this.f54510a.f54482s = false;
                this.f54510a.O0();
                this.f54510a.o1(false);
                com.transsion.postdetail.layer.local.o oVar = this.f54510a.T;
                if (oVar != null) {
                    oVar.j();
                }
                uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onLoadingEnd", false, 4, null);
                this.f54510a.M.removeCallbacksAndMessages(null);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingProgress(int i12, float f11, MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.l(this, i12, f11, mediaSource);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoopingStart() {
                uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onLoopingStart", false, 4, null);
            }

            @Override // com.transsion.player.orplayer.e
            public void onMediaItemTransition(String str) {
                com.transsion.player.orplayer.e.a.o(this, str);
            }

            @Override // com.transsion.player.orplayer.e
            public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
                Intrinsics.g(errorInfo, "errorInfo");
                this.f54510a.U0();
                com.transsion.postdetail.layer.local.o oVar = this.f54510a.T;
                if (oVar != null) {
                    oVar.l(errorInfo);
                }
                boolean zE = com.tn.lib.util.networkinfo.f.f49475a.e();
                uo.b.f78622a.c(LongVodPlayerView.TAG, "onPlayError， hasNet:" + zE + ", code:" + errorInfo.getErrorCode() + ", msg:" + errorInfo.getErrorMessage(), true);
                this.f54510a.f1(zE ^ true);
            }

            @Override // com.transsion.player.orplayer.e
            public void onPlayerRelease(MediaSource mediaSource) {
                com.transsion.player.orplayer.e.a.s(this, mediaSource);
                if (this.f54510a.v0()) {
                    Context context2 = this.f54510a.getContext();
                    AppCompatActivity appCompatActivity = context2 instanceof AppCompatActivity ? (AppCompatActivity) context2 : null;
                    if (appCompatActivity != null) {
                        appCompatActivity.finish();
                    }
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onPlayerReset() {
                uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onPlayerReset", false, 4, null);
                this.f54510a.f54482s = false;
                this.f54510a.f54474o = 0L;
                this.f54510a.f54476p = 0L;
                this.f54510a.getLongVodPlayerViewAdHelper().L1();
            }

            @Override // com.transsion.player.orplayer.e
            public void onPrepare(MediaSource mediaSource) {
                this.f54510a.U0();
                this.f54510a.F = true;
                LongVodPlayerView longVodPlayerView = this.f54510a;
                longVodPlayerView.f54474o = longVodPlayerView.f54456f.getDuration();
                uo.b.f78622a.c(LongVodPlayerView.TAG, "onPrepare， totalDuration:" + this.f54510a.f54474o, true);
                this.f54510a.f54447a.f71243p.f71290m.setMax(this.f54510a.f54474o);
                this.f54510a.f54447a.f71242o.f71272t.setMax(this.f54510a.f54474o);
                LongVodPlayerViewAdHelper longVodPlayerViewAdHelper = this.f54510a.getLongVodPlayerViewAdHelper();
                final LongVodPlayerView longVodPlayerView2 = this.f54510a;
                longVodPlayerViewAdHelper.F2(new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$playerListener$1$onPrepare$1
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
                        uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "---> showStartAd end", false, 4, null);
                        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper2 = longVodPlayerView2.getLongVodPlayerViewAdHelper();
                        long j11 = longVodPlayerView2.f54474o;
                        final LongVodPlayerView longVodPlayerView3 = longVodPlayerView2;
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$playerListener$1$onPrepare$1.1
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
                                uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "-----> checkShowRewardIntercept end", false, 4, null);
                                longVodPlayerView3.B0();
                                longVodPlayerView3.n0();
                                longVodPlayerView3.B = false;
                            }
                        };
                        final LongVodPlayerView longVodPlayerView4 = longVodPlayerView2;
                        Function0<Unit> function1 = new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$playerListener$1$onPrepare$1.2
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
                                longVodPlayerView4.D0();
                            }
                        };
                        final LongVodPlayerView longVodPlayerView5 = longVodPlayerView2;
                        longVodPlayerViewAdHelper2.L0(j11, function0, function1, new Function1<Boolean, Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$playerListener$1$onPrepare$1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(boolean z11) {
                                uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "-----> checkShowInterpolateAd --> onRewardUnlock", false, 4, null);
                                longVodPlayerView5.E0();
                                if (!z11) {
                                    longVodPlayerView5.f54456f.play();
                                    return;
                                }
                                longVodPlayerView5.B0();
                                longVodPlayerView5.n0();
                                longVodPlayerView5.B = false;
                            }
                        });
                    }
                });
            }

            @Override // com.transsion.player.orplayer.e
            public void onProgress(long j11, MediaSource mediaSource) {
                if (this.f54510a.B && j11 == 0 && this.f54510a.f54476p > 0) {
                    uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onProgress, 正在切换分辨率，progress重置，不做处理", false, 4, null);
                } else {
                    this.f54510a.t1(j11);
                }
                com.transsion.postdetail.layer.local.o oVar = this.f54510a.T;
                if (oVar != null) {
                    oVar.m(j11);
                }
                this.f54510a.f54476p = j11;
                this.f54510a.f54478q = j11;
                com.transsion.player.longvideo.helper.c cVar = this.f54510a.f54455e0;
                if (cVar != null) {
                    cVar.e(j11, this.f54510a.f54474o);
                }
                LongVodSubtitleHelper longVodSubtitleHelper = this.f54510a.W;
                if (longVodSubtitleHelper != null) {
                    longVodSubtitleHelper.B(j11);
                }
                this.f54510a.f54447a.f71243p.f71290m.setMax(this.f54510a.f54474o);
                this.f54510a.f54447a.f71242o.f71272t.setMax(this.f54510a.f54474o);
                LongVodPlayerViewAdHelper longVodPlayerViewAdHelper = this.f54510a.getLongVodPlayerViewAdHelper();
                final LongVodPlayerView longVodPlayerView = this.f54510a;
                longVodPlayerViewAdHelper.K0(j11, new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$playerListener$1$onProgress$1
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
                        longVodPlayerView.f54456f.play();
                    }
                });
                this.f54510a.getLongVodPlayerViewAdHelper().H0(j11);
            }

            @Override // com.transsion.player.orplayer.e
            public void onRenderFirstFrame() {
                uo.b.f78622a.c(LongVodPlayerView.TAG, "onRenderFirstFrame", true);
                com.transsion.postdetail.layer.local.o oVar = this.f54510a.T;
                if (oVar != null) {
                    oVar.n();
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onSetDataSource() {
                com.transsion.player.orplayer.e.a.A(this);
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksAudioBitrateChange(int i12) {
                com.transsion.postdetail.layer.local.o oVar = this.f54510a.T;
                if (oVar != null) {
                    oVar.t(i12);
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksChange(ov.c tracks) {
                ImmutableList<ov.d> immutableListA;
                com.transsion.postdetail.layer.local.o oVar;
                Intrinsics.g(tracks, "tracks");
                com.transsion.player.orplayer.e.a.C(this, tracks);
                lv.a aVar = this.f54510a.H;
                if ((aVar == null || !aVar.t()) && (immutableListA = tracks.a()) != null && !immutableListA.isEmpty() && this.f54510a.f54469l0) {
                    this.f54510a.f54469l0 = false;
                    this.f54510a.f54471m0.clear();
                    uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onTracksChange, tracks =\n " + tracks, false, 4, null);
                    ImmutableList<ov.d> immutableListA2 = tracks.a();
                    LongVodPlayerView longVodPlayerView = this.f54510a;
                    for (ov.d dVar : immutableListA2) {
                        if (dVar.e() == 2) {
                            longVodPlayerView.f54465j0 = dVar;
                            for (ov.b bVar : dVar.b()) {
                                longVodPlayerView.f54471m0.add(new lv.b(false, bVar.c() + "P", LongVodPlayerConfigType.BITRATE));
                            }
                        }
                    }
                    lv.a aVar2 = this.f54510a.H;
                    if ((aVar2 != null ? aVar2.s() : null) != PlayMimeType.HLS || (oVar = this.f54510a.T) == null) {
                        return;
                    }
                    oVar.J(this.f54510a.f54471m0.size() > 1 ? PrepareException.ERROR_NO_URL : "5");
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksVideoBitrateChange(int i12) {
                com.transsion.postdetail.layer.local.o oVar = this.f54510a.T;
                if (oVar != null) {
                    oVar.u(i12);
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoPause(MediaSource mediaSource) {
                this.f54510a.q1(false);
                com.transsion.postdetail.layer.local.o oVar = this.f54510a.T;
                if (oVar != null) {
                    oVar.v();
                }
                uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onVideoPause", false, 4, null);
                this.f54510a.y0(false);
                com.transsion.player.longvideo.helper.c cVar = this.f54510a.f54455e0;
                if (cVar != null) {
                    cVar.d();
                }
                this.f54510a.setPauseViewStatus(false);
                if (this.f54510a.f54489v0 || this.f54510a.f54493x0) {
                    return;
                }
                LongVodPlayerView.d1(this.f54510a, false, 1, null);
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoSizeChanged(int i12, int i13) {
                this.f54510a.f54472n = i12;
                this.f54510a.f54470m = i13;
                com.transsion.player.longvideo.helper.h hVar = this.f54510a.f54448a0;
                if (hVar != null) {
                    hVar.b(i12, i13);
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoStart(MediaSource mediaSource) {
                lv.c cVar;
                com.transsion.player.longvideo.helper.r rVar;
                if (this.f54510a.f54493x0) {
                    this.f54510a.f54456f.pause();
                    return;
                }
                this.f54510a.q1(true);
                com.transsion.player.longvideo.helper.r rVar2 = this.f54510a.f54454d0;
                if (rVar2 != null) {
                    rVar2.A();
                }
                this.f54510a.f54488v = false;
                this.f54510a.N();
                this.f54510a.U0();
                com.transsion.postdetail.layer.local.o oVar = this.f54510a.T;
                if (oVar != null) {
                    oVar.w();
                }
                uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "onVideoStart", false, 4, null);
                this.f54510a.hideBottomController(false);
                this.f54510a.setPauseViewStatus(true);
                this.f54510a.y0(true);
                this.f54510a.O0();
                this.f54510a.o1(false);
                com.transsion.player.longvideo.helper.c cVar2 = this.f54510a.f54455e0;
                if (cVar2 != null) {
                    cVar2.f();
                }
                if (this.f54510a.f54494y) {
                    this.f54510a.f54494y = false;
                    LongVodPlayerView longVodPlayerView = this.f54510a;
                    String string = Utils.a().getString(R$string.long_vod_load_us_cellular);
                    Intrinsics.f(string, "getApp().getString(R.str…ong_vod_load_us_cellular)");
                    longVodPlayerView.n1(string);
                }
                com.tn.lib.util.networkinfo.f fVar = com.tn.lib.util.networkinfo.f.f49475a;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                if (fVar.h(applicationA) && (cVar = this.f54510a.I) != null && cVar.h() && (rVar = this.f54510a.f54454d0) != null) {
                    rVar.z();
                }
                this.f54510a.getLongVodPlayerViewAdHelper().V1();
                MusicFloatManager.f51403i.b().z(mediaSource != null ? mediaSource.h() : null);
            }

            @Override // com.transsion.player.orplayer.e
            public void setOnSeekCompleteListener() {
                com.transsion.player.orplayer.e.a.J(this);
            }
        };
        this.B0 = new Runnable() { // from class: com.transsion.player.longvideo.ui.r
            @Override // java.lang.Runnable
            public final void run() {
                LongVodPlayerView.X0(this.f54589a);
            }
        };
        this.C0 = new e();
        this.D0 = new Runnable() { // from class: com.transsion.player.longvideo.ui.s
            @Override // java.lang.Runnable
            public final void run() {
                LongVodPlayerView.I0(this.f54590a);
            }
        };
        this.F0 = LazyKt__LazyJVMKt.b(new Function0<com.transsion.postdetail.util.j>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$orientationEventListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsion.postdetail.util.j invoke() {
                Context context2 = this.this$0.getContext();
                Intrinsics.e(context2, "null cannot be cast to non-null type android.app.Activity");
                return new com.transsion.postdetail.util.j((Activity) context2, new Function1<Integer, Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$orientationEventListener$2$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(int i12) {
                    }
                });
            }
        });
    }

    public static /* synthetic */ void A(LongVodPlayerView longVodPlayerView, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        longVodPlayerView.z(z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(boolean z11, boolean z12) {
        if (z11) {
            c1(z12);
        } else {
            hideBottomController(z12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        if (this.f54459g0 > 0.0f) {
            k1(false);
            setSpeed(this.f54459g0);
            String str = this.f54464j;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.A0;
            lv.a aVar = this.H;
            com.transsion.baselib.utils.k.b(str, jElapsedRealtime, aVar != null ? aVar.m() : null, Float.valueOf(this.f54459g0));
            this.f54459g0 = 0.0f;
        }
    }

    private final void E(boolean z11, boolean z12) {
        if (z12) {
            if (this.f54466k == LongVodUiType.MIDDLE) {
                LongVodMiddleForwardViewControl localVideoMiddleForwardViewControl = getLocalVideoMiddleForwardViewControl();
                if (localVideoMiddleForwardViewControl != null) {
                    localVideoMiddleForwardViewControl.c(z11);
                }
            } else {
                LongVodLandForwardViewControl localVideoLandForwardViewControl = getLocalVideoLandForwardViewControl();
                if (localVideoLandForwardViewControl != null) {
                    localVideoLandForwardViewControl.b(z11);
                }
            }
        }
        long jH = z11 ? kotlin.ranges.a.h(this.f54478q + ((long) 10000), this.f54474o) : kotlin.ranges.a.e(this.f54478q - ((long) 10000), 0L);
        this.f54478q = jH;
        this.f54456f.seekTo(jH);
    }

    public static /* synthetic */ void F(LongVodPlayerView longVodPlayerView, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        longVodPlayerView.E(z11, z12);
    }

    public static final void I0(LongVodPlayerView this$0) {
        Intrinsics.g(this$0, "this$0");
        MediaSource mediaSource = this$0.f54477p0;
        if (mediaSource != null) {
            this$0.f54456f.reset();
            this$0.f54456f.stop();
            com.transsion.postdetail.layer.local.o oVar = this$0.T;
            if (oVar != null) {
                oVar.L(true);
            }
            uo.b.f78622a.c(TAG, "playerTimeout,change 2 software decoder, path = " + mediaSource.j(), true);
            this$0.f54456f.enableHardwareDecoder(false);
            this$0.f54456f.setDataSource(mediaSource);
            this$0.f54456f.prepare();
        }
    }

    private final void M(MotionEvent motionEvent, boolean z11) {
        LongVodUiType longVodUiType = this.f54466k;
        if ((longVodUiType != LongVodUiType.LAND && longVodUiType != LongVodUiType.MIDDLE) || !z11 || motionEvent == null) {
            L();
            return;
        }
        int iE = com.blankj.utilcode.util.d0.e() / 3;
        int rawX = (int) motionEvent.getRawX();
        boolean zF = so.c.f();
        if (rawX >= 0 && rawX <= iE) {
            F(this, zF, false, 2, null);
        } else if (rawX > iE * 2) {
            F(this, !zF, false, 2, null);
        } else {
            L();
        }
    }

    private final void M0() {
        this.f54492x = true;
        lv.a aVar = this.H;
        if (aVar != null) {
            O0();
            this.f54456f.stop();
            setDataSource(aVar);
        }
    }

    private final void N0() {
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        List<Fragment> fragments = ((FragmentActivity) context).getSupportFragmentManager().getFragments();
        Intrinsics.f(fragments, "context as FragmentActiv…FragmentManager.fragments");
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

    private final void O() {
        if (!this.f54482s) {
            ConstraintLayout root = this.f54447a.f71244q.getRoot();
            Intrinsics.f(root, "viewBinding.layoutTopToolBar.root");
            root.setVisibility(8);
        }
        kv.a.b bVar = this.V;
        if (bVar != null) {
            bVar.g(false);
        }
        AppCompatTextView appCompatTextView = this.f54447a.f71242o.f71265m;
        Intrinsics.f(appCompatTextView, "viewBinding.layoutLand.ivLock");
        appCompatTextView.setVisibility(8);
        ConstraintLayout constraintLayout = this.f54447a.f71242o.f71257d;
        Intrinsics.f(constraintLayout, "viewBinding.layoutLand.clBottomControl");
        constraintLayout.setVisibility(8);
        ConstraintLayout root2 = this.f54447a.f71242o.f71256c.getRoot();
        Intrinsics.f(root2, "viewBinding.layoutLand.centerControlLayout.root");
        root2.setVisibility(8);
        Group group = this.f54447a.f71242o.f71261i;
        Intrinsics.f(group, "viewBinding.layoutLand.groupControlPk");
        group.setVisibility(8);
        AppCompatTextView appCompatTextView2 = this.f54447a.f71242o.f71277y;
        Intrinsics.f(appCompatTextView2, "viewBinding.layoutLand.tvPlayNext");
        appCompatTextView2.setVisibility(8);
        View view = this.f54447a.f71242o.f71269q;
        Intrinsics.f(view, "viewBinding.layoutLand.landGradientTop");
        view.setVisibility(8);
        View view2 = this.f54447a.f71242o.f71268p;
        Intrinsics.f(view2, "viewBinding.layoutLand.landGradientBottom");
        view2.setVisibility(8);
        View view3 = this.f54447a.f71243p.f71287j;
        Intrinsics.f(view3, "viewBinding.layoutMiddle.middleGradientTop");
        view3.setVisibility(8);
        View view4 = this.f54447a.f71243p.f71286i;
        Intrinsics.f(view4, "viewBinding.layoutMiddle.middleGradientBottom");
        view4.setVisibility(8);
        LinearLayout linearLayout = this.f54447a.f71243p.f71285h;
        Intrinsics.f(linearLayout, "viewBinding.layoutMiddle.llMiddleBottomController");
        linearLayout.setVisibility(8);
    }

    private final void P() {
        if (!getPkStyle()) {
            this.f54447a.f71242o.f71265m.setText((CharSequence) null);
            this.f54447a.f71242o.f71276x.setText((CharSequence) null);
            TextView textView = this.f54447a.f71242o.f71278z;
            Intrinsics.f(textView, "viewBinding.layoutLand.tvPlayScale");
            so.c.g(textView);
        }
        ImmSpeedView immSpeedView = this.f54447a.f71242o.A;
        Intrinsics.f(immSpeedView, "viewBinding.layoutLand.tvPlaySpeed");
        ImmSpeedView.updateSpeed$default(immSpeedView, LocalVideoPlayerConfigMmkv.f51172a.c(), false, 2, null);
    }

    private final void Q0() {
        f0 f0Var = this.P;
        if (f0Var != null) {
            f0Var.d();
        }
    }

    private final void R() {
        if (x0()) {
            com.transsion.player.longvideo.helper.c cVar = new com.transsion.player.longvideo.helper.c(this.f54447a);
            cVar.a();
            this.f54455e0 = cVar;
        }
    }

    private final void S() {
        LongVodMiddleForwardViewControl.f55227b.f(this.f54447a);
        this.f54447a.f71243p.f71283f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.g0(this.f54591a, view);
            }
        });
        this.f54447a.f71248u.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.h0(this.f54577a, view);
            }
        });
        this.f54447a.f71244q.f71222b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.i0(this.f54578a, view);
            }
        });
        this.f54447a.f71243p.f71282d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.T(this.f54579a, view);
            }
        });
        this.f54447a.f71242o.f71264l.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.U(this.f54580a, view);
            }
        });
        this.f54447a.f71244q.f71224d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.V(this.f54581a, view);
            }
        });
        this.f54447a.f71244q.f71225f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.W(this.f54582a, view);
            }
        });
        this.f54447a.f71242o.f71273u.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.X(this.f54583a, view);
            }
        });
        this.f54447a.f71242o.f71277y.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.Y(this.f54584a, view);
            }
        });
        this.f54447a.f71242o.f71256c.f65266d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.Z(this.f54585a, view);
            }
        });
        this.f54447a.f71242o.f71256c.f65267f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.a0(this.f54592a, view);
            }
        });
        this.f54447a.f71242o.f71256c.f65265c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.b0(this.f54593a, view);
            }
        });
        this.f54447a.f71242o.f71267o.setOnModelChangeListener(new ImmScaleView.a() { // from class: com.transsion.player.longvideo.ui.w
            @Override // com.transsion.postdetail.ui.view.ImmScaleView.a
            public final void a(ScaleMode scaleMode, String str) {
                LongVodPlayerView.c0(this.f54594a, scaleMode, str);
            }
        });
        this.f54447a.f71242o.f71270r.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.d0(this.f54515a, view);
            }
        });
        this.f54447a.f71242o.f71265m.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.e0(this.f54516a, view);
            }
        });
        this.f54456f.setGestureListener(new b(so.c.f()));
        AppCompatImageView appCompatImageView = this.f54447a.f71243p.f71281c;
        Intrinsics.f(appCompatImageView, "viewBinding.layoutMiddle.ivFloat");
        appCompatImageView.setVisibility(w0() ? 0 : 8);
        this.f54447a.f71243p.f71281c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerView.f0(this.f54517a, view);
            }
        });
    }

    public static final void T(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        w1(this$0, null, false, 3, null);
    }

    public static final void U(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        iv.c.f67718a.a(this$0.f54464j, this$0.f54480r, false);
        w1(this$0, null, false, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0() {
        this.f54477p0 = null;
        com.transsion.postdetail.layer.local.o oVar = this.T;
        if (oVar != null) {
            oVar.L(false);
        }
        this.f54475o0.removeCallbacks(this.D0);
    }

    public static final void V(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.H0();
    }

    private final void V0() {
        if (this.C) {
            uo.b.f78622a.c(TAG, "player resetPlayer", true);
            this.f54492x = false;
            this.f54469l0 = true;
            com.transsion.player.longvideo.helper.h hVar = this.f54448a0;
            if (hVar != null) {
                hVar.c();
            }
            this.f54456f.reset();
            setPauseViewStatus(false);
        }
    }

    public static final void W(LongVodPlayerView this$0, View view) {
        Integer numP;
        Intrinsics.g(this$0, "this$0");
        Context context = this$0.getContext();
        String string = null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity != null) {
            PlayerSettingDialog playerSettingDialog = new PlayerSettingDialog();
            FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
            Intrinsics.f(supportFragmentManager, "it.supportFragmentManager");
            playerSettingDialog.show(supportFragmentManager, "PlayerSettingDialog");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        lv.a aVar = this$0.H;
        linkedHashMap.put("subject_id", aVar != null ? aVar.m() : null);
        lv.a aVar2 = this$0.H;
        linkedHashMap.put("subject_ops", aVar2 != null ? aVar2.o() : null);
        lv.a aVar3 = this$0.H;
        linkedHashMap.put("subject_name", aVar3 != null ? aVar3.n() : null);
        lv.a aVar4 = this$0.H;
        linkedHashMap.put("title_name", aVar4 != null ? aVar4.r() : null);
        lv.a aVar5 = this$0.H;
        if (aVar5 != null && (numP = aVar5.p()) != null) {
            string = numP.toString();
        }
        linkedHashMap.put("subject_type", string);
        linkedHashMap.put("module_name", "video_setting");
        String str = this$0.f54464j;
        if (str != null) {
            com.transsion.baselib.report.m.f51277a.m(str, "click", linkedHashMap);
        }
    }

    public static final void X(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.W0();
    }

    public static final void X0(LongVodPlayerView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.O();
    }

    public static final void Y(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        String str = this$0.f54464j;
        if (str == null) {
            str = "";
        }
        mVar.m(str, "click", this$0.getReportNextMap());
        kv.a.b bVar = this$0.V;
        if (bVar != null) {
            bVar.a();
        }
    }

    public static final void Z(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        iv.c.f67718a.a(this$0.f54464j, this$0.f54480r, true);
        w1(this$0, null, false, 3, null);
    }

    public static final void a0(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.S0(ToolBar.FORWARD);
        this$0.E(true, false);
        this$0.hideBottomController(false);
    }

    private final void a1() {
        Map<vx.a, Long> mapE;
        Map<vx.a, Long> mapE2;
        LongVodSubtitleHelper longVodSubtitleHelper = this.W;
        if (longVodSubtitleHelper != null) {
            com.transsion.postdetail.layer.local.o oVar = this.T;
            if (oVar != null && (mapE2 = oVar.e()) != null) {
                mapE2.clear();
            }
            com.transsion.postdetail.layer.local.o oVar2 = this.T;
            if (oVar2 == null || (mapE = oVar2.e()) == null) {
                return;
            }
            mapE.putAll(longVodSubtitleHelper.s());
        }
    }

    public static final void b0(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.S0(ToolBar.BACKWARD);
        this$0.hideBottomController(false);
        this$0.E(false, false);
    }

    public static final void c0(LongVodPlayerView this$0, ScaleMode scaleMode, String scaleModeName) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(scaleMode, "scaleMode");
        Intrinsics.g(scaleModeName, "scaleModeName");
        this$0.y1(scaleMode, scaleModeName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(boolean z11) {
        if (!this.f54482s && com.blankj.utilcode.util.c.j()) {
            if (this.f54447a.f71242o.f71265m.isSelected()) {
                AppCompatTextView appCompatTextView = this.f54447a.f71242o.f71265m;
                Intrinsics.f(appCompatTextView, "viewBinding.layoutLand.ivLock");
                AppCompatTextView appCompatTextView2 = this.f54447a.f71242o.f71265m;
                Intrinsics.f(appCompatTextView2, "viewBinding.layoutLand.ivLock");
                appCompatTextView.setVisibility((appCompatTextView2.getVisibility() == 0) ^ true ? 0 : 8);
                return;
            }
            AppCompatTextView appCompatTextView3 = this.f54447a.f71242o.f71265m;
            Intrinsics.f(appCompatTextView3, "viewBinding.layoutLand.ivLock");
            appCompatTextView3.setVisibility(0);
            if (z11) {
                hideBottomController(false);
            } else {
                this.M.removeCallbacks(this.B0);
            }
            ConstraintLayout constraintLayout = this.f54447a.f71242o.f71257d;
            Intrinsics.f(constraintLayout, "viewBinding.layoutLand.clBottomControl");
            constraintLayout.setVisibility(0);
            ConstraintLayout root = this.f54447a.f71242o.f71256c.getRoot();
            Intrinsics.f(root, "viewBinding.layoutLand.centerControlLayout.root");
            root.setVisibility(0);
            if (getPkStyle() && x0()) {
                Group group = this.f54447a.f71242o.f71261i;
                Intrinsics.f(group, "viewBinding.layoutLand.groupControlPk");
                group.setVisibility(0);
            }
            ConstraintLayout root2 = this.f54447a.f71244q.getRoot();
            Intrinsics.f(root2, "viewBinding.layoutTopToolBar.root");
            root2.setVisibility(0);
            kv.a.b bVar = this.V;
            if (bVar != null) {
                bVar.g(true);
            }
            View view = this.f54447a.f71242o.f71269q;
            Intrinsics.f(view, "viewBinding.layoutLand.landGradientTop");
            view.setVisibility(0);
            View view2 = this.f54447a.f71242o.f71268p;
            Intrinsics.f(view2, "viewBinding.layoutLand.landGradientBottom");
            view2.setVisibility(0);
            AppCompatTextView appCompatTextView4 = this.f54447a.f71242o.f71277y;
            Intrinsics.f(appCompatTextView4, "viewBinding.layoutLand.tvPlayNext");
            appCompatTextView4.setVisibility(this.A ? 0 : 8);
            View view3 = this.f54447a.f71243p.f71287j;
            Intrinsics.f(view3, "viewBinding.layoutMiddle.middleGradientTop");
            view3.setVisibility(0);
            LinearLayout linearLayout = this.f54447a.f71243p.f71285h;
            Intrinsics.f(linearLayout, "viewBinding.layoutMiddle.llMiddleBottomController");
            linearLayout.setVisibility(0);
            View view4 = this.f54447a.f71243p.f71286i;
            Intrinsics.f(view4, "viewBinding.layoutMiddle.middleGradientBottom");
            view4.setVisibility(0);
            R0();
            View viewFindViewById = findViewById(R.id.message);
            if (viewFindViewById == null) {
                return;
            }
            viewFindViewById.setVisibility(8);
        }
    }

    public static final void d0(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.f54447a.f71242o.f71267o.performClick();
    }

    public static /* synthetic */ void d1(LongVodPlayerView longVodPlayerView, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        longVodPlayerView.c1(z11);
    }

    public static final void e0(LongVodPlayerView this$0, View it) {
        String strM;
        Intrinsics.g(this$0, "this$0");
        it.setSelected(!it.isSelected());
        if (it.isSelected()) {
            Context context = this$0.getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).setRequestedOrientation(11);
            this$0.hideBottomController(true);
            Intrinsics.f(it, "it");
            so.c.k(it);
        } else {
            Context context2 = this$0.getContext();
            Intrinsics.e(context2, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context2).setRequestedOrientation(6);
            this$0.c1(true);
        }
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        String str = this$0.f54464j;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = new Pair("module_name", "lock");
        lv.a aVar = this$0.H;
        if (aVar != null && (strM = aVar.m()) != null) {
            str2 = strM;
        }
        pairArr[1] = new Pair("subject_id", str2);
        pairArr[2] = new Pair("type", it.isSelected() ? "1" : "0");
        mVar.m(str, "click", kotlin.collections.s.l(pairArr));
        com.transsion.postdetail.layer.local.o oVar = this$0.T;
        if (oVar != null) {
            oVar.E(it.isSelected());
        }
        this$0.f54456f.enableGesture(true ^ it.isSelected());
        if (this$0.getPkStyle()) {
            this$0.f54447a.f71242o.f71265m.setText(it.isSelected() ? this$0.getContext().getString(com.transsion.baseui.R$string.play_tap_unlock) : this$0.getContext().getString(com.transsion.baseui.R$string.play_tap_lock));
        }
    }

    public static final void f0(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        kv.a.b bVar = this$0.V;
        if (bVar != null) {
            bVar.c(FloatActionType.ICON);
        }
    }

    public static final void g0(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.G();
    }

    public static /* synthetic */ void g1(LongVodPlayerView longVodPlayerView, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        longVodPlayerView.f1(z11);
    }

    private final com.transsion.player.longvideo.ui.dialog.a getConfigViewModel() {
        return (com.transsion.player.longvideo.ui.dialog.a) this.f54461h0.getValue();
    }

    private final LongVodLandForwardViewControl getLocalVideoLandForwardViewControl() {
        View viewInflate;
        if (this.N == null && (viewInflate = this.f54447a.f71242o.F.inflate()) != null) {
            mv.a aVarA = mv.a.a(viewInflate);
            Intrinsics.f(aVarA, "bind(it)");
            this.N = new LongVodLandForwardViewControl(aVarA);
        }
        return this.N;
    }

    private final LongVodMiddleForwardViewControl getLocalVideoMiddleForwardViewControl() {
        View viewInflate;
        if (this.O == null && (viewInflate = this.f54447a.f71243p.f71293p.inflate()) != null) {
            mv.a aVarA = mv.a.a(viewInflate);
            Intrinsics.f(aVarA, "bind(it)");
            this.O = new LongVodMiddleForwardViewControl(aVarA);
        }
        return this.O;
    }

    private final com.transsion.postdetail.util.j getOrientationEventListener() {
        return (com.transsion.postdetail.util.j) this.F0.getValue();
    }

    private final int getPendingIntentFlag() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    private final boolean getPkStyle() {
        return ((Boolean) this.f54481r0.getValue()).booleanValue();
    }

    private final long getPlayTimeoutStream() {
        return ((Number) this.f54479q0.getValue()).longValue();
    }

    private final Map<String, String> getReportNextMap() {
        Pair[] pairArr = new Pair[2];
        pairArr[0] = new Pair("module_name", "play_next");
        lv.a aVar = this.H;
        pairArr[1] = new Pair("subject_id", aVar != null ? aVar.m() : null);
        return kotlin.collections.s.k(pairArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScreenRotationHelper getScreenHelper() {
        return (ScreenRotationHelper) this.f54495y0.getValue();
    }

    private final com.transsion.postdetail.ui.dialog.j getSpeedViewModel() {
        return (com.transsion.postdetail.ui.dialog.j) this.f54463i0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao getVideoDetailPlayDao() {
        return (VideoDetailPlayDao) this.U.getValue();
    }

    public static final void h0(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f54466k == LongVodUiType.LAND) {
            A(this$0, false, 1, null);
        } else {
            this$0.G();
        }
    }

    public static final void h1(View view) {
        NetworkUtils.w();
    }

    public static final void i0(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        A(this$0, false, 1, null);
    }

    public static final void i1(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        kv.a.b bVar = this$0.V;
        if ((bVar == null || !bVar.b()) && com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.M0();
        }
    }

    public static final void j1(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        A(this$0, false, 1, null);
    }

    private final void l0() {
        SecondariesSeekBar secondariesSeekBar = this.f54447a.f71242o.f71272t;
        Intrinsics.f(secondariesSeekBar, "viewBinding.layoutLand.seekBarLand");
        m0(secondariesSeekBar);
        SecondariesSeekBar secondariesSeekBar2 = this.f54447a.f71243p.f71290m;
        Intrinsics.f(secondariesSeekBar2, "viewBinding.layoutMiddle.seekBarMiddle");
        m0(secondariesSeekBar2);
    }

    public static /* synthetic */ void l1(LongVodPlayerView longVodPlayerView, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        longVodPlayerView.k1(z11);
    }

    public static final void m1(LongVodPlayerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.x1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1(String str) {
        if (this.Q == null) {
            this.Q = this.f54447a.D.inflate();
            p0();
            View view = this.Q;
            Intrinsics.d(view);
            TextView textView = (TextView) view.findViewById(R$id.tv_toast_1);
            View view2 = this.Q;
            Intrinsics.d(view2);
            this.P = new f0(textView, (TextView) view2.findViewById(R$id.tv_toast_2));
        }
        f0 f0Var = this.P;
        if (f0Var != null) {
            f0.i(f0Var, str, 0L, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(boolean z11) {
        if (this.f54484t == z11) {
            return;
        }
        this.f54484t = z11;
        if (!z11) {
            uo.b.a.f(uo.b.f78622a, TAG, "showVideoLoading gone", false, 4, null);
            z0(false);
        } else {
            if (this.f54486u) {
                return;
            }
            O0();
            z0(true);
            uo.b.a.f(uo.b.f78622a, TAG, "showVideoLoading visible", false, 4, null);
        }
    }

    private final void q0() {
        com.transsion.postdetail.layer.local.o oVar;
        ConstraintLayout root = this.f54447a.f71242o.getRoot();
        Intrinsics.f(root, "viewBinding.layoutLand.root");
        so.c.g(root);
        this.f54448a0 = new com.transsion.player.longvideo.helper.h(this.f54447a);
        LiveData<lv.b> liveDataB = getConfigViewModel().b();
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        liveDataB.j((FragmentActivity) context, new f(new Function1<lv.b, Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$initViewData$1

            /* JADX INFO: compiled from: source.java */
            @Metadata
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f54509a;

                static {
                    int[] iArr = new int[LongVodPlayerConfigType.values().length];
                    try {
                        iArr[LongVodPlayerConfigType.BITRATE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LongVodPlayerConfigType.SPEED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f54509a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(lv.b bVar) {
                invoke2(bVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(lv.b selectedBean) {
                int i11 = a.f54509a[selectedBean.a().ordinal()];
                if (i11 == 1) {
                    LongVodPlayerView longVodPlayerView = this.this$0;
                    Intrinsics.f(selectedBean, "selectedBean");
                    longVodPlayerView.C0(selectedBean);
                } else {
                    if (i11 != 2) {
                        return;
                    }
                    LongVodPlayerView longVodPlayerView2 = this.this$0;
                    Intrinsics.f(selectedBean, "selectedBean");
                    longVodPlayerView2.G0(selectedBean);
                }
            }
        }));
        LiveData<Float> liveDataB2 = getSpeedViewModel().b();
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        liveDataB2.j((FragmentActivity) context2, new f(new Function1<Float, Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$initViewData$2
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
                LongVodPlayerView longVodPlayerView = this.this$0;
                Intrinsics.f(it, "it");
                longVodPlayerView.setSpeed(it.floatValue());
            }
        }));
        post(new Runnable() { // from class: com.transsion.player.longvideo.ui.o
            @Override // java.lang.Runnable
            public final void run() {
                LongVodPlayerView.r0(this.f54586a);
            }
        });
        if (x0() || v0()) {
            this.T = new com.transsion.postdetail.layer.local.o();
            if (v0() && (oVar = this.T) != null) {
                oVar.D("music_play");
            }
        }
        com.transsion.postdetail.layer.local.o oVar2 = this.T;
        if (oVar2 != null) {
            oVar2.g();
        }
        com.transsion.postdetail.layer.local.o oVar3 = this.T;
        if (oVar3 != null) {
            oVar3.H(this.f54456f);
        }
        if (v0()) {
            this.f54447a.f71244q.f71225f.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(boolean z11) {
        if (v0()) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            Context context = getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null && !fragmentActivity.isDestroyed() && !fragmentActivity.isFinishing()) {
                VideoPipManager.Companion companion2 = VideoPipManager.f60024a;
                if (companion2.a().b() && RoomAppMMKV.f51271a.a().getBoolean("k_pip_enable", true)) {
                    VideoPipManager videoPipManagerA = companion2.a();
                    ViewParent parent = getParent();
                    Result.m163constructorimpl(videoPipManagerA.i(fragmentActivity, false, z11, parent instanceof ViewGroup ? (ViewGroup) parent : null));
                }
            }
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public static final void r0(LongVodPlayerView this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(boolean z11, long j11) {
        this.f54486u = z11;
        if (u0()) {
            AppCompatTextView appCompatTextView = this.f54447a.f71249v;
            Intrinsics.f(appCompatTextView, "viewBinding.tvCenterProgress");
            so.c.g(appCompatTextView);
            return;
        }
        if (z11) {
            this.f54447a.f71249v.setVisibility(0);
            this.f54447a.f71249v.setText(Html.fromHtml(Utils.a().getString(R$string.long_vod_progress_tx_style, com.transsion.postdetail.util.i.d(j11), com.transsion.postdetail.util.i.d(this.f54474o))));
            LongVodSubtitleHelper longVodSubtitleHelper = this.W;
            if (longVodSubtitleHelper != null) {
                longVodSubtitleHelper.I(j11);
            }
            z0(false);
            uo.b.a.f(uo.b.f78622a, TAG, "updateSeekbar loading gone", false, 4, null);
            return;
        }
        LongVodSubtitleHelper longVodSubtitleHelper2 = this.W;
        if (longVodSubtitleHelper2 != null) {
            longVodSubtitleHelper2.C();
        }
        AppCompatTextView appCompatTextView2 = this.f54447a.f71249v;
        Intrinsics.f(appCompatTextView2, "viewBinding.tvCenterProgress");
        so.c.g(appCompatTextView2);
        uo.b.a.f(uo.b.f78622a, TAG, "updateSeekbar loading " + this.f54484t, false, 4, null);
        z0(this.f54484t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s0() {
        return VideoPipManager.f60024a.a().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPauseViewStatus(boolean z11) {
        this.f54447a.f71242o.f71264l.setTag(Boolean.valueOf(z11));
        this.f54447a.f71243p.f71282d.setTag(Boolean.valueOf(z11));
        uo.b.a.f(uo.b.f78622a, TAG, "setPauseViewStatus playing = " + z11, false, 4, null);
        if (z11) {
            this.f54447a.f71242o.f71264l.setImageResource(R$mipmap.icon_player_pause);
            this.f54447a.f71242o.f71256c.f65266d.setImageResource(R$drawable.ic_player_pause);
            this.f54447a.f71243p.f71282d.setImageResource(R$mipmap.icon_player_pause);
        } else {
            this.f54447a.f71242o.f71264l.setImageResource(R$mipmap.icon_player_play);
            this.f54447a.f71242o.f71256c.f65266d.setImageResource(R$drawable.ic_player_play);
            this.f54447a.f71243p.f71282d.setImageResource(R$mipmap.icon_player_play);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPlayerDataSourceAdPrepare(lv.c cVar) {
        LinkedHashMap linkedHashMap;
        lv.c cVar2;
        this.R = cVar;
        if (cVar.d().length() > 0) {
            linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("cookie", cVar.d());
        } else {
            linkedHashMap = null;
        }
        MediaSource mediaSource = new MediaSource(String.valueOf(com.transsion.baselib.utils.i.f(cVar.f()).hashCode()), cVar.f(), 0, cVar.a(), I(cVar), 4, null);
        MusicFloatManager.a aVar = MusicFloatManager.f51403i;
        aVar.b().A(mediaSource.e());
        aVar.b().z(mediaSource.h());
        mediaSource.n(linkedHashMap);
        uo.b.a aVar2 = uo.b.f78622a;
        lv.a aVar3 = this.H;
        Integer numValueOf = aVar3 != null ? Integer.valueOf(aVar3.k()) : null;
        lv.a aVar4 = this.H;
        Integer numValueOf2 = aVar4 != null ? Integer.valueOf(aVar4.d()) : null;
        aVar2.c(TAG, "setPlayerDataSourceAdPrepare,  se:" + numValueOf + " ep:" + numValueOf2 + ", resolution:" + cVar.c() + "，id：" + mediaSource.e() + ",url:" + cVar.f(), true);
        U0();
        this.f54477p0 = mediaSource;
        this.f54456f.clearScreen();
        this.f54456f.setDataSource(mediaSource);
        this.f54456f.prepare();
        this.f54475o0.postDelayed(this.D0, getPlayTimeoutStream());
        com.tn.lib.util.networkinfo.f fVar = com.tn.lib.util.networkinfo.f.f49475a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        if (!fVar.h(applicationA) || (cVar2 = this.I) == null || !cVar2.h() || nv.a.f72164a.b()) {
            return;
        }
        K();
    }

    private final boolean t0() {
        boolean z11 = this.f54466k == LongVodUiType.LAND && this.f54447a.f71242o.f71258f.getVisibility() == 0;
        this.f54457f0 = z11;
        return z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(long j11) {
        LongVodSubtitleHelper longVodSubtitleHelper = this.W;
        if (longVodSubtitleHelper != null) {
            longVodSubtitleHelper.I(j11);
        }
        if (this.f54474o <= 0) {
            this.f54474o = this.f54456f.getDuration();
        }
        if (!this.f54490w) {
            long j12 = this.f54474o;
            if (j12 > 0) {
                int i11 = (int) ((j11 / j12) * j12);
                if (!this.f54486u) {
                    long j13 = i11;
                    this.f54447a.f71242o.f71272t.setProgress(j13);
                    this.f54447a.f71243p.f71290m.setProgress(j13);
                }
            }
        }
        if (this.f54474o >= 0) {
            String strD = com.transsion.postdetail.util.i.d(j11);
            String strD2 = com.transsion.postdetail.util.i.d(this.f54474o);
            this.f54447a.f71242o.f71274v.setText(strD);
            this.f54447a.f71242o.f71275w.setText(strD2);
            TextView textView = this.f54447a.f71243p.f71291n;
            String str = strD + "/" + strD2;
            Intrinsics.f(str, "toString(...)");
            textView.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u0() {
        View view = this.J;
        return (view == null || view == null || view.getVisibility() != 0) ? false : true;
    }

    private final boolean w0() {
        return (!this.E || this.f54460h == LongVodPageType.MUSIC || this.f54473n0) ? false : true;
    }

    public static /* synthetic */ void w1(LongVodPlayerView longVodPlayerView, MotionEvent motionEvent, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            motionEvent = null;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        longVodPlayerView.v1(motionEvent, z11);
    }

    private final void x1() {
        com.transsion.postdetail.layer.local.o oVar = this.T;
        if (oVar != null) {
            oVar.o();
        }
        View view = this.K;
        if (view != null) {
            so.c.g(view);
        }
        this.f54456f.seekTo(0L);
        this.f54456f.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(boolean z11) {
        LongVodUiType longVodUiType = this.f54466k;
        LongVodUiType longVodUiType2 = this.f54468l;
        boolean z12 = this.f54496z;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("旋转to竖屏: ");
        sb2.append(z11);
        sb2.append("，curUiType：");
        sb2.append(longVodUiType);
        sb2.append("，curUiRation: ");
        sb2.append(longVodUiType2);
        sb2.append(", resume:");
        sb2.append(z12);
        if (this.f54447a.f71242o.f71265m.isSelected()) {
            return;
        }
        LongVodUiType longVodUiType3 = z11 ? LongVodUiType.MIDDLE : LongVodUiType.LAND;
        if (!this.f54496z || this.f54468l == longVodUiType3 || longVodUiType3 == this.f54466k) {
            this.f54468l = longVodUiType3;
            return;
        }
        this.f54468l = longVodUiType3;
        com.transsion.baselib.report.m.f51277a.n("auto_screen", kotlin.collections.r.f(new Pair("orientation", longVodUiType3 == LongVodUiType.LAND ? "land" : "port")));
        if (!z11) {
            G();
        } else {
            N0();
            z(false);
        }
    }

    private final void z0(boolean z11) {
        ProgressBar progressBar = this.f54447a.f71242o.f71256c.f65268g;
        Intrinsics.f(progressBar, "viewBinding.layoutLand.c…ControlLayout.progressBar");
        progressBar.setVisibility(z11 ? 0 : 8);
        AppCompatImageView appCompatImageView = this.f54447a.f71242o.f71256c.f65266d;
        Intrinsics.f(appCompatImageView, "viewBinding.layoutLand.c…ntrolLayout.ivCenterPause");
        appCompatImageView.setVisibility(z11 ^ true ? 0 : 8);
        LinearLayout root = this.f54447a.f71243p.f71284g.getRoot();
        Intrinsics.f(root, "viewBinding.layoutMiddle.layoutLoading.root");
        root.setVisibility(z11 ? 0 : 8);
        if (z11) {
            AppCompatImageView appCompatImageView2 = this.f54447a.f71242o.f71256c.f65266d;
            Intrinsics.f(appCompatImageView2, "viewBinding.layoutLand.c…ntrolLayout.ivCenterPause");
            so.c.h(appCompatImageView2);
        }
    }

    public final void A0() {
        if (!this.f54456f.isPlaying() || this.f54447a.f71242o.f71265m.isSelected()) {
            return;
        }
        float fC = LocalVideoPlayerConfigMmkv.f51172a.c();
        this.f54459g0 = fC;
        this.f54456f.setSpeed(fC * 2);
        l1(this, false, 1, null);
        this.A0 = SystemClock.elapsedRealtime();
        String str = this.f54464j;
        lv.a aVar = this.H;
        com.transsion.baselib.utils.k.a(str, aVar != null ? aVar.m() : null, Float.valueOf(this.f54459g0));
    }

    public final void B0() {
        lv.c cVar;
        if (!this.f54492x && !this.B) {
            String string = Utils.a().getString(R$string.long_vod_analysing_from);
            String[] stringArray = Utils.a().getResources().getStringArray(R$array.long_vod_analysing_array);
            Intrinsics.f(stringArray, "getApp().resources.getSt…long_vod_analysing_array)");
            n1(string + " [" + kotlin.collections.d.r0(stringArray, Random.Default) + "]");
        }
        com.tn.lib.util.networkinfo.f fVar = com.tn.lib.util.networkinfo.f.f49475a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        boolean z11 = fVar.h(applicationA) && (cVar = this.I) != null && cVar.h();
        t1(0L);
        J0();
        if (!this.f54496z) {
            uo.b.f78622a.c(TAG, "----onPrepare2PlayVideo, pause video", true);
            this.f54456f.pause();
            o1(false);
        } else {
            if (z11 && this.f54494y) {
                uo.b.f78622a.c(TAG, "----onPrepare2PlayVideo, showMobileDataTips pause", true);
                return;
            }
            N();
            uo.b.f78622a.c(TAG, "onPrepare2PlayVideo, play", true);
            this.f54456f.play();
        }
    }

    public final void C() {
        com.transsion.player.longvideo.helper.g gVar = new com.transsion.player.longvideo.helper.g();
        gVar.c(this.f54464j, this.f54447a);
        this.f54452c0 = gVar;
        this.f54454d0 = new com.transsion.player.longvideo.helper.r(this.f54447a, new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$createHelper$2
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
                Context context = this.this$0.getContext();
                Intrinsics.f(context, "context");
                if (!com.transsion.baseui.util.b.a(context)) {
                    this.this$0.getScreenHelper().g();
                }
                LongVodPlayerView.w1(this.this$0, null, false, 3, null);
            }
        });
    }

    public final void C0(lv.b bVar) {
        int i11;
        Iterator<lv.b> it = this.f54471m0.iterator();
        while (true) {
            i11 = 0;
            if (!it.hasNext()) {
                break;
            }
            lv.b next = it.next();
            if (next.c()) {
                next.d(false);
                break;
            }
        }
        int i12 = 0;
        for (lv.b bVar2 : this.f54471m0) {
            int i13 = i12 + 1;
            if (Intrinsics.b(bVar.b(), bVar2.b())) {
                bVar2.d(true);
                this.f54447a.f71242o.f71273u.setText(bVar2.b());
                i11 = i12;
                break;
            }
            i12 = i13;
        }
        uo.b.f78622a.c(TAG, "onResolutionChange, content = " + bVar.b() + ", selectedIndex = " + i11, true);
        lv.a aVar = this.H;
        if (aVar != null) {
            com.transsion.postdetail.layer.local.o oVar = this.T;
            if (oVar != null) {
                oVar.K(bVar.b());
            }
            if (!aVar.t()) {
                ov.d dVar = this.f54465j0;
                if (dVar != null) {
                    this.f54456f.changeTrackSelection(dVar, i11);
                    return;
                }
                return;
            }
            lv.c cVarD = this.f54450b0.d(aVar, bVar);
            if (cVarD != null) {
                this.f54450b0.f(cVarD.c());
                lv.a aVar2 = this.H;
                if (aVar2 != null) {
                    aVar2.u(this.f54456f.getCurrentPosition());
                }
                this.B = true;
                V0();
                setPlayerDataSourceAdPrepare(cVarD);
            }
        }
    }

    public final void D0() {
        uo.b.a.f(uo.b.f78622a, TAG, " ---> onRewardInterceptShow", false, 4, null);
        this.f54493x0 = true;
        this.f54482s = true;
        hideBottomController(true);
        LinearLayout root = this.f54447a.f71243p.f71284g.getRoot();
        Intrinsics.f(root, "viewBinding.layoutMiddle.layoutLoading.root");
        so.c.g(root);
        ConstraintLayout root2 = this.f54447a.f71244q.getRoot();
        Intrinsics.f(root2, "viewBinding.layoutTopToolBar.root");
        so.c.k(root2);
        b1();
        if (this.f54456f.isPlaying()) {
            this.f54456f.pause();
        }
    }

    public final void E0() {
        uo.b.a.f(uo.b.f78622a, TAG, " ---> onRewardUnlock", false, 4, null);
        this.f54491w0 = true;
        this.f54493x0 = false;
        this.f54482s = false;
        b1();
    }

    public final void F0() {
        ConstraintLayout root = this.f54447a.f71244q.getRoot();
        Intrinsics.f(root, "viewBinding.layoutTopToolBar.root");
        if (root.getVisibility() == 0) {
            uo.b.a.f(uo.b.f78622a, TAG, "onSingleTap hideBottomController ", false, 4, null);
            hideBottomController(true);
        } else {
            uo.b.a.f(uo.b.f78622a, TAG, "onSingleTap showBottomController ", false, 4, null);
            d1(this, false, 1, null);
        }
    }

    public final void G() {
        View view;
        if (!this.f54456f.isPlaying() && !this.f54456f.isComplete() && !u0() && !this.f54489v0 && !this.f54493x0) {
            this.f54456f.play();
            View view2 = this.K;
            if (view2 != null) {
                Intrinsics.d(view2);
                if (so.c.i(view2) && (view = this.K) != null) {
                    so.c.g(view);
                }
            }
        }
        com.transsion.videofloat.a.f60027a.a();
        this.f54466k = LongVodUiType.LAND;
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        ImmersionBar.with(fragmentActivity).hideBar(BarHide.FLAG_HIDE_BAR).init();
        fragmentActivity.setRequestedOrientation(6);
        this.f54447a.f71253z.setPadding(0, 0, 0, 0);
        Y0(true, this.f54466k);
    }

    public final void G0(lv.b bVar) {
        Float fK = kotlin.text.j.k(bVar.b());
        if (fK != null) {
            this.f54456f.setSpeed(fK.floatValue());
        }
    }

    public final Intent H(lv.c cVar, String str) {
        Intent intent = new Intent();
        intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "/playvideo/music_detail");
        lv.a aVar = this.H;
        intent.putExtra("id", aVar != null ? aVar.m() : null);
        intent.putExtra("isMusicLikedFragment", this.E0);
        return intent;
    }

    public final void H0() {
        kv.a.b bVar = this.V;
        if (bVar != null) {
            bVar.d(this.H);
        }
    }

    public final MediaItem I(lv.c cVar) {
        LongVodPageType longVodPageType = this.f54460h;
        LongVodPageType longVodPageType2 = LongVodPageType.MUSIC;
        if (longVodPageType != longVodPageType2) {
            return null;
        }
        lv.a aVar = this.H;
        String strR = aVar != null ? aVar.r() : null;
        lv.a aVar2 = this.H;
        String strM = aVar2 != null ? aVar2.m() : null;
        lv.a aVar3 = this.H;
        String strC = aVar3 != null ? aVar3.c() : null;
        PendingIntent pendingIntentJ = J(cVar);
        Intent intentH = H(cVar, "media_music_float_notification");
        MusicFloatManager musicFloatManagerB = MusicFloatManager.f51403i.b();
        lv.a aVar4 = this.H;
        String strR2 = musicFloatManagerB.r(aVar4 != null ? aVar4.m() : null);
        boolean z11 = this.f54460h == longVodPageType2;
        String str = this.f54464j;
        lv.a aVar5 = this.H;
        return new MediaItem(strR, "", strC, null, null, null, pendingIntentJ, intentH, strM, strR2, Boolean.valueOf(z11), str, null, aVar5 != null ? aVar5.o() : null, 4152, null);
    }

    public final PendingIntent J(lv.c cVar) {
        IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb2.append("/movie/detail");
        sb2.append("&");
        sb2.append("extra_resource_id");
        sb2.append("=");
        sb2.append(cVar.b());
        sb2.append("&");
        sb2.append("subject_type");
        sb2.append("=");
        lv.a aVar = this.H;
        sb2.append(aVar != null ? aVar.p() : null);
        sb2.append("&");
        sb2.append("&");
        sb2.append("season");
        sb2.append("=");
        lv.a aVar2 = this.H;
        sb2.append(aVar2 != null ? aVar2.k() : 0);
        sb2.append("&");
        sb2.append("&");
        sb2.append("episode");
        sb2.append("=");
        lv.a aVar3 = this.H;
        sb2.append(aVar3 != null ? aVar3.d() : 0);
        sb2.append("&");
        sb2.append("&");
        sb2.append("id");
        sb2.append("=");
        lv.a aVar4 = this.H;
        sb2.append(aVar4 != null ? aVar4.m() : null);
        sb2.append("&");
        sb2.append("&");
        sb2.append("ops");
        sb2.append("=");
        lv.a aVar5 = this.H;
        sb2.append(aVar5 != null ? aVar5.o() : null);
        sb2.append("&");
        sb2.append("extra_page_from");
        sb2.append("=");
        sb2.append(this.f54464j);
        sb2.append("&");
        sb2.append("is_music_liked_fragment");
        sb2.append("=");
        sb2.append(this.E0);
        sb2.append("&");
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intentD1 = iPushProvider.d1(applicationA);
        intentD1.addFlags(603979776);
        intentD1.setData(Uri.parse(sb2.toString()));
        return PendingIntent.getActivity(Utils.a(), 0, intentD1, getPendingIntentFlag());
    }

    public final void J0() {
        long j11 = this.f54476p;
        if (j11 <= 0) {
            lv.a aVar = this.H;
            j11 = aVar != null ? aVar.j() : 0L;
        }
        if (j11 < 1000 || v0()) {
            return;
        }
        uo.b.f78622a.c(TAG, "prepareSeekTo,progress = " + j11, true);
        this.f54456f.seekTo(j11);
        t1(j11);
        if (this.f54492x || this.B) {
            return;
        }
        n1(Utils.a().getString(R$string.long_vod_last_played_time) + " " + com.transsion.postdetail.util.i.d(j11));
    }

    public final void K() {
        uo.b.f78622a.c(TAG, "onPrepare2PlayVideo, is mobile , pause video", true);
        this.f54494y = true;
        L();
        Context context = getContext();
        Intrinsics.f(context, "context");
        if (!com.transsion.baseui.util.b.a(context)) {
            getScreenHelper().h();
        }
        com.transsion.player.longvideo.helper.r rVar = this.f54454d0;
        if (rVar != null) {
            rVar.o();
        }
    }

    public final void K0() {
        RoomActivityLifecycleCallbacks.f51239a.b(this);
        com.tn.lib.util.networkinfo.f.f49475a.l(this.C0);
    }

    public final void L() {
        this.f54488v = true;
        uo.b.f78622a.c(TAG, "----handlePause, pause video", true);
        setPauseViewStatus(false);
        this.f54456f.pause();
        o1(false);
        this.f54449b.s1(true ^ this.f54494y);
    }

    public final void L0() {
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            com.transsion.postdetail.util.j orientationEventListener = getOrientationEventListener();
            if (orientationEventListener != null) {
                orientationEventListener.disable();
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void N() {
        List<lv.c> listI;
        lv.c cVar;
        lv.a aVar = this.H;
        if (aVar == null || (listI = aVar.i()) == null || (cVar = (lv.c) CollectionsKt___CollectionsKt.g0(listI)) == null || !cVar.g()) {
            AppCompatImageView appCompatImageView = this.f54447a.f71245r;
            Intrinsics.f(appCompatImageView, "viewBinding.orLongVodIvBg");
            so.c.g(appCompatImageView);
        }
    }

    public final void O0() {
        View view = this.J;
        if (view != null) {
            so.c.g(view);
        }
    }

    public final void P0() {
        if (getParent() != null) {
            ViewParent parent = getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this);
            }
        }
    }

    public final void Q() {
    }

    public final void R0() {
        mv.i iVar = this.f54447a;
        AppCompatTextView appCompatTextView = iVar.f71242o.f71277y;
        Intrinsics.f(appCompatTextView, "it.layoutLand.tvPlayNext");
        if (appCompatTextView.getVisibility() == 0) {
            ConstraintLayout root = iVar.f71242o.getRoot();
            Intrinsics.f(root, "it.layoutLand.root");
            if (root.getVisibility() == 0) {
                com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
                String str = this.f54464j;
                if (str == null) {
                    str = "";
                }
                mVar.t(str, "browse", getReportNextMap());
            }
        }
    }

    public final void S0(String str) {
        List<lv.c> listI;
        lv.c cVar;
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        String str2 = this.f54464j;
        if (str2 == null) {
            str2 = "";
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = new Pair("module_name", str);
        lv.a aVar = this.H;
        String strB = null;
        pairArr[1] = new Pair("subject_id", aVar != null ? aVar.m() : null);
        lv.a aVar2 = this.H;
        if (aVar2 != null && (listI = aVar2.i()) != null && (cVar = (lv.c) CollectionsKt___CollectionsKt.g0(listI)) != null) {
            strB = cVar.b();
        }
        pairArr[2] = new Pair("resource_id", strB);
        mVar.m(str2, "click", kotlin.collections.s.k(pairArr));
    }

    public final void T0(lv.a aVar, lv.c cVar) {
        DownloadBean downloadBean = new DownloadBean(cVar.f(), cVar.b(), aVar.n(), "", kotlin.text.k.n(cVar.e()), "", null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -64, 1073741823, null);
        downloadBean.setSubjectId(aVar.m());
        downloadBean.setEp(aVar.d());
        downloadBean.setSe(aVar.k());
        downloadBean.setOps(aVar.o());
        com.transsion.postdetail.layer.local.o oVar = this.T;
        if (oVar != null) {
            oVar.a();
        }
        com.transsion.postdetail.layer.local.o oVar2 = this.T;
        if (oVar2 != null) {
            oVar2.z(downloadBean, aVar.g());
        }
        if (aVar.s() == PlayMimeType.DASH) {
            com.transsion.postdetail.layer.local.o oVar3 = this.T;
            if (oVar3 == null) {
                return;
            }
            oVar3.J("3");
            return;
        }
        if (aVar.s() == PlayMimeType.HLS) {
            com.transsion.postdetail.layer.local.o oVar4 = this.T;
            if (oVar4 == null) {
                return;
            }
            oVar4.J(aVar.t() ? "5" : PrepareException.ERROR_NO_URL);
            return;
        }
        if (cVar.h()) {
            com.transsion.postdetail.layer.local.o oVar5 = this.T;
            if (oVar5 == null) {
                return;
            }
            oVar5.J("4");
            return;
        }
        com.transsion.postdetail.layer.local.o oVar6 = this.T;
        if (oVar6 == null) {
            return;
        }
        oVar6.J("0");
    }

    public final void W0() {
        LongVdPlayerConfigDialog longVdPlayerConfigDialog = new LongVdPlayerConfigDialog();
        longVdPlayerConfigDialog.r0(this.f54464j, LongVodPlayerConfigType.BITRATE, this.f54471m0);
        longVdPlayerConfigDialog.j0(getContext(), "LongVdPlayerConfigDialog");
    }

    public final void Y0(boolean z11, LongVodUiType longVodUiType) {
        lv.c cVar;
        com.transsion.player.longvideo.helper.r rVar;
        this.f54449b.T1(longVodUiType);
        if (longVodUiType == LongVodUiType.LAND) {
            this.f54447a.f71244q.f71225f.setVisibility(0);
        } else {
            this.f54447a.f71244q.f71225f.setVisibility(8);
        }
        if (v0()) {
            this.f54447a.f71244q.f71225f.setVisibility(8);
        }
        p0();
        com.transsion.player.longvideo.helper.g gVar = this.f54452c0;
        if (gVar != null) {
            gVar.h(longVodUiType);
        }
        LongVodSubtitleHelper longVodSubtitleHelper = this.W;
        if (longVodSubtitleHelper != null) {
            longVodSubtitleHelper.A(longVodUiType);
        }
        com.transsion.player.longvideo.helper.c cVar2 = this.f54455e0;
        if (cVar2 != null) {
            cVar2.c(longVodUiType);
        }
        b1();
        com.transsion.postdetail.layer.local.o oVar = this.T;
        if (oVar != null) {
            oVar.k(longVodUiType == LongVodUiType.MIDDLE ? LocalUiType.MIDDLE : LocalUiType.LAND);
        }
        ViewGroup.LayoutParams layoutParams = this.f54447a.f71240m.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        com.transsion.postdetail.util.j orientationEventListener = getOrientationEventListener();
        if (orientationEventListener != null) {
            Context context = getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
            int iB = orientationEventListener.b((Activity) context);
            if (orientationEventListener.a() != iB) {
                orientationEventListener.c(iB);
            }
        }
        ViewGroup.LayoutParams layoutParams2 = this.f54447a.f71249v.getLayoutParams();
        Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        if (z11) {
            bVar.f7299l = 0;
            bVar.I = "0";
            bVar2.f7293i = -1;
            ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin = gs.a.a(80);
        } else {
            bVar.I = "h,16:9";
            bVar.f7299l = -1;
            bVar2.f7293i = this.f54447a.f71240m.getId();
            ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin = 0;
        }
        ConstraintLayout root = this.f54447a.f71242o.getRoot();
        Intrinsics.f(root, "viewBinding.layoutLand.root");
        root.setVisibility(z11 ? 0 : 8);
        ConstraintLayout root2 = this.f54447a.f71243p.getRoot();
        Intrinsics.f(root2, "viewBinding.layoutMiddle.root");
        root2.setVisibility(z11 ^ true ? 0 : 8);
        Log.e(TAG, "screenUIChange  fullScreen:" + z11 + "  rotation:" + getRotation());
        if (z11) {
            if (this.f54458g == null) {
                ViewParent parent = getParent();
                this.f54458g = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            }
            ViewGroup viewGroup = this.L;
            if (viewGroup != null) {
                Intrinsics.d(viewGroup);
            } else {
                Context context2 = getContext();
                Intrinsics.e(context2, "null cannot be cast to non-null type android.app.Activity");
                viewGroup = (ViewGroup) ((Activity) context2).findViewById(R.id.content);
            }
            P0();
            viewGroup.addView(this, new FrameLayout.LayoutParams(-1, -1));
        } else {
            ViewGroup viewGroup2 = this.f54458g;
            if (viewGroup2 != null) {
                P0();
                viewGroup2.addView(this);
            }
        }
        com.tn.lib.util.networkinfo.f fVar = com.tn.lib.util.networkinfo.f.f49475a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        if (!fVar.h(applicationA) || (cVar = this.I) == null || !cVar.h() || (rVar = this.f54454d0) == null) {
            return;
        }
        rVar.y(z11);
    }

    public final void Z0(VideoDetailPlayBean videoDetailPlayBean) {
        QuickJSHelper.ExecuteBuilder executeBuilderM = new QuickJSHelper.ExecuteBuilder().l("watch_info").m("onWatch");
        String strJ = com.blankj.utilcode.util.n.j(videoDetailPlayBean);
        Intrinsics.f(strJ, "toJson(bean)");
        executeBuilderM.i(strJ).j(new g()).n();
    }

    public final void b1() {
        AppCompatTextView appCompatTextView = this.f54447a.f71244q.f71228i;
        Intrinsics.f(appCompatTextView, "viewBinding.layoutTopToolBar.vdTitle");
        LongVodUiType longVodUiType = this.f54466k;
        LongVodUiType longVodUiType2 = LongVodUiType.MIDDLE;
        appCompatTextView.setVisibility(longVodUiType != longVodUiType2 ? 0 : 8);
        if (this.f54466k != longVodUiType2 || this.f54493x0) {
            AppCompatImageView appCompatImageView = this.f54447a.f71244q.f71222b;
            Intrinsics.f(appCompatImageView, "viewBinding.layoutTopToolBar.ivBack");
            so.c.k(appCompatImageView);
        } else {
            AppCompatImageView appCompatImageView2 = this.f54447a.f71244q.f71222b;
            Intrinsics.f(appCompatImageView2, "viewBinding.layoutTopToolBar.ivBack");
            so.c.h(appCompatImageView2);
        }
    }

    @Override // kv.a
    public long currentPosition() {
        return this.f54456f.getCurrentPosition();
    }

    public final void e1() {
        lv.a aVar = this.H;
        if (aVar == null || aVar.c().length() == 0) {
            return;
        }
        lv.c cVar = (lv.c) CollectionsKt___CollectionsKt.g0(aVar.i());
        boolean zG = cVar != null ? cVar.g() : false;
        uo.b.f78622a.c(TAG, "showCoverBg, isMp3:" + zG, true);
        if (this.f54460h != LongVodPageType.TRAILER && !zG) {
            AppCompatImageView appCompatImageView = this.f54447a.f71245r;
            Intrinsics.f(appCompatImageView, "viewBinding.orLongVodIvBg");
            so.c.g(appCompatImageView);
            return;
        }
        AppCompatImageView appCompatImageView2 = this.f54447a.f71245r;
        Intrinsics.f(appCompatImageView2, "viewBinding.orLongVodIvBg");
        so.c.k(appCompatImageView2);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        AppCompatImageView appCompatImageView3 = this.f54447a.f71245r;
        Intrinsics.f(appCompatImageView3, "viewBinding.orLongVodIvBg");
        companion.q(context, appCompatImageView3, aVar.c(), (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : aVar.q(), (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
    }

    @Override // kv.a
    public void exitFullScreen() {
        if (this.f54466k != LongVodUiType.MIDDLE) {
            if (this.f54447a.f71242o.f71265m.isSelected()) {
                this.f54447a.f71242o.f71265m.performClick();
            }
            z(false);
        }
    }

    public final void f1(boolean z11) {
        if (this.J == null) {
            View viewInflate = this.f54447a.A.inflate();
            this.J = viewInflate;
            if (viewInflate != null) {
                TextView showError$lambda$46$lambda$43 = (TextView) viewInflate.findViewById(R$id.tv_fail_left_btn);
                Intrinsics.f(showError$lambda$46$lambda$43, "showError$lambda$46$lambda$43");
                showError$lambda$46$lambda$43.setVisibility(z11 ? 0 : 8);
                showError$lambda$46$lambda$43.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LongVodPlayerView.h1(view);
                    }
                });
                ((TextView) viewInflate.findViewById(R$id.tv_fail_right_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LongVodPlayerView.i1(this.f54587a, view);
                    }
                });
                ((ImageView) viewInflate.findViewById(R$id.iv_fail_back)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LongVodPlayerView.j1(this.f54588a, view);
                    }
                });
            }
        }
        View view = this.J;
        TextView textView = view != null ? (TextView) view.findViewById(R$id.tv_fail_title) : null;
        if (textView != null) {
            textView.setText(Utils.a().getString(z11 ? R$string.long_vod_load_failed : com.tn.lib.widget.R$string.error_load_failed));
        }
        o1(false);
        View view2 = this.K;
        if (view2 != null) {
            so.c.g(view2);
        }
        if (this.f54466k == LongVodUiType.MIDDLE) {
            setPauseViewStatus(false);
        }
        this.f54456f.pause();
        View view3 = this.J;
        if (view3 != null) {
            so.c.k(view3);
        }
    }

    public void floatBack2ExitPage(com.transsion.player.orplayer.f orPlayer, ORPlayerView playerView) {
        Intrinsics.g(orPlayer, "orPlayer");
        Intrinsics.g(playerView, "playerView");
    }

    public final LongVodPlayerViewAdHelper getLongVodPlayerViewAdHelper() {
        return this.f54449b;
    }

    @Override // kv.a
    public com.transsion.player.orplayer.f getPlayer() {
        return this.f54456f.getOrPlayer();
    }

    @Override // kv.a
    public ORPlayerView getPlayerView() {
        return this.S;
    }

    @Override // kv.a
    public lv.c getPlayingStream() {
        return this.R;
    }

    @Override // kv.a
    public SimpleSubtitleView getSubtitleView() {
        return this.f54447a.f71252y;
    }

    @Override // kv.a
    public ViewGroup getSubtitleViewGroup() {
        return this.f54447a.f71239l;
    }

    @Override // kv.a
    public void hasNextEpisode(boolean z11) {
        this.A = z11;
        ConstraintLayout constraintLayout = this.f54447a.f71242o.f71257d;
        Intrinsics.f(constraintLayout, "viewBinding.layoutLand.clBottomControl");
        if (constraintLayout.getVisibility() == 0) {
            AppCompatTextView appCompatTextView = this.f54447a.f71242o.f71277y;
            Intrinsics.f(appCompatTextView, "viewBinding.layoutLand.tvPlayNext");
            appCompatTextView.setVisibility(this.A ? 0 : 8);
            R0();
        }
    }

    @Override // kv.a
    public void hideBottomController(boolean z11) {
        if (com.blankj.utilcode.util.c.j()) {
            if (z11) {
                O();
            } else if (this.f54456f.isPlaying()) {
                this.M.removeCallbacks(this.B0);
                this.M.postDelayed(this.B0, 3000L);
            }
        }
    }

    @Override // kv.a
    public void init(String pageName, LongVodPageType pageType, String str, FrameLayout frameLayout, ViewGroup viewGroup, List<DubsInfo> dubs) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(pageType, "pageType");
        Intrinsics.g(dubs, "dubs");
        Function0<Boolean> function0G = TnPlayerManager.f54684a.g();
        boolean z11 = false;
        if (function0G != null && function0G.invoke().booleanValue()) {
            z11 = true;
        }
        this.E = z11;
        this.f54464j = pageName;
        this.f54460h = pageType;
        this.L = frameLayout;
        this.f54487u0 = dubs;
        this.f54462i = str;
        uo.b.a.f(uo.b.f78622a, TAG, "init,pageName:" + pageName + ", pageType:" + pageType + " ", false, 4, null);
        q0();
        P();
        l0();
        R();
        o0(viewGroup);
        S();
        com.transsion.postdetail.util.j orientationEventListener = getOrientationEventListener();
        if (orientationEventListener != null) {
            orientationEventListener.enable();
        }
        Q();
    }

    public final void initAdHelper(String str) {
        this.f54449b.t1(this.f54464j, this.f54447a, str, new Function1<Boolean, Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView.initAdHelper.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                LongVodPlayerView.this.f54489v0 = z11;
                if (z11) {
                    LongVodPlayerView.this.hideBottomController(true);
                    if (LongVodPlayerView.this.f54456f.isPlaying()) {
                        LongVodPlayerView.this.f54456f.pause();
                    }
                }
            }
        });
    }

    public boolean isPressedPause() {
        return this.f54488v;
    }

    public final void j0(lv.a aVar, lv.c cVar) {
        if (cVar.c().length() == 0) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, TAG, "initMp4Resolution, resolution = " + cVar.c(), false, 4, null);
        com.transsion.postdetail.layer.local.o oVar = this.T;
        if (oVar != null) {
            oVar.K(cVar.c() + "P");
        }
        this.f54447a.f71242o.f71273u.setText(cVar.c() + "P");
        this.f54471m0.clear();
        this.f54471m0.addAll(this.f54450b0.e(cVar, aVar.i()));
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0121  */
    public final void k0(String str, lv.a aVar) {
        com.transsion.player.orplayer.f fVarQ;
        boolean z11;
        String strF;
        if (this.S != null) {
            return;
        }
        iv.d dVar = new iv.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 512, 0, false, false, false, false, false, null, 130559, null);
        LocalVideoPlayerConfigMmkv localVideoPlayerConfigMmkv = LocalVideoPlayerConfigMmkv.f51172a;
        iv.a aVar2 = new iv.a(dVar, null, false, false, localVideoPlayerConfigMmkv.c(), localVideoPlayerConfigMmkv.b(), 10, null);
        Context context = getContext();
        Intrinsics.f(context, "context");
        this.S = new ORPlayerView(context, aVar2.c() ? RenderType.SURFACE_VIEW : RenderType.TEXTURE_VIEW);
        lv.c cVar = (lv.c) CollectionsKt___CollectionsKt.g0(aVar.i());
        if (cVar == null || (strF = cVar.f()) == null) {
            fVarQ = null;
            z11 = true;
        } else {
            uo.b.a aVar3 = uo.b.f78622a;
            uo.b.a.f(aVar3, TAG, "initPayer, id：" + com.transsion.baselib.utils.i.f(strF).hashCode() + ",", false, 4, null);
            if (v0()) {
                MusicFloatManager.a aVar4 = MusicFloatManager.f51403i;
                fVarQ = aVar4.b().q();
                String str2 = this.G;
                if (str2 != null) {
                    aVar4.b().u().add(str2);
                }
                uo.b.a.f(aVar3, TAG, "music  mediaSourceId:" + aVar4.b().p(), false, 4, null);
                if (Intrinsics.b(aVar4.b().p(), String.valueOf(com.transsion.baselib.utils.i.f(strF).hashCode()))) {
                    uo.b.a.f(aVar3, TAG, "music 是同一个音乐", false, 4, null);
                    z11 = false;
                } else {
                    uo.b.a.f(aVar3, TAG, "music 是不同的音乐", false, 4, null);
                    if (fVarQ != null) {
                        fVarQ.stop();
                    }
                    if (fVarQ != null) {
                        fVarQ.reset();
                    }
                    this.f54476p = 0L;
                }
            } else {
                fVarQ = null;
            }
            z11 = true;
        }
        com.transsion.player.orplayer.f fVarB = com.transsion.videofloat.manager.v.f60111a.b(str == null ? "" : str);
        boolean z12 = fVarB == null && z11;
        this.C = z12;
        uo.b.a aVar5 = uo.b.f78622a;
        aVar5.c(TAG, "initPayer, tag:" + str + ", isNewPlayer:" + z12, true);
        if (fVarQ != null) {
            uo.b.a.f(aVar5, TAG, "initPayer, 音乐播放器复用", false, 4, null);
            com.transsion.player.ui.longvideo.a aVar6 = this.f54456f;
            ORPlayerView oRPlayerView = this.S;
            Intrinsics.d(oRPlayerView);
            aVar6.setExistPlayer(aVar2, fVarQ, oRPlayerView);
            this.f54456f.play();
        } else if (fVarB != null) {
            uo.b.a.o(aVar5, TAG, new String[]{"initPayer, float播放器复用"}, false, 4, null);
            com.transsion.player.ui.longvideo.a aVar7 = this.f54456f;
            ORPlayerView oRPlayerView2 = this.S;
            Intrinsics.d(oRPlayerView2);
            aVar7.setExistPlayer(aVar2, fVarB, oRPlayerView2);
        } else {
            com.transsion.player.ui.longvideo.a aVar8 = this.f54456f;
            ORPlayerView oRPlayerView3 = this.S;
            Intrinsics.d(oRPlayerView3);
            aVar8.initLongVodPlayer(aVar2, oRPlayerView3);
        }
        VideoFloatManager.a.a(VideoFloatManager.f60019a.b(), false, 1, null);
        this.f54456f.addPlayerListener(this.f54497z0);
    }

    public final void k1(boolean z11) {
        if (!z11) {
            AppCompatTextView appCompatTextView = this.f54447a.f71250w;
            Intrinsics.f(appCompatTextView, "viewBinding.tvPressSpeed");
            appCompatTextView.setVisibility(8);
        } else {
            hideBottomController(true);
            O();
            AppCompatTextView appCompatTextView2 = this.f54447a.f71250w;
            Intrinsics.f(appCompatTextView2, "viewBinding.tvPressSpeed");
            appCompatTextView2.setVisibility(0);
        }
    }

    public final void m0(SecondariesSeekBar secondariesSeekBar) {
        secondariesSeekBar.setOnSeekBarChangeListener(new c(new Ref.LongRef()));
    }

    public final void n0() {
        lv.a aVar = this.H;
        if (aVar == null || !aVar.t()) {
            ov.b currentVideoFormat = this.f54456f.getCurrentVideoFormat();
            this.f54467k0 = currentVideoFormat;
            if (currentVideoFormat != null && currentVideoFormat.c() > 0) {
                this.f54450b0.f(String.valueOf(currentVideoFormat.c()));
            }
            uo.b.a.f(uo.b.f78622a, TAG, "onPrepareInitBitrate, curVideoFormat = " + this.f54467k0, false, 4, null);
            if (this.f54467k0 == null || !(!this.f54471m0.isEmpty())) {
                return;
            }
            ov.d dVar = this.f54465j0;
            if (dVar != null) {
                for (ov.b bVar : dVar.b()) {
                    ov.b bVar2 = this.f54467k0;
                    if (Intrinsics.b(bVar2 != null ? bVar2.d() : null, bVar.d())) {
                        this.f54447a.f71242o.f71273u.setText(bVar.c() + "P");
                        com.transsion.postdetail.layer.local.o oVar = this.T;
                        if (oVar == null) {
                            break;
                        }
                        oVar.K(bVar.c() + "P");
                        break;
                    }
                }
            }
            for (lv.b bVar3 : this.f54471m0) {
                String strB = bVar3.b();
                ov.b bVar4 = this.f54467k0;
                Intrinsics.d(bVar4);
                if (Intrinsics.b(strB, bVar4.c() + "P")) {
                    bVar3.d(true);
                }
            }
        }
    }

    public final void o0(ViewGroup viewGroup) {
        if (!x0()) {
            Group group = this.f54447a.f71242o.f71261i;
            Intrinsics.f(group, "viewBinding.layoutLand.groupControlPk");
            so.c.g(group);
            return;
        }
        mv.i iVar = this.f54447a;
        String str = this.f54464j;
        List<DubsInfo> list = this.f54487u0;
        if (list == null) {
            Intrinsics.y("dubs");
            list = null;
        }
        LongVodSubtitleHelper longVodSubtitleHelper = new LongVodSubtitleHelper(iVar, str, list, new d(), new Function1<DubsInfo, Unit>() { // from class: com.transsion.player.longvideo.ui.LongVodPlayerView$initSubtitle$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DubsInfo dubsInfo) {
                invoke2(dubsInfo);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DubsInfo it) {
                Intrinsics.g(it, "it");
                Function1 function1 = this.this$0.f54485t0;
                if (function1 != null) {
                    function1.invoke(it);
                }
            }
        }, false, 32, null);
        longVodSubtitleHelper.J(LocalVideoPlayerConfigMmkv.f51172a.c());
        longVodSubtitleHelper.G(viewGroup);
        this.W = longVodSubtitleHelper;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Context context = getContext();
        Intrinsics.f(context, "context");
        if (com.transsion.baseui.util.b.a(context)) {
            return;
        }
        getScreenHelper().g();
    }

    @Override // kv.a
    public boolean onBackPressed() {
        if (this.f54466k != LongVodUiType.MIDDLE) {
            A(this, false, 1, null);
            return true;
        }
        kv.a.b bVar = this.V;
        if (bVar != null && bVar.c(FloatActionType.BACK)) {
            return false;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return false;
    }

    @Override // com.transsion.baselib.report.RoomActivityLifecycleCallbacks.a
    public void onBackgroundStatusChange(boolean z11) {
        if (z11) {
            uo.b.f78622a.c(TAG, "app退至后台 上报埋点", true);
            if (this.f54456f.isPlaying()) {
                this.f54496z = false;
                if (!v0()) {
                    this.f54456f.pause();
                }
                L0();
            }
            a1();
            com.transsion.postdetail.layer.local.o oVar = this.T;
            if (oVar != null) {
                oVar.b(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Context context = getContext();
        Intrinsics.f(context, "context");
        if (com.transsion.baseui.util.b.a(context)) {
            return;
        }
        getScreenHelper().h();
    }

    @Override // kv.a
    public void onHandlePause() {
        uo.b.f78622a.c(TAG, "onHandlePause", true);
        this.f54496z = false;
        this.f54488v = true;
        if (!v0()) {
            this.f54456f.pause();
        }
        L0();
    }

    @Override // kv.a
    public void onHandlePlay() {
        uo.b.f78622a.c(TAG, "onHandlePlay", true);
        this.f54496z = true;
        if (this.f54494y) {
            return;
        }
        w1(this, null, false, 3, null);
    }

    @Override // kv.a
    public void onPageDestroy() {
        this.f54469l0 = true;
        a1();
        uo.b.f78622a.c(TAG, "页面关闭 上报埋点", true);
        com.transsion.postdetail.layer.local.o oVar = this.T;
        if (oVar != null) {
            com.transsion.postdetail.layer.local.o.c(oVar, false, 1, null);
        }
        this.f54456f.removePlayerListener(this.f54497z0);
        LongVodSubtitleHelper longVodSubtitleHelper = this.W;
        if (longVodSubtitleHelper != null) {
            longVodSubtitleHelper.v();
        }
        p1();
        U0();
        this.f54449b.P0();
    }

    @Override // kv.a
    public void onPipModeChanged(boolean z11) {
        com.transsion.postdetail.layer.local.o oVar = this.T;
        if (oVar == null) {
            return;
        }
        oVar.C(z11);
    }

    @Override // kv.a
    public void onSaveHistory() {
        if (this.f54460h != LongVodPageType.TRAILER && this.f54476p > 0) {
            kotlinx.coroutines.j.d(this.f54483s0, null, null, new C19961(this.H, this, null), 3, null);
        }
    }

    @Override // kv.a
    public void onViewPause() {
        uo.b.f78622a.c(TAG, "onViewPause", true);
        this.f54496z = false;
        if (!v0()) {
            this.f54456f.pause();
        }
        L0();
        this.f54449b.W1();
    }

    @Override // kv.a
    public void onViewResume() {
        uo.b.f78622a.c(TAG, "onViewResume", true);
        this.f54496z = true;
        com.transsion.postdetail.util.j orientationEventListener = getOrientationEventListener();
        if (orientationEventListener != null) {
            orientationEventListener.enable();
        }
        if (!this.f54488v && com.tn.lib.util.networkinfo.f.f49475a.e() && !com.transsion.videofloat.a.f60027a.d() && !this.f54489v0 && !this.f54493x0) {
            this.f54456f.play();
        }
        this.f54449b.X1();
    }

    public final void p0() {
        com.transsion.player.longvideo.helper.h hVar;
        View view = this.Q;
        if (view == null) {
            return;
        }
        Intrinsics.d(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        LongVodUiType longVodUiType = this.f54466k;
        LongVodUiType longVodUiType2 = LongVodUiType.LAND;
        int iA = 0;
        ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = longVodUiType == longVodUiType2 ? com.blankj.utilcode.util.f0.a(72.0f) : 0;
        if (this.f54466k == longVodUiType2 && (hVar = this.f54448a0) != null) {
            iA = hVar.a();
        }
        bVar.setMarginStart(iA);
        View view2 = this.Q;
        Intrinsics.d(view2);
        view2.setLayoutParams(bVar);
    }

    public final void p1() {
        RoomActivityLifecycleCallbacks.f51239a.k(this);
        com.tn.lib.util.networkinfo.f.f49475a.m(this.C0);
    }

    @Override // kv.a
    public void release() {
        this.F = false;
        if (v0()) {
            uo.b.f78622a.c(TAG, "music release clearSurfaceOnly", true);
            this.f54456f.clearSurfaceOnly();
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        aVar.c(TAG, "release player", true);
        if (com.transsion.videofloat.manager.v.f60111a.c(getPlayer())) {
            aVar.c(TAG, "播放器在缓存中，后续要用到，不能release", true);
            return;
        }
        com.transsion.player.ui.longvideo.a aVar2 = this.f54456f;
        lv.c cVar = this.R;
        String strF = cVar != null ? cVar.f() : null;
        aVar2.release(String.valueOf(strF != null ? strF.hashCode() : 0));
    }

    @Override // kv.a
    public void removeNoNetError() {
        O0();
    }

    @Override // kv.a
    public void replay() {
        x1();
    }

    @Override // kv.a
    public void reset() {
        if (this.C) {
            uo.b.f78622a.c(TAG, "player reset", true);
            this.f54492x = false;
            this.F = false;
            this.f54469l0 = true;
            LongVodSubtitleHelper longVodSubtitleHelper = this.W;
            if (longVodSubtitleHelper != null) {
                longVodSubtitleHelper.D();
            }
            com.transsion.player.longvideo.helper.h hVar = this.f54448a0;
            if (hVar != null) {
                hVar.c();
            }
            this.f54456f.reset();
            U0();
            t1(0L);
            setPauseViewStatus(false);
        }
    }

    public final void s1() {
        LongVodSubtitleHelper longVodSubtitleHelper = this.W;
        if (longVodSubtitleHelper != null) {
            List<DubsInfo> list = this.f54487u0;
            if (list == null) {
                Intrinsics.y("dubs");
                list = null;
            }
            longVodSubtitleHelper.H(list);
        }
    }

    public final void setAudioSelectCallback(Function1<? super DubsInfo, Unit> function1) {
        this.f54485t0 = function1;
    }

    @Override // kv.a
    public void setCallback(kv.a.b callback) {
        Intrinsics.g(callback, "callback");
        this.V = callback;
        com.transsion.player.longvideo.helper.g gVar = this.f54452c0;
        if (gVar != null) {
            gVar.d(callback);
        }
    }

    @Override // kv.a
    public void setDataSource(lv.a bean) {
        String strM;
        String strM2;
        Intrinsics.g(bean, "bean");
        this.f54494y = false;
        this.F = false;
        this.f54476p = 0L;
        com.transsion.player.longvideo.helper.r rVar = this.f54454d0;
        if (rVar != null) {
            rVar.A();
        }
        this.f54493x0 = false;
        this.f54449b.m2(bean);
        k0(this.f54462i, bean);
        this.f54487u0 = bean.a();
        s1();
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, TAG, "setDataSource,  isNewPlayer：" + this.C, false, 4, null);
        onSaveHistory();
        if (this.H != null) {
            a1();
            com.transsion.postdetail.layer.local.o oVar = this.T;
            if (oVar != null) {
                com.transsion.postdetail.layer.local.o.c(oVar, false, 1, null);
            }
            com.transsion.postdetail.layer.local.o oVar2 = this.T;
            if (oVar2 != null) {
                oVar2.g();
            }
        }
        this.f54469l0 = true;
        this.H = bean;
        com.transsion.postdetail.layer.local.o oVar3 = this.T;
        if (oVar3 != null) {
            oVar3.I(bean.h());
        }
        com.transsion.postdetail.layer.local.o oVar4 = this.T;
        if (oVar4 != null) {
            oVar4.F(this.E0);
        }
        String strH = bean.h();
        this.f54464j = strH;
        ImmScaleView immScaleView = this.f54447a.f71242o.f71267o;
        lv.a aVar2 = this.H;
        String str = "";
        if (aVar2 == null || (strM = aVar2.m()) == null) {
            strM = "";
        }
        immScaleView.setPageParams(strH, strM);
        ImmSpeedView immSpeedView = this.f54447a.f71242o.A;
        String str2 = this.f54464j;
        lv.a aVar3 = this.H;
        if (aVar3 != null && (strM2 = aVar3.m()) != null) {
            str = strM2;
        }
        immSpeedView.setPageParams(str2, str);
        u1(bean);
        if (this.C) {
            e1();
        }
        lv.c cVarA = this.f54450b0.a(bean);
        if (cVarA != null) {
            o1(this.C);
            LongVodSubtitleHelper longVodSubtitleHelper = this.W;
            if (longVodSubtitleHelper != null) {
                longVodSubtitleHelper.x(bean, cVarA);
            }
            if (bean.t()) {
                j0(bean, cVarA);
            }
            this.I = cVarA;
            T0(bean, cVarA);
            if (this.C) {
                setPlayerDataSourceAdPrepare(cVarA);
            } else {
                setPauseViewStatus(true);
                this.f54456f.play();
                LongVodSubtitleHelper longVodSubtitleHelper2 = this.W;
                if (longVodSubtitleHelper2 != null) {
                    longVodSubtitleHelper2.F(true);
                }
            }
        }
        uo.b.a.s(aVar, TAG, "setDataSource, reset isNewPlayer", false, 4, null);
        this.C = true;
        MediaItem mediaItemO = MusicFloatManager.f51403i.b().o();
        if (mediaItemO == null) {
            return;
        }
        mediaItemO.setPageName(this.f54464j);
    }

    public final void setFeedBackVisible(boolean z11) {
        AppCompatTextView appCompatTextView = this.f54447a.f71244q.f71224d;
        Intrinsics.f(appCompatTextView, "viewBinding.layoutTopToolBar.tvFeedback");
        so.c.j(appCompatTextView, z11);
    }

    @Override // kv.a
    public void setFloatIsShow(boolean z11) {
        this.D = z11;
    }

    public void setFragmentId(String fragmentId) {
        Intrinsics.g(fragmentId, "fragmentId");
        this.G = fragmentId;
    }

    public final void setLongVodPlayerViewAdHelper(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper) {
        Intrinsics.g(longVodPlayerViewAdHelper, "<set-?>");
        this.f54449b = longVodPlayerViewAdHelper;
    }

    public final void setMusicLikedFragment(boolean z11) {
        this.E0 = z11;
    }

    public void setSpeed(float f11) {
        this.f54456f.setSpeed(f11);
        ImmSpeedView immSpeedView = this.f54447a.f71242o.A;
        Intrinsics.f(immSpeedView, "viewBinding.layoutLand.tvPlaySpeed");
        ImmSpeedView.updateSpeed$default(immSpeedView, f11, false, 2, null);
        LongVodSubtitleHelper longVodSubtitleHelper = this.W;
        if (longVodSubtitleHelper != null) {
            longVodSubtitleHelper.J(f11);
        }
    }

    @Override // kv.a
    public void showNoNetError() {
        g1(this, false, 1, null);
    }

    @Override // kv.a
    public void showReplay() {
        if (u0()) {
            return;
        }
        if (this.f54466k == LongVodUiType.MIDDLE) {
            hideBottomController(true);
        } else {
            c1(false);
        }
        setPauseViewStatus(false);
        Q0();
        if (this.K == null) {
            this.K = this.f54447a.C.inflate();
        }
        View view = this.K;
        if (view != null) {
            so.c.k(view);
        }
        View view2 = this.K;
        if (view2 != null) {
            if (this.f54466k == LongVodUiType.LAND) {
                this.f54457f0 = false;
            }
            ((TextView) view2.findViewById(R$id.tv_replay)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LongVodPlayerView.m1(this.f54514a, view3);
                }
            });
        }
    }

    public final void u1(lv.a aVar) {
        String strN;
        if (aVar.d() > 0) {
            strN = aVar.n() + " " + com.transsion.baselib.utils.h.b(aVar.d(), aVar.k(), aVar.p()) + com.transsion.baselib.utils.h.d(aVar.e());
        } else {
            strN = aVar.n();
        }
        this.f54447a.f71244q.f71228i.setText(strN);
        b1();
    }

    public final boolean v0() {
        return this.f54460h == LongVodPageType.MUSIC;
    }

    public final void v1(MotionEvent motionEvent, boolean z11) {
        if (com.transsion.baseui.util.c.f51452a.a(this.f54447a.f71243p.f71282d.getId(), 500L)) {
            return;
        }
        uo.b.f78622a.c(TAG, "videoPause click", true);
        if (u0()) {
            if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                return;
            }
            com.tn.lib.widget.toast.core.h.f50034a.k(com.transsion.baseui.R$string.base_network_fail);
            return;
        }
        com.transsion.player.longvideo.helper.r rVar = this.f54454d0;
        if (rVar != null) {
            rVar.A();
        }
        if (this.f54456f.isComplete()) {
            if (t0()) {
                return;
            }
            x1();
        } else {
            if (this.f54456f.isPlaying()) {
                M(motionEvent, z11);
                return;
            }
            com.transsion.player.longvideo.helper.c cVar = this.f54455e0;
            if (cVar == null || !cVar.b()) {
                this.f54488v = false;
                setPauseViewStatus(true);
                com.transsion.videofloat.a.f60027a.a();
                this.f54456f.play();
            }
        }
    }

    public final boolean x0() {
        LongVodPageType longVodPageType = this.f54460h;
        return longVodPageType == LongVodPageType.STREAM || longVodPageType == LongVodPageType.LOCAL_VIDEO;
    }

    public final void y0(boolean z11) {
        this.f54447a.getRoot().setKeepScreenOn(z11);
    }

    public final void y1(ScaleMode scaleMode, String str) {
        this.f54456f.setScaleMode(scaleMode);
        this.f54447a.f71242o.f71278z.setText(str);
    }

    public final void z(boolean z11) {
        LongVodUiType longVodUiType = this.f54466k;
        LongVodUiType longVodUiType2 = LongVodUiType.MIDDLE;
        if (longVodUiType != longVodUiType2) {
            if (longVodUiType == LongVodUiType.LAND) {
                Context context = getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
                Activity activity = (Activity) context;
                ImmersionBar.with(activity).hideBar(BarHide.FLAG_SHOW_BAR).init();
                activity.setRequestedOrientation(1);
            }
            this.f54447a.f71253z.setPadding(0, 0, 0, 0);
            this.f54466k = longVodUiType2;
            Y0(false, longVodUiType2);
            return;
        }
        if (z11) {
            kv.a.b bVar = this.V;
            if (bVar == null || !bVar.c(FloatActionType.BACK)) {
                Context context2 = getContext();
                Intrinsics.e(context2, "null cannot be cast to non-null type android.app.Activity");
                ((Activity) context2).finish();
            }
        }
    }
}
