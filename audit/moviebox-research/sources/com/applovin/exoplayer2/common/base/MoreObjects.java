package com.applovin.exoplayer2.common.base;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MoreObjects {

    /* JADX INFO: compiled from: source.java */
    public static final class ToStringHelper {
        private final String className;
        private final a holderHead;
        private a holderTail;
        private boolean omitNullValues;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String f17201a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f17202b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            a f17203c;

            private a() {
            }
        }

        private ToStringHelper(String str) {
            a aVar = new a();
            this.holderHead = aVar;
            this.holderTail = aVar;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        private a addHolder() {
            a aVar = new a();
            this.holderTail.f17203c = aVar;
            this.holderTail = aVar;
            return aVar;
        }

        private ToStringHelper addHolder(@NullableDecl Object obj) {
            addHolder().f17202b = obj;
            return this;
        }

        private ToStringHelper addHolder(String str, @NullableDecl Object obj) {
            a aVarAddHolder = addHolder();
            aVarAddHolder.f17202b = obj;
            aVarAddHolder.f17201a = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public ToStringHelper add(String str, char c11) {
            return addHolder(str, String.valueOf(c11));
        }

        public ToStringHelper add(String str, double d11) {
            return addHolder(str, String.valueOf(d11));
        }

        public ToStringHelper add(String str, float f11) {
            return addHolder(str, String.valueOf(f11));
        }

        public ToStringHelper add(String str, int i11) {
            return addHolder(str, String.valueOf(i11));
        }

        public ToStringHelper add(String str, long j11) {
            return addHolder(str, String.valueOf(j11));
        }

        public ToStringHelper add(String str, @NullableDecl Object obj) {
            return addHolder(str, obj);
        }

        public ToStringHelper add(String str, boolean z11) {
            return addHolder(str, String.valueOf(z11));
        }

        public ToStringHelper addValue(char c11) {
            return addHolder(String.valueOf(c11));
        }

        public ToStringHelper addValue(double d11) {
            return addHolder(String.valueOf(d11));
        }

        public ToStringHelper addValue(float f11) {
            return addHolder(String.valueOf(f11));
        }

        public ToStringHelper addValue(int i11) {
            return addHolder(String.valueOf(i11));
        }

        public ToStringHelper addValue(long j11) {
            return addHolder(String.valueOf(j11));
        }

        public ToStringHelper addValue(@NullableDecl Object obj) {
            return addHolder(obj);
        }

        public ToStringHelper addValue(boolean z11) {
            return addHolder(String.valueOf(z11));
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public String toString() {
            boolean z11 = this.omitNullValues;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.className);
            sb2.append('{');
            String str = "";
            for (a aVar = this.holderHead.f17203c; aVar != null; aVar = aVar.f17203c) {
                Object obj = aVar.f17202b;
                if (!z11 || obj != null) {
                    sb2.append(str);
                    String str2 = aVar.f17201a;
                    if (str2 != null) {
                        sb2.append(str2);
                        sb2.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb2.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    private MoreObjects() {
    }

    public static <T> T firstNonNull(@NullableDecl T t11, @NullableDecl T t12) {
        if (t11 != null) {
            return t11;
        }
        if (t12 != null) {
            return t12;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }
}
