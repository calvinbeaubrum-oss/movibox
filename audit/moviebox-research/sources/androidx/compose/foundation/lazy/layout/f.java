package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

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
public final class f implements androidx.compose.ui.modifier.j<androidx.compose.ui.layout.e>, androidx.compose.ui.layout.e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f2707g = new b(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f2708h = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f2709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f2710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutDirection f2712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Orientation f2713f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.compose.ui.layout.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2714a;

        @Override // androidx.compose.ui.layout.e.a
        public boolean a() {
            return this.f2714a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2715a;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f2715a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements androidx.compose.ui.layout.e.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<e.a> f2717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f2718c;

        public d(Ref.ObjectRef<e.a> objectRef, int i11) {
            this.f2717b = objectRef;
            this.f2718c = i11;
        }

        @Override // androidx.compose.ui.layout.e.a
        public boolean a() {
            return f.this.r(this.f2717b.element, this.f2718c);
        }
    }

    public f(h hVar, e eVar, boolean z11, LayoutDirection layoutDirection, Orientation orientation) {
        this.f2709b = hVar;
        this.f2710c = eVar;
        this.f2711d = z11;
        this.f2712e = layoutDirection;
        this.f2713f = orientation;
    }

    @Override // androidx.compose.ui.layout.e
    public <T> T a(int i11, Function1<? super androidx.compose.ui.layout.e.a, ? extends T> function1) {
        if (this.f2709b.getItemCount() <= 0 || !this.f2709b.b()) {
            return function1.invoke(f2708h);
        }
        int iD = s(i11) ? this.f2709b.d() : this.f2709b.c();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) this.f2710c.a(iD, iD);
        T tInvoke = null;
        while (tInvoke == null && r((e.a) objectRef.element, i11)) {
            T t11 = (T) p((e.a) objectRef.element, i11);
            this.f2710c.e((e.a) objectRef.element);
            objectRef.element = t11;
            this.f2709b.a();
            tInvoke = function1.invoke(new d(objectRef, i11));
        }
        this.f2710c.e((e.a) objectRef.element);
        this.f2709b.a();
        return tInvoke;
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ Object c(Object obj, Function2 function2) {
        return androidx.compose.ui.g.b(this, obj, function2);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ boolean d(Function1 function1) {
        return androidx.compose.ui.g.a(this, function1);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ androidx.compose.ui.f f(androidx.compose.ui.f fVar) {
        return androidx.compose.ui.e.a(this, fVar);
    }

    @Override // androidx.compose.ui.modifier.j
    public androidx.compose.ui.modifier.l<androidx.compose.ui.layout.e> getKey() {
        return BeyondBoundsLayoutKt.a();
    }

    public final e.a p(e.a aVar, int i11) {
        int iB = aVar.b();
        int iA = aVar.a();
        if (s(i11)) {
            iA++;
        } else {
            iB--;
        }
        return this.f2710c.a(iB, iA);
    }

    @Override // androidx.compose.ui.modifier.j
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public androidx.compose.ui.layout.e getValue() {
        return this;
    }

    public final boolean r(e.a aVar, int i11) {
        if (t(i11)) {
            return false;
        }
        if (s(i11)) {
            if (aVar.a() >= this.f2709b.getItemCount() - 1) {
                return false;
            }
        } else if (aVar.b() <= 0) {
            return false;
        }
        return true;
    }

    public final boolean s(int i11) {
        androidx.compose.ui.layout.e.b.a aVar = androidx.compose.ui.layout.e.b.f4862a;
        if (androidx.compose.ui.layout.e.b.h(i11, aVar.c())) {
            return false;
        }
        if (!androidx.compose.ui.layout.e.b.h(i11, aVar.b())) {
            if (androidx.compose.ui.layout.e.b.h(i11, aVar.a())) {
                return this.f2711d;
            }
            if (androidx.compose.ui.layout.e.b.h(i11, aVar.d())) {
                if (this.f2711d) {
                    return false;
                }
            } else if (androidx.compose.ui.layout.e.b.h(i11, aVar.e())) {
                int i12 = c.f2715a[this.f2712e.ordinal()];
                if (i12 == 1) {
                    return this.f2711d;
                }
                if (i12 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.f2711d) {
                    return false;
                }
            } else {
                if (!androidx.compose.ui.layout.e.b.h(i11, aVar.f())) {
                    g.c();
                    throw new KotlinNothingValueException();
                }
                int i13 = c.f2715a[this.f2712e.ordinal()];
                if (i13 != 1) {
                    if (i13 == 2) {
                        return this.f2711d;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (this.f2711d) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean t(int i11) {
        androidx.compose.ui.layout.e.b.a aVar = androidx.compose.ui.layout.e.b.f4862a;
        if (androidx.compose.ui.layout.e.b.h(i11, aVar.a()) || androidx.compose.ui.layout.e.b.h(i11, aVar.d())) {
            if (this.f2713f == Orientation.Horizontal) {
                return true;
            }
        } else if (androidx.compose.ui.layout.e.b.h(i11, aVar.e()) || androidx.compose.ui.layout.e.b.h(i11, aVar.f())) {
            if (this.f2713f == Orientation.Vertical) {
                return true;
            }
        } else if (!androidx.compose.ui.layout.e.b.h(i11, aVar.c()) && !androidx.compose.ui.layout.e.b.h(i11, aVar.b())) {
            g.c();
            throw new KotlinNothingValueException();
        }
        return false;
    }
}
