package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

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
public abstract class o<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f12313c = new l(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public static final o<Integer> f12314d = new f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public static final o<Integer> f12315e = new i();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public static final o<int[]> f12316f = new e();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public static final o<Long> f12317g = new h();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public static final o<long[]> f12318h = new g();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public static final o<Float> f12319i = new d();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public static final o<float[]> f12320j = new c();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @JvmField
    public static final o<Boolean> f12321k = new b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @JvmField
    public static final o<boolean[]> f12322l = new a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @JvmField
    public static final o<String> f12323m = new k();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @JvmField
    public static final o<String[]> f12324n = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12326b = "nav_type";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends o<boolean[]> {
        public a() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "boolean[]";
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean[] a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            return (boolean[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean[] h(String value) {
            Intrinsics.g(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, boolean[] zArr) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            bundle.putBooleanArray(key, zArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends o<Boolean> {
        public b() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "boolean";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Boolean bool) {
            i(bundle, str, bool.booleanValue());
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            return (Boolean) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean h(String value) {
            boolean z11;
            Intrinsics.g(value, "value");
            if (Intrinsics.b(value, "true")) {
                z11 = true;
            } else {
                if (!Intrinsics.b(value, "false")) {
                    throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
                }
                z11 = false;
            }
            return Boolean.valueOf(z11);
        }

        public void i(Bundle bundle, String key, boolean z11) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            bundle.putBoolean(key, z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends o<float[]> {
        public c() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "float[]";
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public float[] a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            return (float[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public float[] h(String value) {
            Intrinsics.g(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, float[] fArr) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            bundle.putFloatArray(key, fArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends o<Float> {
        public d() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "float";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Float f11) {
            i(bundle, str, f11.floatValue());
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Float a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            Object obj = bundle.get(key);
            if (obj != null) {
                return Float.valueOf(((Float) obj).floatValue());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Float h(String value) {
            Intrinsics.g(value, "value");
            return Float.valueOf(Float.parseFloat(value));
        }

        public void i(Bundle bundle, String key, float f11) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            bundle.putFloat(key, f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends o<int[]> {
        public e() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "integer[]";
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public int[] a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            return (int[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int[] h(String value) {
            Intrinsics.g(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, int[] iArr) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            bundle.putIntArray(key, iArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends o<Integer> {
        public f() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "integer";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Integer num) {
            i(bundle, str, num.intValue());
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            Object obj = bundle.get(key);
            if (obj != null) {
                return Integer.valueOf(((Integer) obj).intValue());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Integer h(String value) {
            int i11;
            Intrinsics.g(value, "value");
            if (kotlin.text.l.L(value, "0x", false, 2, null)) {
                String strSubstring = value.substring(2);
                Intrinsics.f(strSubstring, "this as java.lang.String).substring(startIndex)");
                i11 = Integer.parseInt(strSubstring, kotlin.text.a.a(16));
            } else {
                i11 = Integer.parseInt(value);
            }
            return Integer.valueOf(i11);
        }

        public void i(Bundle bundle, String key, int i11) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            bundle.putInt(key, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g extends o<long[]> {
        public g() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "long[]";
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public long[] a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            return (long[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public long[] h(String value) {
            Intrinsics.g(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, long[] jArr) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            bundle.putLongArray(key, jArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h extends o<Long> {
        public h() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "long";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Long l11) {
            i(bundle, str, l11.longValue());
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Long a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            Object obj = bundle.get(key);
            if (obj != null) {
                return Long.valueOf(((Long) obj).longValue());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Long h(String value) {
            String strSubstring;
            long j11;
            Intrinsics.g(value, "value");
            if (kotlin.text.l.u(value, "L", false, 2, null)) {
                strSubstring = value.substring(0, value.length() - 1);
                Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                strSubstring = value;
            }
            if (kotlin.text.l.L(value, "0x", false, 2, null)) {
                String strSubstring2 = strSubstring.substring(2);
                Intrinsics.f(strSubstring2, "this as java.lang.String).substring(startIndex)");
                j11 = Long.parseLong(strSubstring2, kotlin.text.a.a(16));
            } else {
                j11 = Long.parseLong(strSubstring);
            }
            return Long.valueOf(j11);
        }

        public void i(Bundle bundle, String key, long j11) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            bundle.putLong(key, j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class i extends o<Integer> {
        public i() {
            super(false);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "reference";
        }

        @Override // androidx.navigation.o
        public /* bridge */ /* synthetic */ void f(Bundle bundle, String str, Integer num) {
            i(bundle, str, num.intValue());
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            Object obj = bundle.get(key);
            if (obj != null) {
                return Integer.valueOf(((Integer) obj).intValue());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Integer h(String value) {
            int i11;
            Intrinsics.g(value, "value");
            if (kotlin.text.l.L(value, "0x", false, 2, null)) {
                String strSubstring = value.substring(2);
                Intrinsics.f(strSubstring, "this as java.lang.String).substring(startIndex)");
                i11 = Integer.parseInt(strSubstring, kotlin.text.a.a(16));
            } else {
                i11 = Integer.parseInt(value);
            }
            return Integer.valueOf(i11);
        }

        public void i(Bundle bundle, String key, int i11) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            bundle.putInt(key, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class j extends o<String[]> {
        public j() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "string[]";
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public String[] a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            return (String[]) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String[] h(String value) {
            Intrinsics.g(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, String[] strArr) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            bundle.putStringArray(key, strArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class k extends o<String> {
        public k() {
            super(true);
        }

        @Override // androidx.navigation.o
        public String b() {
            return "string";
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public String a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            return (String) bundle.get(key);
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String h(String value) {
            Intrinsics.g(value, "value");
            return value;
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, String str) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            bundle.putString(key, str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class l {
        public l() {
        }

        public /* synthetic */ l(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public o<?> a(String str, String str2) {
            o<Integer> oVar = o.f12314d;
            if (Intrinsics.b(oVar.b(), str)) {
                return oVar;
            }
            o oVar2 = o.f12316f;
            if (Intrinsics.b(oVar2.b(), str)) {
                return oVar2;
            }
            o<Long> oVar3 = o.f12317g;
            if (Intrinsics.b(oVar3.b(), str)) {
                return oVar3;
            }
            o oVar4 = o.f12318h;
            if (Intrinsics.b(oVar4.b(), str)) {
                return oVar4;
            }
            o<Boolean> oVar5 = o.f12321k;
            if (Intrinsics.b(oVar5.b(), str)) {
                return oVar5;
            }
            o oVar6 = o.f12322l;
            if (Intrinsics.b(oVar6.b(), str)) {
                return oVar6;
            }
            o<String> oVar7 = o.f12323m;
            if (Intrinsics.b(oVar7.b(), str)) {
                return oVar7;
            }
            o oVar8 = o.f12324n;
            if (Intrinsics.b(oVar8.b(), str)) {
                return oVar8;
            }
            o<Float> oVar9 = o.f12319i;
            if (Intrinsics.b(oVar9.b(), str)) {
                return oVar9;
            }
            o oVar10 = o.f12320j;
            if (Intrinsics.b(oVar10.b(), str)) {
                return oVar10;
            }
            o<Integer> oVar11 = o.f12315e;
            if (Intrinsics.b(oVar11.b(), str)) {
                return oVar11;
            }
            if (str == null || str.length() == 0) {
                return oVar7;
            }
            try {
                String strP = (!kotlin.text.l.L(str, InstructionFileId.DOT, false, 2, null) || str2 == null) ? str : Intrinsics.p(str2, str);
                if (kotlin.text.l.u(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, false, 2, null)) {
                    strP = strP.substring(0, strP.length() - 2);
                    Intrinsics.f(strP, "this as java.lang.String…ing(startIndex, endIndex)");
                    Class<?> cls = Class.forName(strP);
                    if (Parcelable.class.isAssignableFrom(cls)) {
                        return new n(cls);
                    }
                    if (Serializable.class.isAssignableFrom(cls)) {
                        return new p(cls);
                    }
                } else {
                    Class<?> cls2 = Class.forName(strP);
                    if (Parcelable.class.isAssignableFrom(cls2)) {
                        return new C0111o(cls2);
                    }
                    if (Enum.class.isAssignableFrom(cls2)) {
                        return new m(cls2);
                    }
                    if (Serializable.class.isAssignableFrom(cls2)) {
                        return new q(cls2);
                    }
                }
                throw new IllegalArgumentException(Intrinsics.p(strP, " is not Serializable or Parcelable."));
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException(e11);
            }
        }

        @JvmStatic
        public final o<Object> b(String value) {
            Intrinsics.g(value, "value");
            try {
                try {
                    try {
                        try {
                            o<Integer> oVar = o.f12314d;
                            oVar.h(value);
                            return oVar;
                        } catch (IllegalArgumentException unused) {
                            o<Float> oVar2 = o.f12319i;
                            oVar2.h(value);
                            return oVar2;
                        }
                    } catch (IllegalArgumentException unused2) {
                        o<Long> oVar3 = o.f12317g;
                        oVar3.h(value);
                        return oVar3;
                    }
                } catch (IllegalArgumentException unused3) {
                    return o.f12323m;
                }
            } catch (IllegalArgumentException unused4) {
                o<Boolean> oVar4 = o.f12321k;
                oVar4.h(value);
                return oVar4;
            }
        }

        /* JADX WARN: Code duplicated, block: B:45:0x008e  */
        /* JADX WARN: Code duplicated, block: B:47:0x0098  */
        /* JADX WARN: Code duplicated, block: B:49:0x00ab  */
        /* JADX WARN: Code duplicated, block: B:51:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:52:0x00bb  */
        /* JADX WARN: Code duplicated, block: B:54:0x00c3  */
        /* JADX WARN: Code duplicated, block: B:56:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:57:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:59:0x00d5  */
        /* JADX WARN: Code duplicated, block: B:60:0x00df  */
        /* JADX WARN: Code duplicated, block: B:62:0x00e3  */
        /* JADX WARN: Code duplicated, block: B:63:0x00ed  */
        /* JADX WARN: Instruction removed from duplicated block: B:63:0x00ed, please report this as an issue */
        @JvmStatic
        public final o<Object> c(Object obj) {
            o<Object> qVar;
            Class<?> componentType;
            Class<?> componentType2;
            if (obj instanceof Integer) {
                return o.f12314d;
            }
            if (obj instanceof int[]) {
                return o.f12316f;
            }
            if (obj instanceof Long) {
                return o.f12317g;
            }
            if (obj instanceof long[]) {
                return o.f12318h;
            }
            if (obj instanceof Float) {
                return o.f12319i;
            }
            if (obj instanceof float[]) {
                return o.f12320j;
            }
            if (obj instanceof Boolean) {
                return o.f12321k;
            }
            if (obj instanceof boolean[]) {
                return o.f12322l;
            }
            if ((obj instanceof String) || obj == null) {
                return o.f12323m;
            }
            if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
                return o.f12324n;
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType3 = obj.getClass().getComponentType();
                Intrinsics.d(componentType3);
                if (Parcelable.class.isAssignableFrom(componentType3)) {
                    Class<?> componentType4 = obj.getClass().getComponentType();
                    if (componentType4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                    }
                    qVar = new n<>(componentType4);
                } else if (obj.getClass().isArray()) {
                    componentType = obj.getClass().getComponentType();
                    Intrinsics.d(componentType);
                    if (Serializable.class.isAssignableFrom(componentType)) {
                        componentType2 = obj.getClass().getComponentType();
                        if (componentType2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                        }
                        qVar = new p<>(componentType2);
                    } else if (obj instanceof Parcelable) {
                        qVar = new C0111o<>(obj.getClass());
                    } else if (obj instanceof Enum) {
                        qVar = new m<>(obj.getClass());
                    } else {
                        if (obj instanceof Serializable) {
                            throw new IllegalArgumentException("Object of type " + ((Object) obj.getClass().getName()) + " is not supported for navigation arguments.");
                        }
                        qVar = new q<>(obj.getClass());
                    }
                } else if (obj instanceof Parcelable) {
                    qVar = new C0111o<>(obj.getClass());
                } else if (obj instanceof Enum) {
                    qVar = new m<>(obj.getClass());
                } else {
                    if (obj instanceof Serializable) {
                        throw new IllegalArgumentException("Object of type " + ((Object) obj.getClass().getName()) + " is not supported for navigation arguments.");
                    }
                    qVar = new q<>(obj.getClass());
                }
            } else if (obj.getClass().isArray()) {
                componentType = obj.getClass().getComponentType();
                Intrinsics.d(componentType);
                if (Serializable.class.isAssignableFrom(componentType)) {
                    componentType2 = obj.getClass().getComponentType();
                    if (componentType2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                    }
                    qVar = new p<>(componentType2);
                } else if (obj instanceof Parcelable) {
                    qVar = new C0111o<>(obj.getClass());
                } else if (obj instanceof Enum) {
                    qVar = new m<>(obj.getClass());
                } else {
                    if (obj instanceof Serializable) {
                        throw new IllegalArgumentException("Object of type " + ((Object) obj.getClass().getName()) + " is not supported for navigation arguments.");
                    }
                    qVar = new q<>(obj.getClass());
                }
            } else if (obj instanceof Parcelable) {
                qVar = new C0111o<>(obj.getClass());
            } else if (obj instanceof Enum) {
                qVar = new m<>(obj.getClass());
            } else {
                if (obj instanceof Serializable) {
                    throw new IllegalArgumentException("Object of type " + ((Object) obj.getClass().getName()) + " is not supported for navigation arguments.");
                }
                qVar = new q<>(obj.getClass());
            }
            return qVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class m<D extends Enum<?>> extends q<D> {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Class<D> f12327p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Class<D> type) {
            super(false, type);
            Intrinsics.g(type, "type");
            if (type.isEnum()) {
                this.f12327p = type;
                return;
            }
            throw new IllegalArgumentException((type + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.o.q, androidx.navigation.o
        public String b() {
            String name = this.f12327p.getName();
            Intrinsics.f(name, "type.name");
            return name;
        }

        @Override // androidx.navigation.o.q
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public D h(String value) {
            D d11;
            Intrinsics.g(value, "value");
            D[] enumConstants = this.f12327p.getEnumConstants();
            Intrinsics.f(enumConstants, "type.enumConstants");
            int length = enumConstants.length;
            int i11 = 0;
            do {
                if (i11 >= length) {
                    d11 = null;
                    break;
                }
                d11 = enumConstants[i11];
                i11++;
            } while (!kotlin.text.l.v(d11.name(), value, true));
            D d12 = d11;
            if (d12 != null) {
                return d12;
            }
            throw new IllegalArgumentException("Enum value " + value + " not found for type " + ((Object) this.f12327p.getName()) + '.');
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class n<D extends Parcelable> extends o<D[]> {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Class<D[]> f12328o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Class<D> type) {
            super(true);
            Intrinsics.g(type, "type");
            if (!Parcelable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Parcelable.").toString());
            }
            try {
                this.f12328o = (Class<D[]>) Class.forName("[L" + ((Object) type.getName()) + ';');
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f12328o.getName();
            Intrinsics.f(name, "arrayType.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.b(n.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.b(this.f12328o, ((n) obj).f12328o);
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public D[] a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            return (D[]) ((Parcelable[]) bundle.get(key));
        }

        @Override // androidx.navigation.o
        public D[] h(String value) {
            Intrinsics.g(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.f12328o.hashCode();
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, D[] dArr) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            this.f12328o.cast(dArr);
            bundle.putParcelableArray(key, dArr);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.o$o, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0111o<D> extends o<D> {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Class<D> f12329o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0111o(Class<D> type) {
            super(true);
            Intrinsics.g(type, "type");
            if (Parcelable.class.isAssignableFrom(type) || Serializable.class.isAssignableFrom(type)) {
                this.f12329o = type;
                return;
            }
            throw new IllegalArgumentException((type + " does not implement Parcelable or Serializable.").toString());
        }

        @Override // androidx.navigation.o
        public D a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            return (D) bundle.get(key);
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f12329o.getName();
            Intrinsics.f(name, "type.name");
            return name;
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: e */
        public D h(String value) {
            Intrinsics.g(value, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.b(C0111o.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.b(this.f12329o, ((C0111o) obj).f12329o);
        }

        @Override // androidx.navigation.o
        public void f(Bundle bundle, String key, D d11) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            this.f12329o.cast(d11);
            if (d11 == null || (d11 instanceof Parcelable)) {
                bundle.putParcelable(key, (Parcelable) d11);
            } else if (d11 instanceof Serializable) {
                bundle.putSerializable(key, (Serializable) d11);
            }
        }

        public int hashCode() {
            return this.f12329o.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class p<D extends Serializable> extends o<D[]> {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Class<D[]> f12330o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Class<D> type) {
            super(true);
            Intrinsics.g(type, "type");
            if (!Serializable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
            }
            try {
                this.f12330o = (Class<D[]>) Class.forName("[L" + ((Object) type.getName()) + ';');
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f12330o.getName();
            Intrinsics.f(name, "arrayType.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.b(p.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.b(this.f12330o, ((p) obj).f12330o);
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public D[] a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            return (D[]) ((Serializable[]) bundle.get(key));
        }

        @Override // androidx.navigation.o
        public D[] h(String value) {
            Intrinsics.g(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.f12330o.hashCode();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, D[] dArr) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            this.f12330o.cast(dArr);
            bundle.putSerializable(key, dArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static class q<D extends Serializable> extends o<D> {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Class<D> f12331o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(Class<D> type) {
            super(true);
            Intrinsics.g(type, "type");
            if (!Serializable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
            }
            if (true ^ type.isEnum()) {
                this.f12331o = type;
                return;
            }
            throw new IllegalArgumentException((type + " is an Enum. You should use EnumType instead.").toString());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(boolean z11, Class<D> type) {
            super(z11);
            Intrinsics.g(type, "type");
            if (Serializable.class.isAssignableFrom(type)) {
                this.f12331o = type;
                return;
            }
            throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
        }

        @Override // androidx.navigation.o
        public String b() {
            String name = this.f12331o.getName();
            Intrinsics.f(name, "type.name");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof q) {
                return Intrinsics.b(this.f12331o, ((q) obj).f12331o);
            }
            return false;
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public D a(Bundle bundle, String key) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            return (D) bundle.get(key);
        }

        @Override // androidx.navigation.o
        public D h(String value) {
            Intrinsics.g(value, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public int hashCode() {
            return this.f12331o.hashCode();
        }

        @Override // androidx.navigation.o
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(Bundle bundle, String key, D value) {
            Intrinsics.g(bundle, "bundle");
            Intrinsics.g(key, "key");
            Intrinsics.g(value, "value");
            this.f12331o.cast(value);
            bundle.putSerializable(key, value);
        }
    }

    public o(boolean z11) {
        this.f12325a = z11;
    }

    public abstract T a(Bundle bundle, String str);

    public abstract String b();

    public boolean c() {
        return this.f12325a;
    }

    public final T d(Bundle bundle, String key, String value) {
        Intrinsics.g(bundle, "bundle");
        Intrinsics.g(key, "key");
        Intrinsics.g(value, "value");
        T tH = h(value);
        f(bundle, key, tH);
        return tH;
    }

    /* JADX INFO: renamed from: e */
    public abstract T h(String str);

    public abstract void f(Bundle bundle, String str, T t11);

    public String toString() {
        return b();
    }
}
