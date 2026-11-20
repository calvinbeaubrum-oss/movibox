package androidx.compose.ui.text.font;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.t1;

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
@Metadata
@SourceDebugExtension
public final class AsyncFontListLoader implements a3<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h> f5786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0 f5787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AsyncTypefaceCache f5788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<o0.b, Unit> f5789d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a0 f5790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i1 f5791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5792h = true;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(List<? extends h> list, Object obj, n0 n0Var, AsyncTypefaceCache asyncTypefaceCache, Function1<? super o0.b, Unit> function1, a0 a0Var) {
        this.f5786a = list;
        this.f5787b = n0Var;
        this.f5788c = asyncTypefaceCache;
        this.f5789d = function1;
        this.f5790f = a0Var;
        this.f5791g = u2.c(obj, null, 2, null);
    }

    private void setValue(Object obj) {
        this.f5791g.setValue(obj);
    }

    public final boolean b() {
        return this.f5792h;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008c A[Catch: all -> 0x00ef, TryCatch #2 {all -> 0x00ef, blocks: (B:28:0x0075, B:30:0x008c, B:35:0x00bb, B:40:0x00f2), top: B:57:0x0075 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:35:0x00bb A[Catch: all -> 0x00ef, TRY_LEAVE, TryCatch #2 {all -> 0x00ef, blocks: (B:28:0x0075, B:30:0x008c, B:35:0x00bb, B:40:0x00f2), top: B:57:0x0075 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00f2 A[Catch: all -> 0x00ef, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00ef, blocks: (B:28:0x0075, B:30:0x008c, B:35:0x00bb, B:40:0x00f2), top: B:57:0x0075 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0104 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x0105  */
    /* JADX WARN: Code duplicated, block: B:45:0x010a  */
    /* JADX WARN: Code duplicated, block: B:57:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0105 -> B:44:0x0106). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x010a -> B:46:0x010c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object e(kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f(h hVar, Continuation<Object> continuation) {
        AsyncFontListLoader$loadWithTimeoutOrNull$1 asyncFontListLoader$loadWithTimeoutOrNull$1;
        if (continuation instanceof AsyncFontListLoader$loadWithTimeoutOrNull$1) {
            asyncFontListLoader$loadWithTimeoutOrNull$1 = (AsyncFontListLoader$loadWithTimeoutOrNull$1) continuation;
            int i11 = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                asyncFontListLoader$loadWithTimeoutOrNull$1.label = i11 - Integer.MIN_VALUE;
            } else {
                asyncFontListLoader$loadWithTimeoutOrNull$1 = new AsyncFontListLoader$loadWithTimeoutOrNull$1(this, continuation);
            }
        } else {
            asyncFontListLoader$loadWithTimeoutOrNull$1 = new AsyncFontListLoader$loadWithTimeoutOrNull$1(this, continuation);
        }
        Object objD = asyncFontListLoader$loadWithTimeoutOrNull$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
        Object obj = null;
        try {
            if (i12 == 0) {
                ResultKt.b(objD);
                AsyncFontListLoader$loadWithTimeoutOrNull$2 asyncFontListLoader$loadWithTimeoutOrNull$2 = new AsyncFontListLoader$loadWithTimeoutOrNull$2(this, hVar, null);
                asyncFontListLoader$loadWithTimeoutOrNull$1.L$0 = hVar;
                asyncFontListLoader$loadWithTimeoutOrNull$1.label = 1;
                objD = TimeoutKt.d(15000L, asyncFontListLoader$loadWithTimeoutOrNull$2, asyncFontListLoader$loadWithTimeoutOrNull$1);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                hVar = (h) asyncFontListLoader$loadWithTimeoutOrNull$1.L$0;
                ResultKt.b(objD);
            }
            obj = objD;
            return obj;
        } catch (CancellationException e11) {
            if (t1.m(asyncFontListLoader$loadWithTimeoutOrNull$1.getContext())) {
                return obj;
            }
            throw e11;
        } catch (Exception e12) {
            kotlinx.coroutines.g0 g0Var = (kotlinx.coroutines.g0) asyncFontListLoader$loadWithTimeoutOrNull$1.getContext().get(kotlinx.coroutines.g0.f69429i8);
            if (g0Var == null) {
                return obj;
            }
            g0Var.l(asyncFontListLoader$loadWithTimeoutOrNull$1.getContext(), new IllegalStateException("Unable to load font " + hVar, e12));
            return obj;
        }
    }

    @Override // androidx.compose.runtime.a3
    public Object getValue() {
        return this.f5791g.getValue();
    }
}
