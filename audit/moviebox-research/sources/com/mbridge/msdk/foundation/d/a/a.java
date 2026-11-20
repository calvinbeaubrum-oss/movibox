package com.mbridge.msdk.foundation.d.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.FeedbackRadioGroup;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f44114a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f44115b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f44117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CampaignEx f44118e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private FeedBackButton f44120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f44121h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f44124k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MBFeedBackDialog f44125l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Dialog f44126m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private JSONArray f44127n;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f44132s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<C0485a> f44133t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f44136w;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f44116c = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f44119f = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f44122i = -1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f44123j = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f44128o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f44129p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f44130q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f44131r = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f44134u = ai.a(c.m().c(), 20.0f);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f44135v = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private com.mbridge.msdk.widget.dialog.a f44137x = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.foundation.d.a.a.1
        @Override // com.mbridge.msdk.widget.dialog.a
        public final void a() {
            a.a(a.this);
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void b() {
            a.b(a.this);
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void c() {
            a.c(a.this);
        }
    };

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f44138y = f44114a;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f44139z = -1;
    private int A = -1;
    private int B = -1;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.d.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0485a implements com.mbridge.msdk.widget.dialog.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.foundation.d.a f44146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f44147b;

        public C0485a(String str, com.mbridge.msdk.foundation.d.a aVar) {
            this.f44146a = aVar;
            this.f44147b = str;
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void a() {
            b.f44150c = false;
            com.mbridge.msdk.foundation.d.a aVar = this.f44146a;
            if (aVar != null) {
                aVar.a(a.f44115b);
            }
        }

        public final void a(int i11) {
            b.f44150c = true;
            com.mbridge.msdk.foundation.d.a aVar = this.f44146a;
            if (aVar == null || i11 != 2) {
                return;
            }
            aVar.a();
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void b() {
            b.f44150c = false;
            com.mbridge.msdk.foundation.d.a aVar = this.f44146a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void c() {
            com.mbridge.msdk.foundation.d.a aVar = this.f44146a;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public a(String str) {
        this.f44133t = new ArrayList();
        this.f44124k = str;
        if (this.f44133t == null) {
            this.f44133t = new ArrayList();
        }
        k();
        i();
        j();
    }

    private FeedbackRadioGroup a(com.mbridge.msdk.c.b.C0476b c0476b) {
        JSONArray jSONArrayB = c0476b.b();
        Context contextC = c.m().c();
        if (jSONArrayB == null || jSONArrayB.length() <= 0 || contextC == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(contextC);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    private void a(Context context) {
        if (context != null) {
            try {
                com.mbridge.msdk.click.c.e(context, ai.a(this.f44118e));
            } catch (Exception unused) {
                com.mbridge.msdk.click.c.c(context, ai.a(this.f44118e));
            }
        }
    }

    private void a(RadioButton radioButton) {
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mbridge.msdk.foundation.d.a.a.4
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                    if (z11) {
                        String unused = a.f44115b = (String) compoundButton.getText();
                    }
                    if (a.this.f44125l != null) {
                        a.this.f44125l.setCancelButtonClickable(!TextUtils.isEmpty(a.f44115b));
                    }
                }
            });
        }
    }

    public static /* synthetic */ void a(a aVar) {
        b.a().a(aVar.f44124k, 1, 4, f44115b, aVar.f44119f);
        List<C0485a> list = aVar.f44133t;
        if (list != null) {
            for (C0485a c0485a : list) {
                if (c0485a != null) {
                    c0485a.a();
                }
            }
        }
        if (!TextUtils.isEmpty(aVar.f44135v)) {
            try {
                Activity activityA = b.a().a(c.m().c());
                if (activityA != null) {
                    View viewInflate = LayoutInflater.from(activityA).inflate(v.a(activityA, "mbridge_cm_feedback_notice_layout", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                    Dialog dialog = new Dialog(activityA, 3);
                    aVar.f44126m = dialog;
                    dialog.requestWindowFeature(1);
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    Window window = aVar.f44126m.getWindow();
                    layoutParams.copyFrom(window.getAttributes());
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    aVar.f44126m.setContentView(viewInflate);
                    aVar.f44126m.show();
                    window.setAttributes(layoutParams);
                    viewInflate.postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.d.a.a.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (a.this.f44126m == null || !a.this.f44126m.isShowing()) {
                                    return;
                                }
                                a.this.f44126m.dismiss();
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                        }
                    }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        f44115b = "";
    }

    private void a(FeedbackRadioGroup feedbackRadioGroup, com.mbridge.msdk.c.b.C0476b c0476b) {
        ColorStateList colorStateList;
        JSONArray jSONArrayB = c0476b.b();
        Context contextC = c.m().c();
        if (jSONArrayB == null || jSONArrayB.length() <= 0 || contextC == null) {
            return;
        }
        v.a(contextC, "mbridge_cm_feedback_choice_btn_bg", "drawable");
        Resources resourcesA = v.a(contextC);
        int iA = v.a(contextC, "mbridge_cm_feedback_rb_text_color_color_list", TtmlNode.ATTR_TTS_COLOR);
        if (resourcesA != null) {
            try {
                colorStateList = resourcesA.getColorStateList(iA);
            } catch (Exception e11) {
                e11.printStackTrace();
                colorStateList = null;
            }
        } else {
            colorStateList = null;
        }
        int iA2 = ai.a(contextC, 1.0f);
        int iA3 = ai.a(contextC, 1.0f);
        int iA4 = ai.a(contextC, 1.0f);
        for (int i11 = 0; i11 < jSONArrayB.length(); i11++) {
            String strOptString = jSONArrayB.optString(i11);
            RadioButton radioButton = new RadioButton(contextC);
            radioButton.setButtonTintList(colorStateList);
            radioButton.setText(strOptString);
            if (colorStateList != null) {
                radioButton.setTextColor(colorStateList);
            }
            radioButton.setCompoundDrawablePadding(iA2);
            radioButton.setPadding(iA2, iA3, iA2, iA3);
            radioButton.setEllipsize(TextUtils.TruncateAt.END);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
            int i12 = iA4 / 4;
            layoutParams.setMargins(iA4, i12, iA4, i12);
            a(radioButton);
            feedbackRadioGroup.addView(radioButton, layoutParams);
        }
    }

    public static /* synthetic */ void b(a aVar) {
        b.a().a(aVar.f44124k, 0, 4, f44115b, aVar.f44119f);
        List<C0485a> list = aVar.f44133t;
        if (list != null) {
            for (C0485a c0485a : list) {
                if (c0485a != null) {
                    c0485a.b();
                }
            }
        }
        f44115b = "";
    }

    public static /* synthetic */ void c(a aVar) {
        b.a().a(aVar.f44124k, 0, 4, f44115b, aVar.f44119f);
        Context contextE = c.m().e();
        if (contextE == null) {
            contextE = c.m().c();
        }
        List<C0485a> list = aVar.f44133t;
        if (list != null) {
            for (C0485a c0485a : list) {
                if (c0485a != null) {
                    c0485a.b();
                }
            }
        }
        aVar.a(contextE);
        f44115b = "";
    }

    private void i() {
        Context contextC = c.m().c();
        if (contextC != null) {
            try {
                FeedBackButton feedBackButton = new FeedBackButton(contextC);
                this.f44120g = feedBackButton;
                int i11 = 8;
                if (this.f44138y != 8) {
                    i11 = 0;
                }
                feedBackButton.setVisibility(i11);
                this.f44120g.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.d.a.a.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.this.e();
                    }
                });
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    private void j() {
        try {
            if (b.a().a(c.m().c()) != null) {
                g gVarB = h.a().b(c.m().k());
                if (gVarB == null) {
                    h.a();
                    gVarB = i.a();
                }
                com.mbridge.msdk.c.b.C0476b c0476bD = gVarB.D();
                if (c0476bD == null) {
                    ad.c("", "feedback fbk is null");
                    return;
                }
                k();
                this.f44125l = new MBFeedBackDialog(b.a().a(c.m().c()), this.f44137x);
                FeedbackRadioGroup feedbackRadioGroupA = a(c0476bD);
                this.f44125l.setCancelText(c0476bD.d());
                this.f44125l.setConfirmText(c0476bD.a());
                this.f44125l.setPrivacyText(c0476bD.c());
                this.f44135v = c0476bD.e();
                this.f44125l.setTitle(c0476bD.f());
                this.f44125l.setContent(feedbackRadioGroupA);
                this.f44125l.setCancelButtonClickable(!TextUtils.isEmpty(f44115b));
                a(feedbackRadioGroupA, c0476bD);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void k() {
        if (this.f44137x == null) {
            this.f44137x = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.foundation.d.a.a.3
                @Override // com.mbridge.msdk.widget.dialog.a
                public final void a() {
                    a.a(a.this);
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void b() {
                    a.b(a.this);
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void c() {
                    a.c(a.this);
                }
            };
        }
    }

    private void l() {
        FeedBackButton feedBackButton = this.f44120g;
        if (feedBackButton != null) {
            int i11 = this.A;
            if (i11 > -1) {
                feedBackButton.setX(i11);
            }
            int i12 = this.B;
            if (i12 > -1) {
                this.f44120g.setY(i12);
            }
            float f11 = this.f44116c;
            if (f11 >= 0.0f) {
                this.f44120g.setAlpha(f11);
                this.f44120g.setEnabled(this.f44116c != 0.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.f44120g.getLayoutParams();
            int i13 = this.f44139z;
            if (i13 > 0) {
                this.f44120g.setWidth(i13);
                if (layoutParams != null) {
                    layoutParams.width = this.f44139z;
                }
            }
            int i14 = this.f44123j;
            if (i14 > 0) {
                this.f44120g.setHeight(i14);
                if (layoutParams != null) {
                    layoutParams.height = this.f44123j;
                }
            }
            if (layoutParams != null) {
                this.f44120g.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.f44121h)) {
                    this.f44120g.setTextColor(Color.parseColor(this.f44121h));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            float f12 = this.f44122i;
            if (f12 > 0.0f) {
                this.f44120g.setTextSize(f12);
            }
            JSONArray jSONArray = this.f44127n;
            if (jSONArray != null && jSONArray.length() == 4) {
                Context contextC = c.m().c();
                this.f44120g.setPadding(ai.a(contextC, (float) this.f44127n.optDouble(0)), ai.a(contextC, (float) this.f44127n.optDouble(1)), ai.a(contextC, (float) this.f44127n.optDouble(2)), ai.a(contextC, (float) this.f44127n.optDouble(3)));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i15 = this.f44134u;
            if (i15 > 0) {
                gradientDrawable.setCornerRadius(i15);
            }
            if (TextUtils.isEmpty(this.f44117d)) {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            } else {
                gradientDrawable.setColor(Color.parseColor(this.f44117d));
            }
            this.f44120g.setBackground(gradientDrawable);
        }
    }

    public final void a() {
        FeedBackButton feedBackButton = this.f44120g;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener(null);
            this.f44120g.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.f44120g.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f44120g);
            }
        }
        MBFeedBackDialog mBFeedBackDialog = this.f44125l;
        if (mBFeedBackDialog != null) {
            mBFeedBackDialog.cancel();
            this.f44125l.setListener(null);
        }
        this.f44125l = null;
        this.f44133t = null;
        this.f44120g = null;
        this.f44137x = null;
    }

    public final void a(int i11) {
        this.f44132s = i11;
    }

    public final void a(int i11, int i12, int i13, int i14, int i15, float f11, String str, String str2, float f12, JSONArray jSONArray) {
        if (i11 > -1) {
            this.A = i11;
        }
        if (i12 > -1) {
            this.B = i12;
        }
        if (i13 > -1) {
            this.f44139z = i13;
        }
        if (i14 > -1) {
            this.f44123j = i14;
        }
        if (f12 > -1.0f) {
            this.f44122i = f12;
        }
        if (jSONArray != null) {
            this.f44127n = jSONArray;
        }
        this.f44121h = str;
        this.f44117d = str2;
        this.f44116c = f11;
        this.f44134u = i15;
        l();
    }

    public final void a(C0485a c0485a) {
        if (this.f44133t == null) {
            this.f44133t = new ArrayList();
        }
        this.f44133t.add(c0485a);
    }

    public final void a(CampaignEx campaignEx) {
        this.f44118e = campaignEx;
    }

    public final void a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.f44120g;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.f44116c);
            feedBackButton.setEnabled(this.f44116c != 0.0f);
            feedBackButton.setVisibility(this.f44138y != 8 ? 0 : 8);
            this.f44120g = feedBackButton;
            CampaignEx campaignEx = this.f44118e;
            if (campaignEx != null && !campaignEx.isDynamicView()) {
                l();
            }
            feedBackButton.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.d.a.a.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.this.e();
                }
            });
        }
    }

    public final void a(String str) {
        this.f44119f = str;
    }

    public final void b() {
        MBFeedBackDialog mBFeedBackDialog = this.f44125l;
        if (mBFeedBackDialog == null || !mBFeedBackDialog.isShowing()) {
            return;
        }
        this.f44125l.cancel();
    }

    public final void b(int i11) {
        this.f44136w = i11;
    }

    public final CampaignEx c() {
        return this.f44118e;
    }

    public final void c(int i11) {
        this.f44138y = i11;
        FeedBackButton feedBackButton = this.f44120g;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i11);
        }
    }

    public final FeedBackButton d() {
        if (this.f44120g == null) {
            i();
        }
        return this.f44120g;
    }

    public final void e() {
        try {
            b.a().a(this.f44124k, 0, 1, f44115b, this.f44119f);
            Activity activityA = b.a().a(c.m().c());
            MBFeedBackDialog mBFeedBackDialog = this.f44125l;
            if (mBFeedBackDialog == null || mBFeedBackDialog.getContext() != activityA) {
                j();
            }
            Context contextC = c.m().c();
            FeedBackButton feedBackButton = this.f44120g;
            if (feedBackButton != null) {
                contextC = feedBackButton.getContext();
            }
            boolean zA = b.a().a(this.f44124k, contextC, this.f44125l);
            int i11 = zA ? 2 : 3;
            if (i11 == 2) {
                b.a().a(this.f44124k, 0, 2, f44115b, this.f44119f);
            } else {
                b.a().a(this.f44124k, 0, 3, f44115b, this.f44119f);
            }
            List<C0485a> list = this.f44133t;
            if (list != null) {
                for (C0485a c0485a : list) {
                    if (c0485a != null) {
                        c0485a.a(i11);
                    }
                }
            }
            if (zA) {
                return;
            }
            a(contextC);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final int f() {
        return this.f44132s;
    }

    public final int g() {
        return this.f44136w;
    }
}
