package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f1089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1090b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1092d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LayoutInflater f1093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1094g;

    public e(f fVar, LayoutInflater layoutInflater, boolean z11, int i11) {
        this.f1092d = z11;
        this.f1093f = layoutInflater;
        this.f1089a = fVar;
        this.f1094g = i11;
        a();
    }

    public void a() {
        h hVarX = this.f1089a.x();
        if (hVarX != null) {
            ArrayList<h> arrayListB = this.f1089a.B();
            int size = arrayListB.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (arrayListB.get(i11) == hVarX) {
                    this.f1090b = i11;
                    return;
                }
            }
        }
        this.f1090b = -1;
    }

    public f b() {
        return this.f1089a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public h getItem(int i11) {
        ArrayList<h> arrayListB = this.f1092d ? this.f1089a.B() : this.f1089a.G();
        int i12 = this.f1090b;
        if (i12 >= 0 && i11 >= i12) {
            i11++;
        }
        return arrayListB.get(i11);
    }

    public void d(boolean z11) {
        this.f1091c = z11;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<h> arrayListB = this.f1092d ? this.f1089a.B() : this.f1089a.G();
        return this.f1090b < 0 ? arrayListB.size() : arrayListB.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i11) {
        return i11;
    }

    @Override // android.widget.Adapter
    public View getView(int i11, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1093f.inflate(this.f1094g, viewGroup, false);
        }
        int groupId = getItem(i11).getGroupId();
        int i12 = i11 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1089a.I() && groupId != (i12 >= 0 ? getItem(i12).getGroupId() : groupId));
        m.a aVar = (m.a) view;
        if (this.f1091c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i11), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
