package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerAdUnitWaterfallsListActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f18066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ec f18067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f18068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18069d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ListView f18070f;

    /* JADX INFO: compiled from: source.java */
    public class a extends ec {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f18071f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, List list) {
            super(context);
            this.f18071f = list;
        }

        @Override // com.applovin.impl.ec
        public int b() {
            return 1;
        }

        @Override // com.applovin.impl.ec
        public List c(int i11) {
            return c0.this.f18068c;
        }

        @Override // com.applovin.impl.ec
        public int d(int i11) {
            return this.f18071f.size();
        }

        @Override // com.applovin.impl.ec
        public dc e(int i11) {
            return new fj("");
        }
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ID\t\t\t\t\t\t", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(zVar.c(), ViewCompat.MEASURED_STATE_MASK));
            spannableStringBuilder.append((CharSequence) new SpannedString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("FORMAT  ", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(zVar.b(), ViewCompat.MEASURED_STATE_MASK));
            arrayList.add(dc.a(dc.c.DETAIL).b(StringUtils.createSpannedString(zVar.d(), ViewCompat.MEASURED_STATE_MASK, 18, 1)).a(new SpannedString(spannableStringBuilder)).a(this).a(true).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, final com.applovin.impl.sdk.j jVar, lb lbVar, dc dcVar) {
        final z zVar = (z) list.get(lbVar.a());
        if (zVar.g().size() == 1) {
            r.a(this, MaxDebuggerAdUnitDetailActivity.class, jVar.e(), new r.b() { // from class: com.applovin.impl.qt
                @Override // com.applovin.impl.r.b
                public final void a(Activity activity) {
                    ((MaxDebuggerAdUnitDetailActivity) activity).initialize(zVar, null, null, jVar);
                }
            });
        } else {
            r.a(this, MaxDebuggerAdUnitWaterfallsListActivity.class, jVar.e(), new r.b() { // from class: com.applovin.impl.rt
                @Override // com.applovin.impl.r.b
                public final void a(Activity activity) {
                    ((MaxDebuggerAdUnitWaterfallsListActivity) activity).initialize(zVar, jVar);
                }
            });
        }
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        return this.f18066a;
    }

    public void initialize(final List<z> list, boolean z11, final com.applovin.impl.sdk.j jVar) {
        this.f18069d = z11;
        this.f18066a = jVar;
        this.f18068c = a(list);
        a aVar = new a(this, list);
        this.f18067b = aVar;
        aVar.a(new ec.a() { // from class: com.applovin.impl.pt
            @Override // com.applovin.impl.ec.a
            public final void a(lb lbVar, dc dcVar) {
                this.f21849a.a(list, jVar, lbVar, dcVar);
            }
        });
        this.f18067b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f18069d ? "Selective Init " : "");
        sb2.append("Ad Units");
        setTitle(sb2.toString());
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f18070f = listView;
        listView.setAdapter((ListAdapter) this.f18067b);
    }
}
