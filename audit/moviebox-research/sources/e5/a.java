package e5;

import androidx.media3.common.Metadata;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import c5.c;
import java.nio.ByteBuffer;
import java.util.Arrays;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {
    @Override // c5.c
    public Metadata b(c5.b bVar, ByteBuffer byteBuffer) {
        return new Metadata(c(new c0(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage c(c0 c0Var) {
        return new EventMessage((String) z3.a.e(c0Var.B()), (String) z3.a.e(c0Var.B()), c0Var.A(), c0Var.A(), Arrays.copyOfRange(c0Var.e(), c0Var.f(), c0Var.g()));
    }
}
