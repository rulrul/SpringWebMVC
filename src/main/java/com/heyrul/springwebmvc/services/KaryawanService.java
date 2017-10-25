/*
 * @Author Rully Andhika a.k.a jarul
 * www.heyrul.com-2017
 */
package com.heyrul.springwebmvc.services;

import java.util.List;

import com.heyrul.springwebmvc.models.Karyawan;

public interface KaryawanService {
	
	public void insertKaryawan(Karyawan karyawan);
	
	public void updateKaryawan(Karyawan karyawan);
	
	public void deleteKaryawan(String nip);
	
	public List<Karyawan> getAllDataKaryawan();

}
