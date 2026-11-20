package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$dimen;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniutils.util.j0;
import com.cloud.tmc.miniutils.util.z;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ImmersiveTitleBarView extends FrameLayout implements ub.c {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public final Lazy f31820OooO;
    public View.OnClickListener OooO00o;
    public View.OnClickListener OooO0O0;
    public View.OnClickListener OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final Lazy f31821OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public final Lazy f31822OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public final Lazy f31823OooO0o0;
    public final Lazy OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public final Lazy f31824OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public int f31825OooOO0;
    public boolean OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public int f31826OooOO0o;
    public AddScreenView OooOOO;
    public int OooOOO0;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<FrameLayout> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) ImmersiveTitleBarView.this.findViewById(R$id.fl_menu_container);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<Unit> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ImmersiveTitleBarView immersiveTitleBarView = ImmersiveTitleBarView.this;
            View.OnClickListener onClickListener = immersiveTitleBarView.OooO00o;
            if (onClickListener != null) {
                onClickListener.onClick(immersiveTitleBarView.getCapsule());
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<Unit> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ImmersiveTitleBarView immersiveTitleBarView = ImmersiveTitleBarView.this;
            View.OnClickListener onClickListener = immersiveTitleBarView.OooO0O0;
            if (onClickListener != null) {
                onClickListener.onClick(immersiveTitleBarView.getCapsule());
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<CapsuleView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public CapsuleView invoke() {
            return (CapsuleView) ImmersiveTitleBarView.this.findViewById(R$id.capsule);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<FrameLayout> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) ImmersiveTitleBarView.this.findViewById(R$id.fl_home);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<AppCompatImageView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) ImmersiveTitleBarView.this.findViewById(R$id.iv_add_screen);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<AppCompatImageView> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) ImmersiveTitleBarView.this.findViewById(R$id.iv_home);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function0<TextView> {
        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) ImmersiveTitleBarView.this.findViewById(R$id.tv_app_title);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmersiveTitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f31821OooO0Oo = LazyKt__LazyJVMKt.b(new OooO0o());
        this.f31823OooO0o0 = LazyKt__LazyJVMKt.b(new OooOO0O());
        this.f31822OooO0o = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.OooO0oO = LazyKt__LazyJVMKt.b(new OooO());
        this.f31824OooO0oo = LazyKt__LazyJVMKt.b(new OooOO0());
        this.f31820OooO = LazyKt__LazyJVMKt.b(new OooOOO0());
        this.f31826OooOO0o = 1;
        LayoutInflater.from(context).inflate(R$layout.layout_mini_app_title_bar, this);
        getIvHome().setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImmersiveTitleBarView.OooO00o(this.f31893a, view);
            }
        });
        try {
            getIvHome().setRotationY(j0.a() ? 180.0f : 0.0f);
        } catch (Throwable th2) {
            TmcLogger.h("TitleBarView", th2);
        }
        CapsuleView capsule = getCapsule();
        capsule.setOnLeftClickListener(new OooO00o());
        capsule.setOnRightClickListener(new OooO0O0());
        OooO00o();
    }

    public static final void OooO00o(ImmersiveTitleBarView this$0, View view) {
        View.OnClickListener onClickListener;
        Intrinsics.g(this$0, "this$0");
        if (com.cloud.tmc.integration.utils.u.a()) {
            return;
        }
        int i11 = this$0.f31825OooOO0;
        if (i11 != 0) {
            if (i11 == 1 && (onClickListener = this$0.OooO00o) != null) {
                onClickListener.onClick(view);
                return;
            }
            return;
        }
        View.OnClickListener onClickListener2 = this$0.OooO0O0;
        if (onClickListener2 != null) {
            onClickListener2.onClick(view);
        }
    }

    public static final void OooO0O0(ImmersiveTitleBarView this$0, View view) {
        View.OnClickListener onClickListener;
        Intrinsics.g(this$0, "this$0");
        if (com.cloud.tmc.integration.utils.u.a() || (onClickListener = this$0.OooO0OO) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CapsuleView getCapsule() {
        Object value = this.f31822OooO0o.getValue();
        Intrinsics.f(value, "<get-capsule>(...)");
        return (CapsuleView) value;
    }

    private final FrameLayout getFlHome() {
        Object value = this.f31821OooO0Oo.getValue();
        Intrinsics.f(value, "<get-flHome>(...)");
        return (FrameLayout) value;
    }

    private final FrameLayout getFlMenuContainer() {
        Object value = this.OooO0oO.getValue();
        Intrinsics.f(value, "<get-flMenuContainer>(...)");
        return (FrameLayout) value;
    }

    private final AppCompatImageView getIvAddScreen() {
        Object value = this.f31824OooO0oo.getValue();
        Intrinsics.f(value, "<get-ivAddScreen>(...)");
        return (AppCompatImageView) value;
    }

    private final AppCompatImageView getIvHome() {
        Object value = this.f31823OooO0o0.getValue();
        Intrinsics.f(value, "<get-ivHome>(...)");
        return (AppCompatImageView) value;
    }

    private final TextView getTvAppTitle() {
        Object value = this.f31820OooO.getValue();
        Intrinsics.f(value, "<get-tvAppTitle>(...)");
        return (TextView) value;
    }

    public final void OooO00o() {
        int i11 = !z.a(getContext()) ? 1 : 0;
        this.f31826OooOO0o = i11;
        setThemeMode(i11);
        setPadding(0, isInEditMode() ? xb.a.b(24) : e0.a(), 0, 0);
        try {
            setBackgroundColor(Color.parseColor(eb.a.f64071a.a(getContext())));
        } catch (Throwable th2) {
            TmcLogger.h("[ImmersiveTitleBarView]: error", th2);
        }
    }

    public void attachPage(Page page) {
        AddScreenView addScreenView;
        tb.d pageContext;
        ViewGroup viewGroupV;
        if (page == null || (pageContext = page.getPageContext()) == null || (viewGroupV = pageContext.v()) == null || (addScreenView = (AddScreenView) viewGroupV.findViewById(R$id.addScreenView)) == null) {
            addScreenView = null;
        } else {
            addScreenView.setTranslationY(addScreenView.getTranslationY() + e0.a());
            addScreenView.setTranslationX(j0.a() ? getResources().getDimension(R$dimen.mini_dp_100) : getResources().getDimension(R$dimen.mini_dp_m_100));
            addScreenView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImmersiveTitleBarView.OooO0O0(this.f31894a, view);
                }
            });
        }
        this.OooOOO = addScreenView;
    }

    @Override // ub.c
    public boolean getAddScreenVisibility() {
        AddScreenView addScreenView = this.OooOOO;
        return addScreenView != null && xb.i.a(addScreenView);
    }

    @Override // ub.c
    public View getContent() {
        return this;
    }

    public Integer getHomeAction() {
        return Integer.valueOf(this.f31825OooOO0);
    }

    @Override // ub.c
    public boolean isTransparent() {
        return this.OooOO0O;
    }

    public void setAddScreenVisibility(boolean z11) {
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        super.setBackgroundColor(i11);
        if (this.OooOO0O) {
            return;
        }
        this.OooOOO0 = i11;
    }

    @Override // ub.c
    public void setHomeAction(int i11, boolean z11) {
        this.f31825OooOO0 = i11;
        if (z11) {
            setThemeMode(this.f31826OooOO0o);
        }
    }

    @Override // ub.c
    public void setHomeVisibility(boolean z11) {
        xb.i.f(getFlHome(), z11);
    }

    public void setOnAddScreenClickListener(View.OnClickListener onClickListener) {
        this.OooO0OO = onClickListener;
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        this.OooO00o = onClickListener;
    }

    public void setOnHomeClickListener(View.OnClickListener onClickListener) {
        this.OooO0O0 = onClickListener;
    }

    public void setThemeMode(int i11) {
        AddScreenView addScreenView;
        this.f31826OooOO0o = i11;
        AddScreenView addScreenView2 = this.OooOOO;
        if (addScreenView2 != null && xb.i.a(addScreenView2) && (addScreenView = this.OooOOO) != null) {
            addScreenView.setThemeMode(i11);
        }
        if (xb.i.a(this)) {
            int i12 = 0;
            xb.i.f(getIvHome(), this.f31825OooOO0 != 2);
            xb.i.f(getCapsule(), this.f31825OooOO0 == 2);
            if (xb.i.a(getCapsule())) {
                CapsuleView.OooO00o(getCapsule(), i11, null, 2);
            }
            if (i11 == 0) {
                getIvHome().setBackgroundResource(R$drawable.shape_bg_title_bar_no_stroke_white_mode);
                AppCompatImageView ivHome = getIvHome();
                int i13 = this.f31825OooOO0;
                if (i13 == 0) {
                    i12 = R$drawable.mini_ic_title_home_white_mode;
                } else if (i13 == 1) {
                    i12 = R$drawable.mini_ic_title_back_white_mode;
                }
                ivHome.setImageResource(i12);
                return;
            }
            if (i11 != 1) {
                return;
            }
            getIvHome().setBackgroundResource(R$drawable.shape_bg_title_bar_no_stroke_black_mode);
            AppCompatImageView ivHome2 = getIvHome();
            int i14 = this.f31825OooOO0;
            if (i14 == 0) {
                i12 = R$drawable.mini_ic_immersive_title_bar_home_black_mode;
            } else if (i14 == 1) {
                i12 = R$drawable.mini_ic_immersive_title_bar_back_black_mode;
            }
            ivHome2.setImageResource(i12);
        }
    }

    @Override // ub.c
    public void setTitle(String str) {
        TextView tvAppTitle = getTvAppTitle();
        if (str != null) {
            tvAppTitle.setText(str);
        }
    }

    @Override // ub.c
    public void setTitleBarVisible(boolean z11) {
        if (z11) {
            setThemeMode(this.f31826OooOO0o);
        }
        xb.i.f(this, z11);
    }

    @Override // ub.c
    public void setTitleColor(boolean z11) {
        getTvAppTitle().setTextColor(z2.a.getColor(getContext(), z11 ? R$color.default_navigation_bar_title_white_color : R$color.default_navigation_bar_title_black_color));
    }

    @Override // ub.c
    public void setTitleVisible(boolean z11) {
        xb.i.f(getTvAppTitle(), z11);
    }

    @Override // ub.c
    public void setTransparent(boolean z11) {
        this.OooOO0O = z11;
        if (z11) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(this.OooOOO0);
        }
    }
}
