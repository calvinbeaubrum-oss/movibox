package y9;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$style;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f81302g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f81303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PopupWindow f81304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f81305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f81306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<e> f81307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f81308f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(View parent) {
        Intrinsics.g(parent, "parent");
        this.f81303a = parent;
        this.f81307e = new ArrayList<>();
    }

    public static final void e(d this$0, e buttonInfo, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(buttonInfo, "$buttonInfo");
        this$0.f();
        Function0<Unit> function0A = buttonInfo.a();
        if (function0A != null) {
            function0A.invoke();
        }
        buttonInfo.e(null);
    }

    public static final void l(d this$0) {
        Intrinsics.g(this$0, "this$0");
        Function0<Unit> function0 = this$0.f81308f;
        if (function0 != null) {
            function0.invoke();
        }
        this$0.f81308f = null;
    }

    public final d c(e eVar) {
        this.f81307e.add(eVar);
        if (this.f81307e.size() > 2) {
            this.f81307e.remove(0);
        }
        return this;
    }

    public final void d(Button button, final e eVar) {
        if (button != null) {
            button.setText(eVar.d());
            button.setTextColor(eVar.b());
            button.setTextSize(eVar.c());
            button.setOnClickListener(new View.OnClickListener() { // from class: y9.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.e(this.f81300a, eVar, view);
                }
            });
        }
    }

    public final void f() {
        try {
            PopupWindow popupWindow = this.f81304b;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            this.f81304b = null;
        } catch (Throwable unused) {
        }
    }

    public final void g() {
        f();
    }

    public final d h(String message) {
        Intrinsics.g(message, "message");
        this.f81306d = f.f81314d.a(message);
        return this;
    }

    public final d i(String text, Function0<Unit> function0) {
        Intrinsics.g(text, "text");
        c(e.f81309e.a(text, function0));
        return this;
    }

    public final d j(String title) {
        Intrinsics.g(title, "title");
        this.f81305c = f.f81314d.b(title);
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x012d A[Catch: all -> 0x0099, TryCatch #0 {all -> 0x0099, blocks: (B:18:0x0034, B:20:0x007f, B:22:0x0083, B:25:0x009c, B:27:0x00a6, B:29:0x00b5, B:30:0x00ca, B:32:0x00d1, B:34:0x00de, B:33:0x00d8, B:35:0x00e1, B:54:0x0141, B:56:0x0145, B:58:0x0164, B:59:0x0167, B:52:0x012d, B:42:0x010b, B:39:0x0105, B:45:0x0111, B:49:0x0127, B:53:0x0131), top: B:63:0x0034 }] */
    @SuppressLint({"InflateParams"})
    public final void k() {
        f fVar;
        String strB;
        f fVar2;
        String strB2;
        f fVar3 = this.f81305c;
        if (fVar3 != null && (strB = fVar3.b()) != null && strB.length() == 0 && (fVar2 = this.f81306d) != null && (strB2 = fVar2.b()) != null && strB2.length() == 0 && this.f81307e.isEmpty()) {
            z.a().w("CustomDialog", "Custom dialog show failed, title and message and buttons is all empty.");
            return;
        }
        try {
            g();
            View viewInflate = LayoutInflater.from(com.cloud.sdk.commonutil.util.f.a()).inflate(R$layout.custom_dialog_layout, (ViewGroup) null);
            Intrinsics.f(viewInflate, "from(HSCoreUtil.getConte…stom_dialog_layout, null)");
            FrameLayout frameLayout = new FrameLayout(com.cloud.sdk.commonutil.util.f.a());
            frameLayout.setBackgroundColor(Color.parseColor("#33000000"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            Unit unit = Unit.f68710a;
            frameLayout.addView(viewInflate, layoutParams);
            this.f81304b = new PopupWindow((View) frameLayout, -1, -1, false);
            TextView textView = (TextView) viewInflate.findViewById(R$id.dialog_title);
            if (textView != null && (fVar = this.f81305c) != null) {
                textView.setText(fVar.b());
                textView.setTextSize(fVar.c());
                textView.setTextColor(fVar.a());
            }
            TextView textView2 = (TextView) viewInflate.findViewById(R$id.dialog_message);
            if (textView2 != null) {
                textView2.setMovementMethod(new ScrollingMovementMethod());
                textView2.setOverScrollMode(0);
                f fVar4 = this.f81306d;
                if (fVar4 != null) {
                    textView2.setText(fVar4.b());
                    textView2.setTextSize(fVar4.c());
                    textView2.setTextColor(fVar4.a());
                }
                textView2.setMaxHeight(j.e() == 2 ? j.a(90.0f) : j.a(300.0f));
            }
            Button button = (Button) viewInflate.findViewById(R$id.dialog_button1);
            Button button2 = (Button) viewInflate.findViewById(R$id.dialog_button2);
            View viewFindViewById = viewInflate.findViewById(R$id.separator_v);
            if (this.f81307e.isEmpty()) {
                if (button != null) {
                    button.setVisibility(8);
                }
                if (button2 != null) {
                    button2.setVisibility(8);
                }
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(8);
                }
            } else {
                d(button, (e) CollectionsKt___CollectionsKt.e0(this.f81307e));
                if (this.f81307e.size() == 1) {
                    if (button2 != null) {
                        button2.setVisibility(8);
                    }
                    if (viewFindViewById != null) {
                        viewFindViewById.setVisibility(8);
                    }
                } else {
                    e eVar = this.f81307e.get(1);
                    Intrinsics.f(eVar, "buttons[1]");
                    d(button2, eVar);
                }
            }
            PopupWindow popupWindow = this.f81304b;
            if (popupWindow != null) {
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setAnimationStyle(R$style.Animation_AppCompat_Dialog);
                popupWindow.setOutsideTouchable(false);
                popupWindow.setTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.setClippingEnabled(true);
                if (Build.VERSION.SDK_INT >= 29) {
                    popupWindow.setIsClippedToScreen(true);
                }
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: y9.b
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public final void onDismiss() {
                        d.l(this.f81299a);
                    }
                });
                popupWindow.update();
                popupWindow.showAtLocation(this.f81303a, 0, 0, 0);
            }
        } catch (Throwable th2) {
            z.a().w("CustomDialog", "Show custom dialog failed, error: " + Log.getStackTraceString(th2));
        }
    }
}
