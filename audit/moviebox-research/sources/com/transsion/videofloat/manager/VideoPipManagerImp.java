package com.transsion.videofloat.manager;

import android.R;
import android.app.Application;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.PowerManager;
import android.util.Rational;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.PermissionDialogClickType;
import com.tn.lib.util.device.TNDeviceHelper;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.videofloat.R$mipmap;
import com.transsion.videofloat.R$string;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsion.videofloat.dialog.VideoFloatPermissionDialog;
import com.transsion.web.api.WebConstants;
import com.vungle.warren.error.VungleException;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class VideoPipManagerImp implements VideoPipManager {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f60045v = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FragmentActivity f60047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vz.a f60048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PowerManager.WakeLock f60049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.player.orplayer.f f60050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ORPlayerView f60051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f60052h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f60053i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f60054j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Rect f60056l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f60057m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f60058n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f60059o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f60060p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f60061q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f60062r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f60064t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f60046b = VideoPipManagerImp.class.getSimpleName();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f60055k = 16.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final VideoPipManagerImp$pipActionReceiver$1 f60063s = new BroadcastReceiver() { // from class: com.transsion.videofloat.manager.VideoPipManagerImp$pipActionReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.s(aVar, "VideoFloat-pip", this.f60070a.f60046b + " --pipActionReceiver action:" + (intent != null ? intent.getAction() : null), false, 4, null);
            if (intent == null || !Intrinsics.b(intent.getAction(), "pip_action_control")) {
                return;
            }
            int intExtra = intent.getIntExtra("control_type", 0);
            uo.b.a.o(aVar, "VideoFloat-pip", new String[]{this.f60070a.f60046b + " --pipActionReceiver controlType:" + intExtra}, false, 4, null);
            if (intExtra == 1) {
                this.f60070a.M();
            } else if (intExtra == 2) {
                this.f60070a.H(true);
            } else {
                if (intExtra != 3) {
                    return;
                }
                this.f60070a.H(false);
            }
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f60065u = true;

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
    public final class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Boolean, Unit> f60066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f60067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VideoPipManagerImp f60068c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(VideoPipManagerImp videoPipManagerImp, Function1<? super Boolean, Unit> callback) {
            Intrinsics.g(callback, "callback");
            this.f60068c = videoPipManagerImp;
            this.f60066a = callback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.g(context, "context");
            Intrinsics.g(intent, "intent");
            String action = intent.getAction();
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -2128145023) {
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        this.f60067b = true;
                        this.f60066a.invoke(Boolean.TRUE);
                        uo.b.a.f(uo.b.f78622a, "CommonInfo", "Screen off", false, 4, null);
                        return;
                    }
                    return;
                }
                if (iHashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                    this.f60067b = false;
                    this.f60066a.invoke(Boolean.FALSE);
                    uo.b.a.f(uo.b.f78622a, "CommonInfo", "User present", false, 4, null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f60069a;

        static {
            int[] iArr = new int[FloatActionType.values().length];
            try {
                iArr[FloatActionType.ICON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FloatActionType.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FloatActionType.HOME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f60069a = iArr;
        }
    }

    public static final void W(boolean z11, VideoPipManagerImp this$0, String subjectId, String pageName, com.permissionx.guolindev.request.d scope, List deniedList, boolean z12, boolean z13) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(subjectId, "$subjectId");
        Intrinsics.g(pageName, "$pageName");
        Intrinsics.g(scope, "scope");
        Intrinsics.g(deniedList, "deniedList");
        if (!z12) {
            uo.b.a.f(uo.b.f78622a, "VideoFloat-pip", "pip 请求权限之后，", false, 4, null);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "VideoFloat", "pip 请求权限前，提示弹窗，isFullLand：" + z11, false, 4, null);
        if (z11) {
            scope.d(new VideoFloatPermissionDialog(true, deniedList));
        } else {
            scope.e(deniedList, new co.a(null, Utils.a().getString(R$string.video_float_tips_pip), Utils.a().getString(R$string.video_float_enable), Integer.valueOf(R$mipmap.video_float_ic_permission_img), Integer.valueOf(R$color.white_20), 1, null));
        }
        this$0.T(subjectId, pageName);
    }

    public static final void X(VideoPipManagerImp this$0, String subjectId, String pageName, BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(subjectId, "$subjectId");
        Intrinsics.g(pageName, "$pageName");
        this$0.S(permissionDialogClickType == PermissionDialogClickType.POSITIVE, subjectId, pageName);
    }

    public static final void Y(VideoPipManagerImp this$0, Function1 function1, boolean z11, List grantedList, List deniedList) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(grantedList, "grantedList");
        Intrinsics.g(deniedList, "deniedList");
        uo.b.a.f(uo.b.f78622a, "VideoFloat-pip", "pip 请求权限结果:" + z11, false, 4, null);
        this$0.U(z11);
        if (z11) {
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        } else if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    @RequiresApi(26)
    public final RemoteAction E(Context context, int i11, @StringRes int i12, int i13, int i14) {
        i.a();
        return r.a(Icon.createWithResource(context, i11), Utils.a().getString(i12), Utils.a().getString(i12), PendingIntent.getBroadcast(context, i13, new Intent("pip_action_control").putExtra("control_type", i14), 67108864));
    }

    @RequiresApi(26)
    public final void F(FragmentActivity fragmentActivity, vz.a aVar, FloatActionType floatActionType) {
        Object objM163constructorimpl;
        FragmentActivity fragmentActivity2;
        this.f60062r = false;
        if (this.f60058n && fragmentActivity.isInPictureInPictureMode()) {
            uo.b.f78622a.r("VideoFloat-pip", this.f60046b + " enterPip--- 已经进入，无需重复调用}", true);
            return;
        }
        if (floatActionType != FloatActionType.ICON && !Intrinsics.b(fragmentActivity, this.f60047c)) {
            String simpleName = fragmentActivity.getClass().getSimpleName();
            FragmentActivity fragmentActivity3 = this.f60047c;
            if (Intrinsics.b(simpleName, fragmentActivity3 != null ? fragmentActivity3.getClass().getSimpleName() : null)) {
                uo.b.f78622a.r("VideoFloat-pip", this.f60046b + " 不是相同页面, pip activity:" + this.f60047c + ", cur activity:" + fragmentActivity, true);
                if (floatActionType == FloatActionType.BACK) {
                    aVar.e().release();
                    fragmentActivity.finish();
                    return;
                }
                return;
            }
        }
        FloatActionType floatActionType2 = FloatActionType.HOME;
        if (floatActionType != floatActionType2 && (fragmentActivity2 = this.f60047c) != null && !Intrinsics.b(fragmentActivity, fragmentActivity2)) {
            uo.b.f78622a.r("VideoFloat-pip", this.f60046b + " 主动进入的，不是同一个activity，需要关闭上一个pip", true);
            this.f60058n = false;
            g();
            com.transsion.player.orplayer.f fVar = this.f60050f;
            if (fVar != null) {
                fVar.release();
            }
            this.f60050f = null;
            G();
        }
        this.f60050f = null;
        this.f60051g = null;
        this.f60052h = null;
        this.f60047c = fragmentActivity;
        this.f60048d = aVar;
        N();
        uo.b.a aVar2 = uo.b.f78622a;
        aVar2.r("VideoFloat-pip", this.f60046b + " enterPip---, isPlaying:" + aVar.e().isPlaying(), true);
        try {
            Result.Companion companion = Result.Companion;
            this.f60050f = aVar.e();
            this.f60051g = aVar.k();
            this.f60052h = aVar.t();
            if (!this.f60059o) {
                this.f60059o = true;
                ViewGroup viewGroupT = aVar.t();
                ViewParent parent = viewGroupT != null ? viewGroupT.getParent() : null;
                this.f60053i = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                ViewParent parent2 = aVar.k().getParent();
                this.f60054j = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            }
            if (Build.VERSION.SDK_INT < 31 || floatActionType != floatActionType2) {
                PictureInPictureParams pictureInPictureParamsI = i(fragmentActivity, aVar.h() == FloatPlayType.SHORT_TV, aVar.e().isPlaying(), this.f60054j);
                if (pictureInPictureParamsI != null) {
                    fragmentActivity.enterPictureInPictureMode(pictureInPictureParamsI);
                }
                aVar2.h("VideoFloat-pip", "enterPipNext ----", true);
                K(fragmentActivity);
            } else {
                aVar2.h("VideoFloat-pip", " >=android12 ---2 wait auto into", true);
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            L();
            uo.b.a.j(uo.b.f78622a, "VideoFloat-pip", this.f60046b + " error:" + thM166exceptionOrNullimpl + "}", false, 4, null);
        }
    }

    public final void G() {
        KeyEventDispatcher.Component component = this.f60047c;
        if (component instanceof com.transsion.videofloat.manager.c) {
            Intrinsics.e(component, "null cannot be cast to non-null type com.transsion.videofloat.manager.IVideoPipView");
            ((com.transsion.videofloat.manager.c) component).v();
        }
        FragmentActivity fragmentActivity = this.f60047c;
        if (fragmentActivity != null) {
            fragmentActivity.finish();
        }
        this.f60047c = null;
        this.f60059o = false;
    }

    public final void H(boolean z11) {
        long jE;
        uo.b.f78622a.r("VideoFloat-pip", this.f60046b + " -- forward :" + z11, true);
        if (z11) {
            com.transsion.player.orplayer.f fVar = this.f60050f;
            long currentPosition = (fVar != null ? fVar.getCurrentPosition() : 0L) + ((long) 10000);
            com.transsion.player.orplayer.f fVar2 = this.f60050f;
            jE = kotlin.ranges.a.h(currentPosition, fVar2 != null ? fVar2.getDuration() : 0L);
        } else {
            com.transsion.player.orplayer.f fVar3 = this.f60050f;
            jE = kotlin.ranges.a.e(0L, (fVar3 != null ? fVar3.getCurrentPosition() : 0L) - ((long) 10000));
        }
        com.transsion.player.orplayer.f fVar4 = this.f60050f;
        if (fVar4 != null) {
            fVar4.seekTo(jE);
        }
    }

    @RequiresApi(26)
    public final List<RemoteAction> I(FragmentActivity fragmentActivity, boolean z11) {
        RemoteAction[] remoteActionArr = new RemoteAction[3];
        remoteActionArr[0] = E(fragmentActivity, R$mipmap.video_float_ic_backward, R$string.video_pip_action_rewind, 13, 3);
        remoteActionArr[1] = z11 ? E(fragmentActivity, R$mipmap.video_float_ic_pause, R$string.video_pip_action_play, 11, 1) : E(fragmentActivity, R$mipmap.video_float_ic_play, R$string.video_pip_action_pause, 11, 1);
        remoteActionArr[2] = E(fragmentActivity, R$mipmap.video_float_ic_forward, R$string.video_pip_action_fast_forword, 12, 2);
        return kotlin.collections.g.o(remoteActionArr);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0046  */
    public final boolean J() {
        boolean z11;
        String value;
        Integer numL;
        if (!this.f60064t) {
            ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sa_pip_enable_memory", false, 2, null);
            int iIntValue = (configBeanC == null || (value = configBeanC.getValue()) == null || (numL = kotlin.text.k.l(value)) == null) ? 4 : numL.intValue();
            if (iIntValue > 0) {
                TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                z11 = ((double) tNDeviceHelper.j(applicationA).totalMem) > ((double) 1073741824) * ((double) iIntValue);
            }
            this.f60065u = z11;
        }
        return this.f60065u;
    }

    public final void K(FragmentActivity fragmentActivity) {
        View childAt;
        Unit unit;
        this.f60062r = false;
        if (this.f60058n) {
            return;
        }
        com.transsion.player.orplayer.f fVar = this.f60050f;
        if (fVar != null) {
            fVar.play();
        }
        this.f60058n = true;
        FrameLayout frameLayout = (FrameLayout) fragmentActivity.findViewById(R.id.content);
        Q();
        if (this.f60051g == null) {
            uo.b.f78622a.h("VideoFloat-pip", "onEnterPip playerView is null", true);
            return;
        }
        P(fragmentActivity);
        try {
            Result.Companion companion = Result.Companion;
            uo.b.f78622a.c("VideoFloat-pip", "onEnterPip childCount：" + frameLayout.getChildCount(), true);
            View childAt2 = frameLayout.getChildAt(0);
            if (childAt2 != null) {
                so.c.g(childAt2);
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        frameLayout.addView(this.f60051g, new FrameLayout.LayoutParams(-1, -1));
        ViewGroup viewGroup = this.f60052h;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            this.f60057m = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                ViewGroup viewGroup2 = this.f60052h;
                if (viewGroup2 != null && (childAt = viewGroup2.getChildAt(i11)) != null) {
                    Intrinsics.f(childAt, "getChildAt(i)");
                    SimpleSubtitleView simpleSubtitleView = childAt instanceof SimpleSubtitleView ? (SimpleSubtitleView) childAt : null;
                    if (simpleSubtitleView != null) {
                        this.f60055k = f0.c(simpleSubtitleView.getTextSize());
                        this.f60056l = new Rect(simpleSubtitleView.getPaddingLeft(), simpleSubtitleView.getPaddingTop(), simpleSubtitleView.getPaddingRight(), simpleSubtitleView.getPaddingBottom());
                        ViewGroup.LayoutParams layoutParams2 = simpleSubtitleView.getLayoutParams();
                        layoutParams2.width = -1;
                        simpleSubtitleView.setLayoutParams(layoutParams2);
                        if (i11 == 1) {
                            simpleSubtitleView.setTextSize(0.0f);
                            simpleSubtitleView.setPadding(0, 0, 0, 0);
                        } else {
                            simpleSubtitleView.setTextSize(12.0f);
                            int iA = f0.a(6.0f);
                            simpleSubtitleView.setPadding(iA, 0, iA, iA);
                        }
                    }
                }
            }
        }
        ViewGroup viewGroup3 = this.f60052h;
        if (viewGroup3 != null) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 81;
            frameLayout.addView(viewGroup3, layoutParams3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00be  */
    /* JADX WARN: Code duplicated, block: B:44:0x00de  */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x00be, please report this as an issue */
    public final void L() {
        vz.a aVar;
        Unit unit;
        View childAt;
        View childAt2;
        this.f60058n = false;
        this.f60059o = false;
        ViewGroup viewGroup = this.f60052h;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                ViewGroup viewGroup2 = this.f60052h;
                if (viewGroup2 != null && (childAt2 = viewGroup2.getChildAt(i11)) != null) {
                    Intrinsics.f(childAt2, "getChildAt(i)");
                    SimpleSubtitleView simpleSubtitleView = childAt2 instanceof SimpleSubtitleView ? (SimpleSubtitleView) childAt2 : null;
                    if (simpleSubtitleView != null) {
                        simpleSubtitleView.setTextSize(this.f60055k);
                        Rect rect = this.f60056l;
                        if (rect != null) {
                            simpleSubtitleView.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                        }
                    }
                }
            }
        }
        Q();
        try {
            Result.Companion companion = Result.Companion;
            FragmentActivity fragmentActivity = this.f60047c;
            FrameLayout frameLayout = fragmentActivity != null ? (FrameLayout) fragmentActivity.findViewById(R.id.content) : null;
            if (frameLayout == null || (childAt = frameLayout.getChildAt(0)) == null) {
                unit = null;
            } else {
                Intrinsics.f(childAt, "getChildAt(0)");
                so.c.k(childAt);
                unit = Unit.f68710a;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        g();
        FragmentActivity fragmentActivity2 = this.f60047c;
        if (fragmentActivity2 != null) {
            Intrinsics.d(fragmentActivity2);
            if (fragmentActivity2.getLifecycle().b().compareTo(Lifecycle.State.STARTED) < 0) {
                uo.b.f78622a.n("VideoFloat-pip", new String[]{this.f60046b + ", 用户主动关闭pip----关闭页面，释放播放器"}, true);
                com.transsion.player.orplayer.f fVar = this.f60050f;
                if (fVar != null) {
                    fVar.release();
                }
                this.f60050f = null;
                G();
            } else {
                uo.b.f78622a.n("VideoFloat-pip", new String[]{this.f60046b + ", 退出画中画返回页面"}, true);
                aVar = this.f60048d;
                if (aVar != null) {
                    R(aVar.q(), aVar.g());
                }
            }
        } else {
            uo.b.f78622a.n("VideoFloat-pip", new String[]{this.f60046b + ", 退出画中画返回页面"}, true);
            aVar = this.f60048d;
            if (aVar != null) {
                R(aVar.q(), aVar.g());
            }
        }
        uo.b.f78622a.n("VideoFloat-pip", new String[]{this.f60046b + ", onExitPip----" + this.f60054j}, true);
        ViewGroup viewGroup3 = this.f60054j;
        if (viewGroup3 != null) {
            viewGroup3.addView(this.f60051g);
        }
        if (this.f60052h != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = this.f60057m;
            ViewGroup viewGroup4 = this.f60053i;
            if (viewGroup4 != null) {
                viewGroup4.addView(this.f60052h, layoutParams);
            }
        }
        this.f60047c = null;
        this.f60050f = null;
        this.f60051g = null;
        this.f60052h = null;
        this.f60053i = null;
        this.f60054j = null;
        this.f60048d = null;
    }

    public final void M() {
        com.transsion.player.orplayer.f fVar;
        uo.b.a aVar = uo.b.f78622a;
        String str = this.f60046b;
        com.transsion.player.orplayer.f fVar2 = this.f60050f;
        aVar.r("VideoFloat-pip", str + " --onPlayOrPauseClick isPlaying:" + (fVar2 != null ? Boolean.valueOf(fVar2.isPlaying()) : null), true);
        com.transsion.player.orplayer.f fVar3 = this.f60050f;
        if (fVar3 != null && fVar3.isPlaying()) {
            this.f60061q = true;
            com.transsion.player.orplayer.f fVar4 = this.f60050f;
            if (fVar4 != null) {
                fVar4.pause();
                return;
            }
            return;
        }
        com.transsion.player.orplayer.f fVar5 = this.f60050f;
        if (fVar5 != null && fVar5.isComplete() && (fVar = this.f60050f) != null) {
            fVar.seekTo(0L);
        }
        this.f60061q = false;
        com.transsion.player.orplayer.f fVar6 = this.f60050f;
        if (fVar6 != null) {
            fVar6.play();
        }
    }

    public final void N() {
        try {
            Result.Companion companion = Result.Companion;
            Result.m163constructorimpl(Build.VERSION.SDK_INT >= 33 ? Utils.a().registerReceiver(this.f60063s, new IntentFilter("pip_action_control"), 2) : Utils.a().registerReceiver(this.f60063s, new IntentFilter("pip_action_control")));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        O();
    }

    public final void O() {
        this.f60060p = new b(this, new Function1<Boolean, Unit>() { // from class: com.transsion.videofloat.manager.VideoPipManagerImp$registerScreenStateReceiver$1
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
                if (z11) {
                    com.transsion.player.orplayer.f fVar2 = this.this$0.f60050f;
                    if (fVar2 != null) {
                        fVar2.pause();
                        return;
                    }
                    return;
                }
                if (this.this$0.f60061q || (fVar = this.this$0.f60050f) == null) {
                    return;
                }
                fVar.play();
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            Result.Companion companion = Result.Companion;
            Result.m163constructorimpl(Build.VERSION.SDK_INT >= 33 ? Utils.a().registerReceiver(this.f60060p, intentFilter, 2) : Utils.a().registerReceiver(this.f60060p, intentFilter));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void P(FragmentActivity fragmentActivity) {
        try {
            Result.Companion companion = Result.Companion;
            List<Fragment> fragments = fragmentActivity.getSupportFragmentManager().getFragments();
            Intrinsics.f(fragments, "activity.supportFragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if (fragment instanceof DialogFragment) {
                    ((DialogFragment) fragment).dismissAllowingStateLoss();
                }
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void Q() {
        ORPlayerView oRPlayerView = this.f60051g;
        ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f60051g);
        }
        ViewGroup viewGroup2 = this.f60052h;
        ViewParent parent2 = viewGroup2 != null ? viewGroup2.getParent() : null;
        ViewGroup viewGroup3 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup3 != null) {
            viewGroup3.removeView(this.f60052h);
        }
    }

    public final void R(String str, String str2) {
        HashMap map = new HashMap();
        map.put("subject_id", str);
        map.put("opt_type", "float_back_page");
        map.put("type", "pip");
        com.transsion.baselib.report.m.f51277a.m(str2, "click", map);
    }

    public final void S(boolean z11, String str, String str2) {
        HashMap map = new HashMap();
        map.put("subject_id", str);
        map.put("opt_type", z11 ? "allow" : "cancel");
        map.put(WebConstants.PAGE_FROM, str2);
        com.transsion.baselib.report.m.f51277a.m("pip_permission_dialog_pip", "click", map);
    }

    public final void T(String str, String str2) {
        HashMap map = new HashMap();
        map.put("subject_id", str);
        map.put(WebConstants.PAGE_FROM, str2);
        com.transsion.baselib.report.m.f51277a.t("pip_permission_dialog_pip", "dialog_show", map);
    }

    public final void U(boolean z11) {
        HashMap map = new HashMap();
        map.put("has_permission", String.valueOf(z11));
        com.transsion.baselib.report.m.f51277a.t("pip_opt", "app_perf", map);
    }

    public final void V(FragmentActivity fragmentActivity, final boolean z11, final String str, final String str2, final Function1<? super Boolean, Unit> function1) {
        PermissionX.f48641a.d(fragmentActivity).b("android.permission.PICTURE_IN_PICTURE").a().c(new ao.b() { // from class: com.transsion.videofloat.manager.s
            @Override // ao.b
            public final void a(com.permissionx.guolindev.request.d dVar, List list, boolean z12, boolean z13) {
                VideoPipManagerImp.W(z11, this, str2, str, dVar, list, z12, z13);
            }
        }).d(new ao.a() { // from class: com.transsion.videofloat.manager.t
            @Override // ao.a
            public final void a(BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
                VideoPipManagerImp.X(this.f60106a, str2, str, baseDialog, bool, permissionDialogClickType);
            }
        }).b(new ao.c() { // from class: com.transsion.videofloat.manager.u
            @Override // ao.c
            public final void a(boolean z12, List list, List list2) {
                VideoPipManagerImp.Y(this.f60109a, function1, z12, list, list2);
            }
        });
    }

    @Override // com.transsion.videofloat.VideoPipManager
    public boolean a(String tag) {
        Intrinsics.g(tag, "tag");
        vz.a aVar = this.f60048d;
        if (aVar == null) {
            return false;
        }
        return Intrinsics.b(tag, aVar.q() + aVar.p() + aVar.b());
    }

    @Override // com.transsion.videofloat.VideoPipManager
    public boolean b() {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        boolean zHasSystemFeature = Utils.a().getPackageManager().hasSystemFeature("android.software.picture_in_picture");
        boolean zJ = J();
        uo.b.f78622a.r("VideoFloat-pip", this.f60046b + " --hasPipFeature:" + zHasSystemFeature + ", isMemoryEnable:" + zJ + " ", true);
        return zHasSystemFeature && zJ;
    }

    @Override // com.transsion.videofloat.VideoPipManager
    @RequiresApi(VungleException.WEB_CRASH)
    public void c(FragmentActivity activity, vz.a bean) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(bean, "bean");
        this.f60047c = activity;
        this.f60048d = bean;
        N();
        uo.b.a aVar = uo.b.f78622a;
        aVar.n("VideoFloat-pip", new String[]{">=android12  " + this.f60046b + " =====updateData---, isPlaying:" + bean.e().isPlaying() + ", isSetData:" + this.f60059o}, true);
        this.f60052h = bean.t();
        if (!this.f60059o) {
            this.f60059o = true;
            ViewGroup viewGroupT = bean.t();
            ViewParent parent = viewGroupT != null ? viewGroupT.getParent() : null;
            this.f60053i = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            ViewParent parent2 = bean.k().getParent();
            ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            this.f60054j = viewGroup;
            aVar.c("VideoFloat-pip", ">=android12  " + this.f60046b + " =====updateData---, playerOriginalContainer:" + viewGroup, true);
        }
        this.f60050f = bean.e();
        this.f60051g = bean.k();
    }

    @Override // com.transsion.videofloat.VideoPipManager
    public void d(boolean z11) {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new VideoPipManagerImp$closePip$1$1(this, z11, null), 3, null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            uo.b.f78622a.h("VideoFloat-pip", "closePip error:" + thM166exceptionOrNullimpl, true);
        }
    }

    @Override // com.transsion.videofloat.VideoPipManager
    public void e() {
        boolean zHasSystemFeature = Build.VERSION.SDK_INT >= 26 ? Utils.a().getPackageManager().hasSystemFeature("android.software.picture_in_picture") : true;
        HashMap map = new HashMap();
        map.put("pip_opt", String.valueOf(zHasSystemFeature));
        map.put("pip_enable", String.valueOf(b()));
        com.transsion.baselib.report.m.f51277a.t("pip", "app_perf", map);
    }

    @Override // com.transsion.videofloat.VideoPipManager
    public boolean f(com.transsion.player.orplayer.f fVar) {
        com.transsion.player.orplayer.f fVar2;
        uo.b.a.s(uo.b.f78622a, "VideoFloat-pip", "2-isEnterPip：" + this.f60058n + ", " + this.f60050f + ", " + fVar + " ", false, 4, null);
        return this.f60058n && (fVar2 = this.f60050f) != null && Intrinsics.b(fVar2, fVar);
    }

    @Override // com.transsion.videofloat.VideoPipManager
    public void g() {
        try {
            Result.Companion companion = Result.Companion;
            Utils.a().unregisterReceiver(this.f60063s);
            Utils.a().unregisterReceiver(this.f60060p);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.transsion.videofloat.VideoPipManager
    public boolean h() {
        if (Build.VERSION.SDK_INT >= 26) {
            return Utils.a().getPackageManager().hasSystemFeature("android.software.picture_in_picture");
        }
        return true;
    }

    @Override // com.transsion.videofloat.VideoPipManager
    @RequiresApi(26)
    public PictureInPictureParams i(FragmentActivity activity, boolean z11, boolean z12, ViewGroup viewGroup) {
        Intrinsics.g(activity, "activity");
        if (activity.isFinishing() || activity.isDestroyed()) {
            return null;
        }
        if (this.f60062r && !z12) {
            uo.b.a.f(uo.b.f78622a, "VideoFloat-pip", this.f60046b + " updatePictureInPictureParams isEntering return", false, 4, null);
            return null;
        }
        uo.b.a.f(uo.b.f78622a, "VideoFloat-pip", this.f60046b + " updatePictureInPictureParams AutoEnterEnabled:" + z12 + "}", false, 4, null);
        Rational rational = new Rational(z11 ? 9 : 16, z11 ? 16 : 9);
        PictureInPictureParams.Builder builderA = q.a();
        builderA.setAspectRatio(rational);
        builderA.setActions(I(activity, z12));
        if (viewGroup != null) {
            Rect rect = new Rect();
            viewGroup.getGlobalVisibleRect(rect);
            builderA.setSourceRectHint(rect);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            builderA.setAutoEnterEnabled(z12);
        }
        PictureInPictureParams pictureInPictureParamsBuild = builderA.build();
        try {
            activity.setPictureInPictureParams(pictureInPictureParamsBuild);
        } catch (Throwable unused) {
        }
        return pictureInPictureParamsBuild;
    }

    @Override // com.transsion.videofloat.VideoPipManager
    public boolean isPlaying() {
        com.transsion.player.orplayer.f fVar;
        if (this.f60058n && (fVar = this.f60050f) != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.videofloat.VideoPipManager
    public void j(final FragmentActivity activity, final vz.a bean, final FloatActionType actionType, boolean z11) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(bean, "bean");
        Intrinsics.g(actionType, "actionType");
        this.f60062r = true;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            return;
        }
        if (i11 >= 31 && actionType == FloatActionType.HOME) {
            uo.b.f78622a.n("VideoFloat-pip", new String[]{">=android12，触发home键，使用自动模式，不使用home键监听"}, true);
            return;
        }
        if (PermissionX.f48641a.b(activity)) {
            F(activity, bean, actionType);
            return;
        }
        uo.b.f78622a.c("VideoFloat-pip", "画中画 没权限", true);
        int i12 = c.f60069a[actionType.ordinal()];
        if (i12 == 1) {
            V(activity, z11, bean.g(), bean.q(), new Function1<Boolean, Unit>() { // from class: com.transsion.videofloat.manager.VideoPipManagerImp$enterPip$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z12) {
                    if (z12) {
                        this.this$0.F(activity, bean, actionType);
                    }
                }
            });
        } else {
            if (i12 != 2) {
                return;
            }
            activity.finish();
        }
    }

    @Override // com.transsion.videofloat.VideoPipManager
    public boolean k() {
        return this.f60058n;
    }

    @Override // com.transsion.videofloat.VideoPipManager
    public void onPipModeChanged(boolean z11) {
        FragmentActivity fragmentActivity = this.f60047c;
        Object obj = null;
        if (fragmentActivity == null || fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
            uo.b.a.j(uo.b.f78622a, "CommonInfo", "onPipModeChanged, activity:" + fragmentActivity + " isFinishing:" + (fragmentActivity != null ? Boolean.valueOf(fragmentActivity.isFinishing()) : null) + ", " + (fragmentActivity != null ? Boolean.valueOf(fragmentActivity.isDestroyed()) : null), false, 4, null);
            return;
        }
        uo.b.f78622a.n("VideoFloat-pip", new String[]{"onPipModeChanged " + this.f60046b + ", activity:" + fragmentActivity.getClass().getSimpleName() + " onPictureInPictureModeChanged 2， isInPipMode:" + z11}, true);
        if (z11) {
            K(fragmentActivity);
            try {
                Result.Companion companion = Result.Companion;
                PowerManager powerManager = (PowerManager) fragmentActivity.getSystemService("power");
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager != null ? powerManager.newWakeLock(26, "MB::PlayerPip") : null;
                this.f60049e = wakeLockNewWakeLock;
                if (wakeLockNewWakeLock != null) {
                    wakeLockNewWakeLock.acquire();
                    obj = Unit.f68710a;
                }
                Result.m163constructorimpl(obj);
                return;
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
                return;
            }
        }
        ORPlayerView oRPlayerView = this.f60051g;
        if (oRPlayerView != null) {
            oRPlayerView.getKeepScreenOn();
        }
        L();
        try {
            Result.Companion companion3 = Result.Companion;
            PowerManager.WakeLock wakeLock = this.f60049e;
            if (wakeLock != null) {
                wakeLock.release();
            }
            this.f60049e = null;
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th3));
        }
    }
}
