package com.duynb.spring.eureka.service1.entity;

import com.duynb.spring.eureka.service1.constant.MainConstants;
import com.duynb.spring.eureka.service1.dto.CauThuManagerDto;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
// Lớp ánh xạ đối tượng CauThu sang bảng cau_thu trên mysql
@Table(name = MainConstants.ENTITY_TABLE_NAME)
public class CauThu extends CauThuManagerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(example = MainConstants.CAU_THU_ID_EXAMPLE)
    private Long id;
    @NotNull(message = MainConstants.ENTITY_COLUMN_NULLPOINTER_HOTEN)
    @Column(name = MainConstants.ENTITY_COLUMN_HOTEN)
    @ApiModelProperty(example = MainConstants.HO_TEN_CAU_THU_EXAMPLE)
    private String hoTen;
    @NotNull(message = MainConstants.ENTITY_COLUMN_NULLPOINTER_NAMSINH)
    @Temporal(TemporalType.DATE)
    @Column(name = MainConstants.ENTITY_COLUMN_NAMSINH)
    @ApiModelProperty(example = MainConstants.NAM_SINH_CAU_THU_EXAMPLE)
    private Date namSinh;
    @NotNull(message = MainConstants.ENTITY_COLUMN_NULLPOINTER_VITRI)
    @Column(name = MainConstants.ENTITY_COLUMN_VITRI)
    @ApiModelProperty(example = MainConstants.VI_TRI_CAU_THU_EXAMPLE)
    private String viTri;
    @NotNull(message = MainConstants.ENTITY_COLUMN_NULLPOINTER_SOAO)
    @Column(name = MainConstants.ENTITY_COLUMN_SOAO)
    @ApiModelProperty(example = MainConstants.SO_AO_CAU_THU_EXAMPLE)
    private Integer soAo;
    @NotNull(message = MainConstants.ENTITY_COLUMN_NULLPOINTER_CAULACBO)
    @Column(name = MainConstants.ENTITY_COLUMN_CAULACBO)
    @ApiModelProperty(example = MainConstants.CAU_LAC_BO_CAU_THU_EXAMPLE)
    private String cauLacBo;
    @NotNull(message = MainConstants.ENTITY_COLUMN_NULLPOINTER_QUOCTICH)
    @Column(name = MainConstants.ENTITY_COLUMN_QUOCTICH)
    @ApiModelProperty(example = MainConstants.QUOC_TICH_CAU_THU_EXAMPLE)
    private String quocTich;
    @NotNull(message = MainConstants.ENTITY_COLUMN_NULLPOINTER_THOIHANHOPDONG)
    @Temporal(TemporalType.DATE)
    @Column(name = MainConstants.ENTITY_COLUMN_THOIHANHOPDONG)
    @ApiModelProperty(example = MainConstants.THOI_HAN_HOP_DONG_CAU_THU_EXAMPLE)
    private Date thoiHanHopDong;
    @NotNull(message = MainConstants.ENTITY_COLUMN_NULLPOINTER_LUONG)
    @Column(name = MainConstants.ENTITY_COLUMN_LUONG)
    @ApiModelProperty(example = MainConstants.LUONG_CAU_THU_EXAMPLE)
    private BigDecimal luong;

    public Long getId() {
        return id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public Integer getSoAo() {
        return soAo;
    }

    public void setSoAo(Integer soAo) {
        this.soAo = soAo;
    }

    public String getCauLacBo() {
        return cauLacBo;
    }

    public void setCauLacBo(String cauLacBo) {
        this.cauLacBo = cauLacBo;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public Date getThoiHanHopDong() {
        return thoiHanHopDong;
    }

    public void setThoiHanHopDong(Date thoiHanHopDong) {
        this.thoiHanHopDong = thoiHanHopDong;
    }

    public BigDecimal getLuong() {
        return luong;
    }

    public void setLuong(BigDecimal luong) {
        this.luong = luong;
    }

    public CauThu() {
    }

    public CauThu(Long id, String hoTen, Date namSinh, String viTri, Integer soAo, String cauLacBo, String quocTich, Date thoiHanHopDong, BigDecimal luong) {
        this.id = id;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.viTri = viTri;
        this.soAo = soAo;
        this.cauLacBo = cauLacBo;
        this.quocTich = quocTich;
        this.thoiHanHopDong = thoiHanHopDong;
        this.luong = luong;
    }

    public CauThu(String hoTen, Date namSinh, String viTri, Integer soAo, String cauLacBo, String quocTich, Date thoiHanHopDong, BigDecimal luong) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.viTri = viTri;
        this.soAo = soAo;
        this.cauLacBo = cauLacBo;
        this.quocTich = quocTich;
        this.thoiHanHopDong = thoiHanHopDong;
        this.luong = luong;
    }
}
