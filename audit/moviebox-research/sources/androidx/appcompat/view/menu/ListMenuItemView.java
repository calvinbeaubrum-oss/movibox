package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.n0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ListMenuItemView extends LinearLayout implements m.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f1027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f1028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f1029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f1030d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CheckBox f1031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f1032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f1033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f1034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f1035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f1036k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1037l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Context f1038m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1039n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f1040o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1041p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LayoutInflater f1042q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1043r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet);
        n0 n0VarV = n0.v(getContext(), attributeSet, R$styleable.MenuView, i11, 0);
        this.f1036k = n0VarV.g(R$styleable.MenuView_android_itemBackground);
        this.f1037l = n0VarV.n(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f1039n = n0VarV.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.f1038m = context;
        this.f1040o = n0VarV.g(R$styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, R$attr.dropDownListViewStyle, 0);
        this.f1041p = typedArrayObtainStyledAttributes.hasValue(0);
        n0VarV.x();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f1042q == null) {
            this.f1042q = LayoutInflater.from(getContext());
        }
        return this.f1042q;
    }

    private void setSubMenuArrowVisible(boolean z11) {
        ImageView imageView = this.f1033h;
        if (imageView != null) {
            imageView.setVisibility(z11 ? 0 : 8);
        }
    }

    public final void a(View view) {
        b(view, -1);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1034i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1034i.getLayoutParams();
        rect.top += this.f1034i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void b(View view, int i11) {
        LinearLayout linearLayout = this.f1035j;
        if (linearLayout != null) {
            linearLayout.addView(view, i11);
        } else {
            addView(view, i11);
        }
    }

    public final void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f1031f = checkBox;
        a(checkBox);
    }

    public final void d() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f1028b = imageView;
        b(imageView, 0);
    }

    public final void e() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f1029c = radioButton;
        a(radioButton);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public h getItemData() {
        return this.f1027a;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void initialize(h hVar, int i11) {
        this.f1027a = hVar;
        setVisibility(hVar.isVisible() ? 0 : 8);
        setTitle(hVar.i(this));
        setCheckable(hVar.isCheckable());
        setShortcut(hVar.A(), hVar.g());
        setIcon(hVar.getIcon());
        setEnabled(hVar.isEnabled());
        setSubMenuArrowVisible(hVar.hasSubMenu());
        setContentDescription(hVar.getContentDescription());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f1036k);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f1030d = textView;
        int i11 = this.f1037l;
        if (i11 != -1) {
            textView.setTextAppearance(this.f1038m, i11);
        }
        this.f1032g = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f1033h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1040o);
        }
        this.f1034i = (ImageView) findViewById(R$id.group_divider);
        this.f1035j = (LinearLayout) findViewById(R$id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        if (this.f1028b != null && this.f1039n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1028b.getLayoutParams();
            int i13 = layoutParams.height;
            if (i13 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i13;
            }
        }
        super.onMeasure(i11, i12);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z11) {
        CompoundButton compoundButton;
        View view;
        if (!z11 && this.f1029c == null && this.f1031f == null) {
            return;
        }
        if (this.f1027a.m()) {
            if (this.f1029c == null) {
                e();
            }
            compoundButton = this.f1029c;
            view = this.f1031f;
        } else {
            if (this.f1031f == null) {
                c();
            }
            compoundButton = this.f1031f;
            view = this.f1029c;
        }
        if (z11) {
            compoundButton.setChecked(this.f1027a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f1031f;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1029c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z11) {
        CompoundButton compoundButton;
        if (this.f1027a.m()) {
            if (this.f1029c == null) {
                e();
            }
            compoundButton = this.f1029c;
        } else {
            if (this.f1031f == null) {
                c();
            }
            compoundButton = this.f1031f;
        }
        compoundButton.setChecked(z11);
    }

    public void setForceShowIcon(boolean z11) {
        this.f1043r = z11;
        this.f1039n = z11;
    }

    public void setGroupDividerEnabled(boolean z11) {
        ImageView imageView = this.f1034i;
        if (imageView != null) {
            imageView.setVisibility((this.f1041p || !z11) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z11 = this.f1027a.z() || this.f1043r;
        if (z11 || this.f1039n) {
            ImageView imageView = this.f1028b;
            if (imageView == null && drawable == null && !this.f1039n) {
                return;
            }
            if (imageView == null) {
                d();
            }
            if (drawable == null && !this.f1039n) {
                this.f1028b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f1028b;
            if (!z11) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f1028b.getVisibility() != 0) {
                this.f1028b.setVisibility(0);
            }
        }
    }

    public void setShortcut(boolean z11, char c11) {
        int i11 = (z11 && this.f1027a.A()) ? 0 : 8;
        if (i11 == 0) {
            this.f1032g.setText(this.f1027a.h());
        }
        if (this.f1032g.getVisibility() != i11) {
            this.f1032g.setVisibility(i11);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f1030d.getVisibility() != 8) {
                this.f1030d.setVisibility(8);
            }
        } else {
            this.f1030d.setText(charSequence);
            if (this.f1030d.getVisibility() != 0) {
                this.f1030d.setVisibility(0);
            }
        }
    }

    public boolean showsIcon() {
        return this.f1043r;
    }
}
