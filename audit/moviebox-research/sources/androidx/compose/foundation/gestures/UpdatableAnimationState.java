package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.v0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
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
@Metadata
@SourceDebugExtension
public final class UpdatableAnimationState {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f2349f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f2350g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final androidx.compose.animation.core.k f2351h = new androidx.compose.animation.core.k(0.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0<androidx.compose.animation.core.k> f2352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2353b = Long.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.compose.animation.core.k f2354c = f2351h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2356e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final androidx.compose.animation.core.k a() {
            return UpdatableAnimationState.f2351h;
        }

        public final boolean b(float f11) {
            return Math.abs(f11) < 0.01f;
        }
    }

    public UpdatableAnimationState(androidx.compose.animation.core.g<Float> gVar) {
        this.f2352a = gVar.a(VectorConvertersKt.b(FloatCompanionObject.f68904a));
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0085 A[Catch: all -> 0x00b1, PHI: r0 r1 r2 r13 r14 r15
  0x0085: PHI (r0v9 ??) = (r0v3 ??), (r0v15 ??) binds: [B:30:0x007d, B:38:0x00aa] A[DONT_GENERATE, DONT_INLINE]
  0x0085: PHI (r1v3 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) = 
  (r1v1 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
  (r1v4 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
 binds: [B:30:0x007d, B:38:0x00aa] A[DONT_GENERATE, DONT_INLINE]
  0x0085: PHI (r2v4 java.lang.Object) = (r2v2 java.lang.Object), (r2v5 java.lang.Object) binds: [B:30:0x007d, B:38:0x00aa] A[DONT_GENERATE, DONT_INLINE]
  0x0085: PHI (r13v6 float) = (r13v4 float), (r13v7 float) binds: [B:30:0x007d, B:38:0x00aa] A[DONT_GENERATE, DONT_INLINE]
  0x0085: PHI (r14v8 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>) = 
  (r14v5 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>)
  (r14v9 kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>)
 binds: [B:30:0x007d, B:38:0x00aa] A[DONT_GENERATE, DONT_INLINE]
  0x0085: PHI (r15v16 androidx.compose.foundation.gestures.UpdatableAnimationState) = 
  (r15v10 androidx.compose.foundation.gestures.UpdatableAnimationState)
  (r15v17 androidx.compose.foundation.gestures.UpdatableAnimationState)
 binds: [B:30:0x007d, B:38:0x00aa] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x00b1, blocks: (B:36:0x00a5, B:31:0x0085, B:33:0x008f), top: B:55:0x00a5 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x008f A[Catch: all -> 0x00b1, TryCatch #0 {all -> 0x00b1, blocks: (B:36:0x00a5, B:31:0x0085, B:33:0x008f), top: B:55:0x00a5 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v11, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v0, types: [kotlin.jvm.functions.Function0<kotlin.Unit>] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [androidx.compose.foundation.gestures.UpdatableAnimationState] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v2, types: [androidx.compose.foundation.gestures.UpdatableAnimationState] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a2 -> B:55:0x00a5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object h(kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r13, kotlin.jvm.functions.Function0<kotlin.Unit> r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.h(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final float i() {
        return this.f2356e;
    }

    public final void j(float f11) {
        this.f2356e = f11;
    }
}
