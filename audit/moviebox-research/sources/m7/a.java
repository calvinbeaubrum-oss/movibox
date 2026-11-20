package m7;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.TypeUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.transsion.gslb.Worker;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f70866c = com.alibaba.fastjson.util.b.g(l7.a.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f70867d = com.alibaba.fastjson.util.b.g(l7.c.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.alibaba.fastjson.util.a f70868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f70869b = new AtomicLong();

    /* JADX INFO: renamed from: m7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0757a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f70870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Integer> f70871b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<?> f70872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.alibaba.fastjson.util.h f70873d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f70874e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.alibaba.fastjson.util.d[] f70875f;

        public C0757a(String str, l7.h hVar, com.alibaba.fastjson.util.h hVar2, int i11) {
            this.f70870a = -1;
            this.f70874e = str;
            this.f70872c = hVar2.f15577a;
            this.f70870a = i11;
            this.f70873d = hVar2;
            this.f70875f = hVar2.f15584h;
        }

        public String g(com.alibaba.fastjson.util.d dVar) {
            if (j(dVar.f15532a)) {
                return dVar.f15532a + "_asm_deser__";
            }
            return "_asm_deser__" + TypeUtils.K(dVar.f15532a);
        }

        public String h(com.alibaba.fastjson.util.d dVar) {
            if (j(dVar.f15532a)) {
                return dVar.f15532a + "_asm_prefix__";
            }
            return "asm_field_" + TypeUtils.K(dVar.f15532a);
        }

        public Class<?> i() {
            Class<?> cls = this.f70873d.f15578b;
            return cls == null ? this.f70872c : cls;
        }

        public boolean j(String str) {
            for (int i11 = 0; i11 < str.length(); i11++) {
                char cCharAt = str.charAt(i11);
                if (cCharAt == 0) {
                    if (!com.alibaba.fastjson.util.f.h(cCharAt)) {
                        return false;
                    }
                } else if (!com.alibaba.fastjson.util.f.l(cCharAt)) {
                    return false;
                }
            }
            return true;
        }

        public int k(String str) {
            if (this.f70871b.get(str) == null) {
                Map<String, Integer> map = this.f70871b;
                int i11 = this.f70870a;
                this.f70870a = i11 + 1;
                map.put(str, Integer.valueOf(i11));
            }
            return this.f70871b.get(str).intValue();
        }

        public int l(String str, int i11) {
            if (this.f70871b.get(str) == null) {
                this.f70871b.put(str, Integer.valueOf(this.f70870a));
                this.f70870a += i11;
            }
            return this.f70871b.get(str).intValue();
        }

        public int m(com.alibaba.fastjson.util.d dVar) {
            return k(dVar.f15532a + "_asm");
        }

        public int n(com.alibaba.fastjson.util.d dVar, int i11) {
            return l(dVar.f15532a + "_asm", i11);
        }
    }

    public a(ClassLoader classLoader) {
        this.f70868a = classLoader instanceof com.alibaba.fastjson.util.a ? (com.alibaba.fastjson.util.a) classLoader : new com.alibaba.fastjson.util.a(classLoader);
    }

    public final void a(C0757a c0757a, k7.h hVar) {
        b(c0757a, hVar, true);
    }

    public final void b(C0757a c0757a, k7.h hVar, boolean z11) {
        int length = c0757a.f70875f.length;
        for (int i11 = 0; i11 < length; i11++) {
            k7.f fVar = new k7.f();
            if (z11) {
                n(hVar, c0757a, i11, fVar);
            }
            o(c0757a, hVar, c0757a.f70875f[i11]);
            if (z11) {
                hVar.e(fVar);
            }
        }
    }

    public final void c(k7.c cVar, C0757a c0757a) {
        if (Modifier.isPublic(c0757a.f70873d.f15579c.getModifiers())) {
            k7.i iVar = new k7.i(cVar, 1, "createInstance", "(L" + f70866c + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", null, null);
            iVar.g(187, com.alibaba.fastjson.util.b.g(c0757a.i()));
            iVar.i(89);
            iVar.k(183, com.alibaba.fastjson.util.b.g(c0757a.i()), "<init>", "()V");
            iVar.i(176);
            iVar.j(3, 3);
            iVar.l();
        }
    }

    public final void d(C0757a c0757a, k7.h hVar) {
        Constructor<?> constructor = c0757a.f70873d.f15579c;
        if (Modifier.isPublic(constructor.getModifiers())) {
            hVar.g(187, com.alibaba.fastjson.util.b.g(c0757a.i()));
            hVar.i(89);
            hVar.k(183, com.alibaba.fastjson.util.b.g(constructor.getDeclaringClass()), "<init>", "()V");
        } else {
            hVar.c(25, 0);
            hVar.c(25, 1);
            hVar.c(25, 0);
            hVar.a(180, com.alibaba.fastjson.util.b.g(o.class), "clazz", "Ljava/lang/Class;");
            hVar.k(183, com.alibaba.fastjson.util.b.g(o.class), "createInstance", "(L" + f70866c + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
            hVar.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(c0757a.i()));
        }
        hVar.c(58, c0757a.k("instance"));
    }

    public final void e(C0757a c0757a, k7.h hVar, com.alibaba.fastjson.util.d dVar, Class<?> cls, int i11) {
        l(c0757a, hVar, dVar);
        k7.f fVar = new k7.f();
        k7.f fVar2 = new k7.f();
        if ((dVar.f15541k & Feature.SupportArrayToBean.mask) != 0) {
            hVar.i(89);
            hVar.g(193, com.alibaba.fastjson.util.b.g(o.class));
            hVar.b(153, fVar);
            hVar.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(o.class));
            hVar.c(25, 1);
            if (dVar.f15537g instanceof Class) {
                hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(dVar.f15536f)));
            } else {
                hVar.c(25, 0);
                hVar.d(Integer.valueOf(i11));
                hVar.k(182, com.alibaba.fastjson.util.b.g(o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            hVar.d(dVar.f15532a);
            hVar.d(Integer.valueOf(dVar.f15541k));
            hVar.k(182, com.alibaba.fastjson.util.b.g(o.class), "deserialze", "(L" + f70866c + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            hVar.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls));
            hVar.c(58, c0757a.m(dVar));
            hVar.b(167, fVar2);
            hVar.e(fVar);
        }
        hVar.c(25, 1);
        if (dVar.f15537g instanceof Class) {
            hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(dVar.f15536f)));
        } else {
            hVar.c(25, 0);
            hVar.d(Integer.valueOf(i11));
            hVar.k(182, com.alibaba.fastjson.util.b.g(o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        hVar.d(dVar.f15532a);
        hVar.k(185, com.alibaba.fastjson.util.b.g(b2.class), "deserialze", "(L" + f70866c + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls));
        hVar.c(58, c0757a.m(dVar));
        hVar.e(fVar2);
    }

    public final void f(C0757a c0757a, k7.h hVar, k7.f fVar) {
        hVar.h(21, c0757a.k("matchedCount"));
        hVar.b(158, fVar);
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, f70867d, "token", "()I");
        hVar.d(13);
        hVar.b(160, fVar);
        r(c0757a, hVar);
    }

    /* JADX WARN: Code duplicated, block: B:134:0x0ac1  */
    public final void g(k7.c cVar, C0757a c0757a) {
        int i11;
        k7.f fVar;
        String str;
        String str2;
        String str3;
        k7.i iVar;
        k7.f fVar2;
        k7.f fVar3;
        int i12;
        String str4;
        String str5;
        k7.f fVar4;
        if (c0757a.f70875f.length == 0) {
            return;
        }
        for (com.alibaba.fastjson.util.d dVar : c0757a.f70875f) {
            Class<?> cls = dVar.f15536f;
            Type type = dVar.f15537g;
            if (cls == Character.TYPE) {
                return;
            }
            if (Collection.class.isAssignableFrom(cls) && (!(type instanceof ParameterizedType) || !(((ParameterizedType) type).getActualTypeArguments()[0] instanceof Class))) {
                return;
            }
        }
        com.alibaba.fastjson.util.h hVar = c0757a.f70873d;
        c0757a.f70875f = hVar.f15585i;
        StringBuilder sb2 = new StringBuilder();
        String str6 = "(L";
        sb2.append("(L");
        String str7 = f70866c;
        sb2.append(str7);
        sb2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
        k7.i iVar2 = new k7.i(cVar, 1, "deserialze", sb2.toString(), null, null);
        k7.f fVar5 = new k7.f();
        k7.f fVar6 = new k7.f();
        k7.f fVar7 = new k7.f();
        k7.f fVar8 = new k7.f();
        w(c0757a, iVar2);
        k7.f fVar9 = new k7.f();
        iVar2.c(25, c0757a.k("lexer"));
        String str8 = f70867d;
        iVar2.k(182, str8, "token", "()I");
        iVar2.d(14);
        iVar2.b(160, fVar9);
        int i13 = hVar.f15586j;
        Feature feature = Feature.SupportArrayToBean;
        if ((i13 & feature.mask) == 0) {
            iVar2.c(25, c0757a.k("lexer"));
            iVar2.c(21, 4);
            iVar2.d(Integer.valueOf(feature.mask));
            iVar2.k(182, str8, "isEnabled", "(II)Z");
            iVar2.b(153, fVar9);
        }
        iVar2.c(25, 0);
        iVar2.c(25, 1);
        iVar2.c(25, 2);
        iVar2.c(25, 3);
        iVar2.i(1);
        iVar2.k(183, c0757a.f70874e, "deserialzeArrayMapping", "(L" + str7 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        iVar2.i(176);
        iVar2.e(fVar9);
        iVar2.c(25, c0757a.k("lexer"));
        iVar2.d(Integer.valueOf(Feature.SortFeidFastMatch.mask));
        iVar2.k(182, str8, "isEnabled", "(I)Z");
        k7.f fVar10 = new k7.f();
        iVar2.b(154, fVar10);
        iVar2.b(200, fVar6);
        iVar2.e(fVar10);
        iVar2.c(25, c0757a.k("lexer"));
        iVar2.d(c0757a.f70872c.getName());
        iVar2.k(182, str8, "scanType", "(Ljava/lang/String;)I");
        iVar2.d(-1);
        k7.f fVar11 = new k7.f();
        iVar2.b(160, fVar11);
        iVar2.b(200, fVar6);
        iVar2.e(fVar11);
        iVar2.c(25, 1);
        iVar2.k(182, str7, "getContext", "()" + com.alibaba.fastjson.util.b.b(l7.g.class));
        iVar2.c(58, c0757a.k("mark_context"));
        iVar2.i(3);
        iVar2.c(54, c0757a.k("matchedCount"));
        d(c0757a, iVar2);
        iVar2.c(25, 1);
        iVar2.k(182, str7, "getContext", "()" + com.alibaba.fastjson.util.b.b(l7.g.class));
        iVar2.c(58, c0757a.k("context"));
        iVar2.c(25, 1);
        iVar2.c(25, c0757a.k("context"));
        iVar2.c(25, c0757a.k("instance"));
        iVar2.c(25, 3);
        iVar2.k(182, str7, "setContext", "(" + com.alibaba.fastjson.util.b.b(l7.g.class) + "Ljava/lang/Object;Ljava/lang/Object;)" + com.alibaba.fastjson.util.b.b(l7.g.class));
        iVar2.c(58, c0757a.k("childContext"));
        iVar2.c(25, c0757a.k("lexer"));
        String str9 = "matchStat";
        String str10 = "I";
        iVar2.a(180, str8, "matchStat", "I");
        iVar2.d(4);
        k7.f fVar12 = new k7.f();
        iVar2.b(160, fVar12);
        iVar2.b(200, fVar7);
        iVar2.e(fVar12);
        int i14 = 3;
        iVar2.i(3);
        iVar2.h(54, c0757a.k("matchStat"));
        int length = c0757a.f70875f.length;
        int i15 = 0;
        while (i15 < length) {
            iVar2.i(i14);
            iVar2.c(54, c0757a.k("_asm_flag_" + (i15 / 32)));
            i15 += 32;
            i14 = 3;
        }
        iVar2.c(25, c0757a.k("lexer"));
        iVar2.d(Integer.valueOf(Feature.InitStringFieldAsEmpty.mask));
        iVar2.k(182, f70867d, "isEnabled", "(I)Z");
        iVar2.h(54, c0757a.k("initStringFieldAsEmpty"));
        int i16 = 0;
        while (i16 < length) {
            com.alibaba.fastjson.util.d dVar2 = c0757a.f70875f[i16];
            Class<?> cls2 = dVar2.f15536f;
            if (cls2 == Boolean.TYPE || cls2 == Byte.TYPE || cls2 == Short.TYPE || cls2 == Integer.TYPE) {
                str6 = str6;
                fVar5 = fVar5;
                fVar6 = fVar6;
                fVar7 = fVar7;
                iVar2.i(3);
                iVar2.c(54, c0757a.m(dVar2));
            } else {
                if (cls2 == Long.TYPE) {
                    iVar2.i(9);
                    iVar2.c(55, c0757a.n(dVar2, 2));
                } else if (cls2 == Float.TYPE) {
                    iVar2.i(11);
                    iVar2.c(56, c0757a.m(dVar2));
                } else if (cls2 == Double.TYPE) {
                    iVar2.i(14);
                    iVar2.c(57, c0757a.n(dVar2, 2));
                } else {
                    if (cls2 == String.class) {
                        k7.f fVar13 = new k7.f();
                        k7.f fVar14 = new k7.f();
                        iVar2.c(21, c0757a.k("initStringFieldAsEmpty"));
                        iVar2.b(153, fVar14);
                        u(iVar2, c0757a, i16);
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.k(182, f70867d, "stringDefaultValue", "()Ljava/lang/String;");
                        iVar2.b(167, fVar13);
                        iVar2.e(fVar14);
                        iVar2.i(1);
                        iVar2.e(fVar13);
                    } else {
                        iVar2.i(1);
                    }
                    iVar2.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls2));
                    iVar2.c(58, c0757a.m(dVar2));
                }
                str6 = str6;
                fVar5 = fVar5;
                fVar6 = fVar6;
                fVar7 = fVar7;
            }
            i16++;
            fVar6 = fVar6;
            fVar7 = fVar7;
            fVar5 = fVar5;
            str6 = str6;
        }
        String str11 = str6;
        k7.f fVar15 = fVar5;
        k7.f fVar16 = fVar6;
        k7.f fVar17 = fVar7;
        int i17 = 0;
        while (i17 < length) {
            com.alibaba.fastjson.util.d dVar3 = c0757a.f70875f[i17];
            Class<?> cls3 = dVar3.f15536f;
            Type type2 = dVar3.f15537g;
            k7.f fVar18 = new k7.f();
            if (cls3 == Boolean.TYPE) {
                iVar2.c(25, c0757a.k("lexer"));
                iVar2.c(25, 0);
                iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                iVar2.k(182, f70867d, "scanFieldBoolean", "([C)Z");
                iVar2.c(54, c0757a.m(dVar3));
            } else {
                if (cls3 == Byte.TYPE) {
                    iVar2.c(25, c0757a.k("lexer"));
                    iVar2.c(25, 0);
                    iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                    iVar2.k(182, f70867d, "scanFieldInt", "([C)I");
                    iVar2.c(54, c0757a.m(dVar3));
                } else {
                    i11 = length;
                    fVar = fVar18;
                    if (cls3 == Byte.class) {
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.c(25, 0);
                        iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                        String str12 = f70867d;
                        iVar2.k(182, str12, "scanFieldInt", "([C)I");
                        iVar2.k(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                        iVar2.c(58, c0757a.m(dVar3));
                        k7.f fVar19 = new k7.f();
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.a(180, str12, str9, str10);
                        iVar2.d(5);
                        iVar2.b(160, fVar19);
                        iVar2.i(1);
                        iVar2.c(58, c0757a.m(dVar3));
                        iVar2.e(fVar19);
                    } else if (cls3 == Short.TYPE) {
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.c(25, 0);
                        iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                        iVar2.k(182, f70867d, "scanFieldInt", "([C)I");
                        iVar2.c(54, c0757a.m(dVar3));
                    } else if (cls3 == Short.class) {
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.c(25, 0);
                        iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                        String str13 = f70867d;
                        iVar2.k(182, str13, "scanFieldInt", "([C)I");
                        iVar2.k(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                        iVar2.c(58, c0757a.m(dVar3));
                        k7.f fVar20 = new k7.f();
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.a(180, str13, str9, str10);
                        iVar2.d(5);
                        iVar2.b(160, fVar20);
                        iVar2.i(1);
                        iVar2.c(58, c0757a.m(dVar3));
                        iVar2.e(fVar20);
                    } else if (cls3 == Integer.TYPE) {
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.c(25, 0);
                        iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                        iVar2.k(182, f70867d, "scanFieldInt", "([C)I");
                        iVar2.c(54, c0757a.m(dVar3));
                    } else if (cls3 == Integer.class) {
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.c(25, 0);
                        iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                        String str14 = f70867d;
                        iVar2.k(182, str14, "scanFieldInt", "([C)I");
                        iVar2.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        iVar2.c(58, c0757a.m(dVar3));
                        k7.f fVar21 = new k7.f();
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.a(180, str14, str9, str10);
                        iVar2.d(5);
                        iVar2.b(160, fVar21);
                        iVar2.i(1);
                        iVar2.c(58, c0757a.m(dVar3));
                        iVar2.e(fVar21);
                    } else if (cls3 == Long.TYPE) {
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.c(25, 0);
                        iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                        iVar2.k(182, f70867d, "scanFieldLong", "([C)J");
                        iVar2.c(55, c0757a.n(dVar3, 2));
                    } else if (cls3 == Long.class) {
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.c(25, 0);
                        iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                        String str15 = f70867d;
                        iVar2.k(182, str15, "scanFieldLong", "([C)J");
                        iVar2.k(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                        iVar2.c(58, c0757a.m(dVar3));
                        k7.f fVar22 = new k7.f();
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.a(180, str15, str9, str10);
                        iVar2.d(5);
                        iVar2.b(160, fVar22);
                        iVar2.i(1);
                        iVar2.c(58, c0757a.m(dVar3));
                        iVar2.e(fVar22);
                    } else if (cls3 == Float.TYPE) {
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.c(25, 0);
                        iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                        iVar2.k(182, f70867d, "scanFieldFloat", "([C)F");
                        iVar2.c(56, c0757a.m(dVar3));
                    } else if (cls3 == Float.class) {
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.c(25, 0);
                        iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                        String str16 = f70867d;
                        iVar2.k(182, str16, "scanFieldFloat", "([C)F");
                        iVar2.k(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                        iVar2.c(58, c0757a.m(dVar3));
                        k7.f fVar23 = new k7.f();
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.a(180, str16, str9, str10);
                        iVar2.d(5);
                        iVar2.b(160, fVar23);
                        iVar2.i(1);
                        iVar2.c(58, c0757a.m(dVar3));
                        iVar2.e(fVar23);
                    } else {
                        if (cls3 == Double.TYPE) {
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.c(25, 0);
                            iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                            iVar2.k(182, f70867d, "scanFieldDouble", "([C)D");
                            iVar2.c(57, c0757a.n(dVar3, 2));
                        } else if (cls3 == Double.class) {
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.c(25, 0);
                            iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                            String str17 = f70867d;
                            iVar2.k(182, str17, "scanFieldDouble", "([C)D");
                            iVar2.k(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                            iVar2.c(58, c0757a.m(dVar3));
                            k7.f fVar24 = new k7.f();
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.a(180, str17, str9, str10);
                            iVar2.d(5);
                            iVar2.b(160, fVar24);
                            iVar2.i(1);
                            iVar2.c(58, c0757a.m(dVar3));
                            iVar2.e(fVar24);
                        } else if (cls3 == String.class) {
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.c(25, 0);
                            iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                            iVar2.k(182, f70867d, "scanFieldString", "([C)Ljava/lang/String;");
                            iVar2.c(58, c0757a.m(dVar3));
                        } else if (cls3 == Date.class) {
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.c(25, 0);
                            iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                            iVar2.k(182, f70867d, "scanFieldDate", "([C)Ljava/util/Date;");
                            iVar2.c(58, c0757a.m(dVar3));
                        } else if (cls3 == UUID.class) {
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.c(25, 0);
                            iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                            iVar2.k(182, f70867d, "scanFieldUUID", "([C)Ljava/util/UUID;");
                            iVar2.c(58, c0757a.m(dVar3));
                        } else if (cls3 == BigDecimal.class) {
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.c(25, 0);
                            iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                            iVar2.k(182, f70867d, "scanFieldDecimal", "([C)Ljava/math/BigDecimal;");
                            iVar2.c(58, c0757a.m(dVar3));
                        } else if (cls3 == BigInteger.class) {
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.c(25, 0);
                            iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                            iVar2.k(182, f70867d, "scanFieldBigInteger", "([C)Ljava/math/BigInteger;");
                            iVar2.c(58, c0757a.m(dVar3));
                        } else if (cls3 == int[].class) {
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.c(25, 0);
                            iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                            iVar2.k(182, f70867d, "scanFieldIntArray", "([C)[I");
                            iVar2.c(58, c0757a.m(dVar3));
                        } else if (cls3 == float[].class) {
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.c(25, 0);
                            iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                            iVar2.k(182, f70867d, "scanFieldFloatArray", "([C)[F");
                            iVar2.c(58, c0757a.m(dVar3));
                        } else if (cls3 == float[][].class) {
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.c(25, 0);
                            iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                            iVar2.k(182, f70867d, "scanFieldFloatArray2", "([C)[[F");
                            iVar2.c(58, c0757a.m(dVar3));
                        } else if (cls3.isEnum()) {
                            iVar2.c(25, 0);
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.c(25, 0);
                            iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                            l(c0757a, iVar2, dVar3);
                            String strG = com.alibaba.fastjson.util.b.g(o.class);
                            StringBuilder sb3 = new StringBuilder();
                            str = str11;
                            sb3.append(str);
                            sb3.append(f70867d);
                            sb3.append(";[C");
                            sb3.append(com.alibaba.fastjson.util.b.b(b2.class));
                            sb3.append(")Ljava/lang/Enum;");
                            iVar2.k(182, strG, "scanEnum", sb3.toString());
                            iVar2.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls3));
                            iVar2.c(58, c0757a.m(dVar3));
                            iVar2.c(25, c0757a.k("lexer"));
                            str5 = f70867d;
                            iVar2.a(180, str5, str9, str10);
                            k7.f fVar25 = new k7.f();
                            iVar2.b(158, fVar25);
                            u(iVar2, c0757a, i17);
                            iVar2.e(fVar25);
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.a(180, str5, str9, str10);
                            iVar2.i(89);
                            iVar2.c(54, c0757a.k(str9));
                            iVar2.d(-1);
                            fVar4 = fVar15;
                            iVar2.b(159, fVar4);
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.a(180, str5, str9, str10);
                            k7.f fVar26 = fVar;
                            iVar2.b(158, fVar26);
                            iVar2.c(21, c0757a.k("matchedCount"));
                            iVar2.i(4);
                            iVar2.i(96);
                            iVar2.c(54, c0757a.k("matchedCount"));
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.a(180, str5, str9, str10);
                            iVar2.d(4);
                            fVar2 = fVar8;
                            iVar2.b(159, fVar2);
                            iVar2.e(fVar26);
                            if (i17 == i11 - 1) {
                                iVar2.c(25, c0757a.k("lexer"));
                                iVar2.a(180, str5, str9, str10);
                                iVar2.d(4);
                                iVar2.b(160, fVar4);
                            }
                            str4 = str10;
                            str2 = str9;
                            str3 = str;
                            iVar = iVar2;
                            i12 = i11;
                            fVar3 = fVar4;
                        } else {
                            str = str11;
                            if (Collection.class.isAssignableFrom(cls3)) {
                                iVar2.c(25, c0757a.k("lexer"));
                                iVar2.c(25, 0);
                                iVar2.a(180, c0757a.f70874e, c0757a.h(dVar3), "[C");
                                Class<?> clsS = TypeUtils.S(type2);
                                if (clsS == String.class) {
                                    iVar2.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls3)));
                                    iVar2.k(182, f70867d, "scanFieldStringArray", "([CLjava/lang/Class;)" + com.alibaba.fastjson.util.b.b(Collection.class));
                                    iVar2.c(58, c0757a.m(dVar3));
                                    iVar2.c(25, c0757a.k("lexer"));
                                    str5 = f70867d;
                                    iVar2.a(180, str5, str9, str10);
                                    k7.f fVar27 = new k7.f();
                                    iVar2.b(158, fVar27);
                                    u(iVar2, c0757a, i17);
                                    iVar2.e(fVar27);
                                    iVar2.c(25, c0757a.k("lexer"));
                                    iVar2.a(180, str5, str9, str10);
                                    iVar2.i(89);
                                    iVar2.c(54, c0757a.k(str9));
                                    iVar2.d(-1);
                                    fVar4 = fVar15;
                                    iVar2.b(159, fVar4);
                                    iVar2.c(25, c0757a.k("lexer"));
                                    iVar2.a(180, str5, str9, str10);
                                    k7.f fVar28 = fVar;
                                    iVar2.b(158, fVar28);
                                    iVar2.c(21, c0757a.k("matchedCount"));
                                    iVar2.i(4);
                                    iVar2.i(96);
                                    iVar2.c(54, c0757a.k("matchedCount"));
                                    iVar2.c(25, c0757a.k("lexer"));
                                    iVar2.a(180, str5, str9, str10);
                                    iVar2.d(4);
                                    fVar2 = fVar8;
                                    iVar2.b(159, fVar2);
                                    iVar2.e(fVar28);
                                    if (i17 == i11 - 1) {
                                        iVar2.c(25, c0757a.k("lexer"));
                                        iVar2.a(180, str5, str9, str10);
                                        iVar2.d(4);
                                        iVar2.b(160, fVar4);
                                    }
                                    str4 = str10;
                                    str2 = str9;
                                    str3 = str;
                                    iVar = iVar2;
                                    i12 = i11;
                                    fVar3 = fVar4;
                                } else {
                                    fVar2 = fVar8;
                                    str4 = str10;
                                    str2 = str9;
                                    i12 = i11;
                                    str3 = str;
                                    iVar = iVar2;
                                    i(c0757a, iVar2, fVar15, dVar3, cls3, clsS, i17);
                                    fVar3 = fVar15;
                                    if (i17 == i12 - 1) {
                                        f(c0757a, iVar, fVar3);
                                    }
                                }
                            } else {
                                str2 = str9;
                                str3 = str;
                                iVar = iVar2;
                                fVar2 = fVar8;
                                fVar3 = fVar15;
                                i12 = i11;
                                str4 = str10;
                                j(c0757a, iVar, fVar3, dVar3, cls3, i17);
                                if (i17 == i12 - 1) {
                                    f(c0757a, iVar, fVar3);
                                }
                            }
                        }
                        str = str11;
                        iVar2.c(25, c0757a.k("lexer"));
                        str5 = f70867d;
                        iVar2.a(180, str5, str9, str10);
                        k7.f fVar29 = new k7.f();
                        iVar2.b(158, fVar29);
                        u(iVar2, c0757a, i17);
                        iVar2.e(fVar29);
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.a(180, str5, str9, str10);
                        iVar2.i(89);
                        iVar2.c(54, c0757a.k(str9));
                        iVar2.d(-1);
                        fVar4 = fVar15;
                        iVar2.b(159, fVar4);
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.a(180, str5, str9, str10);
                        k7.f fVar210 = fVar;
                        iVar2.b(158, fVar210);
                        iVar2.c(21, c0757a.k("matchedCount"));
                        iVar2.i(4);
                        iVar2.i(96);
                        iVar2.c(54, c0757a.k("matchedCount"));
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.a(180, str5, str9, str10);
                        iVar2.d(4);
                        fVar2 = fVar8;
                        iVar2.b(159, fVar2);
                        iVar2.e(fVar210);
                        if (i17 == i11 - 1) {
                            iVar2.c(25, c0757a.k("lexer"));
                            iVar2.a(180, str5, str9, str10);
                            iVar2.d(4);
                            iVar2.b(160, fVar4);
                        }
                        str4 = str10;
                        str2 = str9;
                        str3 = str;
                        iVar = iVar2;
                        i12 = i11;
                        fVar3 = fVar4;
                    }
                    str = str11;
                    iVar2.c(25, c0757a.k("lexer"));
                    str5 = f70867d;
                    iVar2.a(180, str5, str9, str10);
                    k7.f fVar211 = new k7.f();
                    iVar2.b(158, fVar211);
                    u(iVar2, c0757a, i17);
                    iVar2.e(fVar211);
                    iVar2.c(25, c0757a.k("lexer"));
                    iVar2.a(180, str5, str9, str10);
                    iVar2.i(89);
                    iVar2.c(54, c0757a.k(str9));
                    iVar2.d(-1);
                    fVar4 = fVar15;
                    iVar2.b(159, fVar4);
                    iVar2.c(25, c0757a.k("lexer"));
                    iVar2.a(180, str5, str9, str10);
                    k7.f fVar212 = fVar;
                    iVar2.b(158, fVar212);
                    iVar2.c(21, c0757a.k("matchedCount"));
                    iVar2.i(4);
                    iVar2.i(96);
                    iVar2.c(54, c0757a.k("matchedCount"));
                    iVar2.c(25, c0757a.k("lexer"));
                    iVar2.a(180, str5, str9, str10);
                    iVar2.d(4);
                    fVar2 = fVar8;
                    iVar2.b(159, fVar2);
                    iVar2.e(fVar212);
                    if (i17 == i11 - 1) {
                        iVar2.c(25, c0757a.k("lexer"));
                        iVar2.a(180, str5, str9, str10);
                        iVar2.d(4);
                        iVar2.b(160, fVar4);
                    }
                    str4 = str10;
                    str2 = str9;
                    str3 = str;
                    iVar = iVar2;
                    i12 = i11;
                    fVar3 = fVar4;
                }
                i17++;
                fVar15 = fVar3;
                iVar2 = iVar;
                str10 = str4;
                str9 = str2;
                length = i12;
                str11 = str3;
                fVar8 = fVar2;
            }
            i11 = length;
            fVar = fVar18;
            str = str11;
            iVar2.c(25, c0757a.k("lexer"));
            str5 = f70867d;
            iVar2.a(180, str5, str9, str10);
            k7.f fVar213 = new k7.f();
            iVar2.b(158, fVar213);
            u(iVar2, c0757a, i17);
            iVar2.e(fVar213);
            iVar2.c(25, c0757a.k("lexer"));
            iVar2.a(180, str5, str9, str10);
            iVar2.i(89);
            iVar2.c(54, c0757a.k(str9));
            iVar2.d(-1);
            fVar4 = fVar15;
            iVar2.b(159, fVar4);
            iVar2.c(25, c0757a.k("lexer"));
            iVar2.a(180, str5, str9, str10);
            k7.f fVar214 = fVar;
            iVar2.b(158, fVar214);
            iVar2.c(21, c0757a.k("matchedCount"));
            iVar2.i(4);
            iVar2.i(96);
            iVar2.c(54, c0757a.k("matchedCount"));
            iVar2.c(25, c0757a.k("lexer"));
            iVar2.a(180, str5, str9, str10);
            iVar2.d(4);
            fVar2 = fVar8;
            iVar2.b(159, fVar2);
            iVar2.e(fVar214);
            if (i17 == i11 - 1) {
                iVar2.c(25, c0757a.k("lexer"));
                iVar2.a(180, str5, str9, str10);
                iVar2.d(4);
                iVar2.b(160, fVar4);
            }
            str4 = str10;
            str2 = str9;
            str3 = str;
            iVar = iVar2;
            i12 = i11;
            fVar3 = fVar4;
            i17++;
            fVar15 = fVar3;
            iVar2 = iVar;
            str10 = str4;
            str9 = str2;
            length = i12;
            str11 = str3;
            fVar8 = fVar2;
        }
        int i18 = length;
        k7.i iVar3 = iVar2;
        k7.f fVar30 = fVar15;
        String str18 = str11;
        iVar3.e(fVar8);
        if (!c0757a.f70872c.isInterface() && !Modifier.isAbstract(c0757a.f70872c.getModifiers())) {
            a(c0757a, iVar3);
        }
        iVar3.e(fVar17);
        t(c0757a, iVar3);
        iVar3.c(25, c0757a.k("instance"));
        Method method = c0757a.f70873d.f15582f;
        if (method != null) {
            iVar3.k(182, com.alibaba.fastjson.util.b.g(c0757a.i()), method.getName(), "()" + com.alibaba.fastjson.util.b.b(method.getReturnType()));
        }
        iVar3.i(176);
        iVar3.e(fVar30);
        a(c0757a, iVar3);
        iVar3.c(25, 0);
        iVar3.c(25, 1);
        iVar3.c(25, 2);
        iVar3.c(25, 3);
        iVar3.c(25, c0757a.k("instance"));
        iVar3.c(21, 4);
        int i19 = i18 / 32;
        if (i18 != 0 && i18 % 32 != 0) {
            i19++;
        }
        if (i19 == 1) {
            iVar3.i(4);
        } else {
            iVar3.h(16, i19);
        }
        iVar3.h(188, 10);
        for (int i21 = 0; i21 < i19; i21++) {
            iVar3.i(89);
            if (i21 == 0) {
                iVar3.i(3);
            } else if (i21 == 1) {
                iVar3.i(4);
            } else {
                iVar3.h(16, i21);
            }
            iVar3.c(21, c0757a.k("_asm_flag_" + i21));
            iVar3.i(79);
        }
        String strG2 = com.alibaba.fastjson.util.b.g(o.class);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str18);
        String str19 = f70866c;
        sb4.append(str19);
        sb4.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;");
        iVar3.k(182, strG2, "parseRest", sb4.toString());
        iVar3.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(c0757a.f70872c));
        iVar3.i(176);
        iVar3.e(fVar16);
        iVar3.c(25, 0);
        iVar3.c(25, 1);
        iVar3.c(25, 2);
        iVar3.c(25, 3);
        iVar3.c(21, 4);
        iVar3.k(183, com.alibaba.fastjson.util.b.g(o.class), "deserialze", str18 + str19 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
        iVar3.i(176);
        iVar3.j(10, c0757a.f70870a);
        iVar3.l();
    }

    public final void h(k7.c cVar, C0757a c0757a) {
        int i11;
        Class<o> cls;
        int i12;
        int i13;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(L");
        String str = f70866c;
        sb2.append(str);
        sb2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        k7.i iVar = new k7.i(cVar, 1, "deserialzeArrayMapping", sb2.toString(), null, null);
        w(c0757a, iVar);
        iVar.c(25, c0757a.k("lexer"));
        iVar.c(25, 1);
        iVar.k(182, str, "getSymbolTable", "()" + com.alibaba.fastjson.util.b.b(l7.i.class));
        iVar.k(182, f70867d, "scanTypeName", "(" + com.alibaba.fastjson.util.b.b(l7.i.class) + ")Ljava/lang/String;");
        iVar.c(58, c0757a.k("typeName"));
        k7.f fVar = new k7.f();
        iVar.c(25, c0757a.k("typeName"));
        iVar.b(198, fVar);
        iVar.c(25, 1);
        iVar.k(182, str, "getConfig", "()" + com.alibaba.fastjson.util.b.b(l7.h.class));
        iVar.c(25, 0);
        Class<o> cls2 = o.class;
        iVar.a(180, com.alibaba.fastjson.util.b.g(cls2), "beanInfo", com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.util.h.class));
        iVar.c(25, c0757a.k("typeName"));
        iVar.k(184, com.alibaba.fastjson.util.b.g(cls2), "getSeeAlso", "(" + com.alibaba.fastjson.util.b.b(l7.h.class) + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.util.h.class) + "Ljava/lang/String;)" + com.alibaba.fastjson.util.b.b(cls2));
        iVar.c(58, c0757a.k("userTypeDeser"));
        iVar.c(25, c0757a.k("userTypeDeser"));
        iVar.g(193, com.alibaba.fastjson.util.b.g(cls2));
        iVar.b(153, fVar);
        iVar.c(25, c0757a.k("userTypeDeser"));
        iVar.c(25, 1);
        iVar.c(25, 2);
        iVar.c(25, 3);
        iVar.c(25, 4);
        iVar.k(182, com.alibaba.fastjson.util.b.g(cls2), "deserialzeArrayMapping", "(L" + str + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        iVar.i(176);
        iVar.e(fVar);
        d(c0757a, iVar);
        com.alibaba.fastjson.util.d[] dVarArr = c0757a.f70873d.f15585i;
        int length = dVarArr.length;
        int i14 = 0;
        while (i14 < length) {
            boolean z11 = i14 == length + (-1);
            int i15 = z11 ? 93 : 44;
            com.alibaba.fastjson.util.d dVar = dVarArr[i14];
            Class<?> cls3 = dVar.f15536f;
            Type type = dVar.f15537g;
            int i16 = length;
            com.alibaba.fastjson.util.d[] dVarArr2 = dVarArr;
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                i11 = i14;
                cls = cls2;
                i16 = i16;
                iVar.c(25, c0757a.k("lexer"));
                iVar.c(16, i15);
                iVar.k(182, f70867d, "scanInt", "(C)I");
                iVar.c(54, c0757a.m(dVar));
            } else {
                boolean z12 = z11;
                int i17 = i14;
                if (cls3 == Byte.class) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    String str2 = f70867d;
                    iVar.k(182, str2, "scanInt", "(C)I");
                    iVar.k(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                    iVar.c(58, c0757a.m(dVar));
                    k7.f fVar2 = new k7.f();
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.a(180, str2, "matchStat", "I");
                    iVar.d(5);
                    iVar.b(160, fVar2);
                    iVar.i(1);
                    iVar.c(58, c0757a.m(dVar));
                    iVar.e(fVar2);
                } else if (cls3 == Short.class) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    String str3 = f70867d;
                    iVar.k(182, str3, "scanInt", "(C)I");
                    iVar.k(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                    iVar.c(58, c0757a.m(dVar));
                    k7.f fVar3 = new k7.f();
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.a(180, str3, "matchStat", "I");
                    iVar.d(5);
                    iVar.b(160, fVar3);
                    iVar.i(1);
                    iVar.c(58, c0757a.m(dVar));
                    iVar.e(fVar3);
                } else if (cls3 == Integer.class) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    String str4 = f70867d;
                    iVar.k(182, str4, "scanInt", "(C)I");
                    iVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    iVar.c(58, c0757a.m(dVar));
                    k7.f fVar4 = new k7.f();
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.a(180, str4, "matchStat", "I");
                    iVar.d(5);
                    iVar.b(160, fVar4);
                    iVar.i(1);
                    iVar.c(58, c0757a.m(dVar));
                    iVar.e(fVar4);
                } else if (cls3 == Long.TYPE) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    iVar.k(182, f70867d, "scanLong", "(C)J");
                    iVar.c(55, c0757a.n(dVar, 2));
                } else if (cls3 == Long.class) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    String str5 = f70867d;
                    iVar.k(182, str5, "scanLong", "(C)J");
                    iVar.k(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                    iVar.c(58, c0757a.m(dVar));
                    k7.f fVar5 = new k7.f();
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.a(180, str5, "matchStat", "I");
                    iVar.d(5);
                    iVar.b(160, fVar5);
                    iVar.i(1);
                    iVar.c(58, c0757a.m(dVar));
                    iVar.e(fVar5);
                } else if (cls3 == Boolean.TYPE) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    iVar.k(182, f70867d, "scanBoolean", "(C)Z");
                    iVar.c(54, c0757a.m(dVar));
                } else if (cls3 == Float.TYPE) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    iVar.k(182, f70867d, "scanFloat", "(C)F");
                    iVar.c(56, c0757a.m(dVar));
                } else if (cls3 == Float.class) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    String str6 = f70867d;
                    iVar.k(182, str6, "scanFloat", "(C)F");
                    iVar.k(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                    iVar.c(58, c0757a.m(dVar));
                    k7.f fVar6 = new k7.f();
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.a(180, str6, "matchStat", "I");
                    iVar.d(5);
                    iVar.b(160, fVar6);
                    iVar.i(1);
                    iVar.c(58, c0757a.m(dVar));
                    iVar.e(fVar6);
                } else if (cls3 == Double.TYPE) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    iVar.k(182, f70867d, "scanDouble", "(C)D");
                    iVar.c(57, c0757a.n(dVar, 2));
                } else if (cls3 == Double.class) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    String str7 = f70867d;
                    iVar.k(182, str7, "scanDouble", "(C)D");
                    iVar.k(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                    iVar.c(58, c0757a.m(dVar));
                    k7.f fVar7 = new k7.f();
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.a(180, str7, "matchStat", "I");
                    iVar.d(5);
                    iVar.b(160, fVar7);
                    iVar.i(1);
                    iVar.c(58, c0757a.m(dVar));
                    iVar.e(fVar7);
                } else if (cls3 == Character.TYPE) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    iVar.k(182, f70867d, "scanString", "(C)Ljava/lang/String;");
                    iVar.i(3);
                    iVar.k(182, "java/lang/String", "charAt", "(I)C");
                    iVar.c(54, c0757a.m(dVar));
                } else if (cls3 == String.class) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    iVar.k(182, f70867d, "scanString", "(C)Ljava/lang/String;");
                    iVar.c(58, c0757a.m(dVar));
                } else if (cls3 == BigDecimal.class) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    iVar.k(182, f70867d, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                    iVar.c(58, c0757a.m(dVar));
                } else if (cls3 == Date.class) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    iVar.k(182, f70867d, "scanDate", "(C)Ljava/util/Date;");
                    iVar.c(58, c0757a.m(dVar));
                } else if (cls3 == UUID.class) {
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    iVar.k(182, f70867d, "scanUUID", "(C)Ljava/util/UUID;");
                    iVar.c(58, c0757a.m(dVar));
                } else if (cls3.isEnum()) {
                    k7.f fVar8 = new k7.f();
                    k7.f fVar9 = new k7.f();
                    k7.f fVar10 = new k7.f();
                    k7.f fVar11 = new k7.f();
                    cls = cls2;
                    iVar.c(25, c0757a.k("lexer"));
                    String str8 = f70867d;
                    iVar.k(182, str8, "getCurrent", "()C");
                    iVar.i(89);
                    iVar.c(54, c0757a.k("ch"));
                    iVar.d(Integer.valueOf(Worker.WHAT_QUIT));
                    iVar.b(159, fVar11);
                    iVar.c(21, c0757a.k("ch"));
                    iVar.d(34);
                    iVar.b(160, fVar8);
                    iVar.e(fVar11);
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls3)));
                    iVar.c(25, 1);
                    iVar.k(182, f70866c, "getSymbolTable", "()" + com.alibaba.fastjson.util.b.b(l7.i.class));
                    iVar.c(16, i15);
                    iVar.k(182, str8, "scanEnum", "(Ljava/lang/Class;" + com.alibaba.fastjson.util.b.b(l7.i.class) + "C)Ljava/lang/Enum;");
                    iVar.b(167, fVar10);
                    iVar.e(fVar8);
                    iVar.c(21, c0757a.k("ch"));
                    iVar.d(48);
                    iVar.b(161, fVar9);
                    iVar.c(21, c0757a.k("ch"));
                    iVar.d(57);
                    iVar.b(163, fVar9);
                    l(c0757a, iVar, dVar);
                    iVar.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(h.class));
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    iVar.k(182, str8, "scanInt", "(C)I");
                    iVar.k(182, com.alibaba.fastjson.util.b.g(h.class), "valueOf", "(I)Ljava/lang/Enum;");
                    iVar.b(167, fVar10);
                    iVar.e(fVar9);
                    iVar.c(25, 0);
                    iVar.c(25, c0757a.k("lexer"));
                    iVar.c(16, i15);
                    iVar.k(182, com.alibaba.fastjson.util.b.g(cls), "scanEnum", "(L" + str8 + ";C)Ljava/lang/Enum;");
                    iVar.e(fVar10);
                    iVar.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls3));
                    iVar.c(58, c0757a.m(dVar));
                    i11 = i17;
                } else {
                    cls = cls2;
                    if (Collection.class.isAssignableFrom(cls3)) {
                        Class<?> clsS = TypeUtils.S(type);
                        if (clsS == String.class) {
                            if (cls3 == List.class || cls3 == Collections.class || cls3 == ArrayList.class) {
                                iVar.g(187, com.alibaba.fastjson.util.b.g(ArrayList.class));
                                iVar.i(89);
                                iVar.k(183, com.alibaba.fastjson.util.b.g(ArrayList.class), "<init>", "()V");
                            } else {
                                iVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls3)));
                                iVar.k(184, com.alibaba.fastjson.util.b.g(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                            }
                            iVar.c(58, c0757a.m(dVar));
                            iVar.c(25, c0757a.k("lexer"));
                            iVar.c(25, c0757a.m(dVar));
                            iVar.c(16, i15);
                            String str9 = f70867d;
                            iVar.k(182, str9, "scanStringArray", "(Ljava/util/Collection;C)V");
                            k7.f fVar12 = new k7.f();
                            iVar.c(25, c0757a.k("lexer"));
                            iVar.a(180, str9, "matchStat", "I");
                            iVar.d(5);
                            iVar.b(160, fVar12);
                            iVar.i(1);
                            iVar.c(58, c0757a.m(dVar));
                            iVar.e(fVar12);
                            i13 = i17;
                        } else {
                            k7.f fVar13 = new k7.f();
                            iVar.c(25, c0757a.k("lexer"));
                            String str10 = f70867d;
                            iVar.k(182, str10, "token", "()I");
                            iVar.c(54, c0757a.k("token"));
                            iVar.c(21, c0757a.k("token"));
                            int i18 = i17 == 0 ? 14 : 16;
                            iVar.d(Integer.valueOf(i18));
                            iVar.b(159, fVar13);
                            iVar.c(25, 1);
                            iVar.d(Integer.valueOf(i18));
                            String str11 = f70866c;
                            iVar.k(182, str11, "throwException", "(I)V");
                            iVar.e(fVar13);
                            k7.f fVar14 = new k7.f();
                            k7.f fVar15 = new k7.f();
                            iVar.c(25, c0757a.k("lexer"));
                            iVar.k(182, str10, "getCurrent", "()C");
                            iVar.c(16, 91);
                            iVar.b(160, fVar14);
                            iVar.c(25, c0757a.k("lexer"));
                            iVar.k(182, str10, "next", "()C");
                            iVar.i(87);
                            iVar.c(25, c0757a.k("lexer"));
                            iVar.d(14);
                            iVar.k(182, str10, "setToken", "(I)V");
                            iVar.b(167, fVar15);
                            iVar.e(fVar14);
                            iVar.c(25, c0757a.k("lexer"));
                            iVar.d(14);
                            iVar.k(182, str10, "nextToken", "(I)V");
                            iVar.e(fVar15);
                            i13 = i17;
                            p(iVar, cls3, i13, false);
                            iVar.i(89);
                            iVar.c(58, c0757a.m(dVar));
                            k(c0757a, iVar, dVar, clsS);
                            iVar.c(25, 1);
                            iVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(clsS)));
                            iVar.c(25, 3);
                            iVar.k(184, com.alibaba.fastjson.util.b.g(cls), "parseArray", "(Ljava/util/Collection;" + com.alibaba.fastjson.util.b.b(b2.class) + "L" + str11 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                        }
                        i11 = i13;
                    } else if (cls3.isArray()) {
                        iVar.c(25, c0757a.k("lexer"));
                        iVar.d(14);
                        iVar.k(182, f70867d, "nextToken", "(I)V");
                        iVar.c(25, 1);
                        iVar.c(25, 0);
                        iVar.d(Integer.valueOf(i17));
                        iVar.k(182, com.alibaba.fastjson.util.b.g(cls), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                        iVar.k(182, f70866c, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                        iVar.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls3));
                        iVar.c(58, c0757a.m(dVar));
                        i11 = i17;
                        i16 = i16;
                    } else {
                        k7.f fVar16 = new k7.f();
                        k7.f fVar17 = new k7.f();
                        if (cls3 == Date.class) {
                            iVar.c(25, c0757a.k("lexer"));
                            String str12 = f70867d;
                            iVar.k(182, str12, "getCurrent", "()C");
                            iVar.d(49);
                            iVar.b(160, fVar16);
                            iVar.g(187, com.alibaba.fastjson.util.b.g(Date.class));
                            iVar.i(89);
                            iVar.c(25, c0757a.k("lexer"));
                            i12 = 16;
                            iVar.c(16, i15);
                            iVar.k(182, str12, "scanLong", "(C)J");
                            iVar.k(183, com.alibaba.fastjson.util.b.g(Date.class), "<init>", "(J)V");
                            iVar.c(58, c0757a.m(dVar));
                            iVar.b(167, fVar17);
                        } else {
                            i12 = 16;
                        }
                        iVar.e(fVar16);
                        q(c0757a, iVar, 14);
                        i11 = i17;
                        i16 = i16;
                        e(c0757a, iVar, dVar, cls3, i11);
                        iVar.c(25, c0757a.k("lexer"));
                        iVar.k(182, f70867d, "token", "()I");
                        iVar.d(15);
                        iVar.b(159, fVar17);
                        iVar.c(25, 0);
                        iVar.c(25, c0757a.k("lexer"));
                        if (z12) {
                            iVar.d(15);
                        } else {
                            iVar.d(Integer.valueOf(i12));
                        }
                        iVar.k(183, com.alibaba.fastjson.util.b.g(cls), "check", "(" + com.alibaba.fastjson.util.b.b(l7.b.class) + "I)V");
                        iVar.e(fVar17);
                    }
                }
                cls = cls2;
                i11 = i17;
            }
            i14 = i11 + 1;
            length = i16;
            dVarArr = dVarArr2;
            cls2 = cls;
        }
        b(c0757a, iVar, false);
        k7.f fVar18 = new k7.f();
        k7.f fVar19 = new k7.f();
        k7.f fVar20 = new k7.f();
        k7.f fVar21 = new k7.f();
        iVar.c(25, c0757a.k("lexer"));
        String str13 = f70867d;
        iVar.k(182, str13, "getCurrent", "()C");
        iVar.i(89);
        iVar.c(54, c0757a.k("ch"));
        iVar.c(16, 44);
        iVar.b(160, fVar19);
        iVar.c(25, c0757a.k("lexer"));
        iVar.k(182, str13, "next", "()C");
        iVar.i(87);
        iVar.c(25, c0757a.k("lexer"));
        iVar.d(16);
        iVar.k(182, str13, "setToken", "(I)V");
        iVar.b(167, fVar21);
        iVar.e(fVar19);
        iVar.c(21, c0757a.k("ch"));
        iVar.c(16, 93);
        iVar.b(160, fVar20);
        iVar.c(25, c0757a.k("lexer"));
        iVar.k(182, str13, "next", "()C");
        iVar.i(87);
        iVar.c(25, c0757a.k("lexer"));
        iVar.d(15);
        iVar.k(182, str13, "setToken", "(I)V");
        iVar.b(167, fVar21);
        iVar.e(fVar20);
        iVar.c(21, c0757a.k("ch"));
        iVar.c(16, 26);
        iVar.b(160, fVar18);
        iVar.c(25, c0757a.k("lexer"));
        iVar.k(182, str13, "next", "()C");
        iVar.i(87);
        iVar.c(25, c0757a.k("lexer"));
        iVar.d(20);
        iVar.k(182, str13, "setToken", "(I)V");
        iVar.b(167, fVar21);
        iVar.e(fVar18);
        iVar.c(25, c0757a.k("lexer"));
        iVar.d(16);
        iVar.k(182, str13, "nextToken", "(I)V");
        iVar.e(fVar21);
        iVar.c(25, c0757a.k("instance"));
        iVar.i(176);
        iVar.j(5, c0757a.f70870a);
        iVar.l();
    }

    public final void i(C0757a c0757a, k7.h hVar, k7.f fVar, com.alibaba.fastjson.util.d dVar, Class<?> cls, Class<?> cls2, int i11) {
        String str;
        String str2;
        String str3;
        int i12;
        int i13;
        int i14;
        k7.f fVar2 = new k7.f();
        String str4 = f70867d;
        hVar.k(182, str4, "matchField", "([C)Z");
        hVar.b(153, fVar2);
        u(hVar, c0757a, i11);
        k7.f fVar3 = new k7.f();
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, str4, "token", "()I");
        hVar.d(8);
        hVar.b(160, fVar3);
        hVar.c(25, c0757a.k("lexer"));
        hVar.d(16);
        hVar.k(182, str4, "nextToken", "(I)V");
        hVar.b(167, fVar2);
        hVar.e(fVar3);
        k7.f fVar4 = new k7.f();
        k7.f fVar5 = new k7.f();
        k7.f fVar6 = new k7.f();
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, str4, "token", "()I");
        hVar.d(21);
        hVar.b(160, fVar5);
        hVar.c(25, c0757a.k("lexer"));
        hVar.d(14);
        hVar.k(182, str4, "nextToken", "(I)V");
        p(hVar, cls, i11, true);
        hVar.b(167, fVar4);
        hVar.e(fVar5);
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, str4, "token", "()I");
        hVar.d(14);
        hVar.b(159, fVar6);
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, str4, "token", "()I");
        hVar.d(12);
        hVar.b(160, fVar);
        p(hVar, cls, i11, false);
        hVar.c(58, c0757a.m(dVar));
        k(c0757a, hVar, dVar, cls2);
        hVar.c(25, 1);
        hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls2)));
        hVar.i(3);
        hVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String strG = com.alibaba.fastjson.util.b.g(b2.class);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(L");
        String str5 = f70866c;
        sb2.append(str5);
        sb2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.k(185, strG, "deserialze", sb2.toString());
        hVar.c(58, c0757a.k("list_item_value"));
        hVar.c(25, c0757a.m(dVar));
        hVar.c(25, c0757a.k("list_item_value"));
        if (cls.isInterface()) {
            hVar.k(185, com.alibaba.fastjson.util.b.g(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            hVar.k(182, com.alibaba.fastjson.util.b.g(cls), "add", "(Ljava/lang/Object;)Z");
        }
        hVar.i(87);
        hVar.b(167, fVar2);
        hVar.e(fVar6);
        p(hVar, cls, i11, false);
        hVar.e(fVar4);
        hVar.c(58, c0757a.m(dVar));
        boolean zW = l7.h.w(dVar.f15536f);
        k(c0757a, hVar, dVar, cls2);
        if (zW) {
            hVar.k(185, com.alibaba.fastjson.util.b.g(b2.class), "getFastMatchToken", "()I");
            hVar.c(54, c0757a.k("fastMatchToken"));
            hVar.c(25, c0757a.k("lexer"));
            hVar.c(21, c0757a.k("fastMatchToken"));
            str = str4;
            str2 = "nextToken";
            str3 = "(I)V";
            hVar.k(182, str, str2, str3);
        } else {
            str = str4;
            str2 = "nextToken";
            str3 = "(I)V";
            hVar.i(87);
            hVar.d(12);
            hVar.c(54, c0757a.k("fastMatchToken"));
            q(c0757a, hVar, 12);
        }
        hVar.c(25, 1);
        String str6 = str3;
        hVar.k(182, str5, "getContext", "()" + com.alibaba.fastjson.util.b.b(l7.g.class));
        hVar.c(58, c0757a.k("listContext"));
        hVar.c(25, 1);
        hVar.c(25, c0757a.m(dVar));
        hVar.d(dVar.f15532a);
        hVar.k(182, str5, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + com.alibaba.fastjson.util.b.b(l7.g.class));
        hVar.i(87);
        k7.f fVar7 = new k7.f();
        k7.f fVar8 = new k7.f();
        hVar.i(3);
        String str7 = str2;
        hVar.c(54, c0757a.k("i"));
        hVar.e(fVar7);
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, str, "token", "()I");
        hVar.d(15);
        hVar.b(159, fVar8);
        hVar.c(25, 0);
        hVar.a(180, c0757a.f70874e, dVar.f15532a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(b2.class));
        hVar.c(25, 1);
        hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls2)));
        hVar.c(21, c0757a.k("i"));
        hVar.k(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        hVar.k(185, com.alibaba.fastjson.util.b.g(b2.class), "deserialze", "(L" + str5 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.c(58, c0757a.k("list_item_value"));
        hVar.f(c0757a.k("i"), 1);
        hVar.c(25, c0757a.m(dVar));
        hVar.c(25, c0757a.k("list_item_value"));
        if (cls.isInterface()) {
            hVar.k(185, com.alibaba.fastjson.util.b.g(cls), "add", "(Ljava/lang/Object;)Z");
            i13 = 87;
            i12 = 182;
        } else {
            i12 = 182;
            hVar.k(182, com.alibaba.fastjson.util.b.g(cls), "add", "(Ljava/lang/Object;)Z");
            i13 = 87;
        }
        hVar.i(i13);
        hVar.c(25, 1);
        hVar.c(25, c0757a.m(dVar));
        hVar.k(i12, str5, "checkListResolve", "(Ljava/util/Collection;)V");
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(i12, str, "token", "()I");
        hVar.d(16);
        hVar.b(160, fVar7);
        if (zW) {
            hVar.c(25, c0757a.k("lexer"));
            hVar.c(21, c0757a.k("fastMatchToken"));
            hVar.k(i12, str, str7, str6);
            i14 = 167;
        } else {
            q(c0757a, hVar, 12);
            i14 = 167;
        }
        hVar.b(i14, fVar7);
        hVar.e(fVar8);
        hVar.c(25, 1);
        hVar.c(25, c0757a.k("listContext"));
        hVar.k(182, str5, "setContext", "(" + com.alibaba.fastjson.util.b.b(l7.g.class) + ")V");
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, str, "token", "()I");
        hVar.d(15);
        hVar.b(160, fVar);
        r(c0757a, hVar);
        hVar.e(fVar2);
    }

    public final void j(C0757a c0757a, k7.h hVar, k7.f fVar, com.alibaba.fastjson.util.d dVar, Class<?> cls, int i11) {
        k7.f fVar2 = new k7.f();
        k7.f fVar3 = new k7.f();
        hVar.c(25, c0757a.k("lexer"));
        hVar.c(25, 0);
        hVar.a(180, c0757a.f70874e, c0757a.h(dVar), "[C");
        hVar.k(182, f70867d, "matchField", "([C)Z");
        hVar.b(154, fVar2);
        hVar.i(1);
        hVar.c(58, c0757a.m(dVar));
        hVar.b(167, fVar3);
        hVar.e(fVar2);
        u(hVar, c0757a, i11);
        hVar.c(21, c0757a.k("matchedCount"));
        hVar.i(4);
        hVar.i(96);
        hVar.c(54, c0757a.k("matchedCount"));
        e(c0757a, hVar, dVar, cls, i11);
        hVar.c(25, 1);
        String str = f70866c;
        hVar.k(182, str, "getResolveStatus", "()I");
        hVar.d(1);
        hVar.b(160, fVar3);
        hVar.c(25, 1);
        hVar.k(182, str, "getLastResolveTask", "()" + com.alibaba.fastjson.util.b.b(l7.a.C0751a.class));
        hVar.c(58, c0757a.k("resolveTask"));
        hVar.c(25, c0757a.k("resolveTask"));
        hVar.c(25, 1);
        hVar.k(182, str, "getContext", "()" + com.alibaba.fastjson.util.b.b(l7.g.class));
        hVar.a(181, com.alibaba.fastjson.util.b.g(l7.a.C0751a.class), "ownerContext", com.alibaba.fastjson.util.b.b(l7.g.class));
        hVar.c(25, c0757a.k("resolveTask"));
        hVar.c(25, 0);
        hVar.d(dVar.f15532a);
        hVar.k(182, com.alibaba.fastjson.util.b.g(o.class), "getFieldDeserializer", "(Ljava/lang/String;)" + com.alibaba.fastjson.util.b.b(l.class));
        hVar.a(181, com.alibaba.fastjson.util.b.g(l7.a.C0751a.class), "fieldDeserializer", com.alibaba.fastjson.util.b.b(l.class));
        hVar.c(25, 1);
        hVar.d(0);
        hVar.k(182, str, "setResolveStatus", "(I)V");
        hVar.e(fVar3);
    }

    public final void k(C0757a c0757a, k7.h hVar, com.alibaba.fastjson.util.d dVar, Class<?> cls) {
        k7.f fVar = new k7.f();
        hVar.c(25, 0);
        hVar.a(180, c0757a.f70874e, dVar.f15532a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(b2.class));
        hVar.b(199, fVar);
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.k(182, f70866c, "getConfig", "()" + com.alibaba.fastjson.util.b.b(l7.h.class));
        hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(cls)));
        hVar.k(182, com.alibaba.fastjson.util.b.g(l7.h.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + com.alibaba.fastjson.util.b.b(b2.class));
        hVar.a(181, c0757a.f70874e, dVar.f15532a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(b2.class));
        hVar.e(fVar);
        hVar.c(25, 0);
        hVar.a(180, c0757a.f70874e, dVar.f15532a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(b2.class));
    }

    public final void l(C0757a c0757a, k7.h hVar, com.alibaba.fastjson.util.d dVar) {
        k7.f fVar = new k7.f();
        hVar.c(25, 0);
        hVar.a(180, c0757a.f70874e, c0757a.g(dVar), com.alibaba.fastjson.util.b.b(b2.class));
        hVar.b(199, fVar);
        hVar.c(25, 0);
        hVar.c(25, 1);
        hVar.k(182, f70866c, "getConfig", "()" + com.alibaba.fastjson.util.b.b(l7.h.class));
        hVar.d(k7.j.g(com.alibaba.fastjson.util.b.b(dVar.f15536f)));
        hVar.k(182, com.alibaba.fastjson.util.b.g(l7.h.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + com.alibaba.fastjson.util.b.b(b2.class));
        hVar.a(181, c0757a.f70874e, c0757a.g(dVar), com.alibaba.fastjson.util.b.b(b2.class));
        hVar.e(fVar);
        hVar.c(25, 0);
        hVar.a(180, c0757a.f70874e, c0757a.g(dVar), com.alibaba.fastjson.util.b.b(b2.class));
    }

    public final void m(k7.c cVar, C0757a c0757a) {
        int length = c0757a.f70875f.length;
        for (int i11 = 0; i11 < length; i11++) {
            new k7.d(cVar, 1, c0757a.h(c0757a.f70875f[i11]), "[C").c();
        }
        int length2 = c0757a.f70875f.length;
        for (int i12 = 0; i12 < length2; i12++) {
            com.alibaba.fastjson.util.d dVar = c0757a.f70875f[i12];
            Class<?> cls = dVar.f15536f;
            if (!cls.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls)) {
                    new k7.d(cVar, 1, dVar.f15532a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(b2.class)).c();
                } else {
                    new k7.d(cVar, 1, c0757a.g(dVar), com.alibaba.fastjson.util.b.b(b2.class)).c();
                }
            }
        }
        k7.i iVar = new k7.i(cVar, 1, "<init>", "(" + com.alibaba.fastjson.util.b.b(l7.h.class) + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.util.h.class) + ")V", null, null);
        iVar.c(25, 0);
        iVar.c(25, 1);
        iVar.c(25, 2);
        iVar.k(183, com.alibaba.fastjson.util.b.g(o.class), "<init>", "(" + com.alibaba.fastjson.util.b.b(l7.h.class) + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.util.h.class) + ")V");
        int length3 = c0757a.f70875f.length;
        for (int i13 = 0; i13 < length3; i13++) {
            com.alibaba.fastjson.util.d dVar2 = c0757a.f70875f[i13];
            iVar.c(25, 0);
            iVar.d("\"" + dVar2.f15532a + "\":");
            iVar.k(182, "java/lang/String", "toCharArray", "()[C");
            iVar.a(181, c0757a.f70874e, c0757a.h(dVar2), "[C");
        }
        iVar.i(177);
        iVar.j(4, 4);
        iVar.l();
    }

    public final void n(k7.h hVar, C0757a c0757a, int i11, k7.f fVar) {
        hVar.c(21, c0757a.k("_asm_flag_" + (i11 / 32)));
        hVar.d(Integer.valueOf(1 << i11));
        hVar.i(WebSocketProtocol.PAYLOAD_SHORT);
        hVar.b(153, fVar);
    }

    public final void o(C0757a c0757a, k7.h hVar, com.alibaba.fastjson.util.d dVar) {
        Class<?> cls = dVar.f15536f;
        Type type = dVar.f15537g;
        if (cls == Boolean.TYPE) {
            hVar.c(25, c0757a.k("instance"));
            hVar.c(21, c0757a.m(dVar));
            s(c0757a, hVar, dVar);
            return;
        }
        if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            hVar.c(25, c0757a.k("instance"));
            hVar.c(21, c0757a.m(dVar));
            s(c0757a, hVar, dVar);
            return;
        }
        if (cls == Long.TYPE) {
            hVar.c(25, c0757a.k("instance"));
            hVar.c(22, c0757a.n(dVar, 2));
            if (dVar.f15533b == null) {
                hVar.a(181, com.alibaba.fastjson.util.b.g(dVar.f15538h), dVar.f15534c.getName(), com.alibaba.fastjson.util.b.b(dVar.f15536f));
                return;
            }
            hVar.k(182, com.alibaba.fastjson.util.b.g(c0757a.i()), dVar.f15533b.getName(), com.alibaba.fastjson.util.b.c(dVar.f15533b));
            if (dVar.f15533b.getReturnType().equals(Void.TYPE)) {
                return;
            }
            hVar.i(87);
            return;
        }
        if (cls == Float.TYPE) {
            hVar.c(25, c0757a.k("instance"));
            hVar.c(23, c0757a.m(dVar));
            s(c0757a, hVar, dVar);
            return;
        }
        if (cls == Double.TYPE) {
            hVar.c(25, c0757a.k("instance"));
            hVar.c(24, c0757a.n(dVar, 2));
            s(c0757a, hVar, dVar);
            return;
        }
        if (cls == String.class) {
            hVar.c(25, c0757a.k("instance"));
            hVar.c(25, c0757a.m(dVar));
            s(c0757a, hVar, dVar);
            return;
        }
        if (cls.isEnum()) {
            hVar.c(25, c0757a.k("instance"));
            hVar.c(25, c0757a.m(dVar));
            s(c0757a, hVar, dVar);
        } else if (!Collection.class.isAssignableFrom(cls)) {
            hVar.c(25, c0757a.k("instance"));
            hVar.c(25, c0757a.m(dVar));
            s(c0757a, hVar, dVar);
        } else {
            hVar.c(25, c0757a.k("instance"));
            if (TypeUtils.S(type) == String.class) {
                hVar.c(25, c0757a.m(dVar));
                hVar.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls));
            } else {
                hVar.c(25, c0757a.m(dVar));
            }
            s(c0757a, hVar, dVar);
        }
    }

    public final void p(k7.h hVar, Class<?> cls, int i11, boolean z11) {
        if (cls.isAssignableFrom(ArrayList.class) && !z11) {
            hVar.g(187, "java/util/ArrayList");
            hVar.i(89);
            hVar.k(183, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z11) {
            hVar.g(187, com.alibaba.fastjson.util.b.g(LinkedList.class));
            hVar.i(89);
            hVar.k(183, com.alibaba.fastjson.util.b.g(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            hVar.g(187, com.alibaba.fastjson.util.b.g(HashSet.class));
            hVar.i(89);
            hVar.k(183, com.alibaba.fastjson.util.b.g(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            hVar.g(187, com.alibaba.fastjson.util.b.g(TreeSet.class));
            hVar.i(89);
            hVar.k(183, com.alibaba.fastjson.util.b.g(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            hVar.g(187, com.alibaba.fastjson.util.b.g(LinkedHashSet.class));
            hVar.i(89);
            hVar.k(183, com.alibaba.fastjson.util.b.g(LinkedHashSet.class), "<init>", "()V");
        } else if (z11) {
            hVar.g(187, com.alibaba.fastjson.util.b.g(HashSet.class));
            hVar.i(89);
            hVar.k(183, com.alibaba.fastjson.util.b.g(HashSet.class), "<init>", "()V");
        } else {
            hVar.c(25, 0);
            hVar.d(Integer.valueOf(i11));
            hVar.k(182, com.alibaba.fastjson.util.b.g(o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            hVar.k(184, com.alibaba.fastjson.util.b.g(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        hVar.g(PsExtractor.AUDIO_STREAM, com.alibaba.fastjson.util.b.g(cls));
    }

    public final void q(C0757a c0757a, k7.h hVar, int i11) {
        k7.f fVar = new k7.f();
        k7.f fVar2 = new k7.f();
        hVar.c(25, c0757a.k("lexer"));
        String str = f70867d;
        hVar.k(182, str, "getCurrent", "()C");
        if (i11 == 12) {
            hVar.c(16, 123);
        } else {
            if (i11 != 14) {
                throw new IllegalStateException();
            }
            hVar.c(16, 91);
        }
        hVar.b(160, fVar);
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, str, "next", "()C");
        hVar.i(87);
        hVar.c(25, c0757a.k("lexer"));
        hVar.d(Integer.valueOf(i11));
        hVar.k(182, str, "setToken", "(I)V");
        hVar.b(167, fVar2);
        hVar.e(fVar);
        hVar.c(25, c0757a.k("lexer"));
        hVar.d(Integer.valueOf(i11));
        hVar.k(182, str, "nextToken", "(I)V");
        hVar.e(fVar2);
    }

    public final void r(C0757a c0757a, k7.h hVar) {
        k7.f fVar = new k7.f();
        k7.f fVar2 = new k7.f();
        k7.f fVar3 = new k7.f();
        k7.f fVar4 = new k7.f();
        k7.f fVar5 = new k7.f();
        hVar.c(25, c0757a.k("lexer"));
        String str = f70867d;
        hVar.k(182, str, "getCurrent", "()C");
        hVar.i(89);
        hVar.c(54, c0757a.k("ch"));
        hVar.c(16, 44);
        hVar.b(160, fVar2);
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, str, "next", "()C");
        hVar.i(87);
        hVar.c(25, c0757a.k("lexer"));
        hVar.d(16);
        hVar.k(182, str, "setToken", "(I)V");
        hVar.b(167, fVar5);
        hVar.e(fVar2);
        hVar.c(21, c0757a.k("ch"));
        hVar.c(16, 125);
        hVar.b(160, fVar3);
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, str, "next", "()C");
        hVar.i(87);
        hVar.c(25, c0757a.k("lexer"));
        hVar.d(13);
        hVar.k(182, str, "setToken", "(I)V");
        hVar.b(167, fVar5);
        hVar.e(fVar3);
        hVar.c(21, c0757a.k("ch"));
        hVar.c(16, 93);
        hVar.b(160, fVar4);
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, str, "next", "()C");
        hVar.i(87);
        hVar.c(25, c0757a.k("lexer"));
        hVar.d(15);
        hVar.k(182, str, "setToken", "(I)V");
        hVar.b(167, fVar5);
        hVar.e(fVar4);
        hVar.c(21, c0757a.k("ch"));
        hVar.c(16, 26);
        hVar.b(160, fVar);
        hVar.c(25, c0757a.k("lexer"));
        hVar.d(20);
        hVar.k(182, str, "setToken", "(I)V");
        hVar.b(167, fVar5);
        hVar.e(fVar);
        hVar.c(25, c0757a.k("lexer"));
        hVar.k(182, str, "nextToken", "()V");
        hVar.e(fVar5);
    }

    public final void s(C0757a c0757a, k7.h hVar, com.alibaba.fastjson.util.d dVar) {
        Method method = dVar.f15533b;
        if (method == null) {
            hVar.a(181, com.alibaba.fastjson.util.b.g(dVar.f15538h), dVar.f15534c.getName(), com.alibaba.fastjson.util.b.b(dVar.f15536f));
            return;
        }
        hVar.k(method.getDeclaringClass().isInterface() ? 185 : 182, com.alibaba.fastjson.util.b.g(dVar.f15538h), method.getName(), com.alibaba.fastjson.util.b.c(method));
        if (dVar.f15533b.getReturnType().equals(Void.TYPE)) {
            return;
        }
        hVar.i(87);
    }

    public final void t(C0757a c0757a, k7.h hVar) {
        hVar.c(25, 1);
        hVar.c(25, c0757a.k("context"));
        hVar.k(182, f70866c, "setContext", "(" + com.alibaba.fastjson.util.b.b(l7.g.class) + ")V");
        k7.f fVar = new k7.f();
        hVar.c(25, c0757a.k("childContext"));
        hVar.b(198, fVar);
        hVar.c(25, c0757a.k("childContext"));
        hVar.c(25, c0757a.k("instance"));
        hVar.a(181, com.alibaba.fastjson.util.b.g(l7.g.class), "object", "Ljava/lang/Object;");
        hVar.e(fVar);
    }

    public final void u(k7.h hVar, C0757a c0757a, int i11) {
        String str = "_asm_flag_" + (i11 / 32);
        hVar.c(21, c0757a.k(str));
        hVar.d(Integer.valueOf(1 << i11));
        hVar.i(128);
        hVar.c(54, c0757a.k(str));
    }

    public b2 v(l7.h hVar, com.alibaba.fastjson.util.h hVar2) throws Exception {
        String str;
        Class<?> cls = hVar2.f15577a;
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("not support type :" + cls.getName());
        }
        String str2 = "FastjsonASMDeserializer_" + this.f70869b.incrementAndGet() + "_" + cls.getSimpleName();
        Package r11 = a.class.getPackage();
        if (r11 != null) {
            String name = r11.getName();
            String str3 = name.replace('.', '/') + "/" + str2;
            str = name + InstructionFileId.DOT + str2;
            str2 = str3;
        } else {
            str = str2;
        }
        k7.c cVar = new k7.c();
        cVar.k(49, 33, str2, com.alibaba.fastjson.util.b.g(o.class), null);
        m(cVar, new C0757a(str2, hVar, hVar2, 3));
        c(cVar, new C0757a(str2, hVar, hVar2, 3));
        g(cVar, new C0757a(str2, hVar, hVar2, 5));
        h(cVar, new C0757a(str2, hVar, hVar2, 4));
        byte[] bArrJ = cVar.j();
        return (b2) this.f70868a.a(str, bArrJ, 0, bArrJ.length).getConstructor(l7.h.class, com.alibaba.fastjson.util.h.class).newInstance(hVar, hVar2);
    }

    public final void w(C0757a c0757a, k7.h hVar) {
        hVar.c(25, 1);
        hVar.a(180, f70866c, "lexer", com.alibaba.fastjson.util.b.b(l7.b.class));
        hVar.g(PsExtractor.AUDIO_STREAM, f70867d);
        hVar.c(58, c0757a.k("lexer"));
    }
}
