package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.core.view.GravityCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zq {

    /* JADX INFO: compiled from: source.java */
    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f24911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f24912b;

        public a(View view, Runnable runnable) {
            this.f24911a = view;
            this.f24912b = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Runnable runnable = this.f24912b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f24911a.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f24913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f24914b;

        public b(View view, Runnable runnable) {
            this.f24913a = view;
            this.f24914b = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f24913a.setVisibility(4);
            Runnable runnable = this.f24914b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f24913a.setVisibility(0);
        }
    }

    public static Activity a(View view, com.applovin.impl.sdk.j jVar) {
        if (view == null) {
            return null;
        }
        for (int i11 = 0; i11 < 1000; i11++) {
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th2) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().a("ViewUtils", "Encountered error while retrieving activity from view", th2);
                }
            }
        }
        return null;
    }

    public static String a(int i11) {
        if (i11 == 0) {
            return "VISIBLE";
        }
        if (i11 == 4) {
            return "INVISIBLE";
        }
        return i11 == 8 ? "GONE" : String.valueOf(i11);
    }

    public static String a(View view) {
        return view.getClass().getName() + '@' + Integer.toHexString(view.hashCode());
    }

    public static void a(View view, long j11) {
        a(view, j11, (Runnable) null);
    }

    public static void a(View view, long j11, Runnable runnable) {
        view.setVisibility(4);
        view.bringToFront();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(j11);
        alphaAnimation.setAnimationListener(new a(view, runnable));
        view.startAnimation(alphaAnimation);
    }

    public static boolean a(int i11, int i12) {
        return b(i11) != b(i12);
    }

    public static boolean a(View view, Activity activity) {
        if (activity != null && view != null) {
            Window window = activity.getWindow();
            if (window != null) {
                return a(view, window.getDecorView());
            }
            View viewFindViewById = activity.findViewById(R.id.content);
            if (viewFindViewById != null) {
                return a(view, viewFindViewById.getRootView());
            }
        }
        return false;
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                if (a(view, viewGroup.getChildAt(i11))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0033  */
    /* JADX WARN: Code duplicated, block: B:42:0x006f  */
    public static int[] a(int i11, int i12, int i13) {
        if (i11 == 0) {
            return new int[]{i12, i13};
        }
        if ((i11 & 119) == 119) {
            return new int[]{13};
        }
        if ((i11 & 112) == 112) {
            i12 = 15;
        } else if ((i11 & 48) == 48) {
            i12 = 10;
        } else if ((i11 & 80) == 80) {
            i12 = 12;
        } else if ((i11 & 16) == 16) {
            i12 = 15;
        }
        if ((i11 & 7) == 7) {
            i13 = 14;
        } else if (z3.d() && (i11 & GravityCompat.START) == 8388611) {
            i13 = 20;
        } else if ((i11 & 3) == 3) {
            i13 = 9;
        } else if (z3.d() && (i11 & GravityCompat.END) == 8388613) {
            i13 = 21;
        } else if ((i11 & 5) == 5) {
            i13 = 11;
        } else if ((i11 & 1) == 1) {
            i13 = 14;
        }
        return new int[]{i13, i12};
    }

    public static View b(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View viewFindViewById = rootView.findViewById(R.id.content);
        return viewFindViewById != null ? viewFindViewById : rootView;
    }

    public static void b(View view, long j11, Runnable runnable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j11);
        alphaAnimation.setAnimationListener(new b(view, runnable));
        view.startAnimation(alphaAnimation);
    }

    public static boolean b(int i11) {
        return i11 == 0;
    }

    public static void c(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }
}
