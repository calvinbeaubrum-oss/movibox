package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.sdk.R;
import com.tn.lib.view.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n3 extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f21228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ec f21229b;

    /* JADX INFO: compiled from: source.java */
    public class a extends ec {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f21230f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f21231g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f21232h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f21233i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ List f21234j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, List list, List list2, List list3, List list4, List list5) {
            super(context);
            this.f21230f = list;
            this.f21231g = list2;
            this.f21232h = list3;
            this.f21233i = list4;
            this.f21234j = list5;
        }

        @Override // com.applovin.impl.ec
        public int b() {
            return c.values().length;
        }

        @Override // com.applovin.impl.ec
        public List c(int i11) {
            List list;
            boolean z11 = true;
            if (i11 == c.MISSING_TC_NETWORKS.ordinal()) {
                list = this.f21230f;
            } else if (i11 == c.MISSING_AC_NETWORKS.ordinal()) {
                list = this.f21231g;
            } else {
                z11 = false;
                if (i11 == c.LISTED_TC_NETWORKS.ordinal()) {
                    list = this.f21232h;
                } else {
                    list = i11 == c.LISTED_AC_NETWORKS.ordinal() ? this.f21233i : this.f21234j;
                }
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(n3.this.a((rn) it.next(), z11));
            }
            return arrayList;
        }

        @Override // com.applovin.impl.ec
        public int d(int i11) {
            if (i11 == c.MISSING_TC_NETWORKS.ordinal()) {
                return this.f21230f.size();
            }
            if (i11 == c.MISSING_AC_NETWORKS.ordinal()) {
                return this.f21231g.size();
            }
            if (i11 == c.LISTED_TC_NETWORKS.ordinal()) {
                return this.f21232h.size();
            }
            return i11 == c.LISTED_AC_NETWORKS.ordinal() ? this.f21233i.size() : this.f21234j.size();
        }

        @Override // com.applovin.impl.ec
        public dc e(int i11) {
            if (i11 == c.MISSING_TC_NETWORKS.ordinal()) {
                return new fj("MISSING TCF VENDORS (TC STRING)");
            }
            if (i11 == c.MISSING_AC_NETWORKS.ordinal()) {
                return new fj("MISSING ATP NETWORKS (AC STRING)");
            }
            if (i11 == c.LISTED_TC_NETWORKS.ordinal()) {
                return new fj("LISTED TCF VENDORS (TC STRING)");
            }
            return i11 == c.LISTED_AC_NETWORKS.ordinal() ? new fj("LISTED ATP NETWORKS (AC STRING)") : new fj("NON-CONFIGURABLE NETWORKS");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ec.a {
        public b() {
        }

        @Override // com.applovin.impl.ec.a
        public void a(lb lbVar, dc dcVar) {
            yp.a(dcVar.c(), dcVar.b(), n3.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum c {
        MISSING_TC_NETWORKS,
        MISSING_AC_NETWORKS,
        LISTED_TC_NETWORKS,
        LISTED_AC_NETWORKS,
        OTHER_NETWORKS
    }

    /* JADX INFO: Access modifiers changed from: private */
    public dc a(rn rnVar, boolean z11) {
        dc.b bVarA = dc.a();
        boolean zB = this.f21228a.k0().b();
        rn.a aVarF = rnVar.f();
        rn.a aVar = rn.a.TCF_VENDOR;
        if (aVarF == aVar || (rnVar.f() == rn.a.ATP_NETWORK && zB)) {
            String strC = rnVar.c();
            String str = rnVar.f() == aVar ? "IAB Vendor ID: " : "Google ATP ID: ";
            bVarA.d(strC).d(z11 ? FlowLayout.SPACING_AUTO : ViewCompat.MEASURED_STATE_MASK).b(strC).a(str + rnVar.d()).a(true);
        } else {
            bVarA.d(rnVar.b());
        }
        return bVarA.a();
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        return this.f21228a;
    }

    public void initialize(List<rn> list, List<rn> list2, List<rn> list3, List<rn> list4, List<rn> list5, com.applovin.impl.sdk.j jVar) {
        this.f21228a = jVar;
        a aVar = new a(this, list, list2, list3, list4, list5);
        this.f21229b = aVar;
        aVar.a(new b());
        this.f21229b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Configured CMP Networks");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f21229b);
    }
}
