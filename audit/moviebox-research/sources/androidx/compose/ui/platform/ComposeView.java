package androidx.compose.ui.platform;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ComposeView extends AbstractComposeView {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.compose.runtime.i1<Function2<androidx.compose.runtime.i, Integer, Unit>> f5303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5304k;

    @JvmOverloads
    public ComposeView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public ComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @JvmOverloads
    public ComposeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f5303j = androidx.compose.runtime.u2.c(null, null, 2, null);
    }

    public /* synthetic */ ComposeView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static /* synthetic */ void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i iVarG = iVar.g(420213850);
        if ((i11 & 6) == 0) {
            i12 = (iVarG.A(this) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 3) == 2 && iVarG.h()) {
            iVarG.H();
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(420213850, i12, -1, "androidx.compose.ui.platform.ComposeView.Content (ComposeView.android.kt:439)");
            }
            Function2<androidx.compose.runtime.i, Integer, Unit> value = this.f5303j.getValue();
            if (value == null) {
                iVarG.R(358373017);
            } else {
                iVarG.R(150107752);
                value.invoke(iVarG, 0);
            }
            iVarG.L();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        androidx.compose.runtime.g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.platform.ComposeView.Content.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i13) {
                    ComposeView.this.Content(iVar2, androidx.compose.runtime.v1.a(i11 | 1));
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return ComposeView.class.getName();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.f5304k;
    }

    public final void setContent(Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        this.f5304k = true;
        this.f5303j.setValue(function2);
        if (isAttachedToWindow()) {
            createComposition();
        }
    }
}
