package com.applovin.impl;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class le extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private me f20451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ListView f20452b;

    /* JADX INFO: compiled from: source.java */
    public class a implements ec.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ke f20453a;

        /* JADX INFO: renamed from: com.applovin.impl.le$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0185a implements r.b {
            public C0185a() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                maxDebuggerMultiAdActivity.initialize(a.this.f20453a);
            }
        }

        public a(ke keVar) {
            this.f20453a = keVar;
        }

        @Override // com.applovin.impl.ec.a
        public void a(lb lbVar, dc dcVar) {
            if (lbVar.b() != me.a.TEST_ADS.ordinal()) {
                yp.a(dcVar.c(), dcVar.b(), le.this);
                return;
            }
            com.applovin.impl.sdk.j jVarO = this.f20453a.o();
            ke.b bVarX = this.f20453a.x();
            if (!le.this.f20451a.a(lbVar)) {
                yp.a(dcVar.c(), dcVar.b(), le.this);
                return;
            }
            if (ke.b.READY == bVarX) {
                r.a(le.this, MaxDebuggerMultiAdActivity.class, jVarO.e(), new C0185a());
            } else if (ke.b.DISABLED != bVarX) {
                yp.a(dcVar.c(), dcVar.b(), le.this);
            } else {
                jVarO.l0().a();
                yp.a(dcVar.c(), dcVar.b(), le.this);
            }
        }
    }

    public le() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        me meVar = this.f20451a;
        if (meVar != null) {
            return meVar.h().o();
        }
        return null;
    }

    public void initialize(ke keVar) {
        setTitle(keVar.g());
        me meVar = new me(keVar, this);
        this.f20451a = meVar;
        meVar.a(new a(keVar));
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f20452b = listView;
        listView.setAdapter((ListAdapter) this.f20451a);
    }

    @Override // com.applovin.impl.se, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.f20451a.h().b().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.f20451a.k();
            this.f20451a.c();
        }
    }
}
