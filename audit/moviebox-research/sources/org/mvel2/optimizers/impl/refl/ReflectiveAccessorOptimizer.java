package org.mvel2.optimizers.impl.refl;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mvel2.CompileException;
import org.mvel2.OptimizationFailure;
import org.mvel2.ParserContext;
import org.mvel2.PropertyAccessException;
import org.mvel2.ast.TypeDescriptor;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.compiler.ExecutableLiteral;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.compiler.PropertyVerifier;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.AbstractOptimizer;
import org.mvel2.optimizers.a;
import org.mvel2.optimizers.impl.refl.nodes.ArrayAccessor;
import org.mvel2.optimizers.impl.refl.nodes.ArrayAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.ArrayLength;
import org.mvel2.optimizers.impl.refl.nodes.ConstructorAccessor;
import org.mvel2.optimizers.impl.refl.nodes.DynamicFieldAccessor;
import org.mvel2.optimizers.impl.refl.nodes.DynamicFunctionAccessor;
import org.mvel2.optimizers.impl.refl.nodes.FieldAccessor;
import org.mvel2.optimizers.impl.refl.nodes.FieldAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.FunctionAccessor;
import org.mvel2.optimizers.impl.refl.nodes.GetterAccessor;
import org.mvel2.optimizers.impl.refl.nodes.GetterAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.IndexedCharSeqAccessor;
import org.mvel2.optimizers.impl.refl.nodes.IndexedCharSeqAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.IndexedVariableAccessor;
import org.mvel2.optimizers.impl.refl.nodes.ListAccessor;
import org.mvel2.optimizers.impl.refl.nodes.ListAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.MapAccessor;
import org.mvel2.optimizers.impl.refl.nodes.MapAccessorNest;
import org.mvel2.optimizers.impl.refl.nodes.MethodAccessor;
import org.mvel2.optimizers.impl.refl.nodes.MethodAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.Notify;
import org.mvel2.optimizers.impl.refl.nodes.NullSafe;
import org.mvel2.optimizers.impl.refl.nodes.PropertyHandlerAccessor;
import org.mvel2.optimizers.impl.refl.nodes.SetterAccessor;
import org.mvel2.optimizers.impl.refl.nodes.StaticReferenceAccessor;
import org.mvel2.optimizers.impl.refl.nodes.StaticVarAccessor;
import org.mvel2.optimizers.impl.refl.nodes.StaticVarAccessorNH;
import org.mvel2.optimizers.impl.refl.nodes.ThisValueAccessor;
import org.mvel2.optimizers.impl.refl.nodes.VariableAccessor;
import org.mvel2.optimizers.impl.refl.nodes.WithAccessor;
import org.mvel2.util.MethodStub;
import p30.b;
import p30.c;
import p30.d;
import t30.e;
import t30.f;
import t30.l;
import t30.m;
import t30.n;
import t30.p;
import t30.s;
import t30.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ReflectiveAccessorOptimizer extends AbstractOptimizer implements a {
    private static final int DONE = -1;
    private Object ctx;
    private AccessorNode currNode;
    private boolean first;
    private Class ingressType;
    private Class returnType;
    private AccessorNode rootNode;
    private Object thisRef;
    private Object val;
    private VariableResolverFactory variableFactory;
    private static final Logger LOG = Logger.getLogger(ReflectiveAccessorOptimizer.class.getName());
    private static final Object[] EMPTYARG = new Object[0];
    private static final Class[] EMPTYCLS = new Class[0];

    public ReflectiveAccessorOptimizer() {
        this.first = true;
    }

    private ReflectiveAccessorOptimizer(ParserContext parserContext, char[] cArr, int i11, int i12, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        super(parserContext);
        this.first = true;
        this.expr = cArr;
        this.start = i11;
        i12 = cArr == null ? i11 : i12;
        this.length = i12;
        this.end = i11 + i12;
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
        this.thisRef = obj2;
    }

    private org.mvel2.compiler.a _getAccessor(Object obj, Class cls) {
        int i11;
        int i12 = 0;
        if (obj instanceof List) {
            List list = (List) obj;
            org.mvel2.compiler.a[] aVarArr = new org.mvel2.compiler.a[list.size()];
            Iterator it = list.iterator();
            while (it.hasNext()) {
                aVarArr[i12] = _getAccessor(it.next(), cls);
                i12++;
            }
            this.returnType = List.class;
            return new c(aVarArr);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            int size = map.size();
            org.mvel2.compiler.a[] aVarArr2 = new org.mvel2.compiler.a[size];
            org.mvel2.compiler.a[] aVarArr3 = new org.mvel2.compiler.a[size];
            for (Object obj2 : map.keySet()) {
                aVarArr2[i12] = _getAccessor(obj2, cls);
                aVarArr3[i12] = _getAccessor(map.get(obj2), cls);
                i12++;
            }
            this.returnType = Map.class;
            return new d(aVarArr2, aVarArr3);
        }
        if (!(obj instanceof Object[])) {
            if (this.returnType == null) {
                this.returnType = Object.class;
            }
            return cls.isArray() ? new b((String) obj, cls, this.ctx, this.variableFactory, this.pCtx) : new b((String) obj, Object.class, this.ctx, this.variableFactory, this.pCtx);
        }
        org.mvel2.compiler.a[] aVarArr4 = new org.mvel2.compiler.a[((Object[]) obj).length];
        if (cls != null) {
            i11 = 0;
            while (cls.getName().charAt(i11) == '[') {
                i11++;
            }
        } else {
            cls = Object[].class;
            i11 = 1;
        }
        try {
            Class clsI = m.I(cls);
            Class clsD = i11 > 1 ? m.D(null, m.A0('[', i11 - 1) + "L" + clsI.getName() + ";", this.pCtx) : cls;
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            int i13 = 0;
            while (i12 < length) {
                Object obj3 = objArr[i12];
                ParserContext parserContext = this.pCtx;
                org.mvel2.compiler.a aVar_getAccessor = _getAccessor(obj3, clsD);
                aVarArr4[i13] = aVar_getAccessor;
                e.c(parserContext, aVar_getAccessor, clsI, true);
                i12++;
                i13++;
            }
            return new p30.a(aVarArr4, m.T(cls));
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("this error should never throw:" + m.I(cls).getName(), e11);
        }
    }

    private void addAccessorNode(AccessorNode accessorNode) {
        if (this.rootNode != null) {
            this.currNode = this.currNode.setNextNode(accessorNode);
        } else {
            this.currNode = accessorNode;
            this.rootNode = accessorNode;
        }
    }

    private AccessorNode compileConstructor(char[] cArr, Object obj, VariableResolverFactory variableResolverFactory) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        String[] strArrG = m.g(cArr, this.start, this.length);
        int i11 = 0;
        List<char[]> listW0 = m.w0(strArrG[0].toCharArray());
        if (listW0 == null) {
            ParserContext parserContext = this.pCtx;
            Constructor<?> constructor = Class.forName(new String(cArr), true, parserContext != null ? parserContext.getClassLoader() : Thread.currentThread().getContextClassLoader()).getConstructor(EMPTYCLS);
            ConstructorAccessor constructorAccessor = new ConstructorAccessor(constructor, null);
            if (strArrG.length <= 1) {
                return constructorAccessor;
            }
            ReflectiveAccessorOptimizer reflectiveAccessorOptimizer = new ReflectiveAccessorOptimizer(this.pCtx, strArrG[1].toCharArray(), 0, strArrG[1].length(), constructor.newInstance(null), obj, variableResolverFactory);
            reflectiveAccessorOptimizer.setRootNode(constructorAccessor);
            reflectiveAccessorOptimizer.compileGetChain();
            AccessorNode rootNode = reflectiveAccessorOptimizer.getRootNode();
            this.val = reflectiveAccessorOptimizer.getResultOptPass();
            return rootNode;
        }
        Class clsD = m.D(variableResolverFactory, new String(m.K0(cArr, 0, t30.b.a('(', this.start, this.length, cArr))), this.pCtx);
        ExecutableStatement[] executableStatementArr = new ExecutableStatement[listW0.size()];
        for (int i12 = 0; i12 < listW0.size(); i12++) {
            executableStatementArr[i12] = (ExecutableStatement) m.J0(listW0.get(i12), this.pCtx);
        }
        int size = listW0.size();
        Object[] objArr = new Object[size];
        for (int i13 = 0; i13 < listW0.size(); i13++) {
            objArr[i13] = executableStatementArr[i13].getValue(obj, variableResolverFactory);
        }
        Constructor constructorN = m.N(objArr, clsD, this.pCtx.isStrongTyping());
        if (constructorN == null) {
            StringBuilder sb2 = new StringBuilder();
            while (i11 < size) {
                sb2.append(objArr[i11].getClass().getName());
                i11++;
                if (i11 < size) {
                    sb2.append(", ");
                }
            }
            throw new CompileException("unable to find constructor: " + clsD.getName() + "(" + sb2.toString() + ")", this.expr, this.start);
        }
        while (i11 < size) {
            objArr[i11] = org.mvel2.b.b(objArr[i11], t.b(constructorN.getParameterTypes(), i11, constructorN.isVarArgs()));
            i11++;
        }
        Object[] objArrA = t.a(constructorN.getParameterTypes(), objArr, constructorN.isVarArgs());
        ConstructorAccessor constructorAccessor2 = new ConstructorAccessor(constructorN, executableStatementArr);
        if (strArrG.length <= 1) {
            return constructorAccessor2;
        }
        ReflectiveAccessorOptimizer reflectiveAccessorOptimizer2 = new ReflectiveAccessorOptimizer(this.pCtx, strArrG[1].toCharArray(), 0, strArrG[1].length(), constructorN.newInstance(objArrA), obj, variableResolverFactory);
        reflectiveAccessorOptimizer2.ingressType = constructorN.getDeclaringClass();
        reflectiveAccessorOptimizer2.setRootNode(constructorAccessor2);
        reflectiveAccessorOptimizer2.compileGetChain();
        AccessorNode rootNode2 = reflectiveAccessorOptimizer2.getRootNode();
        this.val = reflectiveAccessorOptimizer2.getResultOptPass();
        return rootNode2;
    }

    private org.mvel2.compiler.a compileGetChain() {
        Object beanPropertyAO = this.ctx;
        this.cursor = this.start;
        try {
            if (org.mvel2.d.f73308h) {
                while (this.cursor < this.end) {
                    int iNextSubToken = nextSubToken();
                    if (iNextSubToken == 0) {
                        beanPropertyAO = getBeanPropertyAO(beanPropertyAO, capture());
                    } else if (iNextSubToken == 1) {
                        beanPropertyAO = getMethod(beanPropertyAO, capture());
                    } else if (iNextSubToken == 2) {
                        beanPropertyAO = getCollectionPropertyAO(beanPropertyAO, capture());
                    } else if (iNextSubToken == 3) {
                        beanPropertyAO = getWithProperty(beanPropertyAO);
                    }
                    this.first = false;
                    if (beanPropertyAO != null) {
                        this.returnType = beanPropertyAO.getClass();
                    }
                    int i11 = this.cursor;
                    if (i11 < this.end) {
                        if (this.nullSafe) {
                            char[] cArr = this.expr;
                            int i12 = cArr[i11] == '.' ? 1 : 0;
                            addAccessorNode(new NullSafe(cArr, i11 + i12, (this.length - i11) - i12, this.pCtx));
                            if (beanPropertyAO == null) {
                                break;
                            }
                        }
                        if (beanPropertyAO == null) {
                            throw new NullPointerException();
                        }
                    }
                    this.staticAccess = false;
                }
            } else {
                while (this.cursor < this.end) {
                    int iNextSubToken2 = nextSubToken();
                    if (iNextSubToken2 == 0) {
                        beanPropertyAO = getBeanProperty(beanPropertyAO, capture());
                    } else if (iNextSubToken2 == 1) {
                        beanPropertyAO = getMethod(beanPropertyAO, capture());
                    } else if (iNextSubToken2 == 2) {
                        beanPropertyAO = getCollectionProperty(beanPropertyAO, capture());
                    } else if (iNextSubToken2 == 3) {
                        beanPropertyAO = getWithProperty(beanPropertyAO);
                    }
                    this.first = false;
                    if (beanPropertyAO != null) {
                        this.returnType = beanPropertyAO.getClass();
                    }
                    int i13 = this.cursor;
                    int i14 = this.end;
                    if (i13 < i14) {
                        if (this.nullSafe) {
                            char[] cArr2 = this.expr;
                            int i15 = cArr2[i13] == '.' ? 1 : 0;
                            addAccessorNode(new NullSafe(cArr2, i13 + i15, (i14 - i13) - i15, this.pCtx));
                            if (beanPropertyAO == null) {
                                break;
                            }
                        }
                        if (beanPropertyAO == null) {
                            throw new NullPointerException();
                        }
                    }
                    this.staticAccess = false;
                }
            }
            this.val = beanPropertyAO;
            return this.rootNode;
        } catch (IllegalAccessException e11) {
            throw new PropertyAccessException(new String(this.expr, this.start, this.length) + ": " + e11.getMessage(), this.expr, this.f73300st, e11, this.pCtx);
        } catch (IndexOutOfBoundsException e12) {
            throw new PropertyAccessException(new String(this.expr, this.start, this.length) + ": array index out of bounds.", this.expr, this.f73300st, e12, this.pCtx);
        } catch (NullPointerException e13) {
            throw new PropertyAccessException("null pointer: " + new String(this.expr, this.start, this.length), this.expr, this.f73300st, e13, this.pCtx);
        } catch (InvocationTargetException e14) {
            if (org.mvel2.d.f73306f) {
                if (e14.getTargetException() instanceof RuntimeException) {
                    throw ((RuntimeException) e14.getTargetException());
                }
                throw new RuntimeException(e14);
            }
            throw new PropertyAccessException(new String(this.expr, this.start, this.length) + ": " + e14.getTargetException().getMessage(), this.expr, this.f73300st, e14, this.pCtx);
        } catch (CompileException e15) {
            throw e15;
        } catch (Exception e16) {
            LOG.log(Level.WARNING, "", (Throwable) e16);
            throw new CompileException(e16.getMessage(), this.expr, this.f73300st, e16);
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00f8 A[Catch: IllegalArgumentException -> 0x00ed, IllegalAccessException -> 0x00ef, TryCatch #4 {IllegalAccessException -> 0x00ef, IllegalArgumentException -> 0x00ed, blocks: (B:59:0x00e3, B:63:0x00f2, B:65:0x00f8, B:67:0x0109, B:68:0x0119), top: B:187:0x00e3 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0109 A[Catch: IllegalArgumentException -> 0x00ed, IllegalAccessException -> 0x00ef, TryCatch #4 {IllegalAccessException -> 0x00ef, IllegalArgumentException -> 0x00ed, blocks: (B:59:0x00e3, B:63:0x00f2, B:65:0x00f8, B:67:0x0109, B:68:0x0119), top: B:187:0x00e3 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0119 A[Catch: IllegalArgumentException -> 0x00ed, IllegalAccessException -> 0x00ef, TRY_LEAVE, TryCatch #4 {IllegalAccessException -> 0x00ef, IllegalArgumentException -> 0x00ed, blocks: (B:59:0x00e3, B:63:0x00f2, B:65:0x00f8, B:67:0x0109, B:68:0x0119), top: B:187:0x00e3 }] */
    private Object getBeanProperty(Object obj, String str) throws Exception {
        Class<?> cls;
        boolean z11;
        Object objB;
        ParserContext parserContext = this.pCtx;
        Object objB2 = null;
        if ((parserContext == null ? this.currType : parserContext.getVarOrInputTypeOrNull(str)) == Object.class && !this.pCtx.isStrongTyping()) {
            this.currType = null;
        }
        if (this.first) {
            if ("this".equals(str)) {
                addAccessorNode(new ThisValueAccessor());
                return this.thisRef;
            }
            VariableResolverFactory variableResolverFactory = this.variableFactory;
            if (variableResolverFactory != null && variableResolverFactory.isResolveable(str)) {
                if (!this.variableFactory.isIndexedFactory() || !this.variableFactory.isTarget(str)) {
                    addAccessorNode(new VariableAccessor(str));
                    return this.variableFactory.getVariableResolver(str).getValue();
                }
                int iVariableIndexOf = this.variableFactory.variableIndexOf(str);
                addAccessorNode(new IndexedVariableAccessor(iVariableIndexOf));
                if (this.variableFactory.getIndexedVariableResolver(iVariableIndexOf) == null) {
                    VariableResolverFactory variableResolverFactory2 = this.variableFactory;
                    variableResolverFactory2.setIndexedVariableResolver(iVariableIndexOf, variableResolverFactory2.getVariableResolver(str));
                }
                return this.variableFactory.getIndexedVariableResolver(iVariableIndexOf).getValue();
            }
        }
        boolean z12 = obj instanceof Class;
        if (!z12) {
            cls = obj != null ? obj.getClass() : this.currType;
            z11 = false;
        } else {
            if (org.mvel2.d.f73310j && "class".equals(str)) {
                return obj;
            }
            cls = (Class) obj;
            z11 = true;
        }
        if (l30.e.f(cls)) {
            PropertyHandlerAccessor propertyHandlerAccessor = new PropertyHandlerAccessor(str, cls, l30.e.c(cls));
            addAccessorNode(propertyHandlerAccessor);
            return propertyHandlerAccessor.getValue(obj, this.thisRef, this.variableFactory);
        }
        Member memberA = cls != null ? n.a(cls, str) : null;
        if (memberA != null && z11 && (memberA.getModifiers() & 8) == 0) {
            memberA = null;
        }
        if (memberA instanceof Method) {
            if (obj != null) {
                try {
                    objB2 = ((Method) memberA).invoke(obj, EMPTYARG);
                    if (l30.e.e()) {
                        addAccessorNode(new GetterAccessorNH((Method) memberA, l30.e.b()));
                        if (objB2 == null) {
                            objB2 = l30.e.b().b(memberA.getName(), obj, this.variableFactory);
                        }
                    } else {
                        addAccessorNode(new GetterAccessor((Method) memberA));
                    }
                } catch (IllegalAccessException unused) {
                    Method method = (Method) memberA;
                    Method methodZ = m.z(method);
                    if (methodZ == null) {
                        throw new PropertyAccessException("could not access field: " + cls.getName() + InstructionFileId.DOT + str, this.expr, this.start, this.pCtx);
                    }
                    Object objInvoke = methodZ.invoke(obj, EMPTYARG);
                    if (l30.e.e()) {
                        addAccessorNode(new GetterAccessorNH(method, l30.e.a()));
                        if (objInvoke == null) {
                            objB2 = l30.e.a().b(memberA.getName(), obj, this.variableFactory);
                        }
                    } else {
                        addAccessorNode(new GetterAccessor(methodZ));
                    }
                    objB2 = objInvoke;
                } catch (IllegalArgumentException e11) {
                    if (memberA.getDeclaringClass().equals(obj)) {
                        try {
                            throw new CompileException("name collision between innerclass: " + Class.forName(memberA.getDeclaringClass().getName() + "$" + str).getCanonicalName() + "; and bean accessor: " + str + " (" + memberA.toString() + ")", this.expr, this.tkStart);
                        } catch (ClassNotFoundException unused2) {
                            throw e11;
                        }
                    }
                    throw e11;
                }
            } else if (l30.e.e()) {
                addAccessorNode(new GetterAccessorNH((Method) memberA, l30.e.b()));
                if (objB2 == null) {
                    objB2 = l30.e.b().b(memberA.getName(), obj, this.variableFactory);
                }
            } else {
                addAccessorNode(new GetterAccessor((Method) memberA));
            }
            this.currType = p.i(((Method) memberA).getReturnType());
            return objB2;
        }
        if (memberA != null) {
            Field field = (Field) memberA;
            if ((field.getModifiers() & 8) != 0) {
                objB = field.get(null);
                if (l30.e.e()) {
                    addAccessorNode(new StaticVarAccessorNH(field, l30.e.a()));
                    if (objB == null) {
                        objB = l30.e.a().b(memberA.getName(), obj, this.variableFactory);
                    }
                } else {
                    addAccessorNode(new StaticVarAccessor(field));
                }
            } else {
                objB2 = obj != null ? field.get(obj) : null;
                if (l30.e.e()) {
                    addAccessorNode(new FieldAccessorNH(field, l30.e.a()));
                    if (objB2 == null) {
                        objB = l30.e.a().b(memberA.getName(), obj, this.variableFactory);
                    }
                } else {
                    addAccessorNode(new FieldAccessor(field));
                }
                objB = objB2;
            }
            this.currType = p.i(field.getType());
            return objB;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str) || this.nullSafe) {
                addAccessorNode(new MapAccessor(str));
                return map.get(str);
            }
        }
        if (obj != null && "length".equals(str) && obj.getClass().isArray()) {
            addAccessorNode(new ArrayLength());
            return Integer.valueOf(Array.getLength(obj));
        }
        if (AbstractParser.LITERALS.containsKey(str)) {
            Object obj2 = AbstractParser.LITERALS.get(str);
            addAccessorNode(new StaticReferenceAccessor(obj2));
            return obj2;
        }
        Object objTryStaticAccess = tryStaticAccess();
        this.staticAccess = true;
        if (objTryStaticAccess != null) {
            if (objTryStaticAccess instanceof Class) {
                addAccessorNode(new StaticReferenceAccessor(objTryStaticAccess));
                return objTryStaticAccess;
            }
            if (!(objTryStaticAccess instanceof Field)) {
                addAccessorNode(new StaticReferenceAccessor(objTryStaticAccess));
                return objTryStaticAccess;
            }
            Field field2 = (Field) objTryStaticAccess;
            addAccessorNode(new StaticVarAccessor(field2));
            return field2.get(null);
        }
        if (z12) {
            Class cls2 = (Class) obj;
            for (Method method2 : cls2.getMethods()) {
                if (str.equals(method2.getName())) {
                    ParserContext parserContext2 = this.pCtx;
                    if (parserContext2 == null || parserContext2.getParserConfiguration() == null ? !org.mvel2.d.f73307g : !this.pCtx.getParserConfiguration().isAllowNakedMethCall()) {
                        addAccessorNode(new StaticReferenceAccessor(method2));
                        return method2;
                    }
                    Object objInvoke2 = method2.invoke(null, m.f76821a);
                    if (l30.e.d()) {
                        addAccessorNode(new MethodAccessorNH(method2, new ExecutableStatement[0], l30.e.a()));
                        return objInvoke2 == null ? l30.e.a().b(method2.getName(), obj, this.variableFactory) : objInvoke2;
                    }
                    addAccessorNode(new MethodAccessor(method2, new ExecutableStatement[0]));
                    return objInvoke2;
                }
            }
            try {
                Class clsD = m.D(this.variableFactory, cls2.getName() + "$" + str, this.pCtx);
                addAccessorNode(new StaticReferenceAccessor(clsD));
                return clsD;
            } catch (ClassNotFoundException unused3) {
            }
        } else {
            ParserContext parserContext3 = this.pCtx;
            if (parserContext3 == null || parserContext3.getParserConfiguration() == null ? org.mvel2.d.f73307g : this.pCtx.getParserConfiguration().isAllowNakedMethCall()) {
                return getMethod(obj, str);
            }
        }
        if (obj == null) {
            throw new PropertyAccessException("unresolvable property or identifier: " + str, this.expr, this.start, this.pCtx);
        }
        throw new PropertyAccessException("could not access: " + str + "; in class: " + obj.getClass().getName(), this.expr, this.start, this.pCtx);
    }

    private Object getBeanPropertyAO(Object obj, String str) throws Exception {
        if (l30.a.a()) {
            l30.a.c(obj, str, this.variableFactory);
            addAccessorNode(new Notify(str));
        }
        return (obj == null || !l30.e.f(obj.getClass())) ? getBeanProperty(obj, str) : propHandler(str, obj, obj.getClass());
    }

    private Object getCollectionProperty(Object obj, String str) throws Exception {
        Integer numValueOf;
        boolean z11;
        ExecutableStatement executableStatement;
        Object value;
        if (str.length() > 0) {
            obj = getBeanProperty(obj, str);
        }
        this.currType = null;
        if (obj == null) {
            return null;
        }
        int i11 = this.cursor + 1;
        this.cursor = i11;
        skipWhitespace();
        if (this.cursor == this.end) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        if (scanTo(']')) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        String str2 = new String(this.expr, i11, this.cursor - i11);
        try {
            numValueOf = Integer.valueOf(Integer.parseInt(str2));
            z11 = false;
        } catch (Exception unused) {
            numValueOf = null;
            z11 = true;
        }
        if (z11) {
            try {
                executableStatement = (ExecutableStatement) m.J0(str2.toCharArray(), this.pCtx);
                Object obj2 = this.thisRef;
                value = executableStatement.getValue(obj2, obj2, this.variableFactory);
            } catch (CompileException e11) {
                e11.setExpr(this.expr);
                e11.setCursor(i11);
                throw e11;
            }
        } else {
            value = numValueOf;
            executableStatement = null;
        }
        this.cursor++;
        if (obj instanceof Map) {
            if (z11) {
                addAccessorNode(new MapAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new MapAccessor(Integer.valueOf(Integer.parseInt(str2))));
            }
            return ((Map) obj).get(value);
        }
        if (obj instanceof List) {
            if (z11) {
                addAccessorNode(new ListAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new ListAccessor(Integer.parseInt(str2)));
            }
            return ((List) obj).get(((Integer) value).intValue());
        }
        if (obj.getClass().isArray()) {
            if (z11) {
                addAccessorNode(new ArrayAccessorNest(executableStatement));
            } else {
                addAccessorNode(new ArrayAccessor(Integer.parseInt(str2)));
            }
            return Array.get(obj, ((Integer) value).intValue());
        }
        if (obj instanceof CharSequence) {
            if (z11) {
                addAccessorNode(new IndexedCharSeqAccessorNest(executableStatement));
            } else {
                addAccessorNode(new IndexedCharSeqAccessor(Integer.parseInt(str2)));
            }
            return Character.valueOf(((CharSequence) obj).charAt(((Integer) value).intValue()));
        }
        if (obj instanceof Class) {
            TypeDescriptor typeDescriptor = new TypeDescriptor(this.expr, this.start, this.length, 0);
            if (typeDescriptor.isArray()) {
                Class classReference = TypeDescriptor.getClassReference((Class) obj, typeDescriptor, this.variableFactory, this.pCtx);
                this.rootNode = new StaticReferenceAccessor(classReference);
                return classReference;
            }
        }
        throw new CompileException("illegal use of []: unknown type: " + obj.getClass().getName(), this.expr, this.start);
    }

    private Object getCollectionPropertyAO(Object obj, String str) throws Exception {
        Integer numValueOf;
        boolean z11;
        Object value;
        ExecutableStatement executableStatement;
        if (str.length() > 0) {
            obj = getBeanPropertyAO(obj, str);
        }
        this.currType = null;
        if (obj == null) {
            return null;
        }
        int i11 = this.cursor + 1;
        this.cursor = i11;
        skipWhitespace();
        if (this.cursor == this.end) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        if (scanTo(']')) {
            throw new CompileException("unterminated '['", this.expr, this.start);
        }
        String str2 = new String(this.expr, i11, this.cursor - i11);
        try {
            numValueOf = Integer.valueOf(Integer.parseInt(str2));
            z11 = false;
        } catch (Exception unused) {
            numValueOf = null;
            z11 = true;
        }
        if (z11) {
            executableStatement = (ExecutableStatement) m.J0(str2.toCharArray(), this.pCtx);
            Object obj2 = this.thisRef;
            value = executableStatement.getValue(obj2, obj2, this.variableFactory);
        } else {
            value = numValueOf;
            executableStatement = null;
        }
        this.cursor++;
        if (obj instanceof Map) {
            if (l30.e.f(Map.class)) {
                return propHandler(str2, obj, Map.class);
            }
            if (z11) {
                addAccessorNode(new MapAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new MapAccessor(Integer.valueOf(Integer.parseInt(str2))));
            }
            return ((Map) obj).get(value);
        }
        if (obj instanceof List) {
            if (l30.e.f(List.class)) {
                return propHandler(str2, obj, List.class);
            }
            if (z11) {
                addAccessorNode(new ListAccessorNest(executableStatement, (Class) null));
            } else {
                addAccessorNode(new ListAccessor(Integer.parseInt(str2)));
            }
            return ((List) obj).get(((Integer) value).intValue());
        }
        if (obj.getClass().isArray()) {
            if (l30.e.f(Array.class)) {
                return propHandler(str2, obj, Array.class);
            }
            if (z11) {
                addAccessorNode(new ArrayAccessorNest(executableStatement));
            } else {
                addAccessorNode(new ArrayAccessor(Integer.parseInt(str2)));
            }
            return Array.get(obj, ((Integer) value).intValue());
        }
        if (obj instanceof CharSequence) {
            if (l30.e.f(CharSequence.class)) {
                return propHandler(str2, obj, CharSequence.class);
            }
            if (z11) {
                addAccessorNode(new IndexedCharSeqAccessorNest(executableStatement));
            } else {
                addAccessorNode(new IndexedCharSeqAccessor(Integer.parseInt(str2)));
            }
            return Character.valueOf(((CharSequence) obj).charAt(((Integer) value).intValue()));
        }
        char[] cArr = this.expr;
        int i12 = this.start;
        TypeDescriptor typeDescriptor = new TypeDescriptor(cArr, i12, this.end - i12, 0);
        if (typeDescriptor.isArray()) {
            Class classReference = TypeDescriptor.getClassReference((Class) obj, typeDescriptor, this.variableFactory, this.pCtx);
            this.rootNode = new StaticReferenceAccessor(classReference);
            return classReference;
        }
        throw new CompileException("illegal use of []: unknown type: " + obj.getClass().getName(), this.expr, this.f73300st);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0025  */
    private Object getMethod(Object obj, String str) throws Exception {
        String str2;
        ExecutableStatement[] executableStatementArr;
        Object[] objArr;
        Class[] clsArr;
        int i11 = this.cursor;
        if (i11 != this.end) {
            char[] cArr = this.expr;
            if (cArr[i11] == '(') {
                int iC = m.c(cArr, i11, '(');
                this.cursor = iC;
                if (iC - i11 > 1) {
                    str2 = new String(this.expr, i11 + 1, (iC - i11) - 1);
                } else {
                    str2 = "";
                }
            } else {
                str2 = "";
            }
        } else {
            str2 = "";
        }
        this.cursor++;
        if (str2.length() == 0) {
            objArr = m.f76821a;
            executableStatementArr = null;
            clsArr = m.f76822b;
        } else {
            char[] charArray = str2.toCharArray();
            int i12 = 0;
            List<char[]> listY0 = m.y0(charArray, 0, -1);
            ExecutableStatement[] executableStatementArr2 = new ExecutableStatement[listY0.size()];
            int size = listY0.size();
            Object[] objArr2 = new Object[size];
            Class[] clsArr2 = new Class[listY0.size()];
            for (int i13 = 0; i13 < listY0.size(); i13++) {
                try {
                    ExecutableStatement executableStatement = (ExecutableStatement) m.J0(listY0.get(i13), this.pCtx);
                    executableStatementArr2[i13] = executableStatement;
                    Object obj2 = this.thisRef;
                    objArr2[i13] = executableStatement.getValue(obj2, obj2, this.variableFactory);
                    if (executableStatementArr2[i13].isExplicitCast()) {
                        clsArr2[i13] = executableStatementArr2[i13].getKnownEgressType();
                    }
                } catch (CompileException e11) {
                    throw f.a(e11, this.expr, this.start);
                }
            }
            if (this.pCtx.isStrictTypeEnforcement()) {
                while (i12 < size) {
                    clsArr2[i12] = executableStatementArr2[i12].getKnownEgressType();
                    ExecutableStatement executableStatement2 = executableStatementArr2[i12];
                    if ((executableStatement2 instanceof ExecutableLiteral) && ((ExecutableLiteral) executableStatement2).getLiteral() == null) {
                        clsArr2[i12] = l.class;
                    }
                    i12++;
                }
            } else {
                while (i12 < size) {
                    if (clsArr2[i12] == null) {
                        if (executableStatementArr2[i12].getKnownEgressType() == Object.class) {
                            Object obj3 = objArr2[i12];
                            clsArr2[i12] = obj3 == null ? null : obj3.getClass();
                        } else {
                            clsArr2[i12] = executableStatementArr2[i12].getKnownEgressType();
                        }
                    }
                    i12++;
                }
            }
            executableStatementArr = executableStatementArr2;
            objArr = objArr2;
            clsArr = clsArr2;
        }
        return getMethod(obj, str, objArr, clsArr, executableStatementArr);
    }

    private Object getMethod(Object obj, String str, Object[] objArr, Class[] clsArr, ExecutableStatement[] executableStatementArr) throws Exception {
        boolean z11;
        VariableResolverFactory variableResolverFactory;
        Class<?> classReference = obj;
        String methodName = str;
        int i11 = 0;
        if (this.first && (variableResolverFactory = this.variableFactory) != null && variableResolverFactory.isResolveable(methodName)) {
            Object value = this.variableFactory.getVariableResolver(methodName).getValue();
            if (value instanceof Method) {
                Method method = (Method) value;
                classReference = method.getDeclaringClass();
                methodName = method.getName();
            } else {
                if (!(value instanceof MethodStub)) {
                    if (value instanceof org.mvel2.ast.b) {
                        org.mvel2.ast.b bVar = (org.mvel2.ast.b) value;
                        if (methodName.equals(bVar.b().getName())) {
                            addAccessorNode(new FunctionAccessor(bVar, executableStatementArr));
                        } else {
                            getBeanProperty(obj, str);
                            addAccessorNode(new DynamicFunctionAccessor(executableStatementArr));
                        }
                        return bVar.a(classReference, this.thisRef, this.variableFactory, objArr);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("attempt to optimize a method call for a reference that does not point to a method: ");
                    sb2.append(methodName);
                    sb2.append(" (reference is type: ");
                    sb2.append(classReference != null ? obj.getClass().getName() : null);
                    sb2.append(")");
                    throw new OptimizationFailure(sb2.toString());
                }
                MethodStub methodStub = (MethodStub) value;
                classReference = methodStub.getClassReference();
                methodName = methodStub.getMethodName();
            }
            this.first = false;
        }
        if (classReference == null && this.currType == null) {
            throw new PropertyAccessException("null pointer or function not found: " + methodName, this.expr, this.start, this.pCtx);
        }
        Class<?> cls = this.currType;
        if (cls != null) {
            z11 = false;
        } else {
            boolean z12 = classReference instanceof Class;
            z11 = z12;
            cls = z12 ? classReference : classReference.getClass();
        }
        this.currType = null;
        Method methodK = m.K(clsArr, methodName, cls, cls.getMethods(), false, z11);
        Class<?>[] parameterTypes = methodK != null ? methodK.getParameterTypes() : null;
        if (methodK == null && z11) {
            methodK = m.J(clsArr, methodName, cls, Class.class.getMethods(), false);
            if (methodK != null) {
                parameterTypes = methodK.getParameterTypes();
            }
        }
        Class<?>[] parameterTypes2 = parameterTypes;
        if (methodK == null && classReference != null && cls != classReference.getClass() && !(classReference instanceof Class)) {
            cls = classReference.getClass();
            methodK = m.K(clsArr, methodName, cls, cls.getMethods(), false, z11);
            if (methodK != null) {
                parameterTypes2 = methodK.getParameterTypes();
            }
        }
        if (methodK != null) {
            if (executableStatementArr != null) {
                while (i11 < executableStatementArr.length) {
                    ExecutableStatement executableStatement = executableStatementArr[i11];
                    if (executableStatement.getKnownIngressType() == null) {
                        executableStatement.setKnownIngressType(t.b(parameterTypes2, i11, methodK.isVarArgs()));
                        executableStatement.computeTypeConversionRule();
                    }
                    if (!executableStatement.isConvertableIngressEgress()) {
                        objArr[i11] = org.mvel2.b.b(objArr[i11], t.b(parameterTypes2, i11, methodK.isVarArgs()));
                    }
                    i11++;
                }
            } else {
                while (i11 < objArr.length) {
                    objArr[i11] = org.mvel2.b.b(objArr[i11], t.b(parameterTypes2, i11, methodK.isVarArgs()));
                    i11++;
                }
            }
            Method methodU = m.U(cls, methodK);
            Object objInvoke = classReference != null ? methodU.invoke(classReference, t.a(parameterTypes2, objArr, methodK.isVarArgs())) : null;
            if (l30.e.d()) {
                addAccessorNode(new MethodAccessorNH(methodU, executableStatementArr, l30.e.a()));
                if (objInvoke == null) {
                    objInvoke = l30.e.a().b(methodK.getName(), classReference, this.variableFactory);
                }
            } else {
                addAccessorNode(new MethodAccessor(methodU, executableStatementArr));
            }
            this.currType = p.i(methodU.getReturnType());
            return objInvoke;
        }
        s sVar = new s();
        if ("size".equals(methodName) && objArr.length == 0 && cls.isArray()) {
            addAccessorNode(new ArrayLength());
            return Integer.valueOf(Array.getLength(classReference));
        }
        while (i11 < objArr.length) {
            Object obj2 = objArr[i11];
            sVar.d(obj2 != null ? obj2.getClass().getName() : null);
            if (i11 < objArr.length - 1) {
                sVar.d(", ");
            }
            i11++;
        }
        throw new PropertyAccessException("unable to resolve method: " + cls.getName() + InstructionFileId.DOT + methodName + "(" + sVar.toString() + ") [arglength=" + objArr.length + "]", this.expr, this.f73300st, this.pCtx);
    }

    private AccessorNode getRootNode() {
        return this.rootNode;
    }

    private Object getWithProperty(Object obj) {
        this.currType = null;
        int i11 = this.start;
        int i12 = this.cursor;
        String strTrim = i11 != i12 ? new String(this.expr, i11, i12 - 1).trim() : null;
        int i13 = this.cursor;
        int i14 = i13 + 1;
        int iE = m.e(this.expr, i13, this.end, '{', this.pCtx);
        ParserContext parserContext = this.pCtx;
        char[] cArr = this.expr;
        this.cursor = iE + 1;
        WithAccessor withAccessor = new WithAccessor(parserContext, strTrim, cArr, i14, iE - i14, this.ingressType);
        addAccessorNode(withAccessor);
        return withAccessor.getValue(obj, this.thisRef, this.variableFactory);
    }

    private Object propHandler(String str, Object obj, Class cls) {
        l30.d dVarC = l30.e.c(cls);
        addAccessorNode(new PropertyHandlerAccessor(str, cls, dVarC));
        return dVarC.b(str, obj, this.variableFactory);
    }

    private void setRootNode(AccessorNode accessorNode) {
        this.currNode = accessorNode;
        this.rootNode = accessorNode;
    }

    @Override // org.mvel2.optimizers.a
    public Class getEgressType() {
        return this.returnType;
    }

    @Override // org.mvel2.optimizers.a
    public Object getResultOptPass() {
        return this.val;
    }

    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) throws Exception {
        return this.rootNode.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.optimizers.a
    public void init() {
    }

    @Override // org.mvel2.optimizers.a
    public boolean isLiteralOnly() {
        return false;
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeAccessor(ParserContext parserContext, char[] cArr, int i11, int i12, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z11, Class cls) {
        this.currNode = null;
        this.rootNode = null;
        this.expr = cArr;
        this.start = i11;
        int i13 = i12 + i11;
        this.end = i13;
        this.length = i13 - i11;
        this.first = true;
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.ingressType = cls;
        this.pCtx = parserContext;
        return compileGetChain();
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeCollection(ParserContext parserContext, Object obj, Class cls, char[] cArr, int i11, int i12, Object obj2, Object obj3, VariableResolverFactory variableResolverFactory) {
        this.cursor = i11;
        this.start = i11;
        this.length = i11 + i12;
        this.returnType = cls;
        this.ctx = obj2;
        this.variableFactory = variableResolverFactory;
        this.pCtx = parserContext;
        org.mvel2.compiler.a aVar_getAccessor = _getAccessor(obj, cls);
        return (cArr == null || this.length <= i11) ? aVar_getAccessor : new org.mvel2.optimizers.impl.refl.nodes.a(parserContext, aVar_getAccessor, cArr, this.cursor, i12);
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeObjectCreation(ParserContext parserContext, char[] cArr, int i11, int i12, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        this.length = i12 + i11;
        this.start = i11;
        this.cursor = i11;
        this.pCtx = parserContext;
        try {
            return compileConstructor(cArr, obj, variableResolverFactory);
        } catch (ClassNotFoundException e11) {
            throw new CompileException("could not resolve class: " + e11.getMessage(), cArr, this.start, e11);
        } catch (CompileException e12) {
            throw f.a(e12, cArr, this.start);
        } catch (Exception e13) {
            throw new CompileException("could not create constructor: " + e13.getMessage(), cArr, this.start, e13);
        }
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeSetAccessor(ParserContext parserContext, char[] cArr, int i11, int i12, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z11, Object obj3, Class cls) {
        char[] cArrK0;
        Class cls2 = null;
        this.currNode = null;
        this.rootNode = null;
        this.expr = cArr;
        this.start = i11;
        this.first = true;
        this.length = i11 + i12;
        this.ctx = obj;
        this.thisRef = obj2;
        this.variableFactory = variableResolverFactory;
        this.ingressType = cls;
        int iFindLastUnion = findLastUnion();
        this.pCtx = parserContext;
        PropertyVerifier propertyVerifier = new PropertyVerifier(cArr, parserContext);
        if (iFindLastUnion != -1) {
            int i13 = iFindLastUnion + 1;
            cArrK0 = m.K0(cArr, 0, iFindLastUnion);
            cArr = m.K0(cArr, i13, cArr.length - i13);
        } else {
            cArrK0 = null;
        }
        if (cArrK0 != null) {
            this.expr = cArrK0;
            int length = cArrK0.length;
            this.end = length;
            this.length = length;
            compileGetChain();
            obj = this.val;
        }
        if (obj == null) {
            throw new PropertyAccessException("could not access property: " + new String(cArr, this.start, Math.min(this.length, cArr.length)) + "; parent is null: " + new String(this.expr), this.expr, this.start, parserContext);
        }
        try {
            this.expr = cArr;
            int length2 = cArr.length;
            this.end = length2;
            this.length = length2;
            this.cursor = 0;
            skipWhitespace();
            if (this.collection) {
                int i14 = this.cursor;
                if (i14 == this.end) {
                    throw new PropertyAccessException("unterminated '['", this.expr, this.start, parserContext);
                }
                if (scanTo(']')) {
                    throw new PropertyAccessException("unterminated '['", this.expr, this.start, parserContext);
                }
                String str = new String(cArr, i14, this.cursor - i14);
                if (obj instanceof Map) {
                    if (org.mvel2.d.f73308h && l30.e.f(Map.class)) {
                        propHandlerSet(str, obj, Map.class, obj3);
                    } else {
                        Map map = (Map) obj;
                        Object objL = org.mvel2.d.l(str, obj, this.variableFactory);
                        Class clsAnalyze = propertyVerifier.analyze();
                        this.returnType = clsAnalyze;
                        map.put(objL, org.mvel2.b.b(obj3, clsAnalyze));
                        addAccessorNode(new MapAccessorNest(str, this.returnType));
                    }
                    return this.rootNode;
                }
                if (obj instanceof List) {
                    if (org.mvel2.d.f73308h && l30.e.f(List.class)) {
                        propHandlerSet(str, obj, List.class, obj3);
                    } else {
                        List list = (List) obj;
                        int iIntValue = ((Integer) org.mvel2.d.m(str, obj, this.variableFactory, Integer.class)).intValue();
                        Class clsAnalyze2 = propertyVerifier.analyze();
                        this.returnType = clsAnalyze2;
                        list.set(iIntValue, org.mvel2.b.b(obj3, clsAnalyze2));
                        addAccessorNode(new ListAccessorNest(str, this.returnType));
                    }
                    return this.rootNode;
                }
                if (org.mvel2.d.f73308h && l30.e.f(obj.getClass())) {
                    propHandlerSet(str, obj, obj.getClass(), obj3);
                    return this.rootNode;
                }
                if (obj.getClass().isArray()) {
                    if (org.mvel2.d.f73308h && l30.e.f(Array.class)) {
                        propHandlerSet(str, obj, Array.class, obj3);
                    } else {
                        Array.set(obj, ((Integer) org.mvel2.d.m(str, obj, this.variableFactory, Integer.class)).intValue(), org.mvel2.b.b(obj3, m.I(obj.getClass())));
                        addAccessorNode(new ArrayAccessorNest(str));
                    }
                    return this.rootNode;
                }
                throw new PropertyAccessException("cannot bind to collection property: " + new String(cArr) + ": not a recognized collection type: " + obj.getClass(), this.expr, this.f73300st, parserContext);
            }
            if (org.mvel2.d.f73308h && l30.e.f(obj.getClass())) {
                propHandlerSet(new String(cArr), obj, obj.getClass(), obj3);
                return this.rootNode;
            }
            String strTrim = new String(cArr, 0, this.length).trim();
            if (l30.a.b()) {
                l30.a.d(obj, strTrim, this.variableFactory, obj3);
                addAccessorNode(new Notify(strTrim));
            }
            Class<?> cls3 = obj.getClass();
            if (obj3 != null) {
                cls2 = cls;
            }
            Member memberC = n.c(cls3, strTrim, cls2);
            if (memberC instanceof Field) {
                Field field = (Field) memberC;
                if (obj3 == null || field.getType().isAssignableFrom(obj3.getClass())) {
                    if (obj3 == null && field.getType().isPrimitive()) {
                        field.set(obj, n.f(field.getType()));
                        addAccessorNode(new FieldAccessor(field));
                    } else {
                        field.set(obj, obj3);
                        addAccessorNode(new FieldAccessor(field));
                    }
                } else {
                    if (!org.mvel2.b.a(field.getType(), obj3.getClass())) {
                        throw new CompileException("cannot convert type: " + obj3.getClass() + ": to " + field.getType(), this.expr, this.start);
                    }
                    field.set(obj, org.mvel2.b.b(obj3, field.getType()));
                    addAccessorNode(new DynamicFieldAccessor(field));
                }
            } else if (memberC != null) {
                Method method = (Method) memberC;
                if (obj3 == null || method.getParameterTypes()[0].isAssignableFrom(obj3.getClass())) {
                    if (obj3 == null && method.getParameterTypes()[0].isPrimitive()) {
                        method.invoke(obj, n.f(method.getParameterTypes()[0]));
                    } else {
                        method.invoke(obj, obj3);
                    }
                } else {
                    if (!org.mvel2.b.a(method.getParameterTypes()[0], obj3.getClass())) {
                        throw new CompileException("cannot convert type: " + obj3.getClass() + ": to " + method.getParameterTypes()[0], this.expr, this.start);
                    }
                    method.invoke(obj, org.mvel2.b.b(obj3, method.getParameterTypes()[0]));
                }
                addAccessorNode(new SetterAccessor(method));
            } else {
                if (!(obj instanceof Map)) {
                    throw new PropertyAccessException("could not access property (" + strTrim + ") in: " + cls.getName(), this.expr, this.start, parserContext);
                }
                ((Map) obj).put(strTrim, obj3);
                addAccessorNode(new MapAccessor(strTrim));
            }
            return this.rootNode;
        } catch (IllegalAccessException e11) {
            throw new PropertyAccessException("could not access property: " + new String(cArr), this.expr, this.f73300st, e11, parserContext);
        } catch (IllegalArgumentException e12) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error binding property: ");
            sb2.append(new String(cArr));
            sb2.append(" (value <<");
            sb2.append(obj3);
            sb2.append(">>::");
            sb2.append(obj3 == null ? "null" : obj3.getClass().getCanonicalName());
            sb2.append(")");
            throw new PropertyAccessException(sb2.toString(), this.expr, this.f73300st, e12, parserContext);
        } catch (InvocationTargetException e13) {
            throw new PropertyAccessException("could not access property: " + new String(cArr), this.expr, this.f73300st, e13, parserContext);
        }
    }

    public void propHandlerSet(String str, Object obj, Class cls, Object obj2) {
        l30.d dVarC = l30.e.c(cls);
        addAccessorNode(new PropertyHandlerAccessor(str, cls, dVarC));
        dVarC.a(str, obj, this.variableFactory, obj2);
    }
}
