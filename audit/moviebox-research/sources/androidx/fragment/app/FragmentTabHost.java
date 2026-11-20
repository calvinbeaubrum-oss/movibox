package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f8522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f8523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f8524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FragmentManager f8525d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TabHost.OnTabChangeListener f8527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f8528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8529i;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8530a;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f8530a = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f8530a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f8530a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a implements TabHost.TabContentFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f8531a;

        public a(Context context) {
            this.f8531a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.f8531a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final String f8532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final Class<?> f8533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Bundle f8534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Fragment f8535d;

        public b(@NonNull String str, @NonNull Class<?> cls, @Nullable Bundle bundle) {
            this.f8532a = str;
            this.f8533b = cls;
            this.f8534c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, null);
        this.f8522a = new ArrayList<>();
        e(context, null);
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8522a = new ArrayList<>();
        e(context, attributeSet);
    }

    @Nullable
    public final FragmentTransaction a(@Nullable String str, @Nullable FragmentTransaction fragmentTransaction) {
        Fragment fragment;
        b bVarD = d(str);
        if (this.f8528h != bVarD) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f8525d.beginTransaction();
            }
            b bVar = this.f8528h;
            if (bVar != null && (fragment = bVar.f8535d) != null) {
                fragmentTransaction.detach(fragment);
            }
            if (bVarD != null) {
                Fragment fragment2 = bVarD.f8535d;
                if (fragment2 == null) {
                    Fragment fragmentInstantiate = this.f8525d.getFragmentFactory().instantiate(this.f8524c.getClassLoader(), bVarD.f8533b.getName());
                    bVarD.f8535d = fragmentInstantiate;
                    fragmentInstantiate.setArguments(bVarD.f8534c);
                    fragmentTransaction.add(this.f8526f, bVarD.f8535d, bVarD.f8532a);
                } else {
                    fragmentTransaction.attach(fragment2);
                }
            }
            this.f8528h = bVarD;
        }
        return fragmentTransaction;
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec tabSpec, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        tabSpec.setContent(new a(this.f8524c));
        String tag = tabSpec.getTag();
        b bVar = new b(tag, cls, bundle);
        if (this.f8529i) {
            Fragment fragmentFindFragmentByTag = this.f8525d.findFragmentByTag(tag);
            bVar.f8535d = fragmentFindFragmentByTag;
            if (fragmentFindFragmentByTag != null && !fragmentFindFragmentByTag.isDetached()) {
                FragmentTransaction fragmentTransactionBeginTransaction = this.f8525d.beginTransaction();
                fragmentTransactionBeginTransaction.detach(bVar.f8535d);
                fragmentTransactionBeginTransaction.commit();
            }
        }
        this.f8522a.add(bVar);
        addTab(tabSpec);
    }

    public final void b() {
        if (this.f8523b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.f8526f);
            this.f8523b = frameLayout;
            if (frameLayout != null) {
                return;
            }
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.f8526f);
        }
    }

    public final void c(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f8523b = frameLayout2;
            frameLayout2.setId(this.f8526f);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Nullable
    public final b d(String str) {
        int size = this.f8522a.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f8522a.get(i11);
            if (bVar.f8532a.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f8526f = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f8522a.size();
        FragmentTransaction fragmentTransactionBeginTransaction = null;
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f8522a.get(i11);
            Fragment fragmentFindFragmentByTag = this.f8525d.findFragmentByTag(bVar.f8532a);
            bVar.f8535d = fragmentFindFragmentByTag;
            if (fragmentFindFragmentByTag != null && !fragmentFindFragmentByTag.isDetached()) {
                if (bVar.f8532a.equals(currentTabTag)) {
                    this.f8528h = bVar;
                } else {
                    if (fragmentTransactionBeginTransaction == null) {
                        fragmentTransactionBeginTransaction = this.f8525d.beginTransaction();
                    }
                    fragmentTransactionBeginTransaction.detach(bVar.f8535d);
                }
            }
        }
        this.f8529i = true;
        FragmentTransaction fragmentTransactionA = a(currentTabTag, fragmentTransactionBeginTransaction);
        if (fragmentTransactionA != null) {
            fragmentTransactionA.commit();
            this.f8525d.executePendingTransactions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8529i = false;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f8530a);
    }

    @Override // android.view.View
    @NonNull
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8530a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@Nullable String str) {
        FragmentTransaction fragmentTransactionA;
        if (this.f8529i && (fragmentTransactionA = a(str, null)) != null) {
            fragmentTransactionA.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f8527g;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener onTabChangeListener) {
        this.f8527g = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        c(context);
        super.setup();
        this.f8524c = context;
        this.f8525d = fragmentManager;
        b();
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i11) {
        c(context);
        super.setup();
        this.f8524c = context;
        this.f8525d = fragmentManager;
        this.f8526f = i11;
        b();
        this.f8523b.setId(i11);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }
}
