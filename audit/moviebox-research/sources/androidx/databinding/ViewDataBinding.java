package androidx.databinding;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.view.Choreographer;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.library.R$id;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ViewDataBinding extends androidx.databinding.a implements n6.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f8151m = Build.VERSION.SDK_INT;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f8152n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final androidx.databinding.d f8153o = new a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final androidx.databinding.d f8154p = new b();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final androidx.databinding.d f8155q = new c();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final androidx.databinding.d f8156r = new d();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final androidx.databinding.c.a<k, ViewDataBinding, Void> f8157s = new e();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ReferenceQueue<ViewDataBinding> f8158t = new ReferenceQueue<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final View.OnAttachStateChangeListener f8159u = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f8160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f8163d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.databinding.c<k, ViewDataBinding, Void> f8164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Choreographer f8166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Choreographer.FrameCallback f8167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Handler f8168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewDataBinding f8169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public u f8170l;

    /* JADX INFO: renamed from: androidx.databinding.ViewDataBinding$7, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass7 implements Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ViewDataBinding.this.f8161b = false;
            }
            ViewDataBinding.l();
            if (ViewDataBinding.this.f8163d.isAttachedToWindow()) {
                ViewDataBinding.this.i();
            } else {
                ViewDataBinding.this.f8163d.removeOnAttachStateChangeListener(ViewDataBinding.f8159u);
                ViewDataBinding.this.f8163d.addOnAttachStateChangeListener(ViewDataBinding.f8159u);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements androidx.databinding.d {
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements androidx.databinding.d {
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements androidx.databinding.d {
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements androidx.databinding.d {
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends androidx.databinding.c.a<k, ViewDataBinding, Void> {
        @Override // androidx.databinding.c.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k kVar, ViewDataBinding viewDataBinding, int i11, Void r11) {
            if (i11 == 1) {
                if (kVar.c(viewDataBinding)) {
                    return;
                }
                viewDataBinding.f8162c = true;
            } else if (i11 == 2) {
                kVar.b(viewDataBinding);
            } else {
                if (i11 != 3) {
                    return;
                }
                kVar.a(viewDataBinding);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        @TargetApi(19)
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.j(view).f8160a.run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static ViewDataBinding j(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R$id.dataBinding);
        }
        return null;
    }

    public static void l() {
        while (true) {
            Reference<? extends ViewDataBinding> referencePoll = f8158t.poll();
            if (referencePoll == null) {
                return;
            }
            if (referencePoll instanceof m) {
                ((m) referencePoll).a();
            }
        }
    }

    public abstract void g();

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f8163d;
    }

    public final void h() {
        if (this.f8165g) {
            m();
            return;
        }
        if (k()) {
            this.f8165g = true;
            this.f8162c = false;
            androidx.databinding.c<k, ViewDataBinding, Void> cVar = this.f8164f;
            if (cVar != null) {
                cVar.d(this, 1, null);
                if (this.f8162c) {
                    this.f8164f.d(this, 2, null);
                }
            }
            if (!this.f8162c) {
                g();
                androidx.databinding.c<k, ViewDataBinding, Void> cVar2 = this.f8164f;
                if (cVar2 != null) {
                    cVar2.d(this, 3, null);
                }
            }
            this.f8165g = false;
        }
    }

    public void i() {
        ViewDataBinding viewDataBinding = this.f8169k;
        if (viewDataBinding == null) {
            h();
        } else {
            viewDataBinding.i();
        }
    }

    public abstract boolean k();

    public void m() {
        ViewDataBinding viewDataBinding = this.f8169k;
        if (viewDataBinding != null) {
            viewDataBinding.m();
            return;
        }
        u uVar = this.f8170l;
        if (uVar == null || uVar.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
            synchronized (this) {
                try {
                    if (this.f8161b) {
                        return;
                    }
                    this.f8161b = true;
                    if (f8152n) {
                        this.f8166h.postFrameCallback(this.f8167i);
                    } else {
                        this.f8168j.post(this.f8160a);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}
