package com.tn.lib.view.expand;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class SubjectExpandView extends AppCompatTextView {
    public static final int STATE_EXPAND = 1;
    public static final int STATE_SHRINK = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f49862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f49863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f49864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f49865d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f49866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f49867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f49868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f49869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f49870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f49871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f49872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f49873m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f49874n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f49875o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f49876p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f49877q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f49878r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f49879s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public vp.a f49880t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public vp.a f49881u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Layout f49882v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f49883w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ClickableSpan f49884x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f49885y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f49886z;

    /* JADX INFO: compiled from: source.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            SubjectExpandView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            SubjectExpandView subjectExpandView = SubjectExpandView.this;
            subjectExpandView.j(subjectExpandView.f49883w);
            SubjectExpandView.this.f49871k = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
    }

    public SubjectExpandView(Context context) {
        this(context, null);
    }

    public SubjectExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49865d = "  ";
        this.f49866f = "  ";
        this.f49867g = false;
        this.f49868h = true;
        this.f49869i = true;
        this.f49870j = true;
        this.f49871k = false;
        this.f49872l = 1;
        this.f49873m = -1711276033;
        this.f49874n = -1711276033;
        this.f49875o = 872415231;
        this.f49876p = 872415231;
        this.f49877q = -1;
        this.f49878r = 0;
        this.f49885y = false;
        this.f49886z = false;
        h(context, attributeSet);
    }

    public SubjectExpandView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f49865d = "  ";
        this.f49866f = "  ";
        this.f49867g = false;
        this.f49868h = true;
        this.f49869i = true;
        this.f49870j = true;
        this.f49871k = false;
        this.f49872l = 1;
        this.f49873m = -1711276033;
        this.f49874n = -1711276033;
        this.f49875o = 872415231;
        this.f49876p = 872415231;
        this.f49877q = -1;
        this.f49878r = 0;
        this.f49885y = false;
        this.f49886z = false;
        h(context, attributeSet);
    }

    private void g() {
        if (this.f49879s == 0.0f) {
            this.f49879s = getTextSize();
        }
        boolean z11 = getLayoutDirection() == 1;
        this.f49881u = new vp.a(getContext(), R$mipmap.info_player_ic_expand, this.f49873m, this.f49875o, this.f49879s, 5, z11);
        this.f49880t = new vp.a(getContext(), R$mipmap.info_player_ic_collapse, this.f49874n, this.f49876p, this.f49879s, 5, z11);
        setMovementMethod(new LinkMovementMethod());
        if (TextUtils.isEmpty(this.f49862a)) {
            this.f49862a = "...";
        }
        if (TextUtils.isEmpty(this.f49863b)) {
            this.f49863b = getResources().getString(R$string.player_more);
        }
        if (TextUtils.isEmpty(this.f49864c)) {
            this.f49864c = getResources().getString(R$string.player_hide);
        }
        if (this.f49865d == null) {
            this.f49865d = "  ";
        }
        if (this.f49866f == null) {
            this.f49866f = "  ";
        }
        setOnClickListener(new View.OnClickListener() { // from class: vp.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f79048a.i(view);
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private int getLayoutWidth() {
        Layout layout = getLayout();
        int width = layout != null ? layout.getWidth() : 0;
        return (width > 0 || getWidth() == 0) ? width : (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void l() {
        if (getText().toString().contains(this.f49863b) || getText().toString().contains(this.f49864c) || this.f49886z) {
            int i11 = this.f49878r;
            if (i11 == 0) {
                this.f49878r = 1;
            } else if (i11 == 1) {
                this.f49878r = 0;
            }
            j(this.f49883w);
        }
    }

    public final CharSequence e(int i11) {
        String str;
        int i12;
        TextPaint paint = getPaint();
        if (this.f49883w != null) {
            str = "" + ((Object) this.f49883w);
        } else {
            str = "";
        }
        if (this.f49882v == null) {
            this.f49882v = new StaticLayout(str, paint, i11, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        int lineCount = this.f49882v.getLineCount();
        int i13 = this.f49872l;
        if (lineCount <= i13) {
            CharSequence charSequence = this.f49883w;
            if (charSequence == null) {
                charSequence = " ";
            }
            return k(new SpannableStringBuilder(charSequence));
        }
        int i14 = this.f49878r;
        if (i14 != 0) {
            if (i14 != 1 || !this.f49870j) {
                return k(new SpannableStringBuilder(this.f49883w));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f49883w);
            spannableStringBuilder.append((CharSequence) this.f49866f).append((CharSequence) this.f49864c);
            int length = (spannableStringBuilder.length() - this.f49866f.length()) - this.f49864c.length();
            int length2 = spannableStringBuilder.length();
            i12 = length >= 0 ? length : 0;
            spannableStringBuilder.setSpan(this.f49884x, i12, length2, 33);
            spannableStringBuilder.setSpan(this.f49880t, i12, length2, 33);
            return k(spannableStringBuilder);
        }
        int iF = f(str, paint, this.f49882v.getLineStart(this.f49872l - 1), this.f49882v.getLineEnd(i13 - 1), i11);
        CharSequence charSequence2 = this.f49883w;
        if (charSequence2 != null && charSequence2.length() <= iF) {
            iF = this.f49883w.length() - 1;
        }
        CharSequence charSequence3 = this.f49883w;
        if (charSequence3 == null || iF <= 0) {
            return charSequence3;
        }
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder(charSequence3.length() > 180 ? this.f49883w.subSequence(0, 180) : this.f49883w).append((CharSequence) this.f49862a);
        if (this.f49869i) {
            spannableStringBuilderAppend.append((CharSequence) this.f49865d);
            spannableStringBuilderAppend.append((CharSequence) this.f49863b);
            int length3 = (spannableStringBuilderAppend.length() - this.f49865d.length()) - this.f49863b.length();
            int length4 = spannableStringBuilderAppend.length();
            i12 = length3 >= 0 ? length3 : 0;
            spannableStringBuilderAppend.setSpan(this.f49884x, i12, length4, 33);
            spannableStringBuilderAppend.setSpan(this.f49881u, i12, length4, 33);
        }
        return k(spannableStringBuilderAppend);
    }

    public final int f(String str, TextPaint textPaint, int i11, int i12, int i13) {
        String str2;
        vp.a aVar = this.f49881u;
        String str3 = this.f49862a;
        if (this.f49869i) {
            str2 = this.f49863b + this.f49865d;
        } else {
            str2 = "";
        }
        return textPaint.breakText(str, i11, i12, true, i13 - aVar.e(textPaint, str3, str2), null) + i11;
    }

    public int getExpandState() {
        return this.f49878r;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            g();
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandView);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.ExpandView_pop_hint_text_size) {
                this.f49879s = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == R$styleable.ExpandView_pop_reverse_Lines) {
                this.f49872l = typedArrayObtainStyledAttributes.getInteger(index, 1);
            } else if (index == R$styleable.ExpandView_pop_ellipsis) {
                this.f49862a = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_expand_hint) {
                this.f49863b = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint) {
                this.f49864c = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_toggle_enabled) {
                this.f49867g = typedArrayObtainStyledAttributes.getBoolean(index, this.f49867g);
            } else if (index == R$styleable.ExpandView_pop_show_expand_hint) {
                this.f49869i = typedArrayObtainStyledAttributes.getBoolean(index, this.f49869i);
            } else if (index == R$styleable.ExpandView_pop_show_shrink_hint) {
                this.f49870j = typedArrayObtainStyledAttributes.getBoolean(index, this.f49870j);
            } else if (index == R$styleable.ExpandView_pop_expand_hint_color) {
                this.f49873m = typedArrayObtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint_color) {
                this.f49874n = typedArrayObtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_expand_bg_Color) {
                this.f49875o = typedArrayObtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R$styleable.ExpandView_pop_shrink_bg_color) {
                this.f49876p = typedArrayObtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R$styleable.ExpandView_pop_Init_state) {
                this.f49878r = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.ExpandView_pop_expand_gap) {
                this.f49865d = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_collapse_gap) {
                this.f49866f = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_hash_tag_color) {
                this.f49877q = typedArrayObtainStyledAttributes.getInteger(index, this.f49877q);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        g();
    }

    public final /* synthetic */ void i(View view) {
        l();
    }

    public boolean isOutLines() {
        Layout layout = this.f49882v;
        return layout != null && layout.getLineCount() > this.f49872l;
    }

    public final CharSequence k(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void reset() {
        this.f49878r = 0;
        j(this.f49883w);
    }

    public void setCollapseEnable(boolean z11) {
        this.f49868h = z11;
    }

    public void setExpandListener(b bVar) {
    }

    public void setHasStarring(boolean z11) {
        this.f49885y = z11;
    }

    public void setShrink(boolean z11) {
        this.f49886z = z11;
        if (z11) {
            this.f49878r = 1;
            l();
            this.f49886z = false;
        }
    }

    /* JADX INFO: renamed from: setTitle, reason: merged with bridge method [inline-methods] */
    public void j(final CharSequence charSequence) {
        if (!this.f49868h) {
            super.setText(charSequence);
            return;
        }
        if (!TextUtils.equals(charSequence, this.f49883w)) {
            this.f49882v = null;
        }
        this.f49883w = charSequence;
        int layoutWidth = getLayoutWidth();
        if (this.f49885y) {
            if (this.f49878r == 1) {
                super.setText(charSequence);
                return;
            }
            if (this.f49883w != null) {
                charSequence = e(layoutWidth);
            }
            super.setText(charSequence);
            return;
        }
        if (layoutWidth > 0) {
            if (this.f49883w != null) {
                charSequence = e(layoutWidth);
            }
            super.setText(charSequence);
        } else if (this.f49871k) {
            postDelayed(new Runnable() { // from class: vp.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f79049a.j(charSequence);
                }
            }, 100L);
        }
    }
}
