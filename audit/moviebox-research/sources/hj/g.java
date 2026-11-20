package hj;

import com.google.common.base.m;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gj.a<File> f66471a = new b();

    /* JADX INFO: compiled from: source.java */
    public class a implements j<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f66472a = Lists.i();

        @Override // hj.j
        public boolean b(String str) {
            this.f66472a.add(str);
            return true;
        }

        @Override // hj.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> a() {
            return this.f66472a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements gj.a<File> {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends hj.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f66473a;

        public c(File file) {
            this.f66473a = (File) m.p(file);
        }

        public /* synthetic */ c(File file, a aVar) {
            this(file);
        }

        @Override // hj.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public FileInputStream b() throws IOException {
            return new FileInputStream(this.f66473a);
        }

        public String toString() {
            return "Files.asByteSource(" + this.f66473a + ")";
        }
    }

    public static hj.a a(File file) {
        return new c(file, null);
    }

    public static hj.c b(File file, Charset charset) {
        return a(file).a(charset);
    }

    public static List<String> c(File file, Charset charset) throws IOException {
        return (List) b(file, charset).b(new a());
    }
}
