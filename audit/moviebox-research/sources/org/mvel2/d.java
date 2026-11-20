package org.mvel2;

import java.io.Serializable;
import java.util.Map;
import org.mvel2.compiler.CompiledAccExpression;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.compiler.ExpressionCompiler;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.CachingMapVariableResolverFactory;
import t30.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f73301a = Boolean.getBoolean("mvel2.debug.fileoutput");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f73302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f73303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f73304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f73305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f73306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f73307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f73308h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f73309i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f73310j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f73311k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f73312l;

    static {
        f73302b = System.getProperty("mvel2.debugging.file") == null ? "mvel_debug.txt" : System.getProperty("mvel2.debugging.file");
        f73303c = Boolean.getBoolean("mvel2.advanced_debugging");
        f73304d = Boolean.getBoolean("mvel2.weak_caching");
        f73305e = Boolean.getBoolean("mvel2.disable.jit");
        f73306f = Boolean.getBoolean("mvel2.invoked_meth_exceptions_bubble");
        f73307g = Boolean.getBoolean("mvel2.compiler.allow_naked_meth_calls");
        f73308h = Boolean.getBoolean("mvel2.compiler.allow_override_all_prophandling");
        f73309i = Boolean.getBoolean("mvel2.compiler.allow_resolve_inner_classes_with_dotnotation");
        f73310j = Boolean.getBoolean("mvel2.compiler.support_java_style_class_literals");
        f73311k = Boolean.getBoolean("mvel2.compiler.allocate_type_literals_to_shared_symbol_table");
        f73312l = true;
        if (System.getProperty("mvel2.optimizer") != null) {
            f73312l = Boolean.getBoolean("mvel2.optimizer");
        }
    }

    public static void a(String str, ParserContext parserContext) {
        b(str.toCharArray(), parserContext);
    }

    public static void b(char[] cArr, ParserContext parserContext) {
        ExpressionCompiler expressionCompiler = new ExpressionCompiler(cArr, parserContext);
        expressionCompiler.setVerifyOnly(true);
        expressionCompiler.compile();
    }

    public static Class c(char[] cArr, ParserContext parserContext) {
        ExpressionCompiler expressionCompiler = new ExpressionCompiler(cArr, parserContext);
        expressionCompiler.setVerifyOnly(true);
        expressionCompiler.compile();
        return expressionCompiler.getReturnType();
    }

    public static Serializable d(String str, ParserContext parserContext) {
        return m.v0(new ExpressionCompiler(str, parserContext).compile());
    }

    public static Serializable e(char[] cArr, int i11, int i12, ParserContext parserContext) {
        return m.v0(new ExpressionCompiler(cArr, i11, i12, parserContext)._compile());
    }

    public static Serializable f(char[] cArr, ParserContext parserContext) {
        return m.v0(new ExpressionCompiler(cArr, parserContext).compile());
    }

    public static Serializable g(String str, Class cls, ParserContext parserContext) {
        return new CompiledAccExpression(str.toCharArray(), cls, parserContext);
    }

    public static Serializable h(char[] cArr) {
        return new CompiledAccExpression(cArr, Object.class, new ParserContext());
    }

    public static Serializable i(char[] cArr, int i11, int i12, ParserContext parserContext) {
        return new CompiledAccExpression(cArr, i11, i12, Object.class, parserContext);
    }

    public static Serializable j(char[] cArr, Class cls, ParserContext parserContext) {
        return new CompiledAccExpression(cArr, cls, parserContext);
    }

    public static Serializable k(char[] cArr, ParserContext parserContext) {
        return new CompiledAccExpression(cArr, Object.class, parserContext);
    }

    public static Object l(String str, Object obj, VariableResolverFactory variableResolverFactory) {
        return new MVELInterpretedRuntime(str, obj, variableResolverFactory).parse();
    }

    public static <T> T m(String str, Object obj, VariableResolverFactory variableResolverFactory, Class<T> cls) {
        return (T) b.b(new MVELInterpretedRuntime(str, obj, variableResolverFactory).parse(), cls);
    }

    public static Object n(String str, Map<String, Object> map) {
        CachingMapVariableResolverFactory cachingMapVariableResolverFactory = new CachingMapVariableResolverFactory(map);
        try {
            return new MVELInterpretedRuntime(str, (Object) null, cachingMapVariableResolverFactory).parse();
        } finally {
            cachingMapVariableResolverFactory.externalize();
        }
    }

    public static Object o(char[] cArr, int i11, int i12, Object obj, VariableResolverFactory variableResolverFactory) {
        return new MVELInterpretedRuntime(cArr, i11, i12, obj, variableResolverFactory).parse();
    }

    public static <T> T p(char[] cArr, int i11, int i12, Object obj, VariableResolverFactory variableResolverFactory, Class<T> cls) {
        return (T) b.b(new MVELInterpretedRuntime(cArr, i11, i12, obj, variableResolverFactory).parse(), cls);
    }

    public static Object q(char[] cArr, Object obj, VariableResolverFactory variableResolverFactory) {
        return new MVELInterpretedRuntime(cArr, obj, variableResolverFactory).parse();
    }

    public static Object r(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return ((ExecutableStatement) obj).getValue(obj2, variableResolverFactory);
    }

    public static <T> T s(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Class<T> cls) {
        return (T) b.b(r(obj, obj2, variableResolverFactory), cls);
    }

    public static void t(Serializable serializable, Object obj, VariableResolverFactory variableResolverFactory, Object obj2) {
        ((CompiledAccExpression) serializable).setValue(obj, obj, variableResolverFactory, obj2);
    }

    public static String u() {
        return f73302b;
    }

    public static Object v(String str, Object obj) {
        return h.k(str, obj);
    }

    public static boolean w() {
        return f73303c;
    }

    public static boolean x() {
        return f73301a;
    }

    public static void y(Object obj, String str, Object obj2) {
        h.z(obj, str, obj2);
    }
}
