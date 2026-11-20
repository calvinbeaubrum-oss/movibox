package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class y extends ec {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final z f24427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a0 f24428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ir f24429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f24430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f24431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f24432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f24433l;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        INFO,
        BIDDERS,
        WATERFALL,
        COUNT
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends cg {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final ir f24439p;

        public b(ir irVar, String str, boolean z11) {
            super(irVar.b().d(), y.this.f18683a);
            this.f24439p = irVar;
            this.f18405c = StringUtils.createSpannedString(irVar.b().a(), ViewCompat.MEASURED_STATE_MASK, 18, 1);
            this.f18406d = !TextUtils.isEmpty(str) ? new SpannedString(str) : null;
            this.f18404b = z11;
        }

        @Override // com.applovin.impl.dc
        public int g() {
            return -12303292;
        }

        @Override // com.applovin.impl.cg, com.applovin.impl.dc
        public boolean o() {
            return this.f18404b;
        }

        public ir v() {
            return this.f24439p;
        }
    }

    public y(z zVar, a0 a0Var, ir irVar, Context context) {
        super(context);
        this.f24427f = zVar;
        this.f24429h = irVar;
        this.f24428g = a0Var != null ? a0Var : zVar.f();
        this.f24430i = a0Var != null ? a0Var.c() : zVar.d();
        this.f24431j = h();
        this.f24432k = e();
        this.f24433l = l();
        notifyDataSetChanged();
    }

    private dc d() {
        return dc.a().d("Ad Format").c(this.f24427f.b()).a();
    }

    private List e() {
        ir irVar = this.f24429h;
        if (irVar != null && !irVar.d()) {
            return new ArrayList();
        }
        List<ir> listA = this.f24428g.a();
        ArrayList arrayList = new ArrayList(listA.size());
        for (ir irVar2 : listA) {
            ir irVar3 = this.f24429h;
            if (irVar3 == null || irVar3.b().c().equals(irVar2.b().c())) {
                arrayList.add(new b(irVar2, irVar2.a() != null ? irVar2.a().a() : "", this.f24429h == null));
            }
        }
        return arrayList;
    }

    private dc f() {
        return dc.a().d("AB Test Experiment Name").c(j().b()).a();
    }

    private dc g() {
        return dc.a().d("ID").c(this.f24427f.c()).a();
    }

    private List h() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(g());
        arrayList.add(d());
        if (this.f24428g.b() != null) {
            arrayList.add(f());
        }
        if (this.f24429h != null) {
            arrayList.add(i());
        }
        return arrayList;
    }

    private dc i() {
        return dc.a().d("Selected Network").c(this.f24429h.b().a()).a();
    }

    private List l() {
        ir irVar = this.f24429h;
        if (irVar != null && irVar.d()) {
            return new ArrayList();
        }
        List<ir> listE = this.f24428g.e();
        ArrayList arrayList = new ArrayList(listE.size());
        for (ir irVar2 : listE) {
            ir irVar3 = this.f24429h;
            if (irVar3 == null || irVar3.b().c().equals(irVar2.b().c())) {
                arrayList.add(new b(irVar2, null, this.f24429h == null));
                for (dg dgVar : irVar2.c()) {
                    arrayList.add(dc.a().d(dgVar.a()).c(dgVar.b()).b(true).a());
                }
            }
        }
        return arrayList;
    }

    @Override // com.applovin.impl.ec
    public int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.ec
    public List c(int i11) {
        if (i11 == a.INFO.ordinal()) {
            return this.f24431j;
        }
        return i11 == a.BIDDERS.ordinal() ? this.f24432k : this.f24433l;
    }

    @Override // com.applovin.impl.ec
    public int d(int i11) {
        if (i11 == a.INFO.ordinal()) {
            return this.f24431j.size();
        }
        return i11 == a.BIDDERS.ordinal() ? this.f24432k.size() : this.f24433l.size();
    }

    @Override // com.applovin.impl.ec
    public dc e(int i11) {
        if (i11 == a.INFO.ordinal()) {
            return new fj("INFO");
        }
        return i11 == a.BIDDERS.ordinal() ? new fj("BIDDERS") : new fj("WATERFALL");
    }

    public a0 j() {
        return this.f24428g;
    }

    public String k() {
        return this.f24430i;
    }
}
