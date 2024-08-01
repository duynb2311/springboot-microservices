package com.duynb.spring.eureka.service1.service;

import com.duynb.spring.eureka.service1.dto.response.ResponseWithCollectionDto;
import com.duynb.spring.eureka.service1.dto.response.ResponseWithObjectDto;
import com.duynb.spring.eureka.service1.dto.response.ResponseWithPageDto;
import com.duynb.spring.eureka.service1.entity.CauThu;
import org.springframework.data.domain.Page;

import java.util.List;

// interface cho các service của CauThu
public interface CauThuService {
    ResponseWithObjectDto<CauThu> deleteCauThu(Long id);
    ResponseWithPageDto<Page<CauThu>> getAllCauThu(Integer page, Integer size);
    ResponseWithObjectDto<CauThu> addCauThu(CauThu cauThuNew);
    ResponseWithObjectDto<CauThu> getCauThuById(Long id);

    ResponseWithCollectionDto<List<CauThu>> getCauThuByCauLacBo(String club, Integer page, Integer size);

    ResponseWithObjectDto<CauThu> updateCauThu(CauThu cauThu);
}
