package xyz.v2my.easymodeling.factory.field.numeric;

import com.squareup.javapoet.TypeName;
import xyz.v2my.easymodeling.Field;

public class ByteField extends NumericField {

    public ByteField(TypeName type, String name, Field field) {
        super(type, name, field);
    }

    @Override
    protected long ceiling() {
        return Byte.MAX_VALUE;
    }

    @Override
    protected long floor() {
        return Byte.MIN_VALUE;
    }

    @Override
    protected String staticInitializer() {
        return "aByte";
    }
}
