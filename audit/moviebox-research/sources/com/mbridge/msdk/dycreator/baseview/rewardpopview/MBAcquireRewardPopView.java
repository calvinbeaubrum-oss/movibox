package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBAcquireRewardPopView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f43542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AcquireRewardPopViewParameters f43543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnimationSet f43544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f43545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f43546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f43547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f43548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f43549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f43550i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f43551j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f43552k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final View.OnClickListener f43553l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Runnable f43554m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Runnable f43555n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View.OnTouchListener f43556o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final View.OnClickListener f43557p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final View.OnClickListener f43558q;

    public MBAcquireRewardPopView(Context context) {
        super(context);
        this.f43542a = "MBAcquireRewardPopView";
        this.f43545d = 0.0f;
        this.f43546e = 0.0f;
        this.f43547f = 0.0f;
        this.f43548g = 0.0f;
        this.f43553l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f43554m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean zContains = MBAcquireRewardPopView.this.f43543b.rightAnswerList.contains(str);
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                View viewE = zContains ? MBAcquireRewardPopView.e(mBAcquireRewardPopView2) : MBAcquireRewardPopView.f(mBAcquireRewardPopView2);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                }
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    if (zContains) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f43543b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView3.postDelayed(mBAcquireRewardPopView3.f43555n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
        };
        this.f43554m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.f43549h > 0) {
                    MBAcquireRewardPopView.i(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.f43554m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f43550i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f43555n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f43550i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f43556o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f43545d = motionEvent.getX();
                    MBAcquireRewardPopView.this.f43546e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f43547f = motionEvent.getX();
                        MBAcquireRewardPopView.this.f43548g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f43547f <= MBAcquireRewardPopView.this.f43545d || Math.abs(MBAcquireRewardPopView.this.f43547f - MBAcquireRewardPopView.this.f43545d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.f43548g - MBAcquireRewardPopView.this.f43546e) >= 100.0f) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f43545d, MBAcquireRewardPopView.this.f43546e);
                } else {
                    if (MBAcquireRewardPopView.this.f43551j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f43554m);
                    MBAcquireRewardPopView.this.f43551j = true;
                    View viewE = MBAcquireRewardPopView.e(MBAcquireRewardPopView.this);
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                    }
                    if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f43543b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f43555n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }
                return false;
            }
        };
        this.f43557p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f43545d, MBAcquireRewardPopView.this.f43546e);
                }
            }
        };
        this.f43558q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f43550i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43542a = "MBAcquireRewardPopView";
        this.f43545d = 0.0f;
        this.f43546e = 0.0f;
        this.f43547f = 0.0f;
        this.f43548g = 0.0f;
        this.f43553l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f43554m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean zContains = MBAcquireRewardPopView.this.f43543b.rightAnswerList.contains(str);
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                View viewE = zContains ? MBAcquireRewardPopView.e(mBAcquireRewardPopView2) : MBAcquireRewardPopView.f(mBAcquireRewardPopView2);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                }
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    if (zContains) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f43543b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView3.postDelayed(mBAcquireRewardPopView3.f43555n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
        };
        this.f43554m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.f43549h > 0) {
                    MBAcquireRewardPopView.i(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.f43554m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f43550i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f43555n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f43550i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f43556o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f43545d = motionEvent.getX();
                    MBAcquireRewardPopView.this.f43546e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f43547f = motionEvent.getX();
                        MBAcquireRewardPopView.this.f43548g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f43547f <= MBAcquireRewardPopView.this.f43545d || Math.abs(MBAcquireRewardPopView.this.f43547f - MBAcquireRewardPopView.this.f43545d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.f43548g - MBAcquireRewardPopView.this.f43546e) >= 100.0f) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f43545d, MBAcquireRewardPopView.this.f43546e);
                } else {
                    if (MBAcquireRewardPopView.this.f43551j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f43554m);
                    MBAcquireRewardPopView.this.f43551j = true;
                    View viewE = MBAcquireRewardPopView.e(MBAcquireRewardPopView.this);
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                    }
                    if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f43543b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f43555n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }
                return false;
            }
        };
        this.f43557p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f43545d, MBAcquireRewardPopView.this.f43546e);
                }
            }
        };
        this.f43558q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f43550i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43542a = "MBAcquireRewardPopView";
        this.f43545d = 0.0f;
        this.f43546e = 0.0f;
        this.f43547f = 0.0f;
        this.f43548g = 0.0f;
        this.f43553l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f43554m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean zContains = MBAcquireRewardPopView.this.f43543b.rightAnswerList.contains(str);
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                View viewE = zContains ? MBAcquireRewardPopView.e(mBAcquireRewardPopView2) : MBAcquireRewardPopView.f(mBAcquireRewardPopView2);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                }
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    if (zContains) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f43543b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView3.postDelayed(mBAcquireRewardPopView3.f43555n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
        };
        this.f43554m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.f43549h > 0) {
                    MBAcquireRewardPopView.i(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.f43554m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f43550i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f43555n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f43550i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f43556o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f43545d = motionEvent.getX();
                    MBAcquireRewardPopView.this.f43546e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f43547f = motionEvent.getX();
                        MBAcquireRewardPopView.this.f43548g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f43547f <= MBAcquireRewardPopView.this.f43545d || Math.abs(MBAcquireRewardPopView.this.f43547f - MBAcquireRewardPopView.this.f43545d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.f43548g - MBAcquireRewardPopView.this.f43546e) >= 100.0f) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f43545d, MBAcquireRewardPopView.this.f43546e);
                } else {
                    if (MBAcquireRewardPopView.this.f43551j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f43554m);
                    MBAcquireRewardPopView.this.f43551j = true;
                    View viewE = MBAcquireRewardPopView.e(MBAcquireRewardPopView.this);
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                    }
                    if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f43543b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f43555n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }
                return false;
            }
        };
        this.f43557p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f43545d, MBAcquireRewardPopView.this.f43546e);
                }
            }
        };
        this.f43558q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f43550i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f43542a = "MBAcquireRewardPopView";
        this.f43545d = 0.0f;
        this.f43546e = 0.0f;
        this.f43547f = 0.0f;
        this.f43548g = 0.0f;
        this.f43553l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f43554m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean zContains = MBAcquireRewardPopView.this.f43543b.rightAnswerList.contains(str);
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                View viewE = zContains ? MBAcquireRewardPopView.e(mBAcquireRewardPopView2) : MBAcquireRewardPopView.f(mBAcquireRewardPopView2);
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                }
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    if (zContains) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f43543b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView3 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView3.postDelayed(mBAcquireRewardPopView3.f43555n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
        };
        this.f43554m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.f43549h > 0) {
                    MBAcquireRewardPopView.i(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.f43554m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.f43550i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.f43555n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.f43550i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.f43556o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.f43545d = motionEvent.getX();
                    MBAcquireRewardPopView.this.f43546e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f43547f = motionEvent.getX();
                        MBAcquireRewardPopView.this.f43548g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f43547f <= MBAcquireRewardPopView.this.f43545d || Math.abs(MBAcquireRewardPopView.this.f43547f - MBAcquireRewardPopView.this.f43545d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.f43548g - MBAcquireRewardPopView.this.f43546e) >= 100.0f) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f43545d, MBAcquireRewardPopView.this.f43546e);
                } else {
                    if (MBAcquireRewardPopView.this.f43551j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.f43554m);
                    MBAcquireRewardPopView.this.f43551j = true;
                    View viewE = MBAcquireRewardPopView.e(MBAcquireRewardPopView.this);
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, childAt, viewE);
                    }
                    if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.f43543b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.f43555n, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }
                return false;
            }
        };
        this.f43557p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.f43545d, MBAcquireRewardPopView.this.f43546e);
                }
            }
        };
        this.f43558q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.f43543b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.f43543b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.f43550i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    private GradientDrawable a(int[] iArr, GradientDrawable.Orientation orientation) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(iArr);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(orientation);
        gradientDrawable.setShape(0);
        return gradientDrawable;
    }

    private View a(ArrayList<String> arrayList) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.a(getContext(), 290.0f), -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f43543b;
        int i11 = acquireRewardPopViewParameters.viewBackLayerTopColor;
        int i12 = acquireRewardPopViewParameters.viewBackLayerBottomColor;
        int i13 = acquireRewardPopViewParameters.viewForegroundTopColor;
        int i14 = acquireRewardPopViewParameters.viewForegroundBottomColor;
        int[] iArr = {i11, i12};
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        GradientDrawable gradientDrawableA = a(iArr, orientation);
        gradientDrawableA.setCornerRadius(ai.a(getContext(), 12.0f));
        GradientDrawable gradientDrawableA2 = a(new int[]{i13, i14}, orientation);
        gradientDrawableA2.setCornerRadius(ai.a(getContext(), 12.0f));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawableA, gradientDrawableA2});
        layerDrawable.setLayerInset(1, 5, 5, 5, 5);
        linearLayout.setBackground(layerDrawable);
        ImageView imageView = new ImageView(getContext());
        int iA = ai.a(getContext(), 20.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iA, iA);
        layoutParams2.gravity = GravityCompat.END;
        layoutParams2.setMargins(0, 13, 13, 0);
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageResource(getResources().getIdentifier("mbridge_reward_popview_close", "drawable", c.m().g()));
        imageView.setOnClickListener(this.f43558q);
        linearLayout.addView(imageView);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        int iA2 = ai.a(getContext(), 18.0f);
        layoutParams3.setMargins(iA2, 5, iA2, ai.a(getContext(), 12.0f));
        textView.setLayoutParams(layoutParams3);
        textView.setText(this.f43543b.title);
        textView.setTextColor(this.f43543b.titleTextColor);
        textView.setTextSize(18.0f);
        textView.setGravity(17);
        linearLayout.addView(textView);
        if (arrayList != null && arrayList.size() > 1) {
            int iA3 = ai.a(getContext(), 8.0f);
            int iA4 = ai.a(getContext(), 24.0f);
            int iA5 = ai.a(getContext(), 30.0f);
            int iA6 = ai.a(getContext(), 12.0f);
            int iA7 = ai.a(getContext(), 40.0f);
            for (int i15 = 0; i15 < arrayList.size(); i15++) {
                boolean zContains = this.f43543b.rightAnswerList.contains(arrayList.get(i15));
                TextView textView2 = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.gravity = 1;
                layoutParams4.setMargins(iA5, iA6, iA5, 0);
                textView2.setPadding(iA4, iA3, iA4, iA3);
                textView2.setLayoutParams(layoutParams4);
                textView2.setText(arrayList.get(i15));
                textView2.setSingleLine(true);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setTag(arrayList.get(i15));
                textView2.setTextSize(17.0f);
                textView2.setGravity(17);
                AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f43543b;
                textView2.setTextColor(zContains ? acquireRewardPopViewParameters2.buttonTextLightColor : acquireRewardPopViewParameters2.buttonTextDarkColor);
                AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.f43543b;
                int i16 = zContains ? acquireRewardPopViewParameters3.buttonBackgroundLightColor : acquireRewardPopViewParameters3.buttonBackgroundDarkColor;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(i16);
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(iA7);
                textView2.setBackground(gradientDrawable);
                textView2.setOnClickListener(this.f43553l);
                linearLayout.addView(textView2);
            }
        }
        this.f43552k = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        int iA8 = ai.a(getContext(), 16.0f);
        int iA9 = ai.a(getContext(), 18.0f);
        layoutParams5.setMargins(iA9, iA8, iA9, iA8);
        layoutParams5.gravity = 1;
        this.f43552k.setLayoutParams(layoutParams5);
        TextView textView3 = this.f43552k;
        AcquireRewardPopViewParameters acquireRewardPopViewParameters4 = this.f43543b;
        textView3.setText(String.format(acquireRewardPopViewParameters4.tips, Integer.valueOf(acquireRewardPopViewParameters4.reduceTime)));
        this.f43552k.setTextColor(this.f43543b.tipTextColor);
        this.f43552k.setGravity(17);
        this.f43552k.setTextSize(12.0f);
        linearLayout.addView(this.f43552k);
        return linearLayout;
    }

    public static /* synthetic */ void a(MBAcquireRewardPopView mBAcquireRewardPopView, final View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.8f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(1000L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(true);
        mBAcquireRewardPopView.f43544c = animationSet;
        animationSet.addAnimation(translateAnimation);
        mBAcquireRewardPopView.f43544c.addAnimation(alphaAnimation);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(1000L);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(MBAcquireRewardPopView.this.f43544c);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        mBAcquireRewardPopView.f43544c.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(alphaAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(mBAcquireRewardPopView.f43544c);
    }

    public static /* synthetic */ void a(MBAcquireRewardPopView mBAcquireRewardPopView, View view, View view2) {
        mBAcquireRewardPopView.removeView(view);
        mBAcquireRewardPopView.addView(view2);
    }

    public static /* synthetic */ View e(MBAcquireRewardPopView mBAcquireRewardPopView) {
        String str;
        LinearLayout linearLayout = new LinearLayout(mBAcquireRewardPopView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = mBAcquireRewardPopView.f43543b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.successTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.successTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.successTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(mBAcquireRewardPopView.getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, ai.a(mBAcquireRewardPopView.getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = mBAcquireRewardPopView.f43543b;
        int i11 = acquireRewardPopViewParameters2.viewType;
        if (i11 == 1) {
            str = acquireRewardPopViewParameters2.successTitle;
        } else {
            str = i11 == 2 ? acquireRewardPopViewParameters2.slideSuccessTitle : "";
        }
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setText(String.format(" %s ", str));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable gradientDrawableA = mBAcquireRewardPopView.a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(mBAcquireRewardPopView.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(mBAcquireRewardPopView.f43543b.successTipTextColor);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = mBAcquireRewardPopView.f43543b;
        textView.setText(String.format(acquireRewardPopViewParameters3.successTip, Integer.valueOf(acquireRewardPopViewParameters3.reduceTime)));
        int iA = ai.a(mBAcquireRewardPopView.getContext(), 6.0f);
        int iA2 = ai.a(mBAcquireRewardPopView.getContext(), 32.0f);
        textView.setPadding(iA2, iA, iA2, iA);
        textView.setBackground(gradientDrawableA);
        linearLayout.addView(textView);
        return linearLayout;
    }

    public static /* synthetic */ View f(MBAcquireRewardPopView mBAcquireRewardPopView) {
        LinearLayout linearLayout = new LinearLayout(mBAcquireRewardPopView.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = mBAcquireRewardPopView.f43543b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.failTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.failTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.failTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(mBAcquireRewardPopView.getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, ai.a(mBAcquireRewardPopView.getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        mBGradientAndShadowTextView.setText(String.format(" %s ", mBAcquireRewardPopView.f43543b.failTitle));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable gradientDrawableA = mBAcquireRewardPopView.a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(mBAcquireRewardPopView.getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(mBAcquireRewardPopView.f43543b.failTipTextColor);
        textView.setText(String.format(mBAcquireRewardPopView.f43543b.failTip, ""));
        int iA = ai.a(mBAcquireRewardPopView.getContext(), 6.0f);
        int iA2 = ai.a(mBAcquireRewardPopView.getContext(), 32.0f);
        textView.setPadding(iA2, iA, iA2, iA);
        textView.setBackground(gradientDrawableA);
        linearLayout.addView(textView);
        return linearLayout;
    }

    public static /* synthetic */ int i(MBAcquireRewardPopView mBAcquireRewardPopView) {
        int i11 = mBAcquireRewardPopView.f43549h;
        mBAcquireRewardPopView.f43549h = i11 - 1;
        return i11;
    }

    public void init(AcquireRewardPopViewParameters acquireRewardPopViewParameters) {
        View view;
        if (acquireRewardPopViewParameters == null) {
            ad.b("MBAcquireRewardPopView", "Must generate parameters.");
            return;
        }
        this.f43543b = acquireRewardPopViewParameters;
        if (acquireRewardPopViewParameters.viewType == 1) {
            ArrayList<String> arrayList = new ArrayList<>();
            AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f43543b;
            if (acquireRewardPopViewParameters2 != null) {
                Collection<? extends String> collection = acquireRewardPopViewParameters2.rightAnswerList;
                if (collection != null) {
                    arrayList.addAll(collection);
                }
                if (this.f43543b.wrongAnswerList != null) {
                    int iNextInt = new Random().nextInt(this.f43543b.wrongAnswerList.size());
                    if (iNextInt > this.f43543b.wrongAnswerList.size() - 1) {
                        iNextInt = 0;
                    }
                    arrayList.add(this.f43543b.wrongAnswerList.get(iNextInt));
                }
            }
            View viewA = a(arrayList);
            view = viewA;
            if (this.f43543b.canClickMaskArea) {
                setOnClickListener(this.f43557p);
                view = viewA;
            }
        } else {
            view = null;
        }
        View view2 = view;
        if (this.f43543b.viewType == 2) {
            int iA = ai.a(getContext(), 290.0f);
            LinearLayout linearLayout = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, -2);
            layoutParams.addRule(13);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
            AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.f43543b;
            gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters3.successTitleGradientStartColor;
            gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters3.successTitleGradientEndColor;
            gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters3.successTitleShadowColor;
            gradientAndShadowParameters.textSize = 30;
            MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(getContext(), gradientAndShadowParameters);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, 0, ai.a(getContext(), 12.0f));
            layoutParams2.gravity = 1;
            mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
            mBGradientAndShadowTextView.setText(String.format(" %s ", this.f43543b.slideTitle));
            mBGradientAndShadowTextView.setGravity(17);
            linearLayout.addView(mBGradientAndShadowTextView);
            GradientDrawable gradientDrawableA = a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
            this.f43552k = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 1;
            layoutParams3.setMargins(0, 0, 0, ai.a(getContext(), 25.0f));
            this.f43552k.setLayoutParams(layoutParams3);
            this.f43552k.setTextSize(12.0f);
            this.f43552k.setGravity(17);
            this.f43552k.setTextColor(this.f43543b.successTipTextColor);
            TextView textView = this.f43552k;
            AcquireRewardPopViewParameters acquireRewardPopViewParameters4 = this.f43543b;
            textView.setText(String.format(acquireRewardPopViewParameters4.slideTip, Integer.valueOf(acquireRewardPopViewParameters4.reduceTime)));
            int iA2 = ai.a(getContext(), 6.0f);
            int iA3 = ai.a(getContext(), 32.0f);
            this.f43552k.setPadding(iA3, iA2, iA3, iA2);
            this.f43552k.setBackground(gradientDrawableA);
            linearLayout.addView(this.f43552k);
            View imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = 1;
            imageView.setLayoutParams(layoutParams4);
            imageView.setBackgroundResource(getResources().getIdentifier("mbridge_slide_rightarrow", "drawable", c.m().g()));
            linearLayout.addView(imageView);
            View imageView2 = new ImageView(getContext());
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            imageView2.setBackgroundResource(getResources().getIdentifier("mbridge_slide_hand", "drawable", c.m().g()));
            linearLayout.addView(imageView2);
            imageView2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view3) {
                    MBAcquireRewardPopView.a(MBAcquireRewardPopView.this, view3);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view3) {
                    if (MBAcquireRewardPopView.this.f43544c != null) {
                        MBAcquireRewardPopView.this.f43544c.cancel();
                    }
                }
            });
            linearLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view3) {
                    MBAcquireRewardPopView.this.setLongClickable(true);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.setOnTouchListener(mBAcquireRewardPopView.f43556o);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view3) {
                }
            });
            view2 = linearLayout;
        }
        if (view2 != null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            setBackgroundColor(this.f43543b.containerBackgroundColor);
            addView(view2);
            int i11 = this.f43543b.autoDismissTime;
            if (i11 > 0) {
                this.f43549h = i11;
                post(this.f43554m);
                this.f43550i = true;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f43554m);
    }

    public void onPause() {
        if (!this.f43550i || this.f43549h <= 0) {
            return;
        }
        removeCallbacks(this.f43554m);
    }

    public void onResume() {
        if (!this.f43550i || this.f43549h <= 0) {
            return;
        }
        post(this.f43554m);
    }

    public void onStop() {
        if (!this.f43550i || this.f43549h <= 0) {
            return;
        }
        removeCallbacks(this.f43554m);
    }

    public void onTimeLessThanReduce(int i11) {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f43543b;
        acquireRewardPopViewParameters.reduceTime = i11;
        TextView textView = this.f43552k;
        if (textView != null) {
            textView.setText(String.format(acquireRewardPopViewParameters.tips, Integer.valueOf(i11)));
        }
    }
}
