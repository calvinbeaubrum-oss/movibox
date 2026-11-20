package com.bigkoo.pickerview.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bigkoo.pickerview.R$id;
import com.bigkoo.pickerview.R$layout;
import com.bigkoo.pickerview.R$style;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BasePickerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f25166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f25167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f25168d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f8.a f25169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Animation f25171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animation f25172i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f25173j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Dialog f25175l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f25176m;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25174k = 80;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f25177n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnKeyListener f25178o = new c();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View.OnTouchListener f25179p = new d();

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BasePickerView.this.f();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BasePickerView.this.h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements View.OnKeyListener {
        public c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i11, KeyEvent keyEvent) {
            if (i11 != 4 || keyEvent.getAction() != 0 || !BasePickerView.this.q()) {
                return false;
            }
            BasePickerView.this.f();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            BasePickerView.this.f();
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements DialogInterface.OnDismissListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            BasePickerView.a(BasePickerView.this);
        }
    }

    public BasePickerView(Context context) {
        this.f25165a = context;
    }

    public static /* bridge */ /* synthetic */ g8.b a(BasePickerView basePickerView) {
        basePickerView.getClass();
        return null;
    }

    public static String j() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int k(Context context) {
        Resources resources;
        int identifier;
        if (!m(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    @TargetApi(14)
    public static boolean m(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z11 = resources.getBoolean(identifier);
        String strJ = j();
        if ("1".equals(strJ)) {
            return false;
        }
        if ("0".equals(strJ)) {
            return true;
        }
        return z11;
    }

    public void e() {
        if (this.f25168d != null) {
            Dialog dialog = new Dialog(this.f25165a, R$style.custom_dialog2);
            this.f25175l = dialog;
            dialog.setCancelable(this.f25169f.U);
            this.f25175l.setContentView(this.f25168d);
            Window window = this.f25175l.getWindow();
            if (window != null) {
                window.setWindowAnimations(R$style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.f25175l.setOnDismissListener(new e());
        }
    }

    public void f() {
        if (p()) {
            g();
            return;
        }
        if (this.f25170g) {
            return;
        }
        if (this.f25177n) {
            this.f25171h.setAnimationListener(new b());
            this.f25166b.startAnimation(this.f25171h);
        } else {
            h();
        }
        this.f25170g = true;
    }

    public View findViewById(int i11) {
        return this.f25166b.findViewById(i11);
    }

    public final void g() {
        Dialog dialog = this.f25175l;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void h() {
        this.f25169f.A.post(new Runnable() { // from class: com.bigkoo.pickerview.view.BasePickerView.3
            @Override // java.lang.Runnable
            public void run() {
                BasePickerView basePickerView = BasePickerView.this;
                basePickerView.f25169f.A.removeView(basePickerView.f25167c);
                BasePickerView.this.f25173j = false;
                BasePickerView.this.f25170g = false;
                BasePickerView.a(BasePickerView.this);
            }
        });
    }

    public final Animation i() {
        return AnimationUtils.loadAnimation(this.f25165a, h8.c.a(this.f25174k, true));
    }

    public final Animation l() {
        return AnimationUtils.loadAnimation(this.f25165a, h8.c.a(this.f25174k, false));
    }

    public void n() {
        this.f25172i = i();
        this.f25171h = l();
    }

    public void o() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f25165a);
        if (p()) {
            ViewGroup viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R$layout.layout_basepickerview, (ViewGroup) null, false);
            this.f25168d = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f25168d.findViewById(R$id.content_container);
            this.f25166b = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            e();
            this.f25168d.setOnClickListener(new a());
        } else {
            f8.a aVar = this.f25169f;
            if (aVar.A == null) {
                aVar.A = (ViewGroup) ((Activity) this.f25165a).getWindow().getDecorView();
            }
            this.f25167c = (ViewGroup) layoutInflaterFrom.inflate(R$layout.layout_basepickerview, this.f25169f.A, false);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.bottomMargin = k(this.f25165a);
            this.f25167c.setLayoutParams(layoutParams2);
            int i11 = this.f25169f.R;
            if (i11 != -1) {
                this.f25167c.setBackgroundColor(i11);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f25167c.findViewById(R$id.content_container);
            this.f25166b = viewGroup3;
            viewGroup3.setLayoutParams(layoutParams);
        }
        t(true);
    }

    public boolean p() {
        throw null;
    }

    public boolean q() {
        if (p()) {
            return false;
        }
        return this.f25167c.getParent() != null || this.f25173j;
    }

    public final void r(View view) {
        this.f25169f.A.addView(view);
        if (this.f25177n) {
            this.f25166b.startAnimation(this.f25172i);
        }
    }

    public void s() {
        Dialog dialog = this.f25175l;
        if (dialog != null) {
            dialog.setCancelable(this.f25169f.U);
        }
    }

    public void t(boolean z11) {
        ViewGroup viewGroup = p() ? this.f25168d : this.f25167c;
        viewGroup.setFocusable(z11);
        viewGroup.setFocusableInTouchMode(z11);
        if (z11) {
            viewGroup.setOnKeyListener(this.f25178o);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    public BasePickerView u(boolean z11) {
        ViewGroup viewGroup = this.f25167c;
        if (viewGroup != null) {
            View viewFindViewById = viewGroup.findViewById(R$id.outmost_container);
            if (z11) {
                viewFindViewById.setOnTouchListener(this.f25179p);
            } else {
                viewFindViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void v() {
        if (p()) {
            w();
        } else {
            if (q()) {
                return;
            }
            this.f25173j = true;
            r(this.f25167c);
            this.f25167c.requestFocus();
        }
    }

    public final void w() {
        Dialog dialog = this.f25175l;
        if (dialog != null) {
            dialog.show();
        }
    }
}
