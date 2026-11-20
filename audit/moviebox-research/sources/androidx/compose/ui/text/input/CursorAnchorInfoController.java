package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.r0;
import androidx.compose.ui.input.pointer.l0;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class CursorAnchorInfoController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f5889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f5890b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5897i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextFieldValue f5898j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.compose.ui.text.a0 f5899k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public y1.i f5901m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public y1.i f5902n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5891c = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super k4, Unit> f5900l = new Function1<k4, Unit>() { // from class: androidx.compose.ui.text.input.CursorAnchorInfoController$textFieldToRootTransform$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(k4 k4Var) {
            m88invoke58bKbWc(k4Var.r());
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke-58bKbWc, reason: not valid java name */
        public final void m88invoke58bKbWc(float[] fArr) {
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CursorAnchorInfo.Builder f5903o = new CursorAnchorInfo.Builder();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float[] f5904p = k4.c(null, 1, null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Matrix f5905q = new Matrix();

    public CursorAnchorInfoController(l0 l0Var, r rVar) {
        this.f5889a = l0Var;
        this.f5890b = rVar;
    }

    public final void a(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        synchronized (this.f5891c) {
            try {
                this.f5894f = z13;
                this.f5895g = z14;
                this.f5896h = z15;
                this.f5897i = z16;
                if (z11) {
                    this.f5893e = true;
                    if (this.f5898j != null) {
                        b();
                    }
                }
                this.f5892d = z12;
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b() {
        if (this.f5890b.isActive()) {
            this.f5900l.invoke(k4.a(this.f5904p));
            this.f5889a.mo53localToScreen58bKbWc(this.f5904p);
            r0.a(this.f5905q, this.f5904p);
            r rVar = this.f5890b;
            CursorAnchorInfo.Builder builder = this.f5903o;
            TextFieldValue textFieldValue = this.f5898j;
            Intrinsics.d(textFieldValue);
            Intrinsics.d(null);
            androidx.compose.ui.text.a0 a0Var = this.f5899k;
            Intrinsics.d(a0Var);
            Matrix matrix = this.f5905q;
            y1.i iVar = this.f5901m;
            Intrinsics.d(iVar);
            y1.i iVar2 = this.f5902n;
            Intrinsics.d(iVar2);
            rVar.a(j.b(builder, textFieldValue, null, a0Var, matrix, iVar, iVar2, this.f5894f, this.f5895g, this.f5896h, this.f5897i));
            this.f5893e = false;
        }
    }
}
