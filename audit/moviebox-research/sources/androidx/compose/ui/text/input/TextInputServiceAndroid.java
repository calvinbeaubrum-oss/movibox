package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.input.pointer.l0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
@SourceDebugExtension
public final class TextInputServiceAndroid implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f5914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f5915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f5916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super List<? extends m>, Unit> f5918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super o, Unit> f5919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextFieldValue f5920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f5921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<WeakReference<y>> f5922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f5923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CursorAnchorInfoController f5924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<TextInputCommand> f5925l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum TextInputCommand {
        StartInput,
        StopInput,
        ShowKeyboard,
        HideKeyboard
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements q {
        public a() {
        }

        @Override // androidx.compose.ui.text.input.q
        public void a(KeyEvent keyEvent) {
            TextInputServiceAndroid.this.g().sendKeyEvent(keyEvent);
        }

        @Override // androidx.compose.ui.text.input.q
        public void b(y yVar) {
            int size = TextInputServiceAndroid.this.f5922i.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (Intrinsics.b(((WeakReference) TextInputServiceAndroid.this.f5922i.get(i11)).get(), yVar)) {
                    TextInputServiceAndroid.this.f5922i.remove(i11);
                    return;
                }
            }
        }

        @Override // androidx.compose.ui.text.input.q
        public void c(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
            TextInputServiceAndroid.this.f5924k.a(z11, z12, z13, z14, z15, z16);
        }

        @Override // androidx.compose.ui.text.input.q
        public void d(int i11) {
            TextInputServiceAndroid.this.f5919f.invoke(o.i(i11));
        }

        @Override // androidx.compose.ui.text.input.q
        public void e(List<? extends m> list) {
            TextInputServiceAndroid.this.f5918e.invoke(list);
        }
    }

    public TextInputServiceAndroid(View view, l0 l0Var) {
        this(view, l0Var, new InputMethodManagerImpl(view), null, 8, null);
    }

    public TextInputServiceAndroid(View view, l0 l0Var, r rVar, Executor executor) {
        this.f5914a = view;
        this.f5915b = rVar;
        this.f5916c = executor;
        this.f5918e = new Function1<List<? extends m>, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onEditCommand$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends m> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends m> list) {
            }
        };
        this.f5919f = new Function1<o, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onImeActionPerformed$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(o oVar) {
                m89invokeKlQnJC8(oVar.o());
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke-KlQnJC8, reason: not valid java name */
            public final void m89invokeKlQnJC8(int i11) {
            }
        };
        this.f5920g = new TextFieldValue("", androidx.compose.ui.text.c0.f5765b.a(), (androidx.compose.ui.text.c0) null, 4, (DefaultConstructorMarker) null);
        this.f5921h = p.f5954g.a();
        this.f5922i = new ArrayList();
        this.f5923j = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<BaseInputConnection>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$baseInputConnection$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BaseInputConnection invoke() {
                return new BaseInputConnection(this.this$0.h(), false);
            }
        });
        this.f5924k = new CursorAnchorInfoController(l0Var, rVar);
        this.f5925l = new androidx.compose.runtime.collection.b<>(new TextInputCommand[16], 0);
    }

    public /* synthetic */ TextInputServiceAndroid(View view, l0 l0Var, r rVar, Executor executor, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, l0Var, rVar, (i11 & 8) != 0 ? g0.d(Choreographer.getInstance()) : executor);
    }

    public final InputConnection f(EditorInfo editorInfo) {
        if (!this.f5917d) {
            return null;
        }
        g0.h(editorInfo, this.f5921h, this.f5920g);
        g0.i(editorInfo);
        y yVar = new y(this.f5920g, new a(), this.f5921h.b());
        this.f5922i.add(new WeakReference<>(yVar));
        return yVar;
    }

    public final BaseInputConnection g() {
        return (BaseInputConnection) this.f5923j.getValue();
    }

    public final View h() {
        return this.f5914a;
    }

    public final boolean i() {
        return this.f5917d;
    }
}
