package org.apache.tools.ant.util;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: compiled from: source.java */
    public static final class a implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Enumeration f72941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Enumeration f72942b;

        public a(Enumeration enumeration, Enumeration enumeration2) {
            this.f72941a = enumeration;
            this.f72942b = enumeration2;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f72941a.hasMoreElements() || this.f72942b.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() throws NoSuchElementException {
            return this.f72941a.hasMoreElements() ? this.f72941a.nextElement() : this.f72942b.nextElement();
        }
    }

    /* JADX INFO: renamed from: org.apache.tools.ant.util.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0788b implements Enumeration {
        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() throws NoSuchElementException {
            throw new NoSuchElementException();
        }
    }

    public static Enumeration a(Enumeration enumeration, Enumeration enumeration2) {
        return new a(enumeration, enumeration2);
    }
}
