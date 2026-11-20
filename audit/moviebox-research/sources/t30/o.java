package t30;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.EndOfStatement;
import org.mvel2.ast.Proto;
import org.mvel2.compiler.ExecutableStatement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class o {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static ThreadLocal<Queue<b>> f76828m = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f76829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ParserContext f76830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f76831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f76832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f76833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f76834f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f76835g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Class f76836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f76837i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f76838j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f76839k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f76840l;

    /* JADX INFO: compiled from: source.java */
    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f76841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Proto.c f76842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f76843c;

        public a(String str, Proto.c cVar, String str2) {
            this.f76841a = str;
            this.f76842b = cVar;
            this.f76843c = str2;
        }

        @Override // t30.o.b
        public boolean a(Proto proto) {
            if (!this.f76841a.equals(proto.getName())) {
                return false;
            }
            this.f76842b.f(Proto.ReceiverType.PROPERTY);
            this.f76842b.e((ExecutableStatement) m.G0(this.f76843c, o.this.f76830b));
            return true;
        }

        @Override // t30.o.b
        public String getName() {
            return this.f76841a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        boolean a(Proto proto);

        String getName();
    }

    public o(char[] cArr, int i11, int i12, String str, ParserContext parserContext, int i13, g gVar) {
        this.f76839k = false;
        this.f76829a = cArr;
        this.f76832d = i11;
        this.f76831c = i12;
        this.f76833e = str;
        this.f76830b = parserContext;
        this.f76839k = (i13 & 16) == 0;
        this.f76840l = gVar;
    }

    public static void c(char[] cArr, int i11, ParserContext parserContext) {
        if (g()) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) parserContext.getParserConfiguration().getImports();
            Object obj = linkedHashMap.values().toArray()[linkedHashMap.size() - 1];
            if (obj instanceof Proto) {
                Proto proto = (Proto) obj;
                int cursorEnd = proto.getCursorEnd();
                do {
                    i11--;
                    if (i11 <= cursorEnd) {
                        break;
                    }
                } while (m.q0(cArr[i11]));
                while (i11 > cursorEnd && m.c0(cArr[i11])) {
                    i11--;
                }
                while (i11 > cursorEnd && (m.q0(cArr[i11]) || cArr[i11] == ';')) {
                    i11--;
                }
                if (i11 == cursorEnd) {
                    return;
                }
                throw new CompileException("unresolved reference (possible illegal forward-reference?): " + f(), cArr, proto.getCursorStart());
            }
        }
    }

    public static String f() {
        if (f76828m.get() == null || f76828m.get().isEmpty()) {
            return null;
        }
        return f76828m.get().poll().getName();
    }

    public static boolean g() {
        return (f76828m.get() == null || f76828m.get().isEmpty()) ? false : true;
    }

    public static void h(Proto proto) {
        if (f76828m.get() != null) {
            Queue<b> queue = f76828m.get();
            HashSet hashSet = new HashSet();
            for (b bVar : queue) {
                if (bVar.a(proto)) {
                    hashSet.add(bVar);
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                queue.remove((b) it.next());
            }
        }
    }

    public final void b() {
        if (this.f76835g != null) {
            try {
                if (this.f76830b.hasProtoImport(this.f76834f)) {
                    this.f76836h = Proto.class;
                } else {
                    this.f76836h = m.D(null, this.f76834f, this.f76830b);
                }
                this.f76837i = this.f76835g;
            } catch (ClassNotFoundException e11) {
                if (!this.f76839k) {
                    throw new CompileException("could not resolve class: " + this.f76834f, this.f76829a, this.f76832d, e11);
                }
                this.f76836h = b.class;
                this.f76838j = this.f76834f;
                this.f76837i = this.f76835g;
            }
        } else {
            this.f76836h = Object.class;
            this.f76837i = this.f76834f;
        }
        this.f76834f = null;
        this.f76835g = null;
    }

    public final void d(String str, Proto.c cVar, String str2) {
        Queue<b> queue = f76828m.get();
        if (queue == null) {
            ThreadLocal<Queue<b>> threadLocal = f76828m;
            LinkedList linkedList = new LinkedList();
            threadLocal.set(linkedList);
            queue = linkedList;
        }
        queue.add(new a(str, cVar, str2));
    }

    public int e() {
        return this.f76832d;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0125  */
    public Proto i() {
        Proto proto = new Proto(this.f76833e, this.f76830b);
        while (true) {
            int i11 = this.f76832d;
            if (i11 >= this.f76831c) {
                int i12 = i11 + 1;
                this.f76832d = i12;
                if (this.f76840l != null && m.p0(this.f76829a, i12)) {
                    this.f76840l.a(new EndOfStatement(this.f76830b));
                }
                return proto;
            }
            int iE0 = m.E0(this.f76829a, i11);
            this.f76832d = iE0;
            if (this.f76835g == null) {
                while (true) {
                    int i13 = this.f76832d;
                    if (i13 >= this.f76831c || !m.c0(this.f76829a[i13])) {
                        break;
                    }
                    this.f76832d++;
                }
                int i14 = this.f76832d;
                if (i14 > iE0) {
                    String str = new String(this.f76829a, iE0, i14 - iE0);
                    this.f76834f = str;
                    if ("def".equals(str) || "function".equals(this.f76834f)) {
                        int i15 = this.f76832d + 1;
                        this.f76832d = i15;
                        int iE1 = m.E0(this.f76829a, i15);
                        this.f76832d = iE1;
                        while (true) {
                            int i16 = this.f76832d;
                            if (i16 >= this.f76831c || !m.c0(this.f76829a[i16])) {
                                break;
                            }
                            this.f76832d++;
                        }
                        int i17 = this.f76832d;
                        if (iE1 == i17) {
                            throw new CompileException("attempt to declare an anonymous function as a prototype member", this.f76829a, iE1);
                        }
                        h hVar = new h(new String(this.f76829a, iE1, i17 - iE1), this.f76832d, this.f76831c, this.f76829a, 0, this.f76830b, null);
                        proto.declareReceiver(hVar.b(), hVar.c());
                        this.f76832d = hVar.a() + 1;
                        this.f76834f = null;
                    }
                }
                this.f76832d = m.E0(this.f76829a, this.f76832d);
            }
            int i18 = this.f76832d;
            if (i18 > this.f76831c) {
                throw new CompileException("unexpected end of statement in proto declaration: " + this.f76833e, this.f76829a, iE0);
            }
            char[] cArr = this.f76829a;
            char c11 = cArr[i18];
            if (c11 == ';') {
                this.f76832d = i18 + 1;
                b();
                if (this.f76839k && this.f76836h == b.class) {
                    d(this.f76838j, proto.declareReceiver(this.f76837i, Proto.ReceiverType.DEFERRED, (ExecutableStatement) null), null);
                } else {
                    proto.declareReceiver(this.f76837i, this.f76836h, (ExecutableStatement) null);
                }
            } else if (c11 != '=') {
                while (true) {
                    int i19 = this.f76832d;
                    if (i19 >= this.f76831c || !m.c0(this.f76829a[i19])) {
                        break;
                    }
                    this.f76832d++;
                }
                int i21 = this.f76832d;
                if (i21 > i18) {
                    this.f76835g = new String(this.f76829a, i18, i21 - i18);
                }
            } else {
                int i22 = i18 + 1;
                this.f76832d = i22;
                int iE2 = m.E0(cArr, i22);
                this.f76832d = iE2;
                while (true) {
                    int i23 = this.f76832d;
                    int i24 = this.f76831c;
                    if (i23 >= i24) {
                        break;
                    }
                    char[] cArr2 = this.f76829a;
                    char c12 = cArr2[i23];
                    if (c12 != '\"') {
                        if (c12 == ';') {
                            break;
                        }
                        if (c12 == '[' || c12 == '{' || c12 == '\'' || c12 == '(') {
                            this.f76832d = m.e(cArr2, i23, i24, c12, this.f76830b);
                        }
                    } else {
                        this.f76832d = m.e(cArr2, i23, i24, c12, this.f76830b);
                    }
                    this.f76832d++;
                }
                b();
                char[] cArr3 = this.f76829a;
                int i25 = this.f76832d;
                this.f76832d = i25 + 1;
                String str2 = new String(cArr3, iE2, i25 - iE2);
                if (this.f76839k && this.f76836h == b.class) {
                    d(this.f76838j, proto.declareReceiver(this.f76837i, Proto.ReceiverType.DEFERRED, (ExecutableStatement) null), str2);
                } else {
                    proto.declareReceiver(this.f76837i, this.f76836h, (ExecutableStatement) m.G0(str2, this.f76830b));
                }
            }
        }
    }
}
