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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class vn extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f23922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f23923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ec f23924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f23925d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ListView f23926f;

    /* JADX INFO: compiled from: source.java */
    public class a extends ec {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f23927f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, List list) {
            super(context);
            this.f23927f = list;
        }

        @Override // com.applovin.impl.ec
        public dc a() {
            return new dc.b(dc.c.SECTION_CENTERED).d("Select a network to load test ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
        }

        @Override // com.applovin.impl.ec
        public int b() {
            return 1;
        }

        @Override // com.applovin.impl.ec
        public List c(int i11) {
            return vn.this.f23925d;
        }

        @Override // com.applovin.impl.ec
        public int d(int i11) {
            return this.f23927f.size();
        }

        @Override // com.applovin.impl.ec
        public dc e(int i11) {
            return new fj("TEST MODE NETWORKS");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ec.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f23929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f23930b;

        public b(List list, com.applovin.impl.sdk.j jVar) {
            this.f23929a = list;
            this.f23930b = jVar;
        }

        @Override // com.applovin.impl.ec.a
        public void a(lb lbVar, dc dcVar) {
            List listSingletonList = Collections.singletonList(((ke) this.f23929a.get(lbVar.a())).m());
            if (listSingletonList.equals(this.f23930b.l0().b())) {
                this.f23930b.l0().a((List) null);
            } else {
                this.f23930b.l0().a(listSingletonList);
            }
            vn.this.f23924c.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends cg {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ ke f23932p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ke keVar, Context context, ke keVar2) {
            super(keVar, context);
            this.f23932p = keVar2;
        }

        @Override // com.applovin.impl.cg, com.applovin.impl.dc
        public int d() {
            if (Collections.singletonList(this.f23932p.m()).equals(vn.this.f23922a.l0().b())) {
                return R.drawable.applovin_ic_check_mark_borderless;
            }
            return 0;
        }

        @Override // com.applovin.impl.cg, com.applovin.impl.dc
        public int e() {
            if (Collections.singletonList(this.f23932p.m()).equals(vn.this.f23922a.l0().b())) {
                return -16776961;
            }
            return super.e();
        }

        @Override // com.applovin.impl.dc
        public SpannedString k() {
            return StringUtils.createSpannedString(this.f23932p.g(), o() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
        }
    }

    public vn() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ke keVar = (ke) it.next();
            arrayList.add(new c(keVar, this, keVar));
        }
        return arrayList;
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        return this.f23922a;
    }

    public void initialize(List<ke> list, com.applovin.impl.sdk.j jVar) {
        this.f23922a = jVar;
        this.f23923b = list;
        this.f23925d = a(list);
        a aVar = new a(this, list);
        this.f23924c = aVar;
        aVar.a(new b(list, jVar));
        this.f23924c.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Test Mode Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f23926f = listView;
        listView.setAdapter((ListAdapter) this.f23924c);
    }

    @Override // com.applovin.impl.se, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.f23925d = a(this.f23923b);
        this.f23924c.notifyDataSetChanged();
    }
}
