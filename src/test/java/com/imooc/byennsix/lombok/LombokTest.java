package com.imooc.byennsix.lombok;

import com.imooc.byennsix.service.CartService;
import com.sun.istack.internal.NotNull;
import lombok.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: wjy
 * @Date: 2020/3/4 0:01
 */
@Getter
@Setter(value = AccessLevel.PRIVATE)
@ToString(exclude = {"field2"})
@EqualsAndHashCode
// @NoArgsConstructor
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@AllArgsConstructor

public class LombokTest {

    private final CartService cartService = null;

    @Getter(lazy = true)
    private final String constant = "HELLO _ WORLD";

    private String field1;
    private String field2;
    @NonNull
    private String field3;

    public void valTest(@NonNull String world) {
       val hello = "hello";
       System.out.println(hello);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
