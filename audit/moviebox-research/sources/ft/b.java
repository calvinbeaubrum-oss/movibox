package ft;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.i;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public et.b f65286a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Intrinsics.g(context, "context");
    }

    public static final void b(b this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        et.b bVarC = et.b.c(getLayoutInflater());
        Intrinsics.f(bVarC, "inflate(layoutInflater)");
        this.f65286a = bVarC;
        et.b bVar = null;
        if (bVarC == null) {
            Intrinsics.y("viewBinding");
            bVarC = null;
        }
        setContentView(bVarC.getRoot());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(null);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.gravity = 17;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            if (attributes2 != null) {
                attributes2.width = d0.e() - i.e(70.0f);
            }
        }
        float fE = i.e(8.0f);
        et.b bVar2 = this.f65286a;
        if (bVar2 == null) {
            Intrinsics.y("viewBinding");
            bVar2 = null;
        }
        LinearLayout root = bVar2.getRoot();
        Intrinsics.f(root, "viewBinding.root");
        gt.a.a(root, fE);
        et.b bVar3 = this.f65286a;
        if (bVar3 == null) {
            Intrinsics.y("viewBinding");
            bVar3 = null;
        }
        AppCompatTextView appCompatTextView = bVar3.f64355b;
        Intrinsics.f(appCompatTextView, "viewBinding.btnOk");
        gt.a.a(appCompatTextView, fE);
        et.b bVar4 = this.f65286a;
        if (bVar4 == null) {
            Intrinsics.y("viewBinding");
        } else {
            bVar = bVar4;
        }
        bVar.f64355b.setOnClickListener(new View.OnClickListener() { // from class: ft.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.b(this.f65285a, view);
            }
        });
    }
}
