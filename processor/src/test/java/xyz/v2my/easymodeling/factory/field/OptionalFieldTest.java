package xyz.v2my.easymodeling.factory.field;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.ParameterizedTypeName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import xyz.v2my.easymodeling.factory.FieldWrapper;
import xyz.v2my.easymodeling.factory.field.string.StringField;
import xyz.v2my.easymodeling.factory.helper.FieldWrapperFactory;
import xyz.v2my.easymodeling.randomizer.OptionalRandomizer;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class OptionalFieldTest extends FieldTest {

    private ClassName rawType;

    private StringField stringField;

    @BeforeEach
    void setUp() {
        fieldWrapper = FieldWrapperFactory.one(FIELD_NAME).min(3.).max(9.).build();
        stringField = new StringField(fieldWrapper);
        typeName = ParameterizedTypeName.get(Optional.class, Integer.class);
        rawType = ClassName.get(Integer.class);
        modelField = new OptionalField(rawType, fieldWrapper, Collections.singletonList(stringField));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void should_generate_init_value_based_on_field_wrapper(boolean allowEmpty) {
        FieldWrapper fieldWrapper = FieldWrapperFactory.one("field_name").allowEmpty(allowEmpty).build();
        final PlainField<String> stringField = new StringField(fieldWrapper);
        final List<ModelField> nestedFields = Collections.singletonList(stringField);
        final OptionalField optionalField = new OptionalField(rawType, fieldWrapper, nestedFields);

        final CodeBlock initialValue = optionalField.initialValue();

        assertThat(initialValue.toString())
                .isEqualTo("new " + $(OptionalRandomizer.class) + "<>(" + stringField.initializer() + ", " + allowEmpty + ").next()");
    }

    @Override
    @Test
    protected void should_generate_initializer() {
        final CodeBlock initializer = modelField.initializer();

        assertThat(initializer.toString())
                .isEqualTo("new " + $(OptionalRandomizer.class) + "<>(" + stringField.initializer() + ", false)");
    }
}
