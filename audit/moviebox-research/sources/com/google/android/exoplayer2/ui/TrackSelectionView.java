package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.o3;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TrackSelectionView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f35068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CheckedTextView f35069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckedTextView f35070d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f35071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<o3.a> f35072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<nh.i0, fi.x> f35073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f35074i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f35075j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public o0 f35076k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CheckedTextView[][] f35077l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f35078m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public Comparator<c> f35079n;

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView.this.d(view);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o3.a f35081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35082b;

        public c(o3.a aVar, int i11) {
            this.f35081a = aVar;
            this.f35082b = i11;
        }

        public m1 a() {
            return this.f35081a.c(this.f35082b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
    }

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.f35067a = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f35068b = layoutInflaterFrom;
        b bVar = new b();
        this.f35071f = bVar;
        this.f35076k = new g(getResources());
        this.f35072g = new ArrayList();
        this.f35073h = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f35069c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R$string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(layoutInflaterFrom.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f35070d = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R$string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }

    public static /* synthetic */ int c(Comparator comparator, c cVar, c cVar2) {
        return comparator.compare(cVar.a(), cVar2.a());
    }

    public static Map<nh.i0, fi.x> filterOverrides(Map<nh.i0, fi.x> map, List<o3.a> list, boolean z11) {
        HashMap map2 = new HashMap();
        for (int i11 = 0; i11 < list.size(); i11++) {
            fi.x xVar = map.get(list.get(i11).b());
            if (xVar != null && (z11 || map2.isEmpty())) {
                map2.put(xVar.f65055a, xVar);
            }
        }
        return map2;
    }

    public final void d(View view) {
        if (view == this.f35069c) {
            f();
        } else if (view == this.f35070d) {
            e();
        } else {
            g(view);
        }
        j();
    }

    public final void e() {
        this.f35078m = false;
        this.f35073h.clear();
    }

    public final void f() {
        this.f35078m = true;
        this.f35073h.clear();
    }

    public final void g(View view) {
        this.f35078m = false;
        c cVar = (c) com.google.android.exoplayer2.util.a.e(view.getTag());
        nh.i0 i0VarB = cVar.f35081a.b();
        int i11 = cVar.f35082b;
        fi.x xVar = this.f35073h.get(i0VarB);
        if (xVar == null) {
            if (!this.f35075j && this.f35073h.size() > 0) {
                this.f35073h.clear();
            }
            this.f35073h.put(i0VarB, new fi.x(i0VarB, ImmutableList.of(Integer.valueOf(i11))));
            return;
        }
        ArrayList arrayList = new ArrayList(xVar.f65056b);
        boolean zIsChecked = ((CheckedTextView) view).isChecked();
        boolean zH = h(cVar.f35081a);
        boolean z11 = zH || i();
        if (zIsChecked && z11) {
            arrayList.remove(Integer.valueOf(i11));
            if (arrayList.isEmpty()) {
                this.f35073h.remove(i0VarB);
                return;
            } else {
                this.f35073h.put(i0VarB, new fi.x(i0VarB, arrayList));
                return;
            }
        }
        if (zIsChecked) {
            return;
        }
        if (!zH) {
            this.f35073h.put(i0VarB, new fi.x(i0VarB, ImmutableList.of(Integer.valueOf(i11))));
        } else {
            arrayList.add(Integer.valueOf(i11));
            this.f35073h.put(i0VarB, new fi.x(i0VarB, arrayList));
        }
    }

    public boolean getIsDisabled() {
        return this.f35078m;
    }

    public Map<nh.i0, fi.x> getOverrides() {
        return this.f35073h;
    }

    public final boolean h(o3.a aVar) {
        return this.f35074i && aVar.e();
    }

    public final boolean i() {
        return this.f35075j && this.f35072g.size() > 1;
    }

    public void init(List<o3.a> list, boolean z11, Map<nh.i0, fi.x> map, @Nullable final Comparator<m1> comparator, @Nullable d dVar) {
        this.f35078m = z11;
        this.f35079n = comparator == null ? null : new Comparator() { // from class: com.google.android.exoplayer2.ui.p0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return TrackSelectionView.c(comparator, (TrackSelectionView.c) obj, (TrackSelectionView.c) obj2);
            }
        };
        this.f35072g.clear();
        this.f35072g.addAll(list);
        this.f35073h.clear();
        this.f35073h.putAll(filterOverrides(map, list, this.f35075j));
        k();
    }

    public final void j() {
        this.f35069c.setChecked(this.f35078m);
        this.f35070d.setChecked(!this.f35078m && this.f35073h.size() == 0);
        for (int i11 = 0; i11 < this.f35077l.length; i11++) {
            fi.x xVar = this.f35073h.get(this.f35072g.get(i11).b());
            int i12 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f35077l[i11];
                if (i12 < checkedTextViewArr.length) {
                    if (xVar != null) {
                        this.f35077l[i11][i12].setChecked(xVar.f65056b.contains(Integer.valueOf(((c) com.google.android.exoplayer2.util.a.e(checkedTextViewArr[i12].getTag())).f35082b)));
                    } else {
                        checkedTextViewArr[i12].setChecked(false);
                    }
                    i12++;
                }
            }
        }
    }

    public final void k() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f35072g.isEmpty()) {
            this.f35069c.setEnabled(false);
            this.f35070d.setEnabled(false);
            return;
        }
        this.f35069c.setEnabled(true);
        this.f35070d.setEnabled(true);
        this.f35077l = new CheckedTextView[this.f35072g.size()][];
        boolean zI = i();
        for (int i11 = 0; i11 < this.f35072g.size(); i11++) {
            o3.a aVar = this.f35072g.get(i11);
            boolean zH = h(aVar);
            CheckedTextView[][] checkedTextViewArr = this.f35077l;
            int i12 = aVar.f33629a;
            checkedTextViewArr[i11] = new CheckedTextView[i12];
            c[] cVarArr = new c[i12];
            for (int i13 = 0; i13 < aVar.f33629a; i13++) {
                cVarArr[i13] = new c(aVar, i13);
            }
            Comparator<c> comparator = this.f35079n;
            if (comparator != null) {
                Arrays.sort(cVarArr, comparator);
            }
            for (int i14 = 0; i14 < i12; i14++) {
                if (i14 == 0) {
                    addView(this.f35068b.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f35068b.inflate((zH || zI) ? R.layout.simple_list_item_multiple_choice : R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView.setBackgroundResource(this.f35067a);
                checkedTextView.setText(this.f35076k.a(cVarArr[i14].a()));
                checkedTextView.setTag(cVarArr[i14]);
                if (aVar.h(i14)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.f35071f);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f35077l[i11][i14] = checkedTextView;
                addView(checkedTextView);
            }
        }
        j();
    }

    public void setAllowAdaptiveSelections(boolean z11) {
        if (this.f35074i != z11) {
            this.f35074i = z11;
            k();
        }
    }

    public void setAllowMultipleOverrides(boolean z11) {
        if (this.f35075j != z11) {
            this.f35075j = z11;
            if (!z11 && this.f35073h.size() > 1) {
                Map<nh.i0, fi.x> mapFilterOverrides = filterOverrides(this.f35073h, this.f35072g, false);
                this.f35073h.clear();
                this.f35073h.putAll(mapFilterOverrides);
            }
            k();
        }
    }

    public void setShowDisableOption(boolean z11) {
        this.f35069c.setVisibility(z11 ? 0 : 8);
    }

    public void setTrackNameProvider(o0 o0Var) {
        this.f35076k = (o0) com.google.android.exoplayer2.util.a.e(o0Var);
        k();
    }
}
