package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
@Metadata
@SourceDebugExtension
public final class PointerInteropFilter$pointerInputFilter$1 extends f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointerInteropFilter.DispatchToViewState f4644b = PointerInteropFilter.DispatchToViewState.Unknown;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PointerInteropFilter f4645c;

    public PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter pointerInteropFilter) {
        this.f4645c = pointerInteropFilter;
    }

    @Override // androidx.compose.ui.input.pointer.f0
    public boolean c() {
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.f0
    public void d() {
        if (this.f4644b == PointerInteropFilter.DispatchToViewState.Dispatching) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            final PointerInteropFilter pointerInteropFilter = this.f4645c;
            i0.a(jUptimeMillis, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$onCancel$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                    invoke2(motionEvent);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MotionEvent motionEvent) {
                    pointerInteropFilter.o().invoke(motionEvent);
                }
            });
            i();
        }
    }

    @Override // androidx.compose.ui.input.pointer.f0
    public void e(q qVar, PointerEventPass pointerEventPass, long j11) {
        boolean z11;
        List<z> listC = qVar.c();
        if (this.f4645c.a()) {
            z11 = true;
            break;
        }
        int size = listC.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                z11 = false;
                break;
            }
            z zVar = listC.get(i11);
            if (r.b(zVar) || r.d(zVar)) {
                z11 = true;
                break;
            }
            i11++;
        }
        if (this.f4644b != PointerInteropFilter.DispatchToViewState.NotDispatching) {
            if (pointerEventPass == PointerEventPass.Initial && z11) {
                h(qVar);
            }
            if (pointerEventPass == PointerEventPass.Final && !z11) {
                h(qVar);
            }
        }
        if (pointerEventPass == PointerEventPass.Final) {
            int size2 = listC.size();
            for (int i12 = 0; i12 < size2; i12++) {
                if (!r.d(listC.get(i12))) {
                    return;
                }
            }
            i();
        }
    }

    public final void h(q qVar) {
        List<z> listC = qVar.c();
        int size = listC.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (listC.get(i11).p()) {
                if (this.f4644b == PointerInteropFilter.DispatchToViewState.Dispatching) {
                    androidx.compose.ui.layout.m mVarB = b();
                    if (mVarB == null) {
                        throw new IllegalStateException("layoutCoordinates not set".toString());
                    }
                    long jV = mVarB.V(y1.g.f81070b.c());
                    final PointerInteropFilter pointerInteropFilter = this.f4645c;
                    i0.b(qVar, jV, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                            invoke2(motionEvent);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(MotionEvent motionEvent) {
                            pointerInteropFilter.o().invoke(motionEvent);
                        }
                    });
                }
                this.f4644b = PointerInteropFilter.DispatchToViewState.NotDispatching;
                return;
            }
        }
        androidx.compose.ui.layout.m mVarB2 = b();
        if (mVarB2 == null) {
            throw new IllegalStateException("layoutCoordinates not set".toString());
        }
        long jV2 = mVarB2.V(y1.g.f81070b.c());
        final PointerInteropFilter pointerInteropFilter2 = this.f4645c;
        i0.c(qVar, jV2, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                invoke2(motionEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 0) {
                    pointerInteropFilter2.o().invoke(motionEvent);
                } else {
                    this.this$0.f4644b = pointerInteropFilter2.o().invoke(motionEvent).booleanValue() ? PointerInteropFilter.DispatchToViewState.Dispatching : PointerInteropFilter.DispatchToViewState.NotDispatching;
                }
            }
        });
        if (this.f4644b == PointerInteropFilter.DispatchToViewState.Dispatching) {
            int size2 = listC.size();
            for (int i12 = 0; i12 < size2; i12++) {
                listC.get(i12).a();
            }
            i iVarD = qVar.d();
            if (iVarD == null) {
                return;
            }
            iVarD.e(!this.f4645c.a());
        }
    }

    public final void i() {
        this.f4644b = PointerInteropFilter.DispatchToViewState.Unknown;
        this.f4645c.p(false);
    }
}
