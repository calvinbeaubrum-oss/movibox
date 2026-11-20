package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.out.Campaign;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBAdChoice extends MBImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f48601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f48602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f48603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CampaignEx f48604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.foundation.d.a f48605f;

    public MBAdChoice(Context context) {
        super(context);
        this.f48601b = "";
        this.f48602c = "";
        this.f48603d = "";
        this.f48600a = context;
        a();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48601b = "";
        this.f48602c = "";
        this.f48603d = "";
        this.f48600a = context;
        a();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f48601b = "";
        this.f48602c = "";
        this.f48603d = "";
        this.f48600a = context;
        a();
    }

    private void a() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f48605f == null) {
            this.f48605f = new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.widget.MBAdChoice.1
                @Override // com.mbridge.msdk.foundation.d.a
                public final void a() {
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str) {
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void b() {
                }
            };
        }
        ai.a(this.f48604e, this.f48605f, 4, "");
        return true;
    }

    public void setCampaign(Campaign campaign) {
        if (!(campaign instanceof CampaignEx)) {
            this.f48604e = null;
            return;
        }
        CampaignEx campaignEx = (CampaignEx) campaign;
        this.f48604e = campaignEx;
        g gVarB = h.a().b(c.m().k());
        this.f48604e = campaignEx;
        if (campaignEx != null) {
            String privacyUrl = campaignEx.getPrivacyUrl();
            this.f48602c = privacyUrl;
            if (TextUtils.isEmpty(privacyUrl)) {
                CampaignEx.a adchoice = campaignEx.getAdchoice();
                if (adchoice != null) {
                    this.f48602c = adchoice.c();
                }
                if (TextUtils.isEmpty(this.f48602c) && gVarB != null) {
                    this.f48602c = gVarB.g();
                }
                if (TextUtils.isEmpty(this.f48602c)) {
                    this.f48602c = d.f().f44629f;
                }
            }
        } else if (gVarB != null) {
            this.f48602c = gVarB.g();
        }
        this.f48604e = campaignEx;
        if (campaignEx != null) {
            CampaignEx.a adchoice2 = campaignEx.getAdchoice();
            if (adchoice2 != null) {
                this.f48601b = adchoice2.b();
            }
            if (TextUtils.isEmpty(this.f48601b) && gVarB != null) {
                this.f48601b = gVarB.f();
            }
        } else if (gVarB != null) {
            this.f48601b = gVarB.f();
        }
        this.f48604e = campaignEx;
        if (campaignEx != null) {
            CampaignEx.a adchoice3 = campaignEx.getAdchoice();
            if (adchoice3 != null) {
                this.f48603d = adchoice3.d();
            }
            if (TextUtils.isEmpty(this.f48603d) && gVarB != null) {
                this.f48603d = gVarB.h();
            }
        } else if (gVarB != null) {
            this.f48603d = gVarB.h();
        }
        boolean z11 = (TextUtils.isEmpty(this.f48601b) || TextUtils.isEmpty(this.f48602c) || TextUtils.isEmpty(this.f48603d)) ? false : true;
        setImageUrl(this.f48601b);
        if (!z11 || this.f48600a == null) {
            return;
        }
        b.a(c.m().c()).a(this.f48601b, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.widget.MBAdChoice.2
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                MBAdChoice.this.setImageBitmap(bitmap);
            }
        });
    }

    public void setFeedbackDialogEventListener(com.mbridge.msdk.foundation.d.a aVar) {
        this.f48605f = aVar;
    }
}
