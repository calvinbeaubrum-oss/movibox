package androidx.compose.ui.text.input;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class y implements InputConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f5979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextFieldValue f5982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<m> f5985g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5986h = true;

    public y(TextFieldValue textFieldValue, q qVar, boolean z11) {
        this.f5979a = qVar;
        this.f5980b = z11;
        this.f5982d = textFieldValue;
    }

    public final void a(m mVar) {
        b();
        try {
            this.f5985g.add(mVar);
        } finally {
            c();
        }
    }

    public final boolean b() {
        this.f5981c++;
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        boolean z11 = this.f5986h;
        return z11 ? b() : z11;
    }

    public final boolean c() {
        int i11 = this.f5981c - 1;
        this.f5981c = i11;
        if (i11 == 0 && (!this.f5985g.isEmpty())) {
            this.f5979a.e(CollectionsKt___CollectionsKt.M0(this.f5985g));
            this.f5985g.clear();
        }
        return this.f5981c > 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i11) {
        boolean z11 = this.f5986h;
        if (z11) {
            return false;
        }
        return z11;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.f5985g.clear();
        this.f5981c = 0;
        this.f5986h = false;
        this.f5979a.b(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        boolean z11 = this.f5986h;
        if (z11) {
            return false;
        }
        return z11;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i11, Bundle bundle) {
        boolean z11 = this.f5986h;
        if (z11) {
            return false;
        }
        return z11;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean z11 = this.f5986h;
        return z11 ? this.f5980b : z11;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i11) {
        boolean z11 = this.f5986h;
        if (z11) {
            a(new a(String.valueOf(charSequence), i11));
        }
        return z11;
    }

    public final void d(int i11) {
        sendKeyEvent(new KeyEvent(0, i11));
        sendKeyEvent(new KeyEvent(1, i11));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i11, int i12) {
        boolean z11 = this.f5986h;
        if (!z11) {
            return z11;
        }
        a(new k(i11, i12));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i11, int i12) {
        boolean z11 = this.f5986h;
        if (!z11) {
            return z11;
        }
        a(new l(i11, i12));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return c();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        boolean z11 = this.f5986h;
        if (!z11) {
            return z11;
        }
        a(new n());
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i11) {
        return TextUtils.getCapsMode(this.f5982d.d(), androidx.compose.ui.text.c0.j(this.f5982d.c()), i11);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i11) {
        boolean z11 = (i11 & 1) != 0;
        this.f5984f = z11;
        if (z11) {
            this.f5983e = extractedTextRequest != null ? extractedTextRequest.token : 0;
        }
        return s.a(this.f5982d);
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i11) {
        if (androidx.compose.ui.text.c0.f(this.f5982d.c())) {
            return null;
        }
        return c0.a(this.f5982d).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i11, int i12) {
        return c0.b(this.f5982d, i11).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i11, int i12) {
        return c0.c(this.f5982d, i11).toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i11) {
        boolean z11 = this.f5986h;
        if (z11) {
            z11 = false;
            switch (i11) {
                case R.id.selectAll:
                    a(new b0(0, this.f5982d.d().length()));
                    break;
                case R.id.cut:
                    d(277);
                    break;
                case R.id.copy:
                    d(278);
                    break;
                case R.id.paste:
                    d(279);
                    break;
            }
        }
        return z11;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i11) {
        int iA;
        boolean z11 = this.f5986h;
        if (!z11) {
            return z11;
        }
        if (i11 != 0) {
            switch (i11) {
                case 2:
                    iA = o.f5943b.c();
                    break;
                case 3:
                    iA = o.f5943b.g();
                    break;
                case 4:
                    iA = o.f5943b.h();
                    break;
                case 5:
                    iA = o.f5943b.d();
                    break;
                case 6:
                    iA = o.f5943b.b();
                    break;
                case 7:
                    iA = o.f5943b.f();
                    break;
                default:
                    Log.w("RecordingIC", "IME sends unsupported Editor Action: " + i11);
                    iA = o.f5943b.a();
                    break;
            }
        } else {
            iA = o.f5943b.a();
        }
        this.f5979a.d(iA);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z11 = this.f5986h;
        if (z11) {
            return true;
        }
        return z11;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z11) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i11) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15 = this.f5986h;
        if (!z15) {
            return z15;
        }
        boolean z16 = false;
        boolean z17 = (i11 & 1) != 0;
        boolean z18 = (i11 & 2) != 0;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 33) {
            boolean z19 = (i11 & 16) != 0;
            boolean z21 = (i11 & 8) != 0;
            boolean z22 = (i11 & 4) != 0;
            if (i12 >= 34 && (i11 & 32) != 0) {
                z16 = true;
            }
            if (z19 || z21 || z22 || z16) {
                z14 = z16;
                z13 = z22;
                z12 = z21;
                z11 = z19;
            } else if (i12 >= 34) {
                z11 = true;
                z12 = true;
                z13 = true;
                z14 = true;
            } else {
                z14 = z16;
                z11 = true;
                z12 = true;
                z13 = true;
            }
        } else {
            z11 = true;
            z12 = true;
            z13 = false;
            z14 = false;
        }
        this.f5979a.c(z17, z18, z11, z12, z13, z14);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        boolean z11 = this.f5986h;
        if (!z11) {
            return z11;
        }
        this.f5979a.a(keyEvent);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i11, int i12) {
        boolean z11 = this.f5986h;
        if (z11) {
            a(new z(i11, i12));
        }
        return z11;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i11) {
        boolean z11 = this.f5986h;
        if (z11) {
            a(new a0(String.valueOf(charSequence), i11));
        }
        return z11;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i11, int i12) {
        boolean z11 = this.f5986h;
        if (!z11) {
            return z11;
        }
        a(new b0(i11, i12));
        return true;
    }
}
