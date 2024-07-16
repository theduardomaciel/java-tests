# Testes no Java

Este repositório contém a implementação de testes de unidade ~~e testes de integração em Java.~~

## Testes de unidade

Os testes de unidade são feitos com JUnit 5.

Para rodar os testes de unidade, execute o seguinte comando:

```bash
./gradlew test
```

### Teste de unidade com JUnit 5

Para criar um teste de unidade com JUnit 5, crie uma classe de teste e anote-a com `@Test`.

```java
class UnitTest {

    @Test
    void test() {
        assertEquals(1, 1);
    }
}
```

### Asserções

As asserções são feitas com a classe `Assertions`.

```java
import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitTest {

    @Test
    void test() {
        assertEquals(1, 1);
    }
}
```

### Princípios FIRST

- **Fast**: Os testes devem ser rápidos.
- **Isolated**: Os testes devem ser isolados, ou seja, não devem depender uns dos outros.
- **Repeatable**: Os testes devem ser repetíveis, ou seja, não podem retornar resultados diferentes a cada execução.
- **Self-validating**: Os testes devem ser autovalidados.
- **Timely**: Os testes devem ser feitos no momento certo.

## Testes de integração

Os testes de integração são feitos com Mockito.

Para rodar os testes de integração, execute o seguinte comando:

```bash
./gradlew integrationTest
```

### Mock

Mock é uma técnica de teste de software que cria objetos simulados para substituir componentes reais. Um mock é um objeto que simula o comportamento de um objeto real.

Para criar um mock, utilize a anotação `@Mock`, após estender a classe com `MockitoExtension`.

```java
@ExtendWith(MockitoExtension.class)
class MockTest {

    @Mock
    private MyService myService;

    @Test
    void test() {
        Mockito.when(myService.doSomething()).thenReturn("mock");
        assertEquals("mock", myService.doSomething());
    }
}
```

### Stubbing (when, thenReturn, thenThrow)

Stubbing é a técnica de definir o comportamento de um mock.  
Para isso, utilize o método `Mockito.when()` e métodos como `thenReturn()` e `thenThrow()`.

```java
@ExtendWith(MockitoExtension.class)
class StubbingTest {

    @Mock
    private MyService myService;

    @Test
    void test() {
        Mockito.when(myService.doSomething()).thenReturn("mock");
        assertEquals("mock", myService.doSomething());
    }
}
```

### Verificação (verify)

Verificação é a técnica de verificar diversos aspectos, como se um método foi chamado, em qual ordem, quantas vezes, etc.  
Para isso, utilize o método `Mockito.verify()`.

```java
@ExtendWith(MockitoExtension.class)
class VerificationTest {

    @Mock
    private MyService myService;

    @Test
    void test() {
        myService.doSomething();
        Mockito.verify(myService).doSomething();
    }
}
```

### Captura de argumentos (ArgumentCaptor)

Captura de argumentos é a técnica de capturar os argumentos passados para um método, para assim sabermos como determinadas informações estão chegando nas mais diversas partes do código.  
Para isso, utilize a classe `ArgumentCaptor`.

```java
@ExtendWith(MockitoExtension.class)
class ArgumentCaptorTest {

    @Mock
    private MyService myService;

    @Test
    void test() {
        myService.doSomething("mock");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(myService).doSomething(captor.capture());
        assertEquals("mock", captor.getValue());
    }
}
```

### Mock de métodos estáticos

Para realizar Mocks com métodos estáticos, é necessário substituir a dependência `mockito-core` pela `mockito-inline`.