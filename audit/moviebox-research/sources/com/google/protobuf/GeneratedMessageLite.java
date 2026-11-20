package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends com.google.protobuf.a<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected i1 unknownFields = i1.c();
    protected int memoizedSerializedSize = -1;

    /* JADX INFO: compiled from: source.java */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        public SerializedForm(n0 n0Var) {
            Class<?> cls = n0Var.getClass();
            this.messageClass = cls;
            this.messageClassName = cls.getName();
            this.asBytes = n0Var.h();
        }

        public static SerializedForm of(n0 n0Var) {
            return new SerializedForm(n0Var);
        }

        @Deprecated
        private Object readResolveFallback() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((n0) declaredField.get(null)).j().w(this.asBytes).u();
            } catch (InvalidProtocolBufferException e11) {
                throw new RuntimeException("Unable to understand proto buffer", e11);
            } catch (ClassNotFoundException e12) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e12);
            } catch (IllegalAccessException e13) {
                throw new RuntimeException("Unable to call parsePartialFrom", e13);
            } catch (NoSuchFieldException e14) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e14);
            } catch (SecurityException e15) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e15);
            }
        }

        private Class<?> resolveMessageClass() throws ClassNotFoundException {
            Class<?> cls = this.messageClass;
            return cls != null ? cls : Class.forName(this.messageClassName);
        }

        public Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((n0) declaredField.get(null)).j().w(this.asBytes).u();
            } catch (InvalidProtocolBufferException e11) {
                throw new RuntimeException("Unable to understand proto buffer", e11);
            } catch (ClassNotFoundException e12) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e12);
            } catch (IllegalAccessException e13) {
                throw new RuntimeException("Unable to call parsePartialFrom", e13);
            } catch (NoSuchFieldException unused) {
                return readResolveFallback();
            } catch (SecurityException e14) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e14);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends com.google.protobuf.a.AbstractC0458a<MessageType, BuilderType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageType f41173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MessageType f41174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f41175c = false;

        public a(MessageType messagetype) {
            this.f41173a = messagetype;
            this.f41174b = (MessageType) messagetype.z(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        @Override // com.google.protobuf.n0.a
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public MessageType u() {
            if (this.f41175c) {
                return this.f41174b;
            }
            this.f41174b.I();
            this.f41175c = true;
            return this.f41174b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public BuilderType clone() {
            com.google.firebase.perf.v1.h.c cVar = (BuilderType) k().j();
            cVar.G(u());
            return cVar;
        }

        public final void C() {
            if (this.f41175c) {
                D();
                this.f41175c = false;
            }
        }

        public void D() {
            MessageType messagetype = (MessageType) this.f41174b.z(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            J(messagetype, this.f41174b);
            this.f41174b = messagetype;
        }

        @Override // com.google.protobuf.o0
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public MessageType k() {
            return this.f41173a;
        }

        @Override // com.google.protobuf.a.AbstractC0458a
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public BuilderType s(MessageType messagetype) {
            return (BuilderType) G(messagetype);
        }

        public BuilderType G(MessageType messagetype) {
            C();
            J(this.f41174b, messagetype);
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0458a
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public BuilderType x(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
            return (BuilderType) I(bArr, i11, i12, p.b());
        }

        public BuilderType I(byte[] bArr, int i11, int i12, p pVar) throws InvalidProtocolBufferException {
            C();
            try {
                x0.a().e(this.f41174b).i(this.f41174b, bArr, i11, i11 + i12, new com.google.protobuf.e.b(pVar));
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e12);
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final void J(MessageType messagetype, MessageType messagetype2) {
            x0.a().e(messagetype).a(messagetype, messagetype2);
        }

        @Override // com.google.protobuf.n0.a
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public final MessageType build() {
            MessageType messagetype = (MessageType) u();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw com.google.protobuf.a.AbstractC0458a.y(messagetype);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static class b<T extends GeneratedMessageLite<T, ?>> extends com.google.protobuf.b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f41176b;

        public b(T t11) {
            this.f41176b = t11;
        }

        @Override // com.google.protobuf.v0
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public T b(j jVar, p pVar) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.N(this.f41176b, jVar, pVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements o0 {
        protected u<d> extensions = u.h();

        public u<d> Q() {
            if (this.extensions.o()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.n0
        public /* bridge */ /* synthetic */ n0.a b() {
            return super.b();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.n0
        public /* bridge */ /* synthetic */ n0.a j() {
            return super.j();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.o0
        public /* bridge */ /* synthetic */ n0 k() {
            return super.k();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class d implements u.b<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y.d<?> f41177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f41179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f41180d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f41181f;

        @Override // com.google.protobuf.u.b
        public boolean N() {
            return this.f41180d;
        }

        @Override // com.google.protobuf.u.b
        public WireFormat.FieldType O() {
            return this.f41179c;
        }

        @Override // com.google.protobuf.u.b
        public WireFormat.JavaType Q() {
            return this.f41179c.getJavaType();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return this.f41178b - dVar.f41178b;
        }

        public y.d<?> b() {
            return this.f41177a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.u.b
        public n0.a f(n0.a aVar, n0 n0Var) {
            return ((a) aVar).G((GeneratedMessageLite) n0Var);
        }

        @Override // com.google.protobuf.u.b
        public int getNumber() {
            return this.f41178b;
        }

        @Override // com.google.protobuf.u.b
        public boolean isPacked() {
            return this.f41181f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static class e<ContainingType extends n0, Type> extends n<ContainingType, Type> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n0 f41182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f41183b;

        public WireFormat.FieldType a() {
            return this.f41183b.O();
        }

        public n0 b() {
            return this.f41182a;
        }

        public int c() {
            return this.f41183b.getNumber();
        }

        public boolean d() {
            return this.f41183b.f41180d;
        }
    }

    public static y.g C() {
        return x.g();
    }

    public static <E> y.j<E> D() {
        return y0.e();
    }

    public static <T extends GeneratedMessageLite<?, ?>> T E(Class<T> cls) {
        GeneratedMessageLite<?, ?> generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = (T) ((GeneratedMessageLite) l1.l(cls)).k();
            if (generatedMessageLite == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, generatedMessageLite);
        }
        return (T) generatedMessageLite;
    }

    public static Object G(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e11);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final <T extends GeneratedMessageLite<T, ?>> boolean H(T t11, boolean z11) {
        byte bByteValue = ((Byte) t11.z(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zD = x0.a().e(t11).d(t11);
        if (z11) {
            t11.A(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, zD ? t11 : null);
        }
        return zD;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.y$g] */
    public static y.g J(y.g gVar) {
        int size = gVar.size();
        return gVar.c2(size == 0 ? 10 : size * 2);
    }

    public static <E> y.j<E> K(y.j<E> jVar) {
        int size = jVar.size();
        return jVar.c2(size == 0 ? 10 : size * 2);
    }

    public static Object M(n0 n0Var, String str, Object[] objArr) {
        return new z0(n0Var, str, objArr);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T N(T t11, j jVar, p pVar) throws InvalidProtocolBufferException {
        T t12 = (T) t11.z(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            b1 b1VarE = x0.a().e(t12);
            b1VarE.h(t12, k.P(jVar), pVar);
            b1VarE.c(t12);
            return t12;
        } catch (InvalidProtocolBufferException e11) {
            e = e11;
            if (e.getThrownFromInputStream()) {
                e = new InvalidProtocolBufferException(e);
            }
            throw e.setUnfinishedMessage(t12);
        } catch (IOException e12) {
            if (e12.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e12.getCause());
            }
            throw new InvalidProtocolBufferException(e12).setUnfinishedMessage(t12);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e13.getCause());
            }
            throw e13;
        }
    }

    public static <T extends GeneratedMessageLite<?, ?>> void O(Class<T> cls, T t11) {
        defaultInstanceMap.put(cls, t11);
    }

    public Object A(MethodToInvoke methodToInvoke, Object obj) {
        return B(methodToInvoke, obj, null);
    }

    public abstract Object B(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    @Override // com.google.protobuf.o0
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public final MessageType k() {
        return (MessageType) z(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public void I() {
        x0.a().e(this).c(this);
    }

    @Override // com.google.protobuf.n0
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final BuilderType j() {
        return (BuilderType) z(MethodToInvoke.NEW_BUILDER);
    }

    @Override // com.google.protobuf.n0
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public final BuilderType b() {
        BuilderType buildertype = (BuilderType) z(MethodToInvoke.NEW_BUILDER);
        buildertype.G(this);
        return buildertype;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return x0.a().e(this).j(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    @Override // com.google.protobuf.n0
    public int g() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = x0.a().e(this).e(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i11 = this.memoizedHashCode;
        if (i11 != 0) {
            return i11;
        }
        int iG = x0.a().e(this).g(this);
        this.memoizedHashCode = iG;
        return iG;
    }

    @Override // com.google.protobuf.o0
    public final boolean isInitialized() {
        return H(this, true);
    }

    @Override // com.google.protobuf.n0
    public void l(CodedOutputStream codedOutputStream) throws IOException {
        x0.a().e(this).b(this, l.P(codedOutputStream));
    }

    @Override // com.google.protobuf.n0
    public final v0<MessageType> p() {
        return (v0) z(MethodToInvoke.GET_PARSER);
    }

    @Override // com.google.protobuf.a
    public int q() {
        return this.memoizedSerializedSize;
    }

    public String toString() {
        return p0.e(this, super.toString());
    }

    @Override // com.google.protobuf.a
    public void v(int i11) {
        this.memoizedSerializedSize = i11;
    }

    public Object x() throws Exception {
        return z(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType y() {
        return (BuilderType) z(MethodToInvoke.NEW_BUILDER);
    }

    public Object z(MethodToInvoke methodToInvoke) {
        return B(methodToInvoke, null, null);
    }
}
