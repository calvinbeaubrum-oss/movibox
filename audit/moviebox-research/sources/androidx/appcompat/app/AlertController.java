package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class AlertController {
    public NestedScrollView A;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public Handler R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ListView f667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f672l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f673m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Button f675o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f676p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Message f677q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f678r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Button f679s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CharSequence f680t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Message f681u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f682v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Button f683w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f684x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Message f685y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f686z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f674n = false;
    public int B = 0;
    public int I = -1;
    public int Q = 0;
    public final View.OnClickListener S = new a();

    /* JADX INFO: compiled from: source.java */
    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f688b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.f688b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f687a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void setHasDecor(boolean z11, boolean z12) {
            if (z12 && z11) {
                return;
            }
            setPadding(getPaddingLeft(), z11 ? getPaddingTop() : this.f687a, getPaddingRight(), z12 ? getPaddingBottom() : this.f688b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.f675o && (message3 = alertController.f677q) != null) {
                messageObtain = Message.obtain(message3);
            } else if (view != alertController.f679s || (message2 = alertController.f681u) == null) {
                messageObtain = (view != alertController.f683w || (message = alertController.f685y) == null) ? null : Message.obtain(message);
            } else {
                messageObtain = Message.obtain(message2);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f662b).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements NestedScrollView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f691b;

        public b(View view, View view2) {
            this.f690a = view;
            this.f691b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.d
        public void a(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
            AlertController.f(nestedScrollView, this.f690a, this.f691b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f694b;

        public c(View view, View view2) {
            this.f693a = view;
            this.f694b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
            AlertController.f(absListView, this.f693a, this.f694b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i11) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f697b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f699d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f701f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f702g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f703h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f704i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Drawable f705j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f706k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f707l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Drawable f708m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f709n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public CharSequence f710o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Drawable f711p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f712q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f714s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f715t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f716u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public CharSequence[] f717v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public ListAdapter f718w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f719x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f720y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public View f721z;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f698c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f700e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean O = true;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f713r = true;

        /* JADX INFO: compiled from: source.java */
        public class a extends ArrayAdapter<CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f722a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, int i11, int i12, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i11, i12, charSequenceArr);
                this.f722a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i11, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i11, view, viewGroup);
                boolean[] zArr = d.this.F;
                if (zArr != null && zArr[i11]) {
                    this.f722a.setItemChecked(i11, true);
                }
                return view2;
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends CursorAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f724a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f725b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f726c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AlertController f727d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Context context, Cursor cursor, boolean z11, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z11);
                this.f726c = recycleListView;
                this.f727d = alertController;
                Cursor cursor2 = getCursor();
                this.f724a = cursor2.getColumnIndexOrThrow(d.this.L);
                this.f725b = cursor2.getColumnIndexOrThrow(d.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f724a));
                this.f726c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f725b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return d.this.f697b.inflate(this.f727d.M, viewGroup, false);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class c implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AlertController f729a;

            public c(AlertController alertController) {
                this.f729a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                d.this.f719x.onClick(this.f729a.f662b, i11);
                if (d.this.H) {
                    return;
                }
                this.f729a.f662b.dismiss();
            }
        }

        /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$d$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0028d implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f731a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AlertController f732b;

            public C0028d(RecycleListView recycleListView, AlertController alertController) {
                this.f731a = recycleListView;
                this.f732b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                boolean[] zArr = d.this.F;
                if (zArr != null) {
                    zArr[i11] = this.f731a.isItemChecked(i11);
                }
                d.this.J.onClick(this.f732b.f662b, i11, this.f731a.isItemChecked(i11));
            }
        }

        public d(Context context) {
            this.f696a = context;
            this.f697b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.f702g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f701f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f699d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i11 = this.f698c;
                if (i11 != 0) {
                    alertController.m(i11);
                }
                int i12 = this.f700e;
                if (i12 != 0) {
                    alertController.m(alertController.c(i12));
                }
            }
            CharSequence charSequence2 = this.f703h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f704i;
            if (charSequence3 != null || this.f705j != null) {
                alertController.k(-1, charSequence3, this.f706k, null, this.f705j);
            }
            CharSequence charSequence4 = this.f707l;
            if (charSequence4 != null || this.f708m != null) {
                alertController.k(-2, charSequence4, this.f709n, null, this.f708m);
            }
            CharSequence charSequence5 = this.f710o;
            if (charSequence5 != null || this.f711p != null) {
                alertController.k(-3, charSequence5, this.f712q, null, this.f711p);
            }
            if (this.f717v != null || this.K != null || this.f718w != null) {
                b(alertController);
            }
            View view2 = this.f721z;
            if (view2 != null) {
                if (this.E) {
                    alertController.t(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i13 = this.f720y;
            if (i13 != 0) {
                alertController.r(i13);
            }
        }

        public final void b(AlertController alertController) {
            ListAdapter fVar;
            RecycleListView recycleListView = (RecycleListView) this.f697b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                fVar = this.K == null ? new a(this.f696a, alertController.M, R.id.text1, this.f717v, recycleListView) : new b(this.f696a, this.K, false, recycleListView, alertController);
            } else {
                int i11 = this.H ? alertController.N : alertController.O;
                if (this.K != null) {
                    fVar = new SimpleCursorAdapter(this.f696a, i11, this.K, new String[]{this.L}, new int[]{R.id.text1});
                } else {
                    fVar = this.f718w;
                    if (fVar == null) {
                        fVar = new f(this.f696a, i11, R.id.text1, this.f717v);
                    }
                }
            }
            alertController.H = fVar;
            alertController.I = this.I;
            if (this.f719x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new C0028d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f667g = recycleListView;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f734a;

        public e(DialogInterface dialogInterface) {
            this.f734a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == -3 || i11 == -2 || i11 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f734a.get(), message.what);
            } else {
                if (i11 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends ArrayAdapter<CharSequence> {
        public f(Context context, int i11, int i12, CharSequence[] charSequenceArr) {
            super(context, i11, i12, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, w wVar, Window window) {
        this.f661a = context;
        this.f662b = wVar;
        this.f663c = window;
        this.R = new e(wVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.J = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.P = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f664d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        wVar.i(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void f(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public int c(int i11) {
        TypedValue typedValue = new TypedValue();
        this.f661a.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f667g;
    }

    public void e() {
        this.f662b.setContentView(j());
        y();
    }

    public boolean g(int i11, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean h(int i11, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    @Nullable
    public final ViewGroup i(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final int j() {
        int i11 = this.K;
        return (i11 != 0 && this.Q == 1) ? i11 : this.J;
    }

    public void k(int i11, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i11, onClickListener);
        }
        if (i11 == -3) {
            this.f684x = charSequence;
            this.f685y = message;
            this.f686z = drawable;
        } else if (i11 == -2) {
            this.f680t = charSequence;
            this.f681u = message;
            this.f682v = drawable;
        } else {
            if (i11 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f676p = charSequence;
            this.f677q = message;
            this.f678r = drawable;
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i11) {
        this.C = null;
        this.B = i11;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i11 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void o(CharSequence charSequence) {
        this.f666f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void p(ViewGroup viewGroup, View view, int i11, int i12) {
        final View viewFindViewById = this.f663c.findViewById(R$id.scrollIndicatorUp);
        final View viewFindViewById2 = this.f663c.findViewById(R$id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, i11, i12);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (i11 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (i11 & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f666f != null) {
            this.A.setOnScrollChangeListener(new b(viewFindViewById, viewFindViewById2));
            this.A.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.3
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.f(AlertController.this.A, viewFindViewById, viewFindViewById2);
                }
            });
            return;
        }
        ListView listView = this.f667g;
        if (listView != null) {
            listView.setOnScrollListener(new c(viewFindViewById, viewFindViewById2));
            this.f667g.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.5
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.f(AlertController.this.f667g, viewFindViewById, viewFindViewById2);
                }
            });
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    public void q(CharSequence charSequence) {
        this.f665e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i11) {
        this.f668h = null;
        this.f669i = i11;
        this.f674n = false;
    }

    public void s(View view) {
        this.f668h = view;
        this.f669i = 0;
        this.f674n = false;
    }

    public void t(View view, int i11, int i12, int i13, int i14) {
        this.f668h = view;
        this.f669i = 0;
        this.f674n = true;
        this.f670j = i11;
        this.f671k = i12;
        this.f672l = i13;
        this.f673m = i14;
    }

    public final void u(ViewGroup viewGroup) {
        int i11;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f675o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f676p) && this.f678r == null) {
            this.f675o.setVisibility(8);
            i11 = 0;
        } else {
            this.f675o.setText(this.f676p);
            Drawable drawable = this.f678r;
            if (drawable != null) {
                int i12 = this.f664d;
                drawable.setBounds(0, 0, i12, i12);
                this.f675o.setCompoundDrawables(this.f678r, null, null, null);
            }
            this.f675o.setVisibility(0);
            i11 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f679s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f680t) && this.f682v == null) {
            this.f679s.setVisibility(8);
        } else {
            this.f679s.setText(this.f680t);
            Drawable drawable2 = this.f682v;
            if (drawable2 != null) {
                int i13 = this.f664d;
                drawable2.setBounds(0, 0, i13, i13);
                this.f679s.setCompoundDrawables(this.f682v, null, null, null);
            }
            this.f679s.setVisibility(0);
            i11 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f683w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f684x) && this.f686z == null) {
            this.f683w.setVisibility(8);
        } else {
            this.f683w.setText(this.f684x);
            Drawable drawable3 = this.f686z;
            if (drawable3 != null) {
                int i14 = this.f664d;
                drawable3.setBounds(0, 0, i14, i14);
                this.f683w.setCompoundDrawables(this.f686z, null, null, null);
            }
            this.f683w.setVisibility(0);
            i11 |= 4;
        }
        if (z(this.f661a)) {
            if (i11 == 1) {
                b(this.f675o);
            } else if (i11 == 2) {
                b(this.f679s);
            } else if (i11 == 4) {
                b(this.f683w);
            }
        }
        if (i11 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f663c.findViewById(R$id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f666f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f667g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f667g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void w(ViewGroup viewGroup) {
        View viewInflate = this.f668h;
        if (viewInflate == null) {
            viewInflate = this.f669i != 0 ? LayoutInflater.from(this.f661a).inflate(this.f669i, viewGroup, false) : null;
        }
        boolean z11 = viewInflate != null;
        if (!z11 || !a(viewInflate)) {
            this.f663c.setFlags(131072, 131072);
        }
        if (!z11) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f663c.findViewById(R$id.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f674n) {
            frameLayout.setPadding(this.f670j, this.f671k, this.f672l, this.f673m);
        }
        if (this.f667g != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    public final void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f663c.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f663c.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f665e)) || !this.P) {
            this.f663c.findViewById(R$id.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f663c.findViewById(R$id.alertTitle);
        this.E = textView;
        textView.setText(this.f665e);
        int i11 = this.B;
        if (i11 != 0) {
            this.D.setImageResource(i11);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f663c.findViewById(R$id.parentPanel);
        View viewFindViewById4 = viewFindViewById3.findViewById(R$id.topPanel);
        View viewFindViewById5 = viewFindViewById3.findViewById(R$id.contentPanel);
        View viewFindViewById6 = viewFindViewById3.findViewById(R$id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R$id.customPanel);
        w(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(R$id.topPanel);
        View viewFindViewById8 = viewGroup.findViewById(R$id.contentPanel);
        View viewFindViewById9 = viewGroup.findViewById(R$id.buttonPanel);
        ViewGroup viewGroupI = i(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupI2 = i(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupI3 = i(viewFindViewById9, viewFindViewById6);
        v(viewGroupI2);
        u(viewGroupI3);
        x(viewGroupI);
        boolean z11 = viewGroup.getVisibility() != 8;
        boolean z12 = (viewGroupI == null || viewGroupI.getVisibility() == 8) ? 0 : 1;
        boolean z13 = (viewGroupI3 == null || viewGroupI3.getVisibility() == 8) ? false : true;
        if (!z13 && viewGroupI2 != null && (viewFindViewById2 = viewGroupI2.findViewById(R$id.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z12 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f666f == null && this.f667g == null) ? null : viewGroupI.findViewById(R$id.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupI2 != null && (viewFindViewById = viewGroupI2.findViewById(R$id.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f667g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z12, z13);
        }
        if (!z11) {
            View view = this.f667g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                p(viewGroupI2, view, z12 | (z13 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f667g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i11 = this.I;
        if (i11 > -1) {
            listView2.setItemChecked(i11, true);
            listView2.setSelection(i11);
        }
    }
}
