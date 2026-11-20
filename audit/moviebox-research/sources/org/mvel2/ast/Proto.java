package org.mvel2.ast;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.UnresolveablePropertyException;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolver;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.mvel2.integration.impl.SimpleValueResolver;
import t30.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Proto extends ASTNode {
    private int cursorEnd;
    private int cursorStart;
    private String name;
    private Map<String, c> receivers;

    /* JADX INFO: compiled from: source.java */
    public class ProtoContextFactory extends MapVariableResolverFactory {
        private final q<String, VariableResolver> variableResolvers;

        public ProtoContextFactory(q qVar) {
            super(qVar);
            this.variableResolvers = new q<>(qVar, true);
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver createIndexedVariable(int i11, String str, Object obj) {
            VariableResolver variableResolverA = this.variableResolvers.a(i11);
            if (variableResolverA == null) {
                this.variableResolvers.d(i11, new SimpleValueResolver(obj));
            } else {
                variableResolverA.setValue(obj);
            }
            return this.indexedVariableResolvers[i11];
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver createIndexedVariable(int i11, String str, Object obj, Class<?> cls) {
            q<String, VariableResolver> qVar = this.variableResolvers;
            VariableResolver variableResolverA = qVar != null ? qVar.a(i11) : null;
            if (variableResolverA == null || variableResolverA.getType() == null) {
                return createIndexedVariable(variableIndexOf(str), str, obj);
            }
            String str2 = "variable already defined within scope: " + variableResolverA.getType() + " " + str;
            Proto proto = Proto.this;
            throw new CompileException(str2, proto.expr, proto.start);
        }

        @Override // org.mvel2.integration.impl.MapVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver createVariable(String str, Object obj) {
            try {
                VariableResolver variableResolver = getVariableResolver(str);
                variableResolver.setValue(obj);
                return variableResolver;
            } catch (UnresolveablePropertyException unused) {
                ProtoResolver protoResolver = Proto.this.new ProtoResolver(this.variables, str);
                addResolver(str, protoResolver).setValue(obj);
                return protoResolver;
            }
        }

        @Override // org.mvel2.integration.impl.MapVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver createVariable(String str, Object obj, Class<?> cls) {
            VariableResolver variableResolver;
            try {
                variableResolver = getVariableResolver(str);
            } catch (UnresolveablePropertyException unused) {
                variableResolver = null;
            }
            if (variableResolver == null || variableResolver.getType() == null) {
                ProtoResolver protoResolver = Proto.this.new ProtoResolver(this.variables, str, cls);
                addResolver(str, protoResolver).setValue(obj);
                return protoResolver;
            }
            String str2 = "variable already defined within scope: " + variableResolver.getType() + " " + str;
            Proto proto = Proto.this;
            throw new CompileException(str2, proto.expr, proto.start);
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory
        public String[] getIndexedVariableNames() {
            return null;
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver getIndexedVariableResolver(int i11) {
            return this.variableResolvers.a(i11);
        }

        @Override // org.mvel2.integration.impl.MapVariableResolverFactory, org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver getVariableResolver(String str) {
            VariableResolver variableResolver = this.variableResolvers.get(str);
            if (variableResolver != null) {
                return variableResolver;
            }
            if (this.variables.containsKey(str)) {
                q<String, VariableResolver> qVar = this.variableResolvers;
                ProtoResolver protoResolver = Proto.this.new ProtoResolver(this.variables, str);
                qVar.put(str, protoResolver);
                return protoResolver;
            }
            VariableResolverFactory variableResolverFactory = this.nextFactory;
            if (variableResolverFactory != null) {
                return variableResolverFactory.getVariableResolver(str);
            }
            throw new UnresolveablePropertyException("unable to resolve variable '" + str + "'");
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory
        public void setIndexedVariableNames(String[] strArr) {
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public VariableResolver setIndexedVariableResolver(int i11, VariableResolver variableResolver) {
            this.variableResolvers.d(i11, variableResolver);
            return variableResolver;
        }

        @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
        public int variableIndexOf(String str) {
            return this.variableResolvers.c(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class ProtoResolver implements VariableResolver {
        private Class<?> knownType;
        private String name;
        private Map<String, Object> variableMap;

        public ProtoResolver(Map<String, Object> map, String str) {
            this.variableMap = map;
            this.name = str;
        }

        public ProtoResolver(Map<String, Object> map, String str, Class cls) {
            this.name = str;
            this.knownType = cls;
            this.variableMap = map;
        }

        @Override // org.mvel2.integration.VariableResolver
        public int getFlags() {
            return 0;
        }

        @Override // org.mvel2.integration.VariableResolver
        public String getName() {
            return this.name;
        }

        @Override // org.mvel2.integration.VariableResolver
        public Class getType() {
            return this.knownType;
        }

        @Override // org.mvel2.integration.VariableResolver
        public Object getValue() {
            return ((c) this.variableMap.get(this.name)).f73283b;
        }

        public void setName(String str) {
            this.name = str;
        }

        @Override // org.mvel2.integration.VariableResolver
        public void setStaticType(Class cls) {
            this.knownType = cls;
        }

        @Override // org.mvel2.integration.VariableResolver
        public void setValue(Object obj) {
            if (this.knownType != null && obj != null) {
                Class<?> cls = obj.getClass();
                Class<?> cls2 = this.knownType;
                if (cls != cls2) {
                    if (!org.mvel2.b.a(cls2, obj.getClass())) {
                        String str = "cannot assign " + obj.getClass().getName() + " to type: " + this.knownType.getName();
                        Proto proto = Proto.this;
                        throw new CompileException(str, proto.expr, proto.start);
                    }
                    try {
                        obj = org.mvel2.b.b(obj, this.knownType);
                    } catch (Exception unused) {
                        String str2 = "cannot convert value of " + obj.getClass().getName() + " to: " + this.knownType.getName();
                        Proto proto2 = Proto.this;
                        throw new CompileException(str2, proto2.expr, proto2.start);
                    }
                }
            }
            ((c) this.variableMap.get(this.name)).f73283b = obj;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum ReceiverType {
        DEFERRED,
        FUNCTION,
        PROPERTY
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f73277a;

        static {
            int[] iArr = new int[ReceiverType.values().length];
            f73277a = iArr;
            try {
                iArr[ReceiverType.FUNCTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f73277a[ReceiverType.PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f73277a[ReceiverType.DEFERRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Map<String, c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Proto f73278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public VariableResolverFactory f73279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public q<String, c> f73280c = new q<>();

        public b(Proto proto, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
            this.f73278a = proto;
            for (Map.Entry entry : proto.receivers.entrySet()) {
                this.f73280c.put((String) entry.getKey(), ((c) entry.getValue()).d(this, obj, obj2, variableResolverFactory));
            }
            this.f73279b = Proto.this.new ProtoContextFactory(this.f73280c);
        }

        @Override // java.util.Map
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public c get(Object obj) {
            return this.f73280c.get(obj);
        }

        @Override // java.util.Map
        public void clear() {
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.f73280c.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.f73280c.containsValue(obj);
        }

        @Override // java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public c put(String str, c cVar) {
            return this.f73280c.put(str, cVar);
        }

        @Override // java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public c remove(Object obj) {
            return this.f73280c.remove(obj);
        }

        @Override // java.util.Map
        public Set<Map.Entry<String, c>> entrySet() {
            return this.f73280c.entrySet();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.f73280c.isEmpty();
        }

        @Override // java.util.Map
        public Set<String> keySet() {
            return this.f73280c.keySet();
        }

        @Override // java.util.Map
        public void putAll(Map<? extends String, ? extends c> map) {
        }

        @Override // java.util.Map
        public int size() {
            return this.f73280c.size();
        }

        @Override // java.util.Map
        public Collection<c> values() {
            return this.f73280c.values();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ReceiverType f73282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f73283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ExecutableStatement f73284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b f73285d;

        public c(b bVar, ReceiverType receiverType, Object obj) {
            this.f73285d = bVar;
            this.f73282a = receiverType;
            this.f73283b = obj;
        }

        public c(b bVar, ReceiverType receiverType, ExecutableStatement executableStatement) {
            this.f73285d = bVar;
            this.f73282a = receiverType;
            this.f73284c = executableStatement;
        }

        public Object c(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object[] objArr) {
            int i11 = a.f73277a[this.f73282a.ordinal()];
            if (i11 == 1) {
                return ((Function) this.f73283b).call(obj, obj2, new InvokationContextFactory(variableResolverFactory, this.f73285d.f73279b), objArr);
            }
            if (i11 == 2) {
                return this.f73283b;
            }
            if (i11 != 3) {
                return null;
            }
            Proto proto = Proto.this;
            throw new CompileException("unresolved prototype receiver", proto.expr, proto.start);
        }

        public c d(b bVar, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
            ExecutableStatement executableStatement;
            Proto proto = Proto.this;
            ReceiverType receiverType = this.f73282a;
            return proto.new c(bVar, receiverType, (receiverType != ReceiverType.PROPERTY || (executableStatement = this.f73284c) == null) ? this.f73283b : executableStatement.getValue(obj, obj2, variableResolverFactory));
        }

        public void e(ExecutableStatement executableStatement) {
            this.f73284c = executableStatement;
        }

        public void f(ReceiverType receiverType) {
            this.f73282a = receiverType;
        }
    }

    public Proto(String str, ParserContext parserContext) {
        super(parserContext);
        this.name = str;
        this.receivers = new q();
    }

    public c declareReceiver(String str, Class cls, ExecutableStatement executableStatement) {
        c cVar = new c((b) null, ReceiverType.PROPERTY, executableStatement);
        this.receivers.put(str, cVar);
        return cVar;
    }

    public c declareReceiver(String str, Function function) {
        c cVar = new c((b) null, ReceiverType.FUNCTION, function);
        this.receivers.put(str, cVar);
        return cVar;
    }

    public c declareReceiver(String str, ReceiverType receiverType, ExecutableStatement executableStatement) {
        c cVar = new c((b) null, receiverType, executableStatement);
        this.receivers.put(str, cVar);
        return cVar;
    }

    public int getCursorEnd() {
        return this.cursorEnd;
    }

    public int getCursorStart() {
        return this.cursorStart;
    }

    @Override // org.mvel2.ast.ASTNode
    public String getName() {
        return this.name;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        variableResolverFactory.createVariable(this.name, this);
        return this;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        variableResolverFactory.createVariable(this.name, this);
        return this;
    }

    public b newInstance(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return new b(this, obj, obj2, variableResolverFactory);
    }

    public void setCursorPosition(int i11, int i12) {
        this.cursorStart = i11;
        this.cursorEnd = i12;
    }

    @Override // org.mvel2.ast.ASTNode
    public String toString() {
        return "proto " + this.name;
    }
}
