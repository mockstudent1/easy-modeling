package xyz.v2my.easymodeling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestModelTest {

    @Test
    void should_create_test_model() {
        final TestModel testModel = EMTestModelFactory.builder().build();

        assertNotNull(testModel);
        assertNull(testModel.getaString());
    }

    @Test
    void should_create_test_model_and_build_string_field() {
        final TestModel testModel = EMTestModelFactory.builder().aString("some-string").build();

        assertNotNull(testModel);
        assertEquals("some-string", testModel.getaString());
    }
}
