package io.work03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Leeyj
 * @date 2021/2/19 13:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private Long id;
    private String name;
}
