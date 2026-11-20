package t30;

import java.util.ArrayList;
import java.util.HashMap;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f76795h = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f76796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f76797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f76798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f76799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f76800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Class f76801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ParserContext f76802g;

    public c() {
    }

    public c(int i11) {
        this.f76800e = i11;
    }

    public int a() {
        return this.f76797b;
    }

    public final boolean b() {
        ParserContext parserContext = this.f76802g;
        return parserContext != null && parserContext.isStrongTyping();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:84:0x014d  */
    public final Object c(boolean z11) {
        HashMap map;
        ArrayList arrayList;
        int i11;
        Object objD;
        int iE0;
        int i12;
        int i13 = this.f76799d;
        int iE1 = this.f76798c;
        if (i13 - iE1 == 0) {
            return this.f76800e == 0 ? new ArrayList() : f76795h;
        }
        int i14 = this.f76800e;
        if (i14 == -1) {
            map = null;
            arrayList = null;
        } else if (i14 == 0 || i14 == 1) {
            arrayList = new ArrayList();
            map = null;
        } else if (i14 != 2) {
            map = null;
            arrayList = null;
        } else {
            map = new HashMap();
            arrayList = null;
        }
        HashMap map2 = map;
        Object obj = null;
        int i15 = -1;
        while (true) {
            int i16 = this.f76797b;
            int i17 = this.f76799d;
            if (i16 >= i17) {
                if (iE1 < i17 && m.q0(this.f76796a[iE1])) {
                    iE1 = m.E0(this.f76796a, iE1);
                }
                int i18 = this.f76799d;
                if (iE1 < i18) {
                    int i19 = this.f76797b;
                    if (i19 < i18 - 1) {
                        this.f76797b = i19 + 1;
                    }
                    if (this.f76800e == 2) {
                        map2.put(obj, m.x(this.f76796a, iE1, this.f76797b - iE1));
                    } else {
                        int i21 = this.f76797b;
                        if (i21 < i18) {
                            this.f76797b = i21 + 1;
                        }
                        arrayList.add(m.x(this.f76796a, iE1, this.f76797b - iE1));
                    }
                    if (z11) {
                        f(iE1, this.f76797b - iE1);
                    }
                }
                int i22 = this.f76800e;
                if (i22 != 1) {
                    return i22 != 2 ? arrayList : map2;
                }
                return arrayList.toArray();
            }
            char[] cArr = this.f76796a;
            char c11 = cArr[i16];
            if (c11 == '\"') {
                this.f76797b = m.d(cArr, i16, i17, c11);
            } else if (c11 == ',') {
                if (this.f76800e != 2) {
                    arrayList.add(new String(cArr, iE1, i16 - iE1).trim());
                } else {
                    map2.put(obj, m.x(cArr, iE1, i16 - iE1));
                }
                if (z11) {
                    f(iE1, this.f76797b - iE1);
                }
                iE1 = this.f76797b + 1;
            } else if (c11 == '.') {
                int i23 = i16 + 1;
                this.f76797b = i23;
                int iE2 = m.E0(cArr, i23);
                this.f76797b = iE2;
                if (iE2 != this.f76799d) {
                    char[] cArr2 = this.f76796a;
                    if (cArr2[iE2] == '{') {
                        this.f76797b = m.c(cArr2, iE2, '{');
                    }
                }
            } else if (c11 == ':') {
                if (this.f76800e != 2) {
                    map2 = new HashMap();
                    this.f76800e = 2;
                }
                String strX = m.x(this.f76796a, iE1, this.f76797b - iE1);
                if (z11) {
                    f(iE1, this.f76797b - iE1);
                }
                iE1 = this.f76797b + 1;
                obj = strX;
            } else if (c11 == '[') {
                if (i16 > this.f76798c || !m.c0(cArr[i16 - 1])) {
                    if (i15 == -1) {
                        i11 = 0;
                    } else {
                        i11 = i15;
                    }
                    c cVar = new c(i11);
                    char[] cArr3 = this.f76796a;
                    int i24 = this.f76797b;
                    int iD = m.d(cArr3, i24, this.f76799d, cArr3[i24]);
                    this.f76797b = iD;
                    objD = cVar.d(cArr3, i24 + 1, (iD - i24) - 1, z11, this.f76801f, this.f76802g);
                    if (this.f76800e == 2) {
                        map2.put(obj, objD);
                    } else {
                        arrayList.add(objD);
                        obj = objD;
                    }
                    char[] cArr4 = this.f76796a;
                    int i25 = this.f76797b + 1;
                    this.f76797b = i25;
                    iE0 = m.E0(cArr4, i25);
                    this.f76797b = iE0;
                    i12 = this.f76799d;
                    if (iE0 >= i12 && this.f76796a[iE0] == ',') {
                        iE0++;
                    } else if (iE0 < i12 && m.u0(this.f76796a[iE0]) == -1) {
                        throw new CompileException("unterminated collection element", this.f76796a, this.f76797b);
                    }
                    iE1 = iE0;
                    i15 = i11;
                }
            } else if (c11 == '{') {
                if (i15 == -1) {
                    i15 = 1;
                }
                if (i16 > this.f76798c) {
                    if (i15 == -1) {
                        i11 = 0;
                    } else {
                        i11 = i15;
                    }
                    c cVar2 = new c(i11);
                    char[] cArr5 = this.f76796a;
                    int i26 = this.f76797b;
                    int iD2 = m.d(cArr5, i26, this.f76799d, cArr5[i26]);
                    this.f76797b = iD2;
                    objD = cVar2.d(cArr5, i26 + 1, (iD2 - i26) - 1, z11, this.f76801f, this.f76802g);
                    if (this.f76800e == 2) {
                        map2.put(obj, objD);
                    } else {
                        arrayList.add(objD);
                        obj = objD;
                    }
                    char[] cArr6 = this.f76796a;
                    int i27 = this.f76797b + 1;
                    this.f76797b = i27;
                    iE0 = m.E0(cArr6, i27);
                    this.f76797b = iE0;
                    i12 = this.f76799d;
                    if (iE0 >= i12) {
                        if (iE0 < i12) {
                            throw new CompileException("unterminated collection element", this.f76796a, this.f76797b);
                        }
                    } else if (iE0 < i12) {
                        throw new CompileException("unterminated collection element", this.f76796a, this.f76797b);
                    }
                    iE1 = iE0;
                    i15 = i11;
                } else {
                    if (i15 == -1) {
                        i11 = 0;
                    } else {
                        i11 = i15;
                    }
                    c cVar3 = new c(i11);
                    char[] cArr7 = this.f76796a;
                    int i28 = this.f76797b;
                    int iD3 = m.d(cArr7, i28, this.f76799d, cArr7[i28]);
                    this.f76797b = iD3;
                    objD = cVar3.d(cArr7, i28 + 1, (iD3 - i28) - 1, z11, this.f76801f, this.f76802g);
                    if (this.f76800e == 2) {
                        map2.put(obj, objD);
                    } else {
                        arrayList.add(objD);
                        obj = objD;
                    }
                    char[] cArr8 = this.f76796a;
                    int i29 = this.f76797b + 1;
                    this.f76797b = i29;
                    iE0 = m.E0(cArr8, i29);
                    this.f76797b = iE0;
                    i12 = this.f76799d;
                    if (iE0 >= i12) {
                        if (iE0 < i12) {
                            throw new CompileException("unterminated collection element", this.f76796a, this.f76797b);
                        }
                    } else if (iE0 < i12) {
                        throw new CompileException("unterminated collection element", this.f76796a, this.f76797b);
                    }
                    iE1 = iE0;
                    i15 = i11;
                }
            } else if (c11 == '\'') {
                this.f76797b = m.d(cArr, i16, i17, c11);
            } else if (c11 == '(') {
                this.f76797b = m.d(cArr, i16, i17, '(');
            }
            this.f76797b++;
        }
    }

    public Object d(char[] cArr, int i11, int i12, boolean z11, Class cls, ParserContext parserContext) {
        if (cls != null) {
            this.f76801f = m.I(cls);
        }
        this.f76796a = cArr;
        this.f76799d = i12 + i11;
        while (i11 < this.f76799d && m.q0(cArr[i11])) {
            i11++;
        }
        this.f76797b = i11;
        this.f76798c = i11;
        this.f76802g = parserContext;
        return c(z11);
    }

    public Object e(char[] cArr, int i11, int i12, boolean z11, ParserContext parserContext) {
        this.f76796a = cArr;
        this.f76802g = parserContext;
        this.f76799d = i12 + i11;
        while (i11 < this.f76799d && m.q0(cArr[i11])) {
            i11++;
        }
        this.f76797b = i11;
        this.f76798c = i11;
        return c(z11);
    }

    public final void f(int i11, int i12) {
        if (this.f76801f == null) {
            m.I0(this.f76796a, i11, i12, this.f76802g);
            return;
        }
        Class knownEgressType = ((ExecutableStatement) m.I0(this.f76796a, i11, i12, this.f76802g)).getKnownEgressType();
        if (knownEgressType == null || p.f(this.f76801f, knownEgressType)) {
            return;
        }
        if (b() || !org.mvel2.b.a(knownEgressType, this.f76801f)) {
            throw new CompileException("expected type: " + this.f76801f.getName() + "; but found: " + knownEgressType.getName(), this.f76796a, this.f76797b);
        }
    }
}
