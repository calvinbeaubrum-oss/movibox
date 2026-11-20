package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.a.AbstractC0458a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0458a<MessageType, BuilderType>> implements n0 {
    protected int memoizedHashCode = 0;

    /* JADX INFO: renamed from: com.google.protobuf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractC0458a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0458a<MessageType, BuilderType>> implements n0.a {
        public static <T> void q(Iterable<T> iterable, List<? super T> list) {
            y.a(iterable);
            if (!(iterable instanceof d0)) {
                if (iterable instanceof w0) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    r(iterable, list);
                    return;
                }
            }
            List<?> listL = ((d0) iterable).l();
            d0 d0Var = (d0) list;
            int size = list.size();
            for (Object obj : listL) {
                if (obj == null) {
                    String str = "Element at index " + (d0Var.size() - size) + " is null.";
                    for (int size2 = d0Var.size() - 1; size2 >= size; size2--) {
                        d0Var.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof ByteString) {
                    d0Var.d((ByteString) obj);
                } else {
                    d0Var.add((String) obj);
                }
            }
        }

        public static <T> void r(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T t11 : iterable) {
                if (t11 == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(t11);
            }
        }

        public static UninitializedMessageException y(n0 n0Var) {
            return new UninitializedMessageException(n0Var);
        }

        public abstract BuilderType s(MessageType messagetype);

        @Override // com.google.protobuf.n0.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public BuilderType i(n0 n0Var) {
            if (k().getClass().isInstance(n0Var)) {
                return (BuilderType) s((a) n0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.n0.a
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public BuilderType w(byte[] bArr) throws InvalidProtocolBufferException {
            return (BuilderType) x(bArr, 0, bArr.length);
        }

        public abstract BuilderType x(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException;
    }

    public static <T> void e(Iterable<T> iterable, List<? super T> list) {
        AbstractC0458a.q(iterable, list);
    }

    @Override // com.google.protobuf.n0
    public ByteString c() {
        try {
            ByteString.f fVarNewCodedBuilder = ByteString.newCodedBuilder(g());
            l(fVarNewCodedBuilder.b());
            return fVarNewCodedBuilder.a();
        } catch (IOException e11) {
            throw new RuntimeException(s("ByteString"), e11);
        }
    }

    @Override // com.google.protobuf.n0
    public byte[] h() {
        try {
            byte[] bArr = new byte[g()];
            CodedOutputStream codedOutputStreamE0 = CodedOutputStream.e0(bArr);
            l(codedOutputStreamE0);
            codedOutputStreamE0.d();
            return bArr;
        } catch (IOException e11) {
            throw new RuntimeException(s("byte array"), e11);
        }
    }

    public int q() {
        throw new UnsupportedOperationException();
    }

    public int r(b1 b1Var) {
        int iQ = q();
        if (iQ != -1) {
            return iQ;
        }
        int iE = b1Var.e(this);
        v(iE);
        return iE;
    }

    public final String s(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public UninitializedMessageException t() {
        return new UninitializedMessageException(this);
    }

    public void v(int i11) {
        throw new UnsupportedOperationException();
    }
}
