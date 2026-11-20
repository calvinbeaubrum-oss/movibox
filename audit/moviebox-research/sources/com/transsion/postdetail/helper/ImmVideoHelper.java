package com.transsion.postdetail.helper;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.c0;
import com.blankj.utilcode.util.f0;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
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
public final class ImmVideoHelper {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f55024g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy<ImmVideoHelper> f55025h = LazyKt__LazyJVMKt.b(new Function0<ImmVideoHelper>() { // from class: com.transsion.postdetail.helper.ImmVideoHelper$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ImmVideoHelper invoke() {
            return new ImmVideoHelper();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f55027b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f55030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f55031f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PostSubjectItem> f55026a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f55028c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f55029d = LazyKt__LazyJVMKt.b(new Function0<c0<List<? extends PostSubjectItem>>>() { // from class: com.transsion.postdetail.helper.ImmVideoHelper$videoCache$2
        @Override // kotlin.jvm.functions.Function0
        public final c0<List<? extends PostSubjectItem>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImmVideoHelper a() {
            return (ImmVideoHelper) ImmVideoHelper.f55025h.getValue();
        }
    }

    public ImmVideoHelper() {
        this.f55030e = true;
        this.f55031f = true;
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        this.f55030e = roomAppMMKV.a().getBoolean("k_imm_video_guide", true);
        this.f55031f = roomAppMMKV.a().getBoolean("k_short_tv_guide", true);
    }

    public static final void j(FragmentActivity activity, ImmVideoHelper this$0) {
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
        this$0.f55027b = i11;
        uo.b.a.f(uo.b.f78622a, "ImmVideoHelper", "on get navigation gesture height = " + i11, false, 4, null);
    }

    public final void d() {
        this.f55026a.clear();
    }

    public final List<PostSubjectItem> e() {
        return this.f55026a;
    }

    public final int f() {
        return this.f55027b;
    }

    public final c0<List<PostSubjectItem>> g() {
        return (c0) this.f55029d.getValue();
    }

    public final Map<String, Long> h() {
        return this.f55028c;
    }

    public final void i(final FragmentActivity activity) {
        Intrinsics.g(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            this.f55027b = 0;
            return;
        }
        if (com.blankj.utilcode.util.d.a() > 50) {
            uo.b.a.f(uo.b.f78622a, "ImmVideoHelper", "is open navigation bar", false, 4, null);
            this.f55027b = 0;
            return;
        }
        Window window = activity.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            decorView.post(new Runnable() { // from class: com.transsion.postdetail.helper.b
                @Override // java.lang.Runnable
                public final void run() {
                    ImmVideoHelper.j(activity, this);
                }
            });
        }
    }

    public final boolean k() {
        return this.f55030e;
    }

    public final void l() {
        j.d(l0.a(w0.b()), null, null, new ImmVideoHelper$loadCache$1(this, null), 3, null);
    }

    public final void m(List<Video> list) {
        String url;
        if (list == null || !(!list.isEmpty()) || (url = list.get(0).getUrl()) == null) {
            return;
        }
        ORPlayerPreloadManager.f54651i.a().h(url, 3000L);
    }

    public final void n(List<PostSubjectItem> list) {
        List<PostSubjectItem> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        j.d(l0.a(w0.b()), null, null, new ImmVideoHelper$saveCache$1(list, this, null), 3, null);
    }

    public final void o(PostSubjectItem data) {
        List<Video> video;
        Intrinsics.g(data, "data");
        Media media = data.getMedia();
        if (media == null || (video = media.getVideo()) == null || !(!video.isEmpty())) {
            return;
        }
        d();
        this.f55026a.add(PostSubjectItem.Companion.a(data));
    }

    public final void p() {
        uo.b.a.s(uo.b.f78622a, "ImmVideoPlayer", "-- setVideoGuideShown", false, 4, null);
        this.f55030e = false;
        RoomAppMMKV.f51271a.a().putBoolean("k_imm_video_guide", false);
    }
}
