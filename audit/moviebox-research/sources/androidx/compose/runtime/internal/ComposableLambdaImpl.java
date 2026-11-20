package androidx.compose.runtime.internal;

import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.u1;
import androidx.compose.runtime.v1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

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
public final class ComposableLambdaImpl implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f3436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u1 f3437d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<u1> f3438f;

    public ComposableLambdaImpl(int i11, boolean z11, Object obj) {
        this.f3434a = i11;
        this.f3435b = z11;
        this.f3436c = obj;
    }

    public Object a(i iVar, int i11) {
        i iVarG = iVar.g(this.f3434a);
        g(iVarG);
        int iD = i11 | (iVarG.Q(this) ? b.d(0) : b.g(0));
        Object obj = this.f3436c;
        Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object objInvoke = ((Function2) TypeIntrinsics.e(obj, 2)).invoke(iVarG, Integer.valueOf(iD));
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            Intrinsics.e(this, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>");
            g2VarJ.a((Function2) TypeIntrinsics.e(this, 2));
        }
        return objInvoke;
    }

    public Object b(final Object obj, i iVar, final int i11) {
        i iVarG = iVar.g(this.f3434a);
        g(iVarG);
        int iD = iVarG.Q(this) ? b.d(1) : b.g(1);
        Object obj2 = this.f3436c;
        Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object objInvoke = ((Function3) TypeIntrinsics.e(obj2, 3)).invoke(obj, iVarG, Integer.valueOf(iD | i11));
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(i iVar2, int i12) {
                    ComposableLambdaImpl.this.b(obj, iVar2, v1.a(i11) | 1);
                }
            });
        }
        return objInvoke;
    }

    public Object c(final Object obj, final Object obj2, i iVar, final int i11) {
        i iVarG = iVar.g(this.f3434a);
        g(iVarG);
        int iD = iVarG.Q(this) ? b.d(2) : b.g(2);
        Object obj3 = this.f3436c;
        Intrinsics.e(obj3, "null cannot be cast to non-null type kotlin.Function4<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object objInvoke = ((Function4) TypeIntrinsics.e(obj3, 4)).invoke(obj, obj2, iVarG, Integer.valueOf(iD | i11));
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(i iVar2, int i12) {
                    ComposableLambdaImpl.this.c(obj, obj2, iVar2, v1.a(i11) | 1);
                }
            });
        }
        return objInvoke;
    }

    public Object d(final Object obj, final Object obj2, final Object obj3, i iVar, final int i11) {
        i iVarG = iVar.g(this.f3434a);
        g(iVarG);
        int iD = iVarG.Q(this) ? b.d(3) : b.g(3);
        Object obj4 = this.f3436c;
        Intrinsics.e(obj4, "null cannot be cast to non-null type kotlin.Function5<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object objInvoke = ((Function5) TypeIntrinsics.e(obj4, 5)).invoke(obj, obj2, obj3, iVarG, Integer.valueOf(iD | i11));
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(i iVar2, int i12) {
                    ComposableLambdaImpl.this.d(obj, obj2, obj3, iVar2, v1.a(i11) | 1);
                }
            });
        }
        return objInvoke;
    }

    public Object e(final Object obj, final Object obj2, final Object obj3, final Object obj4, i iVar, final int i11) {
        i iVarG = iVar.g(this.f3434a);
        g(iVarG);
        int iD = iVarG.Q(this) ? b.d(4) : b.g(4);
        Object obj5 = this.f3436c;
        Intrinsics.e(obj5, "null cannot be cast to non-null type kotlin.Function6<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object objInvoke = ((Function6) TypeIntrinsics.e(obj5, 6)).invoke(obj, obj2, obj3, obj4, iVarG, Integer.valueOf(iD | i11));
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(i iVar2, int i12) {
                    ComposableLambdaImpl.this.e(obj, obj2, obj3, obj4, iVar2, v1.a(i11) | 1);
                }
            });
        }
        return objInvoke;
    }

    public Object f(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, i iVar, final int i11) {
        i iVarG = iVar.g(this.f3434a);
        g(iVarG);
        int iD = iVarG.Q(this) ? b.d(5) : b.g(5);
        Object obj6 = this.f3436c;
        Intrinsics.e(obj6, "null cannot be cast to non-null type kotlin.Function7<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'p5')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object objInvoke = ((Function7) TypeIntrinsics.e(obj6, 7)).invoke(obj, obj2, obj3, obj4, obj5, iVarG, Integer.valueOf(i11 | iD));
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(i iVar2, int i12) {
                    ComposableLambdaImpl.this.f(obj, obj2, obj3, obj4, obj5, iVar2, v1.a(i11) | 1);
                }
            });
        }
        return objInvoke;
    }

    public final void g(i iVar) {
        u1 u1VarV;
        if (!this.f3435b || (u1VarV = iVar.v()) == null) {
            return;
        }
        iVar.K(u1VarV);
        if (b.f(this.f3437d, u1VarV)) {
            this.f3437d = u1VarV;
            return;
        }
        List<u1> list = this.f3438f;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.f3438f = arrayList;
            arrayList.add(u1VarV);
            return;
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (b.f(list.get(i11), u1VarV)) {
                list.set(i11, u1VarV);
                return;
            }
        }
        list.add(u1VarV);
    }

    public final void h() {
        if (this.f3435b) {
            u1 u1Var = this.f3437d;
            if (u1Var != null) {
                u1Var.invalidate();
                this.f3437d = null;
            }
            List<u1> list = this.f3438f;
            if (list != null) {
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    list.get(i11).invalidate();
                }
                list.clear();
            }
        }
    }

    public final void i(Object obj) {
        if (Intrinsics.b(this.f3436c, obj)) {
            return;
        }
        boolean z11 = this.f3436c == null;
        this.f3436c = obj;
        if (z11) {
            return;
        }
        h();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(i iVar, Integer num) {
        return a(iVar, num.intValue());
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, i iVar, Integer num) {
        return b(obj, iVar, num.intValue());
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, i iVar, Integer num) {
        return c(obj, obj2, iVar, num.intValue());
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, i iVar, Integer num) {
        return d(obj, obj2, obj3, iVar, num.intValue());
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, i iVar, Integer num) {
        return e(obj, obj2, obj3, obj4, iVar, num.intValue());
    }

    @Override // kotlin.jvm.functions.Function7
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, i iVar, Integer num) {
        return f(obj, obj2, obj3, obj4, obj5, iVar, num.intValue());
    }
}
