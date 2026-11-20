package m7;

import com.alibaba.fastjson.JSONException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b2 f70881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f70882d;

    public f(l7.h hVar, Class<?> cls, com.alibaba.fastjson.util.d dVar) {
        super(cls, dVar);
        boolean z11 = false;
        this.f70882d = false;
        j7.b bVarD = dVar.d();
        if (bVarD != null) {
            Class<?> clsDeserializeUsing = bVarD.deserializeUsing();
            if (clsDeserializeUsing != null && clsDeserializeUsing != Void.class) {
                z11 = true;
            }
            this.f70882d = z11;
        }
    }

    @Override // m7.l
    public int b() {
        b2 b2Var = this.f70881c;
        if (b2Var != null) {
            return b2Var.b();
        }
        return 2;
    }

    @Override // m7.l
    public void d(l7.a aVar, Object obj, Type type, Map<String, Object> map) {
        Object objF;
        com.alibaba.fastjson.util.d dVar;
        int i11;
        if (this.f70881c == null) {
            k(aVar.h());
        }
        b2 b2VarP = this.f70881c;
        Type typeJ = this.f70900a.f15537g;
        if (type instanceof ParameterizedType) {
            l7.g gVarI = aVar.i();
            if (gVarI != null) {
                gVarI.f70121e = type;
            }
            if (typeJ != type) {
                typeJ = com.alibaba.fastjson.util.d.j(this.f70901b, type, typeJ);
                if (b2VarP instanceof p) {
                    b2VarP = aVar.h().p(typeJ);
                }
            }
        }
        Type type2 = typeJ;
        if (!(b2VarP instanceof o) || (i11 = (dVar = this.f70900a).f15541k) == 0) {
            com.alibaba.fastjson.util.d dVar2 = this.f70900a;
            String str = dVar2.f15551u;
            objF = (!(str == null && dVar2.f15541k == 0) && (b2VarP instanceof e)) ? ((e) b2VarP).f(aVar, type2, dVar2.f15532a, str, dVar2.f15541k) : b2VarP.e(aVar, type2, dVar2.f15532a);
        } else {
            objF = ((o) b2VarP).h(aVar, type2, dVar.f15532a, i11);
        }
        if ((objF instanceof byte[]) && ("gzip".equals(this.f70900a.f15551u) || "gzip,base64".equals(this.f70900a.f15551u))) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream((byte[]) objF));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    byte[] bArr = new byte[1024];
                    int i12 = gZIPInputStream.read(bArr);
                    if (i12 == -1) {
                        break;
                    } else if (i12 > 0) {
                        byteArrayOutputStream.write(bArr, 0, i12);
                    }
                }
                objF = byteArrayOutputStream.toByteArray();
            } catch (IOException e11) {
                throw new JSONException("unzip bytes error.", e11);
            }
        }
        if (aVar.r() == 1) {
            l7.a.C0751a c0751aO = aVar.o();
            c0751aO.f70090c = this;
            c0751aO.f70091d = aVar.i();
            aVar.A0(0);
            return;
        }
        if (obj == null) {
            map.put(this.f70900a.f15532a, objF);
        } else {
            h(obj, objF);
        }
    }

    public b2 k(l7.h hVar) {
        if (this.f70881c == null) {
            j7.b bVarD = this.f70900a.d();
            if (bVarD == null || bVarD.deserializeUsing() == Void.class) {
                com.alibaba.fastjson.util.d dVar = this.f70900a;
                this.f70881c = hVar.o(dVar.f15536f, dVar.f15537g);
            } else {
                try {
                    this.f70881c = (b2) bVarD.deserializeUsing().newInstance();
                } catch (Exception e11) {
                    throw new JSONException("create deserializeUsing ObjectDeserializer error", e11);
                }
            }
        }
        return this.f70881c;
    }
}
