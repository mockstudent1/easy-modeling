package xyz.v2my.easymodeling.factory.field.primitive;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.TypeName;
import xyz.v2my.easymodeling.factory.FieldWrapper;
import xyz.v2my.easymodeling.factory.field.ModelField;

public abstract class PrimitiveField<E> extends ModelField<E> {

    protected PrimitiveField(TypeName type, FieldWrapper field) {
        super(type, field);
    }

    public PrimitiveField() {
    }

    @Override
    protected CodeBlock initializerParameter() {
        return CodeBlock.of("");
    }
}
