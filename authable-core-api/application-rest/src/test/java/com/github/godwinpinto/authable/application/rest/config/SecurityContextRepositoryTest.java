package com.github.godwinpinto.authable.application.rest.config;

import static org.mockito.Mockito.*;

/*@ContextConfiguration(
    classes = {
      SecurityContextRepository.class,
    })
@ExtendWith(SpringExtension.class)
class SecurityContextRepositoryTest {
  @MockBean private AuthenticationManager authenticationManager;

  @Autowired private SecurityContextRepository securityContextRepository;

  @Test
  void testSave2() {
    ServerHttpRequestDecorator request = mock(ServerHttpRequestDecorator.class);
    when(request.getHeaders()).thenReturn(new HttpHeaders());
    when(request.getId()).thenReturn("https://example.org/example");
    Mono<WebSession> mono = mock(Mono.class);
    when(mono.cache()).thenReturn(null);
    WebSessionManager sessionManager = mock(WebSessionManager.class);
    when(sessionManager.getSession(Mockito.<ServerWebExchange>any())).thenReturn(mono);
    MockServerHttpResponse response = new MockServerHttpResponse();
    DefaultServerCodecConfigurer codecConfigurer = new DefaultServerCodecConfigurer();
    SecurityContextServerWebExchange swe =
        new SecurityContextServerWebExchange(
            new SecurityContextServerWebExchange(
                new SecurityContextServerWebExchange(
                    new SecurityContextServerWebExchange(
                        new DefaultServerWebExchange(
                            request,
                            response,
                            sessionManager,
                            codecConfigurer,
                            new AcceptHeaderLocaleContextResolver()),
                        null),
                    null),
                null),
            null);

    assertThrows(
        UnsupportedOperationException.class,
        () -> securityContextRepository.save(swe, new SecurityContextImpl()));
    verify(request).getId();
    verify(request, atLeast(1)).getHeaders();
    verify(sessionManager).getSession(Mockito.<ServerWebExchange>any());
    verify(mono).cache();
  }

  @Test
  void testSave3() {

    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.set("Authorization", "Bearer TEST_JWT_TOKEN");

    MockServerHttpRequest request =
        MockServerHttpRequest.get("/path")
            .headers(headers) // .header("Authorization", "Bearer TEST_JWT_TOKEN")
            .build();

    MockServerHttpResponse response = new MockServerHttpResponse();
    ServerWebExchange exchange = MockServerWebExchange.from(request);

    Authentication auth =
        new UsernamePasswordAuthenticationToken("TEST_JWT_TOKEN", "TEST_JWT_TOKEN");

    doReturn(Mono.just(auth)).when(authenticationManager).authenticate(any(Authentication.class));
    StepVerifier.create(securityContextRepository.load(exchange))
        .assertNext(
            securityContext -> {
              assertEquals(securityContext.getAuthentication().getPrincipal(), "TEST_JWT_TOKEN");
            })
        .verifyComplete();
  }
}*/
