package com.sebastian.czech.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InfoTest {

    @Test
    void should_return_version_as_created() {
        // given
        Info info = new Info(1L);

        // when
        Long version = info.getVersion();

        // then
        assertThat(version).isEqualTo(1);

    }

}
