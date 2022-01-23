package xyz.v2my.easymodeling.factory.field.datetime;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import org.junit.jupiter.api.BeforeEach;
import xyz.v2my.easymodeling.factory.field.FieldTest;
import xyz.v2my.easymodeling.factory.helper.FieldPatternFactory;
import xyz.v2my.easymodeling.randomizer.datetime.SqlDateRandomizer;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

class SqlDateFieldTest extends FieldTest {

    @Override
    @BeforeEach
    protected void setUp() {
        fieldPattern = FieldPatternFactory.one(FIELD_NAME).after("1991-01-23T00:00:00Z").before("1991-02-22T00:00:00Z").build();
        typeName = ClassName.get(Date.class);
        modelField = new SqlDateField().create(fieldPattern);
    }

    @Override
    protected void should_generate_initializer() {
        final CodeBlock initializer = modelField.initializer();

        assertThat(initializer)
                .hasToString("new " + $(SqlDateRandomizer.class) + "(664588800000L, 667180800000L)");
    }
}
