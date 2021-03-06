package com.vti.railway12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.railway12.DAO.HocSinhDAO;
import com.vti.railway12.entity.HocSinh;

@Service
@Transactional
public class HocSinhService {

	@Autowired
	private HocSinhDAO hocsinhDAO;

	public List<HocSinh> findAll() {
		return hocsinhDAO.findAll();
	}

	public HocSinh findById(final int id) {
		return hocsinhDAO.findById(id);
	}
	
	public void save(final HocSinh hocSinh) {
		hocsinhDAO.save(hocSinh);
	}

	public void updateHocSinh(HocSinh hocsinh) {
		hocsinhDAO.update(hocsinh);
	}

	public void delete(final HocSinh hocSinh) {
		hocsinhDAO.delete(hocSinh);
	}

}