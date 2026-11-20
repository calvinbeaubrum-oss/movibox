package OooO0o0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import com.cloud.tmc.miniapp.dialog.BottomActionSheetDialog$ActionItem;
import com.cloud.tmc.miniapp.widget.q;
import id.h;
import j.f;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class OooOO0O extends OooO0o0.OooO0OO.OooO00o<OooOO0O> {
    public f A;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f52t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f53u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f54v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f55w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f56x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f57y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final OooO0o0.OooO f58z;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<View> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return OooOO0O.this.findViewById(R$id.view_padding1);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<RecyclerView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public RecyclerView invoke() {
            return (RecyclerView) OooOO0O.this.findViewById(R$id.rv_action_items);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<AppCompatTextView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatTextView invoke() {
            return (AppCompatTextView) OooOO0O.this.findViewById(R$id.tv_desc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<AppCompatTextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatTextView invoke() {
            return (AppCompatTextView) OooOO0O.this.findViewById(R$id.tv_title);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<View> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return OooOO0O.this.findViewById(R$id.view_padding2);
        }
    }

    /* JADX INFO: renamed from: OooO0o0.OooOO0O$OooOO0O, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0005OooOO0O extends Lambda implements Function0<View> {
        public C0005OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return OooOO0O.this.findViewById(R$id.view_padding3);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements BaseAdapter.d {
        public a() {
        }

        @Override // com.cloud.tmc.miniapp.base.BaseAdapter.d
        public void onItemClick(RecyclerView recyclerView, View view, int i11) {
            BottomActionSheetDialog$ActionItem item = OooOO0O.this.f58z.getItem(i11);
            if (Intrinsics.b(item.getId(), "Cancel")) {
                OooOO0O.this.l();
                return;
            }
            if (item.getEnable()) {
                OooOO0O.this.l();
                f fVar = OooOO0O.this.A;
                if (fVar != null) {
                    fVar.a(i11, item);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooOO0O(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f52t = LazyKt__LazyJVMKt.b(new OooO());
        this.f53u = LazyKt__LazyJVMKt.b(new OooOO0());
        this.f54v = LazyKt__LazyJVMKt.b(new C0005OooOO0O());
        this.f55w = LazyKt__LazyJVMKt.b(new OooO0o());
        this.f56x = LazyKt__LazyJVMKt.b(new OooO0OO());
        this.f57y = LazyKt__LazyJVMKt.b(new OooO0O0());
        OooO0o0.OooO oooO = new OooO0o0.OooO(context);
        this.f58z = oooO;
        j(R$layout.mini_layout_bottom_action_sheet_dialog);
        g(true);
        a(0.1f);
        oooO.q(new a());
        RecyclerView recyclerViewW = w();
        if (recyclerViewW == null) {
            return;
        }
        recyclerViewW.setAdapter(oooO);
    }

    public final View A() {
        return (View) this.f54v.getValue();
    }

    @Override // OooO0o0.OooO0OO.OooO00o
    public void q() {
        AppCompatTextView appCompatTextViewY;
        AppCompatTextView appCompatTextViewX;
        AppCompatTextView appCompatTextViewX2;
        AppCompatTextView appCompatTextViewX3;
        AppCompatTextView appCompatTextViewX4;
        AppCompatTextView appCompatTextViewX5;
        AppCompatTextView appCompatTextViewY2 = y();
        if (appCompatTextViewY2 == null || !i.a(appCompatTextViewY2) || (appCompatTextViewX5 = x()) == null || !i.a(appCompatTextViewX5)) {
            AppCompatTextView appCompatTextViewY3 = y();
            if ((appCompatTextViewY3 == null || !i.a(appCompatTextViewY3) || (appCompatTextViewX3 = x()) == null || i.a(appCompatTextViewX3)) && ((appCompatTextViewY = y()) == null || i.a(appCompatTextViewY) || (appCompatTextViewX2 = x()) == null || !i.a(appCompatTextViewX2))) {
                AppCompatTextView appCompatTextViewY4 = y();
                if (appCompatTextViewY4 != null && !i.a(appCompatTextViewY4) && (appCompatTextViewX = x()) != null && !i.a(appCompatTextViewX)) {
                    View viewV = v();
                    if (viewV != null) {
                        i.c(viewV);
                    }
                    View viewZ = z();
                    if (viewZ != null) {
                        i.c(viewZ);
                    }
                    View viewA = A();
                    if (viewA != null) {
                        i.c(viewA);
                    }
                }
            } else {
                View viewV2 = v();
                if (viewV2 != null) {
                    i.e(viewV2);
                }
                View viewZ2 = z();
                if (viewZ2 != null) {
                    i.c(viewZ2);
                }
                View viewA2 = A();
                if (viewA2 != null) {
                    i.e(viewA2);
                }
            }
        } else {
            View viewV3 = v();
            if (viewV3 != null) {
                i.e(viewV3);
            }
            View viewZ3 = z();
            if (viewZ3 != null) {
                i.e(viewZ3);
            }
            View viewA3 = A();
            if (viewA3 != null) {
                i.e(viewA3);
            }
        }
        RecyclerView recyclerView = (RecyclerView) this.f57y.getValue();
        if (recyclerView != null) {
            Context context = this.f27a;
            Intrinsics.g(context, "context");
            q.a params = new q.a();
            params.f31940a = 0;
            params.f31941b = h.a.a(this, R$color.mini_color_E4E6EB_pure);
            params.f31942c = xb.a.b(1);
            AppCompatTextView appCompatTextViewY5 = y();
            params.f31944e = (appCompatTextViewY5 != null && i.a(appCompatTextViewY5)) || ((appCompatTextViewX4 = x()) != null && i.a(appCompatTextViewX4));
            params.f31943d = false;
            q qVar = new q();
            Intrinsics.g(context, "context");
            Intrinsics.g(params, "params");
            qVar.f31937e = params.f31940a;
            qVar.f31933a = params.f31941b;
            qVar.f31934b = params.f31942c;
            qVar.f31935c = params.f31944e;
            qVar.f31936d = params.f31943d;
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), 0);
            qVar.f31939g = bitmapDecodeResource;
            if (bitmapDecodeResource != null) {
                Intrinsics.d(bitmapDecodeResource);
                if (bitmapDecodeResource.getNinePatchChunk() != null) {
                    Bitmap bitmap = qVar.f31939g;
                    Intrinsics.d(bitmap);
                    new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
                }
                if (qVar.f31937e == 0 && qVar.f31934b == 0) {
                    Bitmap bitmap2 = qVar.f31939g;
                    Intrinsics.d(bitmap2);
                    bitmap2.getHeight();
                }
                if (qVar.f31937e == 1 && qVar.f31934b == 0) {
                    Bitmap bitmap3 = qVar.f31939g;
                    Intrinsics.d(bitmap3);
                    bitmap3.getWidth();
                }
            }
            Paint paint = new Paint();
            paint.setColor(qVar.f31933a);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(qVar.f31934b);
            qVar.f31938f = paint;
            recyclerView.addItemDecoration(qVar);
        }
        super.q();
    }

    public final View v() {
        return (View) this.f52t.getValue();
    }

    public final RecyclerView w() {
        return (RecyclerView) this.f57y.getValue();
    }

    public final AppCompatTextView x() {
        return (AppCompatTextView) this.f56x.getValue();
    }

    public final AppCompatTextView y() {
        return (AppCompatTextView) this.f55w.getValue();
    }

    public final View z() {
        return (View) this.f53u.getValue();
    }
}
