package w9;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$style;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
@SuppressLint({"InflateParams"})
public final class l extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f79369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f79370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f79371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f79372d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f79373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f79374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f79375h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {

        /* JADX INFO: renamed from: w9.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0885a {
            public static void a(a aVar) {
            }

            public static void b(a aVar) {
            }

            public static void c(a aVar) {
            }
        }

        void a();

        void b();

        void c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, a aVar) {
        super(context, R$style.HSDialogTheme);
        Intrinsics.g(context, "context");
        this.f79369a = aVar;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.confirm_dialog_layout, (ViewGroup) null);
        setContentView(viewInflate);
        setCancelable(false);
        this.f79370b = (TextView) viewInflate.findViewById(R$id.title);
        this.f79371c = (TextView) viewInflate.findViewById(R$id.content);
        TextView textView = (TextView) viewInflate.findViewById(R$id.positive);
        this.f79372d = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: w9.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.d(this.f79366a, view);
                }
            });
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.negative);
        this.f79373f = textView2;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: w9.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.e(this.f79367a, view);
                }
            });
        }
        this.f79375h = viewInflate.findViewById(R$id.separator_v);
        TextView textView3 = (TextView) viewInflate.findViewById(R$id.confirm);
        this.f79374g = textView3;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: w9.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.f(this.f79368a, view);
                }
            });
        }
        l();
    }

    public static final void d(l this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        a aVar = this$0.f79369a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static final void e(l this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        a aVar = this$0.f79369a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static final void f(l this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        a aVar = this$0.f79369a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void g(String text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f79374g;
        if (textView != null) {
            textView.setText(text);
        }
    }

    public final void h(String content) {
        Intrinsics.g(content, "content");
        TextView textView = this.f79371c;
        if (textView != null) {
            textView.setText(content);
        }
    }

    public final void i(String text) {
        Intrinsics.g(text, "text");
        TextView textView = this.f79372d;
        if (textView != null) {
            textView.setText(text);
        }
    }

    public final void j(boolean z11) {
        TextView textView = this.f79374g;
        if (textView != null) {
            textView.setVisibility(z11 ? 0 : 8);
        }
        TextView textView2 = this.f79372d;
        if (textView2 != null) {
            textView2.setVisibility(z11 ? 8 : 0);
        }
        TextView textView3 = this.f79373f;
        if (textView3 != null) {
            textView3.setVisibility(z11 ? 8 : 0);
        }
        View view = this.f79375h;
        if (view == null) {
            return;
        }
        view.setVisibility(z11 ? 8 : 0);
    }

    public final void k(String title) {
        Intrinsics.g(title, "title");
        TextView textView = this.f79370b;
        if (textView != null) {
            textView.setText(title);
        }
    }

    public final void l() {
        float f11 = getContext().getResources().getConfiguration().orientation == 2 ? 0.5f : 0.9f;
        Window window = getWindow();
        if (window != null) {
            window.setLayout((int) (getContext().getResources().getDisplayMetrics().widthPixels * f11), -2);
        }
    }
}
