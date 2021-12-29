package xyz.v2my.easymodeling.factory.field.primitive;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.TypeName;
import xyz.v2my.easymodeling.factory.FieldWrapper;
import xyz.v2my.easymodeling.factory.field.AbstractField;

import java.util.Optional;

public abstract class PrimitiveField extends AbstractField {

    protected PrimitiveField(TypeName type, FieldWrapper field) {
        super(type, field);
    }

    public PrimitiveField() {
    }

    @Override
    protected Optional<CodeBlock> constantInit() {
        return Optional.empty();
    }

    @Override
    public CodeBlock initializer() {
        return CodeBlock.of("new $T()", randomizer());
    }
}
