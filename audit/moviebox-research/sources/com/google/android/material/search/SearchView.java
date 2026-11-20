package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.b, ti.b {
    public static final int E = R$style.Widget_Material3_SearchView;
    public boolean A;
    public boolean B;

    @NonNull
    public TransitionState C;
    public Map<View, Integer> D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f37365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClippableRoundedCornerLayout f37366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f37367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f37368d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f37369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f37370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MaterialToolbar f37371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Toolbar f37372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f37373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final EditText f37374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageButton f37375l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f37376m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TouchObserverFrameLayout f37377n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f37378o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final g0 f37379p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final ti.c f37380q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f37381r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final pi.a f37382s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Set<b> f37383t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public SearchBar f37384u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f37385v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f37386w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f37387x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f37388y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f37389z;

    /* JADX INFO: compiled from: source.java */
    public static class Behavior extends CoordinatorLayout.c<SearchView> {
        public Behavior() {
        }

        public Behavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SearchView searchView, @NonNull View view) {
            if (searchView.isSetupWithSearchBar() || !(view instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view);
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f37390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f37391b;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f37390a = parcel.readString();
            this.f37391b = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f37390a);
            parcel.writeInt(this.f37391b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum TransitionState {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            SearchView.this.f37375l.setVisibility(charSequence.length() > 0 ? 0 : 8);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(@NonNull SearchView searchView, @NonNull TransitionState transitionState, @NonNull TransitionState transitionState2);
    }

    public SearchView(@NonNull Context context) {
        this(context, null);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialSearchViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12 = E;
        super(zi.a.c(context, attributeSet, i11, i12), attributeSet, i11);
        this.f37380q = new ti.c(this);
        this.f37383t = new LinkedHashSet();
        this.f37385v = 16;
        this.C = TransitionState.HIDDEN;
        Context context2 = getContext();
        TypedArray typedArrayI = com.google.android.material.internal.b0.i(context2, attributeSet, R$styleable.SearchView, i11, i12, new int[0]);
        this.f37389z = typedArrayI.getColor(R$styleable.SearchView_backgroundTint, 0);
        int resourceId = typedArrayI.getResourceId(R$styleable.SearchView_headerLayout, -1);
        int resourceId2 = typedArrayI.getResourceId(R$styleable.SearchView_android_textAppearance, -1);
        String string = typedArrayI.getString(R$styleable.SearchView_android_text);
        String string2 = typedArrayI.getString(R$styleable.SearchView_android_hint);
        String string3 = typedArrayI.getString(R$styleable.SearchView_searchPrefixText);
        boolean z11 = typedArrayI.getBoolean(R$styleable.SearchView_useDrawerArrowDrawable, false);
        this.f37386w = typedArrayI.getBoolean(R$styleable.SearchView_animateNavigationIcon, true);
        this.f37387x = typedArrayI.getBoolean(R$styleable.SearchView_animateMenuItems, true);
        boolean z12 = typedArrayI.getBoolean(R$styleable.SearchView_hideNavigationIcon, false);
        this.f37388y = typedArrayI.getBoolean(R$styleable.SearchView_autoShowKeyboard, true);
        this.f37381r = typedArrayI.getBoolean(R$styleable.SearchView_backHandlingEnabled, true);
        typedArrayI.recycle();
        LayoutInflater.from(context2).inflate(R$layout.mtrl_search_view, this);
        this.f37378o = true;
        this.f37365a = findViewById(R$id.open_search_view_scrim);
        this.f37366b = (ClippableRoundedCornerLayout) findViewById(R$id.open_search_view_root);
        this.f37367c = findViewById(R$id.open_search_view_background);
        this.f37368d = findViewById(R$id.open_search_view_status_bar_spacer);
        this.f37369f = (FrameLayout) findViewById(R$id.open_search_view_header_container);
        this.f37370g = (FrameLayout) findViewById(R$id.open_search_view_toolbar_container);
        this.f37371h = (MaterialToolbar) findViewById(R$id.open_search_view_toolbar);
        this.f37372i = (Toolbar) findViewById(R$id.open_search_view_dummy_toolbar);
        this.f37373j = (TextView) findViewById(R$id.open_search_view_search_prefix);
        this.f37374k = (EditText) findViewById(R$id.open_search_view_edit_text);
        this.f37375l = (ImageButton) findViewById(R$id.open_search_view_clear_button);
        this.f37376m = findViewById(R$id.open_search_view_divider);
        this.f37377n = (TouchObserverFrameLayout) findViewById(R$id.open_search_view_content_container);
        this.f37379p = new g0(this);
        this.f37382s = new pi.a(context2);
        G();
        A();
        setUpHeaderLayout(resourceId);
        setSearchPrefixText(string3);
        E(resourceId2, string, string2);
        z(z11, z12);
        B();
        C();
        F();
    }

    @Nullable
    private Window getActivityWindow() {
        Activity activityA = com.google.android.material.internal.c.a(getContext());
        if (activityA == null) {
            return null;
        }
        return activityA.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f37384u;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(R$dimen.m3_searchview_elevation);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static /* synthetic */ WindowInsetsCompat s(ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12, View view, WindowInsetsCompat windowInsetsCompat) {
        marginLayoutParams.leftMargin = i11 + windowInsetsCompat.getSystemWindowInsetLeft();
        marginLayoutParams.rightMargin = i12 + windowInsetsCompat.getSystemWindowInsetRight();
        return windowInsetsCompat;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z11) {
        this.f37368d.setVisibility(z11 ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f11) {
        pi.a aVar = this.f37382s;
        if (aVar == null || this.f37367c == null) {
            return;
        }
        this.f37367c.setBackgroundColor(aVar.c(this.f37389z, f11));
    }

    private void setUpHeaderLayout(int i11) {
        if (i11 != -1) {
            addHeaderView(LayoutInflater.from(getContext()).inflate(i11, (ViewGroup) this.f37369f, false));
        }
    }

    private void setUpStatusBarSpacer(int i11) {
        if (this.f37368d.getLayoutParams().height != i11) {
            this.f37368d.getLayoutParams().height = i11;
            this.f37368d.requestLayout();
        }
    }

    public static /* synthetic */ boolean t(View view, MotionEvent motionEvent) {
        return true;
    }

    public final void A() {
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
    }

    public final void B() {
        this.f37375l.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f37453a.q(view);
            }
        });
        this.f37374k.addTextChangedListener(new a());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void C() {
        this.f37377n.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.search.p
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f37456a.r(view, motionEvent);
            }
        });
    }

    public final void D() {
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f37376m.getLayoutParams();
        final int i11 = marginLayoutParams.leftMargin;
        final int i12 = marginLayoutParams.rightMargin;
        ViewCompat.setOnApplyWindowInsetsListener(this.f37376m, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.search.s
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return SearchView.s(marginLayoutParams, i11, i12, view, windowInsetsCompat);
            }
        });
    }

    public final void E(int i11, String str, String str2) {
        if (i11 != -1) {
            androidx.core.widget.m.p(this.f37374k, i11);
        }
        this.f37374k.setText(str);
        this.f37374k.setHint(str2);
    }

    public final void F() {
        I();
        D();
        H();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void G() {
        this.f37366b.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.search.q
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SearchView.t(view, motionEvent);
            }
        });
    }

    public final void H() {
        setUpStatusBarSpacer(getStatusBarHeight());
        ViewCompat.setOnApplyWindowInsetsListener(this.f37368d, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.search.t
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return this.f37461a.u(view, windowInsetsCompat);
            }
        });
    }

    public final void I() {
        com.google.android.material.internal.f0.f(this.f37371h, new com.google.android.material.internal.f0.d() { // from class: com.google.android.material.search.n
            @Override // com.google.android.material.internal.f0.d
            public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, com.google.android.material.internal.f0.e eVar) {
                return this.f37454a.v(view, windowInsetsCompat, eVar);
            }
        });
    }

    @SuppressLint({"InlinedApi"})
    public final void J(ViewGroup viewGroup, boolean z11) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt != this) {
                if (childAt.findViewById(this.f37366b.getId()) != null) {
                    J((ViewGroup) childAt, z11);
                } else if (z11) {
                    this.D.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    ViewCompat.setImportantForAccessibility(childAt, 4);
                } else {
                    Map<View, Integer> map = this.D;
                    if (map != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.D.get(childAt).intValue());
                    }
                }
            }
        }
    }

    public final void K(@NonNull TransitionState transitionState) {
        if (this.f37384u == null || !this.f37381r) {
            return;
        }
        if (transitionState.equals(TransitionState.SHOWN)) {
            this.f37380q.c();
        } else if (transitionState.equals(TransitionState.HIDDEN)) {
            this.f37380q.f();
        }
    }

    public final void L() {
        MaterialToolbar materialToolbar = this.f37371h;
        if (materialToolbar == null || m(materialToolbar)) {
            return;
        }
        int defaultNavigationIconResource = getDefaultNavigationIconResource();
        if (this.f37384u == null) {
            this.f37371h.setNavigationIcon(defaultNavigationIconResource);
            return;
        }
        Drawable drawableR = d3.a.r(d1.a.b(getContext(), defaultNavigationIconResource).mutate());
        if (this.f37371h.getNavigationIconTint() != null) {
            d3.a.n(drawableR, this.f37371h.getNavigationIconTint().intValue());
        }
        this.f37371h.setNavigationIcon(new com.google.android.material.internal.h(this.f37384u.getNavigationIcon(), drawableR));
        M();
    }

    public final void M() {
        ImageButton imageButtonE = ToolbarUtils.e(this.f37371h);
        if (imageButtonE == null) {
            return;
        }
        int i11 = this.f37366b.getVisibility() == 0 ? 1 : 0;
        Drawable drawableQ = d3.a.q(imageButtonE.getDrawable());
        if (drawableQ instanceof androidx.appcompat.graphics.drawable.c) {
            ((androidx.appcompat.graphics.drawable.c) drawableQ).setProgress(i11);
        }
        if (drawableQ instanceof com.google.android.material.internal.h) {
            ((com.google.android.material.internal.h) drawableQ).a(i11);
        }
    }

    public void addHeaderView(@NonNull View view) {
        this.f37369f.addView(view);
        this.f37369f.setVisibility(0);
    }

    public void addTransitionListener(@NonNull b bVar) {
        this.f37383t.add(bVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (this.f37378o) {
            this.f37377n.addView(view, i11, layoutParams);
        } else {
            super.addView(view, i11, layoutParams);
        }
    }

    @Override // ti.b
    public void cancelBackProgress() {
        if (l() || this.f37384u == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        this.f37379p.o();
    }

    public void clearFocusAndHideKeyboard() {
        this.f37374k.post(new Runnable() { // from class: com.google.android.material.search.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f37455a.n();
            }
        });
    }

    public void clearText() {
        this.f37374k.setText("");
    }

    public ti.h getBackHelper() {
        return this.f37379p.r();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @NonNull
    public CoordinatorLayout.c<SearchView> getBehavior() {
        return new Behavior();
    }

    @NonNull
    public TransitionState getCurrentTransitionState() {
        return this.C;
    }

    public int getDefaultNavigationIconResource() {
        return R$drawable.ic_arrow_back_black_24;
    }

    @NonNull
    public EditText getEditText() {
        return this.f37374k;
    }

    @Nullable
    public CharSequence getHint() {
        return this.f37374k.getHint();
    }

    @NonNull
    public TextView getSearchPrefix() {
        return this.f37373j;
    }

    @Nullable
    public CharSequence getSearchPrefixText() {
        return this.f37373j.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f37385v;
    }

    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.f37374k.getText();
    }

    @NonNull
    public Toolbar getToolbar() {
        return this.f37371h;
    }

    @Override // ti.b
    public void handleBackInvoked() {
        if (l()) {
            return;
        }
        androidx.activity.b bVarS = this.f37379p.S();
        if (Build.VERSION.SDK_INT < 34 || this.f37384u == null || bVarS == null) {
            hide();
        } else {
            this.f37379p.p();
        }
    }

    public void hide() {
        if (this.C.equals(TransitionState.HIDDEN) || this.C.equals(TransitionState.HIDING)) {
            return;
        }
        this.f37379p.M();
    }

    public void inflateMenu(int i11) {
        this.f37371h.inflateMenu(i11);
    }

    public boolean isAnimatedNavigationIcon() {
        return this.f37386w;
    }

    public boolean isAutoShowKeyboard() {
        return this.f37388y;
    }

    public boolean isMenuItemsAnimated() {
        return this.f37387x;
    }

    public boolean isSetupWithSearchBar() {
        return this.f37384u != null;
    }

    public boolean isShowing() {
        return this.C.equals(TransitionState.SHOWN) || this.C.equals(TransitionState.SHOWING);
    }

    public boolean isUseWindowInsetsController() {
        return this.A;
    }

    public boolean k() {
        return this.f37385v == 48;
    }

    public final boolean l() {
        return this.C.equals(TransitionState.HIDDEN) || this.C.equals(TransitionState.HIDING);
    }

    public final boolean m(@NonNull Toolbar toolbar) {
        return d3.a.q(toolbar.getNavigationIcon()) instanceof androidx.appcompat.graphics.drawable.c;
    }

    public final /* synthetic */ void n() {
        this.f37374k.clearFocus();
        SearchBar searchBar = this.f37384u;
        if (searchBar != null) {
            searchBar.requestFocus();
        }
        com.google.android.material.internal.f0.o(this.f37374k, this.A);
    }

    public final /* synthetic */ void o() {
        if (this.f37374k.requestFocus()) {
            this.f37374k.sendAccessibilityEvent(8);
        }
        com.google.android.material.internal.f0.v(this.f37374k, this.A);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        yi.j.e(this);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        updateSoftInputMode();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.f37390a);
        setVisible(savedState.f37391b == 0);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        savedState.f37390a = text == null ? null : text.toString();
        savedState.f37391b = this.f37366b.getVisibility();
        return savedState;
    }

    public final /* synthetic */ void p(View view) {
        hide();
    }

    public final /* synthetic */ void q(View view) {
        clearText();
        x();
    }

    public final /* synthetic */ boolean r(View view, MotionEvent motionEvent) {
        if (!k()) {
            return false;
        }
        clearFocusAndHideKeyboard();
        return false;
    }

    public void removeAllHeaderViews() {
        this.f37369f.removeAllViews();
        this.f37369f.setVisibility(8);
    }

    public void removeHeaderView(@NonNull View view) {
        this.f37369f.removeView(view);
        if (this.f37369f.getChildCount() == 0) {
            this.f37369f.setVisibility(8);
        }
    }

    public void removeTransitionListener(@NonNull b bVar) {
        this.f37383t.remove(bVar);
    }

    public void requestFocusAndShowKeyboard() {
        this.f37374k.postDelayed(new Runnable() { // from class: com.google.android.material.search.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f37462a.o();
            }
        }, 100L);
    }

    public void setAnimatedNavigationIcon(boolean z11) {
        this.f37386w = z11;
    }

    public void setAutoShowKeyboard(boolean z11) {
        this.f37388y = z11;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f11) {
        super.setElevation(f11);
        setUpBackgroundViewElevationOverlay(f11);
    }

    public void setHint(@StringRes int i11) {
        this.f37374k.setHint(i11);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.f37374k.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z11) {
        this.f37387x = z11;
    }

    public void setModalForAccessibility(boolean z11) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z11) {
            this.D = new HashMap(viewGroup.getChildCount());
        }
        J(viewGroup, z11);
        if (z11) {
            return;
        }
        this.D = null;
    }

    public void setOnMenuItemClickListener(@Nullable Toolbar.g gVar) {
        this.f37371h.setOnMenuItemClickListener(gVar);
    }

    public void setSearchPrefixText(@Nullable CharSequence charSequence) {
        this.f37373j.setText(charSequence);
        this.f37373j.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void setStatusBarSpacerEnabled(boolean z11) {
        this.B = true;
        setStatusBarSpacerEnabledInternal(z11);
    }

    public void setText(@StringRes int i11) {
        this.f37374k.setText(i11);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(@Nullable CharSequence charSequence) {
        this.f37374k.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z11) {
        this.f37371h.setTouchscreenBlocksFocus(z11);
    }

    public void setTransitionState(@NonNull TransitionState transitionState) {
        y(transitionState, true);
    }

    public void setUseWindowInsetsController(boolean z11) {
        this.A = z11;
    }

    public void setVisible(boolean z11) {
        boolean z12 = this.f37366b.getVisibility() == 0;
        this.f37366b.setVisibility(z11 ? 0 : 8);
        M();
        y(z11 ? TransitionState.SHOWN : TransitionState.HIDDEN, z12 != z11);
    }

    public void setupWithSearchBar(@Nullable SearchBar searchBar) {
        this.f37384u = searchBar;
        this.f37379p.X(searchBar);
        if (searchBar != null) {
            searchBar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f37463a.w(view);
                }
            });
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    searchBar.setHandwritingDelegatorCallback(new Runnable() { // from class: com.google.android.material.search.w
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f37464a.show();
                        }
                    });
                    this.f37374k.setIsHandwritingDelegate(true);
                } catch (LinkageError unused) {
                }
            }
        }
        L();
        A();
        K(getCurrentTransitionState());
    }

    public void show() {
        if (this.C.equals(TransitionState.SHOWN) || this.C.equals(TransitionState.SHOWING)) {
            return;
        }
        this.f37379p.Z();
    }

    @Override // ti.b
    public void startBackProgress(@NonNull androidx.activity.b bVar) {
        if (l() || this.f37384u == null) {
            return;
        }
        this.f37379p.a0(bVar);
    }

    public final /* synthetic */ WindowInsetsCompat u(View view, WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        setUpStatusBarSpacer(systemWindowInsetTop);
        if (!this.B) {
            setStatusBarSpacerEnabledInternal(systemWindowInsetTop > 0);
        }
        return windowInsetsCompat;
    }

    @Override // ti.b
    public void updateBackProgress(@NonNull androidx.activity.b bVar) {
        if (l() || this.f37384u == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        this.f37379p.f0(bVar);
    }

    public void updateSoftInputMode() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f37385v = activityWindow.getAttributes().softInputMode;
        }
    }

    public final /* synthetic */ WindowInsetsCompat v(View view, WindowInsetsCompat windowInsetsCompat, com.google.android.material.internal.f0.e eVar) {
        boolean zP = com.google.android.material.internal.f0.p(this.f37371h);
        this.f37371h.setPadding((zP ? eVar.f37044c : eVar.f37042a) + windowInsetsCompat.getSystemWindowInsetLeft(), eVar.f37043b, (zP ? eVar.f37042a : eVar.f37044c) + windowInsetsCompat.getSystemWindowInsetRight(), eVar.f37045d);
        return windowInsetsCompat;
    }

    public final /* synthetic */ void w(View view) {
        show();
    }

    public void x() {
        if (this.f37388y) {
            requestFocusAndShowKeyboard();
        }
    }

    public final void y(@NonNull TransitionState transitionState, boolean z11) {
        if (this.C.equals(transitionState)) {
            return;
        }
        if (z11) {
            if (transitionState == TransitionState.SHOWN) {
                setModalForAccessibility(true);
            } else if (transitionState == TransitionState.HIDDEN) {
                setModalForAccessibility(false);
            }
        }
        TransitionState transitionState2 = this.C;
        this.C = transitionState;
        Iterator it = new LinkedHashSet(this.f37383t).iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this, transitionState2, transitionState);
        }
        K(transitionState);
    }

    public final void z(boolean z11, boolean z12) {
        if (z12) {
            this.f37371h.setNavigationIcon((Drawable) null);
            return;
        }
        this.f37371h.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f37457a.p(view);
            }
        });
        if (z11) {
            androidx.appcompat.graphics.drawable.c cVar = new androidx.appcompat.graphics.drawable.c(getContext());
            cVar.c(com.google.android.material.color.b.d(this, R$attr.colorOnSurface));
            this.f37371h.setNavigationIcon(cVar);
        }
    }
}
