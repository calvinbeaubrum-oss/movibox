package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.cvk;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Tf extends com.bytedance.sdk.openadsdk.core.ExN.zY {
    private Runnable ExN;
    private int Qj;
    private Runnable TRI;
    private long We;
    protected boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ExN.We f27693qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected UFX f27694sc;
    private int zY;

    public Tf(@NonNull Context context) {
        super(context);
        this.We = 10L;
        this.pFF = true;
        this.Qj = 1;
        zY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(int i11) {
        UFX ufx = this.f27694sc;
        if (ufx != null) {
            ufx.sc(i11);
        }
        if (i11 == 100 && this.pFF) {
            pFF();
        }
    }

    private void zY() {
        setBackgroundColor(Color.parseColor("#2E2E2E"));
        setVisibility(8);
    }

    private void zY(int i11) {
        if (this.Qj != i11) {
            this.Qj = i11;
            com.bytedance.sdk.openadsdk.core.ExN.We we2 = this.f27693qr;
            if (we2 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) we2.getLayoutParams();
                if (this.Qj == 1) {
                    marginLayoutParams.width = kX.zY(getContext(), 64.0f);
                    marginLayoutParams.height = kX.zY(getContext(), 24.0f);
                    marginLayoutParams.bottomMargin = kX.zY(getContext(), 60.0f);
                } else {
                    marginLayoutParams.width = kX.zY(getContext(), 41.0f);
                    marginLayoutParams.height = kX.zY(getContext(), 15.0f);
                    marginLayoutParams.bottomMargin = kX.zY(getContext(), 24.0f);
                }
                this.f27693qr.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public UFX getLoadingStyle() {
        return this.f27694sc;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        zY(configuration.orientation);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.ExN;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.ExN = null;
        }
    }

    public void pFF() {
        this.zY = 0;
        UFX ufx = this.f27694sc;
        if (ufx != null) {
            removeView(ufx.f27699sc);
            this.f27694sc.We();
        }
        setVisibility(8);
        this.f27694sc = null;
        Runnable runnable = this.ExN;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.TRI;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        this.TRI = null;
        this.ExN = null;
    }

    public void sc() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.Tf.2
            @Override // java.lang.Runnable
            public void run() {
                Tf tf2 = Tf.this;
                if (tf2.f27694sc != null) {
                    tf2.setVisibility(0);
                }
            }
        });
        if (this.ExN == null) {
            this.ExN = new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.Tf.3
                @Override // java.lang.Runnable
                public void run() {
                    Tf.this.pFF();
                }
            };
        }
        postDelayed(this.ExN, this.We * 1000);
    }

    public void sc(int i11) {
        if (i11 == 100 || Math.abs(i11 - this.zY) >= 7) {
            this.zY = i11;
            if (p8.a.e()) {
                pFF(this.zY);
                return;
            }
            if (this.TRI == null) {
                this.TRI = new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.Tf.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Tf tf2 = Tf.this;
                        tf2.pFF(tf2.zY);
                    }
                };
            }
            post(this.TRI);
        }
    }

    public void sc(final Sfl sfl) {
        com.bytedance.sdk.openadsdk.core.model.wjp wjpVarOl;
        if (sfl != null && (wjpVarOl = sfl.Ol()) != null) {
            this.We = wjpVarOl.sc();
        }
        UFX ufx = new UFX(getContext());
        this.f27694sc = ufx;
        View viewSc = ufx.sc();
        if (viewSc.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewSc.getParent()).removeView(viewSc);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        viewSc.setLayoutParams(layoutParams);
        if (sfl != null) {
            boolean zYL = sfl.yL();
            com.bytedance.sdk.openadsdk.core.widget.Xc xcPFF = this.f27694sc.pFF();
            if (xcPFF != null) {
                if (zYL) {
                    xcPFF.setVisibility(8);
                } else {
                    com.bytedance.sdk.openadsdk.core.model.BT btQfG = (sfl.qfG() == null || TextUtils.isEmpty(sfl.qfG().sc())) ? null : sfl.qfG();
                    if (btQfG == null || TextUtils.isEmpty(btQfG.sc())) {
                        xcPFF.setVisibility(8);
                    } else {
                        try {
                            com.bytedance.sdk.openadsdk.Ol.We.sc(btQfG).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(sfl, btQfG.sc(), new cvk(xcPFF)));
                        } catch (Throwable unused) {
                            xcPFF.setVisibility(8);
                        }
                    }
                }
            }
            com.bytedance.sdk.openadsdk.core.ExN.Qj qjZY = this.f27694sc.zY();
            if (qjZY != null) {
                if (zYL) {
                    qjZY.setText("Loading");
                } else if (TextUtils.isEmpty(sfl.YdT())) {
                    qjZY.setVisibility(8);
                } else {
                    qjZY.setText(sfl.YdT());
                }
            }
        }
        addView(viewSc);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(getContext());
        this.f27693qr = we2;
        we2.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(getContext(), "tt_ad_logo_big"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(kX.zY(getContext(), 64.0f), kX.zY(getContext(), 24.0f));
        layoutParams2.bottomMargin = kX.zY(getContext(), 60.0f);
        layoutParams2.gravity = 81;
        this.f27693qr.setLayoutParams(layoutParams2);
        addView(this.f27693qr);
        this.f27693qr.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.Tf.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Context context = Tf.this.getContext();
                Sfl sfl2 = sfl;
                TTWebsiteActivity.sc(context, sfl2, cJ.sc(sfl2));
            }
        });
        zY(getResources().getConfiguration().orientation);
    }
}
