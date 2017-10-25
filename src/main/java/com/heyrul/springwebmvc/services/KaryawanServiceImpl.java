/*
 * @Author Rully Andhika a.k.a jarul
 * www.heyrul.com-2017
 */
package com.heyrul.springwebmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyrul.springwebmvc.daos.KaryawanDao;
import com.heyrul.springwebmvc.models.Karyawan;

@Service
public class KaryawanServiceImpl implements KaryawanService {
	
	@Autowired
	private KaryawanDao karyawanDao;

	public void insertKaryawan(Karyawan karyawan) {
		karyawanDao.insert(karyawan);
	}

	public void updateKaryawan(Karyawan karyawan) {
		karyawanDao.update(karyawan);
	}

	public void deleteKaryawan(String nip) {
		karyawanDao.delete(nip);
	}

	public List<Karyawan> getAllDataKaryawan() {
		return karyawanDao.getAllData();
	}

}
