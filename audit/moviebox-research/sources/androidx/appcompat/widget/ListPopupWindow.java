package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import com.google.android.gms.common.api.Api;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ListPopupWindow implements androidx.appcompat.view.menu.o {
    public static Method H;
    public static Method I;
    public static Method J;
    public final ListSelectorHider A;
    public Runnable B;
    public final Handler C;
    public final Rect D;
    public Rect E;
    public boolean F;
    public PopupWindow G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f1450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DropDownListView f1451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1452d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f1464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1465r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DataSetObserver f1466s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f1467t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Drawable f1468u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AdapterView.OnItemClickListener f1469v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f1470w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ResizePopupRunnable f1471x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f f1472y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final e f1473z;

    /* JADX INFO: compiled from: source.java */
    public class ListSelectorHider implements Runnable {
        public ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.q();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class ResizePopupRunnable implements Runnable {
        public ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f1451c;
            if (dropDownListView == null || !dropDownListView.isAttachedToWindow() || ListPopupWindow.this.f1451c.getCount() <= ListPopupWindow.this.f1451c.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.f1451c.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.f1463p) {
                listPopupWindow.G.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
            DropDownListView dropDownListView;
            if (i11 == -1 || (dropDownListView = ListPopupWindow.this.f1451c) == null) {
                return;
            }
            dropDownListView.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class b {
        public static int a(PopupWindow popupWindow, View view, int i11, boolean z11) {
            return popupWindow.getMaxAvailableHeight(view, i11, z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class c {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z11) {
            popupWindow.setIsClippedToScreen(z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.a()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i11) {
            if (i11 != 1 || ListPopupWindow.this.z() || ListPopupWindow.this.G.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.C.removeCallbacks(listPopupWindow.f1471x);
            ListPopupWindow.this.f1471x.run();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x11 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.G) != null && popupWindow.isShowing() && x11 >= 0 && x11 < ListPopupWindow.this.G.getWidth() && y11 >= 0 && y11 < ListPopupWindow.this.G.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.C.postDelayed(listPopupWindow.f1471x, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
            listPopupWindow2.C.removeCallbacks(listPopupWindow2.f1471x);
            return false;
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                H = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                J = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                I = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, null, R$attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        this.f1452d = -2;
        this.f1453f = -2;
        this.f1456i = 1002;
        this.f1460m = 0;
        this.f1461n = false;
        this.f1462o = false;
        this.f1463p = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f1465r = 0;
        this.f1471x = new ResizePopupRunnable();
        this.f1472y = new f();
        this.f1473z = new e();
        this.A = new ListSelectorHider();
        this.D = new Rect();
        this.f1449a = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i11, i12);
        this.f1454g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1455h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1457j = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        k kVar = new k(context, attributeSet, i11, i12);
        this.G = kVar;
        kVar.setInputMethodMode(1);
    }

    public boolean A() {
        return this.F;
    }

    public final void B() {
        View view = this.f1464q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1464q);
            }
        }
    }

    public void C(@Nullable View view) {
        this.f1467t = view;
    }

    public void D(int i11) {
        this.G.setAnimationStyle(i11);
    }

    public void E(int i11) {
        Drawable background = this.G.getBackground();
        if (background == null) {
            Q(i11);
            return;
        }
        background.getPadding(this.D);
        Rect rect = this.D;
        this.f1453f = rect.left + rect.right + i11;
    }

    public void F(int i11) {
        this.f1460m = i11;
    }

    public void G(@Nullable Rect rect) {
        this.E = rect != null ? new Rect(rect) : null;
    }

    public void H(int i11) {
        this.G.setInputMethodMode(i11);
    }

    public void I(boolean z11) {
        this.F = z11;
        this.G.setFocusable(z11);
    }

    public void J(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.G.setOnDismissListener(onDismissListener);
    }

    public void K(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.f1469v = onItemClickListener;
    }

    public void L(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f1470w = onItemSelectedListener;
    }

    public void M(boolean z11) {
        this.f1459l = true;
        this.f1458k = z11;
    }

    public final void N(boolean z11) {
        if (Build.VERSION.SDK_INT > 28) {
            c.b(this.G, z11);
            return;
        }
        Method method = H;
        if (method != null) {
            try {
                method.invoke(this.G, Boolean.valueOf(z11));
            } catch (Exception unused) {
            }
        }
    }

    public void O(int i11) {
        this.f1465r = i11;
    }

    public void P(int i11) {
        DropDownListView dropDownListView = this.f1451c;
        if (!a() || dropDownListView == null) {
            return;
        }
        dropDownListView.setListSelectionHidden(false);
        dropDownListView.setSelection(i11);
        if (dropDownListView.getChoiceMode() != 0) {
            dropDownListView.setItemChecked(i11, true);
        }
    }

    public void Q(int i11) {
        this.f1453f = i11;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean a() {
        return this.G.isShowing();
    }

    public void b(@Nullable Drawable drawable) {
        this.G.setBackgroundDrawable(drawable);
    }

    public int c() {
        return this.f1454g;
    }

    @Override // androidx.appcompat.view.menu.o
    public void dismiss() {
        this.G.dismiss();
        B();
        this.G.setContentView(null);
        this.f1451c = null;
        this.C.removeCallbacks(this.f1471x);
    }

    public void e(int i11) {
        this.f1454g = i11;
    }

    @Nullable
    public Drawable g() {
        return this.G.getBackground();
    }

    public void i(int i11) {
        this.f1455h = i11;
        this.f1457j = true;
    }

    public int l() {
        if (this.f1457j) {
            return this.f1455h;
        }
        return 0;
    }

    public void m(@Nullable ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1466s;
        if (dataSetObserver == null) {
            this.f1466s = new d();
        } else {
            ListAdapter listAdapter2 = this.f1450b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1450b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1466s);
        }
        DropDownListView dropDownListView = this.f1451c;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f1450b);
        }
    }

    @Override // androidx.appcompat.view.menu.o
    @Nullable
    public ListView o() {
        return this.f1451c;
    }

    public final int p() {
        int measuredHeight;
        int i11;
        int iMakeMeasureSpec;
        View view;
        int i12;
        if (this.f1451c == null) {
            Context context = this.f1449a;
            this.B = new Runnable() { // from class: androidx.appcompat.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View viewS = ListPopupWindow.this.s();
                    if (viewS == null || viewS.getWindowToken() == null) {
                        return;
                    }
                    ListPopupWindow.this.show();
                }
            };
            DropDownListView dropDownListViewR = r(context, !this.F);
            this.f1451c = dropDownListViewR;
            Drawable drawable = this.f1468u;
            if (drawable != null) {
                dropDownListViewR.setSelector(drawable);
            }
            this.f1451c.setAdapter(this.f1450b);
            this.f1451c.setOnItemClickListener(this.f1469v);
            this.f1451c.setFocusable(true);
            this.f1451c.setFocusableInTouchMode(true);
            this.f1451c.setOnItemSelectedListener(new a());
            this.f1451c.setOnScrollListener(this.f1473z);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1470w;
            if (onItemSelectedListener != null) {
                this.f1451c.setOnItemSelectedListener(onItemSelectedListener);
            }
            DropDownListView dropDownListView = this.f1451c;
            View view2 = this.f1464q;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i13 = this.f1465r;
                if (i13 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(dropDownListView, layoutParams);
                } else if (i13 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f1465r);
                } else {
                    linearLayout.addView(dropDownListView, layoutParams);
                    linearLayout.addView(view2);
                }
                int i14 = this.f1453f;
                if (i14 >= 0) {
                    i12 = Integer.MIN_VALUE;
                } else {
                    i14 = 0;
                    i12 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i14, i12), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = dropDownListView;
            }
            this.G.setContentView(view);
        } else {
            View view3 = this.f1464q;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.G.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            Rect rect = this.D;
            int i15 = rect.top;
            i11 = rect.bottom + i15;
            if (!this.f1457j) {
                this.f1455h = -i15;
            }
        } else {
            this.D.setEmpty();
            i11 = 0;
        }
        int iT = t(s(), this.f1455h, this.G.getInputMethodMode() == 2);
        if (this.f1461n || this.f1452d == -1) {
            return iT + i11;
        }
        int i16 = this.f1453f;
        if (i16 == -2) {
            int i17 = this.f1449a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.D;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i16 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
        } else {
            int i18 = this.f1449a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.D;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - (rect3.left + rect3.right), 1073741824);
        }
        int iMeasureHeightOfChildrenCompat = this.f1451c.measureHeightOfChildrenCompat(iMakeMeasureSpec, 0, -1, iT - measuredHeight, -1);
        if (iMeasureHeightOfChildrenCompat > 0) {
            measuredHeight += i11 + this.f1451c.getPaddingTop() + this.f1451c.getPaddingBottom();
        }
        return iMeasureHeightOfChildrenCompat + measuredHeight;
    }

    public void q() {
        DropDownListView dropDownListView = this.f1451c;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    @NonNull
    public DropDownListView r(Context context, boolean z11) {
        return new DropDownListView(context, z11);
    }

    @Nullable
    public View s() {
        return this.f1467t;
    }

    @Override // androidx.appcompat.view.menu.o
    public void show() {
        int iP = p();
        boolean z11 = z();
        androidx.core.widget.k.b(this.G, this.f1456i);
        if (this.G.isShowing()) {
            if (s().isAttachedToWindow()) {
                int width = this.f1453f;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = s().getWidth();
                }
                int i11 = this.f1452d;
                if (i11 == -1) {
                    if (!z11) {
                        iP = -1;
                    }
                    if (z11) {
                        this.G.setWidth(this.f1453f == -1 ? -1 : 0);
                        this.G.setHeight(0);
                    } else {
                        this.G.setWidth(this.f1453f == -1 ? -1 : 0);
                        this.G.setHeight(-1);
                    }
                } else if (i11 != -2) {
                    iP = i11;
                }
                this.G.setOutsideTouchable((this.f1462o || this.f1461n) ? false : true);
                this.G.update(s(), this.f1454g, this.f1455h, width < 0 ? -1 : width, iP < 0 ? -1 : iP);
                return;
            }
            return;
        }
        int width2 = this.f1453f;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = s().getWidth();
        }
        int i12 = this.f1452d;
        if (i12 == -1) {
            iP = -1;
        } else if (i12 != -2) {
            iP = i12;
        }
        this.G.setWidth(width2);
        this.G.setHeight(iP);
        N(true);
        this.G.setOutsideTouchable((this.f1462o || this.f1461n) ? false : true);
        this.G.setTouchInterceptor(this.f1472y);
        if (this.f1459l) {
            androidx.core.widget.k.a(this.G, this.f1458k);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = J;
            if (method != null) {
                try {
                    method.invoke(this.G, this.E);
                } catch (Exception e11) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e11);
                }
            }
        } else {
            c.a(this.G, this.E);
        }
        androidx.core.widget.k.c(this.G, s(), this.f1454g, this.f1455h, this.f1460m);
        this.f1451c.setSelection(-1);
        if (!this.F || this.f1451c.isInTouchMode()) {
            q();
        }
        if (this.F) {
            return;
        }
        this.C.post(this.A);
    }

    public final int t(View view, int i11, boolean z11) {
        if (Build.VERSION.SDK_INT > 23) {
            return b.a(this.G, view, i11, z11);
        }
        Method method = I;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.G, view, Integer.valueOf(i11), Boolean.valueOf(z11))).intValue();
            } catch (Exception unused) {
            }
        }
        return this.G.getMaxAvailableHeight(view, i11);
    }

    @Nullable
    public Object u() {
        if (a()) {
            return this.f1451c.getSelectedItem();
        }
        return null;
    }

    public long v() {
        if (a()) {
            return this.f1451c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int w() {
        if (a()) {
            return this.f1451c.getSelectedItemPosition();
        }
        return -1;
    }

    @Nullable
    public View x() {
        if (a()) {
            return this.f1451c.getSelectedView();
        }
        return null;
    }

    public int y() {
        return this.f1453f;
    }

    public boolean z() {
        return this.G.getInputMethodMode() == 2;
    }
}
