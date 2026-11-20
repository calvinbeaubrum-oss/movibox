package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerCmpNetworksListActivity;
import com.applovin.mediation.MaxDebuggerTcfStringActivity;
import com.applovin.sdk.R;
import com.tn.lib.view.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class pn extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f21781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ec f21782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f21783c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f21784d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f21785f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f21786g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f21787h = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public class a extends ec {
        public a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.ec
        public int b() {
            return e.values().length;
        }

        @Override // com.applovin.impl.ec
        public List c(int i11) {
            return i11 == e.IAB_TCF_PARAMETERS.ordinal() ? pn.this.c() : pn.this.a();
        }

        @Override // com.applovin.impl.ec
        public int d(int i11) {
            return i11 == e.IAB_TCF_PARAMETERS.ordinal() ? d.values().length : c.values().length;
        }

        @Override // com.applovin.impl.ec
        public dc e(int i11) {
            return i11 == e.IAB_TCF_PARAMETERS.ordinal() ? new fj("IAB TCF Parameters") : new fj("CMP CONFIGURATION");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ec.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qn f21789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f21790b;

        /* JADX INFO: compiled from: source.java */
        public class a implements r.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f21792a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f21793b;

            public a(String str, String str2) {
                this.f21792a = str;
                this.f21793b = str2;
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerTcfStringActivity maxDebuggerTcfStringActivity) {
                maxDebuggerTcfStringActivity.initialize(this.f21792a, this.f21793b, b.this.f21790b);
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.pn$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0193b implements r.b {
            public C0193b() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerCmpNetworksListActivity maxDebuggerCmpNetworksListActivity) {
                maxDebuggerCmpNetworksListActivity.initialize(pn.this.f21785f, pn.this.f21786g, pn.this.f21783c, pn.this.f21784d, pn.this.f21787h, b.this.f21790b);
            }
        }

        public b(qn qnVar, com.applovin.impl.sdk.j jVar) {
            this.f21789a = qnVar;
            this.f21790b = jVar;
        }

        @Override // com.applovin.impl.ec.a
        public void a(lb lbVar, dc dcVar) {
            String strA;
            String strC;
            if (lbVar.b() != e.IAB_TCF_PARAMETERS.ordinal()) {
                if (lbVar.a() == c.CONFIGURED_NETWORKS.ordinal()) {
                    r.a(pn.this, MaxDebuggerCmpNetworksListActivity.class, this.f21790b.e(), new C0193b());
                    return;
                } else {
                    yp.a(dcVar.c(), dcVar.b(), pn.this);
                    return;
                }
            }
            if (lbVar.a() == d.TC_STRING.ordinal()) {
                strA = uj.f23602s.a();
                strC = this.f21789a.k();
            } else {
                strA = uj.f23603t.a();
                strC = this.f21789a.c();
            }
            r.a(pn.this, MaxDebuggerTcfStringActivity.class, this.f21790b.e(), new a(strA, strC));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum c {
        CMP_SDK_ID,
        CMP_SDK_VERSION,
        INSTRUCTIONS,
        CONFIGURED_NETWORKS
    }

    /* JADX INFO: compiled from: source.java */
    public enum d {
        GDPR_APPLIES,
        TC_STRING,
        AC_STRING
    }

    /* JADX INFO: compiled from: source.java */
    public enum e {
        IAB_TCF_PARAMETERS,
        CMP_CONFIGURATION
    }

    private dc a(String str, Integer num) {
        return dc.a(dc.c.RIGHT_DETAIL).d(str).c(num != null ? num.toString() : "No value set").c(num != null ? ViewCompat.MEASURED_STATE_MASK : FlowLayout.SPACING_AUTO).a();
    }

    private dc a(String str, String str2, boolean z11) {
        boolean zIsValidString = StringUtils.isValidString(str2);
        if (zIsValidString && str2.length() > 35) {
            str2 = str2.substring(0, 35) + "...";
        }
        dc.b bVarD = dc.a(dc.c.DETAIL).d(str);
        if (!zIsValidString) {
            str2 = "No value set";
        }
        dc.b bVarA = bVarD.c(str2).c(z11 ? FlowLayout.SPACING_AUTO : ViewCompat.MEASURED_STATE_MASK).a(zIsValidString);
        if (zIsValidString) {
            bVarA.a(this);
        }
        return bVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a() {
        String str;
        ArrayList arrayList = new ArrayList(c.values().length);
        int size = this.f21785f.size() + this.f21786g.size();
        arrayList.add(b());
        arrayList.add(a(uj.f23600q.a(), this.f21781a.k0().f()));
        arrayList.add(dc.a(dc.c.DETAIL).d("To check which networks are missing from your CMP, first make sure that you have granted consent to all networks through your CMP flow. Then add the following networks to your CMP network list.").a());
        dc.b bVarD = dc.a(dc.c.RIGHT_DETAIL).d("Configured CMP Networks");
        if (size > 0) {
            str = "Missing " + size + " network(s)";
        } else {
            str = "";
        }
        arrayList.add(bVarD.c(str).c(size > 0 ? FlowLayout.SPACING_AUTO : ViewCompat.MEASURED_STATE_MASK).a(this).a(true).a());
        return arrayList;
    }

    private void a(rn rnVar, List list) {
        if (rnVar.d() != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (rnVar.d().equals(((rn) it.next()).d())) {
                    return;
                }
            }
        }
        list.add(rnVar);
    }

    private void a(List list) {
        boolean zB = this.f21781a.k0().b();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rn rnVar = (rn) it.next();
            if (rnVar.f() == rn.a.TCF_VENDOR) {
                if (Boolean.TRUE.equals(rnVar.a())) {
                    a(rnVar, this.f21783c);
                } else {
                    a(rnVar, this.f21785f);
                }
            } else if (rnVar.f() != rn.a.ATP_NETWORK) {
                this.f21787h.add(rnVar);
            } else if (!zB) {
                this.f21787h.add(rnVar);
            } else if (Boolean.TRUE.equals(rnVar.a())) {
                a(rnVar, this.f21784d);
            } else {
                a(rnVar, this.f21786g);
            }
        }
    }

    private dc b() {
        dc.b bVarA;
        String strA = uj.f23599p.a();
        Integer numE = this.f21781a.k0().e();
        if (StringUtils.isValidString(this.f21781a.k0().d())) {
            bVarA = dc.a(dc.c.RIGHT_DETAIL);
        } else {
            String str = "SharedPreferences value for key " + strA + " is " + numE + InstructionFileId.DOT;
            bVarA = dc.a(dc.c.DETAIL).b("Unknown CMP SDK ID").a("Your integrated CMP might not be Google-certified. " + str + "\n\nIf you use Google AdMob or Google Ad Manager, make sure that the integrated CMP is included in the list of Google-certified CMPs at: https://support.google.com/admob/answer/13554116").a(R.drawable.applovin_ic_warning).b(t3.a(R.color.applovin_sdk_warningColor, this)).a(true);
        }
        bVarA.d(strA);
        bVarA.c(numE != null ? numE.toString() : "No value set");
        bVarA.c(numE != null ? ViewCompat.MEASURED_STATE_MASK : FlowLayout.SPACING_AUTO);
        return bVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List c() {
        ArrayList arrayList = new ArrayList(d.values().length);
        Integer numG = this.f21781a.k0().g();
        String strK = this.f21781a.k0().k();
        String strC = this.f21781a.k0().c();
        arrayList.add(a(uj.f23601r.a(), numG));
        arrayList.add(a(uj.f23602s.a(), strK, !tn.b(strK)));
        arrayList.add(a(uj.f23603t.a(), strC, false));
        return arrayList;
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        return this.f21781a;
    }

    public void initialize(com.applovin.impl.sdk.j jVar) {
        this.f21781a = jVar;
        qn qnVarK0 = jVar.k0();
        a(qnVarK0.i());
        a aVar = new a(this);
        this.f21782b = aVar;
        aVar.a(new b(qnVarK0, jVar));
        this.f21782b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("CMP (Consent Management Platform)");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f21782b);
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ec ecVar = this.f21782b;
        if (ecVar != null) {
            ecVar.a((ec.a) null);
        }
    }
}
