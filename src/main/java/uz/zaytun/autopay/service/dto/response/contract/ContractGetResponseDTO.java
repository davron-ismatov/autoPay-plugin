package uz.zaytun.autopay.service.dto.response.contract;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractGetResponseDTO {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer total;
    private Integer lastPage;
    private Integer currentPage;
    private List<ContractDTO> data;
}
