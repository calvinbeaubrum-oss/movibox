package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class nn extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f21374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ec f21375b;

    /* JADX INFO: compiled from: source.java */
    public class a extends ec {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f21376f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f21377g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f21378h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, ArrayList arrayList, ArrayList arrayList2, boolean z11) {
            super(context);
            this.f21376f = arrayList;
            this.f21377g = arrayList2;
            this.f21378h = z11;
        }

        @Override // com.applovin.impl.ec
        public int b() {
            return b.values().length;
        }

        @Override // com.applovin.impl.ec
        public List c(int i11) {
            return i11 == b.TC_NETWORKS.ordinal() ? this.f21376f : this.f21377g;
        }

        @Override // com.applovin.impl.ec
        public int d(int i11) {
            return i11 == b.TC_NETWORKS.ordinal() ? this.f21376f.size() : this.f21377g.size();
        }

        @Override // com.applovin.impl.ec
        public dc e(int i11) {
            if (i11 == b.TC_NETWORKS.ordinal()) {
                return new fj("TCF VENDORS (TC STRING)");
            }
            return new fj(this.f21378h ? "ATP NETWORKS (AC STRING)" : "APPLOVIN PRIVACY SETTING");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        TC_NETWORKS,
        AC_NETWORKS
    }

    private dc a(String str, String str2) {
        return dc.a().d(str).c(str2).a();
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        return this.f21374a;
    }

    public void initialize(com.applovin.impl.sdk.j jVar) {
        this.f21374a = jVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strA = a4.b().a(this);
        boolean zB = jVar.k0().b();
        if (!zB) {
            arrayList2.add(a("Has User Consent", strA));
        }
        for (rn rnVar : jVar.k0().i()) {
            Boolean boolA = rnVar.a();
            if (boolA != null) {
                if (rnVar.f() == rn.a.TCF_VENDOR) {
                    arrayList.add(a(rnVar.b(), String.valueOf(boolA)));
                } else if (rnVar.f() == rn.a.ATP_NETWORK) {
                    arrayList2.add(a(rnVar.b(), String.valueOf(boolA)));
                }
            } else if (zB && rnVar.f() == rn.a.ATP_NETWORK) {
                arrayList2.add(a(rnVar.b(), strA));
            }
        }
        a aVar = new a(this, arrayList, arrayList2, zB);
        this.f21375b = aVar;
        aVar.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Network Consent Statuses");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f21375b);
    }
}
