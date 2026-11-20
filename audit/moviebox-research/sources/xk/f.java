package xk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class f implements uk.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f80584a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f80585b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public uk.b f80586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.firebase.encoders.proto.b f80587d;

    public f(com.google.firebase.encoders.proto.b bVar) {
        this.f80587d = bVar;
    }

    public final void a() {
        if (this.f80584a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f80584a = true;
    }

    @Override // uk.f
    @NonNull
    public uk.f b(@Nullable String str) throws IOException {
        a();
        this.f80587d.n(this.f80586c, str, this.f80585b);
        return this;
    }

    @Override // uk.f
    @NonNull
    public uk.f c(boolean z11) throws IOException {
        a();
        this.f80587d.k(this.f80586c, z11, this.f80585b);
        return this;
    }

    public void d(uk.b bVar, boolean z11) {
        this.f80584a = false;
        this.f80586c = bVar;
        this.f80585b = z11;
    }
}
