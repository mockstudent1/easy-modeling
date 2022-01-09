package xyz.v2my.easymodeling.factory.field.collection;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.v2my.easymodeling.factory.field.FieldTest;
import xyz.v2my.easymodeling.factory.field.ModelField;
import xyz.v2my.easymodeling.factory.field.string.StringField;
import xyz.v2my.easymodeling.factory.helper.FieldWrapperFactory;
import xyz.v2my.easymodeling.randomizer.collection.ListRandomizer;
import xyz.v2my.easymodeling.randomizer.string.StringRandomizer;

import javax.lang.model.element.Modifier;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static xyz.v2my.easymodeling.ClassPatterns.BUILDER_CLASS_NAME;

class ListFieldTest extends FieldTest {

    @BeforeEach
    void setUp() {
        typeName = ParameterizedTypeName.get(List.class, String.class);
        fieldWrapper = FieldWrapperFactory.one(FIELD_NAME).string("").min(3.).max(9.).minSize(20).maxSize(50).build();
        final List<ModelField> nestedFields = Collections.singletonList(new StringField(fieldWrapper));
        modelField = new ListField(typeName, fieldWrapper, nestedFields);
    }

    @Test
    @Override
    protected void should_generate_builder_setter() {
        final MethodSpec setter = modelField.setter();

        assertThat(setter.returnType.toString()).isEqualTo(BUILDER_CLASS_NAME);
        assertThat(setter.name).isEqualTo(fieldWrapper.name());
        assertThat(setter.modifiers).containsExactly(Modifier.PUBLIC);
        assertThat(setter.parameters).hasSize(1);
        assertThat(setter.parameters.get(0).type).isEqualTo(typeName);
        assertThat(setter.parameters.get(0).name).contains(fieldWrapper.name());
    }

    @Test
    void should_generate_initializer() {
        final CodeBlock initializer = modelField.initializer();

        final String stringRandomizer = "new " + $(StringRandomizer.class) + "(3, 9, 3)";
        assertThat(initializer.toString()).isEqualTo("new " + $(ListRandomizer.class) + "<>(" + stringRandomizer + ", 20, 50)");
    }
}
