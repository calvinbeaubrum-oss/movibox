package com.bytedance.sdk.openadsdk.core.zY;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Qj.Sfl;
import com.bytedance.sdk.openadsdk.core.Qj.Xc;
import com.bytedance.sdk.openadsdk.core.model.SR;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.Tf;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.material.card.MaterialCardView;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr extends com.bytedance.sdk.openadsdk.core.Qj.sc implements c.a, c.d {
    private com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI BT;
    private Sfl Ql;
    private com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI SR;
    private PAGBannerAdWrapperListener Sfl;
    private String Xc;
    private ImageView dE;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public boolean f28584sc;
    private long wjp;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public PAGLogoView ExN;
        public com.bytedance.sdk.openadsdk.core.ExN.We TRI;
        public com.bytedance.sdk.openadsdk.core.ExN.We We;
        public Tf pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public FrameLayout f28589sc;
        public com.bytedance.sdk.openadsdk.core.ExN.We zY;

        private sc() {
        }
    }

    public qr(@NonNull Context context) {
        super(context);
        this.f28584sc = true;
        this.pFF = context;
    }

    private void ExN() {
        Xc xcSc = com.bytedance.sdk.openadsdk.core.zY.sc.sc(this.Ql.getExpectExpressWidth(), this.Ql.getExpectExpressHeight());
        if (this.Ql.getExpectExpressWidth() <= 0 || this.Ql.getExpectExpressHeight() <= 0) {
            int iZY = kX.zY(this.pFF);
            this.f28092qr = iZY;
            this.Qj = Float.valueOf(iZY / xcSc.pFF).intValue();
        } else {
            this.f28092qr = kX.zY(this.pFF, this.Ql.getExpectExpressWidth());
            this.Qj = kX.zY(this.pFF, this.Ql.getExpectExpressHeight());
        }
        int i11 = this.f28092qr;
        if (i11 > 0 && i11 > kX.zY(this.pFF)) {
            float fZY = kX.zY(this.pFF) / this.f28092qr;
            this.f28092qr = kX.zY(this.pFF);
            this.Qj = Float.valueOf(this.Qj * fZY).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f28092qr, this.Qj);
        }
        layoutParams.width = this.f28092qr;
        layoutParams.height = this.Qj;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        sc(xcSc);
    }

    private sc pFF(Xc xc2) {
        sc scVar = new sc();
        scVar.f28589sc = new FrameLayout(this.pFF);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        scVar.f28589sc.setLayoutParams(layoutParams);
        scVar.pFF = new Tf(this.pFF);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        scVar.pFF.setLayoutParams(layoutParams2);
        scVar.f28589sc.addView(scVar.pFF);
        int iZY = kX.zY(this.pFF, 28.0f);
        int iZY2 = kX.zY(this.pFF, 12.0f);
        int iZY3 = kX.zY(this.pFF, 2.25f);
        int iZY4 = kX.zY(this.pFF, 5.0f);
        if (xc2 != null && xc2.f28083sc == 1) {
            iZY = iZY2;
        }
        if (xc2 == null || xc2.f28083sc != 1) {
            iZY3 = iZY4;
        }
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(getContext());
        scVar.zY = we2;
        we2.setPadding(iZY3, iZY3, iZY3, iZY3);
        scVar.zY.setBackground(com.bytedance.sdk.openadsdk.core.widget.We.sc());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iZY, iZY);
        layoutParams3.setMargins(iZY4, iZY4, iZY4, iZY4);
        com.bytedance.sdk.openadsdk.core.ExN.We we3 = scVar.zY;
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        we3.setScaleType(scaleType);
        scVar.zY.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(getContext(), "tt_reward_full_mute"));
        scVar.zY.setLayoutParams(layoutParams3);
        scVar.f28589sc.addView(scVar.zY);
        if (xc2 == null || xc2.f28083sc != 1) {
            scVar.We = com.bytedance.sdk.openadsdk.core.widget.qr.pFF(getContext());
        } else {
            scVar.We = com.bytedance.sdk.openadsdk.core.widget.qr.sc(getContext());
        }
        scVar.We.setId(520093697);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = GravityCompat.END;
        layoutParams4.setMargins(iZY4, iZY4, iZY4, iZY4);
        scVar.We.setLayoutParams(layoutParams4);
        scVar.f28589sc.addView(scVar.We);
        scVar.ExN = new PAGLogoView(this.pFF);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
        layoutParams5.setMargins(iZY4, iZY4, iZY4, iZY4);
        scVar.ExN.setLayoutParams(layoutParams5);
        scVar.f28589sc.addView(scVar.ExN);
        scVar.TRI = new com.bytedance.sdk.openadsdk.core.ExN.We(this.pFF);
        int iZY5 = kX.zY(this.pFF, 11.0f);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(iZY5, iZY5);
        layoutParams6.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_END;
        layoutParams6.rightMargin = iZY4;
        layoutParams6.bottomMargin = iZY4;
        scVar.TRI.setVisibility(8);
        scVar.TRI.setScaleType(scaleType);
        scVar.TRI.setLayoutParams(layoutParams6);
        scVar.f28589sc.addView(scVar.TRI);
        return scVar;
    }

    private void sc(Xc xc2) {
        View view;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.zY;
        if (sfl != null) {
            int iDix = sfl.dix();
            sc scVarPFF = pFF(xc2);
            if (scVarPFF == null || (view = scVarPFF.f28589sc) == null) {
                return;
            }
            addView(view);
            com.bytedance.sdk.openadsdk.core.ExN.We we2 = scVarPFF.We;
            PAGLogoView pAGLogoView = scVarPFF.ExN;
            com.bytedance.sdk.openadsdk.core.ExN.We we3 = scVarPFF.TRI;
            if (we3 != null && this.zY.Qj()) {
                kX.sc((View) we3, 0);
                com.bytedance.sdk.openadsdk.Xc.zY.sc().sc((int) kX.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), 11.0f, true), we3, this.zY);
            }
            this.dE = scVarPFF.zY;
            com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI videoView = getVideoView();
            if (videoView instanceof com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI) {
                this.BT = videoView;
                videoView.setVideoAdLoadListener(this);
                this.BT.setVideoAdInteractionListener(this);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(we2, FriendlyObstructionPurpose.CLOSE_AD));
                FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
                arrayList.add(new Pair(pAGLogoView, friendlyObstructionPurpose));
                arrayList.add(new Pair(we3, friendlyObstructionPurpose));
                arrayList.add(new Pair(this.dE, FriendlyObstructionPurpose.VIDEO_CONTROLS));
                this.BT.sc(arrayList);
                this.BT.setAdCreativeClickListener(new com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.sc() { // from class: com.bytedance.sdk.openadsdk.core.zY.qr.1
                    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.sc
                    public void sc(View view2, int i11) {
                        if (qr.this.Sfl != null) {
                            qr.this.Sfl.onAdClicked();
                        }
                    }
                });
            }
            if (pAGLogoView != null) {
                pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.zY.qr.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TTWebsiteActivity.sc(((com.bytedance.sdk.openadsdk.core.Qj.sc) qr.this).pFF, ((com.bytedance.sdk.openadsdk.core.Qj.sc) qr.this).zY, ((com.bytedance.sdk.openadsdk.core.Qj.sc) qr.this).TRI);
                    }
                });
            }
            if (we2 != null) {
                we2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.zY.qr.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        qr.this.sc();
                    }
                });
                Sfl sfl2 = this.Ql;
                if (sfl2 != null) {
                    if (sfl2.getClickListener() != null) {
                        this.Ql.getClickListener().pFF(we2);
                    }
                    if (this.Ql.getClickCreativeListener() != null) {
                        this.Ql.getClickCreativeListener().pFF(we2);
                    }
                }
            }
            ImageView imageView = this.dE;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.zY.qr.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (qr.this.BT != null) {
                            boolean z11 = !qr.this.BT.Ol();
                            qr qrVar = qr.this;
                            Drawable drawableZY = z11 ? com.bytedance.sdk.component.utils.Sfl.zY(qrVar.getContext(), "tt_reward_full_mute") : com.bytedance.sdk.component.utils.Sfl.zY(qrVar.getContext(), "tt_reward_full_unmute");
                            qr.this.BT.setIsQuiet(z11);
                            qr.this.dE.setImageDrawable(drawableZY);
                            if (((com.bytedance.sdk.openadsdk.core.Qj.sc) qr.this).zY == null || ((com.bytedance.sdk.openadsdk.core.Qj.sc) qr.this).zY.GOt() == null || ((com.bytedance.sdk.openadsdk.core.Qj.sc) qr.this).zY.GOt().sc() == null) {
                                return;
                            }
                            if (z11) {
                                ((com.bytedance.sdk.openadsdk.core.Qj.sc) qr.this).zY.GOt().sc().Qj(qr.this.wjp);
                            } else {
                                ((com.bytedance.sdk.openadsdk.core.Qj.sc) qr.this).zY.GOt().sc().Ol(qr.this.wjp);
                            }
                        }
                    }
                });
            }
            Tf tf2 = scVarPFF.pFF;
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl3 = this.zY;
            if (sfl3 != null && sfl3.GOt() != null && tf2 != null) {
                int iTf = this.zY.GOt().Tf();
                float fQl = this.zY.GOt().Ql();
                if (iTf > 0 && fQl > 0.0f) {
                    tf2.setRatio(iTf / fQl);
                } else if (iDix == 15) {
                    tf2.setRatio(0.5625f);
                } else if (iDix == 5) {
                    tf2.setRatio(1.7777778f);
                } else {
                    tf2.setRatio(1.0f);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (videoView != null && tf2 != null) {
                tf2.addView(videoView, layoutParams);
                videoView.setTag(520093762, Boolean.TRUE);
            }
            sc((View) videoView, true);
            sc((View) this, true);
            sc(tf2);
        }
    }

    @Override // t8.c.d
    public void d_() {
    }

    @Override // t8.c.d
    public void g_() {
    }

    public long getVideoProgress() {
        return this.wjp;
    }

    @Override // t8.c.d
    public void h_() {
    }

    @Override // t8.c.d
    public void i_() {
        ImageView imageView = this.dE;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.sc
    public void sc() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.ExN;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.zY.zY zYVar = this.We;
        if (zYVar != null) {
            zYVar.sc();
        } else {
            TTDelegateActivity.sc(this.zY, this.Xc);
        }
    }

    @Override // t8.c.a
    public void sc(int i11, int i12) {
        ImageView imageView = this.dE;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // t8.c.d
    public void sc(long j11, long j12) {
        this.wjp = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.sc
    public void sc(View view, int i11, SR sr2) {
        Sfl sfl = this.Ql;
        if (sfl != null) {
            sfl.sc(view, i11, sr2);
            com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = this.BT;
            if (tri == null || !(tri.getNativeVideoController() instanceof com.bytedance.sdk.openadsdk.core.Ql.pFF.zY)) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.Ql.pFF.zY) this.BT.getNativeVideoController()).OXF();
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, Sfl sfl2, com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI tri) {
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zY = sfl;
        this.Ql = sfl2;
        this.SR = tri;
        this.TRI = "banner_ad";
        sfl2.addView(this, new ViewGroup.LayoutParams(-2, -2));
        ExN();
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.Sfl = pAGBannerAdWrapperListener;
    }

    public void setClosedListenerKey(String str) {
        this.Xc = str;
    }
}
