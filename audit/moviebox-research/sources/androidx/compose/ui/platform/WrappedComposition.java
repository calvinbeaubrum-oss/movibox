package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.R$id;
import androidx.lifecycle.Lifecycle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;

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
public final class WrappedComposition implements androidx.compose.runtime.l, androidx.lifecycle.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AndroidComposeView f5415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.compose.runtime.l f5416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Lifecycle f5418d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> f5419f = ComposableSingletons$Wrapper_androidKt.f5301a.a();

    public WrappedComposition(AndroidComposeView androidComposeView, androidx.compose.runtime.l lVar) {
        this.f5415a = androidComposeView;
        this.f5416b = lVar;
    }

    @Override // androidx.compose.runtime.l
    public void d(final Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        this.f5415a.setOnViewTreeOwnersAvailable(new Function1<AndroidComposeView.b, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AndroidComposeView.b bVar) {
                invoke2(bVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AndroidComposeView.b bVar) {
                if (this.this$0.f5417c) {
                    return;
                }
                Lifecycle lifecycle = bVar.a().getLifecycle();
                this.this$0.f5419f = function2;
                if (this.this$0.f5418d == null) {
                    this.this$0.f5418d = lifecycle;
                    lifecycle.a(this.this$0);
                } else if (lifecycle.b().isAtLeast(Lifecycle.State.CREATED)) {
                    androidx.compose.runtime.l lVarX = this.this$0.x();
                    final WrappedComposition wrappedComposition = this.this$0;
                    final Function2<androidx.compose.runtime.i, Integer, Unit> function3 = function2;
                    lVarX.d(androidx.compose.runtime.internal.b.c(-2000640158, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar, Integer num) {
                            invoke(iVar, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar, int i11) {
                            if ((i11 & 3) == 2 && iVar.h()) {
                                iVar.H();
                                return;
                            }
                            if (androidx.compose.runtime.k.J()) {
                                androidx.compose.runtime.k.S(-2000640158, i11, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:134)");
                            }
                            Object tag = wrappedComposition.y().getTag(R$id.inspection_slot_table_set);
                            Set<w1.a> set = TypeIntrinsics.n(tag) ? (Set) tag : null;
                            if (set == null) {
                                Object parent = wrappedComposition.y().getParent();
                                View view = parent instanceof View ? (View) parent : null;
                                Object tag2 = view != null ? view.getTag(R$id.inspection_slot_table_set) : null;
                                set = TypeIntrinsics.n(tag2) ? (Set) tag2 : null;
                            }
                            if (set != null) {
                                set.add(iVar.z());
                                iVar.u();
                            }
                            AndroidComposeView androidComposeViewY = wrappedComposition.y();
                            boolean zA = iVar.A(wrappedComposition);
                            WrappedComposition wrappedComposition2 = wrappedComposition;
                            Object objY = iVar.y();
                            if (zA || objY == androidx.compose.runtime.i.f3413a.a()) {
                                objY = new WrappedComposition$setContent$1$1$1$1(wrappedComposition2, null);
                                iVar.p(objY);
                            }
                            androidx.compose.runtime.g0.d(androidComposeViewY, (Function2) objY, iVar, 0);
                            AndroidComposeView androidComposeViewY2 = wrappedComposition.y();
                            boolean zA2 = iVar.A(wrappedComposition);
                            WrappedComposition wrappedComposition3 = wrappedComposition;
                            Object objY2 = iVar.y();
                            if (zA2 || objY2 == androidx.compose.runtime.i.f3413a.a()) {
                                objY2 = new WrappedComposition$setContent$1$1$2$1(wrappedComposition3, null);
                                iVar.p(objY2);
                            }
                            androidx.compose.runtime.g0.d(androidComposeViewY2, (Function2) objY2, iVar, 0);
                            androidx.compose.runtime.t1<Set<w1.a>> t1VarD = InspectionTablesKt.a().d(set);
                            final WrappedComposition wrappedComposition4 = wrappedComposition;
                            final Function2<androidx.compose.runtime.i, Integer, Unit> function4 = function3;
                            CompositionLocalKt.a(t1VarD, androidx.compose.runtime.internal.b.e(-1193460702, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition.setContent.1.1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                                    invoke(iVar2, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(androidx.compose.runtime.i iVar2, int i12) {
                                    if ((i12 & 3) == 2 && iVar2.h()) {
                                        iVar2.H();
                                        return;
                                    }
                                    if (androidx.compose.runtime.k.J()) {
                                        androidx.compose.runtime.k.S(-1193460702, i12, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:154)");
                                    }
                                    AndroidCompositionLocals_androidKt.a(wrappedComposition4.y(), function4, iVar2, 0);
                                    if (androidx.compose.runtime.k.J()) {
                                        androidx.compose.runtime.k.R();
                                    }
                                }
                            }, iVar, 54), iVar, androidx.compose.runtime.t1.f3721i | 48);
                            if (androidx.compose.runtime.k.J()) {
                                androidx.compose.runtime.k.R();
                            }
                        }
                    }));
                }
            }
        });
    }

    @Override // androidx.compose.runtime.l
    public void dispose() {
        if (!this.f5417c) {
            this.f5417c = true;
            this.f5415a.getView().setTag(R$id.wrapped_composition_tag, null);
            Lifecycle lifecycle = this.f5418d;
            if (lifecycle != null) {
                lifecycle.d(this);
            }
        }
        this.f5416b.dispose();
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(androidx.lifecycle.u uVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else {
            if (event != Lifecycle.Event.ON_CREATE || this.f5417c) {
                return;
            }
            d(this.f5419f);
        }
    }

    public final androidx.compose.runtime.l x() {
        return this.f5416b;
    }

    public final AndroidComposeView y() {
        return this.f5415a;
    }
}
