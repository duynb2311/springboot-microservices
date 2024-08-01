package com.duynb.spring.eureka.service1.controller;

import com.duynb.spring.eureka.service1.constant.MainConstants;
import com.duynb.spring.eureka.service1.dto.response.ResponseWithCollectionDto;
import com.duynb.spring.eureka.service1.dto.response.ResponseWithObjectDto;
import com.duynb.spring.eureka.service1.entity.CauThu;
import com.duynb.spring.eureka.service1.service.CauThuService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = MainConstants.CAU_THU_CONTROLLER_API_VALUE, description = MainConstants.CAU_THU_CONTROLLER_API_DESCRIPTION)
@RestController
@RequestMapping("/")
// Lớp controller tạo các api crud cho bảng cầu thủ
public class CauThuController {
    private final CauThuService cauThuService;

    public CauThuController(CauThuService cauThuService) {
        this.cauThuService = cauThuService;
    }

    //Duy -- phương thức lấy thông tin chi tiết cầu thủ với đầu vào là id cầu thủ
    @ApiOperation(value = MainConstants.GET_CAU_THU_BY_ID_API_OPERATION_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = MainConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = 404, message = MainConstants.GET_BY_ID_NOT_FOUND_MESSAGE)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseWithObjectDto<CauThu>> getCauThuById(
            @ApiParam(value = MainConstants.GET_CAU_THU_BY_ID_API_PARAM_VALUE, example = MainConstants.GET_CAU_THU_BY_ID_API_PARAM_EXAMPLE) @PathVariable Long id
    ){
        ResponseWithObjectDto<CauThu> response= cauThuService.getCauThuById(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    // Duy -- phương thức tìm danh sách cầu thủ chung câu lạc bộ
    // input -- tên câu lạc bộ, thứ tự page và độ dài page
    // output -- page cầu thủ đc yêu cầu
    @ApiOperation(value = MainConstants.GET_CAU_THU_BY_ID_API_OPERATION_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = MainConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = 404, message = MainConstants.API_GET_CAU_THU_BY_CLB_NOT_FOUND_MESSAGE)
    })
    @GetMapping("/search")
    public ResponseEntity<ResponseWithCollectionDto<List<CauThu>>> getCauThuByCauLacBo(
            @ApiParam(value = MainConstants.GET_CAU_THU_BY_CLB_API_PARAM1_VALUE, example = MainConstants.GET_CAU_THU_BY_CLB_API_PARAM1_EXAMPLE) @RequestParam( defaultValue = MainConstants.CLUB_PARAM_DEFAULT) String club,
            @ApiParam(value = MainConstants.GET_CAU_THU_BY_CLB_API_PARAM2_VALUE, example = MainConstants.GET_CAU_THU_BY_CLB_API_PARAM2_EXAMPLE) @RequestParam( defaultValue = MainConstants.FIRST_PAGE) Integer page,
            @ApiParam(value = MainConstants.GET_CAU_THU_BY_CLB_API_PARAM3_VALUE, example = MainConstants.GET_CAU_THU_BY_CLB_API_PARAM3_EXAMPLE) @RequestParam( defaultValue = MainConstants.SIZE_PAGE) Integer size
    ){
        ResponseWithCollectionDto<List<CauThu>> response =cauThuService.getCauThuByCauLacBo(club, page, size);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    // Duy -- phương thức cập nhật thông tin cầu thủ với đầu vào là đối tượng CauThu với thông tin mới
    @ApiOperation(value = MainConstants.UPDATE_CAU_THU_API_OPERATION_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = MainConstants.SUCCESS_MESSAGE),
            @ApiResponse(code = 404, message = MainConstants.GET_BY_ID_NOT_FOUND_MESSAGE),
            @ApiResponse(code = 400, message = MainConstants.UPDATE_CAU_THU_WITH_NULL_VALUE_MESSAGE)
    })
    @PutMapping
    public ResponseEntity<ResponseWithObjectDto<CauThu>> updateCauThu(
            @ApiParam(value = MainConstants.UPDATE_CAU_THU_API_PARAM_VALUE) @RequestBody CauThu cauThu
    ){
        ResponseWithObjectDto<CauThu> response= cauThuService.updateCauThu(cauThu);
        return new ResponseEntity<>(response,HttpStatus.valueOf(response.getStatusCode()));
    }
}
