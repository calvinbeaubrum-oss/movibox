package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.g2;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.u2;
import androidx.compose.runtime.v1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class LazySaveableStateHolder implements androidx.compose.runtime.saveable.b, androidx.compose.runtime.saveable.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f2665d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.runtime.saveable.b f2666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i1 f2667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Object> f2668c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final androidx.compose.runtime.saveable.d<LazySaveableStateHolder, Map<String, List<Object>>> a(final androidx.compose.runtime.saveable.b bVar) {
            return SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, LazySaveableStateHolder, Map<String, ? extends List<? extends Object>>>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$1
                @Override // kotlin.jvm.functions.Function2
                public final Map<String, List<Object>> invoke(androidx.compose.runtime.saveable.e eVar, LazySaveableStateHolder lazySaveableStateHolder) {
                    Map<String, List<Object>> mapE = lazySaveableStateHolder.e();
                    if (mapE.isEmpty()) {
                        return null;
                    }
                    return mapE;
                }
            }, new Function1<Map<String, ? extends List<? extends Object>>, LazySaveableStateHolder>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final LazySaveableStateHolder invoke(Map<String, ? extends List<? extends Object>> map) {
                    return new LazySaveableStateHolder(bVar, map);
                }
            });
        }
    }

    public LazySaveableStateHolder(androidx.compose.runtime.saveable.b bVar) {
        this.f2666a = bVar;
        this.f2667b = u2.c(null, null, 2, null);
        this.f2668c = new LinkedHashSet();
    }

    public LazySaveableStateHolder(final androidx.compose.runtime.saveable.b bVar, Map<String, ? extends List<? extends Object>> map) {
        this(SaveableStateRegistryKt.a(map, new Function1<Object, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.1
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                androidx.compose.runtime.saveable.b bVar2 = bVar;
                return Boolean.valueOf(bVar2 != null ? bVar2.a(obj) : true);
            }
        }));
    }

    @Override // androidx.compose.runtime.saveable.b
    public boolean a(Object obj) {
        return this.f2666a.a(obj);
    }

    @Override // androidx.compose.runtime.saveable.b
    public androidx.compose.runtime.saveable.b.a b(String str, Function0<? extends Object> function0) {
        return this.f2666a.b(str, function0);
    }

    @Override // androidx.compose.runtime.saveable.a
    public void c(Object obj) {
        androidx.compose.runtime.saveable.a aVarH = h();
        if (aVarH == null) {
            throw new IllegalArgumentException("null wrappedHolder".toString());
        }
        aVarH.c(obj);
    }

    @Override // androidx.compose.runtime.saveable.a
    public void d(final Object obj, final Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i iVarG = iVar.g(-697180401);
        if ((i11 & 6) == 0) {
            i12 = (iVarG.A(obj) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= iVarG.A(function2) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= iVarG.A(this) ? 256 : 128;
        }
        if ((i12 & 147) == 146 && iVarG.h()) {
            iVarG.H();
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-697180401, i12, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:82)");
            }
            androidx.compose.runtime.saveable.a aVarH = h();
            if (aVarH == null) {
                throw new IllegalArgumentException("null wrappedHolder".toString());
            }
            int i13 = i12 & 14;
            aVarH.d(obj, function2, iVarG, (i12 & 112) | i13);
            boolean zA = iVarG.A(this) | iVarG.A(obj);
            Object objY = iVarG.y();
            if (zA || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$2$1

                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @SourceDebugExtension
                    public static final class a implements androidx.compose.runtime.c0 {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ LazySaveableStateHolder f2669a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ Object f2670b;

                        public a(LazySaveableStateHolder lazySaveableStateHolder, Object obj) {
                            this.f2669a = lazySaveableStateHolder;
                            this.f2670b = obj;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f2669a.f2668c.add(this.f2670b);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                        this.this$0.f2668c.remove(obj);
                        return new a(this.this$0, obj);
                    }
                };
                iVarG.p(objY);
            }
            androidx.compose.runtime.g0.a(obj, (Function1) objY, iVarG, i13);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$3
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

                public final void invoke(androidx.compose.runtime.i iVar2, int i14) {
                    this.$tmp1_rcvr.d(obj, function2, iVar2, v1.a(i11 | 1));
                }
            });
        }
    }

    @Override // androidx.compose.runtime.saveable.b
    public Map<String, List<Object>> e() {
        androidx.compose.runtime.saveable.a aVarH = h();
        if (aVarH != null) {
            Iterator<T> it = this.f2668c.iterator();
            while (it.hasNext()) {
                aVarH.c(it.next());
            }
        }
        return this.f2666a.e();
    }

    @Override // androidx.compose.runtime.saveable.b
    public Object f(String str) {
        return this.f2666a.f(str);
    }

    public final androidx.compose.runtime.saveable.a h() {
        return (androidx.compose.runtime.saveable.a) this.f2667b.getValue();
    }

    public final void i(androidx.compose.runtime.saveable.a aVar) {
        this.f2667b.setValue(aVar);
    }
}
