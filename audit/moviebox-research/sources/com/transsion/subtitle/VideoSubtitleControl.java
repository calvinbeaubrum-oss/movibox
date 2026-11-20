package com.transsion.subtitle;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.d0;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.m;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.subtitle.dialog.SubtitleMainDialog2;
import com.transsion.subtitle.helper.LocalVideoUiType;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.j;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class VideoSubtitleControl {
    public final Lazy A;
    public Map<String, String> B;
    public final b C;
    public final VideoSubtitleControl$downloadListener$1 D;
    public long E;
    public final Set<vx.a> F;
    public boolean G;
    public String H;
    public final c I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f58079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f58081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<DubsInfo> f58082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Boolean, Unit> f58083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<Boolean, Boolean, Unit> f58084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function3<String, String, Integer, Unit> f58085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<DubsInfo, Unit> f58086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<List<vx.a>, Unit> f58087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<String, Unit> f58088j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function2<String, String, Unit> f58089k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<vx.a> f58090l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f58091m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f58092n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f58093o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DownloadBean f58094p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.transsion.subtitle.helper.d f58095q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LocalVideoUiType f58096r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final k0 f58097s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Map<String, SimpleSubtitleView> f58098t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewGroup f58099u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<LocalVideoUiType, Map<String, SimpleSubtitleView>> f58100v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map<LocalVideoUiType, ViewGroup> f58101w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function1<? super String, Unit> f58102x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Map<LocalVideoUiType, Function2<View, Boolean, Unit>> f58103y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Map<LocalVideoUiType, Function1<View, Unit>> f58104z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements y7.a {
        public a() {
        }

        @Override // y7.a
        public long getCurrentPosition() {
            return VideoSubtitleControl.this.f58092n;
        }

        @Override // y7.a
        public Float getSpeed() {
            return Float.valueOf(VideoSubtitleControl.this.f58081c);
        }

        @Override // y7.a
        public boolean isPlaying() {
            return VideoSubtitleControl.this.J();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements xx.c {
        public b() {
        }

        @Override // xx.c
        public void T(boolean z11, DownloadBean bean) {
            Intrinsics.g(bean, "bean");
            String resourceId = bean.getResourceId();
            DownloadBean downloadBean = VideoSubtitleControl.this.f58094p;
            if (Intrinsics.b(resourceId, downloadBean != null ? downloadBean.getResourceId() : null) && z11 && VideoSubtitleControl.this.f58090l.isEmpty()) {
                com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.this.getClass().getSimpleName() + " --> -------- 检测到有字幕但是在下载中");
            }
        }

        @Override // xx.c
        public void b(vx.a aVar) {
            xx.c.a.b(this, aVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements xx.b {
        public c() {
        }

        @Override // xx.b
        public SimpleSubtitleView a() {
            return (SimpleSubtitleView) VideoSubtitleControl.this.f58098t.get("bottom");
        }

        @Override // xx.b
        public void b(boolean z11) {
            VideoSubtitleControl.this.O(z11);
            VideoSubtitleControl.this.U(null, z11);
        }

        @Override // xx.b
        public void c(String msg) {
            Intrinsics.g(msg, "msg");
            Function1 function1 = VideoSubtitleControl.this.f58088j;
            if (function1 != null) {
                function1.invoke(msg);
            }
        }

        @Override // xx.b
        public SimpleSubtitleView d() {
            return (SimpleSubtitleView) VideoSubtitleControl.this.f58098t.get("top");
        }

        @Override // xx.b
        public void e(boolean z11) {
            VideoSubtitleControl.this.G = z11;
            VideoSubtitleControl.this.T(z11);
        }

        @Override // xx.b
        public boolean f() {
            return VideoSubtitleControl.this.G;
        }

        @Override // xx.b
        public void g(DubsInfo info) {
            Intrinsics.g(info, "info");
            VideoSubtitleControl.this.f58086h.invoke(info);
        }

        @Override // xx.b
        public ViewGroup getSubtitleViewGroup() {
            return VideoSubtitleControl.this.f58099u;
        }

        @Override // xx.b
        public com.transsion.subtitle.helper.d h() {
            return VideoSubtitleControl.this.f58095q;
        }

        @Override // xx.b
        public List<vx.a> i() {
            return VideoSubtitleControl.this.f58090l;
        }

        @Override // xx.b
        public void j(vx.a aVar, long j11) {
            if (aVar != null) {
                VideoSubtitleControl.this.V(aVar);
            }
            String strA = aVar != null ? aVar.a() : null;
            if (strA != null) {
                int iHashCode = strA.hashCode();
                if (iHashCode != 0) {
                    if (iHashCode != 50770) {
                        if (iHashCode == 51560 && strA.equals("2nd")) {
                            SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) VideoSubtitleControl.this.f58098t.get("bottom");
                            if (simpleSubtitleView != null) {
                                simpleSubtitleView.subtitleDelay(j11);
                                return;
                            }
                            return;
                        }
                    } else if (strA.equals("1st")) {
                        SimpleSubtitleView simpleSubtitleView2 = (SimpleSubtitleView) VideoSubtitleControl.this.f58098t.get("top");
                        if (simpleSubtitleView2 != null) {
                            simpleSubtitleView2.subtitleDelay(j11);
                            return;
                        }
                        return;
                    }
                } else if (strA.equals("")) {
                    SimpleSubtitleView simpleSubtitleView3 = (SimpleSubtitleView) VideoSubtitleControl.this.f58098t.get("top");
                    if (simpleSubtitleView3 != null) {
                        simpleSubtitleView3.subtitleDelay(j11);
                        return;
                    }
                    return;
                }
            }
            com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.this.getClass().getSimpleName() + " --> onSubtitleDelay() --> 异常");
        }

        @Override // xx.b
        public boolean k() {
            int i11 = RoomAppMMKV.f51271a.a().getInt("subtitle_options_position", 10);
            com.transsion.subtitle.helper.d dVar = VideoSubtitleControl.this.f58095q;
            if (dVar != null) {
                dVar.j(VideoSubtitleControl.this.f58096r, VideoSubtitleControl.this.f58099u, i11);
            }
            return !Intrinsics.b(VideoSubtitleControl.this.H, BucketVersioningConfiguration.OFF);
        }

        @Override // xx.b
        public void l(vx.a aVar, vx.a aVar2, boolean z11) {
            String lanName;
            SubtitleDownloadTable subtitleDownloadTableB;
            SubtitleDownloadTable subtitleDownloadTableB2;
            SubtitleDownloadTable subtitleDownloadTableB3;
            SubtitleDownloadTable subtitleDownloadTableB4;
            String lan;
            SubtitleDownloadTable subtitleDownloadTableB5;
            SubtitleDownloadTable subtitleDownloadTableB6;
            SubtitleDownloadTable subtitleDownloadTableB7;
            VideoSubtitleControl.this.G = z11;
            String lan2 = null;
            com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.this.getClass().getSimpleName() + " --> onSubtitleSelect() --> isOpenBilingual = " + z11 + " --> top = " + ((aVar == null || (subtitleDownloadTableB7 = aVar.b()) == null) ? null : subtitleDownloadTableB7.getName()) + " --> bottom = " + ((aVar2 == null || (subtitleDownloadTableB6 = aVar2.b()) == null) ? null : subtitleDownloadTableB6.getName()));
            Function3 function3 = VideoSubtitleControl.this.f58085g;
            String str = "";
            if (aVar == null || (subtitleDownloadTableB5 = aVar.b()) == null || (lanName = subtitleDownloadTableB5.getLanName()) == null) {
                lanName = "";
            }
            if (aVar != null && (subtitleDownloadTableB4 = aVar.b()) != null && (lan = subtitleDownloadTableB4.getLan()) != null) {
                str = lan;
            }
            function3.invoke(lanName, str, Integer.valueOf((aVar == null || (subtitleDownloadTableB3 = aVar.b()) == null) ? 1 : subtitleDownloadTableB3.getType()));
            Function2 function2 = VideoSubtitleControl.this.f58089k;
            String lan3 = (aVar == null || (subtitleDownloadTableB2 = aVar.b()) == null) ? null : subtitleDownloadTableB2.getLan();
            if (aVar2 != null && (subtitleDownloadTableB = aVar2.b()) != null) {
                lan2 = subtitleDownloadTableB.getLan();
            }
            function2.invoke(lan3, lan2);
            VideoSubtitleControl videoSubtitleControl = VideoSubtitleControl.this;
            videoSubtitleControl.c0(aVar, (SimpleSubtitleView) videoSubtitleControl.f58098t.get("top"), true);
            VideoSubtitleControl videoSubtitleControl2 = VideoSubtitleControl.this;
            videoSubtitleControl2.c0(aVar2, (SimpleSubtitleView) videoSubtitleControl2.f58098t.get("bottom"), false);
            VideoSubtitleControl.this.F.clear();
            if (aVar != null) {
                VideoSubtitleControl.this.F.add(aVar);
            }
            if (aVar2 != null) {
                VideoSubtitleControl.this.F.add(aVar2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoSubtitleControl(FragmentActivity activity, String str, float f11, List<DubsInfo> dubs, Function1<? super Boolean, Unit> loadingCallback, Function2<? super Boolean, ? super Boolean, Unit> controlCallback, Function3<? super String, ? super String, ? super Integer, Unit> subtitleSelected, Function1<? super DubsInfo, Unit> audioSelected, Function1<? super List<vx.a>, Unit> setSublistData, Function1<? super String, Unit> function1, Function2<? super String, ? super String, Unit> subtitleSelectedBilingual) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(dubs, "dubs");
        Intrinsics.g(loadingCallback, "loadingCallback");
        Intrinsics.g(controlCallback, "controlCallback");
        Intrinsics.g(subtitleSelected, "subtitleSelected");
        Intrinsics.g(audioSelected, "audioSelected");
        Intrinsics.g(setSublistData, "setSublistData");
        Intrinsics.g(subtitleSelectedBilingual, "subtitleSelectedBilingual");
        this.f58079a = activity;
        this.f58080b = str;
        this.f58081c = f11;
        this.f58082d = dubs;
        this.f58083e = loadingCallback;
        this.f58084f = controlCallback;
        this.f58085g = subtitleSelected;
        this.f58086h = audioSelected;
        this.f58087i = setSublistData;
        this.f58088j = function1;
        this.f58089k = subtitleSelectedBilingual;
        this.f58090l = new ArrayList();
        this.f58096r = LocalVideoUiType.MIDDLE;
        this.f58097s = l0.a(w0.c());
        this.f58098t = new LinkedHashMap();
        this.f58100v = new LinkedHashMap();
        this.f58101w = new LinkedHashMap();
        this.f58103y = new LinkedHashMap();
        this.f58104z = new LinkedHashMap();
        this.A = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.subtitle.VideoSubtitleControl$videoDetailPlayDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoDetailPlayDao invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).O0();
            }
        });
        this.B = new LinkedHashMap();
        b bVar = new b();
        this.C = bVar;
        VideoSubtitleControl$downloadListener$1 videoSubtitleControl$downloadListener$1 = new VideoSubtitleControl$downloadListener$1(this);
        this.D = videoSubtitleControl$downloadListener$1;
        this.f58095q = new com.transsion.subtitle.helper.d(activity);
        com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> init{} --> VideoSubtitleControl --> 创建了");
        VideoSubtitleManager.Companion companion = VideoSubtitleManager.f58109a;
        companion.a().e(videoSubtitleControl$downloadListener$1);
        companion.a().i(bVar);
        this.F = new LinkedHashSet();
        this.H = "";
        this.I = new c();
    }

    public /* synthetic */ VideoSubtitleControl(FragmentActivity fragmentActivity, String str, float f11, List list, Function1 function1, Function2 function2, Function3 function3, Function1 function4, Function1 function5, Function1 function6, Function2 function7, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, str, f11, (i11 & 8) != 0 ? g.l() : list, function1, function2, function3, function4, function5, (i11 & 512) != 0 ? null : function6, function7);
    }

    public static final void Z(VideoSubtitleControl this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Iterator<Map.Entry<LocalVideoUiType, Function1<View, Unit>>> it = this$0.f58104z.entrySet().iterator();
        while (it.hasNext()) {
            Function1<View, Unit> value = it.next().getValue();
            Intrinsics.f(view, "view");
            value.invoke(view);
        }
        this$0.l0();
    }

    public static final void d0(VideoSubtitleControl this$0, SimpleSubtitleView this_apply, vx.a aVar, boolean z11, SimpleSubtitleView simpleSubtitleView, boolean z12) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.f58083e.invoke(Boolean.FALSE);
        this_apply.turnOff(false);
        this_apply.refreshImmediately();
        VideoSubtitleManager.f58109a.a().b(aVar);
        Long delay = aVar.b().getDelay();
        if (delay != null) {
            this_apply.subtitleDelay(delay.longValue());
        }
        com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> setSubtitle() --> refreshImmediately() --> 展示字幕 --> bean.dbBean.name = " + aVar.b().getName() + " --> isTop = " + z11 + "  --> view.hashCode = " + simpleSubtitleView.hashCode() + " -- path = " + aVar.b().getPath());
    }

    public static /* synthetic */ void j0(VideoSubtitleControl videoSubtitleControl, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        videoSubtitleControl.i0(z11, z12);
    }

    public final void D(LocalVideoUiType uitType, Function2<? super View, ? super Boolean, Unit> switchCallback, Function1<? super View, Unit> settingCallback) {
        Intrinsics.g(uitType, "uitType");
        Intrinsics.g(switchCallback, "switchCallback");
        Intrinsics.g(settingCallback, "settingCallback");
        this.f58103y.put(uitType, switchCallback);
        this.f58104z.put(uitType, settingCallback);
    }

    public final Map<vx.a, Long> E() {
        return new LinkedHashMap();
    }

    public final VideoDetailPlayDao F() {
        return (VideoDetailPlayDao) this.A.getValue();
    }

    public final void G() {
        for (Map.Entry<String, SimpleSubtitleView> entry : this.f58098t.entrySet()) {
            SimpleSubtitleView value = entry.getValue();
            if (value != null) {
                value.turnOff(true);
            }
            SimpleSubtitleView value2 = entry.getValue();
            if (value2 != null) {
                value2.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x01d0  */
    public final void H() {
        String lanName;
        SubtitleDownloadTable subtitleDownloadTableB;
        Long delay;
        SubtitleDownloadTable subtitleDownloadTableB2;
        String path;
        SubtitleDownloadTable subtitleDownloadTableB3;
        SubtitleDownloadTable subtitleDownloadTableB4;
        String lan;
        SubtitleDownloadTable subtitleDownloadTableB5;
        Locale localeA = com.transsion.subtitle.helper.c.a();
        com.transsion.subtitle.a aVar = com.transsion.subtitle.a.f58119a;
        aVar.a(VideoSubtitleControl.class.getSimpleName() + " --> initDefaultSubtitle() --> cur language = " + localeA.getLanguage() + " -- country = " + localeA.getCountry());
        String str = "";
        String string = RoomAppMMKV.f51271a.a().getString("k_subtitle_language", "");
        DownloadBean downloadBean = this.f58094p;
        vx.a aVar2 = null;
        String subtitleSelectId = downloadBean != null ? downloadBean.getSubtitleSelectId() : null;
        aVar.a(VideoSubtitleControl.class.getSimpleName() + " --> initDefaultSubtitle() --> savedDiffId = " + subtitleSelectId + " -- savedLan = " + string);
        String id2 = "";
        vx.a aVar3 = null;
        for (vx.a aVar4 : this.f58090l) {
            if (aVar4.d()) {
                if (Intrinsics.b(aVar4.b().getLan(), "en")) {
                    aVar2 = aVar4;
                }
                if ((subtitleSelectId == null || subtitleSelectId.length() == 0) && Intrinsics.b(aVar4.b().getLanAbbr(), localeA.getLanguage())) {
                    id2 = aVar4.b().getId();
                    com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> initDefaultSubtitle() --> 没有自己选择的默认语言，使用手机语言 -- phone set def language = " + id2);
                } else if (Intrinsics.b(aVar4.b().getId(), subtitleSelectId)) {
                    id2 = aVar4.b().getId();
                    com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> initDefaultSubtitle() --> 使用之前选择的字幕 saved flag = " + id2);
                } else if (subtitleSelectId == null || subtitleSelectId.length() == 0) {
                    if (Intrinsics.b(aVar4.b().getLanName(), string)) {
                        id2 = aVar4.b().getId();
                        com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> initDefaultSubtitle() --> 使用之前选择的语言 local set savedLan = " + string);
                    }
                }
                aVar3 = aVar4;
            }
        }
        if (id2.length() != 0) {
            aVar2 = aVar3;
        } else if (aVar2 != null && aVar2.d()) {
            id2 = aVar2.b().getId();
            com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> initDefaultSubtitle() --> 没有设置默认语言 --> english set def language = " + id2);
        } else if (!this.f58090l.isEmpty()) {
            Iterator<vx.a> it = this.f58090l.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar2 = aVar3;
                    break;
                }
                vx.a next = it.next();
                if (next.d()) {
                    id2 = next.b().getId();
                    aVar2 = next;
                    break;
                }
            }
            if (id2.length() == 0) {
                com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> initDefaultSubtitle() --> 可能外部只读取到了数据库前面没下载的字幕 --> 没有对应的语言，不设置，需要用户手动设置或当前下载后自动设置上");
                return;
            }
        } else {
            aVar2 = aVar3;
        }
        this.H = id2;
        Function3<String, String, Integer, Unit> function3 = this.f58085g;
        if (aVar2 == null || (subtitleDownloadTableB5 = aVar2.b()) == null || (lanName = subtitleDownloadTableB5.getLanName()) == null) {
            lanName = "";
        }
        if (aVar2 != null && (subtitleDownloadTableB4 = aVar2.b()) != null && (lan = subtitleDownloadTableB4.getLan()) != null) {
            str = lan;
        }
        function3.invoke(lanName, str, Integer.valueOf((aVar2 == null || (subtitleDownloadTableB3 = aVar2.b()) == null) ? 1 : subtitleDownloadTableB3.getType()));
        if (aVar2 != null && (subtitleDownloadTableB2 = aVar2.b()) != null && (path = subtitleDownloadTableB2.getPath()) != null) {
            Iterator<Map.Entry<String, SimpleSubtitleView>> it2 = this.f58098t.entrySet().iterator();
            while (it2.hasNext()) {
                SimpleSubtitleView value = it2.next().getValue();
                if (value != null) {
                    value.setDefaultSubtitle(path);
                }
            }
        }
        if (aVar2 != null) {
            aVar2.l(true);
        }
        if (aVar2 != null && (subtitleDownloadTableB = aVar2.b()) != null && (delay = subtitleDownloadTableB.getDelay()) != null) {
            long jLongValue = delay.longValue();
            uo.b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), "default delayDuration = " + jLongValue, true);
            Iterator<Map.Entry<String, SimpleSubtitleView>> it3 = this.f58098t.entrySet().iterator();
            while (it3.hasNext()) {
                SimpleSubtitleView value2 = it3.next().getValue();
                if (value2 != null) {
                    value2.subtitleDelay(jLongValue);
                }
            }
        }
        if (aVar2 != null) {
            this.F.add(aVar2);
        }
        c0(aVar2, this.f58098t.get("top"), true);
    }

    public final void I(SimpleSubtitleView simpleSubtitleView) {
        Unit unit;
        if (simpleSubtitleView != null) {
            simpleSubtitleView.initSubtitle(new a(), false);
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> vdSubtitle --> initSubtitle() --> null");
        }
    }

    public final boolean J() {
        return this.f58093o;
    }

    public final boolean K() {
        Iterator<T> it = this.f58090l.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (!((vx.a) it.next()).b().isInner()) {
                i11++;
            }
        }
        return i11 > 1;
    }

    public final void L() {
        com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> onDestroy()");
        for (Map.Entry<String, SimpleSubtitleView> entry : this.f58098t.entrySet()) {
            SimpleSubtitleView value = entry.getValue();
            if (value != null) {
                value.stop();
            }
            SimpleSubtitleView value2 = entry.getValue();
            if (value2 != null) {
                value2.destroy();
            }
        }
        if (this.f58091m) {
            try {
                Result.Companion companion = Result.Companion;
                Iterator<Map.Entry<LocalVideoUiType, Map<String, SimpleSubtitleView>>> it = this.f58100v.entrySet().iterator();
                while (it.hasNext()) {
                    Iterator<Map.Entry<String, SimpleSubtitleView>> it2 = it.next().getValue().entrySet().iterator();
                    while (it2.hasNext()) {
                        SimpleSubtitleView value3 = it2.next().getValue();
                        if (value3 != null) {
                            value3.destroy();
                        }
                    }
                }
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
        this.f58098t.clear();
        this.f58103y.clear();
        this.f58104z.clear();
        VideoSubtitleManager.Companion companion3 = VideoSubtitleManager.f58109a;
        companion3.a().j(this.D);
        companion3.a().h(this.C);
        companion3.a().reset();
    }

    public final void M(vx.a bean) {
        Intrinsics.g(bean, "bean");
        com.transsion.subtitle.a aVar = com.transsion.subtitle.a.f58119a;
        aVar.a(VideoSubtitleControl.class.getSimpleName() + " --> onDetailPageSubtitleSelect--> " + bean.b().getLan() + ", " + bean.b().getLanName() + ", " + bean.d());
        if (bean.d()) {
            this.I.l(bean, null, false);
            return;
        }
        if (!f.f49475a.e()) {
            h.f50034a.k(com.transsion.baseui.R$string.base_network_fail);
            return;
        }
        bean.b().setStatus(2);
        String simpleName = VideoSubtitleControl.class.getSimpleName();
        DownloadBean downloadBean = this.f58094p;
        String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
        aVar.a(simpleName + " --> DetailPage downloadSubtitle() --> 内置字幕列表，下载字幕，name = " + totalTitleName + ", subtype = " + bean.b().getType() + ",\"  download subtitleName = " + bean.b().getSubtitleName() + ", subResourceId = " + bean.b().getResourceId() + "~");
        VideoSubtitleManager.f58109a.a().g(bean);
    }

    public final void N(LocalVideoUiType type) {
        SimpleSubtitleView simpleSubtitleView;
        Intrinsics.g(type, "type");
        this.f58096r = type;
        if (this.f58091m) {
            Map<String, SimpleSubtitleView> linkedHashMap = this.f58100v.get(type);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
            this.f58098t = linkedHashMap;
            this.f58099u = this.f58101w.get(this.f58096r);
            com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> onLocalUiChanged() --> currentUiType = " + this.f58096r + " --> subtitleSelectList.size = " + this.F.size());
            for (vx.a aVar : this.F) {
                boolean z11 = true;
                if (this.G) {
                    String strA = aVar.a();
                    int iHashCode = strA.hashCode();
                    if (iHashCode != 0) {
                        if (iHashCode != 50770) {
                            simpleSubtitleView = (iHashCode == 51560 && strA.equals("2nd")) ? this.f58098t.get("bottom") : null;
                            z11 = false;
                        } else if (strA.equals("1st")) {
                            simpleSubtitleView = this.f58098t.get("top");
                        }
                        z11 = false;
                    } else if (strA.equals("")) {
                        simpleSubtitleView = this.f58098t.get("top");
                    } else {
                        z11 = false;
                    }
                    c0(aVar, simpleSubtitleView, z11);
                } else {
                    c0(aVar, this.f58098t.get("top"), true);
                }
            }
        }
        com.transsion.subtitle.helper.d dVar = this.f58095q;
        if (dVar != null) {
            dVar.i(this.f58098t.get("top"), this.f58098t.get("bottom"), type, this.f58099u);
        }
        com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> onLocalUiChanged() --> 页面切换刷新字幕位置信息");
    }

    public final void O(boolean z11) {
        com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> onSubtitleSwitchClick() --> turnOn = " + z11 + " --> 字幕开关状态变化");
        if (z11) {
            this.H = "";
            k0();
        } else {
            this.H = BucketVersioningConfiguration.OFF;
            G();
        }
        if (!z11) {
            this.f58085g.invoke(BucketVersioningConfiguration.OFF, BucketVersioningConfiguration.OFF, 0);
        } else if (!this.F.isEmpty()) {
            vx.a aVar = (vx.a) CollectionsKt___CollectionsKt.d0(this.F);
            Function3<String, String, Integer, Unit> function3 = this.f58085g;
            String lanName = aVar.b().getLanName();
            if (lanName == null) {
                lanName = "";
            }
            String lan = aVar.b().getLan();
            function3.invoke(lanName, lan != null ? lan : "", Integer.valueOf(aVar.b().getType()));
        }
        if (z11 && K()) {
            l0();
        }
    }

    public final void P() {
        Iterator<Map.Entry<String, SimpleSubtitleView>> it = this.f58098t.entrySet().iterator();
        while (it.hasNext()) {
            SimpleSubtitleView value = it.next().getValue();
            if (value != null) {
                value.pause();
            }
        }
    }

    public final void Q(long j11) {
        this.E = j11;
    }

    public final void R() {
        Iterator<Map.Entry<String, SimpleSubtitleView>> it = this.f58098t.entrySet().iterator();
        while (it.hasNext()) {
            SimpleSubtitleView value = it.next().getValue();
            if (value != null) {
                value.resume();
            }
        }
    }

    @Deprecated
    public final void S() {
    }

    public final void T(boolean z11) {
        String str = this.f58080b;
        if (str == null || str.length() == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("bilingual", String.valueOf(z11));
        m.f51277a.m(this.f58080b, "click", linkedHashMap);
    }

    public final void U(vx.a aVar, boolean z11) {
        String subjectId;
        String resourceId;
        String lan;
        String lanName;
        SubtitleDownloadTable subtitleDownloadTableB;
        SubtitleDownloadTable subtitleDownloadTableB2;
        String id2;
        SubtitleDownloadTable subtitleDownloadTableB3;
        SubtitleDownloadTable subtitleDownloadTableB4;
        SubtitleDownloadTable subtitleDownloadTableB5;
        SubtitleDownloadTable subtitleDownloadTableB6;
        SubtitleDownloadTable subtitleDownloadTableB7;
        SubtitleDownloadTable subtitleDownloadTableB8;
        String str = this.f58080b;
        if (str == null || str.length() == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DownloadBean downloadBean = this.f58094p;
        String str2 = "";
        if (downloadBean == null || (subjectId = downloadBean.getSubjectId()) == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        DownloadBean downloadBean2 = this.f58094p;
        if (downloadBean2 == null || (resourceId = downloadBean2.getResourceId()) == null) {
            resourceId = "";
        }
        linkedHashMap.put("resource_id", resourceId);
        Integer numValueOf = null;
        if (aVar != null && (subtitleDownloadTableB7 = aVar.b()) != null && subtitleDownloadTableB7.getEp() > 0) {
            linkedHashMap.put("ep", String.valueOf((aVar == null || (subtitleDownloadTableB8 = aVar.b()) == null) ? null : Integer.valueOf(subtitleDownloadTableB8.getEp())));
        }
        if (aVar != null && (subtitleDownloadTableB5 = aVar.b()) != null && subtitleDownloadTableB5.getSe() > 0) {
            linkedHashMap.put("se", String.valueOf((aVar == null || (subtitleDownloadTableB6 = aVar.b()) == null) ? null : Integer.valueOf(subtitleDownloadTableB6.getSe())));
        }
        if (aVar == null || (subtitleDownloadTableB4 = aVar.b()) == null || (lan = subtitleDownloadTableB4.getLan()) == null) {
            lan = "";
        }
        linkedHashMap.put("lan", lan);
        if (aVar == null || (subtitleDownloadTableB3 = aVar.b()) == null || (lanName = subtitleDownloadTableB3.getLanName()) == null) {
            lanName = "";
        }
        linkedHashMap.put("lan_name", lanName);
        if (aVar != null && (subtitleDownloadTableB2 = aVar.b()) != null && (id2 = subtitleDownloadTableB2.getId()) != null) {
            str2 = id2;
        }
        linkedHashMap.put("id", str2);
        if (aVar != null && (subtitleDownloadTableB = aVar.b()) != null) {
            numValueOf = Integer.valueOf(subtitleDownloadTableB.getType());
        }
        linkedHashMap.put("type", String.valueOf(numValueOf));
        linkedHashMap.put("result", z11 ? "1" : "0");
        m.f51277a.m(this.f58080b, "subtitle_switch", linkedHashMap);
    }

    public final void V(vx.a aVar) {
        String str;
        String subjectId;
        String resourceId;
        if (this.B.containsKey(aVar.b().getId()) || (str = this.f58080b) == null || str.length() == 0) {
            return;
        }
        this.B.put(aVar.b().getId(), "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DownloadBean downloadBean = this.f58094p;
        if (downloadBean == null || (subjectId = downloadBean.getSubjectId()) == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        DownloadBean downloadBean2 = this.f58094p;
        if (downloadBean2 == null || (resourceId = downloadBean2.getResourceId()) == null) {
            resourceId = "";
        }
        linkedHashMap.put("resource_id", resourceId);
        if (aVar.b().getEp() > 0) {
            linkedHashMap.put("ep", String.valueOf(aVar.b().getEp()));
        }
        if (aVar.b().getSe() > 0) {
            linkedHashMap.put("se", String.valueOf(aVar.b().getSe()));
        }
        String lan = aVar.b().getLan();
        if (lan == null) {
            lan = "";
        }
        linkedHashMap.put("lan", lan);
        String lanName = aVar.b().getLanName();
        linkedHashMap.put("lan_name", lanName != null ? lanName : "");
        linkedHashMap.put("id", aVar.b().getId());
        linkedHashMap.put("type", String.valueOf(aVar.b().getType()));
        m.f51277a.m(this.f58080b, "subtitle_sync", linkedHashMap);
    }

    public final void W() {
        this.H = "";
        this.f58090l.clear();
        for (Map.Entry<String, SimpleSubtitleView> entry : this.f58098t.entrySet()) {
            SimpleSubtitleView value = entry.getValue();
            if (value != null) {
                value.reset();
            }
            SimpleSubtitleView value2 = entry.getValue();
            if (value2 != null) {
                so.c.g(value2);
            }
        }
        com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> reset() --> 重置资源");
        VideoSubtitleManager.f58109a.a().reset();
    }

    public final void X(vx.a aVar) {
        SubtitleDownloadTable subtitleDownloadTableB;
        SubtitleDownloadTable subtitleDownloadTableB2;
        SubtitleDownloadTable subtitleDownloadTableB3;
        SubtitleDownloadTable subtitleDownloadTableB4;
        if (aVar != null && (subtitleDownloadTableB4 = aVar.b()) != null && subtitleDownloadTableB4.isInner()) {
            RoomAppMMKV.f51271a.a().putString("k_subtitle_language", aVar.b().getLanName());
        }
        com.transsion.subtitle.a aVar2 = com.transsion.subtitle.a.f58119a;
        String simpleName = VideoSubtitleControl.class.getSimpleName();
        DownloadBean downloadBean = this.f58094p;
        aVar2.a(simpleName + " --> saveSelectedFlag() --> saveSelectId = " + (downloadBean != null ? downloadBean.getSubjectId() : null) + " -- id = " + ((aVar == null || (subtitleDownloadTableB3 = aVar.b()) == null) ? null : subtitleDownloadTableB3.getId()));
        DownloadBean downloadBean2 = this.f58094p;
        if (downloadBean2 != null) {
            downloadBean2.setSubtitleSelectId((aVar == null || (subtitleDownloadTableB2 = aVar.b()) == null) ? null : subtitleDownloadTableB2.getId());
        }
        Function1<? super String, Unit> function1 = this.f58102x;
        if (function1 != null) {
            function1.invoke((aVar == null || (subtitleDownloadTableB = aVar.b()) == null) ? null : subtitleDownloadTableB.getId());
        }
        j.d(l0.a(w0.b()), null, null, new VideoSubtitleControl$saveSelectedFlag$1(this, aVar, null), 3, null);
    }

    public final void Y(LocalVideoUiType uiType, TextView textView, SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, ViewGroup viewGroup, boolean z11) {
        Intrinsics.g(uiType, "uiType");
        this.f58091m = z11;
        this.f58099u = viewGroup;
        this.f58098t.put("top", simpleSubtitleView);
        this.f58098t.put("bottom", simpleSubtitleView2);
        if (z11) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("top", simpleSubtitleView);
            linkedHashMap.put("bottom", simpleSubtitleView2);
            this.f58100v.put(uiType, linkedHashMap);
            this.f58101w.put(uiType, this.f58099u);
        }
        VideoSubtitleManager.f58109a.a().reset();
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoSubtitleControl.Z(this.f58120a, view);
                }
            });
        }
        if (simpleSubtitleView != null) {
            I(simpleSubtitleView);
        }
        if (simpleSubtitleView2 != null) {
            I(simpleSubtitleView2);
        }
        com.transsion.subtitle.helper.d dVar = this.f58095q;
        if (dVar != null) {
            dVar.i(simpleSubtitleView, simpleSubtitleView2, uiType, viewGroup);
        }
        com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> setData() --> uiType = " + uiType + " --> END");
    }

    public final void a0(boolean z11) {
        this.f58093o = z11;
    }

    public final void b0(Function1<? super String, Unit> function1) {
        this.f58102x = function1;
    }

    public final void c0(final vx.a aVar, final SimpleSubtitleView simpleSubtitleView, final boolean z11) {
        String id2;
        SubtitleDownloadTable subtitleDownloadTableB;
        if (aVar == null || (subtitleDownloadTableB = aVar.b()) == null || (id2 = subtitleDownloadTableB.getId()) == null) {
            id2 = "";
        }
        this.H = id2;
        if (aVar == null) {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.turnOff(true);
                simpleSubtitleView.setVisibility(8);
            }
            com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> setSubtitle() --> " + (z11 ? "topBean" : "bottomBean") + " == null --> isTop = " + z11 + " --> view.hashCode = " + (simpleSubtitleView != null ? simpleSubtitleView.hashCode() : 0));
            return;
        }
        if (simpleSubtitleView == null) {
            com.transsion.subtitle.a.f58119a.b(VideoSubtitleControl.class.getSimpleName() + " --> setSubtitle() --> subtitleView ==null --> isTop = " + z11);
            return;
        }
        simpleSubtitleView.setVisibility(0);
        String path = aVar.b().getPath();
        if (path == null) {
            path = "";
        }
        simpleSubtitleView.setSubtitlePath(path, com.transsion.subtitle.helper.c.b(aVar));
        String path2 = aVar.b().getPath();
        simpleSubtitleView.selectSubtitle(path2 != null ? path2 : "", com.transsion.subtitle.helper.c.b(aVar), new y7.b() { // from class: com.transsion.subtitle.c
            @Override // y7.b
            public final void a(boolean z12) {
                VideoSubtitleControl.d0(this.f58124a, simpleSubtitleView, aVar, z11, simpleSubtitleView, z12);
            }
        });
        Function1<? super String, Unit> function1 = this.f58102x;
        if (function1 != null) {
            function1.invoke(aVar.b().getId());
        }
    }

    public final void e0(List<vx.a> list) {
        W();
        List<vx.a> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            if (!this.f58090l.isEmpty()) {
                return;
            }
            com.transsion.subtitle.a aVar = com.transsion.subtitle.a.f58119a;
            String simpleName = VideoSubtitleControl.class.getSimpleName();
            DownloadBean downloadBean = this.f58094p;
            aVar.a(simpleName + " --> setSubtitleDataList() --> 无字幕 --> subtitleResId:" + (downloadBean != null ? downloadBean.getSubtitleResId() : null));
            return;
        }
        com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> setSubtitleDataList() --> 当前可用字幕数量 -- size = " + list.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ListIterator<vx.a> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            vx.a next = listIterator.next();
            next.l(false);
            if (linkedHashMap.containsKey(next.b().getId()) && linkedHashMap.containsValue(next.b().getName())) {
                com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> setSubtitleDataList() --> Repeated，remove~  name = " + next.b().getName());
                listIterator.remove();
            } else {
                linkedHashMap.put(next.b().getId(), next.b().getName());
            }
        }
        if (list.size() > 1) {
            kotlin.collections.j.z(list, new Comparator() { // from class: com.transsion.subtitle.VideoSubtitleControl$setSubtitleDataList$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return kotlin.comparisons.b.d(Integer.valueOf(((vx.a) t11).b().getType()), Integer.valueOf(((vx.a) t12).b().getType()));
                }
            });
        }
        this.f58090l.clear();
        this.f58090l.addAll(list);
        this.f58087i.invoke(this.f58090l);
        H();
    }

    @Deprecated
    public final void f0(xx.a callback) {
        Intrinsics.g(callback, "callback");
    }

    public final void g0(DownloadBean downloadBean) {
        this.f58094p = downloadBean;
    }

    @Deprecated
    public final void h0(Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
    }

    public final void i0(boolean z11, boolean z12) {
        String value;
        Boolean boolY0;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_show_no_subtitle_tips", true);
        if (((configBeanB == null || (value = configBeanB.getValue()) == null || (boolY0 = StringsKt__StringsKt.Y0(value)) == null || !boolY0.booleanValue()) && !z12) || this.f58079a.isDestroyed() || this.f58079a.isFinishing()) {
            return;
        }
        FragmentActivity fragmentActivity = this.f58079a;
        SubtitleMainDialog2 subtitleMainDialog2A = SubtitleMainDialog2.f58131y.a(this.f58096r == LocalVideoUiType.LAND, z11, this.f58082d, this.f58094p, this.f58080b);
        subtitleMainDialog2A.j0(fragmentActivity, "fragment_subtitle_main_dialog");
        subtitleMainDialog2A.H0(this.I);
    }

    public final void k0() {
        int i11 = 0;
        for (Object obj : this.F) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            vx.a aVar = (vx.a) obj;
            if (i11 == 0) {
                c0(aVar, this.f58098t.get("top"), true);
            } else if (i11 == 1) {
                c0(aVar, this.f58098t.get("bottom"), false);
            }
            i11 = i12;
        }
    }

    public final void l0() {
        if (this.f58090l.isEmpty()) {
            i0(false, true);
            return;
        }
        FragmentActivity fragmentActivity = this.f58079a;
        SubtitleMainDialog2.a aVar = SubtitleMainDialog2.f58131y;
        boolean z11 = this.f58096r == LocalVideoUiType.LAND;
        boolean zB = Intrinsics.b(this.H, BucketVersioningConfiguration.OFF);
        List<vx.a> list = this.f58090l;
        List<DubsInfo> list2 = this.f58082d;
        DownloadBean downloadBean = this.f58094p;
        LocalVideoUiType localVideoUiType = this.f58096r;
        com.transsion.subtitle.helper.d dVar = this.f58095q;
        SubtitleMainDialog2 subtitleMainDialog2B = aVar.b(z11, zB, list, list2, downloadBean, localVideoUiType, Integer.valueOf(dVar != null ? dVar.h(localVideoUiType) : d0.c()), this.f58080b);
        subtitleMainDialog2B.H0(this.I);
        subtitleMainDialog2B.L0(new Function1<vx.a, Unit>() { // from class: com.transsion.subtitle.VideoSubtitleControl$showSubtitleSelect$1$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(vx.a aVar2) {
                invoke2(aVar2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(vx.a bean) {
                Intrinsics.g(bean, "bean");
                this.this$0.m0(bean);
            }
        });
        subtitleMainDialog2B.j0(fragmentActivity, "fragment_subtitle_main_dialog");
    }

    public final void m0(vx.a aVar) {
        String string;
        com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 搜索字幕选中 --> 直接设置使用 --> isOpenBilingual = " + this.G);
        String str = "";
        if (this.G) {
            for (vx.a aVar2 : this.f58090l) {
                if (aVar2.f() && TextUtils.equals(aVar2.a(), "1st")) {
                    aVar2.l(false);
                    aVar2.g("");
                    com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 这里默认替换 1st --> it.isSelect = false");
                }
            }
            for (vx.a aVar3 : this.f58090l) {
                if (Intrinsics.b(aVar3.b().getId(), aVar.b().getId())) {
                    aVar3.l(true);
                    aVar3.g("1st");
                    com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 这里默认替换 1st --> it.isSelect = true");
                }
            }
        } else {
            for (vx.a aVar4 : this.f58090l) {
                if (aVar4.f()) {
                    aVar4.l(false);
                }
            }
            com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 能从搜索选中回调，一定在字幕列表里面了");
            for (vx.a aVar5 : this.f58090l) {
                if (Intrinsics.b(aVar.b().getId(), aVar5.b().getId())) {
                    aVar5.l(true);
                }
            }
            com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 找到ID相同的哪个设置 选中");
        }
        c0(aVar, this.f58098t.get("top"), true);
        com.transsion.subtitle.a.f58119a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 设置字幕 --> bean.id = " + aVar.b().getId());
        Function1<String, Unit> function1 = this.f58088j;
        if (function1 != null) {
            Application applicationA = Utils.a();
            if (applicationA != null && (string = applicationA.getString(R$string.subtitle_switch_toast)) != null) {
                str = string;
            }
            function1.invoke(str);
        }
    }

    public final void n0(List<DubsInfo> dubs) {
        Intrinsics.g(dubs, "dubs");
        this.f58082d = dubs;
    }

    public final void o0(long j11) {
        this.f58092n = j11;
    }

    public final void p0(float f11) {
        this.f58081c = f11;
    }
}
