package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerWaterfallSegmentsActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f17802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.applovin.impl.sdk.j f17803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ec f17804c;

    /* JADX INFO: compiled from: source.java */
    public class a extends ec {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ z f17805f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, z zVar) {
            super(context);
            this.f17805f = zVar;
        }

        @Override // com.applovin.impl.ec
        public int b() {
            return this.f17805f.g().size();
        }

        @Override // com.applovin.impl.ec
        public List c(int i11) {
            ArrayList arrayList = new ArrayList();
            a0 a0Var = (a0) this.f17805f.g().get(i11);
            arrayList.add(b0.this.c(a0Var.c()));
            if (a0Var.b() != null) {
                arrayList.add(b0.this.a("AB Test Experiment Name", a0Var.b()));
            }
            kr krVarD = a0Var.d();
            b0 b0Var = b0.this;
            arrayList.add(b0Var.a("Device ID Targeting", b0Var.a(krVarD.a())));
            b0 b0Var2 = b0.this;
            arrayList.add(b0Var2.a("Device Type Targeting", b0Var2.b(krVarD.b())));
            if (krVarD.c() != null) {
                arrayList.add(b0.this.a(krVarD.c()));
            }
            return arrayList;
        }

        @Override // com.applovin.impl.ec
        public int d(int i11) {
            a0 a0Var = (a0) this.f17805f.g().get(i11);
            return (a0Var.b() != null ? 1 : 0) + 3 + (a0Var.d().c() != null ? 1 : 0);
        }

        @Override // com.applovin.impl.ec
        public dc e(int i11) {
            if (i11 == b.TARGETED_WATERFALL.ordinal()) {
                return new fj("TARGETED WATERFALL FOR CURRENT DEVICE");
            }
            return i11 == b.OTHER_WATERFALLS.ordinal() ? new fj("OTHER WATERFALLS") : new fj("");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        TARGETED_WATERFALL,
        OTHER_WATERFALLS
    }

    /* JADX INFO: Access modifiers changed from: private */
    public dc a(String str, String str2) {
        return dc.a(dc.c.RIGHT_DETAIL).d(str).c(str2).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public dc a(List list) {
        return dc.a(dc.c.DETAIL).d("Segment Targeting").a(StringUtils.createSpannedString(list.size() + " segment group(s)", -7829368, 14)).a(this).a(true).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (str.equals("idfa")) {
            return "IDFA Only";
        }
        return str.equals("dnt") ? "No IDFA Only" : "All";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.applovin.impl.sdk.j jVar, final z zVar, final lb lbVar, dc dcVar) {
        if (lbVar.a() == 0) {
            r.a(this, MaxDebuggerAdUnitDetailActivity.class, jVar.e(), new r.b() { // from class: com.applovin.impl.zs
                @Override // com.applovin.impl.r.b
                public final void a(Activity activity) {
                    b0.a(zVar, lbVar, jVar, (MaxDebuggerAdUnitDetailActivity) activity);
                }
            });
        } else {
            r.a(this, MaxDebuggerWaterfallSegmentsActivity.class, jVar.e(), new r.b() { // from class: com.applovin.impl.at
                @Override // com.applovin.impl.r.b
                public final void a(Activity activity) {
                    b0.a(zVar, lbVar, jVar, (MaxDebuggerWaterfallSegmentsActivity) activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(z zVar, lb lbVar, com.applovin.impl.sdk.j jVar, MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
        maxDebuggerAdUnitDetailActivity.initialize(zVar, (a0) zVar.g().get(lbVar.b()), null, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(z zVar, lb lbVar, com.applovin.impl.sdk.j jVar, MaxDebuggerWaterfallSegmentsActivity maxDebuggerWaterfallSegmentsActivity) {
        a0 a0Var = (a0) zVar.g().get(lbVar.b());
        maxDebuggerWaterfallSegmentsActivity.initialize(a0Var.c(), a0Var.d().c(), jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        if (str.equals("phone")) {
            return "Phones";
        }
        return str.equals("tablet") ? "Tablets" : "All";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public dc c(String str) {
        return dc.a(dc.c.RIGHT_DETAIL).b(StringUtils.createSpannedString(str, ViewCompat.MEASURED_STATE_MASK, 18, 1)).a(this).a(true).a();
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        return this.f17803b;
    }

    public void initialize(final z zVar, final com.applovin.impl.sdk.j jVar) {
        this.f17802a = zVar;
        this.f17803b = jVar;
        a aVar = new a(this, zVar);
        this.f17804c = aVar;
        aVar.a(new ec.a() { // from class: com.applovin.impl.ys
            @Override // com.applovin.impl.ec.a
            public final void a(lb lbVar, dc dcVar) {
                this.f24718a.a(jVar, zVar, lbVar, dcVar);
            }
        });
        this.f17804c.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.f17802a.d());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter((ListAdapter) this.f17804c);
        listView.setDividerHeight(0);
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ec ecVar = this.f17804c;
        if (ecVar != null) {
            ecVar.a((ec.a) null);
        }
    }
}
