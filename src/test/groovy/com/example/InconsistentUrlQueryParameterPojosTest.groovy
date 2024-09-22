package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class InconsistentUrlQueryParameterPojosTest extends Specification {

    static final String PATH_WITH_PARAMS = "/test?test=true"

    @Inject
    @Client("/")
    HttpClient client

    def "Get"() {
        when:
        def response = client.toBlocking().retrieve(HttpRequest.GET(PATH_WITH_PARAMS), Map.class)

        then:
        noExceptionThrown()
        response.get("test") == "true"
    }

    def "Post"() {
        when:
        def response = client.toBlocking().retrieve(HttpRequest.POST(PATH_WITH_PARAMS, Map.of("hello", "world")), Map.class)

        then:
        noExceptionThrown()
        response.get("test") == "true"
    }
}
