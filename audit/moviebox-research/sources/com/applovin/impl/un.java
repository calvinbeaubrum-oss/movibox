package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannedString;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class un extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f23636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f23637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f23638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ec f23639d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f23640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f23641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ListView f23642h;

    /* JADX INFO: compiled from: source.java */
    public class a extends ec {
        public a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.ec
        public dc a() {
            return new dc.b(dc.c.SECTION_CENTERED).d("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
        }

        @Override // com.applovin.impl.ec
        public int b() {
            return c.COUNT.ordinal();
        }

        @Override // com.applovin.impl.ec
        public List c(int i11) {
            return i11 == c.BIDDERS.ordinal() ? un.this.f23640f : un.this.f23641g;
        }

        @Override // com.applovin.impl.ec
        public int d(int i11) {
            return i11 == c.BIDDERS.ordinal() ? un.this.f23640f.size() : un.this.f23641g.size();
        }

        @Override // com.applovin.impl.ec
        public dc e(int i11) {
            return i11 == c.BIDDERS.ordinal() ? new fj("BIDDERS") : new fj("WATERFALL");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends cg {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ jc f23644p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ke keVar, Context context, jc jcVar) {
            super(keVar, context);
            this.f23644p = jcVar;
        }

        @Override // com.applovin.impl.cg, com.applovin.impl.dc
        public int d() {
            if (un.this.f23636a.l0().b() == null || !un.this.f23636a.l0().b().equals(this.f23644p.b())) {
                return 0;
            }
            return R.drawable.applovin_ic_check_mark_borderless;
        }

        @Override // com.applovin.impl.cg, com.applovin.impl.dc
        public int e() {
            if (un.this.f23636a.l0().b() == null || !un.this.f23636a.l0().b().equals(this.f23644p.b())) {
                return super.e();
            }
            return -16776961;
        }

        @Override // com.applovin.impl.dc
        public SpannedString k() {
            return StringUtils.createSpannedString(this.f23644p.a(), o() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum c {
        BIDDERS,
        WATERFALL,
        COUNT
    }

    public un() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    private jc a(lb lbVar) {
        return lbVar.b() == c.BIDDERS.ordinal() ? (jc) this.f23637b.get(lbVar.a()) : (jc) this.f23638c.get(lbVar.a());
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jc jcVar = (jc) it.next();
            arrayList.add(new b(jcVar.d(), this, jcVar));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.j jVar, lb lbVar, dc dcVar) {
        List listB = a(lbVar).b();
        if (listB.equals(jVar.l0().b())) {
            jVar.l0().a((List) null);
        } else {
            jVar.l0().a(listB);
        }
        this.f23639d.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        return this.f23636a;
    }

    public void initialize(List<jc> list, List<jc> list2, final com.applovin.impl.sdk.j jVar) {
        this.f23636a = jVar;
        this.f23637b = list;
        this.f23638c = list2;
        this.f23640f = a(list);
        this.f23641g = a(list2);
        a aVar = new a(this);
        this.f23639d = aVar;
        aVar.a(new ec.a() { // from class: com.applovin.impl.c70
            @Override // com.applovin.impl.ec.a
            public final void a(lb lbVar, dc dcVar) {
                this.f18114a.a(jVar, lbVar, dcVar);
            }
        });
        this.f23639d.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f23642h = listView;
        listView.setAdapter((ListAdapter) this.f23639d);
    }

    @Override // com.applovin.impl.se, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.f23640f = a(this.f23637b);
        this.f23641g = a(this.f23638c);
        this.f23639d.c();
    }
}
