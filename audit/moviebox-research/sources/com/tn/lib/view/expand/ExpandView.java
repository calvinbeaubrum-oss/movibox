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
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.R$styleable;
import com.tn.lib.widget.TnTextView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class ExpandView extends TnTextView {
    public static final int STATE_EXPAND = 1;
    public static final int STATE_SHRINK = 0;
    public c A;
    public String B;
    public String C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f49837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f49838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f49839d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f49840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f49841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f49842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f49843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f49844j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f49845k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f49846l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f49847m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f49848n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f49849o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f49850p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f49851q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f49852r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f49853s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f49854t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f49855u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ClickableSpan f49856v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public vp.a f49857w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public vp.a f49858x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Layout f49859y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f49860z;

    /* JADX INFO: compiled from: source.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ExpandView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ExpandView expandView = ExpandView.this;
            expandView.l(expandView.f49860z);
            ExpandView.this.f49846l = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(ExpandView expandView);

        void b(ExpandView expandView);
    }

    public ExpandView(Context context) {
        this(context, null);
    }

    public ExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49840f = "  ";
        this.f49841g = "  ";
        this.f49842h = false;
        this.f49843i = true;
        this.f49844j = true;
        this.f49845k = true;
        this.f49846l = false;
        this.f49847m = 1;
        this.f49848n = -1711276033;
        this.f49849o = -1711276033;
        this.f49850p = 872415231;
        this.f49851q = 872415231;
        this.f49852r = -1;
        this.f49853s = 0;
        this.f49855u = true;
        j(context, attributeSet);
    }

    public ExpandView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f49840f = "  ";
        this.f49841g = "  ";
        this.f49842h = false;
        this.f49843i = true;
        this.f49844j = true;
        this.f49845k = true;
        this.f49846l = false;
        this.f49847m = 1;
        this.f49848n = -1711276033;
        this.f49849o = -1711276033;
        this.f49850p = 872415231;
        this.f49851q = 872415231;
        this.f49852r = -1;
        this.f49853s = 0;
        this.f49855u = true;
        j(context, attributeSet);
    }

    private CharSequence g(int i11) {
        String str;
        int i12;
        TextPaint paint = getPaint();
        if (this.f49860z != null) {
            str = "" + ((Object) this.f49860z);
        } else {
            str = "";
        }
        if (this.f49859y == null) {
            this.f49859y = new StaticLayout(str, paint, i11, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        int lineCount = this.f49859y.getLineCount();
        int i13 = this.f49847m;
        if (lineCount <= i13) {
            CharSequence charSequence = this.f49860z;
            if (charSequence == null) {
                charSequence = " ";
            }
            return n(new SpannableStringBuilder(charSequence));
        }
        int i14 = this.f49853s;
        if (i14 != 0) {
            if (i14 != 1 || !this.f49845k) {
                return n(new SpannableStringBuilder(this.f49860z));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f49860z);
            spannableStringBuilder.append((CharSequence) this.f49841g).append((CharSequence) this.f49839d);
            int length = (spannableStringBuilder.length() - this.f49841g.length()) - this.f49839d.length();
            int length2 = spannableStringBuilder.length();
            i12 = length >= 0 ? length : 0;
            spannableStringBuilder.setSpan(this.f49856v, i12, length2, 33);
            spannableStringBuilder.setSpan(this.f49857w, i12, length2, 33);
            return n(spannableStringBuilder);
        }
        int iH = h(str, paint, this.f49859y.getLineStart(this.f49847m - 1), this.f49859y.getLineEnd(i13 - 1), i11);
        CharSequence charSequence2 = this.f49860z;
        if (charSequence2 != null && charSequence2.length() <= iH) {
            iH = this.f49860z.length() - 1;
        }
        CharSequence charSequence3 = this.f49860z;
        if (charSequence3 == null || iH <= 0) {
            return charSequence3;
        }
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder(charSequence3.subSequence(0, iH)).append((CharSequence) this.f49837b);
        if (this.f49844j) {
            spannableStringBuilderAppend.append((CharSequence) this.f49840f);
            spannableStringBuilderAppend.append((CharSequence) this.f49838c);
            int length3 = (spannableStringBuilderAppend.length() - this.f49840f.length()) - this.f49838c.length();
            int length4 = spannableStringBuilderAppend.length();
            i12 = length3 >= 0 ? length3 : 0;
            spannableStringBuilderAppend.setSpan(this.f49856v, i12, length4, 33);
            spannableStringBuilderAppend.setSpan(this.f49858x, i12, length4, 33);
        }
        return n(spannableStringBuilderAppend);
    }

    private int getLayoutWidth() {
        Layout layout = getLayout();
        int width = layout != null ? layout.getWidth() : 0;
        return (width > 0 || getWidth() == 0) ? width : (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int h(String str, TextPaint textPaint, int i11, int i12, int i13) {
        String str2;
        vp.a aVar = this.f49858x;
        String str3 = this.f49837b;
        if (this.f49844j) {
            str2 = this.f49838c + this.f49840f;
        } else {
            str2 = "";
        }
        return textPaint.breakText(str, i11, i12, true, i13 - aVar.e(textPaint, str3, str2), null) + i11;
    }

    private void i() {
        if (this.f49854t == 0.0f) {
            this.f49854t = getTextSize();
        }
        boolean z11 = getLayoutDirection() == 1;
        this.f49858x = new vp.a(getContext(), this.f49855u ? R$mipmap.info_player_ic_expand : -111, this.f49848n, this.f49850p, this.f49854t, 5, z11);
        this.f49857w = new vp.a(getContext(), this.f49855u ? R$mipmap.info_player_ic_collapse : -111, this.f49849o, this.f49851q, this.f49854t, 5, z11);
        setMovementMethod(new LinkMovementMethod());
        if (TextUtils.isEmpty(this.f49837b)) {
            this.f49837b = "...";
        }
        if (TextUtils.isEmpty(this.f49838c)) {
            this.f49838c = getResources().getString(R$string.player_more);
        }
        if (TextUtils.isEmpty(this.f49839d)) {
            this.f49839d = getResources().getString(R$string.player_hide);
        }
        if (this.f49840f == null) {
            this.f49840f = "  ";
        }
        if (this.f49841g == null) {
            this.f49841g = "  ";
        }
        setOnClickListener(new View.OnClickListener() { // from class: vp.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f79045a.k(view);
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void j(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            i();
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandView);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.ExpandView_pop_hint_text_size) {
                this.f49854t = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == R$styleable.ExpandView_pop_reverse_Lines) {
                this.f49847m = typedArrayObtainStyledAttributes.getInteger(index, 1);
            } else if (index == R$styleable.ExpandView_pop_ellipsis) {
                this.f49837b = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_expand_hint) {
                this.f49838c = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint) {
                this.f49839d = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_toggle_enabled) {
                this.f49842h = typedArrayObtainStyledAttributes.getBoolean(index, this.f49842h);
            } else if (index == R$styleable.ExpandView_pop_show_expand_hint) {
                this.f49844j = typedArrayObtainStyledAttributes.getBoolean(index, this.f49844j);
            } else if (index == R$styleable.ExpandView_pop_show_shrink_hint) {
                this.f49845k = typedArrayObtainStyledAttributes.getBoolean(index, this.f49845k);
            } else if (index == R$styleable.ExpandView_pop_expand_hint_color) {
                this.f49848n = typedArrayObtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint_color) {
                this.f49849o = typedArrayObtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_expand_bg_Color) {
                this.f49850p = typedArrayObtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R$styleable.ExpandView_pop_shrink_bg_color) {
                this.f49851q = typedArrayObtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R$styleable.ExpandView_pop_Init_state) {
                this.f49853s = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.ExpandView_pop_expand_gap) {
                this.f49840f = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_collapse_gap) {
                this.f49841g = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_hash_tag_color) {
                this.f49852r = typedArrayObtainStyledAttributes.getInteger(index, this.f49852r);
            } else if (index == R$styleable.ExpandView_pop_show_hint_icon) {
                this.f49855u = typedArrayObtainStyledAttributes.getBoolean(index, true);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        o();
    }

    private CharSequence n(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder;
    }

    private void o() {
        if (getText().toString().contains(this.f49838c) || getText().toString().contains(this.f49839d)) {
            int i11 = this.f49853s;
            if (i11 == 0) {
                this.f49853s = 1;
                c cVar = this.A;
                if (cVar != null) {
                    cVar.b(this);
                }
            } else if (i11 == 1) {
                this.f49853s = 0;
                c cVar2 = this.A;
                if (cVar2 != null) {
                    cVar2.a(this);
                }
            }
            l(this.f49860z);
        }
    }

    public void addLegacyHashTag(String str, String str2) {
        this.C = str;
        this.B = str2;
    }

    @Override // com.tn.lib.widget.TnTextView, bs.a
    public void changeLocal() {
        this.f49838c = getResources().getString(R$string.player_more);
        this.f49839d = getResources().getString(R$string.player_hide);
        super.changeLocal();
    }

    public int getExpandState() {
        return this.f49853s;
    }

    public boolean isOutLines() {
        Layout layout = this.f49859y;
        return layout != null && layout.getLineCount() > this.f49847m;
    }

    public final /* synthetic */ CharSequence m(final CharSequence charSequence) {
        if (!this.f49843i) {
            return charSequence;
        }
        if (!TextUtils.equals(charSequence, this.f49860z)) {
            this.f49859y = null;
        }
        this.f49860z = charSequence;
        int layoutWidth = getLayoutWidth();
        if (layoutWidth > 0) {
            return this.f49860z == null ? charSequence : g(layoutWidth);
        }
        if (this.f49846l) {
            postDelayed(new Runnable() { // from class: vp.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f79046a.l(charSequence);
                }
            }, 100L);
        }
        return null;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void reset() {
        this.f49853s = 0;
        c cVar = this.A;
        if (cVar != null) {
            cVar.a(this);
        }
        l(this.f49860z);
    }

    public void setCollapseEnable(boolean z11) {
        this.f49843i = z11;
    }

    public void setExpandListener(c cVar) {
        this.A = cVar;
    }

    public void setOnClickHashTagListener(b bVar) {
    }

    /* JADX INFO: renamed from: setTitle, reason: merged with bridge method [inline-methods] */
    public void l(final CharSequence charSequence) {
        setTextAction(new Function0() { // from class: vp.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f79043a.m(charSequence);
            }
        });
    }
}
