package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.applovin.sdk.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f21245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f21247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f21248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j4 f21249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h4.c f21250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h4.b f21251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j4 f21252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Dialog f21253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final p f21254j = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends p {
        public a() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            if ((activity instanceof AppLovinWebViewActivity) || n4.this.f21252h == null) {
                return;
            }
            if (n4.this.f21253i != null) {
                n4 n4Var = n4.this;
                if (!r.a(n4Var.a(n4Var.f21253i))) {
                    n4.this.f21253i.dismiss();
                }
                n4.this.f21253i = null;
            }
            j4 j4Var = n4.this.f21252h;
            n4.this.f21252h = null;
            n4 n4Var2 = n4.this;
            n4Var2.a(n4Var2.f21249e, j4Var, activity);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l4 f21256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j4 f21257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f21258c;

        public b(l4 l4Var, j4 j4Var, Activity activity) {
            this.f21256a = l4Var;
            this.f21257b = j4Var;
            this.f21258c = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i11) {
            n4.this.f21252h = null;
            n4.this.f21253i = null;
            j4 j4VarA = n4.this.a(this.f21256a.a());
            if (j4VarA == null) {
                n4.this.b("Destination state for TOS/PP alert is null");
                return;
            }
            n4.this.a(this.f21257b, j4VarA, this.f21258c);
            if (j4VarA.c() != j4.b.ALERT) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f21260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f21261b;

        public c(Uri uri, Activity activity) {
            this.f21260a = uri;
            this.f21261b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            yp.a(this.f21260a, this.f21261b, n4.this.f21245a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f21263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f21264b;

        public d(Uri uri, Activity activity) {
            this.f21263a = uri;
            this.f21264b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            yp.a(this.f21263a, this.f21264b, n4.this.f21245a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements CmpServiceImpl.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j4 f21266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f21267b;

        public e(j4 j4Var, Activity activity) {
            this.f21266a = j4Var;
            this.f21267b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.d
        public void a(AppLovinCmpError appLovinCmpError) {
            n4.this.a(this.f21266a, this.f21267b, Boolean.valueOf(appLovinCmpError == null));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements CmpServiceImpl.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j4 f21269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f21270b;

        public f(j4 j4Var, Activity activity) {
            this.f21269a = j4Var;
            this.f21270b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
        public void a(AppLovinCmpError appLovinCmpError) {
            if (appLovinCmpError == null && n4.this.f21251g != null) {
                n4.this.f21251g.a(true);
            }
            n4.this.b(this.f21269a, this.f21270b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j4 f21272a;

        public g(j4 j4Var) {
            this.f21272a = j4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            n4 n4Var = n4.this;
            n4Var.a(n4Var.f21249e, this.f21272a, n4.this.f21245a.n0());
        }
    }

    public n4(com.applovin.impl.sdk.j jVar) {
        this.f21245a = jVar;
        this.f21246b = ((Integer) jVar.a(sj.f23067t6)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity a(Dialog dialog) {
        Context context = dialog.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        if (baseContext instanceof Activity) {
            return (Activity) baseContext;
        }
        return null;
    }

    private j4 a() {
        List<j4> list = this.f21247c;
        if (list == null) {
            return null;
        }
        for (j4 j4Var : list) {
            if (j4Var.d()) {
                return j4Var;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j4 a(String str) {
        List<j4> list = this.f21247c;
        if (list == null) {
            return null;
        }
        for (j4 j4Var : list) {
            if (str.equalsIgnoreCase(j4Var.b())) {
                return j4Var;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AlertDialog alertDialog, Activity activity, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(alertDialog.getContext().getResources().getIdentifier("android:id/alertTitle", null, null));
        textView.setLinkTextColor(textView.getCurrentTextColor());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setMaxLines(this.f21246b);
        textView.setMinHeight(AppLovinSdkUtils.dpToPx(activity, 48));
    }

    private void a(j4 j4Var) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new g(j4Var), TimeUnit.SECONDS.toMillis(1L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(j4 j4Var, final Activity activity) {
        SpannableString spannableString;
        if (j4Var == null) {
            b("Consent flow state is null");
            return;
        }
        this.f21245a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f21245a.J().a("AppLovinSdk", "Transitioning to state: " + j4Var);
        }
        if (j4Var.c() == j4.b.ALERT) {
            if (r.a(activity)) {
                a(j4Var);
                return;
            }
            k4 k4Var = (k4) j4Var;
            this.f21252h = k4Var;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(false);
            for (l4 l4Var : k4Var.e()) {
                b bVar = new b(l4Var, j4Var, activity);
                if (l4Var.c() == l4.a.POSITIVE) {
                    builder.setPositiveButton(l4Var.d(), bVar);
                } else if (l4Var.c() == l4.a.NEGATIVE) {
                    builder.setNegativeButton(l4Var.d(), bVar);
                } else {
                    builder.setNeutralButton(l4Var.d(), bVar);
                }
            }
            String strG = k4Var.g();
            if (StringUtils.isValidString(strG)) {
                spannableString = new SpannableString(strG);
                String strA = com.applovin.impl.sdk.j.a(R.string.applovin_terms_of_service_text);
                String strA2 = com.applovin.impl.sdk.j.a(R.string.applovin_privacy_policy_text);
                if (StringUtils.containsAtLeastOneSubstring(strG, Arrays.asList(strA, strA2))) {
                    Uri uriI = this.f21245a.u().i();
                    if (uriI != null) {
                        StringUtils.addLinks(spannableString, Pattern.compile(strA), new c(uriI, activity), true);
                    }
                    StringUtils.addLinks(spannableString, Pattern.compile(strA2), new d(this.f21245a.u().h(), activity), true);
                }
            } else {
                spannableString = null;
            }
            final AlertDialog alertDialogCreate = builder.setTitle(spannableString).setMessage(k4Var.f()).create();
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.applovin.impl.f00
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    this.f18834a.a(alertDialogCreate, activity, dialogInterface);
                }
            });
            this.f21253i = alertDialogCreate;
            alertDialogCreate.show();
            return;
        }
        if (j4Var.c() == j4.b.EVENT) {
            m4 m4Var = (m4) j4Var;
            String strF = m4Var.f();
            Map<String, String> mapE = m4Var.e();
            if (mapE == null) {
                mapE = new HashMap<>(1);
            }
            mapE.put("flow_type", this.f21245a.u().e().b());
            this.f21245a.A().trackEvent(strF, mapE);
            b(m4Var, activity);
            return;
        }
        if (j4Var.c() == j4.b.HAS_USER_CONSENT) {
            a(true);
            b(j4Var, activity);
            return;
        }
        if (j4Var.c() == j4.b.CMP_LOAD) {
            if (r.a(activity)) {
                a(j4Var);
                return;
            } else {
                this.f21245a.o().loadCmp(activity, new e(j4Var, activity));
                return;
            }
        }
        if (j4Var.c() == j4.b.CMP_SHOW) {
            if (r.a(activity)) {
                a(j4Var);
                return;
            } else {
                this.f21245a.A().trackEvent("cf_start");
                this.f21245a.o().showCmp(activity, new f(j4Var, activity));
                return;
            }
        }
        if (j4Var.c() == j4.b.DECISION) {
            j4.a aVarA = j4Var.a();
            if (aVarA != j4.a.IS_AL_GDPR) {
                b("Invalid consent flow decision type: " + aVarA);
                return;
            }
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyF = this.f21245a.u().f();
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
            a(j4Var, activity, Boolean.valueOf(this.f21245a.r().getConsentFlowUserGeography() == consentFlowUserGeography || (consentFlowUserGeographyF == consentFlowUserGeography && yp.c(this.f21245a))));
            return;
        }
        if (j4Var.c() != j4.b.TERMS_FLOW) {
            if (j4Var.c() == j4.b.REINIT) {
                c();
                return;
            }
            b("Invalid consent flow destination state: " + j4Var);
            return;
        }
        List listA = g4.a(this.f21245a);
        if (listA == null || listA.size() <= 0) {
            c();
            return;
        }
        this.f21245a.A().trackEvent("cf_start");
        this.f21247c = listA;
        a(j4Var, a(), activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j4 j4Var, Activity activity, Boolean bool) {
        a(j4Var, a(j4Var.a(bool)), activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j4 j4Var, j4 j4Var2, Activity activity) {
        this.f21249e = j4Var;
        c(j4Var2, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j4 j4Var, Activity activity) {
        a(j4Var, activity, (Boolean) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        q6.a(str, new Object[0]);
        this.f21245a.E().a(la.I, str, (Map) CollectionUtils.hashMap("details", "Last started states: " + this.f21248d + "\nLast successful state: " + this.f21249e));
        h4.b bVar = this.f21251g;
        if (bVar != null) {
            bVar.a(new f4(f4.f18860f, str));
        }
        c();
    }

    private void c(final j4 j4Var, final Activity activity) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.g00
            @Override // java.lang.Runnable
            public final void run() {
                this.f19136a.a(j4Var, activity);
            }
        });
    }

    public void a(List list, Activity activity, h4.c cVar) {
        if (this.f21247c == null) {
            this.f21247c = list;
            this.f21248d = String.valueOf(list);
            this.f21250f = cVar;
            this.f21251g = new h4.b();
            com.applovin.impl.sdk.j.a(activity).a(this.f21254j);
            a((j4) null, a(), activity);
            return;
        }
        this.f21245a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f21245a.J().a("AppLovinSdk", "Unable to start states: " + list);
        }
        this.f21245a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f21245a.J().a("AppLovinSdk", "Consent flow already in progress for states: " + this.f21247c);
        }
        cVar.a(new h4.b(new f4(f4.f18859e, "Consent flow is already in progress.")));
    }

    public void a(boolean z11) {
        if (this.f21245a.u().e() == i4.a.TERMS) {
            return;
        }
        a4.b(z11, com.applovin.impl.sdk.j.l());
    }

    public boolean b() {
        return this.f21247c != null;
    }

    public void c() {
        h4.b bVar;
        this.f21247c = null;
        this.f21249e = null;
        this.f21245a.e().b(this.f21254j);
        h4.c cVar = this.f21250f;
        if (cVar != null && (bVar = this.f21251g) != null) {
            cVar.a(bVar);
        }
        this.f21250f = null;
        this.f21251g = null;
    }
}
