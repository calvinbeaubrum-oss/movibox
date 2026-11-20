package androidx.compose.ui.text.input;

import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class InputMethodManagerImpl implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f5906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f5907b = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<InputMethodManager>() { // from class: androidx.compose.ui.text.input.InputMethodManagerImpl$imm$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InputMethodManager invoke() {
            Object systemService = this.this$0.f5906a.getContext().getSystemService("input_method");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            return (InputMethodManager) systemService;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SoftwareKeyboardControllerCompat f5908c;

    public InputMethodManagerImpl(View view) {
        this.f5906a = view;
        this.f5908c = new SoftwareKeyboardControllerCompat(view);
    }

    @Override // androidx.compose.ui.text.input.r
    public void a(CursorAnchorInfo cursorAnchorInfo) {
        c().updateCursorAnchorInfo(this.f5906a, cursorAnchorInfo);
    }

    public final InputMethodManager c() {
        return (InputMethodManager) this.f5907b.getValue();
    }

    @Override // androidx.compose.ui.text.input.r
    public boolean isActive() {
        return c().isActive(this.f5906a);
    }
}
