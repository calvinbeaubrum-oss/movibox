package org.mvel2.ast;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.gslb.Worker;
import com.transsion.push.bean.MsgStyle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolver;
import org.mvel2.integration.VariableResolverFactory;
import t30.g;
import t30.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Stacklang extends BlockNode {
    static final Map<String, Integer> opcodes;
    List<b> instructionList;
    ParserContext pCtx;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f73288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f73289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f73290c;

        public b() {
        }
    }

    static {
        HashMap map = new HashMap();
        opcodes = map;
        map.put(MsgStyle.SOURCE_PUSH, 102);
        map.put("pop", Integer.valueOf(Worker.WHAT_SYNC_DATA));
        map.put("load", 104);
        map.put("ldtype", 105);
        map.put("invoke", 106);
        map.put(PlaceTypes.STORE, 109);
        map.put("getfield", 107);
        map.put("storefield", 108);
        map.put("dup", Integer.valueOf(Worker.WHAT_QUIT));
        map.put("jump", 112);
        map.put("jumpif", 113);
        map.put("label", 111);
        map.put("eq", 18);
        map.put("ne", 19);
        map.put("reduce", 114);
        map.put("xswap", 116);
        map.put("swap", 115);
    }

    public Stacklang(char[] cArr, int i11, int i12, int i13, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.blockStart = i11;
        this.blockOffset = i12;
        this.fields = i13 | 4194304;
        String[] strArrSplit = new String(cArr, i11, i12).split(";");
        this.instructionList = new ArrayList(strArrSplit.length);
        for (String str : strArrSplit) {
            this.instructionList.add(parseInstruction(str.trim()));
        }
        this.pCtx = parserContext;
    }

    private static b parseInstruction(String str) {
        int iIndexOf = str.indexOf(32);
        b bVar = new b();
        String strSubstring = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
        Map<String, Integer> map = opcodes;
        if (map.containsKey(strSubstring)) {
            bVar.f73288a = map.get(strSubstring).intValue();
        }
        if (strSubstring != str) {
            bVar.f73289b = str.substring(iIndexOf + 1);
        }
        return bVar;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Field field;
        Method methodL;
        Constructor constructorN;
        g gVar = (g) obj;
        int size = this.instructionList.size();
        int iIntValue = 0;
        while (iIntValue < size) {
            b bVar = this.instructionList.get(iIntValue);
            System.out.println(gVar.toString() + " >> " + bVar.f73288a + ":" + bVar.f73289b);
            int i11 = bVar.f73288a;
            if (i11 == 18) {
                gVar.q(Boolean.valueOf(gVar.n().equals(gVar.n())));
            } else if (i11 != 19) {
                switch (i11) {
                    case 102:
                        if (bVar.f73290c == null) {
                            bVar.f73290c = org.mvel2.d.l(bVar.f73289b, obj, variableResolverFactory);
                        }
                        gVar.q(bVar.f73290c);
                        break;
                    case Worker.WHAT_SYNC_DATA /* 103 */:
                        gVar.n();
                        break;
                    case 104:
                        if (bVar.f73290c == null) {
                            bVar.f73290c = variableResolverFactory.getVariableResolver(bVar.f73289b);
                        }
                        gVar.q(((VariableResolver) bVar.f73290c).getValue());
                        break;
                    case 105:
                        try {
                            if (bVar.f73290c == null) {
                                bVar.f73290c = m.v(bVar.f73289b, this.pCtx);
                            }
                            gVar.q(bVar.f73290c);
                        } catch (ClassNotFoundException e11) {
                            throw new CompileException("error", this.expr, this.blockStart, e11);
                        }
                        break;
                    case 106:
                        g gVar2 = new g();
                        while (!gVar.g() && !(gVar.k() instanceof Class)) {
                            gVar2.q(gVar.n());
                        }
                        if (gVar.g()) {
                            throw new CompileException("invoke without class", this.expr, this.blockStart);
                        }
                        Object[] objArr = new Object[gVar2.t()];
                        int i12 = 0;
                        while (!gVar2.g()) {
                            objArr[i12] = gVar2.n();
                            i12++;
                        }
                        if ("<init>".equals(bVar.f73289b)) {
                            Object obj3 = bVar.f73290c;
                            if (obj3 == null) {
                                constructorN = m.N(objArr, (Class) gVar.n(), false);
                                bVar.f73290c = constructorN;
                            } else {
                                constructorN = (Constructor) obj3;
                            }
                            try {
                                gVar.q(constructorN.newInstance(objArr));
                            } catch (Exception e12) {
                                throw new CompileException("instantiation error", this.expr, this.blockStart, e12);
                            }
                        } else {
                            if (bVar.f73290c == null) {
                                Class cls = (Class) gVar.n();
                                methodL = m.L(objArr, bVar.f73289b, cls, cls.getDeclaredMethods(), false);
                                bVar.f73290c = methodL;
                            } else {
                                gVar.e();
                                methodL = (Method) bVar.f73290c;
                            }
                            try {
                                gVar.q(methodL.invoke(gVar.g() ? null : gVar.n(), objArr));
                            } catch (Exception e13) {
                                throw new CompileException("invokation error", this.expr, this.blockStart, e13);
                            }
                        }
                        break;
                        break;
                    case 107:
                        try {
                            if (gVar.g() || !(gVar.k() instanceof Class)) {
                                throw new CompileException("getfield without class", this.expr, this.blockStart);
                            }
                            if (bVar.f73290c == null) {
                                field = ((Class) gVar.n()).getField(bVar.f73289b);
                                bVar.f73290c = field;
                            } else {
                                gVar.e();
                                field = (Field) bVar.f73290c;
                            }
                            gVar.q(field.get(gVar.n()));
                        } catch (Exception e14) {
                            throw new CompileException("field access error", this.expr, this.blockStart, e14);
                        }
                        break;
                    case 108:
                        try {
                            if (gVar.g() || !(gVar.k() instanceof Class)) {
                                throw new CompileException("storefield without class", this.expr, this.blockStart);
                            }
                            Class cls2 = (Class) gVar.n();
                            Object objN = gVar.n();
                            cls2.getField(bVar.f73289b).set(gVar.n(), objN);
                            gVar.q(objN);
                        } catch (Exception e15) {
                            throw new CompileException("field access error", this.expr, this.blockStart, e15);
                        }
                        break;
                    case 109:
                        Object obj4 = bVar.f73290c;
                        if (obj4 == null) {
                            bVar.f73290c = variableResolverFactory.createVariable(bVar.f73289b, gVar.k());
                        } else {
                            ((VariableResolver) obj4).setValue(gVar.k());
                        }
                        break;
                    case Worker.WHAT_QUIT /* 110 */:
                        gVar.f();
                        break;
                    default:
                        switch (i11) {
                            case 112:
                                break;
                            case 113:
                                if (!gVar.p().booleanValue()) {
                                }
                                break;
                            case 114:
                                gVar.i();
                                continue;
                            case 115:
                                Object objN2 = gVar.n();
                                Object objN3 = gVar.n();
                                gVar.q(objN2);
                                gVar.q(objN3);
                                continue;
                            case 116:
                                gVar.v();
                                continue;
                            default:
                                continue;
                        }
                        Object obj5 = bVar.f73290c;
                        if (obj5 != null) {
                            iIntValue = ((Integer) obj5).intValue();
                        } else {
                            for (int i13 = 0; i13 < this.instructionList.size(); i13++) {
                                b bVar2 = this.instructionList.get(i13);
                                if (bVar2.f73288a == 111 && bVar.f73289b.equals(bVar2.f73289b)) {
                                    bVar.f73290c = Integer.valueOf(i13);
                                    iIntValue = i13;
                                }
                            }
                        }
                        break;
                }
            } else {
                gVar.q(Boolean.valueOf(!gVar.n().equals(gVar.n())));
            }
            iIntValue++;
        }
        return gVar.n();
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        g gVar = new g();
        gVar.q(getReducedValue(gVar, obj2, variableResolverFactory));
        if (gVar.h()) {
            while (true) {
                gVar.i();
                if (!gVar.h()) {
                    break;
                }
                gVar.u();
            }
        }
        return gVar.k();
    }
}
