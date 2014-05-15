package com.me.resttest

import com.me.config.shared.MyBean
import com.me.service.AuthorService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

/**
 * Created by chrislin on 5/15/2014.
 */
@Configuration
class AuthorResourceFixture {


    @Bean(name = "authorService")
    AuthorService mockAuthorService() {
        def m = mock(AuthorService.class)
        def b = mock(MyBean.class)
        when(m.myBean).thenReturn(b)
        when(b.value1).thenReturn("from-SpringMockConfig-value-MOCKITO")
        m
    }

}