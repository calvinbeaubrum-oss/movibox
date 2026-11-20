package com.applovin.impl;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTcfConsentStatusesListActivity;
import com.applovin.mediation.MaxDebuggerTcfInfoListActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.mediation.MaxDebuggerTestModeNetworkActivity;
import com.applovin.mediation.MaxDebuggerUnifiedFlowActivity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class re extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private te f22083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DataSetObserver f22084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FrameLayout f22085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ListView f22086d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private o f22087f;

    /* JADX INFO: compiled from: source.java */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            re.this.a();
            re reVar = re.this;
            reVar.b((Context) reVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ec.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f22089a;

        /* JADX INFO: compiled from: source.java */
        public class a implements r.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.applovin.impl.sdk.j f22091a;

            public a(com.applovin.impl.sdk.j jVar) {
                this.f22091a = jVar;
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerUnifiedFlowActivity maxDebuggerUnifiedFlowActivity) {
                maxDebuggerUnifiedFlowActivity.initialize(this.f22091a);
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.re$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0197b implements r.b {
            public C0197b() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerTcfInfoListActivity maxDebuggerTcfInfoListActivity) {
                maxDebuggerTcfInfoListActivity.initialize(re.this.f22083a.t());
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class c implements r.b {
            public c() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerTcfConsentStatusesListActivity maxDebuggerTcfConsentStatusesListActivity) {
                maxDebuggerTcfConsentStatusesListActivity.initialize(re.this.f22083a.t());
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class d implements r.b {
            public d() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(re.this.f22083a.e(), false, re.this.f22083a.t());
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class e implements r.b {
            public e() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                maxDebuggerTestLiveNetworkActivity.initialize(re.this.f22083a.j(), re.this.f22083a.w(), re.this.f22083a.t());
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class f implements r.b {
            public f() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerTestModeNetworkActivity maxDebuggerTestModeNetworkActivity) {
                maxDebuggerTestModeNetworkActivity.initialize(re.this.f22083a.v(), re.this.f22083a.t());
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class g implements r.b {
            public g() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(re.this.f22083a.n(), true, re.this.f22083a.t());
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class h implements r.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ dc f22099a;

            public h(dc dcVar) {
                this.f22099a = dcVar;
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                maxDebuggerDetailActivity.initialize(((cg) this.f22099a).r());
            }
        }

        public b(q qVar) {
            this.f22089a = qVar;
        }

        @Override // com.applovin.impl.ec.a
        public void a(lb lbVar, dc dcVar) {
            int iB = lbVar.b();
            if (iB == te.f.APP_INFO.ordinal()) {
                yp.a(dcVar.c(), dcVar.b(), re.this);
                return;
            }
            if (iB == te.f.MAX.ordinal()) {
                com.applovin.impl.sdk.j jVarT = re.this.f22083a.t();
                if (jVarT.u().k()) {
                    int iA = lbVar.a();
                    if (jVarT.u().e() != i4.a.UNIFIED) {
                        int i11 = iA + 1;
                        if (i11 == te.d.PRIVACY_POLICY_URL.ordinal()) {
                            if (jVarT.u().h() != null) {
                                tp.a(jVarT.u().h(), com.applovin.impl.sdk.j.l(), jVarT);
                                return;
                            } else {
                                yp.a("Missing Privacy Policy URL", "You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL", re.this);
                                return;
                            }
                        }
                        if (i11 == te.d.TERMS_OF_SERVICE_URL.ordinal()) {
                            if (jVarT.u().i() != null) {
                                tp.a(jVarT.u().i(), com.applovin.impl.sdk.j.l(), jVarT);
                                return;
                            }
                            return;
                        }
                    } else if (re.this.f22083a.a(dcVar)) {
                        r.a(re.this, MaxDebuggerUnifiedFlowActivity.class, this.f22089a, new a(jVarT));
                        return;
                    }
                }
                yp.a(dcVar.c(), dcVar.b(), re.this);
                return;
            }
            if (iB == te.f.PRIVACY.ordinal()) {
                if (lbVar.a() != te.e.CMP.ordinal()) {
                    if (lbVar.a() == te.e.NETWORK_CONSENT_STATUSES.ordinal()) {
                        r.a(re.this, MaxDebuggerTcfConsentStatusesListActivity.class, this.f22089a, new c());
                        return;
                    }
                    return;
                } else if (StringUtils.isValidString(re.this.f22083a.t().k0().k())) {
                    r.a(re.this, MaxDebuggerTcfInfoListActivity.class, this.f22089a, new C0197b());
                    return;
                } else {
                    yp.a(dcVar.c(), dcVar.b(), re.this);
                    return;
                }
            }
            if (iB != te.f.ADS.ordinal()) {
                if ((iB == te.f.INCOMPLETE_NETWORKS.ordinal() || iB == te.f.COMPLETED_NETWORKS.ordinal()) && (dcVar instanceof cg)) {
                    r.a(re.this, MaxDebuggerDetailActivity.class, this.f22089a, new h(dcVar));
                    return;
                }
                return;
            }
            if (lbVar.a() == te.b.AD_UNITS.ordinal()) {
                if (re.this.f22083a.e().size() > 0) {
                    r.a(re.this, MaxDebuggerAdUnitsListActivity.class, this.f22089a, new d());
                    return;
                } else {
                    yp.a("No live ad units", "Please setup or enable your MAX ad units on https://applovin.com.", re.this);
                    return;
                }
            }
            if (lbVar.a() == te.b.SELECT_LIVE_NETWORKS.ordinal()) {
                if (re.this.f22083a.j().size() <= 0 && re.this.f22083a.w().size() <= 0) {
                    yp.a("Complete Integrations", "Please complete integrations in order to access this.", re.this);
                    return;
                } else if (re.this.f22083a.t().l0().c()) {
                    yp.a("Restart Required", dcVar.b(), re.this);
                    return;
                } else {
                    r.a(re.this, MaxDebuggerTestLiveNetworkActivity.class, this.f22089a, new e());
                    return;
                }
            }
            if (lbVar.a() != te.b.SELECT_TEST_MODE_NETWORKS.ordinal()) {
                if (lbVar.a() == te.b.INITIALIZATION_AD_UNITS.ordinal()) {
                    r.a(re.this, MaxDebuggerAdUnitsListActivity.class, this.f22089a, new g());
                }
            } else if (!re.this.f22083a.t().l0().c()) {
                re.this.getSdk().l0().a();
                yp.a("Restart Required", dcVar.b(), re.this);
            } else if (re.this.f22083a.v().size() > 0) {
                r.a(re.this, MaxDebuggerTestModeNetworkActivity.class, this.f22089a, new f());
            } else {
                yp.a("Complete Integrations", "Please complete integrations in order to access this.", re.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        o oVar = this.f22087f;
        if (oVar != null) {
            oVar.b();
            this.f22085c.removeView(this.f22087f);
            this.f22087f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context) {
        yp.a(this.f22083a.h(), this.f22083a.g(), context);
    }

    private void b() {
        String strO = this.f22083a.o();
        if (TextUtils.isEmpty(strO)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", strO);
        intent.putExtra("android.intent.extra.TITLE", "Mediation Debugger logs");
        intent.putExtra("android.intent.extra.SUBJECT", "MAX Mediation Debugger logs");
        startActivity(Intent.createChooser(intent, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context) {
        if (!StringUtils.isValidString(this.f22083a.g()) || this.f22083a.d()) {
            return;
        }
        this.f22083a.b(true);
        runOnUiThread(new Runnable() { // from class: com.applovin.impl.u40
            @Override // java.lang.Runnable
            public final void run() {
                this.f23518a.a(context);
            }
        });
    }

    private void c() {
        a();
        o oVar = new o(this, 50, R.attr.progressBarStyleLarge);
        this.f22087f = oVar;
        oVar.setColor(-3355444);
        this.f22085c.addView(this.f22087f, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f22085c.bringChildToFront(this.f22087f);
        this.f22087f.a();
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        te teVar = this.f22083a;
        if (teVar != null) {
            return teVar.t();
        }
        return null;
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(com.applovin.sdk.R.layout.mediation_debugger_list_view);
        this.f22085c = (FrameLayout) findViewById(R.id.content);
        ListView listView = (ListView) findViewById(com.applovin.sdk.R.id.listView);
        this.f22086d = listView;
        listView.setAdapter((ListAdapter) this.f22083a);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.applovin.sdk.R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        te teVar = this.f22083a;
        if (teVar != null) {
            teVar.unregisterDataSetObserver(this.f22084b);
            this.f22083a.a((ec.a) null);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (com.applovin.sdk.R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        b();
        return true;
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        te teVar = this.f22083a;
        if (teVar == null || teVar.x()) {
            return;
        }
        c();
    }

    public void setListAdapter(te teVar, q qVar) {
        DataSetObserver dataSetObserver;
        te teVar2 = this.f22083a;
        if (teVar2 != null && (dataSetObserver = this.f22084b) != null) {
            teVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f22083a = teVar;
        this.f22084b = new a();
        b((Context) this);
        this.f22083a.registerDataSetObserver(this.f22084b);
        this.f22083a.a(new b(qVar));
    }
}
