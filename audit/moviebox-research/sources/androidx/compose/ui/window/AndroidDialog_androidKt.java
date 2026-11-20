package androidx.compose.ui.window;

import android.view.View;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.c0;
import androidx.compose.runtime.d0;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g0;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.m;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.s;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.layout.k0;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.layout.u;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.layout.x;
import androidx.compose.ui.layout.y;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.n;
import androidx.compose.ui.semantics.q;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class AndroidDialog_androidKt {
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    /* JADX WARN: Code duplicated, block: B:29:0x004f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0055  */
    /* JADX WARN: Code duplicated, block: B:32:0x0058  */
    /* JADX WARN: Code duplicated, block: B:40:0x006f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:54:0x012f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0137  */
    /* JADX WARN: Code duplicated, block: B:59:0x014d  */
    /* JADX WARN: Code duplicated, block: B:60:0x014f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0158  */
    /* JADX WARN: Code duplicated, block: B:67:0x0167  */
    /* JADX WARN: Code duplicated, block: B:71:0x0173  */
    /* JADX WARN: Code duplicated, block: B:74:0x0188  */
    /* JADX WARN: Code duplicated, block: B:78:0x0192  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    public static final void a(final Function0<Unit> function0, c cVar, final Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        int i13;
        c cVar2;
        int i14;
        View view;
        q2.e eVar;
        final LayoutDirection layoutDirection;
        m mVarC;
        final a3 a3VarI;
        UUID uuid;
        boolean zQ;
        char c11;
        Object obj;
        androidx.compose.runtime.i iVar2;
        final DialogWrapper dialogWrapper;
        boolean zA;
        Object objY;
        boolean z11;
        boolean zQ2;
        Object objY2;
        final c cVar3;
        final c cVar4;
        androidx.compose.runtime.i iVar3;
        g2 g2VarJ;
        androidx.compose.runtime.i iVarG = iVar.g(-2032877254);
        if ((i12 & 1) != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (iVarG.A(function0) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        int i15 = i12 & 2;
        if (i15 == 0) {
            if ((i11 & 48) == 0) {
                cVar2 = cVar;
                i13 |= iVarG.Q(cVar2) ? 32 : 16;
            }
            if ((i12 & 4) != 0) {
                i13 |= 384;
            } else if ((i11 & 384) == 0) {
                if (iVarG.A(function2)) {
                    i14 = 256;
                } else {
                    i14 = 128;
                }
                i13 |= i14;
            }
            if ((i13 & 147) == 146 || !iVarG.h()) {
                if (i15 != 0) {
                    cVar2 = new c(false, false, false, 7, (DefaultConstructorMarker) null);
                }
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-2032877254, i13, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:166)");
                }
                view = (View) iVarG.l(AndroidCompositionLocals_androidKt.j());
                eVar = (q2.e) iVarG.l(CompositionLocalsKt.c());
                layoutDirection = (LayoutDirection) iVarG.l(CompositionLocalsKt.g());
                mVarC = androidx.compose.runtime.g.c(iVarG, 0);
                a3VarI = r2.i(function2, iVarG, (i13 >> 6) & 14);
                uuid = (UUID) RememberSaveableKt.c(new Object[0], null, null, new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1
                    @Override // kotlin.jvm.functions.Function0
                    public final UUID invoke() {
                        return UUID.randomUUID();
                    }
                }, iVarG, 3072, 6);
                zQ = iVarG.Q(view) | iVarG.Q(eVar);
                Object objY3 = iVarG.y();
                if (!zQ || objY3 == androidx.compose.runtime.i.f3413a.a()) {
                    c11 = 4;
                    androidx.compose.runtime.i iVar4 = iVarG;
                    DialogWrapper dialogWrapper2 = new DialogWrapper(function0, cVar2, view, layoutDirection, eVar, uuid);
                    dialogWrapper2.i(mVarC, androidx.compose.runtime.internal.b.c(488261145, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar5, Integer num) {
                            invoke(iVar5, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.runtime.i iVar5, int i16) {
                            if ((i16 & 3) == 2 && iVar5.h()) {
                                iVar5.H();
                                return;
                            }
                            if (androidx.compose.runtime.k.J()) {
                                androidx.compose.runtime.k.S(488261145, i16, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:185)");
                            }
                            androidx.compose.ui.f fVarC = n.c(androidx.compose.ui.f.f3863a, false, new Function1<q, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(q qVar) {
                                    invoke2(qVar);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(q qVar) {
                                    SemanticsPropertiesKt.e(qVar);
                                }
                            }, 1, null);
                            final a3<Function2<androidx.compose.runtime.i, Integer, Unit>> a3Var = a3VarI;
                            AndroidDialog_androidKt.c(fVarC, androidx.compose.runtime.internal.b.e(-533674951, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar6, Integer num) {
                                    invoke(iVar6, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(androidx.compose.runtime.i iVar6, int i17) {
                                    if ((i17 & 3) == 2 && iVar6.h()) {
                                        iVar6.H();
                                        return;
                                    }
                                    if (androidx.compose.runtime.k.J()) {
                                        androidx.compose.runtime.k.S(-533674951, i17, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:188)");
                                    }
                                    AndroidDialog_androidKt.b(a3Var).invoke(iVar6, 0);
                                    if (androidx.compose.runtime.k.J()) {
                                        androidx.compose.runtime.k.R();
                                    }
                                }
                            }, iVar5, 54), iVar5, 48, 0);
                            if (androidx.compose.runtime.k.J()) {
                                androidx.compose.runtime.k.R();
                            }
                        }
                    }));
                    iVar4.p(dialogWrapper2);
                    iVar2 = iVar4;
                    obj = dialogWrapper2;
                } else {
                    iVar2 = iVarG;
                    c11 = 4;
                    obj = objY3;
                }
                dialogWrapper = (DialogWrapper) obj;
                zA = iVar2.A(dialogWrapper);
                objY = iVar2.y();
                if (zA || objY == androidx.compose.runtime.i.f3413a.a()) {
                    objY = new Function1<d0, c0>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1

                        /* JADX INFO: compiled from: source.java */
                        @Metadata
                        @SourceDebugExtension
                        public static final class a implements c0 {

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            public final /* synthetic */ DialogWrapper f6220a;

                            public a(DialogWrapper dialogWrapper) {
                                this.f6220a = dialogWrapper;
                            }

                            @Override // androidx.compose.runtime.c0
                            public void dispose() {
                                this.f6220a.dismiss();
                                this.f6220a.h();
                            }
                        }

                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final c0 invoke(d0 d0Var) {
                            dialogWrapper.show();
                            return new a(dialogWrapper);
                        }
                    };
                    iVar2.p(objY);
                }
                g0.a(dialogWrapper, (Function1) objY, iVar2, 0);
                boolean zA2 = iVar2.A(dialogWrapper);
                if ((i13 & 14) == c11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zQ2 = zA2 | z11 | ((i13 & 112) == 32) | iVar2.Q(layoutDirection);
                objY2 = iVar2.y();
                if (!zQ2 || objY2 == androidx.compose.runtime.i.f3413a.a()) {
                    cVar3 = cVar2;
                    objY2 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            dialogWrapper.l(function0, cVar3, layoutDirection);
                        }
                    };
                    iVar2.p(objY2);
                } else {
                    cVar3 = cVar2;
                }
                g0.e((Function0) objY2, iVar2, 0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                cVar4 = cVar3;
                iVar3 = iVar2;
            } else {
                iVarG.H();
                cVar4 = cVar2;
                iVar3 = iVarG;
            }
            g2VarJ = iVar3.j();
            if (g2VarJ != null) {
                g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar5, Integer num) {
                        invoke(iVar5, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar5, int i16) {
                        AndroidDialog_androidKt.a(function0, cVar4, function2, iVar5, v1.a(i11 | 1), i12);
                    }
                });
            }
        }
        i13 |= 48;
        cVar2 = cVar;
        if ((i12 & 4) != 0) {
            i13 |= 384;
        } else if ((i11 & 384) == 0) {
            if (iVarG.A(function2)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i13 |= i14;
        }
        if ((i13 & 147) == 146) {
            if (i15 != 0) {
                cVar2 = new c(false, false, false, 7, (DefaultConstructorMarker) null);
            }
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-2032877254, i13, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:166)");
            }
            view = (View) iVarG.l(AndroidCompositionLocals_androidKt.j());
            eVar = (q2.e) iVarG.l(CompositionLocalsKt.c());
            layoutDirection = (LayoutDirection) iVarG.l(CompositionLocalsKt.g());
            mVarC = androidx.compose.runtime.g.c(iVarG, 0);
            a3VarI = r2.i(function2, iVarG, (i13 >> 6) & 14);
            uuid = (UUID) RememberSaveableKt.c(new Object[0], null, null, new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, iVarG, 3072, 6);
            zQ = iVarG.Q(view) | iVarG.Q(eVar);
            Object objY4 = iVarG.y();
            if (zQ) {
                c11 = 4;
                androidx.compose.runtime.i iVar5 = iVarG;
                DialogWrapper dialogWrapper3 = new DialogWrapper(function0, cVar2, view, layoutDirection, eVar, uuid);
                dialogWrapper3.i(mVarC, androidx.compose.runtime.internal.b.c(488261145, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar6, Integer num) {
                        invoke(iVar6, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar6, int i16) {
                        if ((i16 & 3) == 2 && iVar6.h()) {
                            iVar6.H();
                            return;
                        }
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(488261145, i16, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:185)");
                        }
                        androidx.compose.ui.f fVarC = n.c(androidx.compose.ui.f.f3863a, false, new Function1<q, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(q qVar) {
                                invoke2(qVar);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(q qVar) {
                                SemanticsPropertiesKt.e(qVar);
                            }
                        }, 1, null);
                        final a3<? extends Function2<? super androidx.compose.runtime.i, ? super Integer, Unit>> a3Var = a3VarI;
                        AndroidDialog_androidKt.c(fVarC, androidx.compose.runtime.internal.b.e(-533674951, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar7, Integer num) {
                                invoke(iVar7, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(androidx.compose.runtime.i iVar7, int i17) {
                                if ((i17 & 3) == 2 && iVar7.h()) {
                                    iVar7.H();
                                    return;
                                }
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.S(-533674951, i17, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:188)");
                                }
                                AndroidDialog_androidKt.b(a3Var).invoke(iVar7, 0);
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.R();
                                }
                            }
                        }, iVar6, 54), iVar6, 48, 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                    }
                }));
                iVar5.p(dialogWrapper3);
                iVar2 = iVar5;
                obj = dialogWrapper3;
            } else {
                c11 = 4;
                androidx.compose.runtime.i iVar6 = iVarG;
                DialogWrapper dialogWrapper4 = new DialogWrapper(function0, cVar2, view, layoutDirection, eVar, uuid);
                dialogWrapper4.i(mVarC, androidx.compose.runtime.internal.b.c(488261145, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar7, Integer num) {
                        invoke(iVar7, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar7, int i16) {
                        if ((i16 & 3) == 2 && iVar7.h()) {
                            iVar7.H();
                            return;
                        }
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(488261145, i16, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:185)");
                        }
                        androidx.compose.ui.f fVarC = n.c(androidx.compose.ui.f.f3863a, false, new Function1<q, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(q qVar) {
                                invoke2(qVar);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(q qVar) {
                                SemanticsPropertiesKt.e(qVar);
                            }
                        }, 1, null);
                        final a3<? extends Function2<? super androidx.compose.runtime.i, ? super Integer, Unit>> a3Var = a3VarI;
                        AndroidDialog_androidKt.c(fVarC, androidx.compose.runtime.internal.b.e(-533674951, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar8, Integer num) {
                                invoke(iVar8, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(androidx.compose.runtime.i iVar8, int i17) {
                                if ((i17 & 3) == 2 && iVar8.h()) {
                                    iVar8.H();
                                    return;
                                }
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.S(-533674951, i17, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:188)");
                                }
                                AndroidDialog_androidKt.b(a3Var).invoke(iVar8, 0);
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.R();
                                }
                            }
                        }, iVar7, 54), iVar7, 48, 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                    }
                }));
                iVar6.p(dialogWrapper4);
                iVar2 = iVar6;
                obj = dialogWrapper4;
            }
            dialogWrapper = (DialogWrapper) obj;
            zA = iVar2.A(dialogWrapper);
            objY = iVar2.y();
            if (zA) {
                objY = new Function1<d0, c0>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1

                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @SourceDebugExtension
                    public static final class a implements c0 {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ DialogWrapper f6220a;

                        public a(DialogWrapper dialogWrapper) {
                            this.f6220a = dialogWrapper;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f6220a.dismiss();
                            this.f6220a.h();
                        }
                    }

                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final c0 invoke(d0 d0Var) {
                        dialogWrapper.show();
                        return new a(dialogWrapper);
                    }
                };
                iVar2.p(objY);
            } else {
                objY = new Function1<d0, c0>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1

                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @SourceDebugExtension
                    public static final class a implements c0 {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ DialogWrapper f6220a;

                        public a(DialogWrapper dialogWrapper) {
                            this.f6220a = dialogWrapper;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f6220a.dismiss();
                            this.f6220a.h();
                        }
                    }

                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final c0 invoke(d0 d0Var) {
                        dialogWrapper.show();
                        return new a(dialogWrapper);
                    }
                };
                iVar2.p(objY);
            }
            g0.a(dialogWrapper, (Function1) objY, iVar2, 0);
            boolean zA3 = iVar2.A(dialogWrapper);
            if ((i13 & 14) == c11) {
                z11 = true;
            } else {
                z11 = false;
            }
            zQ2 = zA3 | z11 | ((i13 & 112) == 32) | iVar2.Q(layoutDirection);
            objY2 = iVar2.y();
            if (zQ2) {
                cVar3 = cVar2;
                objY2 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        dialogWrapper.l(function0, cVar3, layoutDirection);
                    }
                };
                iVar2.p(objY2);
            } else {
                cVar3 = cVar2;
                objY2 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        dialogWrapper.l(function0, cVar3, layoutDirection);
                    }
                };
                iVar2.p(objY2);
            }
            g0.e((Function0) objY2, iVar2, 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
            cVar4 = cVar3;
            iVar3 = iVar2;
        } else {
            if (i15 != 0) {
                cVar2 = new c(false, false, false, 7, (DefaultConstructorMarker) null);
            }
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-2032877254, i13, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:166)");
            }
            view = (View) iVarG.l(AndroidCompositionLocals_androidKt.j());
            eVar = (q2.e) iVarG.l(CompositionLocalsKt.c());
            layoutDirection = (LayoutDirection) iVarG.l(CompositionLocalsKt.g());
            mVarC = androidx.compose.runtime.g.c(iVarG, 0);
            a3VarI = r2.i(function2, iVarG, (i13 >> 6) & 14);
            uuid = (UUID) RememberSaveableKt.c(new Object[0], null, null, new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, iVarG, 3072, 6);
            zQ = iVarG.Q(view) | iVarG.Q(eVar);
            Object objY5 = iVarG.y();
            if (zQ) {
                c11 = 4;
                androidx.compose.runtime.i iVar7 = iVarG;
                DialogWrapper dialogWrapper5 = new DialogWrapper(function0, cVar2, view, layoutDirection, eVar, uuid);
                dialogWrapper5.i(mVarC, androidx.compose.runtime.internal.b.c(488261145, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar8, Integer num) {
                        invoke(iVar8, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar8, int i16) {
                        if ((i16 & 3) == 2 && iVar8.h()) {
                            iVar8.H();
                            return;
                        }
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(488261145, i16, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:185)");
                        }
                        androidx.compose.ui.f fVarC = n.c(androidx.compose.ui.f.f3863a, false, new Function1<q, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(q qVar) {
                                invoke2(qVar);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(q qVar) {
                                SemanticsPropertiesKt.e(qVar);
                            }
                        }, 1, null);
                        final a3<? extends Function2<? super androidx.compose.runtime.i, ? super Integer, Unit>> a3Var = a3VarI;
                        AndroidDialog_androidKt.c(fVarC, androidx.compose.runtime.internal.b.e(-533674951, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                                invoke(iVar9, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(androidx.compose.runtime.i iVar9, int i17) {
                                if ((i17 & 3) == 2 && iVar9.h()) {
                                    iVar9.H();
                                    return;
                                }
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.S(-533674951, i17, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:188)");
                                }
                                AndroidDialog_androidKt.b(a3Var).invoke(iVar9, 0);
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.R();
                                }
                            }
                        }, iVar8, 54), iVar8, 48, 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                    }
                }));
                iVar7.p(dialogWrapper5);
                iVar2 = iVar7;
                obj = dialogWrapper5;
            } else {
                c11 = 4;
                androidx.compose.runtime.i iVar8 = iVarG;
                DialogWrapper dialogWrapper6 = new DialogWrapper(function0, cVar2, view, layoutDirection, eVar, uuid);
                dialogWrapper6.i(mVarC, androidx.compose.runtime.internal.b.c(488261145, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                        invoke(iVar9, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar9, int i16) {
                        if ((i16 & 3) == 2 && iVar9.h()) {
                            iVar9.H();
                            return;
                        }
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(488261145, i16, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:185)");
                        }
                        androidx.compose.ui.f fVarC = n.c(androidx.compose.ui.f.f3863a, false, new Function1<q, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(q qVar) {
                                invoke2(qVar);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(q qVar) {
                                SemanticsPropertiesKt.e(qVar);
                            }
                        }, 1, null);
                        final a3<? extends Function2<? super androidx.compose.runtime.i, ? super Integer, Unit>> a3Var = a3VarI;
                        AndroidDialog_androidKt.c(fVarC, androidx.compose.runtime.internal.b.e(-533674951, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar10, Integer num) {
                                invoke(iVar10, num.intValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(androidx.compose.runtime.i iVar10, int i17) {
                                if ((i17 & 3) == 2 && iVar10.h()) {
                                    iVar10.H();
                                    return;
                                }
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.S(-533674951, i17, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:188)");
                                }
                                AndroidDialog_androidKt.b(a3Var).invoke(iVar10, 0);
                                if (androidx.compose.runtime.k.J()) {
                                    androidx.compose.runtime.k.R();
                                }
                            }
                        }, iVar9, 54), iVar9, 48, 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                    }
                }));
                iVar8.p(dialogWrapper6);
                iVar2 = iVar8;
                obj = dialogWrapper6;
            }
            dialogWrapper = (DialogWrapper) obj;
            zA = iVar2.A(dialogWrapper);
            objY = iVar2.y();
            if (zA) {
                objY = new Function1<d0, c0>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1

                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @SourceDebugExtension
                    public static final class a implements c0 {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ DialogWrapper f6220a;

                        public a(DialogWrapper dialogWrapper) {
                            this.f6220a = dialogWrapper;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f6220a.dismiss();
                            this.f6220a.h();
                        }
                    }

                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final c0 invoke(d0 d0Var) {
                        dialogWrapper.show();
                        return new a(dialogWrapper);
                    }
                };
                iVar2.p(objY);
            } else {
                objY = new Function1<d0, c0>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1

                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @SourceDebugExtension
                    public static final class a implements c0 {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ DialogWrapper f6220a;

                        public a(DialogWrapper dialogWrapper) {
                            this.f6220a = dialogWrapper;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f6220a.dismiss();
                            this.f6220a.h();
                        }
                    }

                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final c0 invoke(d0 d0Var) {
                        dialogWrapper.show();
                        return new a(dialogWrapper);
                    }
                };
                iVar2.p(objY);
            }
            g0.a(dialogWrapper, (Function1) objY, iVar2, 0);
            boolean zA4 = iVar2.A(dialogWrapper);
            if ((i13 & 14) == c11) {
                z11 = true;
            } else {
                z11 = false;
            }
            zQ2 = zA4 | z11 | ((i13 & 112) == 32) | iVar2.Q(layoutDirection);
            objY2 = iVar2.y();
            if (zQ2) {
                cVar3 = cVar2;
                objY2 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        dialogWrapper.l(function0, cVar3, layoutDirection);
                    }
                };
                iVar2.p(objY2);
            } else {
                cVar3 = cVar2;
                objY2 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        dialogWrapper.l(function0, cVar3, layoutDirection);
                    }
                };
                iVar2.p(objY2);
            }
            g0.e((Function0) objY2, iVar2, 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
            cVar4 = cVar3;
            iVar3 = iVar2;
        }
        g2VarJ = iVar3.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar9, Integer num) {
                    invoke(iVar9, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar9, int i16) {
                    AndroidDialog_androidKt.a(function0, cVar4, function2, iVar9, v1.a(i11 | 1), i12);
                }
            });
        }
    }

    public static final Function2<androidx.compose.runtime.i, Integer, Unit> b(a3<? extends Function2<? super androidx.compose.runtime.i, ? super Integer, Unit>> a3Var) {
        return (Function2) a3Var.getValue();
    }

    public static final void c(final androidx.compose.ui.f fVar, final Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        int i13;
        androidx.compose.runtime.i iVarG = iVar.g(-1177876616);
        int i14 = i12 & 1;
        if (i14 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (iVarG.Q(fVar) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i11 & 48) == 0) {
            i13 |= iVarG.A(function2) ? 32 : 16;
        }
        if ((i13 & 19) == 18 && iVarG.h()) {
            iVarG.H();
        } else {
            if (i14 != 0) {
                fVar = androidx.compose.ui.f.f3863a;
            }
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-1177876616, i13, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:464)");
            }
            AndroidDialog_androidKt$DialogLayout$1 androidDialog_androidKt$DialogLayout$1 = new u() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1
                @Override // androidx.compose.ui.layout.u
                public final w c(y yVar, List<? extends t> list, long j11) {
                    Object obj;
                    final ArrayList arrayList = new ArrayList(list.size());
                    int size = list.size();
                    for (int i15 = 0; i15 < size; i15++) {
                        arrayList.add(list.get(i15).L(j11));
                    }
                    Object obj2 = null;
                    int i16 = 1;
                    if (!arrayList.isEmpty()) {
                        obj = arrayList.get(0);
                        int iS0 = ((k0) obj).s0();
                        int iN = kotlin.collections.g.n(arrayList);
                        if (1 <= iN) {
                            int i17 = 1;
                            while (true) {
                                Object obj3 = arrayList.get(i17);
                                int iS1 = ((k0) obj3).s0();
                                if (iS0 < iS1) {
                                    obj = obj3;
                                    iS0 = iS1;
                                }
                                if (i17 == iN) {
                                    break;
                                }
                                i17++;
                            }
                        }
                    } else {
                        obj = null;
                    }
                    k0 k0Var = (k0) obj;
                    int iS2 = k0Var != null ? k0Var.s0() : q2.b.n(j11);
                    if (!arrayList.isEmpty()) {
                        Object obj4 = arrayList.get(0);
                        int iG0 = ((k0) obj4).g0();
                        int iN2 = kotlin.collections.g.n(arrayList);
                        if (1 <= iN2) {
                            while (true) {
                                Object obj5 = arrayList.get(i16);
                                int iG1 = ((k0) obj5).g0();
                                if (iG0 < iG1) {
                                    obj4 = obj5;
                                    iG0 = iG1;
                                }
                                if (i16 == iN2) {
                                    break;
                                }
                                i16++;
                            }
                        }
                        obj2 = obj4;
                    }
                    k0 k0Var2 = (k0) obj2;
                    return x.b(yVar, iS2, k0Var2 != null ? k0Var2.g0() : q2.b.m(j11), null, new Function1<k0.a, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar) {
                            invoke2(aVar);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(k0.a aVar) {
                            List<k0> list2 = arrayList;
                            int size2 = list2.size();
                            for (int i18 = 0; i18 < size2; i18++) {
                                k0.a.l(aVar, list2.get(i18), 0, 0, 0.0f, 4, null);
                            }
                        }
                    }, 4, null);
                }
            };
            int i15 = ((i13 >> 3) & 14) | 384 | ((i13 << 3) & 112);
            int iA = androidx.compose.runtime.g.a(iVarG, 0);
            s sVarN = iVarG.n();
            androidx.compose.ui.f fVarE = ComposedModifierKt.e(iVarG, fVar);
            ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
            Function0<ComposeUiNode> function0A = companion.a();
            int i16 = ((i15 << 6) & 896) | 6;
            if (!(iVarG.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVarG.D();
            if (iVarG.e()) {
                iVarG.G(function0A);
            } else {
                iVarG.o();
            }
            androidx.compose.runtime.i iVarA = f3.a(iVarG);
            f3.b(iVarA, androidDialog_androidKt$DialogLayout$1, companion.c());
            f3.b(iVarA, sVarN, companion.e());
            Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
            if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
                iVarA.p(Integer.valueOf(iA));
                iVarA.k(Integer.valueOf(iA), function2B);
            }
            f3.b(iVarA, fVarE, companion.d());
            function2.invoke(iVarG, Integer.valueOf((i16 >> 6) & 14));
            iVarG.r();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$2
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

                public final void invoke(androidx.compose.runtime.i iVar2, int i17) {
                    AndroidDialog_androidKt.c(fVar, function2, iVar2, v1.a(i11 | 1), i12);
                }
            });
        }
    }
}
