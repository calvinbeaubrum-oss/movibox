package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.R$id;
import com.blankj.utilcode.R$layout;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ToastUtils {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ToastUtils f25264l = n();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static WeakReference<b> f25265m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25267b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25268c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25269d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25270e = -16777217;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25271f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25272g = -16777217;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25273h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f25274i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable[] f25275j = new Drawable[4];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f25276k = false;

    /* JADX INFO: compiled from: source.java */
    public static final class ActivityToast extends a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f25277f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Utils.a f25278d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public b f25279e;

        /* JADX INFO: compiled from: source.java */
        public class a extends Utils.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f25280a;

            public a(int i11) {
                this.f25280a = i11;
            }

            @Override // com.blankj.utilcode.util.Utils.a
            public void a(@NonNull Activity activity) {
                if (ActivityToast.this.i()) {
                    ActivityToast.this.l(activity, this.f25280a, false);
                }
            }
        }

        public ActivityToast(ToastUtils toastUtils) {
            super(toastUtils);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void a(int i11) {
            if (this.f25285a == null) {
                return;
            }
            if (!j0.w()) {
                this.f25279e = k(i11);
                return;
            }
            boolean z11 = false;
            for (Activity activity : j0.h()) {
                if (j0.v(activity)) {
                    if (z11) {
                        l(activity, f25277f, true);
                    } else {
                        this.f25279e = m(activity, i11);
                        z11 = true;
                    }
                }
            }
            if (!z11) {
                this.f25279e = k(i11);
                return;
            }
            j();
            j0.I(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.ActivityToast.1
                @Override // java.lang.Runnable
                public void run() {
                    ActivityToast.this.cancel();
                }
            }, i11 == 0 ? AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS : 3500L);
            f25277f++;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.a, com.blankj.utilcode.util.ToastUtils.b
        public void cancel() {
            Window window;
            if (i()) {
                n();
                for (Activity activity : j0.h()) {
                    if (j0.v(activity) && (window = activity.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("TAG_TOAST");
                        sb2.append(f25277f - 1);
                        View viewFindViewWithTag = viewGroup.findViewWithTag(sb2.toString());
                        if (viewFindViewWithTag != null) {
                            try {
                                viewGroup.removeView(viewFindViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            b bVar = this.f25279e;
            if (bVar != null) {
                bVar.cancel();
                this.f25279e = null;
            }
            super.cancel();
        }

        public final boolean i() {
            return this.f25278d != null;
        }

        public final void j() {
            a aVar = new a(f25277f);
            this.f25278d = aVar;
            j0.a(aVar);
        }

        public final b k(int i11) {
            c cVar = new c(this.f25286b);
            cVar.f25285a = this.f25285a;
            cVar.a(i11);
            return cVar;
        }

        public final void l(Activity activity, int i11, boolean z11) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.f25285a.getGravity();
                layoutParams.bottomMargin = this.f25285a.getYOffset() + j0.p();
                layoutParams.topMargin = this.f25285a.getYOffset() + j0.s();
                layoutParams.leftMargin = this.f25285a.getXOffset();
                View viewD = d(i11);
                if (z11) {
                    viewD.setAlpha(0.0f);
                    viewD.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(viewD, layoutParams);
            }
        }

        public final b m(Activity activity, int i11) {
            WindowManagerToast windowManagerToast = new WindowManagerToast(this.f25286b, activity.getWindowManager(), 99);
            windowManagerToast.f25287c = d(-1);
            windowManagerToast.f25285a = this.f25285a;
            windowManagerToast.a(i11);
            return windowManagerToast;
        }

        public final void n() {
            j0.G(this.f25278d);
            this.f25278d = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f25282a = j0.d(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
            super(context, attributeSet, i11);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        public void onMeasure(int i11, int i12) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(j0.i() - f25282a, Integer.MIN_VALUE), i12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class WindowManagerToast extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public WindowManager f25283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public WindowManager.LayoutParams f25284e;

        public WindowManagerToast(ToastUtils toastUtils, int i11) {
            super(toastUtils);
            this.f25284e = new WindowManager.LayoutParams();
            this.f25283d = (WindowManager) Utils.a().getSystemService("window");
            this.f25284e.type = i11;
        }

        public WindowManagerToast(ToastUtils toastUtils, WindowManager windowManager, int i11) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f25284e = layoutParams;
            this.f25283d = windowManager;
            layoutParams.type = i11;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void a(int i11) {
            if (this.f25285a == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.f25284e;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            layoutParams.setTitle("ToastWithoutNotification");
            WindowManager.LayoutParams layoutParams2 = this.f25284e;
            layoutParams2.flags = 152;
            layoutParams2.packageName = Utils.a().getPackageName();
            this.f25284e.gravity = this.f25285a.getGravity();
            WindowManager.LayoutParams layoutParams3 = this.f25284e;
            int i12 = layoutParams3.gravity;
            if ((i12 & 7) == 7) {
                layoutParams3.horizontalWeight = 1.0f;
            }
            if ((i12 & 112) == 112) {
                layoutParams3.verticalWeight = 1.0f;
            }
            layoutParams3.x = this.f25285a.getXOffset();
            this.f25284e.y = this.f25285a.getYOffset();
            this.f25284e.horizontalMargin = this.f25285a.getHorizontalMargin();
            this.f25284e.verticalMargin = this.f25285a.getVerticalMargin();
            try {
                WindowManager windowManager = this.f25283d;
                if (windowManager != null) {
                    windowManager.addView(this.f25287c, this.f25284e);
                }
            } catch (Exception unused) {
            }
            j0.I(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.WindowManagerToast.1
                @Override // java.lang.Runnable
                public void run() {
                    WindowManagerToast.this.cancel();
                }
            }, i11 == 0 ? AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS : 3500L);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.a, com.blankj.utilcode.util.ToastUtils.b
        public void cancel() {
            try {
                WindowManager windowManager = this.f25283d;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.f25287c);
                    this.f25283d = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Toast f25285a = new Toast(Utils.a());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ToastUtils f25286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f25287c;

        public a(ToastUtils toastUtils) {
            this.f25286b = toastUtils;
            if (toastUtils.f25267b == -1 && this.f25286b.f25268c == -1 && this.f25286b.f25269d == -1) {
                return;
            }
            this.f25285a.setGravity(this.f25286b.f25267b, this.f25286b.f25268c, this.f25286b.f25269d);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void b(View view) {
            this.f25287c = view;
            this.f25285a.setView(view);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void c(CharSequence charSequence) {
            View viewS = this.f25286b.s(charSequence);
            if (viewS != null) {
                b(viewS);
                e();
                return;
            }
            View view = this.f25285a.getView();
            this.f25287c = view;
            if (view == null || view.findViewById(R.id.message) == null) {
                b(j0.D(R$layout.utils_toast_view));
            }
            TextView textView = (TextView) this.f25287c.findViewById(R.id.message);
            textView.setText(charSequence);
            if (this.f25286b.f25272g != -16777217) {
                textView.setTextColor(this.f25286b.f25272g);
            }
            if (this.f25286b.f25273h != -1) {
                textView.setTextSize(this.f25286b.f25273h);
            }
            f(textView);
            e();
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        @CallSuper
        public void cancel() {
            Toast toast = this.f25285a;
            if (toast != null) {
                toast.cancel();
            }
            this.f25285a = null;
            this.f25287c = null;
        }

        public View d(int i11) {
            Bitmap bitmapK = j0.K(this.f25287c);
            ImageView imageView = new ImageView(Utils.a());
            imageView.setTag("TAG_TOAST" + i11);
            imageView.setImageBitmap(bitmapK);
            return imageView;
        }

        public final void e() {
            if (j0.A()) {
                b(d(-1));
            }
        }

        public final void f(TextView textView) {
            if (this.f25286b.f25271f != -1) {
                this.f25287c.setBackgroundResource(this.f25286b.f25271f);
                textView.setBackgroundColor(0);
                return;
            }
            if (this.f25286b.f25270e != -16777217) {
                Drawable background = this.f25287c.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f25286b.f25270e, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f25286b.f25270e, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.f25286b.f25270e, PorterDuff.Mode.SRC_IN));
                } else {
                    this.f25287c.setBackgroundColor(this.f25286b.f25270e);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(int i11);

        void b(View view);

        void c(CharSequence charSequence);

        void cancel();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends a {

        /* JADX INFO: compiled from: source.java */
        public static class a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f25288a;

            public a(Handler handler) {
                this.f25288a = handler;
            }

            @Override // android.os.Handler
            public void dispatchMessage(@NonNull Message message) {
                try {
                    this.f25288a.dispatchMessage(message);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                this.f25288a.handleMessage(message);
            }
        }

        public c(ToastUtils toastUtils) {
            super(toastUtils);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.f25285a);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new a((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void a(int i11) {
            Toast toast = this.f25285a;
            if (toast == null) {
                return;
            }
            toast.setDuration(i11);
            this.f25285a.show();
        }
    }

    public static void l() {
        j0.H(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtils.f25265m != null) {
                    b bVar = (b) ToastUtils.f25265m.get();
                    if (bVar != null) {
                        bVar.cancel();
                    }
                    WeakReference unused = ToastUtils.f25265m = null;
                }
            }
        });
    }

    public static CharSequence m(CharSequence charSequence) {
        if (charSequence == null) {
            return "toast null";
        }
        return charSequence.length() == 0 ? "toast nothing" : charSequence;
    }

    @NonNull
    public static ToastUtils n() {
        return new ToastUtils();
    }

    public static b o(ToastUtils toastUtils) {
        if (toastUtils.f25276k || !NotificationManagerCompat.from(Utils.a()).areNotificationsEnabled() || (Build.VERSION.SDK_INT >= 23 && j0.y())) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 < 25) {
                return new WindowManagerToast(toastUtils, 2005);
            }
            if (j0.y()) {
                return i11 >= 26 ? new WindowManagerToast(toastUtils, 2038) : new WindowManagerToast(toastUtils, 2002);
            }
            return new ActivityToast(toastUtils);
        }
        return new c(toastUtils);
    }

    public static void p(@Nullable final View view, @Nullable final CharSequence charSequence, final int i11, @NonNull ToastUtils toastUtils) {
        j0.H(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.2
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.l();
                b bVarO = ToastUtils.o(ToastUtils.this);
                WeakReference unused = ToastUtils.f25265m = new WeakReference(bVarO);
                View view2 = view;
                if (view2 != null) {
                    bVarO.b(view2);
                } else {
                    bVarO.c(charSequence);
                }
                bVarO.a(i11);
            }
        });
    }

    public static void q(@Nullable CharSequence charSequence, int i11, ToastUtils toastUtils) {
        p(null, m(charSequence), i11, toastUtils);
    }

    public static void r(@Nullable String str, Object... objArr) {
        q(j0.g(str, objArr), 0, f25264l);
    }

    public final View s(CharSequence charSequence) {
        if (!"dark".equals(this.f25266a) && !"light".equals(this.f25266a)) {
            Drawable[] drawableArr = this.f25275j;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View viewD = j0.D(R$layout.utils_toast_view);
        TextView textView = (TextView) viewD.findViewById(R.id.message);
        if ("dark".equals(this.f25266a)) {
            ((GradientDrawable) viewD.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.f25275j[0] != null) {
            View viewFindViewById = viewD.findViewById(R$id.utvLeftIconView);
            ViewCompat.setBackground(viewFindViewById, this.f25275j[0]);
            viewFindViewById.setVisibility(0);
        }
        if (this.f25275j[1] != null) {
            View viewFindViewById2 = viewD.findViewById(R$id.utvTopIconView);
            ViewCompat.setBackground(viewFindViewById2, this.f25275j[1]);
            viewFindViewById2.setVisibility(0);
        }
        if (this.f25275j[2] != null) {
            View viewFindViewById3 = viewD.findViewById(R$id.utvRightIconView);
            ViewCompat.setBackground(viewFindViewById3, this.f25275j[2]);
            viewFindViewById3.setVisibility(0);
        }
        if (this.f25275j[3] != null) {
            View viewFindViewById4 = viewD.findViewById(R$id.utvBottomIconView);
            ViewCompat.setBackground(viewFindViewById4, this.f25275j[3]);
            viewFindViewById4.setVisibility(0);
        }
        return viewD;
    }
}
