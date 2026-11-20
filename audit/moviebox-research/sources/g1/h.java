package g1;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f65372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewPropertyAnimatorListener f65373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f65374e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f65371b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewPropertyAnimatorListenerAdapter f65375f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<ViewPropertyAnimatorCompat> f65370a = new ArrayList<>();

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewPropertyAnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f65376a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f65377b = 0;

        public a() {
        }

        public void a() {
            this.f65377b = 0;
            this.f65376a = false;
            h.this.b();
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i11 = this.f65377b + 1;
            this.f65377b = i11;
            if (i11 == h.this.f65370a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = h.this.f65373d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(null);
                }
                a();
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (this.f65376a) {
                return;
            }
            this.f65376a = true;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = h.this.f65373d;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(null);
            }
        }
    }

    public void a() {
        if (this.f65374e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f65370a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.f65374e = false;
        }
    }

    public void b() {
        this.f65374e = false;
    }

    public h c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f65374e) {
            this.f65370a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public h d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f65370a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f65370a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public h e(long j11) {
        if (!this.f65374e) {
            this.f65371b = j11;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f65374e) {
            this.f65372c = interpolator;
        }
        return this;
    }

    public h g(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f65374e) {
            this.f65373d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void h() {
        if (this.f65374e) {
            return;
        }
        for (ViewPropertyAnimatorCompat viewPropertyAnimatorCompat : this.f65370a) {
            long j11 = this.f65371b;
            if (j11 >= 0) {
                viewPropertyAnimatorCompat.setDuration(j11);
            }
            Interpolator interpolator = this.f65372c;
            if (interpolator != null) {
                viewPropertyAnimatorCompat.setInterpolator(interpolator);
            }
            if (this.f65373d != null) {
                viewPropertyAnimatorCompat.setListener(this.f65375f);
            }
            viewPropertyAnimatorCompat.start();
        }
        this.f65374e = true;
    }
}
