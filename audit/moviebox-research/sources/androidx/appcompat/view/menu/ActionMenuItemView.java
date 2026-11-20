package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.s0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ActionMenuItemView extends AppCompatTextView implements m.a, View.OnClickListener, ActionMenuView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f.b f985d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ForwardingListener f986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f990j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f991k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f992l;

    /* JADX INFO: compiled from: source.java */
    public class a extends ForwardingListener {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public o b() {
            b bVar = ActionMenuItemView.this.f987g;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean c() {
            o oVarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            f.b bVar = actionMenuItemView.f985d;
            return bVar != null && bVar.invokeItem(actionMenuItemView.f982a) && (oVarB = b()) != null && oVarB.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {
        public abstract o a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Resources resources = context.getResources();
        this.f988h = a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i11, 0);
        this.f990j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f992l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f991k = -1;
        setSaveEnabled(false);
    }

    public final boolean a() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i11 = configuration.screenWidthDp;
        return i11 >= 480 || (i11 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void b() {
        boolean z11 = true;
        boolean z12 = !TextUtils.isEmpty(this.f983b);
        if (this.f984c != null && (!this.f982a.B() || (!this.f988h && !this.f989i))) {
            z11 = false;
        }
        boolean z13 = z12 & z11;
        setText(z13 ? this.f983b : null);
        CharSequence contentDescription = this.f982a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z13 ? null : this.f982a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f982a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            s0.a(this, z13 ? null : this.f982a.getTitle());
        } else {
            s0.a(this, tooltipText);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.m.a
    public h getItemData() {
        return this.f982a;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void initialize(h hVar, int i11) {
        this.f982a = hVar;
        setIcon(hVar.getIcon());
        setTitle(hVar.i(this));
        setId(hVar.getItemId());
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.f986f == null) {
            this.f986f = new a();
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean needsDividerAfter() {
        return hasText();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean needsDividerBefore() {
        return hasText() && this.f982a.getIcon() == null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f.b bVar = this.f985d;
        if (bVar != null) {
            bVar.invokeItem(this.f982a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f988h = a();
        b();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i11, int i12) {
        int i13;
        boolean zHasText = hasText();
        if (zHasText && (i13 = this.f991k) >= 0) {
            super.setPadding(i13, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f990j) : this.f990j;
        if (mode != 1073741824 && this.f990j > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i12);
        }
        if (zHasText || this.f984c == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f984c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (this.f982a.hasSubMenu() && (forwardingListener = this.f986f) != null && forwardingListener.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z11) {
    }

    public void setChecked(boolean z11) {
    }

    public void setExpandedFormat(boolean z11) {
        if (this.f989i != z11) {
            this.f989i = z11;
            h hVar = this.f982a;
            if (hVar != null) {
                hVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f984c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i11 = this.f992l;
            if (intrinsicWidth > i11) {
                intrinsicHeight = (int) (intrinsicHeight * (i11 / intrinsicWidth));
                intrinsicWidth = i11;
            }
            if (intrinsicHeight > i11) {
                intrinsicWidth = (int) (intrinsicWidth * (i11 / intrinsicHeight));
            } else {
                i11 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i11);
        }
        setCompoundDrawables(drawable, null, null, null);
        b();
    }

    public void setItemInvoker(f.b bVar) {
        this.f985d = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i11, int i12, int i13, int i14) {
        this.f991k = i11;
        super.setPadding(i11, i12, i13, i14);
    }

    public void setPopupCallback(b bVar) {
        this.f987g = bVar;
    }

    public void setShortcut(boolean z11, char c11) {
    }

    public void setTitle(CharSequence charSequence) {
        this.f983b = charSequence;
        b();
    }

    public boolean showsIcon() {
        return true;
    }
}
