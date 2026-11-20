package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements l, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f1078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f1079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f1080d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l.a f1084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f1085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1086k;

    /* JADX INFO: compiled from: source.java */
    public class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1087a = -1;

        public a() {
            a();
        }

        public void a() {
            h hVarX = d.this.f1079c.x();
            if (hVarX != null) {
                ArrayList<h> arrayListB = d.this.f1079c.B();
                int size = arrayListB.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (arrayListB.get(i11) == hVarX) {
                        this.f1087a = i11;
                        return;
                    }
                }
            }
            this.f1087a = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h getItem(int i11) {
            ArrayList<h> arrayListB = d.this.f1079c.B();
            int i12 = i11 + d.this.f1081f;
            int i13 = this.f1087a;
            if (i13 >= 0 && i12 >= i13) {
                i12++;
            }
            return arrayListB.get(i12);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = d.this.f1079c.B().size() - d.this.f1081f;
            return this.f1087a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // android.widget.Adapter
        public View getView(int i11, View view, ViewGroup viewGroup) {
            if (view == null) {
                d dVar = d.this;
                view = dVar.f1078b.inflate(dVar.f1083h, viewGroup, false);
            }
            ((m.a) view).initialize(getItem(i11), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public d(int i11, int i12) {
        this.f1083h = i11;
        this.f1082g = i12;
    }

    public d(Context context, int i11) {
        this(i11, 0);
        this.f1077a = context;
        this.f1078b = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f1085j == null) {
            this.f1085j = new a();
        }
        return this.f1085j;
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(f fVar, boolean z11) {
        l.a aVar = this.f1084i;
        if (aVar != null) {
            aVar.b(fVar, z11);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean c(f fVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(l.a aVar) {
        this.f1084i = aVar;
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(Parcelable parcelable) {
        m((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean f(q qVar) {
        if (!qVar.hasVisibleItems()) {
            return false;
        }
        new g(qVar).d(null);
        l.a aVar = this.f1084i;
        if (aVar == null) {
            return true;
        }
        aVar.c(qVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        if (this.f1080d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        n(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f1086k;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z11) {
        a aVar = this.f1085j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(f fVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(Context context, f fVar) {
        if (this.f1082g != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f1082g);
            this.f1077a = contextThemeWrapper;
            this.f1078b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f1077a != null) {
            this.f1077a = context;
            if (this.f1078b == null) {
                this.f1078b = LayoutInflater.from(context);
            }
        }
        this.f1079c = fVar;
        a aVar = this.f1085j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public m l(ViewGroup viewGroup) {
        if (this.f1080d == null) {
            this.f1080d = (ExpandedMenuView) this.f1078b.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1085j == null) {
                this.f1085j = new a();
            }
            this.f1080d.setAdapter((ListAdapter) this.f1085j);
            this.f1080d.setOnItemClickListener(this);
        }
        return this.f1080d;
    }

    public void m(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1080d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void n(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f1080d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
        this.f1079c.P(this.f1085j.getItem(i11), this, 0);
    }
}
