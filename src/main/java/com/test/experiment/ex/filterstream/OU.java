package com.test.experiment.ex.filterstream;

import lombok.Builder;
import lombok.Data;

/**
 * @author trd
 * @since 2022/6/14 14:27
 */
@Data
@Builder
public class OU {
    String desc;
    String creator;
    String email;
}
