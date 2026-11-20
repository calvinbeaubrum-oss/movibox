package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f71571c = com.alibaba.fastjson.util.b.g(o0.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f71572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f71573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f71574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f71575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f71576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f71577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f71578j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f71579k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.alibaba.fastjson.util.a f71580a = new com.alibaba.fastjson.util.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f71581b = new AtomicLong();

    /* JADX INFO: renamed from: n7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0769a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static int f71582h = 6;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static int f71583i = 7;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static int f71584j = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.alibaba.fastjson.util.d[] f71585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f71586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f1 f71587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f71588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, Integer> f71589e = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f71590f = 9;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f71591g;

        public C0769a(com.alibaba.fastjson.util.d[] dVarArr, f1 f1Var, String str, boolean z11, boolean z12) {
            this.f71585a = dVarArr;
            this.f71586b = str;
            this.f71587c = f1Var;
            this.f71588d = z11;
            this.f71591g = z12 || f1Var.f71604a.isEnum();
        }

        public int f(String str) {
            int length = this.f71585a.length;
            for (int i11 = 0; i11 < length; i11++) {
                if (this.f71585a[i11].f15532a.equals(str)) {
                    return i11;
                }
            }
            return -1;
        }

        public int g(String str) {
            if (this.f71589e.get(str) == null) {
                Map<String, Integer> map = this.f71589e;
                int i11 = this.f71590f;
                this.f71590f = i11 + 1;
                map.put(str, Integer.valueOf(i11));
            }
            return this.f71589e.get(str).intValue();
        }

        public int h(String str, int i11) {
            if (this.f71589e.get(str) == null) {
                this.f71589e.put(str, Integer.valueOf(this.f71590f));
                this.f71590f += i11;
            }
            return this.f71589e.get(str).intValue();
        }
    }

    static {
        String strG = com.alibaba.fastjson.util.b.g(z0.class);
        f71572d = strG;
        f71573e = "L" + strG + ";";
        String strG2 = com.alibaba.fastjson.util.b.g(j1.class);
        f71574f = strG2;
        f71575g = "L" + strG2 + ";";
        f71576h = com.alibaba.fastjson.util.b.g(p0.class);
        f71577i = "L" + com.alibaba.fastjson.util.b.g(p0.class) + ";";
        f71578j = com.alibaba.fastjson.util.b.b(e1.class);
        f71579k = com.alibaba.fastjson.util.b.b(i1.class);
    }

    public final void A(Class<?> cls, k7.h hVar, com.alibaba.fastjson.util.d[] dVarArr, C0769a c0769a) throws Exception {
        String str;
        String str2;
        String str3;
        a aVar;
        int i11;
        Class<?> cls2;
        k7.f fVar;
        int i12;
        int i13;
        String str4;
        int i14;
        a aVar2 = this;
        com.alibaba.fastjson.util.d[] dVarArr2 = dVarArr;
        k7.f fVar2 = new k7.f();
        hVar.c(25, 1);
        hVar.c(25, 0);
        String str5 = f71571c;
        hVar.k(182, str5, "hasPropertyFilters", "(" + f71579k + ")Z");
        hVar.b(154, fVar2);
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 2);
        hVar.c(25, 3);
        hVar.c(25, 4);
        hVar.c(21, 5);
        String str6 = f71576h;
        StringBuilder sb2 = new StringBuilder();
        String str7 = "(L";
        sb2.append("(L");
        sb2.append(str5);
        String str8 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
        sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        hVar.k(183, str6, "writeNoneASM", sb2.toString());
        hVar.i(177);
        hVar.e(fVar2);
        String str9 = "out";
        hVar.c(25, c0769a.g("out"));
        hVar.c(16, 91);
        String str10 = f71574f;
        String str11 = "(I)V";
        hVar.k(182, str10, "write", "(I)V");
        int length = dVarArr2.length;
        if (length == 0) {
            hVar.c(25, c0769a.g("out"));
            hVar.c(16, 93);
            hVar.k(182, str10, "write", "(I)V");
            return;
        }
        int i15 = 0;
        while (i15 < length) {
            int i16 = i15 == length + (-1) ? 93 : 44;
            com.alibaba.fastjson.util.d dVar = dVarArr2[i15];
            Class<?> cls3 = dVar.f15536f;
            hVar.d(dVar.f15532a);
            hVar.c(58, C0769a.f71582h);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                str = str9;
                length = length;
                i15 = i15;
                str2 = str7;
                str3 = str11;
                hVar.c(25, c0769a.g(str));
                hVar.i(89);
                aVar = this;
                aVar.i(hVar, c0769a, dVar);
                String str12 = f71574f;
                hVar.k(182, str12, "writeInt", str3);
                hVar.c(16, i16);
                hVar.k(182, str12, "write", str3);
            } else {
                if (cls3 == Long.TYPE) {
                    hVar.c(25, c0769a.g(str9));
                    hVar.i(89);
                    aVar2.i(hVar, c0769a, dVar);
                    String str13 = f71574f;
                    hVar.k(182, str13, "writeLong", "(J)V");
                    hVar.c(16, i16);
                    hVar.k(182, str13, "write", str11);
                } else if (cls3 == Float.TYPE) {
                    hVar.c(25, c0769a.g(str9));
                    hVar.i(89);
                    aVar2.i(hVar, c0769a, dVar);
                    hVar.i(4);
                    String str14 = f71574f;
                    hVar.k(182, str14, "writeFloat", "(FZ)V");
                    hVar.c(16, i16);
                    hVar.k(182, str14, "write", str11);
                } else if (cls3 == Double.TYPE) {
                    hVar.c(25, c0769a.g(str9));
                    hVar.i(89);
                    aVar2.i(hVar, c0769a, dVar);
                    hVar.i(4);
                    String str15 = f71574f;
                    hVar.k(182, str15, "writeDouble", "(DZ)V");
                    hVar.c(16, i16);
                    hVar.k(182, str15, "write", str11);
                } else {
                    if (cls3 == Boolean.TYPE) {
                        hVar.c(25, c0769a.g(str9));
                        hVar.i(89);
                        aVar2.i(hVar, c0769a, dVar);
                        String str16 = f71574f;
                        hVar.k(182, str16, "write", "(Z)V");
                        hVar.c(16, i16);
                        hVar.k(182, str16, "write", str11);
                    } else if (cls3 == Character.TYPE) {
                        hVar.c(25, c0769a.g(str9));
                        aVar2.i(hVar, c0769a, dVar);
                        hVar.k(184, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
                        hVar.c(16, i16);
                        hVar.k(182, f71574f, "writeString", "(Ljava/lang/String;C)V");
                    } else if (cls3 == String.class) {
                        hVar.c(25, c0769a.g(str9));
                        aVar2.i(hVar, c0769a, dVar);
                        hVar.c(16, i16);
                        hVar.k(182, f71574f, "writeString", "(Ljava/lang/String;C)V");
                    } else if (cls3.isEnum()) {
                        hVar.c(25, c0769a.g(str9));
                        hVar.i(89);
                        aVar2.i(hVar, c0769a, dVar);
                        String str17 = f71574f;
                        hVar.k(182, str17, "writeEnum", "(Ljava/lang/Enum;)V");
                        hVar.c(16, i16);
                        hVar.k(182, str17, "write", str11);
                    } else if (List.class.isAssignableFrom(cls3)) {
                        Type type = dVar.f15537g;
                        Type type2 = type instanceof Class ? Object.class : ((ParameterizedType) type).getActualTypeArguments()[0];
                        if (!(type2 instanceof Class) || (cls2 = (Class) type2) == Object.class) {
                            cls2 = null;
                        }
                        aVar2.i(hVar, c0769a, dVar);
                        hVar.g(PsExtractor.AUDIO_STREAM, "java/util/List");
                        hVar.c(58, c0769a.g("list"));
                        if (cls2 == String.class && c0769a.f71588d) {
                            hVar.c(25, c0769a.g(str9));
                            hVar.c(25, c0769a.g("list"));
                            hVar.k(182, f71574f, "write", "(Ljava/util/List;)V");
                            str = str9;
                            str2 = str7;
                            str4 = str11;
                            i14 = 182;
                            i12 = 25;
                            i13 = 16;
                        } else {
                            k7.f fVar3 = new k7.f();
                            k7.f fVar4 = new k7.f();
                            hVar.c(25, c0769a.g("list"));
                            hVar.b(199, fVar4);
                            hVar.c(25, c0769a.g(str9));
                            String str18 = f71574f;
                            Type type3 = type2;
                            String str19 = str8;
                            hVar.k(182, str18, "writeNull", "()V");
                            hVar.b(167, fVar3);
                            hVar.e(fVar4);
                            hVar.c(25, c0769a.g("list"));
                            hVar.k(185, "java/util/List", "size", "()I");
                            hVar.c(54, c0769a.g("size"));
                            hVar.c(25, c0769a.g(str9));
                            hVar.c(16, 91);
                            hVar.k(182, str18, "write", str11);
                            k7.f fVar5 = new k7.f();
                            k7.f fVar6 = new k7.f();
                            k7.f fVar7 = new k7.f();
                            hVar.i(3);
                            String str20 = str7;
                            hVar.c(54, c0769a.g("i"));
                            hVar.e(fVar5);
                            hVar.c(21, c0769a.g("i"));
                            hVar.c(21, c0769a.g("size"));
                            hVar.b(162, fVar7);
                            hVar.c(21, c0769a.g("i"));
                            hVar.b(153, fVar6);
                            hVar.c(25, c0769a.g(str9));
                            hVar.c(16, 44);
                            hVar.k(182, str18, "write", str11);
                            hVar.e(fVar6);
                            hVar.c(25, c0769a.g("list"));
                            hVar.c(21, c0769a.g("i"));
                            hVar.k(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
                            hVar.c(58, c0769a.g("list_item"));
                            k7.f fVar8 = new k7.f();
                            k7.f fVar9 = new k7.f();
                            String str21 = str11;
                            hVar.c(25, c0769a.g("list_item"));
                            hVar.b(199, fVar9);
                            hVar.c(25, c0769a.g(str9));
                            String str22 = str9;
                            hVar.k(182, str18, "writeNull", "()V");
                            hVar.b(167, fVar8);
                            hVar.e(fVar9);
                            k7.f fVar10 = new k7.f();
                            k7.f fVar11 = new k7.f();
                            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                                fVar5 = fVar5;
                                fVar8 = fVar8;
                                str8 = str19;
                                str2 = str20;
                                fVar = fVar11;
                            } else {
                                hVar.c(25, c0769a.g("list_item"));
                                hVar.k(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                                hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                                hVar.b(166, fVar11);
                                aVar2.k(c0769a, hVar, dVar, cls2);
                                hVar.c(58, c0769a.g("list_item_desc"));
                                k7.f fVar12 = new k7.f();
                                k7.f fVar13 = new k7.f();
                                if (c0769a.f71588d) {
                                    hVar.c(25, c0769a.g("list_item_desc"));
                                    String str23 = f71576h;
                                    hVar.g(193, str23);
                                    hVar.b(153, fVar12);
                                    hVar.c(25, c0769a.g("list_item_desc"));
                                    hVar.g(PsExtractor.AUDIO_STREAM, str23);
                                    hVar.c(25, 1);
                                    hVar.c(25, c0769a.g("list_item"));
                                    if (c0769a.f71591g) {
                                        hVar.i(1);
                                    } else {
                                        hVar.c(21, c0769a.g("i"));
                                        hVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    }
                                    hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                                    hVar.d(Integer.valueOf(dVar.f15540j));
                                    StringBuilder sb3 = new StringBuilder();
                                    str2 = str20;
                                    sb3.append(str2);
                                    sb3.append(f71571c);
                                    str8 = str19;
                                    sb3.append(str8);
                                    hVar.k(182, str23, "writeAsArrayNonContext", sb3.toString());
                                    hVar.b(167, fVar13);
                                    hVar.e(fVar12);
                                } else {
                                    fVar8 = fVar8;
                                    fVar11 = fVar11;
                                    str8 = str19;
                                    str2 = str20;
                                }
                                hVar.c(25, c0769a.g("list_item_desc"));
                                hVar.c(25, 1);
                                hVar.c(25, c0769a.g("list_item"));
                                if (c0769a.f71591g) {
                                    hVar.i(1);
                                } else {
                                    hVar.c(21, c0769a.g("i"));
                                    hVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                }
                                hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                                hVar.d(Integer.valueOf(dVar.f15540j));
                                hVar.k(185, f71572d, "write", str2 + f71571c + str8);
                                hVar.e(fVar13);
                                fVar10 = fVar10;
                                hVar.b(167, fVar10);
                                fVar = fVar11;
                            }
                            hVar.e(fVar);
                            hVar.c(25, 1);
                            hVar.c(25, c0769a.g("list_item"));
                            if (c0769a.f71591g) {
                                hVar.i(1);
                            } else {
                                hVar.c(21, c0769a.g("i"));
                                hVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                            }
                            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                                hVar.k(182, f71571c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            } else {
                                hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b((Class) type3)));
                                hVar.d(Integer.valueOf(dVar.f15540j));
                                hVar.k(182, f71571c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                            }
                            hVar.e(fVar10);
                            hVar.e(fVar8);
                            hVar.f(c0769a.g("i"), 1);
                            hVar.b(167, fVar5);
                            hVar.e(fVar7);
                            str = str22;
                            i12 = 25;
                            hVar.c(25, c0769a.g(str));
                            i13 = 16;
                            hVar.c(16, 93);
                            str4 = str21;
                            i14 = 182;
                            hVar.k(182, str18, "write", str4);
                            hVar.e(fVar3);
                        }
                        hVar.c(i12, c0769a.g(str));
                        hVar.c(i13, i16);
                        hVar.k(i14, f71574f, "write", str4);
                        aVar = this;
                        str3 = str4;
                    } else {
                        String str24 = str9;
                        length = length;
                        i15 = i15;
                        str2 = str7;
                        String str25 = str11;
                        k7.f fVar14 = new k7.f();
                        k7.f fVar15 = new k7.f();
                        i(hVar, c0769a, dVar);
                        hVar.i(89);
                        hVar.c(58, c0769a.g("field_" + dVar.f15536f.getName()));
                        hVar.b(199, fVar15);
                        hVar.c(25, c0769a.g(str24));
                        String str26 = f71574f;
                        int i17 = i16;
                        hVar.k(182, str26, "writeNull", "()V");
                        hVar.b(167, fVar14);
                        hVar.e(fVar15);
                        k7.f fVar16 = new k7.f();
                        k7.f fVar17 = new k7.f();
                        hVar.c(25, c0769a.g("field_" + dVar.f15536f.getName()));
                        hVar.k(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                        hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls3)));
                        hVar.b(166, fVar17);
                        j(c0769a, hVar, dVar);
                        hVar.c(58, c0769a.g("fied_ser"));
                        k7.f fVar18 = new k7.f();
                        k7.f fVar19 = new k7.f();
                        if (c0769a.f71588d && Modifier.isPublic(cls3.getModifiers())) {
                            hVar.c(25, c0769a.g("fied_ser"));
                            String str27 = f71576h;
                            hVar.g(193, str27);
                            hVar.b(153, fVar18);
                            hVar.c(25, c0769a.g("fied_ser"));
                            hVar.g(PsExtractor.AUDIO_STREAM, str27);
                            hVar.c(25, 1);
                            hVar.c(25, c0769a.g("field_" + dVar.f15536f.getName()));
                            hVar.c(25, C0769a.f71582h);
                            hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls3)));
                            hVar.d(Integer.valueOf(dVar.f15540j));
                            hVar.k(182, str27, "writeAsArrayNonContext", str2 + f71571c + str8);
                            hVar.b(167, fVar19);
                            hVar.e(fVar18);
                        }
                        hVar.c(25, c0769a.g("fied_ser"));
                        hVar.c(25, 1);
                        hVar.c(25, c0769a.g("field_" + dVar.f15536f.getName()));
                        hVar.c(25, C0769a.f71582h);
                        hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls3)));
                        hVar.d(Integer.valueOf(dVar.f15540j));
                        String str28 = f71572d;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str2);
                        String str29 = f71571c;
                        sb4.append(str29);
                        sb4.append(str8);
                        hVar.k(185, str28, "write", sb4.toString());
                        hVar.e(fVar19);
                        hVar.b(167, fVar16);
                        hVar.e(fVar17);
                        String strL = dVar.l();
                        hVar.c(25, 1);
                        hVar.c(25, c0769a.g("field_" + dVar.f15536f.getName()));
                        if (strL != null) {
                            hVar.d(strL);
                            i11 = 182;
                            hVar.k(182, str29, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                        } else {
                            i11 = 182;
                            hVar.c(25, C0769a.f71582h);
                            Type type4 = dVar.f15537g;
                            if ((type4 instanceof Class) && ((Class) type4).isPrimitive()) {
                                hVar.k(182, str29, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            } else {
                                hVar.c(25, 0);
                                hVar.a(180, c0769a.f71586b, dVar.f15532a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                                hVar.d(Integer.valueOf(dVar.f15540j));
                                i11 = 182;
                                hVar.k(182, str29, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                            }
                            hVar.e(fVar16);
                            hVar.e(fVar14);
                            str = str24;
                            hVar.c(25, c0769a.g(str));
                            hVar.c(16, i17);
                            str3 = str25;
                            hVar.k(i11, str26, "write", str3);
                            aVar = this;
                        }
                        hVar.e(fVar16);
                        hVar.e(fVar14);
                        str = str24;
                        hVar.c(25, c0769a.g(str));
                        hVar.c(16, i17);
                        str3 = str25;
                        hVar.k(i11, str26, "write", str3);
                        aVar = this;
                    }
                    aVar = aVar2;
                    str = str9;
                    length = length;
                    i15 = i15;
                    str2 = str7;
                    str3 = str11;
                }
                aVar = aVar2;
                str = str9;
                str2 = str7;
                str3 = str11;
            }
            str9 = str;
            str11 = str3;
            str7 = str2;
            i15++;
            aVar2 = aVar;
            length = length;
            dVarArr2 = dVarArr;
        }
    }

    public final void B(Class<?> cls, k7.h hVar, com.alibaba.fastjson.util.d[] dVarArr, C0769a c0769a) throws Exception {
        String str;
        int i11;
        int i12;
        String str2;
        Class<?> cls2;
        com.alibaba.fastjson.util.d[] dVarArr2 = dVarArr;
        k7.f fVar = new k7.f();
        int length = dVarArr2.length;
        String str3 = "out";
        if (!c0769a.f71588d) {
            k7.f fVar2 = new k7.f();
            k7.f fVar3 = new k7.f();
            hVar.c(25, c0769a.g("out"));
            hVar.d(Integer.valueOf(SerializerFeature.PrettyFormat.mask));
            hVar.k(182, f71574f, "isEnabled", "(I)Z");
            hVar.b(154, fVar3);
            int length2 = dVarArr2.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length2) {
                    hVar.b(167, fVar2);
                    break;
                }
                int i14 = length2;
                if (dVarArr2[i13].f15533b != null) {
                    hVar.c(25, c0769a.g("out"));
                    hVar.d(Integer.valueOf(SerializerFeature.IgnoreErrorGetter.mask));
                    hVar.k(182, f71574f, "isEnabled", "(I)Z");
                    hVar.b(153, fVar2);
                    break;
                }
                i13++;
                length2 = i14;
            }
            hVar.e(fVar3);
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 2);
            hVar.c(25, 3);
            hVar.c(25, 4);
            hVar.c(21, 5);
            hVar.k(183, f71576h, "write", "(L" + f71571c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.i(177);
            hVar.e(fVar2);
        }
        if (!c0769a.f71591g) {
            k7.f fVar4 = new k7.f();
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 2);
            hVar.c(21, 5);
            hVar.k(182, f71576h, "writeReference", "(L" + f71571c + ";Ljava/lang/Object;I)Z");
            hVar.b(153, fVar4);
            hVar.i(177);
            hVar.e(fVar4);
        }
        if (c0769a.f71588d) {
            str = c0769a.f71591g ? "writeAsArrayNonContext" : "writeAsArray";
        } else {
            str = "writeAsArrayNormal";
        }
        int i15 = c0769a.f71587c.f71610g;
        SerializerFeature serializerFeature = SerializerFeature.BeanToArray;
        if ((i15 & serializerFeature.mask) == 0) {
            k7.f fVar5 = new k7.f();
            hVar.c(25, c0769a.g("out"));
            hVar.d(Integer.valueOf(serializerFeature.mask));
            hVar.k(182, f71574f, "isEnabled", "(I)Z");
            hVar.b(153, fVar5);
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 2);
            hVar.c(25, 3);
            hVar.c(25, 4);
            hVar.c(21, 5);
            hVar.k(182, c0769a.f71586b, str, "(L" + f71571c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.i(177);
            hVar.e(fVar5);
        } else {
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 2);
            hVar.c(25, 3);
            hVar.c(25, 4);
            hVar.c(21, 5);
            hVar.k(182, c0769a.f71586b, str, "(L" + f71571c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.i(177);
        }
        String str4 = "parent";
        if (!c0769a.f71591g) {
            hVar.c(25, 1);
            String str5 = f71571c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("()");
            String str6 = f71578j;
            sb2.append(str6);
            hVar.k(182, str5, "getContext", sb2.toString());
            hVar.c(58, c0769a.g("parent"));
            hVar.c(25, 1);
            hVar.c(25, c0769a.g("parent"));
            hVar.c(25, 2);
            hVar.c(25, 3);
            hVar.d(Integer.valueOf(c0769a.f71587c.f71610g));
            hVar.k(182, str5, "setContext", "(" + str6 + "Ljava/lang/Object;Ljava/lang/Object;I)V");
        }
        boolean z11 = (c0769a.f71587c.f71610g & SerializerFeature.WriteClassName.mask) != 0;
        if (z11 || !c0769a.f71588d) {
            k7.f fVar6 = new k7.f();
            k7.f fVar7 = new k7.f();
            k7.f fVar8 = new k7.f();
            if (z11) {
                i11 = 182;
            } else {
                hVar.c(25, 1);
                hVar.c(25, 4);
                hVar.c(25, 2);
                i11 = 182;
                hVar.k(182, f71571c, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                hVar.b(153, fVar7);
            }
            hVar.c(25, 4);
            hVar.c(25, 2);
            hVar.k(i11, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            hVar.b(165, fVar7);
            hVar.e(fVar8);
            hVar.c(25, c0769a.g("out"));
            hVar.c(16, 123);
            hVar.k(i11, f71574f, "write", "(I)V");
            hVar.c(25, 0);
            hVar.c(25, 1);
            if (c0769a.f71587c.f71606c != null) {
                hVar.d(c0769a.f71587c.f71606c);
            } else {
                hVar.i(1);
            }
            hVar.c(25, 2);
            hVar.k(182, f71576h, "writeClassName", "(L" + f71571c + ";Ljava/lang/String;Ljava/lang/Object;)V");
            hVar.c(16, 44);
            hVar.b(167, fVar6);
            hVar.e(fVar7);
            hVar.c(16, 123);
            hVar.e(fVar6);
        } else {
            hVar.c(16, 123);
            str4 = "parent";
        }
        hVar.c(54, c0769a.g("seperator"));
        if (!c0769a.f71588d) {
            c(hVar, c0769a);
        }
        if (c0769a.f71588d) {
            i12 = 0;
        } else {
            hVar.c(25, c0769a.g("out"));
            hVar.k(182, f71574f, "isNotWriteDefaultValue", "()Z");
            hVar.c(54, c0769a.g("notWriteDefaultValue"));
            hVar.c(25, 1);
            hVar.c(25, 0);
            String str7 = f71571c;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(");
            String str8 = f71579k;
            sb3.append(str8);
            sb3.append(")Z");
            hVar.k(182, str7, "checkValue", sb3.toString());
            hVar.c(54, c0769a.g("checkValue"));
            hVar.c(25, 1);
            i12 = 0;
            hVar.c(25, 0);
            hVar.k(182, str7, "hasNameFilters", "(" + str8 + ")Z");
            hVar.c(54, c0769a.g("hasNameFilters"));
        }
        while (i12 < length) {
            com.alibaba.fastjson.util.d dVar = dVarArr2[i12];
            Class<?> cls3 = dVar.f15536f;
            hVar.d(dVar.f15532a);
            hVar.c(58, C0769a.f71582h);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                str2 = str3;
                m(cls, hVar, dVar, c0769a, c0769a.g(cls3.getName()), 'I');
            } else {
                if (cls3 == Long.TYPE) {
                    cls2 = cls;
                    p(cls2, hVar, dVar, c0769a);
                } else {
                    cls2 = cls;
                    if (cls3 == Float.TYPE) {
                        h(cls2, hVar, dVar, c0769a);
                    } else if (cls3 == Double.TYPE) {
                        e(cls2, hVar, dVar, c0769a);
                    } else if (cls3 == Boolean.TYPE) {
                        str2 = str3;
                        m(cls, hVar, dVar, c0769a, c0769a.g("boolean"), 'Z');
                    } else {
                        str2 = str3;
                        if (cls3 == Character.TYPE) {
                            m(cls, hVar, dVar, c0769a, c0769a.g("char"), 'C');
                        } else if (cls3 == String.class) {
                            w(cls2, hVar, dVar, c0769a);
                        } else if (cls3 == BigDecimal.class) {
                            d(cls2, hVar, dVar, c0769a);
                        } else if (List.class.isAssignableFrom(cls3)) {
                            o(cls2, hVar, dVar, c0769a);
                        } else if (cls3.isEnum()) {
                            f(cls2, hVar, dVar, c0769a);
                        } else {
                            s(cls2, hVar, dVar, c0769a);
                        }
                    }
                }
                str2 = str3;
            }
            i12++;
            dVarArr2 = dVarArr;
            str3 = str2;
        }
        String str9 = str3;
        if (!c0769a.f71588d) {
            a(hVar, c0769a);
        }
        k7.f fVar9 = new k7.f();
        k7.f fVar10 = new k7.f();
        hVar.c(21, c0769a.g("seperator"));
        hVar.h(16, 123);
        hVar.b(160, fVar9);
        hVar.c(25, c0769a.g(str9));
        hVar.c(16, 123);
        String str10 = f71574f;
        hVar.k(182, str10, "write", "(I)V");
        hVar.e(fVar9);
        hVar.c(25, c0769a.g(str9));
        hVar.c(16, 125);
        hVar.k(182, str10, "write", "(I)V");
        hVar.e(fVar10);
        hVar.e(fVar);
        if (c0769a.f71591g) {
            return;
        }
        hVar.c(25, 1);
        hVar.c(25, c0769a.g(str4));
        hVar.k(182, f71571c, "setContext", "(" + f71578j + ")V");
    }

    public final void a(k7.h hVar, C0769a c0769a) {
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 2);
        hVar.c(21, c0769a.g("seperator"));
        hVar.k(182, f71576h, "writeAfter", "(L" + f71571c + ";Ljava/lang/Object;C)C");
        hVar.c(54, c0769a.g("seperator"));
    }

    public final void b(k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a) {
        Class<?> cls = dVar.f15536f;
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 2);
        hVar.c(25, C0769a.f71582h);
        if (cls == Byte.TYPE) {
            hVar.c(21, c0769a.g("byte"));
            hVar.k(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            hVar.c(21, c0769a.g("short"));
            hVar.k(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            hVar.c(21, c0769a.g("int"));
            hVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            hVar.c(21, c0769a.g("char"));
            hVar.k(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            hVar.c(22, c0769a.h("long", 2));
            hVar.k(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            hVar.c(23, c0769a.g("float"));
            hVar.k(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            hVar.c(24, c0769a.h("double", 2));
            hVar.k(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            hVar.c(21, c0769a.g("boolean"));
            hVar.k(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            hVar.c(25, c0769a.g("decimal"));
        } else if (cls == String.class) {
            hVar.c(25, c0769a.g("string"));
        } else if (cls.isEnum()) {
            hVar.c(25, c0769a.g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.c(25, c0769a.g("list"));
        } else {
            hVar.c(25, c0769a.g("object"));
        }
        hVar.k(182, f71576h, "apply", "(L" + f71571c + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    public final void c(k7.h hVar, C0769a c0769a) {
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 2);
        hVar.c(21, c0769a.g("seperator"));
        hVar.k(182, f71576h, "writeBefore", "(L" + f71571c + ";Ljava/lang/Object;C)C");
        hVar.c(54, c0769a.g("seperator"));
    }

    public final void d(Class<?> cls, k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a) {
        k7.f fVar = new k7.f();
        q(hVar, dVar, c0769a, fVar);
        i(hVar, c0769a, dVar);
        hVar.c(58, c0769a.g("decimal"));
        g(hVar, dVar, c0769a, fVar);
        k7.f fVar2 = new k7.f();
        k7.f fVar3 = new k7.f();
        k7.f fVar4 = new k7.f();
        hVar.e(fVar2);
        hVar.c(25, c0769a.g("decimal"));
        hVar.b(199, fVar3);
        l(hVar, dVar, c0769a);
        hVar.b(167, fVar4);
        hVar.e(fVar3);
        hVar.c(25, c0769a.g("out"));
        hVar.c(21, c0769a.g("seperator"));
        hVar.c(25, C0769a.f71582h);
        hVar.c(25, c0769a.g("decimal"));
        hVar.k(182, f71574f, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        v(hVar, c0769a);
        hVar.b(167, fVar4);
        hVar.e(fVar4);
        hVar.e(fVar);
    }

    public final void e(Class<?> cls, k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a) {
        k7.f fVar = new k7.f();
        q(hVar, dVar, c0769a, fVar);
        i(hVar, c0769a, dVar);
        hVar.c(57, c0769a.h("double", 2));
        g(hVar, dVar, c0769a, fVar);
        hVar.c(25, c0769a.g("out"));
        hVar.c(21, c0769a.g("seperator"));
        hVar.c(25, C0769a.f71582h);
        hVar.c(24, c0769a.h("double", 2));
        hVar.k(182, f71574f, "writeFieldValue", "(CLjava/lang/String;D)V");
        v(hVar, c0769a);
        hVar.e(fVar);
    }

    public final void f(Class<?> cls, k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a) {
        k7.f fVar = new k7.f();
        k7.f fVar2 = new k7.f();
        k7.f fVar3 = new k7.f();
        q(hVar, dVar, c0769a, fVar3);
        i(hVar, c0769a, dVar);
        hVar.g(PsExtractor.AUDIO_STREAM, "java/lang/Enum");
        hVar.c(58, c0769a.g("enum"));
        g(hVar, dVar, c0769a, fVar3);
        hVar.c(25, c0769a.g("enum"));
        hVar.b(199, fVar);
        l(hVar, dVar, c0769a);
        hVar.b(167, fVar2);
        hVar.e(fVar);
        if (c0769a.f71588d) {
            hVar.c(25, c0769a.g("out"));
            hVar.c(21, c0769a.g("seperator"));
            hVar.c(25, C0769a.f71582h);
            hVar.c(25, c0769a.g("enum"));
            hVar.k(182, "java/lang/Enum", "name", "()Ljava/lang/String;");
            hVar.k(182, f71574f, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            hVar.c(25, c0769a.g("out"));
            hVar.c(21, c0769a.g("seperator"));
            String str = f71574f;
            hVar.k(182, str, "write", "(I)V");
            hVar.c(25, c0769a.g("out"));
            hVar.c(25, C0769a.f71582h);
            hVar.i(3);
            hVar.k(182, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            hVar.c(25, 1);
            hVar.c(25, c0769a.g("enum"));
            hVar.c(25, C0769a.f71582h);
            hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(dVar.f15536f)));
            hVar.d(Integer.valueOf(dVar.f15540j));
            hVar.k(182, f71571c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        v(hVar, c0769a);
        hVar.e(fVar2);
        hVar.e(fVar3);
    }

    public final void g(k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a, k7.f fVar) {
        if (dVar.f15546p) {
            hVar.c(25, c0769a.g("out"));
            hVar.d(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
            hVar.k(182, f71574f, "isEnabled", "(I)Z");
            hVar.b(154, fVar);
        }
        r(hVar, dVar, c0769a, fVar);
        if (c0769a.f71588d) {
            return;
        }
        b(hVar, dVar, c0769a);
        hVar.b(153, fVar);
        t(hVar, dVar, c0769a);
        u(hVar, dVar, c0769a, fVar);
    }

    public final void h(Class<?> cls, k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a) {
        k7.f fVar = new k7.f();
        q(hVar, dVar, c0769a, fVar);
        i(hVar, c0769a, dVar);
        hVar.c(56, c0769a.g("float"));
        g(hVar, dVar, c0769a, fVar);
        hVar.c(25, c0769a.g("out"));
        hVar.c(21, c0769a.g("seperator"));
        hVar.c(25, C0769a.f71582h);
        hVar.c(23, c0769a.g("float"));
        hVar.k(182, f71574f, "writeFieldValue", "(CLjava/lang/String;F)V");
        v(hVar, c0769a);
        hVar.e(fVar);
    }

    public final void i(k7.h hVar, C0769a c0769a, com.alibaba.fastjson.util.d dVar) {
        Method method = dVar.f15533b;
        if (method != null) {
            hVar.c(25, c0769a.g("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            hVar.k(declaringClass.isInterface() ? 185 : 182, com.alibaba.fastjson.util.b.g(declaringClass), method.getName(), com.alibaba.fastjson.util.b.c(method));
            if (method.getReturnType().equals(dVar.f15536f)) {
                return;
            }
            hVar.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(dVar.f15536f));
            return;
        }
        hVar.c(25, c0769a.g("entity"));
        Field field = dVar.f15534c;
        hVar.a(180, com.alibaba.fastjson.util.b.g(dVar.f15538h), field.getName(), com.alibaba.fastjson.util.b.b(field.getType()));
        if (field.getType().equals(dVar.f15536f)) {
            return;
        }
        hVar.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(dVar.f15536f));
    }

    public final void j(C0769a c0769a, k7.h hVar, com.alibaba.fastjson.util.d dVar) {
        k7.f fVar = new k7.f();
        hVar.c(25, 0);
        String str = c0769a.f71586b;
        String str2 = dVar.f15532a + "_asm_ser_";
        String str3 = f71573e;
        hVar.a(180, str, str2, str3);
        hVar.b(199, fVar);
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(dVar.f15536f)));
        hVar.k(182, f71571c, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        hVar.a(181, c0769a.f71586b, dVar.f15532a + "_asm_ser_", str3);
        hVar.e(fVar);
        hVar.c(25, 0);
        hVar.a(180, c0769a.f71586b, dVar.f15532a + "_asm_ser_", str3);
    }

    public final void k(C0769a c0769a, k7.h hVar, com.alibaba.fastjson.util.d dVar, Class<?> cls) {
        k7.f fVar = new k7.f();
        hVar.c(25, 0);
        String str = c0769a.f71586b;
        String str2 = dVar.f15532a + "_asm_list_item_ser_";
        String str3 = f71573e;
        hVar.a(180, str, str2, str3);
        hVar.b(199, fVar);
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls)));
        hVar.k(182, f71571c, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        hVar.a(181, c0769a.f71586b, dVar.f15532a + "_asm_list_item_ser_", str3);
        hVar.e(fVar);
        hVar.c(25, 0);
        hVar.a(180, c0769a.f71586b, dVar.f15532a + "_asm_list_item_ser_", str3);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0099  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:43:0x0138  */
    public final void l(k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a) {
        int i11;
        int mask;
        int mask2;
        Class<?> cls = dVar.f15536f;
        k7.f fVar = new k7.f();
        k7.f fVar2 = new k7.f();
        k7.f fVar3 = new k7.f();
        k7.f fVar4 = new k7.f();
        hVar.e(fVar);
        j7.b bVarD = dVar.d();
        int iOf = bVarD != null ? SerializerFeature.of(bVarD.serialzeFeatures()) : 0;
        j7.d dVar2 = c0769a.f71587c.f71607d;
        if (dVar2 != null) {
            iOf |= SerializerFeature.of(dVar2.serialzeFeatures());
        }
        if (cls == String.class) {
            mask = SerializerFeature.WriteMapNullValue.getMask();
            mask2 = SerializerFeature.WriteNullStringAsEmpty.getMask();
        } else if (Number.class.isAssignableFrom(cls)) {
            mask = SerializerFeature.WriteMapNullValue.getMask();
            mask2 = SerializerFeature.WriteNullNumberAsZero.getMask();
        } else {
            if (!Collection.class.isAssignableFrom(cls)) {
                if (Boolean.class == cls) {
                    mask = SerializerFeature.WriteMapNullValue.getMask();
                    mask2 = SerializerFeature.WriteNullBooleanAsFalse.getMask();
                } else {
                    i11 = SerializerFeature.WRITE_MAP_NULL_FEATURES;
                }
                if ((iOf & i11) == 0) {
                    hVar.c(25, c0769a.g("out"));
                    hVar.d(Integer.valueOf(i11));
                    hVar.k(182, f71574f, "isEnabled", "(I)Z");
                    hVar.b(153, fVar2);
                }
                hVar.e(fVar3);
                hVar.c(25, c0769a.g("out"));
                hVar.c(21, c0769a.g("seperator"));
                String str = f71574f;
                hVar.k(182, str, "write", "(I)V");
                x(hVar, c0769a);
                hVar.c(25, c0769a.g("out"));
                hVar.d(Integer.valueOf(iOf));
                if (cls != String.class || cls == Character.class) {
                    hVar.d(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
                } else if (Number.class.isAssignableFrom(cls)) {
                    hVar.d(Integer.valueOf(SerializerFeature.WriteNullNumberAsZero.mask));
                } else if (cls == Boolean.class) {
                    hVar.d(Integer.valueOf(SerializerFeature.WriteNullBooleanAsFalse.mask));
                } else if (Collection.class.isAssignableFrom(cls) || cls.isArray()) {
                    hVar.d(Integer.valueOf(SerializerFeature.WriteNullListAsEmpty.mask));
                } else {
                    hVar.d(0);
                }
                hVar.k(182, str, "writeNull", "(II)V");
                v(hVar, c0769a);
                hVar.b(167, fVar4);
                hVar.e(fVar2);
                hVar.e(fVar4);
            }
            mask = SerializerFeature.WriteMapNullValue.getMask();
            mask2 = SerializerFeature.WriteNullListAsEmpty.getMask();
        }
        i11 = mask | mask2;
        if ((iOf & i11) == 0) {
            hVar.c(25, c0769a.g("out"));
            hVar.d(Integer.valueOf(i11));
            hVar.k(182, f71574f, "isEnabled", "(I)Z");
            hVar.b(153, fVar2);
        }
        hVar.e(fVar3);
        hVar.c(25, c0769a.g("out"));
        hVar.c(21, c0769a.g("seperator"));
        String str2 = f71574f;
        hVar.k(182, str2, "write", "(I)V");
        x(hVar, c0769a);
        hVar.c(25, c0769a.g("out"));
        hVar.d(Integer.valueOf(iOf));
        if (cls != String.class) {
            hVar.d(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
        } else {
            hVar.d(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
        }
        hVar.k(182, str2, "writeNull", "(II)V");
        v(hVar, c0769a);
        hVar.b(167, fVar4);
        hVar.e(fVar2);
        hVar.e(fVar4);
    }

    public final void m(Class<?> cls, k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a, int i11, char c11) {
        k7.f fVar = new k7.f();
        q(hVar, dVar, c0769a, fVar);
        i(hVar, c0769a, dVar);
        hVar.c(54, i11);
        g(hVar, dVar, c0769a, fVar);
        hVar.c(25, c0769a.g("out"));
        hVar.c(21, c0769a.g("seperator"));
        hVar.c(25, C0769a.f71582h);
        hVar.c(21, i11);
        hVar.k(182, f71574f, "writeFieldValue", "(CLjava/lang/String;" + c11 + ")V");
        v(hVar, c0769a);
        hVar.e(fVar);
    }

    public final void n(k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a, k7.f fVar) {
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.d(dVar.f15542l);
        hVar.k(182, f71576h, "applyLabel", "(L" + f71571c + ";Ljava/lang/String;)Z");
        hVar.b(153, fVar);
    }

    public final void o(Class<?> cls, k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a) {
        k7.f fVar;
        String str;
        com.alibaba.fastjson.util.d dVar2;
        k7.f fVar2;
        int i11;
        int i12;
        int i13;
        Type typeV = TypeUtils.V(dVar.f15537g);
        Class<?> cls2 = null;
        Class<?> cls3 = typeV instanceof Class ? (Class) typeV : null;
        if (cls3 != Object.class && cls3 != Serializable.class) {
            cls2 = cls3;
        }
        k7.f fVar3 = new k7.f();
        k7.f fVar4 = new k7.f();
        k7.f fVar5 = new k7.f();
        q(hVar, dVar, c0769a, fVar3);
        i(hVar, c0769a, dVar);
        hVar.g(PsExtractor.AUDIO_STREAM, "java/util/List");
        hVar.c(58, c0769a.g("list"));
        g(hVar, dVar, c0769a, fVar3);
        hVar.c(25, c0769a.g("list"));
        hVar.b(199, fVar4);
        l(hVar, dVar, c0769a);
        hVar.b(167, fVar5);
        hVar.e(fVar4);
        hVar.c(25, c0769a.g("out"));
        hVar.c(21, c0769a.g("seperator"));
        String str2 = f71574f;
        hVar.k(182, str2, "write", "(I)V");
        x(hVar, c0769a);
        hVar.c(25, c0769a.g("list"));
        hVar.k(185, "java/util/List", "size", "()I");
        hVar.c(54, c0769a.g("size"));
        k7.f fVar6 = new k7.f();
        k7.f fVar7 = new k7.f();
        hVar.c(21, c0769a.g("size"));
        hVar.i(3);
        hVar.b(160, fVar6);
        hVar.c(25, c0769a.g("out"));
        hVar.d(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        hVar.k(182, str2, "write", "(Ljava/lang/String;)V");
        hVar.b(167, fVar7);
        hVar.e(fVar6);
        if (!c0769a.f71591g) {
            hVar.c(25, 1);
            hVar.c(25, c0769a.g("list"));
            hVar.c(25, C0769a.f71582h);
            hVar.k(182, f71571c, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        }
        if (typeV == String.class && c0769a.f71588d) {
            hVar.c(25, c0769a.g("out"));
            hVar.c(25, c0769a.g("list"));
            hVar.k(182, str2, "write", "(Ljava/util/List;)V");
            i11 = 1;
            i12 = 25;
            i13 = 182;
        } else {
            hVar.c(25, c0769a.g("out"));
            hVar.c(16, 91);
            hVar.k(182, str2, "write", "(I)V");
            k7.f fVar8 = new k7.f();
            k7.f fVar9 = new k7.f();
            k7.f fVar10 = new k7.f();
            hVar.i(3);
            hVar.c(54, c0769a.g("i"));
            hVar.e(fVar8);
            hVar.c(21, c0769a.g("i"));
            hVar.c(21, c0769a.g("size"));
            hVar.b(162, fVar10);
            hVar.c(21, c0769a.g("i"));
            hVar.b(153, fVar9);
            hVar.c(25, c0769a.g("out"));
            hVar.c(16, 44);
            hVar.k(182, str2, "write", "(I)V");
            hVar.e(fVar9);
            hVar.c(25, c0769a.g("list"));
            hVar.c(21, c0769a.g("i"));
            hVar.k(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            hVar.c(58, c0769a.g("list_item"));
            k7.f fVar11 = new k7.f();
            k7.f fVar12 = new k7.f();
            hVar.c(25, c0769a.g("list_item"));
            hVar.b(199, fVar12);
            hVar.c(25, c0769a.g("out"));
            hVar.k(182, str2, "writeNull", "()V");
            hVar.b(167, fVar11);
            hVar.e(fVar12);
            k7.f fVar13 = new k7.f();
            k7.f fVar14 = new k7.f();
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                fVar11 = fVar11;
                fVar = fVar13;
                str = "write";
                dVar2 = dVar;
                fVar2 = fVar14;
            } else {
                hVar.c(25, c0769a.g("list_item"));
                hVar.k(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                hVar.b(166, fVar14);
                dVar2 = dVar;
                k(c0769a, hVar, dVar2, cls2);
                hVar.c(58, c0769a.g("list_item_desc"));
                k7.f fVar15 = new k7.f();
                k7.f fVar16 = new k7.f();
                if (c0769a.f71588d) {
                    String str3 = (c0769a.f71591g && c0769a.f71588d) ? "writeDirectNonContext" : "write";
                    hVar.c(25, c0769a.g("list_item_desc"));
                    String str4 = f71576h;
                    hVar.g(193, str4);
                    hVar.b(153, fVar15);
                    hVar.c(25, c0769a.g("list_item_desc"));
                    hVar.g(PsExtractor.AUDIO_STREAM, str4);
                    hVar.c(25, 1);
                    hVar.c(25, c0769a.g("list_item"));
                    if (c0769a.f71591g) {
                        hVar.i(1);
                    } else {
                        hVar.c(21, c0769a.g("i"));
                        hVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                    hVar.d(Integer.valueOf(dVar2.f15540j));
                    hVar.k(182, str4, str3, "(L" + f71571c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    hVar.b(167, fVar16);
                    hVar.e(fVar15);
                } else {
                    fVar11 = fVar11;
                    fVar14 = fVar14;
                }
                hVar.c(25, c0769a.g("list_item_desc"));
                hVar.c(25, 1);
                hVar.c(25, c0769a.g("list_item"));
                if (c0769a.f71591g) {
                    hVar.i(1);
                } else {
                    hVar.c(21, c0769a.g("i"));
                    hVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls2)));
                hVar.d(Integer.valueOf(dVar2.f15540j));
                str = "write";
                hVar.k(185, f71572d, str, "(L" + f71571c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                hVar.e(fVar16);
                fVar = fVar13;
                hVar.b(167, fVar);
                fVar2 = fVar14;
            }
            hVar.e(fVar2);
            hVar.c(25, 1);
            hVar.c(25, c0769a.g("list_item"));
            if (c0769a.f71591g) {
                hVar.i(1);
            } else {
                hVar.c(21, c0769a.g("i"));
                hVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                hVar.k(182, f71571c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b((Class) typeV)));
                hVar.d(Integer.valueOf(dVar2.f15540j));
                hVar.k(182, f71571c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            hVar.e(fVar);
            hVar.e(fVar11);
            i11 = 1;
            hVar.f(c0769a.g("i"), 1);
            hVar.b(167, fVar8);
            hVar.e(fVar10);
            i12 = 25;
            hVar.c(25, c0769a.g("out"));
            hVar.c(16, 93);
            i13 = 182;
            hVar.k(182, str2, str, "(I)V");
        }
        hVar.c(i12, i11);
        hVar.k(i13, f71571c, "popContext", "()V");
        hVar.e(fVar7);
        v(hVar, c0769a);
        hVar.e(fVar5);
        hVar.e(fVar3);
    }

    public final void p(Class<?> cls, k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a) {
        k7.f fVar = new k7.f();
        q(hVar, dVar, c0769a, fVar);
        i(hVar, c0769a, dVar);
        hVar.c(55, c0769a.h("long", 2));
        g(hVar, dVar, c0769a, fVar);
        hVar.c(25, c0769a.g("out"));
        hVar.c(21, c0769a.g("seperator"));
        hVar.c(25, C0769a.f71582h);
        hVar.c(22, c0769a.h("long", 2));
        hVar.k(182, f71574f, "writeFieldValue", "(CLjava/lang/String;J)V");
        v(hVar, c0769a);
        hVar.e(fVar);
    }

    public final void q(k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a, k7.f fVar) {
        if (!c0769a.f71588d) {
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 2);
            hVar.c(25, C0769a.f71582h);
            hVar.k(182, f71576h, "applyName", "(L" + f71571c + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            hVar.b(153, fVar);
            n(hVar, dVar, c0769a, fVar);
        }
        if (dVar.f15534c == null) {
            hVar.c(25, c0769a.g("out"));
            hVar.d(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
            hVar.k(182, f71574f, "isEnabled", "(I)Z");
            hVar.b(154, fVar);
        }
    }

    public final void r(k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a, k7.f fVar) {
        if (c0769a.f71588d) {
            return;
        }
        k7.f fVar2 = new k7.f();
        hVar.c(21, c0769a.g("notWriteDefaultValue"));
        hVar.b(153, fVar2);
        Class<?> cls = dVar.f15536f;
        if (cls == Boolean.TYPE) {
            hVar.c(21, c0769a.g("boolean"));
            hVar.b(153, fVar);
        } else if (cls == Byte.TYPE) {
            hVar.c(21, c0769a.g("byte"));
            hVar.b(153, fVar);
        } else if (cls == Short.TYPE) {
            hVar.c(21, c0769a.g("short"));
            hVar.b(153, fVar);
        } else if (cls == Integer.TYPE) {
            hVar.c(21, c0769a.g("int"));
            hVar.b(153, fVar);
        } else if (cls == Long.TYPE) {
            hVar.c(22, c0769a.g("long"));
            hVar.i(9);
            hVar.i(148);
            hVar.b(153, fVar);
        } else if (cls == Float.TYPE) {
            hVar.c(23, c0769a.g("float"));
            hVar.i(11);
            hVar.i(149);
            hVar.b(153, fVar);
        } else if (cls == Double.TYPE) {
            hVar.c(24, c0769a.g("double"));
            hVar.i(14);
            hVar.i(151);
            hVar.b(153, fVar);
        }
        hVar.e(fVar2);
    }

    public final void s(Class<?> cls, k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a) {
        k7.f fVar = new k7.f();
        q(hVar, dVar, c0769a, fVar);
        i(hVar, c0769a, dVar);
        hVar.c(58, c0769a.g("object"));
        g(hVar, dVar, c0769a, fVar);
        y(hVar, dVar, c0769a, fVar);
        hVar.e(fVar);
    }

    public final void t(k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a) {
        k7.f fVar = new k7.f();
        hVar.c(21, c0769a.g("hasNameFilters"));
        hVar.b(153, fVar);
        Class<?> cls = dVar.f15536f;
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 2);
        hVar.c(25, C0769a.f71582h);
        if (cls == Byte.TYPE) {
            hVar.c(21, c0769a.g("byte"));
            hVar.k(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            hVar.c(21, c0769a.g("short"));
            hVar.k(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            hVar.c(21, c0769a.g("int"));
            hVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            hVar.c(21, c0769a.g("char"));
            hVar.k(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            hVar.c(22, c0769a.h("long", 2));
            hVar.k(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            hVar.c(23, c0769a.g("float"));
            hVar.k(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            hVar.c(24, c0769a.h("double", 2));
            hVar.k(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            hVar.c(21, c0769a.g("boolean"));
            hVar.k(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            hVar.c(25, c0769a.g("decimal"));
        } else if (cls == String.class) {
            hVar.c(25, c0769a.g("string"));
        } else if (cls.isEnum()) {
            hVar.c(25, c0769a.g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.c(25, c0769a.g("list"));
        } else {
            hVar.c(25, c0769a.g("object"));
        }
        hVar.k(182, f71576h, "processKey", "(L" + f71571c + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        hVar.c(58, C0769a.f71582h);
        hVar.e(fVar);
    }

    public final void u(k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a, k7.f fVar) {
        k7.f fVar2 = new k7.f();
        Class<?> cls = dVar.f15536f;
        if (cls.isPrimitive()) {
            k7.f fVar3 = new k7.f();
            hVar.c(21, c0769a.g("checkValue"));
            hVar.b(154, fVar3);
            hVar.i(1);
            hVar.i(89);
            hVar.c(58, C0769a.f71583i);
            hVar.c(58, C0769a.f71584j);
            hVar.b(167, fVar2);
            hVar.e(fVar3);
        }
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.c(25, 0);
        hVar.d(Integer.valueOf(c0769a.f(dVar.f15532a)));
        String str = f71576h;
        hVar.k(182, str, "getBeanContext", "(I)" + com.alibaba.fastjson.util.b.b(p.class));
        hVar.c(25, 2);
        hVar.c(25, C0769a.f71582h);
        if (cls == Byte.TYPE) {
            hVar.c(21, c0769a.g("byte"));
            hVar.k(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            hVar.i(89);
            hVar.c(58, C0769a.f71583i);
        } else if (cls == Short.TYPE) {
            hVar.c(21, c0769a.g("short"));
            hVar.k(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            hVar.i(89);
            hVar.c(58, C0769a.f71583i);
        } else if (cls == Integer.TYPE) {
            hVar.c(21, c0769a.g("int"));
            hVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            hVar.i(89);
            hVar.c(58, C0769a.f71583i);
        } else if (cls == Character.TYPE) {
            hVar.c(21, c0769a.g("char"));
            hVar.k(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            hVar.i(89);
            hVar.c(58, C0769a.f71583i);
        } else if (cls == Long.TYPE) {
            hVar.c(22, c0769a.h("long", 2));
            hVar.k(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            hVar.i(89);
            hVar.c(58, C0769a.f71583i);
        } else if (cls == Float.TYPE) {
            hVar.c(23, c0769a.g("float"));
            hVar.k(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            hVar.i(89);
            hVar.c(58, C0769a.f71583i);
        } else if (cls == Double.TYPE) {
            hVar.c(24, c0769a.h("double", 2));
            hVar.k(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            hVar.i(89);
            hVar.c(58, C0769a.f71583i);
        } else if (cls == Boolean.TYPE) {
            hVar.c(21, c0769a.g("boolean"));
            hVar.k(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            hVar.i(89);
            hVar.c(58, C0769a.f71583i);
        } else if (cls == BigDecimal.class) {
            hVar.c(25, c0769a.g("decimal"));
            hVar.c(58, C0769a.f71583i);
            hVar.c(25, C0769a.f71583i);
        } else if (cls == String.class) {
            hVar.c(25, c0769a.g("string"));
            hVar.c(58, C0769a.f71583i);
            hVar.c(25, C0769a.f71583i);
        } else if (cls.isEnum()) {
            hVar.c(25, c0769a.g("enum"));
            hVar.c(58, C0769a.f71583i);
            hVar.c(25, C0769a.f71583i);
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.c(25, c0769a.g("list"));
            hVar.c(58, C0769a.f71583i);
            hVar.c(25, C0769a.f71583i);
        } else {
            hVar.c(25, c0769a.g("object"));
            hVar.c(58, C0769a.f71583i);
            hVar.c(25, C0769a.f71583i);
        }
        hVar.k(182, str, "processValue", "(L" + f71571c + ";" + com.alibaba.fastjson.util.b.b(p.class) + "Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.c(58, C0769a.f71584j);
        hVar.c(25, C0769a.f71583i);
        hVar.c(25, C0769a.f71584j);
        hVar.b(165, fVar2);
        y(hVar, dVar, c0769a, fVar);
        hVar.b(167, fVar);
        hVar.e(fVar2);
    }

    public final void v(k7.h hVar, C0769a c0769a) {
        hVar.c(16, 44);
        hVar.c(54, c0769a.g("seperator"));
    }

    public final void w(Class<?> cls, k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a) {
        k7.f fVar = new k7.f();
        if (dVar.f15532a.equals(c0769a.f71587c.f71606c)) {
            hVar.c(25, 1);
            hVar.c(25, 4);
            hVar.c(25, 2);
            hVar.k(182, f71571c, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            hVar.b(154, fVar);
        }
        q(hVar, dVar, c0769a, fVar);
        i(hVar, c0769a, dVar);
        hVar.c(58, c0769a.g("string"));
        g(hVar, dVar, c0769a, fVar);
        k7.f fVar2 = new k7.f();
        k7.f fVar3 = new k7.f();
        hVar.c(25, c0769a.g("string"));
        hVar.b(199, fVar2);
        l(hVar, dVar, c0769a);
        hVar.b(167, fVar3);
        hVar.e(fVar2);
        if ("trim".equals(dVar.f15551u)) {
            hVar.c(25, c0769a.g("string"));
            hVar.k(182, "java/lang/String", "trim", "()Ljava/lang/String;");
            hVar.c(58, c0769a.g("string"));
        }
        if (c0769a.f71588d) {
            hVar.c(25, c0769a.g("out"));
            hVar.c(21, c0769a.g("seperator"));
            hVar.c(25, C0769a.f71582h);
            hVar.c(25, c0769a.g("string"));
            hVar.k(182, f71574f, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            hVar.c(25, c0769a.g("out"));
            hVar.c(21, c0769a.g("seperator"));
            hVar.c(25, C0769a.f71582h);
            hVar.c(25, c0769a.g("string"));
            hVar.k(182, f71574f, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        v(hVar, c0769a);
        hVar.e(fVar3);
        hVar.e(fVar);
    }

    public final void x(k7.h hVar, C0769a c0769a) {
        if (c0769a.f71588d) {
            hVar.c(25, c0769a.g("out"));
            hVar.c(25, C0769a.f71582h);
            hVar.k(182, f71574f, "writeFieldNameDirect", "(Ljava/lang/String;)V");
        } else {
            hVar.c(25, c0769a.g("out"));
            hVar.c(25, C0769a.f71582h);
            hVar.i(3);
            hVar.k(182, f71574f, "writeFieldName", "(Ljava/lang/String;Z)V");
        }
    }

    public final void y(k7.h hVar, com.alibaba.fastjson.util.d dVar, C0769a c0769a, k7.f fVar) {
        k7.f fVar2;
        k7.f fVar3;
        String str;
        String strL = dVar.l();
        Class<?> cls = dVar.f15536f;
        k7.f fVar4 = new k7.f();
        if (c0769a.f71588d) {
            hVar.c(25, c0769a.g("object"));
        } else {
            hVar.c(25, C0769a.f71584j);
        }
        hVar.i(89);
        hVar.c(58, c0769a.g("object"));
        hVar.b(199, fVar4);
        l(hVar, dVar, c0769a);
        hVar.b(167, fVar);
        hVar.e(fVar4);
        hVar.c(25, c0769a.g("out"));
        hVar.c(21, c0769a.g("seperator"));
        hVar.k(182, f71574f, "write", "(I)V");
        x(hVar, c0769a);
        k7.f fVar5 = new k7.f();
        k7.f fVar6 = new k7.f();
        if (!Modifier.isPublic(cls.getModifiers()) || l7.h.w(cls)) {
            fVar2 = fVar5;
            fVar3 = fVar6;
        } else {
            hVar.c(25, c0769a.g("object"));
            hVar.k(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls)));
            hVar.b(166, fVar6);
            j(c0769a, hVar, dVar);
            hVar.c(58, c0769a.g("fied_ser"));
            k7.f fVar7 = new k7.f();
            k7.f fVar8 = new k7.f();
            hVar.c(25, c0769a.g("fied_ser"));
            String str2 = f71576h;
            hVar.g(193, str2);
            hVar.b(153, fVar7);
            int i11 = dVar.f15540j;
            boolean z11 = (SerializerFeature.DisableCircularReferenceDetect.mask & i11) != 0;
            boolean z12 = (SerializerFeature.BeanToArray.mask & i11) != 0;
            if (z11 || (c0769a.f71591g && c0769a.f71588d)) {
                str = z12 ? "writeAsArrayNonContext" : "writeDirectNonContext";
            } else {
                str = z12 ? "writeAsArray" : "write";
            }
            hVar.c(25, c0769a.g("fied_ser"));
            hVar.g(PsExtractor.AUDIO_STREAM, str2);
            hVar.c(25, 1);
            hVar.c(25, c0769a.g("object"));
            hVar.c(25, C0769a.f71582h);
            hVar.c(25, 0);
            hVar.a(180, c0769a.f71586b, dVar.f15532a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            hVar.d(Integer.valueOf(dVar.f15540j));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(L");
            String str3 = f71571c;
            sb2.append(str3);
            sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.k(182, str2, str, sb2.toString());
            hVar.b(167, fVar8);
            hVar.e(fVar7);
            hVar.c(25, c0769a.g("fied_ser"));
            hVar.c(25, 1);
            hVar.c(25, c0769a.g("object"));
            hVar.c(25, C0769a.f71582h);
            hVar.c(25, 0);
            hVar.a(180, c0769a.f71586b, dVar.f15532a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            hVar.d(Integer.valueOf(dVar.f15540j));
            hVar.k(185, f71572d, "write", "(L" + str3 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.e(fVar8);
            fVar2 = fVar5;
            hVar.b(167, fVar2);
            fVar3 = fVar6;
        }
        hVar.e(fVar3);
        hVar.c(25, 1);
        if (c0769a.f71588d) {
            hVar.c(25, c0769a.g("object"));
        } else {
            hVar.c(25, C0769a.f71584j);
        }
        if (strL != 0) {
            hVar.d(strL);
            hVar.k(182, f71571c, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            hVar.c(25, C0769a.f71582h);
            Type type = dVar.f15537g;
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                hVar.k(182, f71571c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                if (dVar.f15536f == String.class) {
                    hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(String.class)));
                } else {
                    hVar.c(25, 0);
                    hVar.a(180, c0769a.f71586b, dVar.f15532a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                hVar.d(Integer.valueOf(dVar.f15540j));
                hVar.k(182, f71571c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
        }
        hVar.e(fVar2);
        v(hVar, c0769a);
    }

    public p0 z(f1 f1Var) throws Exception {
        String str;
        String str2;
        boolean z11;
        Class<f1> cls;
        com.alibaba.fastjson.util.d[] dVarArr;
        String str3;
        String str4;
        boolean z12;
        boolean z13;
        String str5;
        boolean z14;
        boolean z15;
        int i11;
        Method method;
        Class<?> cls2 = f1Var.f71604a;
        if (cls2.isPrimitive()) {
            throw new JSONException("unsupportd class " + cls2.getName());
        }
        j7.d dVar = (j7.d) TypeUtils.N(cls2, j7.d.class);
        com.alibaba.fastjson.util.d[] dVarArr2 = f1Var.f71608e;
        for (com.alibaba.fastjson.util.d dVar2 : dVarArr2) {
            if (dVar2.f15534c == null && (method = dVar2.f15533b) != null && method.getDeclaringClass().isInterface()) {
                return new p0(f1Var);
            }
        }
        com.alibaba.fastjson.util.d[] dVarArr3 = f1Var.f71609f;
        boolean z16 = dVarArr3 == f1Var.f71608e;
        if (dVarArr3.length > 256) {
            return new p0(f1Var);
        }
        for (com.alibaba.fastjson.util.d dVar3 : dVarArr3) {
            if (!com.alibaba.fastjson.util.b.a(dVar3.n().getName())) {
                return new p0(f1Var);
            }
        }
        String str6 = "ASMSerializer_" + this.f71581b.incrementAndGet() + "_" + cls2.getSimpleName();
        Package r11 = a.class.getPackage();
        if (r11 != null) {
            String name = r11.getName();
            String str7 = name.replace('.', '/') + "/" + str6;
            str = name + InstructionFileId.DOT + str6;
            str2 = str7;
        } else {
            str = str6;
            str2 = str;
        }
        k7.c cVar = new k7.c();
        cVar.k(49, 33, str2, f71576h, new String[]{f71572d});
        int i12 = 0;
        for (int length = dVarArr3.length; i12 < length; length = length) {
            com.alibaba.fastjson.util.d dVar4 = dVarArr3[i12];
            if (!dVar4.f15536f.isPrimitive() && dVar4.f15536f != String.class) {
                new k7.d(cVar, 1, dVar4.f15532a + "_asm_fieldType", "Ljava/lang/reflect/Type;").c();
                if (List.class.isAssignableFrom(dVar4.f15536f)) {
                    new k7.d(cVar, 1, dVar4.f15532a + "_asm_list_item_ser_", f71573e).c();
                }
                new k7.d(cVar, 1, dVar4.f15532a + "_asm_ser_", f71573e).c();
            }
            i12++;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Class<f1> cls3 = f1.class;
        sb2.append(com.alibaba.fastjson.util.b.b(cls3));
        sb2.append(")V");
        String string = sb2.toString();
        Class<?> cls4 = String.class;
        k7.c cVar2 = cVar;
        k7.i iVar = new k7.i(cVar2, 1, "<init>", string, null, null);
        iVar.c(25, 0);
        iVar.c(25, 1);
        String str8 = str;
        iVar.k(183, f71576h, "<init>", "(" + com.alibaba.fastjson.util.b.b(cls3) + ")V");
        int i13 = 0;
        while (i13 < dVarArr3.length) {
            com.alibaba.fastjson.util.d dVar5 = dVarArr3[i13];
            if (dVar5.f15536f.isPrimitive() || dVar5.f15536f == cls4) {
                cls4 = cls4;
            } else {
                iVar.c(25, 0);
                if (dVar5.f15533b != null) {
                    iVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(dVar5.f15538h)));
                    iVar.d(dVar5.f15533b.getName());
                    iVar.k(184, com.alibaba.fastjson.util.b.g(com.alibaba.fastjson.util.b.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                } else {
                    iVar.c(25, 0);
                    iVar.d(Integer.valueOf(i13));
                    iVar.k(183, f71576h, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                }
                iVar.a(181, str2, dVar5.f15532a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            }
            i13++;
            cls4 = cls4;
        }
        iVar.i(177);
        iVar.j(4, 4);
        iVar.l();
        if (dVar == null) {
            z11 = false;
            break;
        }
        SerializerFeature[] serializerFeatureArrSerialzeFeatures = dVar.serialzeFeatures();
        int length2 = serializerFeatureArrSerialzeFeatures.length;
        int i14 = 0;
        while (true) {
            if (i14 >= length2) {
                z11 = false;
                break;
            }
            if (serializerFeatureArrSerialzeFeatures[i14] == SerializerFeature.DisableCircularReferenceDetect) {
                z11 = true;
                break;
            }
            i14++;
        }
        int i15 = 0;
        while (true) {
            cls = cls3;
            dVarArr = dVarArr2;
            if (i15 >= 3) {
                break;
            }
            if (i15 == 0) {
                str5 = "write";
                z15 = z11;
                z14 = true;
            } else if (i15 == 1) {
                str5 = "writeNormal";
                z15 = z11;
                z14 = false;
            } else {
                str5 = "writeDirectNonContext";
                z14 = true;
                z15 = true;
            }
            k7.c cVar3 = cVar2;
            String str9 = str8;
            String str10 = str2;
            C0769a c0769a = new C0769a(dVarArr3, f1Var, str2, z14, z15);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(L");
            String str11 = f71571c;
            sb3.append(str11);
            sb3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            int i16 = i15;
            k7.i iVar2 = new k7.i(cVar2, 1, str5, sb3.toString(), null, new String[]{"java/io/IOException"});
            k7.f fVar = new k7.f();
            iVar2.c(25, 2);
            iVar2.b(199, fVar);
            iVar2.c(25, 1);
            iVar2.k(182, str11, "writeNull", "()V");
            iVar2.i(177);
            iVar2.e(fVar);
            iVar2.c(25, 1);
            iVar2.a(180, str11, "out", f71575g);
            iVar2.c(58, c0769a.g("out"));
            if (z16 || c0769a.f71588d || !(dVar == null || dVar.alphabetic())) {
                str2 = str10;
            } else {
                k7.f fVar2 = new k7.f();
                iVar2.c(25, c0769a.g("out"));
                iVar2.k(182, f71574f, "isSortField", "()Z");
                iVar2.b(154, fVar2);
                iVar2.c(25, 0);
                iVar2.c(25, 1);
                iVar2.c(25, 2);
                iVar2.c(25, 3);
                iVar2.c(25, 4);
                iVar2.c(21, 5);
                str2 = str10;
                iVar2.k(182, str2, "writeUnsorted", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                iVar2.i(177);
                iVar2.e(fVar2);
            }
            if (!c0769a.f71588d || z15) {
                i11 = 177;
            } else {
                k7.f fVar3 = new k7.f();
                k7.f fVar4 = new k7.f();
                iVar2.c(25, 0);
                iVar2.c(25, 1);
                iVar2.k(182, f71576h, "writeDirect", "(L" + str11 + ";)Z");
                iVar2.b(154, fVar4);
                iVar2.c(25, 0);
                iVar2.c(25, 1);
                iVar2.c(25, 2);
                iVar2.c(25, 3);
                iVar2.c(25, 4);
                iVar2.c(21, 5);
                iVar2.k(182, str2, "writeNormal", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                iVar2.i(177);
                iVar2.e(fVar4);
                iVar2.c(25, c0769a.g("out"));
                iVar2.d(Integer.valueOf(SerializerFeature.DisableCircularReferenceDetect.mask));
                iVar2.k(182, f71574f, "isEnabled", "(I)Z");
                iVar2.b(153, fVar3);
                iVar2.c(25, 0);
                iVar2.c(25, 1);
                iVar2.c(25, 2);
                iVar2.c(25, 3);
                iVar2.c(25, 4);
                iVar2.c(21, 5);
                iVar2.k(182, str2, "writeDirectNonContext", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                i11 = 177;
                iVar2.i(177);
                iVar2.e(fVar3);
            }
            iVar2.c(25, 2);
            iVar2.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls2));
            iVar2.c(58, c0769a.g("entity"));
            B(cls2, iVar2, dVarArr3, c0769a);
            iVar2.i(i11);
            iVar2.j(7, c0769a.f71590f + 2);
            iVar2.l();
            i15 = i16 + 1;
            dVar = dVar;
            z16 = z16;
            cls3 = cls;
            dVarArr2 = dVarArr;
            cVar2 = cVar3;
            str8 = str9;
        }
        k7.c cVar4 = cVar2;
        String str12 = str8;
        if (z16) {
            str3 = "entity";
        } else {
            C0769a c0769a2 = new C0769a(dVarArr3, f1Var, str2, false, z11);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("(L");
            String str13 = f71571c;
            sb4.append(str13);
            sb4.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            str3 = "entity";
            k7.i iVar3 = new k7.i(cVar4, 1, "writeUnsorted", sb4.toString(), null, new String[]{"java/io/IOException"});
            iVar3.c(25, 1);
            iVar3.a(180, str13, "out", f71575g);
            iVar3.c(58, c0769a2.g("out"));
            iVar3.c(25, 2);
            iVar3.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls2));
            iVar3.c(58, c0769a2.g(str3));
            B(cls2, iVar3, dVarArr, c0769a2);
            iVar3.i(177);
            iVar3.j(7, c0769a2.f71590f + 2);
            iVar3.l();
        }
        int i17 = 0;
        for (int i18 = 3; i17 < i18; i18 = 3) {
            if (i17 == 0) {
                str4 = "writeAsArray";
                z13 = z11;
                z12 = true;
            } else if (i17 == 1) {
                str4 = "writeAsArrayNormal";
                z13 = z11;
                z12 = false;
            } else {
                str4 = "writeAsArrayNonContext";
                z12 = true;
                z13 = true;
            }
            C0769a c0769a3 = new C0769a(dVarArr3, f1Var, str2, z12, z13);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("(L");
            String str14 = f71571c;
            sb5.append(str14);
            sb5.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            k7.i iVar4 = new k7.i(cVar4, 1, str4, sb5.toString(), null, new String[]{"java/io/IOException"});
            iVar4.c(25, 1);
            iVar4.a(180, str14, "out", f71575g);
            iVar4.c(58, c0769a3.g("out"));
            iVar4.c(25, 2);
            iVar4.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls2));
            str3 = str3;
            iVar4.c(58, c0769a3.g(str3));
            A(cls2, iVar4, dVarArr3, c0769a3);
            iVar4.i(177);
            iVar4.j(7, c0769a3.f71590f + 2);
            iVar4.l();
            i17++;
        }
        byte[] bArrJ = cVar4.j();
        return (p0) this.f71580a.a(str12, bArrJ, 0, bArrJ.length).getConstructor(cls).newInstance(f1Var);
    }
}
