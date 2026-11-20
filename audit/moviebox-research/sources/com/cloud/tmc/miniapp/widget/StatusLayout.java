package com.cloud.tmc.miniapp.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.x;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class StatusLayout extends FrameLayout {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public TextView f31863OooO;
    public ViewGroup OooO00o;
    public TextView OooO0O0;
    public TextView OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public AppCompatImageView f31864OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public LinearLayout f31865OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public TextView f31866OooO0o0;
    public ConstraintLayout OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public LoadingTextView f31867OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public MiniappLaunchLoadingView f31868OooOO0;
    public UpgradeHostAppPromptLayout OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public TextView f31869OooOO0o;
    public TextView OooOOO;
    public MiniNoNetworkView OooOOO0;
    public b OooOOOO;
    public boolean OooOOOo;
    public final View.OnClickListener OooOOo;
    public boolean OooOOo0;

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(StatusLayout statusLayout);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StatusLayout(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StatusLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StatusLayout(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StatusLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        this.OooOOo = new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatusLayout.OooO00o(this.f31947a, view);
            }
        };
    }

    public /* synthetic */ StatusLayout(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public static final void OooO00o(StatusLayout this$0, View view) {
        b bVar;
        Intrinsics.g(this$0, "this$0");
        if (!Intrinsics.b(view, this$0.f31866OooO0o0) || (bVar = this$0.OooOOOO) == null) {
            return;
        }
        bVar.a(this$0);
    }

    public static final void OooO0O0(StatusLayout this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
            Bundle bundle = new Bundle();
            if (this$0.OooOOo0) {
                bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, "1");
            } else {
                bundle.putString(RequestParameters.SUBRESOURCE_LOCATION, "0");
            }
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.recordForCommon(null, "settings_click", bundle);
            if (NetworkUtils.w()) {
                this$0.getContext().getApplicationContext().startActivity(new Intent("android.settings.WIFI_SETTINGS").setFlags(ASTNode.DEOP));
            } else if (NetworkUtils.t()) {
                this$0.getContext().getApplicationContext().startActivity(new Intent("android.settings.NETWORK_OPERATOR_SETTINGS").setFlags(ASTNode.DEOP));
            } else {
                this$0.getContext().getApplicationContext().startActivity(new Intent("android.settings.SETTINGS").setFlags(ASTNode.DEOP));
            }
        } catch (Throwable unused) {
        }
    }

    public final void OooO00o() {
        try {
            MiniappLaunchLoadingView miniappLaunchLoadingView = this.f31868OooOO0;
            if (miniappLaunchLoadingView != null) {
                try {
                    miniappLaunchLoadingView.f31841OooO0o0 = 0;
                    TranslateAnimation translateAnimation = miniappLaunchLoadingView.f31838OooO;
                    if (translateAnimation != null) {
                        translateAnimation.cancel();
                    }
                    AnimationSet animationSet = miniappLaunchLoadingView.f31842OooO0oo;
                    if (animationSet != null) {
                        animationSet.cancel();
                    }
                    com.cloud.tmc.kernel.utils.e.e(miniappLaunchLoadingView.f31843OooOO0);
                    miniappLaunchLoadingView.f31838OooO = null;
                    miniappLaunchLoadingView.f31842OooO0oo = null;
                    miniappLaunchLoadingView.f31840OooO0o = false;
                    miniappLaunchLoadingView.OooO0oO = false;
                } catch (Throwable th2) {
                    TmcLogger.h(miniappLaunchLoadingView.f31839OooO0Oo, th2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void OooO00o(Integer num) {
        if (num != null && num.intValue() == 2) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.widget_status_layout_normal_mode, (ViewGroup) this, false);
            Intrinsics.e(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
            this.OooO00o = (ViewGroup) viewInflate;
        } else {
            View viewInflate2 = LayoutInflater.from(getContext()).inflate(R$layout.widget_status_layout, (ViewGroup) this, false);
            Intrinsics.e(viewInflate2, "null cannot be cast to non-null type android.view.ViewGroup");
            this.OooO00o = (ViewGroup) viewInflate2;
        }
        ViewGroup viewGroup = this.OooO00o;
        this.OooO0O0 = viewGroup != null ? (TextView) viewGroup.findViewById(R$id.tv_status_title) : null;
        ViewGroup viewGroup2 = this.OooO00o;
        this.OooO0OO = viewGroup2 != null ? (TextView) viewGroup2.findViewById(R$id.tv_status_text) : null;
        ViewGroup viewGroup3 = this.OooO00o;
        this.f31864OooO0Oo = viewGroup3 != null ? (AppCompatImageView) viewGroup3.findViewById(R$id.iv_error_icon) : null;
        ViewGroup viewGroup4 = this.OooO00o;
        this.f31866OooO0o0 = viewGroup4 != null ? (TextView) viewGroup4.findViewById(R$id.tv_status_retry) : null;
        ViewGroup viewGroup5 = this.OooO00o;
        this.OooO0oO = viewGroup5 != null ? (ConstraintLayout) viewGroup5.findViewById(R$id.ll_error_layout) : null;
        ViewGroup viewGroup6 = this.OooO00o;
        this.f31865OooO0o = viewGroup6 != null ? (LinearLayout) viewGroup6.findViewById(R$id.ll_loading_layout) : null;
        ViewGroup viewGroup7 = this.OooO00o;
        MiniappLaunchLoadingView miniappLaunchLoadingView = viewGroup7 != null ? (MiniappLaunchLoadingView) viewGroup7.findViewById(R$id.cl_launcher_loading) : null;
        this.f31868OooOO0 = miniappLaunchLoadingView;
        if (miniappLaunchLoadingView != null) {
            miniappLaunchLoadingView.OooO0OO = num;
            if (num != null && num.intValue() == 2) {
                LayoutInflater.from(miniappLaunchLoadingView.getContext()).inflate(R$layout.layout_miniapp_launch_normal_mode, miniappLaunchLoadingView);
            } else {
                LayoutInflater.from(miniappLaunchLoadingView.getContext()).inflate(R$layout.layout_miniapp_launch, miniappLaunchLoadingView);
            }
            View viewFindViewById = miniappLaunchLoadingView.findViewById(R$id.iv_loading_img);
            Intrinsics.f(viewFindViewById, "findViewById(R.id.iv_loading_img)");
            miniappLaunchLoadingView.OooO00o = (AppCompatImageView) viewFindViewById;
            View viewFindViewById2 = miniappLaunchLoadingView.findViewById(R$id.ll_bottom);
            Intrinsics.f(viewFindViewById2, "findViewById(R.id.ll_bottom)");
            miniappLaunchLoadingView.OooO0O0 = (LinearLayoutCompat) viewFindViewById2;
        }
        ViewGroup viewGroup8 = this.OooO00o;
        this.f31863OooO = viewGroup8 != null ? (TextView) viewGroup8.findViewById(R$id.tv_loading_name) : null;
        ViewGroup viewGroup9 = this.OooO00o;
        this.f31867OooO0oo = viewGroup9 != null ? (LoadingTextView) viewGroup9.findViewById(R$id.tv_loading_progress) : null;
        ViewGroup viewGroup10 = this.OooO00o;
        this.f31869OooOO0o = viewGroup10 != null ? (TextView) viewGroup10.findViewById(R$id.tv_error_msg) : null;
        ViewGroup viewGroup11 = this.OooO00o;
        this.OooOOO = viewGroup11 != null ? (TextView) viewGroup11.findViewById(R$id.tv_go_setting) : null;
        ViewGroup viewGroup12 = this.OooO00o;
        MiniNoNetworkView miniNoNetworkView = viewGroup12 != null ? (MiniNoNetworkView) viewGroup12.findViewById(R$id.cl_no_network_view) : null;
        this.OooOOO0 = miniNoNetworkView;
        if (miniNoNetworkView != null) {
            miniNoNetworkView.OooO00o(num);
        }
        ViewGroup viewGroup13 = this.OooO00o;
        this.OooOO0O = viewGroup13 != null ? (UpgradeHostAppPromptLayout) viewGroup13.findViewById(R$id.ul_upgrade) : null;
        ViewGroup viewGroup14 = this.OooO00o;
        if ((viewGroup14 != null ? viewGroup14.getBackground() : null) == null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowBackground});
            Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…R.attr.windowBackground))");
            ViewGroup viewGroup15 = this.OooO00o;
            if (viewGroup15 != null) {
                viewGroup15.setBackground(typedArrayObtainStyledAttributes.getDrawable(0));
            }
            ViewGroup viewGroup16 = this.OooO00o;
            if (viewGroup16 != null) {
                viewGroup16.setClickable(true);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        TextView textView = this.OooOOO;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StatusLayout.OooO0O0(this.f31948a, view);
                }
            });
        }
        TextView textView2 = this.f31866OooO0o0;
        if (textView2 != null) {
            textView2.setOnClickListener(this.OooOOo);
        }
        ViewGroup viewGroup17 = this.OooO00o;
        if (viewGroup17 != null) {
            viewGroup17.setPadding(0, x.a(56.0f) + e0.a(), 0, 0);
        }
        ViewGroup viewGroup18 = this.OooO00o;
        xb.i.b(viewGroup18);
        addView(viewGroup18);
    }

    public final void OooO0O0() {
        if (this.OooO00o == null || !OooO0OO() || this.OooOOOo) {
            return;
        }
        ViewGroup viewGroup = this.OooO00o;
        if (viewGroup != null) {
            viewGroup.setVisibility(4);
        }
        LoadingTextView loadingTextView = this.f31867OooO0oo;
        if (loadingTextView != null) {
            loadingTextView.OooO00o();
        }
    }

    public final void OooO0O0(Integer num) {
        ViewGroup viewGroup;
        if (this.OooO00o == null) {
            OooO00o(num);
        }
        if (OooO0OO() || (viewGroup = this.OooO00o) == null) {
            return;
        }
        viewGroup.setVisibility(0);
    }

    public final boolean OooO0OO() {
        ViewGroup viewGroup = this.OooO00o;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public final void OooO0Oo() {
        this.OooOOOo = false;
        LinearLayout linearLayout = this.f31865OooO0o;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout = this.OooO0oO;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        MiniNoNetworkView miniNoNetworkView = this.OooOOO0;
        if (miniNoNetworkView != null) {
            miniNoNetworkView.setVisibility(8);
        }
    }

    public final void setHint(@StringRes int i11) {
        setHint(getResources().getString(i11));
    }

    public final void setHint(CharSequence charSequence) {
        TextView textView = this.OooO0OO;
        if (textView == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        textView.setText(charSequence);
    }

    public final void setHintColor(int i11) {
        TextView textView = this.OooO0OO;
        if (textView != null) {
            textView.setTextColor(z2.a.getColor(getContext(), i11));
        }
    }

    public final void setIcon(int i11) {
        setIcon(z2.a.getDrawable(getContext(), i11));
    }

    public final void setIcon(Drawable drawable) {
        AppCompatImageView appCompatImageView = this.f31864OooO0Oo;
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(drawable);
        }
    }

    public final void setLoadingProgressConfig(LoadingTextView.LoadingAnimationModel progressConfig) {
        Intrinsics.g(progressConfig, "progressConfig");
        LoadingTextView loadingTextView = this.f31867OooO0oo;
        if (loadingTextView == null) {
            return;
        }
        loadingTextView.setProgressConfigModel(progressConfig);
    }

    public final void setMainLayoutAlpha(float f11) {
        ViewGroup viewGroup = this.OooO00o;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setAlpha(f11);
    }

    public final void setOnCustomNoNetWorkOnPinForLaterListener(a aVar) {
    }

    public final void setOnCustomNoNetWorkRetryListener(b bVar) {
        MiniNoNetworkView miniNoNetworkView = this.OooOOO0;
        if (miniNoNetworkView != null) {
            miniNoNetworkView.setOnRetryListener(bVar);
        }
    }

    public final void setOnPinForLaterListener(a aVar) {
    }

    public final void setOnRetryListener(b bVar) {
        TextView textView;
        this.OooOOOO = bVar;
        if (!OooO0OO() || (textView = this.f31866OooO0o0) == null) {
            return;
        }
        textView.setVisibility(this.OooOOOO == null ? 4 : 0);
    }

    public final void setTitle(@StringRes int i11) {
        setTitle(getResources().getString(i11));
    }

    public final void setTitle(CharSequence charSequence) {
        TextView textView = this.OooO0O0;
        if (textView != null) {
            textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        }
        TextView textView2 = this.OooO0O0;
        if (textView2 == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        textView2.setText(charSequence);
    }

    public final void setTitleColor(int i11) {
        TextView textView = this.OooO0O0;
        if (textView != null) {
            textView.setTextColor(z2.a.getColor(getContext(), i11));
        }
    }
}
