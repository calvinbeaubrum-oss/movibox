package com.transsion.shorttv.widget;

import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.tn.lib.pager.PagerLayoutManager;
import com.transsion.player.ui.ORPlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class c extends jp.a implements r {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f57940m = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f57941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseProviderMultiAdapter<qx.e> f57942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.transsion.player.orplayer.f f57943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ORPlayerView f57944d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PagerLayoutManager f57945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f57946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f57947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f57948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f57949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f57950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f57951l;

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
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57952a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f57952a = iArr;
        }
    }

    public c(Fragment fragment, BaseProviderMultiAdapter<qx.e> baseProviderMultiAdapter, com.transsion.player.orplayer.f fVar, ORPlayerView oRPlayerView, PagerLayoutManager pagerLayoutManager) {
        Intrinsics.g(fragment, "fragment");
        this.f57941a = fragment;
        this.f57942b = baseProviderMultiAdapter;
        this.f57943c = fVar;
        this.f57944d = oRPlayerView;
        this.f57945f = pagerLayoutManager;
        this.f57948i = true;
        fragment.getLifecycle().a(this);
    }

    private final void e() {
        h9.f fVarQ;
        BaseProviderMultiAdapter<qx.e> baseProviderMultiAdapter = this.f57942b;
        if (((baseProviderMultiAdapter == null || (fVarQ = baseProviderMultiAdapter.Q()) == null) ? null : fVarQ.i()) == LoadMoreStatus.Fail && com.tn.lib.util.networkinfo.f.f49475a.e()) {
            uo.b.a.f(uo.b.f78622a, "ShortTvControl", "current is fail, try load more", false, 4, null);
            this.f57942b.Q().v();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j(int i11, View view) {
        this.f57950k = view;
        uo.b.a.f(uo.b.f78622a, "ShortTvControl", "on page select position = " + i11, false, 4, null);
        if (i11 < 0) {
            return;
        }
        BaseProviderMultiAdapter<qx.e> baseProviderMultiAdapter = this.f57942b;
        qx.e eVarO = baseProviderMultiAdapter != null ? baseProviderMultiAdapter.O(i11) : null;
        this.f57946g = i11;
        if (eVarO instanceof qx.d) {
            if (view instanceof com.transsion.shorttv.a) {
                ((com.transsion.shorttv.a) view).onPageSelected(this.f57943c, this.f57944d, (qx.d) eVarO);
            }
        } else {
            com.transsion.player.orplayer.f fVar = this.f57943c;
            if (fVar != null) {
                fVar.pause();
            }
        }
    }

    @Override // jp.a
    public void a(int i11, boolean z11, View view) {
        uo.b.a.o(uo.b.f78622a, "ShortTvControl", new String[]{"onEachPageSelected, position = " + i11}, false, 4, null);
    }

    @Override // jp.a
    public void b(View view) {
        if (this.f57951l) {
            this.f57951l = false;
            return;
        }
        PagerLayoutManager pagerLayoutManager = this.f57945f;
        if (pagerLayoutManager != null) {
            int iFindFirstVisibleItemPosition = pagerLayoutManager.findFirstVisibleItemPosition();
            uo.b.a.s(uo.b.f78622a, "ShortTvControl", "onInitComplete, position = " + iFindFirstVisibleItemPosition + ", ----- currentPosition = " + this.f57946g, false, 4, null);
            if (this.f57946g == iFindFirstVisibleItemPosition) {
                return;
            }
            if (iFindFirstVisibleItemPosition != -1) {
                this.f57946g = iFindFirstVisibleItemPosition;
            }
            j(this.f57946g, view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jp.a
    public void c(boolean z11, int i11, View view) {
        RecyclerView recyclerViewW;
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.s(aVar, "ShortTvControl", "onPageRelease, position = " + i11 + ", ----- currentPosition = " + this.f57946g, false, 4, null);
        if (i11 == this.f57946g) {
            BaseProviderMultiAdapter<qx.e> baseProviderMultiAdapter = this.f57942b;
            if (baseProviderMultiAdapter != null && (recyclerViewW = baseProviderMultiAdapter.W()) != null && recyclerViewW.getScrollState() == 1) {
                uo.b.a.s(aVar, "ShortTvControl", "onPageRelease, 连续滑动，暂停", false, 4, null);
                com.transsion.player.orplayer.f fVar = this.f57943c;
                if (fVar != null) {
                    fVar.pause();
                }
            }
            if (view instanceof com.transsion.shorttv.a) {
                ((com.transsion.shorttv.a) view).onPageRelease(i11);
            }
        }
    }

    @Override // jp.a
    public void d(int i11, boolean z11, View view) {
        e();
        uo.b.a.f(uo.b.f78622a, "ShortTvControl", "onPageSelected, position = " + i11 + ", ----- currentPosition = " + this.f57946g, false, 4, null);
        int i12 = this.f57946g;
        if (i12 != i11 || this.f57949j) {
            this.f57949j = false;
            this.f57947h = i12;
            this.f57946g = i11;
            j(i11, view);
        }
    }

    public final View f() {
        return this.f57950k;
    }

    public final int g() {
        return this.f57946g;
    }

    public final long h() {
        KeyEvent.Callback callback = this.f57950k;
        com.transsion.shorttv.a aVar = callback instanceof com.transsion.shorttv.a ? (com.transsion.shorttv.a) callback : null;
        if (aVar != null) {
            return aVar.getProgress();
        }
        return 0L;
    }

    public final void i() {
        if (this.f57948i) {
            this.f57948i = false;
        }
    }

    public final void k(boolean z11) {
        this.f57951l = z11;
    }

    public final void l(int i11) {
        this.f57946g = i11;
    }

    public final void m(ShortTvVideoItemView view, int i11, qx.d item) {
        Intrinsics.g(view, "view");
        Intrinsics.g(item, "item");
        view.updateShortTvInfo(this.f57943c, this.f57944d, item);
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        if (b.f57952a[event.ordinal()] != 3) {
            return;
        }
        this.f57950k = null;
        this.f57941a.getLifecycle().d(this);
    }
}
