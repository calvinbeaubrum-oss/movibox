package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CopyOnWriteArrayList<a> f8592a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FragmentManager f8593b;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final FragmentManager.m f8594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f8595b;

        public a(@NonNull FragmentManager.m mVar, boolean z11) {
            this.f8594a = mVar;
            this.f8595b = z11;
        }
    }

    public k(@NonNull FragmentManager fragmentManager) {
        this.f8593b = fragmentManager;
    }

    public void a(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().a(fragment, bundle, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentActivityCreated(this.f8593b, fragment, bundle);
            }
        }
    }

    public void b(@NonNull Fragment fragment, boolean z11) {
        Context contextF = this.f8593b.getHost().f();
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().b(fragment, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentAttached(this.f8593b, fragment, contextF);
            }
        }
    }

    public void c(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().c(fragment, bundle, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentCreated(this.f8593b, fragment, bundle);
            }
        }
    }

    public void d(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().d(fragment, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentDestroyed(this.f8593b, fragment);
            }
        }
    }

    public void e(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().e(fragment, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentDetached(this.f8593b, fragment);
            }
        }
    }

    public void f(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().f(fragment, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentPaused(this.f8593b, fragment);
            }
        }
    }

    public void g(@NonNull Fragment fragment, boolean z11) {
        Context contextF = this.f8593b.getHost().f();
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().g(fragment, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentPreAttached(this.f8593b, fragment, contextF);
            }
        }
    }

    public void h(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().h(fragment, bundle, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentPreCreated(this.f8593b, fragment, bundle);
            }
        }
    }

    public void i(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().i(fragment, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentResumed(this.f8593b, fragment);
            }
        }
    }

    public void j(@NonNull Fragment fragment, @NonNull Bundle bundle, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().j(fragment, bundle, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentSaveInstanceState(this.f8593b, fragment, bundle);
            }
        }
    }

    public void k(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().k(fragment, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentStarted(this.f8593b, fragment);
            }
        }
    }

    public void l(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().l(fragment, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentStopped(this.f8593b, fragment);
            }
        }
    }

    public void m(@NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().m(fragment, view, bundle, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentViewCreated(this.f8593b, fragment, view, bundle);
            }
        }
    }

    public void n(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.f8593b.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().n(fragment, true);
        }
        for (a aVar : this.f8592a) {
            if (!z11 || aVar.f8595b) {
                aVar.f8594a.onFragmentViewDestroyed(this.f8593b, fragment);
            }
        }
    }

    public void o(@NonNull FragmentManager.m mVar, boolean z11) {
        this.f8592a.add(new a(mVar, z11));
    }

    public void p(@NonNull FragmentManager.m mVar) {
        synchronized (this.f8592a) {
            try {
                int size = this.f8592a.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (this.f8592a.get(i11).f8594a == mVar) {
                        this.f8592a.remove(i11);
                        break;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
