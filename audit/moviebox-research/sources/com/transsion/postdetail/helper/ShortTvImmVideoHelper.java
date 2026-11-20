package com.transsion.postdetail.helper;

import android.content.Context;
import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.c0;
import com.blankj.utilcode.util.f0;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.postdetail.R$layout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
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
@SourceDebugExtension
public final class ShortTvImmVideoHelper {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f55051k = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy<ShortTvImmVideoHelper> f55052l = LazyKt__LazyJVMKt.b(new Function0<ShortTvImmVideoHelper>() { // from class: com.transsion.postdetail.helper.ShortTvImmVideoHelper$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ShortTvImmVideoHelper invoke() {
            return new ShortTvImmVideoHelper();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f55054b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f55057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f55058f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<? extends Subject> f55061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f55062j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Subject> f55053a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f55055c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f55056d = LazyKt__LazyJVMKt.b(new Function0<c0<List<? extends Subject>>>() { // from class: com.transsion.postdetail.helper.ShortTvImmVideoHelper$videoCache$2
        @Override // kotlin.jvm.functions.Function0
        public final c0<List<? extends Subject>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<View> f55059g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<View> f55060h = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortTvImmVideoHelper a() {
            return (ShortTvImmVideoHelper) ShortTvImmVideoHelper.f55052l.getValue();
        }
    }

    public ShortTvImmVideoHelper() {
        this.f55057e = true;
        this.f55058f = true;
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        this.f55057e = roomAppMMKV.a().getBoolean("k_imm_video_guide", true);
        this.f55058f = roomAppMMKV.a().getBoolean("k_short_tv_guide", true);
    }

    public static final void o(FragmentActivity activity, ShortTvImmVideoHelper this$0) {
        View decorView;
        WindowInsets rootWindowInsets;
        Intrinsics.g(activity, "$activity");
        Intrinsics.g(this$0, "this$0");
        if (activity.isFinishing()) {
            return;
        }
        Window window = activity.getWindow();
        Insets mandatorySystemGestureInsets = (window == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null) ? null : rootWindowInsets.getMandatorySystemGestureInsets();
        if (mandatorySystemGestureInsets == null || mandatorySystemGestureInsets.bottom > f0.a(40.0f)) {
            uo.b.a.f(uo.b.f78622a, "ImmVideoHelper", "is open navigation bar 2", false, 4, null);
            return;
        }
        int i11 = mandatorySystemGestureInsets.bottom;
        this$0.f55054b = i11;
        uo.b.a.f(uo.b.f78622a, "ImmVideoHelper", "on get navigation gesture height = " + i11, false, 4, null);
    }

    public static final void t(ShortTvImmVideoHelper this$0, View view, int i11, ViewGroup viewGroup) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(view, "view");
        uo.b.a.f(uo.b.f78622a, "ShortTvImmVideoPlayer", "for you preloadItemViews completion, " + view, false, 4, null);
        if (this$0.f55062j) {
            return;
        }
        this$0.f55059g.add(view);
    }

    public static final void u(ShortTvImmVideoHelper this$0, View view, int i11, ViewGroup viewGroup) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(view, "view");
        uo.b.a.f(uo.b.f78622a, "ShortTvImmVideoPlayer", "detail preloadItemViews completion, " + view, false, 4, null);
        if (this$0.f55062j) {
            return;
        }
        this$0.f55060h.add(view);
    }

    public final void h() {
        this.f55053a.clear();
    }

    public final List<Subject> i() {
        return this.f55053a;
    }

    public final List<View> j() {
        return this.f55059g;
    }

    public final int k() {
        return this.f55054b;
    }

    public final c0<List<Subject>> l() {
        return (c0) this.f55056d.getValue();
    }

    public final Map<String, Long> m() {
        return this.f55055c;
    }

    public final void n(final FragmentActivity activity) {
        Intrinsics.g(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            this.f55054b = 0;
            return;
        }
        if (com.blankj.utilcode.util.d.a() > 50) {
            uo.b.a.f(uo.b.f78622a, "ImmVideoHelper", "is open navigation bar", false, 4, null);
            this.f55054b = 0;
            return;
        }
        Window window = activity.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            decorView.post(new Runnable() { // from class: com.transsion.postdetail.helper.d
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTvImmVideoHelper.o(activity, this);
                }
            });
        }
    }

    public final boolean p() {
        return this.f55057e;
    }

    public final void q() {
        List<Subject> listF = l().f();
        if (listF == null || listF.size() <= 0) {
            j.d(l0.a(w0.b()), null, null, new ShortTvImmVideoHelper$loadCache$1(this, null), 3, null);
        }
    }

    public final void r(Video video) {
        String url;
        if (video == null || (url = video.getUrl()) == null) {
            return;
        }
        ORPlayerPreloadManager.f54651i.a().h(url, 3000L);
    }

    public final void s(Context context) {
        Intrinsics.g(context, "context");
        this.f55062j = false;
        for (int i11 = 0; i11 < 2; i11++) {
            new AsyncLayoutInflater(context).a(R$layout.item_short_tv_immersion_video, null, new AsyncLayoutInflater.d() { // from class: com.transsion.postdetail.helper.e
                @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.d
                public final void a(View view, int i12, ViewGroup viewGroup) {
                    ShortTvImmVideoHelper.t(this.f55069a, view, i12, viewGroup);
                }
            });
        }
        for (int i12 = 0; i12 < 2; i12++) {
            new AsyncLayoutInflater(context).a(com.transsion.shorttv.R$layout.short_tv_item_video, null, new AsyncLayoutInflater.d() { // from class: com.transsion.postdetail.helper.f
                @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.d
                public final void a(View view, int i13, ViewGroup viewGroup) {
                    ShortTvImmVideoHelper.u(this.f55070a, view, i13, viewGroup);
                }
            });
        }
    }

    public final void v() {
        this.f55062j = true;
        this.f55059g.clear();
        this.f55060h.clear();
    }

    public final void w(List<? extends Subject> list) {
        List<? extends Subject> list2 = list;
        if (list2 == null || list2.isEmpty() || Intrinsics.b(list, l().f())) {
            return;
        }
        j.d(l0.a(w0.b()), null, null, new ShortTvImmVideoHelper$saveCache$1(list, this, null), 3, null);
    }

    public final void x() {
        uo.b.a.s(uo.b.f78622a, "ImmVideoPlayer", "-- setVideoGuideShown", false, 4, null);
        this.f55057e = false;
        RoomAppMMKV.f51271a.a().putBoolean("k_imm_video_guide", false);
    }
}
