package com.transsion.audio.view;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.transsion.audio.fragment.AudioBottomSheetFragment;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FloatingMagnetView f50893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<FrameLayout> f50894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<IFloatingApi.a> f50895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f50896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioBean f50897e;

    /* JADX INFO: compiled from: source.java */
    public class a implements EnFloatingView.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f50898a;

        public a(FrameLayout frameLayout) {
            this.f50898a = frameLayout;
        }

        @Override // com.transsion.audio.view.EnFloatingView.f
        public void a(ViewGroup viewGroup) {
            d dVar = d.this;
            dVar.i((ViewGroup) dVar.f50894b.get());
            for (IFloatingApi.a aVar : d.this.f50895c) {
                if (aVar != null) {
                    aVar.c();
                }
            }
            d.this.w(8);
        }

        @Override // com.transsion.audio.view.EnFloatingView.f
        public void b(ViewGroup viewGroup) {
            AudioBottomSheetFragment.f50775o.a(d.this.f50897e).show(((FragmentActivity) this.f50898a.getContext()).getSupportFragmentManager(), "dialog");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f50900a = new d();
    }

    public d() {
        this.f50896d = "";
        this.f50897e = null;
        this.f50895c = new ArrayList();
    }

    public static d k() {
        return b.f50900a;
    }

    public d d(Activity activity, AudioBean audioBean) {
        j(activity, audioBean);
        return this;
    }

    public final void e(View view) {
        FrameLayout frameLayoutN;
        if (n() == null || (frameLayoutN = n()) == null) {
            return;
        }
        frameLayoutN.addView(view);
    }

    public d f(Activity activity) {
        g(activity, l(activity));
        return this;
    }

    public void g(Activity activity, FrameLayout frameLayout) {
        FloatingMagnetView floatingMagnetView;
        String simpleName = activity.getClass().getSimpleName();
        if (!TextUtils.equals(this.f50896d, simpleName)) {
            this.f50896d = simpleName;
            FloatingMagnetView floatingMagnetView2 = this.f50893a;
            if (floatingMagnetView2 != null) {
                floatingMagnetView2.packUp();
            }
        }
        if (frameLayout == null || (floatingMagnetView = this.f50893a) == null) {
            this.f50894b = new WeakReference<>(frameLayout);
            return;
        }
        floatingMagnetView.setOnOptionListener(new a(frameLayout));
        if (this.f50893a.getParent() == frameLayout) {
            return;
        }
        if (this.f50893a.getParent() != null) {
            ((ViewGroup) this.f50893a.getParent()).removeView(this.f50893a);
        }
        this.f50893a.attach(activity);
        this.f50894b = new WeakReference<>(frameLayout);
        frameLayout.addView(this.f50893a);
    }

    public d h(Activity activity) {
        i(l(activity));
        return this;
    }

    public void i(ViewGroup viewGroup) {
        FloatingMagnetView floatingMagnetView = this.f50893a;
        if (floatingMagnetView != null && viewGroup != null && ViewCompat.isAttachedToWindow(floatingMagnetView)) {
            viewGroup.removeView(this.f50893a);
        }
        if (n() == viewGroup) {
            this.f50894b = null;
        }
    }

    public final void j(Activity activity, AudioBean audioBean) {
        if (this.f50893a == null) {
            EnFloatingView enFloatingView = new EnFloatingView(activity);
            this.f50893a = enFloatingView;
            e(enFloatingView);
        } else {
            w(0);
            if (!((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).D(audioBean) && this.f50893a.isPackUp()) {
                this.f50893a.expanded();
            }
        }
    }

    public final FrameLayout l(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            return (FrameLayout) activity.getWindow().getDecorView().findViewById(R.id.content);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public AudioBean m() {
        return this.f50897e;
    }

    public final FrameLayout n() {
        WeakReference<FrameLayout> weakReference = this.f50894b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public Boolean o() {
        return Boolean.valueOf(this.f50893a.getVisibility() == 8);
    }

    public d p(Long l11, Long l12) {
        if (this.f50893a != null) {
            int iLongValue = (int) (((l11.longValue() * 1.0f) / l12.longValue()) * 100.0f);
            if (iLongValue > 100) {
                iLongValue = 100;
            }
            this.f50893a.onProgress(iLongValue);
        }
        return this;
    }

    public d q(int i11) {
        FloatingMagnetView floatingMagnetView = this.f50893a;
        if (floatingMagnetView != null) {
            floatingMagnetView.onStateChanged(i11);
        }
        return this;
    }

    public void r() {
        FloatingMagnetView floatingMagnetView = this.f50893a;
        if (floatingMagnetView != null) {
            floatingMagnetView.packUp();
        }
    }

    public void s() {
        FloatingMagnetView floatingMagnetView = this.f50893a;
        if (floatingMagnetView != null) {
            floatingMagnetView.packUpAnimation();
        }
    }

    public d t(AudioBean audioBean) {
        if (audioBean != null) {
            this.f50897e = audioBean;
            uo.b.f78622a.c("EnFloatingView", "prepare..mEnFloatingView.." + this.f50893a, false);
            FloatingMagnetView floatingMagnetView = this.f50893a;
            if (floatingMagnetView != null) {
                floatingMagnetView.prepare();
            }
        }
        return this;
    }

    public void u(IFloatingApi.a aVar) {
        this.f50895c.remove(aVar);
    }

    public void v(IFloatingApi.a aVar) {
        this.f50895c.add(aVar);
    }

    public d w(int i11) {
        FloatingMagnetView floatingMagnetView = this.f50893a;
        if (floatingMagnetView != null && floatingMagnetView.getVisibility() != i11) {
            this.f50893a.setVisibility(i11);
        }
        return this;
    }

    public void x(String str) {
        m().setTitle(str);
    }
}
