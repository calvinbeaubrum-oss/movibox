package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.tn.lib.view.FlowLayout;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class SearchView extends LinearLayoutCompat implements g1.c {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final m f1505o0;
    public Rect A;
    public Rect B;
    public int[] C;
    public int[] D;
    public final ImageView E;
    public final Drawable F;
    public final int G;
    public final int H;
    public final Intent I;
    public final Intent J;
    public final CharSequence K;
    public View.OnFocusChangeListener L;
    public View.OnClickListener M;
    public boolean N;
    public boolean O;
    public j3.a P;
    public boolean Q;
    public CharSequence R;
    public boolean S;
    public boolean T;
    public int U;
    public boolean V;
    public CharSequence W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public CharSequence f1506a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1507b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f1508c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public SearchableInfo f1509d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Bundle f1510e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Runnable f1511f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public Runnable f1512g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f1513h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final View.OnClickListener f1514i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public View.OnKeyListener f1515j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final TextView.OnEditorActionListener f1516k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final AdapterView.OnItemClickListener f1517l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f1518m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public TextWatcher f1519n0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SearchAutoComplete f1520q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f1521r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f1522s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f1523t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ImageView f1524u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ImageView f1525v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ImageView f1526w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ImageView f1527x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final View f1528y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public n f1529z;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1530a;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1530a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1530a + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeValue(Boolean.valueOf(this.f1530a));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1531f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public SearchView f1532g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f1533h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Runnable f1534i;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i11) {
            super(context, attributeSet, i11);
            this.f1534i = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.d();
                }
            };
            this.f1531f = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i11 = configuration.screenWidthDp;
            int i12 = configuration.screenHeightDp;
            if (i11 >= 960 && i12 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i11 >= 600) {
                return PsExtractor.AUDIO_STREAM;
            }
            if (i11 < 640 || i12 < 480) {
                return 160;
            }
            return PsExtractor.AUDIO_STREAM;
        }

        public void b() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f1505o0.c(this);
                return;
            }
            i.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        public boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void d() {
            if (this.f1533h) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1533h = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f1531f <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1533h) {
                removeCallbacks(this.f1534i);
                post(this.f1534i);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z11, int i11, Rect rect) {
            super.onFocusChanged(z11, i11, rect);
            this.f1532g.R();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i11, KeyEvent keyEvent) {
            if (i11 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1532g.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i11, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z11) {
            super.onWindowFocusChanged(z11);
            if (z11 && this.f1532g.hasFocus() && getVisibility() == 0) {
                this.f1533h = true;
                if (SearchView.E(getContext())) {
                    b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z11) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z11) {
                this.f1533h = false;
                removeCallbacks(this.f1534i);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f1533h = true;
                    return;
                }
                this.f1533h = false;
                removeCallbacks(this.f1534i);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f1532g = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i11) {
            super.setThreshold(i11);
            this.f1531f = i11;
        }
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
            SearchView.this.Q(charSequence);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z11) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.L;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements View.OnLayoutChangeListener {
        public c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            SearchView.this.u();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f1524u) {
                searchView.N();
                return;
            }
            if (view == searchView.f1526w) {
                searchView.J();
                return;
            }
            if (view == searchView.f1525v) {
                searchView.O();
            } else if (view == searchView.f1527x) {
                searchView.S();
            } else if (view == searchView.f1520q) {
                searchView.A();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements View.OnKeyListener {
        public e() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i11, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f1509d0 == null) {
                return false;
            }
            if (searchView.f1520q.isPopupShowing() && SearchView.this.f1520q.getListSelection() != -1) {
                return SearchView.this.P(view, i11, keyEvent);
            }
            if (SearchView.this.f1520q.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i11 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.H(0, null, searchView2.f1520q.getText().toString());
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements TextView.OnEditorActionListener {
        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            SearchView.this.O();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements AdapterView.OnItemClickListener {
        public g() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            SearchView.this.K(i11, 0, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements AdapterView.OnItemSelectedListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
            SearchView.this.L(i11);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class i {
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        public static void b(SearchAutoComplete searchAutoComplete, int i11) {
            searchAutoComplete.setInputMethodMode(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface j {
    }

    /* JADX INFO: compiled from: source.java */
    public interface k {
    }

    /* JADX INFO: compiled from: source.java */
    public interface l {
    }

    /* JADX INFO: compiled from: source.java */
    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f1543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f1544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Method f1545c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public m() {
            this.f1543a = null;
            this.f1544b = null;
            this.f1545c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1543a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1544b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f1545c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        public void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1544b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1543a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1545c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class n extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f1546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f1547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect f1548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f1549d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1550e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1551f;

        public n(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1550e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1547b = new Rect();
            this.f1549d = new Rect();
            this.f1548c = new Rect();
            a(rect, rect2);
            this.f1546a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f1547b.set(rect);
            this.f1549d.set(rect);
            Rect rect3 = this.f1549d;
            int i11 = this.f1550e;
            rect3.inset(-i11, -i11);
            this.f1548c.set(rect2);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x003c  */
        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z11;
            boolean z12;
            int x11 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z13 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z12 = this.f1551f;
                    if (z12 && !this.f1549d.contains(x11, y11)) {
                        z13 = z12;
                        z11 = false;
                    }
                } else if (action != 3) {
                    z11 = true;
                    z13 = false;
                } else {
                    z12 = this.f1551f;
                    this.f1551f = false;
                }
                z13 = z12;
                z11 = true;
            } else if (this.f1547b.contains(x11, y11)) {
                this.f1551f = true;
                z11 = true;
            } else {
                z11 = true;
                z13 = false;
            }
            if (!z13) {
                return false;
            }
            if (!z11 || this.f1548c.contains(x11, y11)) {
                Rect rect = this.f1548c;
                motionEvent.setLocation(x11 - rect.left, y11 - rect.top);
            } else {
                motionEvent.setLocation(this.f1546a.getWidth() / 2, this.f1546a.getHeight() / 2);
            }
            return this.f1546a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f1505o0 = Build.VERSION.SDK_INT < 29 ? new m() : null;
    }

    public SearchView(@NonNull Context context) {
        this(context, null);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.searchViewStyle);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.A = new Rect();
        this.B = new Rect();
        this.C = new int[2];
        this.D = new int[2];
        this.f1511f0 = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.W();
            }
        };
        this.f1512g0 = new Runnable() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // java.lang.Runnable
            public void run() {
                j3.a aVar = SearchView.this.P;
                if (aVar instanceof h0) {
                    aVar.a(null);
                }
            }
        };
        this.f1513h0 = new WeakHashMap<>();
        d dVar = new d();
        this.f1514i0 = dVar;
        this.f1515j0 = new e();
        f fVar = new f();
        this.f1516k0 = fVar;
        g gVar = new g();
        this.f1517l0 = gVar;
        h hVar = new h();
        this.f1518m0 = hVar;
        this.f1519n0 = new a();
        n0 n0VarV = n0.v(context, attributeSet, R$styleable.SearchView, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.SearchView, attributeSet, n0VarV.r(), i11, 0);
        LayoutInflater.from(context).inflate(n0VarV.n(R$styleable.SearchView_layout, R$layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R$id.search_src_text);
        this.f1520q = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1521r = findViewById(R$id.search_edit_frame);
        View viewFindViewById = findViewById(R$id.search_plate);
        this.f1522s = viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.submit_area);
        this.f1523t = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R$id.search_button);
        this.f1524u = imageView;
        ImageView imageView2 = (ImageView) findViewById(R$id.search_go_btn);
        this.f1525v = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R$id.search_close_btn);
        this.f1526w = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R$id.search_voice_btn);
        this.f1527x = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R$id.search_mag_icon);
        this.E = imageView5;
        ViewCompat.setBackground(viewFindViewById, n0VarV.g(R$styleable.SearchView_queryBackground));
        ViewCompat.setBackground(viewFindViewById2, n0VarV.g(R$styleable.SearchView_submitBackground));
        imageView.setImageDrawable(n0VarV.g(R$styleable.SearchView_searchIcon));
        imageView2.setImageDrawable(n0VarV.g(R$styleable.SearchView_goIcon));
        imageView3.setImageDrawable(n0VarV.g(R$styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(n0VarV.g(R$styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(n0VarV.g(R$styleable.SearchView_searchIcon));
        this.F = n0VarV.g(R$styleable.SearchView_searchHintIcon);
        s0.a(imageView, getResources().getString(R$string.abc_searchview_description_search));
        this.G = n0VarV.n(R$styleable.SearchView_suggestionRowLayout, R$layout.abc_search_dropdown_item_icons_2line);
        this.H = n0VarV.n(R$styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(dVar);
        imageView3.setOnClickListener(dVar);
        imageView2.setOnClickListener(dVar);
        imageView4.setOnClickListener(dVar);
        searchAutoComplete.setOnClickListener(dVar);
        searchAutoComplete.addTextChangedListener(this.f1519n0);
        searchAutoComplete.setOnEditorActionListener(fVar);
        searchAutoComplete.setOnItemClickListener(gVar);
        searchAutoComplete.setOnItemSelectedListener(hVar);
        searchAutoComplete.setOnKeyListener(this.f1515j0);
        searchAutoComplete.setOnFocusChangeListener(new b());
        setIconifiedByDefault(n0VarV.a(R$styleable.SearchView_iconifiedByDefault, true));
        int iF = n0VarV.f(R$styleable.SearchView_android_maxWidth, -1);
        if (iF != -1) {
            setMaxWidth(iF);
        }
        this.K = n0VarV.p(R$styleable.SearchView_defaultQueryHint);
        this.R = n0VarV.p(R$styleable.SearchView_queryHint);
        int iK = n0VarV.k(R$styleable.SearchView_android_imeOptions, -1);
        if (iK != -1) {
            setImeOptions(iK);
        }
        int iK2 = n0VarV.k(R$styleable.SearchView_android_inputType, -1);
        if (iK2 != -1) {
            setInputType(iK2);
        }
        setFocusable(n0VarV.a(R$styleable.SearchView_android_focusable, true));
        n0VarV.x();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.I = intent;
        intent.addFlags(ASTNode.DEOP);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.J = intent2;
        intent2.addFlags(ASTNode.DEOP);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f1528y = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new c());
        }
        b0(this.N);
        X();
    }

    public static boolean E(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        this.f1520q.setText(charSequence);
        this.f1520q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void A() {
        if (Build.VERSION.SDK_INT >= 29) {
            i.a(this.f1520q);
            return;
        }
        m mVar = f1505o0;
        mVar.b(this.f1520q);
        mVar.a(this.f1520q);
    }

    public final void B(View view, Rect rect) {
        view.getLocationInWindow(this.C);
        getLocationInWindow(this.D);
        int[] iArr = this.C;
        int i11 = iArr[1];
        int[] iArr2 = this.D;
        int i12 = i11 - iArr2[1];
        int i13 = iArr[0] - iArr2[0];
        rect.set(i13, i12, view.getWidth() + i13, view.getHeight() + i12);
    }

    public final CharSequence C(CharSequence charSequence) {
        if (!this.N || this.F == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1520q.getTextSize()) * 1.25d);
        this.F.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public final boolean D() {
        Intent intent;
        SearchableInfo searchableInfo = this.f1509d0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        if (this.f1509d0.getVoiceSearchLaunchWebSearch()) {
            intent = this.I;
        } else {
            intent = this.f1509d0.getVoiceSearchLaunchRecognizer() ? this.J : null;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public final boolean F() {
        return (this.Q || this.V) && !isIconified();
    }

    public final void G(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e11) {
            Log.e("SearchView", "Failed launch activity: " + intent, e11);
        }
    }

    public void H(int i11, String str, String str2) {
        getContext().startActivity(v("android.intent.action.SEARCH", null, null, str2, i11, str));
    }

    public final boolean I(int i11, int i12, String str) {
        Cursor cursorD = this.P.d();
        if (cursorD == null || !cursorD.moveToPosition(i11)) {
            return false;
        }
        G(w(cursorD, i12, str));
        return true;
    }

    public void J() {
        if (!TextUtils.isEmpty(this.f1520q.getText())) {
            this.f1520q.setText("");
            this.f1520q.requestFocus();
            this.f1520q.setImeVisibility(true);
        } else if (this.N) {
            clearFocus();
            b0(true);
        }
    }

    public boolean K(int i11, int i12, String str) {
        I(i11, 0, null);
        this.f1520q.setImeVisibility(false);
        z();
        return true;
    }

    public boolean L(int i11) {
        U(i11);
        return true;
    }

    public void M(@Nullable CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void N() {
        b0(false);
        this.f1520q.requestFocus();
        this.f1520q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.M;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void O() {
        Editable text = this.f1520q.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f1509d0 != null) {
            H(0, null, text.toString());
        }
        this.f1520q.setImeVisibility(false);
        z();
    }

    public boolean P(View view, int i11, KeyEvent keyEvent) {
        if (this.f1509d0 != null && this.P != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i11 == 66 || i11 == 84 || i11 == 61) {
                return K(this.f1520q.getListSelection(), 0, null);
            }
            if (i11 == 21 || i11 == 22) {
                this.f1520q.setSelection(i11 == 21 ? 0 : this.f1520q.length());
                this.f1520q.setListSelection(0);
                this.f1520q.clearListSelection();
                this.f1520q.b();
                return true;
            }
            if (i11 == 19) {
                this.f1520q.getListSelection();
                return false;
            }
        }
        return false;
    }

    public void Q(CharSequence charSequence) {
        Editable text = this.f1520q.getText();
        this.f1506a0 = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        a0(!zIsEmpty);
        c0(zIsEmpty);
        V();
        Z();
        this.W = charSequence.toString();
    }

    public void R() {
        b0(isIconified());
        T();
        if (this.f1520q.hasFocus()) {
            A();
        }
    }

    public void S() {
        SearchableInfo searchableInfo = this.f1509d0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(y(this.I, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(x(this.J, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public final void T() {
        post(this.f1511f0);
    }

    public final void U(int i11) {
        Editable text = this.f1520q.getText();
        Cursor cursorD = this.P.d();
        if (cursorD == null) {
            return;
        }
        if (!cursorD.moveToPosition(i11)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceB = this.P.b(cursorD);
        if (charSequenceB != null) {
            setQuery(charSequenceB);
        } else {
            setQuery(text);
        }
    }

    public final void V() {
        boolean z11 = true;
        boolean z12 = !TextUtils.isEmpty(this.f1520q.getText());
        if (!z12 && (!this.N || this.f1507b0)) {
            z11 = false;
        }
        this.f1526w.setVisibility(z11 ? 0 : 8);
        Drawable drawable = this.f1526w.getDrawable();
        if (drawable != null) {
            drawable.setState(z12 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public void W() {
        int[] iArr = this.f1520q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f1522s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1523t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void X() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1520q;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(C(queryHint));
    }

    public final void Y() {
        this.f1520q.setThreshold(this.f1509d0.getSuggestThreshold());
        this.f1520q.setImeOptions(this.f1509d0.getImeOptions());
        int inputType = this.f1509d0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= FlowLayout.SPACING_ALIGN;
            if (this.f1509d0.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f1520q.setInputType(inputType);
        j3.a aVar = this.P;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.f1509d0.getSuggestAuthority() != null) {
            h0 h0Var = new h0(getContext(), this, this.f1509d0, this.f1513h0);
            this.P = h0Var;
            this.f1520q.setAdapter(h0Var);
            ((h0) this.P).x(this.S ? 2 : 1);
        }
    }

    public final void Z() {
        this.f1523t.setVisibility((F() && (this.f1525v.getVisibility() == 0 || this.f1527x.getVisibility() == 0)) ? 0 : 8);
    }

    public final void a0(boolean z11) {
        this.f1525v.setVisibility((this.Q && F() && hasFocus() && (z11 || !this.V)) ? 0 : 8);
    }

    public final void b0(boolean z11) {
        this.O = z11;
        int i11 = 8;
        int i12 = z11 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f1520q.getText());
        this.f1524u.setVisibility(i12);
        a0(!zIsEmpty);
        this.f1521r.setVisibility(z11 ? 8 : 0);
        if (this.E.getDrawable() != null && !this.N) {
            i11 = 0;
        }
        this.E.setVisibility(i11);
        V();
        c0(zIsEmpty);
        Z();
    }

    public final void c0(boolean z11) {
        int i11 = 8;
        if (this.V && !isIconified() && z11) {
            this.f1525v.setVisibility(8);
            i11 = 0;
        }
        this.f1527x.setVisibility(i11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.T = true;
        super.clearFocus();
        this.f1520q.clearFocus();
        this.f1520q.setImeVisibility(false);
        this.T = false;
    }

    public int getImeOptions() {
        return this.f1520q.getImeOptions();
    }

    public int getInputType() {
        return this.f1520q.getInputType();
    }

    public int getMaxWidth() {
        return this.U;
    }

    public CharSequence getQuery() {
        return this.f1520q.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.R;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1509d0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.K : getContext().getText(this.f1509d0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.H;
    }

    public int getSuggestionRowLayout() {
        return this.G;
    }

    public j3.a getSuggestionsAdapter() {
        return this.P;
    }

    public boolean isIconfiedByDefault() {
        return this.N;
    }

    public boolean isIconified() {
        return this.O;
    }

    public boolean isQueryRefinementEnabled() {
        return this.S;
    }

    public boolean isSubmitButtonEnabled() {
        return this.Q;
    }

    @Override // g1.c
    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        b0(true);
        this.f1520q.setImeOptions(this.f1508c0);
        this.f1507b0 = false;
    }

    @Override // g1.c
    public void onActionViewExpanded() {
        if (this.f1507b0) {
            return;
        }
        this.f1507b0 = true;
        int imeOptions = this.f1520q.getImeOptions();
        this.f1508c0 = imeOptions;
        this.f1520q.setImeOptions(imeOptions | ASTNode.PCTX_STORED);
        this.f1520q.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1511f0);
        post(this.f1512g0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (z11) {
            B(this.f1520q, this.A);
            Rect rect = this.B;
            Rect rect2 = this.A;
            rect.set(rect2.left, 0, rect2.right, i14 - i12);
            n nVar = this.f1529z;
            if (nVar != null) {
                nVar.a(this.B, this.A);
                return;
            }
            n nVar2 = new n(this.B, this.A, this.f1520q);
            this.f1529z = nVar2;
            setTouchDelegate(nVar2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i11, int i12) {
        int i13;
        if (isIconified()) {
            super.onMeasure(i11, i12);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            int i14 = this.U;
            size = i14 > 0 ? Math.min(i14, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.U;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i13 = this.U) > 0) {
            size = Math.min(i13, size);
        }
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        b0(savedState.f1530a);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1530a = isIconified();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        T();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i11, Rect rect) {
        if (this.T || !isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(i11, rect);
        }
        boolean zRequestFocus = this.f1520q.requestFocus(i11, rect);
        if (zRequestFocus) {
            b0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1510e0 = bundle;
    }

    public void setIconified(boolean z11) {
        if (z11) {
            J();
        } else {
            N();
        }
    }

    public void setIconifiedByDefault(boolean z11) {
        if (this.N == z11) {
            return;
        }
        this.N = z11;
        b0(z11);
        X();
    }

    public void setImeOptions(int i11) {
        this.f1520q.setImeOptions(i11);
    }

    public void setInputType(int i11) {
        this.f1520q.setInputType(i11);
    }

    public void setMaxWidth(int i11) {
        this.U = i11;
        requestLayout();
    }

    public void setOnCloseListener(j jVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.L = onFocusChangeListener;
    }

    public void setOnQueryTextListener(k kVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.M = onClickListener;
    }

    public void setOnSuggestionListener(l lVar) {
    }

    public void setQuery(CharSequence charSequence, boolean z11) {
        this.f1520q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1520q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1506a0 = charSequence;
        }
        if (!z11 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        O();
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.R = charSequence;
        X();
    }

    public void setQueryRefinementEnabled(boolean z11) {
        this.S = z11;
        j3.a aVar = this.P;
        if (aVar instanceof h0) {
            ((h0) aVar).x(z11 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1509d0 = searchableInfo;
        if (searchableInfo != null) {
            Y();
            X();
        }
        boolean zD = D();
        this.V = zD;
        if (zD) {
            this.f1520q.setPrivateImeOptions("nm");
        }
        b0(isIconified());
    }

    public void setSubmitButtonEnabled(boolean z11) {
        this.Q = z11;
        b0(isIconified());
    }

    public void setSuggestionsAdapter(j3.a aVar) {
        this.P = aVar;
        this.f1520q.setAdapter(aVar);
    }

    public void u() {
        if (this.f1528y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1522s.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = y0.b(this);
            int dimensionPixelSize = this.N ? resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f1520q.getDropDownBackground().getPadding(rect);
            this.f1520q.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f1520q.setDropDownWidth((((this.f1528y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public final Intent v(String str, Uri uri, String str2, String str3, int i11, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(ASTNode.DEOP);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1506a0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1510e0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i11 != 0) {
            intent.putExtra("action_key", i11);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1509d0.getSearchActivity());
        return intent;
    }

    public final Intent w(Cursor cursor, int i11, String str) {
        int position;
        String strO;
        try {
            String strO2 = h0.o(cursor, "suggest_intent_action");
            if (strO2 == null) {
                strO2 = this.f1509d0.getSuggestIntentAction();
            }
            if (strO2 == null) {
                strO2 = "android.intent.action.SEARCH";
            }
            String str2 = strO2;
            String strO3 = h0.o(cursor, "suggest_intent_data");
            if (strO3 == null) {
                strO3 = this.f1509d0.getSuggestIntentData();
            }
            if (strO3 != null && (strO = h0.o(cursor, "suggest_intent_data_id")) != null) {
                strO3 = strO3 + "/" + Uri.encode(strO);
            }
            return v(str2, strO3 == null ? null : Uri.parse(strO3), h0.o(cursor, "suggest_intent_extra_data"), h0.o(cursor, "suggest_intent_query"), i11, str);
        } catch (RuntimeException e11) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e11);
            return null;
        }
    }

    public final Intent x(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1510e0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final Intent y(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    public final void z() {
        this.f1520q.dismissDropDown();
    }
}
