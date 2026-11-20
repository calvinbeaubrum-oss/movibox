package com.mbridge.msdk.video.dynview.j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBTextView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeFramLayout;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f47687a = "mbridge_top_play_bg";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f47688b = "mbridge_top_finger_bg";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f47689c = "mbridge_bottom_play_bg";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f47690d = "mbridge_bottom_finger_bg";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f47691e = "mbridge_tv_count";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f47692f = "mbridge_sound_switch";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f47693g = "mbridge_top_control";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f47694h = "mbridge_tv_title";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f47695i = "mbridge_tv_desc";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f47696j = "mbridge_tv_install";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f47697k = "mbridge_sv_starlevel";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f47698l = "mbridge_sv_heat_count_level";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f47699m = "mbridge_tv_cta";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f47700n = "mbridge_native_ec_controller";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f47701o = "mbridge_reward_shape_choice_rl";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f47702p = "#FFFFFF";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f47703q = "#FF000000";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f47704r = "#40000000";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f47705s = "#CAEF79";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f47706t = "#2196F3";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f47707u = "#402196F3";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f47708v = "#8FC31F";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f47709w = "#03A9F4";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f47710x = "#FF89C120";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f47711y = "#FF2BAE5D";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f47712z = false;

    private int a(String str) {
        return v.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "id");
    }

    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    public final void a(View view, com.mbridge.msdk.video.dynview.c cVar) {
        Context context;
        int iA;
        if (view == null || cVar == null || (context = view.getContext()) == null) {
            return;
        }
        if (cVar.e() == 1) {
            view.setBackground(context.getResources().getDrawable(v.a(context, this.f47701o, "drawable")));
            TextView textView = (TextView) view.findViewById(a(this.f47694h));
            if (textView != null) {
                textView.setTextColor(Color.parseColor(this.f47703q));
            }
            TextView textView2 = (TextView) view.findViewById(a(this.f47695i));
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(this.f47703q));
            }
            iA = ai.a(context, 2.0f);
        } else {
            iA = ai.a(context, 10.0f);
            view.getBackground().setAlpha(100);
        }
        int iA2 = ai.a(context, 8.0f);
        View viewFindViewById = view.findViewById(a(this.f47696j));
        if (viewFindViewById != null) {
            if (cVar.f() != null && (cVar.f() instanceof MBridgeClickCTAView)) {
                ((MBridgeClickCTAView) cVar.f()).setObjectAnimator(new com.mbridge.msdk.video.dynview.h.b().c(viewFindViewById));
            }
            if (viewFindViewById instanceof TextView) {
                TextView textView3 = (TextView) viewFindViewById;
                textView3.setTextColor(Color.parseColor(this.f47702p));
                textView3.setTextSize(15.0f);
                String str = this.f47708v;
                String str2 = this.f47705s;
                com.mbridge.msdk.video.dynview.i.b.a.a(textView3, 1.0f, 5.0f, str2, new String[]{str, str2}, GradientDrawable.Orientation.LEFT_RIGHT);
            }
        }
        if (view.getLayoutParams() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(iA, iA, iA, iA2);
            layoutParams.height = ai.a(context, 60.0f);
            view.setLayoutParams(layoutParams);
        }
    }

    public final void a(View view, com.mbridge.msdk.video.dynview.c cVar, Map<String, Object> map) {
        TextView textView;
        TextView textView2;
        String str;
        String str2;
        Context context = view != null ? view.getContext() : null;
        if (context == null || cVar == null) {
            return;
        }
        if (map == null || !map.containsKey("is_dy_success")) {
            textView = (TextView) view.findViewById(a(this.f47691e));
            textView2 = (TextView) view.findViewById(a("mbridge_reward_click_tv"));
        } else {
            boolean zBooleanValue = ((Boolean) map.get("is_dy_success")).booleanValue();
            this.f47712z = zBooleanValue;
            if (zBooleanValue) {
                textView = (TextView) view.findViewById(b(this.f47691e));
                textView2 = (TextView) view.findViewById(b("mbridge_reward_click_tv"));
            } else {
                textView = (TextView) view.findViewById(a(this.f47691e));
                textView2 = (TextView) view.findViewById(a("mbridge_reward_click_tv"));
            }
        }
        if (textView != null) {
            textView.setBackgroundResource(v.a(context, "mbridge_reward_shape_progress", "drawable"));
            textView.setTextColor(Color.parseColor(this.f47702p));
            textView.setTextSize(11.0f);
        }
        if (textView2 != null) {
            textView2.setTextSize(20.0f);
            if (textView2 instanceof MBridgeTextView) {
                ((MBridgeTextView) textView2).setObjectAnimator(new com.mbridge.msdk.video.dynview.h.b().c(textView2));
            }
            if (textView2 instanceof MBTextView) {
                ((MBTextView) textView2).setAnimator(new com.mbridge.msdk.video.dynview.h.b().c(textView2));
            }
        }
        String str3 = this.f47703q;
        String str4 = this.f47705s;
        int i11 = cVar.i();
        float f11 = 10.0f;
        float f12 = 1.0f;
        if (i11 == 302) {
            str = this.f47706t;
            str2 = this.f47709w;
            str3 = this.f47702p;
            str4 = this.f47707u;
        } else if (i11 == 802) {
            str = this.f47702p;
            str3 = this.f47703q;
            str4 = this.f47704r;
            f11 = 25.0f;
            str2 = str;
            f12 = 0.5f;
        } else if (i11 != 5002010) {
            str = this.f47708v;
            str2 = this.f47705s;
            f11 = 5.0f;
        } else {
            str = this.f47708v;
            str3 = this.f47702p;
            str4 = str;
            str2 = str4;
        }
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor(str3));
            com.mbridge.msdk.video.dynview.i.b.a.a(textView2, f12, f11, str4, new String[]{str, str2}, GradientDrawable.Orientation.LEFT_RIGHT);
        }
        if (cVar.f() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.f().getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            cVar.f().setLayoutParams(layoutParams);
        }
        RelativeLayout relativeLayout = this.f47712z ? (RelativeLayout) view.findViewById(b(this.f47693g)) : (RelativeLayout) view.findViewById(a(this.f47693g));
        if (relativeLayout != null) {
            if (com.mbridge.msdk.video.dynview.a.a.f47533a == 0 && com.mbridge.msdk.video.dynview.a.a.f47534b == 0 && com.mbridge.msdk.video.dynview.a.a.f47535c == 0 && com.mbridge.msdk.video.dynview.a.a.f47536d == 0) {
                return;
            }
            relativeLayout.setVisibility(4);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
            alphaAnimation.setDuration(200L);
            relativeLayout.startAnimation(alphaAnimation);
            relativeLayout.setVisibility(0);
        }
    }

    public final void a(View view, Map<String, Object> map) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (view == null || !(view instanceof MBridgeFramLayout)) {
            return;
        }
        MBridgeFramLayout mBridgeFramLayout = (MBridgeFramLayout) view;
        AnimatorSet animatorSet = new AnimatorSet();
        if (view.getContext() != null) {
            if (map != null && map.containsKey("is_dy_success")) {
                this.f47712z = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            if (this.f47712z) {
                imageView = (ImageView) view.findViewById(b(this.f47687a));
                imageView2 = (ImageView) view.findViewById(b(this.f47688b));
                imageView3 = (ImageView) view.findViewById(b(this.f47689c));
                imageView4 = (ImageView) view.findViewById(b(this.f47690d));
            } else {
                imageView = (ImageView) view.findViewById(a(this.f47687a));
                imageView2 = (ImageView) view.findViewById(a(this.f47688b));
                imageView3 = (ImageView) view.findViewById(a(this.f47689c));
                imageView4 = (ImageView) view.findViewById(a(this.f47690d));
            }
            ObjectAnimator objectAnimatorA = imageView != null ? new com.mbridge.msdk.video.dynview.h.b().a(imageView) : null;
            ObjectAnimator objectAnimatorB = imageView2 != null ? new com.mbridge.msdk.video.dynview.h.b().b(imageView2) : null;
            ObjectAnimator objectAnimatorA2 = imageView3 != null ? new com.mbridge.msdk.video.dynview.h.b().a(imageView3) : null;
            ObjectAnimator objectAnimatorB2 = imageView4 != null ? new com.mbridge.msdk.video.dynview.h.b().b(imageView4) : null;
            if (objectAnimatorA == null || objectAnimatorA2 == null || objectAnimatorB == null || objectAnimatorB2 == null) {
                return;
            }
            animatorSet.playTogether(objectAnimatorA, objectAnimatorA2, objectAnimatorB, objectAnimatorB2);
            mBridgeFramLayout.setAnimatorSet(animatorSet);
        }
    }

    public final void b(View view, com.mbridge.msdk.video.dynview.c cVar, Map<String, Object> map) {
        LinearLayout linearLayout;
        View viewFindViewById;
        if (view == null || cVar == null) {
            return;
        }
        if (view.getContext() != null) {
            if (map != null && map.containsKey("is_dy_success")) {
                this.f47712z = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            if (this.f47712z) {
                linearLayout = (LinearLayout) view.findViewById(b(this.f47697k));
                viewFindViewById = view.findViewById(b(this.f47699m));
            } else {
                linearLayout = (LinearLayout) view.findViewById(a(this.f47697k));
                viewFindViewById = view.findViewById(a(this.f47699m));
            }
            View view2 = viewFindViewById;
            if (linearLayout != null && (linearLayout instanceof MBridgeLevelLayoutView)) {
                if (cVar.e() == 1) {
                    linearLayout.setOrientation(1);
                } else {
                    linearLayout.setOrientation(0);
                }
            }
            if (linearLayout != null && (linearLayout instanceof MBStarLevelLayoutView)) {
                linearLayout.setOrientation(0);
            }
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(this.f47700n));
            if (relativeLayout != null) {
                if (cVar.e() == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.setMargins(layoutParams.leftMargin + com.mbridge.msdk.video.dynview.a.a.f47533a, layoutParams.topMargin + com.mbridge.msdk.video.dynview.a.a.f47535c, layoutParams.rightMargin + com.mbridge.msdk.video.dynview.a.a.f47534b, layoutParams.bottomMargin + com.mbridge.msdk.video.dynview.a.a.f47536d);
                    relativeLayout.setLayoutParams(layoutParams);
                } else {
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams2.setMargins(layoutParams2.leftMargin + com.mbridge.msdk.video.dynview.a.a.f47533a, layoutParams2.topMargin + com.mbridge.msdk.video.dynview.a.a.f47535c, layoutParams2.rightMargin + com.mbridge.msdk.video.dynview.a.a.f47534b, layoutParams2.bottomMargin + com.mbridge.msdk.video.dynview.a.a.f47536d);
                    relativeLayout.setLayoutParams(layoutParams2);
                }
            }
            if (view2 != null) {
                if (view2 instanceof TextView) {
                    TextView textView = (TextView) view2;
                    textView.setTextColor(Color.parseColor(this.f47702p));
                    textView.setTextSize(22.0f);
                    com.mbridge.msdk.video.dynview.i.b.a.a(view2, 1.0f, cVar.i() == 1302 ? 25 : 5, this.f47705s, new String[]{this.f47710x, this.f47711y}, GradientDrawable.Orientation.LEFT_RIGHT);
                }
                int i11 = cVar.i();
                if (i11 == 404 || i11 == 704 || i11 == 1402) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new com.mbridge.msdk.video.dynview.h.b().c(view2));
                    animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.mbridge.msdk.video.dynview.j.b.1
                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator) {
                        }
                    });
                    if (view instanceof MBFrameLayout) {
                        ((MBFrameLayout) view).setAnimator(animatorSet);
                    }
                    if (view instanceof MBridgeFramLayout) {
                        ((MBridgeFramLayout) view).setAnimatorSet(animatorSet);
                    }
                    if (view instanceof MBridgeRelativeLayout) {
                        ((MBridgeRelativeLayout) view).setAnimatorSet(animatorSet);
                    }
                }
            }
        }
        new com.mbridge.msdk.video.dynview.h.b().c(view, 500L);
    }
}
