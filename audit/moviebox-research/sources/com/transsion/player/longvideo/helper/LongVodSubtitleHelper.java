package com.transsion.player.longvideo.helper;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.postdetail.R$string;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.subtitle.VideoSubtitleManager;
import com.transsion.subtitle.helper.LocalVideoUiType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LongVodSubtitleHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mv.i f54368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<DubsInfo> f54370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f54371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<DubsInfo, Unit> f54372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f54373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<vx.a> f54374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final VideoSubtitleControl f54375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f54376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DownloadBean f54377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public lv.a f54378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f54379l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f54380m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f54381n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final w f54382o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final k0 f54383p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f54384q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements xx.a {
        public a() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54386a;

        static {
            int[] iArr = new int[LongVodUiType.values().length];
            try {
                iArr[LongVodUiType.LAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LongVodUiType.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f54386a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f54387a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f54387a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f54387a;
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
            this.f54387a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LongVodSubtitleHelper(mv.i viewBinding, String str, List<DubsInfo> dubs, u callback, Function1<? super DubsInfo, Unit> function1, boolean z11) {
        Intrinsics.g(viewBinding, "viewBinding");
        Intrinsics.g(dubs, "dubs");
        Intrinsics.g(callback, "callback");
        this.f54368a = viewBinding;
        this.f54369b = str;
        this.f54370c = dubs;
        this.f54371d = callback;
        this.f54372e = function1;
        this.f54373f = z11;
        this.f54374g = new ArrayList();
        this.f54379l = true;
        this.f54383p = l0.a(w0.b());
        this.f54384q = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper$videoDetailPlayDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoDetailPlayDao invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).O0();
            }
        });
        Context context = viewBinding.getRoot().getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        w wVar = (w) new v0((FragmentActivity) context).a(w.class);
        this.f54382o = wVar;
        this.f54379l = RoomAppMMKV.f51271a.a().getBoolean("subtitle_land_guide", true);
        Context context2 = viewBinding.getRoot().getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        VideoSubtitleControl videoSubtitleControl = new VideoSubtitleControl((FragmentActivity) context2, str, LocalVideoPlayerConfigMmkv.f51172a.c(), this.f54370c, new Function1<Boolean, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z12) {
            }
        }, new Function2<Boolean, Boolean, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper.2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z12, boolean z13) {
                if (z12) {
                    LongVodSubtitleHelper.this.f54371d.b(true, z13);
                } else {
                    LongVodSubtitleHelper.this.f54371d.b(false, true);
                }
            }
        }, new Function3<String, String, Integer, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper.3
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str2, String str3, Integer num) {
                invoke(str2, str3, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(String lanName, String lan, int i11) {
                Intrinsics.g(lanName, "lanName");
                Intrinsics.g(lan, "lan");
                LongVodSubtitleHelper.this.f54382o.d().n(new Pair<>(lanName, lan));
                LongVodSubtitleHelper.this.f54371d.g(lanName, lan, i11);
            }
        }, new Function1<DubsInfo, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper.4
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
                Function1 function2 = LongVodSubtitleHelper.this.f54372e;
                if (function2 != null) {
                    function2.invoke(it);
                }
            }
        }, new Function1<List<vx.a>, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<vx.a> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<vx.a> list) {
                Intrinsics.g(list, "list");
                LongVodSubtitleHelper.this.f54382o.c().n(list);
                LongVodSubtitleHelper.this.f54371d.e(list);
            }
        }, new Function1<String, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                u uVar = LongVodSubtitleHelper.this.f54371d;
                if (str2 == null) {
                    str2 = "";
                }
                uVar.c(str2);
            }
        }, new Function2<String, String, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper.7
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str2, String str3) {
                invoke2(str2, str3);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str2, String str3) {
                LongVodSubtitleHelper.this.f54371d.d(str2, str3);
            }
        });
        videoSubtitleControl.N(LocalVideoUiType.MIDDLE);
        videoSubtitleControl.f0(new a());
        videoSubtitleControl.b0(new Function1<String, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper$8$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                this.this$0.f54371d.f(str2);
            }
        });
        this.f54375h = videoSubtitleControl;
        if (this.f54373f) {
            this.f54379l = false;
        }
        c0<vx.a> c0VarB = wVar.b();
        Context context3 = viewBinding.getRoot().getContext();
        Intrinsics.e(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        c0VarB.j((FragmentActivity) context3, new c(new Function1<vx.a, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper.9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(vx.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(vx.a bean) {
                VideoSubtitleControl videoSubtitleControl2 = LongVodSubtitleHelper.this.f54375h;
                Intrinsics.f(bean, "bean");
                videoSubtitleControl2.M(bean);
            }
        }));
    }

    public /* synthetic */ LongVodSubtitleHelper(mv.i iVar, String str, List list, u uVar, Function1 function1, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar, str, list, uVar, function1, (i11 & 32) != 0 ? true : z11);
    }

    public final void A(LongVodUiType uiType) {
        LocalVideoUiType localVideoUiType;
        Intrinsics.g(uiType, "uiType");
        if (uiType == LongVodUiType.LAND) {
            m();
        }
        int i11 = b.f54386a[uiType.ordinal()];
        if (i11 != 1) {
            localVideoUiType = i11 != 2 ? LocalVideoUiType.MIDDLE : LocalVideoUiType.PORTRAIT;
        } else {
            localVideoUiType = LocalVideoUiType.LAND;
        }
        this.f54375h.N(localVideoUiType);
    }

    public final void B(long j11) {
        this.f54375h.Q(j11);
    }

    public final void C() {
        this.f54375h.S();
    }

    public final void D() {
        VideoSubtitleControl videoSubtitleControl = this.f54375h;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.W();
        }
    }

    public final void E(VideoSubtitleControl videoSubtitleControl) {
        LocalVideoUiType localVideoUiType = LocalVideoUiType.MIDDLE;
        TextView textViewQ = q();
        mv.i iVar = this.f54368a;
        videoSubtitleControl.Y(localVideoUiType, textViewQ, iVar.f71252y, iVar.f71251x, iVar.f71238k, false);
        videoSubtitleControl.h0(new Function1<Boolean, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper$setData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                View viewO = this.this$0.o();
                if (viewO != null) {
                    viewO.setVisibility(z11 ? 0 : 8);
                }
                ImageView imageViewP = this.this$0.p();
                if (imageViewP != null) {
                    imageViewP.setVisibility(z11 ^ true ? 0 : 8);
                }
                TextView textViewR = this.this$0.r();
                if (textViewR == null) {
                    return;
                }
                textViewR.setText(Utils.a().getString(z11 ? R$string.play_loading : R$string.turn_on_short));
            }
        });
        videoSubtitleControl.D(localVideoUiType, new Function2<View, Boolean, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper$setData$2
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
                this.this$0.z(switchView, z11);
            }
        }, new Function1<View, Unit>() { // from class: com.transsion.player.longvideo.helper.LongVodSubtitleHelper$setData$3
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
                this.this$0.y(settingView);
            }
        });
    }

    public final void F(boolean z11) {
        this.f54375h.a0(z11);
    }

    public final void G(ViewGroup viewGroup) {
        this.f54381n = viewGroup;
        E(this.f54375h);
    }

    public final void H(List<DubsInfo> dubs) {
        Intrinsics.g(dubs, "dubs");
        this.f54370c = dubs;
        this.f54375h.n0(dubs);
    }

    public final void I(long j11) {
        this.f54375h.o0(j11);
    }

    public final void J(float f11) {
        this.f54375h.p0(f11);
    }

    public final void m() {
        if (!(!this.f54374g.isEmpty()) && this.f54379l) {
            RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
            if (roomAppMMKV.a().getBoolean("subtitle_is_search_downloaded", false)) {
                this.f54379l = false;
                roomAppMMKV.a().putBoolean("subtitle_land_guide", false);
            } else {
                this.f54379l = false;
                roomAppMMKV.a().putBoolean("subtitle_land_guide", false);
                this.f54371d.b(true, false);
            }
        }
    }

    public final void n(DownloadBean downloadBean) {
        this.f54376i = true;
        uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), "流媒体，开始播放检测字幕，name:" + downloadBean.getTotalTitleName() + " subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId(), true);
        VideoSubtitleManager.f58109a.a().d(downloadBean, new LongVodSubtitleHelper$firstStartCheckSub$1(this));
    }

    public final View o() {
        return null;
    }

    public final ImageView p() {
        return null;
    }

    public final TextView q() {
        if (this.f54373f) {
            return this.f54368a.f71242o.f71276x;
        }
        return null;
    }

    public final TextView r() {
        return null;
    }

    public final Map<vx.a, Long> s() {
        return this.f54375h.E();
    }

    public final VideoDetailPlayDao t() {
        return (VideoDetailPlayDao) this.f54384q.getValue();
    }

    public final void u(DownloadBean downloadBean) {
        kotlinx.coroutines.j.d(this.f54383p, null, null, new LongVodSubtitleHelper$loadFromDB$1(downloadBean, this, null), 3, null);
    }

    public final void v() {
        this.f54375h.L();
    }

    public final void w() {
        DownloadBean downloadBean;
        if (this.f54376i || (downloadBean = this.f54377j) == null) {
            return;
        }
        this.f54376i = true;
        uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), "流媒体，网络连接成功开始检测字幕，name:" + downloadBean.getTotalTitleName() + " subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId(), true);
        VideoSubtitleManager.a.a(VideoSubtitleManager.f58109a.a(), downloadBean, null, 2, null);
    }

    public final void x(lv.a bean, lv.c playStream) {
        Intrinsics.g(bean, "bean");
        Intrinsics.g(playStream, "playStream");
        this.f54376i = false;
        this.f54378k = bean;
        String strF = playStream.f();
        String strB = playStream.b();
        String strN = bean.n();
        Long lN = kotlin.text.k.n(playStream.e());
        String strM = bean.m();
        DownloadBean downloadBean = new DownloadBean(strF, strB, strN, "", lN, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, bean.d(), bean.k(), 0, 0, 0, 0, 0, 0, 0, strM, this.f54369b, null, bean.n(), 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1477181472, 1073741823, null);
        downloadBean.setStream(playStream.i());
        downloadBean.setStreamVideoDetail(true);
        this.f54377j = downloadBean;
        this.f54375h.g0(downloadBean);
        DownloadBean downloadBean2 = this.f54377j;
        Intrinsics.d(downloadBean2);
        u(downloadBean2);
    }

    public final void y(View view) {
        mv.j jVar = this.f54368a.f71242o;
        View view2 = this.f54380m;
        if (view2 != null) {
            so.c.g(view2);
        }
    }

    public final void z(View view, boolean z11) {
        this.f54371d.b(true, true);
        u uVar = this.f54371d;
        String string = Utils.a().getString(z11 ? com.transsion.subtitle.R$string.subtitle_turn_on_toast : com.transsion.subtitle.R$string.subtitle_turn_off_toast);
        Intrinsics.f(string, "getApp()\n               ….subtitle_turn_off_toast)");
        uVar.c(string);
    }
}
