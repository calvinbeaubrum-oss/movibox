package fw;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.w;
import com.blankj.utilcode.util.KeyboardUtils;
import com.transsion.publish.R$layout;
import com.transsion.publish.R$style;
import com.transsion.publish.view.j;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class b extends w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f65289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InterfaceC0679b f65290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f65291i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f65292a;

        public a(Context context) {
            Intrinsics.g(context, "context");
            this.f65292a = context;
        }

        public final b a(InterfaceC0679b listener, View view) {
            Intrinsics.g(listener, "listener");
            return new b(this.f65292a, listener, view, null);
        }
    }

    /* JADX INFO: renamed from: fw.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface InterfaceC0679b {
        void completeLoad();
    }

    public b(Context context, InterfaceC0679b interfaceC0679b, View view) {
        super(context, R$style.CommentEditInputDialogTheme);
        this.f65290h = interfaceC0679b;
        this.f65291i = view;
        setContentView(R$layout.dialog_link_input_edit);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                Intrinsics.f(attributes, "it.attributes ?: return@let");
                if (attributes.width != -1) {
                    attributes.width = -1;
                }
                if (attributes.height != -2) {
                    attributes.height = -2;
                }
                window.setAttributes(attributes);
                window.setSoftInputMode(4);
            }
        }
        this.f65289g = new j(null, this, interfaceC0679b, this.f65291i, true, 1, null);
        com.transsion.publish.view.b bVar = new com.transsion.publish.view.b();
        j jVar = this.f65289g;
        if (jVar != null) {
            jVar.k(bVar);
        }
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: fw.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                return b.k(this.f65288a, dialogInterface, i11, keyEvent);
            }
        });
    }

    public /* synthetic */ b(Context context, InterfaceC0679b interfaceC0679b, View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, interfaceC0679b, view);
    }

    public static final boolean k(b this$0, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Intrinsics.g(this$0, "this$0");
        if (i11 != 4 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        this$0.dismiss();
        return false;
    }

    private final void l() {
    }

    private final void m() {
    }

    @Override // androidx.appcompat.app.w, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        View viewJ;
        super.dismiss();
        this.f65291i = null;
        j jVar = this.f65289g;
        if (jVar == null || (viewJ = jVar.j()) == null) {
            return;
        }
        KeyboardUtils.e(viewJ);
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void onStart() {
        super.onStart();
        l();
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void onStop() {
        super.onStop();
        m();
    }
}
