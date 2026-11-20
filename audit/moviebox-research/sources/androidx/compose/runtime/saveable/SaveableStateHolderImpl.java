package androidx.compose.runtime.saveable;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.c0;
import androidx.compose.runtime.d0;
import androidx.compose.runtime.g0;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.t1;
import androidx.compose.runtime.v1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.s;
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
public final class SaveableStateHolderImpl implements androidx.compose.runtime.saveable.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3574d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d<SaveableStateHolderImpl, ?> f3575e = SaverKt.a(new Function2<e, SaveableStateHolderImpl, Map<Object, Map<String, ? extends List<? extends Object>>>>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final Map<Object, Map<String, List<Object>>> invoke(e eVar, SaveableStateHolderImpl saveableStateHolderImpl) {
            return saveableStateHolderImpl.h();
        }
    }, new Function1<Map<Object, Map<String, ? extends List<? extends Object>>>, SaveableStateHolderImpl>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$Companion$Saver$2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final SaveableStateHolderImpl invoke2(Map<Object, Map<String, List<Object>>> map) {
            return new SaveableStateHolderImpl(map);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ SaveableStateHolderImpl invoke(Map<Object, Map<String, ? extends List<? extends Object>>> map) {
            return invoke2((Map<Object, Map<String, List<Object>>>) map);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Object, Map<String, List<Object>>> f3576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Object, RegistryHolder> f3577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f3578c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class RegistryHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f3579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3580b = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f3581c;

        public RegistryHolder(Object obj) {
            this.f3579a = obj;
            this.f3581c = SaveableStateRegistryKt.a((Map) SaveableStateHolderImpl.this.f3576a.get(obj), new Function1<Object, Boolean>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$RegistryHolder$registry$1
                {
                    super(1);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj2) {
                    b bVarG = saveableStateHolderImpl.g();
                    return Boolean.valueOf(bVarG != null ? bVarG.a(obj2) : true);
                }
            });
        }

        public final b a() {
            return this.f3581c;
        }

        public final void b(Map<Object, Map<String, List<Object>>> map) {
            if (this.f3580b) {
                Map<String, List<Object>> mapE = this.f3581c.e();
                if (mapE.isEmpty()) {
                    map.remove(this.f3579a);
                } else {
                    map.put(this.f3579a, mapE);
                }
            }
        }

        public final void c(boolean z11) {
            this.f3580b = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d<SaveableStateHolderImpl, ?> a() {
            return SaveableStateHolderImpl.f3575e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SaveableStateHolderImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public SaveableStateHolderImpl(Map<Object, Map<String, List<Object>>> map) {
        this.f3576a = map;
        this.f3577b = new LinkedHashMap();
    }

    public /* synthetic */ SaveableStateHolderImpl(Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new LinkedHashMap() : map);
    }

    @Override // androidx.compose.runtime.saveable.a
    public void c(Object obj) {
        RegistryHolder registryHolder = this.f3577b.get(obj);
        if (registryHolder != null) {
            registryHolder.c(false);
        } else {
            this.f3576a.remove(obj);
        }
    }

    @Override // androidx.compose.runtime.saveable.a
    public void d(final Object obj, final Function2<? super i, ? super Integer, Unit> function2, i iVar, final int i11) {
        int i12;
        i iVarG = iVar.g(-1198538093);
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
            if (k.J()) {
                k.S(-1198538093, i12, -1, "androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider (SaveableStateHolder.kt:75)");
            }
            iVarG.F(207, obj);
            Object objY = iVarG.y();
            i.a aVar = i.f3413a;
            if (objY == aVar.a()) {
                b bVar = this.f3578c;
                if (bVar != null && !bVar.a(obj)) {
                    throw new IllegalArgumentException(("Type of the key " + obj + " is not supported. On Android you can only use types which can be stored inside the Bundle.").toString());
                }
                objY = new RegistryHolder(obj);
                iVarG.p(objY);
            }
            final RegistryHolder registryHolder = (RegistryHolder) objY;
            CompositionLocalKt.a(SaveableStateRegistryKt.d().d(registryHolder.a()), function2, iVarG, (i12 & 112) | t1.f3721i);
            Unit unit = Unit.f68710a;
            boolean zA = iVarG.A(this) | iVarG.A(obj) | iVarG.A(registryHolder);
            Object objY2 = iVarG.y();
            if (zA || objY2 == aVar.a()) {
                objY2 = new Function1<d0, c0>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$1$1$1

                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @SourceDebugExtension
                    public static final class a implements c0 {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ SaveableStateHolderImpl.RegistryHolder f3583a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ SaveableStateHolderImpl f3584b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        public final /* synthetic */ Object f3585c;

                        public a(SaveableStateHolderImpl.RegistryHolder registryHolder, SaveableStateHolderImpl saveableStateHolderImpl, Object obj) {
                            this.f3583a = registryHolder;
                            this.f3584b = saveableStateHolderImpl;
                            this.f3585c = obj;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f3583a.b(this.f3584b.f3576a);
                            this.f3584b.f3577b.remove(this.f3585c);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final c0 invoke(d0 d0Var) {
                        boolean z11 = !this.this$0.f3577b.containsKey(obj);
                        Object obj2 = obj;
                        if (z11) {
                            this.this$0.f3576a.remove(obj);
                            this.this$0.f3577b.put(obj, registryHolder);
                            return new a(registryHolder, this.this$0, obj);
                        }
                        throw new IllegalArgumentException(("Key " + obj2 + " was used multiple times ").toString());
                    }
                };
                iVarG.p(objY2);
            }
            g0.a(unit, (Function1) objY2, iVarG, 6);
            iVarG.w();
            if (k.J()) {
                k.R();
            }
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(i iVar2, int i13) {
                    this.$tmp0_rcvr.d(obj, function2, iVar2, v1.a(i11 | 1));
                }
            });
        }
    }

    public final b g() {
        return this.f3578c;
    }

    public final Map<Object, Map<String, List<Object>>> h() {
        Map<Object, Map<String, List<Object>>> mapV = s.v(this.f3576a);
        Iterator<T> it = this.f3577b.values().iterator();
        while (it.hasNext()) {
            ((RegistryHolder) it.next()).b(mapV);
        }
        if (mapV.isEmpty()) {
            return null;
        }
        return mapV;
    }

    public final void i(b bVar) {
        this.f3578c = bVar;
    }
}
