package androidx.media3.ui;

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
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class TrackSelectionView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f11989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CheckedTextView f11990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckedTextView f11991d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f11992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<androidx.media3.common.q0.a> f11993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<androidx.media3.common.n0, androidx.media3.common.o0> f11994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p0 f11997k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CheckedTextView[][] f11998l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11999m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public Comparator<c> f12000n;

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
        public final androidx.media3.common.q0.a f12002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12003b;

        public c(androidx.media3.common.q0.a aVar, int i11) {
            this.f12002a = aVar;
            this.f12003b = i11;
        }

        public androidx.media3.common.y a() {
            return this.f12002a.b(this.f12003b);
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
        this.f11988a = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f11989b = layoutInflaterFrom;
        b bVar = new b();
        this.f11992f = bVar;
        this.f11997k = new g(getResources());
        this.f11993g = new ArrayList();
        this.f11994h = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f11990c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R$string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(layoutInflaterFrom.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f11991d = checkedTextView2;
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

    public static Map<androidx.media3.common.n0, androidx.media3.common.o0> filterOverrides(Map<androidx.media3.common.n0, androidx.media3.common.o0> map, List<androidx.media3.common.q0.a> list, boolean z11) {
        HashMap map2 = new HashMap();
        for (int i11 = 0; i11 < list.size(); i11++) {
            androidx.media3.common.o0 o0Var = map.get(list.get(i11).a());
            if (o0Var != null && (z11 || map2.isEmpty())) {
                map2.put(o0Var.f9352a, o0Var);
            }
        }
        return map2;
    }

    public final void d(View view) {
        if (view == this.f11990c) {
            f();
        } else if (view == this.f11991d) {
            e();
        } else {
            g(view);
        }
        j();
    }

    public final void e() {
        this.f11999m = false;
        this.f11994h.clear();
    }

    public final void f() {
        this.f11999m = true;
        this.f11994h.clear();
    }

    public final void g(View view) {
        this.f11999m = false;
        c cVar = (c) z3.a.e(view.getTag());
        androidx.media3.common.n0 n0VarA = cVar.f12002a.a();
        int i11 = cVar.f12003b;
        androidx.media3.common.o0 o0Var = this.f11994h.get(n0VarA);
        if (o0Var == null) {
            if (!this.f11996j && this.f11994h.size() > 0) {
                this.f11994h.clear();
            }
            this.f11994h.put(n0VarA, new androidx.media3.common.o0(n0VarA, ImmutableList.of(Integer.valueOf(i11))));
            return;
        }
        ArrayList arrayList = new ArrayList(o0Var.f9353b);
        boolean zIsChecked = ((CheckedTextView) view).isChecked();
        boolean zH = h(cVar.f12002a);
        boolean z11 = zH || i();
        if (zIsChecked && z11) {
            arrayList.remove(Integer.valueOf(i11));
            if (arrayList.isEmpty()) {
                this.f11994h.remove(n0VarA);
                return;
            } else {
                this.f11994h.put(n0VarA, new androidx.media3.common.o0(n0VarA, arrayList));
                return;
            }
        }
        if (zIsChecked) {
            return;
        }
        if (!zH) {
            this.f11994h.put(n0VarA, new androidx.media3.common.o0(n0VarA, ImmutableList.of(Integer.valueOf(i11))));
        } else {
            arrayList.add(Integer.valueOf(i11));
            this.f11994h.put(n0VarA, new androidx.media3.common.o0(n0VarA, arrayList));
        }
    }

    public boolean getIsDisabled() {
        return this.f11999m;
    }

    public Map<androidx.media3.common.n0, androidx.media3.common.o0> getOverrides() {
        return this.f11994h;
    }

    public final boolean h(androidx.media3.common.q0.a aVar) {
        return this.f11995i && aVar.e();
    }

    public final boolean i() {
        return this.f11996j && this.f11993g.size() > 1;
    }

    public void init(List<androidx.media3.common.q0.a> list, boolean z11, Map<androidx.media3.common.n0, androidx.media3.common.o0> map, @Nullable final Comparator<androidx.media3.common.y> comparator, @Nullable d dVar) {
        this.f11999m = z11;
        this.f12000n = comparator == null ? null : new Comparator() { // from class: androidx.media3.ui.q0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return TrackSelectionView.c(comparator, (TrackSelectionView.c) obj, (TrackSelectionView.c) obj2);
            }
        };
        this.f11993g.clear();
        this.f11993g.addAll(list);
        this.f11994h.clear();
        this.f11994h.putAll(filterOverrides(map, list, this.f11996j));
        k();
    }

    public final void j() {
        this.f11990c.setChecked(this.f11999m);
        this.f11991d.setChecked(!this.f11999m && this.f11994h.size() == 0);
        for (int i11 = 0; i11 < this.f11998l.length; i11++) {
            androidx.media3.common.o0 o0Var = this.f11994h.get(this.f11993g.get(i11).a());
            int i12 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f11998l[i11];
                if (i12 < checkedTextViewArr.length) {
                    if (o0Var != null) {
                        this.f11998l[i11][i12].setChecked(o0Var.f9353b.contains(Integer.valueOf(((c) z3.a.e(checkedTextViewArr[i12].getTag())).f12003b)));
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
        if (this.f11993g.isEmpty()) {
            this.f11990c.setEnabled(false);
            this.f11991d.setEnabled(false);
            return;
        }
        this.f11990c.setEnabled(true);
        this.f11991d.setEnabled(true);
        this.f11998l = new CheckedTextView[this.f11993g.size()][];
        boolean zI = i();
        for (int i11 = 0; i11 < this.f11993g.size(); i11++) {
            androidx.media3.common.q0.a aVar = this.f11993g.get(i11);
            boolean zH = h(aVar);
            CheckedTextView[][] checkedTextViewArr = this.f11998l;
            int i12 = aVar.f9435a;
            checkedTextViewArr[i11] = new CheckedTextView[i12];
            c[] cVarArr = new c[i12];
            for (int i13 = 0; i13 < aVar.f9435a; i13++) {
                cVarArr[i13] = new c(aVar, i13);
            }
            Comparator<c> comparator = this.f12000n;
            if (comparator != null) {
                Arrays.sort(cVarArr, comparator);
            }
            for (int i14 = 0; i14 < i12; i14++) {
                if (i14 == 0) {
                    addView(this.f11989b.inflate(R$layout.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f11989b.inflate((zH || zI) ? R.layout.simple_list_item_multiple_choice : R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView.setBackgroundResource(this.f11988a);
                checkedTextView.setText(this.f11997k.a(cVarArr[i14].a()));
                checkedTextView.setTag(cVarArr[i14]);
                if (aVar.i(i14)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.f11992f);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f11998l[i11][i14] = checkedTextView;
                addView(checkedTextView);
            }
        }
        j();
    }

    public void setAllowAdaptiveSelections(boolean z11) {
        if (this.f11995i != z11) {
            this.f11995i = z11;
            k();
        }
    }

    public void setAllowMultipleOverrides(boolean z11) {
        if (this.f11996j != z11) {
            this.f11996j = z11;
            if (!z11 && this.f11994h.size() > 1) {
                Map<androidx.media3.common.n0, androidx.media3.common.o0> mapFilterOverrides = filterOverrides(this.f11994h, this.f11993g, false);
                this.f11994h.clear();
                this.f11994h.putAll(mapFilterOverrides);
            }
            k();
        }
    }

    public void setShowDisableOption(boolean z11) {
        this.f11990c.setVisibility(z11 ? 0 : 8);
    }

    public void setTrackNameProvider(p0 p0Var) {
        this.f11997k = (p0) z3.a.e(p0Var);
        k();
    }
}
