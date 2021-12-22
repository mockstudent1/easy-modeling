package xyz.v2my.easymodeling;

import com.squareup.javapoet.TypeName;

public class GenericBuilderField extends AbstractBuilderField {

    public GenericBuilderField(TypeName type, String name) {
        super(type, name);
    }

    @Override
    public String initializer() {
        return "null";
    }
}
