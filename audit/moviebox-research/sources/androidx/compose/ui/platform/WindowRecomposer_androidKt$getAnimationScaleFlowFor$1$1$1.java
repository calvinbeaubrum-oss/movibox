package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1", f = "WindowRecomposer.android.kt", l = {117, 123}, m = "invokeSuspend")
public final class WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super Float>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $animationScaleUri;
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ kotlinx.coroutines.channels.a<Unit> $channel;
    final /* synthetic */ WindowRecomposer_androidKt.b $contentObserver;
    final /* synthetic */ ContentResolver $resolver;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(ContentResolver contentResolver, Uri uri, WindowRecomposer_androidKt.b bVar, kotlinx.coroutines.channels.a<Unit> aVar, Context context, Continuation<? super WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1> continuation) {
        super(2, continuation);
        this.$resolver = contentResolver;
        this.$animationScaleUri = uri;
        this.$contentObserver = bVar;
        this.$channel = aVar;
        this.$applicationContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(this.$resolver, this.$animationScaleUri, this.$contentObserver, this.$channel, this.$applicationContext, continuation);
        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$0 = obj;
        return windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.flow.b<? super Float> bVar, Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0059 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x005a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0065 A[Catch: all -> 0x0089, TRY_LEAVE, TryCatch #0 {all -> 0x0089, blocks: (B:19:0x004d, B:23:0x005d, B:25:0x0065), top: B:35:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0086 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0087 -> B:35:0x004d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L35
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.c r1 = (kotlinx.coroutines.channels.c) r1
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.flow.b r4 = (kotlinx.coroutines.flow.b) r4
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L1b
            r10 = r4
            goto L4c
        L1b:
            r10 = move-exception
            r4 = r9
            goto L95
        L1f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L27:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.c r1 = (kotlinx.coroutines.channels.c) r1
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.flow.b r4 = (kotlinx.coroutines.flow.b) r4
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L1b
            r5 = r4
            r4 = r9
            goto L5d
        L35:
            kotlin.ResultKt.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.flow.b r10 = (kotlinx.coroutines.flow.b) r10
            android.content.ContentResolver r1 = r9.$resolver
            android.net.Uri r4 = r9.$animationScaleUri
            r5 = 0
            androidx.compose.ui.platform.WindowRecomposer_androidKt$b r6 = r9.$contentObserver
            r1.registerContentObserver(r4, r5, r6)
            kotlinx.coroutines.channels.a<kotlin.Unit> r1 = r9.$channel     // Catch: java.lang.Throwable -> L1b
            kotlinx.coroutines.channels.c r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1b
        L4c:
            r4 = r9
        L4d:
            r4.L$0 = r10     // Catch: java.lang.Throwable -> L89
            r4.L$1 = r1     // Catch: java.lang.Throwable -> L89
            r4.label = r3     // Catch: java.lang.Throwable -> L89
            java.lang.Object r5 = r1.a(r4)     // Catch: java.lang.Throwable -> L89
            if (r5 != r0) goto L5a
            return r0
        L5a:
            r8 = r5
            r5 = r10
            r10 = r8
        L5d:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L89
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L89
            if (r10 == 0) goto L8b
            r1.next()     // Catch: java.lang.Throwable -> L89
            android.content.Context r10 = r4.$applicationContext     // Catch: java.lang.Throwable -> L89
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L89
            java.lang.String r6 = "animator_duration_scale"
            r7 = 1065353216(0x3f800000, float:1.0)
            float r10 = android.provider.Settings.Global.getFloat(r10, r6, r7)     // Catch: java.lang.Throwable -> L89
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.c(r10)     // Catch: java.lang.Throwable -> L89
            r4.L$0 = r5     // Catch: java.lang.Throwable -> L89
            r4.L$1 = r1     // Catch: java.lang.Throwable -> L89
            r4.label = r2     // Catch: java.lang.Throwable -> L89
            java.lang.Object r10 = r5.emit(r10, r4)     // Catch: java.lang.Throwable -> L89
            if (r10 != r0) goto L87
            return r0
        L87:
            r10 = r5
            goto L4d
        L89:
            r10 = move-exception
            goto L95
        L8b:
            android.content.ContentResolver r10 = r4.$resolver
            androidx.compose.ui.platform.WindowRecomposer_androidKt$b r0 = r4.$contentObserver
            r10.unregisterContentObserver(r0)
            kotlin.Unit r10 = kotlin.Unit.f68710a
            return r10
        L95:
            android.content.ContentResolver r0 = r4.$resolver
            androidx.compose.ui.platform.WindowRecomposer_androidKt$b r1 = r4.$contentObserver
            r0.unregisterContentObserver(r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
