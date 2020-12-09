package com.vavr;

import io.vavr.control.Either;
import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author WhomHim
 * @date Create in 2020/12/9 16:45
 */
public class EitherTest {

    @Test
    public void eitherTest() {
        Supplier<Either<Throwable, String>> compute = () -> new Random().nextBoolean()
                ? Either.left(new RuntimeException("Boom!")) : Either.right("Hello");

        //Either 的 map 和 mapLeft 方法分别对右值和左值进行计算。
        Either<String, String> either = compute.get()
                .map(str -> str + " World")
                .mapLeft(Throwable::getMessage);

        System.out.println(either.isRight());
        System.out.println(either.get());
        System.out.println(either.getLeft());
    }
}
