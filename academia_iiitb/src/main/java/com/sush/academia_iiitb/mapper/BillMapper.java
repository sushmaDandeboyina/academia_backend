package com.sush.academia_iiitb.mapper;

import com.sush.academia_iiitb.dto.BillsResponse;
import com.sush.academia_iiitb.entity.Bills;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BillMapper {
    public BillsResponse toDTO(Bills bill) {
        BillsResponse dto = new BillsResponse();
        dto.setId(bill.getId());
        dto.setDescription(bill.getDescription());
        dto.setAmount(bill.getAmount());
        dto.setBillDate(bill.getBillDate());
        dto.setDeadline(bill.getDeadline());
        return dto;
    }

    public List<BillsResponse> toDTOList(List<Bills> bills) {
        return bills.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
