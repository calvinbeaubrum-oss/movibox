package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ActivityChooserView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f1301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f1302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f1303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f1304d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f1305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f1306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f1307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f1308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ActionProvider f1310k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DataSetObserver f1311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f1312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ListPopupWindow f1313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1314o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1315p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1316q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1317r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1318s;

    /* JADX INFO: compiled from: source.java */
    public static class InnerLayout extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f1319a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            n0 n0VarU = n0.u(context, attributeSet, f1319a);
            setBackgroundDrawable(n0VarU.g(0));
            n0VarU.x();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f1301a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f1301a.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.isShowingPopup()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                ActionProvider actionProvider = ActivityChooserView.this.f1310k;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(true);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends View.AccessibilityDelegate {
        public c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends ForwardingListener {
        public d(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public androidx.appcompat.view.menu.o b() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean c() {
            ActivityChooserView.this.showPopup();
            return true;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean d() {
            ActivityChooserView.this.dismissPopup();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.b();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1325a = 4;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1328d;

        public f() {
        }

        public int a() {
            throw null;
        }

        public androidx.appcompat.widget.b b() {
            return null;
        }

        public ResolveInfo c() {
            throw null;
        }

        public int d() {
            throw null;
        }

        public boolean e() {
            return this.f1326b;
        }

        public void f(androidx.appcompat.widget.b bVar) {
            ActivityChooserView.this.f1301a.b();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            throw null;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i11) {
            int itemViewType = getItemViewType(i11);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (this.f1326b) {
                throw null;
            }
            throw null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i11) {
            return (this.f1328d && i11 == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i11, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i11);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                viewInflate.setId(1);
                ((TextView) viewInflate.findViewById(R$id.title)).setText(ActivityChooserView.this.getContext().getString(R$string.abc_activity_chooser_view_see_all));
                return viewInflate;
            }
            if (view == null || view.getId() != R$id.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(R$id.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i11);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(R$id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f1326b && i11 == 0 && this.f1327c) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public g() {
        }

        public final void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f1314o;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f1307h) {
                activityChooserView.dismissPopup();
                ActivityChooserView.this.f1301a.c();
                ActivityChooserView.this.f1301a.b();
                throw null;
            }
            if (view != activityChooserView.f1305f) {
                throw new IllegalArgumentException();
            }
            activityChooserView.f1315p = false;
            activityChooserView.a(activityChooserView.f1316q);
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            ActionProvider actionProvider = ActivityChooserView.this.f1310k;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i11);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.a(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                return;
            }
            ActivityChooserView.this.dismissPopup();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (!activityChooserView.f1315p) {
                activityChooserView.f1301a.e();
                ActivityChooserView.this.f1301a.b();
                throw null;
            }
            if (i11 <= 0) {
                return;
            }
            activityChooserView.f1301a.b();
            throw null;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f1307h) {
                throw new IllegalArgumentException();
            }
            if (activityChooserView.f1301a.getCount() > 0) {
                ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                activityChooserView2.f1315p = true;
                activityChooserView2.a(activityChooserView2.f1316q);
            }
            return true;
        }
    }

    public ActivityChooserView(@NonNull Context context) {
        this(context, null);
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f1311l = new a();
        this.f1312m = new b();
        this.f1316q = 4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActivityChooserView, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.ActivityChooserView, attributeSet, typedArrayObtainStyledAttributes, i11, 0);
        this.f1316q = typedArrayObtainStyledAttributes.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.abc_activity_chooser_view, (ViewGroup) this, true);
        g gVar = new g();
        this.f1302b = gVar;
        View viewFindViewById = findViewById(R$id.activity_chooser_view_content);
        this.f1303c = viewFindViewById;
        this.f1304d = viewFindViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.default_activity_button);
        this.f1307h = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        this.f1308i = (ImageView) frameLayout.findViewById(R$id.image);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.expand_activities_button);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c());
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.f1305f = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(R$id.image);
        this.f1306g = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.f1301a = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.f1309j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }

    public void a(int i11) {
        this.f1301a.b();
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public void b() {
        if (this.f1301a.getCount() > 0) {
            this.f1305f.setEnabled(true);
        } else {
            this.f1305f.setEnabled(false);
        }
        int iA = this.f1301a.a();
        int iD = this.f1301a.d();
        if (iA == 1 || (iA > 1 && iD > 0)) {
            this.f1307h.setVisibility(0);
            ResolveInfo resolveInfoC = this.f1301a.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f1308i.setImageDrawable(resolveInfoC.loadIcon(packageManager));
            if (this.f1318s != 0) {
                this.f1307h.setContentDescription(getContext().getString(this.f1318s, resolveInfoC.loadLabel(packageManager)));
            }
        } else {
            this.f1307h.setVisibility(8);
        }
        if (this.f1307h.getVisibility() == 0) {
            this.f1303c.setBackgroundDrawable(this.f1304d);
        } else {
            this.f1303c.setBackgroundDrawable(null);
        }
    }

    public boolean dismissPopup() {
        if (!isShowingPopup()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1312m);
        return true;
    }

    public androidx.appcompat.widget.b getDataModel() {
        this.f1301a.b();
        return null;
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f1313n == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f1313n = listPopupWindow;
            listPopupWindow.m(this.f1301a);
            this.f1313n.C(this);
            this.f1313n.I(true);
            this.f1313n.K(this.f1302b);
            this.f1313n.J(this.f1302b);
        }
        return this.f1313n;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1301a.b();
        this.f1317r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1301a.b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1312m);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.f1317r = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.f1303c.layout(0, 0, i13 - i11, i14 - i12);
        if (isShowingPopup()) {
            return;
        }
        dismissPopup();
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        View view = this.f1303c;
        if (this.f1307h.getVisibility() != 0) {
            i12 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12), 1073741824);
        }
        measureChild(view, i11, i12);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(androidx.appcompat.widget.b bVar) {
        this.f1301a.f(bVar);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i11) {
        this.f1318s = i11;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i11) {
        this.f1306g.setContentDescription(getContext().getString(i11));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1306g.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i11) {
        this.f1316q = i11;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1314o = onDismissListener;
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f1310k = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.f1317r) {
            return false;
        }
        this.f1315p = false;
        a(this.f1316q);
        return true;
    }
}
