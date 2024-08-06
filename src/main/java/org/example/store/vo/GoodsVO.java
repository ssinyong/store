package org.example.store.vo;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVO {
    private Integer mno;
    private String mname;
    private Integer mprice;
    private Integer mquantity;
    private String img1;
    private String img2;
    private boolean sell;
}
