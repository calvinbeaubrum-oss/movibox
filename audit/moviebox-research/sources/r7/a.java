package r7;

import com.alibaba.fastjson.JSONObject;
import com.applovin.sdk.AppLovinEventParameters;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.money.Monetary;
import m7.b2;
import n7.j1;
import n7.o0;
import n7.z0;
import org.javamoney.moneta.Money;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f75164a = new a();

    @Override // m7.b2
    public int b() {
        return 0;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        Money money = (Money) obj;
        if (money == null) {
            o0Var.J();
            return;
        }
        j1 j1Var = o0Var.f71701k;
        j1Var.y('{', "numberStripped", money.getNumberStripped());
        j1Var.x(',', AppLovinEventParameters.REVENUE_CURRENCY, money.getCurrency().getCurrencyCode());
        j1Var.write(125);
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        String string;
        JSONObject jSONObjectI0 = aVar.i0();
        Object obj2 = jSONObjectI0.get(AppLovinEventParameters.REVENUE_CURRENCY);
        if (obj2 instanceof JSONObject) {
            string = ((JSONObject) obj2).getString("currencyCode");
        } else {
            string = obj2 instanceof String ? (String) obj2 : null;
        }
        Object obj3 = jSONObjectI0.get("numberStripped");
        if ((obj3 instanceof BigDecimal) || (obj3 instanceof Integer) || (obj3 instanceof BigInteger)) {
            return (T) Money.of((Number) obj3, Monetary.getCurrency(string, new String[0]));
        }
        throw new UnsupportedOperationException();
    }
}
