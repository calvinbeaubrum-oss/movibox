package com.vungle.warren;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.error.VungleException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class NativeAdLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f61753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f61754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b10.e f61755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BroadcastReceiver f61756d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b10.b.a f61757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AdRequest f61758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f61759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f61760i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReference<Boolean> f61761j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f61762k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f61763l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Context f61764m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f61765n;

    /* JADX INFO: compiled from: source.java */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("command");
            if ("stopAll".equalsIgnoreCase(stringExtra)) {
                NativeAdLayout.this.finishDisplayingAdInternal(false);
                return;
            }
            VungleLogger.j(NativeAdLayout.class.getSimpleName() + "#onAttachedToWindow", String.format("Receiving Invalid Broadcast: %1$s", stringExtra));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdRequest f61767a;

        public b(AdRequest adRequest) {
            this.f61767a = adRequest;
        }

        @Override // com.vungle.warren.r.b
        public void a(@NonNull Pair<b10.f, b10.e> pair, @Nullable VungleException vungleException) {
            NativeAdLayout.this.f61754b = null;
            if (vungleException != null) {
                if (NativeAdLayout.this.f61757f != null) {
                    NativeAdLayout.this.f61757f.b(vungleException, this.f61767a.getPlacementId());
                    return;
                }
                return;
            }
            b10.f fVar = (b10.f) pair.first;
            NativeAdLayout.this.f61755c = (b10.e) pair.second;
            NativeAdLayout.this.f61755c.o(NativeAdLayout.this.f61757f);
            NativeAdLayout.this.f61755c.j(fVar, null);
            if (NativeAdLayout.this.f61759h.getAndSet(false)) {
                NativeAdLayout.this.l();
            }
            if (NativeAdLayout.this.f61760i.getAndSet(false)) {
                NativeAdLayout.this.f61755c.c(1, 100.0f);
            }
            if (NativeAdLayout.this.f61761j.get() != null) {
                NativeAdLayout nativeAdLayout = NativeAdLayout.this;
                nativeAdLayout.setAdVisibility(((Boolean) nativeAdLayout.f61761j.get()).booleanValue());
            }
            NativeAdLayout.this.f61763l = false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(int i11);
    }

    public NativeAdLayout(@NonNull Context context) {
        super(context);
        this.f61759h = new AtomicBoolean(false);
        this.f61760i = new AtomicBoolean(false);
        this.f61761j = new AtomicReference<>();
        this.f61762k = false;
        k(context);
    }

    public NativeAdLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f61759h = new AtomicBoolean(false);
        this.f61760i = new AtomicBoolean(false);
        this.f61761j = new AtomicReference<>();
        this.f61762k = false;
        k(context);
    }

    public NativeAdLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f61759h = new AtomicBoolean(false);
        this.f61760i = new AtomicBoolean(false);
        this.f61761j = new AtomicReference<>();
        this.f61762k = false;
        k(context);
    }

    @TargetApi(21)
    public NativeAdLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f61759h = new AtomicBoolean(false);
        this.f61760i = new AtomicBoolean(false);
        this.f61761j = new AtomicReference<>();
        this.f61762k = false;
        k(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdVisibility(boolean z11) {
        b10.e eVar = this.f61755c;
        if (eVar != null) {
            eVar.a(z11);
        } else {
            this.f61761j.set(Boolean.valueOf(z11));
        }
    }

    public void disableLifeCycleManagement(boolean z11) {
        this.f61765n = z11;
    }

    public void finishDisplayingAdInternal(boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("finishDisplayingAdInternal() ");
        sb2.append(z11);
        sb2.append(" ");
        sb2.append(hashCode());
        b10.e eVar = this.f61755c;
        if (eVar != null) {
            eVar.s((z11 ? 4 : 0) | 2);
        } else {
            r rVar = this.f61754b;
            if (rVar != null) {
                rVar.destroy();
                this.f61754b = null;
                this.f61757f.b(new VungleException(25), this.f61758g.getPlacementId());
            }
        }
        release();
    }

    public void finishNativeAd() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("finishNativeAd() ");
        sb2.append(hashCode());
        u3.a.b(this.f61764m).e(this.f61756d);
    }

    public final void k(@NonNull Context context) {
        this.f61764m = context;
    }

    public final void l() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("start() ");
        sb2.append(hashCode());
        if (this.f61755c == null) {
            this.f61759h.set(true);
        } else {
            if (this.f61762k || !hasWindowFocus()) {
                return;
            }
            this.f61755c.start();
            this.f61762k = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAttachedToWindow() ");
        sb2.append(hashCode());
        if (this.f61765n) {
            return;
        }
        renderNativeAd();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onDetachedFromWindow() ");
        sb2.append(hashCode());
        if (this.f61765n) {
            return;
        }
        finishNativeAd();
    }

    public void onImpression() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onImpression() ");
        sb2.append(hashCode());
        b10.e eVar = this.f61755c;
        if (eVar == null) {
            this.f61760i.set(true);
        } else {
            eVar.c(1, 100.0f);
        }
    }

    public void onItemClicked(int i11) {
        c cVar = this.f61753a;
        if (cVar != null) {
            cVar.a(i11);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i11) {
        super.onVisibilityChanged(view, i11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onVisibilityChanged() visibility=");
        sb2.append(i11);
        sb2.append(" ");
        sb2.append(hashCode());
        setAdVisibility(i11 == 0);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onWindowFocusChanged() hasWindowFocus=");
        sb2.append(z11);
        sb2.append(" ");
        sb2.append(hashCode());
        super.onWindowFocusChanged(z11);
        setAdVisibility(z11);
        if (this.f61755c == null || this.f61762k) {
            return;
        }
        l();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onWindowVisibilityChanged() visibility=");
        sb2.append(i11);
        sb2.append(" ");
        sb2.append(hashCode());
        setAdVisibility(i11 == 0);
    }

    public void register(@NonNull Context context, @NonNull p pVar, @NonNull r rVar, @NonNull b10.b.a aVar, @Nullable AdConfig adConfig, @NonNull AdRequest adRequest) {
        this.f61754b = rVar;
        this.f61757f = aVar;
        this.f61758g = adRequest;
        if (this.f61755c == null) {
            rVar.a(context, this, adRequest, adConfig, new b(adRequest));
        }
    }

    public void release() {
        if (this.f61763l) {
            return;
        }
        this.f61763l = true;
        this.f61755c = null;
        this.f61754b = null;
    }

    public void renderNativeAd() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("renderNativeAd() ");
        sb2.append(hashCode());
        this.f61756d = new a();
        u3.a.b(this.f61764m).c(this.f61756d, new IntentFilter("AdvertisementBus"));
        l();
    }

    public void setOnItemClickListener(c cVar) {
        this.f61753a = cVar;
    }
}
