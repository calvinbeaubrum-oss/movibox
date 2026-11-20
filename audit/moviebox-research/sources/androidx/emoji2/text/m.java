package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final androidx.emoji2.text.flatbuffer.b f8364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final char[] f8365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final a f8366c = new a(1024);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Typeface f8367d;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f8368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o f8369b;

        public a() {
            this(1);
        }

        public a(int i11) {
            this.f8368a = new SparseArray<>(i11);
        }

        public a a(int i11) {
            SparseArray<a> sparseArray = this.f8368a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i11);
        }

        public final o b() {
            return this.f8369b;
        }

        public void c(@NonNull o oVar, int i11, int i12) {
            a aVarA = a(oVar.b(i11));
            if (aVarA == null) {
                aVarA = new a();
                this.f8368a.put(oVar.b(i11), aVarA);
            }
            if (i12 > i11) {
                aVarA.c(oVar, i11 + 1, i12);
            } else {
                aVarA.f8369b = oVar;
            }
        }
    }

    public m(@NonNull Typeface typeface, @NonNull androidx.emoji2.text.flatbuffer.b bVar) {
        this.f8367d = typeface;
        this.f8364a = bVar;
        this.f8365b = new char[bVar.l() * 2];
        a(bVar);
    }

    @NonNull
    public static m b(@NonNull Typeface typeface, @NonNull ByteBuffer byteBuffer) throws IOException {
        try {
            androidx.core.os.r.a("EmojiCompat.MetadataRepo.create");
            return new m(typeface, l.b(byteBuffer));
        } finally {
            androidx.core.os.r.b();
        }
    }

    public final void a(androidx.emoji2.text.flatbuffer.b bVar) {
        int iL = bVar.l();
        for (int i11 = 0; i11 < iL; i11++) {
            o oVar = new o(this, i11);
            Character.toChars(oVar.f(), this.f8365b, i11 * 2);
            h(oVar);
        }
    }

    @NonNull
    public char[] c() {
        return this.f8365b;
    }

    @NonNull
    public androidx.emoji2.text.flatbuffer.b d() {
        return this.f8364a;
    }

    public int e() {
        return this.f8364a.m();
    }

    @NonNull
    public a f() {
        return this.f8366c;
    }

    @NonNull
    public Typeface g() {
        return this.f8367d;
    }

    public void h(@NonNull o oVar) {
        androidx.core.util.i.h(oVar, "emoji metadata cannot be null");
        androidx.core.util.i.b(oVar.c() > 0, "invalid metadata codepoint length");
        this.f8366c.c(oVar, 0, oVar.c() - 1);
    }
}
