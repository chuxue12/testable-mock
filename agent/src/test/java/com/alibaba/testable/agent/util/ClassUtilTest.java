package com.alibaba.testable.agent.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassUtilTest {

    @Test
    void should_able_to_get_annotation() {
        assertEquals(0, ClassUtil.getAnnotations("class.not.exist").size());
        assertEquals(0, ClassUtil.getAnnotations("com.alibaba.testable.agent.util.ClassUtil").size());
        assertEquals("org.apiguardian.api.API", ClassUtil.getAnnotations("org.junit.jupiter.api.Assertions").get(0));
    }

    @Test
    void should_able_to_get_parameter_count() {
        assertEquals(1, ClassUtil.getParameterTypes("(Ljava/lang/String;)V").size());
        assertEquals(6, ClassUtil.getParameterTypes("(Ljava/lang/String;IDLjava/lang/String;ZLjava/net/URL;)V").size());
        assertEquals(10, ClassUtil.getParameterTypes("(ZLjava/lang/String;IJFDCSBZ)V").size());
        assertEquals(3, ClassUtil.getParameterTypes("(Ljava/lang/String;[I[Ljava/lang/String;)V").size());
    }

    @Test
    void should_able_to_get_return_type() {
        assertEquals("", ClassUtil.getReturnType("(Ljava/lang/String;)V"));
        assertEquals("java/lang/Integer", ClassUtil.getReturnType("(Ljava/lang/String;)I"));
        assertEquals("[I", ClassUtil.getReturnType("(Ljava/lang/String;)[I"));
        assertEquals("java/lang/String", ClassUtil.getReturnType("(Ljava/lang/String;)Ljava/lang/String;"));
        assertEquals("[Ljava/lang/String;", ClassUtil.getReturnType("(Ljava/lang/String;)[Ljava/lang/String;"));
    }

    @Test
    void should_able_to_convert_class_name() {
        assertEquals("Ljava/lang/String;", ClassUtil.toByteCodeClassName("java.lang.String"));
    }

}
