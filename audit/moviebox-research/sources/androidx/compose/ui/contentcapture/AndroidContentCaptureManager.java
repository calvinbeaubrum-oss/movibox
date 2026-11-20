package androidx.compose.ui.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationRequestValue;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.annotation.RequiresApi;
import androidx.collection.c0;
import androidx.collection.d0;
import androidx.collection.n;
import androidx.collection.o;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.x0;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.g2;
import androidx.compose.ui.platform.h2;
import androidx.compose.ui.platform.i2;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.a0;
import androidx.compose.ui.text.z;
import androidx.lifecycle.u;
import com.vungle.warren.error.VungleException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.w;

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
@SourceDebugExtension
public final class AndroidContentCaptureManager implements m, androidx.lifecycle.f, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AndroidComposeView f3791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<? extends j2.e> f3792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j2.e f3793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<j2.g> f3794d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d0 f3795f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.collection.b<LayoutNode> f3799j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f3803n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public g2 f3805p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3806q;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3796g = 100;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TranslateStatus f3797h = TranslateStatus.SHOW_ORIGINAL;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3798i = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final kotlinx.coroutines.channels.a<Unit> f3800k = kotlinx.coroutines.channels.d.b(1, null, null, 6, null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f3801l = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public n<h2> f3802m = o.a();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c0<g2> f3804o = o.b();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Runnable f3807r = new Runnable() { // from class: androidx.compose.ui.contentcapture.a
        @Override // java.lang.Runnable
        public final void run() {
            AndroidContentCaptureManager.g(this.f3809a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum TranslateStatus {
        SHOW_ORIGINAL,
        SHOW_TRANSLATED
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @RequiresApi(VungleException.WEB_CRASH)
    @SourceDebugExtension
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3808a = new a();

        public static final void e(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
            f3808a.b(androidContentCaptureManager, longSparseArray);
        }

        public final void b(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray<ViewTranslationResponse> longSparseArray) {
            TranslationResponseValue value;
            CharSequence text;
            h2 h2VarC;
            SemanticsNode semanticsNodeB;
            androidx.compose.ui.semantics.a aVar;
            Function1 function1;
            LongIterator longIteratorA = androidx.core.util.c.a(longSparseArray);
            while (longIteratorA.hasNext()) {
                long jA = longIteratorA.a();
                ViewTranslationResponse viewTranslationResponseA = i.a(longSparseArray.get(jA));
                if (viewTranslationResponseA != null && (value = viewTranslationResponseA.getValue("android:text")) != null && (text = value.getText()) != null && (h2VarC = androidContentCaptureManager.h().c((int) jA)) != null && (semanticsNodeB = h2VarC.b()) != null && (aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNodeB.w(), androidx.compose.ui.semantics.k.f5661a.y())) != null && (function1 = (Function1) aVar.a()) != null) {
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0073  */
        @RequiresApi(VungleException.WEB_CRASH)
        public final void c(AndroidContentCaptureManager androidContentCaptureManager, long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
            SemanticsNode semanticsNodeB;
            String strD;
            for (long j11 : jArr) {
                h2 h2VarC = androidContentCaptureManager.h().c((int) j11);
                if (h2VarC != null && (semanticsNodeB = h2VarC.b()) != null) {
                    c.a();
                    ViewTranslationRequest.Builder builderA = b.a(androidContentCaptureManager.i().getAutofillId(), semanticsNodeB.o());
                    List list = (List) SemanticsConfigurationKt.a(semanticsNodeB.w(), SemanticsProperties.f5594a.C());
                    if (list != null && (strD = s2.a.d(list, "\n", null, null, 0, null, null, 62, null)) != null) {
                        builderA.setValue("android:text", TranslationRequestValue.forText(new AnnotatedString(strD, null, null, 6, null)));
                        consumer.accept(builderA.build());
                    }
                }
            }
        }

        @RequiresApi(VungleException.WEB_CRASH)
        public final void d(final AndroidContentCaptureManager androidContentCaptureManager, final LongSparseArray<ViewTranslationResponse> longSparseArray) {
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            if (Intrinsics.b(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                b(androidContentCaptureManager, longSparseArray);
            } else {
                androidContentCaptureManager.i().post(new Runnable() { // from class: androidx.compose.ui.contentcapture.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidContentCaptureManager.a.e(androidContentCaptureManager, longSparseArray);
                    }
                });
            }
        }
    }

    public AndroidContentCaptureManager(AndroidComposeView androidComposeView, Function0<? extends j2.e> function0) {
        this.f3791a = androidComposeView;
        this.f3792b = function0;
        int i11 = 0;
        int i12 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.f3794d = new c0<>(i11, i12, defaultConstructorMarker);
        this.f3795f = new d0(i11, i12, defaultConstructorMarker);
        this.f3799j = new androidx.collection.b<>(i11, i12, defaultConstructorMarker);
        this.f3805p = new g2(androidComposeView.getSemanticsOwner().a(), o.a());
    }

    public static final void g(AndroidContentCaptureManager androidContentCaptureManager) {
        if (androidContentCaptureManager.k()) {
            x0.c(androidContentCaptureManager.f3791a, false, 1, null);
            androidContentCaptureManager.w(androidContentCaptureManager.f3791a.getSemanticsOwner().a(), androidContentCaptureManager.f3805p);
            androidContentCaptureManager.u(androidContentCaptureManager.f3791a.getSemanticsOwner().a(), androidContentCaptureManager.f3805p);
            androidContentCaptureManager.e(androidContentCaptureManager.h());
            androidContentCaptureManager.B();
            androidContentCaptureManager.f3806q = false;
        }
    }

    public final void A(SemanticsNode semanticsNode) {
        if (k()) {
            d(semanticsNode.o());
            List<SemanticsNode> listT = semanticsNode.t();
            int size = listT.size();
            for (int i11 = 0; i11 < size; i11++) {
                A(listT.get(i11));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x005f A[LOOP:0: B:5:0x0017->B:15:0x005f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x0062 A[EDGE_INSN: B:19:0x0062->B:16:0x0062 BREAK  A[LOOP:0: B:5:0x0017->B:15:0x005f], SYNTHETIC] */
    public final void B() {
        this.f3804o.i();
        n<h2> nVarH = h();
        int[] iArr = nVarH.f1952b;
        Object[] objArr = nVarH.f1953c;
        long[] jArr = nVarH.f1951a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j11 = jArr[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i11 != length) {
                        break;
                        break;
                    }
                    i11++;
                } else {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j11) < 128) {
                            int i14 = (i11 << 3) + i13;
                            this.f3804o.t(iArr[i14], new g2(((h2) objArr[i14]).b(), h()));
                        }
                        j11 >>= 8;
                    }
                    if (i12 != 8) {
                        break;
                    } else if (i11 != length) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        this.f3805p = new g2(this.f3791a.getSemanticsOwner().a(), h());
    }

    public final void C(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.a aVar;
        Function1 function1;
        Function1 function2;
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        Boolean bool = (Boolean) SemanticsConfigurationKt.a(lVarW, SemanticsProperties.f5594a.q());
        if (this.f3797h == TranslateStatus.SHOW_ORIGINAL && Intrinsics.b(bool, Boolean.TRUE)) {
            androidx.compose.ui.semantics.a aVar2 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(lVarW, androidx.compose.ui.semantics.k.f5661a.z());
            if (aVar2 == null || (function2 = (Function1) aVar2.a()) == null) {
                return;
            }
            return;
        }
        if (this.f3797h != TranslateStatus.SHOW_TRANSLATED || !Intrinsics.b(bool, Boolean.FALSE) || (aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(lVarW, androidx.compose.ui.semantics.k.f5661a.z())) == null || (function1 = (Function1) aVar.a()) == null) {
            return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0062 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x006e A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0030, B:25:0x0056, B:29:0x0066, B:31:0x006e, B:33:0x0077, B:34:0x007a, B:36:0x007e, B:37:0x0087, B:20:0x0048), top: B:48:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0077 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0030, B:25:0x0056, B:29:0x0066, B:31:0x006e, B:33:0x0077, B:34:0x007a, B:36:0x007e, B:37:0x0087, B:20:0x0048), top: B:48:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x007e A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0030, B:25:0x0056, B:29:0x0066, B:31:0x006e, B:33:0x0077, B:34:0x007a, B:36:0x007e, B:37:0x0087, B:20:0x0048), top: B:48:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x009a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x009b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0098 -> B:14:0x0033). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1 r0 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1 r0 = new androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.c r2 = (kotlinx.coroutines.channels.c) r2
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager r5 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager) r5
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L35
        L33:
            r10 = r2
            goto L56
        L35:
            r10 = move-exception
            goto La5
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L40:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.c r2 = (kotlinx.coroutines.channels.c) r2
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager r5 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager) r5
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L35
            goto L66
        L4c:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.channels.a<kotlin.Unit> r10 = r9.f3800k     // Catch: java.lang.Throwable -> La3
            kotlinx.coroutines.channels.c r10 = r10.iterator()     // Catch: java.lang.Throwable -> La3
            r5 = r9
        L56:
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r10     // Catch: java.lang.Throwable -> L35
            r0.label = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r10.a(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L63
            return r1
        L63:
            r8 = r2
            r2 = r10
            r10 = r8
        L66:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L35
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L9b
            r2.next()     // Catch: java.lang.Throwable -> L35
            boolean r10 = r5.k()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L7a
            r5.l()     // Catch: java.lang.Throwable -> L35
        L7a:
            boolean r10 = r5.f3806q     // Catch: java.lang.Throwable -> L35
            if (r10 != 0) goto L87
            r5.f3806q = r4     // Catch: java.lang.Throwable -> L35
            android.os.Handler r10 = r5.f3801l     // Catch: java.lang.Throwable -> L35
            java.lang.Runnable r6 = r5.f3807r     // Catch: java.lang.Throwable -> L35
            r10.post(r6)     // Catch: java.lang.Throwable -> L35
        L87:
            androidx.collection.b<androidx.compose.ui.node.LayoutNode> r10 = r5.f3799j     // Catch: java.lang.Throwable -> L35
            r10.clear()     // Catch: java.lang.Throwable -> L35
            long r6 = r5.f3796g     // Catch: java.lang.Throwable -> L35
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L35
            r0.label = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = kotlinx.coroutines.r0.a(r6, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r1) goto L33
            return r1
        L9b:
            androidx.collection.b<androidx.compose.ui.node.LayoutNode> r10 = r5.f3799j
            r10.clear()
            kotlin.Unit r10 = kotlin.Unit.f68710a
            return r10
        La3:
            r10 = move-exception
            r5 = r9
        La5:
            androidx.collection.b<androidx.compose.ui.node.LayoutNode> r0 = r5.f3799j
            r0.clear()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.contentcapture.AndroidContentCaptureManager.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void c(int i11, j2.g gVar) {
        if (gVar == null) {
            return;
        }
        if (this.f3795f.a(i11)) {
            this.f3795f.q(i11);
        } else {
            this.f3794d.t(i11, gVar);
        }
    }

    public final void d(int i11) {
        if (this.f3794d.b(i11)) {
            this.f3794d.q(i11);
        } else {
            this.f3795f.f(i11);
        }
    }

    public final void e(n<h2> nVar) {
        int[] iArr = nVar.f1952b;
        long[] jArr = nVar.f1951a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i11 = 0;
        while (true) {
            long j11 = jArr[i11];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i11 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j11) < 128) {
                        int i14 = iArr[(i11 << 3) + i13];
                        g2 g2VarC = this.f3804o.c(i14);
                        h2 h2VarC = nVar.c(i14);
                        SemanticsNode semanticsNodeB = h2VarC != null ? h2VarC.b() : null;
                        if (semanticsNodeB == null) {
                            h2.a.c("no value for specified key");
                            throw new KotlinNothingValueException();
                        }
                        if (g2VarC == null) {
                            Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = semanticsNodeB.w().iterator();
                            while (it.hasNext()) {
                                SemanticsPropertyKey<?> key = it.next().getKey();
                                SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
                                if (Intrinsics.b(key, semanticsProperties.C())) {
                                    List list = (List) SemanticsConfigurationKt.a(semanticsNodeB.w(), semanticsProperties.C());
                                    v(semanticsNodeB.o(), String.valueOf(list != null ? (AnnotatedString) CollectionsKt___CollectionsKt.g0(list) : null));
                                }
                            }
                        } else {
                            Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it2 = semanticsNodeB.w().iterator();
                            while (it2.hasNext()) {
                                SemanticsPropertyKey<?> key2 = it2.next().getKey();
                                SemanticsProperties semanticsProperties2 = SemanticsProperties.f5594a;
                                if (Intrinsics.b(key2, semanticsProperties2.C())) {
                                    List list2 = (List) SemanticsConfigurationKt.a(g2VarC.b(), semanticsProperties2.C());
                                    AnnotatedString annotatedString = list2 != null ? (AnnotatedString) CollectionsKt___CollectionsKt.g0(list2) : null;
                                    List list3 = (List) SemanticsConfigurationKt.a(semanticsNodeB.w(), semanticsProperties2.C());
                                    AnnotatedString annotatedString2 = list3 != null ? (AnnotatedString) CollectionsKt___CollectionsKt.g0(list3) : null;
                                    if (!Intrinsics.b(annotatedString, annotatedString2)) {
                                        v(semanticsNodeB.o(), String.valueOf(annotatedString2));
                                    }
                                }
                            }
                        }
                    }
                    j11 >>= 8;
                }
                if (i12 != 8) {
                    return;
                }
            }
            if (i11 == length) {
                return;
            } else {
                i11++;
            }
        }
    }

    public final void f() {
        androidx.compose.ui.semantics.a aVar;
        Function0 function0;
        n<h2> nVarH = h();
        Object[] objArr = nVarH.f1953c;
        long[] jArr = nVarH.f1951a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i11 = 0;
        while (true) {
            long j11 = jArr[i11];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i11 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j11) < 128) {
                        androidx.compose.ui.semantics.l lVarW = ((h2) objArr[(i11 << 3) + i13]).b().w();
                        if (SemanticsConfigurationKt.a(lVarW, SemanticsProperties.f5594a.q()) != null && (aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(lVarW, androidx.compose.ui.semantics.k.f5661a.a())) != null && (function0 = (Function0) aVar.a()) != null) {
                        }
                    }
                    j11 >>= 8;
                }
                if (i12 != 8) {
                    return;
                }
            }
            if (i11 == length) {
                return;
            } else {
                i11++;
            }
        }
    }

    public final n<h2> h() {
        if (this.f3798i) {
            this.f3798i = false;
            this.f3802m = i2.b(this.f3791a.getSemanticsOwner());
            this.f3803n = System.currentTimeMillis();
        }
        return this.f3802m;
    }

    public final AndroidComposeView i() {
        return this.f3791a;
    }

    public final void j() {
        androidx.compose.ui.semantics.a aVar;
        Function1 function1;
        n<h2> nVarH = h();
        Object[] objArr = nVarH.f1953c;
        long[] jArr = nVarH.f1951a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i11 = 0;
        while (true) {
            long j11 = jArr[i11];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i11 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j11) < 128) {
                        androidx.compose.ui.semantics.l lVarW = ((h2) objArr[(i11 << 3) + i13]).b().w();
                        if (Intrinsics.b(SemanticsConfigurationKt.a(lVarW, SemanticsProperties.f5594a.q()), Boolean.TRUE) && (aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(lVarW, androidx.compose.ui.semantics.k.f5661a.z())) != null && (function1 = (Function1) aVar.a()) != null) {
                        }
                    }
                    j11 >>= 8;
                }
                if (i12 != 8) {
                    return;
                }
            }
            if (i11 == length) {
                return;
            } else {
                i11++;
            }
        }
    }

    public final boolean k() {
        return m.Z7.a() && this.f3793c != null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0064 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0066 A[LOOP:0: B:13:0x0031->B:23:0x0066, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x006d A[EDGE_INSN: B:53:0x006d->B:24:0x006d BREAK  A[LOOP:0: B:13:0x0031->B:23:0x0066], SYNTHETIC] */
    public final void l() {
        j2.e eVar = this.f3793c;
        if (eVar != null && Build.VERSION.SDK_INT >= 29) {
            long j11 = 255;
            char c11 = 7;
            if (this.f3794d.g()) {
                ArrayList arrayList = new ArrayList();
                c0<j2.g> c0Var = this.f3794d;
                Object[] objArr = c0Var.f1953c;
                long[] jArr = c0Var.f1951a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i11 = 0;
                    while (true) {
                        long j12 = jArr[i11];
                        long[] jArr2 = jArr;
                        if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i12 = 8 - ((~(i11 - length)) >>> 31);
                            int i13 = 0;
                            while (i13 < i12) {
                                if ((j12 & j11) < 128) {
                                    arrayList.add((j2.g) objArr[(i11 << 3) + i13]);
                                }
                                j12 >>= 8;
                                i13++;
                                j11 = 255;
                            }
                            if (i12 != 8) {
                                break;
                            }
                            if (i11 != length) {
                                break;
                            }
                            i11++;
                            jArr = jArr2;
                            j11 = 255;
                        } else if (i11 != length) {
                            break;
                            break;
                        } else {
                            i11++;
                            jArr = jArr2;
                            j11 = 255;
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                int size = arrayList.size();
                for (int i14 = 0; i14 < size; i14++) {
                    arrayList2.add(((j2.g) arrayList.get(i14)).h());
                }
                eVar.d(arrayList2);
                this.f3794d.i();
            }
            if (this.f3795f.c()) {
                ArrayList arrayList3 = new ArrayList();
                d0 d0Var = this.f3795f;
                int[] iArr = d0Var.f1964b;
                long[] jArr3 = d0Var.f1963a;
                int length2 = jArr3.length - 2;
                if (length2 >= 0) {
                    int i15 = 0;
                    while (true) {
                        long j13 = jArr3[i15];
                        if ((((~j13) << c11) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i16 = 8 - ((~(i15 - length2)) >>> 31);
                            for (int i17 = 0; i17 < i16; i17++) {
                                if ((j13 & 255) < 128) {
                                    arrayList3.add(Integer.valueOf(iArr[(i15 << 3) + i17]));
                                }
                                j13 >>= 8;
                            }
                            if (i16 != 8) {
                                break;
                            }
                        }
                        if (i15 == length2) {
                            break;
                        }
                        i15++;
                        c11 = 7;
                    }
                }
                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                int size2 = arrayList3.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    arrayList4.add(Long.valueOf(((Number) arrayList3.get(i18)).intValue()));
                }
                eVar.e(CollectionsKt___CollectionsKt.K0(arrayList4));
                this.f3795f.h();
            }
        }
    }

    public final void m(LayoutNode layoutNode) {
        if (this.f3799j.add(layoutNode)) {
            this.f3800k.f(Unit.f68710a);
        }
    }

    public final void n() {
        this.f3797h = TranslateStatus.SHOW_ORIGINAL;
        f();
    }

    @RequiresApi(VungleException.WEB_CRASH)
    public final void o(long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
        a.f3808a.c(this, jArr, iArr, consumer);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onCreate(u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onDestroy(u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onPause(u uVar) {
        androidx.lifecycle.e.c(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onResume(u uVar) {
        androidx.lifecycle.e.d(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public void onStart(u uVar) {
        this.f3793c = this.f3792b.invoke();
        z(this.f3791a.getSemanticsOwner().a());
        l();
    }

    @Override // androidx.lifecycle.f
    public void onStop(u uVar) {
        A(this.f3791a.getSemanticsOwner().a());
        l();
        this.f3793c = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f3801l.removeCallbacks(this.f3807r);
        this.f3793c = null;
    }

    public final void p() {
        this.f3797h = TranslateStatus.SHOW_ORIGINAL;
        j();
    }

    public final void q(LayoutNode layoutNode) {
        this.f3798i = true;
        if (k()) {
            m(layoutNode);
        }
    }

    public final void r() {
        this.f3798i = true;
        if (!k() || this.f3806q) {
            return;
        }
        this.f3806q = true;
        this.f3801l.post(this.f3807r);
    }

    public final void s() {
        this.f3797h = TranslateStatus.SHOW_TRANSLATED;
        x();
    }

    @RequiresApi(VungleException.WEB_CRASH)
    public final void t(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray<ViewTranslationResponse> longSparseArray) {
        a.f3808a.d(androidContentCaptureManager, longSparseArray);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0081 A[LOOP:1: B:13:0x0042->B:25:0x0081, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x0084 A[EDGE_INSN: B:44:0x0084->B:26:0x0084 BREAK  A[LOOP:1: B:13:0x0042->B:25:0x0081], SYNTHETIC] */
    public final void u(SemanticsNode semanticsNode, g2 g2Var) {
        List<SemanticsNode> listT = semanticsNode.t();
        int size = listT.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode2 = listT.get(i11);
            if (h().a(semanticsNode2.o()) && !g2Var.a().a(semanticsNode2.o())) {
                z(semanticsNode2);
            }
        }
        c0<g2> c0Var = this.f3804o;
        int[] iArr = c0Var.f1952b;
        long[] jArr = c0Var.f1951a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i12 = 0;
            while (true) {
                long j11 = jArr[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i12 != length) {
                        break;
                        break;
                    }
                    i12++;
                } else {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((255 & j11) < 128) {
                            int i15 = iArr[(i12 << 3) + i14];
                            if (!h().a(i15)) {
                                d(i15);
                            }
                        }
                        j11 >>= 8;
                    }
                    if (i13 != 8) {
                        break;
                    } else if (i12 != length) {
                        break;
                    } else {
                        i12++;
                    }
                }
            }
        }
        List<SemanticsNode> listT2 = semanticsNode.t();
        int size2 = listT2.size();
        for (int i16 = 0; i16 < size2; i16++) {
            SemanticsNode semanticsNode3 = listT2.get(i16);
            if (h().a(semanticsNode3.o()) && this.f3804o.a(semanticsNode3.o())) {
                g2 g2VarC = this.f3804o.c(semanticsNode3.o());
                if (g2VarC == null) {
                    h2.a.c("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
                u(semanticsNode3, g2VarC);
            }
        }
    }

    public final void v(int i11, String str) {
        j2.e eVar;
        if (Build.VERSION.SDK_INT >= 29 && (eVar = this.f3793c) != null) {
            AutofillId autofillIdA = eVar.a(i11);
            if (autofillIdA != null) {
                eVar.c(autofillIdA, str);
            } else {
                h2.a.c("Invalid content capture ID");
                throw new KotlinNothingValueException();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0095 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0097 A[LOOP:1: B:15:0x0057->B:28:0x0097, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x009a A[EDGE_INSN: B:46:0x009a->B:29:0x009a BREAK  A[LOOP:1: B:15:0x0057->B:28:0x0097], SYNTHETIC] */
    public final void w(SemanticsNode semanticsNode, g2 g2Var) {
        int i11 = 0;
        d0 d0Var = new d0(i11, 1, null);
        List<SemanticsNode> listT = semanticsNode.t();
        int size = listT.size();
        for (int i12 = 0; i12 < size; i12++) {
            SemanticsNode semanticsNode2 = listT.get(i12);
            if (h().a(semanticsNode2.o())) {
                if (!g2Var.a().a(semanticsNode2.o())) {
                    m(semanticsNode.q());
                    return;
                }
                d0Var.f(semanticsNode2.o());
            }
        }
        d0 d0VarA = g2Var.a();
        int[] iArr = d0VarA.f1964b;
        long[] jArr = d0VarA.f1963a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i13 = 0;
            while (true) {
                long j11 = jArr[i13];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i13 != length) {
                        break;
                        break;
                    }
                    i13++;
                } else {
                    int i14 = 8 - ((~(i13 - length)) >>> 31);
                    for (int i15 = 0; i15 < i14; i15++) {
                        if ((255 & j11) < 128 && !d0Var.a(iArr[(i13 << 3) + i15])) {
                            m(semanticsNode.q());
                            return;
                        }
                        j11 >>= 8;
                    }
                    if (i14 != 8) {
                        break;
                    } else if (i13 != length) {
                        break;
                    } else {
                        i13++;
                    }
                }
            }
        }
        List<SemanticsNode> listT2 = semanticsNode.t();
        int size2 = listT2.size();
        while (i11 < size2) {
            SemanticsNode semanticsNode3 = listT2.get(i11);
            if (h().a(semanticsNode3.o())) {
                g2 g2VarC = this.f3804o.c(semanticsNode3.o());
                if (g2VarC == null) {
                    h2.a.c("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
                w(semanticsNode3, g2VarC);
            }
            i11++;
        }
    }

    public final void x() {
        androidx.compose.ui.semantics.a aVar;
        Function1 function1;
        n<h2> nVarH = h();
        Object[] objArr = nVarH.f1953c;
        long[] jArr = nVarH.f1951a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i11 = 0;
        while (true) {
            long j11 = jArr[i11];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i11 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j11) < 128) {
                        androidx.compose.ui.semantics.l lVarW = ((h2) objArr[(i11 << 3) + i13]).b().w();
                        if (Intrinsics.b(SemanticsConfigurationKt.a(lVarW, SemanticsProperties.f5594a.q()), Boolean.FALSE) && (aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(lVarW, androidx.compose.ui.semantics.k.f5661a.z())) != null && (function1 = (Function1) aVar.a()) != null) {
                        }
                    }
                    j11 >>= 8;
                }
                if (i12 != 8) {
                    return;
                }
            }
            if (i11 == length) {
                return;
            } else {
                i11++;
            }
        }
    }

    public final j2.g y(SemanticsNode semanticsNode) {
        j2.b bVarA;
        AutofillId autofillIdA;
        String strH;
        j2.e eVar = this.f3793c;
        if (eVar == null || Build.VERSION.SDK_INT < 29 || (bVarA = j2.f.a(this.f3791a)) == null) {
            return null;
        }
        SemanticsNode semanticsNodeR = semanticsNode.r();
        if (semanticsNodeR != null) {
            autofillIdA = eVar.a(semanticsNodeR.o());
            if (autofillIdA == null) {
                return null;
            }
        } else {
            autofillIdA = bVarA.a();
        }
        j2.g gVarB = eVar.b(autofillIdA, semanticsNode.o());
        if (gVarB == null) {
            return null;
        }
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        if (lVarW.f(semanticsProperties.v())) {
            return null;
        }
        Bundle bundleA = gVarB.a();
        if (bundleA != null) {
            bundleA.putLong("android.view.contentcapture.EventTimestamp", this.f3803n);
        }
        String str = (String) SemanticsConfigurationKt.a(lVarW, semanticsProperties.B());
        if (str != null) {
            gVarB.e(semanticsNode.o(), null, null, str);
        }
        List list = (List) SemanticsConfigurationKt.a(lVarW, semanticsProperties.C());
        if (list != null) {
            gVarB.b("android.widget.TextView");
            gVarB.f(s2.a.d(list, "\n", null, null, 0, null, null, 62, null));
        }
        AnnotatedString annotatedString = (AnnotatedString) SemanticsConfigurationKt.a(lVarW, semanticsProperties.g());
        if (annotatedString != null) {
            gVarB.b("android.widget.EditText");
            gVarB.f(annotatedString);
        }
        List list2 = (List) SemanticsConfigurationKt.a(lVarW, semanticsProperties.d());
        if (list2 != null) {
            gVarB.c(s2.a.d(list2, "\n", null, null, 0, null, null, 62, null));
        }
        androidx.compose.ui.semantics.i iVar = (androidx.compose.ui.semantics.i) SemanticsConfigurationKt.a(lVarW, semanticsProperties.x());
        if (iVar != null && (strH = i2.h(iVar.n())) != null) {
            gVarB.b(strH);
        }
        a0 a0VarE = i2.e(lVarW);
        if (a0VarE != null) {
            z zVarK = a0VarE.k();
            gVarB.g(w.h(zVarK.i().l()) * zVarK.b().getDensity() * zVarK.b().M0(), 0, 0, 0);
        }
        y1.i iVarH = semanticsNode.h();
        gVarB.d((int) iVarH.f(), (int) iVarH.i(), 0, 0, (int) iVarH.k(), (int) iVarH.e());
        return gVarB;
    }

    public final void z(SemanticsNode semanticsNode) {
        if (k()) {
            C(semanticsNode);
            c(semanticsNode.o(), y(semanticsNode));
            List<SemanticsNode> listT = semanticsNode.t();
            int size = listT.size();
            for (int i11 = 0; i11 < size; i11++) {
                z(listT.get(i11));
            }
        }
    }
}
