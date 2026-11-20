package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class jr extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f20025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.applovin.impl.sdk.j f20026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ec f20027c;

    /* JADX INFO: compiled from: source.java */
    public class a extends ec {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f20028f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, List list) {
            super(context);
            this.f20028f = list;
        }

        @Override // com.applovin.impl.ec
        public dc a() {
            return new dc.b(dc.c.SECTION_CENTERED).d("A plus in front of each segment indicates inclusion and a minus indicates exclusion. The comma in comma-separated values functions as an ∨ (or) operator, and a new row functions as an ∧ (and) operator.").a();
        }

        @Override // com.applovin.impl.ec
        public int b() {
            return 1;
        }

        @Override // com.applovin.impl.ec
        public List c(int i11) {
            return this.f20028f;
        }

        @Override // com.applovin.impl.ec
        public int d(int i11) {
            return this.f20028f.size();
        }

        @Override // com.applovin.impl.ec
        public dc e(int i11) {
            return new fj("SEGMENT TARGETING");
        }
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(dc.a(dc.c.DETAIL).d((String) it.next()).a());
        }
        return arrayList;
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        return this.f20026b;
    }

    public void initialize(String str, List<String> list, com.applovin.impl.sdk.j jVar) {
        this.f20025a = str;
        this.f20026b = jVar;
        a aVar = new a(this, a(list));
        this.f20027c = aVar;
        aVar.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.f20025a);
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f20027c);
    }
}
