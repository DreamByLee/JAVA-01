package io.work01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Leeyj
 * @date 2021/2/16 22:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Animal {

    private Dog dog;

    private Cat cat;

    private String name;
}
