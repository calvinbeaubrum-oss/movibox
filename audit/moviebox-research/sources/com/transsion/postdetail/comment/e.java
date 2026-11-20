package com.transsion.postdetail.comment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.Window;
import android.view.WindowManager;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$style;
import com.transsion.postdetail.bean.CommentBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class e extends androidx.appcompat.app.w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k f54925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public sv.a f54926h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f54927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public sv.a f54928b;

        public a(Context context) {
            Intrinsics.g(context, "context");
            this.f54927a = context;
            this.f54928b = new sv.a();
        }

        public final e a() {
            e eVar = new e(this.f54927a, null);
            eVar.o(this.f54928b);
            return eVar;
        }

        public final a b(Editable editable) {
            sv.a aVar = this.f54928b;
            if (aVar != null) {
                aVar.g(editable);
            }
            return this;
        }

        public final a c(a0 a0Var) {
            sv.a aVar = this.f54928b;
            if (aVar != null) {
                aVar.f(a0Var);
            }
            return this;
        }

        public final a d(int i11) {
            sv.a aVar = this.f54928b;
            if (aVar != null) {
                aVar.h(i11);
            }
            return this;
        }

        public final a e(CommentBean commentBean) {
            sv.a aVar = this.f54928b;
            if (aVar != null) {
                aVar.i(commentBean);
            }
            return this;
        }
    }

    public e(Context context) {
        super(context, R$style.CommentEditInputDialogTheme);
        setContentView(R$layout.dialog_comment_input_edit);
        setCancelable(true);
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
        this.f54925g = new k(null, this, null, true, 5, null);
    }

    public /* synthetic */ e(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final void m() {
        k kVar = this.f54925g;
        if (kVar != null) {
            kVar.k(this.f54926h);
        }
        k kVar2 = this.f54925g;
        if (kVar2 != null) {
            kVar2.B();
        }
    }

    public final void j() {
        k kVar = this.f54925g;
        if (kVar != null) {
            kVar.g();
        }
    }

    public final sv.a k() {
        return this.f54926h;
    }

    public final k l() {
        return this.f54925g;
    }

    public final void n(Editable editable) {
        sv.a aVar = this.f54926h;
        if (aVar == null) {
            return;
        }
        aVar.g(editable);
    }

    public final void o(sv.a aVar) {
        this.f54926h = aVar;
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void onStart() {
        super.onStart();
        m();
    }

    @Override // androidx.appcompat.app.w, androidx.activity.k, android.app.Dialog
    public void onStop() {
        super.onStop();
        q();
    }

    public final void p() {
        k kVar = this.f54925g;
        if (kVar != null) {
            kVar.y();
        }
    }

    public final void q() {
        k kVar = this.f54925g;
        if (kVar != null) {
            kVar.z();
        }
    }
}
