package com.transsion.player.longvideo.helper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class r {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f54430k = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mv.i f54431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f54432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f54433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public mv.c f54434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f54435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f54436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f54437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f54438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f54439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f54440j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public r(mv.i viewBinding, Function0<Unit> continuePlaCallback) {
        String value;
        Intrinsics.g(viewBinding, "viewBinding");
        Intrinsics.g(continuePlaCallback, "continuePlaCallback");
        this.f54431a = viewBinding;
        this.f54432b = continuePlaCallback;
        this.f54438h = new Handler(Looper.getMainLooper());
        this.f54439i = new Handler(Looper.getMainLooper());
        this.f54440j = new Handler(Looper.getMainLooper());
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sa_data_operator_config", false, 2, null);
        if (configBeanC != null && (value = configBeanC.getValue()) != null) {
            this.f54433c = (b) com.blankj.utilcode.util.n.d(value, b.class);
        }
        b bVar = this.f54433c;
        if (bVar != null) {
            mv.d dVar = viewBinding.f71242o.f71271s;
            dVar.f71199f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.v(this.f54424a, view);
                }
            });
            dVar.f71197c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.w(this.f54425a, view);
                }
            });
            String strL = bVar.l();
            if (strL != null) {
                dVar.f71201h.setText(strL);
            }
            String strK = bVar.k();
            if (strK != null) {
                dVar.f71200g.setText(strK);
            }
            String strA = bVar.a();
            if (strA != null) {
                dVar.f71198d.setText(strA);
            }
            String strB = bVar.b();
            if (strB != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = dVar.f71196b.getContext();
                Intrinsics.f(context, "ivMore.context");
                AppCompatImageView ivMore = dVar.f71196b;
                Intrinsics.f(ivMore, "ivMore");
                companion.r(context, ivMore, strB, (4088 & 8) != 0 ? companion.d() : gs.a.a(16), (4088 & 16) != 0 ? companion.c() : gs.a.a(16), (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            }
            mv.d dVar2 = viewBinding.f71243p.f71289l;
            dVar2.f71199f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.t(this.f54426a, view);
                }
            });
            dVar2.f71197c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.u(this.f54427a, view);
                }
            });
            String strL2 = bVar.l();
            if (strL2 != null) {
                dVar2.f71201h.setText(strL2);
            }
            String strK2 = bVar.k();
            if (strK2 != null) {
                dVar2.f71200g.setText(strK2);
            }
            String strA2 = bVar.a();
            if (strA2 != null) {
                dVar2.f71198d.setText(strA2);
            }
            String strB2 = bVar.b();
            if (strB2 != null) {
                ImageHelper.Companion companion2 = ImageHelper.f51371a;
                Context context2 = dVar2.f71196b.getContext();
                Intrinsics.f(context2, "ivMore.context");
                AppCompatImageView ivMore2 = dVar2.f71196b;
                Intrinsics.f(ivMore2, "ivMore");
                companion2.r(context2, ivMore2, strB2, (4088 & 8) != 0 ? companion2.d() : gs.a.a(16), (4088 & 16) != 0 ? companion2.c() : gs.a.a(16), (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            }
        }
    }

    public static final void C(r this_runCatching) {
        Intrinsics.g(this_runCatching, "$this_runCatching");
        try {
            Result.Companion companion = Result.Companion;
            this_runCatching.r();
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public static final void k(r this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.B(true);
    }

    public static final void m(r this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.B(false);
    }

    public static final void p(r this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "LongVodMobileData", "click-- play with mobile data", false, 4, null);
        nv.a.f72164a.c(true);
        this$0.f54432b.invoke();
        this$0.n();
    }

    public static final void q(r this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "LongVodMobileData", "click-- page openDeeplink", false, 4, null);
        this$0.x();
    }

    public static final void t(r this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.r();
    }

    public static final void u(r this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "LongVodMobileData", "click-- float openDeeplink", false, 4, null);
        this$0.x();
    }

    public static final void v(r this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.r();
    }

    public static final void w(r this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "LongVodMobileData", "click-- float openDeeplink", false, 4, null);
        this$0.x();
    }

    public final void A() {
        ConstraintLayout root;
        mv.c cVar = this.f54434d;
        if (cVar == null || (root = cVar.getRoot()) == null) {
            return;
        }
        so.c.g(root);
    }

    public final void B(boolean z11) {
        try {
            Result.Companion companion = Result.Companion;
            uo.b.a.f(uo.b.f78622a, "LongVodMobileData", "showOperatorLayout", false, 4, null);
            if (z11) {
                BLLinearLayout root = this.f54431a.f71242o.f71271s.getRoot();
                Intrinsics.f(root, "viewBinding.layoutLand.operatorLayout.root");
                so.c.k(root);
            } else {
                BLLinearLayout root2 = this.f54431a.f71243p.f71289l.getRoot();
                Intrinsics.f(root2, "viewBinding.layoutMiddle.operatorLayout.root");
                so.c.k(root2);
            }
            b bVar = this.f54433c;
            int iJ = bVar != null ? bVar.j() : 10;
            this.f54440j.removeCallbacksAndMessages(null);
            Result.m163constructorimpl(Boolean.valueOf(this.f54440j.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.q
                @Override // java.lang.Runnable
                public final void run() {
                    r.C(this.f54429a);
                }
            }, ((long) iJ) * 1000)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void j() {
        ConstraintLayout root;
        mv.c cVar = this.f54434d;
        if (cVar != null && (root = cVar.getRoot()) != null && root.getVisibility() == 0) {
            uo.b.a.s(uo.b.f78622a, "LongVodMobileData", "checkFullscreenPageShowOperator, mobile ui show~~", false, 4, null);
            return;
        }
        if (this.f54436f) {
            uo.b.a.s(uo.b.f78622a, "LongVodMobileData", "checkFullscreenPageShowOperator shown return", false, 4, null);
            return;
        }
        if (!s()) {
            uo.b.a.s(uo.b.f78622a, "LongVodMobileData", "checkFullscreenPageShowOperator intercept--", false, 4, null);
            return;
        }
        this.f54436f = true;
        b bVar = this.f54433c;
        int iD = bVar != null ? bVar.d() : 3;
        uo.b.a.s(uo.b.f78622a, "LongVodMobileData", "checkFullscreenPageShowOperator delay show:" + iD + "s", false, 4, null);
        this.f54438h.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.i
            @Override // java.lang.Runnable
            public final void run() {
                r.k(this.f54421a);
            }
        }, ((long) iD) * 1000);
    }

    public final void l() {
        if (this.f54437g) {
            return;
        }
        if (this.f54435e) {
            uo.b.a.s(uo.b.f78622a, "LongVodMobileData", "checkMiddlePageShowOperator shown return", false, 4, null);
            return;
        }
        if (!s()) {
            uo.b.a.s(uo.b.f78622a, "LongVodMobileData", "checkMiddlePageShowOperator config--", false, 4, null);
            return;
        }
        this.f54435e = true;
        b bVar = this.f54433c;
        int i11 = bVar != null ? bVar.i() : 3;
        uo.b.a.s(uo.b.f78622a, "LongVodMobileData", "checkMiddlePageShowOperator delay show:" + i11 + "s", false, 4, null);
        this.f54439i.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.p
            @Override // java.lang.Runnable
            public final void run() {
                r.m(this.f54428a);
            }
        }, ((long) i11) * 1000);
    }

    public final void n() {
        if (this.f54437g) {
            j();
        } else {
            l();
        }
    }

    public final void o() {
        BLTextView longVdTvOperator;
        AppCompatTextView longVodTvTips;
        BLTextView longVdTvOperator2;
        AppCompatTextView longVodTvTips2;
        ConstraintLayout root;
        uo.b.a aVar = uo.b.f78622a;
        aVar.c("LongVodMobileData", "onPrepare2PlayVideo, is mobile , pause video. show layout", true);
        if (this.f54434d == null) {
            this.f54434d = mv.c.a(this.f54431a.B.inflate());
        }
        mv.c cVar = this.f54434d;
        if (cVar != null && (root = cVar.getRoot()) != null) {
            so.c.k(root);
        }
        mv.c cVar2 = this.f54434d;
        if (cVar2 != null) {
            if (cVar2 != null && (longVodTvTips2 = cVar2.f71193d) != null) {
                Intrinsics.f(longVodTvTips2, "longVodTvTips");
                so.c.g(longVodTvTips2);
            }
            mv.c cVar3 = this.f54434d;
            if (cVar3 != null && (longVdTvOperator2 = cVar3.f71191b) != null) {
                Intrinsics.f(longVdTvOperator2, "longVdTvOperator");
                so.c.g(longVdTvOperator2);
            }
            if (s()) {
                uo.b.a.f(aVar, "LongVodMobileData", "mobile data layout, show operator ui--------", false, 4, null);
                b bVar = this.f54433c;
                if (bVar != null) {
                    String strG = bVar.g();
                    if (strG != null) {
                        mv.c cVar4 = this.f54434d;
                        AppCompatTextView appCompatTextView = cVar4 != null ? cVar4.f71194f : null;
                        if (appCompatTextView != null) {
                            appCompatTextView.setText(strG);
                        }
                    }
                    String strF = bVar.f();
                    if (strF != null) {
                        mv.c cVar5 = this.f54434d;
                        AppCompatTextView appCompatTextView2 = cVar5 != null ? cVar5.f71193d : null;
                        if (appCompatTextView2 != null) {
                            appCompatTextView2.setText(strF);
                        }
                        mv.c cVar6 = this.f54434d;
                        if (cVar6 != null && (longVodTvTips = cVar6.f71193d) != null) {
                            Intrinsics.f(longVodTvTips, "longVodTvTips");
                            so.c.k(longVodTvTips);
                        }
                    }
                    String strE = bVar.e();
                    if (strE != null) {
                        mv.c cVar7 = this.f54434d;
                        BLTextView bLTextView = cVar7 != null ? cVar7.f71191b : null;
                        if (bLTextView != null) {
                            bLTextView.setText(strE);
                        }
                        mv.c cVar8 = this.f54434d;
                        if (cVar8 != null && (longVdTvOperator = cVar8.f71191b) != null) {
                            Intrinsics.f(longVdTvOperator, "longVdTvOperator");
                            so.c.k(longVdTvOperator);
                        }
                    }
                }
            }
            cVar2.f71192c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.p(this.f54422a, view);
                }
            });
            BLTextView longVdTvOperator3 = cVar2.f71191b;
            Intrinsics.f(longVdTvOperator3, "longVdTvOperator");
            longVdTvOperator3.setVisibility(s() ? 0 : 8);
            cVar2.f71191b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.q(this.f54423a, view);
                }
            });
        }
    }

    public final void r() {
        uo.b.a.f(uo.b.f78622a, "LongVodMobileData", "hideOperatorLayout", false, 4, null);
        BLLinearLayout root = this.f54431a.f71242o.f71271s.getRoot();
        Intrinsics.f(root, "viewBinding.layoutLand.operatorLayout.root");
        so.c.g(root);
        BLLinearLayout root2 = this.f54431a.f71243p.f71289l.getRoot();
        Intrinsics.f(root2, "viewBinding.layoutMiddle.operatorLayout.root");
        so.c.g(root2);
    }

    public final boolean s() {
        b bVar = this.f54433c;
        if (bVar != null) {
            String strH = bVar != null ? bVar.h() : null;
            if (strH != null && strH.length() != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - RoomAppMMKV.f51271a.a().getLong("key_video_operator_last_open_time", 0L);
                b bVar2 = this.f54433c;
                boolean z11 = jCurrentTimeMillis >= ((long) ((bVar2 != null ? bVar2.c() : 0) * 3600000));
                uo.b.f78622a.c("LongVodMobileData", "isShowDataOperator time :" + z11, true);
                return z11;
            }
        }
        uo.b.a.f(uo.b.f78622a, "LongVodMobileData", "isShowDataOperator config is null", false, 4, null);
        return false;
    }

    public final void x() {
        String strH;
        r();
        uo.b.a aVar = uo.b.f78622a;
        b bVar = this.f54433c;
        uo.b.a.f(aVar, "LongVodMobileData", "onOperatorClick link:" + (bVar != null ? bVar.h() : null), false, 4, null);
        b bVar2 = this.f54433c;
        if (bVar2 != null && (strH = bVar2.h()) != null) {
            com.transsion.baselib.utils.i.e(strH, null, 1, null);
        }
        RoomAppMMKV.f51271a.a().putLong("key_video_operator_last_open_time", System.currentTimeMillis());
    }

    public final void y(boolean z11) {
        this.f54437g = z11;
        r();
        if (z11) {
            this.f54439i.removeCallbacksAndMessages(null);
            uo.b.a.s(uo.b.f78622a, "LongVodMobileData", "onScreenChange enter full", false, 4, null);
            j();
        } else {
            this.f54438h.removeCallbacksAndMessages(null);
            uo.b.a.s(uo.b.f78622a, "LongVodMobileData", "onScreenChange exit full to middle page", false, 4, null);
            l();
        }
    }

    public final void z() {
        uo.b.a.f(uo.b.f78622a, "LongVodMobileData", "onVideoStart", false, 4, null);
        n();
    }
}
